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
        b.a aVar = new b.a(c0083a.f6161a, c0083a.f6162b);
        float f2 = c0083a.f6161a / c0083a.f6162b;
        float f3 = a2.f6162b / a2.f6161a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar;
        }
        if (f2 < f3) {
            int i2 = a2.f6162b;
            aVar.f6173a = (c0083a.f6162b * i2) / c0083a.f6161a;
            aVar.f6174b = i2;
        } else {
            int i3 = a2.f6161a;
            aVar.f6173a = i3;
            aVar.f6174b = (i3 * c0083a.f6161a) / c0083a.f6162b;
        }
        return aVar;
    }

    public void bindSurfaceView(Activity activity, a.C0083a c0083a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0083a);
        if (a2 != null && (a2.f6173a != c0083a.f6161a || a2.f6174b != c0083a.f6162b)) {
            layoutParams.width = a2.f6173a;
            layoutParams.height = a2.f6174b;
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
