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
import d.b.c.e.p.l;
import d.b.h0.b.g.b;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w1;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f4420e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f4421f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4422g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4423h;
    public TextView i;
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
        this.f4420e = (BarImageView) findViewById(R.id.forum_head_image);
        this.f4421f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.f4422g = (TextView) findViewById(R.id.forum_head_info_attention);
        this.f4423h = (TextView) findViewById(R.id.forum_head_info_thread);
        this.i = (TextView) findViewById(R.id.hot_rank_index);
        this.j = (TextView) findViewById(R.id.hot_rank_num);
        this.k = (TextView) findViewById(R.id.thread_extend_info);
        this.f4420e.setShowOval(true);
        this.f4420e.setAutoChangeStyle(true);
        this.f4420e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f4420e.setStrokeColorResId(R.color.CAM_X0401);
        this.f4420e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f4420e.setOnClickListener(this);
        this.f4421f.setOnClickListener(this);
        this.f4422g.setOnClickListener(this);
        this.f4423h.setOnClickListener(this);
        this.f4421f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.f4421f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
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
        this.f4421f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f4421f.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f4421f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f4422g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f4423h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        c();
        d();
    }

    public final void c() {
        b.e(this.f4421f);
    }

    public final void d() {
        Drawable mutate;
        a2 a2Var = this.o;
        if (a2Var != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(a2Var.position + 1);
            this.i.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
            int color = SkinManager.getColor(indexTextColorRes);
            a2 a2Var2 = this.o;
            if (a2Var2.Z1) {
                if ("agree_num".equals(a2Var2.a2)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.o.a2)) {
                    mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else {
                    mutate = "share_num".equals(this.o.a2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
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
            this.i.setCompoundDrawables(mutate, null, null, null);
            this.i.setBackgroundDrawable(null);
            SkinManager.setViewTextColor(this.i, indexTextColorRes);
            SkinManager.setViewTextColor(this.j, indexTextColorRes);
        }
    }

    public final void e() {
        this.f4420e.setVisibility(8);
        this.f4421f.setVisibility(8);
        this.f4423h.setVisibility(8);
        this.f4422g.setVisibility(8);
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

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            e();
            return;
        }
        this.f4420e.setPlaceHolder(1);
        this.f4420e.setVisibility(0);
        this.f4421f.setVisibility(0);
        this.l = str;
        this.f4421f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
        this.f4420e.W(str2, 10, false);
        this.f4423h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i)));
        this.f4422g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i2)));
        b.d(this.f4421f);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 3;
        a(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 3;
        a(context);
    }

    public void setData(a2 a2Var) {
        String str;
        String str2;
        this.o = a2Var;
        if (a2Var != null && a2Var.h0() != null) {
            if (a2Var.Y1) {
                this.f4423h.setVisibility(8);
                this.f4422g.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setText(a2Var.r1());
                int i = a2Var.v2;
                if (i < 1000) {
                    i = 1000;
                }
                this.j.setVisibility(0);
                String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
                TextView textView = this.j;
                textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                int i2 = a2Var.position + 1;
                TextView textView2 = this.i;
                if (i2 >= 10) {
                    str2 = String.valueOf(i2);
                } else {
                    str2 = "0" + i2;
                }
                textView2.setText(str2);
                d();
                w1 h0 = a2Var.h0();
                this.f4420e.setPlaceHolder(1);
                this.f4420e.setVisibility(0);
                this.f4420e.W(h0.a(), 10, false);
                this.f4421f.setVisibility(0);
                this.l = h0.f51324b;
                this.f4421f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                b.d(this.f4421f);
                return;
            } else if (a2Var.Z1) {
                this.k.setVisibility(8);
                if (!"agree_num".equals(a2Var.a2) && !"comment_num".equals(a2Var.a2) && !"share_num".equals(a2Var.a2)) {
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                    this.j.setVisibility(0);
                    if ("agree_num".equals(a2Var.a2)) {
                        String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.L() != null ? a2Var.L().agreeNum : 0L);
                        TextView textView3 = this.j;
                        textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                    } else if ("comment_num".equals(a2Var.a2)) {
                        String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.Z0());
                        TextView textView4 = this.j;
                        textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                    } else if ("share_num".equals(a2Var.a2)) {
                        String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(a2Var.g1());
                        TextView textView5 = this.j;
                        textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                    }
                    int i3 = a2Var.position + 1;
                    TextView textView6 = this.i;
                    if (i3 >= 10) {
                        str = String.valueOf(i3);
                    } else {
                        str = "0" + i3;
                    }
                    textView6.setText(str);
                    d();
                }
                setData(a2Var.h0().f51324b, a2Var.h0().a(), a2Var.h0().f51330h, a2Var.h0().i);
                return;
            } else {
                if (a2Var.Y1()) {
                    this.f4423h.setVisibility(8);
                    this.f4422g.setVisibility(8);
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(a2Var.r1());
                } else {
                    this.k.setVisibility(8);
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                    this.f4423h.setVisibility(0);
                    this.f4422g.setVisibility(0);
                }
                setData(a2Var.h0().f51324b, a2Var.h0().a(), a2Var.h0().f51330h, a2Var.h0().i);
                if (a2Var.y()) {
                    if (a2Var.T() != null && !StringUtils.isNull(a2Var.T().getName_show())) {
                        this.f4422g.setText(a2Var.T().getName_show());
                    } else {
                        this.f4422g.setText(R.string.user_name_default_txt);
                    }
                    this.f4423h.setText(a2Var.r1());
                    return;
                }
                return;
            }
        }
        e();
    }
}
