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
import c.a.q0.r.r.a;
import c.a.q0.r.r.e2;
import c.a.q0.r.v.c;
import c.a.r0.f0.b0;
import c.a.r0.f0.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
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
/* loaded from: classes4.dex */
public class BjhArticleLayout extends RelativeLayout implements p<a>, View.OnClickListener, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31747e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f31748f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f31749g;

    /* renamed from: h  reason: collision with root package name */
    public View f31750h;

    /* renamed from: i  reason: collision with root package name */
    public a f31751i;

    /* renamed from: j  reason: collision with root package name */
    public float f31752j;
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
            this.f31747e = textView;
            c d2 = c.d(textView);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            this.f31747e.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.icon);
            this.f31748f = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
            this.f31749g = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.f31749g.setOnClickListener(this);
            View findViewById = findViewById(R.id.bottom_mask);
            this.f31750h = findViewById;
            findViewById.setOnClickListener(this);
            if (this.f31749g.getLayoutParams() != null) {
                this.f31749g.getLayoutParams().height = (int) (((n.k(getContext()) - (this.l * 2.0f)) / 16.0f) * 9.0f);
            }
            this.f31748f.setTranslationY(-this.k);
            this.f31749g.setDrawCorner(true);
            this.f31749g.setConrers(15);
            this.f31749g.setRadiusById(R.string.J_X05);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.f31747e, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31748f : (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31747e : (TextView) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            a aVar = this.f31751i;
            if (aVar != null && aVar.getThreadData() != null) {
                m.l(this.f31747e, this.f31751i.getThreadData().h0(), this.f31749g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.f31748f, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.f31752j).into(this.f31748f);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(n.f(getContext(), R.dimen.tbds21)).trRadius(n.f(getContext(), R.dimen.tbds21)).blRadius(n.f(getContext(), R.dimen.tbds21)).brRadius(n.f(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.f31750h);
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
                b0Var.a(view, this.f31751i);
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
        this.f31752j = n.f(context, R.dimen.tbds10);
        n.f(context, R.dimen.tbds21);
        this.k = n.f(context, R.dimen.tbds16);
        n.f(context, R.dimen.tbds30);
        this.l = n.f(context, R.dimen.tbds44);
        a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(a aVar) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f31751i = aVar;
            e2 threadData = aVar.getThreadData();
            if (threadData.A1 && (originalThreadInfo = threadData.z1) != null) {
                if (!originalThreadInfo.m && !threadData.Q4()) {
                    threadData = threadData.z1.a();
                } else {
                    setVisibility(8);
                    return;
                }
            }
            this.f31747e.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.H())) {
                this.f31748f.setVisibility(8);
                this.f31749g.setVisibility(8);
                this.f31750h.setVisibility(8);
            } else {
                this.f31748f.setVisibility(0);
                this.f31749g.setVisibility(0);
                this.f31750h.setVisibility(0);
                this.f31749g.startLoad(threadData.H(), 10, false);
            }
            m.l(this.f31747e, threadData.h0(), this.f31749g.getVisibility() == 0 ? R.color.CAM_X0101 : R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
