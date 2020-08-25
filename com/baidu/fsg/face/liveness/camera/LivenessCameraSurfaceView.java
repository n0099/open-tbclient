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
/* loaded from: classes11.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void bindSurfaceView(Activity activity, a.C0126a c0126a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a = a(activity, c0126a);
        if (a == null || (a.a == c0126a.a && a.b == c0126a.b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = a.a;
            layoutParams.height = a.b;
        }
        setLayoutParams(layoutParams);
    }

    private b.a a(Activity activity, a.C0126a c0126a) {
        if (c0126a == null) {
            return null;
        }
        a.C0126a a = a(activity);
        b.a aVar = new b.a(c0126a.a, c0126a.b);
        float f = c0126a.a / c0126a.b;
        float f2 = a.b / a.a;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                aVar.a = (a.b * c0126a.b) / c0126a.a;
                aVar.b = a.b;
                return aVar;
            }
            aVar.a = a.a;
            aVar.b = (a.a * c0126a.a) / c0126a.b;
            return aVar;
        }
        return aVar;
    }

    private a.C0126a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0126a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
