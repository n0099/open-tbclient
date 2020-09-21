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
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String ezZ = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String alA;
    private LINK_TYPE eAa;
    private CharSequence eAb;
    private CharSequence eAc;
    private String eAd;
    private String eAe;
    private int eAf;
    private t ezY;
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
        this.eAa = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.eAa = link_type;
    }

    public void build() {
        setValid(true);
        if (this.eAa == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bmB();
        } else {
            bmA();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.eAa == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.eAc = " ";
            return;
        }
        this.eAb = editable.subSequence(i, i2 - 1);
        this.eAc = editable.subSequence(i2 - 1, i2);
    }

    public void bmA() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.eAe = ezZ;
            String str = "[p]" + ezZ + ((Object) this.eAc);
            this.eAf = str.length();
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
        if (this.ezY == null) {
            String str2 = at.isEmpty(this.alA) ? "0" : this.alA;
            if (this.eAa == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.eAd)) {
                str = "";
            } else {
                str = this.eAe;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eAb.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.eAc);
            m(sb);
        } else if (this.eAa == LINK_TYPE.INTERNAL_LINK || this.eAa == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.eAe;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.eAb.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.ezY.dZO)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.ezY.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.ezY.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.ezY.dZR).append(")").append(this.eAc);
            m(sb2);
        } else if (this.eAa == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.ezY.dZP);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.ezY.mContent);
                jSONObject2.put("url", this.ezY.dZN);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.eAc);
                m(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.ezY != null && this.ezY.mType == 2) {
            if (this.ezY.dZK != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.ezY.dZK).append("_commo)");
                m(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.eAb).append(this.eAc);
        m(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.eAa = tbLinkSpanGroup.eAa;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.eAb = tbLinkSpanGroup.eAb;
        this.eAc = tbLinkSpanGroup.eAc;
        this.alA = tbLinkSpanGroup.alA;
        this.eAd = tbLinkSpanGroup.eAd;
        this.eAe = tbLinkSpanGroup.eAe;
        this.ezY = tbLinkSpanGroup.ezY;
    }

    public void bmB() {
        if (this.mShowType != 2 && !at.isEmpty(this.eAd)) {
            this.mShowType = 2;
            this.eAe = at.aj(this.eAd, 40);
            String str = "[p]" + this.eAe + ((Object) this.eAc);
            this.eAf = str.length();
            m(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public t bmC() {
        return this.ezY;
    }

    public LINK_TYPE bmD() {
        return this.eAa;
    }

    public void setTid(String str) {
        this.alA = str;
    }

    public String getTid() {
        return this.alA;
    }

    public void Bg(String str) {
        this.eAd = str;
    }

    public void b(t tVar) {
        this.ezY = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.eAa = link_type;
    }

    public int bmE() {
        return this.eAf;
    }
}
