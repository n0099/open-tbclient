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
/* loaded from: classes2.dex */
public class LivenessCameraSurfaceView extends SurfaceView {
    public LivenessCameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private b.a a(Activity activity, a.C0082a c0082a) {
        if (c0082a == null) {
            return null;
        }
        a.C0082a a2 = a(activity);
        b.a aVar = new b.a(c0082a.f6015a, c0082a.f6016b);
        float f2 = c0082a.f6015a / c0082a.f6016b;
        float f3 = a2.f6016b / a2.f6015a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar;
        }
        if (f2 < f3) {
            int i2 = a2.f6016b;
            aVar.f6027a = (c0082a.f6016b * i2) / c0082a.f6015a;
            aVar.f6028b = i2;
        } else {
            int i3 = a2.f6015a;
            aVar.f6027a = i3;
            aVar.f6028b = (i3 * c0082a.f6015a) / c0082a.f6016b;
        }
        return aVar;
    }

    public void bindSurfaceView(Activity activity, a.C0082a c0082a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0082a);
        if (a2 != null && (a2.f6027a != c0082a.f6015a || a2.f6028b != c0082a.f6016b)) {
            layoutParams.width = a2.f6027a;
            layoutParams.height = a2.f6028b;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        setLayoutParams(layoutParams);
    }

    private a.C0082a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0082a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
