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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.b.d;
import c.a.s0.b.g.b;
import c.a.s0.s.q.a2;
import c.a.s0.s.q.e2;
import c.a.s0.s.u.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f33144e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f33145f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33146g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33147h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f33148i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f33149j;
    public TextView k;
    public TextView l;
    public TextView m;
    public String n;
    public View.OnClickListener o;
    public int p;
    public e2 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
            this.f33144e = (BarImageView) findViewById(R.id.forum_head_image);
            this.f33145f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.f33146g = (TextView) findViewById(R.id.forum_head_info_attention);
            this.f33147h = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f33148i = (EMTextView) findViewById(R.id.forum_head_attention_status);
            this.f33149j = (EMTextView) findViewById(R.id.forum_recommend_reason);
            this.k = (TextView) findViewById(R.id.hot_rank_index);
            this.l = (TextView) findViewById(R.id.hot_rank_num);
            this.m = (TextView) findViewById(R.id.thread_extend_info);
            this.f33144e.setShowOval(true);
            this.f33144e.setAutoChangeStyle(true);
            this.f33144e.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f33144e.setStrokeColorResId(R.color.CAM_X0401);
            this.f33144e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f33145f.setOnClickListener(this);
            this.f33146g.setOnClickListener(this);
            this.f33147h.setOnClickListener(this);
            this.f33145f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f33145f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            onChangeSkinType();
        }
    }

    public final void b(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) || e2Var == null || e2Var.a0() == null || !e2Var.a2) {
            return;
        }
        String attentionStatus = e2Var.a0().getAttentionStatus();
        String recReason = e2Var.a0().getRecReason();
        if (d.p() && !StringUtils.isNull(attentionStatus)) {
            this.f33149j.setVisibility(8);
            this.f33148i.setVisibility(0);
            this.f33148i.setText(attentionStatus);
        } else if (d.q() && !StringUtils.isNull(recReason)) {
            this.f33146g.setVisibility(8);
            this.f33147h.setVisibility(8);
            this.f33148i.setVisibility(8);
            this.f33149j.setVisibility(0);
            this.f33149j.setText(recReason);
        } else if (d.r()) {
            if (!StringUtils.isNull(attentionStatus)) {
                this.f33148i.setVisibility(0);
                this.f33148i.setText(attentionStatus);
            } else {
                this.f33148i.setVisibility(8);
            }
            if (!StringUtils.isNull(recReason)) {
                this.f33146g.setVisibility(8);
                this.f33147h.setVisibility(8);
                this.f33149j.setVisibility(0);
                this.f33149j.setText(recReason);
            } else {
                this.f33149j.setVisibility(8);
            }
        } else {
            this.f33149j.setVisibility(8);
            this.f33148i.setVisibility(8);
            return;
        }
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this.f33148i);
            d2.n(R.string.J_X04);
            d2.v(R.color.CAM_X0108);
            d2.f(R.color.CAM_X0206);
            if (d.w0()) {
                if (this.f33149j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33149j.getLayoutParams();
                    marginLayoutParams.topMargin = n.f(getContext(), R.dimen.tbds8);
                    this.f33149j.setLayoutParams(marginLayoutParams);
                }
                this.f33149j.setPadding(0, 0, 0, 0);
                c d3 = c.d(this.f33149j);
                d3.v(R.color.CAM_X0316);
                d3.z(R.dimen.T_X09);
                d3.f(0);
                return;
            }
            if (this.f33149j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f33149j.getLayoutParams();
                marginLayoutParams2.topMargin = n.f(getContext(), R.dimen.tbds14);
                this.f33149j.setLayoutParams(marginLayoutParams2);
            }
            int f2 = n.f(getContext(), R.dimen.M_W_X002);
            this.f33149j.setPadding(f2, 0, f2, 0);
            c d4 = c.d(this.f33149j);
            d4.n(R.string.J_X04);
            d4.v(R.color.CAM_X0304);
            d4.z(R.dimen.T_X10);
            d4.f(R.color.CAM_X0905);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.g(this.f33145f);
        }
    }

    public final void e() {
        e2 e2Var;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (e2Var = this.q) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(e2Var.position + 1);
        this.k.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        e2 e2Var2 = this.q;
        if (e2Var2.h2) {
            if ("agree_num".equals(e2Var2.j2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
            } else if ("comment_num".equals(this.q.j2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
            } else {
                mutate = "share_num".equals(this.q.j2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
            }
        } else {
            mutate = SkinManager.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
        }
        int f2 = n.f(getContext(), R.dimen.tbds42);
        if (mutate == null) {
            return;
        }
        mutate.setBounds(0, 0, f2, f2);
        DrawableCompat.setTint(mutate, color);
        this.k.setCompoundDrawables(mutate, null, null, null);
        this.k.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.k, indexTextColorRes);
        SkinManager.setViewTextColor(this.l, indexTextColorRes);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f33144e.setVisibility(8);
            this.f33145f.setVisibility(8);
            this.f33147h.setVisibility(8);
            this.f33146g.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.p) {
            return;
        }
        this.p = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int f2 = n.f(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, f2, f2);
        this.f33145f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f33145f.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f33145f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f33146g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f33147h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        c();
        d();
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || StringUtils.isNull(this.n)) {
            return;
        }
        e2 e2Var = this.q;
        if (e2Var != null && e2Var.a2) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.n, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        View.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setData(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, str, str2, i2, i3) == null) {
            if (StringUtils.isNull(str)) {
                f();
                return;
            }
            this.f33144e.setPlaceHolder(1);
            this.f33144e.setVisibility(0);
            this.f33145f.setVisibility(0);
            this.n = str;
            this.f33145f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.n));
            this.f33144e.startLoad(str2, 10, false);
            this.f33147h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
            this.f33146g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
            b.f(this.f33145f);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f33144e.setOnClickListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 3;
        a(context);
    }

    public void setData(e2 e2Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, e2Var) == null) {
            this.q = e2Var;
            if (e2Var != null && e2Var.Z() != null) {
                if (e2Var.g2) {
                    this.f33147h.setVisibility(8);
                    this.f33146g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.l.setVisibility(0);
                    this.m.setVisibility(0);
                    this.m.setText(e2Var.q1());
                    int i2 = e2Var.F2;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    this.l.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    TextView textView = this.l;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i3 = e2Var.position + 1;
                    TextView textView2 = this.k;
                    if (i3 >= 10) {
                        str2 = String.valueOf(i3);
                    } else {
                        str2 = "0" + i3;
                    }
                    textView2.setText(str2);
                    e();
                    a2 Z = e2Var.Z();
                    this.f33144e.setPlaceHolder(1);
                    this.f33144e.setVisibility(0);
                    this.f33144e.startLoad(Z.b(), 10, false);
                    this.f33145f.setVisibility(0);
                    this.n = Z.f13459b;
                    this.f33145f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.n));
                    b.f(this.f33145f);
                } else if (e2Var.h2) {
                    this.m.setVisibility(8);
                    if (!"agree_num".equals(e2Var.j2) && !"comment_num".equals(e2Var.j2) && !"share_num".equals(e2Var.j2)) {
                        this.k.setVisibility(8);
                        this.l.setVisibility(8);
                    } else {
                        this.k.setVisibility(0);
                        this.l.setVisibility(0);
                        if ("agree_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.B() != null ? e2Var.B().agreeNum : 0L);
                            TextView textView3 = this.l;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.W0());
                            TextView textView4 = this.l;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.e1());
                            TextView textView5 = this.l;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i4 = e2Var.position + 1;
                        TextView textView6 = this.k;
                        if (i4 >= 10) {
                            str = String.valueOf(i4);
                        } else {
                            str = "0" + i4;
                        }
                        textView6.setText(str);
                        e();
                    }
                    setData(e2Var.Z().f13459b, e2Var.Z().b(), e2Var.Z().f13465h, e2Var.Z().f13466i);
                } else {
                    if (e2Var.b2()) {
                        this.f33147h.setVisibility(8);
                        this.f33146g.setVisibility(8);
                        this.k.setVisibility(8);
                        this.l.setVisibility(8);
                        this.m.setVisibility(0);
                        this.m.setText(e2Var.q1());
                    } else {
                        this.m.setVisibility(8);
                        this.k.setVisibility(8);
                        this.l.setVisibility(8);
                        this.f33147h.setVisibility(0);
                        this.f33146g.setVisibility(0);
                    }
                    setData(e2Var.Z().f13459b, e2Var.Z().b(), e2Var.Z().f13465h, e2Var.Z().f13466i);
                    if (e2Var.showWeakenName()) {
                        if (e2Var.J() != null && !StringUtils.isNull(e2Var.J().getName_show())) {
                            this.f33146g.setText(e2Var.J().getName_show());
                        } else {
                            this.f33146g.setText(R.string.user_name_default_txt);
                        }
                        this.f33147h.setText(e2Var.q1());
                    }
                }
                b(e2Var);
                return;
            }
            f();
        }
    }
}
