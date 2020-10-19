package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements Comparable<t> {
    public String elL;
    public String elM;
    public boolean elN;
    public String elO;
    public String elP;
    public String elQ;
    public String elR;
    public boolean elS;
    public int elT;
    public int elU;
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
        tVar.mIcon = dVar.bUs;
        tVar.elQ = dVar.elQ;
        tVar.mPrice = dVar.eMn;
        tVar.elL = dVar.elL;
        tVar.elS = dVar.elS;
        tVar.mDescription = dVar.mDescription;
        tVar.elN = dVar.elT == 1;
        tVar.elT = dVar.elT;
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
        tVar.mContent = TextUtils.isEmpty(aVar.cCs()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cCs() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        tVar.mTitle = aVar.cCq();
        tVar.elR = aVar.cCt();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.elQ = aVar.cCs();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cCr() != null) {
            tVar.elO = aVar.cCr().cCu();
            tVar.elP = aVar.cCr().cCv();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.elU - tVar.elU;
    }
}
