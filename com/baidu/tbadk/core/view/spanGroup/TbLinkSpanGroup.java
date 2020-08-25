package com.baidu.tbadk.core.view.spanGroup;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String exP = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String akY;
    private t exO;
    private LINK_TYPE exQ;
    private CharSequence exR;
    private CharSequence exS;
    private String exT;
    private String exU;
    private int exV;
    private int mShowType;

    /* loaded from: classes2.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    private TbLinkSpanGroup() {
        this.mShowType = 0;
        this.exQ = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.exQ = link_type;
    }

    public void build() {
        setValid(true);
        if (this.exQ == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            blH();
        } else {
            blG();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.exQ == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.exS = " ";
            return;
        }
        this.exR = editable.subSequence(i, i2 - 1);
        this.exS = editable.subSequence(i2 - 1, i2);
    }

    public void blG() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.exU = exP;
            String str = "[p]" + exP + ((Object) this.exS);
            this.exV = str.length();
            m(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i) {
        String str;
        if (this.exO == null) {
            String str2 = at.isEmpty(this.akY) ? "0" : this.akY;
            if (this.exQ == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.exT)) {
                str = "";
            } else {
                str = this.exU;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exR.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.exS);
            m(sb);
        } else if (this.exQ == LINK_TYPE.INTERNAL_LINK || this.exQ == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.exU;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.exR.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exO.dXA)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.exO.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exO.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.exO.dXD).append(")").append(this.exS);
            m(sb2);
        } else if (this.exQ == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.exO.dXB);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.exO.mContent);
                jSONObject2.put("url", this.exO.dXz);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.exS);
                m(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.exO != null && this.exO.mType == 2) {
            if (this.exO.dXw != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.exO.dXw).append("_commo)");
                m(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.exR).append(this.exS);
        m(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.exQ = tbLinkSpanGroup.exQ;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.exR = tbLinkSpanGroup.exR;
        this.exS = tbLinkSpanGroup.exS;
        this.akY = tbLinkSpanGroup.akY;
        this.exT = tbLinkSpanGroup.exT;
        this.exU = tbLinkSpanGroup.exU;
        this.exO = tbLinkSpanGroup.exO;
    }

    public void blH() {
        if (this.mShowType != 2 && !at.isEmpty(this.exT)) {
            this.mShowType = 2;
            this.exU = at.aj(this.exT, 40);
            String str = "[p]" + this.exU + ((Object) this.exS);
            this.exV = str.length();
            m(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public t blI() {
        return this.exO;
    }

    public LINK_TYPE blJ() {
        return this.exQ;
    }

    public void setTid(String str) {
        this.akY = str;
    }

    public String getTid() {
        return this.akY;
    }

    public void AJ(String str) {
        this.exT = str;
    }

    public void b(t tVar) {
        this.exO = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.exQ = link_type;
    }

    public int blK() {
        return this.exV;
    }
}
