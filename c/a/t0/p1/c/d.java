package c.a.t0.p1.c;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.s0.d1.k0;
import c.a.s0.d1.n0;
import c.a.s0.d1.s;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.o0;
import c.a.t0.g0.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public o a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.d.n.e.n> f20460b;

    /* renamed from: c  reason: collision with root package name */
    public DataRes.Builder f20461c;

    /* renamed from: d  reason: collision with root package name */
    public DataRes.Builder f20462d;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f20463e;

    /* renamed from: f  reason: collision with root package name */
    public String f20464f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20465g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20466h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20467i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20468j;
    public final BdTypeRecyclerView k;
    public final c.a.t0.p1.c.a l;
    public c.a.t0.r0.a m;
    public boolean n;
    public final c.a.t0.p1.c.g.a o;
    public int p;
    public BigdaySwipeRefreshLayout q;
    public int r;
    public List<o0> s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public RecyclerView.OnScrollListener v;
    public CustomMessageListener w;
    public View.OnTouchListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes8.dex */
    public class a extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20469b;

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
            this.f20469b = dVar;
            this.a = builder;
        }

        @Override // c.a.s0.d1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            DataRes build;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<byte[]> e2 = c.a.s0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                try {
                    build = builder.build(true);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                    e2.g("0", build.toByteArray());
                    d.T(this.f20469b.f20464f);
                    d.U(System.currentTimeMillis());
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f20470b;

        /* renamed from: c  reason: collision with root package name */
        public String f20471c;

        /* renamed from: d  reason: collision with root package name */
        public String f20472d;

        /* renamed from: e  reason: collision with root package name */
        public String f20473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f20474f;

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
            this.f20474f = dVar;
            this.a = "";
            this.f20470b = "";
            this.f20471c = "";
            this.f20472d = "";
            this.f20473e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f20470b = jSONObject.optString("tid", "");
                    this.f20471c = jSONObject.optString("fid", "");
                    this.f20472d = jSONObject.optString("liveId", "");
                    this.f20473e = jSONObject.optString("sid", "");
                } else if ((this.a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.a)) && ((this.f20472d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f20472d)) && (this.f20473e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f20473e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f20470b);
                        jSONObject.put("fid", this.f20471c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f20474f.t(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.t(customResponsedMessage);
            }
        }
    }

    /* renamed from: c.a.t0.p1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1279d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1279d(d dVar, int i2) {
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.t(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
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
                if (!data.a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().f40770b, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (data.f40772d) {
                } else {
                    Iterator it = this.a.f20460b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof c.a.t0.g0.f0.b) && ThreadCardUtils.isTargetUser(((c.a.t0.g0.f0.b) next).getThreadData(), data.f40771c)) {
                            it.remove();
                        }
                    }
                    c.a.t0.k3.a.c(this.a.f20460b);
                    this.a.s.clear();
                    if (this.a.f20460b.size() < 9) {
                        this.a.E();
                    } else {
                        d dVar = this.a;
                        dVar.W(dVar.f20460b);
                        this.a.l.d();
                        if (this.a.a != null) {
                            this.a.a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.a.f20461c == null || this.a.f20461c.hot_recomforum == null || ListUtils.isEmpty(this.a.f20461c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.a.f20461c.hot_recomforum);
            if (c.a.t0.p1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.a.f20461c.hot_recomforum = builder.build(true);
                this.a.O(new DataRes.Builder(this.a.f20461c.build(true)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) && i2 == 0) {
                v.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
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

    /* loaded from: classes8.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f20461c == null || c.a.t0.y1.o.k.a.e(this.a.f20460b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.t0.k3.a.d(str, this.a.f20460b);
            c.a.t0.k3.a.d(str, this.a.f20461c.app_list);
            c.a.t0.k3.a.d(str, this.a.s);
            c.a.t0.k3.a.u(this.a.f20460b);
            if (this.a.l != null) {
                this.a.l.j(new ArrayList(this.a.f20460b));
            }
            d dVar = this.a;
            dVar.r(dVar.f20460b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20475e;

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
            this.f20475e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f20475e.m != null) {
                    this.f20475e.m.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k extends k0<DataRes> {
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
        @Override // c.a.s0.d1.k0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.s0.s.r.a.f();
                c.a.s0.s.r.a.a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements s<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.a.J(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends k0<DataRes> {
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
        @Override // c.a.s0.d1.k0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<byte[]> e2 = c.a.s0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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

    /* loaded from: classes8.dex */
    public class n implements s<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.a.J(dataRes);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface o {
        void a(c.a.s0.d1.g gVar);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, c.a.s0.d1.g gVar);

        void onError(int i2, String str);
    }

    public d(c.a.d.a.f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, c.a.t0.p1.c.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
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
        this.a = null;
        this.f20460b = new LinkedList<>();
        this.f20466h = false;
        this.f20467i = false;
        this.f20468j = false;
        this.n = false;
        this.r = 0;
        this.s = new ArrayList();
        this.t = new f(this, 2001115);
        this.u = new g(this, 0);
        this.v = new h(this);
        this.w = new i(this, 2016331);
        this.x = new j(this);
        this.y = new b(this, 2921547);
        this.z = new c(this, 2016488);
        this.A = new C1279d(this, 2016553);
        this.B = new e(this, 2921425);
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.x);
        this.m = new c.a.t0.r0.a();
        this.o = new c.a.t0.p1.c.g.a();
        this.l = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.v);
        this.q = bigdaySwipeRefreshLayout;
        R(false);
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.s0.s.i0.b.k().h(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_loaded"), false) : invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.s0.b.d.i() && c.a.s0.s.i0.b.k().l("key_home_concern_all_status", 0) == 0 : invokeV.booleanValue;
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            c.a.s0.s.i0.b.k().u(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_loaded"), z);
        }
    }

    public static void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            c.a.s0.s.i0.b.k().y(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_nextpage_key"), str);
        }
    }

    public static void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            c.a.s0.s.i0.b.k().y(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_nextpage_update_key"), str);
        }
    }

    public static void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j2) == null) {
            c.a.s0.s.i0.b.k().x(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_time"), j2);
        }
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c.a.s0.s.i0.b.k().q(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_nextpage_key"), "") : (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? c.a.s0.s.i0.b.k().q(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_nextpage_update_key"), "") : (String) invokeV.objValue;
    }

    public static long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c.a.s0.s.i0.b.k().m(c.a.s0.s.i0.b.o("key_home_concern_all_status_cache_time"), 0L) : invokeV.longValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20466h : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20468j : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long w = w();
            long j2 = currentTimeMillis - w;
            if (w != 0 && j2 <= 86400000) {
                n0.b(new m(this), new n(this));
            } else {
                n0.b(new k(this), new l(this));
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.d1.g q = q(true);
            o oVar = this.a;
            if (oVar != null) {
                oVar.a(q);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !B() && this.f20465g) {
            c.a.s0.d1.g q = q(false);
            if (this.a != null) {
                V(true);
                this.a.d(this.f20464f, q);
            }
        }
    }

    public final List<c.a.d.n.e.n> G(boolean z, DataRes.Builder builder, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), builder, Boolean.valueOf(z2)})) == null) {
            if (this.f20461c == null) {
                this.f20461c = new DataRes.Builder();
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            c.a.t0.p1.h.k.d b2 = this.o.b(z, this.f20461c, builder, !z2 ? 1 : 0);
            if (b2 != null) {
                return b2.a;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public final void J(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            this.f20467i = true;
            R(true);
            if (dataRes != null) {
                if (N(false, true, dataRes)) {
                    o oVar = this.a;
                    if (oVar != null) {
                        oVar.c(false, true);
                        return;
                    }
                    return;
                }
                E();
                return;
            }
            E();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l.f();
        }
    }

    public void L(boolean z, DataRes dataRes, int i2, String str) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            V(false);
            if (i2 == 0 && dataRes != null && N(true, z, dataRes)) {
                o oVar2 = this.a;
                if (oVar2 != null) {
                    oVar2.c(z, false);
                }
                if (z) {
                    a0();
                }
            } else if (i2 == 0 && ListUtils.getCount(this.f20460b) == 0 && (oVar = this.a) != null) {
                oVar.b();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.q;
                if (bigdaySwipeRefreshLayout != null) {
                    bigdaySwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.f20460b.size() > 0) {
                o oVar3 = this.a;
                if (oVar3 != null) {
                    oVar3.onError(1, str);
                }
            } else {
                o oVar4 = this.a;
                if (oVar4 != null) {
                    oVar4.onError(2, str);
                }
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.q;
            if (bigdaySwipeRefreshLayout2 != null) {
                bigdaySwipeRefreshLayout2.setRefreshing(false);
            }
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z) {
            this.l.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean N(boolean z, boolean z2, DataRes dataRes) {
        InterceptResult invokeCommon;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dataRes})) == null) {
            if (dataRes == null) {
                return false;
            }
            int i3 = z2 ? 1 : this.r + 1;
            this.r = i3;
            int k2 = i3 == 1 ? 0 : c.a.t0.y1.o.k.a.k(this.f20460b);
            this.f20464f = dataRes.page_tag;
            this.f20463e = new DataRes.Builder(dataRes);
            if (H()) {
                S(this.f20464f);
            }
            LinkedList linkedList = new LinkedList();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.p = builder.user_tips_type.intValue();
            if (dataRes.req_unix != null) {
                c.a.s0.s.i0.b.k().x(c.a.s0.s.i0.b.o("concern_data_res_request_time"), dataRes.req_unix.longValue());
            }
            List<c.a.d.n.e.n> G = G(z, builder, z2);
            x(G, builder, k2);
            this.f20468j = false;
            if (G != null && TbadkCoreApplication.isLogin()) {
                if (ListUtils.isEmpty(G) || (ListUtils.getCount(G) == 1 && (ListUtils.getItem(G, 0) instanceof c.a.t0.p1.c.f.a))) {
                    int i4 = this.p;
                    if (3 == i4) {
                        c.a.t0.p1.c.f.b bVar = new c.a.t0.p1.c.f.b();
                        bVar.f20538i = c.a.t0.p1.c.f.b.f20533j;
                        bVar.f20534e = 3;
                        G.add(bVar);
                        this.f20468j = true;
                    } else if (2 == i4) {
                        c.a.t0.p1.c.f.b bVar2 = new c.a.t0.p1.c.f.b();
                        bVar2.f20534e = builder.user_tips_type.intValue();
                        bVar2.f20535f = builder.user_tips;
                        if (builder.user_tips_type.intValue() == 4) {
                            bVar2.f20536g = true;
                        } else {
                            bVar2.f20537h = true;
                        }
                        if (H() && ((i2 = bVar2.f20534e) == 2 || i2 == 3)) {
                            if (linkedList.size() > 0) {
                                bVar2.f20534e = 0;
                                z3 = false;
                                if (z3) {
                                    linkedList.add(bVar2);
                                }
                            } else {
                                bVar2.f20535f = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                    }
                }
                linkedList.addAll(G);
            }
            this.f20465g = builder.has_more.intValue() == 1;
            if (ListUtils.isEmpty(linkedList)) {
                if (!this.f20460b.isEmpty()) {
                    c.a.d.n.e.n nVar = null;
                    Iterator<c.a.d.n.e.n> it = this.f20460b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.d.n.e.n next = it.next();
                        if (next instanceof c.a.s0.u.b) {
                            nVar = next;
                            break;
                        }
                    }
                    if (nVar != null) {
                        this.f20460b.remove(nVar);
                    }
                    this.l.j(this.f20460b);
                }
                return false;
            }
            this.f20460b.clear();
            this.f20460b.addAll(linkedList);
            if (z2) {
                DataRes.Builder builder2 = this.f20461c;
                builder2.page_tag = dataRes.page_tag;
                builder2.has_more = dataRes.has_more;
                builder2.user_list = dataRes.user_list;
                builder2.user_tips_type = dataRes.user_tips_type;
                builder2.user_tips = dataRes.user_tips;
                builder2.last_tips = dataRes.last_tips;
            }
            DataRes.Builder builder3 = this.f20461c;
            builder3.banner_user_story = dataRes.banner_user_story;
            builder3.banner_follow_live = dataRes.banner_follow_live;
            builder3.hot_recomforum = dataRes.hot_recomforum;
            builder3.top_tips = dataRes.top_tips;
            builder3.top_user_info = dataRes.top_user_info;
            int i5 = this.p;
            if (i5 == 2 || i5 == 3) {
                DataRes.Builder builder4 = this.f20461c;
                builder4.user_tips_type = dataRes.user_tips_type;
                builder4.user_tips = dataRes.user_tips;
            }
            this.l.j(this.f20460b);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void O(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, builder) == null) && H()) {
            n0.b(new a(this, builder), null);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            E();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f20461c = new DataRes.Builder(this.f20462d.build(true));
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f20466h = z;
        }
    }

    public final void W(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.l.j(list);
        }
    }

    public void X(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, oVar) == null) {
            this.a = oVar;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public void Z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            this.z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
            this.A.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.A);
            this.B.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.B);
            this.t.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.t);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
            this.u.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(2001335, this.u);
            MessageManager.getInstance().registerListener(2001336, this.u);
            this.w.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.w);
        }
    }

    public final void a0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (builder = this.f20463e) == null) {
            return;
        }
        O(builder);
    }

    public final List<o0> b0(List<o0> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (o0 o0Var : list) {
                if (o0Var instanceof AdvertAppInfo) {
                    arrayList.add(new c.a.t0.g0.f0.d((AdvertAppInfo) o0Var));
                } else if (o0Var instanceof c.a.t0.g0.f0.d) {
                    arrayList.add((c.a.t0.g0.f0.d) o0Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f20462d = new DataRes.Builder(this.f20461c.build(true));
        }
    }

    public final c.a.s0.d1.g q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            String e2 = c.a.t0.k3.a.e(this.f20460b, z);
            c.a.s0.d1.g gVar = new c.a.s0.d1.g();
            gVar.f12505b = e2;
            return gVar;
        }
        return (c.a.s0.d1.g) invokeZ.objValue;
    }

    public final void r(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            c.a.t0.k3.l0.b.f().i("CONCERN", c.a.t0.k3.a.b(list));
        }
    }

    public final void s() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (builder = this.f20461c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f20460b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f20460b.size()) {
                break;
            } else if (this.f20460b.get(i2) instanceof c.a.t0.p1.c.f.a) {
                this.f20460b.remove(i2);
                c.a.t0.p1.c.a aVar = this.l;
                if (aVar != null) {
                    aVar.j(this.f20460b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f20461c.thread_info.size(); i3++) {
            if (c.a.t0.p1.c.f.a.o(this.f20461c.thread_info.get(i3))) {
                this.f20461c.thread_info.remove(i3);
                a0();
                return;
            }
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f20461c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f20460b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = this.f20460b.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next instanceof c.a.t0.g0.f0.b) {
                c.a.t0.g0.f0.b bVar = (c.a.t0.g0.f0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().w1() != null) {
                    if (bVar.getThreadData().w1().equals(optString)) {
                        it.remove();
                        z = true;
                    } else if (z) {
                        c.a.t0.p1.c.a aVar = this.l;
                        if (aVar != null) {
                            aVar.j(this.f20460b);
                        }
                    }
                }
            }
        }
        long g2 = c.a.d.f.m.b.g(optString, 0L);
        for (int i2 = 0; i2 < this.f20461c.thread_info.size(); i2++) {
            ConcernData concernData = this.f20461c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                this.f20461c.thread_info.remove(i2);
                a0();
                return;
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (H() && !this.f20467i) {
                D();
            } else {
                E();
            }
        }
    }

    public final void x(List<c.a.d.n.e.n> list, DataRes.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, list, builder, i2) == null) {
            List<o0> b0 = b0(c.a.t0.k3.a.h(builder.app_list, "CONCERN"));
            if (this.f20461c == null) {
                this.f20461c = new DataRes.Builder();
            }
            if (c.a.t0.y1.o.k.a.e(this.f20461c.app_list)) {
                this.f20461c.app_list = new ArrayList();
            }
            this.f20461c.app_list.addAll(builder.app_list);
            if (this.r == 1 || i2 == 0) {
                this.s.clear();
            }
            b0.addAll(this.s);
            if (!c.a.t0.y1.o.k.a.e(b0)) {
                this.s = c.a.t0.k3.a.k(b0, list, i2);
            }
            c.a.t0.k3.a.u(list);
            c.a.t0.k3.a.a(list, this.r, "CONCERN");
            r(list);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f20465g : invokeV.booleanValue;
    }

    public void z(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, e2Var) == null) {
            e2Var.O3(true);
            c.a.s0.b.f.a.e(e2Var);
            List<c.a.d.n.e.n> e2 = this.o.e(e2Var, -1, null);
            DataRes.Builder builder = this.f20461c;
            if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.f20460b) <= 1) {
                this.f20460b.clear();
            }
            this.f20460b.addAll(0, e2);
            this.l.j(this.f20460b);
        }
    }
}
