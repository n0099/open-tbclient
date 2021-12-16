package c.a.s0.s1.m;

import androidx.collection.LongSparseArray;
import c.a.d.c.f.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
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

    public final void c(GroupMsgData groupMsgData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, groupMsgData) == null) || groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.c.f.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, socketResponsedMessage)) == null) {
            MessageSyncMessage messageSyncMessage = null;
            if (socketResponsedMessage instanceof ResponsePullMessage) {
                if (socketResponsedMessage.getOrginalMessage() != null && (socketResponsedMessage.getOrginalMessage() instanceof MessageSyncMessage)) {
                    messageSyncMessage = (MessageSyncMessage) socketResponsedMessage.getOrginalMessage();
                }
                if (messageSyncMessage != null) {
                    c.a.r0.s.c0.a.a("im", messageSyncMessage.getClientLogID(), messageSyncMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
                }
                if (socketResponsedMessage.getError() == 110000) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
                }
                ResponsePullMessage responsePullMessage = (ResponsePullMessage) socketResponsedMessage;
                List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
                if (groupMsg != null && groupMsg.size() > 0) {
                    for (GroupMsgData groupMsgData : groupMsg) {
                        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                            c(groupMsgData);
                        }
                    }
                }
                if (!e(responsePullMessage)) {
                    b.l().n();
                }
                return socketResponsedMessage;
            }
            return null;
        }
        return (SocketResponsedMessage) invokeL.objValue;
    }

    public final boolean e(ResponsePullMessage responsePullMessage) {
        InterceptResult invokeL;
        Long l;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responsePullMessage)) == null) {
            if (responsePullMessage != null && responsePullMessage.getGroupMsg() != null && responsePullMessage.getGroupMsg().size() != 0 && !responsePullMessage.hasError()) {
                List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
                if (!(responsePullMessage.getOrginalMessage() instanceof MessageSyncMessage)) {
                    return false;
                }
                MessageSyncMessage messageSyncMessage = (MessageSyncMessage) responsePullMessage.getOrginalMessage();
                if (messageSyncMessage.getGroupMids() != null && messageSyncMessage.getGroupMids().size() != 0) {
                    LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
                    LongSparseArray<Long> r = c.a.s0.s1.k.b.o().r();
                    boolean z = false;
                    for (GroupMsgData groupMsgData : groupMsg) {
                        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && c.a.s0.s1.k.c.a(groupMsgData.getGroupInfo().getCustomType()) && (l = r.get(groupMsgData.getGroupInfo().getGroupId())) != null && (l2 = messageSyncMessage.getGroupMids().get(groupMsgData.getGroupInfo().getGroupId())) != null) {
                            if (l.longValue() > l2.longValue()) {
                                z = true;
                            }
                            if (groupMsgData.hasMore()) {
                                longSparseArray.put(groupMsgData.getGroupInfo().getGroupId(), l);
                            }
                        }
                    }
                    if (z && longSparseArray.size() > 0) {
                        b.l().q(longSparseArray);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
