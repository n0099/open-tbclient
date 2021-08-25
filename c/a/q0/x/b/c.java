package c.a.q0.x.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.data.CommitCardInfoHttpResMsg;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import com.baidu.tieba.barselect.data.CommitCardInfoSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f28535a;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28535a = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309643);
        socketMessageTask.setResponsedClass(CommitCardInfoSocketResMsg.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMMIT_CARD_INFO, c.a.q0.i3.d0.a.a(TbConfig.URL_COMMIT_CARD_INFO, 309643));
        tbHttpMessageTask.setResponsedClass(CommitCardInfoHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            CommitCardInfoReqMsg commitCardInfoReqMsg = new CommitCardInfoReqMsg();
            commitCardInfoReqMsg.resource_id = str;
            commitCardInfoReqMsg.card_type = i2;
            commitCardInfoReqMsg.image_info = str2;
            commitCardInfoReqMsg.setTag(this.f28535a.getUniqueId());
            MessageManager.getInstance().sendMessage(commitCardInfoReqMsg);
        }
    }
}
