package c.a.p0.w0.i;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l0.f;
import c.a.o0.r.r.o1;
import c.a.o0.r.r.p0;
import c.a.o0.r.t.a;
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
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements c.a.o0.b0.b, c.a.o0.k0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EnterForumModel.f A;
    public f.g B;
    public EnterForumFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w0.o.b f19390b;

    /* renamed from: c  reason: collision with root package name */
    public EnterForumModel f19391c;

    /* renamed from: d  reason: collision with root package name */
    public RecentlyVisitedForumModel f19392d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.h4.d f19393e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.r.t.a f19394f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19395g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19396h;
    public boolean i;
    public String j;
    public BaseFragmentActivity k;
    public long l;
    public boolean m;
    public LikeModel n;
    public ViewEventCenter o;
    public c.a.o0.r.l0.a p;
    public int q;
    public c.a.p0.w0.o.f r;
    public boolean s;
    public View t;
    public final c.a.p0.w0.l.d.b u;
    public boolean v;
    public CustomMessageListener w;
    public c.a.d.c.g.a x;
    public c.a.d.c.g.a y;
    public c.a.d.a.e z;

    /* renamed from: c.a.p0.w0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1465a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w0.e.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19397b;

        public View$OnClickListenerC1465a(a aVar, c.a.p0.w0.e.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19397b = aVar;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f19397b.k.getPageContext(), new String[]{this.a.f().B()});
                this.f19397b.f19394f.dismiss();
                this.f19397b.f19394f = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.a.f19394f = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.f31844e.E();
                this.a.f19391c.J(!StringUtils.isNull(this.a.j));
                this.a.f19392d.loadData();
                this.a.f19391c.Y(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                this.a.u.h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f19398b;

        public d(a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f19398b = z;
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
                c.a.p0.u1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.f19398b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.i = true;
        }
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.f19390b != null && this.a.f19390b.L()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements CustomMessageTask.CustomRunnable<p0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<p0> run(CustomMessage<p0> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                p0 p0Var = new p0();
                ArrayList arrayList = new ArrayList();
                if (this.a.f19391c != null && this.a.f19391c.C() != null && this.a.f19391c.C().e() != null && ListUtils.getCount(this.a.f19391c.C().e().b()) > 0) {
                    Iterator<c.a.p0.w0.e.h> it = this.a.f19391c.C().e().b().iterator();
                    while (it.hasNext()) {
                        c.a.p0.w0.e.h next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(c.a.d.f.m.b.g(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.r());
                            hotTopicBussinessData.setForumAvatar(next.i());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    p0Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, p0Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class h extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((z || (responsedMessage instanceof ForumGuideHttpResponseMessage)) && this.a.f19391c.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    this.a.f19390b.M();
                    this.a.f19390b.z = true;
                    if (responsedMessage.hasError()) {
                        if (this.a.v || responsedMessage.getError() != -100000303) {
                            if (this.a.f19390b.Z()) {
                                this.a.f19390b.F0(this.a.t);
                                return;
                            }
                            return;
                        } else if (responsedMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                            this.a.f19391c.K(true, ((ForumGuideRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getSortType().intValue());
                            this.a.v = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        this.a.f19391c.Q((ForumGuideSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                        this.a.f19391c.P((ForumGuideHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(a aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (((responsedMessage instanceof SetLikeForumSocketResponseMessage) || (responsedMessage instanceof SetLikeForumHttpResponseMessage)) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null) {
                    if (responsedMessage.getError() == 0) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(true);
                        bdTopToast.h(this.a.k.getActivity().getString(R.string.obfuscated_res_0x7f0f09de));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                        return;
                    }
                    BdTopToast bdTopToast2 = new BdTopToast(currentActivity, 2000);
                    bdTopToast2.i(false);
                    bdTopToast2.h(responsedMessage.getErrorString());
                    bdTopToast2.j((ViewGroup) currentActivity.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w0.e.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19399b;

        public j(a aVar, c.a.p0.w0.e.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19399b = aVar;
            this.a = hVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.d.f.p.n.C()) {
                    this.f19399b.k.showToast(R.string.obfuscated_res_0x7f0f0494);
                } else {
                    new o(this.f19399b, this.a).execute(new c.a.p0.w0.e.h[0]);
                }
                TiebaStatic.eventStat(this.f19399b.k.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (AntiHelper.m(this.a.n.getErrorCode(), this.a.n.getErrorString())) {
                    AntiHelper.u(this.a.k.getPageContext().getPageActivity(), this.a.n.getErrorString());
                } else if (obj != null) {
                    this.a.f19391c.J(!StringUtils.isNull(this.a.j));
                } else if (StringUtils.isNull(this.a.n.getErrorString())) {
                } else {
                    c.a.d.f.p.n.N(TbadkCoreApplication.getInst(), this.a.n.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public m(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || this.a.a == null) {
                return;
            }
            if (eVar.f31907c == 1) {
                this.a.f19390b.M();
            }
            if (eVar.f31906b) {
                int i = eVar.f31907c;
                if (i == 1) {
                    this.a.f19396h = true;
                    c.a.p0.w0.e.f fVar = eVar.f31908d;
                    this.a.P(fVar);
                    if (fVar.h() > 0) {
                        c.a.o0.r.j0.b.k().w("key_LIKE_forum_sort_state", fVar.h());
                        c.a.o0.r.j0.b.k().u("like_forum_sort_level", fVar.h() == 2);
                    }
                } else if (i == 0 && !this.a.f19396h) {
                    c.a.p0.w0.e.f fVar2 = eVar.f31908d;
                    this.a.f19391c.V(fVar2);
                    this.a.P(fVar2);
                }
            } else {
                String str = eVar.a;
                if (str != null && !str.equals("")) {
                    this.a.k.showToast(eVar.a);
                    this.a.f19390b.h0(c.a.p0.w0.b.a(2));
                }
            }
            if (eVar.f31907c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.J()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.f31907c == 1 && this.a.l > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.a.l, this.a.f19391c.E() - this.a.l, this.a.f19391c.G(), this.a.f19391c.F(), currentTimeMillis - this.a.f19391c.D());
                this.a.l = -1L;
            }
            String string = this.a.k.getResources().getString(R.string.obfuscated_res_0x7f0f0560);
            c.a.p0.w0.e.f fVar3 = eVar.f31908d;
            if (fVar3 != null && fVar3.d() != null) {
                HotSearchInfoData d2 = eVar.f31908d.d();
                c.a.o0.r.j0.b.k().y("hot_search_info", OrmObject.jsonStrWithObject(d2));
                if (d2 != null && d2.y() != null) {
                    string = d2.y();
                }
            }
            this.a.W(string);
            c.a.p0.w0.e.f fVar4 = eVar.f31908d;
            if (fVar4 == null || fVar4.c() == null) {
                return;
            }
            this.a.f19390b.t0(eVar.f31908d.c());
        }
    }

    /* loaded from: classes2.dex */
    public class n extends BdAsyncTask<c.a.p0.w0.e.h, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.w0.e.h f19400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f19401c;

        public n(a aVar, c.a.p0.w0.e.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19401c = aVar;
            this.a = null;
            this.f19400b = null;
            this.f19400b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(c.a.p0.w0.e.h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVarArr)) == null) {
                c.a.p0.w0.e.h hVar = this.f19400b;
                if (hVar != null) {
                    try {
                        if (hVar.getId() == null || hVar.r() == null) {
                            return null;
                        }
                        if (hVar.m() == 0) {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.a.addPostData("forum_id", hVar.getId());
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
                this.f19401c.X(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((n) str);
                this.f19401c.X(false);
                int m = this.f19400b.m();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f19401c.m = true;
                        if (this.f19401c.a.isAdded() && this.f19401c.k != null) {
                            this.f19401c.k.showToast(this.f19401c.k.getActivity().getString(m > 0 ? R.string.obfuscated_res_0x7f0f0566 : R.string.obfuscated_res_0x7f0f0562));
                        }
                        this.f19401c.f19391c.J(true);
                    } else if (this.f19401c.k == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.f19401c.k.showToast(this.a.getErrorString());
                        } else if (this.f19401c.a.isAdded()) {
                            this.f19401c.k.showToast(this.f19401c.k.getActivity().getString(m > 0 ? R.string.obfuscated_res_0x7f0f0565 : R.string.obfuscated_res_0x7f0f0561));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o extends BdAsyncTask<c.a.p0.w0.e.h, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.w0.e.h f19402b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f19403c;

        public o(a aVar, c.a.p0.w0.e.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19403c = aVar;
            this.a = null;
            this.f19402b = null;
            this.f19402b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(c.a.p0.w0.e.h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVarArr)) == null) {
                c.a.p0.w0.e.h hVar = this.f19402b;
                if (hVar != null) {
                    try {
                        if (hVar.getId() == null || hVar.r() == null) {
                            return null;
                        }
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.a = netWork;
                        netWork.addPostData("fid", hVar.getId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, hVar.r());
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
                this.f19403c.X(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((o) str);
                this.f19403c.X(false);
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f19403c.m = true;
                        if (this.f19403c.a.isAdded() && this.f19403c.k != null) {
                            this.f19403c.k.showToast(this.f19403c.k.getActivity().getString(R.string.obfuscated_res_0x7f0f1480));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.f19403c.T(false, this.f19402b.getId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.f19402b.getId()));
                        long g2 = c.a.d.f.m.b.g(this.f19402b.getId(), 0L);
                        if (g2 > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(g2)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f19402b.r()));
                        }
                        this.f19403c.f19390b.n0(this.f19402b, this.f19403c.f19391c.H());
                        this.f19403c.f19391c.M(this.f19402b);
                    } else if (this.f19403c.k == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.f19403c.k.showToast(this.a.getErrorString());
                        } else if (this.f19403c.a.isAdded()) {
                            this.f19403c.k.showToast(this.f19403c.k.getActivity().getString(R.string.obfuscated_res_0x7f0f0494));
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
        this.f19390b = null;
        this.f19391c = null;
        this.f19394f = null;
        this.f19395g = true;
        this.f19396h = false;
        this.l = -1L;
        this.q = 1;
        this.w = new e(this, 2921032);
        this.x = new h(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        this.y = new i(this, CmdConfigHttp.CMD_SET_LIKE_FORUM, 309685);
        this.z = new l(this);
        this.A = new m(this);
        this.B = new c(this);
        this.a = enterForumFragment;
        this.k = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.o = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        c.a.p0.f1.q2.d.d();
        this.l = System.currentTimeMillis();
        this.f19395g = true;
        this.f19396h = false;
        this.j = "";
        this.f19391c = new EnterForumModel(this.k.getPageContext());
        this.u = new c.a.p0.w0.l.d.b();
        this.f19392d = new RecentlyVisitedForumModel();
        this.n = new LikeModel(this.k.getPageContext());
        this.f19393e = new c.a.p0.h4.d(this.k.getPageContext());
        this.n.setLoadDataCallBack(this.z);
        this.f19391c.X(this.A);
        c.a.o0.r.j0.b.k().u("enter_forum_edit_mode", false);
        c.a.p0.w0.k.a.b().c(this.a.getFragmentActivity(), c.a.d.f.p.n.r(this.a.getFragmentActivity()));
        H();
        G();
        R();
    }

    public void A(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.s || this.f19391c == null || this.f19390b == null) {
            return;
        }
        String str = this.j;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.j = currentAccount;
        if (this.f19395g) {
            this.f19395g = false;
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
            EnterForumModel enterForumModel2 = this.f19391c;
            if (enterForumModel2 != null && enterForumModel2.C() != null && this.f19391c.C().e() != null) {
                Iterator<c.a.p0.w0.e.h> it = this.f19391c.C().e().b().iterator();
                while (it.hasNext()) {
                    c.a.p0.w0.e.h next = it.next();
                    if (TbadkCoreApplication.getInst().hasSignedForum(next.r())) {
                        next.L(1);
                        int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.r());
                        if (signLevelUpValue > 0) {
                            next.M(signLevelUpValue);
                        }
                    }
                }
            }
            TbadkCoreApplication.getInst().clearSignedForum();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                c.a.p0.a4.q0.a.g(currentAccount2);
            }
            this.f19390b.c0(this.f19391c.H());
        }
        if (z3 || z2) {
            x();
            c.a.p0.w0.l.d.b bVar = this.u;
            if (bVar != null) {
                bVar.h();
            }
            if (z2) {
                EnterForumModel enterForumModel3 = this.f19391c;
                if (enterForumModel3 != null) {
                    enterForumModel3.I(!StringUtils.isNull(this.j));
                }
                this.f19392d.loadData();
            } else if (!z3 || (enterForumModel = this.f19391c) == null) {
            } else {
                enterForumModel.I(!StringUtils.isNull(this.j));
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19390b == null) {
            return;
        }
        A(true);
    }

    public c.a.p0.w0.o.b C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19390b : (c.a.p0.w0.o.b) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public final void E() {
        c.a.o0.r.t.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f19394f) == null) {
            return;
        }
        aVar.dismiss();
        this.f19394f = null;
    }

    public void F() {
        c.a.p0.w0.o.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bVar = this.f19390b) == null) {
            return;
        }
        bVar.X(this.t);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            S();
            this.a.registerListener(this.x);
            this.a.registerListener(this.y);
            this.a.registerListener(this.w);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t = LayoutInflater.from(this.k.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0282, (ViewGroup) null);
            c.a.p0.w0.o.b bVar = new c.a.p0.w0.o.b(this.a, this.t, this.o, this.f19392d, this.f19391c);
            this.f19390b = bVar;
            bVar.A0(this.u);
            this.f19390b.v0(this.B);
            L(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p = new c.a.o0.r.l0.a(this.k.getPageContext());
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.a.isHidden() : invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f19390b == null) {
            return;
        }
        A(false);
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            c.a.p0.w0.o.b bVar = this.f19390b;
            if (bVar != null) {
                bVar.d0(i2);
            }
            c.a.p0.w0.o.f fVar = this.r;
            if (fVar != null) {
                fVar.s();
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            x();
            c.a.p0.w0.k.a.b().a();
            c.a.p0.w0.o.b bVar = this.f19390b;
            if (bVar != null) {
                bVar.e0();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f19392d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.f19391c;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.o;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.w0.o.b bVar = this.f19390b;
            if (bVar != null && bVar.Q() != null) {
                this.f19390b.Q().z();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.f19392d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.z();
            }
            EnterForumModel enterForumModel = this.f19391c;
            if (enterForumModel != null) {
                enterForumModel.O();
            }
            c.a.p0.w0.o.b bVar2 = this.f19390b;
            if (bVar2 != null) {
                bVar2.f0();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.a.isAdded() && this.a.isPrimary()) {
                RecentlyVisitedForumModel recentlyVisitedForumModel = this.f19392d;
                if (recentlyVisitedForumModel != null) {
                    recentlyVisitedForumModel.A();
                }
            } else {
                E();
            }
            c.a.p0.w0.o.b bVar = this.f19390b;
            if (bVar != null) {
                bVar.g0();
            }
        }
    }

    public void P(c.a.p0.w0.e.f fVar) {
        c.a.p0.w0.o.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) || (bVar = this.f19390b) == null) {
            return;
        }
        if (fVar == null) {
            bVar.F0(this.t);
            return;
        }
        c.a.p0.w0.e.j e2 = fVar.e();
        ArrayList<c.a.p0.w0.e.h> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        y(arrayList, fVar.g());
        Z(fVar);
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(c.a.o0.r.j0.b.k().q("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.y() != null) {
            W(hotSearchInfoData.y());
        }
        this.f19390b.i0();
        this.f19390b.h0(fVar.h());
    }

    public void Q(boolean z) {
        c.a.p0.w0.o.b bVar;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (bVar = this.f19390b) == null || (enterForumFragment = this.a) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.a.isResumed()) {
                this.f19390b.G0();
            } else {
                this.f19390b.M();
            }
        } else {
            bVar.M();
        }
        this.f19390b.u0(z);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new g(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.registerListener(new f(this, 2007010));
        }
    }

    public final void T(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, str) == null) {
            new d(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void U(c.a.p0.w0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f19390b.q0(eVar);
            this.a.J0(eVar);
        }
    }

    public void V(BdUniqueId bdUniqueId) {
        c.a.p0.w0.o.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) || (bVar = this.f19390b) == null) {
            return;
        }
        bVar.x0(bdUniqueId);
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.a.G0() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.a.G0().S(str.trim());
        } else {
            this.a.G0().S(this.k.getActivity().getString(R.string.obfuscated_res_0x7f0f0560));
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (this.p == null) {
                I();
            }
            this.p.h(z);
        }
    }

    public void Y(c.a.p0.w0.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, hVar) == null) || hVar == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.k.getPageContext().getPageActivity());
        aVar.setMessage(String.format(this.k.getPageContext().getString(R.string.obfuscated_res_0x7f0f02a3), hVar.r()));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036d), new j(this, hVar));
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c), new k(this));
        aVar.setButtonTextColor(R.color.CAM_X0105);
        aVar.create(this.k.getPageContext());
        aVar.show();
    }

    public final void Z(c.a.p0.w0.e.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) && fVar != null && fVar.f() != null && this.a.isPrimary() && this.f19394f == null) {
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(this.k.getActivity());
            if (frsPrivateCommonDialogView.a(fVar.f())) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.k.getActivity());
                this.f19394f = aVar;
                aVar.setContentViewSize(2);
                this.f19394f.setContentView(frsPrivateCommonDialogView);
                this.f19394f.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new View$OnClickListenerC1465a(this, fVar));
                this.f19394f.setCloseButton(new b(this));
                this.f19394f.create(this.k.getPageContext()).show();
            }
        }
    }

    @Override // c.a.o0.b0.b
    public void a(c.a.d.o.d.a aVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048602, this, aVar, str, z) != null) || aVar == null) {
        }
    }

    @Override // c.a.o0.k0.c.a
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.o0.k0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.k0.c.a
    public boolean onEventDispatch(c.a.o0.k0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bVar)) == null) {
            int b2 = bVar.b();
            c.a.o0.k0.b.a a = bVar.a();
            switch (b2) {
                case 1:
                    if (this.q == 2 || !(a instanceof c.a.p0.w0.e.h)) {
                        return false;
                    }
                    c.a.p0.w0.e.h hVar = (c.a.p0.w0.e.h) a;
                    String r = hVar.r();
                    if (c.a.d.f.p.m.isForumName(r)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageContext().getPageActivity()).createNormalCfg(r, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object c2 = bVar.c();
                        if (c2 instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (hVar.s() && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 2);
                                Bundle bundle = (Bundle) c2;
                                intent.putExtra("info_forum_image_rect", bundle.getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", hVar.i());
                                intent.putExtra("info_forum_name_rect", bundle.getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", r);
                                intent.putExtra("info_forum_head_background_color", hVar.z());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (hVar.B().night != null && hVar.B().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", hVar.B().night.pattern_image);
                                    }
                                } else if (hVar.B().day != null && hVar.B().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", hVar.B().day.pattern_image);
                                }
                            } else {
                                intent.putExtra("transition_type", 0);
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, hVar.k());
                            hVar.K(0L);
                        }
                        this.k.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(r)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.f19391c.C().h() != 1 ? 1 : 2).param("fid", hVar.getId()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.q == 2) {
                        return false;
                    }
                    if (c.a.o0.r.j0.b.k().h("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    c.a.o0.r.j0.b.k().u("enter_forum_edit_mode", true);
                    if (this.a.getView() != null && this.a.getView().getParent() != null) {
                        this.a.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    c.a.o0.r.j0.b.k().u("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (a instanceof c.a.p0.w0.e.h) {
                        Y((c.a.p0.w0.e.h) a);
                        return true;
                    }
                    return false;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.k.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.k.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.k.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.k.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.k.finish();
                    return true;
                case 9:
                    c.a.p0.w0.o.b bVar2 = this.f19390b;
                    if (bVar2 != null) {
                        bVar2.G0();
                    }
                    return true;
                case 10:
                    this.q = 2;
                    return true;
                case 11:
                    this.q = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.q == 2) {
                        return true;
                    }
                    if (this.r == null) {
                        this.r = new c.a.p0.w0.o.f(this.k.getPageContext(), this.o);
                    }
                    if (a instanceof c.a.p0.w0.e.h) {
                        this.r.t((c.a.p0.w0.e.h) a);
                        this.r.m();
                    }
                    return true;
                case 13:
                    if (a instanceof c.a.p0.w0.e.h) {
                        c.a.p0.w0.e.h hVar2 = (c.a.p0.w0.e.h) a;
                        new n(this, hVar2).execute(new c.a.p0.w0.e.h[0]);
                        TiebaStatic.log(new StatisticItem("c13370").param("obj_type", hVar2.m() <= 0 ? 1 : 2).param("fid", hVar2.getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        return true;
                    }
                    return false;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.k.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.f19393e.d() && (a instanceof c.a.p0.w0.e.h)) {
                        UrlManager.getInstance().dealOneLink(this.k.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + ((c.a.p0.w0.e.h) a).getId() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    U((c.a.p0.w0.e.e) bVar.d());
                    break;
                case 17:
                    U((c.a.p0.w0.e.e) bVar.d());
                    break;
                case 18:
                    U((c.a.p0.w0.e.e) bVar.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (enterForumModel = this.f19391c) == null) {
            return;
        }
        enterForumModel.cancelLoadData();
    }

    public final void y(List<c.a.p0.w0.e.h> list, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048607, this, list, o1Var) == null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.f19390b.l0(this.f19391c.Z(list, c.a.o0.c1.k.a()), o1Var, this.f19391c.H());
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || this.f19390b == null || this.a == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }
}
