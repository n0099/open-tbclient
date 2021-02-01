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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private static final int fgF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fgG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fgH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fgI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgJ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fgK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
    private static final int fgL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int fgM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private ImageView fgA;
    private ImageView fgB;
    private int fgC;
    private int fgD;
    private String fgE;
    private TbImageView fgv;
    private RankStarView fgw;
    private TextView fgx;
    private TextView fgy;
    private TextView fgz;
    private Path mPath;
    private RectF mRect;
    private TextView mTitleView;

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgC = R.color.CAM_X0206;
        this.fgD = 0;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.fgv = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.fgw = (RankStarView) findViewById(R.id.item_star);
        this.fgx = (TextView) findViewById(R.id.item_score);
        this.fgy = (TextView) findViewById(R.id.item_des);
        this.fgz = (TextView) findViewById(R.id.item_tag);
        this.fgA = (ImageView) findViewById(R.id.bt_del);
        this.fgB = (ImageView) findViewById(R.id.img_right);
        this.fgv.setDrawCorner(true);
        this.fgv.setConrers(15);
        this.fgv.setRadiusById(R.string.J_X04);
        this.fgv.setPlaceHolder(1);
        this.fgv.setDrawBorder(true);
        this.fgw.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    private void btT() {
        if (this.fgD == 1) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.T_X07));
            this.fgy.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            this.fgz.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.T_X09));
            ((LinearLayout.LayoutParams) this.fgw.getLayoutParams()).height = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32);
            this.fgw.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fgz.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            this.fgz.setLayoutParams(layoutParams);
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.fgE + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.fgE, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.mTitleView.setText(spannableString);
        } else {
            this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.fgv.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.fgw.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.fgw.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
            this.fgx.setText(tbRichTextEvaluateItemInfo.getScore() + "");
        } else {
            this.fgx.setText(R.string.no_evaluate_now);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fgv.getLayoutParams();
        if (this.fgD == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = fgF;
                layoutParams.height = fgG;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = fgH;
                layoutParams.height = fgI;
            } else {
                layoutParams.width = fgJ;
                layoutParams.height = fgK;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = fgF;
            layoutParams.height = fgG;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = fgH;
            layoutParams.height = fgI;
        } else {
            layoutParams.width = fgJ;
            layoutParams.height = fgK;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fgv.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.fgE)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.fgE, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.mTitleView.setText(item.item_name);
        this.fgv.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.fgw.setStarCount(item.star.intValue());
        } else {
            this.fgw.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.fgx.setText(item.score + "");
        } else {
            this.fgx.setText(R.string.no_evaluate_now);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fgv.getLayoutParams();
        if (this.fgD == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = fgF;
                layoutParams.height = fgG;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = fgH;
                layoutParams.height = fgI;
            } else {
                layoutParams.width = fgJ;
                layoutParams.height = fgK;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = fgF;
            layoutParams.height = fgG;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fgH;
            layoutParams.height = fgI;
        } else {
            layoutParams.width = fgJ;
            layoutParams.height = fgK;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            if (this.fgD == 0) {
                layoutParams.width = fgF;
                layoutParams.height = fgG;
            } else if (this.fgD == 1) {
                layoutParams.width = fgF - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = fgG - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fgH;
            layoutParams.height = fgI;
        } else {
            layoutParams.width = fgJ;
            layoutParams.height = fgK;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fgv.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.fgz.setVisibility(8);
            return;
        }
        this.fgz.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fgM), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.fgz.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.mRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.mRect, fgL, fgL, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, this.fgC);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.fgx, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fgz, R.color.CAM_X0109, 1);
        SvgManager.bsR().a(this.fgA, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fgB, R.drawable.icon_pb_right_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.fgv.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fgv.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fgw.buZ();
        this.fgw.invalidate();
        this.fgv.setPlaceHolder(1);
    }

    public void setBackGroundColor(int i) {
        this.fgC = i;
        onChangeSkinType();
    }

    public RankStarView getStarView() {
        return this.fgw;
    }

    public TbImageView getItemImageView() {
        return this.fgv;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getTagView() {
        return this.fgz;
    }

    public void btU() {
        this.fgA.setVisibility(0);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.fgA.setOnClickListener(onClickListener);
    }

    public void setHighLightText(String str) {
        this.fgE = str;
    }

    public void setSizeStyle(int i) {
        this.fgD = i;
        btT();
    }
}
