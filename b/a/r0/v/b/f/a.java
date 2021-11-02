package b.a.r0.v.b.f;

import android.app.Activity;
import android.os.Bundle;
import b.a.q0.p0.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class a extends ActivityDelegation implements b.a.p0.a.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f24171e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.v.b.f.d.a f24172f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f24173g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f24174h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f24175i;

    /* renamed from: b.a.r0.v.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1179a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24176a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1179a(a aVar, int i2) {
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
            this.f24176a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof e) {
                e eVar = (e) data;
                if (getTag() == eVar.f12796a || eVar.f12802g) {
                    this.f24176a.mResult.putInt("result_code", eVar.f12797b);
                    this.f24176a.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f12798c);
                    if (this.f24176a.f24172f != null) {
                        this.f24176a.f24172f.a(this.f24176a.mResult);
                    }
                    this.f24176a.finish();
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24171e = BdUniqueId.gen();
        this.f24175i = new C1179a(this, 2921393);
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f24173g = activity;
        }
    }

    public void c(b.a.r0.v.b.f.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f24172f = aVar;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24172f = null;
            MessageManager.getInstance().unRegisterListener(this.f24175i);
            super.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f24175i.setTag(this.f24171e);
            MessageManager.getInstance().registerListener(this.f24175i);
            int i2 = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            e eVar = new e();
            eVar.f12796a = this.f24171e;
            eVar.f12797b = i2;
            eVar.f12798c = string;
            eVar.f12800e = (Map) this.mParams.getSerializable("params");
            eVar.f12801f = this.f24174h;
            if (getAgent() != null) {
                eVar.f12799d = getAgent();
            } else {
                Activity activity = this.f24173g;
                if (activity != null) {
                    eVar.f12799d = activity;
                } else {
                    eVar.f12799d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, eVar);
            customMessage.setTag(this.f24171e);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            this.mResult.putInt("result_code", sendMessage ? 0 : 1);
            Bundle bundle = this.mResult;
            bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.m.a
    public void onResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mResult.putInt("result_code", i2);
            this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
            finish();
        }
    }
}
