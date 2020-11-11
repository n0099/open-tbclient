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
    private TbImageView eST;
    private RankStarView eSU;
    private TextView eSV;
    private TextView eSW;
    private TextView eSX;
    private int eSY;
    private Path mPath;
    private RectF mRect;
    private TextView mTitleView;
    private static final int eSZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTa = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eTc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTd = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTe = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int RADIUS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds13);
    private static final int eTf = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public ItemCardView(Context context) {
        this(context, null);
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSY = R.color.cp_bg_line_g;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.eST = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.eSU = (RankStarView) findViewById(R.id.item_star);
        this.eSV = (TextView) findViewById(R.id.item_score);
        this.eSW = (TextView) findViewById(R.id.item_des);
        this.eSX = (TextView) findViewById(R.id.item_tag);
        this.eST.setDrawCorner(true);
        this.eST.setConrers(15);
        this.eST.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eST.setPlaceHolder(1);
        this.eSU.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        this.eST.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.eSU.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.eSU.setStarCount(0);
        }
        if (tbRichTextEvaluateItemInfo.bFZ() > 0.0d && tbRichTextEvaluateItemInfo.bFZ() <= 10.0d) {
            this.eSV.setText(tbRichTextEvaluateItemInfo.bFZ() + "");
        } else {
            this.eSV.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eST.getLayoutParams();
        if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = eSZ;
            layoutParams.height = eTa;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = eTb;
            layoutParams.height = eTc;
        } else {
            layoutParams.width = eTd;
            layoutParams.height = eTe;
        }
        this.eST.setLayoutParams(layoutParams);
        setTag(tbRichTextEvaluateItemInfo.getTags());
    }

    public void setData(Item item, int i) {
        this.mTitleView.setText(item.item_name);
        this.eST.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.eSU.setStarCount(item.star.intValue());
        } else {
            this.eSU.setStarCount(0);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.eSV.setText(item.score + "");
        } else {
            this.eSV.setText(R.string.no_evaluate_now);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eST.getLayoutParams();
        if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = eSZ;
            layoutParams.height = eTa;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = eTb;
            layoutParams.height = eTc;
        } else {
            layoutParams.width = eTd;
            layoutParams.height = eTe;
        }
        this.eST.setLayoutParams(layoutParams);
        setTag(item.tags);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.eSX.setVisibility(8);
            return;
        }
        this.eSX.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eTf), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.eSX.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
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
        ap.setBackgroundColor(this, this.eSY);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.eSV, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.eSX, R.color.cp_cont_d, 1);
        this.eSU.bto();
    }

    public void setBackGroundColor(int i) {
        this.eSY = i;
    }
}
