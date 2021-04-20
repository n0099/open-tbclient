package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.f0.b;
import d.b.i0.x.e0.c;
/* loaded from: classes3.dex */
public class SingleLinkCardView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f13141e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13142f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13143g;

    public SingleLinkCardView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            this.f13141e.W(pbLinkData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i = R.color.CAM_X0305;
                int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar = new b(g2, -1, i, g4, i, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(g3);
                bVar.h(g6);
                bVar.i(g7);
                spannableStringBuilder.setSpan(bVar, 0, pbLinkData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
            } else {
                spannableStringBuilder.append((CharSequence) pbLinkData.title);
            }
            this.f13142f.setText(spannableStringBuilder);
            if (pbLinkData.urlType == 2) {
                if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.f13143g.setVisibility(8);
                } else {
                    this.f13142f.setMaxLines(1);
                    this.f13143g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                    this.f13143g.setVisibility(0);
                }
            } else {
                this.f13143g.setVisibility(8);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                this.f13142f.setMaxLines(1);
            }
        } else if (cVar instanceof PbGoodsData) {
            PbGoodsData pbGoodsData = (PbGoodsData) cVar;
            this.f13141e.W(pbGoodsData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                int g8 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g9 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i2 = R.color.CAM_X0305;
                int g10 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g11 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g12 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g13 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar2 = new b(g8, -1, i2, g10, i2, g11, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar2.b(g9);
                bVar2.h(g12);
                bVar2.i(g13);
                spannableStringBuilder2.setSpan(bVar2, 0, pbGoodsData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
            } else {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
            }
            this.f13142f.setText(spannableStringBuilder2);
            if (TextUtils.isEmpty(pbGoodsData.price)) {
                this.f13143g.setVisibility(8);
            } else {
                this.f13142f.setMaxLines(1);
                this.f13143g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                this.f13143g.setVisibility(0);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                this.f13142f.setMaxLines(1);
            }
        }
    }

    public void b() {
        SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
        SkinManager.setViewTextColor(this.f13142f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f13143g, R.color.CAM_X0305);
    }

    public void setMarginTop(int i) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
        requestLayout();
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.f13141e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f13141e.setDrawCorner(true);
        this.f13141e.setConrers(15);
        this.f13141e.setGifIconSupport(false);
        this.f13141e.setLongIconSupport(false);
        this.f13141e.setDrawBorder(true);
        this.f13141e.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.f13141e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f13141e.setRadius(l.g(context, R.dimen.tbds10));
        this.f13141e.setPlaceHolder(2);
        this.f13142f = (TextView) findViewById(R.id.tv_single_link_text);
        this.f13143g = (TextView) findViewById(R.id.goods_price);
        b();
    }
}
