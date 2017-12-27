package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public final class AppCompatResources {
    private static final ThreadLocal<TypedValue> ER = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<a>> ES = new WeakHashMap<>(0);
    private static final Object ET = new Object();

    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList f = f(context, i);
        if (f == null) {
            ColorStateList e = e(context, i);
            if (e != null) {
                a(context, i, e);
                return e;
            }
            return ContextCompat.getColorStateList(context, i);
        }
        return f;
    }

    public static Drawable getDrawable(Context context, int i) {
        return AppCompatDrawableManager.get().getDrawable(context, i);
    }

    private static ColorStateList e(Context context, int i) {
        if (g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return android.support.v7.content.res.a.createFromXml(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList f(Context context, int i) {
        a aVar;
        synchronized (ET) {
            SparseArray<a> sparseArray = ES.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.EV.equals(context.getResources().getConfiguration())) {
                    return aVar.EU;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (ET) {
            SparseArray<a> sparseArray = ES.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                ES.put(context, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean g(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue ev = ev();
        resources.getValue(i, ev, true);
        return ev.type >= 28 && ev.type <= 31;
    }

    private static TypedValue ev() {
        TypedValue typedValue = ER.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            ER.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final ColorStateList EU;
        final Configuration EV;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.EU = colorStateList;
            this.EV = configuration;
        }
    }
}
