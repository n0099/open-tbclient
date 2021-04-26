package com.baidu.sapi2.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.y.a.g;
import java.io.File;
/* loaded from: classes2.dex */
public class BaseOptionActivity extends NaSlideActiviy implements View.OnClickListener {
    public static final int IMG_RESULT_OK_CODE = 10000;
    public static final long LIMIT_TIME = 500;
    public static final int NO_CAMERA_PERM_CODE = 10001;
    public static final String NO_CAMERA_PERM_MSG = "请开启相机和存储权限";
    public static final int NO_STORAGE_PERM_CODE = 10002;
    public static final String NO_STORAGE_PERM_MSG = "请开启存储权限";
    public static final String j = "camera_temp_image.jpg";
    public static final int k = 1001;
    public static final int l = 1002;
    public static long lastClickTime = 0;
    public static final int m = 1003;
    public static final int n = 1;
    public static final int o = 512;
    public long enterTimeMills;

    /* renamed from: i  reason: collision with root package name */
    public ImageCropCallback.ImageCropResult f10642i;

    private ImageCropCallback b() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.5
            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropCallback.ImageCropResult imageCropResult) {
                BaseOptionActivity.this.f10642i = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i2 == ClipBoxView.H) {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                } else {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i3);
                intent.setData(uri);
                BaseOptionActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    public long gapTimeFromEnter() {
        return System.currentTimeMillis() - this.enterTimeMills;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = b();
            activityResultCallback = a();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i2, i3, intent);
        }
        if (i2 == 1001) {
            if (i3 == -1 && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg")), 1, 512, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.3
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                    }
                });
            } else {
                processImgBase64Data(i3, null, null);
            }
        } else if (i2 == 1002) {
            if (i3 == -1 && intent.getData() != null && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, intent.getData(), 1, 512, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.4
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                    }
                });
            } else {
                processImgBase64Data(i3, null, null);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.enterTimeMills = System.currentTimeMillis();
    }

    public void pickPhoto() {
        boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode;
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.isDarkMode = z;
        permissionsDTO.permissions = new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        permissionsDTO.dialogTitle = "存储权限";
        permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.2
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i2) {
                BaseOptionActivity.this.processImgBase64Data(10002, BaseOptionActivity.NO_STORAGE_PERM_MSG, null);
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (Build.VERSION.SDK_INT == 19) {
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                        BaseOptionActivity.this.startActivityForResult(intent, 1002);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                        intent2.setAction("android.intent.action.GET_CONTENT");
                        BaseOptionActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void processImgBase64Data(int i2, String str, String str2) {
    }

    public void takePhoto() {
        boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode;
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.isDarkMode = z;
        permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用摄像头和存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.1
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i2) {
                BaseOptionActivity.this.processImgBase64Data(10001, BaseOptionActivity.NO_CAMERA_PERM_MSG, "");
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseOptionActivity.this, g.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg");
                    if (Build.VERSION.SDK_INT >= 24 && BaseOptionActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                        BaseOptionActivity baseOptionActivity = BaseOptionActivity.this;
                        intent.putExtra("output", FileProvider.getUriForFile(baseOptionActivity, BaseOptionActivity.this.getPackageName() + ".passfileprovider", file2));
                    } else {
                        intent.putExtra("output", Uri.fromFile(file2));
                    }
                    intent.putExtra("orientation", 0);
                    BaseOptionActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    private ActivityResultCallback a() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.6
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i2, int i3, Intent intent) {
                if (i2 == 1003) {
                    if (i3 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra == null || BaseOptionActivity.this.f10642i == null) {
                            return;
                        }
                        BaseOptionActivity.this.f10642i.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                    } else if (BaseOptionActivity.this.f10642i != null) {
                        BaseOptionActivity.this.f10642i.onImageResult(null);
                    }
                }
            }
        };
    }
}
