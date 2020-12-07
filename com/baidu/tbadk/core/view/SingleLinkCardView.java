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
    private TbImageView fca;
    private TextView fcb;
    private TextView fcc;

    public SingleLinkCardView(Context context) {
        this(context, null);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.single_link_card_layout, this);
        this.fca = (TbImageView) findViewById(R.id.iv_single_link_icon);
        this.fca.setBorderSurroundContent(true);
        this.fca.setDrawCorner(true);
        this.fca.setConrers(15);
        this.fca.setGifIconSupport(false);
        this.fca.setLongIconSupport(false);
        this.fca.setDrawBorder(true);
        this.fca.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1));
        this.fca.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fca.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.fca.setPlaceHolder(2);
        this.fcb = (TextView) findViewById(R.id.tv_single_link_text);
        this.fcc = (TextView) findViewById(R.id.goods_price);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.fcb, R.color.CAM_X0107);
        ap.setViewTextColor(this.fcc, R.color.CAM_X0305);
    }

    public void a(com.baidu.tieba.card.data.c cVar) {
        if (cVar instanceof PbLinkData) {
            PbLinkData pbLinkData = (PbLinkData) cVar;
            this.fca.startLoad(pbLinkData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbLinkData.linkFrom)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkFrom);
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i = R.color.CAM_X0305;
                int i2 = R.color.CAM_X0305;
                int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar = new b(dimens, -1, i, dimens3, i2, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.qC(dimens2);
                bVar.qA(dimens5);
                bVar.setMarginRight(dimens6);
                spannableStringBuilder.setSpan(bVar, 0, pbLinkData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl)) {
                spannableStringBuilder.append((CharSequence) pbLinkData.linkUrl);
            } else {
                spannableStringBuilder.append((CharSequence) pbLinkData.title);
            }
            this.fcb.setText(spannableStringBuilder);
            if (pbLinkData.urlType == 2) {
                if (TextUtils.isEmpty(pbLinkData.extTxt)) {
                    this.fcc.setVisibility(8);
                } else {
                    this.fcb.setMaxLines(1);
                    this.fcc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbLinkData.extTxt));
                    this.fcc.setVisibility(0);
                }
            } else {
                this.fcc.setVisibility(8);
            }
            if (TextUtils.isEmpty(pbLinkData.title) && !TextUtils.isEmpty(pbLinkData.linkUrl) && TextUtils.isEmpty(pbLinkData.extTxt)) {
                this.fcb.setMaxLines(1);
            }
        } else if (cVar instanceof PbGoodsData) {
            PbGoodsData pbGoodsData = (PbGoodsData) cVar;
            this.fca.startLoad(pbGoodsData.picUrl, 10, false);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(pbGoodsData.linkFrom)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkFrom);
                int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int dimens8 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.CAM_X0305;
                int i4 = R.color.CAM_X0305;
                int dimens9 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int dimens10 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int dimens11 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int dimens12 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                b bVar2 = new b(dimens7, -1, i3, dimens9, i4, dimens10, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar2.qC(dimens8);
                bVar2.qA(dimens11);
                bVar2.setMarginRight(dimens12);
                spannableStringBuilder2.setSpan(bVar2, 0, pbGoodsData.linkFrom.length(), 17);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.linkUrl);
            } else {
                spannableStringBuilder2.append((CharSequence) pbGoodsData.title);
            }
            this.fcb.setText(spannableStringBuilder2);
            if (TextUtils.isEmpty(pbGoodsData.price)) {
                this.fcc.setVisibility(8);
            } else {
                this.fcb.setMaxLines(1);
                this.fcc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), pbGoodsData.price));
                this.fcc.setVisibility(0);
            }
            if (TextUtils.isEmpty(pbGoodsData.title) && !TextUtils.isEmpty(pbGoodsData.linkUrl) && TextUtils.isEmpty(pbGoodsData.price)) {
                this.fcb.setMaxLines(1);
            }
        }
    }

    public void setMarginTop(int i) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
        requestLayout();
    }
}
