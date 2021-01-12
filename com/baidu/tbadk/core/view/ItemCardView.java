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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private static final int fep = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int feq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fer = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fes = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fet = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int feu = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fev = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int few = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private TbImageView feg;
    private RankStarView feh;
    private TextView fei;
    private TextView fej;
    private TextView fek;
    private ImageView fel;
    private int fem;
    private int fen;
    private String feo;
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
        this.fem = R.color.CAM_X0206;
        this.fen = 0;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.feg = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.feh = (RankStarView) findViewById(R.id.item_star);
        this.fei = (TextView) findViewById(R.id.item_score);
        this.fej = (TextView) findViewById(R.id.item_des);
        this.fek = (TextView) findViewById(R.id.item_tag);
        this.fel = (ImageView) findViewById(R.id.bt_del);
        this.feg.setDrawCorner(true);
        this.feg.setConrers(15);
        this.feg.setRadiusById(R.string.J_X04);
        this.feg.setPlaceHolder(1);
        this.feg.setDrawBorder(true);
        this.feh.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    private void btz() {
        if (this.fen == 1) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
            this.fej.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            this.fek.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            ((LinearLayout.LayoutParams) this.feh.getLayoutParams()).height = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            this.feh.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fek.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            this.fek.setLayoutParams(layoutParams);
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.feo + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.feo, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.mTitleView.setText(spannableString);
        } else {
            this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.feg.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.feh.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.feh.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
            this.fei.setText(tbRichTextEvaluateItemInfo.getScore() + "");
        } else {
            this.fei.setText(R.string.no_evaluate_now);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feg.getLayoutParams();
        if (this.fen == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = fep;
                layoutParams.height = feq;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = fer;
                layoutParams.height = fes;
            } else {
                layoutParams.width = fet;
                layoutParams.height = feu;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = fep;
            layoutParams.height = feq;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = fer;
            layoutParams.height = fes;
        } else {
            layoutParams.width = fet;
            layoutParams.height = feu;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.feg.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.feo)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.feo, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.mTitleView.setText(item.item_name);
        this.feg.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.feh.setStarCount(item.star.intValue());
        } else {
            this.feh.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.fei.setText(item.score + "");
        } else {
            this.fei.setText(R.string.no_evaluate_now);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feg.getLayoutParams();
        if (this.fen == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = fep;
                layoutParams.height = feq;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = fer;
                layoutParams.height = fes;
            } else {
                layoutParams.width = fet;
                layoutParams.height = feu;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = fep;
            layoutParams.height = feq;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fer;
            layoutParams.height = fes;
        } else {
            layoutParams.width = fet;
            layoutParams.height = feu;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            if (this.fen == 0) {
                layoutParams.width = fep;
                layoutParams.height = feq;
            } else if (this.fen == 1) {
                layoutParams.width = fep - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = feq - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fer;
            layoutParams.height = fes;
        } else {
            layoutParams.width = fet;
            layoutParams.height = feu;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.feg.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.fek.setVisibility(8);
            return;
        }
        this.fek.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(few), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.fek.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.mRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.mRect, fev, fev, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, this.fem);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.fei, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fek, R.color.CAM_X0109, 1);
        SvgManager.bsx().a(this.fel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.feg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.feg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.feh.buF();
    }

    public void setBackGroundColor(int i) {
        this.fem = i;
        onChangeSkinType();
    }

    public RankStarView getStarView() {
        return this.feh;
    }

    public TbImageView getItemImageView() {
        return this.feg;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getTagView() {
        return this.fek;
    }

    public void btA() {
        this.fel.setVisibility(0);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.fel.setOnClickListener(onClickListener);
    }

    public void setHighLightText(String str) {
        this.feo = str;
    }

    public void setSizeStyle(int i) {
        this.fen = i;
        btz();
    }
}
