package c.a.r0.f4;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, str) == null) {
            b(tbPageContext, str, null);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, tbPageContext, str, bundle) == null) || StringUtils.isNull(str) || tbPageContext == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.get(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM) == null) {
            bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, false);
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str}, bundle);
    }
}
