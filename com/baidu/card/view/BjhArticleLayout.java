package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
import d.a.k.p;
import d.a.k.q;
import d.a.p0.b.g.b;
import d.a.p0.s.q.a;
import d.a.p0.s.q.b2;
import d.a.p0.s.u.c;
import d.a.q0.a0.b0;
import d.a.q0.a0.m;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4431e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4432f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f4433g;

    /* renamed from: h  reason: collision with root package name */
    public View f4434h;

    /* renamed from: i  reason: collision with root package name */
    public a f4435i;
    public float j;
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setId(R.id.bjh_content);
            TextView textView = (TextView) findViewById(R.id.title);
            this.f4431e = textView;
            c d2 = c.d(textView);
            d2.y(R.string.F_X01);
            d2.x(R.dimen.T_X06);
            this.f4431e.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.icon);
            this.f4432f = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
            this.f4433g = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f4433g.setOnClickListener(this);
            View findViewById = findViewById(R.id.bottom_mask);
            this.f4434h = findViewById;
            findViewById.setOnClickListener(this);
            if (this.f4433g.getLayoutParams() != null) {
                this.f4433g.getLayoutParams().height = (int) (((l.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
            }
            this.f4432f.setTranslationY(-this.k);
            this.f4433g.setDrawCorner(true);
            this.f4433g.setConrers(15);
            this.f4433g.setRadiusById(R.string.J_X05);
            b.m(this.f4431e, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: c */
    public void a(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f4435i = aVar;
            b2 threadData = aVar.getThreadData();
            if (threadData.v1 && (originalThreadInfo = threadData.u1) != null) {
                if (originalThreadInfo.m) {
                    setVisibility(8);
                    return;
                }
                threadData = originalThreadInfo.a();
            }
            this.f4431e.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.F())) {
                this.f4432f.setVisibility(8);
                this.f4433g.setVisibility(8);
                this.f4434h.setVisibility(8);
            } else {
                this.f4432f.setVisibility(0);
                this.f4433g.setVisibility(0);
                this.f4434h.setVisibility(0);
                this.f4433g.M(threadData.F(), 10, false);
            }
            m.l(this.f4431e, threadData.d0(), this.f4433g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4432f : (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4431e : (TextView) invokeV.objValue;
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            a aVar = this.f4435i;
            if (aVar != null && aVar.getThreadData() != null) {
                m.l(this.f4431e, this.f4435i.getThreadData().d0(), this.f4433g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.f4432f, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.j).into(this.f4432f);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(l.g(getContext(), R.dimen.tbds21)).trRadius(l.g(getContext(), R.dimen.tbds21)).blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f4434h);
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
                b0Var.a(view, this.f4435i);
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
        this.j = l.g(context, R.dimen.tbds10);
        l.g(context, R.dimen.tbds21);
        this.k = l.g(context, R.dimen.tbds16);
        l.g(context, R.dimen.tbds30);
        this.l = l.g(context, R.dimen.tbds44);
        b();
    }
}
