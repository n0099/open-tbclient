package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMFetchConfigMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_COUNT = 50;
    public static final String TAG = "IMFetchConfigMsg";
    public static int cur_count = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mCursor;
    public long mLimit;

    /* loaded from: classes3.dex */
    public class FetchConfigTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public int mErrorCode;
        public JSONObject mObj;
        public String mStrMsg;
        public final /* synthetic */ IMFetchConfigMsg this$0;

        public FetchConfigTask(IMFetchConfigMsg iMFetchConfigMsg, Context context, JSONObject jSONObject, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMFetchConfigMsg, context, jSONObject, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMFetchConfigMsg;
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i2;
            this.mStrMsg = str;
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Type type = new Type();
                type.t = 0L;
                if (this.mErrorCode == 0) {
                    try {
                        long j2 = this.mObj.has(Constants.EXTRA_CONFIG_CURSOR) ? this.mObj.getLong(Constants.EXTRA_CONFIG_CURSOR) : 0L;
                        if (!(this.mObj.has("has_more") ? this.mObj.getBoolean("has_more") : false) || IMFetchConfigMsg.cur_count > 50) {
                            int unused = IMFetchConfigMsg.cur_count = 1;
                            if (j2 > Utility.readLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, 0L)) {
                                Utility.writeLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, j2);
                            }
                        } else {
                            IMFetchConfigMsg.access$008();
                            ChatMsgManagerImpl.getInstance(this.mContext).fetchConfigMsg(this.mContext, j2, this.this$0.mLimit);
                        }
                        if (this.mObj.has(NotificationCompat.CarExtender.KEY_MESSAGES)) {
                            ArrayList<ChatMsg> parserMessage = MessageParser.parserMessage(this.mContext, this.mObj.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES), type, true, false);
                            ChatMsgManagerImpl.getInstance(this.mContext).configMsgsFilter(parserMessage);
                            ChatMsgManagerImpl.getInstance(this.mContext).deliverConfigMessage(parserMessage);
                        }
                    } catch (Exception e2) {
                        LogUtils.e(IMFetchConfigMsg.TAG, "Exception ", e2);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1435479093, "Lcom/baidu/android/imsdk/chatmessage/request/IMFetchConfigMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1435479093, "Lcom/baidu/android/imsdk/chatmessage/request/IMFetchConfigMsg;");
        }
    }

    public IMFetchConfigMsg(Context context, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initCommonParameter(context);
        this.mContext = context;
        this.mCursor = j2;
        this.mLimit = j3;
        setNeedReplay(true);
        setType(193);
    }

    public static /* synthetic */ int access$008() {
        int i2 = cur_count;
        cur_count = i2 + 1;
        return i2;
    }

    public static IMFetchConfigMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_CONFIG_CURSOR) && intent.hasExtra(Constants.EXTRA_CONFIG_LIMIT)) {
                return new IMFetchConfigMsg(context, intent.getLongExtra(Constants.EXTRA_CONFIG_CURSOR, 0L), intent.getLongExtra(Constants.EXTRA_CONFIG_LIMIT, 0L));
            }
            return null;
        }
        return (IMFetchConfigMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 193);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("appid", this.mAppid);
                long readLongData = Utility.readLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, 0L);
                if (this.mCursor > readLongData) {
                    readLongData = this.mCursor;
                }
                this.mCursor = readLongData;
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, readLongData);
                if (this.mLimit < 0 || this.mLimit > 20) {
                    this.mLimit = 20L;
                }
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, this.mLimit);
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i2, str) == null) {
            super.handleMessageResult(context, jSONObject, i2, str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new FetchConfigTask(this, context, jSONObject, i2, str));
        }
    }
}
