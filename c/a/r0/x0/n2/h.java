package c.a.r0.x0.n2;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, str) == null) {
            TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(str);
        }
    }

    public static void b(TbPageContext tbPageContext, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, tbPageContext, str, str2, str3) == null) || UtilHelper.isMatchScheme(tbPageContext.getPageActivity().getBaseContext(), str, str3) || str2 == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str2});
    }
}
