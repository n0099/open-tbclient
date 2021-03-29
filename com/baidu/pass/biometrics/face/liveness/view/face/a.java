package com.baidu.pass.biometrics.face.liveness.view.face;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pass.biometrics.face.liveness.view.face.CameraPreview;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9730a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9731b = 640;

    public static CameraPreview.a a(Activity activity, Camera.Parameters parameters) {
        List<CameraPreview.a> b2 = b(activity, parameters);
        CameraPreview.a aVar = new CameraPreview.a(640, 480);
        if (b2 != null && b2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a.C0116a c0116a = new a.C0116a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0116a.f9652b / c0116a.f9651a;
            float f3 = aVar.f9710a / aVar.f9711b;
            for (int i = 0; i < b2.size(); i++) {
                CameraPreview.a aVar2 = b2.get(i);
                float abs = Math.abs((aVar2.f9710a / aVar2.f9711b) - f2);
                if (abs < f3) {
                    aVar = aVar2;
                    f3 = abs;
                }
            }
        }
        return aVar;
    }

    @TargetApi(5)
    public static List<CameraPreview.a> b(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        a.C0116a c0116a = new a.C0116a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i = 153600;
        int i2 = 921600;
        int i3 = c0116a.f9651a * c0116a.f9652b;
        if (i3 / 4 > 921600) {
            i2 = 2073600;
            i = i3 / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < supportedPreviewSizes.size(); i4++) {
            Camera.Size size = supportedPreviewSizes.get(i4);
            int i5 = size.width;
            int i6 = size.height;
            int i7 = i5 * i6;
            if (i7 >= i && i7 <= i2) {
                arrayList.add(new CameraPreview.a(i5, i6));
            }
        }
        return arrayList;
    }
}
