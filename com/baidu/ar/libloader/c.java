package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends b {
    private String sO;
    private a sQ;
    private boolean sR = false;
    private List<String> sP = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);
    }

    public c(String str) {
        this.sO = str;
    }

    private void av(String str) {
        try {
            System.load(str);
        } catch (Throwable th) {
            if (this.sQ != null) {
                this.sQ.a(str, th.getMessage());
            }
            throw th;
        }
    }

    private List<String> fh() {
        List<String> asList = Arrays.asList("c++_shared", "opencv_java3", "anakin_lite");
        try {
            for (String str : asList) {
                require(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return asList;
    }

    public void a(a aVar) {
        this.sQ = aVar;
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void load(Context context, ILibLoader.b bVar) {
        super.load(context, bVar);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        super.prepareCaseRes(aRType, str, str2, aVar);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[DONT_GENERATE, FINALLY_INSNS, RETURN, SYNTHETIC] */
    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void require(String str) {
        boolean isEmpty;
        boolean exists;
        boolean z = true;
        com.baidu.ar.h.b.k("LocalWithPathLibLoader", "require libName = " + str);
        if (!this.sR) {
            this.sR = true;
            if (fh().contains(str)) {
                return;
            }
        }
        try {
            super.require(str);
            if (this.sP.contains(str)) {
                return;
            }
            this.sP.add(str);
        } finally {
            if (!isEmpty) {
                if (exists) {
                    if (z) {
                    }
                }
            }
        }
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        super.setLibLoadPlugin(iLibLoaderPlugin);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        if (cVar == null || !this.sP.contains(str)) {
            super.setLibReadyListener(str, cVar);
        } else {
            cVar.onReady();
        }
    }
}
