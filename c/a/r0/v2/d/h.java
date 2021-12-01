package c.a.r0.v2.d;

import android.view.View;
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
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
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.s2.e f24724e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.v2.d.d f24725f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.b4.a f24726g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f24727h;

    /* renamed from: i  reason: collision with root package name */
    public BlackListModel f24728i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24729j;

    /* renamed from: k  reason: collision with root package name */
    public String f24730k;
    public long l;
    public String m;
    public c.a.r0.v2.e.a n;
    public BdUniqueId o;
    public boolean p;
    public RemoveFansController q;
    public PersonInfoMoreDialog r;
    public final c.a.d.c.g.c s;
    public final c.a.d.c.g.c t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    public final c.a.d.c.g.c w;

    /* loaded from: classes7.dex */
    public class a extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.a.f24727h.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.f24727h.getResources().getString(c.a.r0.w2.g.neterror) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                if (z && i2 != 2260104) {
                    if (StringUtils.isNull(str)) {
                        l.M(this.a.f24727h.getPageActivity(), this.a.f24727h.getString(i2 == 0 ? c.a.r0.w2.g.remove_fans_success : c.a.r0.w2.g.remove_fans_fail));
                    } else {
                        l.M(this.a.f24727h.getPageActivity(), str);
                    }
                }
                h hVar = this.a;
                if (j2 == hVar.l && i2 == 0) {
                    hVar.p = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f24731e;

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
            this.f24731e = hVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f24731e.q.removeFans(this.f24731e.l);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f24732e;

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
            this.f24732e = hVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                h hVar = this.f24732e;
                if (hVar.l > 0) {
                    if (hVar.f24728i.getMaskType() == 1) {
                        this.f24732e.f24728i.removeFromBlackList(this.f24732e.l);
                    } else {
                        this.f24732e.f24728i.addToBlackList(this.f24732e.l);
                    }
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
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
                    this.a.f24728i.setMaskType(1);
                } else {
                    this.a.f24728i.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (this.a.f24728i.getMaskType() == 1) {
                        TbPageContext tbPageContext = this.a.f24727h;
                        tbPageContext.showToast(tbPageContext.getString(c.a.r0.w2.g.chat_message_blocked));
                        return;
                    }
                    TbPageContext tbPageContext2 = this.a.f24727h;
                    tbPageContext2.showToast(tbPageContext2.getString(c.a.r0.w2.g.remove_succ));
                    return;
                }
                this.a.f24727h.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.a.f24727h.getResources().getString(c.a.r0.w2.g.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: c.a.r0.v2.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1415h extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1415h(h hVar, int i2) {
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
            this.a = hVar;
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
                    this.a.f(false);
                } else {
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.a.f24727h.getResources().getString(c.a.r0.w2.g.neterror) : responseDeleteFriendMessage.getErrorString();
                }
                this.a.f24727h.showToast(errorString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) && ((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 0) {
                this.a.f(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                    this.a.f(false);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    this.a.f(true);
                }
            }
        }
    }

    public h(TbPageContext tbPageContext, c.a.r0.v2.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
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
        this.t = new C1415h(this, 304102);
        this.u = new i(this, 2001174);
        this.v = new j(this, 2001174);
        this.w = new a(this, 304103);
        this.f24727h = tbPageContext;
        this.f24725f = dVar;
        this.f24728i = blackListModel;
        this.o = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, c.a.r0.b4.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            c.a.r0.b4.a aVar = (c.a.r0.b4.a) runTask.getData();
            this.f24726g = aVar;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24725f == null || (blackListModel = this.f24728i) == null) {
            return;
        }
        j(this.f24729j, blackListModel.getMaskType() == 1, this.f24725f.e(), this.p);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f24729j = z;
            c.a.r0.v2.e.a aVar = this.n;
            if (aVar != null) {
                aVar.x(z);
            }
            c.a.r0.s2.e eVar = this.f24724e;
            if (eVar == null || (blackListModel = this.f24728i) == null) {
                return;
            }
            eVar.l(this.f24729j, blackListModel.getMaskType() == 1, this.p);
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
            this.f24727h.registerListener(this.s);
            this.f24727h.registerListener(this.t);
            this.f24727h.registerListener(this.w);
            this.f24727h.registerListener(this.v);
            this.f24727h.registerListener(this.u);
        }
    }

    public void h(c.a.r0.v2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || this.f24728i == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.n = aVar;
        UserData j2 = aVar.j();
        this.f24729j = aVar.l();
        this.f24728i.setMaskType(j2.isMask() ? 1 : 0);
        this.f24730k = j2.getName_show();
        this.l = j2.getUserIdLong();
        this.m = j2.getPortrait();
        this.p = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f24730k == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f24727h.getPageActivity());
        aVar.setPositiveButton(c.a.r0.w2.g.confirm, new e(this));
        aVar.setNegativeButton(c.a.r0.w2.g.cancel, new f(this));
        if (this.f24728i.getMaskType() == 1) {
            format = String.format(this.f24727h.getString(c.a.r0.w2.g.block_chat_ensure_toremove_text), this.f24730k);
        } else {
            format = String.format(this.f24727h.getString(c.a.r0.w2.g.block_chat_message_alert), this.f24730k);
        }
        aVar.setMessage(format);
        aVar.create(this.f24727h);
        aVar.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            c.a.r0.s2.e eVar = new c.a.r0.s2.e(this.f24727h, this);
            this.f24724e = eVar;
            eVar.l(z, z2, z3);
            if (i2 != -1) {
                this.f24724e.k(i2);
            }
            c.a.r0.v2.e.a aVar = this.n;
            if (aVar != null && aVar.j() != null) {
                this.f24724e.m(this.n.j().getUserName());
            }
            this.f24724e.j();
            PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f24727h.getPageActivity(), this.f24724e.h());
            this.r = personInfoMoreDialog;
            personInfoMoreDialog.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.l == 0) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f24727h.getPageActivity());
        aVar.setPositiveButton(c.a.r0.w2.g.confirm, new c(this));
        aVar.setNegativeButton(c.a.r0.w2.g.cancel, new d(this));
        aVar.setMessage(String.format(this.f24727h.getString(c.a.r0.w2.g.remove_fans_alert_text), this.f24730k));
        aVar.create(this.f24727h);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        c.a.d.f.m.g.a(this.r, this.f24727h.getPageActivity());
        if (this.f24724e.c() != null && view.getId() == this.f24724e.c().getId()) {
            i();
        } else if (this.f24724e.d() != null && view.getId() == this.f24724e.d().getId()) {
            if (this.f24729j) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.l);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f24727h.getPageActivity(), String.valueOf(this.l), this.f24730k, this.m, null, false, null)));
        } else if (this.f24724e.e() != null && view.getId() == this.f24724e.e().getId()) {
            if (!c.a.d.f.p.j.z()) {
                this.f24727h.showToast(c.a.r0.w2.g.neterror);
                return;
            }
            c.a.r0.v2.d.d dVar = this.f24725f;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.l), this.f24730k, null, null, 0, this.f24725f.d(), this.f24725f.f());
                userMuteAddAndDelCustomMessage.mId = this.f24725f.f();
                c.a.r0.v2.d.d dVar2 = this.f24725f;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.f24730k);
            } else if (this.f24725f.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.l), this.f24730k, null, null, 0, this.f24725f.d(), this.f24725f.f());
                userMuteAddAndDelCustomMessage2.mId = this.f24725f.f();
                this.f24725f.j(true, userMuteAddAndDelCustomMessage2, null, this.f24730k);
            }
        } else if (this.f24724e.g() != null && view.getId() == this.f24724e.g().getId()) {
            if (this.f24726g != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f24726g.c(String.valueOf(this.l));
            }
        } else if (this.f24724e.f() == null || view.getId() != this.f24724e.f().getId()) {
        } else {
            if (!c.a.d.f.p.j.z()) {
                l.L(this.f24727h.getPageActivity(), c.a.r0.w2.g.neterror);
            } else {
                k();
            }
        }
    }
}
