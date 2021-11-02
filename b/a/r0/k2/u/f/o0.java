package b.a.r0.k2.u.f;

import android.net.Uri;
import android.text.TextUtils;
import b.a.q0.s.q.g1;
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
/* loaded from: classes5.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19360a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19361b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f19362c;

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
        this.f19361b = false;
        this.f19360a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f19360a.getPageActivity().getIntent() == null || (uri = (Uri) this.f19360a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f19362c = g1Var;
        g1Var.f13328a = uri.getQueryParameter("tid");
        this.f19362c.f13329b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || b.a.e.a.b.g().h() > 3) {
            return;
        }
        this.f19361b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f19361b || this.f19362c == null || pbModel == null || pbModel.P0() == null || pbModel.P0().l() == null) {
            return;
        }
        ForumData l = pbModel.P0().l();
        this.f19362c.f13330c = l.getFirst_class();
        this.f19362c.f13331d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f19362c);
        if (b.a.e.a.b.g().i("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
