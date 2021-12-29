package c.a.s0.s.i0.t;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.l;
import c.a.s0.s.s.j;
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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.i0.t.a f13472e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<c.a.s0.s.i0.t.b> f13473f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f13474g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.t.e.a f13475h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f13476i;

    /* renamed from: j  reason: collision with root package name */
    public String f13477j;

    /* renamed from: k  reason: collision with root package name */
    public String f13478k;
    public boolean l;
    public boolean m;
    public PopupDialog n;
    public boolean o;
    public c.a.s0.n.d p;
    public f q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.a.f13472e.getUserId()) && this.a.f13472e.getUserId().equals(str)) {
                    this.a.o = true;
                }
                g.a(this.a.n, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                c.a.s0.s.i0.t.a aVar = this.a.f13472e;
                if (aVar == null || StringUtils.isNull(aVar.getUserId()) || data == null || !this.a.f13472e.getUserId().equals(data.f42213c)) {
                    return;
                }
                boolean z = (updateAttentionMessage.getOrginalMessage() == null || this.a.f13476i == null || !updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.f13476i)) ? false : true;
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
                    this.a.f13474g.showToast(str);
                } else if (!data.a) {
                    this.a.o = false;
                    String str2 = updateAttentionMessage.getData() != null ? updateAttentionMessage.getData().f42212b : "";
                    if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str2, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    c.a.s0.s.i0.t.b bVar = (c.a.s0.s.i0.t.b) this.a.f13473f.get();
                    if (bVar == null) {
                        return;
                    }
                    if (z) {
                        bVar.updateLikeStatus(this.a.f13472e.getIsLike(), this.a.f13472e.getLikeStatus(), z);
                    } else {
                        bVar.updateLikeStatus(this.a.f13472e.getIsLike(), this.a.f13472e.getLikeStatus());
                    }
                } else {
                    int fansNum = this.a.f13472e.getFansNum();
                    boolean isLike = this.a.f13472e.getIsLike();
                    if (data.f42214d && !isLike) {
                        fansNum++;
                    } else if (!data.f42214d && isLike) {
                        if (!this.a.m || this.a.o) {
                            fansNum--;
                            if (!this.a.l) {
                                this.a.f13474g.showToast(R.string.un_attention_success);
                            }
                        } else {
                            this.a.o = false;
                            this.a.s();
                            return;
                        }
                    }
                    this.a.f13472e.setLikeStatus(data.m);
                    this.a.f13472e.setIsLike(data.f42214d);
                    this.a.f13472e.setIsFromNetWork(false);
                    this.a.f13472e.setFansNum(fansNum);
                    this.a.o = false;
                    c.a.s0.s.i0.t.b bVar2 = (c.a.s0.s.i0.t.b) this.a.f13473f.get();
                    if (bVar2 != null) {
                        bVar2.updateFansNum(fansNum);
                        if (z) {
                            if (this.a.q != null) {
                                this.a.q.a(data.f42214d);
                            }
                            bVar2.updateLikeStatus(data.f42214d, data.m, true);
                            return;
                        }
                        bVar2.updateLikeStatus(data.f42214d, data.m);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.s0.s.i0.t.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0860c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C0860c(c cVar) {
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
            this.a = cVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.s.i0.t.b bVar = (c.a.s0.s.i0.t.b) this.a.f13473f.get();
                if (bVar instanceof View) {
                    this.a.o = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    c.a.s0.s.i0.t.a aVar = this.a.f13472e;
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, aVar != null ? aVar.getUserId() : "0"));
                    this.a.onClick((View) bVar);
                }
                g.a(this.a.n, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.s0.s.s.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.n == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public interface f {
        void a(boolean z);
    }

    public c(TbPageContext tbPageContext, c.a.s0.s.i0.t.b bVar) {
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
        this.f13473f = new WeakReference<>(null);
        this.f13477j = "0";
        this.r = new a(this, 2921560);
        this.s = new b(this, 2001115);
        this.f13474g = tbPageContext;
        this.f13475h = new c.a.s0.t.e.a(tbPageContext);
        this.f13476i = this.f13474g.getUniqueId();
        tbPageContext.registerListener(this.s);
        tbPageContext.registerListener(this.r);
        r(bVar);
    }

    public c.a.s0.s.i0.t.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13472e : (c.a.s0.s.i0.t.a) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.l = z;
            this.f13475h.i(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f13476i = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.s);
        MessageManager.getInstance().unRegisterListener(this.r);
        this.s.setTag(this.f13476i);
        this.r.setTag(this.f13476i);
        MessageManager.getInstance().registerListener(this.s);
        MessageManager.getInstance().registerListener(this.r);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f13477j = str;
        }
    }

    public void n(c.a.s0.s.i0.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f13472e = aVar;
            c.a.s0.s.i0.t.b bVar = this.f13473f.get();
            if (bVar == null || this.f13472e == null) {
                return;
            }
            bVar.updateLikeStatus(aVar.getIsLike(), aVar.getLikeStatus());
            bVar.updateFansNum(aVar.getFansNum());
        }
    }

    public void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.q = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.s0.s.i0.t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            c.a.s0.n.d dVar = this.p;
            if (dVar == null || !dVar.onClickEvent(view)) {
                if (!l.A()) {
                    this.f13474g.showToast(R.string.neterror);
                    return;
                }
                c.a.s0.s.i0.t.b bVar = this.f13473f.get();
                if (bVar != null) {
                    bVar.onClickEvent(view);
                }
                if (!ViewHelper.checkUpIsLogin(this.f13474g.getPageActivity()) || (aVar = this.f13472e) == null) {
                    return;
                }
                boolean z = !aVar.getIsLike();
                if (this.f13476i == null) {
                    this.f13475h.m(z, this.f13472e.getPortrait(), this.f13472e.getUserId(), this.f13472e.isGod(), this.f13477j, this.f13474g.getUniqueId(), null, "0", this.f13478k);
                } else {
                    this.f13475h.m(z, this.f13472e.getPortrait(), this.f13472e.getUserId(), this.f13472e.isGod(), this.f13477j, this.f13476i, null, "0", this.f13478k);
                }
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f13478k = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.m = z;
        }
    }

    public void r(c.a.s0.s.i0.t.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13473f = new WeakReference<>(bVar);
        bVar.bindOnClickListener(this);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.n == null) {
                j jVar = new j(TbadkCoreApplication.getInst().getCurrentActivity());
                jVar.p(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
                ArrayList arrayList = new ArrayList();
                c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(TbadkCoreApplication.getInst().getString(R.string.confirm), jVar);
                gVar.l(new C0860c(this));
                arrayList.add(gVar);
                jVar.l(new d(this));
                jVar.j(arrayList);
                PopupDialog popupDialog = new PopupDialog(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), jVar);
                this.n = popupDialog;
                popupDialog.setWindowDimAmount(0.7f);
            }
            this.n.setOnCancelListener(new e(this));
            g.i(this.n, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.s);
        MessageManager.getInstance().unRegisterListener(this.r);
    }
}
