package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.b.g.b;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.w1;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f4375e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f4376f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4377g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4378h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4379i;
    public TextView j;
    public TextView k;
    public String l;
    public View.OnClickListener m;
    public int n;
    public a2 o;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.n = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.f4375e = (BarImageView) findViewById(R.id.forum_head_image);
        this.f4376f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.f4377g = (TextView) findViewById(R.id.forum_head_info_attention);
        this.f4378h = (TextView) findViewById(R.id.forum_head_info_thread);
        this.f4379i = (TextView) findViewById(R.id.hot_rank_index);
        this.j = (TextView) findViewById(R.id.hot_rank_num);
        this.k = (TextView) findViewById(R.id.thread_extend_info);
        this.f4375e.setShowOval(true);
        this.f4375e.setAutoChangeStyle(true);
        this.f4375e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f4375e.setStrokeColorResId(R.color.CAM_X0401);
        this.f4375e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f4375e.setOnClickListener(this);
        this.f4376f.setOnClickListener(this);
        this.f4377g.setOnClickListener(this);
        this.f4378h.setOnClickListener(this);
        this.f4376f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.f4376f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.n) {
            return;
        }
        this.n = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int g2 = l.g(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, g2, g2);
        this.f4376f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f4376f.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f4376f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f4377g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f4378h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        c();
        d();
    }

    public final void c() {
        b.e(this.f4376f);
    }

    public final void d() {
        Drawable mutate;
        a2 a2Var = this.o;
        if (a2Var != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(a2Var.position + 1);
            this.f4379i.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
            int color = SkinManager.getColor(indexTextColorRes);
            a2 a2Var2 = this.o;
            if (a2Var2.c2) {
                if ("agree_num".equals(a2Var2.d2)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.o.d2)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else {
                    mutate = "share_num".equals(this.o.d2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
                }
            } else {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            }
            int g2 = l.g(getContext(), R.dimen.tbds42);
            if (mutate == null) {
                return;
            }
            mutate.setBounds(0, 0, g2, g2);
            DrawableCompat.setTint(mutate, color);
            this.f4379i.setCompoundDrawables(mutate, null, null, null);
            this.f4379i.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.f4379i, indexTextColorRes);
            SkinManager.setViewTextColor(this.j, indexTextColorRes);
        }
    }

    public final void e() {
        this.f4375e.setVisibility(8);
        this.f4376f.setVisibility(8);
        this.f4378h.setVisibility(8);
        this.f4377g.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (StringUtils.isNull(this.l)) {
            return;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.l, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setData(String str, String str2, int i2, int i3) {
        if (StringUtils.isNull(str)) {
            e();
            return;
        }
        this.f4375e.setPlaceHolder(1);
        this.f4375e.setVisibility(0);
        this.f4376f.setVisibility(0);
        this.l = str;
        this.f4376f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
        this.f4375e.U(str2, 10, false);
        this.f4378h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
        this.f4377g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
        b.d(this.f4376f);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 3;
        a(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = 3;
        a(context);
    }

    public void setData(a2 a2Var) {
        String str;
        String str2;
        this.o = a2Var;
        if (a2Var != null && a2Var.h0() != null) {
            if (a2Var.b2) {
                this.f4378h.setVisibility(8);
                this.f4377g.setVisibility(8);
                this.f4379i.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(a2Var.t1());
                int i2 = a2Var.y2;
                if (i2 < 1000) {
                    i2 = 1000;
                }
                this.j.setVisibility(0);
                String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                TextView textView = this.j;
                textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                int i3 = a2Var.position + 1;
                TextView textView2 = this.f4379i;
                if (i3 >= 10) {
                    str2 = String.valueOf(i3);
                } else {
                    str2 = "0" + i3;
                }
                textView2.setText(str2);
                d();
                w1 h0 = a2Var.h0();
                this.f4375e.setPlaceHolder(1);
                this.f4375e.setVisibility(0);
                this.f4375e.U(h0.a(), 10, false);
                this.f4376f.setVisibility(0);
                this.l = h0.f53941b;
                this.f4376f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                b.d(this.f4376f);
                return;
            } else if (a2Var.c2) {
                this.k.setVisibility(8);
                if (!"agree_num".equals(a2Var.d2) && !"comment_num".equals(a2Var.d2) && !"share_num".equals(a2Var.d2)) {
                    this.f4379i.setVisibility(8);
                    this.j.setVisibility(8);
                } else {
                    this.f4379i.setVisibility(0);
                    this.j.setVisibility(0);
                    if ("agree_num".equals(a2Var.d2)) {
                        String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.L() != null ? a2Var.L().agreeNum : 0L);
                        TextView textView3 = this.j;
                        textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                    } else if ("comment_num".equals(a2Var.d2)) {
                        String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.b1());
                        TextView textView4 = this.j;
                        textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                    } else if ("share_num".equals(a2Var.d2)) {
                        String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.i1());
                        TextView textView5 = this.j;
                        textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                    }
                    int i4 = a2Var.position + 1;
                    TextView textView6 = this.f4379i;
                    if (i4 >= 10) {
                        str = String.valueOf(i4);
                    } else {
                        str = "0" + i4;
                    }
                    textView6.setText(str);
                    d();
                }
                setData(a2Var.h0().f53941b, a2Var.h0().a(), a2Var.h0().f53947h, a2Var.h0().f53948i);
                return;
            } else {
                if (a2Var.b2()) {
                    this.f4378h.setVisibility(8);
                    this.f4377g.setVisibility(8);
                    this.f4379i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(a2Var.t1());
                } else {
                    this.k.setVisibility(8);
                    this.f4379i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.f4378h.setVisibility(0);
                    this.f4377g.setVisibility(0);
                }
                setData(a2Var.h0().f53941b, a2Var.h0().a(), a2Var.h0().f53947h, a2Var.h0().f53948i);
                if (a2Var.y()) {
                    if (a2Var.T() != null && !StringUtils.isNull(a2Var.T().getName_show())) {
                        this.f4377g.setText(a2Var.T().getName_show());
                    } else {
                        this.f4377g.setText(R.string.user_name_default_txt);
                    }
                    this.f4378h.setText(a2Var.t1());
                    return;
                }
                return;
            }
        }
        e();
    }
}
