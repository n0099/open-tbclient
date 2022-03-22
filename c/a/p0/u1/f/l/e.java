package c.a.p0.u1.f.l;

import android.text.TextUtils;
import c.a.p0.u1.f.l.a;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.a.p0.u1.f.l.a.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(0) && str.equals(ChatStatusManager.getInst().getCurId(0));
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements a.InterfaceC1410a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // c.a.p0.u1.f.l.a.InterfaceC1410a
        public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMessage, imMessageCenterPojo)) == null) {
                if (chatMessage == null || chatMessage.getMsgType() != 22) {
                    return false;
                }
                if (c.a.p0.u1.w.c.p(chatMessage)) {
                    return true;
                }
                long a = e.a(chatMessage);
                if (a > imMessageCenterPojo.getRead_msgId()) {
                    imMessageCenterPojo.setRead_msgId(a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public static long a(ChatMessage chatMessage) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatMessage)) == null) {
            if (chatMessage != null) {
                if (chatMessage.getMsgType() == 22) {
                    try {
                        String content = chatMessage.getContent();
                        if (TextUtils.isEmpty(content)) {
                            return -1L;
                        }
                        JSONObject jSONObject = new JSONObject(content);
                        String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                        if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM)) == null || optJSONObject.optLong(TbEnum.SystemMessage.KEY_GROUP_ID) != c.a.p0.u1.s.a.i.longValue()) {
                            return -1L;
                        }
                    } catch (Exception unused) {
                        return -1L;
                    }
                }
                return c.a.p0.u1.w.b.a(optJSONObject.optLong("readMsgId"));
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            c.a.p0.u1.f.l.a.d(groupMsgData, imMessageCenterPojo, bVar, new a(), ChatStatusManager.getInst().getIsOpen(5), new b());
        }
    }
}
