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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.result.IdCardOcrResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.a;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class IdCardOcrCameraActivity extends Activity implements Camera.PreviewCallback, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public Dialog a;
    public FrameLayout b;
    public FrameLayout c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public Camera h;
    public Camera.Parameters i;
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
    public long w;
    public int x;
    public long[] y;
    public int z;

    public IdCardOcrCameraActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = System.currentTimeMillis();
        this.x = 0;
        this.y = new long[]{255, 255, 255, 255};
        this.z = 300;
        this.A = 80;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.b = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091d70);
            this.c = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091d36);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091d99);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091da1);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d46);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d45);
            if ("1".equals(this.B)) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.e.setText("请将二代身份证的国徽页放入识别框内");
            } else if ("2".equals(this.B)) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.e.setText("请将二代身份证的人像页放入识别框内");
            } else {
                a(true, IdCardOcrResult.CODE_PAGE_PARAMS_ERROR, IdCardOcrResult.MESSAGE_PAGE_PARAMS_ERROR, "", "");
            }
            ((FrameLayout) findViewById(R.id.obfuscated_res_0x7f091d38)).setOnClickListener(this);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            boolean z = false;
            try {
                if (this.h == null) {
                    Camera open = Camera.open(0);
                    this.h = open;
                    Camera.Parameters parameters = open.getParameters();
                    this.i = parameters;
                    parameters.setJpegQuality(100);
                    this.i.setPreviewFormat(17);
                    this.i.setPictureFormat(256);
                    g();
                    h();
                    f();
                    this.h.setParameters(this.i);
                }
                if (this.t == null) {
                    a aVar = new a(this, this.h);
                    this.t = aVar;
                    aVar.setPreviewCallback(this);
                    this.b.addView(this.t);
                }
                z = true;
            } catch (Exception e) {
                Log.e(C, e);
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
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            a aVar = this.t;
            if (aVar != null) {
                this.b.removeView(aVar);
                this.t.a();
                this.t = null;
            }
            Camera camera = this.h;
            if (camera != null) {
                camera.setPreviewCallback(null);
                this.h.stopPreview();
                this.h.release();
                this.h = null;
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                if (shouldShowRequestPermissionRationale(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                    new CommonDialog.Builder(this).setTitle(String.format("%1$sApp将使用“%2$s", PassBiometricUtil.getAppName(this), "摄像头/相机")).setMessage(String.format("为了您使用识别功能，请允许%1$sApp使用%2$s。您可以通过系统“设置”进行权限的管理", PassBiometricUtil.getAppName(this), "摄像头/相机")).setPositiveBtn("继续", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IdCardOcrCameraActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.a.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 2001);
                            }
                        }
                    }).setNegativeButton("关闭", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IdCardOcrCameraActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                IdCardOcrCameraActivity idCardOcrCameraActivity = this.a;
                                idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                            }
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
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            int min = Math.min(this.n - ((int) ((Resources.getSystem().getDisplayMetrics().density * 80.0f) + 0.5f)), dp2px(300.0f));
            this.k = min;
            int i = (int) (min * 1.585f);
            this.l = i;
            layoutParams.width = min;
            layoutParams.height = i;
            Log.e("ocr-test", "设置框尺寸： mBorderWidth = " + this.k + "，mBorderHeight = " + this.l);
            this.c.setLayoutParams(layoutParams);
            this.e.setVisibility(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.rightMargin = (int) (((float) this.l) * 0.14f);
            layoutParams2.bottomMargin = (int) (((float) this.k) * 0.082f);
            this.f.setLayoutParams(layoutParams2);
            layoutParams2.rightMargin = (int) (this.l * 0.098f);
            layoutParams2.topMargin = (int) (this.k * 0.048f);
            this.g.setLayoutParams((FrameLayout.LayoutParams) this.g.getLayoutParams());
        }
    }

    private void g() {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.h == null || (parameters = this.i) == null) {
            return;
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = this.i.getSupportedPictureSizes();
        ArrayList<CameraSize> arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            if (size != null) {
                arrayList.add(new CameraSize(this, size));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Camera.Size size2 : supportedPictureSizes) {
            if (size2 != null) {
                arrayList2.add(new CameraSize(this, size2));
            }
        }
        arrayList.retainAll(arrayList2);
        CameraSize cameraSize = null;
        for (CameraSize cameraSize2 : arrayList) {
            Log.e("ocr-test", "相机支持设置的尺寸： width = " + cameraSize2.a + ", height = " + cameraSize2.b);
            float f = ((float) cameraSize2.b) / ((float) this.n);
            int i = (int) (((float) cameraSize2.a) / f);
            if (i >= this.q && f > this.s) {
                this.s = f;
                this.o = i;
                Log.e("ocr-test", "有合适尺寸：" + cameraSize2.toString());
                cameraSize = cameraSize2;
            }
        }
        if (cameraSize == null) {
            Log.e("ocr-test", "未匹配到合适，默认尺寸: 1920*1080");
            this.s = 1.0f;
            this.o = 1920;
            cameraSize = new CameraSize(this, 1920, 1080);
        }
        this.i.setPictureSize(cameraSize.a, cameraSize.b);
        this.i.setPreviewSize(cameraSize.a, cameraSize.b);
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.height = this.o;
            layoutParams.width = this.p;
            Log.e("ocr-test", "设置preview尺寸： mPreviewHeight = " + this.o + "，mPreviewWidth = " + this.p + ",预览分辨率 / 屏幕 = " + this.s);
            this.b.setLayoutParams(layoutParams);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.a == null) {
                this.a = new CommonDialog.Builder(this).setTitle("开启摄像头权限").setMessage("为了使用正常拍照服务\n请开启摄像头权限").setPositiveBtn("去设置", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IdCardOcrCameraActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                            intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                            if (intent.resolveActivity(this.a.getPackageManager()) != null) {
                                this.a.startActivity(intent);
                            }
                            IdCardOcrCameraActivity idCardOcrCameraActivity = this.a;
                            idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                        }
                    }
                }).setNegativeButton("关闭", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.IdCardOcrCameraActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IdCardOcrCameraActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            IdCardOcrCameraActivity idCardOcrCameraActivity = this.a;
                            idCardOcrCameraActivity.a(false, -401, IdCardOcrResult.MESSAGE_NO_CAMERA_PERMISSION, idCardOcrCameraActivity.B, "");
                        }
                    }
                }).build();
            }
            this.a.setCancelable(false);
            if (isFinishing() || this.a.isShowing()) {
                return;
            }
            this.a.show();
        }
    }

    public int dp2px(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBackPressed();
            IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
            idCardOcrResult.setResultCode(-301);
            this.u.onFailure(idCardOcrResult);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || view2.getId() != R.id.obfuscated_res_0x7f091d38 || this.j == null || (parameters = this.i) == null) {
            return;
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        byte[] a = com.baidu.sapi2.utils.a.a(a(com.baidu.sapi2.utils.a.a(this.j, previewSize.width, previewSize.height)), 100);
        if (a == null) {
            IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
            idCardOcrResult.setResultCode(-403);
            idCardOcrResult.setResultMsg(IdCardOcrResult.MESSAGE_CAMERA_ERROR);
            this.u.onFailure(idCardOcrResult);
            finish();
            return;
        }
        a(true, 0, "", this.B, Base64Utils.encodeToString(a));
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d048b);
            this.u = CoreViewRouter.getInstance().getIdCardOcrCallback();
            a();
            b();
            e();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            d();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            if (this.v) {
                return;
            }
            d();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bArr, camera) == null) {
            this.j = bArr;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.w < this.z) {
                return;
            }
            this.w = currentTimeMillis;
            long j = 0;
            long j2 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
            if (Math.abs(bArr.length - (((float) j2) * 1.5f)) < 1.0E-5f) {
                for (int i = 0; i < j2; i += 10) {
                    j += bArr[i] & 255;
                }
                long j3 = j / (j2 / 10);
                long[] jArr = this.y;
                int length = jArr.length;
                int i2 = this.x % length;
                this.x = i2;
                jArr[i2] = j3;
                this.x = i2 + 1;
                boolean z = true;
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.y[i3] > this.A) {
                        z = false;
                    }
                }
                Log.e("ocr-test", "摄像头环境亮度为 ： " + j3);
                if (isFinishing()) {
                    return;
                }
                if (z) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 2001) {
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.r = true;
                    c();
                    return;
                }
                i();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.r) {
                FrameLayout frameLayout = this.c;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class CameraSize {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ IdCardOcrCameraActivity c;

        public CameraSize(IdCardOcrCameraActivity idCardOcrCameraActivity, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {idCardOcrCameraActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = idCardOcrCameraActivity;
            this.a = i;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || CameraSize.class != obj.getClass()) {
                    return false;
                }
                CameraSize cameraSize = (CameraSize) obj;
                return this.a == cameraSize.a && this.b == cameraSize.b;
            }
            return invokeL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CameraSize{width=" + this.a + ", height=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }

        public CameraSize(IdCardOcrCameraActivity idCardOcrCameraActivity, Camera.Size size) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {idCardOcrCameraActivity, size};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = idCardOcrCameraActivity;
            this.a = size.width;
            this.b = size.height;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
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
    }

    private Bitmap a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bitmap)) == null) {
            try {
                int[] iArr = new int[2];
                int identifier = getApplicationContext().getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
                int dimensionPixelSize = identifier > 0 ? getApplicationContext().getResources().getDimensionPixelSize(identifier) : 0;
                this.c.getLocationInWindow(iArr);
                int i = (int) ((iArr[1] - dimensionPixelSize) * this.s);
                int i2 = (int) (iArr[0] * this.s);
                int i3 = (int) (this.l * this.s);
                int i4 = (int) (this.k * this.s);
                Log.e("ocr-test", "计算点坐标：x = " + i + ", y = " + i2);
                Log.e("ocr-test", "计算点坐标：borderWidth = " + i3 + ", borderHeight = " + i4);
                return Bitmap.createBitmap(bitmap, i, i2, i3, i4);
            } catch (Exception unused) {
                Toast.makeText(this, "取图失败，请使用系统相机，并从相册选取", 1).show();
                a(false, -403, IdCardOcrResult.MESSAGE_CAMERA_ERROR, this.B, "");
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, str2, str3}) == null) {
            IdCardOcrResult idCardOcrResult = new IdCardOcrResult();
            idCardOcrResult.setResultCode(i);
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
}
