package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class i extends a {
    private int Xc;

    public i(int i) {
        this.Xc = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a d(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CH().fM(str);
        if (fM == null || fM.iY() == null) {
            return null;
        }
        return fM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        Bitmap decodeFile;
        if (StringUtils.isNull(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(decodeFile, false);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Xc;
    }
}
