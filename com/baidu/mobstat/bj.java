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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.au;
import com.baidu.mobstat.bt;
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
/* loaded from: classes2.dex */
public class bj {
    public static View a(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }

    public static View b(Activity activity) {
        View a2 = a(activity);
        if (a2 != null) {
            return a2.getRootView();
        }
        return null;
    }

    public static int c(Activity activity) {
        if (activity == null) {
            return 0;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int d(Activity activity) {
        if (activity == null) {
            return 0;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static Rect e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        if (a(view, rect) && rect.right > rect.left && rect.bottom > rect.top) {
            return rect;
        }
        return null;
    }

    public static String f(View view) {
        int lastIndexOf;
        int i;
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

    public static Map<String, String> g(View view) {
        Map<String, String> map;
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

    public static String h(View view) {
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

    @SuppressLint({"NewApi"})
    public static int i(View view) {
        Drawable background;
        return (int) (view.getAlpha() * ((Build.VERSION.SDK_INT < 14 || (background = view.getBackground()) == null) ? 0 : background.getAlpha()));
    }

    @SuppressLint({"NewApi"})
    public static float j(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static String k(View view) {
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

    public static String l(View view) {
        Class<?> cls;
        if (view == null || (cls = view.getClass()) == null) {
            return "";
        }
        String d2 = d(cls);
        if (!TextUtils.isEmpty(d2) && cls.isAnonymousClass()) {
            d2 = d2 + "$";
        }
        return d2 == null ? "" : d2;
    }

    public static boolean m(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof ListView) || (view instanceof GridView)) {
            return true;
        }
        String a2 = a(view.getClass());
        if ("android.widget".equals(a2) || "android.view".equals(a2)) {
            return false;
        }
        Class<?> cls = null;
        try {
            cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
        } catch (Exception unused) {
        }
        return cls != null && cls.isAssignableFrom(view.getClass());
    }

    public static View n(View view) {
        View view2;
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && (view2 = (View) parent) != null && m(view2)) {
            return view2;
        }
        return null;
    }

    public static int o(View view) {
        if (view != null) {
            return view.getWidth();
        }
        return 0;
    }

    public static int p(View view) {
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public static boolean q(View view) {
        if (view == null) {
            return false;
        }
        String a2 = a(view.getClass());
        if ("android.widget".equals(a2) || "android.view".equals(a2)) {
            return false;
        }
        Class<?> cls = null;
        try {
            cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
        } catch (Exception unused) {
        }
        return cls != null && cls.isAssignableFrom(view.getClass());
    }

    public static boolean r(View view) {
        Object tag;
        return (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) ? false : true;
    }

    public static String s(View view) {
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

    public static String t(View view) {
        Object tag;
        return (view == null || (tag = view.getTag(-97004)) == null || !(tag instanceof String)) ? "" : (String) tag;
    }

    public static String u(View view) {
        View view2;
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

    public static boolean v(View view) {
        Object tag;
        return (view == null || (tag = view.getTag(-97002)) == null || !(tag instanceof Boolean)) ? false : true;
    }

    public static Rect w(View view) {
        if (view != null && view.getVisibility() == 0) {
            Rect rect = new Rect();
            a(view, rect);
            return rect;
        }
        return null;
    }

    public static boolean x(View view) {
        return view != null && "com.android.internal.policy".equals(a(view.getClass())) && "DecorView".equals(l(view));
    }

    @SuppressLint({"NewApi"})
    public static String a(View view) {
        String str;
        CharSequence textOff;
        CharSequence text;
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

    public static String b(View view) {
        String simpleName;
        if (view instanceof ListView) {
            simpleName = ListView.class.getSimpleName();
        } else {
            simpleName = view instanceof WebView ? WebView.class.getSimpleName() : "";
        }
        if (TextUtils.isEmpty(simpleName)) {
            String a2 = a(view.getClass());
            if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
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

    public static String c(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String a2 = a(cls);
        if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
            return c(cls.getSuperclass());
        }
        return d(cls);
    }

    public static boolean d(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        return a(view, new Rect());
    }

    public static String e(Activity activity) {
        if (activity == null || activity.getClass() == null) {
            return "";
        }
        String name = activity.getClass().getName();
        return !TextUtils.isEmpty(name) ? name : "";
    }

    public static String g(Activity activity) {
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

    @TargetApi(22)
    public static Uri i(Activity activity) {
        Uri uri;
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

    public static String f(Activity activity) {
        CharSequence title;
        String charSequence = (activity == null || (title = activity.getTitle()) == null) ? "" : title.toString();
        String str = TextUtils.isEmpty(charSequence) ? "" : charSequence;
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public static String d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String b2 = b(jSONObject.getString("p"));
                String string = jSONObject.getString("i");
                sb.append("/" + b2 + "[" + string + "]");
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

    public static String c(View view) {
        ViewParent parent;
        String valueOf;
        if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
            return "";
        }
        String a2 = a(parent.getClass());
        if ("android.widget".equals(a2) || "android.view".equals(a2)) {
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
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(View view2, View view3) {
                                return view2.getLeft() - view3.getLeft();
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

    public static String b(Bitmap bitmap) {
        byte[] c2 = c(bitmap);
        return c2 != null ? bt.a.a(c2) : "";
    }

    public static boolean b(View view, String str) {
        return "ListView".equals(str) || RecyclerView.TAG.equals(str) || "GridView".equals(str) || view.isClickable();
    }

    public static String b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String string = jSONObject.getString("p");
                String string2 = jSONObject.getString("i");
                sb.append("/" + string + "[" + string2 + "]");
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

    public static String h(Activity activity) {
        return activity.getCallingPackage();
    }

    public static String d(Class<?> cls) {
        return a(cls, true);
    }

    public static String a(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        Package r1 = cls.getPackage();
        String name = r1 != null ? r1.getName() : "";
        return name == null ? "" : name;
    }

    public static String a(View view, View view2) {
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

    public static String b(String str) {
        String a2 = ay.a().a(str);
        if (TextUtils.isEmpty(a2)) {
            a2 = au.a().a(str, au.a.f9011a);
        }
        return a2 == null ? "" : a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
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
        if (cls == null) {
            return "";
        }
        String a2 = a(cls, false);
        if (!TextUtils.isEmpty(a2) && cls.isAnonymousClass()) {
            a2 = a2 + "$";
        }
        return a2 == null ? "" : a2;
    }

    public static String c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String b2 = b(jSONObject.getString("p"));
                String string = jSONObject.getString("i");
                sb.append("/" + b2 + "[" + string + "]");
            } catch (Exception unused) {
                return "";
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Integer> b(Activity activity, View view) {
        int i;
        int i2;
        int i3;
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

    public static String a(View view, String str) {
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

    public static String c(View view, String str) {
        Object tag;
        String str2 = (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) ? "" : (String) tag;
        return (str == null || !TextUtils.isEmpty(str2)) ? str2 : str;
    }

    public static boolean c(Activity activity, View view) {
        View a2;
        return (activity == null || view == null || (a2 = a(activity)) == null || !x(view) || a2 == view) ? false : true;
    }

    public static String a(Bitmap bitmap) {
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

    public static boolean a(View view, Rect rect) {
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

    public static int b(ListView listView) {
        if (listView != null && listView.getChildCount() > 0) {
            View childAt = listView.getChildAt(0);
            return (-childAt.getTop()) + (listView.getFirstVisiblePosition() * childAt.getHeight());
        }
        return 0;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0088 */
    public static JSONArray a(Activity activity, View view) {
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

    @TargetApi(11)
    public static int b(GridView gridView) {
        int numColumns;
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

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String string = jSONObject.getString("p");
                String string2 = jSONObject.getString("i");
                sb.append("/" + string + "[" + string2 + "]");
            } catch (Exception unused) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        String a2 = au.a().a(str, au.a.f9012b);
        return a2 == null ? "" : a2;
    }

    public static String a(Class<?> cls, boolean z) {
        if (!cls.isAnonymousClass()) {
            return z ? cls.getSimpleName() : cls.getName();
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return superclass != null ? z ? superclass.getSimpleName() : superclass.getName() : "";
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !str.equals(str2);
    }

    public static View a(View view, Activity activity) {
        View view2;
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

    public static int a(ListView listView) {
        int height = listView.getHeight();
        if (listView.getChildCount() <= 0) {
            return height;
        }
        int height2 = listView.getChildAt(0).getHeight();
        ListAdapter adapter = listView.getAdapter();
        int count = height2 * (adapter != null ? adapter.getCount() : 1);
        return count >= height ? count : height;
    }

    @TargetApi(11)
    public static int a(GridView gridView) {
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

    public static void a(View view, LinkedHashMap<View, Integer> linkedHashMap) {
        if (view == null) {
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
        Rect w;
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        return width * height > 0 && (w = w(view)) != null && ((float) (w.width() * w.height())) >= (f2 * ((float) width)) * ((float) height);
    }

    public static String a(Context context) {
        ActivityInfo activityInfo;
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

    public static boolean a(Context context, String str) {
        PackageManager packageManager;
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
}
