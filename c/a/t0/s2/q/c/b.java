package c.a.t0.s2.q.c;

import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.ChosenPbHttpResponse;
import com.baidu.tieba.pb.chosen.net.ChosenPbNetMessage;
import com.baidu.tieba.pb.chosen.net.ChosenPbSocketResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
        b();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FINE_PB, c.a.t0.w3.f0.a.a(TbConfig.FINE_PB_PAGE, 309093));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ChosenPbHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.a1.b bVar = new c.a.s0.a1.b(309093);
            bVar.setResponsedClass(ChosenPbSocketResponse.class);
            bVar.g(true);
            bVar.h(false);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void c(PbChosenActivity pbChosenActivity, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbChosenActivity, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            ChosenPbNetMessage chosenPbNetMessage = new ChosenPbNetMessage();
            int k = n.k(pbChosenActivity.getPageContext().getPageActivity());
            int i2 = n.i(pbChosenActivity.getPageContext().getPageActivity());
            float h2 = n.h(pbChosenActivity.getPageContext().getPageActivity());
            chosenPbNetMessage.setQ_type(45L);
            chosenPbNetMessage.setScrH(i2);
            chosenPbNetMessage.setScrW(k);
            chosenPbNetMessage.setScr_dip(h2);
            chosenPbNetMessage.setExcId(j2);
            chosenPbNetMessage.setTagCode(j3);
            chosenPbNetMessage.setThreadId(j4);
            pbChosenActivity.sendMessage(chosenPbNetMessage);
        }
    }
}
