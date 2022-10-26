package com.baidu.sapi2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenBdussService extends AbstractService implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenBdussService(SapiConfiguration sapiConfiguration, String str) {
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
        this.context = sapiConfiguration.context;
    }

    public int getBdussState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String cookieBduss = SapiUtils.getCookieBduss();
            if (currentAccount == null && TextUtils.isEmpty(cookieBduss)) {
                return 1;
            }
            if (currentAccount == null && !TextUtils.isEmpty(cookieBduss)) {
                return 2;
            }
            if (currentAccount != null && TextUtils.isEmpty(cookieBduss)) {
                return 3;
            }
            if (currentAccount != null && !cookieBduss.equals(currentAccount.bduss)) {
                return 4;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1 A[LOOP:1: B:34:0x00d9->B:36:0x00e1, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        Map map;
        HttpHashMapWrap httpHashMapWrap;
        List list;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getOpenBdussDTO, getOpenBdussCallback) == null) {
            SapiUtils.notNull(getOpenBdussCallback, "GetOpenBdussCallback can't be null");
            SapiUtils.notNull(getOpenBdussDTO, "GetOpenBdussDTO can't be null");
            SapiUtils.notEmpty(getOpenBdussDTO.clientId, "GetOpenBdussDTO.clientId can't empty");
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                SapiResult openBdussResult = new OpenBdussResult();
                openBdussResult.setResultCode(-901);
                getOpenBdussCallback.onFailure(openBdussResult);
                return;
            }
            OpenBdussResult fromJson = OpenBdussResult.fromJson(SapiContext.getInstance().getDecryptStr(SapiContext.KEY_OPEN_BDUSS_INFO));
            if (fromJson != null && fromJson.getResultCode() == 0) {
                if (SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false).equals(fromJson.flag)) {
                    Iterator it = getOpenBdussDTO.targetTplList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!fromJson.tplStokenMap.containsKey((String) it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fromJson.flag = "";
                        getOpenBdussCallback.onSuccess(fromJson);
                        return;
                    }
                    httpHashMapWrap = new HttpHashMapWrap();
                    httpHashMapWrap.put("client_id", getOpenBdussDTO.clientId);
                    httpHashMapWrap.put("bduss", currentAccount.bduss);
                    httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, currentAccount.ptoken);
                    httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_OPEN_BDUSS));
                    list = getOpenBdussDTO.targetTplList;
                    if (list != null && list.size() > 0) {
                        String str = (String) getOpenBdussDTO.targetTplList.get(0);
                        for (int i = 1; i < getOpenBdussDTO.targetTplList.size(); i++) {
                            str = str + "|" + ((String) getOpenBdussDTO.targetTplList.get(i));
                        }
                        httpHashMapWrap.put("tpl_list", str);
                    }
                    new HttpClientWrap().post(SapiEnv.GET_OPEN_BDUSS, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), getOpenBdussCallback, currentAccount, getOpenBdussDTO, fromJson) { // from class: com.baidu.sapi2.OpenBdussService.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ OpenBdussService this$0;
                        public final /* synthetic */ GetOpenBdussCallback val$callback;
                        public final /* synthetic */ GetOpenBdussDTO val$dto;
                        public final /* synthetic */ OpenBdussResult val$historyOpenBdussResult;
                        public final /* synthetic */ SapiAccount val$sapiAccount;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r8, getOpenBdussCallback, currentAccount, getOpenBdussDTO, fromJson};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((Looper) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callback = getOpenBdussCallback;
                            this.val$sapiAccount = currentAccount;
                            this.val$dto = getOpenBdussDTO;
                            this.val$historyOpenBdussResult = fromJson;
                        }

                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onFailure(Throwable th, int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str2) == null) {
                                OpenBdussResult openBdussResult2 = new OpenBdussResult();
                                openBdussResult2.setResultCode(i2);
                                this.val$callback.onFailure(openBdussResult2);
                            }
                        }

                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.val$callback.onFinish();
                            }
                        }

                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                this.val$callback.onStart();
                            }
                        }

                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onSuccess(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i2, str2) == null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str2);
                                    if (!TextUtils.isEmpty(jSONObject.optString("uid"))) {
                                        jSONObject.put("bduss", this.val$sapiAccount.bduss);
                                    }
                                    jSONObject.put("flag", SecurityUtil.md5((this.val$sapiAccount.bduss + this.val$dto.clientId).getBytes(), false));
                                    jSONObject.put("displayname", this.val$sapiAccount.displayname);
                                    OpenBdussResult fromJson2 = OpenBdussResult.fromJson(jSONObject.toString());
                                    if (fromJson2 != null && fromJson2.getResultCode() == 0) {
                                        OpenBdussResult openBdussResult2 = this.val$historyOpenBdussResult;
                                        if (openBdussResult2 != null && openBdussResult2.tplStokenMap.size() > 0) {
                                            fromJson2.tplStokenMap.putAll(this.val$historyOpenBdussResult.tplStokenMap);
                                        }
                                        SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, fromJson2.toJson().toString());
                                        fromJson2.flag = "";
                                        this.val$callback.onSuccess(fromJson2);
                                        return;
                                    }
                                    this.val$callback.onFailure(fromJson2);
                                } catch (Exception e) {
                                    Log.e(e);
                                    OpenBdussResult openBdussResult3 = new OpenBdussResult();
                                    openBdussResult3.setResultCode(-202);
                                    this.val$callback.onFailure(openBdussResult3);
                                }
                            }
                        }
                    });
                }
            }
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
            if (fromJson != null && (map = fromJson.tplStokenMap) != null) {
                map.clear();
            }
            httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("client_id", getOpenBdussDTO.clientId);
            httpHashMapWrap.put("bduss", currentAccount.bduss);
            httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, currentAccount.ptoken);
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_OPEN_BDUSS));
            list = getOpenBdussDTO.targetTplList;
            if (list != null) {
                String str2 = (String) getOpenBdussDTO.targetTplList.get(0);
                while (i < getOpenBdussDTO.targetTplList.size()) {
                }
                httpHashMapWrap.put("tpl_list", str2);
            }
            new HttpClientWrap().post(SapiEnv.GET_OPEN_BDUSS, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), getOpenBdussCallback, currentAccount, getOpenBdussDTO, fromJson) { // from class: com.baidu.sapi2.OpenBdussService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OpenBdussService this$0;
                public final /* synthetic */ GetOpenBdussCallback val$callback;
                public final /* synthetic */ GetOpenBdussDTO val$dto;
                public final /* synthetic */ OpenBdussResult val$historyOpenBdussResult;
                public final /* synthetic */ SapiAccount val$sapiAccount;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, r8, getOpenBdussCallback, currentAccount, getOpenBdussDTO, fromJson};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = getOpenBdussCallback;
                    this.val$sapiAccount = currentAccount;
                    this.val$dto = getOpenBdussDTO;
                    this.val$historyOpenBdussResult = fromJson;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i2, String str22) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str22) == null) {
                        OpenBdussResult openBdussResult2 = new OpenBdussResult();
                        openBdussResult2.setResultCode(i2);
                        this.val$callback.onFailure(openBdussResult2);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i2, String str22) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i2, str22) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str22);
                            if (!TextUtils.isEmpty(jSONObject.optString("uid"))) {
                                jSONObject.put("bduss", this.val$sapiAccount.bduss);
                            }
                            jSONObject.put("flag", SecurityUtil.md5((this.val$sapiAccount.bduss + this.val$dto.clientId).getBytes(), false));
                            jSONObject.put("displayname", this.val$sapiAccount.displayname);
                            OpenBdussResult fromJson2 = OpenBdussResult.fromJson(jSONObject.toString());
                            if (fromJson2 != null && fromJson2.getResultCode() == 0) {
                                OpenBdussResult openBdussResult2 = this.val$historyOpenBdussResult;
                                if (openBdussResult2 != null && openBdussResult2.tplStokenMap.size() > 0) {
                                    fromJson2.tplStokenMap.putAll(this.val$historyOpenBdussResult.tplStokenMap);
                                }
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, fromJson2.toJson().toString());
                                fromJson2.flag = "";
                                this.val$callback.onSuccess(fromJson2);
                                return;
                            }
                            this.val$callback.onFailure(fromJson2);
                        } catch (Exception e) {
                            Log.e(e);
                            OpenBdussResult openBdussResult3 = new OpenBdussResult();
                            openBdussResult3.setResultCode(-202);
                            this.val$callback.onFailure(openBdussResult3);
                        }
                    }
                }
            });
        }
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable(this) { // from class: com.baidu.sapi2.OpenBdussService.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OpenBdussService this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (String str : SapiContext.getInstance().getOpenBdussDomains()) {
                                arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str, SapiUtils.buildBDUSSCookie(str, "OPENBDUSS", "")));
                            }
                            SapiUtils.syncCookies(this.this$0.context, arrayList);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            }));
        }
    }
}
