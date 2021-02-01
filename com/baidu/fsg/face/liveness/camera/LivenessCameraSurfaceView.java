package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.camera.a;
import com.baidu.fsg.face.liveness.camera.b;
/* loaded from: classes5.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void bindSurfaceView(Activity activity, a.C0113a c0113a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0113a);
        if (a2 == null || (a2.f2297a == c0113a.f2292a && a2.f2298b == c0113a.f2293b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = a2.f2297a;
            layoutParams.height = a2.f2298b;
        }
        setLayoutParams(layoutParams);
    }

    private b.a a(Activity activity, a.C0113a c0113a) {
        if (c0113a == null) {
            return null;
        }
        a.C0113a a2 = a(activity);
        b.a aVar = new b.a(c0113a.f2292a, c0113a.f2293b);
        float f = c0113a.f2292a / c0113a.f2293b;
        float f2 = a2.f2293b / a2.f2292a;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                aVar.f2297a = (a2.f2293b * c0113a.f2293b) / c0113a.f2292a;
                aVar.f2298b = a2.f2293b;
                return aVar;
            }
            aVar.f2297a = a2.f2292a;
            aVar.f2298b = (a2.f2292a * c0113a.f2292a) / c0113a.f2293b;
            return aVar;
        }
        return aVar;
    }

    private a.C0113a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0113a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
