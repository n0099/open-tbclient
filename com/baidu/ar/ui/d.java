package com.baidu.ar.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.baidu.ar.OnClickCameraButtonListener;
import com.baidu.ar.camera.ARSwitchCameraCallback;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.ViewUtils;
import com.baidu.ar.util.sputil.SPUtils;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    private RotateViewGroup a;
    private TextView b;
    private RotateImageView c;
    private c d;
    private boolean e;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;

    public d(c cVar) {
        this.e = false;
        this.d = cVar;
        this.c = this.d.q.getHostUI().getIconCamera();
        this.a = this.d.q.getHostUI().getCameraSwitchTipGroup();
        this.b = this.d.q.getHostUI().getCameraSwitchTip();
        this.d.q.getHostUI().setARSwitchCameraCallback(new ARSwitchCameraCallback() { // from class: com.baidu.ar.ui.d.1
            @Override // com.baidu.ar.camera.ARSwitchCameraCallback
            public void onCameraSwitch(boolean z, boolean z2) {
                if (z) {
                    d.this.c(z2);
                    d.this.d.a(z2);
                    d.this.d.v.c(z2);
                }
            }
        });
        this.d.q.getHostUI().setOnClickCameraButtonListener(new OnClickCameraButtonListener() { // from class: com.baidu.ar.ui.d.2
            @Override // com.baidu.ar.OnClickCameraButtonListener
            public void onClick() {
                d.this.d.j();
            }
        });
        this.e = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ComponentMessageType.MSG_TYPE_CAMERA_CHANGE));
        hashMap.put(ComponentMessageType.MSG_CHANGE_TO_FRONT_CAMERA, Integer.valueOf(z ? 0 : 1));
        this.d.u().i().sendMessage2Lua(hashMap);
    }

    private void d() {
        if (this.e && this.f && !this.h && this.g) {
            ViewUtils.setViewVisibility(this.c, 0);
            RotateViewUtils.requestOrientation(this.c, OrientationManager.getGlobalOrientation(), true);
        }
    }

    private boolean e() {
        return this.d.q.getARCameraManager().isFrontCameraPreviewSupported();
    }

    private void f() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.d.s()) {
                    return;
                }
                final FragmentActivity activity = d.this.d.q.getActivity();
                if (d.this.a == null || SPUtils.hasCameraSwitchTipShown(activity)) {
                    return;
                }
                d.this.a.setVisibility(0);
                UiThreadUtil.postDelayed(new Runnable() { // from class: com.baidu.ar.ui.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.a != null) {
                            d.this.a.setVisibility(4);
                            SPUtils.setCameraSwitchTipShown(activity);
                        }
                    }
                }, 2000L);
            }
        });
    }

    public void a() {
        ViewUtils.setViewVisibility(this.c, 4);
        if (this.d.q.getHostUI() != null) {
            this.d.q.getHostUI().setARSwitchCameraCallback(null);
        }
    }

    public void a(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.a, orientation, true);
        int dimensionPixelSize = Res.getDimensionPixelSize("bdar_camera_tip_margin_top");
        if (orientation == Orientation.PORTRAIT) {
            this.b.setBackground(Res.getDrawable("bdar_drawable_bg_pop_center_top"));
        } else if (orientation == Orientation.LANDSCAPE) {
            this.b.setBackground(Res.getDrawable("bdar_drawable_bg_pop_center_right"));
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            this.b.setBackground(Res.getDrawable("bdar_drawable_bg_pop_center_left"));
        }
        ViewUtils.setRelativeMargins(this.a, 0, dimensionPixelSize, 0, 0);
    }

    public void a(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        switch (MsgParamsUtil.obj2Int(hashMap.get("id"), -1)) {
            case ComponentMessageType.MSG_TYPE_ENABLE_FRONT_CAMERA /* 10201 */:
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.d.s()) {
                            return;
                        }
                        d.this.c();
                    }
                });
                return;
            case ComponentMessageType.MSG_TYPE_INITIAL_CLCIK /* 10500 */:
                f();
                return;
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.g = z;
        if (this.g) {
            d();
        } else {
            ViewUtils.setViewVisibility(this.c, 4);
        }
    }

    public RotateImageView b() {
        return this.c;
    }

    public void b(boolean z) {
        this.h = z;
        if (this.h) {
            ViewUtils.setViewVisibility(this.c, 4);
        } else {
            d();
        }
    }
}
