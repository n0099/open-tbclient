package com.baidu.fsg.face.liveness.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.camera.LivenessCameraSurfaceView;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes17.dex */
public abstract class LivenessCameraBaseActivity extends LivenessBaseActivity implements Camera.PreviewCallback, SurfaceHolder.Callback {
    private static final int b = 1;
    private static final int c = 2;
    protected com.baidu.fsg.face.liveness.camera.a cameraControl;
    private LivenessCameraSurfaceView e;
    private SurfaceHolder f;
    protected com.baidu.fsg.face.base.d.b faceRectGroup;
    private MediaPlayer g;
    protected boolean permissionFlag;
    private int d = 1;

    /* renamed from: a  reason: collision with root package name */
    boolean f1600a = false;

    abstract View a();

    abstract void a(boolean z);

    abstract void a(boolean z, boolean z2, boolean z3);

    abstract void a(byte[] bArr, Camera camera);

    abstract void b();

    abstract void c();

    abstract void d();

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.e = new LivenessCameraSurfaceView(getActivity(), null);
        this.f = this.e.getHolder();
        this.f.setFormat(-2);
        this.f.setType(3);
        this.f.addCallback(this);
        addContentView(this.e, layoutParams);
        addContentView(a(), layoutParams);
        this.cameraControl = new com.baidu.fsg.face.liveness.camera.a();
        this.faceRectGroup = new com.baidu.fsg.face.base.d.b();
        f.b(this, getResources().getColor(17170445));
        setBrightness(getActivity(), 255);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.permissionFlag = false;
        if (i == 1) {
            if (iArr.length == 1) {
                if (iArr[0] == 0) {
                    startVideoOrCamera();
                } else {
                    a(true);
                }
            }
        } else if (i == 2 && iArr.length == 2) {
            boolean z = iArr[0] == 0;
            boolean z2 = iArr[1] == 0;
            if (z && z2) {
                startVideoOrCamera();
            } else {
                a(z, z2, true);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.faceRectGroup.b = new Rect(this.e.getLeft(), this.e.getTop(), this.e.getRight(), this.e.getBottom());
        b();
        this.cameraControl.a((Camera.PreviewCallback) this);
        this.cameraControl.a(getActivity(), this.f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startVideoOrCamera() {
        if (this.d == 0) {
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.1
                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @TargetApi(23)
                    public void isAllAgree(boolean z) {
                        if (z) {
                            LivenessCameraBaseActivity.this.permissionFlag = true;
                            LivenessCameraBaseActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
                            return;
                        }
                        LivenessCameraBaseActivity.this.a(true);
                    }
                });
                return;
            } else if (e()) {
                c();
                return;
            } else {
                a(false);
                return;
            }
        }
        String[] strArr2 = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
        if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr2)) {
            DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr2, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.2
                @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                @TargetApi(23)
                public void isAllAgree(boolean z) {
                    if (z) {
                        LivenessCameraBaseActivity.this.permissionFlag = true;
                        LivenessCameraBaseActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                        return;
                    }
                    LivenessCameraBaseActivity.this.a(false, false, true);
                }
            });
        } else if (e()) {
            c();
        } else {
            a(false, true, true);
        }
    }

    public void startRecod() {
        this.e.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.3
            @Override // java.lang.Runnable
            public void run() {
                new a().execute(new Void[0]);
            }
        });
    }

    protected void startVideoOrCamera2() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            this.permissionFlag = true;
            requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
        } else if (this.d == 0) {
            if (e()) {
                c();
            } else {
                a(false);
            }
        } else if (e()) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_AUDIO_CAPTURE) != 0) {
                this.permissionFlag = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                return;
            }
            this.e.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    new a().execute(new Void[0]);
                }
            });
        } else {
            a(false, true, true);
        }
    }

    /* loaded from: classes17.dex */
    private class a extends AsyncTask<Void, Void, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessCameraBaseActivity.this.f1600a = LivenessCameraBaseActivity.this.cameraControl.a((Context) LivenessCameraBaseActivity.this.getActivity());
            LivenessCameraBaseActivity.this.cameraControl.a((Camera.PreviewCallback) LivenessCameraBaseActivity.this);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (LivenessCameraBaseActivity.this.f1600a) {
                LivenessCameraBaseActivity.this.d();
            } else {
                LivenessCameraBaseActivity.this.a(true, false, false);
            }
        }
    }

    private boolean e() {
        this.e.setVisibility(4);
        boolean a2 = this.cameraControl.a(getActivity(), true);
        this.e.bindSurfaceView(this, this.cameraControl.f());
        this.e.setVisibility(0);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopVideoOrCamera() {
        if (this.d == 0) {
            if (this.cameraControl != null) {
                this.cameraControl.d();
            }
        } else if (this.d == 1 && this.cameraControl != null) {
            this.cameraControl.e();
            this.cameraControl.d();
        }
    }

    public static void setBrightness(Activity activity, int i) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playSound(int i) {
        if (this.g == null || !this.g.isPlaying()) {
            this.g = MediaPlayer.create(this, i);
            if (this.g != null) {
                this.g.setOnErrorListener(new b());
                setVolumeControlStream(3);
                this.g.start();
            }
        }
    }

    /* loaded from: classes17.dex */
    private static class b implements MediaPlayer.OnErrorListener {
        private b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            mediaPlayer.reset();
            return false;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        a(bArr, camera);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.g != null) {
                this.g.stop();
                this.g.release();
            }
        } catch (Exception e) {
            d.a(e);
        }
    }
}
