package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.io.File;
/* loaded from: classes5.dex */
public class SelectImageHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_WRITE_EXTERNAL_STORGE_AND_CAMERA_PERMISSON = 1;
    public static final String TMP_IMAGE_NAME = "camera.jpg";
    public transient /* synthetic */ FieldHolder $fh;

    public SelectImageHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Bitmap AlbumImageResult(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, uri, i)) == null) {
            try {
                return BitmapHelper.subSampleBitmap(context, uri, i);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap ImageResult(int i, Context context, Uri uri, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), context, uri, Integer.valueOf(i2)})) == null) {
            if (i == 12001) {
                return photoResult(i2);
            }
            return AlbumImageResult(context, uri, i2);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static void getAlbumImage(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            getSystemAlbumImage(activity);
        }
    }

    public static void getSystemAlbumImage(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity) == null) {
            try {
                Intent intent = new Intent();
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                intent.setAction("android.intent.action.GET_CONTENT");
                activity.startActivityForResult(intent, TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static Bitmap photoResult(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            try {
                int readPictureDegree = readPictureDegree(FileHelper.getFileDireciory(TMP_IMAGE_NAME));
                Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(TMP_IMAGE_NAME, i);
                return (readPictureDegree == 0 || subSampleBitmap == null) ? subSampleBitmap : BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int readPictureDegree(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        return attributeInt != 8 ? 0 : 270;
                    }
                    return 90;
                }
                return 180;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void takePhoto(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, tbPageContext) == null) {
            try {
                if (!FileHelper.checkSD()) {
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                        return;
                    } else if (tbPageContext instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                File CreateFile = FileHelper.CreateFile(TMP_IMAGE_NAME);
                if (CreateFile != null) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", UtilHelper.getUriFromFile(CreateFile, intent, tbPageContext.getPageActivity()));
                    tbPageContext.getPageActivity().startActivityForResult(intent, w0.I5);
                } else if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0592));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0592));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void takePhoto(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, str) == null) {
            try {
                if (!FileHelper.checkSD()) {
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        ((BaseActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                        return;
                    } else if (tbPageContext instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(FileHelper.getSdErrorString());
                        return;
                    } else {
                        return;
                    }
                }
                String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR;
                boolean z = false;
                if (FileHelper.CheckTempDir(str2)) {
                    File file = new File(str2 + "/" + str);
                    z = !file.exists() ? file.createNewFile() : true;
                    if (z) {
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra("output", UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                        tbPageContext.getPageActivity().startActivityForResult(intent, w0.I5);
                    }
                }
                if (z) {
                    return;
                }
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0592));
                } else if (tbPageContext instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) tbPageContext.getOrignalPage()).showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0592));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
