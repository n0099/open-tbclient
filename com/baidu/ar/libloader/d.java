package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
public class d extends c {
    private String rS;
    private a rU;
    private boolean rV = false;
    private List<String> rT = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void a(String str, String str2);
    }

    public d(String str) {
        this.rS = str;
    }

    private void ap(String str) {
        try {
            System.load(str);
        } catch (Throwable th) {
            if (this.rU != null) {
                this.rU.a(str, th.getMessage());
            }
            throw th;
        }
    }

    private List<String> dX() {
        List<String> asList = Arrays.asList("c++_shared", "opencv_java3", "anakin_lite");
        try {
            for (String str : asList) {
                ao(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return asList;
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public /* bridge */ /* synthetic */ void a(Context context, a.b bVar) {
        super.a(context, bVar);
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public /* bridge */ /* synthetic */ void a(ARType aRType, String str, String str2, a.InterfaceC0086a interfaceC0086a) {
        super.a(aRType, str, str2, interfaceC0086a);
    }

    public void a(a aVar) {
        this.rU = aVar;
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public void a(String str, a.c cVar) {
        if (cVar == null || !this.rT.contains(str)) {
            super.a(str, cVar);
        } else {
            cVar.onReady();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[DONT_GENERATE, FINALLY_INSNS, RETURN, SYNTHETIC] */
    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ao(String str) {
        boolean isEmpty;
        boolean exists;
        boolean z = true;
        if (!this.rV) {
            this.rV = true;
            if (dX().contains(str)) {
                return;
            }
        }
        try {
            super.ao(str);
            if (this.rT.contains(str)) {
                return;
            }
            this.rT.add(str);
        } finally {
            if (!isEmpty) {
                if (exists) {
                    if (z) {
                    }
                }
            }
        }
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public /* bridge */ /* synthetic */ void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        super.setLibLoadPlugin(iLibLoaderPlugin);
    }
}
