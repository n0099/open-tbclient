package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u implements Comparable<u> {
    public String eKA;
    public boolean eKB;
    public String eKC;
    public String eKD;
    public String eKE;
    public String eKF;
    public boolean eKG;
    public int eKH;
    public int eKI;
    public String eKz;
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
        uVar.mIcon = dVar.cpN;
        uVar.eKE = dVar.eKE;
        uVar.mPrice = dVar.fmd;
        uVar.eKz = dVar.eKz;
        uVar.eKG = dVar.eKG;
        uVar.mDescription = dVar.mDescription;
        uVar.eKB = dVar.eKH == 1;
        uVar.eKH = dVar.eKH;
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
        uVar.mContent = TextUtils.isEmpty(aVar.cMq()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cMq() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        uVar.mTitle = aVar.cMo();
        uVar.eKF = aVar.cMr();
        if (!com.baidu.tbadk.core.util.x.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            uVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        uVar.eKE = aVar.cMq();
        uVar.mPrice = aVar.getPrice();
        if (aVar.cMp() != null) {
            uVar.eKC = aVar.cMp().cMs();
            uVar.eKD = aVar.cMp().cMt();
        }
        tbLinkSpanGroup.b(uVar);
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull u uVar) {
        return this.eKI - uVar.eKI;
    }
}
