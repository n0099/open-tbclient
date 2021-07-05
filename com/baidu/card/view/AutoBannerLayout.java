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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.j.q;
import d.a.r0.m.c;
import d.a.r0.r.q.m;
import d.a.r0.r.q.n;
import d.a.r0.r.w.b.d;
import d.a.r0.r.w.b.e;
import java.util.List;
/* loaded from: classes3.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<m> f4393e;

    /* renamed from: f  reason: collision with root package name */
    public List<m> f4394f;

    /* renamed from: g  reason: collision with root package name */
    public c f4395g;

    /* renamed from: h  reason: collision with root package name */
    public d<m> f4396h;

    /* renamed from: i  reason: collision with root package name */
    public d<m> f4397i;

    /* loaded from: classes3.dex */
    public class a extends d.a.r0.r.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f4398a;

        public a(AutoBannerLayout autoBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4398a = autoBannerLayout;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public d.a.r0.r.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.r0.r.w.b.c cVar = new d.a.r0.r.w.b.c();
                cVar.c(R.drawable.shape_home_feed_banner_dot_n);
                cVar.g(R.drawable.shape_home_feed_banner_dot_s);
                cVar.d(81);
                cVar.e(R.dimen.M_H_X003);
                cVar.h(R.dimen.M_W_X003);
                return cVar;
            }
            return (d.a.r0.r.w.b.c) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(l.g(this.f4398a.getContext(), R.dimen.tbds209));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
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
                tbImageView.setRadius(l.g(this.f4398a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f4399a;

        public b(AutoBannerLayout autoBannerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoBannerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4399a = autoBannerLayout;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f4399a.e(str);
                int count = ListUtils.getCount(this.f4399a.f4394f);
                if (i2 < 0 || i2 > count || this.f4399a.f4396h == null) {
                    return;
                }
                this.f4399a.f4396h.b(i2, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) {
                int count = ListUtils.getCount(this.f4399a.f4394f);
                if (i2 < 0 || i2 > count || this.f4399a.f4396h == null) {
                    return;
                }
                this.f4399a.f4396h.a(i2, mVar);
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

    public void d() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (coverFlowView = this.f4393e) == null) {
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
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(getContext()), new String[]{str});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f4393e = new CoverFlowView<>(getContext());
            a aVar = new a(this);
            this.f4393e.setPageMargin(l.g(getContext(), R.dimen.tbds42));
            this.f4393e.setIndicatorNoOffet(false);
            this.f4393e.setDisableParentEvent(false);
            this.f4393e.setCoverFlowFactory(aVar);
            this.f4393e.setIndicatorVisible(0);
            this.f4393e.setIsAutoPlayDragging(false);
            this.f4393e.setCallback(this.f4397i);
            addView(this.f4393e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: g */
    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            if (nVar != null && !ListUtils.isEmpty(nVar.f56019e)) {
                h(nVar.f56019e);
            } else {
                setVisibility(8);
            }
        }
    }

    public CoverFlowView getCoverFlowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4393e : (CoverFlowView) invokeV.objValue;
    }

    public void h(List<m> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                setVisibility(0);
                this.f4394f = list;
                this.f4393e.setData(list);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) || (coverFlowView = this.f4393e) == null) {
            return;
        }
        coverFlowView.s();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f4395g != null) {
                this.f4395g.a(this, i2 == 0, null);
            }
        }
    }

    public void setBannerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f4393e == null) {
            return;
        }
        e eVar = new e();
        eVar.a(i2);
        this.f4393e.x(eVar);
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f4395g = cVar;
        }
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (coverFlowView = this.f4393e) == null) {
            return;
        }
        coverFlowView.setIndicatorVisible(i2);
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048588, this, j) == null) || (coverFlowView = this.f4393e) == null) {
            return;
        }
        coverFlowView.setMarqueenTime(j);
    }

    public void setOnCoverViewCallback(d<m> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f4396h = dVar;
        }
    }

    public void setPageMargin(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (coverFlowView = this.f4393e) == null) {
            return;
        }
        coverFlowView.setPageMargin(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f4393e = null;
        this.f4394f = null;
        this.f4397i = new b(this);
        f();
    }
}
