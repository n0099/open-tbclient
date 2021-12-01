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
import c.a.d.f.p.l;
import c.a.q0.b.g.b;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f33583e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f33584f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33585g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33586h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33587i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f33588j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f33589k;
    public String l;
    public View.OnClickListener m;
    public int n;
    public d2 o;

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
        this.n = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
            this.f33583e = (BarImageView) findViewById(R.id.forum_head_image);
            this.f33584f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.f33585g = (TextView) findViewById(R.id.forum_head_info_attention);
            this.f33586h = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f33587i = (TextView) findViewById(R.id.hot_rank_index);
            this.f33588j = (TextView) findViewById(R.id.hot_rank_num);
            this.f33589k = (TextView) findViewById(R.id.thread_extend_info);
            this.f33583e.setShowOval(true);
            this.f33583e.setAutoChangeStyle(true);
            this.f33583e.setStrokeWith(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f33583e.setStrokeColorResId(R.color.CAM_X0401);
            this.f33583e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f33584f.setOnClickListener(this);
            this.f33585g.setOnClickListener(this);
            this.f33586h.setOnClickListener(this);
            this.f33584f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f33584f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            onChangeSkinType();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.g(this.f33584f);
        }
    }

    public final void c() {
        d2 d2Var;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d2Var = this.o) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(d2Var.position + 1);
        this.f33587i.setCompoundDrawablePadding(l.f(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        d2 d2Var2 = this.o;
        if (d2Var2.i2) {
            if ("agree_num".equals(d2Var2.k2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
            } else if ("comment_num".equals(this.o.k2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
            } else {
                mutate = "share_num".equals(this.o.k2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
            }
        } else {
            mutate = SkinManager.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
        }
        int f2 = l.f(getContext(), R.dimen.tbds42);
        if (mutate == null) {
            return;
        }
        mutate.setBounds(0, 0, f2, f2);
        DrawableCompat.setTint(mutate, color);
        this.f33587i.setCompoundDrawables(mutate, null, null, null);
        this.f33587i.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.f33587i, indexTextColorRes);
        SkinManager.setViewTextColor(this.f33588j, indexTextColorRes);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f33583e.setVisibility(8);
            this.f33584f.setVisibility(8);
            this.f33586h.setVisibility(8);
            this.f33585g.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.n) {
            return;
        }
        this.n = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int f2 = l.f(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, f2, f2);
        this.f33584f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f33584f.setCompoundDrawablePadding(l.f(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f33584f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f33585g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f33586h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f33589k, R.color.CAM_X0109);
        b();
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || StringUtils.isNull(this.l)) {
            return;
        }
        d2 d2Var = this.o;
        if (d2Var != null && d2Var.b2) {
            TbSingleton.getInstance().saveHomeRecommendItemClickTime();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void setData(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2, i3) == null) {
            if (StringUtils.isNull(str)) {
                d();
                return;
            }
            this.f33583e.setPlaceHolder(1);
            this.f33583e.setVisibility(0);
            this.f33584f.setVisibility(0);
            this.l = str;
            this.f33584f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
            this.f33583e.startLoad(str2, 10, false);
            this.f33586h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
            this.f33585g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
            b.f(this.f33584f);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f33583e.setOnClickListener(this);
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
        this.n = 3;
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
        this.n = 3;
        a(context);
    }

    public void setData(d2 d2Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d2Var) == null) {
            this.o = d2Var;
            if (d2Var != null && d2Var.Z() != null) {
                if (d2Var.h2) {
                    this.f33586h.setVisibility(8);
                    this.f33585g.setVisibility(8);
                    this.f33587i.setVisibility(0);
                    this.f33588j.setVisibility(0);
                    this.f33589k.setVisibility(0);
                    this.f33589k.setText(d2Var.p1());
                    int i2 = d2Var.G2;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    this.f33588j.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    TextView textView = this.f33588j;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i3 = d2Var.position + 1;
                    TextView textView2 = this.f33587i;
                    if (i3 >= 10) {
                        str2 = String.valueOf(i3);
                    } else {
                        str2 = "0" + i3;
                    }
                    textView2.setText(str2);
                    c();
                    z1 Z = d2Var.Z();
                    this.f33583e.setPlaceHolder(1);
                    this.f33583e.setVisibility(0);
                    this.f33583e.startLoad(Z.b(), 10, false);
                    this.f33584f.setVisibility(0);
                    this.l = Z.f13108b;
                    this.f33584f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                    b.f(this.f33584f);
                    return;
                } else if (d2Var.i2) {
                    this.f33589k.setVisibility(8);
                    if (!"agree_num".equals(d2Var.k2) && !"comment_num".equals(d2Var.k2) && !"share_num".equals(d2Var.k2)) {
                        this.f33587i.setVisibility(8);
                        this.f33588j.setVisibility(8);
                    } else {
                        this.f33587i.setVisibility(0);
                        this.f33588j.setVisibility(0);
                        if ("agree_num".equals(d2Var.k2)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.B() != null ? d2Var.B().agreeNum : 0L);
                            TextView textView3 = this.f33588j;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(d2Var.k2)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.V0());
                            TextView textView4 = this.f33588j;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(d2Var.k2)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.d1());
                            TextView textView5 = this.f33588j;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i4 = d2Var.position + 1;
                        TextView textView6 = this.f33587i;
                        if (i4 >= 10) {
                            str = String.valueOf(i4);
                        } else {
                            str = "0" + i4;
                        }
                        textView6.setText(str);
                        c();
                    }
                    setData(d2Var.Z().f13108b, d2Var.Z().b(), d2Var.Z().f13114h, d2Var.Z().f13115i);
                    return;
                } else {
                    if (d2Var.a2()) {
                        this.f33586h.setVisibility(8);
                        this.f33585g.setVisibility(8);
                        this.f33587i.setVisibility(8);
                        this.f33588j.setVisibility(8);
                        this.f33589k.setVisibility(0);
                        this.f33589k.setText(d2Var.p1());
                    } else {
                        this.f33589k.setVisibility(8);
                        this.f33587i.setVisibility(8);
                        this.f33588j.setVisibility(8);
                        this.f33586h.setVisibility(0);
                        this.f33585g.setVisibility(0);
                    }
                    setData(d2Var.Z().f13108b, d2Var.Z().b(), d2Var.Z().f13114h, d2Var.Z().f13115i);
                    if (d2Var.showWeakenName()) {
                        if (d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
                            this.f33585g.setText(d2Var.J().getName_show());
                        } else {
                            this.f33585g.setText(R.string.user_name_default_txt);
                        }
                        this.f33586h.setText(d2Var.p1());
                        return;
                    }
                    return;
                }
            }
            d();
        }
    }
}
