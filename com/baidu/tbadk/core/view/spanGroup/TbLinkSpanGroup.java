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
    private static final String fqF = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String anD;
    private u fqE;
    private LINK_TYPE fqG;
    private int fqH;
    private CharSequence fqI;
    private CharSequence fqJ;
    private String fqK;
    private String fqL;
    private int fqM;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.fqH = 0;
        this.fqG = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.c(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.fqH = 0;
        this.fqG = link_type;
    }

    public void build() {
        setValid(true);
        if (this.fqG == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            byN();
        } else {
            byM();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.fqG == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.fqJ = " ";
            return;
        }
        this.fqI = editable.subSequence(i, i2 - 1);
        this.fqJ = editable.subSequence(i2 - 1, i2);
    }

    public void byM() {
        if (this.fqH != 1) {
            this.fqH = 1;
            this.fqL = fqF;
            String str = "[p]" + fqF + ((Object) this.fqJ);
            this.fqM = str.length();
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
        if (this.fqE == null) {
            String str2 = at.isEmpty(this.anD) ? "0" : this.anD;
            if (this.fqG == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.fqK)) {
                str = "";
            } else {
                str = this.fqL;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(",").append(k.getUrlEncode(this.fqI.toString())).append(",").append(k.getUrlEncode(str)).append(")").append(this.fqJ);
            o(sb);
        } else if (this.fqG == LINK_TYPE.INTERNAL_LINK || this.fqG == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.fqL;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.fqI.toString())).append(",").append(k.getUrlEncode(str3)).append(",").append(k.getUrlEncode(this.fqE.ePp)).append(",").append(this.fqE.mIcon).append(",").append(k.getUrlEncode(this.fqE.mPrice)).append(",").append(i).append(",").append(this.fqE.ePs).append(")").append(this.fqJ);
            o(sb2);
        } else if (this.fqG == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.fqE.ePq);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.fqE.mContent);
                jSONObject2.put("url", this.fqE.ePo);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.fqJ);
                o(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        if (this.fqE != null && this.fqE.mType == 2) {
            if (this.fqE.ePl != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.fqE.ePl).append("_commo)");
                o(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.fqI).append(this.fqJ);
        o(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.fqG = tbLinkSpanGroup.fqG;
        this.fqH = tbLinkSpanGroup.fqH;
        this.fqI = tbLinkSpanGroup.fqI;
        this.fqJ = tbLinkSpanGroup.fqJ;
        this.anD = tbLinkSpanGroup.anD;
        this.fqK = tbLinkSpanGroup.fqK;
        this.fqL = tbLinkSpanGroup.fqL;
        this.fqE = tbLinkSpanGroup.fqE;
    }

    public void byN() {
        if (this.fqH != 2 && !at.isEmpty(this.fqK)) {
            this.fqH = 2;
            this.fqL = at.ao(this.fqK, 40);
            String str = "[p]" + this.fqL + ((Object) this.fqJ);
            this.fqM = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public u byO() {
        return this.fqE;
    }

    public LINK_TYPE byP() {
        return this.fqG;
    }

    public void setTid(String str) {
        this.anD = str;
    }

    public String getTid() {
        return this.anD;
    }

    public void CE(String str) {
        this.fqK = str;
    }

    public void setUrl(String str) {
        this.fqI = str;
    }

    public void b(u uVar) {
        this.fqE = uVar;
    }

    public void a(LINK_TYPE link_type) {
        this.fqG = link_type;
    }

    public int byQ() {
        return this.fqM;
    }
}
