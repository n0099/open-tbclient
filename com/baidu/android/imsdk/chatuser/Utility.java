package com.baidu.android.imsdk.chatuser;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Utility {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] ZXS_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1828402124, "Lcom/baidu/android/imsdk/chatuser/Utility;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1828402124, "Lcom/baidu/android/imsdk/chatuser/Utility;");
                return;
            }
        }
        ZXS_LIST = new String[]{"北京市", "天津市", "上海市", "重庆市"};
    }

    public Utility() {
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

    public static ChatUser contructChatUser(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            long optLong = jSONObject.optLong("to_user");
            long optLong2 = jSONObject.optLong("baidu_uid");
            String optString = jSONObject.optString("user_name");
            String optString2 = jSONObject.optString("sex");
            String optString3 = jSONObject.optString("tinyurl");
            String optString4 = jSONObject.optString("headurl");
            String optString5 = jSONObject.optString("phone");
            String optString6 = jSONObject.optString("userdetail");
            int optInt = jSONObject.optInt("account_type");
            ChatUser chatUser = new ChatUser(optLong, optLong2, optString, optString4);
            chatUser.setUserDetail(optString6);
            chatUser.setTinyUrl(optString3);
            if (!TextUtils.isEmpty(optString2) && TextUtils.isDigitsOnly(optString2)) {
                try {
                    chatUser.setSex(Integer.valueOf(optString2).intValue());
                } catch (Exception e2) {
                    LogUtils.e("Utility", "contructChatUser sex:", e2);
                }
            }
            if (!TextUtils.isEmpty(optString5) && TextUtils.isDigitsOnly(optString5)) {
                try {
                    chatUser.setPhone(Long.valueOf(optString5).longValue());
                } catch (Exception e3) {
                    LogUtils.e("Utility", "contructChatUser phone:", e3);
                }
            }
            chatUser.setAccountType(optInt);
            return chatUser;
        }
        return (ChatUser) invokeL.objValue;
    }

    public static ChatUser contructChatUserFormUid(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            long optLong = jSONObject.optLong("uk");
            long optLong2 = jSONObject.optLong("baidu_uid");
            String optString = jSONObject.optString("user_name");
            String optString2 = jSONObject.optString("sex");
            String optString3 = jSONObject.optString("tinyurl");
            String optString4 = jSONObject.optString("headurl");
            String optString5 = jSONObject.optString("phone");
            String optString6 = jSONObject.optString("userdetail");
            int optInt = jSONObject.optInt("account_type");
            ChatUser chatUser = new ChatUser(optLong, optLong2, optString, optString4);
            chatUser.setUserDetail(optString6);
            chatUser.setTinyUrl(optString3);
            if (!TextUtils.isEmpty(optString2) && TextUtils.isDigitsOnly(optString2)) {
                try {
                    chatUser.setSex(Integer.valueOf(optString2).intValue());
                } catch (Exception e2) {
                    LogUtils.e("Utility", "contructChatUserFormUid sex:", e2);
                }
            }
            if (!TextUtils.isEmpty(optString5) && TextUtils.isDigitsOnly(optString5)) {
                try {
                    chatUser.setPhone(Long.valueOf(optString5).longValue());
                } catch (Exception e3) {
                    LogUtils.e("Utility", "contructChatUserFormUid phone:", e3);
                }
            }
            chatUser.setAccountType(optInt);
            return chatUser;
        }
        return (ChatUser) invokeL.objValue;
    }

    public static String createAnonyMousUserName(IpInfo ipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, ipInfo)) == null) {
            if (ipInfo == null) {
                return "未知地区客户";
            }
            String str = new String();
            if (!TextUtils.isEmpty(ipInfo.getProv())) {
                if (isZhiXiaShi(ipInfo.getProv())) {
                    return ipInfo.getProv() + "客户";
                }
                str = str + ipInfo.getProv();
            }
            if (!TextUtils.isEmpty(ipInfo.getCity())) {
                str = str + ipInfo.getCity();
            }
            if (TextUtils.isEmpty(str)) {
                str = ipInfo.getCountry();
            }
            if (TextUtils.isEmpty(str)) {
                str = "未知地区";
            }
            return str + "客户";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isZhiXiaShi(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            for (String str2 : ZXS_LIST) {
                if (str2.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
