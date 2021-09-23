package c.a.r0.j2.k.e;

import android.net.Uri;
import android.text.TextUtils;
import c.a.q0.s.q.g1;
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
    public TbPageContext f20193a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20194b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f20195c;

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
        this.f20194b = false;
        this.f20193a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f20193a.getPageActivity().getIntent() == null || (uri = (Uri) this.f20193a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f20195c = g1Var;
        g1Var.f14196a = uri.getQueryParameter("tid");
        this.f20195c.f14197b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || c.a.e.a.b.f().g() > 3) {
            return;
        }
        this.f20194b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f20194b || this.f20195c == null || pbModel == null || pbModel.P0() == null || pbModel.P0().m() == null) {
            return;
        }
        ForumData m = pbModel.P0().m();
        this.f20195c.f14198c = m.getFirst_class();
        this.f20195c.f14199d = m.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f20195c);
        if (c.a.e.a.b.f().h("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
