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
    private static final String exT = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String ala;
    private t exS;
    private LINK_TYPE exU;
    private CharSequence exV;
    private CharSequence exW;
    private String exX;
    private String exY;
    private int exZ;
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
        this.exU = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.b(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.mShowType = 0;
        this.exU = link_type;
    }

    public void build() {
        setValid(true);
        if (this.exU == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            blH();
        } else {
            blG();
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        if (this.exU == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.exW = " ";
            return;
        }
        this.exV = editable.subSequence(i, i2 - 1);
        this.exW = editable.subSequence(i2 - 1, i2);
    }

    public void blG() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.exY = exT;
            String str = "[p]" + exT + ((Object) this.exW);
            this.exZ = str.length();
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
        if (this.exS == null) {
            String str2 = at.isEmpty(this.ala) ? "0" : this.ala;
            if (this.exU == LINK_TYPE.INTERNAL_LINK && at.isEmpty(this.exX)) {
                str = "";
            } else {
                str = this.exY;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exV.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.exW);
            m(sb);
        } else if (this.exU == LINK_TYPE.INTERNAL_LINK || this.exU == LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            String str3 = this.exY;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#(url,0,").append(k.getUrlEncode(this.exV.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exS.dXE)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.exS.mIcon).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.exS.mPrice)).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(this.exS.dXH).append(")").append(this.exW);
            m(sb2);
        } else if (this.exU == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("goods_id", this.exS.dXF);
                jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                jSONObject2.put("title", this.exS.mContent);
                jSONObject2.put("url", this.exS.dXD);
                StringBuilder sb3 = new StringBuilder();
                jSONObject.put("goods", jSONObject2);
                sb3.append("#(goods,").append(k.getUrlEncode(jSONObject.toString())).append(")").append(this.exW);
                m(sb3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        if (this.exS != null && this.exS.mType == 2) {
            if (this.exS.dXA != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_").append(this.exS.dXA).append("_commo)");
                m(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.exV).append(this.exW);
        m(sb2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    /* renamed from: b */
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.exU = tbLinkSpanGroup.exU;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.exV = tbLinkSpanGroup.exV;
        this.exW = tbLinkSpanGroup.exW;
        this.ala = tbLinkSpanGroup.ala;
        this.exX = tbLinkSpanGroup.exX;
        this.exY = tbLinkSpanGroup.exY;
        this.exS = tbLinkSpanGroup.exS;
    }

    public void blH() {
        if (this.mShowType != 2 && !at.isEmpty(this.exX)) {
            this.mShowType = 2;
            this.exY = at.aj(this.exX, 40);
            String str = "[p]" + this.exY + ((Object) this.exW);
            this.exZ = str.length();
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
        return this.exS;
    }

    public LINK_TYPE blJ() {
        return this.exU;
    }

    public void setTid(String str) {
        this.ala = str;
    }

    public String getTid() {
        return this.ala;
    }

    public void AK(String str) {
        this.exX = str;
    }

    public void b(t tVar) {
        this.exS = tVar;
    }

    public void a(LINK_TYPE link_type) {
        this.exU = link_type;
    }

    public int blK() {
        return this.exZ;
    }
}
