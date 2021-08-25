package c.a.q0.c0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.q0.c0.a;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0790a f16541a;

        public a(a.C0790a c0790a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0790a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16541a = c0790a;
        }

        @Override // c.a.q0.c0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16541a.a(2, i2);
            }
        }
    }

    /* renamed from: c.a.q0.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0791b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0790a f16542a;

        public C0791b(a.C0790a c0790a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0790a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16542a = c0790a;
        }

        @Override // c.a.q0.c0.c
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16542a.a(2, i2);
            }
        }
    }

    public static boolean a(Context context, Uri uri, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, uri, bundle, Boolean.valueOf(z)})) == null) ? b(context, uri, null, bundle, z) : invokeCommon.booleanValue;
    }

    public static boolean b(Context context, Uri uri, c.a.q0.c0.a aVar, Bundle bundle, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, uri, aVar, bundle, Boolean.valueOf(z)})) == null) {
            a.C0790a c0790a = new a.C0790a();
            if (uri == null) {
                if (aVar != null) {
                    aVar.b(1, "Uri is empty.", c0790a);
                }
                return false;
            } else if (!"deeplink".equals(uri.getHost())) {
                if (aVar != null) {
                    aVar.b(2, "Uri host is not deeplink.", c0790a);
                }
                return false;
            } else {
                String queryParameter = uri.getQueryParameter("appUrl");
                String queryParameter2 = uri.getQueryParameter("marketUrl");
                String queryParameter3 = uri.getQueryParameter(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
                String queryParameter4 = uri.getQueryParameter(PushClientConstants.TAG_PKG_NAME);
                String queryParameter5 = uri.getQueryParameter("marketPkgName");
                boolean booleanQueryParameter = uri.getBooleanQueryParameter("isDesignatePkg", true);
                if (e(context, queryParameter, queryParameter4, aVar, booleanQueryParameter, c0790a) || f(context, queryParameter2, queryParameter5, aVar, booleanQueryParameter, c0790a)) {
                    return true;
                }
                return g(context, queryParameter3, bundle, aVar, c0790a, z);
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

    public static boolean e(Context context, String str, String str2, c.a.q0.c0.a aVar, boolean z, a.C0790a c0790a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c0790a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0790a.a(1, -4);
                return false;
            } else if (c(context, str, str2, z, new a(c0790a))) {
                c0790a.b(1);
                if (aVar != null) {
                    aVar.a(1, c0790a);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(Context context, String str, String str2, c.a.q0.c0.a aVar, boolean z, a.C0790a c0790a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z), c0790a})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0790a.a(2, -5);
                return false;
            } else if (c(context, str, str2, z, new C0791b(c0790a))) {
                c0790a.b(2);
                if (aVar != null) {
                    aVar.a(2, c0790a);
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(Context context, String str, Bundle bundle, c.a.q0.c0.a aVar, a.C0790a c0790a, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, bundle, aVar, c0790a, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                c0790a.a(3, -6);
                if (aVar != null) {
                    aVar.b(-6, "Uri web url is empty", c0790a);
                }
                return false;
            } else if (d(context, str, bundle, z)) {
                c0790a.b(3);
                if (aVar != null) {
                    aVar.a(3, c0790a);
                    return true;
                }
                return true;
            } else {
                c0790a.a(3, -7);
                if (aVar != null) {
                    aVar.b(-7, "Uri web url open failed", c0790a);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
