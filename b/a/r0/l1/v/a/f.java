package b.a.r0.l1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class f implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.l1.h.c f21946e;

    /* renamed from: f  reason: collision with root package name */
    public int f21947f;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(b.a.r0.l1.h.c.h(), 2001145);
    }

    public final LoadHistoryResponsedMessage a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i2);
            loadHistoryResponsedMessage.setError(-18);
            return loadHistoryResponsedMessage;
        }
        return (LoadHistoryResponsedMessage) invokeI.objValue;
    }

    public final void b(b.a.r0.l1.h.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i2) == null) {
            this.f21946e = cVar;
            this.f21947f = i2;
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof LoadHistoryMessage)) {
                if (this.f21946e == null) {
                    return a(this.f21947f);
                }
                LoadHistoryMessage.a data = customMessage.getData();
                LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.f21947f);
                LinkedList<ChatMessage> g2 = this.f21946e.g(data.f51397d, data.f51394a, data.f51395b, data.f51396c);
                if (g2 == null) {
                    return a(this.f21947f);
                }
                LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
                if (data.f51394a == null) {
                    aVar.f51400c = true;
                } else {
                    aVar.f51400c = false;
                }
                aVar.f51399b = g2;
                aVar.f51398a = data.f51397d;
                try {
                    loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return loadHistoryResponsedMessage;
            }
            return a(this.f21947f);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
