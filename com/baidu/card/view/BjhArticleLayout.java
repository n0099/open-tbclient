package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.l.p;
import b.a.l.q;
import b.a.q0.b.g.b;
import b.a.q0.s.q.a;
import b.a.q0.s.q.d2;
import b.a.q0.s.u.c;
import b.a.r0.b0.d0;
import b.a.r0.b0.m;
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
/* loaded from: classes7.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37492e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37493f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f37494g;

    /* renamed from: h  reason: collision with root package name */
    public View f37495h;

    /* renamed from: i  reason: collision with root package name */
    public a f37496i;
    public float j;
    public float k;
    public float l;
    public d0<a> m;
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
            this.f37492e = textView;
            c d2 = c.d(textView);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            this.f37492e.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.icon);
            this.f37493f = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
            this.f37494g = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f37494g.setOnClickListener(this);
            View findViewById = findViewById(R.id.bottom_mask);
            this.f37495h = findViewById;
            findViewById.setOnClickListener(this);
            if (this.f37494g.getLayoutParams() != null) {
                this.f37494g.getLayoutParams().height = (int) (((l.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
            }
            this.f37493f.setTranslationY(-this.k);
            this.f37494g.setDrawCorner(true);
            this.f37494g.setConrers(15);
            this.f37494g.setRadiusById(R.string.J_X05);
            b.m(this.f37492e, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37493f : (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37492e : (TextView) invokeV.objValue;
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            a aVar = this.f37496i;
            if (aVar != null && aVar.getThreadData() != null) {
                m.l(this.f37492e, this.f37496i.getThreadData().f0(), this.f37494g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.f37493f, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.j).into(this.f37493f);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(l.g(getContext(), R.dimen.tbds21)).trRadius(l.g(getContext(), R.dimen.tbds21)).blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f37495h);
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
            d0<a> d0Var = this.m;
            if (d0Var != null) {
                d0Var.a(view, this.f37496i);
            }
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setSubClickListener(d0<a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d0Var) == null) {
            this.m = d0Var;
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
        a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f37496i = aVar;
            d2 threadData = aVar.getThreadData();
            if (threadData.z1 && (originalThreadInfo = threadData.y1) != null) {
                if (!originalThreadInfo.m && !threadData.N4()) {
                    threadData = threadData.y1.a();
                } else {
                    setVisibility(8);
                    return;
                }
            }
            this.f37492e.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.H())) {
                this.f37493f.setVisibility(8);
                this.f37494g.setVisibility(8);
                this.f37495h.setVisibility(8);
            } else {
                this.f37493f.setVisibility(0);
                this.f37494g.setVisibility(0);
                this.f37495h.setVisibility(0);
                this.f37494g.startLoad(threadData.H(), 10, false);
            }
            m.l(this.f37492e, threadData.f0(), this.f37494g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
