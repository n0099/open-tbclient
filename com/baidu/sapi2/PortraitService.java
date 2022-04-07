package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.enums.PortraitCategory;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.httpwrap.MultipartHashMapWrap;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PortraitService extends AbstractService implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SetPortraitCallback a;
        public final /* synthetic */ SetPortraitResult b;
        public final /* synthetic */ PortraitService c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PortraitService portraitService, Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitService, looper, setPortraitCallback, setPortraitResult};
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
            this.c = portraitService;
            this.a = setPortraitCallback;
            this.b = setPortraitResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.setResultCode(i);
                this.a.onFailure(this.b);
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
                this.b.setResultCode(this.c.getErrorCode(str));
                this.b.setResultMsg(this.c.getErrorMsg(str));
                int resultCode = this.b.getResultCode();
                if (resultCode == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.b.portraitSign = jSONObject.optString("portrait_tag");
                        String optString = jSONObject.optString("portrait");
                        if (!TextUtils.isEmpty(optString)) {
                            this.b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
                        }
                    } catch (JSONException unused) {
                    }
                    this.a.onSuccess(this.b);
                } else if (resultCode == 160103) {
                    this.a.onBdussExpired(this.b);
                } else if (resultCode == 991613) {
                    this.a.onFailure(this.b);
                } else if (resultCode != 991616) {
                    this.a.onFailure(this.b);
                } else {
                    this.a.onSuccess(this.b);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SetPopularPortraitResult a;
        public final /* synthetic */ SetPopularPortraitCallback b;
        public final /* synthetic */ PortraitService c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PortraitService portraitService, Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitService, looper, setPopularPortraitResult, setPopularPortraitCallback};
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
            this.c = portraitService;
            this.a = setPopularPortraitResult;
            this.b = setPopularPortraitCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.setResultCode(i);
                this.b.onFailure(this.a);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.onFinish();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.onStart();
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    this.a.setResultCode(i2);
                    this.a.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        this.b.onSuccess(this.a);
                    } else {
                        this.b.onFailure(this.a);
                    }
                } catch (JSONException e) {
                    this.a.setResultCode(-202);
                    this.b.onFailure(this.a);
                    Log.e(e);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetHistoryPortraitsResult a;
        public final /* synthetic */ GetHistoryPortraitsCallback b;
        public final /* synthetic */ PortraitService c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PortraitService portraitService, Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitService, looper, getHistoryPortraitsResult, getHistoryPortraitsCallback};
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
            this.c = portraitService;
            this.a = getHistoryPortraitsResult;
            this.b = getHistoryPortraitsCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.setResultCode(i);
                this.b.onFailure(this.a);
            }
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    this.a.setResultCode(i2);
                    this.a.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("history");
                        int length = optJSONArray.length();
                        this.a.historyPortraits = new ArrayList(length);
                        for (int i3 = 0; i3 < length; i3++) {
                            this.a.historyPortraits.add(optJSONArray.optString(i3));
                        }
                        this.b.onSuccess(this.a);
                        return;
                    }
                    this.b.onFailure(this.a);
                } catch (JSONException e) {
                    this.a.setResultCode(-202);
                    this.b.onFailure(this.a);
                    Log.e(e);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetPopularPortraitsCallback a;
        public final /* synthetic */ GetPopularPortraitsInfoResult b;
        public final /* synthetic */ PortraitService c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PortraitService portraitService, Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitService, looper, getPopularPortraitsCallback, getPopularPortraitsInfoResult};
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
            this.c = portraitService;
            this.a = getPopularPortraitsCallback;
            this.b = getPopularPortraitsInfoResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.setResultCode(i);
                this.a.onFailure(this.b);
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
                    int optInt = jSONObject.optInt("errno");
                    this.b.setResultCode(optInt);
                    this.b.setResultMsg(jSONObject.optString("errmsg"));
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("list");
                        int length = optJSONArray.length();
                        this.b.popularPortraitsInfoList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                                popularPortraitsInfo.num = optJSONObject.optInt("num");
                                popularPortraitsInfo.serie = optJSONObject.optString("serie");
                                popularPortraitsInfo.url = optJSONObject.optString("url");
                                popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                                popularPortraitsInfo.color = optJSONObject.optString("color");
                                popularPortraitsInfo.category = optJSONObject.optString("category");
                                popularPortraitsInfo.gifUrl = optJSONObject.optString("gifUrl");
                                this.b.popularPortraitsInfoList.add(popularPortraitsInfo);
                            }
                        }
                        this.a.onSuccess(this.b);
                        return;
                    }
                    this.a.onFailure(this.b);
                } catch (JSONException e) {
                    this.b.setResultCode(-202);
                    this.a.onFailure(this.b);
                    Log.e(e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.configuration.environment.getPortraitUrl() + "/sys/history";
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "/v2/sapi/center/setportrait" : (String) invokeV.objValue;
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, getHistoryPortraitsCallback, getHistoryPortraitsDTO) == null) {
            SapiUtils.notNull(getHistoryPortraitsCallback, GetHistoryPortraitsCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notNull(getHistoryPortraitsDTO, "getHistoryPortrats dto can't be null");
            SapiUtils.notEmpty(getHistoryPortraitsDTO.bduss, "bduss can't be empty");
            int i = getHistoryPortraitsDTO.maxNum;
            if (i >= 0 && i <= 10) {
                GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
                httpHashMapWrap.put("bduss", getHistoryPortraitsDTO.bduss);
                new HttpClientWrap().post(a(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new c(this, Looper.getMainLooper(), getHistoryPortraitsResult, getHistoryPortraitsCallback));
                return;
            }
            throw new IllegalArgumentException("abnormal request history number");
        }
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, getPopularPortraitsCallback, str, portraitCategory) == null) {
            SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", str);
            if (portraitCategory != null) {
                httpHashMapWrap.put("category", portraitCategory.getValue());
            }
            new HttpClientWrap().post(b(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new d(this, Looper.getMainLooper(), getPopularPortraitsCallback, getPopularPortraitsInfoResult));
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, setPopularPortraitCallback, setPopularPortraitDTO) == null) {
            SapiUtils.notNull(setPopularPortraitCallback, SetPopularPortraitCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notNull(setPopularPortraitDTO, "SetPopularPortraitDto can't be null");
            SapiUtils.notEmpty(setPopularPortraitDTO.bduss, "bduss can't be empty");
            SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", setPopularPortraitDTO.bduss);
            if (TextUtils.isEmpty(setPopularPortraitDTO.series)) {
                setPopularPortraitDTO.series = "wildkid";
            }
            httpHashMapWrap.put("serie", setPopularPortraitDTO.series);
            httpHashMapWrap.put("num", String.valueOf(setPopularPortraitDTO.num));
            new HttpClientWrap().post(c(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new b(this, Looper.getMainLooper(), setPopularPortraitResult, setPopularPortraitCallback));
        }
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, setPortraitDTO, setPortraitCallback) == null) {
            SapiUtils.notNull(setPortraitDTO, "SetPortraitDTO can't be null");
            SapiUtils.notNull(setPortraitCallback, "SetPortraitCallback can't be null");
            SapiUtils.notEmpty(setPortraitDTO.bduss, "bduss can't be empty");
            byte[] bArr = setPortraitDTO.file;
            if (bArr != null && bArr.length != 0) {
                SetPortraitResult setPortraitResult = new SetPortraitResult();
                MultipartHashMapWrap multipartHashMapWrap = new MultipartHashMapWrap();
                multipartHashMapWrap.put("bduss", setPortraitDTO.bduss);
                multipartHashMapWrap.put("portrait_type", setPortraitDTO.portraitType + "");
                multipartHashMapWrap.put("file", new ByteArrayInputStream(setPortraitDTO.file), "portrait.jpg", TextUtils.isEmpty(setPortraitDTO.contentType) ? "image/jpeg" : setPortraitDTO.contentType);
                new HttpClientWrap().post(d(), ReqPriority.HIGH, multipartHashMapWrap, null, getUaInfo(), new a(this, Looper.getMainLooper(), setPortraitCallback, setPortraitResult));
                return;
            }
            throw new IllegalArgumentException("file can't be empty");
        }
    }
}
