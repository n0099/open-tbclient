package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class t implements Comparable<t> {
    public String dXA;
    public String dXB;
    public boolean dXC;
    public int dXD;
    public int dXE;
    public String dXv;
    public String dXw;
    public boolean dXx;
    public String dXy;
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
        tVar.mIcon = dVar.bLF;
        tVar.dXA = dVar.dXA;
        tVar.mPrice = dVar.exW;
        tVar.dXv = dVar.dXv;
        tVar.dXC = dVar.dXC;
        tVar.mDescription = dVar.mDescription;
        tVar.dXx = dVar.dXD == 1;
        tVar.dXD = dVar.dXD;
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
        tVar.mTitle = aVar.cvz();
        tVar.dXB = aVar.cvB();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.dXA = aVar.adA();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cvA() != null) {
            tVar.dXy = aVar.cvA().cvC();
            tVar.dXz = aVar.cvA().cvD();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.dXE - tVar.dXE;
    }
}
