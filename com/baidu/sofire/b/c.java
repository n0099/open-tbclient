package com.baidu.sofire.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.BDModuleLoadCallback;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.GzfiCallback;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.CallArgs;
import com.baidu.sofire.d.a;
import com.baidu.sofire.k.k;
import com.baidu.sofire.k.q;
import com.baidu.sofire.k.r;
import com.baidu.sofire.k.s;
import com.baidu.sofire.k.t;
import com.baidu.sofire.k.u;
import com.baidu.sofire.mutiprocess.BinderHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kuaishou.weapon.p0.i1;
import com.yy.gslbsdk.db.DelayTB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static long e;
    public static int[] f;
    public static Timer g;
    public static Object h;
    public static List<GzfiCallback> i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BDModuleLoadCallback c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public a(Context context, int i, BDModuleLoadCallback bDModuleLoadCallback, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), bDModuleLoadCallback, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
            this.c = bDModuleLoadCallback;
            this.d = str;
            this.e = str2;
            this.f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context context = this.a;
                try {
                    File file = new File(new File(context.getFilesDir(), "sofire_tmp"), ".tmp");
                    File file2 = new File(file, "fldr");
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        File file3 = new File(context.getFilesDir(), ".b");
                        if (file3.exists() && file3.isDirectory()) {
                            com.baidu.sofire.k.b.d(file3.getAbsolutePath());
                        }
                        com.baidu.sofire.c.a a = com.baidu.sofire.c.a.a(context);
                        Iterator it = ((ArrayList) a.b()).iterator();
                        while (it.hasNext()) {
                            ApkInfo apkInfo = (ApkInfo) it.next();
                            if (!TextUtils.isEmpty(apkInfo.pkgPath) && !apkInfo.pkgPath.contains("sofire_tmp")) {
                                File file4 = new File(apkInfo.pkgPath);
                                File file5 = new File(file, t.a());
                                File file6 = new File(file5, apkInfo.key + "." + apkInfo.versionName + ".p");
                                if (file4.exists()) {
                                    if (!file5.exists()) {
                                        file5.mkdirs();
                                    }
                                    file4.renameTo(file6);
                                    if (file6.exists()) {
                                        apkInfo.pkgPath = file6.getAbsolutePath();
                                        a.a(apkInfo);
                                    }
                                }
                            }
                            File file7 = new File(context.getFilesDir().getCanonicalPath() + i1.j + apkInfo.key);
                            if (file7.exists() && file7.isDirectory()) {
                                com.baidu.sofire.k.b.d(file7.getAbsolutePath());
                            }
                        }
                        File file8 = new File(context.getFilesDir(), ".tmp");
                        File file9 = new File(file8, ".ffnpp");
                        if (file9.exists()) {
                            file9.renameTo(new File(file, ".ffnpp"));
                        }
                        if (file8.exists() && file8.isDirectory()) {
                            com.baidu.sofire.k.b.d(file8.getAbsolutePath());
                        }
                    }
                } catch (IOException unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                c.a(this.a, this.b, this.c, false);
                Context context2 = this.a;
                if (com.baidu.sofire.k.b.i(context2) && !"com.baidu.input".equals(context2.getPackageName())) {
                    StringBuilder sb = new StringBuilder("SDK Self Check: ");
                    int length = sb.length();
                    try {
                        System.loadLibrary("fire");
                    } catch (Throwable unused2) {
                        sb.append("LoadLibrary Error,");
                    }
                    try {
                        Class.forName("com.baidu.sofire.ac.F").getDeclaredMethod("getInstance", new Class[0]);
                    } catch (Exception unused3) {
                        sb.append("Proguard Error,");
                    }
                    try {
                        boolean z = context2.getPackageManager().resolveContentProvider(context2.getPackageName() + ".sofire.ac.provider", 0).multiprocess;
                    } catch (Throwable unused4) {
                        sb.append("Provider Error,");
                    }
                    if (!com.baidu.sofire.k.b.a(context2, false)) {
                        sb.append("Service or Receiver Error.");
                    }
                    if (sb.length() > length) {
                        throw new UnsupportedOperationException(sb.toString());
                    }
                }
                try {
                    if (com.baidu.sofire.k.b.j(this.a) != 1) {
                        Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                        intent.setClass(this.a, MyService.class);
                        intent.setPackage(this.a.getPackageName());
                        intent.addCategory("com.baidu.category.SOFIRE");
                        intent.addCategory("android.intent.category.DEFAULT");
                        Bundle bundle = new Bundle();
                        bundle.putStringArray("appkey", new String[]{this.d, this.e});
                        bundle.putInt("key", this.b);
                        bundle.putInt(DelayTB.DELAY, this.f);
                        intent.putExtra(StateManager.KEY_STATE, bundle);
                        this.a.startService(intent);
                        com.baidu.sofire.d.b.a(this.a);
                        return;
                    }
                    q.f(this.a);
                    if (!com.baidu.sofire.k.b.a(this.a, true)) {
                        return;
                    }
                    c.b(this.a);
                    com.baidu.sofire.b.b a2 = com.baidu.sofire.b.b.a(this.a);
                    Context context3 = this.a;
                    byte[] bArr = com.baidu.sofire.k.d.a;
                    com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context3);
                    String d = a3.d();
                    if (!TextUtils.isEmpty(d)) {
                        String c = com.baidu.sofire.k.b.c(d);
                        if (!TextUtils.isEmpty(c) && !c.equals(a3.a())) {
                            a3.d.putString("xyus", c);
                            a3.d.commit();
                        }
                    }
                    com.baidu.sofire.k.d.a(this.a);
                    Context context4 = this.a;
                    com.baidu.sofire.j.a a4 = com.baidu.sofire.j.a.a(context4);
                    if (!a4.a.getBoolean("s_r_d_l_f", false)) {
                        com.baidu.sofire.k.e.a(context4);
                        com.baidu.sofire.k.d.b(context4);
                        a4.b.putBoolean("s_r_d_l_f", true);
                        a4.b.commit();
                    }
                    if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e)) {
                        a2.b(this.d, this.e);
                    }
                    int i2 = this.f;
                    if (i2 > 0) {
                        Thread.sleep(i2 * 1000);
                    }
                    com.baidu.sofire.j.a a5 = com.baidu.sofire.j.a.a(this.a);
                    int i3 = this.b;
                    if (i3 > 0) {
                        a5.a(i3);
                    } else {
                        int[] iArr = c.f;
                        if (iArr != null && iArr.length > 0) {
                            a5.a(iArr);
                        }
                    }
                    if (r.a(this.a)) {
                        com.baidu.sofire.b.b.b(1);
                        a2.a();
                        return;
                    }
                    boolean unused5 = c.c = true;
                } catch (Throwable unused6) {
                    int i4 = com.baidu.sofire.a.b.a;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Callback a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Class[] d;
        public final /* synthetic */ Object[] e;

        public b(Callback callback, int i, String str, Class[] clsArr, Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {callback, Integer.valueOf(i), str, clsArr, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callback;
            this.b = i;
            this.c = str;
            this.d = clsArr;
            this.e = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Context context = com.baidu.sofire.b.b.e;
                    if (context == null) {
                        for (int i = 0; i < 20; i++) {
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException unused) {
                                int i2 = com.baidu.sofire.a.b.a;
                            }
                            context = com.baidu.sofire.b.b.e;
                            if (context != null) {
                                break;
                            }
                        }
                        if (context == null) {
                            Callback callback = this.a;
                            if (callback != null) {
                                callback.onError(4);
                                return;
                            }
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                    int i3 = com.baidu.sofire.a.b.a;
                }
                if (!r.a(com.baidu.sofire.b.b.e)) {
                    this.a.onError(12);
                } else if (!com.baidu.sofire.k.b.a(com.baidu.sofire.b.b.e, false)) {
                    Callback callback2 = this.a;
                    if (callback2 != null) {
                        callback2.onError(11);
                    }
                } else {
                    String g = com.baidu.sofire.k.b.g(com.baidu.sofire.b.b.e);
                    if (TextUtils.isEmpty(g)) {
                        if (com.baidu.sofire.k.b.f(com.baidu.sofire.b.b.e.getPackageName())) {
                            Callback callback3 = this.a;
                            if (callback3 != null) {
                                callback3.onError(5);
                                return;
                            }
                            return;
                        }
                        com.baidu.sofire.b.b bVar = com.baidu.sofire.b.b.d;
                        if (bVar == null) {
                            for (int i4 = 0; i4 < 20; i4++) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException unused3) {
                                    int i5 = com.baidu.sofire.a.b.a;
                                }
                                bVar = com.baidu.sofire.b.b.d;
                                if (bVar != null) {
                                    break;
                                }
                            }
                            if (bVar == null) {
                                Callback callback4 = this.a;
                                if (callback4 != null) {
                                    callback4.onError(11);
                                    return;
                                }
                                return;
                            }
                        }
                        bVar.a(this.b, this.c, this.a, this.d, this.e);
                        return;
                    } else if (com.baidu.sofire.k.b.f(g)) {
                        Context context2 = com.baidu.sofire.b.b.e;
                        int i6 = this.b;
                        String str = this.c;
                        Callback callback5 = this.a;
                        Class[] clsArr = this.d;
                        Object[] objArr = this.e;
                        if (TextUtils.isEmpty(str)) {
                            if (callback5 != null) {
                                callback5.onError(1);
                                return;
                            }
                            return;
                        }
                        u.a(context2).a(new g(callback5, context2, i6, str, clsArr, objArr));
                        return;
                    } else {
                        com.baidu.sofire.b.b bVar2 = com.baidu.sofire.b.b.d;
                        if (bVar2 == null) {
                            for (int i7 = 0; i7 < 20; i7++) {
                                try {
                                    Thread.sleep(50L);
                                } catch (InterruptedException unused4) {
                                    int i8 = com.baidu.sofire.a.b.a;
                                }
                                bVar2 = com.baidu.sofire.b.b.d;
                                if (bVar2 != null) {
                                    break;
                                }
                            }
                            if (bVar2 == null) {
                                Callback callback6 = this.a;
                                if (callback6 != null) {
                                    callback6.onError(11);
                                    return;
                                }
                                return;
                            }
                        }
                        bVar2.a(this.b, this.c, this.a, this.d, this.e);
                        return;
                    }
                    int i32 = com.baidu.sofire.a.b.a;
                }
            }
        }
    }

    /* renamed from: com.baidu.sofire.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0175c implements GzfiCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.sofire.d.a a;

        public C0175c(com.baidu.sofire.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.sofire.ac.GzfiCallback
        public void onComplete(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("resultCode", i);
                bundle.putString("ztoken", str);
                bundle.putString("errorMsg", str2);
                try {
                    this.a.a(bundle);
                } catch (RemoteException unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2073990804, "Lcom/baidu/sofire/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2073990804, "Lcom/baidu/sofire/b/c;");
                return;
            }
        }
        h = new Object();
        i = new ArrayList();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x0177, blocks: (B:5:0x0010, B:8:0x0027, B:10:0x002c, B:31:0x0095, B:33:0x009f, B:35:0x00a4, B:70:0x014c, B:72:0x0154, B:74:0x0161, B:75:0x0165, B:77:0x0173, B:36:0x00a9, B:38:0x00c2, B:39:0x00c5, B:41:0x00c8, B:43:0x00d2, B:45:0x00da, B:47:0x00e0, B:49:0x00ed, B:48:0x00e3, B:50:0x00f0, B:53:0x00f6, B:55:0x00ff, B:57:0x0108, B:59:0x011d, B:66:0x013f, B:56:0x0104, B:61:0x0124, B:63:0x0134, B:11:0x0031, B:13:0x0042, B:15:0x0047, B:24:0x0078, B:26:0x0082, B:27:0x0086, B:23:0x0073, B:16:0x0055, B:18:0x0058), top: B:86:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x0177, blocks: (B:5:0x0010, B:8:0x0027, B:10:0x002c, B:31:0x0095, B:33:0x009f, B:35:0x00a4, B:70:0x014c, B:72:0x0154, B:74:0x0161, B:75:0x0165, B:77:0x0173, B:36:0x00a9, B:38:0x00c2, B:39:0x00c5, B:41:0x00c8, B:43:0x00d2, B:45:0x00da, B:47:0x00e0, B:49:0x00ed, B:48:0x00e3, B:50:0x00f0, B:53:0x00f6, B:55:0x00ff, B:57:0x0108, B:59:0x011d, B:66:0x013f, B:56:0x0104, B:61:0x0124, B:63:0x0134, B:11:0x0031, B:13:0x0042, B:15:0x0047, B:24:0x0078, B:26:0x0082, B:27:0x0086, B:23:0x0073, B:16:0x0055, B:18:0x0058), top: B:86:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #2 {all -> 0x0177, blocks: (B:5:0x0010, B:8:0x0027, B:10:0x002c, B:31:0x0095, B:33:0x009f, B:35:0x00a4, B:70:0x014c, B:72:0x0154, B:74:0x0161, B:75:0x0165, B:77:0x0173, B:36:0x00a9, B:38:0x00c2, B:39:0x00c5, B:41:0x00c8, B:43:0x00d2, B:45:0x00da, B:47:0x00e0, B:49:0x00ed, B:48:0x00e3, B:50:0x00f0, B:53:0x00f6, B:55:0x00ff, B:57:0x0108, B:59:0x011d, B:66:0x013f, B:56:0x0104, B:61:0x0124, B:63:0x0134, B:11:0x0031, B:13:0x0042, B:15:0x0047, B:24:0x0078, B:26:0x0082, B:27:0x0086, B:23:0x0073, B:16:0x0055, B:18:0x0058), top: B:86:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Pair<Integer, Object> a2;
        String str2;
        String str3;
        int intValue;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            try {
                Class[] clsArr = null;
                Integer num = null;
                if ("gzfi".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    if (bundle != null) {
                        CallArgs callArgs = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs2 = (CallArgs) bundle.getParcelable(WebChromeClient.KEY_ARG_ARRAY);
                        if (callArgs2 != null) {
                            Object[] objArr = callArgs2.e;
                            if (objArr.length == 2) {
                                str3 = (String) objArr[0];
                                num = (Integer) objArr[1];
                                str2 = null;
                            } else if (objArr.length == 3) {
                                String str4 = (String) objArr[0];
                                str2 = (String) objArr[2];
                                num = (Integer) objArr[1];
                                str3 = str4;
                            }
                            if (num != null) {
                                intValue = 0;
                            } else {
                                intValue = num.intValue();
                            }
                            b2 = b(context, str3, intValue, str2);
                            if (!TextUtils.isEmpty(b2)) {
                                bundle2.putInt("status", 8);
                            } else {
                                callArgs.f = b2;
                                bundle2.putParcelable("result", callArgs);
                                bundle2.putInt("status", 0);
                            }
                            return bundle2;
                        }
                        str2 = null;
                        str3 = null;
                        if (num != null) {
                        }
                        b2 = b(context, str3, intValue, str2);
                        if (!TextUtils.isEmpty(b2)) {
                        }
                        return bundle2;
                    }
                } else if ("invokeMethod".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    if (bundle != null) {
                        CallArgs callArgs3 = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs4 = (CallArgs) bundle.getParcelable(WebChromeClient.KEY_ARG_ARRAY);
                        int i2 = callArgs4.a;
                        int i3 = callArgs4.b;
                        String str5 = callArgs4.c;
                        Object[] objArr2 = callArgs4.d;
                        if (objArr2 != null) {
                            clsArr = new Class[objArr2.length];
                            for (int i4 = 0; i4 < objArr2.length; i4++) {
                                String str6 = (String) objArr2[i4];
                                if (!TextUtils.isEmpty(str6) && str6.contains("@@")) {
                                    Class<?> a3 = com.baidu.sofire.k.b.a(str6);
                                    if (a3 != null) {
                                        clsArr[i4] = a3;
                                    }
                                } else {
                                    clsArr[i4] = Class.forName((String) objArr2[i4]);
                                }
                            }
                        }
                        Object[] objArr3 = callArgs4.e;
                        if (i3 == 1) {
                            if (i2 == 1 && "xgz".equals(str5)) {
                                a2 = a(str5, clsArr, objArr3);
                            } else {
                                a2 = a(i2, str5, clsArr, objArr3);
                            }
                            bundle2.putInt("status", ((Integer) a2.first).intValue());
                            if (((Integer) a2.first).intValue() == 0) {
                                callArgs3.f = a2.second;
                            }
                        } else if (i3 == 0) {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            a(i2, str5, new f(bundle2, callArgs3, countDownLatch, str5), clsArr, objArr3);
                            countDownLatch.await(LiveFeedPageSdk.REFRESH_TIME, TimeUnit.MILLISECONDS);
                        }
                        bundle2.putParcelable("result", callArgs3);
                        return bundle2;
                    }
                } else if ("gz".equals(str)) {
                    bundle2.putBoolean("handle_flag", true);
                    String c2 = c(context);
                    if (TextUtils.isEmpty(c2)) {
                        bundle2.putInt("status", 8);
                    } else {
                        CallArgs callArgs5 = new CallArgs();
                        callArgs5.f = c2;
                        bundle2.putParcelable("result", callArgs5);
                        bundle2.putInt("status", 0);
                    }
                    return bundle2;
                } else {
                    bundle2.putInt("status", 2);
                    return bundle2;
                }
            } catch (Throwable unused) {
                int i5 = com.baidu.sofire.a.b.a;
            }
            bundle2.putInt("status", 10);
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public static Pair<Integer, Object> a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, clsArr, objArr})) == null) {
            try {
                Context context = com.baidu.sofire.b.b.e;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!r.a(context)) {
                    return new Pair<>(12, null);
                }
                if (!com.baidu.sofire.k.b.a(com.baidu.sofire.b.b.e, false)) {
                    return new Pair<>(11, null);
                }
                String g2 = com.baidu.sofire.k.b.g(com.baidu.sofire.b.b.e);
                if (TextUtils.isEmpty(g2)) {
                    if (com.baidu.sofire.k.b.f(com.baidu.sofire.b.b.e.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    return com.baidu.sofire.b.b.a(context).a(i2, str, clsArr, objArr);
                } else if (com.baidu.sofire.k.b.f(g2)) {
                    return a(com.baidu.sofire.b.b.e, i2, 1, str, clsArr, objArr);
                } else {
                    return com.baidu.sofire.b.b.a(context).a(i2, str, clsArr, objArr);
                }
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, Object> b(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, clsArr, objArr})) == null) {
            try {
                Context context = com.baidu.sofire.b.b.e;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!com.baidu.sofire.k.b.a(context, false)) {
                    return new Pair<>(11, null);
                }
                String g2 = com.baidu.sofire.k.b.g(com.baidu.sofire.b.b.e);
                if (TextUtils.isEmpty(g2)) {
                    if (com.baidu.sofire.k.b.f(com.baidu.sofire.b.b.e.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    com.baidu.sofire.b.b.a(context);
                    return a(str, clsArr, objArr);
                } else if (com.baidu.sofire.k.b.f(g2)) {
                    return a(com.baidu.sofire.b.b.e, i2, 1, str, clsArr, objArr);
                } else {
                    com.baidu.sofire.b.b.a(context);
                    return a(str, clsArr, objArr);
                }
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, String> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (!com.baidu.sofire.k.b.b(1)) {
                return new Pair<>(-1, "");
            }
            if (com.baidu.sofire.k.b.j(context) == 0) {
                return new Pair<>(-2, "");
            }
            Pair<Integer, Object> a2 = a(1, "gcfs", (Class<?>[]) null, new Object[0]);
            if (a2 != null && ((Integer) a2.first).intValue() == 0) {
                return (Pair) a2.second;
            }
            return new Pair<>(-1, "");
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<Integer, Object> a(Context context, int i2, int i3, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        String str2;
        CallArgs callArgs;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str, clsArr, objArr})) == null) {
            int i4 = 0;
            try {
                int i5 = 1;
                if (TextUtils.isEmpty(str)) {
                    return Pair.create(1, null);
                }
                if (!"gzfi".equals(str) && !"gz".equals(str)) {
                    str2 = "invokeMethod";
                    i5 = 0;
                } else {
                    str2 = str;
                }
                try {
                    CallArgs callArgs2 = new CallArgs();
                    callArgs2.a = i2;
                    callArgs2.c = str;
                    callArgs2.b = i3;
                    if (clsArr != null) {
                        Object[] objArr2 = new Object[clsArr.length];
                        while (i4 < clsArr.length) {
                            if (clsArr[i4].isPrimitive()) {
                                String a2 = com.baidu.sofire.k.b.a(clsArr[i4]);
                                if (!TextUtils.isEmpty(a2)) {
                                    objArr2[i4] = a2 + "@@";
                                }
                            } else {
                                objArr2[i4] = clsArr[i4].getName();
                            }
                            i4++;
                        }
                        callArgs2.d = objArr2;
                    }
                    callArgs2.e = objArr;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(WebChromeClient.KEY_ARG_ARRAY, callArgs2);
                    Bundle a3 = s.a(context, str2, bundle, "sofire");
                    if (a3 == null) {
                        return Pair.create(3, null);
                    }
                    a3.setClassLoader(CallArgs.class.getClassLoader());
                    int i6 = a3.getInt("status");
                    if (i6 == 0) {
                        callArgs = (CallArgs) a3.getParcelable("result");
                    } else {
                        callArgs = null;
                    }
                    Integer valueOf = Integer.valueOf(i6);
                    if (callArgs == null) {
                        obj = null;
                    } else {
                        obj = callArgs.f;
                    }
                    return Pair.create(valueOf, obj);
                } catch (Throwable th) {
                    th = th;
                    i4 = i5;
                    if (i4 != 0) {
                        com.baidu.sofire.b.a.c = com.baidu.sofire.a.b.a(th);
                    }
                    int i7 = com.baidu.sofire.a.b.a;
                    return Pair.create(3, null);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (Pair) invokeCommon.objValue;
        }
    }

    /* JADX DEBUG: Incorrect args count in method signature: (ILjava/lang/String;[Ljava/lang/Class<*>;[Ljava/lang/Object;)Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Object;>; */
    public static Pair a(String str, Class[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, clsArr, objArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair(1, null);
            }
            try {
                iVar = i.g;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (iVar == null) {
                return new Pair(3, null);
            }
            ApkInfo b2 = iVar.b("com.baidu.sofire.x0");
            if (b2 != null) {
                Class<?> a2 = ((h) b2.classLoader).a(com.baidu.sofire.k.b.b(b2.es));
                return new Pair(0, com.baidu.sofire.k.b.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, com.baidu.sofire.b.b.e), str, clsArr, objArr));
            }
            return new Pair(3, null);
        }
        return (Pair) invokeLLL.objValue;
    }

    public static String a(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65543, null, context, str, i2, str2)) == null) {
            try {
            } catch (Throwable th) {
                com.baidu.sofire.b.a.c = com.baidu.sofire.a.b.a(th);
                int i3 = com.baidu.sofire.a.b.a;
            }
            if (context == null) {
                com.baidu.sofire.b.a.b = 1001;
                return "";
            } else if (!TextUtils.isEmpty(a)) {
                if (i2 != 0 && r.a(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
                    } else {
                        a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
                    }
                }
                return a;
            } else if (!com.baidu.sofire.k.b.a(context, false)) {
                com.baidu.sofire.b.a.b = 1002;
                com.baidu.sofire.b.a.a = com.baidu.sofire.k.b.a();
                return "";
            } else {
                String g2 = com.baidu.sofire.k.b.g(context);
                if (TextUtils.isEmpty(g2)) {
                    if (com.baidu.sofire.k.b.f(context.getPackageName())) {
                        com.baidu.sofire.b.a.b = 1003;
                        com.baidu.sofire.b.a.a = com.baidu.sofire.k.b.a();
                        return "";
                    }
                    return b(context, str, i2, str2);
                } else if (com.baidu.sofire.k.b.f(g2)) {
                    Pair<Integer, Object> a2 = a(context, 0, 1, "gzfi", (Class<?>[]) null, str, Integer.valueOf(i2), str2);
                    if (a2 != null) {
                        if (((Integer) a2.first).intValue() == 0) {
                            return (String) a2.second;
                        }
                        com.baidu.sofire.b.a.b = 1004;
                        com.baidu.sofire.b.a.a(((Integer) a2.first).intValue());
                        return "";
                    }
                    com.baidu.sofire.b.a.b = 1004;
                    com.baidu.sofire.b.a.a(-1001);
                    com.baidu.sofire.b.a.b = 1005;
                    com.baidu.sofire.b.a.a(-1002);
                    return "";
                } else {
                    return b(context, str, i2, str2);
                }
            }
        }
        return (String) invokeLLIL.objValue;
    }

    public static void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65544, null, i2, str, str2) == null) {
            synchronized (i) {
                try {
                    for (GzfiCallback gzfiCallback : i) {
                        if (gzfiCallback != null) {
                            int i3 = com.baidu.sofire.a.b.a;
                            gzfiCallback.onComplete(i2, str, str2);
                        }
                    }
                    List<GzfiCallback> list = i;
                    if (list != null) {
                        list.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void a(Context context, int i2, BDModuleLoadCallback bDModuleLoadCallback, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i2), bDModuleLoadCallback, Boolean.valueOf(z)}) == null) && i2 > 0 && bDModuleLoadCallback != null) {
            if (com.baidu.sofire.k.b.b(i2)) {
                bDModuleLoadCallback.onSuccess(i2);
            } else if (System.currentTimeMillis() - e < 10000) {
                bDModuleLoadCallback.onFailure(i2, 8);
            } else {
                e = System.currentTimeMillis();
                if (com.baidu.sofire.k.b.j(context.getApplicationContext()) == 1) {
                    if (!r.a(context.getApplicationContext())) {
                        bDModuleLoadCallback.onFailure(i2, 10);
                        return;
                    }
                    U.addCallback(i2, bDModuleLoadCallback);
                    if (z && !U.sIsRunning) {
                        u.a(context).b(new U(context.getApplicationContext(), 7, true));
                        return;
                    }
                    return;
                }
                bDModuleLoadCallback.onFailure(i2, 9);
            }
        }
    }

    public static String b(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65554, null, context, str, i2, str2)) == null) {
            if (context == null) {
                return "";
            }
            if (i2 != 0) {
                if (TextUtils.isEmpty(str2) && r.a(context)) {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
                } else {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i2), str2);
                }
            }
            return c(context);
        }
        return (String) invokeLLIL.objValue;
    }

    public static synchronized void a(Context context, int i2, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i2), str, str2, bDModuleLoadCallback, Integer.valueOf(i3)}) == null) {
            synchronized (c.class) {
                try {
                    k.b();
                } catch (Throwable unused) {
                    int i4 = com.baidu.sofire.a.b.a;
                }
                if (context == null) {
                    return;
                }
                if (b) {
                    return;
                }
                b = true;
                com.baidu.sofire.b.b.e = context;
                u.a(context).b(new a(context, i3, bDModuleLoadCallback, str, str2, i2));
            }
        }
    }

    public static synchronized void a(Context context, int i2, String str, String str2, int... iArr) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i2), str, str2, iArr}) == null) {
            synchronized (c.class) {
                if (iArr != null) {
                    try {
                        if (iArr.length > 1) {
                            f = iArr;
                            i3 = 0;
                            a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (iArr != null && iArr.length == 1) {
                    i3 = iArr[0];
                    a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
                }
                i3 = 0;
                a(context, i2, str, str2, (BDModuleLoadCallback) null, i3);
            }
        }
    }

    public static synchronized void a(Context context, Bundle bundle) {
        IBinder iBinder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            synchronized (c.class) {
                bundle.setClassLoader(c.class.getClassLoader());
                String string = bundle.getString("accountId", "");
                int i2 = bundle.getInt("scene", 0);
                String string2 = bundle.getString("para", "");
                int i3 = 20;
                int i4 = bundle.getInt("timeout", 20);
                BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("binderHolder");
                if (binderHolder != null && (iBinder = binderHolder.a) != null) {
                    C0175c c0175c = new C0175c(a.AbstractBinderC0177a.a(iBinder));
                    synchronized (c.class) {
                        try {
                            if (com.baidu.sofire.b.b.e == null) {
                                com.baidu.sofire.b.b.e = context.getApplicationContext();
                            }
                            Pair<Integer, String> a2 = a(context);
                            if (a2 != null && ((Integer) a2.first).intValue() == 1) {
                                c0175c.onComplete(((Integer) a2.first).intValue(), a(context, string, i2, string2), "");
                            } else {
                                synchronized (i) {
                                    i.add(c0175c);
                                }
                                if (i4 > 0) {
                                    i3 = i4;
                                }
                                synchronized (h) {
                                    if (g == null) {
                                        Timer timer = new Timer();
                                        g = timer;
                                        timer.schedule(new e(context, string, i2, string2, System.currentTimeMillis() + (i3 * 1000)), 100L, 100L);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                            int i5 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, context, z) == null) {
            synchronized (c.class) {
                if (context == null) {
                    return;
                }
                try {
                    int j = com.baidu.sofire.k.b.j(context);
                    if (j == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("_agree_policy", z);
                        s.a(context, "setAgreePolicy", bundle, "sofire");
                    } else if (j == 1) {
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        r.a = i2;
                        com.baidu.sofire.k.b.a(context, ".ffnpp", !z ? 1 : 0);
                        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                        a2.d.putBoolean("s_a_pl", z);
                        if (Build.VERSION.SDK_INT >= 9) {
                            a2.d.apply();
                        } else {
                            a2.d.commit();
                        }
                        if (z && !d) {
                            d = true;
                            synchronized (c.class) {
                                try {
                                    if (c) {
                                        c = false;
                                        u.a(context).b(new d(context));
                                    }
                                } catch (Throwable unused) {
                                    int i3 = com.baidu.sofire.a.b.a;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    int i4 = com.baidu.sofire.a.b.a;
                }
            }
        }
    }

    public static boolean a(int i2, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), str, callback, clsArr, objArr})) == null) {
            try {
                if (u.a(com.baidu.sofire.b.b.e).a(new b(callback, i2, str, clsArr, objArr)) != 1) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            if (context == null || !com.baidu.sofire.k.b.a(context, false)) {
                return "";
            }
            String g2 = com.baidu.sofire.k.b.g(context);
            if (TextUtils.isEmpty(g2)) {
                if (com.baidu.sofire.k.b.f(context.getPackageName())) {
                    return "";
                }
                return c(context);
            } else if (com.baidu.sofire.k.b.f(g2)) {
                Pair<Integer, Object> a2 = a(context, 0, 1, "gz", (Class<?>[]) null, new Object[0]);
                if (a2 != null) {
                    if (((Integer) a2.first).intValue() != 0) {
                        return "";
                    }
                    return (String) a2.second;
                }
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            } else {
                return c(context);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        com.baidu.sofire.j.a a2;
        String string;
        byte[] re;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                a2 = com.baidu.sofire.j.a.a(context);
                string = a2.c.getString("xytk", "");
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (!TextUtils.isEmpty(string)) {
                a = string;
                return string;
            }
            String string2 = a2.c.getString("xytk_m", "");
            if (!TextUtils.isEmpty(string2)) {
                a = string2;
                return string2;
            }
            String a3 = com.baidu.sofire.k.d.a(context);
            if (!TextUtils.isEmpty(a3)) {
                String[] split = a3.split(WebChromeClient.PARAM_SEPARATOR);
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                        String str = split[0] + com.baidu.sofire.k.b.a(re);
                        a2.d.putString("xytk_m", str);
                        if (Build.VERSION.SDK_INT >= 9) {
                            a2.d.apply();
                        } else {
                            a2.d.commit();
                        }
                        a = str;
                        return str;
                    }
                }
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
        return (String) invokeL.objValue;
    }
}
