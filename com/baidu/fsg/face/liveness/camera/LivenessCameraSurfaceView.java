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

    public void bindSurfaceView(Activity activity, a.C0119a c0119a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0119a);
        if (a2 == null || (a2.f1765a == c0119a.f1762a && a2.b == c0119a.b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = a2.f1765a;
            layoutParams.height = a2.b;
        }
        setLayoutParams(layoutParams);
    }

    private b.a a(Activity activity, a.C0119a c0119a) {
        if (c0119a == null) {
            return null;
        }
        a.C0119a a2 = a(activity);
        b.a aVar = new b.a(c0119a.f1762a, c0119a.b);
        float f = c0119a.f1762a / c0119a.b;
        float f2 = a2.b / a2.f1762a;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                aVar.f1765a = (a2.b * c0119a.b) / c0119a.f1762a;
                aVar.b = a2.b;
                return aVar;
            }
            aVar.f1765a = a2.f1762a;
            aVar.b = (a2.f1762a * c0119a.f1762a) / c0119a.b;
            return aVar;
        }
        return aVar;
    }

    private a.C0119a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0119a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
