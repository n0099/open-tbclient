package com.baidu.minivideo.arface.b;

import android.util.Log;
import com.baidu.minivideo.arface.b.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private static String ceh = "def";
    private h cei;
    private List<i> cej;
    private List<i> cek;
    d cel;
    d cem;
    private i cen;
    private i.a ceo;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class a {
        private static final b ceq = new b();
    }

    public static final b jP(String str) {
        ceh = str;
        return a.ceq;
    }

    private b() {
        this.cej = new ArrayList();
        this.cek = null;
        this.ceo = new i.a<i>() { // from class: com.baidu.minivideo.arface.b.b.1
        };
        this.cei = new h(e.acv().acx());
        this.cei.jQ(ceh);
        acn();
    }

    public File acm() {
        return this.cem.cet;
    }

    private void acn() {
        this.cej.clear();
        if (this.cek != null) {
            this.cek.clear();
        }
        this.cel = d.acp();
        this.cem = d.acq();
        this.cen = new c(this.cem);
        a(this.cen);
        a(new c(this.cel));
    }

    private void a(i iVar) {
        boolean isLoaded = iVar.isLoaded();
        if (isDebug()) {
            d("isLoaded " + isLoaded + ", " + iVar.getUrl() + " to " + iVar.getLocalFile());
        }
        if (iVar.isLoaded()) {
            this.cej.add(iVar);
            return;
        }
        if (this.cek == null) {
            this.cek = new ArrayList();
        }
        this.cek.add(iVar);
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }

    private static void d(String str) {
        Log.d("DuAr_InitModel", str);
    }
}
