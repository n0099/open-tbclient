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
import com.repackage.bn4;
import com.repackage.bx;
import com.repackage.cn4;
import com.repackage.cr4;
import com.repackage.cx;
import com.repackage.dr4;
import com.repackage.er4;
import com.repackage.f9;
import com.repackage.fr4;
import com.repackage.hl4;
import com.repackage.li;
import java.util.List;
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements cx, bx<cn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<bn4> a;
    public List<bn4> b;
    public hl4 c;
    public String d;
    public er4<bn4> e;
    public er4<bn4> f;

    /* loaded from: classes.dex */
    public class a extends cr4 {
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

        @Override // com.repackage.cr4, com.repackage.ar4
        public dr4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                dr4 dr4Var = new dr4();
                dr4Var.c(R.drawable.obfuscated_res_0x7f0810ea);
                dr4Var.g(R.drawable.obfuscated_res_0x7f0810eb);
                dr4Var.d(81);
                dr4Var.e(R.dimen.M_H_X003);
                dr4Var.h(R.dimen.M_W_X003);
                return dr4Var;
            }
            return (dr4) invokeV.objValue;
        }

        @Override // com.repackage.cr4, com.repackage.ar4
        public fr4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                fr4 fr4Var = new fr4();
                fr4Var.a(li.f(this.a.getContext(), R.dimen.tbds209));
                return fr4Var;
            }
            return (fr4) invokeV.objValue;
        }

        @Override // com.repackage.cr4, com.repackage.ar4
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
                tbImageView.setRadius(li.f(this.a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements er4<bn4> {
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

        @Override // com.repackage.er4
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
        @Override // com.repackage.er4
        /* renamed from: c */
        public void a(int i, bn4 bn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bn4Var) == null) {
                int count = ListUtils.getCount(this.a.b);
                if (i < 0 || i > count || this.a.e == null) {
                    return;
                }
                this.a.e.a(i, bn4Var);
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
        CoverFlowView<bn4> coverFlowView;
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
            this.a.setPageMargin(li.f(getContext(), R.dimen.tbds42));
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
    @Override // com.repackage.bx
    /* renamed from: g */
    public void a(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cn4Var) == null) {
            if (cn4Var != null && !ListUtils.isEmpty(cn4Var.a)) {
                h(cn4Var.a);
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

    public void h(List<bn4> list) {
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

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CoverFlowView<bn4> coverFlowView;
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
        fr4 fr4Var = new fr4();
        fr4Var.a(i);
        this.a.x(fr4Var);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public void setIWindowChangedListener(hl4 hl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hl4Var) == null) {
            this.c = hl4Var;
        }
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<bn4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.setIndicatorVisible(i);
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<bn4> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j) == null) || (coverFlowView = this.a) == null) {
            return;
        }
        coverFlowView.setMarqueenTime(j);
    }

    public void setOnCoverViewCallback(er4<bn4> er4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, er4Var) == null) {
            this.e = er4Var;
        }
    }

    public void setPageMargin(int i) {
        CoverFlowView<bn4> coverFlowView;
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
