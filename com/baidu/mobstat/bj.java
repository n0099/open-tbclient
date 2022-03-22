package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.au;
import com.baidu.mobstat.bt;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(Activity activity) {
        InterceptResult invokeL;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity == null || (window = activity.getWindow()) == null) {
                return null;
            }
            return window.getDecorView();
        }
        return (View) invokeL.objValue;
    }

    public static View b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, activity)) == null) {
            View a = a(activity);
            if (a != null) {
                return a.getRootView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static int c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, activity)) == null) {
            if (activity == null) {
                return 0;
            }
            WindowManager windowManager = activity.getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static int d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, activity)) == null) {
            if (activity == null) {
                return 0;
            }
            WindowManager windowManager = activity.getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static Rect e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, view)) == null) {
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

    public static String f(View view) {
        InterceptResult invokeL;
        int lastIndexOf;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, view)) == null) {
            String str = null;
            try {
                if (view.getId() != 0) {
                    str = view.getResources().getResourceName(view.getId());
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str) && str.contains(":id/") && (lastIndexOf = str.lastIndexOf(":id/")) != -1 && (i = lastIndexOf + 4) < str.length()) {
                str = str.substring(i);
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> g(View view) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, view)) == null) {
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

    public static String h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, view)) == null) {
            String str = null;
            if (view instanceof TextView) {
                CharSequence text = ((TextView) view).getText();
                if (text != null) {
                    str = text.toString();
                }
            } else if (view instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                boolean z = false;
                for (int i = 0; i < childCount && sb.length() < 128; i++) {
                    String h2 = h(viewGroup.getChildAt(i));
                    if (h2 != null && h2.length() > 0) {
                        if (z) {
                            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        }
                        sb.append(h2);
                        z = true;
                    }
                }
                if (sb.length() > 128) {
                    str = sb.substring(0, 128);
                } else if (z) {
                    str = sb.toString();
                }
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int i(View view) {
        InterceptResult invokeL;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, view)) == null) {
            return (int) (view.getAlpha() * ((Build.VERSION.SDK_INT < 14 || (background = view.getBackground()) == null) ? 0 : background.getAlpha()));
        }
        return invokeL.intValue;
    }

    @SuppressLint({"NewApi"})
    public static float j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, view)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view.getZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static String k(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, view)) == null) {
            String str = null;
            if (view instanceof TextView) {
                CharSequence text = ((TextView) view).getText();
                if (text != null) {
                    str = text.toString();
                }
            } else if (view instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                boolean z = false;
                for (int i = 0; i < childCount && sb.length() < 128; i++) {
                    String k = k(viewGroup.getChildAt(i));
                    if (k != null && k.length() > 0) {
                        if (z) {
                            sb.append("| ");
                        }
                        sb.append(k);
                        z = true;
                    }
                }
                if (sb.length() > 4096) {
                    str = sb.substring(0, 4096);
                } else if (z) {
                    str = sb.toString();
                }
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String l(View view) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, view)) == null) {
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

    public static boolean m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, view)) == null) {
            if (view == null) {
                return false;
            }
            if ((view instanceof ListView) || (view instanceof GridView)) {
                return true;
            }
            String a = a(view.getClass());
            if ("android.widget".equals(a) || "android.view".equals(a)) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            return cls != null && cls.isAssignableFrom(view.getClass());
        }
        return invokeL.booleanValue;
    }

    public static View n(View view) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, view)) == null) {
            if (view == null) {
                return null;
            }
            ViewParent parent = view.getParent();
            if ((parent instanceof View) && (view2 = (View) parent) != null && m(view2)) {
                return view2;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static int o(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, view)) == null) {
            if (view != null) {
                return view.getWidth();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int p(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, view)) == null) {
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, view)) == null) {
            if (view == null) {
                return false;
            }
            String a = a(view.getClass());
            if ("android.widget".equals(a) || "android.view".equals(a)) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            return cls != null && cls.isAssignableFrom(view.getClass());
        }
        return invokeL.booleanValue;
    }

    public static boolean r(View view) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65594, null, view)) == null) ? (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) ? false : true : invokeL.booleanValue;
    }

    public static String s(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, view)) == null) {
            String str = "";
            if (view == null) {
                return "";
            }
            Object tag = view.getTag(-97003);
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            }
            return TextUtils.isEmpty(str) ? u(view) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String t(View view) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65596, null, view)) == null) ? (view == null || (tag = view.getTag(-97004)) == null || !(tag instanceof String)) ? "" : (String) tag : (String) invokeL.objValue;
    }

    public static String u(View view) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, view)) == null) {
            if (view == null) {
                return "";
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            a(view, linkedHashMap);
            if (linkedHashMap.size() == 0) {
                return "";
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            int i = 0;
            for (Map.Entry entry : arrayList) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (intValue > i) {
                    i = intValue;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry2 : arrayList) {
                if (((Integer) entry2.getValue()).intValue() >= i && (view2 = (View) entry2.getKey()) != null && (view2 instanceof TextView)) {
                    CharSequence text = ((TextView) view2).getText();
                    String charSequence = text != null ? text.toString() : "";
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (!TextUtils.isEmpty(sb.toString())) {
                            sb.append("_");
                        }
                        sb.append(charSequence);
                    }
                }
            }
            String sb2 = sb.toString();
            return sb2.length() > 256 ? sb2.substring(0, 256) : sb2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean v(View view) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65598, null, view)) == null) ? (view == null || (tag = view.getTag(-97002)) == null || !(tag instanceof Boolean)) ? false : true : invokeL.booleanValue;
    }

    public static Rect w(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, view)) == null) {
            if (view != null && view.getVisibility() == 0) {
                Rect rect = new Rect();
                a(view, rect);
                return rect;
            }
            return null;
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean x(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65600, null, view)) == null) ? view != null && "com.android.internal.policy".equals(a(view.getClass())) && "DecorView".equals(l(view)) : invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static String a(View view) {
        InterceptResult invokeL;
        String str;
        CharSequence textOff;
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) {
            if (view == null) {
                return "";
            }
            if (view instanceof TextView) {
                str = ((view instanceof EditText) || (text = ((TextView) view).getText()) == null) ? "" : text.toString();
                if (Build.VERSION.SDK_INT >= 14 && (view instanceof Switch)) {
                    Switch r4 = (Switch) view;
                    if (r4.isChecked()) {
                        textOff = r4.getTextOn();
                    } else {
                        textOff = r4.getTextOff();
                    }
                    if (textOff != null) {
                        str = textOff.toString();
                    }
                }
            } else if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                Object selectedItem = spinner.getSelectedItem();
                if (selectedItem != null && (selectedItem instanceof String)) {
                    str = (String) selectedItem;
                } else {
                    return a(spinner.getSelectedView());
                }
            } else {
                str = "";
            }
            byte[] bytes = str.getBytes();
            return bytes.length > 4096 ? Build.VERSION.SDK_INT >= 9 ? new String(Arrays.copyOf(bytes, 4096)) : "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(View view) {
        InterceptResult invokeL;
        String simpleName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, view)) == null) {
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

    public static String c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, cls)) == null) {
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

    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, view)) == null) {
            if (view.getVisibility() != 0) {
                return false;
            }
            return a(view, new Rect());
        }
        return invokeL.booleanValue;
    }

    public static String e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, activity)) == null) {
            if (activity == null || activity.getClass() == null) {
                return "";
            }
            String name = activity.getClass().getName();
            return !TextUtils.isEmpty(name) ? name : "";
        }
        return (String) invokeL.objValue;
    }

    public static String g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, activity)) == null) {
            if (activity == null) {
                return "";
            }
            String h2 = h(activity);
            if (TextUtils.isEmpty(h2)) {
                Uri i = i(activity);
                if (i != null) {
                    String host = i.getHost();
                    return !TextUtils.isEmpty(host) ? host : "";
                }
                return "";
            }
            return h2;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(22)
    public static Uri i(Activity activity) {
        InterceptResult invokeL;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, activity)) == null) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 17 || (uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER")) == null) {
                if (Build.VERSION.SDK_INT >= 22) {
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        return Uri.parse(stringExtra);
                    }
                }
                if (Build.VERSION.SDK_INT >= 22) {
                    return activity.getReferrer();
                }
                return null;
            }
            return uri;
        }
        return (Uri) invokeL.objValue;
    }

    public static String f(Activity activity) {
        InterceptResult invokeL;
        CharSequence title;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, activity)) == null) {
            String charSequence = (activity == null || (title = activity.getTitle()) == null) ? "" : title.toString();
            String str = TextUtils.isEmpty(charSequence) ? "" : charSequence;
            return str.length() > 256 ? str.substring(0, 256) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
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

    public static String c(View view) {
        InterceptResult invokeL;
        ViewParent parent;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, view)) == null) {
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
                    int i = 0;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewPager.getChildAt(i2);
                        arrayList.add(childAt);
                        if (e(childAt) != null) {
                            i++;
                        }
                    }
                    if (arrayList.size() >= 2 && i >= 2) {
                        try {
                            Collections.sort(arrayList, new Comparator<View>() { // from class: com.baidu.mobstat.bj.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
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

    public static String b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bitmap)) == null) {
            byte[] c2 = c(bitmap);
            return c2 != null ? bt.a.a(c2) : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(View view, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, view, str)) == null) ? "ListView".equals(str) || RecyclerView.TAG.equals(str) || "GridView".equals(str) || view.isClickable() : invokeLL.booleanValue;
    }

    public static String b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
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

    public static String h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, activity)) == null) ? activity.getCallingPackage() : (String) invokeL.objValue;
    }

    public static String d(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, cls)) == null) ? a(cls, true) : (String) invokeL.objValue;
    }

    public static String a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, view, view2)) == null) {
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
                int i = 0;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null) {
                        if (childAt == view) {
                            break;
                        } else if (childAt.getClass() != null && b2.equals(b(childAt.getClass()))) {
                            i++;
                        }
                    }
                }
                return String.valueOf(i);
            }
            return String.valueOf(0);
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            String a = ay.a().a(str);
            if (TextUtils.isEmpty(a)) {
                a = au.a().a(str, au.a.a);
            }
            return a == null ? "" : a;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] c(Bitmap bitmap) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65571, null, bitmap)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        r0 = null;
        byte[] bArr = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused4) {
            return bArr;
        }
    }

    public static String b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, cls)) == null) {
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

    public static String c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Integer> b(Activity activity, View view) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, activity, view)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (view == null) {
                arrayList.add(0);
                arrayList.add(0);
                return arrayList;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (view instanceof WebView) {
                i = view.getScrollX();
                i2 = view.getScrollY();
            } else {
                if (view instanceof ScrollView) {
                    ScrollView scrollView = (ScrollView) view;
                    if (scrollView.getChildCount() > 0) {
                        i = scrollView.getScrollX();
                        i2 = scrollView.getScrollY();
                    }
                    i2 = 0;
                } else if (view instanceof ListView) {
                    i2 = b((ListView) view);
                } else if (view instanceof GridView) {
                    i2 = b((GridView) view);
                } else {
                    if (q(view)) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) view;
                            i = recyclerView.computeHorizontalScrollOffset();
                            try {
                                i2 = recyclerView.computeVerticalScrollOffset();
                            } catch (Exception unused) {
                                i2 = 0;
                                i3 = width + i;
                                int i4 = height + i2;
                                if (i3 <= 0) {
                                }
                                if (i4 > 0) {
                                }
                                arrayList.add(Integer.valueOf(i3));
                                arrayList.add(Integer.valueOf(r0));
                                return arrayList;
                            }
                        } catch (Exception unused2) {
                            i = 0;
                        }
                    }
                    i2 = 0;
                }
                i = 0;
            }
            i3 = width + i;
            int i42 = height + i2;
            if (i3 <= 0) {
                i3 = 0;
            }
            int i5 = i42 > 0 ? i42 : 0;
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(i5));
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static String a(View view, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, view, str)) == null) {
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

    public static String c(View view, String str) {
        InterceptResult invokeLL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, view, str)) == null) {
            String str2 = (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) ? "" : (String) tag;
            return (str == null || !TextUtils.isEmpty(str2)) ? str2 : str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(Activity activity, View view) {
        InterceptResult invokeLL;
        View a;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, activity, view)) == null) ? (activity == null || view == null || (a = a(activity)) == null || !x(view) || a == view) ? false : true : invokeLL.booleanValue;
    }

    public static String a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            byte[] c2 = c(bitmap);
            if (c2 != null) {
                try {
                    return bp.b(c2);
                } catch (Exception unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(View view, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, view, rect)) == null) {
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

    public static int b(ListView listView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, listView)) == null) {
            if (listView != null && listView.getChildCount() > 0) {
                View childAt = listView.getChildAt(0);
                return (-childAt.getTop()) + (listView.getFirstVisiblePosition() * childAt.getHeight());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x008c */
    public static JSONArray a(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, activity, view)) == null) {
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
                    jSONObject.put("p", l(view));
                    String c2 = c(view);
                    if (TextUtils.isEmpty(c2)) {
                        String str = "";
                        ViewParent parent = view.getParent();
                        if (parent != null && (parent instanceof View)) {
                            str = b((View) parent);
                        }
                        c2 = a(view, str);
                        if (TextUtils.isEmpty(c2)) {
                            c2 = a(view, view2);
                        }
                    }
                    jSONObject.put("i", c2);
                    jSONObject.put("t", b(view));
                    jSONArray.put(jSONObject);
                    ViewParent parent2 = view.getParent();
                    if (parent2 == null || view == view2 || !(parent2 instanceof View) || x(view) || jSONArray.length() > 1000) {
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

    @TargetApi(11)
    public static int b(GridView gridView) {
        InterceptResult invokeL;
        int numColumns;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, gridView)) == null) {
            if (gridView != null && gridView.getChildCount() > 0) {
                View childAt = gridView.getChildAt(0);
                int i = 1;
                if (Build.VERSION.SDK_INT >= 11 && (numColumns = gridView.getNumColumns()) != 0) {
                    i = gridView.getFirstVisiblePosition() / numColumns;
                }
                return (-childAt.getTop()) + (i * childAt.getHeight());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            String a = au.a().a(str, au.a.f27247b);
            return a == null ? "" : a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, cls, z)) == null) {
            if (!cls.isAnonymousClass()) {
                return z ? cls.getSimpleName() : cls.getName();
            }
            Class<? super Object> superclass = cls.getSuperclass();
            return superclass != null ? z ? superclass.getSimpleName() : superclass.getName() : "";
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static View a(View view, Activity activity) {
        InterceptResult invokeLL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view, activity)) == null) {
            if (view == null || activity == null) {
                return null;
            }
            try {
                view2 = a(activity);
            } catch (Exception unused) {
                view2 = null;
            }
            if (view2 == null) {
                return null;
            }
            while (view != null && view != view2 && view.getParent() != null && (view.getParent() instanceof View)) {
                View view3 = (View) view.getParent();
                if (m(view3)) {
                    return view;
                }
                view = view3;
            }
            return null;
        }
        return (View) invokeLL.objValue;
    }

    public static int a(ListView listView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, listView)) == null) {
            int height = listView.getHeight();
            if (listView.getChildCount() <= 0) {
                return height;
            }
            int height2 = listView.getChildAt(0).getHeight();
            ListAdapter adapter = listView.getAdapter();
            int count = height2 * (adapter != null ? adapter.getCount() : 1);
            return count >= height ? count : height;
        }
        return invokeL.intValue;
    }

    @TargetApi(11)
    public static int a(GridView gridView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gridView)) == null) {
            int height = gridView.getHeight();
            if (gridView.getChildCount() <= 0) {
                return height;
            }
            int height2 = gridView.getChildAt(0).getHeight();
            int i = 1;
            if (Build.VERSION.SDK_INT >= 11) {
                ListAdapter adapter = gridView.getAdapter();
                int numColumns = gridView.getNumColumns();
                if (adapter != null && numColumns != 0) {
                    i = (int) Math.ceil(adapter.getCount() / numColumns);
                }
            }
            int i2 = height2 * i;
            return i2 >= height ? i2 : height;
        }
        return invokeL.intValue;
    }

    public static void a(View view, LinkedHashMap<View, Integer> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, view, linkedHashMap) == null) || view == null) {
            return;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getVisibility() == 0) {
                linkedHashMap.put(view, Integer.valueOf((int) (textView.getTextSize() * 10.0f)));
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i), linkedHashMap);
            }
        }
    }

    public static boolean a(View view, float f2) {
        InterceptResult invokeLF;
        Rect w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65552, null, view, f2)) == null) {
            if (view == null) {
                return false;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            return width * height > 0 && (w = w(view)) != null && ((float) (w.width() * w.height())) >= (f2 * ((float) width)) * ((float) height);
        }
        return invokeLF.booleanValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
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
