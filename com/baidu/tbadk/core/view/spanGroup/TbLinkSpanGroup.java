package com.baidu.tbadk.core.view.spanGroup;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    private static final String ehw = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
    private String ajO;
    private String ehA;
    private String ehB;
    private LINK_TYPE ehx;
    private CharSequence ehy;
    private CharSequence ehz;
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
        this.ehx = link_type;
    }

    private TbLinkSpanGroup() {
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable, int i, int i2, int i3) {
        super.a(editable, i, i2, i3);
        this.ehy = editable.subSequence(i, i2 - 1);
        this.ehz = editable.subSequence(i2 - 1, i2);
    }

    public void build() {
        setValid(true);
        aZf();
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(Editable editable) {
        String str;
        String str2 = ar.isEmpty(this.ajO) ? "0" : this.ajO;
        if (this.ehx == LINK_TYPE.INTERNAL_LINK && ar.isEmpty(this.ehA)) {
            str = "";
        } else {
            str = this.ehB;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#(url,").append(str2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(this.ehy.toString())).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(k.getUrlEncode(str)).append(")").append(this.ehz);
        m(sb);
    }

    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void b(Editable editable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ehy).append(this.ehz);
        m(sb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.spanGroup.a
    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        super.a(tbLinkSpanGroup);
        this.ehx = tbLinkSpanGroup.ehx;
        this.mShowType = tbLinkSpanGroup.mShowType;
        this.ehy = tbLinkSpanGroup.ehy;
        this.ehz = tbLinkSpanGroup.ehz;
        this.ajO = tbLinkSpanGroup.ajO;
        this.ehA = tbLinkSpanGroup.ehA;
        this.ehB = tbLinkSpanGroup.ehB;
    }

    public void aZf() {
        if (this.mShowType != 1) {
            this.mShowType = 1;
            this.ehB = ehw;
            m("[p]" + ehw + ((Object) this.ehz));
            Drawable drawable = an.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(an.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public void aZg() {
        if (this.mShowType != 2 && !ar.isEmpty(this.ehA)) {
            this.mShowType = 2;
            this.ehB = ar.ah(this.ehA, 40);
            m("[p]" + this.ehB + ((Object) this.ehz));
            Drawable drawable = an.getDrawable(R.drawable.pic_post_link16);
            drawable.setBounds(0, 0, getFontSize(), getFontSize());
            com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(drawable);
            bVar.setPaddingRight(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            b(bVar, getStart(), getStart() + "[p]".length(), 33);
            b(new TbLinkForegroundColorSpan(an.getColor(R.color.cp_link_tip_a)), getStart() + "[p]".length(), getEnd(), 33);
        }
    }

    public LINK_TYPE aZh() {
        return this.ehx;
    }

    public void setTid(String str) {
        this.ajO = str;
    }

    public String getTid() {
        return this.ajO;
    }

    public void xp(String str) {
        this.ehA = str;
    }
}
