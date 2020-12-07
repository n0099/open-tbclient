package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private TbImageView eZn;
    private RankStarView eZo;
    private TextView eZp;
    private TextView eZq;
    private TextView eZr;
    private ImageView eZs;
    private int eZt;
    private int eZu;
    private String eZv;
    private Path mPath;
    private RectF mRect;
    private TextView mTitleView;
    private static final int eZw = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZx = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZy = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eZz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int eZC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZt = R.color.CAM_X0206;
        this.eZu = 0;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.eZn = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.eZo = (RankStarView) findViewById(R.id.item_star);
        this.eZp = (TextView) findViewById(R.id.item_score);
        this.eZq = (TextView) findViewById(R.id.item_des);
        this.eZr = (TextView) findViewById(R.id.item_tag);
        this.eZs = (ImageView) findViewById(R.id.bt_del);
        this.eZn.setDrawCorner(true);
        this.eZn.setConrers(15);
        this.eZn.setRadiusById(R.string.J_X04);
        this.eZn.setPlaceHolder(1);
        this.eZn.setDrawBorder(true);
        this.eZo.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    private void buX() {
        if (this.eZu == 1) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
            this.eZq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            this.eZr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            ((LinearLayout.LayoutParams) this.eZo.getLayoutParams()).height = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            this.eZo.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eZr.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            this.eZr.setLayoutParams(layoutParams);
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.eZv + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.eZv, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.mTitleView.setText(spannableString);
        } else {
            this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.eZn.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.eZo.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.eZo.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.bIS() > 0.0d && tbRichTextEvaluateItemInfo.bIS() <= 10.0d) {
            this.eZp.setText(tbRichTextEvaluateItemInfo.bIS() + "");
        } else {
            this.eZp.setText(R.string.no_evaluate_now);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZn.getLayoutParams();
        if (this.eZu == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = eZw;
                layoutParams.height = eZx;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = eZy;
                layoutParams.height = eZz;
            } else {
                layoutParams.width = eZA;
                layoutParams.height = eZB;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = eZw;
            layoutParams.height = eZx;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = eZy;
            layoutParams.height = eZz;
        } else {
            layoutParams.width = eZA;
            layoutParams.height = eZB;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.eZn.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.eZv)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.eZv, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.mTitleView.setText(item.item_name);
        this.eZn.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.eZo.setStarCount(item.star.intValue());
        } else {
            this.eZo.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.eZp.setText(item.score + "");
        } else {
            this.eZp.setText(R.string.no_evaluate_now);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZn.getLayoutParams();
        if (this.eZu == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = eZw;
                layoutParams.height = eZx;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = eZy;
                layoutParams.height = eZz;
            } else {
                layoutParams.width = eZA;
                layoutParams.height = eZB;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = eZw;
            layoutParams.height = eZx;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eZy;
            layoutParams.height = eZz;
        } else {
            layoutParams.width = eZA;
            layoutParams.height = eZB;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            if (this.eZu == 0) {
                layoutParams.width = eZw;
                layoutParams.height = eZx;
            } else if (this.eZu == 1) {
                layoutParams.width = eZw - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = eZx - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eZy;
            layoutParams.height = eZz;
        } else {
            layoutParams.width = eZA;
            layoutParams.height = eZB;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.eZn.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.eZr.setVisibility(8);
            return;
        }
        this.eZr.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eZC), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.eZr.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.mRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.mRect, RADIUS, RADIUS, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, this.eZt);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.eZp, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.eZr, R.color.CAM_X0109, 1);
        SvgManager.btW().a(this.eZs, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.eZn.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eZn.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.eZo.bwe();
    }

    public void setBackGroundColor(int i) {
        this.eZt = i;
        onChangeSkinType();
    }

    public RankStarView getStarView() {
        return this.eZo;
    }

    public TbImageView getItemImageView() {
        return this.eZn;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getTagView() {
        return this.eZr;
    }

    public void buY() {
        this.eZs.setVisibility(0);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.eZs.setOnClickListener(onClickListener);
    }

    public void setHighLightText(String str) {
        this.eZv = str;
    }

    public void setSizeStyle(int i) {
        this.eZu = i;
        buX();
    }
}
