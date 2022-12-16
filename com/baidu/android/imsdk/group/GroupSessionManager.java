package com.baidu.android.imsdk.group;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupSessionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_GROUP_APPLY_COUNT = "join_group_apply_count";
    public static final String TAG = "GroupSessionManager";
    public transient /* synthetic */ FieldHolder $fh;

    public GroupSessionManager() {
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

    public static int getGroupApplyCount(ChatSession chatSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, chatSession)) == null) {
            if (chatSession != null) {
                String ext = chatSession.getExt();
                if (!TextUtils.isEmpty(ext)) {
                    try {
                        return new JSONObject(ext).optInt(KEY_GROUP_APPLY_COUNT, 0);
                    } catch (JSONException e) {
                        LogUtils.e(TAG, "getGroupApplyCount failed:", e);
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
