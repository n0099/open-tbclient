package c.a.t0.s2.u.f;

import android.net.Uri;
import android.text.TextUtils;
import c.a.s0.s.q.g1;
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
/* loaded from: classes8.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23623b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f23624c;

    public p0(TbPageContext tbPageContext) {
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
        this.f23623b = false;
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.a.getPageActivity().getIntent() == null || (uri = (Uri) this.a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f23624c = g1Var;
        g1Var.a = uri.getQueryParameter("tid");
        this.f23624c.f13710b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || c.a.d.a.b.g().h() > 3) {
            return;
        }
        this.f23623b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f23623b || this.f23624c == null || pbModel == null || pbModel.R0() == null || pbModel.R0().l() == null) {
            return;
        }
        ForumData l = pbModel.R0().l();
        this.f23624c.f13711c = l.getFirst_class();
        this.f23624c.f13712d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f23624c);
        if (c.a.d.a.b.g().i("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
