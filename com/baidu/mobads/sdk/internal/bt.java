package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.mobads.sdk.internal.cg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes3.dex */
public class bt extends Thread {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "ApkDownloadThread";
    public static final int c = 900000;
    public static volatile bt h;
    public transient /* synthetic */ FieldHolder $fh;
    public cg.a a;
    public volatile String d;
    public String e;
    public double f;
    public Handler g;
    public final Context i;
    public cg j;
    public final bv k;
    public br l;

    public bt(Context context, bv bvVar, String str, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bvVar, str, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.j = null;
        this.l = br.a();
        this.a = new bu(this);
        this.i = context;
        this.k = bvVar;
        a(bvVar.c());
        this.g = handler;
        this.e = str;
    }

    public static bt a(Context context, bv bvVar, String str, Handler handler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, bvVar, str, handler)) == null) {
            if (h == null) {
                h = new bt(context, bvVar, str, handler);
            }
            return h;
        }
        return (bt) invokeLLLL.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String str = bx.e + UUID.randomUUID().toString() + ".jar";
            String str2 = this.e + str;
            File file = new File(str2);
            try {
                file.createNewFile();
                this.j.a(this.e, str);
                return str2;
            } catch (IOException e) {
                file.delete();
                throw e;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (!b()) {
                    return;
                }
                try {
                    a();
                    this.l.a(b, "download apk successfully, downloader exit");
                    h = null;
                } catch (IOException e) {
                    br brVar = this.l;
                    brVar.a(b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.l.a(b, "no newer apk, downloader exit");
                h = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bv bvVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, str, bvVar, str2) == null) {
            if (str.equals(bx.k) || str.equals(bx.l)) {
                Message obtainMessage = this.g.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putParcelable(bx.m, bvVar);
                bundle.putString(bx.n, str);
                obtainMessage.setData(bundle);
                this.g.sendMessage(obtainMessage);
            }
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                try {
                    this.j = new cg(this.i, new URL(this.d), this.k, this.a);
                } catch (MalformedURLException unused) {
                    this.j = new cg(this.i, this.d, this.k, this.a);
                }
                if (bx.q != null) {
                    d = bx.q.b;
                } else if (bx.p != null) {
                    if (bx.p.b > 0.0d) {
                        d = bx.p.b;
                    } else {
                        d = bx.p.b;
                    }
                } else {
                    d = 0.0d;
                }
                this.l.a(b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.k.b());
                if (d > 0.0d) {
                    if (this.k.b() > 0.0d) {
                        this.l.a(b, "remote not null, local apk version is null, force upgrade");
                        this.f = this.k.b();
                        return true;
                    }
                    this.l.a(b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                } else if (this.k.b() <= 0.0d) {
                    this.l.a(b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
                    return false;
                } else if (this.k.b() <= d) {
                    return false;
                } else {
                    this.f = this.k.b();
                    return true;
                }
            } catch (Exception e) {
                String str = "parse apk failed, error:" + e.toString();
                this.l.a(b, str);
                throw new bx.a(str);
            }
        }
        return invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
            interrupt();
        }
    }
}
