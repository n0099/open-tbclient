package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FaceLoginService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FACE_SHARE_V2_MAX_ACCOUNT_SIZE = 10;
    public static final String KEY_FACE_LOGIN_LIVINGUNAMES = "livingunames";
    public static final String KEY_SHARE_FACE_LOGIN_V2 = "face_login_model_v2";
    public static final String TAG = "FaceLoginService";
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1194464510, "Lcom/baidu/sapi2/share/face/FaceLoginService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1194464510, "Lcom/baidu/sapi2/share/face/FaceLoginService;");
        }
    }

    public FaceLoginService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = SapiAccountManager.getInstance().getConfignation().context;
    }

    private String buildV2FaceUidString(Map<String, Long> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_FACE_LOGIN_LIVINGUNAMES, SapiUtils.map2JsonArray(map, "livinguname", "time"));
                return jSONObject.toString();
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private Map<String, Long> getLinkedHashMap(List<FaceLoginModel> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list != null && !list.isEmpty()) {
                Collections.sort(list);
                for (FaceLoginModel faceLoginModel : list) {
                    if (!linkedHashMap.containsKey(faceLoginModel.livingUname)) {
                        linkedHashMap.put(faceLoginModel.livingUname, Long.valueOf(faceLoginModel.time));
                    }
                }
                if (linkedHashMap.size() > 10) {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    int size = linkedHashMap.size() - 10;
                    for (int i2 = 0; it.hasNext() && i2 < size; i2++) {
                        it.next();
                        it.remove();
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    private List<FaceLoginModel> getUidsFromV2ShareStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (SapiContext.getInstance().shareLivingunameEnable()) {
                List<Intent> queryShareActivitys = ShareUtils.queryShareActivitys(this.context);
                if (queryShareActivitys.isEmpty()) {
                    return arrayList;
                }
                ShareStorage shareStorage = new ShareStorage();
                for (Intent intent : queryShareActivitys) {
                    arrayList.addAll(str2ShareModelV2List(shareStorage.getSp(intent.getComponent().getPackageName(), KEY_SHARE_FACE_LOGIN_V2)));
                }
                arrayList.addAll(str2ShareModelV2List(shareStorage.getSd(SecurityUtil.md5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false))));
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private List<FaceLoginModel> getUidsMapFromV2PriStrage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? str2ShareModelV2List(SapiContext.getInstance().getV2FaceLivingUnames()) : (List) invokeV.objValue;
    }

    private void setV2ShareFaceUids(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            if (SapiContext.getInstance().getShareCommonStorageEnabel() && !TextUtils.isEmpty(str) && SapiContext.getInstance().shareLivingunameEnable()) {
                ShareStorage shareStorage = new ShareStorage();
                shareStorage.setSp(KEY_SHARE_FACE_LOGIN_V2, str);
                shareStorage.setSd(SecurityUtil.md5(KEY_SHARE_FACE_LOGIN_V2.getBytes(), false), str);
                return;
            }
            Log.i(TAG, "setV2ShareFaceUids false");
        }
    }

    public boolean isSupFaceLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject v2FaceLoginCheckResults = SapiContext.getInstance().getV2FaceLoginCheckResults();
            return v2FaceLoginCheckResults != null && v2FaceLoginCheckResults.has("list") && v2FaceLoginCheckResults.optJSONArray("list").length() > 0 && SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        }
        return invokeV.booleanValue;
    }

    public List<FaceLoginModel> str2ShareModelV2List(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_FACE_LOGIN_LIVINGUNAMES);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        String optString = optJSONObject.optString("livinguname");
                        long optLong = optJSONObject.optLong("time", 0L);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(new FaceLoginModel(optString, optLong));
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void syncFaceLoginUID(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            ArrayList arrayList = new ArrayList(1);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new FaceLoginModel(str, System.currentTimeMillis()));
            }
            syncFaceLoginUidList(context, arrayList);
        }
    }

    public void syncFaceLoginUidList(Context context, List<FaceLoginModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.addAll(getUidsMapFromV2PriStrage());
            arrayList.addAll(getUidsFromV2ShareStorage());
            Map<String, Long> linkedHashMap = getLinkedHashMap(arrayList);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (String str : linkedHashMap.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("livinguname", str);
                    jSONObject2.put("time", linkedHashMap.get(str));
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("list", jSONArray);
            } catch (JSONException e2) {
                Log.i(e2);
            }
            String buildV2FaceUidString = buildV2FaceUidString(linkedHashMap);
            setV2ShareFaceUids(buildV2FaceUidString);
            SapiContext.getInstance().setV2FaceLivingunames(buildV2FaceUidString);
            SapiContext.getInstance().setV2FaceLoginCheckResults(jSONObject.toString());
        }
    }
}
