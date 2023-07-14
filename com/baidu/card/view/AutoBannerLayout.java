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
import com.baidu.tieba.f05;
import com.baidu.tieba.g25;
import com.baidu.tieba.h25;
import com.baidu.tieba.i85;
import com.baidu.tieba.j85;
import com.baidu.tieba.k85;
import com.baidu.tieba.m85;
import com.baidu.tieba.r9;
import com.baidu.tieba.ry;
import com.baidu.tieba.sy;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerLayout extends RelativeLayout implements sy, ry<h25> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<g25> a;
    public List<g25> b;
    public f05 c;
    public String d;
    public k85<g25> e;
    public k85<g25> f;

    /* loaded from: classes3.dex */
    public class a extends i85 {
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

        @Override // com.baidu.tieba.i85, com.baidu.tieba.g85
        public j85 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                j85 j85Var = new j85();
                j85Var.c(R.drawable.shape_home_feed_banner_dot_n);
                j85Var.g(R.drawable.shape_home_feed_banner_dot_s);
                j85Var.d(81);
                j85Var.e(R.dimen.M_H_X003);
                j85Var.h(R.dimen.M_W_X003);
                return j85Var;
            }
            return (j85) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i85, com.baidu.tieba.g85
        public m85 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                m85 m85Var = new m85();
                m85Var.a(yi.g(this.a.getContext(), R.dimen.tbds209));
                return m85Var;
            }
            return (m85) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i85, com.baidu.tieba.g85
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
                tbImageView.setRadius(yi.g(this.a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements k85<g25> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k85
        /* renamed from: c */
        public void a(int i, g25 g25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, g25Var) == null) {
                int count = ListUtils.getCount(this.a.b);
                if (i >= 0 && i <= count && this.a.e != null) {
                    this.a.e.a(i, g25Var);
                }
            }
        }

        @Override // com.baidu.tieba.k85
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.e(str);
                int count = ListUtils.getCount(this.a.b);
                if (i >= 0 && i <= count && this.a.e != null) {
                    this.a.e.b(i, str);
                }
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: g */
    public void b(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h25Var) == null) {
            if (h25Var != null && !ListUtils.isEmpty(h25Var.a)) {
                h(h25Var.a);
            } else {
                setVisibility(8);
            }
        }
    }

    public void h(List<g25> list) {
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

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.c != null) {
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.a(this, z, null);
            }
        }
    }

    public void setBannerHeight(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.a != null) {
            m85 m85Var = new m85();
            m85Var.a(i);
            this.a.y(m85Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public void setIWindowChangedListener(f05 f05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, f05Var) == null) {
            this.c = f05Var;
        }
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<g25> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<g25> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public void setOnCoverViewCallback(k85<g25> k85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, k85Var) == null) {
            this.e = k85Var;
        }
    }

    public void setPageMargin(int i) {
        CoverFlowView<g25> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setPageMargin(i);
        }
    }

    public void d() {
        CoverFlowView<g25> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.m();
        }
    }

    public CoverFlowView getCoverFlowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (CoverFlowView) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    TbPageContext<?> tbPageContext = (TbPageContext) r9.a(getContext());
                    if (!TextUtils.isEmpty(this.d)) {
                        str = str + "&source=" + this.d;
                    }
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
                }
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
            this.a.setPageMargin(yi.g(getContext(), R.dimen.tbds42));
            this.a.setIndicatorNoOffet(false);
            this.a.setDisableParentEvent(false);
            this.a.setCoverFlowFactory(aVar);
            this.a.setIndicatorVisible(0);
            this.a.setIsAutoPlayDragging(false);
            this.a.setCallback(this.f);
            addView(this.a);
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CoverFlowView<g25> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.t();
        }
    }
}
