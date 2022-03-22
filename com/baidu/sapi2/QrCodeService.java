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
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QrCodeService extends AbstractService implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static QrCodeService f28376c;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpClientWrap a;

    /* renamed from: b  reason: collision with root package name */
    public PassHttpClientRequest f28377b;

    /* loaded from: classes4.dex */
    public class a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f28378b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f28379c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f28380d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, getQrCodeImageResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28380d = qrCodeService;
            this.a = sapiCallback;
            this.f28378b = getQrCodeImageResult;
            this.f28379c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.f28378b.setResultCode(i);
                this.a.onFailure(this.f28378b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f28378b.setResultCode(parseInt);
                    this.f28378b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f28378b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f28378b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f28378b.prompt = jSONObject.optString("prompt");
                    this.f28378b.channelId = jSONObject.optString("sign");
                    if (this.f28379c) {
                        this.f28378b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.a.onSuccess(this.f28378b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f28378b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f28381b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f28382c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f28383d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, GetQrCodeImageResult getQrCodeImageResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, getQrCodeImageResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28383d = qrCodeService;
            this.a = sapiCallback;
            this.f28381b = getQrCodeImageResult;
            this.f28382c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.f28381b.setResultCode(i);
                this.a.onFailure(this.f28381b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f28381b.setResultCode(parseInt);
                    this.f28381b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f28381b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f28381b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f28381b.prompt = jSONObject.optString("prompt");
                    this.f28381b.channelId = jSONObject.optString("sign");
                    if (this.f28382c) {
                        this.f28381b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.a.onSuccess(this.f28381b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f28381b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckCallback f28384b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f28385c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f28386d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f28387e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(QrCodeService qrCodeService, Looper looper, boolean z, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, Boolean.valueOf(z), qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28387e = qrCodeService;
            this.a = z;
            this.f28384b = qrLoginStatusCheckCallback;
            this.f28385c = qrLoginStatusCheckResult;
            this.f28386d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.f28385c.setResultCode(i);
                this.f28384b.onFailure(this.f28385c);
                this.f28384b.onFinish();
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a) {
                this.f28384b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str.substring(3, str.length() - 2));
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f28385c.setResultCode(parseInt);
                    this.f28385c.setResultMsg(optString);
                    if (parseInt != 0) {
                        if (parseInt != 1) {
                            this.f28384b.onFailure(this.f28385c);
                            this.f28384b.onFinish();
                            return;
                        }
                        this.f28387e.qrLoginStatusCheck(this.f28384b, this.f28386d, false);
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                    int optInt = jSONObject2.optInt("status");
                    this.f28385c.status = optInt;
                    if (optInt == 1) {
                        this.f28384b.onScanQrCodeDone(this.f28385c);
                        this.f28387e.qrLoginStatusCheck(this.f28384b, this.f28386d, false);
                    } else if (optInt == 0) {
                        this.f28387e.getQrLoginResult(this.f28384b, this.f28385c, jSONObject2.optString("v"), this.f28386d.hostDeviceId, this.f28386d.isJoinCodeLogin);
                    } else if (optInt == 2) {
                        this.f28385c.setResultCode(optInt);
                        this.f28385c.setResultMsg("您已取消操作");
                        this.f28384b.onFailure(this.f28385c);
                        this.f28384b.onFinish();
                    } else {
                        this.f28387e.qrLoginStatusCheck(this.f28384b, this.f28386d, false);
                    }
                } catch (Throwable th) {
                    this.f28384b.onFailure(this.f28385c);
                    this.f28384b.onFinish();
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QrLoginStatusCheckCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f28388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f28389c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f28390d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(QrCodeService qrCodeService, Looper looper, QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStatusCheckResult qrLoginStatusCheckResult, boolean z) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28390d = qrCodeService;
            this.a = qrLoginStatusCheckCallback;
            this.f28388b = qrLoginStatusCheckResult;
            this.f28389c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.f28388b.setResultCode(i);
                this.a.onFailure(this.f28388b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f28388b.setResultCode(parseInt);
                    this.f28388b.setResultMsg(optString);
                    if (parseInt != 0 && parseInt != 110000) {
                        this.a.onFailure(this.f28388b);
                        return;
                    }
                    if (this.f28389c) {
                        optJSONObject = jSONObject.optJSONObject("data");
                    } else {
                        optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                    }
                    SapiAccount parseAccount = this.f28390d.parseAccount(optJSONObject);
                    parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.QR.getName());
                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                    this.a.onSuccess(this.f28388b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f28388b);
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ QrAppLoginResult f28391b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f28392c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(QrCodeService qrCodeService, Looper looper, SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qrCodeService, looper, sapiCallback, qrAppLoginResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28392c = qrCodeService;
            this.a = sapiCallback;
            this.f28391b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.f28391b.setResultCode(i);
                this.a.onFailure(this.f28391b);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    this.f28391b.setResultCode(parseInt);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f28391b);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("local");
                    if (optJSONObject != null) {
                        this.f28391b.country = optJSONObject.optString("country");
                        this.f28391b.province = optJSONObject.optString("provice");
                        this.f28391b.city = optJSONObject.optString("city");
                    }
                    this.a.onSuccess(this.f28391b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f28391b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                if (f28376c == null) {
                    f28376c = new QrCodeService(sapiConfiguration, str);
                }
                qrCodeService = f28376c;
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
            httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
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
            httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(getQrCodeImageDTO2.openPlatformId)) {
                httpHashMapWrap.put("openPlatformId", getQrCodeImageDTO2.openPlatformId);
            }
            if (!TextUtils.isEmpty(getQrCodeImageDTO2.encuid)) {
                httpHashMapWrap.put(SapiUtils.KEY_QR_LOGIN_ENCUID, getQrCodeImageDTO2.encuid);
            }
            ArrayList arrayList = new ArrayList();
            String url = ServiceManager.getInstance().getIsAccountManager().getConfignation().environment.getURL();
            arrayList.add(ParamsUtil.buidCookie(HttpRequest.BDUSS, str, url));
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
            httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("hostDeviceId", str2);
            String str3 = z ? SapiEnv.GET_QR_JOIN_LOGIN_RESULT : SapiEnv.GET_QR_LOGIN_RESULT;
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            this.a = httpClientWrap;
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
            httpHashMapWrap.put(WebChromeClient.KEY_ARG_CALLBACK, "cb");
            httpHashMapWrap.put("channel_id", qrLoginStstusCheckDTO.channelId);
            httpHashMapWrap.put("tt", String.valueOf(System.currentTimeMillis()));
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            this.a = httpClientWrap;
            this.f28377b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), 40000, new c(this, Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
        }
    }

    public void stopLoginStatusCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PassHttpClientRequest passHttpClientRequest = this.f28377b;
            if (passHttpClientRequest != null) {
                passHttpClientRequest.cancel();
            }
            if (this.a != null) {
                this.a = null;
            }
        }
    }
}
