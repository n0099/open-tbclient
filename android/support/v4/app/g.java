package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    public Method f282a;
    public Method b;
    public ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Activity activity) {
        try {
            this.f282a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            View findViewById = activity.findViewById(16908332);
            if (findViewById != null) {
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() == 2) {
                    View childAt = viewGroup.getChildAt(0);
                    View childAt2 = childAt.getId() != 16908332 ? childAt : viewGroup.getChildAt(1);
                    if (childAt2 instanceof ImageView) {
                        this.c = (ImageView) childAt2;
                    }
                }
            }
        }
    }
}
