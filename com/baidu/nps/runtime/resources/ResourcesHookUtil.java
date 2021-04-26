package com.baidu.nps.runtime.resources;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import d.a.x.i.h;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class ResourcesHookUtil {
    public static Map<String, Set<Integer>> sAddedAssetsMap = new HashMap();

    public static synchronized boolean ensureResourcesReadyForNPS(Resources resources) {
        Set<Integer> set;
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

    public static synchronized boolean hookAssets(AssetManager assetManager, String str) {
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

    public static synchronized boolean hookResources(Resources resources, String str) {
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
}
