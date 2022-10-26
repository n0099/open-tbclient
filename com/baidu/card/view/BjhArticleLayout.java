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
import com.baidu.tieba.a26;
import com.baidu.tieba.ar4;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.p26;
import com.baidu.tieba.xx;
import com.baidu.tieba.yx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BjhArticleLayout extends RelativeLayout implements xx, View.OnClickListener, yx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TbImageView c;
    public View d;
    public ar4 e;
    public float f;
    public float g;
    public float h;
    public p26 i;
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
        this.f = fj.f(context, R.dimen.tbds10);
        fj.f(context, R.dimen.tbds21);
        this.g = fj.f(context, R.dimen.tbds16);
        fj.f(context, R.dimen.tbds30);
        this.h = fj.f(context, R.dimen.tbds44);
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
            p26 p26Var = this.i;
            if (p26Var != null) {
                p26Var.a(view2, this.e);
            }
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public void setSubClickListener(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p26Var) == null) {
            this.i = p26Var;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d015c, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setId(R.id.obfuscated_res_0x7f0903a1);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092203);
            this.a = textView;
            nv4 d = nv4.d(textView);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            this.a.setOnClickListener(this);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090e14);
            this.b = textView2;
            textView2.setOnClickListener(this);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090721);
            this.c = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.c.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0903f9);
            this.d = findViewById;
            findViewById.setOnClickListener(this);
            if (this.c.getLayoutParams() != null) {
                this.c.getLayoutParams().height = (int) (((fj.k(getContext()) - (this.h * 2.0f)) / 16.0f) * 9.0f);
            }
            this.b.setTranslationY(-this.g);
            this.c.setDrawCorner(true);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X05);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx
    /* renamed from: c */
    public void a(ar4 ar4Var) {
        int i;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ar4Var) == null) {
            this.e = ar4Var;
            ThreadData threadData = ar4Var.getThreadData();
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
                this.c.L(threadData.getArticeCover(), 10, false);
            }
            TextView textView = this.a;
            String id = threadData.getId();
            if (this.c.getVisibility() == 0) {
                i = R.color.CAM_X0101;
            } else {
                i = R.color.CAM_X0105;
            }
            a26.l(textView, id, i, R.color.CAM_X0109);
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

    @Override // com.baidu.tieba.yx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            ar4 ar4Var = this.e;
            if (ar4Var != null && ar4Var.getThreadData() != null) {
                TextView textView = this.a;
                String id = this.e.getThreadData().getId();
                if (this.c.getVisibility() == 0) {
                    i2 = R.color.CAM_X0101;
                } else {
                    i2 = R.color.CAM_X0105;
                }
                a26.l(textView, id, i2, R.color.CAM_X0109);
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).defaultColorNotAutoChangeSkinType(R.color.CAM_X0606).radius(this.f).into(this.b);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinearNotAutoChangeSkinType(R.color.CAM_X0611, R.color.CAM_X0605).tlRadius(fj.f(getContext(), R.dimen.tbds21)).trRadius(fj.f(getContext(), R.dimen.tbds21)).blRadius(fj.f(getContext(), R.dimen.tbds21)).brRadius(fj.f(getContext(), R.dimen.tbds21)).setAlpha(128).into(this.d);
        }
    }
}
