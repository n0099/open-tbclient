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
    private static final String eUC = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String alT;
    private t eUB;
    private LINK_TYPE eUD;
    private CharSequence eUE;
    private CharSequence eUF;
    private String eUG;
    private String eUH;
    private int eUI;
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
        this.eUD = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.eUD = link_type;
    }

    public void build() {
        setValid(true);
        if (this.eUD == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bre();
        } else {
            brd();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.eUD == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.eUF = " ";
            return;
        }
        this.eUE = editable.subSequence(i, i2 - 1);
        this.eUF = editable.subSequence(i2 - 1, i2);
    }

    public void brd() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.eUH = eUC;
            String str = "[p]" + eUC + ((Object) this.eUF);
            this.eUI = str.length();
            n(str);
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
        if (this.eUB == null) {
            String str2 = at.isEmpty(this.alT) ? "0" : this.alT;
            if (this.eUD == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.eUG)) {
                str = "";
            } else {
                str = this.eUH;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eUE.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.eUF);
            n(sb);
        } else if (this.eUD == LINK_TYPE.INTERNAL_LINK || this.eUD == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.eUH;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.eUE.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eUB.euq)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eUB.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eUB.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eUB.eut).append(")").append(this.eUF);
            n(sb2);
        } else if (this.eUD == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.eUB.eur);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.eUB.mContent);
                jSONObject2.put("url", this.eUB.eup);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.eUF);
                n(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.eUB != null && this.eUB.mType == 2) {
            if (this.eUB.eum != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.eUB.eum).append("_commo)");
                n(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.eUE).append(this.eUF);
        n(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.eUD = tbLinkSpanGroup.eUD;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.eUE = tbLinkSpanGroup.eUE;
        this.eUF = tbLinkSpanGroup.eUF;
        this.alT = tbLinkSpanGroup.alT;
        this.eUG = tbLinkSpanGroup.eUG;
        this.eUH = tbLinkSpanGroup.eUH;
        this.eUB = tbLinkSpanGroup.eUB;
    }

    public void bre() {
        if (this.mShowType != 2 && !at.isEmpty(this.eUG)) {
            this.mShowType = 2;
            this.eUH = at.ak(this.eUG, 40);
            String str = "[p]" + this.eUH + ((Object) this.eUF);
            this.eUI = str.length();
            n(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public t brf() {
        return this.eUB;
    }

    public LINK_TYPE brg() {
        return this.eUD;
    }

    public void setTid(String str) {
        this.alT = str;
    }

    public String getTid() {
        return this.alT;
    }

    public void Cl(String str) {
        this.eUG = str;
    }

    public void b(t tVar) {
        this.eUB = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.eUD = link_type;
    }

    public int brh() {
        return this.eUI;
    }
}
