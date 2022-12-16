package com.baidu.tbadk.core.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GroupChatEntranceStatisticUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FEED_GROUP_CHAT_CARD_CLICK = 6;
    public static final int FEED_GROUP_CHAT_LINK_CLICK = 13;
    public static final String FORUM_ID = "forumId";
    public static final int FRS_DIALOG_GROUP_CHAT_CLICK = 2;
    public static final String PARAM_URL = "url";
    public static final int PB_GROUP_CHAT_CARD_CLICK = 5;
    public static final int PB_GROUP_CHAT_LINK_CLICK = 4;
    public static final String ROOM_ID = "roomId";
    public transient /* synthetic */ FieldHolder $fh;

    public GroupChatEntranceStatisticUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final String getForumIdByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return getForumIdByUrl(str, true);
        }
        return (String) invokeL.objValue;
    }

    public static String getRoomIdByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return getRoomIdByUrl(str, true);
        }
        return (String) invokeL.objValue;
    }

    public static final String getForumIdByUrl(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            if (z) {
                try {
                    str2 = URLDecoder.decode(str, IMAudioTransRequest.CHARSET);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    str2 = null;
                }
            } else {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return getParamByParamName(str, "forumId");
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public static final String getRoomIdByUrl(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            if (z) {
                try {
                    str2 = URLDecoder.decode(str, IMAudioTransRequest.CHARSET);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    str2 = null;
                }
            } else {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return getParamByParamName(str, "roomId");
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getParamByParamName(String str, String str2) {
        JSONObject jSONObject;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                jSONObject = new JSONObject(Uri.parse(URLDecoder.decode(Uri.parse(str).getQueryParameter("url"), IMAudioTransRequest.CHARSET)).getQueryParameter("params"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                jSONObject = null;
                if (jSONObject == null) {
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
                if (jSONObject == null) {
                }
            }
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.optJSONObject("pageParams").optString(str2);
        }
        return (String) invokeLL.objValue;
    }
}
