package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class i extends a {
    private int procType;

    public i(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vW() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a gi = com.baidu.tbadk.imageManager.c.DZ().gi(str);
        if (gi == null || gi.kN() == null) {
            return null;
        }
        return gi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        Bitmap decodeFile;
        if (StringUtils.isNull(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(decodeFile, false);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vY() {
        return this.procType;
    }
}
