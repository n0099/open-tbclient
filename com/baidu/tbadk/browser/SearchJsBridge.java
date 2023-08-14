package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.gca;
import com.baidu.tieba.kca;
import com.baidu.tieba.ko;
import com.baidu.tieba.kw5;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pv5;
import com.baidu.tieba.sca;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ko
/* loaded from: classes4.dex */
public class SearchJsBridge implements gca {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDUID = "baiduid";
    public static final String CLIENT_VERSION = "_client_version";
    public static final String COOKIE_CFROM = "cfrom";
    public static final String COOKIE_FROM = "from";
    public static final String COOKIE_IMEI = "imei";
    public static final String COOKIE_MERCATOR_CITY = "mercator_city";
    public static final String COOKIE_MERCATOR_LAT = "mercator_lat";
    public static final String COOKIE_MERCATOR_LON = "mercator_lon";
    public static final String COOKIE_MERCATOR_RADIUS = "mercator_radius";
    public static final String COOKIE_MERCATOR_TIME = "mercator_time";
    public static final String COOKIE_MOD = "mod";
    public static final String COOKIE_NET_TYPE = "net_type";
    public static final String COOKIE_OS_TYPE = "os_type";
    public static final String COOKIE_OV = "ov";
    public static final String CUID = "CUID";
    public static final String CUID_GALAXY2 = "cuid_galaxy2";
    public static final String GET_SEARCH_AD_COOKIE = "getSearchAdCookie";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_DELETE_ALL_SEARCH_HISTORY = "deleteAllSearchHistory";
    public static final String METHOD_DELETE_SEARCH_HISTORY = "deleteSearchHistory";
    public static final String METHOD_GET_SEARCH_HISTORY = "getSearchHistory";
    public static final String METHOD_OPEN_SEACH_PAGE = "openSearchPage";
    public static final String METHOD_SET_SEARCH_HISTORY = "setSearchHistory";
    public static final String SHOUBAI_CUID = "shoubai_cuid";
    public static final String SUCCESS_CODE = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mHistoryDatas;

    /* loaded from: classes4.dex */
    public class a extends kw5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(SearchJsBridge searchJsBridge, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchJsBridge, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kw5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                sca.h(this.a);
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pv5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(SearchJsBridge searchJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pv5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921557, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends kw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(SearchJsBridge searchJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kw5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                sca.b();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements pv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchJsBridge a;

        public d(SearchJsBridge searchJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchJsBridge;
        }

        @Override // com.baidu.tieba.pv5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921558));
                if (this.a.mHistoryDatas != null) {
                    this.a.mHistoryDatas.clear();
                }
            }
        }
    }

    public SearchJsBridge() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHistoryDatas = new ArrayList();
    }

    public kca deleteAllSearchHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            kca kcaVar = new kca();
            ow5.b(new c(this), new d(this));
            return kcaVar;
        }
        return (kca) invokeV.objValue;
    }

    public kca getSearchAdCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            kca kcaVar = new kca();
            kcaVar.o(initCookies());
            return kcaVar;
        }
        return (kca) invokeV.objValue;
    }

    public SearchJsBridge(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHistoryDatas = new ArrayList();
        this.mHistoryDatas = list;
    }

    public kca deleteSearchHistory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            kca kcaVar = new kca();
            ow5.b(new a(this, str), new b(this));
            return kcaVar;
        }
        return (kca) invokeL.objValue;
    }

    public void setHistoryDatas(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.mHistoryDatas = list;
        }
    }

    private void addCookie(JSONObject jSONObject, String str, String str2) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, jSONObject, str, str2) == null) {
            jSONObject.put(str, str2);
        }
    }

    private String initCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                MercatorModel.MercatorData e = MercatorModel.d().e();
                if (e != null) {
                    addCookie(jSONObject, COOKIE_MERCATOR_LAT, e.Q());
                    addCookie(jSONObject, COOKIE_MERCATOR_LON, e.R());
                    addCookie(jSONObject, COOKIE_MERCATOR_CITY, String.valueOf(e.N()));
                    addCookie(jSONObject, COOKIE_MERCATOR_RADIUS, e.T());
                    addCookie(jSONObject, COOKIE_MERCATOR_TIME, String.valueOf(e.U()));
                }
                addCookie(jSONObject, COOKIE_MOD, DeviceInfoHelper.getModel());
                addCookie(jSONObject, "ov", DeviceInfoHelper.getOsVersion());
                addCookie(jSONObject, "os_type", String.valueOf(2));
                addCookie(jSONObject, "net_type", String.valueOf(BdNetTypeUtil.netType()));
                addCookie(jSONObject, "imei", TbadkCoreApplication.getInst().getImei());
                addCookie(jSONObject, "from", TbConfig.getFrom());
                addCookie(jSONObject, "cfrom", TbConfig.getCurrentFrom());
                addCookie(jSONObject, "_client_version", TbConfig.getVersion());
                addCookie(jSONObject, "CUID", TbadkCoreApplication.getInst().getCuid());
                String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
                addCookie(jSONObject, "shoubai_cuid", cuidGalaxy2);
                addCookie(jSONObject, "cuid_galaxy2", cuidGalaxy2);
                if (!TextUtils.isEmpty(cuidGalaxy2)) {
                    addCookie(jSONObject, "baiduid", new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gca
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
            if (!"CommonJSBridge".equals(str)) {
                return false;
            }
            if (METHOD_GET_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(getSearchHistoryJson().a());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
                return true;
            } else if (METHOD_DELETE_SEARCH_HISTORY.equals(str2)) {
                try {
                    jsPromptResult.confirm(deleteSearchHistory(new JSONObject(str3).optString("query")).a());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            } else if (METHOD_DELETE_ALL_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(deleteAllSearchHistory().a());
                return true;
            } else if (METHOD_OPEN_SEACH_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(openSearchPage(jSONObject.optString("query"), jSONObject.optInt("sub_type")).a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return true;
            } else if (!GET_SEARCH_AD_COOKIE.equals(str2)) {
                return false;
            } else {
                jsPromptResult.confirm(getSearchAdCookie().a());
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public kca getSearchHistoryJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            kca kcaVar = new kca();
            int count = ListUtils.getCount(this.mHistoryDatas);
            if (count == 0) {
                kcaVar.o("");
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < count; i++) {
                jSONArray.put(this.mHistoryDatas.get(i));
            }
            kcaVar.o(jSONArray.toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
            return kcaVar;
        }
        return (kca) invokeV.objValue;
    }

    public kca openSearchPage(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("query", str);
                jSONObject.put(AdvisoryMsgBusinessExtra.SUBTYPE_KEY, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921559, jSONObject.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return kcaVar;
        }
        return (kca) invokeLI.objValue;
    }
}
