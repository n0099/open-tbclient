package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b.C0008b a;
    public final /* synthetic */ b b;

    public d(b bVar, b.C0008b c0008b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, c0008b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bVar;
        this.a = c0008b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
        if (r1 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
        if (r3 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Context context;
        String i;
        String b;
        String j;
        boolean b2;
        String i2;
        boolean c;
        boolean g;
        String l;
        b.C0008b h;
        boolean b3;
        String f;
        b bVar;
        String str;
        b.C0008b e;
        boolean b4;
        String f2;
        String j2;
        boolean b5;
        String i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.C0008b c0008b = new b.C0008b(null);
            b.C0008b c0008b2 = this.a;
            c0008b.b = c0008b2.b;
            c0008b.a = c0008b2.a;
            context = this.b.b;
            File file = new File(context.getFilesDir(), "libcuid.so");
            i = b.i(c0008b.c());
            if (file.exists()) {
                b = b.b(file);
                j = b.j(b);
                b.C0008b b6 = b.C0008b.b(j);
                if (b6 != null) {
                    b2 = this.b.b(b6);
                    if (b2) {
                        b bVar2 = this.b;
                        i2 = b.i(b6.c());
                        bVar2.e(i2);
                    }
                }
                c = this.b.c();
                if (c) {
                    f2 = this.b.f("com.baidu.deviceid.v2");
                    if (!TextUtils.isEmpty(f2)) {
                        j2 = b.j(f2);
                        b.C0008b b7 = b.C0008b.b(j2);
                        if (b7 != null) {
                            b5 = this.b.b(b7);
                            if (b5) {
                                b bVar3 = this.b;
                                i3 = b.i(b7.c());
                                bVar3.b("com.baidu.deviceid.v2", i3);
                            }
                        }
                    }
                    this.b.b("com.baidu.deviceid.v2", i);
                }
                g = this.b.g("android.permission.WRITE_EXTERNAL_STORAGE");
                if (g) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        e = this.b.e();
                        if (e != null) {
                            b4 = this.b.b(e);
                            if (b4) {
                                i = b.i(e.c());
                            }
                        }
                    }
                    b.k(i);
                }
                if (c) {
                    f = this.b.f("bd_setting_i");
                    if (b.C0008b.a(TextUtils.isEmpty(f) ? 0 : f.length())) {
                        bVar = this.b;
                        str = "O";
                    } else if (b.C0008b.a(f)) {
                        bVar = this.b;
                        str = "0";
                    }
                    bVar.b("bd_setting_i", str);
                }
                if (g || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
                }
                l = this.b.l("");
                h = this.b.h(l);
                if (h != null) {
                    b3 = this.b.b(h);
                    if (b3) {
                        b.c(h.b, h.a);
                        return;
                    }
                    return;
                }
                return;
            }
            this.b.e(i);
            c = this.b.c();
            if (c) {
            }
            g = this.b.g("android.permission.WRITE_EXTERNAL_STORAGE");
            if (g) {
            }
            if (c) {
            }
            if (g) {
            }
        }
    }
}
