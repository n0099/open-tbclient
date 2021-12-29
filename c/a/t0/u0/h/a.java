package c.a.t0.u0.h;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.i0.f;
import c.a.s0.s.q.q0;
import c.a.s0.s.q.r1;
import c.a.s0.s.s.a;
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
/* loaded from: classes8.dex */
public class a implements c.a.s0.c0.b, c.a.s0.l0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.e A;
    public final EnterForumModel.f B;
    public f.g C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumFragment f24668e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.u0.m.b f24669f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumModel f24670g;

    /* renamed from: h  reason: collision with root package name */
    public RecentlyVisitedForumModel f24671h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.e4.d f24672i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.s.a f24673j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24674k;
    public boolean l;
    public boolean m;
    public String n;
    public BaseFragmentActivity o;
    public long p;
    public boolean q;
    public LikeModel r;
    public ViewEventCenter s;
    public c.a.s0.s.i0.a t;
    public int u;
    public ForumManagerDialog v;
    public boolean w;
    public View x;
    public CustomMessageListener y;
    public c.a.d.c.g.a z;

    /* renamed from: c.a.t0.u0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1443a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24675e;

        public C1443a(a aVar) {
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
            this.f24675e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f24675e.f24673j = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24676e;

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
            this.f24676e = aVar;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.f44165c.C();
                this.f24676e.f24670g.H(!StringUtils.isNull(this.f24676e.n));
                this.f24676e.f24671h.loadData();
                this.f24676e.f24670g.U(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f24677b;

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
            this.a = str;
            this.f24677b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                c.a.t0.s1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.f24677b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.m = true;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f24669f != null && this.a.f24669f.F()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CustomMessageTask.CustomRunnable<q0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24678e;

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
            this.f24678e = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<q0> run(CustomMessage<q0> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                q0 q0Var = new q0();
                ArrayList arrayList = new ArrayList();
                if (this.f24678e.f24670g != null && this.f24678e.f24670g.A() != null && this.f24678e.f24670g.A().e() != null && ListUtils.getCount(this.f24678e.f24670g.A().e().b()) > 0) {
                    Iterator<c.a.t0.u0.d.f> it = this.f24678e.f24670g.A().e().b().iterator();
                    while (it.hasNext()) {
                        c.a.t0.u0.d.f next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(c.a.d.f.m.b.g(next.p(), 0L));
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

    /* loaded from: classes8.dex */
    public class g extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof forumRecommendSocketResponseMessage;
                if ((z || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && this.a.f24670g.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    this.a.f24669f.G();
                    if (responsedMessage.hasError()) {
                        if (this.a.f24669f.S()) {
                            this.a.f24669f.x0(this.a.x);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.a.f24670g.N((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        this.a.f24670g.M((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.u0.d.f f24679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24680f;

        public h(a aVar, c.a.t0.u0.d.f fVar) {
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
            this.f24680f = aVar;
            this.f24679e = fVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.n.C()) {
                    this.f24680f.o.showToast(R.string.delete_like_fail);
                } else {
                    new n(this.f24680f, this.f24679e).execute(new c.a.t0.u0.d.f[0]);
                }
                TiebaStatic.eventStat(this.f24680f.o.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.r.getErrorCode(), this.a.r.getErrorString())) {
                    AntiHelper.u(this.a.o.getPageContext().getPageActivity(), this.a.r.getErrorString());
                } else if (obj != null) {
                    this.a.f24670g.H(!StringUtils.isNull(this.a.n));
                } else if (StringUtils.isNull(this.a.r.getErrorString())) {
                } else {
                    c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), this.a.r.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || this.a.f24668e == null) {
                return;
            }
            if (eVar.f44245c == 1) {
                this.a.f24669f.G();
            }
            if (eVar.f44244b) {
                int i2 = eVar.f44245c;
                if (i2 == 1) {
                    this.a.l = true;
                    c.a.t0.u0.d.d dVar = eVar.f44246d;
                    this.a.L(dVar);
                    if (dVar.h() > 0) {
                        c.a.s0.s.g0.b.j().v("key_LIKE_forum_sort_state", dVar.h());
                    }
                } else if (i2 == 0 && !this.a.l) {
                    c.a.t0.u0.d.d dVar2 = eVar.f44246d;
                    this.a.f24670g.S(dVar2);
                    this.a.L(dVar2);
                }
            } else {
                String str = eVar.a;
                if (str != null && !str.equals("")) {
                    this.a.o.showToast(eVar.a);
                    this.a.f24669f.b0(c.a.s0.s.g0.b.j().k("key_LIKE_forum_sort_state", EnterForumModel.SORT_TYPE_LEVEL));
                }
            }
            if (eVar.f44245c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.F()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.f44245c == 1 && this.a.p > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.a.p, this.a.f24670g.C() - this.a.p, this.a.f24670g.E(), this.a.f24670g.D(), currentTimeMillis - this.a.f24670g.B());
                this.a.p = -1L;
            }
            String string = this.a.o.getResources().getString(R.string.enter_forum_search_tip);
            c.a.t0.u0.d.d dVar3 = eVar.f44246d;
            if (dVar3 != null && dVar3.d() != null) {
                HotSearchInfoData d2 = eVar.f44246d.d();
                c.a.s0.s.g0.b.j().x("hot_search_info", OrmObject.jsonStrWithObject(d2));
                if (d2 != null && d2.w() != null) {
                    string = d2.w();
                }
            }
            this.a.S(string);
            c.a.t0.u0.d.d dVar4 = eVar.f44246d;
            if (dVar4 == null || dVar4.c() == null) {
                return;
            }
            this.a.f24669f.n0(eVar.f44246d.c());
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.u0.d.d f24681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24682f;

        public l(a aVar, c.a.t0.u0.d.d dVar) {
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
            this.f24682f = aVar;
            this.f24681e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f24682f.o.getPageContext(), new String[]{this.f24681e.f().z()});
                this.f24682f.f24673j.dismiss();
                this.f24682f.f24673j = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends BdAsyncTask<c.a.t0.u0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.t0.u0.d.f f24683b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f24684c;

        public m(a aVar, c.a.t0.u0.d.f fVar) {
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
            this.f24684c = aVar;
            this.a = null;
            this.f24683b = null;
            this.f24683b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(c.a.t0.u0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                c.a.t0.u0.d.f fVar = this.f24683b;
                if (fVar != null) {
                    try {
                        if (fVar.p() == null || fVar.w() == null) {
                            return null;
                        }
                        if (fVar.q() == 0) {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.a.addPostData("forum_id", fVar.p());
                        this.a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.a.postNetData();
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
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f24684c.T(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.f24684c.T(false);
                int q = this.f24683b.q();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f24684c.q = true;
                        if (this.f24684c.f24668e.isAdded() && this.f24684c.o != null) {
                            this.f24684c.o.showToast(this.f24684c.o.getActivity().getString(q > 0 ? R.string.enter_forum_untop_forum_succ : R.string.enter_forum_top_forum_succ));
                        }
                        this.f24684c.f24670g.H(true);
                    } else if (this.f24684c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.f24684c.o.showToast(this.a.getErrorString());
                        } else if (this.f24684c.f24668e.isAdded()) {
                            this.f24684c.o.showToast(this.f24684c.o.getActivity().getString(q > 0 ? R.string.enter_forum_untop_forum_fail : R.string.enter_forum_top_forum_fail));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends BdAsyncTask<c.a.t0.u0.d.f, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.t0.u0.d.f f24685b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f24686c;

        public n(a aVar, c.a.t0.u0.d.f fVar) {
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
            this.f24686c = aVar;
            this.a = null;
            this.f24685b = null;
            this.f24685b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(c.a.t0.u0.d.f... fVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
                c.a.t0.u0.d.f fVar = this.f24685b;
                if (fVar != null) {
                    try {
                        if (fVar.p() == null || fVar.w() == null) {
                            return null;
                        }
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.a = netWork;
                        netWork.addPostData("fid", fVar.p());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, fVar.w());
                        this.a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.a.postNetData();
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
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f24686c.T(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((n) str);
                this.f24686c.T(false);
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f24686c.q = true;
                        if (this.f24686c.f24668e.isAdded() && this.f24686c.o != null) {
                            this.f24686c.o.showToast(this.f24686c.o.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.f24686c.P(false, this.f24685b.p());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.f24685b.p()));
                        long g2 = c.a.d.f.m.b.g(this.f24685b.p(), 0L);
                        if (g2 > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(g2)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f24685b.w()));
                        }
                        this.f24686c.f24669f.h0(this.f24685b, this.f24686c.f24670g.F());
                        this.f24686c.f24670g.K(this.f24685b);
                    } else if (this.f24686c.o == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.f24686c.o.showToast(this.a.getErrorString());
                        } else if (this.f24686c.f24668e.isAdded()) {
                            this.f24686c.o.showToast(this.f24686c.o.getActivity().getString(R.string.delete_like_fail));
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
        this.f24669f = null;
        this.f24670g = null;
        this.f24673j = null;
        this.f24674k = true;
        this.l = false;
        this.p = -1L;
        this.u = 1;
        this.y = new d(this, 2921032);
        this.z = new g(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.A = new j(this);
        this.B = new k(this);
        this.C = new b(this);
        this.f24668e = enterForumFragment;
        this.o = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.s = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        c.a.t0.d1.x2.d.d();
        this.p = System.currentTimeMillis();
        this.f24674k = true;
        this.l = false;
        this.n = "";
        this.f24670g = new EnterForumModel(this.o.getPageContext());
        this.f24671h = new RecentlyVisitedForumModel();
        this.r = new LikeModel(this.o.getPageContext());
        this.f24672i = new c.a.t0.e4.d(this.o.getPageContext());
        this.r.setLoadDataCallBack(this.A);
        this.f24670g.T(this.B);
        c.a.s0.s.g0.b.j().t("enter_forum_edit_mode", false);
        c.a.t0.u0.j.a.b().c(this.f24668e.getFragmentActivity(), c.a.d.f.p.n.r(this.f24668e.getFragmentActivity()));
        D();
        C();
        N();
    }

    public final void A() {
        c.a.s0.s.s.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f24673j) == null) {
            return;
        }
        aVar.dismiss();
        this.f24673j = null;
    }

    public void B() {
        c.a.t0.u0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f24669f) == null) {
            return;
        }
        bVar.Q(this.x);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O();
            this.f24668e.registerListener(this.z);
            this.f24668e.registerListener(this.y);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.x = LayoutInflater.from(this.o.getActivity()).inflate(R.layout.enter_forum_view, (ViewGroup) null);
            c.a.t0.u0.m.b bVar = new c.a.t0.u0.m.b(this.f24668e, this.x, this.s, this.f24671h, this.f24670g);
            this.f24669f = bVar;
            bVar.p0(this.C);
            H(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = new c.a.s0.s.i0.a(this.o.getPageContext());
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !this.f24668e.isHidden() : invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f24669f == null) {
            return;
        }
        w(false);
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            c.a.t0.u0.m.b bVar = this.f24669f;
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
            c.a.t0.u0.j.a.b().a();
            c.a.t0.u0.m.b bVar = this.f24669f;
            if (bVar != null) {
                bVar.X();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f24671h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.f24670g;
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
            c.a.t0.u0.m.b bVar = this.f24669f;
            if (bVar != null && bVar.K() != null) {
                this.f24669f.K().completePullRefresh();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f24671h;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onPause();
            }
            EnterForumModel enterForumModel = this.f24670g;
            if (enterForumModel != null) {
                enterForumModel.onPause();
            }
            c.a.t0.u0.m.b bVar2 = this.f24669f;
            if (bVar2 != null) {
                bVar2.Z();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f24668e.isAdded() && this.f24668e.isPrimary()) {
                RecentlyVisitedForumModel recentlyVisitedForumModel = this.f24671h;
                if (recentlyVisitedForumModel != null) {
                    recentlyVisitedForumModel.x();
                }
            } else {
                A();
            }
            c.a.t0.u0.m.b bVar = this.f24669f;
            if (bVar != null) {
                bVar.a0();
            }
        }
    }

    public void L(c.a.t0.u0.d.d dVar) {
        c.a.t0.u0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) || (bVar = this.f24669f) == null) {
            return;
        }
        if (dVar == null) {
            bVar.x0(this.x);
            return;
        }
        c.a.t0.u0.d.g e2 = dVar.e();
        ArrayList<c.a.t0.u0.d.f> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        u(arrayList, dVar.g());
        V(dVar);
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(c.a.s0.s.g0.b.j().p("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.w() != null) {
            S(hotSearchInfoData.w());
        }
        this.f24669f.c0();
        this.f24669f.b0(dVar.h());
    }

    public void M(boolean z) {
        c.a.t0.u0.m.b bVar;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (bVar = this.f24669f) == null || (enterForumFragment = this.f24668e) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.f24668e.isResumed()) {
                this.f24669f.y0();
            } else {
                this.f24669f.G();
            }
        } else {
            bVar.G();
        }
        this.f24669f.o0(z);
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
            this.f24668e.registerListener(new e(this, 2007010));
        }
    }

    public final void P(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048591, this, z, str) == null) {
            new c(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void Q(c.a.t0.u0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f24669f.k0(cVar);
            this.f24668e.setAdState(cVar);
        }
    }

    public void R(BdUniqueId bdUniqueId) {
        c.a.t0.u0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) || (bVar = this.f24669f) == null) {
            return;
        }
        bVar.r0(bdUniqueId);
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || this.f24668e.getTabViewController() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f24668e.getTabViewController().O(str.trim());
        } else {
            this.f24668e.getTabViewController().O(this.o.getActivity().getString(R.string.enter_forum_search_tip));
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

    public void U(c.a.t0.u0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) || fVar == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.o.getPageContext().getPageActivity());
        aVar.setMessage(String.format(this.o.getPageContext().getString(R.string.attention_cancel_dialog_message), fVar.w()));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.cancel_attention), new h(this, fVar));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.cancel), new i(this));
        aVar.setButtonTextColor(R.color.CAM_X0105);
        aVar.create(this.o.getPageContext());
        aVar.show();
    }

    public final void V(c.a.t0.u0.d.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) && dVar != null && dVar.f() != null && this.f24668e.isPrimary() && this.f24673j == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.o.getActivity());
            if (frsPrivateCommonDialogView.configPrivateDialog(dVar.f())) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.o.getActivity());
                this.f24673j = aVar;
                aVar.setContentViewSize(2);
                this.f24673j.setContentView(frsPrivateCommonDialogView);
                this.f24673j.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new l(this, dVar));
                this.f24673j.setCloseButton(new C1443a(this));
                this.f24673j.create(this.o.getPageContext()).show();
            }
        }
    }

    @Override // c.a.s0.l0.c.a
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.s0.c0.b
    public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048599, this, aVar, str, z) != null) || aVar == null) {
        }
    }

    @Override // c.a.s0.l0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.l0.c.a
    public boolean onEventDispatch(c.a.s0.l0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bVar)) == null) {
            int b2 = bVar.b();
            c.a.s0.l0.b.a a = bVar.a();
            switch (b2) {
                case 1:
                    if (this.u == 2 || !(a instanceof c.a.t0.u0.d.f)) {
                        return false;
                    }
                    c.a.t0.u0.d.f fVar = (c.a.t0.u0.d.f) a;
                    String w = fVar.w();
                    if (c.a.d.f.p.m.isForumName(w)) {
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
                        TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.f24670g.A().h() != 1 ? 1 : 2).param("fid", fVar.p()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.u == 2) {
                        return false;
                    }
                    if (c.a.s0.s.g0.b.j().g("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    c.a.s0.s.g0.b.j().t("enter_forum_edit_mode", true);
                    if (this.f24668e.getView() != null && this.f24668e.getView().getParent() != null) {
                        this.f24668e.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    c.a.s0.s.g0.b.j().t("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (a instanceof c.a.t0.u0.d.f) {
                        U((c.a.t0.u0.d.f) a);
                        return true;
                    }
                    return false;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.o.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.o.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.o.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.o.finish();
                    return true;
                case 9:
                    c.a.t0.u0.m.b bVar2 = this.f24669f;
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
                    if (a instanceof c.a.t0.u0.d.f) {
                        this.v.setData((c.a.t0.u0.d.f) a);
                        this.v.showDialog();
                    }
                    return true;
                case 13:
                    if (a instanceof c.a.t0.u0.d.f) {
                        c.a.t0.u0.d.f fVar2 = (c.a.t0.u0.d.f) a;
                        new m(this, fVar2).execute(new c.a.t0.u0.d.f[0]);
                        TiebaStatic.log(new StatisticItem("c13370").param("obj_type", fVar2.q() <= 0 ? 1 : 2).param("fid", fVar2.p()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        return true;
                    }
                    return false;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.f24672i.d() && (a instanceof c.a.t0.u0.d.f)) {
                        UrlManager.getInstance().dealOneLink(this.o.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((c.a.t0.u0.d.f) a).p() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    Q((c.a.t0.u0.d.c) bVar.d());
                    break;
                case 17:
                    Q((c.a.t0.u0.d.c) bVar.d());
                    break;
                case 18:
                    Q((c.a.t0.u0.d.c) bVar.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (enterForumModel = this.f24670g) == null) {
            return;
        }
        enterForumModel.cancelLoadData();
    }

    public final void u(List<c.a.t0.u0.d.f> list, r1 r1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, list, r1Var) == null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.f24669f.f0(this.f24670g.V(list, c.a.s0.e1.k.a()), r1Var, this.f24670g.F());
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.f24669f == null || this.f24668e == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }

    public void w(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.w || this.f24670g == null || this.f24669f == null) {
            return;
        }
        String str = this.n;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.n = currentAccount;
        if (this.f24674k) {
            this.f24674k = false;
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
            EnterForumModel enterForumModel2 = this.f24670g;
            if (enterForumModel2 != null && enterForumModel2.A() != null && this.f24670g.A().e() != null) {
                Iterator<c.a.t0.u0.d.f> it = this.f24670g.A().e().b().iterator();
                while (it.hasNext()) {
                    c.a.t0.u0.d.f next = it.next();
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
                c.a.t0.w3.p0.a.g(currentAccount2);
            }
            this.f24669f.V(this.f24670g.F());
        }
        if (z3 || z2) {
            t();
            if (z2) {
                EnterForumModel enterForumModel3 = this.f24670g;
                if (enterForumModel3 != null) {
                    enterForumModel3.G(!StringUtils.isNull(this.n));
                }
                this.f24671h.loadData();
            } else if (!z3 || (enterForumModel = this.f24670g) == null) {
            } else {
                enterForumModel.G(!StringUtils.isNull(this.n));
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.f24669f == null) {
            return;
        }
        w(true);
    }

    public c.a.t0.u0.m.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f24669f : (c.a.t0.u0.m.b) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.x : (View) invokeV.objValue;
    }
}
