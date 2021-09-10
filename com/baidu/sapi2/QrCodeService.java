package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.http.PassHttpClientRequest;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginStatusCheckResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class QrCodeService extends AbstractService implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static QrCodeService f44544c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HttpClientWrap f44545a;

    /* renamed from: b  reason: collision with root package name */
    public PassHttpClientRequest f44546b;

    /* loaded from: classes5.dex */
    public class a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f44547a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f44548b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44549c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f44550d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, getQrCodeImageResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44550d = qrCodeService;
            this.f44547a = sapiCallback;
            this.f44548b = getQrCodeImageResult;
            this.f44549c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f44548b.setResultCode(i2);
                this.f44547a.onFailure(this.f44548b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44547a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f44547a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f44548b.setResultCode(parseInt);
                    this.f44548b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.f44547a.onFailure(this.f44548b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f44548b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f44548b.prompt = jSONObject.optString("prompt");
                    this.f44548b.channelId = jSONObject.optString("sign");
                    if (this.f44549c) {
                        this.f44548b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.f44547a.onSuccess(this.f44548b);
                } catch (Throwable th) {
                    this.f44547a.onFailure(this.f44548b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f44551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f44552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f44554d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, getQrCodeImageResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44554d = qrCodeService;
            this.f44551a = sapiCallback;
            this.f44552b = getQrCodeImageResult;
            this.f44553c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f44552b.setResultCode(i2);
                this.f44551a.onFailure(this.f44552b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44551a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f44551a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f44552b.setResultCode(parseInt);
                    this.f44552b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.f44551a.onFailure(this.f44552b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f44552b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f44552b.prompt = jSONObject.optString("prompt");
                    this.f44552b.channelId = jSONObject.optString("sign");
                    if (this.f44553c) {
                        this.f44552b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.f44551a.onSuccess(this.f44552b);
                } catch (Throwable th) {
                    this.f44551a.onFailure(this.f44552b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44555a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f44556b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f44557c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f44558d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f44559e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(QrCodeService qrCodeService, Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, Boolean.valueOf(z), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44559e = qrCodeService;
            this.f44555a = z;
            this.f44556b = qrLoginStatusCheckCallback;
            this.f44557c = qrLoginStatusCheckResult;
            this.f44558d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f44557c.setResultCode(i2);
                this.f44556b.onFailure(this.f44557c);
                this.f44556b.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f44555a) {
                this.f44556b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f44557c.setResultCode(parseInt);
                    this.f44557c.setResultMsg(optString);
                    if (parseInt != 0) {
                        if (parseInt != 1) {
                            this.f44556b.onFailure(this.f44557c);
                            this.f44556b.onFinish();
                            return;
                        }
                        this.f44559e.qrLoginStatusCheck(this.f44556b, this.f44558d, false);
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                    int optInt = jSONObject2.optInt("status");
                    this.f44557c.status = optInt;
                    if (optInt == 1) {
                        this.f44556b.onScanQrCodeDone(this.f44557c);
                        this.f44559e.qrLoginStatusCheck(this.f44556b, this.f44558d, false);
                    } else if (optInt == 0) {
                        this.f44559e.getQrLoginResult(this.f44556b, this.f44557c, jSONObject2.optString("v"), this.f44558d.hostDeviceId, this.f44558d.isJoinCodeLogin);
                    } else if (optInt == 2) {
                        this.f44557c.setResultCode(optInt);
                        this.f44557c.setResultMsg("您已取消操作");
                        this.f44556b.onFailure(this.f44557c);
                        this.f44556b.onFinish();
                    } else {
                        this.f44559e.qrLoginStatusCheck(this.f44556b, this.f44558d, false);
                    }
                } catch (Throwable th) {
                    this.f44556b.onFailure(this.f44557c);
                    this.f44556b.onFinish();
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f44560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f44561b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44562c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f44563d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(QrCodeService qrCodeService, Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44563d = qrCodeService;
            this.f44560a = qrLoginStatusCheckCallback;
            this.f44561b = qrLoginStatusCheckResult;
            this.f44562c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f44561b.setResultCode(i2);
                this.f44560a.onFailure(this.f44561b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44560a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f44561b.setResultCode(parseInt);
                    this.f44561b.setResultMsg(optString);
                    if (parseInt != 0 && parseInt != 110000) {
                        this.f44560a.onFailure(this.f44561b);
                        return;
                    }
                    if (this.f44562c) {
                        optJSONObject = jSONObject.optJSONObject("data");
                    } else {
                        optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                    }
                    SapiAccount parseAccount = this.f44563d.parseAccount(optJSONObject);
                    parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                    this.f44560a.onSuccess(this.f44561b);
                } catch (Throwable th) {
                    this.f44560a.onFailure(this.f44561b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SapiCallback f44564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrAppLoginResult f44565b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f44566c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, qrAppLoginResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44566c = qrCodeService;
            this.f44564a = sapiCallback;
            this.f44565b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f44565b.setResultCode(i2);
                this.f44564a.onFailure(this.f44565b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f44564a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f44564a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    this.f44565b.setResultCode(parseInt);
                    if (parseInt != 0) {
                        this.f44564a.onFailure(this.f44565b);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("local");
                    if (optJSONObject != null) {
                        this.f44565b.country = optJSONObject.optString("country");
                        this.f44565b.province = optJSONObject.optString("provice");
                        this.f44565b.city = optJSONObject.optString("city");
                    }
                    this.f44564a.onSuccess(this.f44565b);
                } catch (Throwable th) {
                    this.f44564a.onFailure(this.f44565b);
                    Log.e(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrCodeService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sapiConfiguration, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SapiConfiguration) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static synchronized QrCodeService getInstance(SapiConfiguration sapiConfiguration, String str) {
        InterceptResult invokeLL;
        QrCodeService qrCodeService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sapiConfiguration, str)) == null) {
            synchronized (QrCodeService.class) {
                if (f44544c == null) {
                    f44544c = new QrCodeService(sapiConfiguration, str);
                }
                qrCodeService = f44544c;
            }
            return qrCodeService;
        }
        return (QrCodeService) invokeLL.objValue;
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sapiCallback, getQrCodeImageDTO) == null) {
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            if (getQrCodeImageDTO == null) {
                getQrCodeImageDTO = new GetQrCodeImageDTO();
            }
            boolean z = getQrCodeImageDTO.needQrCodeContent;
            GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
            stopLoginStatusCheck();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(getQrCodeImageDTO.lp) ? "pc" : getQrCodeImageDTO.lp);
            httpHashMapWrap.put("apiver", "v3");
            httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(getQrCodeImageDTO.openPlatformId)) {
                httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO.openPlatformId);
            }
            if (!TextUtils.isEmpty(getQrCodeImageDTO.encuid)) {
                httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO.encuid);
            }
            httpHashMapWrap.put("needQrCodeContent", getQrCodeImageDTO.needQrCodeContent ? "1" : "0");
            httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO.hostDeviceId);
            new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new a(this, Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
        }
    }

    public void getQrCodeLoginWithEnuidImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiCallback, getQrCodeImageDTO, str, str2) == null) {
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            GetQrCodeImageDTO getQrCodeImageDTO2 = getQrCodeImageDTO == null ? new GetQrCodeImageDTO() : getQrCodeImageDTO;
            boolean z = getQrCodeImageDTO2.needQrCodeContent;
            GetQrCodeImageResult getQrCodeImageResult = new GetQrCodeImageResult();
            stopLoginStatusCheck();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_LP, TextUtils.isEmpty(getQrCodeImageDTO2.lp) ? "pc" : getQrCodeImageDTO2.lp);
            httpHashMapWrap.put("apiver", "v3");
            httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(getQrCodeImageDTO2.openPlatformId)) {
                httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO2.openPlatformId);
            }
            if (!TextUtils.isEmpty(getQrCodeImageDTO2.encuid)) {
                httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO2.encuid);
            }
            ArrayList arrayList = new ArrayList();
            String url = ServiceManager.getInstance().getIsAccountManager().getConfignation().environment.getURL();
            arrayList.add(ParamsUtil.buidCookie("BDUSS", str, url));
            arrayList.add(ParamsUtil.buidCookie("STOKEN", str2, url));
            httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, "1");
            httpHashMapWrap.put("hostDeviceId", getQrCodeImageDTO2.hostDeviceId);
            new HttpClientWrap().get(SapiEnv.GET_QR_CODE_IMAGE_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, arrayList, getUaInfo(), new b(this, Looper.getMainLooper(), sapiCallback, getQrCodeImageResult, z));
        }
    }

    public void getQrLoginResult(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{qrLoginStatusCheckCallback, qrLoginStatusCheckResult, str, str2, Boolean.valueOf(z)}) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("display", "pcsdk");
            httpHashMapWrap.put("qrcode", "1");
            httpHashMapWrap.put("bduss", str);
            httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("hostDeviceId", str2);
            String str3 = z ? SapiEnv.GET_QR_JOIN_LOGIN_RESULT : SapiEnv.GET_QR_LOGIN_RESULT;
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            this.f44545a = httpClientWrap;
            httpClientWrap.get(str3, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), new d(this, Looper.getMainLooper(), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, z));
        }
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, sapiCallback, str, str2) == null) {
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str2, "cmd can't be empty");
            QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str);
            httpHashMapWrap.put("sign", urlParamsToMap.get("sign"));
            httpHashMapWrap.put("cmd", str2);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put("stoken", currentAccount.stoken);
                httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, currentAccount.ptoken);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("/v2/sapi/qrlogin?lp=");
            sb.append(TextUtils.isEmpty(urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP)) ? "app" : urlParamsToMap.get(SapiUtils.KEY_QR_LOGIN_LP));
            new HttpClientWrap().post(sb.toString(), httpHashMapWrap, null, getUaInfo(), new e(this, Looper.getMainLooper(), sapiCallback, qrAppLoginResult));
        }
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, z) == null) {
            SapiUtils.notNull(qrLoginStatusCheckCallback, SapiCallback.class.getSimpleName() + " can't be null");
            QrLoginStatusCheckResult qrLoginStatusCheckResult = new QrLoginStatusCheckResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("apiver", "v3");
            httpHashMapWrap.put("callback", "cb");
            httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            httpHashMapWrap.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            this.f44545a = httpClientWrap;
            this.f44546b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), 40000, new c(this, Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
        }
    }

    public void stopLoginStatusCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PassHttpClientRequest passHttpClientRequest = this.f44546b;
            if (passHttpClientRequest != null) {
                passHttpClientRequest.cancel();
            }
            if (this.f44545a != null) {
                this.f44545a = null;
            }
        }
    }
}
