package c.a.q0.f1.h;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.l.v0.a;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.l1;
import c.a.p0.s.q.n1;
import c.a.p0.s.q.p0;
import c.a.q0.i0.a;
import c.a.q0.v0.c1;
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
import com.baidu.searchbox.task.item.InitPersonalizePageCacheTask;
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
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public c.a.p0.b1.c0 E;
    public View.OnTouchListener F;
    public c.a.q0.f1.h.j.h G;
    public boolean H;
    public BdUniqueId I;
    public SmartBubbleAnimatedView J;
    public HomePageYoungsterTopView K;
    public HomePageBrowseModelTipView L;
    public int M;
    public BdUniqueId N;
    public a.C0096a O;
    public ThreadInfo P;
    public RecyclerView.OnScrollListener Q;
    public View.OnTouchListener R;
    public a.b S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;

    /* renamed from: a  reason: collision with root package name */
    public final long f17664a;
    public CustomMessageListener a0;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.q0.f1.h.b f17665b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public l0 f17666c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.e.l.e.n> f17667d;
    public Runnable d0;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f17668e;
    public c.a.q0.f1.h.d e0;

    /* renamed from: f  reason: collision with root package name */
    public int f17669f;
    public CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17670g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17671h;
    public CustomMessageListener h0;

    /* renamed from: i  reason: collision with root package name */
    public int f17672i;
    public CustomMessageListener i0;

    /* renamed from: j  reason: collision with root package name */
    public final TbPageContext<?> f17673j;
    public CustomMessageListener j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public c.a.e.c.g.a l0;
    public final c.a.q0.f1.h.h.c0 m;
    public CustomMessageListener m0;
    public int n;
    public CustomMessageListener n0;
    public c1 o;
    public final c.a.e.c.g.a o0;
    public final c.a.q0.f1.h.k.a p;
    public CustomMessageListener p0;
    public c.a.q0.i3.i0.f q;
    public c.a.p0.o0.c r;
    public ScrollFragmentTabHost s;
    public c.a.q0.i0.a t;
    public boolean u;
    public c.a.q0.o2.i v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17674e;

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
            this.f17674e = eVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder d0 = this.f17674e.d0();
                if (d0 != null && d0.getCardView() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(d0.getCardView().o(new a.C0096a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17675a;

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
            this.f17675a = eVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            long j3;
            c.a.q0.f1.k.b.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j2 = blessHttpResponseMessage.userPkId;
                j3 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j2 = blessSocketResponseMessage.userPkId;
                j3 = blessSocketResponseMessage.pkID;
            } else {
                j2 = 0;
                j3 = 0;
            }
            if (j3 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j3 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j3 == 0) {
                return;
            }
            for (c.a.e.l.e.n nVar : this.f17675a.f17667d) {
                if ((nVar instanceof c.a.q0.f1.k.b.c.a) && (bVar = ((c.a.q0.f1.k.b.c.a) nVar).a0) != null && j3 == bVar.f18000b) {
                    bVar.f18001c = j2;
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17676a;

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
            this.f17676a = eVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f17676a.t0();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17677a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f17678e;

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
                this.f17678e = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17678e.f17677a.m.m();
                    if (this.f17678e.f17677a.y || !this.f17678e.f17677a.z) {
                        return;
                    }
                    this.f17678e.f17677a.v.n(this.f17678e.f17677a.w, this.f17678e.f17677a.x, this.f17678e.f17677a.u, true);
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
            this.f17677a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c2 c2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<c.a.e.l.e.n> h2 = this.f17677a.m.h();
                if (!ListUtils.isEmpty(h2)) {
                    for (c.a.e.l.e.n nVar : h2) {
                        if (nVar instanceof c.a.q0.a0.d0.k) {
                            c.a.q0.a0.d0.k kVar = (c.a.q0.a0.d0.k) nVar;
                            if (kVar.o != 0 && (c2Var = kVar.f15245e) != null) {
                                int[] g0 = c2Var.g0();
                                kVar.o = g0[0];
                                kVar.p = g0[1];
                            }
                        }
                    }
                }
                c.a.e.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.p0.b1.h0<DataRes> {
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
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                InitPersonalizePageCacheTask.init();
                return InitPersonalizePageCacheTask.dataResCache;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17679a;

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
            this.f17679a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l1)) {
                l1 l1Var = (l1) customResponsedMessage.getData();
                if (l1Var.f14291a != 1) {
                    return;
                }
                int k = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
                int i2 = c.a.e.e.p.l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f17679a.N);
                requestGetMyPostNetMessage.setParams(c.a.e.e.m.b.f(l1Var.f14293c, 0L), 0L, 0L, k, i2, f2, i3);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.b1.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17680a;

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
            this.f17680a = eVar;
        }

        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f17680a.w0(dataRes);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // c.a.p0.b1.n
        public /* bridge */ /* synthetic */ void onReturnDataInUI(DataRes dataRes) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                a(dataRes);
            } finally {
                TTIStats.record("PersonalizedUpdateController$13.onReturnDataInUI", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17681a;

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
            this.f17681a = eVar;
        }

        @Override // c.a.e.c.g.a
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
                this.f17681a.P = threadInfo;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    }

    /* renamed from: c.a.q0.f1.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0856e extends c.a.p0.b1.h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f17682a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f17683b;

        public C0856e(e eVar, DataRes.Builder builder) {
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
            this.f17683b = eVar;
            this.f17682a = builder;
        }

        @Override // c.a.p0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f17682a.build(true));
                this.f17683b.f17665b.g(builder.thread_list);
                c.a.p0.s.r.a.f();
                try {
                    c.a.p0.s.r.a.e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17684a;

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
            this.f17684a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && c.a.p0.t.h.a.e(TbadkCoreApplication.getInst(), 1)) {
                c.a.p0.t.h.a.g(this.f17684a.f17673j, 7, 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends c.a.p0.b1.h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f17685a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f17686b;

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
            this.f17686b = eVar;
            this.f17685a = builder;
        }

        @Override // c.a.p0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f17685a.build(true));
                this.f17686b.f17665b.g(builder.thread_list);
                c.a.p0.s.r.a.f();
                try {
                    c.a.p0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17687e;

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
            this.f17687e = eVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f17687e.F != null) {
                    this.f17687e.F.onTouch(view, motionEvent);
                }
                if (this.f17687e.t != null) {
                    this.f17687e.t.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17688e;

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
            this.f17688e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f17688e.f17673j, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17689a;

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
            this.f17689a = eVar;
        }

        @Override // c.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f17689a.u = false;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f17689a.u = true;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements HomePageYoungsterTopView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17690a;

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
                    return;
                }
            }
            this.f17690a = eVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.b
        public void onDelete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new BdTopToast(this.f17690a.f17673j.getPageActivity(), 2000).setIcon(true).setContent(this.f17690a.f17673j.getPageActivity().getString(R.string.youngster_frs_top_toast)).show((ViewGroup) this.f17690a.f17673j.getPageActivity().findViewById(R.id.maintabContainer));
                this.f17690a.Y0(false);
                c.a.p0.s.d0.b.j().t("key_youngster_homgpage_top_view_closed", true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17691a;

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
            this.f17691a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f17691a.k == null) {
                return;
            }
            this.f17691a.v.w();
            this.f17691a.z = false;
            this.f17691a.l.setRefreshing(true);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17692a;

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
            this.f17692a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c2 c2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c2) || this.f17692a.f17668e == null || ListUtils.getCount(this.f17692a.f17668e.thread_list) == 0 || (c2Var = (c2) customResponsedMessage.getData()) == null || c2Var.J0() == null || c2Var.f0() == null || ListUtils.getCount(this.f17692a.f17668e.thread_list) == 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f17692a.f17668e.thread_list.size(); i2++) {
                ThreadInfo threadInfo = this.f17692a.f17668e.thread_list.get(i2);
                if (threadInfo != null && threadInfo.id.longValue() == c.a.e.e.m.b.f(c2Var.f0(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) c2Var.J0().getNum());
                    builder.zan = builder2.build(true);
                    this.f17692a.f17668e.thread_list.set(i2, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17693a;

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
            this.f17693a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f17693a.k == null) {
                return;
            }
            this.f17693a.a0();
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17694a;

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
            this.f17694a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c2 c2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage)) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(this.f17694a.f17667d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i2 = 0; i2 < originData.size(); i2++) {
                    if ((originData.get(i2) instanceof c2) && (c2Var = (c2) originData.get(i2)) != null && c2Var.j1() != null && ids.contains(Long.valueOf(c2Var.j1().live_id))) {
                        this.f17694a.f17667d.remove(c2Var);
                    }
                }
                if (this.f17694a.m != null) {
                    this.f17694a.m.z(new ArrayList(this.f17694a.f17667d));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17695a;

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
            this.f17695a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
                if (intValue == 2) {
                    new BdTopToast(this.f17695a.f17673j.getPageActivity(), 2000).setIcon(true).setContent(this.f17695a.f17673j.getPageActivity().getString(R.string.youngster_open_title)).show((ViewGroup) this.f17695a.f17673j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f17695a.Y0(true);
                } else if (intValue == 3) {
                    new BdTopToast(this.f17695a.f17673j.getPageActivity(), 2000).setIcon(true).setContent(this.f17695a.f17673j.getPageActivity().getString(R.string.youngster_close_title)).show((ViewGroup) this.f17695a.f17673j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f17695a.Y0(false);
                } else if (intValue == 5) {
                    new BdTopToast(this.f17695a.f17673j.getPageActivity(), 2000).setIcon(true).setContent(this.f17695a.f17673j.getPageActivity().getString(R.string.youngster_reset_title)).show((ViewGroup) this.f17695a.f17673j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f17695a.Y0(true);
                } else if (c.a.p0.e1.b.e.d()) {
                    this.f17695a.Y0(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ScrollFragmentTabHost.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17696a;

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
            this.f17696a = eVar;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17696a.s.getTabType(i2) == 1 || this.f17696a.o == null) {
                return;
            }
            this.f17696a.o.d();
        }
    }

    /* loaded from: classes3.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17697a;

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
            this.f17697a = eVar;
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
                this.f17697a.V0(true);
            } else {
                this.f17697a.V0(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17698a;

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
            this.f17698a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f17698a.f17668e == null || ListUtils.isEmpty(this.f17698a.f17668e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f47956c)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f17698a.f17668e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = this.f17698a.f17668e.thread_list.get(i2);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != c.a.e.e.m.b.f(updateAttentionMessage.getData().f47956c, -1L)) {
                    i2++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().f47957d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().f47957d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().f47957d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    this.f17698a.f17668e.thread_list.set(i2, builder.build(true));
                }
            }
            this.f17698a.c1(updateAttentionMessage);
        }
    }

    /* loaded from: classes3.dex */
    public interface l0 {
        void a(int i2, c.a.p0.b1.c cVar, int i3);

        void b();

        void c(int i2, int i3, c.a.p0.b1.c cVar, int i4);

        void d(boolean z);

        void onError(int i2, String str);
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17699a;

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
            this.f17699a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.f17699a.f17668e == null || this.f17699a.f17668e.hot_recomforum == null || ListUtils.isEmpty(this.f17699a.f17668e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.f17699a.f17668e.hot_recomforum);
            if (c.a.q0.f1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.f17699a.f17668e.hot_recomforum = builder.build(true);
                this.f17699a.F0(new DataRes.Builder(this.f17699a.f17668e.build(true)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends c.a.p0.b1.h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17701b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f17702c;

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
            this.f17702c = eVar;
            this.f17700a = str;
            this.f17701b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    c.a.p0.s.r.a.f();
                    c.a.e.e.d.l<byte[]> e2 = c.a.p0.s.r.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e2 == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = e2.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i2 = 0; i2 < builder.thread_list.size(); i2++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == c.a.e.e.m.b.f(this.f17700a, -1L)) {
                                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                    User.Builder builder3 = new User.Builder(builder2.author);
                                    builder3.is_like = Integer.valueOf(this.f17701b ? 1 : 0);
                                    builder3.has_concerned = Integer.valueOf(this.f17701b ? 1 : 0);
                                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                    if (this.f17701b) {
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
                            this.f17702c.f17665b.g(builder5.thread_list);
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

    /* loaded from: classes3.dex */
    public class o implements c.a.p0.b1.n<Boolean> {
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
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends c.a.p0.b1.h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f17703a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f17704b;

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
            this.f17704b = eVar;
            this.f17703a = i2;
        }

        @Override // c.a.p0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> h2 = c.a.p0.s.r.a.h(this.f17704b.b0, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f17704b.b0, Integer.toString(this.f17703a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class q implements c.a.q0.f1.h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17705a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17706e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ q f17707f;

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
                this.f17707f = qVar;
                this.f17706e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17707f.f17705a.k.getHandler() == null) {
                    return;
                }
                this.f17707f.f17705a.k.requestFocusFromTouch();
                if (this.f17706e > this.f17707f.f17705a.k.getCount() - 1) {
                    return;
                }
                this.f17707f.f17705a.k.setSelection(this.f17706e);
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
            this.f17705a = eVar;
        }

        @Override // c.a.q0.f1.h.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f17705a.d0 == null) {
                    this.f17705a.d0 = new a(this, i2);
                }
                this.f17705a.k.removeCallbacks(this.f17705a.d0);
                this.f17705a.k.post(this.f17705a.d0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends c.a.p0.b1.h0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17708a;

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
            this.f17708a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> h2 = c.a.p0.s.r.a.h(this.f17708a.b0, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    return h2.get(this.f17708a.b0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements c.a.p0.b1.n<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.f1.h.d f17709a;

        public s(e eVar, c.a.q0.f1.h.d dVar) {
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
            this.f17709a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            c.a.q0.f1.h.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f17709a) == null) {
                return;
            }
            dVar.a(c.a.e.e.m.b.d(str, 0));
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17710a;

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
            this.f17710a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17710a.G == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            this.f17710a.f17667d.remove(this.f17710a.G);
            this.f17710a.m.z(new ArrayList(this.f17710a.f17667d));
            c.a.p0.s.d0.b.j().w("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17711a;

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
            this.f17711a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17711a.b0(customResponsedMessage);
                if (this.f17711a.v == null || !this.f17711a.z) {
                    return;
                }
                this.f17711a.v.n(this.f17711a.w, this.f17711a.x, this.f17711a.u, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17712a;

        /* renamed from: b  reason: collision with root package name */
        public int f17713b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17714c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f17715d;

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
            this.f17715d = eVar;
            this.f17712a = -1;
            this.f17713b = 0;
            this.f17714c = false;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f17713b > i2) {
                    this.f17714c = true;
                }
                if (this.f17715d.E != null && !this.f17715d.y) {
                    this.f17715d.E.a(this.f17713b, i2);
                }
                this.f17713b = i2;
                int i4 = (i3 + i2) - 1;
                if (!this.f17714c && this.f17712a != i4) {
                    this.f17712a = i4;
                    this.f17715d.A0(i4);
                }
                if (this.f17714c && this.f17712a != i2) {
                    this.f17712a = i2;
                    this.f17715d.A0(i2);
                }
                this.f17715d.c0 = i2;
                this.f17715d.w = i2;
                this.f17715d.x = i4;
                ThreadCardViewHolder d0 = this.f17715d.d0();
                if (d0 == null || d0.getCardView() == null) {
                    return;
                }
                d0.getCardView().o(this.f17715d.O);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (this.f17715d.r == null) {
                    this.f17715d.r = new c.a.p0.o0.c();
                    this.f17715d.r.a(1005);
                    this.f17715d.r.f13680e = 1;
                }
                if (this.f17715d.E != null && !this.f17715d.y) {
                    this.f17715d.E.b(recyclerView, i2);
                }
                if (i2 == 0) {
                    c.a.q0.f1.h.c.b(this.f17715d.k);
                    this.f17715d.r.e();
                    c.a.q0.a0.t.b().d(true);
                    c.a.q0.o.d.c().h("page_recommend", "show_");
                    c.a.q0.h3.c.g().h(this.f17715d.I, false);
                    this.f17714c = false;
                    if (this.f17715d.v == null || !this.f17715d.z || this.f17715d.y) {
                        return;
                    }
                    this.f17715d.v.m(this.f17715d.w, this.f17715d.x, this.f17715d.u, 1);
                    return;
                }
                this.f17715d.r.d();
                if (i2 == 1) {
                    if (this.f17715d.o != null) {
                        this.f17715d.o.d();
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

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17716a;

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
            this.f17716a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17716a.b0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f17717a;

        /* renamed from: b  reason: collision with root package name */
        public String f17718b;

        /* renamed from: c  reason: collision with root package name */
        public String f17719c;

        /* renamed from: d  reason: collision with root package name */
        public String f17720d;

        /* renamed from: e  reason: collision with root package name */
        public String f17721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17722f;

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
            this.f17722f = eVar;
            this.f17717a = "";
            this.f17718b = "";
            this.f17719c = "";
            this.f17720d = "";
            this.f17721e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f17717a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f17718b = jSONObject.optString("tid", "");
                    this.f17719c = jSONObject.optString("fid", "");
                    this.f17720d = jSONObject.optString("liveId", "");
                    this.f17721e = jSONObject.optString("sid", "");
                } else if ((this.f17717a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f17717a)) && ((this.f17720d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f17720d)) && (this.f17721e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f17721e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f17718b);
                        jSONObject.put("fid", this.f17719c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f17722f.b0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17723a;

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
            this.f17723a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17723a.f17668e == null || ListUtils.getCount(this.f17723a.f17668e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e eVar = this.f17723a;
            eVar.Y(str, eVar.f17667d);
            this.f17723a.a1(str);
            if (this.f17723a.m != null) {
                this.f17723a.m.z(new ArrayList(this.f17723a.f17667d));
            }
            if (this.f17723a.v == null || !this.f17723a.z) {
                return;
            }
            this.f17723a.v.n(this.f17723a.w, this.f17723a.x, this.f17723a.u, true);
        }
    }

    /* loaded from: classes3.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17724a;

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
            this.f17724a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder d0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (d0 = this.f17724a.d0()) == null || d0.getCardView() == null) {
                    return;
                }
                d0.getCardView().o(new a.C0096a(3));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c.a.q0.f1.h.h.c0 c0Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, c0Var, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17666c = null;
        this.f17667d = new LinkedList();
        this.f17669f = 1;
        this.f17670g = false;
        this.f17671h = false;
        this.f17672i = 0;
        this.n = 2000;
        this.r = null;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = true;
        this.A = false;
        this.D = false;
        this.H = true;
        this.M = 0;
        this.N = BdUniqueId.gen();
        this.O = new a.C0096a(2);
        this.P = null;
        this.Q = new v(this);
        this.R = new f0(this);
        this.S = new g0(this);
        this.T = new h0(this, 2001399);
        this.U = new i0(this, 2921461);
        this.V = new j0(this, 2921486);
        this.W = new k0(this, 2921562);
        this.X = new i(this, 2004004);
        this.Y = new j(this, 2921026);
        this.Z = new l(this, 2001115);
        this.a0 = new m(this, 0);
        this.b0 = "lastReadReadPositionKey";
        this.c0 = 0;
        this.e0 = new q(this);
        this.f0 = new t(this, 2016569);
        this.g0 = new u(this, 2016488);
        this.h0 = new w(this, 2016553);
        this.i0 = new x(this, 2921547);
        this.j0 = new y(this, 2016331);
        this.k0 = new z(this, 2921381);
        this.l0 = new a0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.m0 = new b0(this, 2921414);
        this.n0 = new c0(this, 2921453);
        this.o0 = new d0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.p0 = new e0(this, 2921482);
        this.f17673j = tbPageContext;
        this.M = c.a.p0.s.d0.b.j().k("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.R);
        if (c.a.p0.e1.b.e.d()) {
            Y0(true);
        }
        c.a.q0.i0.a aVar = new c.a.q0.i0.a();
        this.t = aVar;
        aVar.d(this.S);
        this.m = c0Var;
        this.p = new c.a.q0.f1.h.k.a();
        this.f17664a = c.a.p0.s.d0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.Q);
        this.o = new c1();
        j0();
        c.a.q0.o2.i iVar = new c.a.q0.o2.i(this.f17673j, this.k);
        this.v = iVar;
        iVar.p(1);
        this.v.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f17665b = new c.a.q0.f1.h.b(this.f17667d, this.m);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.J = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, c.a.e.e.p.l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        J0();
        this.m0.setTag(this.f17673j.getUniqueId());
        MessageManager.getInstance().registerListener(this.m0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.o0.setTag(this.N);
        if (this.o0.getHttpMessageListener() != null) {
            this.o0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.o0.getSocketMessageListener() != null) {
            this.o0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.o0);
        MessageManager.getInstance().registerListener(this.n0);
        MessageManager.getInstance().registerListener(this.p0);
    }

    public void A0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.q0.i3.i0.f fVar = this.q;
            if ((fVar != null ? fVar.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.q.c(i2);
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.f1.h.c.b(this.k);
            T(this.c0);
            c.a.p0.o0.c cVar = this.r;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void C0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) && z2) {
            this.m.m();
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (ListUtils.getCount(this.f17667d) < this.p.e() - 40) {
                return;
            }
            List<c.a.e.l.e.n> list = null;
            c.a.q0.f1.h.k.c c2 = this.p.c(true, this.f17668e, null, 1);
            int i2 = 0;
            if (c2 != null) {
                list = c2.f17847a;
                int i3 = c2.f17849c;
                c2.f17849c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.f17667d.clear();
                this.f17667d.addAll(list);
                this.m.A(new LinkedList(this.f17667d), i2);
            }
        }
    }

    public final boolean E0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        List<c.a.e.l.e.n> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.M == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || k0())) {
                    L0();
                    this.f17668e = null;
                }
            } else if (z3 && k0()) {
                this.f17668e = null;
            }
            int size = z3 ? 0 : this.f17667d.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.f17667d.clear();
            c.a.q0.f1.h.k.c c2 = this.p.c(z2, this.f17668e, builder, !z3 ? 1 : 0);
            if (c2 != null) {
                list = c2.f17847a;
                this.f17672i = c2.f17848b;
                i2 = c2.f17849c;
                c2.f17849c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.f17667d.addAll(list);
                R(list, size);
                K0(!z3 ? 1 : 0, list, size);
                if (this.D) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.f17668e == null) {
                this.f17668e = builder;
                this.f17665b.j(builder.thread_list);
            }
            if (this.f17667d.size() != 0) {
                if (z3) {
                    if (dataRes.live_answer != null) {
                        c.a.q0.f1.h.j.h hVar = new c.a.q0.f1.h.j.h();
                        this.G = hVar;
                        hVar.g(dataRes.live_answer);
                        this.f17668e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.G = null;
                        this.f17668e.live_answer = null;
                    }
                    this.f17668e.float_info = dataRes.float_info;
                }
                long l2 = c.a.p0.s.d0.b.j().l("key_maintab_banner_close_time", 0L);
                if (this.G != null && !StringHelper.isTaday(l2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.f17667d.add(0, this.G);
                }
                LinkedList linkedList = new LinkedList(this.f17667d);
                c.a.q0.f1.h.h.c0 c0Var = this.m;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                c0Var.t(z5);
                this.m.A(linkedList, i2);
                c.a.q0.o2.i iVar = this.v;
                if (iVar != null && this.z) {
                    iVar.n(this.w, this.x, this.u, true);
                }
                z5 = true;
            }
            c.a.q0.f1.d.a.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = c.a.q0.f1.d.a.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                c.a.q0.f1.d.a.d().k(System.currentTimeMillis() - e2, 1);
                c.a.q0.f1.d.a.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                c.a.q0.q3.d.g(blockPopInfo);
            }
            n1 n1Var = new n1();
            n1Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, n1Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                c.a.p0.o0.l.b().H(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public final void F0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, builder) == null) {
            c.a.p0.b1.k0.b(new f(this, builder), null);
        }
    }

    public void G0(int i2, int i3) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || ListUtils.isEmpty(this.f17667d) || this.f17667d.size() <= i2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.f17667d.size() && i2 <= i3) {
            if (this.f17667d.get(i2).getType().getId() == c2.u3.getId() && (c2Var = (c2) this.f17667d.get(i2)) != null && c2Var.j1() != null) {
                arrayList.add(Long.valueOf(c2Var.j1().live_id));
                arrayList2.add(c2Var);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.o2.i iVar = this.v;
            if (iVar != null && !this.y && this.z) {
                iVar.n(this.w, this.x, this.u, true);
            }
            if (this.A) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.isSupportMsgRemind()) {
                    boolean z2 = this.B;
                    if (z2) {
                        c.a.q0.h3.c.g().h(this.I, false);
                        if (l0(false)) {
                            X0(3, this.f17672i);
                        } else if (this.C > 0) {
                            X0(2, this.f17672i);
                        }
                    } else if (!z2 && this.f17672i == 0) {
                        X0(2, 0);
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

    public void I0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.I = bdUniqueId;
        CustomMessageListener customMessageListener = this.X;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
        }
        CustomMessageListener customMessageListener2 = this.T;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.T);
        }
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
        this.Z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Z);
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.a0);
        MessageManager.getInstance().registerListener(2001336, this.a0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        c.a.q0.o2.i iVar = this.v;
        if (iVar != null) {
            iVar.t(bdUniqueId);
        }
        this.f17665b.i(bdUniqueId);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void K0(int i2, List<c.a.e.l.e.n> list, int i3) {
        c.a.q0.i3.i0.f fVar;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) == null) || (fVar = this.q) == null) {
            return;
        }
        if (i2 == 0) {
            fVar.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = c.a.q0.i3.i0.f.f20280e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof c.a.q0.a0.d0.b) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.q.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void L0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (builder = this.f17668e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        c.a.p0.b1.k0.b(new C0856e(this, builder2), null);
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.q0.f1.h.c.c(this.k);
        }
    }

    public void N0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.H = z2;
            c1 c1Var = this.o;
            if (c1Var == null || z2) {
                return;
            }
            c1Var.d();
        }
    }

    public final void O0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.f17670g = z2;
        }
    }

    public void P0(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, l0Var) == null) {
            this.f17666c = l0Var;
        }
    }

    public void Q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z2) == null) {
            this.z = z2;
        }
    }

    public final void R(List<c.a.e.l.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, list, i2) == null) {
            Set<c.a.e.l.e.n> a2 = c.a.q0.x2.a.a(list, this.f17669f, "NEWINDEX");
            if (a2.size() > 0) {
                c.a.q0.h3.c.g().c(this.I, c.a.q0.h3.a.h("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void R0(c.a.p0.b1.d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, d0Var) == null) || d0Var == null) {
            return;
        }
        this.E = d0Var.a();
        this.F = d0Var.b();
    }

    public final c.a.p0.b1.c S(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z2)) == null) {
            String e2 = c.a.q0.x2.a.e(this.f17667d, z2);
            int U = U(z2);
            c.a.p0.b1.c cVar = new c.a.p0.b1.c();
            cVar.f12822b = e2;
            cVar.f12821a = U;
            return cVar;
        }
        return (c.a.p0.b1.c) invokeZ.objValue;
    }

    public void S0(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost == null) {
                return;
            }
            scrollFragmentTabHost.setOnTabSelectedListener(new k(this));
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            c.a.p0.b1.k0.b(new p(this, i2), null);
        }
    }

    public void T0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.y = z2;
        }
    }

    public int U(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z2)) == null) {
            List<c.a.e.l.e.n> list = this.f17667d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.f17667d.size()) {
                    c.a.e.l.e.n nVar = this.f17667d.get(i4);
                    if ((nVar instanceof c.a.q0.a0.d0.b) && (i3 = ((c.a.q0.a0.d0.b) nVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((nVar instanceof c.a.q0.f1.h.j.a) && nVar.getType() != AdvertAppInfo.p4) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.f17667d.size() - 1; size >= 0; size--) {
                    c.a.e.l.e.n nVar2 = this.f17667d.get(size);
                    if ((nVar2 instanceof c.a.q0.a0.d0.b) && (i2 = ((c.a.q0.a0.d0.b) nVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((nVar2 instanceof c.a.q0.f1.h.j.a) && nVar2.getType() != AdvertAppInfo.p4) {
                        return i4;
                    }
                }
            }
            return this.f17667d.size();
        }
        return invokeZ.intValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.p0.t.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (!activityPrizeData.g() || StringUtils.isNull(activityPrizeData.b())) {
                return;
            }
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            String str = "";
            String p2 = c.a.p0.s.d0.b.j().p("activity_prize_feed_text_time", "");
            boolean z2 = true;
            if (!StringUtils.isNull(p2)) {
                String[] split = p2.split(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
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
                                sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
                                for (String str3 : asList) {
                                    sb.append(str3);
                                    sb.append(",");
                                }
                                sb.append(currentAccount);
                                str = sb.toString();
                            }
                        } else {
                            str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                        }
                    } else {
                        str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                    }
                } else {
                    str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                }
            } else {
                str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
            }
            if (z2) {
                X0(4, 0);
                c.a.p0.s.d0.b.j().x("activity_prize_feed_text_time", str);
            }
        }
    }

    public final void V(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, builder, i2) == null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = c.a.q0.x2.c.b(next);
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

    public final void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            if (z2) {
                if (this.L == null) {
                    HomePageBrowseModelTipView homePageBrowseModelTipView = new HomePageBrowseModelTipView(this.f17673j.getPageActivity());
                    this.L = homePageBrowseModelTipView;
                    homePageBrowseModelTipView.setListener(new g(this));
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setHeaderView(this.L, false);
                    this.L.setVisibility(0);
                    this.k.scrollToPosition(0);
                    return;
                }
                return;
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView2 = this.L;
            if (homePageBrowseModelTipView2 != null) {
                this.k.removeHeaderView(homePageBrowseModelTipView2);
                this.L.setVisibility(8);
                this.L = null;
            }
        }
    }

    public final void W(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public void W0() {
        c.a.p0.b1.c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (c0Var = this.E) == null) {
            return;
        }
        c0Var.c(true);
    }

    public final void X(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public final void X0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) || o0()) {
            return;
        }
        if (this.s != null) {
            this.o.f();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null && scrollFragmentTabHost.getCurrentTabType() != 1) {
            this.o.d();
        } else if (!this.H) {
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
            if (TextUtils.isEmpty(str) || !c.a.e.e.p.j.z()) {
                return;
            }
            if (i2 == 4) {
                this.n = 3000;
            } else {
                this.n = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            smartBubbleAnimatedView.tipText = str;
            smartBubbleAnimatedView.delayDuring = this.n;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.s;
            if (scrollFragmentTabHost2 != null) {
                FrameLayout frameLayout = scrollFragmentTabHost2.getFrameLayout();
                frameLayout.removeView(this.J);
                frameLayout.addView(this.J, layoutParams);
                this.J.playExpansionAnimation();
            }
        }
    }

    public final void Y(String str, List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048607, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                c.a.e.l.e.n next = it.next();
                if (next instanceof c.a.q0.f1.h.j.a) {
                    advertAppInfo = ((c.a.q0.f1.h.j.a) next).g();
                } else if (next instanceof p0) {
                    p0 p0Var = (p0) next;
                    if (p0Var.g() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) p0Var.g()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.T3)) {
                }
            }
            return;
            it.remove();
        }
    }

    public final void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) {
            boolean g2 = c.a.p0.s.d0.b.j().g("key_youngster_homgpage_top_view_closed", false);
            if (this.k == null || g2) {
                return;
            }
            if (z2) {
                if (this.K == null) {
                    HomePageYoungsterTopView homePageYoungsterTopView = new HomePageYoungsterTopView(this.f17673j);
                    this.K = homePageYoungsterTopView;
                    homePageYoungsterTopView.setOnDeleteClick(new h(this));
                }
                this.k.setHeaderView(this.K, false);
                this.K.setVisibility(0);
                this.k.scrollToPosition(0);
                return;
            }
            HomePageYoungsterTopView homePageYoungsterTopView2 = this.K;
            if (homePageYoungsterTopView2 != null) {
                homePageYoungsterTopView2.setVisibility(8);
                this.k.removeHeaderView(this.K);
                this.K = null;
            }
        }
    }

    public void Z(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, l2) == null) || (builder = this.f17668e) == null || (list = builder.thread_list) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                builder2.top_agree_post = null;
                list.set(i2, builder2.build(true));
                b1();
                E0(false, true, false, this.f17668e.build(true));
                return;
            }
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c.a.q0.f1.d.a.d().j(System.currentTimeMillis(), 1);
            this.f17669f = 1;
            this.D = true;
            if (this.f17667d.size() == 0 && !m0()) {
                if (this.f17671h) {
                    return;
                }
                q0();
                return;
            }
            r0();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Iterator<c.a.e.l.e.n> it = this.f17667d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof c.a.q0.f1.h.j.g) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.f17668e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            b1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> f02 = f0(bdTypeRecyclerView);
                int intValue = f02.get(0).intValue();
                int intValue2 = f02.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.k.removeItemList(intValue, intValue2);
            }
        }
    }

    public final void a1(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || TextUtils.isEmpty(str) || (builder = this.f17668e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.f17668e.banner_list.app) {
            if (app != null && str.equals(c.a.q0.x2.c.a(app))) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.f17668e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.f17668e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.f17668e.build(true));
        builder3.banner_list = builder2.build(true);
        F0(builder3);
    }

    public final void b0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f17668e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.f17667d) == 0) {
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
                c.a.e.l.e.n item = this.k.getItem(i2);
                if (item instanceof c.a.q0.a0.d0.j) {
                    c.a.q0.a0.d0.j jVar = (c.a.q0.a0.d0.j) item;
                    if (jVar.getThreadData() != null && jVar.getThreadData().j1() != null && optString2.equals(String.valueOf(jVar.getThreadData().j1().live_id))) {
                        optString = jVar.getThreadData().q1();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<c.a.e.l.e.n> it = this.f17667d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.e.l.e.n next = it.next();
            if (next instanceof c.a.q0.a0.d0.b) {
                c.a.q0.a0.d0.b bVar = (c.a.q0.a0.d0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().q1() != null) {
                    if (bVar.getThreadData().q1().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        c.a.q0.f1.h.k.b.b(this.f17667d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.f17668e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long f2 = c.a.e.e.m.b.f(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.f17668e.thread_list.size()) {
                ThreadInfo threadInfo = this.f17668e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                    c.a.q0.f1.h.l.c.d(threadInfo.tid.longValue(), i3, this.f17668e.thread_list, this.f17667d);
                    this.f17668e.thread_list.remove(i3);
                    b1();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> i02 = i0(optString, bdTypeRecyclerView);
            int intValue = i02.get(0).intValue();
            int intValue2 = i02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.removeItemList(intValue, intValue2);
        }
    }

    public final void b1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (builder = this.f17668e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        W(builder2);
        X(builder2);
        F0(builder2);
    }

    public void c0(c.a.q0.f1.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dVar) == null) {
            c.a.p0.b1.k0.b(new r(this), new s(this, dVar));
        }
    }

    public final void c1(UpdateAttentionMessage updateAttentionMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, updateAttentionMessage) == null) || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f47956c)) {
            return;
        }
        c.a.p0.b1.k0.b(new n(this, updateAttentionMessage.getData().f47956c, updateAttentionMessage.getData().f47957d), new o(this));
    }

    public final ThreadCardViewHolder d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            c.a.q0.o2.i iVar = this.v;
            if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.v.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> f0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                c.a.e.l.e.n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c.a.q0.f1.h.j.g) {
                    c.a.q0.f1.h.j.g gVar = (c.a.q0.f1.h.j.g) item;
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
    public final f.i g0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048620, this)) != null) {
            return (f.i) invokeV.objValue;
        }
        if (!this.A || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.isSupportMsgRemind() || o0()) {
            return null;
        }
        int i2 = this.f17672i;
        boolean z2 = this.B;
        if (z2) {
            c.a.q0.h3.c.g().h(this.I, false);
            if (l0(false)) {
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
            } else if (this.H) {
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
                if (TextUtils.isEmpty(b2) || !c.a.e.e.p.j.z()) {
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
        if (this.H) {
        }
    }

    public c.a.q0.o2.i h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.v : (c.a.q0.o2.i) invokeV.objValue;
    }

    public final List<Integer> i0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                c.a.e.l.e.n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c.a.q0.a0.d0.b) {
                    c.a.q0.a0.d0.b bVar = (c.a.q0.a0.d0.b) item;
                    if (bVar.getThreadData() != null && bVar.getThreadData().q1().equals(str)) {
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

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            c.a.q0.i3.i0.f fVar = new c.a.q0.i3.i0.f("new_index", null);
            this.q = fVar;
            fVar.d();
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? l0(true) : invokeV.booleanValue;
    }

    public final boolean l0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z2)) == null) {
            c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
            long l2 = j2.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return l2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - l2) > this.f17664a;
        }
        return invokeZ.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? c.a.p0.s.d0.b.j().g(e0(), true) : invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f17670g : invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.K;
            return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            c0(this.e0);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f17671h = true;
            if (InitPersonalizePageCacheTask.dataResCache != null) {
                w0(InitPersonalizePageCacheTask.dataResCache);
            } else {
                c.a.p0.b1.k0.b(new c(this), new d(this));
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || this.f17666c == null) {
            return;
        }
        DataRes.Builder builder = this.f17668e;
        this.f17666c.a((builder == null || builder.thread_list == null || k0()) ? 0 : this.f17668e.thread_list.size(), S(true), 0);
    }

    public void s0() {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (n0()) {
                c.a.q0.f1.d.a.d().j(0L, 1);
            } else if (this.f17666c != null) {
                D0();
                this.f17669f++;
                O0(true);
                DataRes.Builder builder = this.f17668e;
                this.f17666c.c(this.f17669f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), S(false), 0);
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            c.a.p0.o0.l.b().q(System.currentTimeMillis() - c.a.p0.o0.l.b().c());
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            c.a.p0.s.d0.b.j().t(e0(), false);
        }
    }

    public void v0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
            this.y = z2;
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.notifyListViewBackground(z2);
            }
            c.a.q0.o2.i iVar = this.v;
            if (iVar == null) {
                return;
            }
            iVar.q(!z2);
            ThreadCardViewHolder d02 = d0();
            boolean z3 = false;
            if (d02 != null && d02.getCardView() != null) {
                z3 = d02.getCardView().o(new a.C0096a(8, Boolean.valueOf(z2)));
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

    public final void w0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, dataRes) == null) {
            this.f17671h = true;
            if (dataRes != null) {
                if (E0(false, true, true, dataRes) && !k0()) {
                    l0 l0Var = this.f17666c;
                    if (l0Var != null) {
                        l0Var.d(true);
                        Looper.myQueue().addIdleHandler(new b(this));
                    }
                    if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                        r0();
                        TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                        return;
                    }
                    return;
                }
                r0();
                return;
            }
            r0();
        }
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.onChangeSkinType(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.K;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.onChangeSkinType();
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView = this.L;
            if (homePageBrowseModelTipView != null) {
                homePageBrowseModelTipView.onChangeSkinType();
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            c.a.q0.o2.i iVar = this.v;
            if (iVar != null) {
                iVar.h();
            }
            c1 c1Var = this.o;
            if (c1Var != null) {
                c1Var.e();
            }
            c.a.q0.f1.h.b bVar = this.f17665b;
            if (bVar != null) {
                bVar.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.d0);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.m0);
            MessageManager.getInstance().unRegisterListener(this.n0);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) != null) {
            return;
        }
        DataRes dataRes2 = dataRes;
        if (z2) {
            c.a.q0.f1.h.g.a();
        }
        c.a.q0.f1.h.k.a aVar = this.p;
        if (aVar != null && aVar.i() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
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
                DataRes.Builder builder2 = this.f17668e;
                size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                    l0 l0Var = this.f17666c;
                    if (l0Var != null) {
                        l0Var.b();
                    }
                    O0(false);
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                    if (bigdaySwipeRefreshLayout != null) {
                        bigdaySwipeRefreshLayout.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.P != null) {
                    DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                    builder3.thread_list.add(0, this.P);
                    dataRes2 = builder3.build(false);
                    DataRes.Builder builder4 = this.f17668e;
                    if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                        Iterator<ThreadInfo> it = this.f17668e.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && (l2 = next.tid) != null && this.P.tid != null && l2.longValue() == this.P.tid.longValue()) {
                                this.f17668e.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.P = null;
                }
                if ((!z4 || i2 == 0) && dataRes2 != null && E0(true, z2, z3, dataRes2)) {
                    u0();
                    if (this.f17666c != null) {
                        c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                        j2.w("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.f17666c.d(false);
                    }
                    this.A = true;
                    this.B = z2;
                    this.C = size;
                    b1();
                } else {
                    this.A = false;
                    if (this.f17667d.size() > 0) {
                        l0 l0Var2 = this.f17666c;
                        if (l0Var2 != null) {
                            l0Var2.onError(1, str);
                        }
                    } else {
                        l0 l0Var3 = this.f17666c;
                        if (l0Var3 != null) {
                            l0Var3.onError(2, str);
                        }
                    }
                }
                O0(false);
                if (this.l == null) {
                    f.i g02 = g0();
                    if (this.l.isSupportMsgRemind() && g02 != null && !TbSingleton.getInstance().isBrowseMode()) {
                        this.l.refreshFinishWithMsgRemind(g02);
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
        DataRes.Builder builder22 = this.f17668e;
        if (builder22 != null) {
        }
        if (z2) {
        }
        if (this.P != null) {
        }
        if (!z4) {
        }
        u0();
        if (this.f17666c != null) {
        }
        this.A = true;
        this.B = z2;
        this.C = size;
        b1();
        O0(false);
        if (this.l == null) {
        }
    }
}
