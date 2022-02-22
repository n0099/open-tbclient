package com.baidu.nps.runtime.resources;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.i.h;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public class ResourcesHookUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Set<Integer>> sAddedAssetsMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1956766466, "Lcom/baidu/nps/runtime/resources/ResourcesHookUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1956766466, "Lcom/baidu/nps/runtime/resources/ResourcesHookUtil;");
                return;
            }
        }
        sAddedAssetsMap = new HashMap();
    }

    public ResourcesHookUtil() {
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

    public static synchronized boolean ensureResourcesReadyForNPS(Resources resources) {
        InterceptResult invokeL;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, resources)) == null) {
            synchronized (ResourcesHookUtil.class) {
                if (sAddedAssetsMap.isEmpty()) {
                    return true;
                }
                if (resources == null) {
                    return false;
                }
                try {
                    AssetManager assets = resources.getAssets();
                    int hashCode = assets.hashCode();
                    for (String str : sAddedAssetsMap.keySet()) {
                        if (!TextUtils.isEmpty(str) && ((set = sAddedAssetsMap.get(str)) == null || !set.contains(Integer.valueOf(hashCode)))) {
                            if (!new File(str).exists()) {
                                return false;
                            }
                            h.c(assets, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                            if (set == null) {
                                set = new HashSet<>();
                                sAddedAssetsMap.put(str, set);
                            }
                            set.add(Integer.valueOf(hashCode));
                        }
                    }
                    return true;
                } catch (IllegalAccessException unused) {
                    return false;
                } catch (NoSuchMethodException unused2) {
                    return false;
                } catch (InvocationTargetException unused3) {
                    return false;
                } catch (Exception unused4) {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean hookAssets(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, assetManager, str)) == null) {
            synchronized (ResourcesHookUtil.class) {
                if (assetManager == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                int hashCode = assetManager.hashCode();
                Set<Integer> set = sAddedAssetsMap.get(str);
                if (set == null || !set.contains(Integer.valueOf(hashCode))) {
                    if (new File(str).exists()) {
                        try {
                            h.c(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                            if (set == null) {
                                set = new HashSet<>();
                                sAddedAssetsMap.put(str, set);
                            }
                            set.add(Integer.valueOf(hashCode));
                            return true;
                        } catch (IllegalAccessException unused) {
                            return false;
                        } catch (NoSuchMethodException unused2) {
                            return false;
                        } catch (InvocationTargetException unused3) {
                            return false;
                        } catch (Exception unused4) {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean hookResources(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, str)) == null) {
            synchronized (ResourcesHookUtil.class) {
                if (resources == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                AssetManager assets = resources.getAssets();
                int hashCode = assets.hashCode();
                Set<Integer> set = sAddedAssetsMap.get(str);
                if (set == null || !set.contains(Integer.valueOf(hashCode))) {
                    if (new File(str).exists()) {
                        try {
                            h.c(assets, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                            if (set == null) {
                                set = new HashSet<>();
                                sAddedAssetsMap.put(str, set);
                            }
                            set.add(Integer.valueOf(hashCode));
                            return true;
                        } catch (IllegalAccessException unused) {
                            return false;
                        } catch (NoSuchMethodException unused2) {
                            return false;
                        } catch (InvocationTargetException unused3) {
                            return false;
                        } catch (Exception unused4) {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
