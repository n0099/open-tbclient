package aegon.chrome.net;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.annotations.CalledByNative;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ProxyChangeListener {
    public static final /* synthetic */ boolean $assertionsDisabled = !ProxyChangeListener.class.desiredAssertionStatus();
    public static boolean sEnabled = true;
    public long mNativePtr;
    public ProxyReceiver mProxyReceiver;
    public BroadcastReceiver mRealProxyReceiver;
    public final Looper mLooper = Looper.myLooper();
    public final Handler mHandler = new Handler(this.mLooper);

    /* loaded from: classes4.dex */
    public static class ProxyConfig {
        public static final ProxyConfig DIRECT = new ProxyConfig("", 0, "", new String[0]);
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        public ProxyConfig(String str, int i, String str2, String[] strArr) {
            this.mHost = str;
            this.mPort = i;
            this.mPacUrl = str2;
            this.mExclusionList = strArr;
        }

        public static /* synthetic */ ProxyConfig access$100(ProxyInfo proxyInfo) {
            if (proxyInfo == null) {
                return null;
            }
            Uri pacFileUrl = proxyInfo.getPacFileUrl();
            return new ProxyConfig(proxyInfo.getHost(), proxyInfo.getPort(), Uri.EMPTY.equals(pacFileUrl) ? null : pacFileUrl.toString(), proxyInfo.getExclusionList());
        }
    }

    /* loaded from: classes4.dex */
    public class ProxyReceiver extends BroadcastReceiver {
        public /* synthetic */ ProxyReceiver(AnonymousClass1 anonymousClass1) {
            ProxyChangeListener.this = r1;
        }

        public static /* synthetic */ void lambda$onReceive$0(ProxyReceiver proxyReceiver, Intent intent) {
            Object obj;
            ProxyConfig proxyConfig;
            ProxyChangeListener proxyChangeListener = ProxyChangeListener.this;
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    proxyConfig = ProxyConfig.access$100((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
                    proxyChangeListener.proxySettingsChanged(proxyConfig);
                }
                try {
                    obj = extras.get(IMTrack.AckBuilder.PROXY_TYPE);
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
                    Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e);
                    proxyConfig = null;
                }
                if (obj != null) {
                    Class<?> cls = Class.forName("android.net.ProxyProperties");
                    Method declaredMethod = cls.getDeclaredMethod("getHost", new Class[0]);
                    Method declaredMethod2 = cls.getDeclaredMethod("getPort", new Class[0]);
                    Method declaredMethod3 = cls.getDeclaredMethod("getExclusionList", new Class[0]);
                    String str = (String) declaredMethod.invoke(obj, new Object[0]);
                    int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
                    String[] split = ((String) declaredMethod3.invoke(obj, new Object[0])).split(",");
                    if (Build.VERSION.SDK_INT >= 19) {
                        String str2 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                        if (!TextUtils.isEmpty(str2)) {
                            proxyConfig = new ProxyConfig(str, intValue, str2, split);
                            proxyChangeListener.proxySettingsChanged(proxyConfig);
                        }
                    }
                    proxyConfig = new ProxyConfig(str, intValue, null, split);
                    proxyChangeListener.proxySettingsChanged(proxyConfig);
                }
            }
            proxyConfig = null;
            proxyChangeListener.proxySettingsChanged(proxyConfig);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.runOnThread(ProxyChangeListener$ProxyReceiver$$Lambda$1.lambdaFactory$(this, intent));
            }
        }
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    public static /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0(ProxyChangeListener proxyChangeListener) {
        ProxyInfo defaultProxy = ((ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")).getDefaultProxy();
        proxyChangeListener.proxySettingsChanged(defaultProxy == null ? ProxyConfig.DIRECT : ProxyConfig.access$100(defaultProxy));
    }

    private native void nativeProxySettingsChanged(long j);

    private native void nativeProxySettingsChangedTo(long j, String str, int i, String str2, String[] strArr);

    public final void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON) {
            if (!(this.mLooper == Looper.myLooper())) {
                throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
            }
        }
    }

    public final void proxySettingsChanged(ProxyConfig proxyConfig) {
        assertOnThread();
        if (sEnabled) {
            long j = this.mNativePtr;
            if (j != 0) {
                if (proxyConfig != null) {
                    nativeProxySettingsChangedTo(j, proxyConfig.mHost, proxyConfig.mPort, proxyConfig.mPacUrl, proxyConfig.mExclusionList);
                } else {
                    nativeProxySettingsChanged(j);
                }
            }
        }
    }

    public final void runOnThread(Runnable runnable) {
        if (this.mLooper == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    @CalledByNative
    public void start(long j) {
        assertOnThread();
        if (!$assertionsDisabled && this.mNativePtr != 0) {
            throw new AssertionError();
        }
        this.mNativePtr = j;
        assertOnThread();
        if (!$assertionsDisabled && this.mProxyReceiver != null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && this.mRealProxyReceiver != null) {
            throw new AssertionError();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(null);
        if (Build.VERSION.SDK_INT < 23) {
            ContextUtils.sApplicationContext.registerReceiver(this.mProxyReceiver, intentFilter);
            return;
        }
        ContextUtils.sApplicationContext.registerReceiver(this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        ContextUtils.sApplicationContext.registerReceiver(this.mRealProxyReceiver, intentFilter);
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0L;
        assertOnThread();
        if (!$assertionsDisabled && this.mProxyReceiver == null) {
            throw new AssertionError();
        }
        ContextUtils.sApplicationContext.unregisterReceiver(this.mProxyReceiver);
        BroadcastReceiver broadcastReceiver = this.mRealProxyReceiver;
        if (broadcastReceiver != null) {
            ContextUtils.sApplicationContext.unregisterReceiver(broadcastReceiver);
        }
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    public void updateProxyConfigFromConnectivityManager() {
        runOnThread(ProxyChangeListener$$Lambda$1.lambdaFactory$(this));
    }
}
