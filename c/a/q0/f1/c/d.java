package c.a.q0.f1.c;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.b1.c0;
import c.a.p0.b1.d0;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.o0;
import c.a.q0.a0.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;

    /* renamed from: a  reason: collision with root package name */
    public o f17271a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.e.l.e.n> f17272b;

    /* renamed from: c  reason: collision with root package name */
    public DataRes.Builder f17273c;

    /* renamed from: d  reason: collision with root package name */
    public DataRes.Builder f17274d;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f17275e;

    /* renamed from: f  reason: collision with root package name */
    public String f17276f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17277g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17278h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17279i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17280j;
    public final BdTypeRecyclerView k;
    public final c.a.q0.f1.c.a l;
    public c.a.q0.i0.a m;
    public boolean n;
    public c0 o;
    public View.OnTouchListener p;
    public final c.a.q0.f1.c.g.a q;
    public int r;
    public BigdaySwipeRefreshLayout s;
    public int t;
    public List<o0> u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public RecyclerView.OnScrollListener x;
    public CustomMessageListener y;
    public View.OnTouchListener z;

    /* loaded from: classes3.dex */
    public class a extends h0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f17281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17282b;

        public a(d dVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17282b = dVar;
            this.f17281a = builder;
        }

        @Override // c.a.p0.b1.h0
        public Object doInBackground() {
            InterceptResult invokeV;
            DataRes build;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f17281a.build(true));
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<byte[]> e2 = c.a.p0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                try {
                    build = builder.build(true);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                    e2.g("0", build.toByteArray());
                    d.V(this.f17282b.f17276f);
                    d.W(System.currentTimeMillis());
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f17283a;

        /* renamed from: b  reason: collision with root package name */
        public String f17284b;

        /* renamed from: c  reason: collision with root package name */
        public String f17285c;

        /* renamed from: d  reason: collision with root package name */
        public String f17286d;

        /* renamed from: e  reason: collision with root package name */
        public String f17287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17288f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17288f = dVar;
            this.f17283a = "";
            this.f17284b = "";
            this.f17285c = "";
            this.f17286d = "";
            this.f17287e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f17283a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f17284b = jSONObject.optString("tid", "");
                    this.f17285c = jSONObject.optString("fid", "");
                    this.f17286d = jSONObject.optString("liveId", "");
                    this.f17287e = jSONObject.optString("sid", "");
                } else if ((this.f17283a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f17283a)) && ((this.f17286d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f17286d)) && (this.f17287e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f17287e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f17284b);
                        jSONObject.put("fid", this.f17285c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f17288f.v(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17289a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17289a.v(customResponsedMessage);
            }
        }
    }

    /* renamed from: c.a.q0.f1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0837d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17290a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0837d(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17290a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17290a.v(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17291a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17291a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17291a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17292a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.l != null) {
                    return;
                }
                if (!data.f47954a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().f47955b, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (data.f47957d) {
                } else {
                    Iterator it = this.f17292a.f17272b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof c.a.q0.a0.d0.b) && ThreadCardUtils.isTargetUser(((c.a.q0.a0.d0.b) next).getThreadData(), data.f47956c)) {
                            it.remove();
                        }
                    }
                    c.a.q0.x2.a.c(this.f17292a.f17272b);
                    this.f17292a.u.clear();
                    if (this.f17292a.f17272b.size() < 9) {
                        this.f17292a.G();
                    } else {
                        d dVar = this.f17292a;
                        dVar.Y(dVar.f17272b);
                        this.f17292a.l.d();
                        if (this.f17292a.f17271a != null) {
                            this.f17292a.f17271a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17292a.n)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17293a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17293a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.f17293a.f17273c == null || this.f17293a.f17273c.hot_recomforum == null || ListUtils.isEmpty(this.f17293a.f17273c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.f17293a.f17273c.hot_recomforum);
            if (c.a.q0.f1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.f17293a.f17273c.hot_recomforum = builder.build(true);
                this.f17293a.Q(new DataRes.Builder(this.f17293a.f17273c.build(true)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17294a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17295b;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17295b = dVar;
            this.f17294a = 0;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f17295b.o != null && !this.f17295b.n) {
                    this.f17295b.o.a(this.f17294a, i2);
                }
                this.f17294a = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17295b.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (this.f17295b.o != null && !this.f17295b.n) {
                    this.f17295b.o.b(recyclerView, i2);
                }
                if (i2 == 0) {
                    t.b().c();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17295b.n)));
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17296a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f17296a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17296a.f17273c == null || c.a.q0.o1.o.k.a.e(this.f17296a.f17272b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.q0.x2.a.d(str, this.f17296a.f17272b);
            c.a.q0.x2.a.d(str, this.f17296a.f17273c.app_list);
            c.a.q0.x2.a.d(str, this.f17296a.u);
            c.a.q0.x2.a.u(this.f17296a.f17272b);
            if (this.f17296a.l != null) {
                this.f17296a.l.j(new ArrayList(this.f17296a.f17272b));
            }
            d dVar = this.f17296a;
            dVar.t(dVar.f17272b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17296a.n)));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17297e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17297e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f17297e.p != null) {
                    this.f17297e.p.onTouch(view, motionEvent);
                }
                if (this.f17297e.m != null) {
                    this.f17297e.m.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends h0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
                c.a.p0.s.r.a.f();
                c.a.p0.s.r.a.a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements c.a.p0.b1.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17298a;

        public l(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17298a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f17298a.L(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends h0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<byte[]> e2 = c.a.p0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get("0")) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e3) {
                        BdLog.e(e3);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n implements c.a.p0.b1.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17299a;

        public n(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17299a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f17299a.L(dataRes);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(c.a.p0.b1.c cVar);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, c.a.p0.b1.c cVar);

        void onError(int i2, String str);
    }

    public d(c.a.e.a.f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, c.a.q0.f1.c.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeRecyclerView, aVar, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17271a = null;
        this.f17272b = new LinkedList<>();
        this.f17278h = false;
        this.f17279i = false;
        this.f17280j = false;
        this.n = false;
        this.t = 0;
        this.u = new ArrayList();
        this.v = new f(this, 2001115);
        this.w = new g(this, 0);
        this.x = new h(this);
        this.y = new i(this, 2016331);
        this.z = new j(this);
        this.A = new b(this, 2921547);
        this.B = new c(this, 2016488);
        this.C = new C0837d(this, 2016553);
        this.D = new e(this, 2921425);
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.z);
        this.m = new c.a.q0.i0.a();
        this.q = new c.a.q0.f1.c.g.a();
        this.l = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.x);
        this.s = bigdaySwipeRefreshLayout;
        T(false);
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.p0.s.d0.b.j().g(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_loaded"), false) : invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.p0.b.d.i() && c.a.p0.s.d0.b.j().k("key_home_concern_all_status", 0) == 0 : invokeV.booleanValue;
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            c.a.p0.s.d0.b.j().t(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_loaded"), z);
        }
    }

    public static void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            c.a.p0.s.d0.b.j().x(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), str);
        }
    }

    public static void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            c.a.p0.s.d0.b.j().x(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), str);
        }
    }

    public static void W(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j2) == null) {
            c.a.p0.s.d0.b.j().w(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_time"), j2);
        }
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c.a.p0.s.d0.b.j().p(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), "") : (String) invokeV.objValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? c.a.p0.s.d0.b.j().p(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), "") : (String) invokeV.objValue;
    }

    public static long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? c.a.p0.s.d0.b.j().l(c.a.p0.s.d0.b.n("key_home_concern_all_status_cache_time"), 0L) : invokeV.longValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17277g : invokeV.booleanValue;
    }

    public void B(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            c2Var.C3(true);
            c.a.p0.b.f.a.e(c2Var);
            List<c.a.e.l.e.n> e2 = this.q.e(c2Var, -1, null);
            DataRes.Builder builder = this.f17273c;
            if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.f17272b) <= 1) {
                this.f17272b.clear();
            }
            this.f17272b.addAll(0, e2);
            this.l.j(this.f17272b);
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17278h : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17280j : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long y = y();
            long j2 = currentTimeMillis - y;
            if (y != 0 && j2 <= 86400000) {
                k0.b(new m(this), new n(this));
            } else {
                k0.b(new k(this), new l(this));
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.b1.c s = s(true);
            o oVar = this.f17271a;
            if (oVar != null) {
                oVar.a(s);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !D() && this.f17277g) {
            c.a.p0.b1.c s = s(false);
            if (this.f17271a != null) {
                X(true);
                this.f17271a.d(this.f17276f, s);
            }
        }
    }

    public final List<c.a.e.l.e.n> I(boolean z, DataRes.Builder builder, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), builder, Boolean.valueOf(z2)})) == null) {
            if (this.f17273c == null) {
                this.f17273c = new DataRes.Builder();
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            c.a.q0.f1.h.k.c b2 = this.q.b(z, this.f17273c, builder, !z2 ? 1 : 0);
            if (b2 != null) {
                return b2.f17847a;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public final void L(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) {
            this.f17279i = true;
            T(true);
            if (dataRes != null) {
                if (P(false, true, dataRes)) {
                    o oVar = this.f17271a;
                    if (oVar != null) {
                        oVar.c(false, true);
                        return;
                    }
                    return;
                }
                G();
                return;
            }
            G();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.f();
        }
    }

    public void N(boolean z, DataRes dataRes, int i2, String str) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            X(false);
            if (i2 == 0 && dataRes != null && P(true, z, dataRes)) {
                o oVar2 = this.f17271a;
                if (oVar2 != null) {
                    oVar2.c(z, false);
                }
                if (z) {
                    e0();
                }
            } else if (i2 == 0 && ListUtils.getCount(this.f17272b) == 0 && (oVar = this.f17271a) != null) {
                oVar.b();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.s;
                if (bigdaySwipeRefreshLayout != null) {
                    bigdaySwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.f17272b.size() > 0) {
                o oVar3 = this.f17271a;
                if (oVar3 != null) {
                    oVar3.onError(1, str);
                }
            } else {
                o oVar4 = this.f17271a;
                if (oVar4 != null) {
                    oVar4.onError(2, str);
                }
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.s;
            if (bigdaySwipeRefreshLayout2 != null) {
                bigdaySwipeRefreshLayout2.setRefreshing(false);
            }
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && z) {
            this.l.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P(boolean z, boolean z2, DataRes dataRes) {
        InterceptResult invokeCommon;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dataRes})) == null) {
            if (dataRes == null) {
                return false;
            }
            int i3 = z2 ? 1 : this.t + 1;
            this.t = i3;
            int k2 = i3 == 1 ? 0 : c.a.q0.o1.o.k.a.k(this.f17272b);
            this.f17276f = dataRes.page_tag;
            this.f17275e = new DataRes.Builder(dataRes);
            if (J()) {
                U(this.f17276f);
            }
            LinkedList linkedList = new LinkedList();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.r = builder.user_tips_type.intValue();
            if (dataRes.req_unix != null) {
                c.a.p0.s.d0.b.j().w(c.a.p0.s.d0.b.n("concern_data_res_request_time"), dataRes.req_unix.longValue());
            }
            List<c.a.e.l.e.n> I = I(z, builder, z2);
            z(I, builder, k2);
            this.f17280j = false;
            if (I != null && TbadkCoreApplication.isLogin()) {
                if (ListUtils.isEmpty(I) || (ListUtils.getCount(I) == 1 && (ListUtils.getItem(I, 0) instanceof c.a.q0.f1.c.f.a))) {
                    int i4 = this.r;
                    if (3 == i4) {
                        c.a.q0.f1.c.f.b bVar = new c.a.q0.f1.c.f.b();
                        bVar.f17380i = c.a.q0.f1.c.f.b.f17375j;
                        bVar.f17376e = 3;
                        I.add(bVar);
                        this.f17280j = true;
                    } else if (2 == i4) {
                        c.a.q0.f1.c.f.b bVar2 = new c.a.q0.f1.c.f.b();
                        bVar2.f17380i = c.a.q0.f1.c.f.b.f17375j;
                        bVar2.f17376e = 2;
                        I.add(bVar2);
                        this.f17280j = true;
                    }
                }
                linkedList.addAll(I);
            }
            if (!c.a.e.e.p.k.isEmpty(builder.user_tips) && 2 == this.r) {
                c.a.q0.f1.c.f.b bVar3 = new c.a.q0.f1.c.f.b();
                bVar3.f17376e = builder.user_tips_type.intValue();
                bVar3.f17377f = builder.user_tips;
                if (builder.user_tips_type.intValue() == 4) {
                    bVar3.f17378g = true;
                } else {
                    bVar3.f17379h = true;
                }
                if (J() && ((i2 = bVar3.f17376e) == 2 || i2 == 3)) {
                    if (linkedList.size() > 0) {
                        bVar3.f17376e = 0;
                        z3 = false;
                        if (z3) {
                            linkedList.add(bVar3);
                        }
                    } else {
                        bVar3.f17377f = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                    }
                }
                z3 = true;
                if (z3) {
                }
            }
            this.f17277g = builder.has_more.intValue() == 1;
            if (ListUtils.isEmpty(linkedList)) {
                if (!this.f17272b.isEmpty()) {
                    Iterator<c.a.e.l.e.n> it = this.f17272b.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    this.l.j(this.f17272b);
                }
                return false;
            }
            this.f17272b.clear();
            this.f17272b.addAll(linkedList);
            if (z2) {
                DataRes.Builder builder2 = this.f17273c;
                builder2.page_tag = dataRes.page_tag;
                builder2.has_more = dataRes.has_more;
                builder2.user_list = dataRes.user_list;
                builder2.user_tips_type = dataRes.user_tips_type;
                builder2.user_tips = dataRes.user_tips;
                builder2.last_tips = dataRes.last_tips;
            }
            DataRes.Builder builder3 = this.f17273c;
            builder3.banner_user_story = dataRes.banner_user_story;
            builder3.banner_follow_live = dataRes.banner_follow_live;
            builder3.hot_recomforum = dataRes.hot_recomforum;
            builder3.top_tips = dataRes.top_tips;
            builder3.top_user_info = dataRes.top_user_info;
            int i5 = this.r;
            if (i5 == 2 || i5 == 3) {
                DataRes.Builder builder4 = this.f17273c;
                builder4.user_tips_type = dataRes.user_tips_type;
                builder4.user_tips = dataRes.user_tips;
            }
            this.l.j(this.f17272b);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void Q(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, builder) == null) && J()) {
            k0.b(new a(this, builder), null);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            G();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f17273c = new DataRes.Builder(this.f17274d.build(true));
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f17278h = z;
        }
    }

    public final void Y(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.l.j(list);
        }
    }

    public void Z(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, oVar) == null) {
            this.f17271a = oVar;
        }
    }

    public void a0(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, d0Var) == null) || d0Var == null) {
            return;
        }
        this.o = d0Var.a();
        this.p = d0Var.b();
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public void c0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            this.B.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.B);
            this.C.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.C);
            this.D.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.D);
            this.v.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.v);
            this.A.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.A);
            this.w.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(2001335, this.w);
            MessageManager.getInstance().registerListener(2001336, this.w);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (J() && !this.f17279i) {
                F();
            } else {
                G();
            }
        }
    }

    public final void e0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (builder = this.f17275e) == null) {
            return;
        }
        Q(builder);
    }

    public final List<o0> f0(List<o0> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (o0 o0Var : list) {
                if (o0Var instanceof AdvertAppInfo) {
                    arrayList.add(new c.a.q0.a0.d0.d((AdvertAppInfo) o0Var));
                } else if (o0Var instanceof c.a.q0.a0.d0.d) {
                    arrayList.add((c.a.q0.a0.d0.d) o0Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f17274d = new DataRes.Builder(this.f17273c.build(true));
        }
    }

    public final c.a.p0.b1.c s(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            String e2 = c.a.q0.x2.a.e(this.f17272b, z);
            c.a.p0.b1.c cVar = new c.a.p0.b1.c();
            cVar.f12822b = e2;
            return cVar;
        }
        return (c.a.p0.b1.c) invokeZ.objValue;
    }

    public final void t(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            c.a.q0.x2.l0.b.f().i("CONCERN", c.a.q0.x2.a.b(list));
        }
    }

    public final void u() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (builder = this.f17273c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f17272b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f17272b.size()) {
                break;
            } else if (this.f17272b.get(i2) instanceof c.a.q0.f1.c.f.a) {
                this.f17272b.remove(i2);
                c.a.q0.f1.c.a aVar = this.l;
                if (aVar != null) {
                    aVar.j(this.f17272b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f17273c.thread_info.size(); i3++) {
            if (c.a.q0.f1.c.f.a.o(this.f17273c.thread_info.get(i3))) {
                this.f17273c.thread_info.remove(i3);
                e0();
                return;
            }
        }
    }

    public final void v(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f17273c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f17272b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = this.f17272b.iterator();
        boolean z = false;
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
                        z = true;
                    } else if (z) {
                        c.a.q0.f1.c.a aVar = this.l;
                        if (aVar != null) {
                            aVar.j(this.f17272b);
                        }
                    }
                }
            }
        }
        long f2 = c.a.e.e.m.b.f(optString, 0L);
        for (int i2 = 0; i2 < this.f17273c.thread_info.size(); i2++) {
            ConcernData concernData = this.f17273c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                this.f17273c.thread_info.remove(i2);
                e0();
                return;
            }
        }
    }

    public final void z(List<c.a.e.l.e.n> list, DataRes.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048607, this, list, builder, i2) == null) {
            List<o0> f0 = f0(c.a.q0.x2.a.h(builder.app_list, "CONCERN"));
            if (this.f17273c == null) {
                this.f17273c = new DataRes.Builder();
            }
            if (c.a.q0.o1.o.k.a.e(this.f17273c.app_list)) {
                this.f17273c.app_list = new ArrayList();
            }
            this.f17273c.app_list.addAll(builder.app_list);
            if (this.t == 1 || i2 == 0) {
                this.u.clear();
            }
            f0.addAll(this.u);
            if (!c.a.q0.o1.o.k.a.e(f0)) {
                this.u = c.a.q0.x2.a.k(f0, list, i2);
            }
            c.a.q0.x2.a.u(list);
            c.a.q0.x2.a.a(list, this.t, "CONCERN");
            t(list);
        }
    }
}
