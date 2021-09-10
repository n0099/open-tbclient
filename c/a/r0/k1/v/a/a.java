package c.a.r0.k1.v.a;

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
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.k1.t.a f21644e;

    /* renamed from: f  reason: collision with root package name */
    public int f21645f;

    public a(c.a.r0.k1.t.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21644e = aVar;
        this.f21645f = i2;
    }

    public final LoadDraftResponsedMessage a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i2);
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
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.f21645f);
            if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
                LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
                String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
                LoadDraftMessage.a data = loadDraftMessage.getData();
                ChatSetting a2 = this.f21644e.a(id, data.f53183a);
                if (a2 == null) {
                    return a(loadDraftMessage.getCmd());
                }
                String draft = a2.getDraft();
                LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
                aVar.f53184a = draft;
                String str = data.f53183a;
                try {
                    loadDraftResponsedMessage.decodeInBackGround(this.f21645f, aVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return loadDraftResponsedMessage;
            }
            return a(this.f21645f);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
