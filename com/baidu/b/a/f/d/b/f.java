package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class f {
    protected com.baidu.b.a.f.d.f aag;
    protected int aav = -1;
    protected int aaw = -1;

    public abstract boolean rU();

    public void m(com.baidu.b.a.f.d.f fVar) {
        this.aag = fVar;
    }

    public int rV() {
        return this.aav;
    }

    public int rW() {
        return this.aaw;
    }

    protected String rX() {
        return com.baidu.b.a.h.e.ae(this.aag.rM().getDownloadPath(), this.aag.rL().md5);
    }

    protected String rY() {
        String rX = rX();
        String str = rX;
        while (true) {
            File file = new File(str);
            if (!file.exists()) {
                return file.getAbsolutePath();
            }
            str = rX + BaseRequestAction.SPLITE + System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean rZ() {
        com.baidu.b.a.c.a.a rL = this.aag.rL();
        if (rL.Zw > 0 && !TextUtils.isEmpty(rL.filePath)) {
            if (rL.Zx == rL.Zw && com.baidu.b.a.h.e.g(rL.filePath, rL.Zx) && com.baidu.b.a.h.e.af(rL.filePath, rL.md5)) {
                this.aag.bH(10);
                return false;
            }
            com.baidu.b.a.h.h.deleteFile(rL.filePath);
            com.baidu.b.a.f.d.e.a(rL, 0L);
        } else {
            rL.filePath = rY();
            com.baidu.b.a.f.d.e.g(rL);
        }
        return true;
    }
}
