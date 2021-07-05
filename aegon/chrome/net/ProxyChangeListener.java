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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ProxyChangeListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean sEnabled = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler mHandler;
    public final Looper mLooper;
    public long mNativePtr;
    public ProxyReceiver mProxyReceiver;
    public BroadcastReceiver mRealProxyReceiver;

    /* renamed from: aegon.chrome.net.ProxyChangeListener$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class ProxyConfig {
        public static /* synthetic */ Interceptable $ic;
        public static final ProxyConfig DIRECT;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78600491, "Laegon/chrome/net/ProxyChangeListener$ProxyConfig;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(78600491, "Laegon/chrome/net/ProxyChangeListener$ProxyConfig;");
                    return;
                }
            }
            DIRECT = new ProxyConfig("", 0, "", new String[0]);
        }

        public ProxyConfig(String str, int i2, String str2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mHost = str;
            this.mPort = i2;
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

    /* loaded from: classes.dex */
    public class ProxyReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ ProxyReceiver(AnonymousClass1 anonymousClass1) {
            ProxyChangeListener.this = r1;
        }

        public static /* synthetic */ void lambda$onReceive$0(ProxyReceiver proxyReceiver, Intent intent) {
            ProxyChangeListener proxyChangeListener = ProxyChangeListener.this;
            Bundle extras = intent.getExtras();
            ProxyConfig proxyConfig = null;
            if (extras != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    proxyConfig = ProxyConfig.access$100((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
                } else {
                    try {
                        Object obj = extras.get(IMTrack.AckBuilder.PROXY_TYPE);
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
                                }
                            }
                            proxyConfig = new ProxyConfig(str, intValue, null, split);
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e2) {
                        Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e2);
                    }
                }
            }
            proxyChangeListener.proxySettingsChanged(proxyConfig);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.runOnThread(ProxyChangeListener$ProxyReceiver$$Lambda$1.$ic);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651082697, "Laegon/chrome/net/ProxyChangeListener;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651082697, "Laegon/chrome/net/ProxyChangeListener;");
        }
    }

    public ProxyChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLooper = Looper.myLooper();
        this.mHandler = new Handler(this.mLooper);
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? new ProxyChangeListener() : (ProxyChangeListener) invokeV.objValue;
    }

    @CalledByNative
    public static String getProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? System.getProperty(str) : (String) invokeL.objValue;
    }

    public static /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0(ProxyChangeListener proxyChangeListener) {
        ProxyInfo defaultProxy = ((ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity")).getDefaultProxy();
        proxyChangeListener.proxySettingsChanged(defaultProxy == null ? ProxyConfig.DIRECT : ProxyConfig.access$100(defaultProxy));
    }

    private native void nativeProxySettingsChanged(long j);

    private native void nativeProxySettingsChangedTo(long j, String str, int i2, String str2, String[] strArr);

    public final void assertOnThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && BuildConfig.DCHECK_IS_ON) {
            if (!(this.mLooper == Looper.myLooper())) {
                throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
            }
        }
    }

    public final void proxySettingsChanged(ProxyConfig proxyConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, proxyConfig) == null) {
            assertOnThread();
            if (sEnabled) {
                long j = this.mNativePtr;
                if (j == 0) {
                    return;
                }
                if (proxyConfig != null) {
                    nativeProxySettingsChangedTo(j, proxyConfig.mHost, proxyConfig.mPort, proxyConfig.mPacUrl, proxyConfig.mExclusionList);
                } else {
                    nativeProxySettingsChanged(j);
                }
            }
        }
    }

    public final void runOnThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            if (this.mLooper == Looper.myLooper()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    @CalledByNative
    public void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            assertOnThread();
            this.mNativePtr = j;
            assertOnThread();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PROXY_CHANGE");
            ProxyReceiver proxyReceiver = new ProxyReceiver(null);
            this.mProxyReceiver = proxyReceiver;
            BroadcastReceiver broadcastReceiver = proxyReceiver;
            if (Build.VERSION.SDK_INT >= 23) {
                ContextUtils.sApplicationContext.registerReceiver(proxyReceiver, new IntentFilter());
                BroadcastReceiver proxyBroadcastReceiver = new ProxyBroadcastReceiver(this);
                this.mRealProxyReceiver = proxyBroadcastReceiver;
                broadcastReceiver = proxyBroadcastReceiver;
            }
            ContextUtils.sApplicationContext.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @CalledByNative
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            assertOnThread();
            this.mNativePtr = 0L;
            assertOnThread();
            ContextUtils.sApplicationContext.unregisterReceiver(this.mProxyReceiver);
            BroadcastReceiver broadcastReceiver = this.mRealProxyReceiver;
            if (broadcastReceiver != null) {
                ContextUtils.sApplicationContext.unregisterReceiver(broadcastReceiver);
            }
            this.mProxyReceiver = null;
            this.mRealProxyReceiver = null;
        }
    }

    public void updateProxyConfigFromConnectivityManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            runOnThread(ProxyChangeListener$$Lambda$1.$ic);
        }
    }
}
