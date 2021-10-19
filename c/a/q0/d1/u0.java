package c.a.q0.d1;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class u0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static BaseWebView f13038a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebView f13039a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, BaseWebView baseWebView) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), baseWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13039a = baseWebView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BaseWebView baseWebView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921024 || (baseWebView = this.f13039a) == null) {
                return;
            }
            baseWebView.reload();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13040a;

        /* renamed from: b  reason: collision with root package name */
        public String f13041b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13040a = "";
            this.f13041b = "";
            this.f13040a = str;
            this.f13041b = str2;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && b.class == obj.getClass()) {
                    b bVar = (b) obj;
                    String str = this.f13040a;
                    if (str == null) {
                        if (bVar.f13040a != null) {
                            return false;
                        }
                    } else if (!str.equals(bVar.f13040a)) {
                        return false;
                    }
                    String str2 = this.f13041b;
                    if (str2 == null) {
                        if (bVar.f13041b != null) {
                            return false;
                        }
                    } else if (!str2.equals(bVar.f13041b)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.f13040a;
                int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
                String str2 = this.f13041b;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (c.a.e.e.p.k.isEmpty(str) || str.contains("page_type")) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("page_type");
            sb.append("=");
            sb.append(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = "";
            if (Build.VERSION.SDK_INT >= 17) {
                StringBuilder sb = new StringBuilder();
                try {
                    str = WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                sb.append(str);
                sb.append(" tieba/");
                sb.append(TbConfig.getVersion());
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                int length = indexOf + str2.length();
                int i2 = length;
                while (i2 < str.length() && str.charAt(i2) != '&') {
                    i2++;
                }
                try {
                    return URLDecoder.decode(str.substring(length, i2));
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String str3 = "";
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (split = str.split("[?]")) != null && split.length >= 2) {
                for (int i2 = 1; i2 < split.length; i2++) {
                    String[] split2 = split[i2].split("&");
                    if (split2 != null && split2.length > 0) {
                        int length = split2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                String[] split3 = split2[i3].split("=");
                                if (split3.length == 2) {
                                    String str4 = split3[0];
                                    String str5 = split3[1];
                                    if (str2.equals(str4)) {
                                        try {
                                            str3 = URLDecoder.decode(str5);
                                            break;
                                        } catch (Exception unused) {
                                            str3 = str5;
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            f();
            BaseWebView baseWebView = f13038a;
            if (baseWebView == null || baseWebView.getSettings() == null) {
                return null;
            }
            return f13038a.getSettings().getUserAgentString();
        }
        return (String) invokeV.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            try {
                if (f13038a == null) {
                    f13038a = new BaseWebView(TbadkCoreApplication.getInst());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void g(BaseWebView baseWebView, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, baseWebView, bdUniqueId) == null) || baseWebView == null) {
            return;
        }
        a aVar = new a(2921024, baseWebView);
        if (bdUniqueId != null) {
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://");
        }
        return invokeL.booleanValue;
    }

    public static Bundle i(String str) {
        InterceptResult invokeL;
        URL url;
        String query;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            try {
                url = new URL(str);
                query = url.getQuery();
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            if (StringUtils.isNull(query) || StringUtils.isNull(url.getPath()) || (split = query.split("&")) == null) {
                return null;
            }
            bundle.putString("path", url.getPath());
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                    bundle.putString(split2[0], split2[1]);
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
