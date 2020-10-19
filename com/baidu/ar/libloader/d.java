package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes14.dex */
public class d extends c {
    private String sx;
    private a sz;
    private boolean sA = false;
    private List<String> sy = new ArrayList();

    /* loaded from: classes14.dex */
    public interface a {
        void a(String str, String str2);
    }

    public d(String str) {
        this.sx = str;
    }

    private void at(String str) {
        try {
            System.load(str);
        } catch (Throwable th) {
            if (this.sz != null) {
                this.sz.a(str, th.getMessage());
            }
            throw th;
        }
    }

    private List<String> fi() {
        List<String> asList = Arrays.asList("c++_shared", "opencv_java3", "anakin_lite");
        try {
            for (String str : asList) {
                as(str);
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
    public /* bridge */ /* synthetic */ void a(ARType aRType, String str, String str2, a.InterfaceC0085a interfaceC0085a) {
        super.a(aRType, str, str2, interfaceC0085a);
    }

    public void a(a aVar) {
        this.sz = aVar;
    }

    @Override // com.baidu.ar.libloader.c, com.baidu.ar.libloader.a
    public void a(String str, a.c cVar) {
        if (cVar == null || !this.sy.contains(str)) {
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
    public void as(String str) {
        boolean isEmpty;
        boolean exists;
        boolean z = true;
        if (!this.sA) {
            this.sA = true;
            if (fi().contains(str)) {
                return;
            }
        }
        try {
            super.as(str);
            if (this.sy.contains(str)) {
                return;
            }
            this.sy.add(str);
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
