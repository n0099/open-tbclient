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
    private static final ThreadLocal<TypedValue> EQ = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<a>> ER = new WeakHashMap<>(0);
    private static final Object ES = new Object();

    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList g = g(context, i);
        if (g == null) {
            ColorStateList f = f(context, i);
            if (f != null) {
                a(context, i, f);
                return f;
            }
            return ContextCompat.getColorStateList(context, i);
        }
        return g;
    }

    public static Drawable getDrawable(Context context, int i) {
        return AppCompatDrawableManager.get().getDrawable(context, i);
    }

    private static ColorStateList f(Context context, int i) {
        if (h(context, i)) {
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

    private static ColorStateList g(Context context, int i) {
        a aVar;
        synchronized (ES) {
            SparseArray<a> sparseArray = ER.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.EU.equals(context.getResources().getConfiguration())) {
                    return aVar.ET;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (ES) {
            SparseArray<a> sparseArray = ER.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                ER.put(context, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean h(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue ev = ev();
        resources.getValue(i, ev, true);
        return ev.type >= 28 && ev.type <= 31;
    }

    private static TypedValue ev() {
        TypedValue typedValue = EQ.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            EQ.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final ColorStateList ET;
        final Configuration EU;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.ET = colorStateList;
            this.EU = configuration;
        }
    }
}
