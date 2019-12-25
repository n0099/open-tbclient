package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class IMUrlProvider {
    private static final String TAG = "IMUrlProvider";
    private static Context mContext;
    private static int mCurrentPolicy = Constants.SOCKET_DEFAULT_POLICY;
    private static int mLastPolicy = mCurrentPolicy;

    /* loaded from: classes2.dex */
    public interface IGetUrlAsyncListener extends IMListener {
        void onGetUrlAsncResult(int i, String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface IMUrlProviderInternal {
        void getUrlAsync(IGetUrlAsyncListener iGetUrlAsyncListener);

        void onConnectSucess(String str, boolean z);
    }

    public static IMUrlProviderInternal getProvide(Context context) {
        mContext = context.getApplicationContext();
        if (mCurrentPolicy == 0) {
            return DefaultUrlProvider.getUrlProvider();
        }
        if (mCurrentPolicy == 1) {
            return HttpDNSUrlProvider.getUrlProvider(context);
        }
        if (Utility.getBdDnsEnable(context) && mCurrentPolicy == 2) {
            return BDHttpDNSUrlProvider.getUrlProvider(context);
        }
        mCurrentPolicy = 0;
        return DefaultUrlProvider.getUrlProvider();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DefaultUrlProvider implements IMUrlProviderInternal {
        private static DefaultUrlProvider mInstance;

        private DefaultUrlProvider() {
        }

        public static synchronized IMUrlProviderInternal getUrlProvider() {
            DefaultUrlProvider defaultUrlProvider;
            synchronized (DefaultUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new DefaultUrlProvider();
                }
                defaultUrlProvider = mInstance;
            }
            return defaultUrlProvider;
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void getUrlAsync(IGetUrlAsyncListener iGetUrlAsyncListener) {
            LogUtils.i(IMUrlProvider.TAG, "DefaultUrlProvider try to getUrlAsync");
            if (iGetUrlAsyncListener != null) {
                IMUrlProvider.nextPolicy(true);
                iGetUrlAsyncListener.onGetUrlAsncResult(0, Constants.ERROR_MSG_SUCCESS, Constants.URL_SOCKET_SERVER);
            }
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void onConnectSucess(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class BDHttpDNSUrlProvider implements IMUrlProviderInternal {
        private static BDHttpDNSUrlProvider mInstance;

        public static synchronized BDHttpDNSUrlProvider getUrlProvider(Context context) {
            BDHttpDNSUrlProvider bDHttpDNSUrlProvider;
            synchronized (BDHttpDNSUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new BDHttpDNSUrlProvider(context);
                }
                bDHttpDNSUrlProvider = mInstance;
            }
            return bDHttpDNSUrlProvider;
        }

        private BDHttpDNSUrlProvider(Context context) {
            Context unused = IMUrlProvider.mContext = context.getApplicationContext();
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void getUrlAsync(final IGetUrlAsyncListener iGetUrlAsyncListener) {
            try {
                IMUrlProvider.nextPolicy(true);
                TaskManager.getInstance(IMUrlProvider.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.IMUrlProvider.BDHttpDNSUrlProvider.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.d(IMUrlProvider.TAG, "bddns > getUrlAsync in...");
                        List<String> ipListForceHttp = new DnsHelper(IMUrlProvider.mContext).getIpListForceHttp(Constants.URL_SOCKET_SERVER);
                        if (ipListForceHttp != null && !ipListForceHttp.isEmpty()) {
                            LogUtils.d(IMUrlProvider.TAG, "bddns > bdDnsIps = " + ipListForceHttp);
                            String str = ipListForceHttp.get(new Random().nextInt(ipListForceHttp.size()));
                            iGetUrlAsyncListener.onGetUrlAsncResult(0, Constants.ERROR_MSG_SUCCESS, str);
                            LogUtils.d(IMUrlProvider.TAG, "bddns > return ip = " + str);
                            return;
                        }
                        LogUtils.d(IMUrlProvider.TAG, "bddns > bdDnsIps is null");
                        IMUrlProvider.getProvide(IMUrlProvider.mContext).getUrlAsync(iGetUrlAsyncListener);
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
                LogUtils.d(IMUrlProvider.TAG, "bddns > bdDnsIps get exception ");
                IMUrlProvider.getProvide(IMUrlProvider.mContext).getUrlAsync(iGetUrlAsyncListener);
            }
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void onConnectSucess(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class HttpDNSUrlProvider implements IMUrlProviderInternal {
        static final String LAST_CONNECTED_IP_KEY = "last_connected_ip_key";
        private static HttpDNSUrlProvider mInstance;
        private Context mContext;
        private String[] mIps;
        private int mCurState = 0;
        private int mIpsIndex = -1;
        private boolean mTryHttpRequest = true;

        private HttpDNSUrlProvider(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public static synchronized HttpDNSUrlProvider getUrlProvider(Context context) {
            HttpDNSUrlProvider httpDNSUrlProvider;
            synchronized (HttpDNSUrlProvider.class) {
                if (mInstance == null) {
                    mInstance = new HttpDNSUrlProvider(context);
                }
                httpDNSUrlProvider = mInstance;
            }
            return httpDNSUrlProvider;
        }

        public String getBackupUrl() {
            String cacheIp = getCacheIp();
            return !TextUtils.isEmpty(cacheIp) ? cacheIp : "";
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void getUrlAsync(IGetUrlAsyncListener iGetUrlAsyncListener) {
            LogUtils.i(IMUrlProvider.TAG, "HttpDNSUrlProvider try to getUrlAsync");
            if (iGetUrlAsyncListener != null) {
                IMUrlProvider.nextPolicy(true);
                getUrlAsyncInternal(iGetUrlAsyncListener);
            }
        }

        void getUrlAsyncInternal(IGetUrlAsyncListener iGetUrlAsyncListener) {
            String backupUrl = getBackupUrl();
            if (this.mCurState == 0 && !TextUtils.isEmpty(backupUrl)) {
                LogUtils.i(IMUrlProvider.TAG, "try to connect with cache ip:" + backupUrl);
                this.mCurState++;
                iGetUrlAsyncListener.onGetUrlAsncResult(0, Constants.ERROR_MSG_SUCCESS, backupUrl);
                return;
            }
            clearCachedIp();
            if (this.mIps != null) {
                synchronized (IMUrlProvider.class) {
                    if (this.mIps != null && this.mIpsIndex < this.mIps.length - 1) {
                        this.mIpsIndex++;
                        iGetUrlAsyncListener.onGetUrlAsncResult(0, Constants.ERROR_MSG_SUCCESS, this.mIps[this.mIpsIndex]);
                    } else {
                        IMUrlProvider.nextPolicy(false);
                        IMUrlProvider.getProvide(this.mContext).getUrlAsync(iGetUrlAsyncListener);
                    }
                }
            } else if (this.mTryHttpRequest) {
                GetUrlRequest getUrlRequest = new GetUrlRequest(Constants.URL_SOCKET_SERVER, this, ListenerManager.getInstance().addListener(iGetUrlAsyncListener));
                HttpHelper.executor(this.mContext, getUrlRequest, getUrlRequest);
            } else {
                IMUrlProvider.nextPolicy(false);
                IMUrlProvider.getProvide(this.mContext).getUrlAsync(iGetUrlAsyncListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onGetUrlResult(int i, String str, String[] strArr, String str2) {
            IGetUrlAsyncListener iGetUrlAsyncListener = (IGetUrlAsyncListener) ListenerManager.getInstance().removeListener(str2);
            if (iGetUrlAsyncListener != null) {
                synchronized (IMUrlProvider.class) {
                    if (i == 200 && strArr != null) {
                        if (strArr.length != 0) {
                            this.mIps = strArr;
                        }
                    }
                    this.mIps = null;
                }
                this.mTryHttpRequest = false;
                getUrlAsyncInternal(iGetUrlAsyncListener);
            }
        }

        private String getCacheIp() {
            return this.mContext.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(LAST_CONNECTED_IP_KEY, "");
        }

        boolean saveIp(String str) {
            if (containsIp(str)) {
                return this.mContext.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(LAST_CONNECTED_IP_KEY, str).commit();
            }
            return false;
        }

        boolean clearCachedIp() {
            if (RequsetNetworkUtils.isNetworkAvailable(this.mContext)) {
                return this.mContext.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(LAST_CONNECTED_IP_KEY).commit();
            }
            return false;
        }

        public boolean containsIp(String str) {
            if (this.mIps == null) {
                return false;
            }
            for (int i = 0; i < this.mIps.length; i++) {
                if (this.mIps[i] != null && this.mIps[i].equals(str)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IMUrlProviderInternal
        public void onConnectSucess(String str, boolean z) {
            if (z) {
                saveIp(str);
            }
            refresh();
        }

        public void refresh() {
            this.mCurState = 0;
            this.mIps = null;
            this.mIpsIndex = 0;
            this.mTryHttpRequest = true;
        }
    }

    public static void onConnectSucess(Context context, String str) {
        refresh(context, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void refresh(Context context, String str, boolean z) {
        mCurrentPolicy = 0;
        DefaultUrlProvider.getUrlProvider().onConnectSucess(str, z);
        HttpDNSUrlProvider.getUrlProvider(context).onConnectSucess(str, z);
    }

    static int nextPolicy(boolean z) {
        if (z && Constants.getEnv(mContext) == 0) {
            mLastPolicy = mCurrentPolicy;
            mCurrentPolicy = (mCurrentPolicy + 1) % 3;
        }
        if (Constants.getEnv(mContext) == 1 || Constants.getEnv(mContext) == 2) {
            mCurrentPolicy = 0;
        }
        LogUtils.d(TAG, "try to connect ip, now policy =" + mCurrentPolicy);
        return mCurrentPolicy;
    }

    public static boolean isIp(String str) {
        return (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true;
    }

    public static int getCurrentPolicy() {
        return mLastPolicy;
    }
}
