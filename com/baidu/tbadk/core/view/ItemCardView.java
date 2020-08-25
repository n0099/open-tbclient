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
/* loaded from: classes2.dex */
public class ItemCardView extends RelativeLayout {
    private RectF aCa;
    private TbImageView eqo;
    private RankStarView eqp;
    private TextView eqq;
    private TextView eqr;
    private TextView eqs;
    private int eqt;
    private Path mPath;
    private TextView mTitleView;
    private static final int equ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqw = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eqx = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqy = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds13);
    private static final int eqA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqt = R.color.cp_bg_line_g;
        this.mPath = new Path();
        this.aCa = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.eqo = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.eqp = (RankStarView) findViewById(R.id.item_star);
        this.eqq = (TextView) findViewById(R.id.item_score);
        this.eqr = (TextView) findViewById(R.id.item_des);
        this.eqs = (TextView) findViewById(R.id.item_tag);
        this.eqo.setDrawCorner(true);
        this.eqo.setConrers(15);
        this.eqo.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eqo.setPlaceHolder(1);
        this.eqp.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        this.eqo.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.eqp.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.eqp.setStarCount(0);
        }
        if (tbRichTextEvaluateItemInfo.bxN() > 0.0d && tbRichTextEvaluateItemInfo.bxN() <= 10.0d) {
            this.eqq.setText(tbRichTextEvaluateItemInfo.bxN() + "");
        } else {
            this.eqq.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqo.getLayoutParams();
        if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = equ;
            layoutParams.height = eqv;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = eqw;
            layoutParams.height = eqx;
        } else {
            layoutParams.width = eqy;
            layoutParams.height = eqz;
        }
        this.eqo.setLayoutParams(layoutParams);
        setTag(tbRichTextEvaluateItemInfo.getTags());
    }

    public void setData(Item item, int i) {
        this.mTitleView.setText(item.item_name);
        this.eqo.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.eqp.setStarCount(item.star.intValue());
        } else {
            this.eqp.setStarCount(0);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.eqq.setText(item.score + "");
        } else {
            this.eqq.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eqo.getLayoutParams();
        if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = equ;
            layoutParams.height = eqv;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eqw;
            layoutParams.height = eqx;
        } else {
            layoutParams.width = eqy;
            layoutParams.height = eqz;
        }
        this.eqo.setLayoutParams(layoutParams);
        setTag(item.tags);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.eqs.setVisibility(8);
            return;
        }
        this.eqs.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eqA), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.eqs.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.aCa.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.aCa, RADIUS, RADIUS, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, this.eqt);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.eqq, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eqs, R.color.cp_cont_d, 1);
        this.eqp.blq();
    }

    public void setBackGroundColor(int i) {
        this.eqt = i;
    }
}
