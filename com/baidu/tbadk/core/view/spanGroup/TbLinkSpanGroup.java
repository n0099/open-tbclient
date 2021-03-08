package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.k;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String fpO = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String anU;
    private v fpN;
    private LINK_TYPE fpP;
    private int fpQ;
    private CharSequence fpR;
    private CharSequence fpS;
    private String fpT;
    private String fpU;
    private int fpV;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.fpQ = 0;
        this.fpP = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.c(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.fpQ = 0;
        this.fpP = link_type;
    }

    public void build() {
        setValid(true);
        if (this.fpP == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bvr();
        } else {
            bvq();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.fpP == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.fpS = " ";
            return;
        }
        this.fpR = editable.subSequence(i, i2 - 1);
        this.fpS = editable.subSequence(i2 - 1, i2);
    }

    public void bvq() {
        if (this.fpQ != 1) {
            this.fpQ = 1;
            this.fpU = fpO;
            String str = "[p]" + fpO + ((Object) this.fpS);
            this.fpV = str.length();
            n(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i) {
        String str;
        if (this.fpN == null) {
            String str2 = au.isEmpty(this.anU) ? "0" : this.anU;
            if (this.fpP == LINK_TYPE.INTERNAL_LINK && au.isEmpty(this.fpT)) {
                str = "";
            } else {
                str = this.fpU;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(",").append(k.getUrlEncode(this.fpR.toString())).append(",").append(k.getUrlEncode(str)).append(")").append(this.fpS);
            n(sb);
        } else if (this.fpP == LINK_TYPE.INTERNAL_LINK || this.fpP == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.fpU;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.fpR.toString())).append(",").append(k.getUrlEncode(str3)).append(",").append(k.getUrlEncode(this.fpN.eOr)).append(",").append(this.fpN.mIcon).append(",").append(k.getUrlEncode(this.fpN.mPrice)).append(",").append(i).append(",").append(this.fpN.eOu).append(")").append(this.fpS);
            n(sb2);
        } else if (this.fpP == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.fpN.eOs);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.fpN.mContent);
                jSONObject2.put("url", this.fpN.eOq);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.fpS);
                n(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        if (this.fpN != null && this.fpN.mType == 2) {
            if (this.fpN.eOn != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.fpN.eOn).append("_commo)");
                n(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.fpR).append(this.fpS);
        n(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.fpP = tbLinkSpanGroup.fpP;
        this.fpQ = tbLinkSpanGroup.fpQ;
        this.fpR = tbLinkSpanGroup.fpR;
        this.fpS = tbLinkSpanGroup.fpS;
        this.anU = tbLinkSpanGroup.anU;
        this.fpT = tbLinkSpanGroup.fpT;
        this.fpU = tbLinkSpanGroup.fpU;
        this.fpN = tbLinkSpanGroup.fpN;
    }

    public void bvr() {
        if (this.fpQ != 2 && !au.isEmpty(this.fpT)) {
            this.fpQ = 2;
            this.fpU = au.ar(this.fpT, 40);
            String str = "[p]" + this.fpU + ((Object) this.fpS);
            this.fpV = str.length();
            n(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public v bvs() {
        return this.fpN;
    }

    public LINK_TYPE bvt() {
        return this.fpP;
    }

    public void setTid(String str) {
        this.anU = str;
    }

    public String getTid() {
        return this.anU;
    }

    public void BQ(String str) {
        this.fpT = str;
    }

    public void setUrl(String str) {
        this.fpR = str;
    }

    public void b(v vVar) {
        this.fpN = vVar;
    }

    public void a(LINK_TYPE link_type) {
        this.fpP = link_type;
    }

    public int bvu() {
        return this.fpV;
    }
}
