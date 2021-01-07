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
    private static final int fja = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fjd = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fje = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjf = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fjg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    private static final int fjh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private TbImageView fiR;
    private RankStarView fiS;
    private TextView fiT;
    private TextView fiU;
    private TextView fiV;
    private ImageView fiW;
    private int fiX;
    private int fiY;
    private String fiZ;
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
        this.fiX = R.color.CAM_X0206;
        this.fiY = 0;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.fiR = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.fiS = (RankStarView) findViewById(R.id.item_star);
        this.fiT = (TextView) findViewById(R.id.item_score);
        this.fiU = (TextView) findViewById(R.id.item_des);
        this.fiV = (TextView) findViewById(R.id.item_tag);
        this.fiW = (ImageView) findViewById(R.id.bt_del);
        this.fiR.setDrawCorner(true);
        this.fiR.setConrers(15);
        this.fiR.setRadiusById(R.string.J_X04);
        this.fiR.setPlaceHolder(1);
        this.fiR.setDrawBorder(true);
        this.fiS.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    private void bxt() {
        if (this.fiY == 1) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
            this.fiU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            this.fiV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            ((LinearLayout.LayoutParams) this.fiS.getLayoutParams()).height = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31);
            this.fiS.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fiV.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            this.fiV.setLayoutParams(layoutParams);
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.fiZ + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.fiZ, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.mTitleView.setText(spannableString);
        } else {
            this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.fiR.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.fiS.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.fiS.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
            this.fiT.setText(tbRichTextEvaluateItemInfo.getScore() + "");
        } else {
            this.fiT.setText(R.string.no_evaluate_now);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiR.getLayoutParams();
        if (this.fiY == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = fja;
                layoutParams.height = fjb;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = fjc;
                layoutParams.height = fjd;
            } else {
                layoutParams.width = fje;
                layoutParams.height = fjf;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = fja;
            layoutParams.height = fjb;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = fjc;
            layoutParams.height = fjd;
        } else {
            layoutParams.width = fje;
            layoutParams.height = fjf;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fiR.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.fiZ)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.fiZ, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.mTitleView.setText(item.item_name);
        this.fiR.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.fiS.setStarCount(item.star.intValue());
        } else {
            this.fiS.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.fiT.setText(item.score + "");
        } else {
            this.fiT.setText(R.string.no_evaluate_now);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiR.getLayoutParams();
        if (this.fiY == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = fja;
                layoutParams.height = fjb;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = fjc;
                layoutParams.height = fjd;
            } else {
                layoutParams.width = fje;
                layoutParams.height = fjf;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = fja;
            layoutParams.height = fjb;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fjc;
            layoutParams.height = fjd;
        } else {
            layoutParams.width = fje;
            layoutParams.height = fjf;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            if (this.fiY == 0) {
                layoutParams.width = fja;
                layoutParams.height = fjb;
            } else if (this.fiY == 1) {
                layoutParams.width = fja - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = fjb - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fjc;
            layoutParams.height = fjd;
        } else {
            layoutParams.width = fje;
            layoutParams.height = fjf;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fiR.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.fiV.setVisibility(8);
            return;
        }
        this.fiV.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fjh), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.fiV.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.mRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.mRect, fjg, fjg, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, this.fiX);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.fiT, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fiV, R.color.CAM_X0109, 1);
        SvgManager.bwr().a(this.fiW, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.fiR.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fiR.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fiS.byz();
    }

    public void setBackGroundColor(int i) {
        this.fiX = i;
        onChangeSkinType();
    }

    public RankStarView getStarView() {
        return this.fiS;
    }

    public TbImageView getItemImageView() {
        return this.fiR;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getTagView() {
        return this.fiV;
    }

    public void bxu() {
        this.fiW.setVisibility(0);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.fiW.setOnClickListener(onClickListener);
    }

    public void setHighLightText(String str) {
        this.fiZ = str;
    }

    public void setSizeStyle(int i) {
        this.fiY = i;
        bxt();
    }
}
