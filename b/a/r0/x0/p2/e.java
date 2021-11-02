package b.a.r0.x0.p2;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f26088a;

    /* renamed from: b  reason: collision with root package name */
    public d2 f26089b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f26090c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f26091d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f26092e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f26093f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f26094g;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f26095a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f26097c;

        public a(e eVar, View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26097c = eVar;
            this.f26095a = view;
            this.f26096b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f26097c.f26088a == null || this.f26097c.f26088a.getFrsView() == null || this.f26097c.f26088a.getFrsView().a0() == null || this.f26097c.f26088a.getFrsView().V() == null) {
                return;
            }
            this.f26097c.f26088a.getFrsView().a0().removeView(this.f26095a);
            this.f26097c.j(this.f26096b);
            this.f26097c.f26088a.getFrsView().V().notifyDataSetChanged();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26099b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f26100c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26101d;

        public b(e eVar, String str, String str2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26101d = eVar;
            this.f26098a = str;
            this.f26099b = str2;
            this.f26100c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f26101d.k(this.f26098a, this.f26099b);
                this.f26100c.setVisibility(8);
                if (this.f26101d.f26088a.getFrsView() == null || this.f26101d.f26088a.getFrsView().V() == null) {
                    return;
                }
                this.f26101d.f26088a.getFrsView().V().notifyDataSetChanged();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26102a;

        /* renamed from: b  reason: collision with root package name */
        public String f26103b;

        /* renamed from: c  reason: collision with root package name */
        public String f26104c;

        /* renamed from: d  reason: collision with root package name */
        public String f26105d;

        /* renamed from: e  reason: collision with root package name */
        public String f26106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26107f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, int i2) {
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
            this.f26107f = eVar;
            this.f26102a = "";
            this.f26103b = "";
            this.f26104c = "";
            this.f26105d = "";
            this.f26106e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f26102a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f26103b = jSONObject.optString("tid", "");
                    this.f26104c = jSONObject.optString("fid", "");
                    this.f26105d = jSONObject.optString("liveId", "");
                    this.f26106e = jSONObject.optString("sid", "");
                } else if ((this.f26102a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f26102a)) && ((this.f26105d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f26105d)) && (this.f26106e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f26106e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f26103b);
                        jSONObject.put("fid", this.f26104c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f26107f.t(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26108a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
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
            this.f26108a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26108a.n(customResponsedMessage);
            }
        }
    }

    /* renamed from: b.a.r0.x0.p2.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1285e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26109a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1285e(e eVar, int i2) {
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
            this.f26109a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26109a.t(customResponsedMessage, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26110a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i2) {
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
            this.f26110a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26110a.j(this.f26110a.u(customResponsedMessage));
                this.f26110a.f26088a.getFrsView().V().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f26111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f26112f;

        public g(e eVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26111e = i2;
            this.f26112f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                int i2 = this.f26111e;
                this.f26112f.getLayoutParams().height = i2 - ((int) (i2 * f2));
                this.f26112f.requestLayout();
            }
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26113a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(e eVar, int i2) {
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
            this.f26113a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26113a.f26088a == null || this.f26113a.f26088a.getModelController() == null || this.f26113a.f26088a.getModelController().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f26113a.m(str, this.f26113a.f26088a.getModelController().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = this.f26113a;
            eVar.l(str, eVar.f26088a.getFrsView().a0().getData());
            e eVar2 = this.f26113a;
            eVar2.l(str, eVar2.f26088a.getFrsLoadMoreModelController().f().z());
            this.f26113a.f26088a.getModelController().I(str);
            if (this.f26113a.f26088a.getFrsView() == null || this.f26113a.f26088a.getFrsView().V() == null) {
                return;
            }
            this.f26113a.f26088a.getFrsView().V().notifyDataSetChanged();
        }
    }

    public e(l lVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26090c = new c(this, 2921547);
        this.f26091d = new d(this, 2921324);
        this.f26092e = new C1285e(this, 2016488);
        this.f26093f = new f(this, 2016553);
        this.f26094g = new h(this, 2016331);
        this.f26088a = lVar;
        this.f26092e.setTag(bdUniqueId);
        this.f26094g.setTag(bdUniqueId);
        this.f26091d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26091d);
        MessageManager.getInstance().registerListener(this.f26092e);
        MessageManager.getInstance().registerListener(this.f26094g);
        this.f26093f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26093f);
        this.f26090c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26090c);
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (d2Var = this.f26089b) != null && d2Var.W1) {
            TbPageTag tbPageTag = null;
            l lVar = this.f26088a;
            if (lVar != null && lVar.getFrsView() != null) {
                tbPageTag = b.a.q0.n0.c.k(this.f26088a.getFrsView().getContext());
            }
            b.a.r0.x0.u2.a.k(this.f26089b, tbPageTag);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<b.a.e.l.e.n> threadList = this.f26088a.getModelController().d0().getThreadList();
        p(str, threadList);
        p(str, this.f26088a.getFrsView().a0().getData());
        p(str, this.f26088a.getFrsLoadMoreModelController().e());
        this.f26088a.getModelController().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f26088a.loadMore();
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<b.a.e.l.e.n> threadList = this.f26088a.getModelController().d0().getThreadList();
            q(str, str2, threadList);
            q(str, str2, this.f26088a.getFrsView().a0().getData());
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                this.f26088a.getModelController().J(str2);
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                this.f26088a.getModelController().K(str2);
            }
            if (threadList == null || threadList.size() >= 5) {
                return;
            }
            this.f26088a.loadMore();
        }
    }

    public final void l(String str, List<b.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<b.a.e.l.e.n> it = list.iterator();
        while (it.hasNext()) {
            b.a.e.l.e.n next = it.next();
            if (next instanceof b.a.r0.g.c) {
                Object a2 = ((b.a.r0.g.c) next).a();
                if ((a2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) a2).X3)) {
                    it.remove();
                }
            }
        }
    }

    public final void m(String str, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null && str.equals(next.X3)) {
                it.remove();
            }
        }
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f26088a) == null || lVar.getModelController() == null || this.f26088a.getModelController().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f26088a.getFrsView() == null || this.f26088a.getFrsView().V() == null) {
            return;
        }
        View childAt = this.f26088a.getFrsView().a0().getChildAt(s(optString, optString2, this.f26088a.getFrsView().a0()));
        if (childAt != null) {
            o(childAt, new b(this, optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f26088a.getFrsView().V().notifyDataSetChanged();
    }

    public final void o(View view, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, animationListener) == null) {
            g gVar = new g(this, view.getMeasuredHeight(), view);
            gVar.setAnimationListener(animationListener);
            gVar.setDuration(300L);
            view.startAnimation(gVar);
        }
    }

    public final void p(String str, List<b.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b.a.e.l.e.n nVar : list) {
            if (nVar instanceof c2) {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.s1() != null && d2Var.s1().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        list.removeAll(arrayList);
        b.a.e.l.e.n nVar2 = (b.a.e.l.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof u) {
            list.remove(nVar2);
        }
    }

    public final void q(String str, String str2, List<b.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b.a.e.l.e.n nVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (nVar instanceof b.a.r0.l3.h) {
                    arrayList.add((b.a.r0.l3.h) nVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof c2)) {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.s1() != null && d2Var.s1().equals(str2)) {
                    arrayList.add(d2Var);
                }
            }
        }
        list.removeAll(arrayList);
        b.a.e.l.e.n nVar2 = (b.a.e.l.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof u) {
            list.remove(nVar2);
        }
    }

    public final int r(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i2 = 0;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getAdapter().getItemCount(); i3++) {
                b.a.e.l.e.n item = bdTypeRecyclerView.getItem(i3);
                if (item instanceof c2) {
                    d2 d2Var = ((c2) item).w;
                    if (d2Var.s1() != null && d2Var.s1().equals(str)) {
                        this.f26089b = d2Var;
                        i2 = i3;
                    }
                }
            }
            return (i2 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLL.intValue;
    }

    public final int s(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i3 = 0;
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                i2 = 0;
                while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    if (bdTypeRecyclerView.getItem(i3) instanceof b.a.r0.l3.h) {
                        i2 = i3;
                    }
                    i3++;
                }
            } else {
                if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                    i2 = 0;
                    while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                        b.a.e.l.e.n item = bdTypeRecyclerView.getItem(i3);
                        if (item instanceof c2) {
                            d2 d2Var = ((c2) item).w;
                            if (d2Var.s1() != null && d2Var.s1().equals(str2)) {
                                i2 = i3;
                            }
                        }
                        i3++;
                    }
                }
                return (i3 + headerViewsCount) - firstVisiblePosition;
            }
            i3 = i2;
            return (i3 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLLL.intValue;
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage, boolean z) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, customResponsedMessage, z) == null) || (lVar = this.f26088a) == null || lVar.getModelController() == null || this.f26088a.getModelController().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f26088a.getFrsView() == null || this.f26088a.getFrsView().V() == null) {
            return;
        }
        View childAt = this.f26088a.getFrsView().a0().getChildAt(r(u, this.f26088a.getFrsView().a0()));
        if (childAt != null) {
            o(childAt, new a(this, childAt, u));
        } else {
            j(u);
            this.f26088a.getFrsView().V().notifyDataSetChanged();
        }
        if (z) {
            i();
        }
    }

    public final String u(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, customResponsedMessage)) == null) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return null;
            }
            return ((JSONObject) customResponsedMessage.getData()).optString("tid");
        }
        return (String) invokeL.objValue;
    }
}
