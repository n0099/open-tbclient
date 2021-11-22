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
public class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20931a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20932b;

    /* renamed from: c  reason: collision with root package name */
    public g1 f20933c;

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
        this.f20932b = false;
        this.f20931a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.f20931a.getPageActivity().getIntent() == null || (uri = (Uri) this.f20931a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter("eqid");
        g1 g1Var = new g1();
        this.f20933c = g1Var;
        g1Var.f14108a = uri.getQueryParameter("tid");
        this.f20933c.f14109b = uri.getQueryParameter("eqid");
        if (TextUtils.isEmpty(queryParameter) || b.a.e.a.b.g().h() > 3) {
            return;
        }
        this.f20932b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f20932b || this.f20933c == null || pbModel == null || pbModel.P0() == null || pbModel.P0().l() == null) {
            return;
        }
        ForumData l = pbModel.P0().l();
        this.f20933c.f14110c = l.getFirst_class();
        this.f20933c.f14111d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f20933c);
        if (b.a.e.a.b.g().i("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
