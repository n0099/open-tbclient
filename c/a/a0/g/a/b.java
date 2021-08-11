package c.a.a0.g.a;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.i.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f1649a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(154526377, "Lc/a/a0/g/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(154526377, "Lc/a/a0/g/a/b;");
                return;
            }
        }
        f1649a = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1649a : (b) invokeV.objValue;
    }

    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_CLEAR, (String) null, bundle);
        }
    }

    public Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_DOWNLOAD_ALL, (String) null, (Bundle) null) : (Bundle) invokeV.objValue;
    }

    public Bundle c(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_DOWNLOAD_BACKGROUND, (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle d(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, "download", (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_FETCH, (String) null, (Bundle) null) : (Bundle) invokeV.objValue;
    }

    public Map<String, BundleInfoGroup> f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "", null, null);
            Map<String, BundleInfoGroup> t = t(BundleInfo.toBundleInfoList(query), j2);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return t;
        }
        return (Map) invokeJ.objValue;
    }

    public List<BundleInfo> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "pkg_name = ? ", new String[]{str}, null);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return bundleInfoList;
        }
        return (List) invokeL.objValue;
    }

    public BundleInfoGroup h(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j2)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(j.b(), null, "pkg_name = ? ", new String[]{str}, null);
            BundleInfoGroup s = s(BundleInfo.toBundleInfoList(query), j2);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return s;
        }
        return (BundleInfoGroup) invokeLJ.objValue;
    }

    public Bundle j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_PRE_INFO, (String) null, (Bundle) null) : (Bundle) invokeV.objValue;
    }

    public Bundle k(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, "install", (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle l(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_INSTALL_ONLY, (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle m(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_LOCAL_INSTALL, (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundleInfo)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_PRE_INSTALL_SINGLE, (String) null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ContextHolder.getApplicationContext().getContentResolver().call(j.b(), BundleOpProvider.METHOD_BUNDLE_PRE_INSTALL_ALL, (String) null, (Bundle) null) : (Bundle) invokeV.objValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
            Bundle call = ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_CHECK, (String) null, bundle);
            return call != null && call.getInt(Constant.TAG.PARAM_PKG_STUS, -1) == 47;
        }
        return invokeL.booleanValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Uri b2 = j.b();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
            ContextHolder.getApplicationContext().getContentResolver().call(b2, BundleOpProvider.METHOD_BUNDLE_RECORD, (String) null, bundle);
        }
    }

    public void r(boolean z, ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, contentObserver) == null) {
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(j.b(), z, contentObserver);
        }
    }

    public final BundleInfoGroup s(List<BundleInfo> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, list, j2)) == null) {
            BundleInfoGroup bundleInfoGroup = new BundleInfoGroup(j2);
            for (BundleInfo bundleInfo : list) {
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return bundleInfoGroup;
        }
        return (BundleInfoGroup) invokeLJ.objValue;
    }

    public final Map<String, BundleInfoGroup> t(List<BundleInfo> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, list, j2)) == null) {
            HashMap hashMap = new HashMap();
            if (list == null) {
                return null;
            }
            for (BundleInfo bundleInfo : list) {
                BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j2);
                    hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                }
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return hashMap;
        }
        return (Map) invokeLJ.objValue;
    }
}
