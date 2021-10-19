package c.a.r0.h1.d;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<BaseFragmentActivity> f18109a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f18110b;

    /* renamed from: c  reason: collision with root package name */
    public RecPersonalizePageModel f18111c;

    /* renamed from: d  reason: collision with root package name */
    public ConcernNetModel f18112d;

    /* renamed from: e  reason: collision with root package name */
    public d f18113e;

    /* renamed from: f  reason: collision with root package name */
    public RecPersonalizePageModel.b f18114f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernNetModel.d f18115g;

    /* renamed from: h  reason: collision with root package name */
    public ConcernNetModel.c f18116h;

    /* loaded from: classes3.dex */
    public class a implements RecPersonalizePageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18117a;

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
            this.f18117a = cVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void a(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.f18117a.f18113e != null) {
                    this.f18117a.f18113e.b(dataRes, z, z2);
                }
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_GET_NET_CACHE_KEY);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f18117a.f18113e == null) {
                return;
            }
            this.f18117a.f18113e.c("", str, i2, false, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ConcernNetModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18118a;

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
            this.f18118a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) || this.f18118a.f18113e == null) {
                return;
            }
            this.f18118a.f18113e.d(dataRes, z);
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.d
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f18118a.f18113e == null) {
                return;
            }
            this.f18118a.f18113e.c("", str, i2, false, 0);
        }
    }

    /* renamed from: c.a.r0.h1.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0880c implements ConcernNetModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18119a;

        public C0880c(c cVar) {
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
            this.f18119a = cVar;
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f18119a.f18113e == null) {
                return;
            }
            this.f18119a.f18113e.a(z);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(String str, String str2, int i2, boolean z, int i3);

        void d(tbclient.Userlike.DataRes dataRes, boolean z);

        void e(boolean z, c.a.r0.h1.i.a.a aVar, boolean z2, String str, String str2, boolean z3);
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
        this.f18111c = RecPersonalizePageModel.f();
        this.f18114f = new a(this);
        this.f18115g = new b(this);
        this.f18116h = new C0880c(this);
        this.f18109a = tbPageContext;
        this.f18110b = bdUniqueId;
        this.f18111c.n(this.f18114f);
        ConcernNetModel concernNetModel = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.f18112d = concernNetModel;
        concernNetModel.E(this.f18115g);
        this.f18112d.D(this.f18116h);
    }

    public void b(boolean z) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (concernNetModel = this.f18112d) == null) {
            return;
        }
        concernNetModel.z(z);
    }

    public TbPageContext<BaseFragmentActivity> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18109a : (TbPageContext) invokeV.objValue;
    }

    public c.a.r0.q1.s.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (c.a.r0.q1.s.a) invokeV.objValue;
    }

    public d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18113e : (d) invokeV.objValue;
    }

    public BdUniqueId f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18110b : (BdUniqueId) invokeV.objValue;
    }

    public void g(String str, c.a.q0.d1.e eVar) {
        ConcernNetModel concernNetModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, eVar) == null) || (concernNetModel = this.f18112d) == null) {
            return;
        }
        concernNetModel.A(str, eVar);
    }

    public void h(int i2, int i3, c.a.q0.d1.e eVar, int i4, int i5) {
        RecPersonalizePageModel recPersonalizePageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (recPersonalizePageModel = this.f18111c) == null) {
            return;
        }
        recPersonalizePageModel.g(i2, i3, eVar, i4, i5);
    }

    public void i(c.a.r0.q1.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f18113e = dVar;
        }
    }
}
