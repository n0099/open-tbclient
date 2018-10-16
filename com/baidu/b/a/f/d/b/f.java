package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class f {
    protected com.baidu.b.a.f.d.f aag;
    protected int aav = -1;
    protected int aaw = -1;

    public abstract boolean rY();

    public void m(com.baidu.b.a.f.d.f fVar) {
        this.aag = fVar;
    }

    public int rZ() {
        return this.aav;
    }

    public int sa() {
        return this.aaw;
    }

    protected String sb() {
        return com.baidu.b.a.h.e.ae(this.aag.rQ().getDownloadPath(), this.aag.rP().md5);
    }

    protected String sc() {
        String sb = sb();
        String str = sb;
        while (true) {
            File file = new File(str);
            if (!file.exists()) {
                return file.getAbsolutePath();
            }
            str = sb + BaseRequestAction.SPLITE + System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sd() {
        com.baidu.b.a.c.a.a rP = this.aag.rP();
        if (rP.Zw > 0 && !TextUtils.isEmpty(rP.filePath)) {
            if (rP.Zx == rP.Zw && com.baidu.b.a.h.e.g(rP.filePath, rP.Zx) && com.baidu.b.a.h.e.af(rP.filePath, rP.md5)) {
                this.aag.bs(10);
                return false;
            }
            com.baidu.b.a.h.h.deleteFile(rP.filePath);
            com.baidu.b.a.f.d.e.a(rP, 0L);
        } else {
            rP.filePath = sc();
            com.baidu.b.a.f.d.e.g(rP);
        }
        return true;
    }
}
