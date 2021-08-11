package c.a.p0.v0.j2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import c.a.p0.a0.t;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f25944e;

    /* renamed from: f  reason: collision with root package name */
    public static c f25945f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f25946a;

    /* renamed from: b  reason: collision with root package name */
    public C1213c f25947b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f25948c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f25949d;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f25950a;

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
            this.f25950a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f25950a.f25949d == null) {
                return;
            }
            this.f25950a.f25949d.clear();
        }
    }

    /* loaded from: classes4.dex */
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
            C1213c c1213c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1213c) || (c1213c = (C1213c) obj) == null) {
                    return;
                }
                c1213c.f25954d = false;
                c1213c.f25951a = false;
                c1213c.f25952b = 0;
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
        this.f25946a = new a(this, 2005016);
        this.f25948c = new b(this, Looper.getMainLooper());
        f25944e = c.a.o0.s.d0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f25946a);
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f25945f == null) {
                synchronized (t.class) {
                    if (f25945f == null) {
                        f25945f = new c();
                    }
                }
            }
            return f25945f;
        }
        return (c) invokeV.objValue;
    }

    public static void l(FrsViewData frsViewData, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i2).param("obj_type", i3);
        if (context != null) {
            c.a.o0.l0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(c2 c2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) && c2Var != null && c2Var.T1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", c2Var.T());
            statisticItem.param("obj_source", c2Var.U0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, c2Var.V0);
            statisticItem.param("obj_param1", c2Var.Y0);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", c2Var.q1());
            t.b().a(statisticItem);
        }
    }

    public void c(c.a.p0.v0.j2.b bVar, c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, c2Var) == null) || bVar == null || !bVar.f25937a || c2Var == null || c2Var.q1() == null) {
            return;
        }
        if (this.f25949d == null) {
            this.f25949d = new SparseArray<>();
        }
        if (this.f25949d.get(bVar.f25940d) == null) {
            this.f25949d.put(bVar.f25940d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f25949d.get(bVar.f25940d);
        String q1 = c2Var.q1();
        if (bVar.f25941e >= 0) {
            q1 = q1 + "_" + bVar.f25941e;
        }
        if (hashSet.contains(q1) || f()) {
            return;
        }
        hashSet.add(q1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f25939c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", c2Var.U0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, c2Var.V0);
        statisticItem.param("obj_param1", c2Var.W0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, c2Var.Y0);
        statisticItem.param("tid", c2Var.q1());
        statisticItem.param("nid", c2Var.D0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f25940d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = c2Var.Q1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (c2Var.t1() == null || (c2Var.t1().K() == null && c2Var.t1().V() == null)) ? 0 : 1;
        if (i4 != 0 && c2Var.t1().K() != null && c2Var.t1().K().y() != null && c2Var.t1().K().y().size() > 0) {
            statisticItem.param("obj_name", c2Var.t1().N ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = c2Var.getType() == c2.D3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && c2Var.J() != null && !StringUtils.isNull(c2Var.J().getName_show())) {
            statisticItem.param("obj_name", c2Var.J().getName_show());
        }
        if (!c2Var.M1() && !c2Var.L1()) {
            if (c2Var.J1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        t.b().a(statisticItem);
        if (c2Var.A2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f25939c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", c2Var.U0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, c2Var.V0);
            statisticItem2.param("obj_param1", c2Var.W0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, c2Var.Y0);
            statisticItem2.param("tid", c2Var.q1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f25940d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f25939c);
            statisticItem3.param("tid", c2Var.q1());
            t.b().a(statisticItem3);
        }
    }

    public void d(c2 c2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c2Var, hashSet) == null) && c2Var != null && c2Var.u2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (c2Var.q1() == null || hashSet.contains(c2Var.q1())) {
                return;
            }
            hashSet.add(c2Var.q1());
            t.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", c2Var.q1()));
        }
    }

    public void e(c2 c2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, c2Var, z) == null) || c2Var == null) {
            return;
        }
        t.b().a(new StatisticItem("c12125").param("tid", c2Var.f0()).param("obj_locate", z ? 2 : 1).param("obj_id", c2Var.j1() != null ? c2Var.j1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f25947b == null) {
                this.f25947b = new C1213c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1213c c1213c = this.f25947b;
            if (c1213c.f25954d) {
                return true;
            }
            if (c1213c.f25951a) {
                int i2 = c1213c.f25952b + 1;
                c1213c.f25952b = i2;
                if (currentTimeMillis - c1213c.f25953c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f25944e) {
                        c1213c.f25954d = true;
                        h(c1213c);
                        return true;
                    }
                } else {
                    c1213c.f25951a = false;
                    c1213c.f25952b = 0;
                }
            } else {
                c1213c.f25951a = true;
                c1213c.f25953c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(c.a.p0.v0.j2.b bVar, c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, bVar, c2Var, i2) == null) || bVar == null || !bVar.f25937a || c2Var == null || c2Var.q1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f25939c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", c2Var.U0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, c2Var.V0);
        statisticItem.param("obj_param1", c2Var.W0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, c2Var.Y0);
        statisticItem.param("tid", c2Var.q1());
        statisticItem.param("nid", c2Var.D0());
        if (!c2Var.M1() && !c2Var.L1()) {
            if (c2Var.J1()) {
                statisticItem.param("obj_type", 13);
            } else {
                statisticItem.param("obj_type", i2);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        statisticItem.param(TiebaStatic.Params.OBJ_TO, i(c2Var));
        int i3 = bVar.f25940d;
        if (i3 >= 0) {
            statisticItem.param("tab_id", i3);
        }
        int i4 = c2Var.Q1;
        if (i4 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
        }
        statisticItem.param("thread_type", c2Var.getType() == c2.D3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (c2Var.A2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f25939c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", c2Var.U0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, c2Var.V0);
            statisticItem2.param("obj_param1", c2Var.W0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, c2Var.Y0);
            statisticItem2.param("tid", c2Var.q1());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(c2Var));
            TiebaStatic.log(statisticItem2);
        }
        if (bVar.f25940d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f25939c);
            statisticItem3.param("tid", c2Var.q1());
            t.b().a(statisticItem3);
        }
        if (c2Var.J() == null || c2Var.J().getAlaUserData() == null) {
            return;
        }
        AlaUserInfoData alaUserData = c2Var.J().getAlaUserData();
        if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
            return;
        }
        StatisticItem statisticItem4 = new StatisticItem("c11850");
        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem4);
    }

    public final void h(C1213c c1213c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1213c) == null) {
            Message obtainMessage = this.f25948c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1213c;
            this.f25948c.removeMessages(5);
            this.f25948c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String i(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, c2Var)) == null) {
            if (c2Var.c1) {
                return String.valueOf(c2Var.h0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int k(c.a.p0.v0.j2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f25942f;
            if (i2 > 0) {
                if (bVar.f25940d == 1120) {
                    return 15;
                }
                if (bVar.f25943g == 3) {
                    return 13;
                }
                return i2;
            }
            int i3 = bVar.f25938b;
            if (i3 == 8) {
                i3 = 9;
            }
            if (bVar.f25940d == 504) {
                i3 = 11;
            }
            if (bVar.f25940d == 1120) {
                return 15;
            }
            return i3;
        }
        return invokeL.intValue;
    }

    /* renamed from: c.a.p0.v0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1213c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f25951a;

        /* renamed from: b  reason: collision with root package name */
        public int f25952b;

        /* renamed from: c  reason: collision with root package name */
        public long f25953c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f25954d;

        public C1213c(c cVar) {
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
            this.f25951a = false;
            this.f25952b = 0;
            this.f25954d = false;
        }

        public /* synthetic */ C1213c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
