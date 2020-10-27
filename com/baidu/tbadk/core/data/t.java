package com.baidu.tbadk.core.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t implements Comparable<t> {
    public String eul;
    public String eum;
    public boolean eun;
    public String euo;
    public String eup;
    public String euq;
    public String eur;
    public boolean eus;
    public int eut;
    public int euu;
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
        tVar.mIcon = dVar.ccQ;
        tVar.euq = dVar.euq;
        tVar.mPrice = dVar.eUJ;
        tVar.eul = dVar.eul;
        tVar.eus = dVar.eus;
        tVar.mDescription = dVar.mDescription;
        tVar.eun = dVar.eut == 1;
        tVar.eut = dVar.eut;
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
        tVar.mContent = TextUtils.isEmpty(aVar.cFz()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cFz() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        tVar.mTitle = aVar.cFx();
        tVar.eur = aVar.cFA();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            tVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        tVar.euq = aVar.cFz();
        tVar.mPrice = aVar.getPrice();
        if (aVar.cFy() != null) {
            tVar.euo = aVar.cFy().cFB();
            tVar.eup = aVar.cFy().cFC();
        }
        tbLinkSpanGroup.b(tVar);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull t tVar) {
        return this.euu - tVar.euu;
    }
}
