package c.a.q0.l0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65536, null, j2, str) == null) {
            RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
            requestPassFriendMessage.setFriendId(j2, str);
            MessageManager.getInstance().sendMessage(requestPassFriendMessage);
        }
    }
}
