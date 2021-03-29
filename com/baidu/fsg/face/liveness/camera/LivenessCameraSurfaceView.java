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
        b.a aVar = new b.a(c0084a.f5961a, c0084a.f5962b);
        float f2 = c0084a.f5961a / c0084a.f5962b;
        float f3 = a2.f5962b / a2.f5961a;
        if (Math.abs(f2 - f3) <= 0.02d) {
            return aVar;
        }
        if (f2 < f3) {
            int i = a2.f5962b;
            aVar.f5972a = (c0084a.f5962b * i) / c0084a.f5961a;
            aVar.f5973b = i;
        } else {
            int i2 = a2.f5961a;
            aVar.f5972a = i2;
            aVar.f5973b = (i2 * c0084a.f5961a) / c0084a.f5962b;
        }
        return aVar;
    }

    public void bindSurfaceView(Activity activity, a.C0084a c0084a) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        b.a a2 = a(activity, c0084a);
        if (a2 != null && (a2.f5972a != c0084a.f5961a || a2.f5973b != c0084a.f5962b)) {
            layoutParams.width = a2.f5972a;
            layoutParams.height = a2.f5973b;
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
