package c.a.r0.v.b.f;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import c.a.e.e.p.l;
import c.a.p0.a.c1.d.f;
import c.a.p0.a.z1.b.f.e;
import c.a.q0.p0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static BroadcastReceiver f25339a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.e.a f25340a;

        public a(b bVar, c.a.d0.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25340a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                this.f25340a.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        }
    }

    /* renamed from: c.a.r0.v.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1180b implements c.a.r0.v.b.f.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.e.a f25341a;

        public C1180b(b bVar, c.a.d0.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25341a = aVar;
        }

        @Override // c.a.r0.v.b.f.d.a
        public void a(Bundle bundle) {
            c.a.d0.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || (aVar = this.f25341a) == null) {
                return;
            }
            aVar.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;
        public final /* synthetic */ c.a.d0.e.a val$callback;

        public c(b bVar, c.a.d0.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bVar;
            this.val$callback = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                intent.getExtras();
                this.val$callback.onPayResult(intent.getExtras().getInt("errorCode", -1), intent.getExtras().getString("errorMsg"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1906317965, "Lc/a/r0/v/b/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1906317965, "Lc/a/r0/v/b/f/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.c1.d.f
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
                return true;
            }
            e.g(context, "您没有安装微信，请选择其他支付方式").F();
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a.c1.d.f
    public void b(Activity activity, String str, c.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, aVar) == null) {
            if (!d.c().g()) {
                l.L(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
                return;
            }
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            if (i2 == null || i2.k() == null) {
                return;
            }
            c.a.r0.v.b.f.a aVar2 = new c.a.r0.v.b.f.a();
            aVar2.mParams.putInt("type", 2);
            aVar2.mParams.putString("orderInfo", str);
            aVar2.b(i2.k());
            aVar2.c(new C1180b(this, aVar));
            aVar2.onExec();
        }
    }

    @Override // c.a.p0.a.c1.d.f
    public void c(Context context, JSONObject jSONObject, c.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, aVar) == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
            PayReq e2 = e(jSONObject);
            createWXAPI.registerApp(e2.appId);
            if (!createWXAPI.isWXAppInstalled()) {
                aVar.onPayResult(3, "wx_not_installed");
                e.g(context, "您没有安装微信，请选择其他支付方式").F();
            } else if (c.a.p0.a.a2.e.i() == null) {
            } else {
                if (!createWXAPI.sendReq(e2)) {
                    aVar.onPayResult(6, "wx_start_failed");
                }
                if (f25339a != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(f25339a);
                }
                f25339a = new c(this, aVar);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(f25339a, intentFilter);
            }
        }
    }

    @Override // c.a.p0.a.c1.d.f
    public void d(Activity activity, String str, c.a.d0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, aVar) == null) {
            DelegateUtils.callOnMainWithActivity(c.a.p0.a.g1.f.V().getActivity(), MainProcessDelegateActivity.class, c.a.r0.v.b.f.e.a.class, c.a.r0.v.b.f.e.a.b(str), new a(this, aVar));
        }
    }

    public final PayReq e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString("packagealias");
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("sign");
            return payReq;
        }
        return (PayReq) invokeL.objValue;
    }
}
