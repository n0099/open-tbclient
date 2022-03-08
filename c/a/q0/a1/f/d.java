package c.a.q0.a1.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.q0.a1.e.c;
import c.a.q0.a1.e.d;
import c.a.q0.a1.e.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.template.message.TemplateHttpResponseMessage;
import com.baidu.tbadk.template.message.TemplateNetMessage;
import com.baidu.tbadk.template.message.TemplateSocketResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d<Q extends c.a.q0.a1.e.c, P extends c.a.q0.a1.e.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.q0.a1.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f12013b;

    /* renamed from: c  reason: collision with root package name */
    public final e<Q, P> f12014c;

    /* renamed from: d  reason: collision with root package name */
    public final Q f12015d;

    /* renamed from: e  reason: collision with root package name */
    public final P f12016e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.q0.a1.f.a f12017f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f12018g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12019h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.c.g.a f12020i;

    /* renamed from: j  reason: collision with root package name */
    public TbHttpMessageTask f12021j;
    public SocketMessageTask k;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = dVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                c.a.q0.a1.h.a.b("TemplateModel-->onMessage");
                this.a.n(responsedMessage);
            }
        }
    }

    public d(f<?> fVar, e<Q, P> eVar, c.a.q0.a1.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, eVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f12019h = false;
        this.f12013b = fVar;
        this.f12018g = fVar.getUniqueId();
        this.f12014c = eVar;
        this.f12015d = eVar.b();
        this.f12016e = this.f12014c.d();
        this.f12017f = aVar;
        o(d(), h(), e());
        q(h());
        p(d(), h());
    }

    public void b(c.a.q0.a1.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || this.a.contains(bVar)) {
            return;
        }
        this.a.add(bVar);
    }

    public final boolean c(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.f12018g) ? false : true : invokeL.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12014c.e() : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12014c.c() : (String) invokeV.objValue;
    }

    public Q f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12015d : (Q) invokeV.objValue;
    }

    public P g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12016e : (P) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12014c.a() : invokeV.intValue;
    }

    public boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            c.a.q0.a1.h.a.b(" ----requestMessage---- ");
            if (this.f12019h) {
                return false;
            }
            this.f12019h = true;
            l(f(), true);
            r();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.q0.a1.h.a.b(" ----loadMoreNetRequest---- ");
            if (this.f12019h) {
                return false;
            }
            this.f12019h = true;
            l(f(), false);
            r();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f12020i);
        }
    }

    public void l(Q q, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, q, z) == null) {
            for (c.a.q0.a1.a.b bVar : this.a) {
                bVar.b(q, z);
            }
        }
    }

    public void m(Q q, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, q, p) == null) {
            for (c.a.q0.a1.a.b bVar : this.a) {
                bVar.a(q, p);
            }
        }
    }

    public final void n(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, responsedMessage) == null) {
            this.f12019h = false;
            if (c(responsedMessage) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (responsedMessage.getError() == 0 && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof TemplateSocketResponsedMessage) {
                        TemplateSocketResponsedMessage templateSocketResponsedMessage = (TemplateSocketResponsedMessage) responsedMessage;
                        m(f(), g());
                        c.a.q0.a1.f.a aVar = this.f12017f;
                        if (aVar != null) {
                            aVar.onSuccess(templateSocketResponsedMessage.getIResp());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof TemplateHttpResponseMessage) {
                        TemplateHttpResponseMessage templateHttpResponseMessage = (TemplateHttpResponseMessage) responsedMessage;
                        m(f(), g());
                        c.a.q0.a1.f.a aVar2 = this.f12017f;
                        if (aVar2 != null) {
                            aVar2.onSuccess(templateHttpResponseMessage.getIResp());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getString(R.string.data_load_error);
                }
                c.a.q0.a1.f.a aVar3 = this.f12017f;
                if (aVar3 != null) {
                    aVar3.onError(error, errorString);
                }
            }
        }
    }

    public final void o(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, str) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, c.a.r0.y3.g0.a.a(str, i3));
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(TemplateHttpResponseMessage.class);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f12021j = tbHttpMessageTask;
        }
    }

    public final void p(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            if (this.f12020i == null) {
                this.f12020i = new a(this, i2, i3);
            }
            this.f12020i.setTag(this.f12018g);
            this.f12020i.getSocketMessageListener().isSelfListener();
            this.f12020i.getHttpMessageListener().isSelfListener();
            MessageManager.getInstance().registerListener(this.f12020i);
        }
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(i2);
            socketMessageTask.g(true);
            socketMessageTask.h(false);
            socketMessageTask.setNeedEncrypt(false);
            socketMessageTask.setResponsedClass(TemplateSocketResponsedMessage.class);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(socketMessageTask);
            this.k = socketMessageTask;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TemplateNetMessage templateNetMessage = new TemplateNetMessage(this.f12014c, this.f12015d, this.f12016e);
            templateNetMessage.setTag(this.f12018g);
            MessageManager.getInstance().sendMessage(templateNetMessage, this.k, this.f12021j);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.f12018g = bdUniqueId;
            o(d(), h(), e());
            q(h());
            p(d(), h());
        }
    }
}
