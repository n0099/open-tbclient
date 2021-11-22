package b.a.r0.x0.v2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.r0.b0.v;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f27998e;

    /* renamed from: f  reason: collision with root package name */
    public static c f27999f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f28000a;

    /* renamed from: b  reason: collision with root package name */
    public C1367c f28001b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f28002c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f28003d;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28004a;

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
            this.f28004a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f28004a.f28003d == null) {
                return;
            }
            this.f28004a.f28003d.clear();
        }
    }

    /* loaded from: classes6.dex */
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
            C1367c c1367c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1367c) || (c1367c = (C1367c) obj) == null) {
                    return;
                }
                c1367c.f28008d = false;
                c1367c.f28005a = false;
                c1367c.f28006b = 0;
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
        this.f28000a = new a(this, 2005016);
        this.f28002c = new b(this, Looper.getMainLooper());
        f27998e = b.a.q0.s.e0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f28000a);
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f27999f == null) {
                synchronized (v.class) {
                    if (f27999f == null) {
                        f27999f = new c();
                    }
                }
            }
            return f27999f;
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
            b.a.q0.n0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) && d2Var != null && d2Var.Y1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", d2Var.T());
            statisticItem.param("obj_source", d2Var.X0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem.param("obj_param1", d2Var.b1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", d2Var.t1());
            v.b().a(statisticItem);
        }
    }

    public void c(b.a.r0.x0.v2.b bVar, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, d2Var) == null) || bVar == null || !bVar.f27991a || d2Var == null || d2Var.t1() == null) {
            return;
        }
        if (this.f28003d == null) {
            this.f28003d = new SparseArray<>();
        }
        if (this.f28003d.get(bVar.f27994d) == null) {
            this.f28003d.put(bVar.f27994d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f28003d.get(bVar.f27994d);
        String t1 = d2Var.t1();
        if (bVar.f27995e >= 0) {
            t1 = t1 + "_" + bVar.f27995e;
        }
        if (hashSet.contains(t1) || f()) {
            return;
        }
        hashSet.add(t1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f27993c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", d2Var.X0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
        statisticItem.param("obj_param1", d2Var.Z0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
        statisticItem.param("tid", d2Var.t1());
        statisticItem.param("nid", d2Var.F0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f27994d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = d2Var.T1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (d2Var.w1() == null || (d2Var.w1().M() == null && d2Var.w1().Y() == null)) ? 0 : 1;
        if (i4 != 0 && d2Var.w1().M() != null && d2Var.w1().M().y() != null && d2Var.w1().M().y().size() > 0) {
            statisticItem.param("obj_name", d2Var.w1().P ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = d2Var.getType() == d2.J3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
            statisticItem.param("obj_name", d2Var.J().getName_show());
        }
        if (!d2Var.R1() && !d2Var.Q1()) {
            if (d2Var.O1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        v.b().a(statisticItem);
        if (d2Var.G2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f27993c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", d2Var.X0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem2.param("obj_param1", d2Var.Z0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
            statisticItem2.param("tid", d2Var.t1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            v.b().a(statisticItem2);
        }
        if (bVar.f27994d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f27993c);
            statisticItem3.param("tid", d2Var.t1());
            v.b().a(statisticItem3);
        }
    }

    public void d(d2 d2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d2Var, hashSet) == null) && d2Var != null && d2Var.A2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (d2Var.t1() == null || hashSet.contains(d2Var.t1())) {
                return;
            }
            hashSet.add(d2Var.t1());
            v.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", d2Var.t1()));
        }
    }

    public void e(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, d2Var, z) == null) || d2Var == null) {
            return;
        }
        v.b().a(new StatisticItem("c12125").param("tid", d2Var.f0()).param("obj_locate", z ? 2 : 1).param("obj_id", d2Var.m1() != null ? d2Var.m1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f28001b == null) {
                this.f28001b = new C1367c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1367c c1367c = this.f28001b;
            if (c1367c.f28008d) {
                return true;
            }
            if (c1367c.f28005a) {
                int i2 = c1367c.f28006b + 1;
                c1367c.f28006b = i2;
                if (currentTimeMillis - c1367c.f28007c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f27998e) {
                        c1367c.f28008d = true;
                        h(c1367c);
                        return true;
                    }
                } else {
                    c1367c.f28005a = false;
                    c1367c.f28006b = 0;
                }
            } else {
                c1367c.f28005a = true;
                c1367c.f28007c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(b.a.r0.x0.v2.b bVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, bVar, d2Var, i2) == null) || d2Var == null || d2Var.t1() == null || bVar == null) {
            return;
        }
        if (bVar.f27991a || d2Var.n) {
            v.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", bVar.f27993c);
            statisticItem.param("obj_locate", k(bVar));
            statisticItem.param("obj_source", d2Var.X0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem.param("obj_param1", d2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
            statisticItem.param("tid", d2Var.t1());
            statisticItem.param("nid", d2Var.F0());
            if (!d2Var.R1() && !d2Var.Q1()) {
                if (d2Var.O1()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i2);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, i(d2Var));
            int i3 = bVar.f27994d;
            if (i3 >= 0) {
                statisticItem.param("tab_id", i3);
            }
            int i4 = d2Var.T1;
            if (i4 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
            }
            statisticItem.param("thread_type", d2Var.getType() == d2.J3 ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (d2Var.G2()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", bVar.f27993c);
                statisticItem2.param("obj_locate", k(bVar));
                statisticItem2.param("obj_source", d2Var.X0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
                statisticItem2.param("obj_param1", d2Var.Z0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
                statisticItem2.param("tid", d2Var.t1());
                statisticItem2.param("obj_type", i2);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(d2Var));
                TiebaStatic.log(statisticItem2);
            }
            if (bVar.f27994d == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", bVar.f27993c);
                statisticItem3.param("tid", d2Var.t1());
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

    public final void h(C1367c c1367c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1367c) == null) {
            Message obtainMessage = this.f28002c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1367c;
            this.f28002c.removeMessages(5);
            this.f28002c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d2Var)) == null) {
            if (d2Var.f1) {
                return String.valueOf(d2Var.h0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int k(b.a.r0.x0.v2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f27992b;
            int i3 = bVar.f27997g;
            if (i3 == 100) {
                return 20;
            }
            int i4 = bVar.f27996f;
            if (i4 > 0) {
                if (bVar.f27994d == 1120) {
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
            if (bVar.f27994d == 504) {
                i2 = 11;
            }
            if (bVar.f27994d == 1120) {
                return 15;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* renamed from: b.a.r0.x0.v2.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1367c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28005a;

        /* renamed from: b  reason: collision with root package name */
        public int f28006b;

        /* renamed from: c  reason: collision with root package name */
        public long f28007c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28008d;

        public C1367c(c cVar) {
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
            this.f28005a = false;
            this.f28006b = 0;
            this.f28008d = false;
        }

        public /* synthetic */ C1367c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
