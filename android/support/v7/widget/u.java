package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
class u extends o {
    private final WeakReference<Context> Xf;

    public u(Context context, Resources resources) {
        super(resources);
        this.Xf = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.o, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.Xf.get();
        if (drawable != null && context != null) {
            AppCompatDrawableManager.get();
            AppCompatDrawableManager.a(context, i, drawable);
        }
        return drawable;
    }
}
