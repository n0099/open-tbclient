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
import c.a.s0.b.g.b;
import c.a.s0.s.q.a2;
import c.a.s0.s.q.e2;
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
/* loaded from: classes10.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f33116e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f33117f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33118g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33119h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33120i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f33121j;
    public TextView k;
    public String l;
    public View.OnClickListener m;
    public int n;
    public e2 o;

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
            this.f33116e = (BarImageView) findViewById(R.id.forum_head_image);
            this.f33117f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.f33118g = (TextView) findViewById(R.id.forum_head_info_attention);
            this.f33119h = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f33120i = (TextView) findViewById(R.id.hot_rank_index);
            this.f33121j = (TextView) findViewById(R.id.hot_rank_num);
            this.k = (TextView) findViewById(R.id.thread_extend_info);
            this.f33116e.setShowOval(true);
            this.f33116e.setAutoChangeStyle(true);
            this.f33116e.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f33116e.setStrokeColorResId(R.color.CAM_X0401);
            this.f33116e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f33117f.setOnClickListener(this);
            this.f33118g.setOnClickListener(this);
            this.f33119h.setOnClickListener(this);
            this.f33117f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f33117f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            onChangeSkinType();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.g(this.f33117f);
        }
    }

    public final void c() {
        e2 e2Var;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (e2Var = this.o) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(e2Var.position + 1);
        this.f33120i.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        e2 e2Var2 = this.o;
        if (e2Var2.h2) {
            if ("agree_num".equals(e2Var2.j2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
            } else if ("comment_num".equals(this.o.j2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
            } else {
                mutate = "share_num".equals(this.o.j2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
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
        this.f33120i.setCompoundDrawables(mutate, null, null, null);
        this.f33120i.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.f33120i, indexTextColorRes);
        SkinManager.setViewTextColor(this.f33121j, indexTextColorRes);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f33116e.setVisibility(8);
            this.f33117f.setVisibility(8);
            this.f33119h.setVisibility(8);
            this.f33118g.setVisibility(8);
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
        int f2 = n.f(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, f2, f2);
        this.f33117f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f33117f.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f33117f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f33118g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f33119h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        b();
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || StringUtils.isNull(this.l)) {
            return;
        }
        e2 e2Var = this.o;
        if (e2Var != null && e2Var.a2) {
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
            this.f33116e.setPlaceHolder(1);
            this.f33116e.setVisibility(0);
            this.f33117f.setVisibility(0);
            this.l = str;
            this.f33117f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
            this.f33116e.startLoad(str2, 10, false);
            this.f33119h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
            this.f33118g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
            b.f(this.f33117f);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f33116e.setOnClickListener(this);
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

    public void setData(e2 e2Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e2Var) == null) {
            this.o = e2Var;
            if (e2Var != null && e2Var.Z() != null) {
                if (e2Var.g2) {
                    this.f33119h.setVisibility(8);
                    this.f33118g.setVisibility(8);
                    this.f33120i.setVisibility(0);
                    this.f33121j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(e2Var.p1());
                    int i2 = e2Var.F2;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    this.f33121j.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    TextView textView = this.f33121j;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i3 = e2Var.position + 1;
                    TextView textView2 = this.f33120i;
                    if (i3 >= 10) {
                        str2 = String.valueOf(i3);
                    } else {
                        str2 = "0" + i3;
                    }
                    textView2.setText(str2);
                    c();
                    a2 Z = e2Var.Z();
                    this.f33116e.setPlaceHolder(1);
                    this.f33116e.setVisibility(0);
                    this.f33116e.startLoad(Z.b(), 10, false);
                    this.f33117f.setVisibility(0);
                    this.l = Z.f13273b;
                    this.f33117f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                    b.f(this.f33117f);
                    return;
                } else if (e2Var.h2) {
                    this.k.setVisibility(8);
                    if (!"agree_num".equals(e2Var.j2) && !"comment_num".equals(e2Var.j2) && !"share_num".equals(e2Var.j2)) {
                        this.f33120i.setVisibility(8);
                        this.f33121j.setVisibility(8);
                    } else {
                        this.f33120i.setVisibility(0);
                        this.f33121j.setVisibility(0);
                        if ("agree_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.B() != null ? e2Var.B().agreeNum : 0L);
                            TextView textView3 = this.f33121j;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.V0());
                            TextView textView4 = this.f33121j;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(e2Var.j2)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(e2Var.d1());
                            TextView textView5 = this.f33121j;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i4 = e2Var.position + 1;
                        TextView textView6 = this.f33120i;
                        if (i4 >= 10) {
                            str = String.valueOf(i4);
                        } else {
                            str = "0" + i4;
                        }
                        textView6.setText(str);
                        c();
                    }
                    setData(e2Var.Z().f13273b, e2Var.Z().b(), e2Var.Z().f13279h, e2Var.Z().f13280i);
                    return;
                } else {
                    if (e2Var.a2()) {
                        this.f33119h.setVisibility(8);
                        this.f33118g.setVisibility(8);
                        this.f33120i.setVisibility(8);
                        this.f33121j.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setText(e2Var.p1());
                    } else {
                        this.k.setVisibility(8);
                        this.f33120i.setVisibility(8);
                        this.f33121j.setVisibility(8);
                        this.f33119h.setVisibility(0);
                        this.f33118g.setVisibility(0);
                    }
                    setData(e2Var.Z().f13273b, e2Var.Z().b(), e2Var.Z().f13279h, e2Var.Z().f13280i);
                    if (e2Var.showWeakenName()) {
                        if (e2Var.J() != null && !StringUtils.isNull(e2Var.J().getName_show())) {
                            this.f33118g.setText(e2Var.J().getName_show());
                        } else {
                            this.f33118g.setText(R.string.user_name_default_txt);
                        }
                        this.f33119h.setText(e2Var.p1());
                        return;
                    }
                    return;
                }
            }
            d();
        }
    }
}
