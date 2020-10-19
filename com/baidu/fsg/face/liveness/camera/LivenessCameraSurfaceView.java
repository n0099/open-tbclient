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
/* loaded from: classes17.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void bindSurfaceView(Activity activity, a.C0131a c0131a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0131a);
        if (a2 == null || (a2.f1723a == c0131a.f1720a && a2.b == c0131a.b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = a2.f1723a;
            layoutParams.height = a2.b;
        }
        setLayoutParams(layoutParams);
    }

    private b.a a(Activity activity, a.C0131a c0131a) {
        if (c0131a == null) {
            return null;
        }
        a.C0131a a2 = a(activity);
        b.a aVar = new b.a(c0131a.f1720a, c0131a.b);
        float f = c0131a.f1720a / c0131a.b;
        float f2 = a2.b / a2.f1720a;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                aVar.f1723a = (a2.b * c0131a.b) / c0131a.f1720a;
                aVar.b = a2.b;
                return aVar;
            }
            aVar.f1723a = a2.f1720a;
            aVar.b = (a2.f1720a * c0131a.f1720a) / c0131a.b;
            return aVar;
        }
        return aVar;
    }

    private a.C0131a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0131a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
