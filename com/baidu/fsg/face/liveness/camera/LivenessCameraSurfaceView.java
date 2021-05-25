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

    private b.a a(Activity activity, a.C0083a c0083a) {
        if (c0083a == null) {
            return null;
        }
        a.C0083a a2 = a(activity);
        b.a aVar = new b.a(c0083a.f5915a, c0083a.f5916b);
        float f2 = c0083a.f5915a / c0083a.f5916b;
        float f3 = a2.f5916b / a2.f5915a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar;
        }
        if (f2 < f3) {
            int i2 = a2.f5916b;
            aVar.f5927a = (c0083a.f5916b * i2) / c0083a.f5915a;
            aVar.f5928b = i2;
        } else {
            int i3 = a2.f5915a;
            aVar.f5927a = i3;
            aVar.f5928b = (i3 * c0083a.f5915a) / c0083a.f5916b;
        }
        return aVar;
    }

    public void bindSurfaceView(Activity activity, a.C0083a c0083a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0083a);
        if (a2 != null && (a2.f5927a != c0083a.f5915a || a2.f5928b != c0083a.f5916b)) {
            layoutParams.width = a2.f5927a;
            layoutParams.height = a2.f5928b;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        setLayoutParams(layoutParams);
    }

    private a.C0083a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0083a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
