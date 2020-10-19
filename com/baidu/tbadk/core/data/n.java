package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n extends bw {
    public static final BdUniqueId elv = BdUniqueId.gen();
    private boolean elw = false;
    private boolean elx = false;
    private boolean ely = false;
    private int elz;

    public boolean bgg() {
        return this.elw;
    }

    public void il(boolean z) {
        this.elw = z;
    }

    public boolean bgh() {
        return this.elx;
    }

    public void im(boolean z) {
        this.elx = z;
    }

    public boolean bgi() {
        return this.ely;
    }

    public void in(boolean z) {
        this.ely = z;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return elv;
    }

    public void setFloorNum(int i) {
        this.elz = i;
    }

    public int getFloorNum() {
        return this.elz;
    }
}
