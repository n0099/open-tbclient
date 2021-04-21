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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.r.f0.o.b;
import java.util.List;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemCardView extends RelativeLayout {
    public static final int s = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    public static final int t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    public static final int u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    public static final int v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    public static final int w = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds146);
    public static final int x = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds195);
    public static final int y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    public static final int z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f13047e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13048f;

    /* renamed from: g  reason: collision with root package name */
    public RankStarView f13049g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13050h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public Path n;
    public RectF o;
    public int p;
    public int q;
    public String r;

    public ItemCardView(Context context) {
        this(context, null);
    }

    private void setTag(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.k.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < list.size(); i++) {
                spannableStringBuilder.append((CharSequence) list.get(i));
                if (i != list.size() - 1) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                    spannableStringBuilder2.setSpan(new b(z), 0, spannableStringBuilder2.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
            }
            this.k.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        this.k.setVisibility(8);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_card_view_layout, (ViewGroup) this, true);
        this.f13047e = (TbImageView) findViewById(R.id.item_image);
        this.f13048f = (TextView) findViewById(R.id.item_title);
        this.f13049g = (RankStarView) findViewById(R.id.item_star);
        this.f13050h = (TextView) findViewById(R.id.item_score);
        this.i = (TextView) findViewById(R.id.tieba_score_tag);
        this.j = (TextView) findViewById(R.id.item_des);
        this.k = (TextView) findViewById(R.id.item_tag);
        this.l = (ImageView) findViewById(R.id.bt_del);
        this.m = (ImageView) findViewById(R.id.img_right);
        this.f13047e.setDrawCorner(true);
        this.f13047e.setConrers(15);
        this.f13047e.setRadiusById(R.string.J_X04);
        this.f13047e.setPlaceHolder(1);
        this.f13047e.setDrawBorder(true);
        this.f13049g.setStarSpacing(l.g(context, R.dimen.tbds10));
        b();
    }

    public void b() {
        SkinManager.setBackgroundColor(this, this.p);
        SkinManager.setViewTextColor(this.f13048f, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f13050h, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.m, R.drawable.icon_pb_right_n, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f13047e.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.f13047e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f13049g.f();
        this.f13049g.invalidate();
        this.f13047e.setPlaceHolder(1);
    }

    public void c() {
        this.l.setVisibility(0);
    }

    public final void d() {
        if (this.q == 1) {
            this.f13048f.setTextSize(0, l.g(getContext(), R.dimen.T_X07));
            this.j.setTextSize(0, l.g(getContext(), R.dimen.tbds31));
            this.k.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            ((LinearLayout.LayoutParams) this.f13049g.getLayoutParams()).height = l.g(getContext(), R.dimen.tbds32);
            this.f13049g.setStarSpacing(l.g(getContext(), R.dimen.tbds3));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds5);
            this.k.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.n.reset();
        this.o.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        Path path = this.n;
        RectF rectF = this.o;
        int i = y;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        canvas.clipPath(this.n);
        super.draw(canvas);
    }

    public TbImageView getItemImageView() {
        return this.f13047e;
    }

    public RankStarView getStarView() {
        return this.f13049g;
    }

    public TextView getTagView() {
        return this.k;
    }

    public TextView getTitleView() {
        return this.f13048f;
    }

    public void setBackGroundColor(int i) {
        this.p = i;
        b();
    }

    public void setData(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo, int i) {
        if (!TextUtils.isEmpty(this.r + tbRichTextEvaluateItemInfo.getTitle())) {
            SpannableString spannableString = new SpannableString(tbRichTextEvaluateItemInfo.getTitle());
            UtilHelper.setSpan(spannableString, tbRichTextEvaluateItemInfo.getTitle(), this.r, new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0301)));
            this.f13048f.setText(spannableString);
        } else {
            this.f13048f.setText(tbRichTextEvaluateItemInfo.getTitle());
        }
        this.f13047e.W(tbRichTextEvaluateItemInfo.getIconUrl(), i, false);
        if (tbRichTextEvaluateItemInfo.getStar() >= 0 && tbRichTextEvaluateItemInfo.getStar() <= 5) {
            this.f13049g.setStarCount(tbRichTextEvaluateItemInfo.getStar());
        } else {
            this.f13049g.setStarCount(0.0f);
        }
        if (tbRichTextEvaluateItemInfo.getScore() > 0.0d && tbRichTextEvaluateItemInfo.getScore() <= 10.0d) {
            this.f13050h.setText(tbRichTextEvaluateItemInfo.getScore() + "");
            this.i.setText(R.string.tieba_score);
        } else {
            this.f13050h.setText(R.string.no_evaluate_now);
            this.i.setText(R.string.no_tieba_score);
        }
        setTag(tbRichTextEvaluateItemInfo.getTags());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13047e.getLayoutParams();
        if (this.q == 1) {
            if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
                layoutParams.width = s;
                layoutParams.height = t;
            } else if (tbRichTextEvaluateItemInfo.getIconSize() < 1.0d) {
                layoutParams.width = u;
                layoutParams.height = v;
            } else {
                layoutParams.width = w;
                layoutParams.height = x;
            }
            layoutParams.width -= l.g(getContext(), R.dimen.tbds5);
            layoutParams.height -= l.g(getContext(), R.dimen.tbds5);
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 1.0d) {
            layoutParams.width = s;
            layoutParams.height = t;
        } else if (tbRichTextEvaluateItemInfo.getIconSize() == 0.67d) {
            layoutParams.width = u;
            layoutParams.height = v;
        } else {
            layoutParams.width = w;
            layoutParams.height = x;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + l.g(getContext(), R.dimen.tbds42);
        this.f13047e.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }

    public void setHighLightText(String str) {
        this.r = str;
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.l.setOnClickListener(onClickListener);
    }

    public void setSizeStyle(int i) {
        this.q = i;
        d();
    }

    public ItemCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = R.color.CAM_X0206;
        this.q = 0;
        this.n = new Path();
        this.o = new RectF();
        a(context);
    }

    public void setData(Item item, int i) {
        if (!TextUtils.isEmpty(item.item_name + this.r)) {
            UtilHelper.setSpan(new SpannableString(item.item_name), item.item_name, this.r, new ForegroundColorSpan(Color.parseColor("#0AC3BC")));
        }
        this.f13048f.setText(item.item_name);
        this.f13047e.W(item.icon_url, i, false);
        if (item.star.intValue() >= 0 && item.star.intValue() <= 5) {
            this.f13049g.setStarCount(item.star.intValue());
        } else {
            this.f13049g.setStarCount(0.0f);
        }
        if (item.score.doubleValue() > 0.0d && item.score.doubleValue() <= 10.0d) {
            this.f13050h.setText(item.score + "");
            this.i.setText(R.string.tieba_score);
        } else {
            this.f13050h.setText(R.string.no_evaluate_now);
            this.f13050h.setText(R.string.no_tieba_score);
        }
        setTag(item.tags);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13047e.getLayoutParams();
        if (this.q == 1) {
            if (item.icon_size.doubleValue() == 1.0d) {
                layoutParams.width = s;
                layoutParams.height = t;
            } else if (item.icon_size.doubleValue() < 1.0d) {
                layoutParams.width = u;
                layoutParams.height = v;
            } else {
                layoutParams.width = w;
                layoutParams.height = x;
            }
            layoutParams.width -= l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            layoutParams.height -= l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
        } else if (item.icon_size.doubleValue() == 1.0d) {
            layoutParams.width = s;
            layoutParams.height = t;
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = u;
            layoutParams.height = v;
        } else {
            layoutParams.width = w;
            layoutParams.height = x;
        }
        if (item.icon_size.doubleValue() == 1.0d) {
            int i2 = this.q;
            if (i2 == 0) {
                layoutParams.width = s;
                layoutParams.height = t;
            } else if (i2 == 1) {
                layoutParams.width = s - l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
                layoutParams.height = t - l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
            }
        } else if (item.icon_size.doubleValue() == 0.67d) {
            layoutParams.width = u;
            layoutParams.height = v;
        } else {
            layoutParams.width = w;
            layoutParams.height = x;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.height = layoutParams.height + l.g(getContext(), R.dimen.tbds42);
        this.f13047e.setLayoutParams(layoutParams);
        setLayoutParams(layoutParams2);
    }
}
