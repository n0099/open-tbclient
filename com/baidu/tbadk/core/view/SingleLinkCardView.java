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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SingleLinkCardView extends RelativeLayout {
    private TbImageView eHi;
    private TextView eHj;
    private TextView eHk;

    public SingleLinkCardView(Context context) {
        this(context, null);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        this.eHi = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.eHi.setBorderSurroundContent(true);
        this.eHi.setDrawCorner(true);
        this.eHi.setConrers(15);
        this.eHi.setGifIconSupport(false);
        this.eHi.setLongIconSupport(false);
        this.eHi.setDrawBorder(true);
        this.eHi.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.eHi.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.eHi.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eHi.setPlaceHolder(2);
        this.eHj = (TextView) findViewById(R.id.tv_single_link_text);
        this.eHk = (TextView) findViewById(R.id.goods_price);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.eHj, R.color.cp_cont_j);
        ap.setViewTextColor(this.eHk, R.color.cp_link_tip_d);
    }

    public void a(com.baidu.tieba.card.data.d dVar) {
        if (dVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) dVar;
            this.eHi.startLoad(pbLinkData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i = R.color.cp_link_tip_a;
                int i2 = R.color.cp_link_tip_a;
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
                b bVar = new b(dimens, dimens2, i, dimens3, i2, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.ph(dimens5);
                bVar.setMarginRight(dimens6);
                spannableStringBuilder.setSpan(bVar, 0, pbLinkData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
            } else {
                spannableStringBuilder.append((CharSequence) pbLinkData.title);
            }
            this.eHj.setText(spannableStringBuilder);
            if (pbLinkData.urlType == 2) {
                if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.eHk.setVisibility(8);
                } else {
                    this.eHj.setMaxLines(1);
                    this.eHk.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                    this.eHk.setVisibility(0);
                }
            } else {
                this.eHk.setVisibility(8);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                this.eHj.setMaxLines(1);
            }
        } else if (dVar instanceof PbGoodsData) {
            PbGoodsData pbGoodsData = (PbGoodsData) dVar;
            this.eHi.startLoad(pbGoodsData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.cp_link_tip_a;
                int i4 = R.color.cp_link_tip_a;
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int dimens11 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int dimens12 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
                b bVar2 = new b(dimens7, dimens8, i3, dimens9, i4, dimens10, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar2.ph(dimens11);
                bVar2.setMarginRight(dimens12);
                spannableStringBuilder2.setSpan(bVar2, 0, pbGoodsData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
            } else {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
            }
            this.eHj.setText(spannableStringBuilder2);
            if (TextUtils.isEmpty(pbGoodsData.price)) {
                this.eHk.setVisibility(8);
            } else {
                this.eHj.setMaxLines(1);
                this.eHk.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                this.eHk.setVisibility(0);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                this.eHj.setMaxLines(1);
            }
        }
    }

    public void setMarginTop(int i) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
        requestLayout();
    }
}
