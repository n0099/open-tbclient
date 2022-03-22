package c.a.p0.j0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.p0.j0.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1169a a;

        public a(a.C1169a c1169a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1169a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1169a;
        }

        @Override // c.a.p0.j0.c
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a(2, i);
            }
        }
    }

    /* renamed from: c.a.p0.j0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1170b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1169a a;

        public C1170b(a.C1169a c1169a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1169a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1169a;
        }

        @Override // c.a.p0.j0.c
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a(2, i);
            }
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, uri, bundle, Boolean.valueOf(z)})) == null) ? b(context, uri, null, bundle, z) : invokeCommon.booleanValue;
    }

    public static boolean b(Context context, Uri uri, c.a.p0.j0.a aVar, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, uri, aVar, bundle, Boolean.valueOf(z)})) == null) {
            a.C1169a c1169a = new a.C1169a();
            if (uri == null) {
                if (aVar != null) {
                    aVar.b(1, "Uri is empty.", c1169a);
                }
                return false;
            } else if (!"deeplink".equals(uri.getHost())) {
                if (aVar != null) {
                    aVar.b(2, "Uri host is not deeplink.", c1169a);
                }
                return false;
            } else {
                String queryParameter = uri.getQueryParameter(DeepLinkItem.DEEPLINK_APPURL_KEY);
                String queryParameter2 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
                String queryParameter3 = uri.getQueryParameter("webUrl");
                String queryParameter4 = uri.getQueryParameter("pkgName");
                String queryParameter5 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKET_PKGNAME_KEY);
                boolean booleanQueryParameter = uri.getBooleanQueryParameter(DeepLinkItem.DEEPLINK_IS_DESIGNATE_PKG, true);
                if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c1169a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c1169a)) {
                    return true;
                }
                return g(context, queryParameter3, bundle, aVar, c1169a, z);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(Context context, String str, String str2, boolean z, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), cVar})) == null) {
            try {
                Intent b2 = d.b(context, str, str2, z, cVar);
                if (b2 == null) {
                    return false;
                }
                context.startActivity(b2);
                return true;
            } catch (Exception unused) {
                if (cVar != null) {
                    cVar.onFailed(-101);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean d(Context context, String str, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, bundle, Boolean.valueOf(z)})) == null) {
            String[] strArr = {str};
            UrlManager urlManager = UrlManager.getInstance();
            if (urlManager == null || (tbPageContext = (TbPageContext) j.a(context)) == null) {
                return false;
            }
            if (urlManager.UrlValidated(str)) {
                urlManager.dealOneLink(tbPageContext, strArr, true);
                return true;
            }
            return urlManager.dealOneLink(tbPageContext, strArr);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e(Context context, String str, String str2, c.a.p0.j0.a aVar, boolean z, a.C1169a c1169a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c1169a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1169a.a(1, -4);
                return false;
            } else if (c(context, str, str2, z, new a(c1169a))) {
                c1169a.b(1);
                if (aVar != null) {
                    aVar.a(1, c1169a);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(Context context, String str, String str2, c.a.p0.j0.a aVar, boolean z, a.C1169a c1169a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c1169a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1169a.a(2, -5);
                return false;
            } else if (c(context, str, str2, z, new C1170b(c1169a))) {
                c1169a.b(2);
                if (aVar != null) {
                    aVar.a(2, c1169a);
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(Context context, String str, Bundle bundle, c.a.p0.j0.a aVar, a.C1169a c1169a, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, str, bundle, aVar, c1169a, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                c1169a.a(3, -6);
                if (aVar != null) {
                    aVar.b(-6, "Uri web url is empty", c1169a);
                }
                return false;
            } else if (d(context, str, bundle, z)) {
                c1169a.b(3);
                if (aVar != null) {
                    aVar.a(3, c1169a);
                    return true;
                }
                return true;
            } else {
                c1169a.a(3, -7);
                if (aVar != null) {
                    aVar.b(-7, "Uri web url open failed", c1169a);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
