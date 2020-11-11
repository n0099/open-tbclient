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
    private static final String far = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String alT;
    private t faq;
    private LINK_TYPE fas;
    private CharSequence fat;
    private CharSequence fau;
    private String fav;
    private String faw;
    private int fax;
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
        this.fas = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.fas = link_type;
    }

    public void build() {
        setValid(true);
        if (this.fas == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            btE();
        } else {
            btD();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.fas == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.fau = " ";
            return;
        }
        this.fat = editable.subSequence(i, i2 - 1);
        this.fau = editable.subSequence(i2 - 1, i2);
    }

    public void btD() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.faw = far;
            String str = "[p]" + far + ((Object) this.fau);
            this.fax = str.length();
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
        if (this.faq == null) {
            String str2 = at.isEmpty(this.alT) ? "0" : this.alT;
            if (this.fas == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.fav)) {
                str = "";
            } else {
                str = this.faw;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.fat.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.fau);
            n(sb);
        } else if (this.fas == LINK_TYPE.INTERNAL_LINK || this.fas == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.faw;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.fat.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.faq.eAj)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.faq.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.faq.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.faq.eAm).append(")").append(this.fau);
            n(sb2);
        } else if (this.fas == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.faq.eAk);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.faq.mContent);
                jSONObject2.put("url", this.faq.eAi);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.fau);
                n(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.faq != null && this.faq.mType == 2) {
            if (this.faq.eAf != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.faq.eAf).append("_commo)");
                n(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.fat).append(this.fau);
        n(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.fas = tbLinkSpanGroup.fas;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.fat = tbLinkSpanGroup.fat;
        this.fau = tbLinkSpanGroup.fau;
        this.alT = tbLinkSpanGroup.alT;
        this.fav = tbLinkSpanGroup.fav;
        this.faw = tbLinkSpanGroup.faw;
        this.faq = tbLinkSpanGroup.faq;
    }

    public void btE() {
        if (this.mShowType != 2 && !at.isEmpty(this.fav)) {
            this.mShowType = 2;
            this.faw = at.am(this.fav, 40);
            String str = "[p]" + this.faw + ((Object) this.fau);
            this.fax = str.length();
            n(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public t btF() {
        return this.faq;
    }

    public LINK_TYPE btG() {
        return this.fas;
    }

    public void setTid(String str) {
        this.alT = str;
    }

    public String getTid() {
        return this.alT;
    }

    public void Cz(String str) {
        this.fav = str;
    }

    public void b(t tVar) {
        this.faq = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.fas = link_type;
    }

    public int btH() {
        return this.fax;
    }
}
