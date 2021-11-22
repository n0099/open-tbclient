package b.a.r0.h1.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f18522a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f18523b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f18524c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f18525d;

    /* renamed from: e  reason: collision with root package name */
    public d f18526e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f18527f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f18528g;

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f18529h;

    /* loaded from: classes4.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18530a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18530a = cVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.f18530a.f18526e != null) {
                    this.f18530a.f18526e.b(dataRes, z, z2);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f18530a.f18526e == null) {
                return;
            }
            this.f18530a.f18526e.c("", str, i2, false, 1);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ConcernNetModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18531a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18531a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) || this.f18531a.f18526e == null) {
                return;
            }
            this.f18531a.f18526e.d(dataRes, z);
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f18531a.f18526e == null) {
                return;
            }
            this.f18531a.f18526e.c("", str, i2, false, 0);
        }
    }

    /* renamed from: b.a.r0.h1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0943c implements ConcernNetModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18532a;

        public C0943c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18532a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f18532a.f18526e == null) {
                return;
            }
            this.f18532a.f18526e.a(z);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, b.a.r0.h1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18524c = RecPersonalizePageModel.f();
        this.f18527f = new a(this);
        this.f18528g = new b(this);
        this.f18529h = new C0943c(this);
        this.f18522a = tbPageContext;
        this.f18523b = bdUniqueId;
        this.f18524c.n(this.f18527f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f18525d = concernNetModel;
        concernNetModel.E(this.f18528g);
        this.f18525d.D(this.f18529h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (concernNetModel = this.f18525d) == null) {
            return;
        }
        concernNetModel.z(z);
    }

    public TbPageContext<BaseFragmentActivity> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18522a : (TbPageContext) invokeV.objValue;
    }

    public b.a.r0.q1.s.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (b.a.r0.q1.s.a) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18526e : (d) invokeV.objValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18523b : (BdUniqueId) invokeV.objValue;
    }

    public void g(String str, b.a.q0.c1.e eVar) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, eVar) == null) || (concernNetModel = this.f18525d) == null) {
            return;
        }
        concernNetModel.A(str, eVar);
    }

    public void h(int i2, int i3, b.a.q0.c1.e eVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (recPersonalizePageModel = this.f18524c) == null) {
            return;
        }
        recPersonalizePageModel.g(i2, i3, eVar, i4, i5);
    }

    public void i(b.a.r0.q1.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f18526e = dVar;
        }
    }
}
