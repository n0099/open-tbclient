package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements Comparable<t> {
    public String eAe;
    public String eAf;
    public boolean eAg;
    public String eAh;
    public String eAi;
    public String eAj;
    public String eAk;
    public boolean eAl;
    public int eAm;
    public int eAn;
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
        tVar.mIcon = dVar.ciC;
        tVar.eAj = dVar.eAj;
        tVar.mPrice = dVar.fay;
        tVar.eAe = dVar.eAe;
        tVar.eAl = dVar.eAl;
        tVar.mDescription = dVar.mDescription;
        tVar.eAg = dVar.eAm == 1;
        tVar.eAm = dVar.eAm;
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
        tVar.mContent = TextUtils.isEmpty(aVar.cIa()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cIa() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        tVar.mTitle = aVar.cHY();
        tVar.eAk = aVar.cIb();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.eAj = aVar.cIa();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cHZ() != null) {
            tVar.eAh = aVar.cHZ().cIc();
            tVar.eAi = aVar.cHZ().cId();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.eAn - tVar.eAn;
    }
}
