package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.d35;
import com.baidu.tieba.e35;
import com.baidu.tieba.f35;
import com.baidu.tieba.h35;
import com.baidu.tieba.it;
import com.baidu.tieba.jt;
import com.baidu.tieba.tw4;
import com.baidu.tieba.uw4;
import com.baidu.tieba.xu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerLayout extends RelativeLayout implements jt, it<uw4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<tw4> a;
    public List<tw4> b;
    public xu4 c;
    public String d;
    public f35<tw4> e;
    public f35<tw4> f;

    /* loaded from: classes3.dex */
    public class a extends d35 {
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

        @Override // com.baidu.tieba.d35, com.baidu.tieba.b35
        public e35 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e35 e35Var = new e35();
                e35Var.c(R.drawable.shape_home_feed_banner_dot_n);
                e35Var.g(R.drawable.shape_home_feed_banner_dot_s);
                e35Var.d(81);
                e35Var.e(R.dimen.M_H_X003);
                e35Var.h(R.dimen.M_W_X003);
                return e35Var;
            }
            return (e35) invokeV.objValue;
        }

        @Override // com.baidu.tieba.d35, com.baidu.tieba.b35
        public h35 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                h35 h35Var = new h35();
                h35Var.a(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds209));
                return h35Var;
            }
            return (h35) invokeV.objValue;
        }

        @Override // com.baidu.tieba.d35, com.baidu.tieba.b35
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
                tbImageView.setRadius(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f35<tw4> {
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
        @Override // com.baidu.tieba.f35
        /* renamed from: c */
        public void a(int i, tw4 tw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tw4Var) == null) {
                int count = ListUtils.getCount(this.a.b);
                if (i >= 0 && i <= count && this.a.e != null) {
                    this.a.e.a(i, tw4Var);
                }
            }
        }

        @Override // com.baidu.tieba.f35
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.d(str);
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
        e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: f */
    public void onBindDataToView(uw4 uw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uw4Var) == null) {
            if (uw4Var != null && !ListUtils.isEmpty(uw4Var.a)) {
                g(uw4Var.a);
            } else {
                setVisibility(8);
            }
        }
    }

    public void g(List<tw4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
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
            h35 h35Var = new h35();
            h35Var.a(i);
            this.a.E(h35Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
        }
    }

    public void setIWindowChangedListener(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xu4Var) == null) {
            this.c = xu4Var;
        }
    }

    public void setIndicatorVisible(int i) {
        CoverFlowView<tw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<tw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setMarqueenTime(j);
        }
    }

    public void setOnCoverViewCallback(f35<tw4> f35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, f35Var) == null) {
            this.e = f35Var;
        }
    }

    public void setPageMargin(int i) {
        CoverFlowView<tw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.setPageMargin(i);
        }
    }

    public void c() {
        CoverFlowView<tw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.o();
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

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    TbPageContext<?> tbPageContext = (TbPageContext) a5.a(getContext());
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new CoverFlowView<>(getContext());
            a aVar = new a(this);
            this.a.setPageMargin(BdUtilHelper.getDimens(getContext(), R.dimen.tbds42));
            this.a.setIndicatorNoOffet(false);
            this.a.setDisableParentEvent(false);
            this.a.setCoverFlowFactory(aVar);
            this.a.setIndicatorVisible(0);
            this.a.setIsAutoPlayDragging(false);
            this.a.setCallback(this.f);
            addView(this.a);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CoverFlowView<tw4> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) && (coverFlowView = this.a) != null) {
            coverFlowView.v();
        }
    }
}
