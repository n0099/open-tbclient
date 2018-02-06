package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.SafeBindDeviceCallback;
import com.baidu.sapi2.callback.SafeFacadeCallback;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.AbsPassPiSafe;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.SafeBindDeviceResult;
import com.baidu.sapi2.result.SafeFacadeResult;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.FH;
/* loaded from: classes.dex */
public final class SapiSafeFacade {
    private static final String a = "SapiSafeFacade";
    private static SapiSafeFacade b;

    private SapiSafeFacade() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized SapiSafeFacade a() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (b == null) {
                b = new SapiSafeFacade();
            }
            sapiSafeFacade = b;
        }
        return sapiSafeFacade;
    }

    public void checkSafeAsync(String str, String str2, int i, SafeFacadeCallback safeFacadeCallback) {
        if (safeFacadeCallback == null) {
            throw new IllegalArgumentException(SafeFacadeResult.class.getSimpleName() + " can't be null");
        }
        SafeFacadeResult safeFacadeResult = new SafeFacadeResult();
        ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new AnonymousClass1(safeFacadeCallback, SapiAccountManager.getInstance().getSapiConfiguration(), safeFacadeResult, str, str2, i)));
    }

    /* renamed from: com.baidu.sapi2.SapiSafeFacade$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ SafeFacadeCallback a;
        final /* synthetic */ SapiConfiguration b;
        final /* synthetic */ SafeFacadeResult c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        AnonymousClass1(SafeFacadeCallback safeFacadeCallback, SapiConfiguration sapiConfiguration, SafeFacadeResult safeFacadeResult, String str, String str2, int i) {
            this.a = safeFacadeCallback;
            this.b = sapiConfiguration;
            this.c = safeFacadeResult;
            this.d = str;
            this.e = str2;
            this.f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onStart();
            if (!SapiContext.getInstance(this.b.context).getSofireSdkEnabled()) {
                this.c.safeItems = null;
                this.c.setResultCode(-1);
                this.a.onFailure(this.c);
                this.a.onFinish();
                return;
            }
            ThreadPoolService.getInstance().runImport(new TPRunnable(new RunnableC00671()));
        }

        /* renamed from: com.baidu.sapi2.SapiSafeFacade$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC00671 implements Runnable {
            RunnableC00671() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbsPassPiSafe absPassPiSafe = PluginFacade.getAbsPassPiSafe();
                    if (absPassPiSafe == null) {
                        Log.e(SapiSafeFacade.a, "checkSafeAsync() no absPassSafe");
                        ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1.this.c.safeItems = null;
                                AnonymousClass1.this.c.setResultCode(-2);
                                AnonymousClass1.this.a.onFailure(AnonymousClass1.this.c);
                                AnonymousClass1.this.a.onFinish();
                            }
                        }));
                    } else {
                        Log.d(SapiSafeFacade.a, "checkSafeAsync() do check");
                        absPassPiSafe.checkSafeAsync(AnonymousClass1.this.d, AnonymousClass1.this.e, AnonymousClass1.this.f, new AbsPassPiSafe.ISafeCallback() { // from class: com.baidu.sapi2.SapiSafeFacade.1.1.2
                            @Override // com.baidu.sapi2.passhost.pluginsdk.AbsPassPiSafe.ISafeCallback
                            public void onFinished(Pair<Integer, Object> pair, final Pair<Integer, Object> pair2) {
                                if (pair2 == null) {
                                    ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.1.1.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1.this.c.setResultCode(-202);
                                            AnonymousClass1.this.a.onFailure(AnonymousClass1.this.c);
                                            AnonymousClass1.this.a.onFinish();
                                        }
                                    }));
                                    return;
                                }
                                AnonymousClass1.this.c.setResultCode(((Integer) pair2.first).intValue());
                                AnonymousClass1.this.c.safeItems = pair2;
                                ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.1.1.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (((Integer) pair2.first).intValue() == 0) {
                                            AnonymousClass1.this.a.onSuccess(AnonymousClass1.this.c);
                                        } else {
                                            AnonymousClass1.this.a.onFailure(AnonymousClass1.this.c);
                                        }
                                        AnonymousClass1.this.a.onFinish();
                                    }
                                }));
                            }
                        });
                        Log.d(SapiSafeFacade.a, "checkSafeAsync() do check end");
                    }
                } catch (Throwable th) {
                    Log.e(SapiSafeFacade.a, "checkSafeAsync()", th.toString());
                    ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.1.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1.this.c.setResultCode(-202);
                            AnonymousClass1.this.a.onFailure(AnonymousClass1.this.c);
                            AnonymousClass1.this.a.onFinish();
                        }
                    }));
                }
            }
        }
    }

    public void bindDeviceAsync(String str, int i, String str2, int i2, SafeBindDeviceCallback safeBindDeviceCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("uid can't be null or empty");
        }
        if (safeBindDeviceCallback == null) {
            throw new IllegalArgumentException(SafeBindDeviceCallback.class.getSimpleName() + " can't be null");
        }
        SafeBindDeviceResult safeBindDeviceResult = new SafeBindDeviceResult();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiContext.getInstance(sapiConfiguration.context).setSofireZidInited(false);
        new Handler(Looper.getMainLooper()).post(new AnonymousClass2(safeBindDeviceCallback, sapiConfiguration, safeBindDeviceResult, str2, i2, str, i));
    }

    /* renamed from: com.baidu.sapi2.SapiSafeFacade$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ SafeBindDeviceCallback a;
        final /* synthetic */ SapiConfiguration b;
        final /* synthetic */ SafeBindDeviceResult c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;

        AnonymousClass2(SafeBindDeviceCallback safeBindDeviceCallback, SapiConfiguration sapiConfiguration, SafeBindDeviceResult safeBindDeviceResult, String str, int i, String str2, int i2) {
            this.a = safeBindDeviceCallback;
            this.b = sapiConfiguration;
            this.c = safeBindDeviceResult;
            this.d = str;
            this.e = i;
            this.f = str2;
            this.g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onStart();
            if (!SapiContext.getInstance(this.b.context).getSofireSdkEnabled()) {
                this.c.setResultCode(-1);
                this.c.sofireZid = null;
                this.a.onFailure(this.c);
                this.a.onFinish();
                return;
            }
            try {
                final Callback callback = new Callback() { // from class: com.baidu.sapi2.SapiSafeFacade.2.1
                    @Override // com.baidu.sofire.ac.Callback
                    public Object onEnd(final Object... objArr) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if ((objArr[0] instanceof String) && !TextUtils.isEmpty(String.valueOf(objArr))) {
                                    AnonymousClass2.this.c.sofireZid = String.valueOf(objArr[0]);
                                    AnonymousClass2.this.c.setResultCode(0);
                                    SapiContext.getInstance(AnonymousClass2.this.b.context).setSofireZidInited(true);
                                    AnonymousClass2.this.a.onSuccess(AnonymousClass2.this.c);
                                } else {
                                    AnonymousClass2.this.c.setResultCode(-202);
                                    AnonymousClass2.this.a.onFailure(AnonymousClass2.this.c);
                                }
                                AnonymousClass2.this.a.onFinish();
                            }
                        });
                        return super.onEnd(objArr);
                    }

                    @Override // com.baidu.sofire.ac.Callback
                    public Object onError(Object... objArr) {
                        AnonymousClass2.this.c.setResultCode(Integer.parseInt(String.valueOf(objArr[0])));
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2.this.a.onFailure(AnonymousClass2.this.c);
                                AnonymousClass2.this.a.onFinish();
                            }
                        });
                        return super.onError(objArr);
                    }
                };
                ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FH.call(1, AnonymousClass2.this.d, callback, new Class[]{Integer.TYPE, String.class, Integer.TYPE}, Integer.valueOf(AnonymousClass2.this.e), AnonymousClass2.this.f, Integer.valueOf(AnonymousClass2.this.g));
                    }
                }));
            } catch (Throwable th) {
                Log.e(th);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiSafeFacade.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.c.setResultCode(-202);
                        AnonymousClass2.this.a.onFailure(AnonymousClass2.this.c);
                        AnonymousClass2.this.a.onFinish();
                    }
                });
            }
        }
    }

    public String getCurrentZid(Context context) {
        String str = null;
        if (SapiAccountManager.getInstance().isLogin()) {
            str = SapiAccountManager.getInstance().getSession("uid");
        }
        String zidAndCheckSafe = SapiAccountManager.getInstance().getSafeFacade().getZidAndCheckSafe(context, str, 1);
        return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }
}
