package c.a.r0.u1;

import android.text.TextUtils;
import c.a.e.e.d.l;
import c.a.e.e.p.p;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryReadMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryReadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public static final List<String> a(List<l.b<String>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                for (l.b<String> bVar : list) {
                    String str = bVar.f2223a;
                    if (!TextUtils.isEmpty(str)) {
                        linkedList.add(str);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof RequestSearchPersonHistoryReadMessage)) {
                return null;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            c.a.q0.s.r.a.f();
            List<String> a2 = a(p.b(c.a.q0.s.r.a.h("tb.searchperson_history", currentAccount)));
            ResponseSearchPersonHistoryReadMessage responseSearchPersonHistoryReadMessage = new ResponseSearchPersonHistoryReadMessage();
            responseSearchPersonHistoryReadMessage.datas.addAll(a2);
            return responseSearchPersonHistoryReadMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
