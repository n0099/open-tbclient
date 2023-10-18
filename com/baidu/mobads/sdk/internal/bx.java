package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;
/* loaded from: classes3.dex */
public class bx {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ApkLoader";
    public static Thread.UncaughtExceptionHandler b = null;
    public static final String c = "__badApkVersion__9.322";
    public static final String d = "previousProxyVersion";
    public static final String e = "__xadsdk__remote__final__";
    public static final String f = "bdxadsdk.jar";
    public static final String g = "__xadsdk__remote__final__builtin__.jar";
    public static final String h = "__xadsdk__remote__final__builtinversion__.jar";
    public static final String i = "__xadsdk__remote__final__downloaded__.jar";
    public static final String j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    public static volatile bm p = null;
    public static volatile bm q = null;
    public static volatile Class r = null;
    public static String s = null;
    public static final Handler t;
    public static final String x = "baidu_sdk_remote";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CopyOnWriteArrayList<c> B;
    public c C;
    public Handler u;
    @SuppressLint({"HandlerLeak"})
    public final Handler v;
    public bv w;
    public final Context y;
    public br z;

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "9.322" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public static final class a extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long a = 2978543166232984104L;
        public transient /* synthetic */ FieldHolder $fh;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            br.a().c(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long a = -7838296421993681751L;
        public transient /* synthetic */ FieldHolder $fh;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            br.a().c(str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833694137, "Lcom/baidu/mobads/sdk/internal/bx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833694137, "Lcom/baidu/mobads/sdk/internal/bx;");
                return;
            }
        }
        t = new by(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            return this.y.getSharedPreferences(w.aH, 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            String string = m().getString(d, null);
            String a2 = a();
            if (string == null || !string.equals(a2)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            try {
                if (!bp.a(c())) {
                    if (!bp.a(f())) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                this.z.a(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new File(f()).delete();
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
        }
        return invokeV.intValue;
    }

    public IXAdContainerFactory i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(p);
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public IXAdContainerFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return a(q);
        }
        return (IXAdContainerFactory) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && p != null) {
            p.b();
            p = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bx(Activity activity) {
        this(activity.getApplicationContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bv bvVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, bvVar) == null) && bvVar.a().booleanValue()) {
            bt a2 = bt.a(this.y, bvVar, s, this.v);
            if (!a2.isAlive()) {
                this.z.a(a, "XApkDownloadThread starting ...");
                a2.start();
                return;
            }
            this.z.a(a, "XApkDownloadThread already started");
            a2.a(bvVar.c());
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, null, context) == null) && TextUtils.isEmpty(s)) {
            File dir = context.getDir(x, 0);
            s = dir.getAbsolutePath() + "/";
        }
    }

    public bx(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.z = br.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new bz(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = cl.a(context);
            cl.a(context).a(new ca(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof cl)) {
            Thread.setDefaultUncaughtExceptionHandler(b);
        }
    }

    public static double b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            JarFile jarFile = null;
            try {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            if (ck.d.booleanValue()) {
                File file = new File(str);
                if (bp.a(file)) {
                    JarFile jarFile2 = new JarFile(file);
                    try {
                        double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                        if (parseDouble > 0.0d) {
                            try {
                                jarFile2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            return parseDouble;
                        }
                        jarFile = jarFile2;
                    } catch (Exception unused2) {
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        return 0.0d;
                    } catch (Throwable th2) {
                        th = th2;
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            try {
                                jarFile.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                return 0.0d;
            }
            return Double.valueOf("9.322").doubleValue();
        }
        return invokeL.doubleValue;
    }

    public static synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, context) == null) {
            synchronized (bx.class) {
                try {
                    String c2 = c();
                    double b2 = b(c2);
                    br a2 = br.a();
                    a2.a(a, "copy assets,compare version=" + Double.valueOf("9.322") + "remote=" + b2);
                    if (Double.valueOf("9.322").doubleValue() != b2) {
                        bq bqVar = new bq(c2, context);
                        if (bqVar.exists()) {
                            bqVar.delete();
                        }
                        bp.a(context, f, c2);
                    }
                } catch (Exception e2) {
                    throw new b("loadBuiltInApk failed: " + e2.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, this, z) == null) {
            if (z) {
                try {
                    d2 = p.b;
                } catch (Exception unused) {
                    return;
                }
            } else {
                d2 = 0.0d;
            }
            an.a(d2, new cd(this, d2), new ce(this));
        }
    }

    private IXAdContainerFactory a(bm bmVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bmVar)) == null) {
            if (bmVar == null) {
                return null;
            }
            try {
                return bmVar.a();
            } catch (Exception unused) {
                return null;
            }
        }
        return (IXAdContainerFactory) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, cVar, handler) == null) {
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
                this.B.add(cVar);
            }
            this.u = handler;
            if (p == null) {
                g();
            } else {
                b(true);
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (TextUtils.isEmpty(s)) {
                File dir = context.getDir(x, 0);
                s = dir.getAbsolutePath() + "/";
            }
            if (TextUtils.isEmpty(s)) {
                return "";
            }
            return s + j;
        }
        return (String) invokeL.objValue;
    }

    public static double b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                c(context);
                double b2 = b(f());
                String d2 = d();
                if (Double.valueOf("9.322").doubleValue() > b(d2)) {
                    bq bqVar = new bq(d2, context);
                    if (bqVar.exists()) {
                        bqVar.delete();
                    }
                    bp.a(context, f, d2);
                }
                return Math.max(b2, b(d()));
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bq bqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bqVar) == null) {
            Class<?> b2 = bqVar.b();
            synchronized (this) {
                q = new bm(b2, this.y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            Message obtainMessage = this.u.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putBoolean("success", z);
            obtainMessage.setData(bundle);
            obtainMessage.what = 0;
            this.u.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65549, this, z, str) == null) {
            synchronized (this) {
                try {
                    cl.a(this.y).c();
                    if (this.B != null && this.B.size() > 0) {
                        for (int i2 = 0; i2 < this.B.size(); i2++) {
                            c cVar = this.B.get(i2);
                            if (cVar != null) {
                                cVar.a(z);
                            }
                        }
                    }
                    if (this.B != null) {
                        this.B.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void b(bq bqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, bqVar) == null) {
            br brVar = this.z;
            brVar.a(a, "len=" + bqVar.length() + ", path=" + bqVar.getAbsolutePath());
            if (p == null) {
                String a2 = a(this.y);
                bq bqVar2 = new bq(a2, this.y);
                if (bqVar2.exists()) {
                    bqVar2.delete();
                }
                try {
                    bp.a(new FileInputStream(bqVar), a2);
                } catch (Exception e2) {
                    this.z.c(e2);
                }
                p = new bm(bqVar2.b(), this.y);
                try {
                    IXAdContainerFactory a3 = p.a();
                    br brVar2 = this.z;
                    brVar2.a(a, "preloaded apk.version=" + a3.getRemoteVersion());
                    return;
                } catch (a e3) {
                    br brVar3 = this.z;
                    brVar3.a(a, "preload local apk " + bqVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
                    a(e3.getMessage());
                    throw e3;
                }
            }
            br brVar4 = this.z;
            brVar4.a(a, "mApkBuilder already initialized, version: " + p.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, this, z) == null) {
            if (!z && !o()) {
                this.A = true;
            } else {
                if (z) {
                    str = "apk Successfully Loaded";
                } else {
                    str = "apk Load Failed";
                }
                a(z, str);
            }
            if (this.A) {
                ba.a().a((h) new cb(this, z));
            } else {
                ba.a().a(new cc(this, z), 5L, TimeUnit.SECONDS);
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (TextUtils.isEmpty(s)) {
                return "";
            }
            return s + g;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (TextUtils.isEmpty(s)) {
                return "";
            }
            return s + h;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (TextUtils.isEmpty(s)) {
                return "";
            }
            return s + i;
        }
        return (String) invokeV.objValue;
    }

    private boolean c(bq bqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, bqVar)) == null) {
            synchronized (this) {
                b(bqVar);
                br brVar = this.z;
                brVar.a(a, "loaded: " + bqVar.getPath());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                File[] listFiles = this.y.getFilesDir().listFiles();
                int i2 = 0;
                while (listFiles != null) {
                    if (i2 < listFiles.length) {
                        if (listFiles[i2].getAbsolutePath().contains(e) && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                            listFiles[i2].delete();
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } catch (Exception e2) {
                br.a().c(e2);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.z.a(a, "start load assets file");
            d(this.y);
            String c2 = c();
            bq bqVar = new bq(c2, this.y);
            if (bp.a(bqVar)) {
                this.z.a(a, "assets file can read ,will use it ");
                if (c(bqVar)) {
                    b(true);
                    return;
                }
                return;
            }
            throw new b("loadBuiltInApk failed: " + c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            bq bqVar = new bq(f(), this.y);
            if (bp.a(bqVar)) {
                try {
                    if (!n()) {
                        synchronized (this) {
                            br brVar = this.z;
                            brVar.a(a, "loadDownloadedOrBuiltInApk len=" + bqVar.length() + ", path=" + bqVar.getAbsolutePath());
                            b(bqVar);
                            double d2 = (double) m().getFloat(c, -1.0f);
                            br brVar2 = this.z;
                            brVar2.a(a, "downloadedApkFile.getApkVersion(): " + bqVar.c() + ", badApkVersion: " + d2);
                            if (bqVar.c() != d2) {
                                br brVar3 = this.z;
                                brVar3.a(a, "loaded: " + bqVar.getPath());
                            } else {
                                throw new a("downloaded file marked bad, drop it and use built-in");
                            }
                        }
                        return true;
                    }
                    throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                } catch (a e2) {
                    br brVar4 = this.z;
                    brVar4.a(a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                    if (bqVar.exists()) {
                        bqVar.delete();
                    }
                    k();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            a(cVar, t);
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, handler) == null) {
            ba.a().a((h) new cf(this, cVar, handler));
        }
    }

    @TargetApi(9)
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(c, (float) p.b);
            edit.apply();
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (h() != 2) {
                z = p();
            } else {
                z = false;
            }
            if (z) {
                this.z.a(a, "load downloaded file success,use it");
                b(true);
                return;
            }
            this.z.a(a, "no downloaded file yet, use built-in apk file");
            try {
                e();
            } catch (b e2) {
                br brVar = this.z;
                brVar.a(a, "loadBuiltInApk failed: " + e2.toString());
                throw new a("load built-in apk failed" + e2.toString());
            }
        }
    }
}
