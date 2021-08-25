package c.a.q0.i2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import c.a.p0.s.q.g1;
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
/* loaded from: classes3.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19479a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19480b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f19481c;

    public m0(TbPageContext tbPageContext) {
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
        this.f19480b = false;
        this.f19479a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f19479a.getPageActivity().getIntent() == null || (uri = (Uri) this.f19479a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f19481c = g1Var;
        g1Var.f14242a = uri.getQueryParameter("tid");
        this.f19481c.f14243b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || c.a.e.a.b.f().g() > 3) {
            return;
        }
        this.f19480b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f19480b || this.f19481c == null || pbModel == null || pbModel.O0() == null || pbModel.O0().m() == null) {
            return;
        }
        ForumData m = pbModel.O0().m();
        this.f19481c.f14244c = m.getFirst_class();
        this.f19481c.f14245d = m.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f19481c);
        if (c.a.e.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
