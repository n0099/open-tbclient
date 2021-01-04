package aegon.chrome.net.impl;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.NetworkChangeNotifier;
import aegon.chrome.net.RegistrationPolicyAlwaysRegister;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
/* loaded from: classes5.dex */
public class CronetLibraryLoader {
    public static volatile boolean sInitThreadInitDone;
    public static final /* synthetic */ boolean $assertionsDisabled = !CronetLibraryLoader.class.desiredAssertionStatus();
    public static final Object sLoadLock = new Object();
    public static final String LIBRARY_NAME = "cronet.77.0.3865.0";
    public static final String TAG = CronetLibraryLoader.class.getSimpleName();
    public static final HandlerThread sInitThread = new HandlerThread("CronetInit");
    public static volatile boolean sLibraryLoaded = false;
    public static final ConditionVariable sWaitForLibLoad = new ConditionVariable();

    public static void ensureInitialized(Context context, CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        synchronized (sLoadLock) {
            if (!sInitThreadInitDone) {
                ContextUtils.initApplicationContext(context);
                if (!sInitThread.isAlive()) {
                    sInitThread.start();
                }
                postToInitThread(new Runnable() { // from class: aegon.chrome.net.impl.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.ensureInitializedOnInitThread();
                    }
                });
            }
            if (!sLibraryLoaded) {
                if (((NativeCronetEngineBuilderWithLibraryLoaderImpl) cronetEngineBuilderImpl).mLibraryLoader != null) {
                    ((NativeCronetEngineBuilderWithLibraryLoaderImpl) cronetEngineBuilderImpl).mLibraryLoader.mWrappedLoader.loadLibrary(LIBRARY_NAME);
                } else {
                    System.loadLibrary(LIBRARY_NAME);
                }
                if (!"77.0.3865.0".equals(nativeGetCronetVersion())) {
                    throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", "77.0.3865.0", nativeGetCronetVersion()));
                }
                String str = TAG;
                Object[] objArr = new Object[2];
                objArr[0] = "77.0.3865.0";
                objArr[1] = System.getProperty("os.arch");
                Log.i(str, "Cronet version: %s, arch: %s", objArr);
                sLibraryLoaded = true;
                sWaitForLibLoad.open();
            }
        }
    }

    @CalledByNative
    public static void ensureInitializedFromNative() {
        synchronized (sLoadLock) {
            sLibraryLoaded = true;
            sWaitForLibLoad.open();
        }
        Context context = ContextUtils.sApplicationContext;
        if (!$assertionsDisabled && context == null) {
            throw new AssertionError();
        }
        ensureInitialized(context, null);
    }

    public static void ensureInitializedOnInitThread() {
        Runnable runnable;
        if (!$assertionsDisabled) {
            if (!(sInitThread.getLooper() == Looper.myLooper())) {
                throw new AssertionError();
            }
        }
        if (sInitThreadInitDone) {
            return;
        }
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
        sWaitForLibLoad.block();
        if (!$assertionsDisabled && !sLibraryLoaded) {
            throw new AssertionError();
        }
        runnable = CronetLibraryLoader$$Lambda$1.instance;
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError e) {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError e2) {
                runnable.run();
            }
        }
        sInitThreadInitDone = true;
    }

    @CalledByNative
    public static String getDefaultUserAgent() {
        return UserAgent.from(ContextUtils.sApplicationContext);
    }

    public static native void nativeCronetInitOnInitThread();

    public static native String nativeGetCronetVersion();

    public static void postToInitThread(Runnable runnable) {
        if (sInitThread.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(sInitThread.getLooper()).post(runnable);
        }
    }

    @CalledByNative
    public static void setNetworkThreadPriorityOnNetworkThread(int i) {
        Process.setThreadPriority(i);
    }
}
