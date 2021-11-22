package b.a.r0.o0.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.q0;
import b.a.q0.s.q.r1;
import b.a.q0.s.s.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.ForumManagerDialog;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements b.a.q0.c0.b, b.a.q0.k0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.e.a.e A;
    public final EnterForumModel.f B;
    public f.g C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumFragment f23101e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.o0.m.b f23102f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumModel f23103g;

    /* renamed from: h  reason: collision with root package name */
    public RecentlyVisitedForumModel f23104h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.u3.d f23105i;
    public b.a.q0.s.s.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public BaseFragmentActivity o;
    public long p;
    public boolean q;
    public LikeModel r;
    public ViewEventCenter s;
    public b.a.q0.s.g0.a t;
    public int u;
    public ForumManagerDialog v;
    public boolean w;
    public View x;
    public CustomMessageListener y;
    public b.a.e.c.g.a z;

    /* renamed from: b.a.r0.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1126a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23106e;

        public C1126a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23106e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f23106e.j = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23107e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23107e = aVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.f48473c.C();
                this.f23107e.f23103g.H(!StringUtils.isNull(this.f23107e.n));
                this.f23107e.f23104h.loadData();
                this.f23107e.f23103g.U(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f23108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f23109b;

        public c(a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23108a = str;
            this.f23109b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.f23108a)) {
                    return null;
                }
                b.a.r0.l1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f23108a), this.f23109b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23110a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f23110a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f23110a.m = true;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23111a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f23111a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f23111a.f23102f != null && this.f23111a.f23102f.F()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CustomMessageTask.CustomRunnable<q0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23112e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23112e = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<q0> run(CustomMessage<q0> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                q0 q0Var = new q0();
                ArrayList arrayList = new ArrayList();
                if (this.f23112e.f23103g != null && this.f23112e.f23103g.A() != null && this.f23112e.f23103g.A().e() != null && ListUtils.getCount(this.f23112e.f23103g.A().e().b()) > 0) {
                    Iterator<b.a.r0.o0.d.f> it = this.f23112e.f23103g.A().e().b().iterator();
                    while (it.hasNext()) {
                        b.a.r0.o0.d.f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(b.a.e.f.m.b.g(next.p(), 0L));
                            hotTopicBussinessData.setForumName(next.w());
                            hotTopicBussinessData.setForumAvatar(next.k());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    q0Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, q0Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23113a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f23113a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
                if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && this.f23113a.f23103g.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    this.f23113a.f23102f.G();
                    if (responsedMessage.hasError()) {
                        if (this.f23113a.f23102f.S()) {
                            this.f23113a.f23102f.x0(this.f23113a.x);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.f23113a.f23103g.N((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        this.f23113a.f23103g.M((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.o0.d.f f23114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23115f;

        public h(a aVar, b.a.r0.o0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23115f = aVar;
            this.f23114e = fVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!b.a.e.f.p.l.D()) {
                    this.f23115f.o.showToast(R.string.delete_like_fail);
                } else {
                    new n(this.f23115f, this.f23114e).execute(new b.a.r0.o0.d.f[0]);
                }
                TiebaStatic.eventStat(this.f23115f.o.getPageContext().getPageActivity(), "recom_flist_unlike", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23116a;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23116a = aVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f23116a.r.getErrorCode(), this.f23116a.r.getErrorString())) {
                    AntiHelper.u(this.f23116a.o.getPageContext().getPageActivity(), this.f23116a.r.getErrorString());
                } else if (obj != null) {
                    this.f23116a.f23103g.H(!StringUtils.isNull(this.f23116a.n));
                } else if (StringUtils.isNull(this.f23116a.r.getErrorString())) {
                } else {
                    b.a.e.f.p.l.M(TbadkCoreApplication.getInst(), this.f23116a.r.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23117a;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23117a = aVar;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || this.f23117a.f23101e == null) {
                return;
            }
            if (eVar.f48567c == 1) {
                this.f23117a.f23102f.G();
            }
            if (eVar.f48566b) {
                int i2 = eVar.f48567c;
                if (i2 == 1) {
                    this.f23117a.l = true;
                    b.a.r0.o0.d.d dVar = eVar.f48568d;
                    this.f23117a.L(dVar);
                    if (dVar.h() > 0) {
                        b.a.q0.s.e0.b.j().v("key_LIKE_forum_sort_state", dVar.h());
                    }
                } else if (i2 == 0 && !this.f23117a.l) {
                    b.a.r0.o0.d.d dVar2 = eVar.f48568d;
                    this.f23117a.f23103g.S(dVar2);
                    this.f23117a.L(dVar2);
                }
            } else {
                String str = eVar.f48565a;
                if (str != null && !str.equals("")) {
                    this.f23117a.o.showToast(eVar.f48565a);
                    this.f23117a.f23102f.b0(b.a.q0.s.e0.b.j().k("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
            }
            if (eVar.f48567c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.f23117a.F()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.f48567c == 1 && this.f23117a.p > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.f23117a.p, this.f23117a.f23103g.C() - this.f23117a.p, this.f23117a.f23103g.E(), this.f23117a.f23103g.D(), currentTimeMillis - this.f23117a.f23103g.B());
                this.f23117a.p = -1L;
            }
            String string = this.f23117a.o.getResources().getString(R.string.enter_forum_search_tip);
            b.a.r0.o0.d.d dVar3 = eVar.f48568d;
            if (dVar3 != null && dVar3.d() != null) {
                HotSearchInfoData d2 = eVar.f48568d.d();
                b.a.q0.s.e0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(d2));
                if (d2 != null && d2.w() != null) {
                    string = d2.w();
                }
            }
            this.f23117a.S(string);
            b.a.r0.o0.d.d dVar4 = eVar.f48568d;
            if (dVar4 == null || dVar4.c() == null) {
                return;
            }
            this.f23117a.f23102f.n0(eVar.f48568d.c());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.o0.d.d f23118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23119f;

        public l(a aVar, b.a.r0.o0.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23119f = aVar;
            this.f23118e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f23119f.o.getPageContext(), new String[]{this.f23118e.f().z()});
                this.f23119f.j.dismiss();
                this.f23119f.j = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask<b.a.r0.o0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f23120a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.o0.d.f f23121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f23122c;

        public m(a aVar, b.a.r0.o0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23122c = aVar;
            this.f23120a = null;
            this.f23121b = null;
            this.f23121b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(b.a.r0.o0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                b.a.r0.o0.d.f fVar = this.f23121b;
                if (fVar != null) {
                    try {
                        if (fVar.p() == null || fVar.w() == null) {
                            return null;
                        }
                        if (fVar.q() == 0) {
                            this.f23120a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.f23120a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.f23120a.addPostData("forum_id", fVar.p());
                        this.f23120a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.f23120a.postNetData();
                        return null;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.f23120a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f23120a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f23122c.T(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.f23122c.T(false);
                int q = this.f23121b.q();
                NetWork netWork = this.f23120a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f23122c.q = true;
                        if (this.f23122c.f23101e.isAdded() && this.f23122c.o != null) {
                            this.f23122c.o.showToast(this.f23122c.o.getActivity().getString(q > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                        }
                        this.f23122c.f23103g.H(true);
                    } else if (this.f23122c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.f23120a.getErrorString())) {
                            this.f23122c.o.showToast(this.f23120a.getErrorString());
                        } else if (this.f23122c.f23101e.isAdded()) {
                            this.f23122c.o.showToast(this.f23122c.o.getActivity().getString(q > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends BdAsyncTask<b.a.r0.o0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f23123a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.o0.d.f f23124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f23125c;

        public n(a aVar, b.a.r0.o0.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23125c = aVar;
            this.f23123a = null;
            this.f23124b = null;
            this.f23124b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(b.a.r0.o0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                b.a.r0.o0.d.f fVar = this.f23124b;
                if (fVar != null) {
                    try {
                        if (fVar.p() == null || fVar.w() == null) {
                            return null;
                        }
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.f23123a = netWork;
                        netWork.addPostData("fid", fVar.p());
                        this.f23123a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, fVar.w());
                        this.f23123a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.f23123a.postNetData();
                        return null;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.f23123a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f23123a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f23125c.T(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((n) str);
                this.f23125c.T(false);
                NetWork netWork = this.f23123a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f23125c.q = true;
                        if (this.f23125c.f23101e.isAdded() && this.f23125c.o != null) {
                            this.f23125c.o.showToast(this.f23125c.o.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.f23125c.P(false, this.f23124b.p());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.f23124b.p()));
                        long g2 = b.a.e.f.m.b.g(this.f23124b.p(), 0L);
                        if (g2 > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(g2)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f23124b.w()));
                        }
                        this.f23125c.f23102f.h0(this.f23124b, this.f23125c.f23103g.F());
                        this.f23125c.f23103g.K(this.f23124b);
                    } else if (this.f23125c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.f23123a.getErrorString())) {
                            this.f23125c.o.showToast(this.f23123a.getErrorString());
                        } else if (this.f23125c.f23101e.isAdded()) {
                            this.f23125c.o.showToast(this.f23125c.o.getActivity().getString(R.string.delete_like_fail));
                        }
                    }
                }
            }
        }
    }

    public a(EnterForumFragment enterForumFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23102f = null;
        this.f23103g = null;
        this.j = null;
        this.k = true;
        this.l = false;
        this.p = -1L;
        this.u = 1;
        this.y = new d(this, 2921032);
        this.z = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.A = new j(this);
        this.B = new k(this);
        this.C = new b(this);
        this.f23101e = enterForumFragment;
        this.o = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.s = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        b.a.r0.x0.x2.d.d();
        this.p = System.currentTimeMillis();
        this.k = true;
        this.l = false;
        this.n = "";
        this.f23103g = new EnterForumModel(this.o.getPageContext());
        this.f23104h = new RecentlyVisitedForumModel();
        this.r = new LikeModel(this.o.getPageContext());
        this.f23105i = new b.a.r0.u3.d(this.o.getPageContext());
        this.r.setLoadDataCallBack(this.A);
        this.f23103g.T(this.B);
        b.a.q0.s.e0.b.j().t("enter_forum_edit_mode", false);
        b.a.r0.o0.j.a.b().c(this.f23101e.getFragmentActivity(), b.a.e.f.p.l.r(this.f23101e.getFragmentActivity()));
        D();
        C();
        N();
    }

    public final void A() {
        b.a.q0.s.s.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.dismiss();
        this.j = null;
    }

    public void B() {
        b.a.r0.o0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f23102f) == null) {
            return;
        }
        bVar.Q(this.x);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O();
            this.f23101e.registerListener(this.z);
            this.f23101e.registerListener(this.y);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.x = LayoutInflater.from(this.o.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
            b.a.r0.o0.m.b bVar = new b.a.r0.o0.m.b(this.f23101e, this.x, this.s, this.f23104h, this.f23103g);
            this.f23102f = bVar;
            bVar.p0(this.C);
            H(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = new b.a.q0.s.g0.a(this.o.getPageContext());
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !this.f23101e.isHidden() : invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f23102f == null) {
            return;
        }
        w(false);
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            b.a.r0.o0.m.b bVar = this.f23102f;
            if (bVar != null) {
                bVar.W(i2);
            }
            ForumManagerDialog forumManagerDialog = this.v;
            if (forumManagerDialog != null) {
                forumManagerDialog.onChangeSkinType();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t();
            b.a.r0.o0.j.a.b().a();
            b.a.r0.o0.m.b bVar = this.f23102f;
            if (bVar != null) {
                bVar.X();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f23104h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.f23103g;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.s;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.r0.o0.m.b bVar = this.f23102f;
            if (bVar != null && bVar.K() != null) {
                this.f23102f.K().completePullRefresh();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f23104h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onPause();
            }
            EnterForumModel enterForumModel = this.f23103g;
            if (enterForumModel != null) {
                enterForumModel.onPause();
            }
            b.a.r0.o0.m.b bVar2 = this.f23102f;
            if (bVar2 != null) {
                bVar2.Z();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f23101e.isAdded() && this.f23101e.isPrimary()) {
                RecentlyVisitedForumModel recentlyVisitedForumModel = this.f23104h;
                if (recentlyVisitedForumModel != null) {
                    recentlyVisitedForumModel.x();
                }
            } else {
                A();
            }
            b.a.r0.o0.m.b bVar = this.f23102f;
            if (bVar != null) {
                bVar.a0();
            }
        }
    }

    public void L(b.a.r0.o0.d.d dVar) {
        b.a.r0.o0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) || (bVar = this.f23102f) == null) {
            return;
        }
        if (dVar == null) {
            bVar.x0(this.x);
            return;
        }
        b.a.r0.o0.d.g e2 = dVar.e();
        ArrayList<b.a.r0.o0.d.f> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        u(arrayList, dVar.g());
        V(dVar);
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(b.a.q0.s.e0.b.j().p("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.w() != null) {
            S(hotSearchInfoData.w());
        }
        this.f23102f.c0();
        this.f23102f.b0(dVar.h());
    }

    public void M(boolean z) {
        b.a.r0.o0.m.b bVar;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (bVar = this.f23102f) == null || (enterForumFragment = this.f23101e) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.f23101e.isResumed()) {
                this.f23102f.y0();
            } else {
                this.f23102f.G();
            }
        } else {
            bVar.G();
        }
        this.f23102f.o0(z);
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f23101e.registerListener(new e(this, 2007010));
        }
    }

    public final void P(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048591, this, z, str) == null) {
            new c(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void Q(b.a.r0.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f23102f.k0(cVar);
            this.f23101e.setAdState(cVar);
        }
    }

    public void R(BdUniqueId bdUniqueId) {
        b.a.r0.o0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) || (bVar = this.f23102f) == null) {
            return;
        }
        bVar.r0(bdUniqueId);
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || this.f23101e.getTabViewController() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f23101e.getTabViewController().V(str.trim());
        } else {
            this.f23101e.getTabViewController().V(this.o.getActivity().getString(R.string.enter_forum_search_tip));
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (this.t == null) {
                E();
            }
            this.t.h(z);
        }
    }

    public void U(b.a.r0.o0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) || fVar == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.o.getPageContext().getPageActivity());
        aVar.setMessage(String.format(this.o.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.w()));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new h(this, fVar));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new i(this));
        aVar.setButtonTextColor(R.color.CAM_X0105);
        aVar.create(this.o.getPageContext());
        aVar.show();
    }

    public final void V(b.a.r0.o0.d.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) && dVar != null && dVar.f() != null && this.f23101e.isPrimary() && this.j == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.o.getActivity());
            if (frsPrivateCommonDialogView.configPrivateDialog(dVar.f())) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.o.getActivity());
                this.j = aVar;
                aVar.setContentViewSize(2);
                this.j.setContentView(frsPrivateCommonDialogView);
                this.j.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new l(this, dVar));
                this.j.setCloseButton(new C1126a(this));
                this.j.create(this.o.getPageContext()).show();
            }
        }
    }

    @Override // b.a.q0.k0.c.a
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // b.a.q0.c0.b
    public void imageLoaded(b.a.e.m.d.a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048599, this, aVar, str, z) != null) || aVar == null) {
        }
    }

    @Override // b.a.q0.k0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.k0.c.a
    public boolean onEventDispatch(b.a.q0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bVar)) == null) {
            int b2 = bVar.b();
            b.a.q0.k0.b.a a2 = bVar.a();
            switch (b2) {
                case 1:
                    if (this.u == 2 || !(a2 instanceof b.a.r0.o0.d.f)) {
                        return false;
                    }
                    b.a.r0.o0.d.f fVar = (b.a.r0.o0.d.f) a2;
                    String w = fVar.w();
                    if (b.a.e.f.p.k.isForumName(w)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageContext().getPageActivity()).createNormalCfg(w, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object c2 = bVar.c();
                        if (c2 instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (fVar.x() && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 2);
                                Bundle bundle = (Bundle) c2;
                                intent.putExtra("info_forum_image_rect", bundle.getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", fVar.k());
                                intent.putExtra("info_forum_name_rect", bundle.getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", w);
                                intent.putExtra("info_forum_head_background_color", fVar.z());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (fVar.B().night != null && fVar.B().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", fVar.B().night.pattern_image);
                                    }
                                } else if (fVar.B().day != null && fVar.B().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", fVar.B().day.pattern_image);
                                }
                            } else {
                                intent.putExtra("transition_type", 0);
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, fVar.o());
                            fVar.K(0L);
                        }
                        this.o.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(w)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.f23103g.A().h() != 1 ? 1 : 2).param("fid", fVar.p()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.u == 2) {
                        return false;
                    }
                    if (b.a.q0.s.e0.b.j().g("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    b.a.q0.s.e0.b.j().t("enter_forum_edit_mode", true);
                    if (this.f23101e.getView() != null && this.f23101e.getView().getParent() != null) {
                        this.f23101e.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    b.a.q0.s.e0.b.j().t("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (a2 instanceof b.a.r0.o0.d.f) {
                        U((b.a.r0.o0.d.f) a2);
                        return true;
                    }
                    return false;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.o.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_6", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.o.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_8", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.o.finish();
                    return true;
                case 9:
                    b.a.r0.o0.m.b bVar2 = this.f23102f;
                    if (bVar2 != null) {
                        bVar2.y0();
                    }
                    return true;
                case 10:
                    this.u = 2;
                    return true;
                case 11:
                    this.u = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.u == 2) {
                        return true;
                    }
                    if (this.v == null) {
                        this.v = new ForumManagerDialog(this.o.getPageContext(), this.s);
                    }
                    if (a2 instanceof b.a.r0.o0.d.f) {
                        this.v.setData((b.a.r0.o0.d.f) a2);
                        this.v.showDialog();
                    }
                    return true;
                case 13:
                    if (a2 instanceof b.a.r0.o0.d.f) {
                        b.a.r0.o0.d.f fVar2 = (b.a.r0.o0.d.f) a2;
                        new m(this, fVar2).execute(new b.a.r0.o0.d.f[0]);
                        TiebaStatic.log(new StatisticItem("c13370").param("obj_type", fVar2.q() <= 0 ? 1 : 2).param("fid", fVar2.p()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        return true;
                    }
                    return false;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.f23105i.d() && (a2 instanceof b.a.r0.o0.d.f)) {
                        UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((b.a.r0.o0.d.f) a2).p() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    Q((b.a.r0.o0.d.c) bVar.d());
                    break;
                case 17:
                    Q((b.a.r0.o0.d.c) bVar.d());
                    break;
                case 18:
                    Q((b.a.r0.o0.d.c) bVar.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (enterForumModel = this.f23103g) == null) {
            return;
        }
        enterForumModel.cancelLoadData();
    }

    public final void u(List<b.a.r0.o0.d.f> list, r1 r1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, list, r1Var) == null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.f23102f.f0(this.f23103g.V(list, b.a.q0.c1.i.a()), r1Var, this.f23103g.F());
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.f23102f == null || this.f23101e == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }

    public void w(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.w || this.f23103g == null || this.f23102f == null) {
            return;
        }
        String str = this.n;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.n = currentAccount;
        if (this.k) {
            this.k = false;
            z2 = false;
            z3 = true;
        } else {
            z2 = (currentAccount == null || currentAccount.equals(str)) ? false : true;
            z3 = false;
        }
        if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
            z2 = true;
        }
        if (z) {
            z2 = true;
        }
        if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
            EnterForumModel enterForumModel2 = this.f23103g;
            if (enterForumModel2 != null && enterForumModel2.A() != null && this.f23103g.A().e() != null) {
                Iterator<b.a.r0.o0.d.f> it = this.f23103g.A().e().b().iterator();
                while (it.hasNext()) {
                    b.a.r0.o0.d.f next = it.next();
                    if (TbadkCoreApplication.getInst().hasSignedForum(next.w())) {
                        next.L(1);
                        int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.w());
                        if (signLevelUpValue > 0) {
                            next.M(signLevelUpValue);
                        }
                    }
                }
            }
            TbadkCoreApplication.getInst().clearSignedForum();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                b.a.r0.m3.p0.a.g(currentAccount2);
            }
            this.f23102f.V(this.f23103g.F());
        }
        if (z3 || z2) {
            t();
            if (z2) {
                EnterForumModel enterForumModel3 = this.f23103g;
                if (enterForumModel3 != null) {
                    enterForumModel3.G(!StringUtils.isNull(this.n));
                }
                this.f23104h.loadData();
            } else if (!z3 || (enterForumModel = this.f23103g) == null) {
            } else {
                enterForumModel.G(!StringUtils.isNull(this.n));
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.f23102f == null) {
            return;
        }
        w(true);
    }

    public b.a.r0.o0.m.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f23102f : (b.a.r0.o0.m.b) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.x : (View) invokeV.objValue;
    }
}
