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
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
/* loaded from: classes7.dex */
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
        if (a2 == null) {
            return null;
        }
        return a2.getRootView();
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

    @SuppressLint({"NewApi"})
    public static String a(View view) {
        String str;
        CharSequence textOff;
        CharSequence text;
        if (view == null) {
            return "";
        }
        if (view instanceof TextView) {
            if ((view instanceof EditText) || (text = ((TextView) view).getText()) == null) {
                str = "";
            } else {
                str = text.toString();
            }
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
        } else if (!(view instanceof Spinner)) {
            str = "";
        } else {
            Object selectedItem = ((Spinner) view).getSelectedItem();
            if (selectedItem != null && (selectedItem instanceof String)) {
                str = (String) selectedItem;
            } else {
                return a(((Spinner) view).getSelectedView());
            }
        }
        byte[] bytes = str.getBytes();
        if (bytes.length > 4096) {
            if (Build.VERSION.SDK_INT >= 9) {
                str = new String(Arrays.copyOf(bytes, 4096));
            } else {
                str = "";
            }
        }
        return str;
    }

    public static String b(View view) {
        String str = "";
        if (view instanceof ListView) {
            str = ListView.class.getSimpleName();
        } else if (view instanceof WebView) {
            str = WebView.class.getSimpleName();
        }
        if (TextUtils.isEmpty(str)) {
            String a2 = a(view.getClass());
            if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
                Class<?> cls = null;
                try {
                    cls = Class.forName("android.support.v7.widget.RecyclerView");
                } catch (Exception e) {
                }
                if (cls != null && cls.isAssignableFrom(view.getClass())) {
                    str = "RecyclerView";
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = c(view.getClass());
        }
        if (TextUtils.isEmpty(str)) {
            return "Object";
        }
        return str;
    }

    private static String c(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String a2 = a(cls);
        if ("android.widget".equals(a2) || "android.view".equals(a2)) {
            return d(cls);
        }
        return c(cls.getSuperclass());
    }

    public static String a(Class<?> cls) {
        String str = "";
        if (cls == null) {
            return "";
        }
        Package r1 = cls.getPackage();
        if (r1 != null) {
            str = r1.getName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String a(View view, View view2) {
        if (view == null) {
            return String.valueOf(0);
        }
        if (view == view2) {
            return String.valueOf(0);
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return String.valueOf(0);
        }
        Class<?> cls = view.getClass();
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
                if (childAt == view) {
                    break;
                } else if (childAt.getClass() != null && b.equals(b(childAt.getClass()))) {
                    i++;
                }
            }
        }
        return String.valueOf(i);
    }

    public static String a(View view, String str) {
        ViewParent parent;
        String str2;
        if (TextUtils.isEmpty(str) || view == null || (parent = view.getParent()) == null || !(parent instanceof View)) {
            return "";
        }
        View view2 = (View) parent;
        if (ListView.class.getSimpleName().equals(str)) {
            try {
                if (!(view2 instanceof ListView) || view.getParent() == null) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(((ListView) view2).getPositionForView(view));
                }
                return str2;
            } catch (Throwable th) {
                return "";
            }
        } else if (GridView.class.getSimpleName().equals(str)) {
            try {
                if (!(view2 instanceof GridView) || view.getParent() == null) {
                    return "";
                }
                return String.valueOf(((GridView) view2).getPositionForView(view));
            } catch (Throwable th2) {
                return "";
            }
        } else if (!"RecyclerView".equals(str)) {
            return "";
        } else {
            try {
                return String.valueOf(((RecyclerView) view2).getChildLayoutPosition(view));
            } catch (Throwable th3) {
                return "";
            }
        }
    }

    public static String c(View view) {
        ViewParent parent;
        String str;
        int i = 0;
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
            cls = Class.forName("android.support.v4.view.ViewPager");
        } catch (ClassNotFoundException e) {
        }
        if (cls == null || !cls.isAssignableFrom(viewGroup.getClass())) {
            return "";
        }
        try {
            ViewPager viewPager = (ViewPager) viewGroup;
            ArrayList arrayList = new ArrayList();
            int childCount = viewPager.getChildCount();
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
                } catch (Exception e2) {
                }
                int left = view.getLeft() / Math.abs(((View) arrayList.get(1)).getLeft() - ((View) arrayList.get(0)).getLeft());
                int count = viewPager.getAdapter().getCount();
                str = String.valueOf(count != 0 ? left % count : left);
            } else {
                str = String.valueOf(viewPager.getCurrentItem());
            }
        } catch (Throwable th) {
            str = "";
        }
        return str;
    }

    public static String a(Bitmap bitmap) {
        byte[] c = c(bitmap);
        if (c != null) {
            try {
                return bp.b(c);
            } catch (Exception e) {
            }
        }
        return "";
    }

    public static String b(Bitmap bitmap) {
        byte[] c = c(bitmap);
        return c != null ? bt.a.a(c) : "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [480=4] */
    private static byte[] c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        }
        return bArr;
    }

    public static boolean d(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        return a(view, new Rect());
    }

    public static Rect e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        if (!a(view, rect) || rect.right <= rect.left || rect.bottom <= rect.top) {
            return null;
        }
        return rect;
    }

    private static boolean a(View view, Rect rect) {
        if (view == null || rect == null) {
            return false;
        }
        try {
            return view.getGlobalVisibleRect(rect);
        } catch (Exception e) {
            return false;
        }
    }

    public static String f(View view) {
        int lastIndexOf;
        int length;
        String str = null;
        try {
            if (view.getId() != 0) {
                str = view.getResources().getResourceName(view.getId());
            }
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(str) && str.contains(":id/") && (lastIndexOf = str.lastIndexOf(":id/")) != -1 && (length = ":id/".length() + lastIndexOf) < str.length()) {
            str = str.substring(length);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static JSONArray a(Activity activity, View view) {
        View view2;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2 = new JSONArray();
        if (activity != null && view != null) {
            try {
                view2 = a(activity);
            } catch (Exception e) {
                view2 = null;
            }
            if (view2 != null) {
                while (view != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("p", l(view));
                        String c = c(view);
                        if (TextUtils.isEmpty(c)) {
                            ViewParent parent = view.getParent();
                            if (parent == null || !(parent instanceof View)) {
                                str = "";
                            } else {
                                str = b((View) parent);
                            }
                            c = a(view, str);
                            if (TextUtils.isEmpty(c)) {
                                c = a(view, view2);
                            }
                        }
                        jSONObject.put("i", c);
                        jSONObject.put("t", b(view));
                        jSONArray2.put(jSONObject);
                        ViewParent parent2 = view.getParent();
                        if (parent2 == null || view == view2 || !(parent2 instanceof View) || x(view) || jSONArray2.length() > 1000) {
                            break;
                        }
                        view = (View) parent2;
                    } catch (Exception e2) {
                        jSONArray = new JSONArray();
                    }
                }
                jSONArray = jSONArray2;
                jSONArray2 = new JSONArray();
                try {
                    for (int length = jSONArray.length() - 1; length >= 0; length--) {
                        jSONArray2.put(jSONArray.get(length));
                    }
                } catch (Exception e3) {
                }
            }
        }
        return jSONArray2;
    }

    public static Map<String, String> g(View view) {
        Map<String, String> map;
        Object tag = view.getTag(-96000);
        if (tag == null || !(tag instanceof Map)) {
            return null;
        }
        try {
            map = (Map) tag;
        } catch (Exception e) {
            map = null;
        }
        if (map == null || map.size() == 0) {
            return null;
        }
        return map;
    }

    public static boolean b(View view, String str) {
        return "ListView".equals(str) || "RecyclerView".equals(str) || "GridView".equals(str) || view.isClickable();
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
                String h = h(viewGroup.getChildAt(i));
                if (h != null && h.length() > 0) {
                    if (z) {
                        sb.append(", ");
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

    @SuppressLint({"NewApi"})
    public static int i(View view) {
        Drawable background;
        float alpha = view.getAlpha();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 14 && (background = view.getBackground()) != null) {
            i = background.getAlpha();
        }
        return (int) (i * alpha);
    }

    @SuppressLint({"NewApi"})
    public static float j(View view) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0.0f;
        }
        return view.getZ();
    }

    public static String a(JSONArray jSONArray) {
        JSONObject jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                sb.append("/" + ((JSONObject) jSONArray.get(i)).getString("p") + "[" + jSONObject.getString("i") + "]");
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + jSONObject.getString("p") + "[" + jSONObject.getString("i") + "]");
                String optString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(optString)) {
                    sb.append("#" + optString);
                }
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String c(JSONArray jSONArray) {
        JSONObject jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                sb.append("/" + b(((JSONObject) jSONArray.get(i)).getString("p")) + "[" + jSONObject.getString("i") + "]");
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + b(jSONObject.getString("p")) + "[" + jSONObject.getString("i") + "]");
                String optString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(optString)) {
                    sb.append("#" + optString);
                }
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
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
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private static String b(String str) {
        String a2 = ay.a().a(str);
        if (TextUtils.isEmpty(a2)) {
            a2 = au.a().a(str, au.a.f2563a);
        }
        if (a2 == null) {
            return "";
        }
        return a2;
    }

    public static String a(String str) {
        String a2 = au.a().a(str, au.a.b);
        if (a2 == null) {
            return "";
        }
        return a2;
    }

    public static String e(Activity activity) {
        if (activity == null || activity.getClass() == null) {
            return "";
        }
        String name = activity.getClass().getName();
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        return name;
    }

    public static String b(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String a2 = a(cls, false);
        if (!TextUtils.isEmpty(a2) && cls.isAnonymousClass()) {
            a2 = a2 + "$";
        }
        if (a2 == null) {
            return "";
        }
        return a2;
    }

    public static String l(View view) {
        Class<?> cls;
        if (view == null || (cls = view.getClass()) == null) {
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

    private static String a(Class<?> cls, boolean z) {
        if (!cls.isAnonymousClass()) {
            return z ? cls.getSimpleName() : cls.getName();
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            return z ? superclass.getSimpleName() : superclass.getName();
        }
        return "";
    }

    private static String d(Class<?> cls) {
        return a(cls, true);
    }

    public static boolean m(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof ListView) || (view instanceof GridView)) {
            return true;
        }
        String a2 = a(view.getClass());
        if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
            Class<?> cls = null;
            try {
                cls = Class.forName("android.support.v7.widget.RecyclerView");
            } catch (Exception e) {
            }
            if (cls != null && cls.isAssignableFrom(view.getClass())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(str2)) {
            return false;
        }
        return true;
    }

    public static View n(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            if (view2 == null || !m(view2)) {
                view2 = null;
            }
            return view2;
        }
        return null;
    }

    public static View a(View view, Activity activity) {
        View view2;
        View view3;
        if (view == null || activity == null) {
            return null;
        }
        try {
            view2 = a(activity);
        } catch (Exception e) {
            view2 = null;
        }
        if (view2 != null) {
            View view4 = view;
            while (view4 != null && view4 != view2 && view4.getParent() != null && (view4.getParent() instanceof View)) {
                View view5 = (View) view4.getParent();
                if (m(view5)) {
                    view3 = view4;
                    break;
                }
                view4 = view5;
            }
            view3 = null;
            return view3;
        }
        return null;
    }

    public static String f(Activity activity) {
        CharSequence title;
        String str = "";
        if (activity != null && (title = activity.getTitle()) != null) {
            str = title.toString();
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            return str.substring(0, 256);
        }
        return str;
    }

    public static int o(View view) {
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public static int p(View view) {
        if (view == null) {
            return 0;
        }
        return view.getHeight();
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
            cls = Class.forName("android.support.v7.widget.RecyclerView");
        } catch (Exception e) {
        }
        if (cls == null || !cls.isAssignableFrom(view.getClass())) {
            return false;
        }
        return true;
    }

    public static int a(ListView listView) {
        int height = listView.getHeight();
        if (listView.getChildCount() > 0) {
            int height2 = listView.getChildAt(0).getHeight();
            int i = 1;
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                i = adapter.getCount();
            }
            int i2 = i * height2;
            if (i2 < height) {
                i2 = height;
            }
            return i2;
        }
        return height;
    }

    @TargetApi(11)
    public static int a(GridView gridView) {
        int height = gridView.getHeight();
        if (gridView.getChildCount() > 0) {
            int height2 = gridView.getChildAt(0).getHeight();
            int i = 1;
            if (Build.VERSION.SDK_INT >= 11) {
                ListAdapter adapter = gridView.getAdapter();
                int numColumns = gridView.getNumColumns();
                if (adapter != null && numColumns != 0) {
                    i = (int) Math.ceil(adapter.getCount() / numColumns);
                }
            }
            int i2 = i * height2;
            if (i2 < height) {
                i2 = height;
            }
            return i2;
        }
        return height;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Integer> b(Activity activity, View view) {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (view == null) {
            arrayList.add(0);
            arrayList.add(0);
            return arrayList;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (view instanceof WebView) {
            i2 = view.getScrollX();
            i3 = view.getScrollY();
        } else if (view instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) view;
            if (scrollView.getChildCount() > 0) {
                i2 = scrollView.getScrollX();
                i3 = scrollView.getScrollY();
            }
            i3 = 0;
            i2 = 0;
        } else if (view instanceof ListView) {
            i3 = b((ListView) view);
            i2 = 0;
        } else if (view instanceof GridView) {
            i3 = b((GridView) view);
            i2 = 0;
        } else {
            if (q(view)) {
                try {
                    RecyclerView recyclerView = (RecyclerView) view;
                    i = recyclerView.computeHorizontalScrollOffset();
                    try {
                        i2 = i;
                        i3 = recyclerView.computeVerticalScrollOffset();
                    } catch (Exception e) {
                        i2 = i;
                        i3 = 0;
                        i4 = i2 + width;
                        int i5 = i3 + height;
                        if (i4 <= 0) {
                        }
                        if (i5 > 0) {
                        }
                        arrayList.add(Integer.valueOf(i4));
                        arrayList.add(Integer.valueOf(r1));
                        return arrayList;
                    }
                } catch (Exception e2) {
                    i = 0;
                }
            }
            i3 = 0;
            i2 = 0;
        }
        i4 = i2 + width;
        int i52 = i3 + height;
        if (i4 <= 0) {
            i4 = 0;
        }
        int i6 = i52 > 0 ? i52 : 0;
        arrayList.add(Integer.valueOf(i4));
        arrayList.add(Integer.valueOf(i6));
        return arrayList;
    }

    public static int b(ListView listView) {
        if (listView != null && listView.getChildCount() > 0) {
            View childAt = listView.getChildAt(0);
            return (childAt.getHeight() * listView.getFirstVisiblePosition()) + (-childAt.getTop());
        }
        return 0;
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
            return (i * childAt.getHeight()) + (-childAt.getTop());
        }
        return 0;
    }

    public static String c(View view, String str) {
        String str2;
        Object tag;
        if (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) tag;
        }
        return (str == null || !TextUtils.isEmpty(str2)) ? str2 : str;
    }

    public static boolean r(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) {
            return false;
        }
        return true;
    }

    public static String s(View view) {
        String str;
        if (view == null) {
            return "";
        }
        Object tag = view.getTag(-97003);
        if (tag == null || !(tag instanceof String)) {
            str = "";
        } else {
            str = (String) tag;
        }
        if (TextUtils.isEmpty(str)) {
            str = u(view);
        }
        return str;
    }

    public static String t(View view) {
        String str;
        if (view == null) {
            return "";
        }
        Object tag = view.getTag(-97004);
        if (tag == null || !(tag instanceof String)) {
            str = "";
        } else {
            str = (String) tag;
        }
        return str;
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
            if (intValue <= i) {
                intValue = i;
            }
            i = intValue;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : arrayList) {
            if (((Integer) entry2.getValue()).intValue() >= i && (view2 = (View) entry2.getKey()) != null && (view2 instanceof TextView)) {
                CharSequence text = ((TextView) view2).getText();
                String str = "";
                if (text != null) {
                    str = text.toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                    }
                    sb.append(str);
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.length() > 256) {
            return sb2.substring(0, 256);
        }
        return sb2;
    }

    private static void a(View view, LinkedHashMap<View, Integer> linkedHashMap) {
        if (view != null) {
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
    }

    private static Rect w(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        a(view, rect);
        return rect;
    }

    public static boolean a(View view, float f) {
        Rect w;
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width * height <= 0 || (w = w(view)) == null) {
            return false;
        }
        if (w.height() * w.width() < width * f * height) {
            return false;
        }
        return true;
    }

    public static boolean v(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(-97002)) == null || !(tag instanceof Boolean)) {
            return false;
        }
        return true;
    }

    private static boolean x(View view) {
        if (view == null || !"com.android.internal.policy".equals(a(view.getClass())) || !"DecorView".equals(l(view))) {
            return false;
        }
        return true;
    }

    public static boolean c(Activity activity, View view) {
        View a2;
        if (activity == null || view == null || (a2 = a(activity)) == null || !x(view) || a2 == view) {
            return false;
        }
        return true;
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
        } catch (Exception e) {
        }
        if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) {
            return "";
        }
        String str = activityInfo.packageName;
        if ("android".equals(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        PackageManager packageManager;
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        List<ResolveInfo> list = null;
        try {
            list = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e) {
        }
        if (list != null) {
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && str.equals(activityInfo.packageName)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Activity activity) {
        String str;
        if (activity == null) {
            return "";
        }
        String h = h(activity);
        if (TextUtils.isEmpty(h)) {
            Uri i = i(activity);
            if (i != null) {
                str = i.getHost();
            }
            str = "";
            return str;
        }
        return h;
    }

    private static String h(Activity activity) {
        return activity.getCallingPackage();
    }

    @TargetApi(22)
    private static Uri i(Activity activity) {
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
}
