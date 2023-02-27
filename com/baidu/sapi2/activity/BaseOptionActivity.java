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
import androidx.appcompat.app.AppCompatActivity;
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
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
/* loaded from: classes2.dex */
public class BaseOptionActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int IMG_RESULT_OK_CODE = 10000;
    public static final long LIMIT_TIME = 500;
    public static final int NO_CAMERA_PERM_CODE = 10001;
    public static final String NO_CAMERA_PERM_MSG = "请开启相机和存储权限";
    public static final int NO_STORAGE_PERM_CODE = 10002;
    public static final String NO_STORAGE_PERM_MSG = "请开启存储权限";
    public static final String b = "camera_temp_image.jpg";
    public static final int c = 1001;
    public static final int d = 1002;
    public static final int e = 1003;
    public static final int f = 1;
    public static final int g = 512;
    public static long lastClickTime;
    public ImageCropCallback.ImageCropResult a;
    public long enterTimeMills;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void processImgBase64Data(int i, String str, String str2) {
    }

    private ActivityResultCallback a() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.6
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i, int i2, Intent intent) {
                if (i == 1003) {
                    if (i2 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra != null && BaseOptionActivity.this.a != null) {
                            BaseOptionActivity.this.a.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                        }
                    } else if (BaseOptionActivity.this.a != null) {
                        BaseOptionActivity.this.a.onImageResult(null);
                    }
                }
            }
        };
    }

    private ImageCropCallback b() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.5
            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropCallback.ImageCropResult imageCropResult) {
                BaseOptionActivity.this.a = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i == ClipBoxView.H) {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                } else {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i2);
                intent.setData(uri);
                BaseOptionActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    public long gapTimeFromEnter() {
        return System.currentTimeMillis() - this.enterTimeMills;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.enterTimeMills = System.currentTimeMillis();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = b();
            activityResultCallback = a();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i, i2, intent);
        }
        if (i == 1001) {
            if (i2 == -1 && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), 1, 512, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.3
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                    }
                });
            } else {
                processImgBase64Data(i2, null, null);
            }
        } else if (i == 1002) {
            if (i2 == -1 && intent.getData() != null && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, intent.getData(), 1, 512, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.4
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        BaseOptionActivity.this.processImgBase64Data(10000, "", str);
                    }
                });
            } else {
                processImgBase64Data(i2, null, null);
            }
        }
    }

    public void pickPhoto() {
        boolean z;
        if (!SapiAccountManager.getInstance().getConfignation().isNightMode && !SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            z = false;
        } else {
            z = true;
        }
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.isDarkMode = z;
        permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "存储权限";
        permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.2
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
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
                        intent2.setAction("android.intent.action.PICK");
                        BaseOptionActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void takePhoto() {
        boolean z;
        if (!SapiAccountManager.getInstance().getConfignation().isNightMode && !SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            z = false;
        } else {
            z = true;
        }
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.isDarkMode = z;
        permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseOptionActivity.1
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                BaseOptionActivity.this.processImgBase64Data(10001, BaseOptionActivity.NO_CAMERA_PERM_MSG, "");
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseOptionActivity.this, (int) R.string.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(BaseOptionActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(BaseOptionActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
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
}
