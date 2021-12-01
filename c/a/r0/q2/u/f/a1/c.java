package c.a.r0.q2.u.f.a1;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.q2.y.b a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f21758b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f21759c;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.e(httpResponsedMessage, CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.e(httpResponsedMessage, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
            }
        }
    }

    public c(c.a.r0.q2.y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21758b = new a(this, CmdConfigHttp.CMD_PB_FLOOR_AGREE, true);
        this.f21759c = new b(this, CmdConfigHttp.CMD_CHANGE_FLOOR_AGREE);
        if (bVar != null) {
            this.a = bVar;
            f();
            return;
        }
        throw new NullPointerException("PbActivity is NullPointerException");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AgreeData agreeData) {
        c.a.q0.n0.c k2;
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, agreeData) == null) || agreeData == null) {
            return;
        }
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                agreeData.agreeType = 2;
                agreeData.hasAgree = false;
                agreeData.agreeNum--;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                httpMessage.addParam("thread_id", agreeData.threadId);
                httpMessage.addParam("op_type", i2);
                if (agreeData.objType == 0) {
                    agreeData.objType = 3;
                }
                httpMessage.addParam("obj_type", agreeData.objType);
                httpMessage.addParam("agree_type", agreeData.agreeType);
                httpMessage.addParam("forum_id", agreeData.forumId);
                k2 = TbPageExtraHelper.k(this.a.getPbActivity());
                if (k2 != null) {
                    httpMessage.addParam("obj_source", k2.a());
                }
                if (!TextUtils.isEmpty(agreeData.postId)) {
                    httpMessage.addParam("post_id", agreeData.postId);
                }
                baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData != null) {
                    httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                    httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
                    httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
                    httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, agreeData.baijiahaoData.oriUgcType);
                }
                httpMessage.setTag(c());
                httpMessage.setExtra(Integer.valueOf(i2));
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            agreeData.agreeType = 2;
            agreeData.hasAgree = true;
            agreeData.agreeNum++;
            c.a.r0.g3.a.g().l(this.a.getPageContext());
        } else {
            agreeData.agreeType = 2;
            agreeData.hasAgree = true;
            agreeData.agreeNum++;
            c.a.r0.g3.a.g().l(this.a.getPageContext());
        }
        i2 = 0;
        HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage2.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage2.addParam("thread_id", agreeData.threadId);
        httpMessage2.addParam("op_type", i2);
        if (agreeData.objType == 0) {
        }
        httpMessage2.addParam("obj_type", agreeData.objType);
        httpMessage2.addParam("agree_type", agreeData.agreeType);
        httpMessage2.addParam("forum_id", agreeData.forumId);
        k2 = TbPageExtraHelper.k(this.a.getPbActivity());
        if (k2 != null) {
        }
        if (!TextUtils.isEmpty(agreeData.postId)) {
        }
        baijiahaoData = agreeData.baijiahaoData;
        if (baijiahaoData != null) {
        }
        httpMessage2.setTag(c());
        httpMessage2.setExtra(Integer.valueOf(i2));
        httpMessage2.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage2);
    }

    public BdUniqueId c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbPageContext pageContext = this.a.getPageContext();
            if (pageContext != null) {
                return pageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
        }
    }

    public final void e(HttpResponsedMessage httpResponsedMessage, int i2) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, httpResponsedMessage, i2) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != i2 || !(httpResponsedMessage instanceof PbFloorAgreeResponseMessage) || (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) == null || pbFloorAgreeResponseMessage.hasError() || this.a == null || pbFloorAgreeResponseMessage.getActivityDialogData() == null) {
            return;
        }
        CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
        activityDialogData.type = 0;
        c.a.r0.q2.t.c.a(this.a.getPageContext(), activityDialogData).show();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.q2.y.b bVar = this.a;
            if (bVar != null) {
                bVar.registerListener(this.f21758b);
                this.a.registerListener(this.f21759c);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f21758b);
            MessageManager.getInstance().unRegisterListener(this.f21759c);
            return true;
        }
        return invokeV.booleanValue;
    }
}
