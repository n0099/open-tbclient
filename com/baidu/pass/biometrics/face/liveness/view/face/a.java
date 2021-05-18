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
    public static final int f9254a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9255b = 640;

    public static CameraPreview.a a(Activity activity, Camera.Parameters parameters) {
        List<CameraPreview.a> b2 = b(activity, parameters);
        CameraPreview.a aVar = new CameraPreview.a(640, 480);
        if (b2 != null && b2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a.C0113a c0113a = new a.C0113a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0113a.f9170b / c0113a.f9169a;
            float f3 = aVar.f9232a / aVar.f9233b;
            for (int i2 = 0; i2 < b2.size(); i2++) {
                CameraPreview.a aVar2 = b2.get(i2);
                float abs = Math.abs((aVar2.f9232a / aVar2.f9233b) - f2);
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
        a.C0113a c0113a = new a.C0113a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i2 = 153600;
        int i3 = 921600;
        int i4 = c0113a.f9169a * c0113a.f9170b;
        if (i4 / 4 > 921600) {
            i3 = 2073600;
            i2 = i4 / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < supportedPreviewSizes.size(); i5++) {
            Camera.Size size = supportedPreviewSizes.get(i5);
            int i6 = size.width;
            int i7 = size.height;
            int i8 = i6 * i7;
            if (i8 >= i2 && i8 <= i3) {
                arrayList.add(new CameraPreview.a(i6, i7));
            }
        }
        return arrayList;
    }
}
