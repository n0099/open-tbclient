package c.a.t0.g1.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.b.d;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.f1.e.c;
import c.a.t0.k3.p;
import c.a.t0.k3.t;
import c.a.t0.x3.j0.o;
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
/* loaded from: classes7.dex */
public class b extends c.a.d.n.e.a<n, FunAdNativeViewHolder> implements t, p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity m;
    public String n;
    public Set<String> o;
    public String p;
    public String q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f17744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f17745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f17746g;

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
            this.f17746g = bVar;
            this.f17744e = oVar;
            this.f17745f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17744e.m(true);
                this.f17746g.H();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f17745f.getFunAdNativeView().getPageType()).param(TiebaStatic.Params.RESOURCE_ID, this.f17746g.Z()).param("obj_locate", 0));
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

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "pb".equals(this.p) ? this.f3363h == AdvertAppInfo.N4 ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public FunAdNativeViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.f3363h;
            if (bdUniqueId == AdvertAppInfo.N4) {
                funAdNativePbView = new FunAdNativeCommentView(this.m);
            } else if (bdUniqueId == AdvertAppInfo.M4) {
                funAdNativePbView = new FunAdNativeFrsView(this.m);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.m);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.m, this.f3363h);
            funAdNativeViewHolder.setSid(this.n);
            funAdNativeViewHolder.setSceneKey(this.q);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j2;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, funAdNativeViewHolder})) == null) {
            if (nVar instanceof d2) {
                e2 e2Var = ((d2) nVar).w;
                oVar = e2Var.M2;
                j2 = e2Var.U();
            } else if (nVar instanceof e2) {
                e2 e2Var2 = (e2) nVar;
                oVar = e2Var2.M2;
                j2 = e2Var2.U();
            } else {
                j2 = 0;
                oVar = nVar instanceof PostData ? ((PostData) nVar).w0 : null;
            }
            if (oVar == null) {
                funAdNativeViewHolder.getFunAdNativeView().hideOrShowView(8);
                return funAdNativeViewHolder.getView();
            }
            if (!"personalize".equals(this.p) && !AdvertAppInfo.N4.equals(this.f3363h)) {
                this.n = c.e().d(this.q);
            }
            BdUniqueId bdUniqueId = this.f3363h;
            if (bdUniqueId == AdvertAppInfo.M4) {
                if ("frs".equals(this.p)) {
                    c.a.t0.f1.a.i().C(this.m, this.n, c.a.t0.f1.a.b(this.p, d.s() ? "1" : "0"), String.valueOf(j2));
                } else if ("personalize".equals(this.p)) {
                    c.a.t0.f1.a.i().B(this.m, this.n, c.a.t0.f1.a.b(this.p, d.X() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.N4) {
                c.a.t0.f1.a.i().D(this.m, this.n, c.a.t0.f1.a.b(this.p, d.U() ? "1" : "0"), oVar.e(), oVar.c());
            }
            funAdNativeViewHolder.setFeedBackListener(new a(this, oVar, funAdNativeViewHolder));
            funAdNativeViewHolder.getFunAdNativeView().onChangedSkinType();
            funAdNativeViewHolder.setPage(this.p);
            funAdNativeViewHolder.setSid(this.n);
            this.o.add(this.n);
            funAdNativeViewHolder.showNativeAd(oVar, nVar instanceof c.a.s0.s.q.a ? ((c.a.s0.s.q.a) nVar).position + 1 : -1);
            return funAdNativeViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.p = str;
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.q = str;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.n = str;
        }
    }

    @Override // c.a.t0.k3.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.t0.k3.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V v = this.k;
            if (v != 0 && ((FunAdNativeViewHolder) v).getFunAdNativeView() != null) {
                ((FunAdNativeViewHolder) this.k).getFunAdNativeView().destroyDownloadButton();
            }
            for (String str : this.o) {
                c.a.t0.f1.a.i().c(str);
            }
        }
    }

    @Override // c.a.t0.k3.p
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v = this.k) == 0 || ((FunAdNativeViewHolder) v).getFunAdNativeView() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).getFunAdNativeView().destroyDownloadButton();
    }

    @Override // c.a.t0.k3.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
