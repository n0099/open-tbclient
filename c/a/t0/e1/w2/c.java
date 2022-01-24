package c.a.t0.e1.w2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.t0.g0.v;
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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f17053e;

    /* renamed from: f  reason: collision with root package name */
    public static c f17054f;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener a;

    /* renamed from: b  reason: collision with root package name */
    public C1075c f17055b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f17056c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f17057d;

    /* loaded from: classes7.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f17057d == null) {
                return;
            }
            this.a.f17057d.clear();
        }
    }

    /* loaded from: classes7.dex */
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
            C1075c c1075c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1075c) || (c1075c = (C1075c) obj) == null) {
                    return;
                }
                c1075c.f17060d = false;
                c1075c.a = false;
                c1075c.f17058b = 0;
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
        this.f17056c = new b(this, Looper.getMainLooper());
        f17053e = c.a.s0.s.i0.b.k().l("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.a);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f17054f == null) {
                synchronized (v.class) {
                    if (f17054f == null) {
                        f17054f = new c();
                    }
                }
            }
            return f17054f;
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
            c.a.s0.p0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) && e2Var != null && e2Var.a2()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", e2Var.U());
            statisticItem.param("obj_source", e2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, e2Var.a1);
            statisticItem.param("obj_param1", e2Var.d1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", e2Var.w1());
            v.b().a(statisticItem);
        }
    }

    public void c(c.a.t0.e1.w2.b bVar, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, e2Var) == null) || bVar == null || !bVar.a || e2Var == null || e2Var.w1() == null) {
            return;
        }
        if (this.f17057d == null) {
            this.f17057d = new SparseArray<>();
        }
        if (this.f17057d.get(bVar.f17049d) == null) {
            this.f17057d.put(bVar.f17049d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f17057d.get(bVar.f17049d);
        String w1 = e2Var.w1();
        if (bVar.f17050e >= 0) {
            w1 = w1 + "_" + bVar.f17050e;
        }
        if (hashSet.contains(w1) || g()) {
            return;
        }
        hashSet.add(w1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f17048c);
        statisticItem.param("obj_locate", l(bVar));
        statisticItem.param("obj_source", e2Var.Z0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, e2Var.a1);
        statisticItem.param("obj_param1", e2Var.b1);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, e2Var.d1);
        statisticItem.param("tid", e2Var.w1());
        statisticItem.param("nid", e2Var.H0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f17049d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = e2Var.T1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (e2Var.z1() == null || (e2Var.z1().N() == null && e2Var.z1().Z() == null)) ? 0 : 1;
        if (i4 != 0 && e2Var.z1().N() != null && e2Var.z1().N().y() != null && e2Var.z1().N().y().size() > 0) {
            statisticItem.param("obj_name", e2Var.z1().P ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = e2Var.getType() == e2.R3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && e2Var.J() != null && !StringUtils.isNull(e2Var.J().getName_show())) {
            statisticItem.param("obj_name", e2Var.J().getName_show());
        }
        if (!e2Var.T1() && !e2Var.S1()) {
            if (e2Var.Q1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        v.b().a(statisticItem);
        if (e2Var.I2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f17048c);
            statisticItem2.param("obj_locate", l(bVar));
            statisticItem2.param("obj_source", e2Var.Z0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, e2Var.a1);
            statisticItem2.param("obj_param1", e2Var.b1);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, e2Var.d1);
            statisticItem2.param("tid", e2Var.w1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            v.b().a(statisticItem2);
        }
        if (bVar.f17049d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f17048c);
            statisticItem3.param("tid", e2Var.w1());
            v.b().a(statisticItem3);
        }
    }

    public void d(e2 e2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, e2Var, hashSet) == null) && e2Var != null && e2Var.C2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (e2Var.w1() == null || hashSet.contains(e2Var.w1())) {
                return;
            }
            hashSet.add(e2Var.w1());
            v.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", e2Var.w1()));
        }
    }

    public void e(e2 e2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, e2Var, z) == null) || e2Var == null) {
            return;
        }
        v.b().a(new StatisticItem("c12125").param("tid", e2Var.h0()).param("obj_locate", z ? 2 : 1).param("obj_id", e2Var.p1() != null ? e2Var.p1().live_id : -1L).param("obj_type", 1));
    }

    public void f(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) || e2Var == null) {
            return;
        }
        v.b().a(new StatisticItem("c14381").param("tid", e2Var.h0()).param("fid", e2Var.U()).param("fname", e2Var.b0()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f17055b == null) {
                this.f17055b = new C1075c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1075c c1075c = this.f17055b;
            if (c1075c.f17060d) {
                return true;
            }
            if (c1075c.a) {
                int i2 = c1075c.f17058b + 1;
                c1075c.f17058b = i2;
                if (currentTimeMillis - c1075c.f17059c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f17053e) {
                        c1075c.f17060d = true;
                        i(c1075c);
                        return true;
                    }
                } else {
                    c1075c.a = false;
                    c1075c.f17058b = 0;
                }
            } else {
                c1075c.a = true;
                c1075c.f17059c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(c.a.t0.e1.w2.b bVar, e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, bVar, e2Var, i2) == null) || e2Var == null || e2Var.w1() == null || bVar == null) {
            return;
        }
        if (bVar.a || e2Var.n) {
            v.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", bVar.f17048c);
            statisticItem.param("obj_locate", l(bVar));
            statisticItem.param("obj_source", e2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, e2Var.a1);
            statisticItem.param("obj_param1", e2Var.b1);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, e2Var.d1);
            statisticItem.param("tid", e2Var.w1());
            statisticItem.param("nid", e2Var.H0());
            if (!e2Var.T1() && !e2Var.S1()) {
                if (e2Var.Q1()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i2);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, j(e2Var));
            int i3 = bVar.f17049d;
            if (i3 >= 0) {
                statisticItem.param("tab_id", i3);
            }
            int i4 = e2Var.T1;
            if (i4 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
            }
            statisticItem.param("thread_type", e2Var.getType() == e2.R3 ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (e2Var.I2()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", bVar.f17048c);
                statisticItem2.param("obj_locate", l(bVar));
                statisticItem2.param("obj_source", e2Var.Z0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, e2Var.a1);
                statisticItem2.param("obj_param1", e2Var.b1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, e2Var.d1);
                statisticItem2.param("tid", e2Var.w1());
                statisticItem2.param("obj_type", i2);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, j(e2Var));
                TiebaStatic.log(statisticItem2);
            }
            if (bVar.f17049d == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", bVar.f17048c);
                statisticItem3.param("tid", e2Var.w1());
                v.b().a(statisticItem3);
            }
            if (e2Var.J() == null || e2Var.J().getAlaUserData() == null) {
                return;
            }
            AlaUserInfoData alaUserData = e2Var.J().getAlaUserData();
            if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
                return;
            }
            StatisticItem statisticItem4 = new StatisticItem("c11850");
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem4);
        }
    }

    public final void i(C1075c c1075c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1075c) == null) {
            Message obtainMessage = this.f17056c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1075c;
            this.f17056c.removeMessages(5);
            this.f17056c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String j(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2Var)) == null) {
            if (e2Var.g1) {
                return String.valueOf(e2Var.j0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int l(c.a.t0.e1.w2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f17047b;
            int i3 = bVar.f17052g;
            if (i3 == 100) {
                return 20;
            }
            int i4 = bVar.f17051f;
            if (i4 > 0) {
                if (bVar.f17049d == 1120) {
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
            if (bVar.f17049d == 504) {
                i2 = 11;
            }
            if (bVar.f17049d == 1120) {
                return 15;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* renamed from: c.a.t0.e1.w2.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1075c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f17058b;

        /* renamed from: c  reason: collision with root package name */
        public long f17059c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17060d;

        public C1075c(c cVar) {
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
            this.f17058b = 0;
            this.f17060d = false;
        }

        public /* synthetic */ C1075c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
