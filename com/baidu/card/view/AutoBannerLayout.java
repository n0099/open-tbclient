package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.l.p;
import b.a.l.q;
import b.a.q0.n.c;
import b.a.q0.s.q.m;
import b.a.q0.s.q.n;
import b.a.q0.s.w.b.d;
import b.a.q0.s.w.b.e;
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
/* loaded from: classes7.dex */
public class AutoBannerLayout extends RelativeLayout implements q, p<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowView<m> f36656e;

    /* renamed from: f  reason: collision with root package name */
    public List<m> f36657f;

    /* renamed from: g  reason: collision with root package name */
    public c f36658g;

    /* renamed from: h  reason: collision with root package name */
    public String f36659h;

    /* renamed from: i  reason: collision with root package name */
    public d<m> f36660i;
    public d<m> j;

    /* loaded from: classes7.dex */
    public class a extends b.a.q0.s.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f36661a;

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
            this.f36661a = autoBannerLayout;
        }

        @Override // b.a.q0.s.w.b.b, b.a.q0.s.w.a
        public b.a.q0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.w.b.c cVar = new b.a.q0.s.w.b.c();
                cVar.c(R.drawable.shape_home_feed_banner_dot_n);
                cVar.g(R.drawable.shape_home_feed_banner_dot_s);
                cVar.d(81);
                cVar.e(R.dimen.M_H_X003);
                cVar.h(R.dimen.M_W_X003);
                return cVar;
            }
            return (b.a.q0.s.w.b.c) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.b.b, b.a.q0.s.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(l.g(this.f36661a.getContext(), R.dimen.tbds209));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // b.a.q0.s.w.b.b, b.a.q0.s.w.a
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
                tbImageView.setRadius(l.g(this.f36661a.getContext(), R.dimen.tbds31));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<m> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AutoBannerLayout f36662a;

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
            this.f36662a = autoBannerLayout;
        }

        @Override // b.a.q0.s.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f36662a.dealOneLink(str);
                int count = ListUtils.getCount(this.f36662a.f36657f);
                if (i2 < 0 || i2 > count || this.f36662a.f36660i == null) {
                    return;
                }
                this.f36662a.f36660i.b(i2, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.s.w.b.d
        /* renamed from: c */
        public void a(int i2, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, mVar) == null) {
                int count = ListUtils.getCount(this.f36662a.f36657f);
                if (i2 < 0 || i2 > count || this.f36662a.f36660i == null) {
                    return;
                }
                this.f36662a.f36660i.a(i2, mVar);
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
            this.f36656e = new CoverFlowView<>(getContext());
            a aVar = new a(this);
            this.f36656e.setPageMargin(l.g(getContext(), R.dimen.tbds42));
            this.f36656e.setIndicatorNoOffet(false);
            this.f36656e.setDisableParentEvent(false);
            this.f36656e.setCoverFlowFactory(aVar);
            this.f36656e.setIndicatorVisible(0);
            this.f36656e.setIsAutoPlayDragging(false);
            this.f36656e.setCallback(this.j);
            addView(this.f36656e);
        }
    }

    public void checkAndStartMarqueen() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.checkAndStartMarqueen();
    }

    public boolean checkIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 > 0 && i2 <= ListUtils.getCount(this.f36657f) : invokeI.booleanValue;
    }

    public void dealOneLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                TbPageContext<?> tbPageContext = (TbPageContext) j.a(getContext());
                if (!TextUtils.isEmpty(this.f36659h)) {
                    str = str + "&source=" + this.f36659h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36656e : (CoverFlowView) invokeV.objValue;
    }

    public m getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (m) ListUtils.getItem(this.f36657f, i2) : (m) invokeI.objValue;
    }

    public void onChangeSkinType(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.onChangeSkinType();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f36658g != null) {
                this.f36658g.a(this, i2 == 0, null);
            }
        }
    }

    public void setBannerHeight(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.f36656e == null) {
            return;
        }
        e eVar = new e();
        eVar.a(i2);
        this.f36656e.updateViewPager(eVar);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f36659h = str;
        }
    }

    public void setIWindowChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f36658g = cVar;
        }
    }

    public void setIndicatorVisible(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.setIndicatorVisible(i2);
    }

    public void setMarqueenTime(long j) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.setMarqueenTime(j);
    }

    public void setOnCoverViewCallback(d<m> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.f36660i = dVar;
        }
    }

    public void setPageMargin(int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.setPageMargin(i2);
    }

    public void startAutoScroll() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.startMarqueen();
    }

    public void stopAutoScroll() {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (coverFlowView = this.f36656e) == null) {
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
                this.f36657f = list;
                this.f36656e.setData(list);
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
        this.f36656e = null;
        this.f36657f = null;
        this.f36659h = "";
        this.j = new b(this);
        c();
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CoverFlowView<m> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i2) == null) || (coverFlowView = this.f36656e) == null) {
            return;
        }
        coverFlowView.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            if (nVar != null && !ListUtils.isEmpty(nVar.f13403e)) {
                onBindDataToView(nVar.f13403e);
            } else {
                setVisibility(8);
            }
        }
    }
}
