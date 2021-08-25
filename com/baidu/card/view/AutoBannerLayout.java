package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.l.p;
import c.a.l.q;
import c.a.p0.n.c;
import c.a.p0.s.q.m;
import c.a.p0.s.q.n;
import c.a.p0.s.w.b.d;
import c.a.p0.s.w.b.e;
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
import java.util.List;
/* loaded from: classes5.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<m> f38496e;

    /* renamed from: f  reason: collision with root package name */
    public List<m> f38497f;

    /* renamed from: g  reason: collision with root package name */
    public c f38498g;

    /* renamed from: h  reason: collision with root package name */
    public String f38499h;

    /* renamed from: i  reason: collision with root package name */
    public d<m> f38500i;

    /* renamed from: j  reason: collision with root package name */
    public d<m> f38501j;

    /* loaded from: classes5.dex */
    public class a extends c.a.p0.s.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f38502a;

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
            this.f38502a = autoBannerLayout;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
        public c.a.p0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.w.b.c cVar = new c.a.p0.s.w.b.c();
                cVar.c(R.drawable.shape_home_feed_banner_dot_n);
                cVar.g(R.drawable.shape_home_feed_banner_dot_s);
                cVar.d(81);
                cVar.e(R.dimen.M_H_X003);
                cVar.h(R.dimen.M_W_X003);
                return cVar;
            }
            return (c.a.p0.s.w.b.c) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(l.g(this.f38502a.getContext(), R.dimen.tbds209));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // c.a.p0.s.w.b.b, c.a.p0.s.w.a
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
                tbImageView.setRadius(l.g(this.f38502a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f38503a;

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
            this.f38503a = autoBannerLayout;
        }

        @Override // c.a.p0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f38503a.dealOneLink(str);
                int count = ListUtils.getCount(this.f38503a.f38497f);
                if (i2 < 0 || i2 > count || this.f38503a.f38500i == null) {
                    return;
                }
                this.f38503a.f38500i.b(i2, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) {
                int count = ListUtils.getCount(this.f38503a.f38497f);
                if (i2 < 0 || i2 > count || this.f38503a.f38500i == null) {
                    return;
                }
                this.f38503a.f38500i.a(i2, mVar);
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38496e = new CoverFlowView<>(getContext());
            a aVar = new a(this);
            this.f38496e.setPageMargin(l.g(getContext(), R.dimen.tbds42));
            this.f38496e.setIndicatorNoOffet(false);
            this.f38496e.setDisableParentEvent(false);
            this.f38496e.setCoverFlowFactory(aVar);
            this.f38496e.setIndicatorVisible(0);
            this.f38496e.setIsAutoPlayDragging(false);
            this.f38496e.setCallback(this.f38501j);
            addView(this.f38496e);
        }
    }

    public void checkAndStartMarqueen() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.checkAndStartMarqueen();
    }

    public boolean checkIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 > 0 && i2 <= ListUtils.getCount(this.f38497f) : invokeI.booleanValue;
    }

    public void dealOneLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                TbPageContext<?> tbPageContext = (TbPageContext) j.a(getContext());
                if (!TextUtils.isEmpty(this.f38499h)) {
                    str = str + "&source=" + this.f38499h;
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public CoverFlowView getCoverFlowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38496e : (CoverFlowView) invokeV.objValue;
    }

    public m getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (m) ListUtils.getItem(this.f38497f, i2) : (m) invokeI.objValue;
    }

    public void onChangeSkinType(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.onChangeSkinType();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f38498g != null) {
                this.f38498g.a(this, i2 == 0, null);
            }
        }
    }

    public void setBannerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.f38496e == null) {
            return;
        }
        e eVar = new e();
        eVar.a(i2);
        this.f38496e.updateViewPager(eVar);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f38499h = str;
        }
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f38498g = cVar;
        }
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.setIndicatorVisible(i2);
    }

    public void setMarqueenTime(long j2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.setMarqueenTime(j2);
    }

    public void setOnCoverViewCallback(d<m> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.f38500i = dVar;
        }
    }

    public void setPageMargin(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.setPageMargin(i2);
    }

    public void startAutoScroll() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.startMarqueen();
    }

    public void stopAutoScroll() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.stopMarqueen();
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

    public void onBindDataToView(List<m> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && !ListUtils.isEmpty(list)) {
                setVisibility(0);
                this.f38497f = list;
                this.f38496e.setData(list);
                return;
            }
            setVisibility(8);
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
        this.f38496e = null;
        this.f38497f = null;
        this.f38499h = "";
        this.f38501j = new b(this);
        c();
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i2) == null) || (coverFlowView = this.f38496e) == null) {
            return;
        }
        coverFlowView.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            if (nVar != null && !ListUtils.isEmpty(nVar.f14307e)) {
                onBindDataToView(nVar.f14307e);
            } else {
                setVisibility(8);
            }
        }
    }
}
