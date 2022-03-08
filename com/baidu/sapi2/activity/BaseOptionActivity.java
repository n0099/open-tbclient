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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
/* loaded from: classes4.dex */
public class BaseOptionActivity extends NaSlideActiviy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMG_RESULT_OK_CODE = 10000;
    public static final long LIMIT_TIME = 500;
    public static final int NO_CAMERA_PERM_CODE = 10001;
    public static final String NO_CAMERA_PERM_MSG = "请开启相机和存储权限";
    public static final int NO_STORAGE_PERM_CODE = 10002;
    public static final String NO_STORAGE_PERM_MSG = "请开启存储权限";

    /* renamed from: j  reason: collision with root package name */
    public static final String f36653j = "camera_temp_image.jpg";
    public static final int k = 1001;
    public static final int l = 1002;
    public static long lastClickTime = 0;
    public static final int m = 1003;
    public static final int n = 1;
    public static final int o = 512;
    public transient /* synthetic */ FieldHolder $fh;
    public long enterTimeMills;

    /* renamed from: i  reason: collision with root package name */
    public ImageCropCallback.ImageCropResult f36654i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-706843976, "Lcom/baidu/sapi2/activity/BaseOptionActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-706843976, "Lcom/baidu/sapi2/activity/BaseOptionActivity;");
        }
    }

    public BaseOptionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private ImageCropCallback b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? new ImageCropCallback(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseOptionActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropCallback.ImageCropResult imageCropResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i2), Integer.valueOf(i3), imageCropResult}) == null) {
                    this.a.f36654i = imageCropResult;
                    Intent intent = new Intent(context, ImageClipActivity.class);
                    if (i2 == ClipBoxView.H) {
                        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                    } else {
                        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                    }
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i3);
                    intent.setData(uri);
                    this.a.startActivityForResult(intent, 1003);
                }
            }
        } : (ImageCropCallback) invokeV.objValue;
    }

    public long gapTimeFromEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.enterTimeMills : invokeV.longValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
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
                    imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), 1, 512, new ImageCropCallback.ImageCropResult(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseOptionActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.a.processImgBase64Data(10000, "", str);
                            }
                        }
                    });
                } else {
                    processImgBase64Data(i3, null, null);
                }
            } else if (i2 == 1002) {
                if (i3 == -1 && intent.getData() != null && imageCropCallback2 != null) {
                    imageCropCallback2.onImageCrop(this, intent.getData(), 1, 512, new ImageCropCallback.ImageCropResult(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseOptionActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.a.processImgBase64Data(10000, "", str);
                            }
                        }
                    });
                } else {
                    processImgBase64Data(i3, null, null);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    @Override // com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.enterTimeMills = System.currentTimeMillis();
        }
    }

    public void pickPhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode;
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = this;
            permissionsDTO.isDarkMode = z;
            permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
            permissionsDTO.dialogTitle = "存储权限";
            permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseOptionActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.a.processImgBase64Data(10002, BaseOptionActivity.NO_STORAGE_PERM_MSG, null);
                    }
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        try {
                            if (Build.VERSION.SDK_INT == 19) {
                                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                                this.a.startActivityForResult(intent, 1002);
                                return;
                            }
                            Intent intent2 = new Intent();
                            intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                            intent2.setAction("android.intent.action.GET_CONTENT");
                            this.a.startActivityForResult(intent2, 1002);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    public void processImgBase64Data(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, str, str2) == null) {
        }
    }

    public void takePhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode;
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = this;
            permissionsDTO.isDarkMode = z;
            permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            permissionsDTO.dialogTitle = "权限申请";
            permissionsDTO.dialogMsg = "为了正常使用图片上传服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseOptionActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.a.processImgBase64Data(10001, BaseOptionActivity.NO_CAMERA_PERM_MSG, "");
                    }
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        try {
                            if (!"mounted".equals(Environment.getExternalStorageState())) {
                                Toast.makeText(this.a, (int) R.string.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                                return;
                            }
                            File file = new File(this.a.getExternalCacheDir(), "camera_temp_image.jpg");
                            if (file.exists()) {
                                file.delete();
                            }
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.setAction("android.media.action.IMAGE_CAPTURE");
                            File file2 = new File(this.a.getExternalCacheDir(), "camera_temp_image.jpg");
                            if (Build.VERSION.SDK_INT >= 24 && this.a.getApplicationInfo().targetSdkVersion >= 24) {
                                BaseOptionActivity baseOptionActivity = this.a;
                                intent.putExtra("output", FileProvider.getUriForFile(baseOptionActivity, this.a.getPackageName() + ".passfileprovider", file2));
                            } else {
                                intent.putExtra("output", Uri.fromFile(file2));
                            }
                            intent.putExtra("orientation", 0);
                            this.a.startActivityForResult(intent, 1001);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    private ActivityResultCallback a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new ActivityResultCallback(this) { // from class: com.baidu.sapi2.activity.BaseOptionActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseOptionActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i2, int i3, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, intent) == null) && i2 == 1003) {
                    if (i3 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra == null || this.a.f36654i == null) {
                            return;
                        }
                        this.a.f36654i.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                    } else if (this.a.f36654i != null) {
                        this.a.f36654i.onImageResult(null);
                    }
                }
            }
        } : (ActivityResultCallback) invokeV.objValue;
    }
}
