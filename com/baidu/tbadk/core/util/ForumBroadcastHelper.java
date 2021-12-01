package com.baidu.tbadk.core.util;

import android.content.Context;
import c.a.d.f.p.a;
import c.a.r0.t3.j0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class ForumBroadcastHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PARMARS_BCAST_CONTENT = "content";
    public static final String KEY_PARMARS_BCAST_FROM = "from";
    public static final String KEY_PARMARS_BCAST_ID = "broadcastID";
    public static final String KEY_PARMARS_BCAST_IMAGE = "image";
    public static final String KEY_PARMARS_BCAST_OBJ_SOURCE = "obj_source";
    public static final String KEY_PARMARS_BCAST_THREADLINK = "threadLink";
    public static final String KEY_PARMARS_BCAST_TITLE = "title";
    public static final String KEY_PARMARS_FORUM_ID = "forumID";
    public static final String KEY_PARMARS_FORUM_NAME = "forumName";
    public static final String KEY_PARMARS_THREAD_ID = "threadID";
    public static final String VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS = "broadcast_publish_success";
    public static final String VALUE_PARMARS_BCAST_FROM_EDIT = "failed_broadcast";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public HashMap<String, Object> params;

    public ForumBroadcastHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new HashMap<>();
        this.mContext = context;
    }

    public void clipCopy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a.a("http://tieba.baidu.com/p/" + str + "?share=9105&fr=share");
        }
    }

    public void jumpFlutterEditGenear(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.params.put(KEY_PARMARS_FORUM_ID, str);
            this.params.put("forumName", str2);
        }
    }

    public void jumpFlutterEditRelease(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9}) == null) {
            this.params.put(KEY_PARMARS_BCAST_ID, str);
            this.params.put("forumName", str2);
            this.params.put(KEY_PARMARS_FORUM_ID, str3);
            this.params.put(KEY_PARMARS_THREAD_ID, str4);
            this.params.put("title", str5);
            this.params.put("content", str6);
            this.params.put("image", str7);
            this.params.put("from", str8);
            this.params.put("obj_source", str9);
            HashMap<String, Object> hashMap = this.params;
            hashMap.put(KEY_PARMARS_BCAST_THREADLINK, "http://tieba.baidu.com/p/" + str4 + "?share=9105&fr=share");
        }
    }

    public void sendClipBoardMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921472, UtilHelper.getClipBoardContent()));
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.params.put("swipeback", Boolean.FALSE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.mContext, "BarBroadcastEdit", this.params)));
        }
    }

    public void jumpFlutterEditGenear(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            this.params.put(KEY_PARMARS_FORUM_ID, str);
            this.params.put("forumName", str2);
            this.params.put("obj_source", str3);
        }
    }
}
