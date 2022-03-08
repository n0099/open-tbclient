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
import com.baidu.tieba.tblauncher.MainTabActivity;
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
    public static QrCodeService f36615c;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpClientWrap a;

    /* renamed from: b  reason: collision with root package name */
    public PassHttpClientRequest f36616b;

    /* loaded from: classes4.dex */
    public class a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetQrCodeImageResult f36617b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36618c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f36619d;

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
            this.f36619d = qrCodeService;
            this.a = sapiCallback;
            this.f36617b = getQrCodeImageResult;
            this.f36618c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f36617b.setResultCode(i2);
                this.a.onFailure(this.f36617b);
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
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f36617b.setResultCode(parseInt);
                    this.f36617b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f36617b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f36617b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f36617b.prompt = jSONObject.optString("prompt");
                    this.f36617b.channelId = jSONObject.optString("sign");
                    if (this.f36618c) {
                        this.f36617b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.a.onSuccess(this.f36617b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f36617b);
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
        public final /* synthetic */ GetQrCodeImageResult f36620b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36621c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f36622d;

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
            this.f36622d = qrCodeService;
            this.a = sapiCallback;
            this.f36620b = getQrCodeImageResult;
            this.f36621c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f36620b.setResultCode(i2);
                this.a.onFailure(this.f36620b);
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
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f36620b.setResultCode(parseInt);
                    this.f36620b.setResultMsg(optString);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f36620b);
                        return;
                    }
                    GetQrCodeImageResult getQrCodeImageResult = this.f36620b;
                    getQrCodeImageResult.imageUrl = "https://" + jSONObject.optString("imgurl");
                    this.f36620b.prompt = jSONObject.optString("prompt");
                    this.f36620b.channelId = jSONObject.optString("sign");
                    if (this.f36621c) {
                        this.f36620b.contentUrl = jSONObject.optString("qrcontent_url");
                    }
                    this.a.onSuccess(this.f36620b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f36620b);
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
        public final /* synthetic */ QrLoginStatusCheckCallback f36623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrLoginStatusCheckResult f36624c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrLoginStstusCheckDTO f36625d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f36626e;

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
            this.f36626e = qrCodeService;
            this.a = z;
            this.f36623b = qrLoginStatusCheckCallback;
            this.f36624c = qrLoginStatusCheckResult;
            this.f36625d = qrLoginStstusCheckDTO;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f36624c.setResultCode(i2);
                this.f36623b.onFailure(this.f36624c);
                this.f36623b.onFinish();
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
                this.f36623b.onStart();
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
                    this.f36624c.setResultCode(parseInt);
                    this.f36624c.setResultMsg(optString);
                    if (parseInt != 0) {
                        if (parseInt != 1) {
                            this.f36623b.onFailure(this.f36624c);
                            this.f36623b.onFinish();
                            return;
                        }
                        this.f36626e.qrLoginStatusCheck(this.f36623b, this.f36625d, false);
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("channel_v"));
                    int optInt = jSONObject2.optInt("status");
                    this.f36624c.status = optInt;
                    if (optInt == 1) {
                        this.f36623b.onScanQrCodeDone(this.f36624c);
                        this.f36626e.qrLoginStatusCheck(this.f36623b, this.f36625d, false);
                    } else if (optInt == 0) {
                        this.f36626e.getQrLoginResult(this.f36623b, this.f36624c, jSONObject2.optString("v"), this.f36625d.hostDeviceId, this.f36625d.isJoinCodeLogin);
                    } else if (optInt == 2) {
                        this.f36624c.setResultCode(optInt);
                        this.f36624c.setResultMsg("您已取消操作");
                        this.f36623b.onFailure(this.f36624c);
                        this.f36623b.onFinish();
                    } else {
                        this.f36626e.qrLoginStatusCheck(this.f36623b, this.f36625d, false);
                    }
                } catch (Throwable th) {
                    this.f36623b.onFailure(this.f36624c);
                    this.f36623b.onFinish();
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
        public final /* synthetic */ QrLoginStatusCheckResult f36627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f36628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f36629d;

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
            this.f36629d = qrCodeService;
            this.a = qrLoginStatusCheckCallback;
            this.f36627b = qrLoginStatusCheckResult;
            this.f36628c = z;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f36627b.setResultCode(i2);
                this.a.onFailure(this.f36627b);
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
        public void onSuccess(int i2, String str) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    String optString = jSONObject.optString("errmsg");
                    this.f36627b.setResultCode(parseInt);
                    this.f36627b.setResultMsg(optString);
                    if (parseInt != 0 && parseInt != 110000) {
                        this.a.onFailure(this.f36627b);
                        return;
                    }
                    if (this.f36628c) {
                        optJSONObject = jSONObject.optJSONObject("data");
                    } else {
                        optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                    }
                    SapiAccount parseAccount = this.f36629d.parseAccount(optJSONObject);
                    parseAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(optJSONObject).tplStokenMap);
                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.QR.getName());
                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                    this.a.onSuccess(this.f36627b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f36627b);
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
        public final /* synthetic */ QrAppLoginResult f36630b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QrCodeService f36631c;

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
            this.f36631c = qrCodeService;
            this.a = sapiCallback;
            this.f36630b = qrAppLoginResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i2, str) == null) {
                this.f36630b.setResultCode(i2);
                this.a.onFailure(this.f36630b);
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
        public void onSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    this.f36630b.setResultCode(parseInt);
                    if (parseInt != 0) {
                        this.a.onFailure(this.f36630b);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(MainTabActivity.TAB_CODE_LOCAL);
                    if (optJSONObject != null) {
                        this.f36630b.country = optJSONObject.optString("country");
                        this.f36630b.province = optJSONObject.optString("provice");
                        this.f36630b.city = optJSONObject.optString("city");
                    }
                    this.a.onSuccess(this.f36630b);
                } catch (Throwable th) {
                    this.a.onFailure(this.f36630b);
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
                if (f36615c == null) {
                    f36615c = new QrCodeService(sapiConfiguration, str);
                }
                qrCodeService = f36615c;
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
            this.f36616b = httpClientWrap.get(SapiEnv.GET_QR_LOGIN_STATUS_CHECK, ReqPriority.IMMEDIATE, httpHashMapWrap, null, getUaInfo(), 40000, new c(this, Looper.getMainLooper(), z, qrLoginStatusCheckCallback, qrLoginStatusCheckResult, qrLoginStstusCheckDTO));
        }
    }

    public void stopLoginStatusCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PassHttpClientRequest passHttpClientRequest = this.f36616b;
            if (passHttpClientRequest != null) {
                passHttpClientRequest.cancel();
            }
            if (this.a != null) {
                this.a = null;
            }
        }
    }
}
