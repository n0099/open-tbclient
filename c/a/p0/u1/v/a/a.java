package c.a.p0.u1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.u1.t.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f18928b;

    public a(c.a.p0.u1.t.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f18928b = i;
    }

    public final LoadDraftResponsedMessage a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
            loadDraftResponsedMessage.setError(-18);
            return loadDraftResponsedMessage;
        }
        return (LoadDraftResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.f18928b);
            if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
                LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
                String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
                LoadDraftMessage.a data = loadDraftMessage.getData();
                ChatSetting a = this.a.a(id, data.a);
                if (a == null) {
                    return a(loadDraftMessage.getCmd());
                }
                String draft = a.getDraft();
                LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
                aVar.a = draft;
                String str = data.a;
                try {
                    loadDraftResponsedMessage.decodeInBackGround(this.f18928b, aVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return loadDraftResponsedMessage;
            }
            return a(this.f18928b);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
