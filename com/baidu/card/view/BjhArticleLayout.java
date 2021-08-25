package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.l.p;
import c.a.l.q;
import c.a.p0.b.g.b;
import c.a.p0.s.q.a;
import c.a.p0.s.q.c2;
import c.a.p0.s.u.c;
import c.a.q0.a0.b0;
import c.a.q0.a0.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38504e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38505f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f38506g;

    /* renamed from: h  reason: collision with root package name */
    public View f38507h;

    /* renamed from: i  reason: collision with root package name */
    public a f38508i;

    /* renamed from: j  reason: collision with root package name */
    public float f38509j;
    public float k;
    public float l;
    public b0<a> m;
    public View.OnClickListener n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BjhArticleLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setId(R.id.bjh_content);
            TextView textView = (TextView) findViewById(R.id.title);
            this.f38504e = textView;
            c d2 = c.d(textView);
            d2.z(R.string.F_X01);
            d2.y(R.dimen.T_X06);
            this.f38504e.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.icon);
            this.f38505f = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
            this.f38506g = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f38506g.setOnClickListener(this);
            View findViewById = findViewById(R.id.bottom_mask);
            this.f38507h = findViewById;
            findViewById.setOnClickListener(this);
            if (this.f38506g.getLayoutParams() != null) {
                this.f38506g.getLayoutParams().height = (int) (((l.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
            }
            this.f38505f.setTranslationY(-this.k);
            this.f38506g.setDrawCorner(true);
            this.f38506g.setConrers(15);
            this.f38506g.setRadiusById(R.string.J_X05);
            b.m(this.f38504e, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38505f : (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38504e : (TextView) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            a aVar = this.f38508i;
            if (aVar != null && aVar.getThreadData() != null) {
                m.l(this.f38504e, this.f38508i.getThreadData().f0(), this.f38506g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.f38505f, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.f38509j).into(this.f38505f);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(l.g(getContext(), R.dimen.tbds21)).trRadius(l.g(getContext(), R.dimen.tbds21)).blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f38507h);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            View.OnClickListener onClickListener = this.n;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            b0<a> b0Var = this.m;
            if (b0Var != null) {
                b0Var.a(view, this.f38508i);
            }
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setSubClickListener(b0<a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b0Var) == null) {
            this.m = b0Var;
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
        this.f38509j = l.g(context, R.dimen.tbds10);
        l.g(context, R.dimen.tbds21);
        this.k = l.g(context, R.dimen.tbds16);
        l.g(context, R.dimen.tbds30);
        this.l = l.g(context, R.dimen.tbds44);
        a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f38508i = aVar;
            c2 threadData = aVar.getThreadData();
            if (threadData.w1 && (originalThreadInfo = threadData.v1) != null) {
                if (originalThreadInfo.m) {
                    setVisibility(8);
                    return;
                }
                threadData = originalThreadInfo.a();
            }
            this.f38504e.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.H())) {
                this.f38505f.setVisibility(8);
                this.f38506g.setVisibility(8);
                this.f38507h.setVisibility(8);
            } else {
                this.f38505f.setVisibility(0);
                this.f38506g.setVisibility(0);
                this.f38507h.setVisibility(0);
                this.f38506g.startLoad(threadData.H(), 10, false);
            }
            m.l(this.f38504e, threadData.f0(), this.f38506g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
