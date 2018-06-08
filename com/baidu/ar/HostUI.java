package com.baidu.ar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.camera.ARSwitchCameraCallback;
import com.baidu.ar.draw.ARRenderer;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.ui.LoadingView;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.APIUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.UiThreadUtil;
/* loaded from: classes3.dex */
public class HostUI implements View.OnClickListener {
    private static final String b = HostUI.class.getSimpleName();
    private ARFragment c;
    private View d;
    private ARRenderer e;
    private GLSurfaceView f;
    private RotateImageView g;
    private RotateImageView h;
    private RotateImageView i;
    private RotateImageView j;
    private RotateViewGroup k;
    private LoadingView l;
    private RotateViewGroup m;
    private TextView n;
    private View o;
    private ARSwitchCameraCallback r;
    private OnClickCameraButtonListener s;
    private boolean p = true;
    private boolean q = true;
    protected boolean a = true;
    private boolean t = false;
    private int u = 0;

    public HostUI(ARFragment aRFragment, View view) {
        Bitmap previewBitmap;
        this.c = aRFragment;
        this.d = view;
        this.f = (GLSurfaceView) view.findViewById(Res.id("bdar_view"));
        this.e = new ARRenderer(isScreenOrientationLandscape(this.c.getActivity().getApplicationContext()));
        this.e.setARFrameListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ar.HostUI.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                Log.d(HostUI.b, "onFrameAvailable");
                HostUI.this.f.requestRender();
            }
        });
        this.f.setEGLContextClientVersion(2);
        this.e.setCameraFrameListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ar.HostUI.3
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                HostUI.this.onCameraFirstFrame();
            }
        });
        this.f.setRenderer(this.e);
        this.f.setRenderMode(0);
        this.g = (RotateImageView) view.findViewById(Res.id("bdar_mask_view"));
        this.h = (RotateImageView) view.findViewById(Res.id("bdar_titlebar_back"));
        this.h.setOnClickListener(this);
        this.i = (RotateImageView) view.findViewById(Res.id("bdar_titlebar_camera"));
        this.i.setOnClickListener(this);
        this.j = (RotateImageView) view.findViewById(Res.id("bdar_titlebar_flash"));
        this.j.setOnClickListener(this);
        if (!SystemInfoUtil.checkFlashFeature(this.c.getActivity())) {
            this.j.setVisibility(8);
        }
        this.k = (RotateViewGroup) view.findViewById(Res.id("bdar_id_loading_group"));
        this.l = (LoadingView) view.findViewById(Res.id("bdar_id_loading"));
        this.m = (RotateViewGroup) view.findViewById(Res.id("bdar_id_camera_switch_tips_layout"));
        this.n = (TextView) view.findViewById(Res.id("bdar_id_camera_switch_tips"));
        this.o = view.findViewById(Res.id("bdar_transparent_layer"));
        try {
            if (ARConfig.getARLaunchMode() == 2 && (previewBitmap = this.c.getARCallback().getPreviewBitmap()) != null && !previewBitmap.isRecycled()) {
                this.g.setVisibility(0);
                if (APIUtils.hasJellyBean()) {
                    this.g.setBackground(new BitmapDrawable(previewBitmap));
                } else {
                    this.g.setBackgroundDrawable(new BitmapDrawable(previewBitmap));
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        this.p = z;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.7
            @Override // java.lang.Runnable
            public void run() {
                if (HostUI.this.j != null) {
                    if (z) {
                        HostUI.this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_disable_selector"));
                    } else {
                        HostUI.this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_enable_selector"));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.t = true;
        this.i.setEnabled(false);
        this.c.getARCameraManager().switchCamera(new ARSwitchCameraCallback() { // from class: com.baidu.ar.HostUI.4
            @Override // com.baidu.ar.camera.ARSwitchCameraCallback
            public void onCameraSwitch(final boolean z, final boolean z2) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HostUI.this.t = false;
                        HostUI.this.i.setEnabled(true);
                        if (z) {
                            HostUI.this.p = true;
                            HostUI.this.q = z2;
                            HostUI.this.j.setImageDrawable(Res.getDrawable("bdar_drawable_btn_flash_disable_selector"));
                            if (HostUI.this.r != null) {
                                HostUI.this.r.onCameraSwitch(z, z2);
                            }
                            if (HostUI.this.u == 1) {
                                if (HostUI.this.q) {
                                    HostUI.this.u = 0;
                                } else {
                                    HostUI.this.b();
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    private void c() {
        if (this.p) {
            d();
        } else {
            closeFlash();
        }
    }

    private void d() {
        this.c.getARCameraManager().openFlash(new com.baidu.ar.camera.a() { // from class: com.baidu.ar.HostUI.5
            @Override // com.baidu.ar.camera.a
            public void a(boolean z) {
                if (z) {
                    HostUI.this.a(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.a) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.2
                @Override // java.lang.Runnable
                public void run() {
                    if (HostUI.this.g != null) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(HostUI.this.g, "alpha", 1.0f, 0.0f);
                        ofFloat.setDuration(1000L);
                        ofFloat.setInterpolator(new DecelerateInterpolator());
                        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.ar.HostUI.2.1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                Bitmap bitmap;
                                try {
                                    HostUI.this.g.setVisibility(8);
                                    Drawable background = HostUI.this.g.getBackground();
                                    HostUI.this.g.setBackgroundColor(0);
                                    if ((background instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) background).getBitmap()) != null && !bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                    HostUI.this.a = false;
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }
                        });
                        ofFloat.start();
                    }
                }
            });
        }
    }

    public void closeFlash() {
        this.c.getARCameraManager().closeFlash(new com.baidu.ar.camera.a() { // from class: com.baidu.ar.HostUI.6
            @Override // com.baidu.ar.camera.a
            public void a(boolean z) {
                if (z) {
                    HostUI.this.a(true);
                }
            }
        });
    }

    public ARRenderer getARRenderer() {
        return this.e;
    }

    public TextView getCameraSwitchTip() {
        return this.n;
    }

    public RotateViewGroup getCameraSwitchTipGroup() {
        return this.m;
    }

    public GLSurfaceView getGLSurfaceView() {
        return this.f;
    }

    public RotateImageView getIconBack() {
        return this.h;
    }

    public RotateImageView getIconCamera() {
        return this.i;
    }

    public RotateImageView getIconFlash() {
        return this.j;
    }

    public View getTransparentView() {
        return this.o;
    }

    public void hideLoadingView() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.9
            @Override // java.lang.Runnable
            public void run() {
                if (HostUI.this.l != null) {
                    HostUI.this.l.dismiss();
                }
            }
        });
    }

    public boolean isBackCamera() {
        return this.q;
    }

    public boolean isScreenOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public void onCameraFirstFrame() {
        if (this.g != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.10
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("0101010", "移除Bitmap");
                    HostUI.this.e();
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == Res.id("bdar_titlebar_back")) {
            this.c.onFragmentBackPressed();
        } else if (id != Res.id("bdar_titlebar_camera")) {
            if (id == Res.id("bdar_titlebar_flash")) {
                c();
            }
        } else {
            b();
            if (this.s != null) {
                this.s.onClick();
            }
        }
    }

    public void onPause() {
        this.p = true;
    }

    public void onResume() {
        a(this.p);
    }

    public void release() {
        this.r = null;
    }

    public void rotateOrientation(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.h, orientation, true);
        RotateViewUtils.requestOrientation(this.i, orientation, true);
        RotateViewUtils.requestOrientation(this.j, orientation, true);
        RotateViewUtils.requestOrientation(this.k, orientation, true);
    }

    public void setARSwitchCameraCallback(ARSwitchCameraCallback aRSwitchCameraCallback) {
        this.r = aRSwitchCameraCallback;
    }

    public void setOnClickCameraButtonListener(OnClickCameraButtonListener onClickCameraButtonListener) {
        this.s = onClickCameraButtonListener;
    }

    public void showLoadingView() {
        showLoadingView(Res.getString("bdar_loading"));
    }

    public void showLoadingView(final String str) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.HostUI.8
            @Override // java.lang.Runnable
            public void run() {
                if (HostUI.this.l != null) {
                    HostUI.this.l.setMsg(str);
                    HostUI.this.l.show();
                }
            }
        });
    }

    public void switchBackCameraForReleaseCase() {
        if (this.t) {
            this.u = 1;
            return;
        }
        this.u = 0;
        if (this.q) {
            return;
        }
        b();
    }
}
