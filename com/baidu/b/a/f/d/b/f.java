package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class f {
    protected int aaE = -1;
    protected int aaF = -1;
    protected com.baidu.b.a.f.d.f aap;

    public abstract boolean rY();

    public void m(com.baidu.b.a.f.d.f fVar) {
        this.aap = fVar;
    }

    public int rZ() {
        return this.aaE;
    }

    public int sa() {
        return this.aaF;
    }

    protected String sb() {
        return com.baidu.b.a.h.e.af(this.aap.rQ().getDownloadPath(), this.aap.rP().md5);
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
        com.baidu.b.a.c.a.a rP = this.aap.rP();
        if (rP.ZF > 0 && !TextUtils.isEmpty(rP.filePath)) {
            if (rP.ZG == rP.ZF && com.baidu.b.a.h.e.g(rP.filePath, rP.ZG) && com.baidu.b.a.h.e.ag(rP.filePath, rP.md5)) {
                this.aap.bH(10);
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
