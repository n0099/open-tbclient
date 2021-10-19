package c.a.r0.x1.o;

import android.content.Context;
import c.a.q0.p0.f;
import c.a.q0.p0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements YYPayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements c.a.q0.p0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayService.YYPayResultCallback f28278a;

        public a(b bVar, YYPayService.YYPayResultCallback yYPayResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, yYPayResultCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28278a = yYPayResultCallback;
        }

        @Override // c.a.q0.p0.b
        public void a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (gVar != null) {
                    YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                    yYPayResultMessage.setStatus(gVar.f13680g);
                    yYPayResultMessage.setAppid(gVar.f13675b);
                    yYPayResultMessage.setUid(gVar.f13681h.longValue());
                    yYPayResultMessage.setUsedChannel(gVar.f13682i);
                    yYPayResultMessage.setCurrencyType(gVar.f13677d);
                    yYPayResultMessage.setAmount(gVar.f13674a.longValue());
                    yYPayResultMessage.setCurrencyAmount(gVar.f13676c.longValue());
                    yYPayResultMessage.setOrderId(gVar.f13679f);
                    yYPayResultMessage.setExpand(gVar.f13678e);
                    this.f28278a.onSuccess(yYPayResultMessage);
                    return;
                }
                this.f28278a.onSuccess(null);
            }
        }

        @Override // c.a.q0.p0.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f28278a.onFail(i2, str);
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
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, yYPayResultCallback) == null) {
            startPayment(context, null, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, yYPayResultCallback) == null) {
            startPayment(context, str, 0L, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, Long l, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, l, yYPayResultCallback) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new f(context, 1, str, l, new a(this, yYPayResultCallback)));
        }
    }
}
