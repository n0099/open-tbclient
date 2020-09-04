package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements Comparable<t> {
    public String dXA;
    public boolean dXB;
    public String dXC;
    public String dXD;
    public String dXE;
    public String dXF;
    public boolean dXG;
    public int dXH;
    public int dXI;
    public String dXz;
    public String mContent;
    public String mDescription;
    public String mIcon;
    public int mId;
    public String mPrice;
    public String mTitle;
    public int mType;

    public t(int i, int i2) {
        this.mId = i;
        this.mType = i2;
    }

    public static t a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tbadk.core.view.spanGroup.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        t tVar = new t(tbLinkSpanGroup.getId(), 1);
        if (dVar == null) {
            return tVar;
        }
        tVar.mTitle = dVar.mTitle;
        tVar.mIcon = dVar.bLJ;
        tVar.dXE = dVar.dXE;
        tVar.mPrice = dVar.eya;
        tVar.dXz = dVar.dXz;
        tVar.dXG = dVar.dXG;
        tVar.mDescription = dVar.mDescription;
        tVar.dXB = dVar.dXH == 1;
        tVar.dXH = dVar.dXH;
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    public static t a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tieba.i.a aVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        t tVar = new t(tbLinkSpanGroup.getId(), 2);
        if (aVar == null) {
            return tVar;
        }
        tVar.mContent = TextUtils.isEmpty(aVar.adA()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.adA() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        tVar.mTitle = aVar.cvA();
        tVar.dXF = aVar.cvC();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.dXE = aVar.adA();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cvB() != null) {
            tVar.dXC = aVar.cvB().cvD();
            tVar.dXD = aVar.cvB().cvE();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.dXI - tVar.dXI;
    }
}
