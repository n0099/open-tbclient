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
    private static final String fon = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String amC;
    private v fom;
    private LINK_TYPE foo;
    private int fop;
    private CharSequence foq;

    /* renamed from: for  reason: not valid java name */
    private CharSequence f3for;
    private String fot;
    private String fou;
    private int fov;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.fop = 0;
        this.foo = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.c(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.fop = 0;
        this.foo = link_type;
    }

    public void build() {
        setValid(true);
        if (this.foo == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bvo();
        } else {
            bvn();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.foo == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.f3for = " ";
            return;
        }
        this.foq = editable.subSequence(i, i2 - 1);
        this.f3for = editable.subSequence(i2 - 1, i2);
    }

    public void bvn() {
        if (this.fop != 1) {
            this.fop = 1;
            this.fou = fon;
            String str = "[p]" + fon + ((Object) this.f3for);
            this.fov = str.length();
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
        if (this.fom == null) {
            String str2 = au.isEmpty(this.amC) ? "0" : this.amC;
            if (this.foo == LINK_TYPE.INTERNAL_LINK && au.isEmpty(this.fot)) {
                str = "";
            } else {
                str = this.fou;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(",").append(k.getUrlEncode(this.foq.toString())).append(",").append(k.getUrlEncode(str)).append(")").append(this.f3for);
            n(sb);
        } else if (this.foo == LINK_TYPE.INTERNAL_LINK || this.foo == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.fou;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.foq.toString())).append(",").append(k.getUrlEncode(str3)).append(",").append(k.getUrlEncode(this.fom.eMQ)).append(",").append(this.fom.mIcon).append(",").append(k.getUrlEncode(this.fom.mPrice)).append(",").append(i).append(",").append(this.fom.eMT).append(")").append(this.f3for);
            n(sb2);
        } else if (this.foo == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.fom.eMR);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.fom.mContent);
                jSONObject2.put("url", this.fom.eMP);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.f3for);
                n(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        if (this.fom != null && this.fom.mType == 2) {
            if (this.fom.eMM != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.fom.eMM).append("_commo)");
                n(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.foq).append(this.f3for);
        n(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.foo = tbLinkSpanGroup.foo;
        this.fop = tbLinkSpanGroup.fop;
        this.foq = tbLinkSpanGroup.foq;
        this.f3for = tbLinkSpanGroup.f3for;
        this.amC = tbLinkSpanGroup.amC;
        this.fot = tbLinkSpanGroup.fot;
        this.fou = tbLinkSpanGroup.fou;
        this.fom = tbLinkSpanGroup.fom;
    }

    public void bvo() {
        if (this.fop != 2 && !au.isEmpty(this.fot)) {
            this.fop = 2;
            this.fou = au.aq(this.fot, 40);
            String str = "[p]" + this.fou + ((Object) this.f3for);
            this.fov = str.length();
            n(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            setSpan(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            setSpan(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public v bvp() {
        return this.fom;
    }

    public LINK_TYPE bvq() {
        return this.foo;
    }

    public void setTid(String str) {
        this.amC = str;
    }

    public String getTid() {
        return this.amC;
    }

    public void BJ(String str) {
        this.fot = str;
    }

    public void setUrl(String str) {
        this.foq = str;
    }

    public void b(v vVar) {
        this.fom = vVar;
    }

    public void a(LINK_TYPE link_type) {
        this.foo = link_type;
    }

    public int bvr() {
        return this.fov;
    }
}
