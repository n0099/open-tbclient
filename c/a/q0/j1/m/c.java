package c.a.q0.j1.m;

import androidx.collection.LongSparseArray;
import c.a.e.c.f.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super(202003);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // c.a.e.c.f.f
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        process2(socketMessage2, socketMessageTask);
        return socketMessage2;
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public SocketMessage process2(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (socketMessage instanceof MessageSyncMessage) {
                MessageSyncMessage messageSyncMessage = (MessageSyncMessage) socketMessage;
                LongSparseArray<Long> groupMids = messageSyncMessage.getGroupMids();
                for (int i2 = 0; i2 < groupMids.size(); i2++) {
                    sb.append(groupMids.keyAt(i2));
                    sb.append("-");
                    sb.append(groupMids.valueAt(i2));
                    sb.append("|");
                }
                c.a.p0.s.z.a.a("im", socketMessage.getClientLogID(), 202003, "sendMsg", 0, null, "reason", "pull" + messageSyncMessage.getSyncTypeString(), "comment", sb.toString());
            }
            return socketMessage;
        }
        return (SocketMessage) invokeLL.objValue;
    }
}
