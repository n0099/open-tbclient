package com.baidu.tbadk.core.util.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
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
            this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0210e.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0210e.ds184);
        this.height = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.C0210e.ds184);
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean jD() {
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
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ex() {
        return this.procType;
    }
}
