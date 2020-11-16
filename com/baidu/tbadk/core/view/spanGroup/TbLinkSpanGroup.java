package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.k;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.elementsMaven.view.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String eZz = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String alZ;
    private LINK_TYPE eZA;
    private CharSequence eZB;
    private CharSequence eZC;
    private String eZD;
    private String eZE;
    private int eZF;
    private u eZy;
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
        this.eZA = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.eZA = link_type;
    }

    public void build() {
        setValid(true);
        if (this.eZA == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bsU();
        } else {
            bsT();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.eZA == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.eZC = " ";
            return;
        }
        this.eZB = editable.subSequence(i, i2 - 1);
        this.eZC = editable.subSequence(i2 - 1, i2);
    }

    public void bsT() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.eZE = eZz;
            String str = "[p]" + eZz + ((Object) this.eZC);
            this.eZF = str.length();
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
        if (this.eZy == null) {
            String str2 = au.isEmpty(this.alZ) ? "0" : this.alZ;
            if (this.eZA == LINK_TYPE.INTERNAL_LINK && au.isEmpty(this.eZD)) {
                str = "";
            } else {
                str = this.eZE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eZB.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.eZC);
            o(sb);
        } else if (this.eZA == LINK_TYPE.INTERNAL_LINK || this.eZA == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.eZE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.eZB.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eZy.eyA)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eZy.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eZy.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eZy.eyD).append(")").append(this.eZC);
            o(sb2);
        } else if (this.eZA == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.eZy.eyB);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.eZy.mContent);
                jSONObject2.put("url", this.eZy.eyz);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.eZC);
                o(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.eZy != null && this.eZy.mType == 2) {
            if (this.eZy.eyw != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.eZy.eyw).append("_commo)");
                o(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.eZB).append(this.eZC);
        o(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.eZA = tbLinkSpanGroup.eZA;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.eZB = tbLinkSpanGroup.eZB;
        this.eZC = tbLinkSpanGroup.eZC;
        this.alZ = tbLinkSpanGroup.alZ;
        this.eZD = tbLinkSpanGroup.eZD;
        this.eZE = tbLinkSpanGroup.eZE;
        this.eZy = tbLinkSpanGroup.eZy;
    }

    public void bsU() {
        if (this.mShowType != 2 && !au.isEmpty(this.eZD)) {
            this.mShowType = 2;
            this.eZE = au.al(this.eZD, 40);
            String str = "[p]" + this.eZE + ((Object) this.eZC);
            this.eZF = str.length();
            o(str);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            b(eMRichTextAnyIconSpan, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public u bsV() {
        return this.eZy;
    }

    public LINK_TYPE bsW() {
        return this.eZA;
    }

    public void setTid(String str) {
        this.alZ = str;
    }

    public String getTid() {
        return this.alZ;
    }

    public void BY(String str) {
        this.eZD = str;
    }

    public void b(u uVar) {
        this.eZy = uVar;
    }

    public void a(LINK_TYPE link_type) {
        this.eZA = link_type;
    }

    public int bsX() {
        return this.eZF;
    }
}
