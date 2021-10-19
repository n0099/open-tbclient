package c.a.r0.z0.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.b.d;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.k3.i0.o;
import c.a.r0.y0.e.c;
import c.a.r0.z2.p;
import c.a.r0.z2.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b extends c.a.e.l.e.a<n, FunAdNativeViewHolder> implements t, p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity m;
    public String n;
    public Set<String> o;
    public String p;
    public String q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f29458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f29459f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f29460g;

        public a(b bVar, o oVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, oVar, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29460g = bVar;
            this.f29458e = oVar;
            this.f29459f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f29458e.m(true);
                this.f29460g.P();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f29459f.getFunAdNativeView().getPageType()).param(TiebaStatic.Params.RESOURCE_ID, this.f29460g.h0()).param("obj_locate", 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new HashSet();
        this.m = baseFragmentActivity;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "pb".equals(this.p) ? this.f2961h == AdvertAppInfo.D4 ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public FunAdNativeViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.f2961h;
            if (bdUniqueId == AdvertAppInfo.D4) {
                funAdNativePbView = new FunAdNativeCommentView(this.m);
            } else if (bdUniqueId == AdvertAppInfo.C4) {
                funAdNativePbView = new FunAdNativeFrsView(this.m);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.m);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.m, this.f2961h);
            funAdNativeViewHolder.setSid(this.n);
            funAdNativeViewHolder.setSceneKey(this.q);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j2;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, funAdNativeViewHolder})) == null) {
            if (nVar instanceof c2) {
                d2 d2Var = ((c2) nVar).w;
                oVar = d2Var.K2;
                j2 = d2Var.T();
            } else if (nVar instanceof d2) {
                d2 d2Var2 = (d2) nVar;
                oVar = d2Var2.K2;
                j2 = d2Var2.T();
            } else {
                j2 = 0;
                oVar = nVar instanceof PostData ? ((PostData) nVar).s0 : null;
            }
            if (oVar == null) {
                funAdNativeViewHolder.getFunAdNativeView().hideOrShowView(8);
                return funAdNativeViewHolder.getView();
            }
            if (!"personalize".equals(this.p) && !AdvertAppInfo.D4.equals(this.f2961h)) {
                this.n = c.e().d(this.q);
            }
            BdUniqueId bdUniqueId = this.f2961h;
            if (bdUniqueId == AdvertAppInfo.C4) {
                if ("frs".equals(this.p)) {
                    c.a.r0.y0.a.i().C(this.m, this.n, c.a.r0.y0.a.b(this.p, d.p() ? "1" : "0"), String.valueOf(j2));
                } else if ("personalize".equals(this.p)) {
                    c.a.r0.y0.a.i().B(this.m, this.n, c.a.r0.y0.a.b(this.p, d.J() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.D4) {
                c.a.r0.y0.a.i().D(this.m, this.n, c.a.r0.y0.a.b(this.p, d.G() ? "1" : "0"), oVar.e(), oVar.c());
            }
            funAdNativeViewHolder.setFeedBackListener(new a(this, oVar, funAdNativeViewHolder));
            funAdNativeViewHolder.getFunAdNativeView().onChangedSkinType();
            funAdNativeViewHolder.setPage(this.p);
            funAdNativeViewHolder.setSid(this.n);
            this.o.add(this.n);
            funAdNativeViewHolder.showNativeAd(oVar, nVar instanceof c.a.q0.s.q.a ? ((c.a.q0.s.q.a) nVar).position + 1 : -1);
            return funAdNativeViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.z2.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.q = str;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.n = str;
        }
    }

    @Override // c.a.r0.z2.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V v = this.k;
            if (v != 0 && ((FunAdNativeViewHolder) v).getFunAdNativeView() != null) {
                ((FunAdNativeViewHolder) this.k).getFunAdNativeView().destroyDownloadButton();
            }
            for (String str : this.o) {
                c.a.r0.y0.a.i().c(str);
            }
        }
    }

    @Override // c.a.r0.z2.p
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v = this.k) == 0 || ((FunAdNativeViewHolder) v).getFunAdNativeView() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).getFunAdNativeView().destroyDownloadButton();
    }

    @Override // c.a.r0.z2.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
