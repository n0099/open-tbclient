package c.a.q0.s.f0.t;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.g;
import c.a.e.e.p.j;
import c.a.q0.s.s.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.f0.t.a f13918e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<c.a.q0.s.f0.t.b> f13919f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f13920g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.t.e.a f13921h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f13922i;

    /* renamed from: j  reason: collision with root package name */
    public String f13923j;
    public boolean k;
    public boolean l;
    public PopupDialog m;
    public boolean n;
    public c.a.q0.n.d o;
    public f p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13924a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f13924a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.f13924a.f13918e.getUserId()) && this.f13924a.f13918e.getUserId().equals(str)) {
                    this.f13924a.n = true;
                }
                g.a(this.f13924a.m, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13925a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f13925a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                c.a.q0.s.f0.t.a aVar = this.f13925a.f13918e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !this.f13925a.f13918e.getUserId().equals(data.f48192c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.f13925a.f13922i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.f13925a.f13922i)) ? false : true;
                BlockPopInfoData blockPopInfoData = data.l;
                if (blockPopInfoData != null) {
                    String str = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    this.f13925a.f13920g.showToast(str);
                } else if (!data.f48190a) {
                    this.f13925a.n = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f48191b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    c.a.q0.s.f0.t.b bVar = (c.a.q0.s.f0.t.b) this.f13925a.f13919f.get();
                    if (bVar == null) {
                        return;
                    }
                    if (z) {
                        bVar.updateLikeStatus(this.f13925a.f13918e.getIsLike(), this.f13925a.f13918e.getLikeStatus(), z);
                    } else {
                        bVar.updateLikeStatus(this.f13925a.f13918e.getIsLike(), this.f13925a.f13918e.getLikeStatus());
                    }
                } else {
                    int fansNum = this.f13925a.f13918e.getFansNum();
                    boolean isLike = this.f13925a.f13918e.getIsLike();
                    if (data.f48193d && !isLike) {
                        fansNum++;
                    } else if (!data.f48193d && isLike) {
                        if (!this.f13925a.l || this.f13925a.n) {
                            fansNum--;
                            if (!this.f13925a.k) {
                                this.f13925a.f13920g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            this.f13925a.n = false;
                            this.f13925a.r();
                            return;
                        }
                    }
                    this.f13925a.f13918e.setLikeStatus(data.m);
                    this.f13925a.f13918e.setIsLike(data.f48193d);
                    this.f13925a.f13918e.setIsFromNetWork(false);
                    this.f13925a.f13918e.setFansNum(fansNum);
                    this.f13925a.n = false;
                    c.a.q0.s.f0.t.b bVar2 = (c.a.q0.s.f0.t.b) this.f13925a.f13919f.get();
                    if (bVar2 != null) {
                        bVar2.updateFansNum(fansNum);
                        if (z) {
                            if (this.f13925a.p != null) {
                                this.f13925a.p.a(data.f48193d);
                            }
                            bVar2.updateLikeStatus(data.f48193d, data.m, true);
                            return;
                        }
                        bVar2.updateLikeStatus(data.f48193d, data.m);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.q0.s.f0.t.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0683c implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13926a;

        public C0683c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13926a = cVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.s.f0.t.b bVar = (c.a.q0.s.f0.t.b) this.f13926a.f13919f.get();
                if (bVar instanceof View) {
                    this.f13926a.n = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    c.a.q0.s.f0.t.a aVar = this.f13926a.f13918e;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, aVar != null ? aVar.getUserId() : "0"));
                    this.f13926a.onClick((View) bVar);
                }
                g.a(this.f13926a.m, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13927a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13927a = cVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13927a.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(boolean z);
    }

    public c(TbPageContext tbPageContext, c.a.q0.s.f0.t.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13919f = new WeakReference<>(null);
        this.f13923j = "0";
        this.q = new a(this, 2921560);
        this.r = new b(this, 2001115);
        this.f13920g = tbPageContext;
        this.f13921h = new c.a.q0.t.e.a(tbPageContext);
        this.f13922i = this.f13920g.getUniqueId();
        tbPageContext.registerListener(this.r);
        tbPageContext.registerListener(this.q);
        q(bVar);
    }

    public c.a.q0.s.f0.t.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13918e : (c.a.q0.s.f0.t.a) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = z;
            this.f13921h.j(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f13922i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
        this.r.setTag(this.f13922i);
        this.q.setTag(this.f13922i);
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f13923j = str;
        }
    }

    public void n(c.a.q0.s.f0.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f13918e = aVar;
            c.a.q0.s.f0.t.b bVar = this.f13919f.get();
            if (bVar == null || this.f13918e == null) {
                return;
            }
            bVar.updateLikeStatus(aVar.getIsLike(), aVar.getLikeStatus());
            bVar.updateFansNum(aVar.getFansNum());
        }
    }

    public void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.q0.s.f0.t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            c.a.q0.n.d dVar = this.o;
            if (dVar == null || !dVar.onClickEvent(view)) {
                if (!j.A()) {
                    this.f13920g.showToast(R.string.neterror);
                    return;
                }
                c.a.q0.s.f0.t.b bVar = this.f13919f.get();
                if (bVar != null) {
                    bVar.onClickEvent(view);
                }
                if (!ViewHelper.checkUpIsLogin(this.f13920g.getPageActivity()) || (aVar = this.f13918e) == null) {
                    return;
                }
                boolean z = !aVar.getIsLike();
                if (this.f13922i == null) {
                    this.f13921h.m(z, this.f13918e.getPortrait(), this.f13918e.getUserId(), this.f13918e.isGod(), this.f13923j, this.f13920g.getUniqueId(), null, "0");
                } else {
                    this.f13921h.m(z, this.f13918e.getPortrait(), this.f13918e.getUserId(), this.f13918e.isGod(), this.f13923j, this.f13922i, null, "0");
                }
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void q(c.a.q0.s.f0.t.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13919f = new WeakReference<>(bVar);
        bVar.bindOnClickListener(this);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.m == null) {
                i iVar = new i(TbadkCoreApplication.getInst().getCurrentActivity());
                iVar.q(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
                ArrayList arrayList = new ArrayList();
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(TbadkCoreApplication.getInst().getString(R.string.confirm), iVar);
                fVar.l(new C0683c(this));
                arrayList.add(fVar);
                iVar.m(new d(this));
                iVar.k(arrayList);
                PopupDialog popupDialog = new PopupDialog(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), iVar);
                this.m = popupDialog;
                popupDialog.setWindowDimAmount(0.7f);
            }
            this.m.setOnCancelListener(new e(this));
            g.i(this.m, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
    }
}
