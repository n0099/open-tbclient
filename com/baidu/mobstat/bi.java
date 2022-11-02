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
import com.baidu.mobstat.at;
import com.baidu.mobstat.bs;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            if (i2 >= height) {
                return i2;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public static String f(View view2) {
        InterceptResult invokeL;
        int lastIndexOf;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, view2)) == null) {
            String str = null;
            try {
                if (view2.getId() != 0) {
                    str = view2.getResources().getResourceName(view2.getId());
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str) && str.contains(":id/") && (lastIndexOf = str.lastIndexOf(":id/")) != -1 && (i = lastIndexOf + 4) < str.length()) {
                str = str.substring(i);
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(22)
    public static Uri i(Activity activity) {
        InterceptResult invokeL;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, activity)) == null) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 17 && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER")) != null) {
                return uri;
            }
            if (Build.VERSION.SDK_INT >= 22) {
                String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                if (!TextUtils.isEmpty(stringExtra)) {
                    return Uri.parse(stringExtra);
                }
            }
            if (Build.VERSION.SDK_INT < 22) {
                return null;
            }
            return activity.getReferrer();
        }
        return (Uri) invokeL.objValue;
    }

    public static String m(View view2) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, view2)) == null) {
            if (view2 == null || (cls = view2.getClass()) == null) {
                return "";
            }
            String d = d(cls);
            if (!TextUtils.isEmpty(d) && cls.isAnonymousClass()) {
                d = d + "$";
            }
            if (d == null) {
                return "";
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public static boolean n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            if ((view2 instanceof ListView) || (view2 instanceof GridView)) {
                return true;
            }
            String a = a(view2.getClass());
            if ("android.widget".equals(a) || "android.view".equals(a)) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            if (cls == null || !cls.isAssignableFrom(view2.getClass())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int a(ListView listView) {
        InterceptResult invokeL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, listView)) == null) {
            int i = 0;
            try {
                height = listView.getHeight();
            } catch (Exception e) {
                e = e;
            }
            try {
            } catch (Exception e2) {
                e = e2;
                i = height;
                e.printStackTrace();
                return i;
            }
            if (listView.getChildCount() <= 0) {
                return height;
            }
            int height2 = listView.getChildAt(0).getHeight();
            int i2 = 1;
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                i2 = adapter.getCount();
            }
            i = height2 * i2;
            if (i < height) {
                return height;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @TargetApi(11)
    public static int b(GridView gridView) {
        InterceptResult invokeL;
        int numColumns;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, gridView)) == null) {
            if (gridView == null || gridView.getChildCount() <= 0) {
                return 0;
            }
            View childAt = gridView.getChildAt(0);
            int i = 1;
            if (Build.VERSION.SDK_INT >= 11 && (numColumns = gridView.getNumColumns()) != 0) {
                i = gridView.getFirstVisiblePosition() / numColumns;
            }
            return (-childAt.getTop()) + (i * childAt.getHeight());
        }
        return invokeL.intValue;
    }

    public static String c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, cls)) == null) {
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

    public static Rect e(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, view2)) == null) {
            if (view2.getVisibility() != 0) {
                return null;
            }
            Rect rect = new Rect();
            if (!a(view2, rect) || rect.right <= rect.left || rect.bottom <= rect.top) {
                return null;
            }
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static String f(Activity activity) {
        InterceptResult invokeL;
        String str;
        CharSequence title;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, activity)) == null) {
            String str2 = "";
            if (activity == null || (title = activity.getTitle()) == null) {
                str = "";
            } else {
                str = title.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            if (str2.length() > 256) {
                return str2.substring(0, 256);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, activity)) == null) {
            if (activity == null) {
                return "";
            }
            String h = h(activity);
            if (!TextUtils.isEmpty(h)) {
                return h;
            }
            Uri i = i(activity);
            if (i == null) {
                return "";
            }
            String host = i.getHost();
            if (TextUtils.isEmpty(host)) {
                return "";
            }
            return host;
        }
        return (String) invokeL.objValue;
    }

    public static boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            String a = a(view2.getClass());
            if ("android.widget".equals(a) || "android.view".equals(a)) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            if (cls == null || !cls.isAssignableFrom(view2.getClass())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean x(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, view2)) == null) {
            if (view2 == null || !"com.android.internal.policy".equals(a(view2.getClass())) || !"DecorView".equals(m(view2))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

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
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, activity)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, activity)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, activity)) == null) {
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

    public static String e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, activity)) == null) {
            if (activity == null || activity.getClass() == null) {
                return "";
            }
            String name = activity.getClass().getName();
            if (TextUtils.isEmpty(name)) {
                return "";
            }
            return name;
        }
        return (String) invokeL.objValue;
    }

    public static String h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, activity)) == null) {
            return activity.getCallingPackage();
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static int i(View view2) {
        InterceptResult invokeL;
        int i;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, view2)) == null) {
            float alpha = view2.getAlpha();
            if (Build.VERSION.SDK_INT >= 14 && (background = view2.getBackground()) != null) {
                i = background.getAlpha();
            } else {
                i = 0;
            }
            return (int) (alpha * i);
        }
        return invokeL.intValue;
    }

    @SuppressLint({"NewApi"})
    public static float j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, view2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return view2.getZ();
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static String l(View view2) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, view2)) == null) {
            try {
                str = k(view2);
            } catch (Throwable unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static View o(View view2) {
        InterceptResult invokeL;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View) || (view3 = (View) parent) == null || !n(view3)) {
                return null;
            }
            return view3;
        }
        return (View) invokeL.objValue;
    }

    public static int p(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, view2)) == null) {
            if (view2 != null) {
                return view2.getWidth();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int q(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, view2)) == null) {
            if (view2 != null) {
                return view2.getHeight();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean s(View view2) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, view2)) == null) {
            if (view2 == null || (tag = view2.getTag(-97001)) == null || !(tag instanceof String)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Map<String, String> t(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, view2)) == null) {
            return a(view2, true);
        }
        return (Map) invokeL.objValue;
    }

    public static String u(View view2) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, view2)) == null) {
            if (view2 == null || (tag = view2.getTag(-97004)) == null || !(tag instanceof String)) {
                return "";
            }
            return (String) tag;
        }
        return (String) invokeL.objValue;
    }

    public static boolean v(View view2) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, view2)) == null) {
            if (view2 == null || (tag = view2.getTag(-97002)) == null || !(tag instanceof Boolean)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Rect w(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, view2)) == null) {
            if (view2 == null || view2.getVisibility() != 0) {
                return null;
            }
            Rect rect = new Rect();
            a(view2, rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static View a(View view2, Activity activity) {
        InterceptResult invokeLL;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view2, activity)) == null) {
            if (view2 == null || activity == null) {
                return null;
            }
            try {
                view3 = a(activity);
            } catch (Exception unused) {
                view3 = null;
            }
            if (view3 == null) {
                return null;
            }
            while (view2 != null && view2 != view3 && view2.getParent() != null && (view2.getParent() instanceof View)) {
                View view4 = (View) view2.getParent();
                if (n(view4)) {
                    return view2;
                }
                view2 = view4;
            }
            return null;
        }
        return (View) invokeLL.objValue;
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
            if ("android".equals(str) || TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            byte[] c = c(bitmap);
            if (c != null) {
                try {
                    return bo.b(c);
                } catch (Exception unused) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, bitmap)) == null) {
            byte[] c = c(bitmap);
            if (c != null) {
                return bs.a.a(c);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, cls)) == null) {
            return a(cls, true);
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String a(View view2) {
        InterceptResult invokeL;
        String str;
        CharSequence textOff;
        CharSequence text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) {
            if (view2 == null) {
                return "";
            }
            if (view2 instanceof TextView) {
                if ((view2 instanceof EditText) || (text = ((TextView) view2).getText()) == null) {
                    str = "";
                } else {
                    str = text.toString();
                }
                if (Build.VERSION.SDK_INT >= 14 && (view2 instanceof Switch)) {
                    Switch r4 = (Switch) view2;
                    if (r4.isChecked()) {
                        textOff = r4.getTextOn();
                    } else {
                        textOff = r4.getTextOff();
                    }
                    if (textOff != null) {
                        str = textOff.toString();
                    }
                }
            } else if (!(view2 instanceof Spinner)) {
                str = "";
            } else {
                Spinner spinner = (Spinner) view2;
                Object selectedItem = spinner.getSelectedItem();
                if (selectedItem != null && (selectedItem instanceof String)) {
                    str = (String) selectedItem;
                } else {
                    return a(spinner.getSelectedView());
                }
            }
            byte[] bytes = str.getBytes();
            if (bytes.length > 4096) {
                if (Build.VERSION.SDK_INT < 9) {
                    return "";
                }
                return new String(Arrays.copyOf(bytes, 4096));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(View view2) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, view2)) == null) {
            if (view2 instanceof ListView) {
                str = ListView.class.getSimpleName();
            } else if (view2 instanceof WebView) {
                str = WebView.class.getSimpleName();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                String a = a(view2.getClass());
                if (!"android.widget".equals(a) && !"android.view".equals(a)) {
                    Class<?> cls = null;
                    try {
                        cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
                    } catch (Exception unused) {
                    }
                    if (cls != null && cls.isAssignableFrom(view2.getClass())) {
                        str = RecyclerView.TAG;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = c(view2.getClass());
            }
            if (TextUtils.isEmpty(str)) {
                return "Object";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    String b = b(jSONObject.getString("p"));
                    String string = jSONObject.getString("i");
                    sb.append("/" + b + PreferencesUtil.LEFT_MOUNT + string + PreferencesUtil.RIGHT_MOUNT);
                } catch (Exception unused) {
                    return "";
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    String b = b(jSONObject.getString("p"));
                    String string = jSONObject.getString("i");
                    sb.append("/" + b + PreferencesUtil.LEFT_MOUNT + string + PreferencesUtil.RIGHT_MOUNT);
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

    public static String h(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, view2)) == null) {
            String str = null;
            if (view2 instanceof TextView) {
                CharSequence text = ((TextView) view2).getText();
                if (text != null) {
                    str = text.toString();
                }
            } else if (view2 instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                boolean z = false;
                for (int i = 0; i < childCount && sb.length() < 128; i++) {
                    String h = h(viewGroup.getChildAt(i));
                    if (h != null && h.length() > 0) {
                        if (z) {
                            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        }
                        sb.append(h);
                        z = true;
                    }
                }
                if (sb.length() > 128) {
                    str = sb.substring(0, 128);
                } else if (z) {
                    str = sb.toString();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, view2)) == null) {
            String str = null;
            if (view2 instanceof TextView) {
                CharSequence text = ((TextView) view2).getText();
                if (text != null) {
                    str = text.toString();
                }
            } else if (view2 instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view2;
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
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String a(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, view2, view3)) == null) {
            if (view2 == null) {
                return String.valueOf(0);
            }
            if (view2 == view3) {
                return String.valueOf(0);
            }
            ViewParent parent = view2.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                Class<?> cls = view2.getClass();
                if (cls == null) {
                    return String.valueOf(0);
                }
                String b = b(cls);
                if (TextUtils.isEmpty(b)) {
                    return String.valueOf(0);
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                int i = 0;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null) {
                        if (childAt == view2) {
                            break;
                        } else if (childAt.getClass() != null && b.equals(b(childAt.getClass()))) {
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

    public static String a(View view2, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, view2, str)) == null) {
            String str2 = "";
            if (TextUtils.isEmpty(str) || view2 == null) {
                return "";
            }
            ViewParent parent = view2.getParent();
            if (parent != null && (parent instanceof View)) {
                View view3 = (View) parent;
                try {
                    if (ListView.class.getSimpleName().equals(str)) {
                        if ((view3 instanceof ListView) && view2.getParent() != null) {
                            str2 = String.valueOf(((ListView) view3).getPositionForView(view2));
                        }
                    } else if (GridView.class.getSimpleName().equals(str)) {
                        if ((view3 instanceof GridView) && view2.getParent() != null) {
                            str2 = String.valueOf(((GridView) view3).getPositionForView(view2));
                        }
                    } else if (RecyclerView.TAG.equals(str)) {
                        str2 = String.valueOf(((RecyclerView) view3).getChildLayoutPosition(view2));
                    }
                } catch (Throwable unused) {
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Class<?> cls) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            if (cls == null) {
                return "";
            }
            Package r4 = cls.getPackage();
            if (r4 == null) {
                str = "";
            } else {
                str = r4.getName();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            String a = ax.a().a(str);
            if (TextUtils.isEmpty(a)) {
                a = at.a().a(str, at.a.a);
            }
            if (a == null) {
                return "";
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, view2)) == null) {
            if (view2.getVisibility() != 0) {
                return false;
            }
            return a(view2, new Rect());
        }
        return invokeL.booleanValue;
    }

    public static String a(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, cls, z)) == null) {
            if (cls.isAnonymousClass()) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null) {
                    if (z) {
                        return superclass.getSimpleName();
                    }
                    return superclass.getName();
                }
                return "";
            } else if (z) {
                return cls.getSimpleName();
            } else {
                return cls.getName();
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean b(View view2, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, view2, str)) == null) {
            if ("ListView".equals(str) || RecyclerView.TAG.equals(str) || "GridView".equals(str) || view2.isClickable()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String c(View view2, String str) {
        InterceptResult invokeLL;
        String str2;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, view2, str)) == null) {
            if (view2 != null && (tag = view2.getTag(-97001)) != null && (tag instanceof String)) {
                str2 = (String) tag;
            } else {
                str2 = "";
            }
            if (str == null || !TextUtils.isEmpty(str2)) {
                return str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            String a = at.a().a(str, at.a.b);
            if (a == null) {
                return "";
            }
            return a;
        }
        return (String) invokeL.objValue;
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

    public static String b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, jSONArray)) == null) {
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

    public static Map<String, String> a(View view2, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, view2, z)) == null) {
            HashMap hashMap = new HashMap();
            if (view2 == null) {
                return hashMap;
            }
            Object tag = view2.getTag(-97003);
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else {
                str = "";
            }
            Map<String, String> b = b(view2, z);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("title", str);
            } else {
                hashMap.put("title", b.get("title"));
            }
            hashMap.put("content", b.get("content"));
            return hashMap;
        }
        return (Map) invokeLZ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x008c */
    public static JSONArray a(Activity activity, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, activity, view2)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (activity != null && view2 != null) {
                View view3 = null;
                try {
                    view3 = a(activity);
                } catch (Exception unused) {
                }
                if (view3 == null) {
                    return jSONArray;
                }
                while (view2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("p", m(view2));
                        String c = c(view2);
                        if (TextUtils.isEmpty(c)) {
                            String str = "";
                            ViewParent parent = view2.getParent();
                            if (parent != null && (parent instanceof View)) {
                                str = b((View) parent);
                            }
                            c = a(view2, str);
                            if (TextUtils.isEmpty(c)) {
                                c = a(view2, view3);
                            }
                        }
                        jSONObject.put("i", c);
                        jSONObject.put("t", b(view2));
                        jSONArray.put(jSONObject);
                        ViewParent parent2 = view2.getParent();
                        if (parent2 == null || view2 == view3 || !(parent2 instanceof View) || x(view2) || jSONArray.length() > 1000) {
                            break;
                        }
                        view2 = (View) parent2;
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
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Integer> b(Activity activity, View view2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, activity, view2)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int i5 = 0;
            if (view2 == null) {
                arrayList.add(0);
                arrayList.add(0);
                return arrayList;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (view2 instanceof WebView) {
                i = view2.getScrollX();
                i2 = view2.getScrollY();
            } else {
                if (view2 instanceof ScrollView) {
                    ScrollView scrollView = (ScrollView) view2;
                    if (scrollView.getChildCount() > 0) {
                        i = scrollView.getScrollX();
                        i2 = scrollView.getScrollY();
                    }
                    i2 = 0;
                } else if (view2 instanceof ListView) {
                    i2 = b((ListView) view2);
                } else if (view2 instanceof GridView) {
                    i2 = b((GridView) view2);
                } else {
                    if (r(view2)) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) view2;
                            i = recyclerView.computeHorizontalScrollOffset();
                            try {
                                i2 = recyclerView.computeVerticalScrollOffset();
                            } catch (Exception unused) {
                                i2 = 0;
                                i3 = width + i;
                                i4 = height + i2;
                                if (i3 <= 0) {
                                }
                                if (i4 > 0) {
                                }
                                arrayList.add(Integer.valueOf(i3));
                                arrayList.add(Integer.valueOf(i5));
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
            i4 = height + i2;
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 > 0) {
                i5 = i4;
            }
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(i5));
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static void a(View view2, LinkedHashMap<View, Integer> linkedHashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65551, null, view2, linkedHashMap) != null) || view2 == null) {
            return;
        }
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            if (textView.getVisibility() == 0) {
                linkedHashMap.put(view2, Integer.valueOf((int) (textView.getTextSize() * 10.0f)));
            }
        } else if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i), linkedHashMap);
            }
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
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
            if (list == null) {
                return false;
            }
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && str.equals(activityInfo.packageName)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(View view2, float f) {
        InterceptResult invokeLF;
        Rect w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65553, null, view2, f)) == null) {
            if (view2 == null) {
                return false;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width * height <= 0 || (w = w(view2)) == null || w.width() * w.height() < f * width * height) {
                return false;
            }
            return true;
        }
        return invokeLF.booleanValue;
    }

    public static boolean a(View view2, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, view2, rect)) == null) {
            if (view2 == null) {
                return false;
            }
            if (rect != null) {
                try {
                } catch (Exception unused) {
                    return false;
                }
            }
            return view2.getGlobalVisibleRect(rect);
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(Activity activity, View view2) {
        InterceptResult invokeLL;
        View a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, activity, view2)) == null) {
            if (activity == null || view2 == null || (a = a(activity)) == null || !x(view2) || a == view2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static int b(ListView listView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, listView)) == null) {
            if (listView == null || listView.getChildCount() <= 0) {
                return 0;
            }
            View childAt = listView.getChildAt(0);
            return (-childAt.getTop()) + (listView.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeL.intValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, bitmap)) == null) {
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
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static Map<String, String> g(View view2) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, view2)) == null) {
            Object tag = view2.getTag(-96000);
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

    public static String b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, cls)) == null) {
            if (cls == null) {
                return "";
            }
            String a = a(cls, false);
            if (!TextUtils.isEmpty(a) && cls.isAnonymousClass()) {
                a = a + "$";
            }
            if (a == null) {
                return "";
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> b(View view2, boolean z) {
        InterceptResult invokeLZ;
        View view3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65565, null, view2, z)) == null) {
            HashMap hashMap = new HashMap();
            if (view2 == null) {
                return hashMap;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            a(view2, linkedHashMap);
            StringBuilder sb = new StringBuilder();
            if (linkedHashMap.size() == 0) {
                return hashMap;
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            Iterator it = arrayList.iterator();
            int i = 0;
            boolean z2 = false;
            while (true) {
                String str2 = "";
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                int intValue = ((Integer) entry.getValue()).intValue();
                if (intValue > i) {
                    i = intValue;
                }
                View view4 = (View) entry.getKey();
                if (view4 != null && (view4 instanceof TextView)) {
                    CharSequence text = ((TextView) view4).getText();
                    if (text != null) {
                        str2 = text.toString();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.isEmpty(sb.toString())) {
                            sb.append("_");
                        }
                        sb.append(str2);
                        if (!z || str2.contains("广告")) {
                            z2 = true;
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2) && z2) {
                if (sb2.length() > 256) {
                    sb2 = sb2.substring(0, 256);
                }
                hashMap.put("content", sb2);
            }
            StringBuilder sb3 = new StringBuilder();
            for (Map.Entry entry2 : arrayList) {
                if (((Integer) entry2.getValue()).intValue() >= i && (view3 = (View) entry2.getKey()) != null && (view3 instanceof TextView)) {
                    CharSequence text2 = ((TextView) view3).getText();
                    if (text2 == null) {
                        str = "";
                    } else {
                        str = text2.toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(sb3.toString())) {
                            sb3.append("_");
                        }
                        sb3.append(str);
                    }
                }
            }
            String sb4 = sb3.toString();
            if (!TextUtils.isEmpty(sb4)) {
                if (sb4.length() > 256) {
                    sb4 = sb4.substring(0, 256);
                }
                hashMap.put("title", sb4);
            }
            return hashMap;
        }
        return (Map) invokeLZ.objValue;
    }

    public static String c(View view2) {
        InterceptResult invokeL;
        ViewParent parent;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, view2)) == null) {
            if (view2 == null || (parent = view2.getParent()) == null || !(parent instanceof ViewGroup)) {
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
            if (cls == null || !cls.isAssignableFrom(viewGroup.getClass())) {
                return "";
            }
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
                        Collections.sort(arrayList, new Comparator<View>() { // from class: com.baidu.mobstat.bi.1
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
                            public int compare(View view3, View view4) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, view4)) == null) {
                                    return view3.getLeft() - view4.getLeft();
                                }
                                return invokeLL.intValue;
                            }
                        });
                    } catch (Exception unused2) {
                    }
                    int left = view2.getLeft() / Math.abs(((View) arrayList.get(1)).getLeft() - ((View) arrayList.get(0)).getLeft());
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
        return (String) invokeL.objValue;
    }
}
