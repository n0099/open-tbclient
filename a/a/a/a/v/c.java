package a.a.a.a.v;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
/* loaded from: classes4.dex */
public final class c {

    /* loaded from: classes4.dex */
    public static class a {
        public static final c BO = new c();
    }

    public void a(View view, String str, ImageView imageView) {
        a(view.getContext(), str, imageView);
    }

    public void a(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + str, new Object[0]);
                    return;
                } else {
                    Glide.with(activity).load(str).into(imageView);
                    return;
                }
            }
            Glide.with(context).load(str).into(imageView);
            return;
        }
        d.b("GlideHelper: context is null when load: " + str, new Object[0]);
    }
}
