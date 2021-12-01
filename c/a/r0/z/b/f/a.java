package c.a.r0.z.b.f;

import android.app.Activity;
import android.os.Bundle;
import c.a.q0.q0.e;
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
/* loaded from: classes7.dex */
public class a extends ActivityDelegation implements c.a.p0.a.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f25799e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.z.b.f.d.a f25800f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f25801g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f25802h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f25803i;

    /* renamed from: c.a.r0.z.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1479a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1479a(a aVar, int i2) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof e) {
                e eVar = (e) data;
                if (getTag() == eVar.a || eVar.f12486g) {
                    this.a.mResult.putInt("result_code", eVar.f12481b);
                    this.a.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, eVar.f12482c);
                    if (this.a.f25800f != null) {
                        this.a.f25800f.a(this.a.mResult);
                    }
                    this.a.finish();
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
        this.f25799e = BdUniqueId.gen();
        this.f25803i = new C1479a(this, 2921393);
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f25801g = activity;
        }
    }

    public void c(c.a.r0.z.b.f.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f25800f = aVar;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25800f = null;
            MessageManager.getInstance().unRegisterListener(this.f25803i);
            super.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f25803i.setTag(this.f25799e);
            MessageManager.getInstance().registerListener(this.f25803i);
            int i2 = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            e eVar = new e();
            eVar.a = this.f25799e;
            eVar.f12481b = i2;
            eVar.f12482c = string;
            eVar.f12484e = (Map) this.mParams.getSerializable("params");
            eVar.f12485f = this.f25802h;
            if (getAgent() != null) {
                eVar.f12483d = getAgent();
            } else {
                Activity activity = this.f25801g;
                if (activity != null) {
                    eVar.f12483d = activity;
                } else {
                    eVar.f12483d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, eVar);
            customMessage.setTag(this.f25799e);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            this.mResult.putInt("result_code", sendMessage ? 0 : 1);
            Bundle bundle = this.mResult;
            bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.m.a
    public void onResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mResult.putInt("result_code", i2);
            this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
            finish();
        }
    }
}
