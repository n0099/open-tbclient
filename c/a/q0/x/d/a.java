package c.a.q0.x.d;

import c.a.p0.x0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchReqMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f28589a;

    public a(TbPageContext tbPageContext) {
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
        this.f28589a = tbPageContext;
        b bVar = new b(309641);
        bVar.setResponsedClass(CandidateSearchSocketResMsg.class);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANDIDATE_SEARCH, c.a.q0.i3.d0.a.a(TbConfig.URL_CANDIDATE_SEARCH, 309641));
        tbHttpMessageTask.setResponsedClass(CandidateSearchHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            CandidateSearchReqMsg candidateSearchReqMsg = new CandidateSearchReqMsg();
            candidateSearchReqMsg.applyId = i2;
            candidateSearchReqMsg.fid = j2;
            candidateSearchReqMsg.setTag(this.f28589a.getUniqueId());
            MessageManager.getInstance().sendMessage(candidateSearchReqMsg);
        }
    }
}
