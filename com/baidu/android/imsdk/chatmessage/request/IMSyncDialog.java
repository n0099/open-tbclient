package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMSyncDialog extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mMaxMsgid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-663570035, "Lcom/baidu/android/imsdk/chatmessage/request/IMSyncDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-663570035, "Lcom/baidu/android/imsdk/chatmessage/request/IMSyncDialog;");
                return;
            }
        }
        TAG = IMDelMsg.class.getSimpleName();
    }

    public IMSyncDialog(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxMsgid = 0L;
        this.mContext = context;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(94);
        this.mMaxMsgid = j2;
    }

    public static IMSyncDialog newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) ? new IMSyncDialog(context, intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, 0L)) : (IMSyncDialog) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 94);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("msgid", this.mMaxMsgid);
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, e2.getMessage(), e2);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i2, str) == null) {
            ArrayList arrayList = new ArrayList();
            long j2 = -1;
            if (i2 == 0 && jSONObject != null) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("dialogue");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        long j3 = jSONObject2.getLong("contacter");
                        int i4 = jSONObject2.getInt("category");
                        long j4 = jSONObject2.getJSONObject(TableDefine.SessionColumns.COLUMN_LAST_MSG).getLong("msgid");
                        DialogRecord dialogRecord = new DialogRecord();
                        dialogRecord.setCategory(i4);
                        dialogRecord.setContacter(j3);
                        dialogRecord.setDialogueMsgid(j4);
                        arrayList.add(dialogRecord);
                        if (j2 < j4) {
                            j2 = j4;
                        }
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "handle IMSyncMsg exception :", e2);
                }
            }
            super.handleMessageResult(context, jSONObject, i2, str);
            ChatSessionManagerImpl.getInstance(this.mContext).onSyncDialogResult(i2, str, getListenerKey(), j2, arrayList);
        }
    }
}
