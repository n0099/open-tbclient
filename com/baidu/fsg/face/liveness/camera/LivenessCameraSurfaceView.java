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
/* loaded from: classes6.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void bindSurfaceView(Activity activity, a.C0115a c0115a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0115a);
        if (a2 == null || (a2.f2348a == c0115a.f2343a && a2.f2349b == c0115a.f2344b)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = a2.f2348a;
            layoutParams.height = a2.f2349b;
        }
        setLayoutParams(layoutParams);
    }

    private b.a a(Activity activity, a.C0115a c0115a) {
        if (c0115a == null) {
            return null;
        }
        a.C0115a a2 = a(activity);
        b.a aVar = new b.a(c0115a.f2343a, c0115a.f2344b);
        float f = c0115a.f2343a / c0115a.f2344b;
        float f2 = a2.f2344b / a2.f2343a;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                aVar.f2348a = (a2.f2344b * c0115a.f2344b) / c0115a.f2343a;
                aVar.f2349b = a2.f2344b;
                return aVar;
            }
            aVar.f2348a = a2.f2343a;
            aVar.f2349b = (a2.f2343a * c0115a.f2343a) / c0115a.f2344b;
            return aVar;
        }
        return aVar;
    }

    private a.C0115a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0115a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
