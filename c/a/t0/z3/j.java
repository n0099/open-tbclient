package c.a.t0.z3;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import c.a.s0.s.q.m1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    public j(TbPageContext tbPageContext) {
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
        this.a = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public void a(Intent intent, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, intent, fVar) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.a.getString(q.des_page_home_recommend);
            m1 m1Var = new m1();
            Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
            int i2 = 1;
            if (matcher.find()) {
                m1Var.f13646c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                m1Var.a = 1;
            } else {
                m1Var.a = 2;
                m1Var.f13645b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, m1Var));
            if (stringExtra.equals(string)) {
                intent.putExtra("sub_locate_type", 1);
                i2 = 2;
            } else {
                intent.putExtra("sub_locate_type", stringExtra);
            }
            if (fVar != null && fVar.z() != null) {
                fVar.z().setCurrentTabByType(i2);
                FragmentTabHost.b tabSpecByType = fVar.z().getTabSpecByType(i2);
                if (tabSpecByType != null) {
                    Fragment fragment = tabSpecByType.f40296c;
                    if (fragment instanceof c.a.s0.s.g) {
                        ((c.a.s0.s.g) fragment).setCurrentSubTab(intent);
                    }
                }
            }
        }
        intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
        intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1 : invokeL.booleanValue;
    }
}
