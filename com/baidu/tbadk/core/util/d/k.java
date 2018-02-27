package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class k extends a {
    private int procType;

    public k(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mw().gP(str);
        if (gP == null || gP.sh() == null) {
            return null;
        }
        return gP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        Bitmap decodeFile;
        if (StringUtils.isNull(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(decodeFile, false);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DK() {
        return this.procType;
    }
}
