package c.a.r0.x0.f2;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.x0.u;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f26838a;

    /* renamed from: b  reason: collision with root package name */
    public d2 f26839b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f26840c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f26841d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f26842e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f26843f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f26844g;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f26845a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26846b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f26847c;

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
            this.f26847c = eVar;
            this.f26845a = view;
            this.f26846b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f26847c.f26838a == null || this.f26847c.f26838a.getFrsView() == null || this.f26847c.f26838a.getFrsView().b0() == null || this.f26847c.f26838a.getFrsView().W() == null) {
                return;
            }
            this.f26847c.f26838a.getFrsView().b0().removeView(this.f26845a);
            this.f26847c.j(this.f26846b);
            this.f26847c.f26838a.getFrsView().W().notifyDataSetChanged();
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

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26848a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26849b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f26850c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26851d;

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
            this.f26851d = eVar;
            this.f26848a = str;
            this.f26849b = str2;
            this.f26850c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f26851d.k(this.f26848a, this.f26849b);
                this.f26850c.setVisibility(8);
                if (this.f26851d.f26838a.getFrsView() == null || this.f26851d.f26838a.getFrsView().W() == null) {
                    return;
                }
                this.f26851d.f26838a.getFrsView().W().notifyDataSetChanged();
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

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26852a;

        /* renamed from: b  reason: collision with root package name */
        public String f26853b;

        /* renamed from: c  reason: collision with root package name */
        public String f26854c;

        /* renamed from: d  reason: collision with root package name */
        public String f26855d;

        /* renamed from: e  reason: collision with root package name */
        public String f26856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26857f;

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
            this.f26857f = eVar;
            this.f26852a = "";
            this.f26853b = "";
            this.f26854c = "";
            this.f26855d = "";
            this.f26856e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f26852a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f26853b = jSONObject.optString("tid", "");
                    this.f26854c = jSONObject.optString("fid", "");
                    this.f26855d = jSONObject.optString("liveId", "");
                    this.f26856e = jSONObject.optString("sid", "");
                } else if ((this.f26852a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f26852a)) && ((this.f26855d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f26855d)) && (this.f26856e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f26856e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f26853b);
                        jSONObject.put("fid", this.f26854c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f26857f.t(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26858a;

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
            this.f26858a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26858a.n(customResponsedMessage);
            }
        }
    }

    /* renamed from: c.a.r0.x0.f2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1261e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26859a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1261e(e eVar, int i2) {
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
            this.f26859a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26859a.t(customResponsedMessage, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26860a;

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
            this.f26860a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f26860a.j(this.f26860a.u(customResponsedMessage));
                this.f26860a.f26838a.getFrsView().W().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f26861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f26862f;

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
            this.f26861e = i2;
            this.f26862f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                int i2 = this.f26861e;
                this.f26862f.getLayoutParams().height = i2 - ((int) (i2 * f2));
                this.f26862f.requestLayout();
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

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f26863a;

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
            this.f26863a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f26863a.f26838a == null || this.f26863a.f26838a.getModelController() == null || this.f26863a.f26838a.getModelController().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f26863a.m(str, this.f26863a.f26838a.getModelController().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = this.f26863a;
            eVar.l(str, eVar.f26838a.getFrsView().b0().getData());
            e eVar2 = this.f26863a;
            eVar2.l(str, eVar2.f26838a.getFrsLoadMoreModelController().f().z());
            this.f26863a.f26838a.getModelController().I(str);
            if (this.f26863a.f26838a.getFrsView() == null || this.f26863a.f26838a.getFrsView().W() == null) {
                return;
            }
            this.f26863a.f26838a.getFrsView().W().notifyDataSetChanged();
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
        this.f26840c = new c(this, 2921547);
        this.f26841d = new d(this, 2921324);
        this.f26842e = new C1261e(this, 2016488);
        this.f26843f = new f(this, 2016553);
        this.f26844g = new h(this, 2016331);
        this.f26838a = lVar;
        this.f26842e.setTag(bdUniqueId);
        this.f26844g.setTag(bdUniqueId);
        this.f26841d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26841d);
        MessageManager.getInstance().registerListener(this.f26842e);
        MessageManager.getInstance().registerListener(this.f26844g);
        this.f26843f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26843f);
        this.f26840c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26840c);
    }

    public final void i() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (d2Var = this.f26839b) != null && d2Var.W1) {
            TbPageTag tbPageTag = null;
            l lVar = this.f26838a;
            if (lVar != null && lVar.getFrsView() != null) {
                tbPageTag = c.a.q0.n0.c.k(this.f26838a.getFrsView().V());
            }
            c.a.r0.x0.k2.a.k(this.f26839b, tbPageTag);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<c.a.e.l.e.n> threadList = this.f26838a.getModelController().d0().getThreadList();
        p(str, threadList);
        p(str, this.f26838a.getFrsView().b0().getData());
        p(str, this.f26838a.getFrsLoadMoreModelController().e());
        this.f26838a.getModelController().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f26838a.loadMore();
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<c.a.e.l.e.n> threadList = this.f26838a.getModelController().d0().getThreadList();
            q(str, str2, threadList);
            q(str, str2, this.f26838a.getFrsView().b0().getData());
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                this.f26838a.getModelController().J(str2);
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                this.f26838a.getModelController().K(str2);
            }
            if (threadList == null || threadList.size() >= 5) {
                return;
            }
            this.f26838a.loadMore();
        }
    }

    public final void l(String str, List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = list.iterator();
        while (it.hasNext()) {
            c.a.e.l.e.n next = it.next();
            if (next instanceof c.a.r0.g.c) {
                Object b2 = ((c.a.r0.g.c) next).b();
                if ((b2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) b2).X3)) {
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f26838a) == null || lVar.getModelController() == null || this.f26838a.getModelController().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f26838a.getFrsView() == null || this.f26838a.getFrsView().W() == null) {
            return;
        }
        View childAt = this.f26838a.getFrsView().b0().getChildAt(s(optString, optString2, this.f26838a.getFrsView().b0()));
        if (childAt != null) {
            o(childAt, new b(this, optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f26838a.getFrsView().W().notifyDataSetChanged();
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

    public final void p(String str, List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c.a.e.l.e.n nVar : list) {
            if (nVar instanceof c2) {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.s1() != null && d2Var.s1().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        list.removeAll(arrayList);
        c.a.e.l.e.n nVar2 = (c.a.e.l.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof u) {
            list.remove(nVar2);
        }
    }

    public final void q(String str, String str2, List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c.a.e.l.e.n nVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (nVar instanceof c.a.r0.k3.h) {
                    arrayList.add((c.a.r0.k3.h) nVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof c2)) {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.s1() != null && d2Var.s1().equals(str2)) {
                    arrayList.add(d2Var);
                }
            }
        }
        list.removeAll(arrayList);
        c.a.e.l.e.n nVar2 = (c.a.e.l.e.n) ListUtils.getItem(list, 0);
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
                c.a.e.l.e.n item = bdTypeRecyclerView.getItem(i3);
                if (item instanceof c2) {
                    d2 d2Var = ((c2) item).w;
                    if (d2Var.s1() != null && d2Var.s1().equals(str)) {
                        this.f26839b = d2Var;
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
                    if (bdTypeRecyclerView.getItem(i3) instanceof c.a.r0.k3.h) {
                        i2 = i3;
                    }
                    i3++;
                }
            } else {
                if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                    i2 = 0;
                    while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                        c.a.e.l.e.n item = bdTypeRecyclerView.getItem(i3);
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
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, customResponsedMessage, z) == null) || (lVar = this.f26838a) == null || lVar.getModelController() == null || this.f26838a.getModelController().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f26838a.getFrsView() == null || this.f26838a.getFrsView().W() == null) {
            return;
        }
        View childAt = this.f26838a.getFrsView().b0().getChildAt(r(u, this.f26838a.getFrsView().b0()));
        if (childAt != null) {
            o(childAt, new a(this, childAt, u));
        } else {
            j(u);
            this.f26838a.getFrsView().W().notifyDataSetChanged();
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
