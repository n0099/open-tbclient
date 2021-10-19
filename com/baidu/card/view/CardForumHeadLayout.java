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
import c.a.e.e.p.l;
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
/* loaded from: classes5.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f38684e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f38685f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38686g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38687h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38688i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38689j;
    public TextView k;
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
            this.f38684e = (BarImageView) findViewById(R.id.forum_head_image);
            this.f38685f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.f38686g = (TextView) findViewById(R.id.forum_head_info_attention);
            this.f38687h = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f38688i = (TextView) findViewById(R.id.hot_rank_index);
            this.f38689j = (TextView) findViewById(R.id.hot_rank_num);
            this.k = (TextView) findViewById(R.id.thread_extend_info);
            this.f38684e.setShowOval(true);
            this.f38684e.setAutoChangeStyle(true);
            this.f38684e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f38684e.setStrokeColorResId(R.color.CAM_X0401);
            this.f38684e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f38685f.setOnClickListener(this);
            this.f38686g.setOnClickListener(this);
            this.f38687h.setOnClickListener(this);
            this.f38685f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f38685f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            onChangeSkinType();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.g(this.f38685f);
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
        this.f38688i.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        d2 d2Var2 = this.o;
        if (d2Var2.h2) {
            if ("agree_num".equals(d2Var2.i2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
            } else if ("comment_num".equals(this.o.i2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
            } else {
                mutate = "share_num".equals(this.o.i2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
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
        this.f38688i.setCompoundDrawables(mutate, null, null, null);
        this.f38688i.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.f38688i, indexTextColorRes);
        SkinManager.setViewTextColor(this.f38689j, indexTextColorRes);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38684e.setVisibility(8);
            this.f38685f.setVisibility(8);
            this.f38687h.setVisibility(8);
            this.f38686g.setVisibility(8);
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
        int g2 = l.g(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, g2, g2);
        this.f38685f.setCompoundDrawables(null, null, pureDrawable, null);
        this.f38685f.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f38685f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f38686g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f38687h, R.color.CAM_X0109);
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
        d2 d2Var = this.o;
        if (d2Var != null && d2Var.a2) {
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
            this.f38684e.setPlaceHolder(1);
            this.f38684e.setVisibility(0);
            this.f38685f.setVisibility(0);
            this.l = str;
            this.f38685f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
            this.f38684e.startLoad(str2, 10, false);
            this.f38687h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
            this.f38686g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
            b.f(this.f38685f);
        }
    }

    public void setOnClickListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f38684e.setOnClickListener(this);
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
            if (d2Var != null && d2Var.Y() != null) {
                if (d2Var.g2) {
                    this.f38687h.setVisibility(8);
                    this.f38686g.setVisibility(8);
                    this.f38688i.setVisibility(0);
                    this.f38689j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(d2Var.m1());
                    int i2 = d2Var.D2;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    this.f38689j.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    TextView textView = this.f38689j;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i3 = d2Var.position + 1;
                    TextView textView2 = this.f38688i;
                    if (i3 >= 10) {
                        str2 = String.valueOf(i3);
                    } else {
                        str2 = "0" + i3;
                    }
                    textView2.setText(str2);
                    c();
                    z1 Y = d2Var.Y();
                    this.f38684e.setPlaceHolder(1);
                    this.f38684e.setVisibility(0);
                    this.f38684e.startLoad(Y.b(), 10, false);
                    this.f38685f.setVisibility(0);
                    this.l = Y.f14394b;
                    this.f38685f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                    b.f(this.f38685f);
                    return;
                } else if (d2Var.h2) {
                    this.k.setVisibility(8);
                    if (!"agree_num".equals(d2Var.i2) && !"comment_num".equals(d2Var.i2) && !"share_num".equals(d2Var.i2)) {
                        this.f38688i.setVisibility(8);
                        this.f38689j.setVisibility(8);
                    } else {
                        this.f38688i.setVisibility(0);
                        this.f38689j.setVisibility(0);
                        if ("agree_num".equals(d2Var.i2)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.B() != null ? d2Var.B().agreeNum : 0L);
                            TextView textView3 = this.f38689j;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(d2Var.i2)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.U0());
                            TextView textView4 = this.f38689j;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(d2Var.i2)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(d2Var.b1());
                            TextView textView5 = this.f38689j;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i4 = d2Var.position + 1;
                        TextView textView6 = this.f38688i;
                        if (i4 >= 10) {
                            str = String.valueOf(i4);
                        } else {
                            str = "0" + i4;
                        }
                        textView6.setText(str);
                        c();
                    }
                    setData(d2Var.Y().f14394b, d2Var.Y().b(), d2Var.Y().f14400h, d2Var.Y().f14401i);
                    return;
                } else {
                    if (d2Var.X1()) {
                        this.f38687h.setVisibility(8);
                        this.f38686g.setVisibility(8);
                        this.f38688i.setVisibility(8);
                        this.f38689j.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setText(d2Var.m1());
                    } else {
                        this.k.setVisibility(8);
                        this.f38688i.setVisibility(8);
                        this.f38689j.setVisibility(8);
                        this.f38687h.setVisibility(0);
                        this.f38686g.setVisibility(0);
                    }
                    setData(d2Var.Y().f14394b, d2Var.Y().b(), d2Var.Y().f14400h, d2Var.Y().f14401i);
                    if (d2Var.showWeakenName()) {
                        if (d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
                            this.f38686g.setText(d2Var.J().getName_show());
                        } else {
                            this.f38686g.setText(R.string.user_name_default_txt);
                        }
                        this.f38687h.setText(d2Var.m1());
                        return;
                    }
                    return;
                }
            }
            d();
        }
    }
}
