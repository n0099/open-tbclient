package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.k;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String fgW = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String amY;
    private u fgV;
    private LINK_TYPE fgX;
    private CharSequence fgY;
    private CharSequence fgZ;
    private String fha;
    private String fhb;
    private int fhc;
    private int mShowType;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.mShowType = 0;
        this.fgX = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.fgX = link_type;
    }

    public void build() {
        setValid(true);
        if (this.fgX == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bwu();
        } else {
            bwt();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.fgX == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.fgZ = " ";
            return;
        }
        this.fgY = editable.subSequence(i, i2 - 1);
        this.fgZ = editable.subSequence(i2 - 1, i2);
    }

    public void bwt() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.fhb = fgW;
            String str = "[p]" + fgW + ((Object) this.fgZ);
            this.fhc = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            b(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i) {
        String str;
        if (this.fgV == null) {
            String str2 = au.isEmpty(this.amY) ? "0" : this.amY;
            if (this.fgX == LINK_TYPE.INTERNAL_LINK && au.isEmpty(this.fha)) {
                str = "";
            } else {
                str = this.fhb;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(",").append(k.getUrlEncode(this.fgY.toString())).append(",").append(k.getUrlEncode(str)).append(")").append(this.fgZ);
            o(sb);
        } else if (this.fgX == LINK_TYPE.INTERNAL_LINK || this.fgX == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.fhb;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.fgY.toString())).append(",").append(k.getUrlEncode(str3)).append(",").append(k.getUrlEncode(this.fgV.eFz)).append(",").append(this.fgV.mIcon).append(",").append(k.getUrlEncode(this.fgV.mPrice)).append(",").append(i).append(",").append(this.fgV.eFC).append(")").append(this.fgZ);
            o(sb2);
        } else if (this.fgX == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.fgV.eFA);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.fgV.mContent);
                jSONObject2.put("url", this.fgV.eFy);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.fgZ);
                o(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.fgV != null && this.fgV.mType == 2) {
            if (this.fgV.eFv != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.fgV.eFv).append("_commo)");
                o(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.fgY).append(this.fgZ);
        o(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.fgX = tbLinkSpanGroup.fgX;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.fgY = tbLinkSpanGroup.fgY;
        this.fgZ = tbLinkSpanGroup.fgZ;
        this.amY = tbLinkSpanGroup.amY;
        this.fha = tbLinkSpanGroup.fha;
        this.fhb = tbLinkSpanGroup.fhb;
        this.fgV = tbLinkSpanGroup.fgV;
    }

    public void bwu() {
        if (this.mShowType != 2 && !au.isEmpty(this.fha)) {
            this.mShowType = 2;
            this.fhb = au.am(this.fha, 40);
            String str = "[p]" + this.fhb + ((Object) this.fgZ);
            this.fhc = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            b(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public u bwv() {
        return this.fgV;
    }

    public LINK_TYPE bww() {
        return this.fgX;
    }

    public void setTid(String str) {
        this.amY = str;
    }

    public String getTid() {
        return this.amY;
    }

    public void CG(String str) {
        this.fha = str;
    }

    public void setUrl(String str) {
        this.fgY = str;
    }

    public void b(u uVar) {
        this.fgV = uVar;
    }

    public void a(LINK_TYPE link_type) {
        this.fgX = link_type;
    }

    public int bwx() {
        return this.fhc;
    }
}
