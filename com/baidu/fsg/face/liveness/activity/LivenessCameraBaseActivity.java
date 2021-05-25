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
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.camera.LivenessCameraSurfaceView;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes2.dex */
public abstract class LivenessCameraBaseActivity extends LivenessBaseActivity implements Camera.PreviewCallback, SurfaceHolder.Callback {

    /* renamed from: b  reason: collision with root package name */
    public static final int f5615b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5616c = 2;
    public com.baidu.fsg.face.liveness.camera.a cameraControl;

    /* renamed from: e  reason: collision with root package name */
    public LivenessCameraSurfaceView f5619e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f5620f;
    public com.baidu.fsg.face.base.d.b faceRectGroup;

    /* renamed from: g  reason: collision with root package name */
    public MediaPlayer f5621g;
    public boolean permissionFlag;

    /* renamed from: d  reason: collision with root package name */
    public int f5618d = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5617a = false;

    /* loaded from: classes2.dex */
    public static class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            mediaPlayer.reset();
            return false;
        }
    }

    private boolean e() {
        this.f5619e.setVisibility(4);
        boolean a2 = this.cameraControl.a(getActivity(), true);
        this.f5619e.bindSurfaceView(this, this.cameraControl.f());
        this.f5619e.setVisibility(0);
        return a2;
    }

    public static void setBrightness(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public abstract View a();

    public abstract void a(boolean z);

    public abstract void a(boolean z, boolean z2, boolean z3);

    public abstract void a(byte[] bArr, Camera camera);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        LivenessCameraSurfaceView livenessCameraSurfaceView = new LivenessCameraSurfaceView(getActivity(), null);
        this.f5619e = livenessCameraSurfaceView;
        SurfaceHolder holder = livenessCameraSurfaceView.getHolder();
        this.f5620f = holder;
        holder.setFormat(-2);
        this.f5620f.setType(3);
        this.f5620f.addCallback(this);
        addContentView(this.f5619e, layoutParams);
        addContentView(a(), layoutParams);
        this.cameraControl = new com.baidu.fsg.face.liveness.camera.a();
        this.faceRectGroup = new com.baidu.fsg.face.base.d.b();
        f.b(this, getResources().getColor(17170445));
        setBrightness(getActivity(), 255);
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f5621g != null) {
                this.f5621g.stop();
                this.f5621g.release();
            }
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        a(bArr, camera);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.permissionFlag = false;
        if (i2 == 1) {
            if (iArr.length == 1) {
                if (iArr[0] == 0) {
                    startVideoOrCamera();
                } else {
                    a(true);
                }
            }
        } else if (i2 == 2 && iArr.length == 2) {
            boolean z = iArr[0] == 0;
            boolean z2 = iArr[1] == 0;
            if (z && z2) {
                startVideoOrCamera();
            } else {
                a(z, z2, true);
            }
        }
    }

    public void playSound(int i2) {
        MediaPlayer mediaPlayer = this.f5621g;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            MediaPlayer create = MediaPlayer.create(this, i2);
            this.f5621g = create;
            if (create == null) {
                return;
            }
            create.setOnErrorListener(new b());
            setVolumeControlStream(3);
            this.f5621g.start();
        }
    }

    public void startRecod() {
        this.f5619e.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.3
            @Override // java.lang.Runnable
            public void run() {
                new a().execute(new Void[0]);
            }
        });
    }

    public void startVideoOrCamera() {
        if (this.f5618d == 0) {
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.1
                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @TargetApi(23)
                    public void isAllAgree(boolean z) {
                        if (z) {
                            LivenessCameraBaseActivity livenessCameraBaseActivity = LivenessCameraBaseActivity.this;
                            livenessCameraBaseActivity.permissionFlag = true;
                            livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
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
                        LivenessCameraBaseActivity livenessCameraBaseActivity = LivenessCameraBaseActivity.this;
                        livenessCameraBaseActivity.permissionFlag = true;
                        livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
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

    public void startVideoOrCamera2() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            this.permissionFlag = true;
            requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
        } else if (this.f5618d == 0) {
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
            this.f5619e.post(new Runnable() { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    new a().execute(new Void[0]);
                }
            });
        } else {
            a(false, true, true);
        }
    }

    public void stopVideoOrCamera() {
        com.baidu.fsg.face.liveness.camera.a aVar;
        int i2 = this.f5618d;
        if (i2 == 0) {
            com.baidu.fsg.face.liveness.camera.a aVar2 = this.cameraControl;
            if (aVar2 != null) {
                aVar2.d();
            }
        } else if (i2 != 1 || (aVar = this.cameraControl) == null) {
        } else {
            aVar.e();
            this.cameraControl.d();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.faceRectGroup.f5545b = new Rect(this.f5619e.getLeft(), this.f5619e.getTop(), this.f5619e.getRight(), this.f5619e.getBottom());
        b();
        this.cameraControl.a((Camera.PreviewCallback) this);
        this.cameraControl.a(getActivity(), this.f5620f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    /* loaded from: classes2.dex */
    public class a extends AsyncTask<Void, Void, String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            LivenessCameraBaseActivity livenessCameraBaseActivity = LivenessCameraBaseActivity.this;
            livenessCameraBaseActivity.f5617a = livenessCameraBaseActivity.cameraControl.a((Context) livenessCameraBaseActivity.getActivity());
            LivenessCameraBaseActivity livenessCameraBaseActivity2 = LivenessCameraBaseActivity.this;
            livenessCameraBaseActivity2.cameraControl.a((Camera.PreviewCallback) livenessCameraBaseActivity2);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            LivenessCameraBaseActivity livenessCameraBaseActivity = LivenessCameraBaseActivity.this;
            if (livenessCameraBaseActivity.f5617a) {
                livenessCameraBaseActivity.d();
            } else {
                livenessCameraBaseActivity.a(true, false, false);
            }
        }
    }
}
