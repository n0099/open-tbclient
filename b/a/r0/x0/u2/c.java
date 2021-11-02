package b.a.r0.x0.u2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.r0.b0.u;
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
    public static int f26392e;

    /* renamed from: f  reason: collision with root package name */
    public static c f26393f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f26394a;

    /* renamed from: b  reason: collision with root package name */
    public C1294c f26395b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f26396c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f26397d;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26398a;

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
            this.f26398a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26398a.f26397d == null) {
                return;
            }
            this.f26398a.f26397d.clear();
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
            C1294c c1294c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1294c) || (c1294c = (C1294c) obj) == null) {
                    return;
                }
                c1294c.f26402d = false;
                c1294c.f26399a = false;
                c1294c.f26400b = 0;
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
        this.f26394a = new a(this, 2005016);
        this.f26396c = new b(this, Looper.getMainLooper());
        f26392e = b.a.q0.s.e0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f26394a);
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f26393f == null) {
                synchronized (u.class) {
                    if (f26393f == null) {
                        f26393f = new c();
                    }
                }
            }
            return f26393f;
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) && d2Var != null && d2Var.W1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", d2Var.T());
            statisticItem.param("obj_source", d2Var.X0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem.param("obj_param1", d2Var.b1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", d2Var.s1());
            u.b().a(statisticItem);
        }
    }

    public void c(b.a.r0.x0.u2.b bVar, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, d2Var) == null) || bVar == null || !bVar.f26385a || d2Var == null || d2Var.s1() == null) {
            return;
        }
        if (this.f26397d == null) {
            this.f26397d = new SparseArray<>();
        }
        if (this.f26397d.get(bVar.f26388d) == null) {
            this.f26397d.put(bVar.f26388d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f26397d.get(bVar.f26388d);
        String s1 = d2Var.s1();
        if (bVar.f26389e >= 0) {
            s1 = s1 + "_" + bVar.f26389e;
        }
        if (hashSet.contains(s1) || f()) {
            return;
        }
        hashSet.add(s1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f26387c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", d2Var.X0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
        statisticItem.param("obj_param1", d2Var.Z0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
        statisticItem.param("tid", d2Var.s1());
        statisticItem.param("nid", d2Var.F0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f26388d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = d2Var.T1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (d2Var.v1() == null || (d2Var.v1().M() == null && d2Var.v1().Y() == null)) ? 0 : 1;
        if (i4 != 0 && d2Var.v1().M() != null && d2Var.v1().M().y() != null && d2Var.v1().M().y().size() > 0) {
            statisticItem.param("obj_name", d2Var.v1().P ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = d2Var.getType() == d2.H3;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
            statisticItem.param("obj_name", d2Var.J().getName_show());
        }
        if (!d2Var.P1() && !d2Var.O1()) {
            if (d2Var.M1()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        u.b().a(statisticItem);
        if (d2Var.E2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f26387c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", d2Var.X0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem2.param("obj_param1", d2Var.Z0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
            statisticItem2.param("tid", d2Var.s1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            u.b().a(statisticItem2);
        }
        if (bVar.f26388d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f26387c);
            statisticItem3.param("tid", d2Var.s1());
            u.b().a(statisticItem3);
        }
    }

    public void d(d2 d2Var, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d2Var, hashSet) == null) && d2Var != null && d2Var.y2()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (d2Var.s1() == null || hashSet.contains(d2Var.s1())) {
                return;
            }
            hashSet.add(d2Var.s1());
            u.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", d2Var.s1()));
        }
    }

    public void e(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, d2Var, z) == null) || d2Var == null) {
            return;
        }
        u.b().a(new StatisticItem("c12125").param("tid", d2Var.f0()).param("obj_locate", z ? 2 : 1).param("obj_id", d2Var.l1() != null ? d2Var.l1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f26395b == null) {
                this.f26395b = new C1294c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1294c c1294c = this.f26395b;
            if (c1294c.f26402d) {
                return true;
            }
            if (c1294c.f26399a) {
                int i2 = c1294c.f26400b + 1;
                c1294c.f26400b = i2;
                if (currentTimeMillis - c1294c.f26401c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f26392e) {
                        c1294c.f26402d = true;
                        h(c1294c);
                        return true;
                    }
                } else {
                    c1294c.f26399a = false;
                    c1294c.f26400b = 0;
                }
            } else {
                c1294c.f26399a = true;
                c1294c.f26401c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(b.a.r0.x0.u2.b bVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, bVar, d2Var, i2) == null) || d2Var == null || d2Var.s1() == null || bVar == null) {
            return;
        }
        if (bVar.f26385a || d2Var.n) {
            u.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", bVar.f26387c);
            statisticItem.param("obj_locate", k(bVar));
            statisticItem.param("obj_source", d2Var.X0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
            statisticItem.param("obj_param1", d2Var.Z0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
            statisticItem.param("tid", d2Var.s1());
            statisticItem.param("nid", d2Var.F0());
            if (!d2Var.P1() && !d2Var.O1()) {
                if (d2Var.M1()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i2);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, i(d2Var));
            int i3 = bVar.f26388d;
            if (i3 >= 0) {
                statisticItem.param("tab_id", i3);
            }
            int i4 = d2Var.T1;
            if (i4 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
            }
            statisticItem.param("thread_type", d2Var.getType() == d2.H3 ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (d2Var.E2()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", bVar.f26387c);
                statisticItem2.param("obj_locate", k(bVar));
                statisticItem2.param("obj_source", d2Var.X0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.Y0);
                statisticItem2.param("obj_param1", d2Var.Z0);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.b1);
                statisticItem2.param("tid", d2Var.s1());
                statisticItem2.param("obj_type", i2);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(d2Var));
                TiebaStatic.log(statisticItem2);
            }
            if (bVar.f26388d == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", bVar.f26387c);
                statisticItem3.param("tid", d2Var.s1());
                u.b().a(statisticItem3);
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

    public final void h(C1294c c1294c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1294c) == null) {
            Message obtainMessage = this.f26396c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1294c;
            this.f26396c.removeMessages(5);
            this.f26396c.sendMessageDelayed(obtainMessage, 300000L);
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

    public int k(b.a.r0.x0.u2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f26386b;
            int i3 = bVar.f26391g;
            if (i3 == 100) {
                return 20;
            }
            int i4 = bVar.f26390f;
            if (i4 > 0) {
                if (bVar.f26388d == 1120) {
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
            if (bVar.f26388d == 504) {
                i2 = 11;
            }
            if (bVar.f26388d == 1120) {
                return 15;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* renamed from: b.a.r0.x0.u2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1294c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f26399a;

        /* renamed from: b  reason: collision with root package name */
        public int f26400b;

        /* renamed from: c  reason: collision with root package name */
        public long f26401c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f26402d;

        public C1294c(c cVar) {
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
            this.f26399a = false;
            this.f26400b = 0;
            this.f26402d = false;
        }

        public /* synthetic */ C1294c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
