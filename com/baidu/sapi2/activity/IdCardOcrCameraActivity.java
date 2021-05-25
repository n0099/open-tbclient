package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.result.IdCardOcrResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.a;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.a0.a.e;
import d.a.a0.a.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class IdCardOcrCameraActivity extends Activity implements Camera.PreviewCallback, View.OnClickListener {
    public static final String C = "IdCardOcrCameraActivity";
    public static final int D = 2001;
    public static final int E = 2002;
    public static final int F = 1920;
    public static final int G = 1080;
    public static final int H = 1001;
    public static final int I = 1002;
    public static final String IAMGE_TYPE_EMBLEM = "1";
    public static final String IAMGE_TYPE_PEOPLE = "2";
    public static final String PARAM_KEY_ID_CARD_TYPE = "PARAM_KEY_ID_CARD_TYPE";
    public static final String PERMISSION_TYPE_ALBUM = "PERMISSION_TYPE_ALBUM";
    public static final String PERMISSION_TYPE_CAMERA = "PERMISSION_TYPE_CAMERA";
    public String B;

    /* renamed from: a  reason: collision with root package name */
    public Dialog f9610a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f9611b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f9612c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9613d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9614e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f9615f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f9616g;

    /* renamed from: h  reason: collision with root package name */
    public Camera f9617h;

    /* renamed from: i  reason: collision with root package name */
    public Camera.Parameters f9618i;
    public byte[] j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public float s;
    public a t;
    public IdCardOcrCallback u;
    public boolean v;
    public long w = System.currentTimeMillis();
    public int x = 0;
    public long[] y = {255, 255, 255, 255};
    public int z = 300;
    public int A = 80;

    private void b() {
        this.f9611b = (FrameLayout) findViewById(e.sapi_sdk_ocr_frame_layout);
        this.f9612c = (FrameLayout) findViewById(e.sapi_sdk_fl_ocr_camera_border);
        this.f9613d = (TextView) findViewById(e.sapi_sdk_tv_light_tip);
        this.f9614e = (TextView) findViewById(e.sapi_sdk_tv_type_tip);
        this.f9615f = (ImageView) findViewById(e.sapi_sdk_iv_ocr_id_card_people);
        this.f9616g = (ImageView) findViewById(e.sapi_sdk_iv_ocr_id_card_emblem);
        if ("1".equals(this.B)) {
            this.f9615f.setVisibility(8);
            this.f9616g.setVisibility(0);
            this.f9614e.setText("请将二代身份证的国徽页放入识别框内");
        } else if ("2".equals(this.B)) {
            this.f9615f.setVisibility(0);
            this.f9616g.setVisibility(8);
            this.f9614e.setText("请将二代身份证的人像页放入识别框内");
        } else {
            a(true, IdCardOcrResult.CODE_PAGE_PARAMS_ERROR, IdCardOcrResult.MESSAGE_PAGE_PARAMS_ERROR, "", "");
        }
        ((FrameLayout) findViewById(e.sapi_sdk_fl_take_photo)).setOnClickListener(this);
    }

    private void c() {
        boolean z = false;
        try {
            if (this.f9617h == null) {
                Camera open = Camera.open(0);
                this.f9617h = open;
                Camera.Parameters parameters = open.getParameters();
                this.f9618i = parameters;
                parameters.setJpegQuality(100);
                this.f9618i.setPreviewFormat(17);
                this.f9618i.setPictureFormat(256);
                g();
                h();
                f();
                this.f9617h.setParameters(this.f9618i);
            }
            if (this.t == null) {
                a aVar = new a(this, this.f9617h);
                this.t = aVar;
                aVar.setPreviewCallback(this);
                this.f9611b.addView(this.t);
            }
            z = true;
        } catch (Exception e2) {
            Log.e(C, e2);
            a aVar2 = this.t;
            if (aVar2 != null) {
                aVar2.a();
                d();
            }
        }
        if (z) {
            return;
        }
        i();
    }

    private void d() {
        FrameLayout frameLayout = this.f9612c;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        TextView textView = this.f9614e;
        if (textView != null) {
            textView.setVisibility(8);
        }
        a aVar = this.t;
        if (aVar != null) {
            this.f9611b.removeView(aVar);
            this.t.a();
            this.t = null;
        }
        Camera camera = this.f9617h;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.f9617h.stopPreview();
            this.f9617h.release();
            this.f9617h = null;
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                new CommonDialog.Builder(this).setTitle(String.format("%1$sApp将使用“%2$s", PassBiometricUtil.getAppName(this), "摄像头/相机")).setMessage(String.format("为了您使用识别功能，请允许%1$sApp使用%2$s。您可以通过系统“设置”进行权限的管理", PassBiometricUtil.getAppName(this), "摄像头/相机")).setPositiveBtn("继续", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IdCardOcrCameraActivity.this.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2001);
                    }
                }).setNegativeButton("关闭", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                        idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                    }
                }).build().show();
                return;
            } else {
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2001);
                return;
            }
        }
        this.r = true;
        c();
    }

    private void f() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9612c.getLayoutParams();
        int min = Math.min(this.n - ((int) ((Resources.getSystem().getDisplayMetrics().density * 80.0f) + 0.5f)), dp2px(300.0f));
        this.k = min;
        int i2 = (int) (min * 1.585f);
        this.l = i2;
        layoutParams.width = min;
        layoutParams.height = i2;
        Log.e("ocr-test", "设置框尺寸： mBorderWidth = " + this.k + "，mBorderHeight = " + this.l);
        this.f9612c.setLayoutParams(layoutParams);
        this.f9614e.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f9615f.getLayoutParams();
        layoutParams2.rightMargin = (int) (((float) this.l) * 0.14f);
        layoutParams2.bottomMargin = (int) (((float) this.k) * 0.082f);
        this.f9615f.setLayoutParams(layoutParams2);
        layoutParams2.rightMargin = (int) (this.l * 0.098f);
        layoutParams2.topMargin = (int) (this.k * 0.048f);
        this.f9616g.setLayoutParams((FrameLayout.LayoutParams) this.f9616g.getLayoutParams());
    }

    private void g() {
        Camera.Parameters parameters;
        if (this.f9617h == null || (parameters = this.f9618i) == null) {
            return;
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = this.f9618i.getSupportedPictureSizes();
        ArrayList<CameraSize> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            if (size != null) {
                arrayList.add(new CameraSize(size));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Camera.Size size2 : supportedPictureSizes) {
            if (size2 != null) {
                arrayList2.add(new CameraSize(size2));
            }
        }
        arrayList.retainAll(arrayList2);
        CameraSize cameraSize = null;
        for (CameraSize cameraSize2 : arrayList) {
            Log.e("ocr-test", "相机支持设置的尺寸： width = " + cameraSize2.f9623a + ", height = " + cameraSize2.f9624b);
            float f2 = ((float) cameraSize2.f9624b) / ((float) this.n);
            int i2 = (int) (((float) cameraSize2.f9623a) / f2);
            if (i2 >= this.q && f2 > this.s) {
                this.s = f2;
                this.o = i2;
                Log.e("ocr-test", "有合适尺寸：" + cameraSize2.toString());
                cameraSize = cameraSize2;
            }
        }
        if (cameraSize == null) {
            Log.e("ocr-test", "未匹配到合适，默认尺寸: 1920*1080");
            this.s = 1.0f;
            this.o = 1920;
            cameraSize = new CameraSize(1920, G);
        }
        this.f9618i.setPictureSize(cameraSize.f9623a, cameraSize.f9624b);
        this.f9618i.setPreviewSize(cameraSize.f9623a, cameraSize.f9624b);
    }

    private void h() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9611b.getLayoutParams();
        layoutParams.height = this.o;
        layoutParams.width = this.p;
        Log.e("ocr-test", "设置preview尺寸： mPreviewHeight = " + this.o + "，mPreviewWidth = " + this.p + ",预览分辨率 / 屏幕 = " + this.s);
        this.f9611b.setLayoutParams(layoutParams);
    }

    private void i() {
        if (this.f9610a == null) {
            this.f9610a = new CommonDialog.Builder(this).setTitle("开启摄像头权限").setMessage("为了使用正常拍照服务\n请开启摄像头权限").setPositiveBtn("去设置", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, IdCardOcrCameraActivity.this.getPackageName(), null));
                    if (intent.resolveActivity(IdCardOcrCameraActivity.this.getPackageManager()) != null) {
                        IdCardOcrCameraActivity.this.startActivity(intent);
                    }
                    IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                    idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                }
            }).setNegativeButton("关闭", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IdCardOcrCameraActivity idCardOcrCameraActivity = IdCardOcrCameraActivity.this;
                    idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                }
            }).build();
        }
        this.f9610a.setCancelable(false);
        if (isFinishing() || this.f9610a.isShowing()) {
            return;
        }
        this.f9610a.show();
    }

    public int dp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
        idCardOcrResult.setResultCode(-301);
        this.u.onFailure(idCardOcrResult);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Camera.Parameters parameters;
        if (view.getId() != e.sapi_sdk_fl_take_photo || this.j == null || (parameters = this.f9618i) == null) {
            return;
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        byte[] a2 = com.baidu.sapi2.utils.a.a(a(com.baidu.sapi2.utils.a.a(this.j, previewSize.width, previewSize.height)), 100);
        if (a2 == null) {
            IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
            idCardOcrResult.setResultCode(IdCardOcrResult.CODE_CAMERA_ERROR);
            idCardOcrResult.setResultMsg(IdCardOcrResult.MESSAGE_CAMERA_ERROR);
            this.u.onFailure(idCardOcrResult);
            finish();
            return;
        }
        a(true, 0, "", this.B, Base64Utils.encodeToString(a2));
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.layout_activity_ocr_id_card);
        this.u = CoreViewRouter.getInstance().getIdCardOcrCallback();
        a();
        b();
        e();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.v) {
            return;
        }
        d();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.j = bArr;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.w < this.z) {
            return;
        }
        this.w = currentTimeMillis;
        long j = 0;
        long j2 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (((float) j2) * 1.5f)) < 1.0E-5f) {
            for (int i2 = 0; i2 < j2; i2 += 10) {
                j += bArr[i2] & 255;
            }
            long j3 = j / (j2 / 10);
            long[] jArr = this.y;
            int length = jArr.length;
            int i3 = this.x % length;
            this.x = i3;
            jArr[i3] = j3;
            this.x = i3 + 1;
            boolean z = true;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.y[i4] > this.A) {
                    z = false;
                }
            }
            Log.e("ocr-test", "摄像头环境亮度为 ： " + j3);
            if (isFinishing()) {
                return;
            }
            if (z) {
                this.f9613d.setVisibility(0);
            } else {
                this.f9613d.setVisibility(8);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 2001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.r = true;
                c();
                return;
            }
            i();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.r) {
            FrameLayout frameLayout = this.f9612c;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c();
        }
    }

    /* loaded from: classes2.dex */
    public class CameraSize {

        /* renamed from: a  reason: collision with root package name */
        public int f9623a;

        /* renamed from: b  reason: collision with root package name */
        public int f9624b;

        public CameraSize(int i2, int i3) {
            this.f9623a = i2;
            this.f9624b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CameraSize.class != obj.getClass()) {
                return false;
            }
            CameraSize cameraSize = (CameraSize) obj;
            return this.f9623a == cameraSize.f9623a && this.f9624b == cameraSize.f9624b;
        }

        public String toString() {
            return "CameraSize{width=" + this.f9623a + ", height=" + this.f9624b + '}';
        }

        public CameraSize(Camera.Size size) {
            this.f9623a = size.width;
            this.f9624b = size.height;
        }
    }

    private void a() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.n = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.m = height;
        this.p = this.n;
        this.q = height - dp2px(120.0f);
        this.B = getIntent().getStringExtra(PARAM_KEY_ID_CARD_TYPE);
        Log.e("ocr-test", "屏幕宽度 = " + this.n);
        Log.e("ocr-test", "屏幕高度 = " + this.m);
        Log.e("ocr-test", "预览区域最小高度 = " + this.q);
    }

    private Bitmap a(Bitmap bitmap) {
        try {
            int[] iArr = new int[2];
            int identifier = getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? getApplicationContext().getResources().getDimensionPixelSize(identifier) : 0;
            this.f9612c.getLocationInWindow(iArr);
            int i2 = (int) ((iArr[1] - dimensionPixelSize) * this.s);
            int i3 = (int) (iArr[0] * this.s);
            int i4 = (int) (this.l * this.s);
            int i5 = (int) (this.k * this.s);
            Log.e("ocr-test", "计算点坐标：x = " + i2 + ", y = " + i3);
            Log.e("ocr-test", "计算点坐标：borderWidth = " + i4 + ", borderHeight = " + i5);
            return Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
        } catch (Exception unused) {
            Toast.makeText(this, "取图失败，请使用系统相机，并从相册选取", 1).show();
            a(false, IdCardOcrResult.CODE_CAMERA_ERROR, IdCardOcrResult.MESSAGE_CAMERA_ERROR, this.B, "");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, String str, String str2, String str3) {
        IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
        idCardOcrResult.setResultCode(i2);
        idCardOcrResult.setResultMsg(str);
        idCardOcrResult.image = str3;
        idCardOcrResult.type = str2;
        if (z) {
            this.u.onSuccess(idCardOcrResult);
        } else {
            this.u.onFailure(idCardOcrResult);
        }
        finish();
        this.v = true;
    }
}
