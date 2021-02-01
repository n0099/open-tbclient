package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class v implements Comparable<v> {
    public String eML;
    public String eMM;
    public boolean eMN;
    public String eMO;
    public String eMP;
    public String eMQ;
    public String eMR;
    public boolean eMS;
    public int eMT;
    public int eMU;
    public String mContent;
    public String mDescription;
    public String mIcon;
    public int mId;
    public String mPrice;
    public String mTitle;
    public int mType;

    public v(int i, int i2) {
        this.mId = i;
        this.mType = i2;
    }

    public static v a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tbadk.core.view.spanGroup.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.getId(), 1);
        if (dVar == null) {
            return vVar;
        }
        vVar.mTitle = dVar.mTitle;
        vVar.mIcon = dVar.dcS;
        vVar.eMQ = dVar.eMQ;
        vVar.mPrice = dVar.fow;
        vVar.eML = dVar.eML;
        vVar.eMS = dVar.eMS;
        vVar.mDescription = dVar.mDescription;
        vVar.eMN = dVar.eMT == 1;
        vVar.eMT = dVar.eMT;
        tbLinkSpanGroup.b(vVar);
        return vVar;
    }

    public static v a(TbLinkSpanGroup tbLinkSpanGroup, com.baidu.tieba.j.a aVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.getId(), 2);
        if (aVar == null) {
            return vVar;
        }
        vVar.mContent = TextUtils.isEmpty(aVar.cOn()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cOn() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        vVar.mTitle = aVar.cOl();
        vVar.eMR = aVar.cOo();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            vVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        vVar.eMQ = aVar.cOn();
        vVar.mPrice = aVar.getPrice();
        if (aVar.cOm() != null) {
            vVar.eMO = aVar.cOm().cOp();
            vVar.eMP = aVar.cOm().cOq();
        }
        tbLinkSpanGroup.b(vVar);
        return vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull v vVar) {
        return this.eMU - vVar.eMU;
    }
}
