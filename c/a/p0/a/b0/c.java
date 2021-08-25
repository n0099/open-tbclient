package c.a.p0.a.b0;

import c.a.p0.a.o;
import c.a.p0.a.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigHTTPResMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigReqMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.b0.a<b> f12502a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12503b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f12504c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.c.g.a f12505d;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f12506a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f12506a = cVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f12506a.f12503b = false;
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f12506a.d() != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (this.f12506a.f12502a != null) {
                        this.f12506a.f12502a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                b bVar = null;
                if (responsedMessage instanceof ActiveConfigSocketResMsg) {
                    bVar = ((ActiveConfigSocketResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof ActiveConfigHTTPResMsg) {
                    bVar = ((ActiveConfigHTTPResMsg) responsedMessage).getData();
                }
                if ((responsedMessage.getOrginalMessage().getExtra() instanceof ActiveConfigReqMsg) && ((ActiveConfigReqMsg) responsedMessage.getOrginalMessage().getExtra()).launtchType == 0) {
                    c.a.p0.s.d0.b.j().w("pref_key_active_config_info", System.currentTimeMillis());
                }
                if (bVar != null && bVar.f12501g != null) {
                    if (this.f12506a.f12502a != null) {
                        this.f12506a.f12502a.a(bVar);
                    }
                    if (bVar.f12501g.is_first_up != 1) {
                        r.g().q(bVar.f12501g);
                    }
                }
                if (bVar == null || !this.f12506a.c()) {
                    return;
                }
                c.a.p0.s.d0.b.j().w("pref_key_last_register_mission", System.currentTimeMillis());
                o.b().i(bVar);
                c.a.p0.s.c0.a.e().j(bVar);
                if (this.f12506a.f12502a != null) {
                    this.f12506a.f12502a.onSuccess(bVar);
                }
            }
        }
    }

    public c(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12503b = false;
        this.f12505d = new a(this, CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);
        this.f12504c = bdUniqueId;
        e();
        this.f12505d.setTag(d());
        MessageManager.getInstance().registerListener(this.f12505d);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !UtilHelper.isSameDay(c.a.p0.s.d0.b.j().l("pref_key_last_register_mission", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public BdUniqueId d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12504c : (BdUniqueId) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.i3.d0.a.h(309637, ActiveConfigSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, c.a.q0.i3.d0.a.a(TbConfig.URL_ACTIVE_CONFIG, 309637));
            tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void f(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f12503b) {
            return;
        }
        if (!z) {
            this.f12503b = true;
        }
        c.a.p0.s.d0.b.j().w("pref_key_last_active_config", System.currentTimeMillis());
        ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
        activeConfigReqMsg.setFirstUp(z);
        activeConfigReqMsg.setSchemaUp(z2);
        activeConfigReqMsg.launtchType = i2;
        activeConfigReqMsg.setTag(d());
        MessageManager.getInstance().sendMessage(activeConfigReqMsg);
    }

    public void g(c.a.p0.a.b0.a<b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f12502a = aVar;
        }
    }
}
