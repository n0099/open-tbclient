package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    public static final String LOG_TAG = "AppCompatResources";
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();
    public static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    public static final Object sColorStateCacheLock = new Object();

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        public final Configuration configuration;
        public final ColorStateList value;

        public ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    public static void addColorStateListToCache(@NonNull Context context, @ColorRes int i2, @NonNull ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                sColorStateCaches.put(context, sparseArray);
            }
            sparseArray.append(i2, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    @Nullable
    public static ColorStateList getCachedColorStateList(@NonNull Context context, @ColorRes int i2) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i2)) != null) {
                if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.value;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList cachedColorStateList = getCachedColorStateList(context, i2);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(context, i2);
        if (inflateColorStateList != null) {
            addColorStateListToCache(context, i2, inflateColorStateList);
            return inflateColorStateList;
        }
        return ContextCompat.getColorStateList(context, i2);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        return ResourceManagerInternal.get().getDrawable(context, i2);
    }

    @NonNull
    public static TypedValue getTypedValue() {
        TypedValue typedValue = TL_TYPED_VALUE.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            TL_TYPED_VALUE.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    @Nullable
    public static ColorStateList inflateColorStateList(Context context, int i2) {
        if (isColorInt(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    public static boolean isColorInt(@NonNull Context context, @ColorRes int i2) {
        Resources resources = context.getResources();
        TypedValue typedValue = getTypedValue();
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        return i3 >= 28 && i3 <= 31;
    }
}
