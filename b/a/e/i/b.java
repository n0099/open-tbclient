package b.a.e.i;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f2215a;

    /* renamed from: b  reason: collision with root package name */
    public File f2216b;

    /* renamed from: c  reason: collision with root package name */
    public PackageInfo f2217c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, ActivityInfo> f2218d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ProviderInfo> f2219e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, IntentFilter> f2220f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, IntentFilter> f2221g;

    /* renamed from: h  reason: collision with root package name */
    public ActivityInfo f2222h;

    /* renamed from: i  reason: collision with root package name */
    public Resources f2223i;

    public b(Context context, File file, Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file, resources};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2217c = null;
        this.f2218d = null;
        this.f2219e = null;
        this.f2220f = null;
        this.f2221g = null;
        this.f2222h = null;
        this.f2223i = null;
        this.f2215a = context;
        this.f2216b = file;
        this.f2223i = resources;
        this.f2218d = new HashMap();
        this.f2220f = new HashMap();
        this.f2221g = new HashMap();
        this.f2219e = new HashMap();
    }

    public ServiceInfo a(String str) {
        InterceptResult invokeL;
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (c2 = c()) != null && c2.services != null && !this.f2221g.isEmpty()) {
                for (ServiceInfo serviceInfo : c2.services) {
                    IntentFilter intentFilter = this.f2221g.get(serviceInfo.name);
                    if (intentFilter != null && intentFilter.hasAction(str)) {
                        return serviceInfo;
                    }
                }
            }
            return null;
        }
        return (ServiceInfo) invokeL.objValue;
    }

    public Map<String, ProviderInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2219e : (Map) invokeV.objValue;
    }

    public PackageInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.f2215a;
            if (context == null || this.f2216b == null) {
                return null;
            }
            if (this.f2217c == null) {
                try {
                    this.f2217c = context.getPackageManager().getPackageArchiveInfo(this.f2216b.getAbsolutePath(), 15);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    b.a.e.i.h.a.b().r("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e2.getMessage());
                }
            }
            return this.f2217c;
        }
        return (PackageInfo) invokeV.objValue;
    }

    public Map<String, IntentFilter> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2220f : (Map) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        XmlResourceParser openXmlResourceParser;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PackageInfo c2 = c();
            if (c2 == null) {
                BdLog.w("Plugin: initManifest() pkgInfo == null!!");
                return false;
            }
            ActivityInfo[] activityInfoArr = c2.receivers;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    this.f2218d.put(activityInfo.name, activityInfo);
                }
            }
            ProviderInfo[] providerInfoArr = c2.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    this.f2219e.put(providerInfo.name, providerInfo);
                }
            }
            try {
                openXmlResourceParser = this.f2223i.getAssets().openXmlResourceParser("AndroidManifest.xml");
            } catch (Exception e2) {
                BdLog.e(e2);
                b.a.e.i.h.a.b().r("plugin_install", "plugin_third_manifest_failed", c2.packageName, e2.getMessage());
            }
            if (openXmlResourceParser == null) {
                return false;
            }
            String str = null;
            char c3 = 65535;
            for (int next = openXmlResourceParser.next(); next != 1; next = openXmlResourceParser.next()) {
                if (next == 2) {
                    if (SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName())) {
                        c3 = 0;
                    } else if ("service".equals(openXmlResourceParser.getName())) {
                        c3 = 1;
                    }
                    if (c3 >= 0 && str == null) {
                        String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue.startsWith(".")) {
                            attributeValue = c2.packageName + attributeValue;
                        }
                        str = attributeValue;
                    } else if (str != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = this.f2220f;
                            if (c3 == 1) {
                                map = this.f2221g;
                            }
                            IntentFilter intentFilter = map.get(str);
                            if (intentFilter == null) {
                                intentFilter = new IntentFilter(attributeValue2);
                            } else {
                                intentFilter.addAction(attributeValue2);
                            }
                            map.put(str, intentFilter);
                        }
                    } else if (this.f2222h == null && "activity".equals(openXmlResourceParser.getName())) {
                        f(openXmlResourceParser, next);
                    }
                } else if (next != 3) {
                    continue;
                } else {
                    if (!SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName()) && !"service".equals(openXmlResourceParser.getName())) {
                        if ("application".equals(openXmlResourceParser.getName())) {
                            return true;
                        }
                    }
                    str = null;
                    c3 = 65535;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(XmlResourceParser xmlResourceParser, int i2) throws XmlPullParserException, IOException {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, xmlResourceParser, i2) == null) || (packageInfo = this.f2217c) == null || packageInfo.activities == null) {
            return;
        }
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        while (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && "activity".equals(xmlResourceParser.getName())) {
                    return;
                }
            } else if ("action".equals(xmlResourceParser.getName())) {
                if (!"android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                    i2 = xmlResourceParser.next();
                } else {
                    if (attributeValue.startsWith(".")) {
                        attributeValue = this.f2217c.packageName + attributeValue;
                    }
                    int i3 = 0;
                    while (true) {
                        ActivityInfo[] activityInfoArr = this.f2217c.activities;
                        if (i3 >= activityInfoArr.length) {
                            break;
                        } else if (activityInfoArr[i3].name.equals(attributeValue)) {
                            this.f2222h = this.f2217c.activities[i3];
                            return;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            i2 = xmlResourceParser.next();
        }
    }
}
