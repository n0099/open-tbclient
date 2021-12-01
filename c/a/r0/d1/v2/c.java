package c.a.r0.d1.v2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.r0.g0.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f16089e;

    /* renamed from: f  reason: collision with root package name */
    public static c f16090f;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener a;

    /* renamed from: b  reason: collision with root package name */
    public C0968c f16091b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f16092c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f16093d;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f16093d == null) {
                return;
            }
            this.a.f16093d.clear();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0968c c0968c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C0968c) || (c0968c = (C0968c) obj) == null) {
                    return;
                }
                c0968c.f16096d = false;
                c0968c.a = false;
                c0968c.f16094b = 0;
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, 2005016);
        this.f16092c = new b(this, Looper.getMainLooper());
        f16089e = c.a.q0.s.e0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.a);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f16090f == null) {
                synchronized (v.class) {
                    if (f16090f == null) {
                        f16090f = new c();
                    }
                }
            }
            return f16090f;
        }
        return (c) invokeV.objValue;
    }

    public static void m(FrsViewData frsViewData, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i2).param("obj_type", i3);
        if (context != null) {
            c.a.q0.o0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) && d2Var != null && d2Var.Z1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", d2Var.U());
            statisticItem.param("obj_source", d2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.a1);
            statisticItem.param("obj_param1", d2Var.d1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", d2Var.v1());
            v.b().a(statisticItem);
        }
    }

    public void c(c.a.r0.d1.v2.b bVar, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, d2Var) == null) || bVar == null || !bVar.a || d2Var == null || d2Var.v1() == null) {
            return;
        }
        if (this.f16093d == null) {
            this.f16093d = new SparseArray<>();
        }
        if (this.f16093d.get(bVar.f16085d) == null) {
            this.f16093d.put(bVar.f16085d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f16093d.get(bVar.f16085d);
        String v1 = d2Var.v1();
        if (bVar.f16086e >= 0) {
            v1 = v1 + "_" + bVar.f16086e;
        }
        if (hashSet.contains(v1) || g()) {
            return;
        }
        hashSet.add(v1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f16084c);
        statisticItem.param("obj_locate", l(bVar));
        statisticItem.param("obj_source", d2Var.Z0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.a1);
        statisticItem.param("obj_param1", d2Var.b1);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.d1);
        statisticItem.param("tid", d2Var.v1());
        statisticItem.param("nid", d2Var.G0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f16085d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = d2Var.U1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (d2Var.y1() == null || (d2Var.y1().M() == null && d2Var.y1().Y() == null)) ? 0 : 1;
        if (i4 != 0 && d2Var.y1().M() != null && d2Var.y1().M().y() != null && d2Var.y1().M().y().size() > 0) {
            statisticItem.param("obj_name", d2Var.y1().P ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = d2Var.getType() == d2.N3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
            statisticItem.param("obj_name", d2Var.J().getName_show());
        }
        if (!d2Var.S1() && !d2Var.R1()) {
            if (d2Var.P1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        v.b().a(statisticItem);
        if (d2Var.H2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f16084c);
            statisticItem2.param("obj_locate", l(bVar));
            statisticItem2.param("obj_source", d2Var.Z0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.a1);
            statisticItem2.param("obj_param1", d2Var.b1);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.d1);
            statisticItem2.param("tid", d2Var.v1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            v.b().a(statisticItem2);
        }
        if (bVar.f16085d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f16084c);
            statisticItem3.param("tid", d2Var.v1());
            v.b().a(statisticItem3);
        }
    }

    public void d(d2 d2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d2Var, hashSet) == null) && d2Var != null && d2Var.B2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (d2Var.v1() == null || hashSet.contains(d2Var.v1())) {
                return;
            }
            hashSet.add(d2Var.v1());
            v.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", d2Var.v1()));
        }
    }

    public void e(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, d2Var, z) == null) || d2Var == null) {
            return;
        }
        v.b().a(new StatisticItem("c12125").param("tid", d2Var.g0()).param("obj_locate", z ? 2 : 1).param("obj_id", d2Var.o1() != null ? d2Var.o1().live_id : -1L).param("obj_type", 1));
    }

    public void f(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null) {
            return;
        }
        v.b().a(new StatisticItem("c14381").param("tid", d2Var.g0()).param("fid", d2Var.U()).param("fname", d2Var.a0()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f16091b == null) {
                this.f16091b = new C0968c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C0968c c0968c = this.f16091b;
            if (c0968c.f16096d) {
                return true;
            }
            if (c0968c.a) {
                int i2 = c0968c.f16094b + 1;
                c0968c.f16094b = i2;
                if (currentTimeMillis - c0968c.f16095c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f16089e) {
                        c0968c.f16096d = true;
                        i(c0968c);
                        return true;
                    }
                } else {
                    c0968c.a = false;
                    c0968c.f16094b = 0;
                }
            } else {
                c0968c.a = true;
                c0968c.f16095c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(c.a.r0.d1.v2.b bVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, bVar, d2Var, i2) == null) || d2Var == null || d2Var.v1() == null || bVar == null) {
            return;
        }
        if (bVar.a || d2Var.n) {
            v.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", bVar.f16084c);
            statisticItem.param("obj_locate", l(bVar));
            statisticItem.param("obj_source", d2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.a1);
            statisticItem.param("obj_param1", d2Var.b1);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.d1);
            statisticItem.param("tid", d2Var.v1());
            statisticItem.param("nid", d2Var.G0());
            if (!d2Var.S1() && !d2Var.R1()) {
                if (d2Var.P1()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i2);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, j(d2Var));
            int i3 = bVar.f16085d;
            if (i3 >= 0) {
                statisticItem.param("tab_id", i3);
            }
            int i4 = d2Var.U1;
            if (i4 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
            }
            statisticItem.param("thread_type", d2Var.getType() == d2.N3 ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (d2Var.H2()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", bVar.f16084c);
                statisticItem2.param("obj_locate", l(bVar));
                statisticItem2.param("obj_source", d2Var.Z0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.a1);
                statisticItem2.param("obj_param1", d2Var.b1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.d1);
                statisticItem2.param("tid", d2Var.v1());
                statisticItem2.param("obj_type", i2);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, j(d2Var));
                TiebaStatic.log(statisticItem2);
            }
            if (bVar.f16085d == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", bVar.f16084c);
                statisticItem3.param("tid", d2Var.v1());
                v.b().a(statisticItem3);
            }
            if (d2Var.J() == null || d2Var.J().getAlaUserData() == null) {
                return;
            }
            AlaUserInfoData alaUserData = d2Var.J().getAlaUserData();
            if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
                return;
            }
            StatisticItem statisticItem4 = new StatisticItem("c11850");
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem4);
        }
    }

    public final void i(C0968c c0968c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c0968c) == null) {
            Message obtainMessage = this.f16092c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c0968c;
            this.f16092c.removeMessages(5);
            this.f16092c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String j(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d2Var)) == null) {
            if (d2Var.h1) {
                return String.valueOf(d2Var.i0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int l(c.a.r0.d1.v2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f16083b;
            int i3 = bVar.f16088g;
            if (i3 == 100) {
                return 20;
            }
            int i4 = bVar.f16087f;
            if (i4 > 0) {
                if (bVar.f16085d == 1120) {
                    return 15;
                }
                if (i3 == 3) {
                    return 13;
                }
                return i4;
            }
            if (i2 == 8) {
                i2 = 9;
            }
            if (bVar.f16085d == 504) {
                i2 = 11;
            }
            if (bVar.f16085d == 1120) {
                return 15;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* renamed from: c.a.r0.d1.v2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0968c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f16094b;

        /* renamed from: c  reason: collision with root package name */
        public long f16095c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16096d;

        public C0968c(c cVar) {
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
            this.a = false;
            this.f16094b = 0;
            this.f16096d = false;
        }

        public /* synthetic */ C0968c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
