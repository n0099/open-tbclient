package b.a.r0.d0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.r0.d0.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0835a f16721a;

        public a(a.C0835a c0835a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0835a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16721a = c0835a;
        }

        @Override // b.a.r0.d0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16721a.a(2, i2);
            }
        }
    }

    /* renamed from: b.a.r0.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0836b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0835a f16722a;

        public C0836b(a.C0835a c0835a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0835a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16722a = c0835a;
        }

        @Override // b.a.r0.d0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16722a.a(2, i2);
            }
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, uri, bundle, Boolean.valueOf(z)})) == null) ? b(context, uri, null, bundle, z) : invokeCommon.booleanValue;
    }

    public static boolean b(Context context, Uri uri, b.a.r0.d0.a aVar, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, uri, aVar, bundle, Boolean.valueOf(z)})) == null) {
            a.C0835a c0835a = new a.C0835a();
            if (uri == null) {
                if (aVar != null) {
                    aVar.b(1, "Uri is empty.", c0835a);
                }
                return false;
            } else if (!"deeplink".equals(uri.getHost())) {
                if (aVar != null) {
                    aVar.b(2, "Uri host is not deeplink.", c0835a);
                }
                return false;
            } else {
                String queryParameter = uri.getQueryParameter("appUrl");
                String queryParameter2 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKETURL_KEY);
                String queryParameter3 = uri.getQueryParameter("webUrl");
                String queryParameter4 = uri.getQueryParameter("pkgName");
                String queryParameter5 = uri.getQueryParameter(DeepLinkItem.DEEPLINK_MARKET_PKGNAME_KEY);
                boolean booleanQueryParameter = uri.getBooleanQueryParameter(DeepLinkItem.DEEPLINK_IS_DESIGNATE_PKG, true);
                if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c0835a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c0835a)) {
                    return true;
                }
                return g(context, queryParameter3, bundle, aVar, c0835a, z);
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

    public static boolean e(Context context, String str, String str2, b.a.r0.d0.a aVar, boolean z, a.C0835a c0835a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c0835a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0835a.a(1, -4);
                return false;
            } else if (c(context, str, str2, z, new a(c0835a))) {
                c0835a.b(1);
                if (aVar != null) {
                    aVar.a(1, c0835a);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(Context context, String str, String str2, b.a.r0.d0.a aVar, boolean z, a.C0835a c0835a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c0835a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0835a.a(2, -5);
                return false;
            } else if (c(context, str, str2, z, new C0836b(c0835a))) {
                c0835a.b(2);
                if (aVar != null) {
                    aVar.a(2, c0835a);
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(Context context, String str, Bundle bundle, b.a.r0.d0.a aVar, a.C0835a c0835a, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, bundle, aVar, c0835a, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0835a.a(3, -6);
                if (aVar != null) {
                    aVar.b(-6, "Uri web url is empty", c0835a);
                }
                return false;
            } else if (d(context, str, bundle, z)) {
                c0835a.b(3);
                if (aVar != null) {
                    aVar.a(3, c0835a);
                    return true;
                }
                return true;
            } else {
                c0835a.a(3, -7);
                if (aVar != null) {
                    aVar.b(-7, "Uri web url open failed", c0835a);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
