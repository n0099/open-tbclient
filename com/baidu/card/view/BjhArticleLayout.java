package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.l.q;
import c.a.o0.r.r.a;
import c.a.o0.r.v.c;
import c.a.p0.h0.b0;
import c.a.p0.h0.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25036b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f25037c;

    /* renamed from: d  reason: collision with root package name */
    public View f25038d;

    /* renamed from: e  reason: collision with root package name */
    public a f25039e;

    /* renamed from: f  reason: collision with root package name */
    public float f25040f;

    /* renamed from: g  reason: collision with root package name */
    public float f25041g;

    /* renamed from: h  reason: collision with root package name */
    public float f25042h;
    public b0<a> i;
    public View.OnClickListener j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BjhArticleLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d015b, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setId(R.id.obfuscated_res_0x7f090374);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09202b);
            this.a = textView;
            c d2 = c.d(textView);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            this.a.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090e06);
            this.f25036b = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09070a);
            this.f25037c = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f25037c.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0903cc);
            this.f25038d = findViewById;
            findViewById.setOnClickListener(this);
            if (this.f25037c.getLayoutParams() != null) {
                this.f25037c.getLayoutParams().height = (int) (((n.k(getContext()) - (this.f25042h * 2.0f)) / 16.0f) * 9.0f);
            }
            this.f25036b.setTranslationY(-this.f25041g);
            this.f25037c.setDrawCorner(true);
            this.f25037c.setConrers(15);
            this.f25037c.setRadiusById(R.string.J_X05);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: c */
    public void a(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f25039e = aVar;
            ThreadData threadData = aVar.getThreadData();
            if (threadData.isShareThread && (originalThreadInfo = threadData.originalThreadData) != null) {
                if (!originalThreadInfo.m && !threadData.shouldShowBlockedState()) {
                    threadData = threadData.originalThreadData.a();
                } else {
                    setVisibility(8);
                    return;
                }
            }
            this.a.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.getArticeCover())) {
                this.f25036b.setVisibility(8);
                this.f25037c.setVisibility(8);
                this.f25038d.setVisibility(8);
            } else {
                this.f25036b.setVisibility(0);
                this.f25037c.setVisibility(0);
                this.f25038d.setVisibility(0);
                this.f25037c.J(threadData.getArticeCover(), 10, false);
            }
            m.l(this.a, threadData.getId(), this.f25037c.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25036b : (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            a aVar = this.f25039e;
            if (aVar != null && aVar.getThreadData() != null) {
                m.l(this.a, this.f25039e.getThreadData().getId(), this.f25037c.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.f25036b, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.f25040f).into(this.f25036b);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(n.f(getContext(), R.dimen.tbds21)).trRadius(n.f(getContext(), R.dimen.tbds21)).blRadius(n.f(getContext(), R.dimen.tbds21)).brRadius(n.f(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f25038d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            b0<a> b0Var = this.i;
            if (b0Var != null) {
                b0Var.a(view, this.f25039e);
            }
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public void setSubClickListener(b0<a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b0Var) == null) {
            this.i = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BjhArticleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25040f = n.f(context, R.dimen.tbds10);
        n.f(context, R.dimen.tbds21);
        this.f25041g = n.f(context, R.dimen.tbds16);
        n.f(context, R.dimen.tbds30);
        this.f25042h = n.f(context, R.dimen.tbds44);
        b();
    }
}
