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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private RectF avT;
    private TextView eaA;
    private int eaB;
    private TbImageView eaw;
    private RankStarView eax;
    private TextView eay;
    private TextView eaz;
    private Path mPath;
    private TextView mTitleView;
    private static final int eaC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eaF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds13);
    private static final int eaI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaB = R.color.cp_bg_line_g;
        this.mPath = new Path();
        this.avT = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.eaw = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.eax = (RankStarView) findViewById(R.id.item_star);
        this.eay = (TextView) findViewById(R.id.item_score);
        this.eaz = (TextView) findViewById(R.id.item_des);
        this.eaA = (TextView) findViewById(R.id.item_tag);
        this.eaw.setDrawCorner(true);
        this.eaw.setConrers(15);
        this.eaw.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eaw.setPlaceHolder(1);
        this.eax.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        this.eaw.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.eax.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.eax.setStarCount(0);
        }
        if (tbRichTextEvaluateItemInfo.blg() > 0.0d && tbRichTextEvaluateItemInfo.blg() <= 10.0d) {
            this.eay.setText(tbRichTextEvaluateItemInfo.blg() + "");
        } else {
            this.eay.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaw.getLayoutParams();
        if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = eaC;
            layoutParams.height = eaD;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = eaE;
            layoutParams.height = eaF;
        } else {
            layoutParams.width = eaG;
            layoutParams.height = eaH;
        }
        this.eaw.setLayoutParams(layoutParams);
        setTag(tbRichTextEvaluateItemInfo.getTags());
    }

    public void setData(Item item, int i) {
        this.mTitleView.setText(item.item_name);
        this.eaw.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.eax.setStarCount(item.star.intValue());
        } else {
            this.eax.setStarCount(0);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.eay.setText(item.score + "");
        } else {
            this.eay.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaw.getLayoutParams();
        if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = eaC;
            layoutParams.height = eaD;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eaE;
            layoutParams.height = eaF;
        } else {
            layoutParams.width = eaG;
            layoutParams.height = eaH;
        }
        this.eaw.setLayoutParams(layoutParams);
        setTag(item.tags);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.eaA.setVisibility(8);
            return;
        }
        this.eaA.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eaI), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.eaA.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.avT.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.avT, RADIUS, RADIUS, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, this.eaB);
        an.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.eay, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.eaA, R.color.cp_cont_d, 1);
        this.eax.aYW();
    }

    public void setBackGroundColor(int i) {
        this.eaB = i;
    }
}
