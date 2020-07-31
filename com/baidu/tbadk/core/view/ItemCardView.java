package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private RectF awY;
    private TbImageView egH;
    private RankStarView egI;
    private TextView egJ;
    private TextView egK;
    private TextView egL;
    private int egM;
    private Path mPath;
    private TextView mTitleView;
    private static final int egN = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int egQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds13);
    private static final int egT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egM = R.color.cp_bg_line_g;
        this.mPath = new Path();
        this.awY = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.egH = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.egI = (RankStarView) findViewById(R.id.item_star);
        this.egJ = (TextView) findViewById(R.id.item_score);
        this.egK = (TextView) findViewById(R.id.item_des);
        this.egL = (TextView) findViewById(R.id.item_tag);
        this.egH.setDrawCorner(true);
        this.egH.setConrers(15);
        this.egH.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.egH.setPlaceHolder(1);
        this.egI.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        this.egH.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.egI.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.egI.setStarCount(0);
        }
        if (tbRichTextEvaluateItemInfo.bpa() > 0.0d && tbRichTextEvaluateItemInfo.bpa() <= 10.0d) {
            this.egJ.setText(tbRichTextEvaluateItemInfo.bpa() + "");
        } else {
            this.egJ.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egH.getLayoutParams();
        if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = egN;
            layoutParams.height = egO;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = egP;
            layoutParams.height = egQ;
        } else {
            layoutParams.width = egR;
            layoutParams.height = egS;
        }
        this.egH.setLayoutParams(layoutParams);
        setTag(tbRichTextEvaluateItemInfo.getTags());
    }

    public void setData(Item item, int i) {
        this.mTitleView.setText(item.item_name);
        this.egH.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.egI.setStarCount(item.star.intValue());
        } else {
            this.egI.setStarCount(0);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.egJ.setText(item.score + "");
        } else {
            this.egJ.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egH.getLayoutParams();
        if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = egN;
            layoutParams.height = egO;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = egP;
            layoutParams.height = egQ;
        } else {
            layoutParams.width = egR;
            layoutParams.height = egS;
        }
        this.egH.setLayoutParams(layoutParams);
        setTag(item.tags);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.egL.setVisibility(8);
            return;
        }
        this.egL.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(egT), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.egL.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.awY.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.awY, RADIUS, RADIUS, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, this.egM);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.egJ, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.egL, R.color.cp_cont_d, 1);
        this.egI.bcT();
    }

    public void setBackGroundColor(int i) {
        this.egM = i;
    }
}
