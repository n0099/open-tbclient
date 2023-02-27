package com.baidu.ar.libloader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.storage.swankv.SwanKV;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b {
    public String sO;
    public a sQ;
    public boolean sR = false;
    public List<String> sP = new ArrayList();

    /* loaded from: classes.dex */
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
            a aVar = this.sQ;
            if (aVar != null) {
                aVar.a(str, th.getMessage());
            }
            throw th;
        }
    }

    private List<String> fh() {
        List<String> asList = Arrays.asList(SwanKV.LIB_CPP_SHARED, "opencv_java3", "anakin_lite");
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

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
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
        } catch (Throwable unused) {
            if (TextUtils.isEmpty(this.sO)) {
                return;
            }
            File file = new File(this.sO, "lib" + str + ".so");
            if (file.exists()) {
                av(file.getAbsolutePath());
                if (this.sP.contains(str)) {
                    return;
                }
                this.sP.add(str);
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
