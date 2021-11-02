package b.a.r0.x1.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import b.a.q0.d1.u0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.pay.IPayCallback;
import com.baidu.searchbox.live.interfaces.pay.IPayChannel;
import com.baidu.searchbox.live.interfaces.pay.PayChannelType;
import com.baidu.searchbox.live.interfaces.pay.YYPayResultService;
import com.baidu.searchbox.live.interfaces.service.PayChannelService;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b implements PayChannelService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ITiebaPay f27025a;

    /* loaded from: classes5.dex */
    public class a implements IPayChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27026a;

        /* renamed from: b.a.r0.x1.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1328a implements ITiebaPayCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ IPayCallback f27027a;

            public C1328a(a aVar, IPayCallback iPayCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iPayCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27027a = iPayCallback;
            }

            @Override // com.baidu.tieba.wallet.ITiebaPayCallback
            public void onPayResult(int i2, String str) {
                IPayCallback iPayCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (iPayCallback = this.f27027a) == null) {
                    return;
                }
                iPayCallback.onPayResult(i2, str);
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27026a = bVar;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public PayChannelType getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PayChannelType.WALLET : (PayChannelType) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public String getUaForFrontPay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return u0.b() + " (Baidu; P1 " + Build.VERSION.RELEASE + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void onPayResult(String str, String str2, String str3, Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, context, Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void pay(Activity activity, HashMap<String, String> hashMap, IPayCallback iPayCallback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, activity, hashMap, iPayCallback) == null) || hashMap == null || hashMap.isEmpty()) {
                return;
            }
            this.f27026a.c();
            if (this.f27026a.f27025a != null) {
                this.f27026a.f27025a.pay(hashMap.remove("channel"), hashMap, new C1328a(this, iPayCallback));
            } else if (iPayCallback != null) {
                iPayCallback.onPayResult(2, null);
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    public b() {
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
        this.f27025a = null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.PayChannelService
    public IPayChannel buildPayChannel(PayChannelType payChannelType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, payChannelType)) == null) {
            if (payChannelType == PayChannelType.WALLET) {
                return new a(this);
            }
            return null;
        }
        return (IPayChannel) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.PayChannelService
    public YYPayResultService buildYYPayResChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (YYPayResultService) invokeV.objValue;
    }

    public final void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f27025a == null && (runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class)) != null) {
            this.f27025a = (ITiebaPay) runTask.getData();
        }
    }
}
