package c.a.u0.u2.u.f;

import android.net.Uri;
import android.text.TextUtils;
import c.a.t0.s.r.g1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23764b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f23765c;

    public q0(TbPageContext tbPageContext) {
        Uri uri;
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
        this.f23764b = false;
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.a.getPageActivity().getIntent() == null || (uri = (Uri) this.a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f23765c = g1Var;
        g1Var.a = uri.getQueryParameter("tid");
        this.f23765c.f13866b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || c.a.d.a.b.f().g() > 3) {
            return;
        }
        this.f23764b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f23764b || this.f23765c == null || pbModel == null || pbModel.R0() == null || pbModel.R0().l() == null) {
            return;
        }
        ForumData l = pbModel.R0().l();
        this.f23765c.f13867c = l.getFirst_class();
        this.f23765c.f13868d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f23765c);
        if (c.a.d.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
