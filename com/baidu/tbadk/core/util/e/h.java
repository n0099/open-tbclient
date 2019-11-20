package com.baidu.tbadk.core.util.e;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
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
            this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.height = this.width;
            return;
        }
        this.width = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
        this.height = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
    }

    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    public boolean fW() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return this.width;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return this.height;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }
}
