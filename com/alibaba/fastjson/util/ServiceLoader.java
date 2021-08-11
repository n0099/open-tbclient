package com.alibaba.fastjson.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class ServiceLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "META-INF/services/";
    public static final Set<String> loadedUrls;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1228023426, "Lcom/alibaba/fastjson/util/ServiceLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1228023426, "Lcom/alibaba/fastjson/util/ServiceLoader;");
                return;
            }
        }
        loadedUrls = new HashSet();
    }

    public ServiceLoader() {
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

    public static <T> Set<T> load(Class<T> cls, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, classLoader)) == null) {
            if (classLoader == null) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet();
            String str = "META-INF/services/" + cls.getName();
            HashSet<String> hashSet2 = new HashSet();
            try {
                Enumeration<URL> resources = classLoader.getResources(str);
                while (resources.hasMoreElements()) {
                    URL nextElement = resources.nextElement();
                    if (!loadedUrls.contains(nextElement.toString())) {
                        load(nextElement, hashSet2);
                        loadedUrls.add(nextElement.toString());
                    }
                }
            } catch (Throwable unused) {
            }
            for (String str2 : hashSet2) {
                try {
                    hashSet.add(classLoader.loadClass(str2).newInstance());
                } catch (Exception unused2) {
                }
            }
            return hashSet;
        }
        return (Set) invokeLL.objValue;
    }

    public static void load(URL url, Set<String> set) throws IOException {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, url, set) != null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            inputStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            IOUtils.close(bufferedReader2);
                            IOUtils.close(inputStream);
                            return;
                        }
                        int indexOf = readLine.indexOf(35);
                        if (indexOf >= 0) {
                            readLine = readLine.substring(0, indexOf);
                        }
                        String trim = readLine.trim();
                        if (trim.length() != 0) {
                            set.add(trim);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        IOUtils.close(bufferedReader);
                        IOUtils.close(inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }
}
