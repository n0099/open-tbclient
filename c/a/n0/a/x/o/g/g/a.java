package c.a.n0.a.x.o.g.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k1.l.e;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.o.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0565a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f7371b;

        public RunnableC0565a(String str, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f7371b = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.d(this.a);
                a.d(a.e(this.a, this.f7371b.pageUrl));
            }
        }
    }

    public static void c(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, prefetchEvent) == null) && e.a()) {
            String str = prefetchEvent.appPath;
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                q.k(new RunnableC0565a(str, prefetchEvent), "addFileResToMemoryCache");
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list == null || list.length == 0) {
                    return;
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = str + File.separator + str2;
                        File file2 = new File(str3);
                        if (file2.exists() && file2.isFile() && (str3.endsWith(FileHelper.FILE_CACHE_CSS) || str3.endsWith(".js"))) {
                            BdSailorWebView.addToWebCache("file://" + str3, true);
                        }
                    }
                }
            } else if (file.isFile()) {
                String absolutePath = file.getAbsolutePath();
                if (TextUtils.isEmpty(absolutePath)) {
                    return;
                }
                if (absolutePath.endsWith(FileHelper.FILE_CACHE_CSS) || absolutePath.endsWith(".js")) {
                    BdSailorWebView.addToWebCache("file://" + absolutePath, true);
                }
            }
        }
    }

    public static String e(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String f2 = o0.f(str2);
            if (!TextUtils.isEmpty(f2) && (lastIndexOf = f2.lastIndexOf(File.separator)) > 0) {
                String substring = f2.substring(0, lastIndexOf);
                return str + File.separator + substring;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
