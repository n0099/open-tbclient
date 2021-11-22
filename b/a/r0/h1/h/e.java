package b.a.r0.h1.h;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.l.w0.a;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.m1;
import b.a.q0.s.q.o1;
import b.a.q0.s.q.p0;
import b.a.r0.k0.a;
import b.a.r0.x0.n1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageBrowseModelTipView;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.App;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public b.a.r0.h1.h.j.h E;
    public boolean F;
    public BdUniqueId G;
    public SmartBubbleAnimatedView H;
    public HomePageYoungsterTopView I;
    public HomePageBrowseModelTipView J;
    public int K;
    public BdUniqueId L;
    public a.C0092a M;
    public ThreadInfo N;
    public RecyclerView.OnScrollListener O;
    public View.OnTouchListener P;
    public a.b Q;
    public final CustomMessageListener R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public final long f18771a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.r0.h1.h.b f18772b;
    public Runnable b0;

    /* renamed from: c  reason: collision with root package name */
    public l0 f18773c;
    public b.a.r0.h1.h.d c0;

    /* renamed from: d  reason: collision with root package name */
    public final List<b.a.e.m.e.n> f18774d;
    public CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f18775e;
    public CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public int f18776f;
    public CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18777g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18778h;
    public CustomMessageListener h0;

    /* renamed from: i  reason: collision with root package name */
    public int f18779i;
    public CustomMessageListener i0;
    public final TbPageContext<?> j;
    public b.a.e.c.g.a j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public CustomMessageListener l0;
    public final b.a.r0.h1.h.h.d0 m;
    public final b.a.e.c.g.a m0;
    public int n;
    public CustomMessageListener n0;
    public n1 o;
    public final b.a.r0.h1.h.k.b p;
    public b.a.r0.m3.j0.f q;
    public b.a.q0.q0.c r;
    public ScrollFragmentTabHost s;
    public b.a.r0.k0.a t;
    public boolean u;
    public b.a.r0.q2.i v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18780e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18780e = eVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder b0 = this.f18780e.b0();
                if (b0 != null && b0.getCardView() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(b0.getCardView().n(new a.C0092a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18781a = eVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            b.a.r0.h1.k.b.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0) {
                return;
            }
            for (b.a.e.m.e.n nVar : this.f18781a.f18774d) {
                if ((nVar instanceof b.a.r0.h1.k.b.c.a) && (bVar = ((b.a.r0.h1.k.b.c.a) nVar).c0) != null && j2 == bVar.f19109b) {
                    bVar.f19110c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18782a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18782a = eVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f18782a.r0();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18783a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f18784e;

            public a(b0 b0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18784e = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18784e.f18783a.m.m();
                    if (this.f18784e.f18783a.y || !this.f18784e.f18783a.z) {
                        return;
                    }
                    this.f18784e.f18783a.v.n(this.f18784e.f18783a.w, this.f18784e.f18783a.x, this.f18784e.f18783a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18783a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<b.a.e.m.e.n> h2 = this.f18783a.m.h();
                if (!ListUtils.isEmpty(h2)) {
                    for (b.a.e.m.e.n nVar : h2) {
                        if (nVar instanceof b.a.r0.b0.f0.k) {
                            b.a.r0.b0.f0.k kVar = (b.a.r0.b0.f0.k) nVar;
                            if (kVar.o != 0 && (d2Var = kVar.f16235e) != null) {
                                int[] g0 = d2Var.g0();
                                kVar.o = g0[0];
                                kVar.p = g0[1];
                            }
                        }
                    }
                }
                b.a.e.f.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.q0.c1.i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.h1.h.k.g.h().f() : (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18785a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18785a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m1)) {
                m1 m1Var = (m1) customResponsedMessage.getData();
                if (m1Var.f14179a != 1) {
                    return;
                }
                int k = b.a.e.f.p.l.k(TbadkCoreApplication.getInst());
                int i2 = b.a.e.f.p.l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f18785a.L);
                requestGetMyPostNetMessage.setParams(b.a.e.f.m.b.g(m1Var.f14181c, 0L), 0L, 0L, k, i2, f2, i3);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a.q0.c1.q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18786a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18786a = eVar;
        }

        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f18786a.u0(dataRes);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.q0.c1.q
        public /* bridge */ /* synthetic */ void onReturnDataInUI(DataRes dataRes) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                a(dataRes);
            } finally {
                TTIStats.record("PersonalizedUpdateController$13.onReturnDataInUI", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18787a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18787a = eVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responseData == null || (dataRes = responseData.data) == null || (threadInfo = dataRes.thread_info) == null) {
                    return;
                }
                this.f18787a.N = threadInfo;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    }

    /* renamed from: b.a.r0.h1.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0957e extends b.a.q0.c1.i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f18788a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18789b;

        public C0957e(e eVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18789b = eVar;
            this.f18788a = builder;
        }

        @Override // b.a.q0.c1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f18788a.build(true));
                this.f18789b.f18772b.g(builder.thread_list);
                b.a.q0.s.r.a.f();
                try {
                    b.a.q0.s.r.a.e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18790a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18790a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && b.a.q0.t.h.a.e(TbadkCoreApplication.getInst(), 1)) {
                b.a.q0.t.h.a.g(this.f18790a.j, 7, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends b.a.q0.c1.i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f18791a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18792b;

        public f(e eVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18792b = eVar;
            this.f18791a = builder;
        }

        @Override // b.a.q0.c1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f18791a.build(true));
                this.f18792b.f18772b.g(builder.thread_list);
                b.a.q0.s.r.a.f();
                try {
                    b.a.q0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18793e;

        public f0(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18793e = eVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f18793e.t != null) {
                    this.f18793e.t.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18794e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18794e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f18794e.j, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18795a;

        public g0(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18795a = eVar;
        }

        @Override // b.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f18795a.u = false;
            }
        }

        @Override // b.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f18795a.u = true;
            }
        }

        @Override // b.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.k0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements HomePageYoungsterTopView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18796a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18796a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f18796a.k == null) {
                return;
            }
            this.f18796a.v.w();
            this.f18796a.z = false;
            this.f18796a.l.setRefreshing(true);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18797a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18797a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d2) || this.f18797a.f18775e == null || ListUtils.getCount(this.f18797a.f18775e.thread_list) == 0 || (d2Var = (d2) customResponsedMessage.getData()) == null || d2Var.L0() == null || d2Var.f0() == null || ListUtils.getCount(this.f18797a.f18775e.thread_list) == 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f18797a.f18775e.thread_list.size(); i2++) {
                ThreadInfo threadInfo = this.f18797a.f18775e.thread_list.get(i2);
                if (threadInfo != null && threadInfo.id.longValue() == b.a.e.f.m.b.g(d2Var.f0(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) d2Var.L0().getNum());
                    builder.zan = builder2.build(true);
                    this.f18797a.f18775e.thread_list.set(i2, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18798a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18798a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f18798a.k == null) {
                return;
            }
            this.f18798a.Y();
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18799a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18799a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage)) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(this.f18799a.f18774d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i2 = 0; i2 < originData.size(); i2++) {
                    if ((originData.get(i2) instanceof d2) && (d2Var = (d2) originData.get(i2)) != null && d2Var.m1() != null && ids.contains(Long.valueOf(d2Var.m1().live_id))) {
                        this.f18799a.f18774d.remove(d2Var);
                    }
                }
                if (this.f18799a.m != null) {
                    this.f18799a.m.z(new ArrayList(this.f18799a.f18774d));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18800a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18800a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    ((Integer) data).intValue();
                }
                if (b.a.q0.f1.b.c.d()) {
                    this.f18800a.U0(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ScrollFragmentTabHost.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18801a;

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18801a = eVar;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f18801a.s.getTabType(i2) == 1 || this.f18801a.o == null) {
                return;
            }
            this.f18801a.o.d();
        }
    }

    /* loaded from: classes4.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18802a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18802a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Boolean bool = Boolean.FALSE;
            if (customResponsedMessage.getData() instanceof Boolean) {
                bool = (Boolean) customResponsedMessage.getData();
            }
            if (bool.booleanValue()) {
                this.f18802a.S0(true);
            } else {
                this.f18802a.S0(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18803a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18803a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f18803a.f18775e == null || ListUtils.isEmpty(this.f18803a.f18775e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f46519c)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f18803a.f18775e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = this.f18803a.f18775e.thread_list.get(i2);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != b.a.e.f.m.b.g(updateAttentionMessage.getData().f46519c, -1L)) {
                    i2++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().f46520d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().f46520d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().f46520d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    this.f18803a.f18775e.thread_list.set(i2, builder.build(true));
                }
            }
            this.f18803a.X0(updateAttentionMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface l0 {
        void a(int i2, b.a.q0.c1.e eVar, int i3);

        void b();

        void c(int i2, int i3, b.a.q0.c1.e eVar, int i4);

        void d(boolean z);

        void onError(int i2, String str);
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18804a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18804a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.f18804a.f18775e == null || this.f18804a.f18775e.hot_recomforum == null || ListUtils.isEmpty(this.f18804a.f18775e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.f18804a.f18775e.hot_recomforum);
            if (b.a.r0.h1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.f18804a.f18775e.hot_recomforum = builder.build(true);
                this.f18804a.D0(new DataRes.Builder(this.f18804a.f18775e.build(true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends b.a.q0.c1.i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f18805a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f18806b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f18807c;

        public n(e eVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18807c = eVar;
            this.f18805a = str;
            this.f18806b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.c1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    b.a.q0.s.r.a.f();
                    b.a.e.f.d.l<byte[]> e2 = b.a.q0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e2 == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = e2.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i2 = 0; i2 < builder.thread_list.size(); i2++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == b.a.e.f.m.b.g(this.f18805a, -1L)) {
                                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                    User.Builder builder3 = new User.Builder(builder2.author);
                                    builder3.is_like = Integer.valueOf(this.f18806b ? 1 : 0);
                                    builder3.has_concerned = Integer.valueOf(this.f18806b ? 1 : 0);
                                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                    if (this.f18806b) {
                                        intValue = builder3.fans_num.intValue() + 1;
                                        builder4.followed = 1;
                                    } else {
                                        intValue = builder3.fans_num.intValue() - 1;
                                        builder4.followed = 0;
                                    }
                                    builder3.fans_num = Integer.valueOf(intValue);
                                    builder3.god_data = builder4.build(true);
                                    builder2.author = builder3.build(true);
                                    builder.thread_list.set(i2, builder2.build(true));
                                }
                            }
                            DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                            this.f18807c.f18772b.g(builder5.thread_list);
                            e2.g("0", builder5.build(true).toByteArray());
                            return Boolean.TRUE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                } catch (Exception e3) {
                    BdLog.e(e3);
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements b.a.q0.c1.q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends b.a.q0.c1.i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18809b;

        public p(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18809b = eVar;
            this.f18808a = i2;
        }

        @Override // b.a.q0.c1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.f.d.l<String> h2 = b.a.q0.s.r.a.h(this.f18809b.Z, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f18809b.Z, Integer.toString(this.f18808a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements b.a.r0.h1.h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18810a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18811e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ q f18812f;

            public a(q qVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18812f = qVar;
                this.f18811e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18812f.f18810a.k.getHandler() == null) {
                    return;
                }
                this.f18812f.f18810a.k.requestFocusFromTouch();
                if (this.f18811e > this.f18812f.f18810a.k.getCount() - 1) {
                    return;
                }
                this.f18812f.f18810a.k.setSelection(this.f18811e);
            }
        }

        public q(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18810a = eVar;
        }

        @Override // b.a.r0.h1.h.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f18810a.b0 == null) {
                    this.f18810a.b0 = new a(this, i2);
                }
                this.f18810a.k.removeCallbacks(this.f18810a.b0);
                this.f18810a.k.post(this.f18810a.b0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends b.a.q0.c1.i0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18813a;

        public r(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18813a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.f.d.l<String> h2 = b.a.q0.s.r.a.h(this.f18813a.Z, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    return h2.get(this.f18813a.Z);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements b.a.q0.c1.q<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.h1.h.d f18814a;

        public s(e eVar, b.a.r0.h1.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18814a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            b.a.r0.h1.h.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f18814a) == null) {
                return;
            }
            dVar.a(b.a.e.f.m.b.e(str, 0));
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18815a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18815a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f18815a.E == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            this.f18815a.f18774d.remove(this.f18815a.E);
            this.f18815a.m.z(new ArrayList(this.f18815a.f18774d));
            b.a.q0.s.e0.b.j().w("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18816a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18816a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18816a.Z(customResponsedMessage);
                if (this.f18816a.v == null || !this.f18816a.z) {
                    return;
                }
                this.f18816a.v.n(this.f18816a.w, this.f18816a.x, this.f18816a.u, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f18817a;

        /* renamed from: b  reason: collision with root package name */
        public int f18818b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18819c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f18820d;

        public v(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18820d = eVar;
            this.f18817a = -1;
            this.f18818b = 0;
            this.f18819c = false;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f18818b > i2) {
                    this.f18819c = true;
                }
                this.f18818b = i2;
                int i4 = (i3 + i2) - 1;
                if (!this.f18819c && this.f18817a != i4) {
                    this.f18817a = i4;
                    this.f18820d.y0(i4);
                }
                if (this.f18819c && this.f18817a != i2) {
                    this.f18817a = i2;
                    this.f18820d.y0(i2);
                }
                this.f18820d.a0 = i2;
                this.f18820d.w = i2;
                this.f18820d.x = i4;
                ThreadCardViewHolder b0 = this.f18820d.b0();
                if (b0 == null || b0.getCardView() == null) {
                    return;
                }
                b0.getCardView().n(this.f18820d.M);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (this.f18820d.r == null) {
                    this.f18820d.r = new b.a.q0.q0.c();
                    this.f18820d.r.a(1005);
                    this.f18820d.r.f13575e = 1;
                }
                if (i2 == 0) {
                    b.a.r0.h1.h.c.b(this.f18820d.k);
                    this.f18820d.r.e();
                    b.a.r0.b0.v.b().d(true);
                    b.a.r0.p.d.c().h("page_recommend", "show_");
                    b.a.r0.l3.c.g().h(this.f18820d.G, false);
                    this.f18819c = false;
                    if (this.f18820d.v == null || !this.f18820d.z || this.f18820d.y) {
                        return;
                    }
                    this.f18820d.v.m(this.f18820d.w, this.f18820d.x, this.f18820d.u, 1);
                    return;
                }
                this.f18820d.r.d();
                if (i2 == 1) {
                    if (this.f18820d.o != null) {
                        this.f18820d.o.d();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                int i5 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i4 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i5 = bdRecyclerView.getFirstVisiblePosition();
                    i4 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i5, (i4 - i5) + 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18821a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18821a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f18821a.Z(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f18822a;

        /* renamed from: b  reason: collision with root package name */
        public String f18823b;

        /* renamed from: c  reason: collision with root package name */
        public String f18824c;

        /* renamed from: d  reason: collision with root package name */
        public String f18825d;

        /* renamed from: e  reason: collision with root package name */
        public String f18826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18827f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18827f = eVar;
            this.f18822a = "";
            this.f18823b = "";
            this.f18824c = "";
            this.f18825d = "";
            this.f18826e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f18822a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f18823b = jSONObject.optString("tid", "");
                    this.f18824c = jSONObject.optString("fid", "");
                    this.f18825d = jSONObject.optString("liveId", "");
                    this.f18826e = jSONObject.optString("sid", "");
                } else if ((this.f18822a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f18822a)) && ((this.f18825d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f18825d)) && (this.f18826e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f18826e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f18823b);
                        jSONObject.put("fid", this.f18824c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f18827f.Z(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18828a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18828a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f18828a.f18775e == null || ListUtils.getCount(this.f18828a.f18775e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e eVar = this.f18828a;
            eVar.W(str, eVar.f18774d);
            this.f18828a.V0(str);
            if (this.f18828a.m != null) {
                this.f18828a.m.z(new ArrayList(this.f18828a.f18774d));
            }
            if (this.f18828a.v == null || !this.f18828a.z) {
                return;
            }
            this.f18828a.v.n(this.f18828a.w, this.f18828a.x, this.f18828a.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18829a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f18829a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder b0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (b0 = this.f18829a.b0()) == null || b0.getCardView() == null) {
                    return;
                }
                b0.getCardView().n(new a.C0092a(3));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b.a.r0.h1.h.h.d0 d0Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, d0Var, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18773c = null;
        this.f18774d = new LinkedList();
        this.f18776f = 1;
        this.f18777g = false;
        this.f18778h = false;
        this.f18779i = 0;
        this.n = 2000;
        this.r = null;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = true;
        this.A = false;
        this.D = false;
        this.F = true;
        this.K = 0;
        this.L = BdUniqueId.gen();
        this.M = new a.C0092a(2);
        this.N = null;
        this.O = new v(this);
        this.P = new f0(this);
        this.Q = new g0(this);
        this.R = new h0(this, 2001399);
        this.S = new i0(this, 2921461);
        this.T = new j0(this, 2921486);
        this.U = new k0(this, 2921562);
        this.V = new i(this, 2004004);
        this.W = new j(this, 2921026);
        this.X = new l(this, 2001115);
        this.Y = new m(this, 0);
        this.Z = "lastReadReadPositionKey";
        this.a0 = 0;
        this.c0 = new q(this);
        this.d0 = new t(this, 2016569);
        this.e0 = new u(this, 2016488);
        this.f0 = new w(this, 2016553);
        this.g0 = new x(this, 2921547);
        this.h0 = new y(this, 2016331);
        this.i0 = new z(this, 2921381);
        this.j0 = new a0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.k0 = new b0(this, 2921414);
        this.l0 = new c0(this, 2921453);
        this.m0 = new d0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.n0 = new e0(this, 2921482);
        this.j = tbPageContext;
        this.K = b.a.q0.s.e0.b.j().k("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.P);
        if (b.a.q0.f1.b.c.d()) {
            U0(true);
        }
        b.a.r0.k0.a aVar = new b.a.r0.k0.a();
        this.t = aVar;
        aVar.d(this.Q);
        this.m = d0Var;
        this.p = new b.a.r0.h1.h.k.b();
        this.f18771a = b.a.q0.s.e0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.O);
        this.o = new n1();
        h0();
        b.a.r0.q2.i iVar = new b.a.r0.q2.i(this.j, this.k);
        this.v = iVar;
        iVar.p(1);
        this.v.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f18772b = new b.a.r0.h1.h.b(this.f18774d, this.m);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.H = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, b.a.e.f.p.l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        H0();
        this.k0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.k0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.m0.setTag(this.L);
        if (this.m0.getHttpMessageListener() != null) {
            this.m0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.m0.getSocketMessageListener() != null) {
            this.m0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.m0);
        MessageManager.getInstance().registerListener(this.l0);
        MessageManager.getInstance().registerListener(this.n0);
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) && z2) {
            this.m.m();
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ListUtils.getCount(this.f18774d) < this.p.e() - 40) {
                return;
            }
            List<b.a.e.m.e.n> list = null;
            b.a.r0.h1.h.k.d c2 = this.p.c(true, this.f18775e, null, 1);
            int i2 = 0;
            if (c2 != null) {
                list = c2.f18951a;
                int i3 = c2.f18953c;
                c2.f18953c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.f18774d.clear();
                this.f18774d.addAll(list);
                this.m.A(new LinkedList(this.f18774d), i2);
            }
        }
    }

    public final boolean C0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        List<b.a.e.m.e.n> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.K == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || i0())) {
                    J0();
                    this.f18775e = null;
                }
            } else if (z3 && i0()) {
                this.f18775e = null;
            }
            int size = z3 ? 0 : this.f18774d.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.f18774d.clear();
            b.a.r0.h1.h.k.d c2 = this.p.c(z2, this.f18775e, builder, !z3 ? 1 : 0);
            if (c2 != null) {
                list = c2.f18951a;
                this.f18779i = c2.f18952b;
                i2 = c2.f18953c;
                c2.f18953c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.f18774d.addAll(list);
                P(list, size);
                I0(!z3 ? 1 : 0, list, size);
                if (this.D) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.f18775e == null) {
                this.f18775e = builder;
                this.f18772b.j(builder.thread_list);
            }
            if (this.f18774d.size() != 0) {
                if (z3) {
                    if (dataRes.live_answer != null) {
                        b.a.r0.h1.h.j.h hVar = new b.a.r0.h1.h.j.h();
                        this.E = hVar;
                        hVar.g(dataRes.live_answer);
                        this.f18775e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.E = null;
                        this.f18775e.live_answer = null;
                    }
                    this.f18775e.float_info = dataRes.float_info;
                }
                long l2 = b.a.q0.s.e0.b.j().l("key_maintab_banner_close_time", 0L);
                if (this.E != null && !StringHelper.isTaday(l2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.f18774d.add(0, this.E);
                }
                LinkedList linkedList = new LinkedList(this.f18774d);
                b.a.r0.h1.h.h.d0 d0Var = this.m;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                d0Var.t(z5);
                this.m.A(linkedList, i2);
                b.a.r0.q2.i iVar = this.v;
                if (iVar != null && this.z) {
                    iVar.n(this.w, this.x, this.u, true);
                }
                z5 = true;
            }
            b.a.r0.h1.d.a.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = b.a.r0.h1.d.a.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                b.a.r0.h1.d.a.d().k(System.currentTimeMillis() - e2, 1);
                b.a.r0.h1.d.a.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                b.a.r0.u3.d.g(blockPopInfo);
            }
            o1 o1Var = new o1();
            o1Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, o1Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                b.a.q0.q0.l.b().H(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public final void D0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, builder) == null) {
            b.a.q0.c1.l0.b(new f(this, builder), null);
        }
    }

    public void E0(int i2, int i3) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || ListUtils.isEmpty(this.f18774d) || this.f18774d.size() <= i2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.f18774d.size() && i2 <= i3) {
            if (this.f18774d.get(i2).getType().getId() == d2.A3.getId() && (d2Var = (d2) this.f18774d.get(i2)) != null && d2Var.m1() != null) {
                arrayList.add(Long.valueOf(d2Var.m1().live_id));
                arrayList2.add(d2Var);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.q2.i iVar = this.v;
            if (iVar != null && !this.y && this.z) {
                iVar.n(this.w, this.x, this.u, true);
            }
            if (this.A) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.isSupportMsgRemind()) {
                    boolean z2 = this.B;
                    if (z2) {
                        b.a.r0.l3.c.g().h(this.G, false);
                        if (j0(false)) {
                            T0(3, this.f18779i);
                        } else if (this.C > 0) {
                            T0(2, this.f18779i);
                        }
                    } else if (!z2 && this.f18779i == 0) {
                        T0(2, 0);
                    }
                }
                this.A = false;
                this.B = false;
                this.C = 0;
                if (this.D) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
                this.D = false;
            }
        }
    }

    public void G0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.G = bdUniqueId;
        CustomMessageListener customMessageListener = this.V;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
        CustomMessageListener customMessageListener2 = this.R;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.R);
        }
        this.S.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.S);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.Y);
        MessageManager.getInstance().registerListener(2001336, this.Y);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.e0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e0);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        b.a.r0.q2.i iVar = this.v;
        if (iVar != null) {
            iVar.t(bdUniqueId);
        }
        this.f18772b.i(bdUniqueId);
        this.d0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        this.T.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.T);
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void I0(int i2, List<b.a.e.m.e.n> list, int i3) {
        b.a.r0.m3.j0.f fVar;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) == null) || (fVar = this.q) == null) {
            return;
        }
        if (i2 == 0) {
            fVar.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = b.a.r0.m3.j0.f.f22455e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof b.a.r0.b0.f0.b) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.q.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void J0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (builder = this.f18775e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        T(builder2, list2 != null ? list2.size() : 0);
        b.a.q0.c1.l0.b(new C0957e(this, builder2), null);
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.r0.h1.h.c.c(this.k);
        }
    }

    public void L0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            this.F = z2;
            n1 n1Var = this.o;
            if (n1Var == null || z2) {
                return;
            }
            n1Var.d();
        }
    }

    public final void M0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.f18777g = z2;
        }
    }

    public void N0(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l0Var) == null) {
            this.f18773c = l0Var;
        }
    }

    public void O0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.z = z2;
        }
    }

    public final void P(List<b.a.e.m.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, list, i2) == null) {
            Set<b.a.e.m.e.n> a2 = b.a.r0.a3.a.a(list, this.f18776f, "NEWINDEX");
            if (a2.size() > 0) {
                b.a.r0.l3.c.g().c(this.G, b.a.r0.l3.a.h("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void P0(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost == null) {
                return;
            }
            scrollFragmentTabHost.setOnTabSelectedListener(new k(this));
        }
    }

    public final b.a.q0.c1.e Q(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z2)) == null) {
            String e2 = b.a.r0.a3.a.e(this.f18774d, z2);
            int S = S(z2);
            b.a.q0.c1.e eVar = new b.a.q0.c1.e();
            eVar.f12764b = e2;
            eVar.f12763a = S;
            return eVar;
        }
        return (b.a.q0.c1.e) invokeZ.objValue;
    }

    public void Q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.y = z2;
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            b.a.q0.c1.l0.b(new p(this, i2), null);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.q0.t.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (!activityPrizeData.g() || StringUtils.isNull(activityPrizeData.b())) {
                return;
            }
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            String str = "";
            String p2 = b.a.q0.s.e0.b.j().p("activity_prize_feed_text_time", "");
            boolean z2 = true;
            if (!StringUtils.isNull(p2)) {
                String[] split = p2.split("@");
                if (split != null && split.length == 2) {
                    String str2 = split[0];
                    String[] split2 = split[1].split(",");
                    if (!StringUtils.isNull(str2) && split2.length != 0) {
                        if (str2.equals(currentDay)) {
                            List<String> asList = Arrays.asList(split2);
                            if (asList.contains(currentAccount)) {
                                z2 = false;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(currentDay);
                                sb.append("@");
                                for (String str3 : asList) {
                                    sb.append(str3);
                                    sb.append(",");
                                }
                                sb.append(currentAccount);
                                str = sb.toString();
                            }
                        } else {
                            str = currentDay + "@" + currentAccount;
                        }
                    } else {
                        str = currentDay + "@" + currentAccount;
                    }
                } else {
                    str = currentDay + "@" + currentAccount;
                }
            } else {
                str = currentDay + "@" + currentAccount;
            }
            if (z2) {
                T0(4, 0);
                b.a.q0.s.e0.b.j().x("activity_prize_feed_text_time", str);
            }
        }
    }

    public int S(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z2)) == null) {
            List<b.a.e.m.e.n> list = this.f18774d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.f18774d.size()) {
                    b.a.e.m.e.n nVar = this.f18774d.get(i4);
                    if ((nVar instanceof b.a.r0.b0.f0.b) && (i3 = ((b.a.r0.b0.f0.b) nVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((nVar instanceof b.a.r0.h1.h.j.a) && nVar.getType() != AdvertAppInfo.u4) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.f18774d.size() - 1; size >= 0; size--) {
                    b.a.e.m.e.n nVar2 = this.f18774d.get(size);
                    if ((nVar2 instanceof b.a.r0.b0.f0.b) && (i2 = ((b.a.r0.b0.f0.b) nVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((nVar2 instanceof b.a.r0.h1.h.j.a) && nVar2.getType() != AdvertAppInfo.u4) {
                        return i4;
                    }
                }
            }
            return this.f18774d.size();
        }
        return invokeZ.intValue;
    }

    public final void S0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            if (z2) {
                if (this.J == null) {
                    HomePageBrowseModelTipView homePageBrowseModelTipView = new HomePageBrowseModelTipView(this.j.getPageActivity());
                    this.J = homePageBrowseModelTipView;
                    homePageBrowseModelTipView.setListener(new g(this));
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setHeaderView(this.J, false);
                    this.J.setVisibility(0);
                    this.k.scrollToPosition(0);
                    return;
                }
                return;
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView2 = this.J;
            if (homePageBrowseModelTipView2 != null) {
                this.k.removeHeaderView(homePageBrowseModelTipView2);
                this.J.setVisibility(8);
                this.J = null;
            }
        }
    }

    public final void T(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, builder, i2) == null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = b.a.r0.a3.c.b(next);
                if (b2 < 0) {
                    it.remove();
                } else if (b2 < i2 + i3 + 1) {
                    i3++;
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        builder.banner_list = builder2.build(false);
    }

    public final void T0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) || m0()) {
            return;
        }
        if (this.s != null) {
            this.o.f();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null && scrollFragmentTabHost.getCurrentTabType() != 1) {
            this.o.d();
        } else if (!this.F) {
            this.o.d();
        } else {
            String str = null;
            if (i2 == 2) {
                if (i3 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i3));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                }
            } else if (i2 == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
            } else if (i2 == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().b();
            }
            if (TextUtils.isEmpty(str) || !b.a.e.f.p.j.z()) {
                return;
            }
            if (i2 == 4) {
                this.n = 3000;
            } else {
                this.n = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
            smartBubbleAnimatedView.tipText = str;
            smartBubbleAnimatedView.delayDuring = this.n;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.s;
            if (scrollFragmentTabHost2 != null) {
                FrameLayout frameLayout = scrollFragmentTabHost2.getFrameLayout();
                frameLayout.removeView(this.H);
                frameLayout.addView(this.H, layoutParams);
                this.H.playExpansionAnimation();
            }
        }
    }

    public final void U(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public final void U0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            boolean g2 = b.a.q0.s.e0.b.j().g("key_youngster_homgpage_top_view_closed", false);
            if (this.k == null || g2) {
                return;
            }
            if (z2) {
                if (this.I == null) {
                    HomePageYoungsterTopView homePageYoungsterTopView = new HomePageYoungsterTopView(this.j);
                    this.I = homePageYoungsterTopView;
                    homePageYoungsterTopView.setOnDeleteClick(new h(this));
                }
                this.k.setHeaderView(this.I, false);
                this.I.setVisibility(0);
                this.k.scrollToPosition(0);
                return;
            }
            HomePageYoungsterTopView homePageYoungsterTopView2 = this.I;
            if (homePageYoungsterTopView2 != null) {
                homePageYoungsterTopView2.setVisibility(8);
                this.k.removeHeaderView(this.I);
                this.I = null;
            }
        }
    }

    public final void V(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public final void V0(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || TextUtils.isEmpty(str) || (builder = this.f18775e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.f18775e.banner_list.app) {
            if (app != null && str.equals(b.a.r0.a3.c.a(app))) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.f18775e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.f18775e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.f18775e.build(true));
        builder3.banner_list = builder2.build(true);
        D0(builder3);
    }

    public final void W(String str, List<b.a.e.m.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<b.a.e.m.e.n> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                b.a.e.m.e.n next = it.next();
                if (next instanceof b.a.r0.h1.h.j.a) {
                    advertAppInfo = ((b.a.r0.h1.h.j.a) next).g();
                } else if (next instanceof p0) {
                    p0 p0Var = (p0) next;
                    if (p0Var.g() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) p0Var.g()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.Y3)) {
                }
            }
            return;
            it.remove();
        }
    }

    public final void W0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (builder = this.f18775e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        T(builder2, list2 != null ? list2.size() : 0);
        U(builder2);
        V(builder2);
        D0(builder2);
    }

    public void X(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, l2) == null) || (builder = this.f18775e) == null || (list = builder.thread_list) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                builder2.top_agree_post = null;
                list.set(i2, builder2.build(true));
                W0();
                C0(false, true, false, this.f18775e.build(true));
                return;
            }
        }
    }

    public final void X0(UpdateAttentionMessage updateAttentionMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, updateAttentionMessage) == null) || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f46519c)) {
            return;
        }
        b.a.q0.c1.l0.b(new n(this, updateAttentionMessage.getData().f46519c, updateAttentionMessage.getData().f46520d), new o(this));
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Iterator<b.a.e.m.e.n> it = this.f18774d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof b.a.r0.h1.h.j.g) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.f18775e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            W0();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> d02 = d0(bdTypeRecyclerView);
                int intValue = d02.get(0).intValue();
                int intValue2 = d02.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.k.removeItemList(intValue, intValue2);
            }
        }
    }

    public final void Z(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f18775e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.f18774d) == 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString("liveid");
            if (this.k == null || TextUtils.isEmpty(optString2)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.k.getCount()) {
                    break;
                }
                b.a.e.m.e.n item = this.k.getItem(i2);
                if (item instanceof b.a.r0.b0.f0.j) {
                    b.a.r0.b0.f0.j jVar = (b.a.r0.b0.f0.j) item;
                    if (jVar.getThreadData() != null && jVar.getThreadData().m1() != null && optString2.equals(String.valueOf(jVar.getThreadData().m1().live_id))) {
                        optString = jVar.getThreadData().t1();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<b.a.e.m.e.n> it = this.f18774d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b.a.e.m.e.n next = it.next();
            if (next instanceof b.a.r0.b0.f0.b) {
                b.a.r0.b0.f0.b bVar = (b.a.r0.b0.f0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().t1() != null) {
                    if (bVar.getThreadData().t1().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        b.a.r0.h1.h.k.c.b(this.f18774d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.f18775e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long g2 = b.a.e.f.m.b.g(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.f18775e.thread_list.size()) {
                ThreadInfo threadInfo = this.f18775e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                    b.a.r0.h1.h.l.c.d(threadInfo.tid.longValue(), i3, this.f18775e.thread_list, this.f18774d);
                    this.f18775e.thread_list.remove(i3);
                    W0();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> g02 = g0(optString, bdTypeRecyclerView);
            int intValue = g02.get(0).intValue();
            int intValue2 = g02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.removeItemList(intValue, intValue2);
        }
    }

    public void a0(b.a.r0.h1.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, dVar) == null) {
            b.a.q0.c1.l0.b(new r(this), new s(this, dVar));
        }
    }

    public final ThreadCardViewHolder b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            b.a.r0.q2.i iVar = this.v;
            if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.v.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> d0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                b.a.e.m.e.n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof b.a.r0.h1.h.j.g) {
                    b.a.r0.h1.h.j.g gVar = (b.a.r0.h1.h.j.g) item;
                    if (!z2) {
                        i2 = i4;
                    }
                    z2 = true;
                    i3 = i4;
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f.i e0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048615, this)) != null) {
            return (f.i) invokeV.objValue;
        }
        if (!this.A || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.isSupportMsgRemind() || m0()) {
            return null;
        }
        int i2 = this.f18779i;
        boolean z2 = this.B;
        if (z2) {
            b.a.r0.l3.c.g().h(this.G, false);
            if (j0(false)) {
                c2 = 3;
            } else if (this.C <= 0) {
                c2 = 0;
            }
            if (this.s != null) {
                this.o.f();
            }
            scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost == null && scrollFragmentTabHost.getCurrentTabType() != 1) {
                this.o.d();
                return null;
            } else if (this.F) {
                this.o.d();
                return null;
            } else {
                if (c2 == 2) {
                    if (i2 > 0) {
                        b2 = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (c2 == 3) {
                    b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    b2 = c2 == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().b() : null;
                }
                if (TextUtils.isEmpty(b2) || !b.a.e.f.p.j.z()) {
                    return null;
                }
                if (c2 == 4) {
                    this.n = 1000;
                } else {
                    this.n = 0;
                }
                return new f.i(b2, this.n);
            }
        } else if (z2 || i2 != 0) {
            return null;
        } else {
            i2 = 0;
        }
        c2 = 2;
        if (this.s != null) {
        }
        scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost == null) {
        }
        if (this.F) {
        }
    }

    public b.a.r0.q2.i f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.v : (b.a.r0.q2.i) invokeV.objValue;
    }

    public final List<Integer> g0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                b.a.e.m.e.n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof b.a.r0.b0.f0.b) {
                    b.a.r0.b0.f0.b bVar = (b.a.r0.b0.f0.b) item;
                    if (bVar.getThreadData() != null && bVar.getThreadData().t1().equals(str)) {
                        if (!z2) {
                            i2 = i4;
                        }
                        z2 = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            b.a.r0.m3.j0.f fVar = new b.a.r0.m3.j0.f("new_index", null);
            this.q = fVar;
            fVar.d();
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? j0(true) : invokeV.booleanValue;
    }

    public final boolean j0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z2)) == null) {
            b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
            long l2 = j2.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return l2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - l2) > this.f18771a;
        }
        return invokeZ.booleanValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? b.a.q0.s.e0.b.j().g(c0(), true) : invokeV.booleanValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f18777g : invokeV.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            a0(this.c0);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f18778h = true;
            b.a.q0.c1.l0.b(new c(this), new d(this));
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || b.a.r0.h1.h.k.g.h().g() || this.f18773c == null) {
            return;
        }
        DataRes.Builder builder = this.f18775e;
        this.f18773c.a((builder == null || builder.thread_list == null || i0()) ? 0 : this.f18775e.thread_list.size(), Q(true), 0);
    }

    public void q0() {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (l0()) {
                b.a.r0.h1.d.a.d().j(0L, 1);
            } else if (this.f18773c != null) {
                B0();
                this.f18776f++;
                M0(true);
                DataRes.Builder builder = this.f18775e;
                this.f18773c.c(this.f18776f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), Q(false), 0);
            }
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            b.a.q0.q0.l.b().q(System.currentTimeMillis() - b.a.q0.q0.l.b().c());
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            b.a.q0.s.e0.b.j().t(c0(), false);
        }
    }

    public void t0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.y = z2;
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.notifyListViewBackground(z2);
            }
            b.a.r0.q2.i iVar = this.v;
            if (iVar == null) {
                return;
            }
            iVar.q(!z2);
            ThreadCardViewHolder b02 = b0();
            boolean z3 = false;
            if (b02 != null && b02.getCardView() != null) {
                z3 = b02.getCardView().n(new a.C0092a(8, Boolean.valueOf(z2)));
            }
            if (z3) {
                return;
            }
            if (z2) {
                this.v.w();
            } else if (this.z) {
                this.v.n(this.w, this.x, this.u, true);
            }
        }
    }

    public final void u0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dataRes) == null) {
            this.f18778h = true;
            if (dataRes != null) {
                C0(false, true, true, dataRes);
                l0 l0Var = this.f18773c;
                if (l0Var != null) {
                    l0Var.d(true);
                    Looper.myQueue().addIdleHandler(new b(this));
                    return;
                }
                return;
            }
            p0();
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            b.a.r0.h1.d.a.d().j(System.currentTimeMillis(), 1);
            this.f18776f = 1;
            this.D = true;
            if (this.f18774d.size() == 0 && !k0()) {
                if (!this.f18778h) {
                    o0();
                    return;
                } else {
                    p0();
                    return;
                }
            }
            p0();
        }
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.onChangeSkinType(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.onChangeSkinType();
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView = this.J;
            if (homePageBrowseModelTipView != null) {
                homePageBrowseModelTipView.onChangeSkinType();
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            b.a.r0.q2.i iVar = this.v;
            if (iVar != null) {
                iVar.h();
            }
            n1 n1Var = this.o;
            if (n1Var != null) {
                n1Var.e();
            }
            b.a.r0.h1.h.b bVar = this.f18772b;
            if (bVar != null) {
                bVar.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.b0);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.k0);
            MessageManager.getInstance().unRegisterListener(this.l0);
            MessageManager.getInstance().unRegisterListener(this.m0);
            MessageManager.getInstance().unRegisterListener(this.n0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) != null) {
            return;
        }
        DataRes dataRes2 = dataRes;
        if (z2) {
            b.a.r0.h1.h.g.a();
        }
        b.a.r0.h1.h.k.b bVar = this.p;
        if (bVar != null && bVar.i() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
            if (dataRes2 == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes2 = builder.build(false);
            }
            if (dataRes2.thread_list != null) {
                List<ThreadInfo> d2 = this.p.d();
                dataRes2.thread_list.addAll(d2);
                if (d2 != null) {
                    d2.clear();
                }
                z4 = true;
                DataRes.Builder builder2 = this.f18775e;
                size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                    l0 l0Var = this.f18773c;
                    if (l0Var != null) {
                        l0Var.b();
                    }
                    M0(false);
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                    if (bigdaySwipeRefreshLayout != null) {
                        bigdaySwipeRefreshLayout.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.N != null) {
                    DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                    builder3.thread_list.add(0, this.N);
                    dataRes2 = builder3.build(false);
                    DataRes.Builder builder4 = this.f18775e;
                    if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                        Iterator<ThreadInfo> it = this.f18775e.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && (l2 = next.tid) != null && this.N.tid != null && l2.longValue() == this.N.tid.longValue()) {
                                this.f18775e.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.N = null;
                }
                if ((!z4 || i2 == 0) && dataRes2 != null && C0(true, z2, z3, dataRes2)) {
                    s0();
                    if (this.f18773c != null) {
                        b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
                        j2.w("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.f18773c.d(false);
                    }
                    this.A = true;
                    this.B = z2;
                    this.C = size;
                    W0();
                } else {
                    this.A = false;
                    if (this.f18774d.size() > 0) {
                        l0 l0Var2 = this.f18773c;
                        if (l0Var2 != null) {
                            l0Var2.onError(1, str);
                        }
                    } else {
                        l0 l0Var3 = this.f18773c;
                        if (l0Var3 != null) {
                            l0Var3.onError(2, str);
                        }
                    }
                }
                M0(false);
                if (this.l == null) {
                    f.i e02 = e0();
                    if (this.l.isSupportMsgRemind() && e02 != null && !TbSingleton.getInstance().isBrowseMode()) {
                        this.l.refreshFinishWithMsgRemind(e02);
                        return;
                    } else {
                        this.l.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z4 = false;
        DataRes.Builder builder22 = this.f18775e;
        if (builder22 != null) {
        }
        if (z2) {
        }
        if (this.N != null) {
        }
        if (!z4) {
        }
        s0();
        if (this.f18773c != null) {
        }
        this.A = true;
        this.B = z2;
        this.C = size;
        W0();
        M0(false);
        if (this.l == null) {
        }
    }

    public void y0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            b.a.r0.m3.j0.f fVar = this.q;
            if ((fVar != null ? fVar.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.q.c(i2);
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            b.a.r0.h1.h.c.b(this.k);
            R(this.a0);
            b.a.q0.q0.c cVar = this.r;
            if (cVar != null) {
                cVar.c();
            }
        }
    }
}
