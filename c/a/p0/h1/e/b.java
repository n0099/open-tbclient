package c.a.p0.h1.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.c1.f;
import c.a.o0.r.r.a2;
import c.a.p0.g1.f.c;
import c.a.p0.l3.p;
import c.a.p0.l3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<n, FunAdNativeViewHolder> implements u, p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity i;
    public String j;
    public Set<String> k;
    public String l;
    public String m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a4.k0.n a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f15425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f15426c;

        public a(b bVar, c.a.p0.a4.k0.n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, nVar, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15426c = bVar;
            this.a = nVar;
            this.f15425b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.m(true);
                this.f15426c.H();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f15425b.g()).param(TiebaStatic.Params.RESOURCE_ID, this.f15426c.Z()).param("obj_locate", 0);
                if ("a006".equals(this.f15425b.g())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.f15425b.e());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.f15425b.d());
                }
                TiebaStatic.log(param);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new HashSet();
        this.i = baseFragmentActivity;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "pb".equals(this.l) ? this.f2570d == AdvertAppInfo.I ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public FunAdNativeViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.f2570d;
            if (bdUniqueId == AdvertAppInfo.I) {
                funAdNativePbView = new FunAdNativeCommentView(this.i);
            } else if (bdUniqueId == AdvertAppInfo.H) {
                funAdNativePbView = new FunAdNativeFrsView(this.i);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.i);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.i, this.f2570d);
            funAdNativeViewHolder.n(this.j);
            funAdNativeViewHolder.m(this.m);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i, View view, ViewGroup viewGroup, n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j;
        c.a.p0.a4.k0.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, nVar, funAdNativeViewHolder})) == null) {
            if (nVar instanceof a2) {
                ThreadData threadData = ((a2) nVar).s;
                nVar2 = threadData.funAdData;
                j = threadData.getFid();
            } else if (nVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) nVar;
                nVar2 = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                j = 0;
                nVar2 = nVar instanceof PostData ? ((PostData) nVar).s0 : null;
            }
            if (nVar2 == null) {
                funAdNativeViewHolder.f().d(8);
                return funAdNativeViewHolder.b();
            }
            if (!"personalize".equals(this.l) && !AdvertAppInfo.I.equals(this.f2570d)) {
                this.j = c.e().d(this.m);
            }
            BdUniqueId bdUniqueId = this.f2570d;
            if (bdUniqueId == AdvertAppInfo.H) {
                if ("frs".equals(this.l)) {
                    c.a.p0.g1.b.j().E(this.i, this.j, c.a.p0.g1.b.b(this.l, UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0"), String.valueOf(j), f.f());
                } else if ("personalize".equals(this.l)) {
                    c.a.p0.g1.b.j().D(this.i, this.j, c.a.p0.g1.b.b(this.l, UbsABTestHelper.isPersonalizeFunAdABTest() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.I) {
                c.a.p0.g1.b.j().F(this.i, this.j, c.a.p0.g1.b.b(this.l, UbsABTestHelper.isPbCommentFunAdABTest() ? "1" : "0"), nVar2.e(), nVar2.c());
            }
            funAdNativeViewHolder.k(new a(this, nVar2, funAdNativeViewHolder));
            funAdNativeViewHolder.f().h();
            funAdNativeViewHolder.l(this.l);
            funAdNativeViewHolder.n(this.j);
            this.k.add(this.j);
            funAdNativeViewHolder.o(nVar2, nVar instanceof c.a.o0.r.r.a ? ((c.a.o0.r.r.a) nVar).position + 1 : -1);
            return funAdNativeViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.l = str;
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = str;
        }
    }

    @Override // c.a.p0.l3.u
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.p0.l3.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V v = this.f2573g;
            if (v != 0 && ((FunAdNativeViewHolder) v).f() != null) {
                ((FunAdNativeViewHolder) this.f2573g).f().b();
            }
            for (String str : this.k) {
                c.a.p0.g1.b.j().c(str);
            }
        }
    }

    @Override // c.a.p0.l3.p
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v = this.f2573g) == 0 || ((FunAdNativeViewHolder) v).f() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.f2573g).f().b();
    }

    @Override // c.a.p0.l3.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
