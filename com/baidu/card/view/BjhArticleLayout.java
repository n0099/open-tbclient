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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cx4;
import com.baidu.tieba.fs4;
import com.baidu.tieba.l86;
import com.baidu.tieba.ux;
import com.baidu.tieba.vx;
import com.baidu.tieba.z86;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BjhArticleLayout extends RelativeLayout implements ux<fs4>, View.OnClickListener, vx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TbImageView c;
    public View d;
    public fs4 e;
    public float f;
    public float g;
    public float h;
    public z86<fs4> i;
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
        this.f = zi.g(context, R.dimen.tbds10);
        zi.g(context, R.dimen.tbds21);
        this.g = zi.g(context, R.dimen.tbds16);
        zi.g(context, R.dimen.tbds30);
        this.h = zi.g(context, R.dimen.tbds44);
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            z86<fs4> z86Var = this.i;
            if (z86Var != null) {
                z86Var.a(view2, this.e);
            }
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public void setSubClickListener(z86<fs4> z86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z86Var) == null) {
            this.i = z86Var;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.bjh_article_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setId(R.id.bjh_content);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0922ff);
            this.a = textView;
            cx4 d = cx4.d(textView);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            this.a.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090ea0);
            this.b = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.cover_img);
            this.c = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.c.setOnClickListener(this);
            View findViewById = findViewById(R.id.bottom_mask);
            this.d = findViewById;
            findViewById.setOnClickListener(this);
            if (this.c.getLayoutParams() != null) {
                this.c.getLayoutParams().height = (int) (((zi.l(getContext()) - (this.h * 2.0f)) / 16.0f) * 9.0f);
            }
            this.b.setTranslationY(-this.g);
            this.c.setDrawCorner(true);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X05);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: c */
    public void a(fs4 fs4Var) {
        int i;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fs4Var) == null) {
            this.e = fs4Var;
            ThreadData threadData = fs4Var.getThreadData();
            if (threadData.isShareThread && (originalThreadInfo = threadData.originalThreadData) != null) {
                if (!originalThreadInfo.m && !threadData.shouldShowBlockedState()) {
                    threadData = threadData.originalThreadData.b();
                } else {
                    setVisibility(8);
                    return;
                }
            }
            this.a.setText(threadData.getTitle());
            if (StringUtils.isNull(threadData.getArticeCover())) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.c.K(threadData.getArticeCover(), 10, false);
            }
            TextView textView = this.a;
            String id = threadData.getId();
            if (this.c.getVisibility() == 0) {
                i = R.color.CAM_X0101;
            } else {
                i = R.color.CAM_X0105;
            }
            l86.l(textView, id, i, R.color.CAM_X0109);
        }
    }

    public TextView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            fs4 fs4Var = this.e;
            if (fs4Var != null && fs4Var.getThreadData() != null) {
                TextView textView = this.a;
                String id = this.e.getThreadData().getId();
                if (this.c.getVisibility() == 0) {
                    i2 = R.color.CAM_X0101;
                } else {
                    i2 = R.color.CAM_X0105;
                }
                l86.l(textView, id, i2, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.f).into(this.b);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(zi.g(getContext(), R.dimen.tbds21)).trRadius(zi.g(getContext(), R.dimen.tbds21)).blRadius(zi.g(getContext(), R.dimen.tbds21)).brRadius(zi.g(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.d);
        }
    }
}
