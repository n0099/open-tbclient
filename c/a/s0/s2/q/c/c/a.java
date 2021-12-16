package c.a.s0.s2.q.c.c;

import c.a.r0.z0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanHttpResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanSocketResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
        a();
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, c.a.s0.v3.f0.a.a(TbConfig.FINE_PB_PRAISE, 309095));
            tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = new b(309095);
            bVar.setResponsedClass(ChosenPbZanSocketResponse.class);
            bVar.g(true);
            bVar.h(false);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void c(PbChosenActivity pbChosenActivity, long j2, long j3, long j4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbChosenActivity, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)}) == null) {
            ChosenZanNetMessage chosenZanNetMessage = new ChosenZanNetMessage();
            chosenZanNetMessage.setExcId(j2);
            chosenZanNetMessage.setAction(i2);
            chosenZanNetMessage.setThreadId(j3);
            chosenZanNetMessage.setPostId(j4);
            pbChosenActivity.sendMessage(chosenZanNetMessage);
        }
    }
}
