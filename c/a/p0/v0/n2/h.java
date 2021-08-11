package c.a.p0.v0.n2;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, str) == null) {
            b(tbPageContext, str, null);
        }
    }

    public static void b(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, str, str2) == null) {
            if (str2 != null) {
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str2});
            }
            TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(str);
        }
    }
}
