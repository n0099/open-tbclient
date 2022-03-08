package com.baidu.android.imsdk.internal;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class NotifyMessageHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NotifyMessageHandler";
    public transient /* synthetic */ FieldHolder $fh;

    public NotifyMessageHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Long] */
    public static void handleConfigMessage(Context context, JSONObject jSONObject) throws JSONException {
        ArrayList<ChatMsg> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, jSONObject) == null) {
            LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
            JSONArray jSONArray = new JSONArray();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                arrayList = null;
            }
            if (jSONArray.length() == 0) {
                return;
            }
            Type type = new Type();
            type.t = 0L;
            arrayList = MessageParser.parserMessage(context, jSONArray, type, true, true);
            ChatMsgManagerImpl.getInstance(context).persisConfigMsgIds(arrayList);
            ChatMsgManagerImpl.getInstance(context).deliverConfigMessage(arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDeliverMessage(Context context, JSONObject jSONObject) throws JSONException {
        long j2;
        SyncStrategy generate;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65538, null, context, jSONObject) != null) {
            return;
        }
        LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
        int i2 = jSONObject.getInt("category");
        if (i2 == 0 && jSONObject.has("msgid")) {
            try {
                j2 = jSONObject.getLong("msgid");
            } catch (JSONException e2) {
                LogUtils.i(TAG, "JSONException:" + e2.getMessage());
            }
            if (i2 != 0 || i2 == 2) {
                generate = Generator.generate(context, 5);
                if (generate == null) {
                    if (j2 != -1) {
                        generate.start(2, j2);
                        return;
                    } else {
                        generate.start(2);
                        return;
                    }
                }
                return;
            } else if (i2 == 1) {
                long j3 = jSONObject.getLong("contacter");
                long j4 = jSONObject.getLong("msgid");
                LogUtils.i(TAG, "msgid : " + j4);
                SyncGroupMessageService.getInstance().execute(context, i2, j3, j4, 2);
                Utility.transformGroupMediaNotify(context, i2, j3, 2, -1L);
                return;
            } else {
                LogUtils.e(TAG, "handleDeliverMessage category error!!");
                return;
            }
        }
        j2 = -1;
        if (i2 != 0) {
        }
        generate = Generator.generate(context, 5);
        if (generate == null) {
        }
    }

    public static void handleMcastMessage(Context context, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) {
            LogUtils.i(TAG, "handleMessage mcast:" + jSONObject.toString());
            if (jSONObject.has("mcast_id")) {
                jSONObject.getLong("mcast_id");
            } else {
                LogUtils.e(TAG, "handleMcastMessage cast error!!");
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, jSONObject) { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ JSONObject val$msgObj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$msgObj = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ConversationStudioManImpl.getInstance(this.val$context).handleMessage(this.val$msgObj);
                    }
                }
            });
        }
    }

    public static void handleMediaNotifyMessage(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
            ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
        }
    }

    public static void handleRtcNotifyMessage(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, jSONObject) == null) {
            handleRtcReport("notify", jSONObject == null ? "msgobj == null" : jSONObject.toString());
            if (context != null && jSONObject != null) {
                try {
                    LogUtils.i(TAG, "handleRtcNotifyMessage context ！= null && msgobj ！= null ");
                    Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
                    cls.getMethod("notifyParse", JSONObject.class).invoke(cls, jSONObject);
                    return;
                } catch (Throwable th) {
                    LogUtils.e(TAG, "handleRtcNotifyMessage ClassNotFoundException BIMRtcManager...", th);
                    handleRtcReport("notify", "exception :" + th.getMessage());
                    return;
                }
            }
            LogUtils.i(TAG, "handleRtcNotifyMessage context == null || msgobj == null ");
        }
    }

    public static void handleRtcReport(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            try {
                LogUtils.i(TAG, "handleRtcReport " + str + ", ext :" + str2);
                Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
                Method method = cls.getMethod("imRtcReport", String.class, String.class);
                method.invoke(cls, "im rtc_report " + str, str2);
            } catch (Throwable th) {
                LogUtils.e(TAG, "handleRtcReport ClassNotFoundException BIMRtcManager...", th);
            }
        }
    }
}
