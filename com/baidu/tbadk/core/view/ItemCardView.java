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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemCardView extends RelativeLayout {
    private TbImageView eNe;
    private RankStarView eNf;
    private TextView eNg;
    private TextView eNh;
    private TextView eNi;
    private int eNj;
    private Path mPath;
    private RectF mRect;
    private TextView mTitleView;
    private static final int eNk = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNl = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNm = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eNn = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNo = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds13);
    private static final int eNq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eNj = R.color.cp_bg_line_g;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.eNe = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.eNf = (RankStarView) findViewById(R.id.item_star);
        this.eNg = (TextView) findViewById(R.id.item_score);
        this.eNh = (TextView) findViewById(R.id.item_des);
        this.eNi = (TextView) findViewById(R.id.item_tag);
        this.eNe.setDrawCorner(true);
        this.eNe.setConrers(15);
        this.eNe.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eNe.setPlaceHolder(1);
        this.eNf.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        this.eNe.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.eNf.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.eNf.setStarCount(0);
        }
        if (tbRichTextEvaluateItemInfo.bDA() > 0.0d && tbRichTextEvaluateItemInfo.bDA() <= 10.0d) {
            this.eNg.setText(tbRichTextEvaluateItemInfo.bDA() + "");
        } else {
            this.eNg.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNe.getLayoutParams();
        if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = eNk;
            layoutParams.height = eNl;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = eNm;
            layoutParams.height = eNn;
        } else {
            layoutParams.width = eNo;
            layoutParams.height = eNp;
        }
        this.eNe.setLayoutParams(layoutParams);
        setTag(tbRichTextEvaluateItemInfo.getTags());
    }

    public void setData(Item item, int i) {
        this.mTitleView.setText(item.item_name);
        this.eNe.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.eNf.setStarCount(item.star.intValue());
        } else {
            this.eNf.setStarCount(0);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.eNg.setText(item.score + "");
        } else {
            this.eNg.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNe.getLayoutParams();
        if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = eNk;
            layoutParams.height = eNl;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eNm;
            layoutParams.height = eNn;
        } else {
            layoutParams.width = eNo;
            layoutParams.height = eNp;
        }
        this.eNe.setLayoutParams(layoutParams);
        setTag(item.tags);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.eNi.setVisibility(8);
            return;
        }
        this.eNi.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eNq), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.eNi.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
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
        ap.setBackgroundColor(this, this.eNj);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.eNg, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eNi, R.color.cp_cont_d, 1);
        this.eNf.bqO();
    }

    public void setBackGroundColor(int i) {
        this.eNj = i;
    }
}
