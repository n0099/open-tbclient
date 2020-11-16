package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u implements Comparable<u> {
    public String eyA;
    public String eyB;
    public boolean eyC;
    public int eyD;
    public int eyE;
    public String eyv;
    public String eyw;
    public boolean eyx;
    public String eyy;
    public String eyz;
    public String mContent;
    public String mDescription;
    public String mIcon;
    public int mId;
    public String mPrice;
    public String mTitle;
    public int mType;

    public u(int i, int i2) {
        this.mId = i;
        this.mType = i2;
    }

    public static u a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tbadk.core.view.spanGroup.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        u uVar = new u(tbLinkSpanGroup.getId(), 1);
        if (dVar == null) {
            return uVar;
        }
        uVar.mTitle = dVar.mTitle;
        uVar.mIcon = dVar.cgQ;
        uVar.eyA = dVar.eyA;
        uVar.mPrice = dVar.eZG;
        uVar.eyv = dVar.eyv;
        uVar.eyC = dVar.eyC;
        uVar.mDescription = dVar.mDescription;
        uVar.eyx = dVar.eyD == 1;
        uVar.eyD = dVar.eyD;
        tbLinkSpanGroup.b(uVar);
        return uVar;
    }

    public static u a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tieba.j.a aVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        u uVar = new u(tbLinkSpanGroup.getId(), 2);
        if (aVar == null) {
            return uVar;
        }
        uVar.mContent = TextUtils.isEmpty(aVar.cHF()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cHF() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        uVar.mTitle = aVar.cHD();
        uVar.eyB = aVar.cHG();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            uVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        uVar.eyA = aVar.cHF();
        uVar.mPrice = aVar.getPrice();
        if (aVar.cHE() != null) {
            uVar.eyy = aVar.cHE().cHH();
            uVar.eyz = aVar.cHE().cHI();
        }
        tbLinkSpanGroup.b(uVar);
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull u uVar) {
        return this.eyE - uVar.eyE;
    }
}
