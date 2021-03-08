package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class v implements Comparable<v> {
    public String eOm;
    public String eOn;
    public boolean eOo;
    public String eOp;
    public String eOq;
    public String eOr;
    public String eOs;
    public boolean eOt;
    public int eOu;
    public int eOv;
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
        vVar.mIcon = dVar.dev;
        vVar.eOr = dVar.eOr;
        vVar.mPrice = dVar.fpW;
        vVar.eOm = dVar.eOm;
        vVar.eOt = dVar.eOt;
        vVar.mDescription = dVar.mDescription;
        vVar.eOo = dVar.eOu == 1;
        vVar.eOu = dVar.eOu;
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
        vVar.mContent = TextUtils.isEmpty(aVar.cOB()) ? TbadkCoreApplication.getInst().getString(R.string.web_page_link) : aVar.cOB() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        vVar.mTitle = aVar.cOz();
        vVar.eOs = aVar.cOC();
        if (!com.baidu.tbadk.core.util.y.isEmpty(aVar.getImageList()) && aVar.getImageList().get(0) != null) {
            vVar.mIcon = aVar.getImageList().get(0).getSrc();
        }
        vVar.eOr = aVar.cOB();
        vVar.mPrice = aVar.getPrice();
        if (aVar.cOA() != null) {
            vVar.eOp = aVar.cOA().cOD();
            vVar.eOq = aVar.cOA().cOE();
        }
        tbLinkSpanGroup.b(vVar);
        return vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull v vVar) {
        return this.eOv - vVar.eOv;
    }
}
