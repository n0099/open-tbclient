package com.baidu.nps.main.manager;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.invoke.InvokeException;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import d.b.w.c.a.f;
import d.b.w.c.a.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class NPSManager {
    public static final String TAG = "NPS-NPSManager";
    public static NPSManager sInstance = new NPSManager();
    public Map<String, Bundle> mBundleMap = new HashMap();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IInvokeCallback f8853g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8854h;
        public final /* synthetic */ Class i;

        public a(String str, String str2, IInvokeCallback iInvokeCallback, int i, Class cls) {
            this.f8851e = str;
            this.f8852f = str2;
            this.f8853g = iInvokeCallback;
            this.f8854h = i;
            this.i = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.f8851e) && !TextUtils.isEmpty(this.f8852f)) {
                int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.f8851e, this.f8854h);
                if (prepareBundle != 41) {
                    if (d.b.w.h.b.a()) {
                        Log.i(NPSManager.TAG, "loadClazz, retCode=" + prepareBundle);
                    }
                    this.f8853g.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                    return;
                }
                NPSPackageManager.getInstance().recordBundleRunning(this.f8851e);
                Bundle bundleInternal = NPSManager.this.getBundleInternal(this.f8851e);
                if (bundleInternal == null) {
                    if (d.b.w.h.b.a()) {
                        Log.i(NPSManager.TAG, "loadClazz, retCode=5");
                    }
                    this.f8853g.onResult(5, Constant.MSG.retMsgInvalidPkg(this.f8851e), null);
                    return;
                }
                try {
                    Class loadClass = bundleInternal.loadClass(this.f8852f, this.i);
                    f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                    if (d.b.w.h.b.a()) {
                        Log.i(NPSManager.TAG, "loadClazz, retCode=14");
                    }
                    this.f8853g.onResult(14, Constant.MSG.retMsgSuccess(), loadClass);
                    return;
                } catch (InvokeException e2) {
                    f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                    if (d.b.w.h.b.a()) {
                        Log.i(NPSManager.TAG, "loadClazz, retCode=" + e2.errCode());
                    }
                    this.f8853g.onResult(e2.errCode(), e2.errMsg(), null);
                    return;
                } catch (InitException e3) {
                    f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                    if (d.b.w.h.b.a()) {
                        Log.i(NPSManager.TAG, "loadClazz, retCode=" + e3.errCode());
                    }
                    this.f8853g.onResult(e3.errCode(), e3.errMsg(), null);
                    return;
                }
            }
            if (d.b.w.h.b.a()) {
                Log.i(NPSManager.TAG, "loadClazz, retCode=5");
            }
            this.f8853g.onResult(5, Constant.MSG.retMsgErrParam(this.f8851e, this.f8852f), null);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            System.exit(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle getBundleInternal(String str) {
        Bundle bundle = this.mBundleMap.get(str);
        if (bundle != null) {
            return bundle;
        }
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
        if (bundleInfo == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundleInfo);
        this.mBundleMap.put(str, bundle2);
        return bundle2;
    }

    public static NPSManager getInstance() {
        return sInstance;
    }

    private boolean isBundleRunning(String str) {
        return NPSPackageManager.getInstance().isBundleRunning(str);
    }

    private Class loadClazzInternal(String str, String str2, Class cls) {
        Bundle bundleInternal = getBundleInternal(str);
        if (bundleInternal == null) {
            return null;
        }
        return bundleInternal.loadClass(str2, cls);
    }

    private void registerRestartReceiver() {
        ContextHolder.getApplicationContext().registerReceiver(new b(), new IntentFilter(d.b.w.h.a.f65591a));
    }

    public Bundle getBundle(String str) {
        return getBundleInternal(str);
    }

    public synchronized void init(Context context, Configurations configurations) {
        init(context, configurations, true);
    }

    public Activity instantiateActivity(String str) {
        Class loadComponentClass = loadComponentClass(str);
        if (loadComponentClass == null) {
            return null;
        }
        try {
            return (Activity) loadComponentClass.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public ContentProvider instantiateProvider(String str, String str2) {
        Class loadClazzInternal = loadClazzInternal(str, str2, ContentProvider.class);
        if (loadClazzInternal == null) {
            return null;
        }
        try {
            return (ContentProvider) loadClazzInternal.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public BroadcastReceiver instantiateReceiver(String str) {
        Class loadComponentClass = loadComponentClass(str);
        if (loadComponentClass == null) {
            return null;
        }
        try {
            return (BroadcastReceiver) loadComponentClass.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public Service instantiateService(String str) {
        Class loadComponentClass = loadComponentClass(str);
        if (loadComponentClass == null) {
            return null;
        }
        try {
            return (Service) loadComponentClass.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public Object invoke(String str, String str2, Object[] objArr) {
        int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
        if (prepareBundle == 41) {
            NPSPackageManager.getInstance().recordBundleRunning(str);
            Bundle bundleInternal = getBundleInternal(str);
            if (bundleInternal == null) {
                return null;
            }
            return bundleInternal.invoke(str2, objArr);
        }
        throw new RuntimeException("invoke error retcode=" + prepareBundle);
    }

    public void loadClazz(String str, String str2, Class cls, IInvokeCallback iInvokeCallback) {
        loadClazz(str, str2, cls, 0, iInvokeCallback);
    }

    public Class loadComponentClass(String str) {
        Bundle bundleInternal;
        String packageNameFromComponent = NPSPackageManager.getInstance().getPackageNameFromComponent(str);
        if (TextUtils.isEmpty(packageNameFromComponent) || (bundleInternal = getBundleInternal(packageNameFromComponent)) == null) {
            return null;
        }
        Class loadClass = bundleInternal.loadClass(str);
        NPSPackageManager.getInstance().recordBundleRunning(packageNameFromComponent);
        return loadClass;
    }

    public void loadClazz(String str, String str2, Class cls, int i, IInvokeCallback iInvokeCallback) {
        g.a().b().run(new a(str, str2, iInvokeCallback, i, cls));
    }

    public synchronized void init(Context context, Configurations configurations, boolean z) {
        d.b.w.h.b.b(configurations.debug);
        registerRestartReceiver();
        if (z) {
            NPSPackageManager.getInstance().init();
        }
    }

    public LoadResult loadClazz(String str, String str2, Class cls) {
        LoadResult loadResult = new LoadResult();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
            if (prepareBundle != 41) {
                loadResult.setRet(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                return loadResult;
            }
            NPSPackageManager.getInstance().recordBundleRunning(str);
            Bundle bundleInternal = getBundleInternal(str);
            if (bundleInternal == null) {
                loadResult.setRet(5, Constant.MSG.retMsgInvalidPkg(str), null);
                return loadResult;
            }
            try {
                Class loadClass = bundleInternal.loadClass(str2, cls);
                f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                loadResult.setRet(14, Constant.MSG.retMsgSuccess(), loadClass);
                return loadResult;
            } catch (InvokeException e2) {
                f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                loadResult.setRet(e2.errCode(), e2.errMsg(), null);
                return loadResult;
            } catch (InitException e3) {
                f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                loadResult.setRet(e3.errCode(), e3.errMsg(), null);
                return loadResult;
            }
        }
        loadResult.setRet(5, Constant.MSG.retMsgErrParam(str, str2), null);
        return loadResult;
    }

    public void invoke(String str, String str2, IInvokeCallback iInvokeCallback, Object[] objArr) {
        if (iInvokeCallback != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
                if (prepareBundle != 41) {
                    iInvokeCallback.onResult(prepareBundle, Constant.MSG.retMsgBundleNotReady(prepareBundle), null);
                    return;
                }
                NPSPackageManager.getInstance().recordBundleRunning(str);
                Bundle bundleInternal = getBundleInternal(str);
                if (bundleInternal == null) {
                    iInvokeCallback.onResult(5, Constant.MSG.retMsgInvalidPkg(str), null);
                    return;
                }
                try {
                    Object invoke = bundleInternal.invoke(str2, objArr);
                    f.a().b().recordInvokeResult(14, bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), Constant.MSG.retMsgSuccess());
                    iInvokeCallback.onResult(14, Constant.MSG.retMsgSuccess(), invoke);
                    return;
                } catch (InvokeException e2) {
                    f.a().b().recordInvokeResult(e2.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e2.errMsg());
                    iInvokeCallback.onResult(e2.errCode(), e2.errMsg(), null);
                    return;
                } catch (InitException e3) {
                    f.a().b().recordInvokeResult(e3.errCode(), bundleInternal.getBundleInfo().getPackageName(), bundleInternal.getBundleInfo().getVersionCode(), e3.errMsg());
                    iInvokeCallback.onResult(e3.errCode(), e3.errMsg(), null);
                    return;
                }
            }
            iInvokeCallback.onResult(5, Constant.MSG.retMsgErrParam(str, str2), null);
            return;
        }
        throw new IllegalArgumentException("param callback should not be null!");
    }
}
