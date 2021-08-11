package c.a.p0.i2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import c.a.o0.s.q.g1;
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
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19292a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19293b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f19294c;

    public o0(TbPageContext tbPageContext) {
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
        this.f19293b = false;
        this.f19292a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f19292a.getPageActivity().getIntent() == null || (uri = (Uri) this.f19292a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f19294c = g1Var;
        g1Var.f13936a = uri.getQueryParameter("tid");
        this.f19294c.f13937b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || c.a.e.a.b.f().g() > 3) {
            return;
        }
        this.f19293b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f19293b || this.f19294c == null || pbModel == null || pbModel.O0() == null || pbModel.O0().m() == null) {
            return;
        }
        ForumData m = pbModel.O0().m();
        this.f19294c.f13938c = m.getFirst_class();
        this.f19294c.f13939d = m.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f19294c);
        if (c.a.e.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
