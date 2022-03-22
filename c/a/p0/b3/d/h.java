package c.a.p0.b3.d;

import android.view.View;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
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
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.y2.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.b3.d.d f12659b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.h4.a f12660c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f12661d;

    /* renamed from: e  reason: collision with root package name */
    public BlackListModel f12662e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12663f;

    /* renamed from: g  reason: collision with root package name */
    public String f12664g;

    /* renamed from: h  reason: collision with root package name */
    public long f12665h;
    public String i;
    public c.a.p0.b3.e.a j;
    public BdUniqueId k;
    public boolean l;
    public RemoveFansController m;
    public c.a.p0.y2.e n;
    public final c.a.d.c.g.c o;
    public final c.a.d.c.g.c p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final c.a.d.c.g.c s;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
                this.a.f12661d.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.f12661d.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : socketResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                if (z && i != 2260104) {
                    if (StringUtils.isNull(str)) {
                        n.N(this.a.f12661d.getPageActivity(), this.a.f12661d.getString(i == 0 ? R.string.obfuscated_res_0x7f0f0f7e : R.string.obfuscated_res_0x7f0f0f7c));
                    } else {
                        n.N(this.a.f12661d.getPageActivity(), str);
                    }
                }
                h hVar = this.a;
                if (j == hVar.f12665h && i == 0) {
                    hVar.l = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.m.removeFans(this.a.f12665h);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                h hVar = this.a;
                if (hVar.f12665h > 0) {
                    if (hVar.f12662e.getMaskType() == 1) {
                        this.a.f12662e.removeFromBlackList(this.a.f12665h);
                    } else {
                        this.a.f12662e.addToBlackList(this.a.f12665h);
                    }
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
    public class g extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
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
                    this.a.f12662e.setMaskType(1);
                } else {
                    this.a.f12662e.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    if (this.a.f12662e.getMaskType() == 1) {
                        TbPageContext tbPageContext = this.a.f12661d;
                        tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f03a3));
                        return;
                    }
                    TbPageContext tbPageContext2 = this.a.f12661d;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f0f83));
                    return;
                }
                this.a.f12661d.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.a.f12661d.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* renamed from: c.a.p0.b3.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0956h extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0956h(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
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
                    errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.a.f12661d.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : responseDeleteFriendMessage.getErrorString();
                }
                this.a.f12661d.showToast(errorString);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
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

    /* loaded from: classes2.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(h hVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
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

    public h(TbPageContext tbPageContext, c.a.p0.b3.d.d dVar, BlackListModel blackListModel, BdUniqueId bdUniqueId) {
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
        this.o = new g(this, 104102);
        this.p = new C0956h(this, 304102);
        this.q = new i(this, 2001174);
        this.r = new j(this, 2001174);
        this.s = new a(this, 304103);
        this.f12661d = tbPageContext;
        this.f12659b = dVar;
        this.f12662e = blackListModel;
        this.k = bdUniqueId;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921343, c.a.p0.h4.a.class, tbPageContext.getPageActivity());
        if (runTask != null) {
            c.a.p0.h4.a aVar = (c.a.p0.h4.a) runTask.getData();
            this.f12660c = aVar;
            aVar.b(bdUniqueId);
        }
        g();
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, this.k);
        this.m = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void e() {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12659b == null || (blackListModel = this.f12662e) == null) {
            return;
        }
        j(this.f12663f, blackListModel.getMaskType() == 1, this.f12659b.e(), this.l);
    }

    public final void f(boolean z) {
        BlackListModel blackListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f12663f = z;
            c.a.p0.b3.e.a aVar = this.j;
            if (aVar != null) {
                aVar.x(z);
            }
            c.a.p0.y2.f fVar = this.a;
            if (fVar == null || (blackListModel = this.f12662e) == null) {
                return;
            }
            fVar.n(this.f12663f, blackListModel.getMaskType() == 1, this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o.setTag(this.k);
            this.p.setTag(this.k);
            this.s.setTag(this.k);
            this.r.setTag(this.k);
            this.q.setTag(this.k);
            this.f12661d.registerListener(this.o);
            this.f12661d.registerListener(this.p);
            this.f12661d.registerListener(this.s);
            this.f12661d.registerListener(this.r);
            this.f12661d.registerListener(this.q);
        }
    }

    public void h(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || this.f12662e == null || aVar == null || aVar.j() == null) {
            return;
        }
        this.j = aVar;
        UserData j2 = aVar.j();
        this.f12663f = aVar.l();
        this.f12662e.setMaskType(j2.isMask() ? 1 : 0);
        this.f12664g = j2.getName_show();
        this.f12665h = j2.getUserIdLong();
        this.i = j2.getPortrait();
        this.l = j2.getIsMyFans() == 1;
    }

    public void i() {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f12664g == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f12661d.getPageActivity());
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new e(this));
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new f(this));
        if (this.f12662e.getMaskType() == 1) {
            format = String.format(this.f12661d.getString(R.string.obfuscated_res_0x7f0f0309), this.f12664g);
        } else {
            format = String.format(this.f12661d.getString(R.string.obfuscated_res_0x7f0f030b), this.f12664g);
        }
        aVar.setMessage(format);
        aVar.create(this.f12661d);
        aVar.show();
    }

    public final void j(boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) {
            c.a.p0.y2.f fVar = new c.a.p0.y2.f(this.f12661d, this);
            this.a = fVar;
            fVar.n(z, z2, z3);
            if (i2 != -1) {
                this.a.m(i2);
            }
            c.a.p0.b3.e.a aVar = this.j;
            if (aVar != null && aVar.j() != null) {
                this.a.o(this.j.j().getUserName());
            }
            this.a.l();
            c.a.p0.y2.e eVar = new c.a.p0.y2.e(this.f12661d.getPageActivity(), this.a.j());
            this.n = eVar;
            eVar.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f12665h == 0) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f12661d.getPageActivity());
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new c(this));
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new d(this));
        aVar.setMessage(String.format(this.f12661d.getString(R.string.obfuscated_res_0x7f0f0f7b), this.f12664g));
        aVar.create(this.f12661d);
        aVar.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        c.a.d.f.m.g.a(this.n, this.f12661d.getPageActivity());
        if (this.a.c() != null && view.getId() == this.a.c().getId()) {
            i();
        } else if (this.a.d() != null && view.getId() == this.a.d().getId()) {
            if (this.f12663f) {
                RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
                requestDeleteFriendMessage.setFriendId(this.f12665h);
                MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.f12661d.getPageActivity(), String.valueOf(this.f12665h), this.f12664g, this.i, null, false, null)));
        } else if (this.a.g() != null && view.getId() == this.a.g().getId()) {
            if (!l.z()) {
                this.f12661d.showToast(R.string.obfuscated_res_0x7f0f0c15);
                return;
            }
            c.a.p0.b3.d.d dVar = this.f12659b;
            if (dVar == null) {
                return;
            }
            if (dVar.e() == 0) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(false, String.valueOf(this.f12665h), this.f12664g, null, null, 0, this.f12659b.d(), this.f12659b.f());
                userMuteAddAndDelCustomMessage.mId = this.f12659b.f();
                c.a.p0.b3.d.d dVar2 = this.f12659b;
                dVar2.j(false, userMuteAddAndDelCustomMessage, dVar2.d(), this.f12664g);
            } else if (this.f12659b.e() == 1) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage2 = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage2.setData(true, String.valueOf(this.f12665h), this.f12664g, null, null, 0, this.f12659b.d(), this.f12659b.f());
                userMuteAddAndDelCustomMessage2.mId = this.f12659b.f();
                this.f12659b.j(true, userMuteAddAndDelCustomMessage2, null, this.f12664g);
            }
        } else if (this.a.i() != null && view.getId() == this.a.i().getId()) {
            if (this.f12660c != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 1));
                this.f12660c.c(String.valueOf(this.f12665h));
            }
        } else if (this.a.h() == null || view.getId() != this.a.h().getId()) {
        } else {
            if (!l.z()) {
                n.M(this.f12661d.getPageActivity(), R.string.obfuscated_res_0x7f0f0c15);
            } else {
                k();
            }
        }
    }
}
