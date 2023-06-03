package com.baidu.nps.runtime.resources;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tieba.ig1;
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
/* loaded from: classes3.dex */
public class ResourcesHookUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Set<Integer>> sAddedAssetsMap;
    public static Map<String, Set<String>> sAddedGroupMap;
    public static Map<String, Set<Integer>> sGroupRecoveryRecord;
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
        sGroupRecoveryRecord = new HashMap();
        sAddedGroupMap = new HashMap();
    }

    public ResourcesHookUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                            ig1.d(assets, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
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

    public static Set<String> getRecoveryAssetsPathByGroup(int i, String str) {
        InterceptResult invokeIL;
        Set<String> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            if (!sAddedAssetsMap.isEmpty() && (set = sAddedGroupMap.get(str)) != null && !set.isEmpty()) {
                for (String str2 : set) {
                    Set<Integer> set2 = sAddedAssetsMap.get(str2);
                    if (set2 != null && set2.contains(Integer.valueOf(i))) {
                        hashSet.add(str2);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeIL.objValue;
    }

    public static synchronized boolean hookAssets(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        boolean hookAssets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, assetManager, str)) == null) {
            synchronized (ResourcesHookUtil.class) {
                hookAssets = hookAssets(assetManager, str, null);
            }
            return hookAssets;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean hookResources(Resources resources, String str) {
        InterceptResult invokeLL;
        boolean hookResources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, resources, str)) == null) {
            synchronized (ResourcesHookUtil.class) {
                hookResources = hookResources(resources, str, null);
            }
            return hookResources;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean hookAssets(AssetManager assetManager, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, assetManager, str, str2)) == null) {
            synchronized (ResourcesHookUtil.class) {
                if (assetManager == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                int hashCode = assetManager.hashCode();
                Set<Integer> set = sAddedAssetsMap.get(str);
                if (set != null && set.contains(Integer.valueOf(hashCode))) {
                    return true;
                }
                if (!new File(str).exists()) {
                    return false;
                }
                try {
                    ig1.d(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                    if (set == null) {
                        set = new HashSet<>();
                        sAddedAssetsMap.put(str, set);
                        if (!TextUtils.isEmpty(str2)) {
                            recordAddByGroup(str2, str);
                        }
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
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized boolean hookResources(Resources resources, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, resources, str, str2)) == null) {
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
                if (set != null && set.contains(Integer.valueOf(hashCode))) {
                    return true;
                }
                if (!new File(str).exists()) {
                    return false;
                }
                try {
                    ig1.d(assets, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                    if (set == null) {
                        set = new HashSet<>();
                        sAddedAssetsMap.put(str, set);
                        if (!TextUtils.isEmpty(str2)) {
                            recordAddByGroup(str2, str);
                        }
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
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized boolean recoveryAssetsByGroup(AssetManager assetManager, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, assetManager, i, str)) == null) {
            synchronized (ResourcesHookUtil.class) {
                if (assetManager == null) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Set<Integer> set = sGroupRecoveryRecord.get(str);
                boolean z = true;
                if (set != null && set.contains(Integer.valueOf(assetManager.hashCode()))) {
                    return true;
                }
                Set<String> recoveryAssetsPathByGroup = getRecoveryAssetsPathByGroup(i, str);
                if (recoveryAssetsPathByGroup != null && !recoveryAssetsPathByGroup.isEmpty()) {
                    for (String str2 : recoveryAssetsPathByGroup) {
                        z &= hookAssets(assetManager, str2, str);
                    }
                }
                if (set == null) {
                    set = new HashSet<>();
                    sGroupRecoveryRecord.put(str, set);
                }
                set.add(Integer.valueOf(assetManager.hashCode()));
                return z;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static void recordAddByGroup(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && !TextUtils.isEmpty(str)) {
            Set<String> set = sAddedGroupMap.get(str);
            if (set == null) {
                set = new HashSet<>();
                sAddedGroupMap.put(str, set);
            }
            if (!set.contains(str2)) {
                set.add(str2);
            }
        }
    }
}
