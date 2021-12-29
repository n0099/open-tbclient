package c.a.t0.z.b.f;

import android.app.Activity;
import android.os.Bundle;
import c.a.s0.r0.f;
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
/* loaded from: classes9.dex */
public class a extends ActivityDelegation implements c.a.r0.a.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f26720e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.z.b.f.d.a f26721f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f26722g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f26723h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f26724i;

    /* renamed from: c.a.t0.z.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1550a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1550a(a aVar, int i2) {
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
            if (data instanceof f) {
                f fVar = (f) data;
                if (getTag() == fVar.a || fVar.f13291g) {
                    this.a.mResult.putInt("result_code", fVar.f13286b);
                    this.a.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, fVar.f13287c);
                    if (this.a.f26721f != null) {
                        this.a.f26721f.a(this.a.mResult);
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
        this.f26720e = BdUniqueId.gen();
        this.f26724i = new C1550a(this, 2921393);
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f26722g = activity;
        }
    }

    public void c(c.a.t0.z.b.f.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f26721f = aVar;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26721f = null;
            MessageManager.getInstance().unRegisterListener(this.f26724i);
            super.finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f26724i.setTag(this.f26720e);
            MessageManager.getInstance().registerListener(this.f26724i);
            int i2 = this.mParams.getInt("type");
            String string = this.mParams.getString("orderInfo");
            f fVar = new f();
            fVar.a = this.f26720e;
            fVar.f13286b = i2;
            fVar.f13287c = string;
            fVar.f13289e = (Map) this.mParams.getSerializable("params");
            fVar.f13290f = this.f26723h;
            if (getAgent() != null) {
                fVar.f13288d = getAgent();
            } else {
                Activity activity = this.f26722g;
                if (activity != null) {
                    fVar.f13288d = activity;
                } else {
                    fVar.f13288d = TbadkCoreApplication.getInst().getCurrentActivity();
                }
            }
            CustomMessage customMessage = new CustomMessage(2921393, fVar);
            customMessage.setTag(this.f26720e);
            boolean sendMessage = MessageManager.getInstance().sendMessage(customMessage);
            this.mResult.putInt("result_code", sendMessage ? 0 : 1);
            Bundle bundle = this.mResult;
            bundle.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "" + sendMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.m.a
    public void onResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mResult.putInt("result_code", i2);
            this.mResult.putString(AbstractThirdPartyService.EXTRA_RESULT_MSG, "");
            finish();
        }
    }
}
