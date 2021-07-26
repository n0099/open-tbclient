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
import d.a.d.e.p.l;
import d.a.p0.b.d;
import d.a.p0.b.g.b;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.x1;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BarImageView f4436e;

    /* renamed from: f  reason: collision with root package name */
    public SingleLineEllipsizeTextView f4437f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4438g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4439h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4440i;
    public TextView j;
    public TextView k;
    public String l;
    public View.OnClickListener m;
    public int n;
    public b2 o;

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

    private void setHomePageRightSuffixDrawableStyleAb(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, textView) == null) && textView != null && d.n()) {
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0107), null);
            pureDrawable.setBounds(0, 0, g2, g2);
            textView.setCompoundDrawables(null, null, pureDrawable, null);
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
            this.f4436e = (BarImageView) findViewById(R.id.forum_head_image);
            this.f4437f = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
            this.f4438g = (TextView) findViewById(R.id.forum_head_info_attention);
            this.f4439h = (TextView) findViewById(R.id.forum_head_info_thread);
            this.f4440i = (TextView) findViewById(R.id.hot_rank_index);
            this.j = (TextView) findViewById(R.id.hot_rank_num);
            this.k = (TextView) findViewById(R.id.thread_extend_info);
            this.f4436e.setShowOval(true);
            this.f4436e.setAutoChangeStyle(true);
            this.f4436e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4436e.setStrokeColorResId(R.color.CAM_X0401);
            this.f4436e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f4436e.setOnClickListener(this);
            this.f4437f.setOnClickListener(this);
            this.f4438g.setOnClickListener(this);
            this.f4439h.setOnClickListener(this);
            this.f4437f.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            this.f4437f.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.n) {
            return;
        }
        this.n = skinType;
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
        int g2 = l.g(getContext(), R.dimen.tbds42);
        pureDrawable.setBounds(0, 0, g2, g2);
        this.f4437f.setCompoundDrawables(null, null, pureDrawable, null);
        setHomePageRightSuffixDrawableStyleAb(this.f4437f);
        this.f4437f.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        SkinManager.setViewTextColor(this.f4437f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f4438g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f4439h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.g(this.f4437f);
        }
    }

    public final void d() {
        b2 b2Var;
        Drawable mutate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b2Var = this.o) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(b2Var.position + 1);
        this.f4440i.setCompoundDrawablePadding(l.g(getContext(), R.dimen.M_W_X002));
        int color = SkinManager.getColor(indexTextColorRes);
        b2 b2Var2 = this.o;
        if (b2Var2.d2) {
            if ("agree_num".equals(b2Var2.e2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
            } else if ("comment_num".equals(this.o.e2)) {
                mutate = SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
            } else {
                mutate = "share_num".equals(this.o.e2) ? SkinManager.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
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
        this.f4440i.setCompoundDrawables(mutate, null, null, null);
        this.f4440i.setBackgroundDrawable(null);
        SkinManager.setViewTextColor(this.f4440i, indexTextColorRes);
        SkinManager.setViewTextColor(this.j, indexTextColorRes);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f4436e.setVisibility(8);
            this.f4437f.setVisibility(8);
            this.f4439h.setVisibility(8);
            this.f4438g.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || StringUtils.isNull(this.l)) {
            return;
        }
        b2 b2Var = this.o;
        if (b2Var != null && b2Var.W1) {
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
                e();
                return;
            }
            this.f4436e.setPlaceHolder(1);
            this.f4436e.setVisibility(0);
            this.f4437f.setVisibility(0);
            this.l = str;
            this.f4437f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
            this.f4436e.M(str2, 10, false);
            this.f4439h.setText(String.format(getContext().getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtra(i2)));
            this.f4438g.setText(String.format(getContext().getString(R.string.concern), StringHelper.numberUniformFormatExtra(i3)));
            b.f(this.f4437f);
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

    public void setData(b2 b2Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) {
            this.o = b2Var;
            if (b2Var != null && b2Var.W() != null) {
                if (b2Var.c2) {
                    this.f4439h.setVisibility(8);
                    this.f4438g.setVisibility(8);
                    this.f4440i.setVisibility(0);
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(b2Var.i1());
                    int i2 = b2Var.z2;
                    if (i2 < 1000) {
                        i2 = 1000;
                    }
                    this.j.setVisibility(0);
                    String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    TextView textView = this.j;
                    textView.setText(textView.getContext().getResources().getString(R.string.thread_rank_tag, numberUniformFormatExtraWithRoundInt));
                    int i3 = b2Var.position + 1;
                    TextView textView2 = this.f4440i;
                    if (i3 >= 10) {
                        str2 = String.valueOf(i3);
                    } else {
                        str2 = "0" + i3;
                    }
                    textView2.setText(str2);
                    d();
                    x1 W = b2Var.W();
                    this.f4436e.setPlaceHolder(1);
                    this.f4436e.setVisibility(0);
                    this.f4436e.M(W.a(), 10, false);
                    this.f4437f.setVisibility(0);
                    this.l = W.f53479b;
                    this.f4437f.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.l));
                    b.f(this.f4437f);
                    return;
                } else if (b2Var.d2) {
                    this.k.setVisibility(8);
                    if (!"agree_num".equals(b2Var.e2) && !"comment_num".equals(b2Var.e2) && !"share_num".equals(b2Var.e2)) {
                        this.f4440i.setVisibility(8);
                        this.j.setVisibility(8);
                    } else {
                        this.f4440i.setVisibility(0);
                        this.j.setVisibility(0);
                        if ("agree_num".equals(b2Var.e2)) {
                            String numberUniformFormatExtraWithRoundInt2 = StringHelper.numberUniformFormatExtraWithRoundInt(b2Var.z() != null ? b2Var.z().agreeNum : 0L);
                            TextView textView3 = this.j;
                            textView3.setText(textView3.getContext().getResources().getString(R.string.thread_like_rank_tag, numberUniformFormatExtraWithRoundInt2));
                        } else if ("comment_num".equals(b2Var.e2)) {
                            String numberUniformFormatExtraWithRoundInt3 = StringHelper.numberUniformFormatExtraWithRoundInt(b2Var.Q0());
                            TextView textView4 = this.j;
                            textView4.setText(textView4.getContext().getResources().getString(R.string.thread_discuss_rank_tag, numberUniformFormatExtraWithRoundInt3));
                        } else if ("share_num".equals(b2Var.e2)) {
                            String numberUniformFormatExtraWithRoundInt4 = StringHelper.numberUniformFormatExtraWithRoundInt(b2Var.X0());
                            TextView textView5 = this.j;
                            textView5.setText(textView5.getContext().getResources().getString(R.string.thread_spread_rank_tag, numberUniformFormatExtraWithRoundInt4));
                        }
                        int i4 = b2Var.position + 1;
                        TextView textView6 = this.f4440i;
                        if (i4 >= 10) {
                            str = String.valueOf(i4);
                        } else {
                            str = "0" + i4;
                        }
                        textView6.setText(str);
                        d();
                    }
                    setData(b2Var.W().f53479b, b2Var.W().a(), b2Var.W().f53485h, b2Var.W().f53486i);
                    return;
                } else {
                    if (b2Var.P1()) {
                        this.f4439h.setVisibility(8);
                        this.f4438g.setVisibility(8);
                        this.f4440i.setVisibility(8);
                        this.j.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setText(b2Var.i1());
                    } else {
                        this.k.setVisibility(8);
                        this.f4440i.setVisibility(8);
                        this.j.setVisibility(8);
                        this.f4439h.setVisibility(0);
                        this.f4438g.setVisibility(0);
                    }
                    setData(b2Var.W().f53479b, b2Var.W().a(), b2Var.W().f53485h, b2Var.W().f53486i);
                    if (b2Var.showWeakenName()) {
                        if (b2Var.H() != null && !StringUtils.isNull(b2Var.H().getName_show())) {
                            this.f4438g.setText(b2Var.H().getName_show());
                        } else {
                            this.f4438g.setText(R.string.user_name_default_txt);
                        }
                        this.f4439h.setText(b2Var.i1());
                        return;
                    }
                    return;
                }
            }
            e();
        }
    }
}
