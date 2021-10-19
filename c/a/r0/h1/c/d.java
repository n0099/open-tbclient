package c.a.r0.h1.c;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.o0;
import c.a.r0.b0.u;
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

    /* renamed from: a  reason: collision with root package name */
    public o f17972a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<c.a.e.l.e.n> f17973b;

    /* renamed from: c  reason: collision with root package name */
    public DataRes.Builder f17974c;

    /* renamed from: d  reason: collision with root package name */
    public DataRes.Builder f17975d;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f17976e;

    /* renamed from: f  reason: collision with root package name */
    public String f17977f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17978g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17979h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17980i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17981j;
    public final BdTypeRecyclerView k;
    public final c.a.r0.h1.c.a l;
    public c.a.r0.k0.a m;
    public boolean n;
    public final c.a.r0.h1.c.g.a o;
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

    /* loaded from: classes3.dex */
    public class a extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f17982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f17983b;

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
            this.f17983b = dVar;
            this.f17982a = builder;
        }

        @Override // c.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            DataRes build;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f17982a.build(true));
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<byte[]> e2 = c.a.q0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                try {
                    build = builder.build(true);
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
                if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                    e2.g("0", build.toByteArray());
                    d.T(this.f17983b.f17977f);
                    d.U(System.currentTimeMillis());
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
        public String f17984a;

        /* renamed from: b  reason: collision with root package name */
        public String f17985b;

        /* renamed from: c  reason: collision with root package name */
        public String f17986c;

        /* renamed from: d  reason: collision with root package name */
        public String f17987d;

        /* renamed from: e  reason: collision with root package name */
        public String f17988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17989f;

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
            this.f17989f = dVar;
            this.f17984a = "";
            this.f17985b = "";
            this.f17986c = "";
            this.f17987d = "";
            this.f17988e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f17984a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f17985b = jSONObject.optString("tid", "");
                    this.f17986c = jSONObject.optString("fid", "");
                    this.f17987d = jSONObject.optString("liveId", "");
                    this.f17988e = jSONObject.optString("sid", "");
                } else if ((this.f17984a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f17984a)) && ((this.f17987d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f17987d)) && (this.f17988e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f17988e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f17985b);
                        jSONObject.put("fid", this.f17986c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f17989f.t(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17990a;

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
            this.f17990a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17990a.t(customResponsedMessage);
            }
        }
    }

    /* renamed from: c.a.r0.h1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0875d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17991a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0875d(d dVar, int i2) {
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
            this.f17991a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17991a.t(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17992a;

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
            this.f17992a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17992a.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17993a;

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
            this.f17993a = dVar;
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
                if (!data.f48111a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().f48112b, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                } else if (data.f48114d) {
                } else {
                    Iterator it = this.f17993a.f17973b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof c.a.r0.b0.e0.b) && ThreadCardUtils.isTargetUser(((c.a.r0.b0.e0.b) next).getThreadData(), data.f48113c)) {
                            it.remove();
                        }
                    }
                    c.a.r0.z2.a.c(this.f17993a.f17973b);
                    this.f17993a.s.clear();
                    if (this.f17993a.f17973b.size() < 9) {
                        this.f17993a.E();
                    } else {
                        d dVar = this.f17993a;
                        dVar.W(dVar.f17973b);
                        this.f17993a.l.d();
                        if (this.f17993a.f17972a != null) {
                            this.f17993a.f17972a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17993a.n)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17994a;

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
            this.f17994a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.f17994a.f17974c == null || this.f17994a.f17974c.hot_recomforum == null || ListUtils.isEmpty(this.f17994a.f17974c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.f17994a.f17974c.hot_recomforum);
            if (c.a.r0.h1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.f17994a.f17974c.hot_recomforum = builder.build(true);
                this.f17994a.O(new DataRes.Builder(this.f17994a.f17974c.build(true)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17995a;

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
            this.f17995a = dVar;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17995a.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) && i2 == 0) {
                u.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17995a.n)));
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
        public final /* synthetic */ d f17996a;

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
            this.f17996a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f17996a.f17974c == null || c.a.r0.q1.o.k.a.e(this.f17996a.f17973b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a.r0.z2.a.d(str, this.f17996a.f17973b);
            c.a.r0.z2.a.d(str, this.f17996a.f17974c.app_list);
            c.a.r0.z2.a.d(str, this.f17996a.s);
            c.a.r0.z2.a.u(this.f17996a.f17973b);
            if (this.f17996a.l != null) {
                this.f17996a.l.j(new ArrayList(this.f17996a.f17973b));
            }
            d dVar = this.f17996a;
            dVar.r(dVar.f17973b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.f17996a.n)));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17997e;

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
            this.f17997e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f17997e.m != null) {
                    this.f17997e.m.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends i0<DataRes> {
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
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                c.a.q0.s.r.a.a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17998a;

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
            this.f17998a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f17998a.J(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends i0<DataRes> {
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
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<byte[]> e2 = c.a.q0.s.r.a.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
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
    public class n implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17999a;

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
            this.f17999a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f17999a.J(dataRes);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(c.a.q0.d1.e eVar);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, c.a.q0.d1.e eVar);

        void onError(int i2, String str);
    }

    public d(c.a.e.a.f<?> fVar, BdTypeRecyclerView bdTypeRecyclerView, c.a.r0.h1.c.a aVar, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
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
        this.f17972a = null;
        this.f17973b = new LinkedList<>();
        this.f17979h = false;
        this.f17980i = false;
        this.f17981j = false;
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
        this.A = new C0875d(this, 2016553);
        this.B = new e(this, 2921425);
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.x);
        this.m = new c.a.r0.k0.a();
        this.o = new c.a.r0.h1.c.g.a();
        this.l = aVar;
        bdTypeRecyclerView.setOnScrollListener(this.v);
        this.q = bigdaySwipeRefreshLayout;
        R(false);
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.q0.s.d0.b.j().g(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_loaded"), false) : invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.q0.b.d.i() && c.a.q0.s.d0.b.j().k("key_home_concern_all_status", 0) == 0 : invokeV.booleanValue;
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            c.a.q0.s.d0.b.j().t(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_loaded"), z);
        }
    }

    public static void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            c.a.q0.s.d0.b.j().x(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), str);
        }
    }

    public static void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            c.a.q0.s.d0.b.j().x(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), str);
        }
    }

    public static void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j2) == null) {
            c.a.q0.s.d0.b.j().w(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_time"), j2);
        }
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c.a.q0.s.d0.b.j().p(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_key"), "") : (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? c.a.q0.s.d0.b.j().p(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_nextpage_update_key"), "") : (String) invokeV.objValue;
    }

    public static long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c.a.q0.s.d0.b.j().l(c.a.q0.s.d0.b.n("key_home_concern_all_status_cache_time"), 0L) : invokeV.longValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17979h : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17981j : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long w = w();
            long j2 = currentTimeMillis - w;
            if (w != 0 && j2 <= 86400000) {
                l0.b(new m(this), new n(this));
            } else {
                l0.b(new k(this), new l(this));
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.d1.e q = q(true);
            o oVar = this.f17972a;
            if (oVar != null) {
                oVar.a(q);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !B() && this.f17978g) {
            c.a.q0.d1.e q = q(false);
            if (this.f17972a != null) {
                V(true);
                this.f17972a.d(this.f17977f, q);
            }
        }
    }

    public final List<c.a.e.l.e.n> G(boolean z, DataRes.Builder builder, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), builder, Boolean.valueOf(z2)})) == null) {
            if (this.f17974c == null) {
                this.f17974c = new DataRes.Builder();
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            c.a.r0.h1.h.k.d b2 = this.o.b(z, this.f17974c, builder, !z2 ? 1 : 0);
            if (b2 != null) {
                return b2.f18550a;
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
            this.f17980i = true;
            R(true);
            if (dataRes != null) {
                if (N(false, true, dataRes)) {
                    o oVar = this.f17972a;
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
                o oVar2 = this.f17972a;
                if (oVar2 != null) {
                    oVar2.c(z, false);
                }
                if (z) {
                    b0();
                }
            } else if (i2 == 0 && ListUtils.getCount(this.f17973b) == 0 && (oVar = this.f17972a) != null) {
                oVar.b();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.q;
                if (bigdaySwipeRefreshLayout != null) {
                    bigdaySwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.f17973b.size() > 0) {
                o oVar3 = this.f17972a;
                if (oVar3 != null) {
                    oVar3.onError(1, str);
                }
            } else {
                o oVar4 = this.f17972a;
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

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fc  */
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
            int k2 = i3 == 1 ? 0 : c.a.r0.q1.o.k.a.k(this.f17973b);
            this.f17977f = dataRes.page_tag;
            this.f17976e = new DataRes.Builder(dataRes);
            if (H()) {
                S(this.f17977f);
            }
            LinkedList linkedList = new LinkedList();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.p = builder.user_tips_type.intValue();
            if (dataRes.req_unix != null) {
                c.a.q0.s.d0.b.j().w(c.a.q0.s.d0.b.n("concern_data_res_request_time"), dataRes.req_unix.longValue());
            }
            List<c.a.e.l.e.n> G = G(z, builder, z2);
            x(G, builder, k2);
            this.f17981j = false;
            if (G != null && TbadkCoreApplication.isLogin()) {
                if (ListUtils.isEmpty(G) || (ListUtils.getCount(G) == 1 && (ListUtils.getItem(G, 0) instanceof c.a.r0.h1.c.f.a))) {
                    int i4 = this.p;
                    if (3 == i4) {
                        c.a.r0.h1.c.f.b bVar = new c.a.r0.h1.c.f.b();
                        bVar.f18081i = c.a.r0.h1.c.f.b.f18076j;
                        bVar.f18077e = 3;
                        G.add(bVar);
                        this.f17981j = true;
                    } else if (2 == i4) {
                        c.a.r0.h1.c.f.b bVar2 = new c.a.r0.h1.c.f.b();
                        bVar2.f18081i = c.a.r0.h1.c.f.b.f18076j;
                        bVar2.f18077e = 2;
                        G.add(bVar2);
                        this.f17981j = true;
                    }
                }
                linkedList.addAll(G);
            }
            if (!c.a.e.e.p.k.isEmpty(builder.user_tips) && 2 == this.p) {
                c.a.r0.h1.c.f.b bVar3 = new c.a.r0.h1.c.f.b();
                bVar3.f18077e = builder.user_tips_type.intValue();
                bVar3.f18078f = builder.user_tips;
                if (builder.user_tips_type.intValue() == 4) {
                    bVar3.f18079g = true;
                } else {
                    bVar3.f18080h = true;
                }
                if (H() && ((i2 = bVar3.f18077e) == 2 || i2 == 3)) {
                    if (linkedList.size() > 0) {
                        bVar3.f18077e = 0;
                        z3 = false;
                        if (z3) {
                            linkedList.add(bVar3);
                        }
                    } else {
                        bVar3.f18078f = TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title);
                    }
                }
                z3 = true;
                if (z3) {
                }
            }
            this.f17978g = builder.has_more.intValue() == 1;
            if (ListUtils.isEmpty(linkedList)) {
                if (!this.f17973b.isEmpty()) {
                    Iterator<c.a.e.l.e.n> it = this.f17973b.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    this.l.j(this.f17973b);
                }
                return false;
            }
            this.f17973b.clear();
            this.f17973b.addAll(linkedList);
            if (z2) {
                DataRes.Builder builder2 = this.f17974c;
                builder2.page_tag = dataRes.page_tag;
                builder2.has_more = dataRes.has_more;
                builder2.user_list = dataRes.user_list;
                builder2.user_tips_type = dataRes.user_tips_type;
                builder2.user_tips = dataRes.user_tips;
                builder2.last_tips = dataRes.last_tips;
            }
            DataRes.Builder builder3 = this.f17974c;
            builder3.banner_user_story = dataRes.banner_user_story;
            builder3.banner_follow_live = dataRes.banner_follow_live;
            builder3.hot_recomforum = dataRes.hot_recomforum;
            builder3.top_tips = dataRes.top_tips;
            builder3.top_user_info = dataRes.top_user_info;
            int i5 = this.p;
            if (i5 == 2 || i5 == 3) {
                DataRes.Builder builder4 = this.f17974c;
                builder4.user_tips_type = dataRes.user_tips_type;
                builder4.user_tips = dataRes.user_tips;
            }
            this.l.j(this.f17973b);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void O(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, builder) == null) && H()) {
            l0.b(new a(this, builder), null);
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
            this.f17974c = new DataRes.Builder(this.f17975d.build(true));
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f17979h = z;
        }
    }

    public final void W(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.l.j(list);
        }
    }

    public void X(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, oVar) == null) {
            this.f17972a = oVar;
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

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (H() && !this.f17980i) {
                D();
            } else {
                E();
            }
        }
    }

    public final void b0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (builder = this.f17976e) == null) {
            return;
        }
        O(builder);
    }

    public final List<o0> c0(List<o0> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (o0 o0Var : list) {
                if (o0Var instanceof AdvertAppInfo) {
                    arrayList.add(new c.a.r0.b0.e0.d((AdvertAppInfo) o0Var));
                } else if (o0Var instanceof c.a.r0.b0.e0.d) {
                    arrayList.add((c.a.r0.b0.e0.d) o0Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f17975d = new DataRes.Builder(this.f17974c.build(true));
        }
    }

    public final c.a.q0.d1.e q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            String e2 = c.a.r0.z2.a.e(this.f17973b, z);
            c.a.q0.d1.e eVar = new c.a.q0.d1.e();
            eVar.f12929b = e2;
            return eVar;
        }
        return (c.a.q0.d1.e) invokeZ.objValue;
    }

    public final void r(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            c.a.r0.z2.l0.b.f().i("CONCERN", c.a.r0.z2.a.b(list));
        }
    }

    public final void s() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (builder = this.f17974c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f17973b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f17973b.size()) {
                break;
            } else if (this.f17973b.get(i2) instanceof c.a.r0.h1.c.f.a) {
                this.f17973b.remove(i2);
                c.a.r0.h1.c.a aVar = this.l;
                if (aVar != null) {
                    aVar.j(this.f17973b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.f17974c.thread_info.size(); i3++) {
            if (c.a.r0.h1.c.f.a.o(this.f17974c.thread_info.get(i3))) {
                this.f17974c.thread_info.remove(i3);
                b0();
                return;
            }
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f17974c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.f17973b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = this.f17973b.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.e.l.e.n next = it.next();
            if (next instanceof c.a.r0.b0.e0.b) {
                c.a.r0.b0.e0.b bVar = (c.a.r0.b0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().s1() != null) {
                    if (bVar.getThreadData().s1().equals(optString)) {
                        it.remove();
                        z = true;
                    } else if (z) {
                        c.a.r0.h1.c.a aVar = this.l;
                        if (aVar != null) {
                            aVar.j(this.f17973b);
                        }
                    }
                }
            }
        }
        long g2 = c.a.e.e.m.b.g(optString, 0L);
        for (int i2 = 0; i2 < this.f17974c.thread_info.size(); i2++) {
            ConcernData concernData = this.f17974c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                this.f17974c.thread_info.remove(i2);
                b0();
                return;
            }
        }
    }

    public final void x(List<c.a.e.l.e.n> list, DataRes.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, list, builder, i2) == null) {
            List<o0> c0 = c0(c.a.r0.z2.a.h(builder.app_list, "CONCERN"));
            if (this.f17974c == null) {
                this.f17974c = new DataRes.Builder();
            }
            if (c.a.r0.q1.o.k.a.e(this.f17974c.app_list)) {
                this.f17974c.app_list = new ArrayList();
            }
            this.f17974c.app_list.addAll(builder.app_list);
            if (this.r == 1 || i2 == 0) {
                this.s.clear();
            }
            c0.addAll(this.s);
            if (!c.a.r0.q1.o.k.a.e(c0)) {
                this.s = c.a.r0.z2.a.k(c0, list, i2);
            }
            c.a.r0.z2.a.u(list);
            c.a.r0.z2.a.a(list, this.r, "CONCERN");
            r(list);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f17978g : invokeV.booleanValue;
    }

    public void z(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, d2Var) == null) {
            d2Var.I3(true);
            c.a.q0.b.f.a.e(d2Var);
            List<c.a.e.l.e.n> e2 = this.o.e(d2Var, -1, null);
            DataRes.Builder builder = this.f17974c;
            if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.f17973b) <= 1) {
                this.f17973b.clear();
            }
            this.f17973b.addAll(0, e2);
            this.l.j(this.f17973b);
        }
    }
}
