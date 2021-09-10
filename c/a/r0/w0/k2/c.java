package c.a.r0.w0.k2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.r0.a0.t;
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
    public static int f26946e;

    /* renamed from: f  reason: collision with root package name */
    public static c f26947f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f26948a;

    /* renamed from: b  reason: collision with root package name */
    public C1263c f26949b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f26950c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f26951d;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26952a;

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
            this.f26952a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26952a.f26951d == null) {
                return;
            }
            this.f26952a.f26951d.clear();
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
            C1263c c1263c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1263c) || (c1263c = (C1263c) obj) == null) {
                    return;
                }
                c1263c.f26956d = false;
                c1263c.f26953a = false;
                c1263c.f26954b = 0;
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
        this.f26948a = new a(this, 2005016);
        this.f26950c = new b(this, Looper.getMainLooper());
        f26946e = c.a.q0.s.d0.b.j().k("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.f26948a);
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f26947f == null) {
                synchronized (t.class) {
                    if (f26947f == null) {
                        f26947f = new c();
                    }
                }
            }
            return f26947f;
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
            c.a.q0.n0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) && d2Var != null && d2Var.W1()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", d2Var.T());
            statisticItem.param("obj_source", d2Var.W0);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.X0);
            statisticItem.param("obj_param1", d2Var.a1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", d2Var.s1());
            t.b().a(statisticItem);
        }
    }

    public void c(c.a.r0.w0.k2.b bVar, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, d2Var) == null) || bVar == null || !bVar.f26939a || d2Var == null || d2Var.s1() == null) {
            return;
        }
        if (this.f26951d == null) {
            this.f26951d = new SparseArray<>();
        }
        if (this.f26951d.get(bVar.f26942d) == null) {
            this.f26951d.put(bVar.f26942d, new HashSet<>());
        }
        HashSet<String> hashSet = this.f26951d.get(bVar.f26942d);
        String s1 = d2Var.s1();
        if (bVar.f26943e >= 0) {
            s1 = s1 + "_" + bVar.f26943e;
        }
        if (hashSet.contains(s1) || f()) {
            return;
        }
        hashSet.add(s1);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f26941c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", d2Var.W0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.X0);
        statisticItem.param("obj_param1", d2Var.Y0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.a1);
        statisticItem.param("tid", d2Var.s1());
        statisticItem.param("nid", d2Var.F0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i2 = bVar.f26942d;
        if (i2 >= 0) {
            statisticItem.param("tab_id", i2);
        }
        int i3 = d2Var.S1;
        if (i3 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
        }
        int i4 = (d2Var.v1() == null || (d2Var.v1().K() == null && d2Var.v1().V() == null)) ? 0 : 1;
        if (i4 != 0 && d2Var.v1().K() != null && d2Var.v1().K().y() != null && d2Var.v1().K().y().size() > 0) {
            statisticItem.param("obj_name", d2Var.v1().N ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i4);
        }
        boolean z = d2Var.getType() == d2.G3;
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
        t.b().a(statisticItem);
        if (d2Var.E2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f26941c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", d2Var.W0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.X0);
            statisticItem2.param("obj_param1", d2Var.Y0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.a1);
            statisticItem2.param("tid", d2Var.s1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            t.b().a(statisticItem2);
        }
        if (bVar.f26942d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f26941c);
            statisticItem3.param("tid", d2Var.s1());
            t.b().a(statisticItem3);
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
            t.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", d2Var.s1()));
        }
    }

    public void e(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, d2Var, z) == null) || d2Var == null) {
            return;
        }
        t.b().a(new StatisticItem("c12125").param("tid", d2Var.f0()).param("obj_locate", z ? 2 : 1).param("obj_id", d2Var.l1() != null ? d2Var.l1().live_id : -1L).param("obj_type", 1));
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f26949b == null) {
                this.f26949b = new C1263c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1263c c1263c = this.f26949b;
            if (c1263c.f26956d) {
                return true;
            }
            if (c1263c.f26953a) {
                int i2 = c1263c.f26954b + 1;
                c1263c.f26954b = i2;
                if (currentTimeMillis - c1263c.f26955c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= f26946e) {
                        c1263c.f26956d = true;
                        h(c1263c);
                        return true;
                    }
                } else {
                    c1263c.f26953a = false;
                    c1263c.f26954b = 0;
                }
            } else {
                c1263c.f26953a = true;
                c1263c.f26955c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(c.a.r0.w0.k2.b bVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, bVar, d2Var, i2) == null) || bVar == null || !bVar.f26939a || d2Var == null || d2Var.s1() == null) {
            return;
        }
        t.b().e(true);
        StatisticItem statisticItem = new StatisticItem("c11438");
        statisticItem.param("fid", bVar.f26941c);
        statisticItem.param("obj_locate", k(bVar));
        statisticItem.param("obj_source", d2Var.W0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.X0);
        statisticItem.param("obj_param1", d2Var.Y0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.a1);
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
        int i3 = bVar.f26942d;
        if (i3 >= 0) {
            statisticItem.param("tab_id", i3);
        }
        int i4 = d2Var.S1;
        if (i4 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i4);
        }
        statisticItem.param("thread_type", d2Var.getType() == d2.G3 ? 2 : 1);
        TiebaStatic.log(statisticItem);
        if (d2Var.E2()) {
            StatisticItem statisticItem2 = new StatisticItem("c12098");
            statisticItem2.param("fid", bVar.f26941c);
            statisticItem2.param("obj_locate", k(bVar));
            statisticItem2.param("obj_source", d2Var.W0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, d2Var.X0);
            statisticItem2.param("obj_param1", d2Var.Y0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, d2Var.a1);
            statisticItem2.param("tid", d2Var.s1());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_TO, i(d2Var));
            TiebaStatic.log(statisticItem2);
        }
        if (bVar.f26942d == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13260");
            statisticItem3.param("fid", bVar.f26941c);
            statisticItem3.param("tid", d2Var.s1());
            t.b().a(statisticItem3);
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

    public final void h(C1263c c1263c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1263c) == null) {
            Message obtainMessage = this.f26950c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1263c;
            this.f26950c.removeMessages(5);
            this.f26950c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d2Var)) == null) {
            if (d2Var.e1) {
                return String.valueOf(d2Var.h0());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int k(c.a.r0.w0.k2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i2 = bVar.f26944f;
            if (i2 > 0) {
                if (bVar.f26942d == 1120) {
                    return 15;
                }
                if (bVar.f26945g == 3) {
                    return 13;
                }
                return i2;
            }
            int i3 = bVar.f26940b;
            if (i3 == 8) {
                i3 = 9;
            }
            if (bVar.f26942d == 504) {
                i3 = 11;
            }
            if (bVar.f26942d == 1120) {
                return 15;
            }
            return i3;
        }
        return invokeL.intValue;
    }

    /* renamed from: c.a.r0.w0.k2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1263c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f26953a;

        /* renamed from: b  reason: collision with root package name */
        public int f26954b;

        /* renamed from: c  reason: collision with root package name */
        public long f26955c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f26956d;

        public C1263c(c cVar) {
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
            this.f26953a = false;
            this.f26954b = 0;
            this.f26956d = false;
        }

        public /* synthetic */ C1263c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
