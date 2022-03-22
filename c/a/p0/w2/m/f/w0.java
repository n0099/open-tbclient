package c.a.p0.w2.m.f;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20333b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.r.e1 f20334c;

    public w0(TbPageContext tbPageContext) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20333b = false;
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() == null || this.a.getPageActivity().getIntent() == null || (uri = (Uri) this.a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("tid");
        uri.getQueryParameter(TiebaStatic.Params.EQID);
        c.a.o0.r.r.e1 e1Var = new c.a.o0.r.r.e1();
        this.f20334c = e1Var;
        e1Var.a = uri.getQueryParameter("tid");
        this.f20334c.f10846b = uri.getQueryParameter(TiebaStatic.Params.EQID);
        if (TextUtils.isEmpty(queryParameter) || c.a.d.a.b.g().h() > 3) {
            return;
        }
        this.f20333b = true;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) || !this.f20333b || this.f20334c == null || pbModel == null || pbModel.S0() == null || pbModel.S0().l() == null) {
            return;
        }
        ForumData l = pbModel.S0().l();
        this.f20334c.f10847c = l.getFirst_class();
        this.f20334c.f10848d = l.getSecond_class();
        TbSingleton.getInstance().setPbToHomeUpdateData(this.f20334c);
        if (c.a.d.a.b.g().i("MainTabActivity")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
        } else {
            TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
        }
    }
}
