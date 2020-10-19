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
    private static final String eMg = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String alS;
    private t eMf;
    private LINK_TYPE eMh;
    private CharSequence eMi;
    private CharSequence eMj;
    private String eMk;
    private String eMl;
    private int eMm;
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
        this.eMh = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.eMh = link_type;
    }

    public void build() {
        setValid(true);
        if (this.eMh == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            bpl();
        } else {
            bpk();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.eMh == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.eMj = " ";
            return;
        }
        this.eMi = editable.subSequence(i, i2 - 1);
        this.eMj = editable.subSequence(i2 - 1, i2);
    }

    public void bpk() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.eMl = eMg;
            String str = "[p]" + eMg + ((Object) this.eMj);
            this.eMm = str.length();
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
        if (this.eMf == null) {
            String str2 = at.isEmpty(this.alS) ? "0" : this.alS;
            if (this.eMh == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.eMk)) {
                str = "";
            } else {
                str = this.eMl;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eMi.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.eMj);
            n(sb);
        } else if (this.eMh == LINK_TYPE.INTERNAL_LINK || this.eMh == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.eMl;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.eMi.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eMf.elQ)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eMf.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.eMf.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.eMf.elT).append(")").append(this.eMj);
            n(sb2);
        } else if (this.eMh == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.eMf.elR);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.eMf.mContent);
                jSONObject2.put("url", this.eMf.elP);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.eMj);
                n(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.eMf != null && this.eMf.mType == 2) {
            if (this.eMf.elM != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.eMf.elM).append("_commo)");
                n(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.eMi).append(this.eMj);
        n(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.eMh = tbLinkSpanGroup.eMh;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.eMi = tbLinkSpanGroup.eMi;
        this.eMj = tbLinkSpanGroup.eMj;
        this.alS = tbLinkSpanGroup.alS;
        this.eMk = tbLinkSpanGroup.eMk;
        this.eMl = tbLinkSpanGroup.eMl;
        this.eMf = tbLinkSpanGroup.eMf;
    }

    public void bpl() {
        if (this.mShowType != 2 && !at.isEmpty(this.eMk)) {
            this.mShowType = 2;
            this.eMl = at.ak(this.eMk, 40);
            String str = "[p]" + this.eMl + ((Object) this.eMj);
            this.eMm = str.length();
            n(str);
            Drawable drawable = ap.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public t bpm() {
        return this.eMf;
    }

    public LINK_TYPE bpn() {
        return this.eMh;
    }

    public void setTid(String str) {
        this.alS = str;
    }

    public String getTid() {
        return this.alS;
    }

    public void BS(String str) {
        this.eMk = str;
    }

    public void b(t tVar) {
        this.eMf = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.eMh = link_type;
    }

    public int bpo() {
        return this.eMm;
    }
}
