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
    private static final int fif = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fig = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fih = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fii = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fij = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    private static final int fik = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
    private static final int fil = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int fim = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private TbImageView fhU;
    private RankStarView fhV;
    private TextView fhW;
    private TextView fhX;
    private TextView fhY;
    private ImageView fhZ;
    private ImageView fia;
    private int fib;
    private int fic;
    private String fie;
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
        this.fib = R.color.CAM_X0206;
        this.fic = 0;
        this.mPath = new Path();
        this.mRect = new RectF();
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.fhU = (TbImageView) findViewById(R.id.item_image);
        this.mTitleView = (TextView) findViewById(R.id.item_title);
        this.fhV = (RankStarView) findViewById(R.id.item_star);
        this.fhW = (TextView) findViewById(R.id.item_score);
        this.fhX = (TextView) findViewById(R.id.item_des);
        this.fhY = (TextView) findViewById(R.id.item_tag);
        this.fhZ = (ImageView) findViewById(R.id.bt_del);
        this.fia = (ImageView) findViewById(R.id.img_right);
        this.fhU.setDrawCorner(true);
        this.fhU.setConrers(15);
        this.fhU.setRadiusById(R.string.J_X04);
        this.fhU.setPlaceHolder(1);
        this.fhU.setDrawBorder(true);
        this.fhV.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        onChangeSkinType();
    }

    private void btW() {
        if (this.fic == 1) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.T_X07));
            this.fhX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31));
            this.fhY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.T_X09));
            ((LinearLayout.LayoutParams) this.fhV.getLayoutParams()).height = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds32);
            this.fhV.setStarSpacing(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhY.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            this.fhY.setLayoutParams(layoutParams);
        }
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.fie + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.fie, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.mTitleView.setText(spannableString);
        } else {
            this.mTitleView.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.fhU.startLoad(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.fhV.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.fhV.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
            this.fhW.setText(tbRichTextEvaluateItemInfo.getScore() + "");
        } else {
            this.fhW.setText(R.string.no_evaluate_now);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhU.getLayoutParams();
        if (this.fic == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = fif;
                layoutParams.height = fig;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = fih;
                layoutParams.height = fii;
            } else {
                layoutParams.width = fij;
                layoutParams.height = fik;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = fif;
            layoutParams.height = fig;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = fih;
            layoutParams.height = fii;
        } else {
            layoutParams.width = fij;
            layoutParams.height = fik;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fhU.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.fie)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.fie, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.mTitleView.setText(item.item_name);
        this.fhU.startLoad(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.fhV.setStarCount(item.star.intValue());
        } else {
            this.fhV.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.fhW.setText(item.score + "");
        } else {
            this.fhW.setText(R.string.no_evaluate_now);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhU.getLayoutParams();
        if (this.fic == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = fif;
                layoutParams.height = fig;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = fih;
                layoutParams.height = fii;
            } else {
                layoutParams.width = fij;
                layoutParams.height = fik;
            }
            layoutParams.width -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = fif;
            layoutParams.height = fig;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fih;
            layoutParams.height = fii;
        } else {
            layoutParams.width = fij;
            layoutParams.height = fik;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            if (this.fic == 0) {
                layoutParams.width = fif;
                layoutParams.height = fig;
            } else if (this.fic == 1) {
                layoutParams.width = fif - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = fig - com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = fih;
            layoutParams.height = fii;
        } else {
            layoutParams.width = fij;
            layoutParams.height = fik;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.fhU.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.fhY.setVisibility(8);
            return;
        }
        this.fhY.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fim), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.fhY.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mPath.reset();
        this.mRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        this.mPath.addRoundRect(this.mRect, fil, fil, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, this.fib);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0107, 1);
        ap.setViewTextColor(this.fhW, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fhY, R.color.CAM_X0109, 1);
        SvgManager.bsU().a(this.fhZ, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        WebPManager.a(this.fia, R.drawable.icon_pb_right_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.fhU.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fhU.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fhV.bvc();
        this.fhV.invalidate();
        this.fhU.setPlaceHolder(1);
    }

    public void setBackGroundColor(int i) {
        this.fib = i;
        onChangeSkinType();
    }

    public RankStarView getStarView() {
        return this.fhV;
    }

    public TbImageView getItemImageView() {
        return this.fhU;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public TextView getTagView() {
        return this.fhY;
    }

    public void btX() {
        this.fhZ.setVisibility(0);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.fhZ.setOnClickListener(onClickListener);
    }

    public void setHighLightText(String str) {
        this.fie = str;
    }

    public void setSizeStyle(int i) {
        this.fic = i;
        btW();
    }
}
