package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@RestrictTo
/* loaded from: classes2.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object Xg = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> Xh;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    public static Context wrap(Context context) {
        if (Z(context)) {
            synchronized (Xg) {
                if (Xh == null) {
                    Xh = new ArrayList<>();
                } else {
                    for (int size = Xh.size() - 1; size >= 0; size--) {
                        WeakReference<TintContextWrapper> weakReference = Xh.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            Xh.remove(size);
                        }
                    }
                    for (int size2 = Xh.size() - 1; size2 >= 0; size2--) {
                        WeakReference<TintContextWrapper> weakReference2 = Xh.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                Xh.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    private static boolean Z(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof u) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed();
    }

    private TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, context.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new u(this, context.getResources());
        this.mTheme = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mTheme == null) {
            super.setTheme(i);
        } else {
            this.mTheme.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }
}
