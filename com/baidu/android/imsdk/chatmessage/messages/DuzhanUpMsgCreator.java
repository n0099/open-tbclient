package com.baidu.android.imsdk.chatmessage.messages;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes6.dex */
public class DuzhanUpMsgCreator {
    public static /* synthetic */ Interceptable $ic = null;
    public static int REQ_TYPE_BOX = 0;
    public static int REQ_TYPE_CLUE = 3;
    public static int REQ_TYPE_LEMON = 4;
    public static int REQ_TYPE_PA = 1;
    public static final String TAG = "DuzhanUpMsgCreateor";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1029979789, "Lcom/baidu/android/imsdk/chatmessage/messages/DuzhanUpMsgCreator;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1029979789, "Lcom/baidu/android/imsdk/chatmessage/messages/DuzhanUpMsgCreator;");
        }
    }

    public DuzhanUpMsgCreator() {
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

    public static String generateExtJson(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("type", chatMsg.getMsgType());
                jSONObject4.put("content", getMsgExtContent(chatMsg));
                if (chatMsg.getMsgType() == 18) {
                    jSONObject3.put("description", chatMsg.getRecommendDescription());
                } else {
                    jSONObject3.put("description", "");
                }
                jSONObject3.put("ext", jSONObject4);
                jSONObject2.put("time", System.currentTimeMillis() / 1000);
                jSONObject2.put("msg", jSONObject3);
                jSONObject.put("text", jSONObject2.toString());
                str = jSONObject.toString();
                LogUtils.d(TAG, "generateExtJson :" + str);
                return str;
            } catch (Exception e2) {
                LogUtils.e(TAG, "generateExtJson :" + e2);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject getImageContent(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMsg)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(chatMsg.getJsonContent());
                String optString = jSONObject.optString("json");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", optString);
                jSONObject2.put("url", ((ImageMsg) chatMsg).getRemoteUrl());
                jSONObject2.put("thumbnail", ((ImageMsg) chatMsg).getThumbUrl());
                jSONObject2.put("w", ((ImageMsg) chatMsg).getWidth());
                jSONObject2.put("h", ((ImageMsg) chatMsg).getHeight());
                if (jSONObject.has("ext")) {
                    jSONObject2.put("ext", jSONObject.get("ext"));
                }
                return jSONObject2;
            } catch (Exception e2) {
                LogUtils.e(TAG, "create json excepiton " + e2.getMessage());
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject getMsgExtContent(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMsg)) == null) {
            try {
                String jsonContent = chatMsg.getJsonContent();
                if (!TextUtils.isEmpty(jsonContent)) {
                    if (chatMsg.getMsgType() == 1) {
                        return getImageContent(chatMsg);
                    }
                    return new JSONObject(jsonContent);
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "getMsgExtContent :", e2);
            }
            return new JSONObject();
        }
        return (JSONObject) invokeL.objValue;
    }

    public static int getReqType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 == 7) {
                return REQ_TYPE_PA;
            }
            if (i2 == 16) {
                return REQ_TYPE_CLUE;
            }
            if (i2 == 25) {
                return REQ_TYPE_LEMON;
            }
            return REQ_TYPE_BOX;
        }
        return invokeI.intValue;
    }

    public static ChatMsg reCreateChatMsg(int i2, ChatMsg chatMsg) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, chatMsg)) == null) {
            chatMsg.setChatType(i2);
            chatMsg.setExtraContent(generateExtJson(chatMsg));
            return chatMsg;
        }
        return (ChatMsg) invokeIL.objValue;
    }
}
