package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends a {
    private int height;
    private int procType;
    private int width;

    public h(boolean z, int i) {
        this.width = 0;
        this.height = 0;
        this.procType = 0;
        this.procType = i;
        if (z) {
            this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds184);
        this.height = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds184);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a f = super.f(str, str2, objArr);
        if (f != null && f.mZ() != null && f.mZ().isRecycled()) {
            return null;
        }
        return f;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ij() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ak() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
        return this.procType;
    }
}
