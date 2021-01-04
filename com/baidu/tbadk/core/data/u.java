package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u implements Comparable<u> {
    public String ePk;
    public String ePl;
    public boolean ePm;
    public String ePn;
    public String ePo;
    public String ePp;
    public String ePq;
    public boolean ePr;
    public int ePs;
    public int ePt;
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
        uVar.mIcon = dVar.cuF;
        uVar.ePp = dVar.ePp;
        uVar.mPrice = dVar.fqN;
        uVar.ePk = dVar.ePk;
        uVar.ePr = dVar.ePr;
        uVar.mDescription = dVar.mDescription;
        uVar.ePm = dVar.ePs == 1;
        uVar.ePs = dVar.ePs;
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
        uVar.mContent = TextUtils.isEmpty(aVar.cQh()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cQh() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        uVar.mTitle = aVar.cQf();
        uVar.ePq = aVar.cQi();
        if (!com.baidu.tbadk.core.util.x.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            uVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        uVar.ePp = aVar.cQh();
        uVar.mPrice = aVar.getPrice();
        if (aVar.cQg() != null) {
            uVar.ePn = aVar.cQg().cQj();
            uVar.ePo = aVar.cQg().cQk();
        }
        tbLinkSpanGroup.b(uVar);
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull u uVar) {
        return this.ePt - uVar.ePt;
    }
}
