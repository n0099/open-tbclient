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
import d.a.c.e.p.l;
import d.a.j0.r.f0.b;
import d.a.k0.x.e0.c;
/* loaded from: classes3.dex */
public class SingleLinkCardView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12429e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12430f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12431g;

    public SingleLinkCardView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            this.f12429e.V(pbLinkData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i2 = R.color.CAM_X0305;
                int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar = new b(g2, -1, i2, g4, i2, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
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
            this.f12430f.setText(spannableStringBuilder);
            if (pbLinkData.urlType == 2) {
                if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.f12431g.setVisibility(8);
                } else {
                    this.f12430f.setMaxLines(1);
                    this.f12431g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                    this.f12431g.setVisibility(0);
                }
            } else {
                this.f12431g.setVisibility(8);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                this.f12430f.setMaxLines(1);
            }
        } else if (cVar instanceof PbGoodsData) {
            PbGoodsData pbGoodsData = (PbGoodsData) cVar;
            this.f12429e.V(pbGoodsData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                int g8 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g9 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.CAM_X0305;
                int g10 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g11 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g12 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g13 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar2 = new b(g8, -1, i3, g10, i3, g11, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
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
            this.f12430f.setText(spannableStringBuilder2);
            if (TextUtils.isEmpty(pbGoodsData.price)) {
                this.f12431g.setVisibility(8);
            } else {
                this.f12430f.setMaxLines(1);
                this.f12431g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                this.f12431g.setVisibility(0);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                this.f12430f.setMaxLines(1);
            }
        }
    }

    public void b() {
        SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
        SkinManager.setViewTextColor(this.f12430f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f12431g, R.color.CAM_X0305);
    }

    public void setMarginTop(int i2) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i2;
        requestLayout();
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.f12429e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.f12429e.setDrawCorner(true);
        this.f12429e.setConrers(15);
        this.f12429e.setGifIconSupport(false);
        this.f12429e.setLongIconSupport(false);
        this.f12429e.setDrawBorder(true);
        this.f12429e.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.f12429e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f12429e.setRadius(l.g(context, R.dimen.tbds10));
        this.f12429e.setPlaceHolder(2);
        this.f12430f = (TextView) findViewById(R.id.tv_single_link_text);
        this.f12431g = (TextView) findViewById(R.id.goods_price);
        b();
    }
}
