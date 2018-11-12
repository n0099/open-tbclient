package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class f {
    protected com.baidu.b.a.f.d.f aag;
    protected int aav = -1;
    protected int aaw = -1;

    public abstract boolean rV();

    public void m(com.baidu.b.a.f.d.f fVar) {
        this.aag = fVar;
    }

    public int rW() {
        return this.aav;
    }

    public int rX() {
        return this.aaw;
    }

    protected String rY() {
        return com.baidu.b.a.h.e.ae(this.aag.rN().getDownloadPath(), this.aag.rM().md5);
    }

    protected String rZ() {
        String rY = rY();
        String str = rY;
        while (true) {
            File file = new File(str);
            if (!file.exists()) {
                return file.getAbsolutePath();
            }
            str = rY + BaseRequestAction.SPLITE + System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sa() {
        com.baidu.b.a.c.a.a rM = this.aag.rM();
        if (rM.Zw > 0 && !TextUtils.isEmpty(rM.filePath)) {
            if (rM.Zx == rM.Zw && com.baidu.b.a.h.e.g(rM.filePath, rM.Zx) && com.baidu.b.a.h.e.af(rM.filePath, rM.md5)) {
                this.aag.bH(10);
                return false;
            }
            com.baidu.b.a.h.h.deleteFile(rM.filePath);
            com.baidu.b.a.f.d.e.a(rM, 0L);
        } else {
            rM.filePath = rZ();
            com.baidu.b.a.f.d.e.g(rM);
        }
        return true;
    }
}
