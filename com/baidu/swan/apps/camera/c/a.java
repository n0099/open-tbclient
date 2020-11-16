package com.baidu.swan.apps.camera.c;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static void a(MotionEvent motionEvent, Camera camera, int i, int i2) {
        if (motionEvent != null && camera != null) {
            Rect a2 = a(motionEvent.getX(), motionEvent.getY(), 1.0f, i, i2);
            camera.cancelAutoFocus();
            Camera.Parameters parameters = camera.getParameters();
            if (parameters != null) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(a2, 800));
                    parameters.setFocusAreas(arrayList);
                }
                final String focusMode = parameters.getFocusMode();
                parameters.setFocusMode(c(parameters));
                camera.setParameters(parameters);
                camera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.swan.apps.camera.c.a.1
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera2) {
                        Camera.Parameters parameters2;
                        if (camera2 != null && (parameters2 = camera2.getParameters()) != null) {
                            parameters2.setFocusMode(focusMode);
                            camera2.setParameters(parameters2);
                        }
                    }
                });
            }
        }
    }

    private static String c(Camera.Parameters parameters) {
        List<String> supportedFocusModes;
        if (parameters == null || (supportedFocusModes = parameters.getSupportedFocusModes()) == null) {
            return "auto";
        }
        if (supportedFocusModes.contains("macro")) {
            return "macro";
        }
        if (!supportedFocusModes.contains("continuous-picture")) {
            return "auto";
        }
        return "continuous-picture";
    }

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        int i3 = (int) (((f / i) * 2000.0f) - 1000.0f);
        int i4 = (int) (((f2 / i2) * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(300.0f * f3).intValue() / 2;
        RectF rectF = new RectF(clamp(i3 - intValue, -1000, 1000), clamp(i4 - intValue, -1000, 1000), clamp(i3 + intValue, -1000, 1000), clamp(intValue + i4, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }
}
