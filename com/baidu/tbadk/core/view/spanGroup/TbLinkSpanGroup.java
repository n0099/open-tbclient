package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.k;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String flV = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String amM;
    private u flU;
    private LINK_TYPE flW;
    private int flX;
    private CharSequence flY;
    private CharSequence flZ;
    private String fma;
    private String fmb;
    private int fmc;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.flX = 0;
        this.flW = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.c(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.flX = 0;
        this.flW = link_type;
    }

    public void build() {
        setValid(true);
        if (this.flW == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            buU();
        } else {
            buT();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.flW == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.flZ = " ";
            return;
        }
        this.flY = editable.subSequence(i, i2 - 1);
        this.flZ = editable.subSequence(i2 - 1, i2);
    }

    public void buT() {
        if (this.flX != 1) {
            this.flX = 1;
            this.fmb = flV;
            String str = "[p]" + flV + ((Object) this.flZ);
            this.fmc = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i) {
        String str;
        if (this.flU == null) {
            String str2 = at.isEmpty(this.amM) ? "0" : this.amM;
            if (this.flW == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.fma)) {
                str = "";
            } else {
                str = this.fmb;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(",").append(k.getUrlEncode(this.flY.toString())).append(",").append(k.getUrlEncode(str)).append(")").append(this.flZ);
            o(sb);
        } else if (this.flW == LINK_TYPE.INTERNAL_LINK || this.flW == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.fmb;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.flY.toString())).append(",").append(k.getUrlEncode(str3)).append(",").append(k.getUrlEncode(this.flU.eKE)).append(",").append(this.flU.mIcon).append(",").append(k.getUrlEncode(this.flU.mPrice)).append(",").append(i).append(",").append(this.flU.eKH).append(")").append(this.flZ);
            o(sb2);
        } else if (this.flW == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.flU.eKF);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.flU.mContent);
                jSONObject2.put("url", this.flU.eKD);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.flZ);
                o(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        if (this.flU != null && this.flU.mType == 2) {
            if (this.flU.eKA != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.flU.eKA).append("_commo)");
                o(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.flY).append(this.flZ);
        o(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.flW = tbLinkSpanGroup.flW;
        this.flX = tbLinkSpanGroup.flX;
        this.flY = tbLinkSpanGroup.flY;
        this.flZ = tbLinkSpanGroup.flZ;
        this.amM = tbLinkSpanGroup.amM;
        this.fma = tbLinkSpanGroup.fma;
        this.fmb = tbLinkSpanGroup.fmb;
        this.flU = tbLinkSpanGroup.flU;
    }

    public void buU() {
        if (this.flX != 2 && !at.isEmpty(this.fma)) {
            this.flX = 2;
            this.fmb = at.ao(this.fma, 40);
            String str = "[p]" + this.fmb + ((Object) this.flZ);
            this.fmc = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public u buV() {
        return this.flU;
    }

    public LINK_TYPE buW() {
        return this.flW;
    }

    public void setTid(String str) {
        this.amM = str;
    }

    public String getTid() {
        return this.amM;
    }

    public void Bs(String str) {
        this.fma = str;
    }

    public void setUrl(String str) {
        this.flY = str;
    }

    public void b(u uVar) {
        this.flU = uVar;
    }

    public void a(LINK_TYPE link_type) {
        this.flW = link_type;
    }

    public int buX() {
        return this.fmc;
    }
}
