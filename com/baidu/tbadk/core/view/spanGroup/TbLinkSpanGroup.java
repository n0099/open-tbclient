package com.baidu.tbadk.core.view.spanGroup;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String enH = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String ajJ;
    private LINK_TYPE enI;
    private CharSequence enJ;
    private CharSequence enK;
    private String enL;
    private String enM;
    private int mShowType = 0;

    /* loaded from: classes.dex */
    public enum LINK_TYPE {
        EXTERNAL_LINK,
        INTERNAL_LINK
    }

    public static TbLinkSpanGroup a(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.a(tbLinkSpanGroup);
        tbLinkSpanGroup2.c(editable);
        return tbLinkSpanGroup2;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.enI = link_type;
    }

    private TbLinkSpanGroup() {
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        this.enJ = editable.subSequence(i, i2 - 1);
        this.enK = editable.subSequence(i2 - 1, i2);
    }

    public void build() {
        setValid(true);
        bdc();
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        String str;
        String str2 = as.isEmpty(this.ajJ) ? "0" : this.ajJ;
        if (this.enI == LINK_TYPE.INTERNAL_LINK && as.isEmpty(this.enL)) {
            str = "";
        } else {
            str = this.enM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.enJ.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.enK);
        m(sb);
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.enJ).append(this.enK);
        m(sb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.enI = tbLinkSpanGroup.enI;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.enJ = tbLinkSpanGroup.enJ;
        this.enK = tbLinkSpanGroup.enK;
        this.ajJ = tbLinkSpanGroup.ajJ;
        this.enL = tbLinkSpanGroup.enL;
        this.enM = tbLinkSpanGroup.enM;
    }

    public void bdc() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.enM = enH;
            m("[p]" + enH + ((Object) this.enK));
            Drawable drawable = ao.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public void bdd() {
        if (this.mShowType != 2 && !as.isEmpty(this.enL)) {
            this.mShowType = 2;
            this.enM = as.ai(this.enL, 40);
            m("[p]" + this.enM + ((Object) this.enK));
            Drawable drawable = ao.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public LINK_TYPE bde() {
        return this.enI;
    }

    public void setTid(String str) {
        this.ajJ = str;
    }

    public String getTid() {
        return this.ajJ;
    }

    public void yu(String str) {
        this.enL = str;
    }
}
