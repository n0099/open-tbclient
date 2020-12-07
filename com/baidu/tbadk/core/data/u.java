package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u implements Comparable<u> {
    public String eFA;
    public boolean eFB;
    public int eFC;
    public int eFD;
    public String eFu;
    public String eFv;
    public boolean eFw;
    public String eFx;
    public String eFy;
    public String eFz;
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
        uVar.mIcon = dVar.cny;
        uVar.eFz = dVar.eFz;
        uVar.mPrice = dVar.fhd;
        uVar.eFu = dVar.eFu;
        uVar.eFB = dVar.eFB;
        uVar.mDescription = dVar.mDescription;
        uVar.eFw = dVar.eFC == 1;
        uVar.eFC = dVar.eFC;
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
        uVar.mContent = TextUtils.isEmpty(aVar.cMT()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cMT() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        uVar.mTitle = aVar.cMR();
        uVar.eFA = aVar.cMU();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            uVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        uVar.eFz = aVar.cMT();
        uVar.mPrice = aVar.getPrice();
        if (aVar.cMS() != null) {
            uVar.eFx = aVar.cMS().cMV();
            uVar.eFy = aVar.cMS().cMW();
        }
        tbLinkSpanGroup.b(uVar);
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull u uVar) {
        return this.eFD - uVar.eFD;
    }
}
