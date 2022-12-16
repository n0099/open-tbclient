package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IMCmdQueueHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMCmdQueueHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public IMCmdQueueHelper() {
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

    public static List<NewAckMessage> getAckCmdQueueMsgs(Context context) {
        InterceptResult invokeL;
        List<CmdQueueMsg> cmdQueueMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                cmdQueueMsg = DBManager.getInstance(context).getCmdQueueMsg(95, 0);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "getAckCmdQueueMsg:", e);
            }
            if (cmdQueueMsg != null && cmdQueueMsg.size() > 0) {
                for (CmdQueueMsg cmdQueueMsg2 : cmdQueueMsg) {
                    arrayList.add(NewAckMessage.parseBody(context, cmdQueueMsg2.getUuid(), cmdQueueMsg2.getBody(), cmdQueueMsg2.getExtra()));
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
