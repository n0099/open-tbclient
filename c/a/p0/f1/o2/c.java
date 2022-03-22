package c.a.p0.f1.o2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.h0.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f14306e;

    /* renamed from: f  reason: collision with root package name */
    public static c f14307f;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener a;

    /* renamed from: b  reason: collision with root package name */
    public C1076c f14308b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f14309c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<HashSet<String>> f14310d;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f14310d == null) {
                return;
            }
            this.a.f14310d.clear();
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1076c c1076c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof C1076c) || (c1076c = (C1076c) obj) == null) {
                    return;
                }
                c1076c.f14313d = false;
                c1076c.a = false;
                c1076c.f14311b = 0;
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, 2005016);
        this.f14309c = new b(this, Looper.getMainLooper());
        f14306e = c.a.o0.r.j0.b.k().l("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.a);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f14307f == null) {
                synchronized (u.class) {
                    if (f14307f == null) {
                        f14307f = new c();
                    }
                }
            }
            return f14307f;
        }
        return (c) invokeV.objValue;
    }

    public static void m(FrsViewData frsViewData, int i, int i2, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i), Integer.valueOf(i2), context}) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i).param("obj_type", i2);
        if (context != null) {
            c.a.o0.o0.c.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && threadData.isFloor5Video()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("obj_source", threadData.mRecomSource);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem.param("obj_param1", threadData.mRecomReason);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", threadData.getTid());
            u.b().a(statisticItem);
        }
    }

    public void c(c.a.p0.f1.o2.b bVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, threadData) == null) || bVar == null || !bVar.a || threadData == null || threadData.getTid() == null) {
            return;
        }
        if (this.f14310d == null) {
            this.f14310d = new SparseArray<>();
        }
        if (this.f14310d.get(bVar.f14302e) == null) {
            this.f14310d.put(bVar.f14302e, new HashSet<>());
        }
        HashSet<String> hashSet = this.f14310d.get(bVar.f14302e);
        String tid = threadData.getTid();
        if (bVar.f14303f >= 0) {
            tid = tid + "_" + bVar.f14303f;
        }
        if (hashSet.contains(tid) || g()) {
            return;
        }
        hashSet.add(tid);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", bVar.f14300c);
        statisticItem.param("obj_locate", l(bVar));
        statisticItem.param("obj_source", threadData.mRecomSource);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
        statisticItem.param("obj_param1", threadData.mRecomAbTag);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("nid", threadData.getNid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i = bVar.f14302e;
        if (i >= 0) {
            statisticItem.param("tab_id", i);
        }
        int i2 = threadData.statFloor;
        if (i2 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
        }
        int i3 = (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().N() == null && threadData.getTopAgreePost().Z() == null)) ? 0 : 1;
        if (i3 != 0 && threadData.getTopAgreePost().N() != null && threadData.getTopAgreePost().N().A() != null && threadData.getTopAgreePost().N().A().size() > 0) {
            statisticItem.param("obj_name", threadData.getTopAgreePost().L ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i3);
        }
        boolean z = threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
            statisticItem.param("obj_name", threadData.getAuthor().getName_show());
        }
        if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
            if (threadData.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        u.b().a(statisticItem);
        if (threadData.isVideoThreadType()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", bVar.f14300c);
            statisticItem2.param("obj_locate", l(bVar));
            statisticItem2.param("obj_source", threadData.mRecomSource);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem2.param("obj_param1", threadData.mRecomAbTag);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
            statisticItem2.param("tid", threadData.getTid());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            u.b().a(statisticItem2);
        }
        if (bVar.f14302e == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", bVar.f14300c);
            statisticItem3.param("tid", threadData.getTid());
            u.b().a(statisticItem3);
        }
    }

    public void d(ThreadData threadData, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, threadData, hashSet) == null) && threadData != null && threadData.isTbReadDispatch()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (threadData.getTid() == null || hashSet.contains(threadData.getTid())) {
                return;
            }
            hashSet.add(threadData.getTid());
            u.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", threadData.getTid()));
        }
    }

    public void e(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, threadData, z) == null) || threadData == null) {
            return;
        }
        u.b().a(new StatisticItem("c12125").param("tid", threadData.getId()).param("obj_locate", z ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() != null ? threadData.getThreadAlaInfo().live_id : -1L).param("obj_type", 1));
    }

    public void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) || threadData == null) {
            return;
        }
        u.b().a(new StatisticItem("c14381").param("tid", threadData.getId()).param("fid", threadData.getFid()).param("fname", threadData.getForum_name()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f14308b == null) {
                this.f14308b = new C1076c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1076c c1076c = this.f14308b;
            if (c1076c.f14313d) {
                return true;
            }
            if (c1076c.a) {
                int i = c1076c.f14311b + 1;
                c1076c.f14311b = i;
                if (currentTimeMillis - c1076c.f14312c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i >= f14306e) {
                        c1076c.f14313d = true;
                        i(c1076c);
                        return true;
                    }
                } else {
                    c1076c.a = false;
                    c1076c.f14311b = 0;
                }
            } else {
                c1076c.a = true;
                c1076c.f14312c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(c.a.p0.f1.o2.b bVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, bVar, threadData, i) == null) || threadData == null || threadData.getTid() == null || bVar == null) {
            return;
        }
        if (bVar.a || threadData.isJumpToFrsVideoTabPlay) {
            u.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", bVar.f14300c);
            statisticItem.param("fname", bVar.f14301d);
            statisticItem.param("obj_locate", l(bVar));
            statisticItem.param("obj_source", threadData.mRecomSource);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem.param("obj_param1", threadData.mRecomAbTag);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("hid", c.a.p0.f1.l2.a.c());
            if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
                if (threadData.isBJHArticleThreadType()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, j(threadData));
            int i2 = bVar.f14302e;
            if (i2 >= 0) {
                statisticItem.param("tab_id", i2);
            }
            int i3 = threadData.statFloor;
            if (i3 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
            }
            statisticItem.param("thread_type", threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (threadData.isVideoThreadType()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", bVar.f14300c);
                statisticItem2.param("obj_locate", l(bVar));
                statisticItem2.param("obj_source", threadData.mRecomSource);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
                statisticItem2.param("obj_param1", threadData.mRecomAbTag);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
                statisticItem2.param("tid", threadData.getTid());
                statisticItem2.param("obj_type", i);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, j(threadData));
                TiebaStatic.log(statisticItem2);
            }
            if (bVar.f14302e == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", bVar.f14300c);
                statisticItem3.param("tid", threadData.getTid());
                u.b().a(statisticItem3);
            }
            if (threadData.getAuthor() == null || threadData.getAuthor().getAlaUserData() == null) {
                return;
            }
            AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
            if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
                return;
            }
            StatisticItem statisticItem4 = new StatisticItem("c11850");
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem4);
        }
    }

    public final void i(C1076c c1076c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1076c) == null) {
            Message obtainMessage = this.f14309c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1076c;
            this.f14309c.removeMessages(5);
            this.f14309c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
            if (threadData.isInsertThread) {
                return String.valueOf(threadData.getInsertFloor());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int l(c.a.p0.f1.o2.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            if (bVar == null) {
                return 5;
            }
            int i = bVar.f14299b;
            int i2 = bVar.f14305h;
            if (i2 == 100) {
                return 20;
            }
            int i3 = bVar.f14304g;
            if (i3 > 0) {
                if (bVar.f14302e == 1120) {
                    return 15;
                }
                if (i2 == 3) {
                    return 13;
                }
                return i3;
            }
            if (i == 8) {
                i = 9;
            }
            if (bVar.f14302e == 504) {
                i = 11;
            }
            if (bVar.f14302e == 1120) {
                return 15;
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* renamed from: c.a.p0.f1.o2.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1076c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f14311b;

        /* renamed from: c  reason: collision with root package name */
        public long f14312c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f14313d;

        public C1076c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.f14311b = 0;
            this.f14313d = false;
        }

        public /* synthetic */ C1076c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
