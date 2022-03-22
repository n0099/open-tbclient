package c.a.p0.c4.q;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.c4.h f13565b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2921491);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.f13565b = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.c4.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (hVar = this.f13565b) == null || hVar.z() == null || this.f13565b.z().getCurrentTabType() == 21) {
            return;
        }
        String str = (String) customResponsedMessage.getData();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.f13565b.z().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        mainTabActivity.mCategoryTipController = new c.a.p0.l0.g(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(2));
        this.a.mCategoryTipController.g0(R.drawable.obfuscated_res_0x7f0802ee);
        this.a.mCategoryTipController.L(2);
        this.a.mCategoryTipController.O(32);
        this.a.mCategoryTipController.h0(true);
        MainTabActivity mainTabActivity2 = this.a;
        mainTabActivity2.mCategoryTipController.k0(-c.a.d.f.p.n.f(mainTabActivity2, R.dimen.tbds10));
        this.a.mCategoryTipController.X(R.color.CAM_X0101);
        this.a.mCategoryTipController.P(R.dimen.tbds54);
        this.a.mCategoryTipController.T(999);
        this.a.mCategoryTipController.N(5000);
        MainTabActivity mainTabActivity3 = this.a;
        mainTabActivity3.mCategoryTipController.a0(c.a.d.f.p.n.f(mainTabActivity3, R.dimen.tbds44));
        this.a.mCategoryTipController.o0(str, "categoryUpdate", false, true);
    }
}
