package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements Comparable<t> {
    public String dZJ;
    public String dZK;
    public boolean dZL;
    public String dZM;
    public String dZN;
    public String dZO;
    public String dZP;
    public boolean dZQ;
    public int dZR;
    public int dZS;
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
        tVar.mIcon = dVar.bNJ;
        tVar.dZO = dVar.dZO;
        tVar.mPrice = dVar.eAg;
        tVar.dZJ = dVar.dZJ;
        tVar.dZQ = dVar.dZQ;
        tVar.mDescription = dVar.mDescription;
        tVar.dZL = dVar.dZR == 1;
        tVar.dZR = dVar.dZR;
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
        tVar.mContent = TextUtils.isEmpty(aVar.aek()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.aek() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        tVar.mTitle = aVar.cyT();
        tVar.dZP = aVar.cyV();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.dZO = aVar.aek();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cyU() != null) {
            tVar.dZM = aVar.cyU().cyW();
            tVar.dZN = aVar.cyU().cyX();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.dZS - tVar.dZS;
    }
}
