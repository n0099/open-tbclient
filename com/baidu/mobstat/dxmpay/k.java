package com.baidu.mobstat.dxmpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.mobstat.dxmpay.c;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(Activity activity) {
        InterceptResult invokeL;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (activity == null || (window = activity.getWindow()) == null) {
                return null;
            }
            return window.getDecorView();
        }
        return (View) invokeL.objValue;
    }

    public static String b(View view) {
        InterceptResult invokeL;
        ViewParent parent;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) {
            if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
                return "";
            }
            String a = a(parent.getClass());
            if ("android.widget".equals(a) || "android.view".equals(a)) {
                return "";
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            Class<?> cls = null;
            try {
                cls = Class.forName("androidx.viewpager.widget.ViewPager");
            } catch (ClassNotFoundException unused) {
            }
            if (cls != null && cls.isAssignableFrom(viewGroup.getClass())) {
                try {
                    ViewPager viewPager = (ViewPager) viewGroup;
                    ArrayList arrayList = new ArrayList();
                    int childCount = viewPager.getChildCount();
                    int i2 = 0;
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewPager.getChildAt(i3);
                        arrayList.add(childAt);
                        if (c(childAt) != null) {
                            i2++;
                        }
                    }
                    if (arrayList.size() >= 2 && i2 >= 2) {
                        try {
                            Collections.sort(arrayList, new Comparator<View>() { // from class: com.baidu.mobstat.dxmpay.k.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                        }
                                    }
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(View view2, View view3) {
                                    InterceptResult invokeLL;
                                    Interceptable interceptable2 = $ic;
                                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, view3)) == null) ? view2.getLeft() - view3.getLeft() : invokeLL.intValue;
                                }
                            });
                        } catch (Exception unused2) {
                        }
                        int left = view.getLeft() / Math.abs(((View) arrayList.get(1)).getLeft() - ((View) arrayList.get(0)).getLeft());
                        int count = viewPager.getAdapter().getCount();
                        if (count != 0) {
                            left %= count;
                        }
                        valueOf = String.valueOf(left);
                    } else {
                        valueOf = String.valueOf(viewPager.getCurrentItem());
                    }
                    return valueOf;
                } catch (Throwable unused3) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, cls)) == null) {
            if (cls == null) {
                return "";
            }
            String a = a(cls);
            if (!"android.widget".equals(a) && !"android.view".equals(a)) {
                return c(cls.getSuperclass());
            }
            return d(cls);
        }
        return (String) invokeL.objValue;
    }

    public static String d(View view) {
        InterceptResult invokeL;
        int lastIndexOf;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, view)) == null) {
            String str = null;
            try {
                if (view.getId() != 0) {
                    str = view.getResources().getResourceName(view.getId());
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str) && str.contains(":id/") && (lastIndexOf = str.lastIndexOf(":id/")) != -1 && (i2 = lastIndexOf + 4) < str.length()) {
                str = str.substring(i2);
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> e(View view) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, view)) == null) {
            Object tag = view.getTag(-96000);
            if (tag != null && (tag instanceof Map)) {
                try {
                    map = (Map) tag;
                } catch (Exception unused) {
                    map = null;
                }
                if (map != null && map.size() != 0) {
                    return map;
                }
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public static String f(View view) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, view)) == null) {
            if (view == null || (cls = view.getClass()) == null) {
                return "";
            }
            String d2 = d(cls);
            if (!TextUtils.isEmpty(d2) && cls.isAnonymousClass()) {
                d2 = d2 + "$";
            }
            return d2 == null ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, view)) == null) ? view != null && "com.android.internal.policy".equals(a(view.getClass())) && "DecorView".equals(f(view)) : invokeL.booleanValue;
    }

    public static String a(View view) {
        InterceptResult invokeL;
        String simpleName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            if (view instanceof ListView) {
                simpleName = ListView.class.getSimpleName();
            } else {
                simpleName = view instanceof WebView ? WebView.class.getSimpleName() : "";
            }
            if (TextUtils.isEmpty(simpleName)) {
                String a = a(view.getClass());
                if (!"android.widget".equals(a) && !"android.view".equals(a)) {
                    Class<?> cls = null;
                    try {
                        cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
                    } catch (Exception unused) {
                    }
                    if (cls != null && cls.isAssignableFrom(view.getClass())) {
                        simpleName = RecyclerView.TAG;
                    }
                }
            }
            if (TextUtils.isEmpty(simpleName)) {
                simpleName = c(view.getClass());
            }
            return TextUtils.isEmpty(simpleName) ? "Object" : simpleName;
        }
        return (String) invokeL.objValue;
    }

    public static Rect c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, view)) == null) {
            if (view.getVisibility() != 0) {
                return null;
            }
            Rect rect = new Rect();
            if (a(view, rect) && rect.right > rect.left && rect.bottom > rect.top) {
                return rect;
            }
            return null;
        }
        return (Rect) invokeL.objValue;
    }

    public static String d(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String b2 = b(jSONObject.getString("p"));
                    String string = jSONObject.getString("i");
                    sb.append("/" + b2 + PreferencesUtil.LEFT_MOUNT + string + PreferencesUtil.RIGHT_MOUNT);
                    String optString = jSONObject.optString("d");
                    if (!TextUtils.isEmpty(optString)) {
                        sb.append("#" + optString);
                    }
                } catch (Exception unused) {
                    return "";
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String b2 = b(jSONObject.getString("p"));
                    String string = jSONObject.getString("i");
                    sb.append("/" + b2 + PreferencesUtil.LEFT_MOUNT + string + PreferencesUtil.RIGHT_MOUNT);
                } catch (Exception unused) {
                    return "";
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            if (cls == null) {
                return "";
            }
            Package r4 = cls.getPackage();
            String name = r4 != null ? r4.getName() : "";
            return name == null ? "" : name;
        }
        return (String) invokeL.objValue;
    }

    public static String a(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view, view2)) == null) {
            if (view == null) {
                return String.valueOf(0);
            }
            if (view == view2) {
                return String.valueOf(0);
            }
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                Class<?> cls = view.getClass();
                if (cls == null) {
                    return String.valueOf(0);
                }
                String b2 = b(cls);
                if (TextUtils.isEmpty(b2)) {
                    return String.valueOf(0);
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                int i2 = 0;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt != null) {
                        if (childAt == view) {
                            break;
                        } else if (childAt.getClass() != null && b2.equals(b(childAt.getClass()))) {
                            i2++;
                        }
                    }
                }
                return String.valueOf(i2);
            }
            return String.valueOf(0);
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, cls)) == null) ? a(cls, true) : (String) invokeL.objValue;
    }

    public static String b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    sb.append("/" + string + PreferencesUtil.LEFT_MOUNT + string2 + PreferencesUtil.RIGHT_MOUNT);
                    String optString = jSONObject.optString("d");
                    if (!TextUtils.isEmpty(optString)) {
                        sb.append("#" + optString);
                    }
                } catch (Exception unused) {
                    return "";
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            String a = f.a().a(str);
            if (TextUtils.isEmpty(a)) {
                a = c.a().a(str, c.a.a);
            }
            return a == null ? "" : a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(View view, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, str)) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(str) || view == null) {
                return "";
            }
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof View)) {
                View view2 = (View) parent;
                try {
                    if (ListView.class.getSimpleName().equals(str)) {
                        if ((view2 instanceof ListView) && view.getParent() != null) {
                            str2 = String.valueOf(((ListView) view2).getPositionForView(view));
                        }
                    } else if (GridView.class.getSimpleName().equals(str)) {
                        if ((view2 instanceof GridView) && view.getParent() != null) {
                            str2 = String.valueOf(((GridView) view2).getPositionForView(view));
                        }
                    } else if (RecyclerView.TAG.equals(str)) {
                        str2 = String.valueOf(((RecyclerView) view2).getChildLayoutPosition(view));
                    }
                } catch (Throwable unused) {
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) {
            if (cls == null) {
                return "";
            }
            String a = a(cls, false);
            if (!TextUtils.isEmpty(a) && cls.isAnonymousClass()) {
                a = a + "$";
            }
            return a == null ? "" : a;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(View view, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, view, rect)) == null) {
            if (view != null) {
                if (rect != null) {
                    try {
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return view.getGlobalVisibleRect(rect);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x008b */
    public static JSONArray a(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, activity, view)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (activity == null || view == null) {
                return jSONArray;
            }
            View view2 = null;
            try {
                view2 = a(activity);
            } catch (Exception unused) {
            }
            if (view2 == null) {
                return jSONArray;
            }
            while (view != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("p", f(view));
                    String b2 = b(view);
                    if (TextUtils.isEmpty(b2)) {
                        String str = "";
                        ViewParent parent = view.getParent();
                        if (parent != null && (parent instanceof View)) {
                            str = a((View) parent);
                        }
                        b2 = a(view, str);
                        if (TextUtils.isEmpty(b2)) {
                            b2 = a(view, view2);
                        }
                    }
                    jSONObject.put("i", b2);
                    jSONObject.put("t", a(view));
                    jSONArray.put(jSONObject);
                    ViewParent parent2 = view.getParent();
                    if (parent2 == null || view == view2 || !(parent2 instanceof View) || g(view) || jSONArray.length() > 1000) {
                        break;
                    }
                    view = (View) parent2;
                } catch (Exception unused2) {
                    jSONArray = new JSONArray();
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            try {
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    jSONArray2.put(jSONArray.get(length));
                }
            } catch (Exception unused3) {
            }
            return jSONArray2;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public static String a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    sb.append("/" + string + PreferencesUtil.LEFT_MOUNT + string2 + PreferencesUtil.RIGHT_MOUNT);
                } catch (Exception unused) {
                    return "";
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String a = c.a().a(str, c.a.f37442b);
            return a == null ? "" : a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, cls, z)) == null) {
            if (!cls.isAnonymousClass()) {
                return z ? cls.getSimpleName() : cls.getName();
            }
            Class<? super Object> superclass = cls.getSuperclass();
            return superclass != null ? z ? superclass.getSimpleName() : superclass.getName() : "";
        }
        return (String) invokeLZ.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return "";
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            ResolveInfo resolveInfo = null;
            try {
                resolveInfo = packageManager.resolveActivity(intent, 0);
            } catch (Exception unused) {
            }
            if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) {
                return "";
            }
            String str = activityInfo.packageName;
            return ("android".equals(str) || TextUtils.isEmpty(str)) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            List<ResolveInfo> list = null;
            try {
                list = packageManager.queryIntentActivities(intent, 65536);
            } catch (Exception unused) {
            }
            if (list != null) {
                for (ResolveInfo resolveInfo : list) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && str.equals(activityInfo.packageName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
