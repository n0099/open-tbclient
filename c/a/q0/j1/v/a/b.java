package c.a.q0.j1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.j1.t.a f21076e;

    /* renamed from: f  reason: collision with root package name */
    public int f21077f;

    public b(c.a.q0.j1.t.a aVar, int i2) {
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
        this.f21076e = aVar;
        this.f21077f = i2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.f21077f);
            if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
                return null;
            }
            SaveDraftMessage.a data = customMessage.getData();
            ChatSetting a2 = this.f21076e.a(TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "", data.f53065b);
            if (a2 == null) {
                return null;
            }
            a2.setDraft(data.f53064a);
            this.f21076e.h(a2);
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
