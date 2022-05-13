package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f9;
import com.repackage.mi;
import com.repackage.mo4;
import com.repackage.ms4;
import com.repackage.no4;
import com.repackage.ns4;
import com.repackage.os4;
import com.repackage.oy;
import com.repackage.ps4;
import com.repackage.py;
import com.repackage.sm4;
import java.util.List;
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements py, oy<no4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<mo4> a;
    public List<mo4> b;
    public sm4 c;
    public String d;
    public os4<mo4> e;
    public os4<mo4> f;

    /* loaded from: classes.dex */
    public class a extends ms4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoBannerLayout a;

        public a(AutoBannerLayout autoBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = autoBannerLayout;
        }

        @Override // com.repackage.ms4, com.repackage.ks4
        public ns4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ns4 ns4Var = new ns4();
                ns4Var.c(R.drawable.obfuscated_res_0x7f0810d8);
                ns4Var.g(R.drawable.obfuscated_res_0x7f0810d9);
                ns4Var.d(81);
                ns4Var.e(R.dimen.M_H_X003);
                ns4Var.h(R.dimen.M_W_X003);
                return ns4Var;
            }
            return (ns4) invokeV.objValue;
        }

        @Override // com.repackage.ms4, com.repackage.ks4
        public ps4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ps4 ps4Var = new ps4();
                ps4Var.a(mi.f(this.a.getContext(), R.dimen.tbds209));
                return ps4Var;
            }
            return (ps4) invokeV.objValue;
        }

        @Override // com.repackage.ms4, com.repackage.ks4
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(mi.f(this.a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements os4<mo4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoBannerLayout a;

        public b(AutoBannerLayout autoBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = autoBannerLayout;
        }

        @Override // com.repackage.os4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.e(str);
                int count = ListUtils.getCount(this.a.b);
                if (i < 0 || i > count || this.a.e == null) {
                    return;
                }
                this.a.e.b(i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.os4
        /* renamed from: c */
        public void a(int i, mo4 mo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, mo4Var) == null) {
                int count = ListUtils.getCount(this.a.b);
                if (i < 0 || i > count || this.a.e == null) {
                    return;
                }
                this.a.e.a(i, mo4Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoBannerLayout(Context context) {
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

    public void d() {
        CoverFlowView<mo4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.l();
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                TbPageContext<?> tbPageContext = (TbPageContext) f9.a(getContext());
                if (!TextUtils.isEmpty(this.d)) {
                    str = str + "&source=" + this.d;
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = new CoverFlowView<>(getContext());
            a aVar = new a(this);
            this.a.setPageMargin(mi.f(getContext(), R.dimen.tbds42));
            this.a.setIndicatorNoOffet(false);
            this.a.setDisableParentEvent(false);
            this.a.setCoverFlowFactory(aVar);
            this.a.setIndicatorVisible(0);
            this.a.setIsAutoPlayDragging(false);
            this.a.setCallback(this.f);
            addView(this.a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: g */
    public void a(no4 no4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, no4Var) == null) {
            if (no4Var != null && !ListUtils.isEmpty(no4Var.a)) {
                h(no4Var.a);
            } else {
                setVisibility(8);
            }
        }
    }

    public CoverFlowView getCoverFlowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (CoverFlowView) invokeV.objValue;
    }

    public void h(List<mo4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                setVisibility(0);
                this.b = list;
                this.a.setData(list);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CoverFlowView<mo4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.s();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.c != null) {
                this.c.a(this, i == 0, null);
            }
        }
    }

    public void setBannerHeight(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || this.a == null) {
            return;
        }
        ps4 ps4Var = new ps4();
        ps4Var.a(i);
        this.a.x(ps4Var);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public void setIWindowChangedListener(sm4 sm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sm4Var) == null) {
            this.c = sm4Var;
        }
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<mo4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.setIndicatorVisible(i);
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<mo4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.setMarqueenTime(j);
    }

    public void setOnCoverViewCallback(os4<mo4> os4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, os4Var) == null) {
            this.e = os4Var;
        }
    }

    public void setPageMargin(int i) {
        CoverFlowView<mo4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.setPageMargin(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = "";
        this.f = new b(this);
        f();
    }
}
