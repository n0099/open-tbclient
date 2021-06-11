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

    private b.a a(Activity activity, a.C0084a c0084a) {
        if (c0084a == null) {
            return null;
        }
        a.C0084a a2 = a(activity);
        b.a aVar = new b.a(c0084a.f5958a, c0084a.f5959b);
        float f2 = c0084a.f5958a / c0084a.f5959b;
        float f3 = a2.f5959b / a2.f5958a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar;
        }
        if (f2 < f3) {
            int i2 = a2.f5959b;
            aVar.f5970a = (c0084a.f5959b * i2) / c0084a.f5958a;
            aVar.f5971b = i2;
        } else {
            int i3 = a2.f5958a;
            aVar.f5970a = i3;
            aVar.f5971b = (i3 * c0084a.f5958a) / c0084a.f5959b;
        }
        return aVar;
    }

    public void bindSurfaceView(Activity activity, a.C0084a c0084a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0084a);
        if (a2 != null && (a2.f5970a != c0084a.f5958a || a2.f5971b != c0084a.f5959b)) {
            layoutParams.width = a2.f5970a;
            layoutParams.height = a2.f5971b;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        setLayoutParams(layoutParams);
    }

    private a.C0084a a(Activity activity) {
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        return new a.C0084a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
    }
}
