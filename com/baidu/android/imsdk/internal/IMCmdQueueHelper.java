package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class IMCmdQueueHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMCmdQueueHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public IMCmdQueueHelper() {
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

    public static Message getFirstIdleCmdQueueMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                CmdQueueMsg cmdQueueMsg = DBManager.getInstance(context).getCmdQueueMsg(0);
                if (cmdQueueMsg == null) {
                    return null;
                }
                return MessageFactory.getInstance().parseMessage(context, cmdQueueMsg.getMethodId(), cmdQueueMsg.getUuid(), cmdQueueMsg.getBody(), cmdQueueMsg.getExtra());
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "getFirstIdleCmdQueueMsg:", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
