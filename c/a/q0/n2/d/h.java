package c.a.q0.n2.d;

import android.view.View;
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.k2.e f22554e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.n2.d.d f22555f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.q3.a f22556g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f22557h;

    /* renamed from: i  reason: collision with root package name */
    public BlackListModel f22558i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22559j;
    public String k;
    public long l;
    public String m;
    public c.a.q0.n2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public PersonInfoMoreDialog r;
    public final c.a.e.c.g.c s;
    public final c.a.e.c.g.c t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    public final c.a.e.c.g.c w;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22560a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f22560a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.f22560a.f22557h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.f22560a.f22557h.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22561a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22561a = hVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                if (z && i2 != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.M(this.f22561a.f22557h.getPageActivity(), this.f22561a.f22557h.getString(i2 == 0 ? R.string.remove_fans_success : R.string.remove_fans_fail));
                    } else {
                        l.M(this.f22561a.f22557h.getPageActivity(), str);
                    }
                }
                h hVar = this.f22561a;
                if (j2 == hVar.l && i2 == 0) {
                    hVar.p = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f22562e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22562e = hVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22562e.q.removeFans(this.f22562e.l);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f22563e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22563e = hVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                h hVar = this.f22563e;
                if (hVar.l > 0) {
                    if (hVar.f22558i.getMaskType() == 1) {
                        this.f22563e.f22558i.removeFromBlackList(this.f22563e.l);
                    } else {
                        this.f22563e.f22558i.addToBlackList(this.f22563e.l);
                    }
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22564a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f22564a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() != 10) {
                    return;
                }
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    this.f22564a.f22558i.setMaskType(1);
                } else {
                    this.f22564a.f22558i.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (this.f22564a.f22558i.getMaskType() == 1) {
                        TbPageContext tbPageContext = this.f22564a.f22557h;
                        tbPageContext.showToast(tbPageContext.getString(R.string.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = this.f22564a.f22557h;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.remove_succ));
                    return;
                }
                this.f22564a.f22557h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.f22564a.f22557h.getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: c.a.q0.n2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1046h extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22565a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1046h(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f22565a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                String errorString = responseDeleteFriendMessage.getErrorString();
                if (error == 0) {
                    this.f22565a.f(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.f22565a.f22557h.getResources().getString(R.string.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                this.f22565a.f22557h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22566a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f22566a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.f22566a.f(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f22567a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f22567a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    this.f22567a.f(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    this.f22567a.f(true);
                }
            }
        }
    }

    public h(TbPageContext tbPageContext, c.a.q0.n2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar, blackListModel, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new g(this, 104102);
        this.t = new C1046h(this, 304102);
        this.u = new i(this, 2001174);
        this.v = new j(this, 2001174);
        this.w = new a(this, 304103);
        this.f22557h = tbPageContext;
        this.f22555f = dVar;
        this.f22558i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, c.a.q0.q3.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            c.a.q0.q3.a aVar = (c.a.q0.q3.a) runTask.getData();
            this.f22556g = aVar;
            aVar.b(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.o);
        this.q = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22555f == null || (blackListModel = this.f22558i) == null) {
            return;
        }
        j(this.f22559j, blackListModel.getMaskType() == 1, this.f22555f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f22559j = z;
            c.a.q0.n2.e.a aVar = this.n;
            if (aVar != null) {
                aVar.x(z);
            }
            c.a.q0.k2.e eVar = this.f22554e;
            if (eVar == null || (blackListModel = this.f22558i) == null) {
                return;
            }
            eVar.l(this.f22559j, blackListModel.getMaskType() == 1, this.p);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s.setTag(this.o);
            this.t.setTag(this.o);
            this.w.setTag(this.o);
            this.v.setTag(this.o);
            this.u.setTag(this.o);
            this.f22557h.registerListener(this.s);
            this.f22557h.registerListener(this.t);
            this.f22557h.registerListener(this.w);
            this.f22557h.registerListener(this.v);
            this.f22557h.registerListener(this.u);
        }
    }

    public void h(c.a.q0.n2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || this.f22558i == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.n = aVar;
        UserData j2 = aVar.j();
        this.f22559j = aVar.l();
        this.f22558i.setMaskType(j2.isMask() ? 1 : 0);
        this.k = j2.getName_show();
        this.l = j2.getUserIdLong();
        this.m = j2.getPortrait();
        this.p = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f22557h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new e(this));
        aVar.setNegativeButton(R.string.cancel, new f(this));
        if (this.f22558i.getMaskType() == 1) {
            format = String.format(this.f22557h.getString(R.string.block_chat_ensure_toremove_text), this.k);
        } else {
            format = String.format(this.f22557h.getString(R.string.block_chat_message_alert), this.k);
        }
        aVar.setMessage(format);
        aVar.create(this.f22557h);
        aVar.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            c.a.q0.k2.e eVar = new c.a.q0.k2.e(this.f22557h, this);
            this.f22554e = eVar;
            eVar.l(z, z2, z3);
            if (i2 != -1) {
                this.f22554e.k(i2);
            }
            c.a.q0.n2.e.a aVar = this.n;
            if (aVar != null && aVar.j() != null) {
                if (this.n.j().getBaijiahaoInfo() != null && !StringUtils.isNull(this.n.j().getBaijiahaoInfo().name)) {
                    this.f22554e.m(this.n.j().getBaijiahaoInfo().name);
                } else {
                    this.f22554e.m(this.n.j().getUserName());
                }
            }
            this.f22554e.j();
            PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f22557h.getPageActivity(), this.f22554e.h());
            this.r = personInfoMoreDialog;
            personInfoMoreDialog.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.l == 0) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f22557h.getPageActivity());
        aVar.setPositiveButton(R.string.confirm, new c(this));
        aVar.setNegativeButton(R.string.cancel, new d(this));
        aVar.setMessage(String.format(this.f22557h.getString(R.string.remove_fans_alert_text), this.k));
        aVar.create(this.f22557h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        c.a.e.e.m.g.a(this.r, this.f22557h.getPageActivity());
        if (this.f22554e.c() != null && view.getId() == this.f22554e.c().getId()) {
            i();
        } else if (this.f22554e.d() != null && view.getId() == this.f22554e.d().getId()) {
            if (this.f22559j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f22557h.getPageActivity(), String.valueOf(this.l), this.k, this.m, null, false, null)));
        } else if (this.f22554e.e() != null && view.getId() == this.f22554e.e().getId()) {
            if (!c.a.e.e.p.j.z()) {
                this.f22557h.showToast(R.string.neterror);
                return;
            }
            c.a.q0.n2.d.d dVar = this.f22555f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.k, null, null, 0, this.f22555f.d(), this.f22555f.f());
                userMuteAddAndDelCustomMessage.mId = this.f22555f.f();
                c.a.q0.n2.d.d dVar2 = this.f22555f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.k);
            } else if (this.f22555f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.k, null, null, 0, this.f22555f.d(), this.f22555f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f22555f.f();
                this.f22555f.j(true, userMuteAddAndDelCustomMessage2, null, this.k);
            }
        } else if (this.f22554e.g() != null && view.getId() == this.f22554e.g().getId()) {
            if (this.f22556g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f22556g.c(String.valueOf(this.l));
            }
        } else if (this.f22554e.f() == null || view.getId() != this.f22554e.f().getId()) {
        } else {
            if (!c.a.e.e.p.j.z()) {
                l.L(this.f22557h.getPageActivity(), R.string.neterror);
            } else {
                k();
            }
        }
    }
}
