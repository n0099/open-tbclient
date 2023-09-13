package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.R;
import com.baidu.tieba.dx5;
import com.baidu.tieba.eg;
import com.baidu.tieba.fg;
import com.baidu.tieba.gx5;
import com.baidu.tieba.vb;
import com.baidu.tieba.yh;
import com.baidu.tieba.zb;
import com.baidu.tieba.zf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class BigImageLoaderProc implements fg<BdImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NCDN_PER = "width=";
    public transient /* synthetic */ FieldHolder $fh;
    public int procType;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public BdImage m121decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (BdImage) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.fg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.baidu.tieba.fg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }

    public BigImageLoaderProc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.procType = 0;
        this.procType = i;
    }

    public static File getFileInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String nameMd5FromUrl = getNameMd5FromUrl(str);
            if (!TextUtils.isEmpty(nameMd5FromUrl)) {
                zb newDiskPicOperate = newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO);
                if (vb.f().call(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                    return newDiskPicOperate.getFileInfo();
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static boolean checkBigImageFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String nameMd5FromUrl = getNameMd5FromUrl(str);
            if (!TextUtils.isEmpty(nameMd5FromUrl)) {
                return newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO).call();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getNameMd5FromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            if (pidFromCDNURL != null) {
                str = pidFromCDNURL;
            }
            return TbMd5.getNameMd5FromUrl(str);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] getFromLocalData(String str, eg egVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, egVar)) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            byte[] bArr = new byte[0];
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            newDiskPicOperate.setLock(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                egVar.a = diskCancelWorker;
            }
            if (!vb.f().a(newDiskPicOperate)) {
                return null;
            }
            int i = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!newDiskPicOperate.isSuccess()) {
                return null;
            }
            if (pidFromCDNURL != null && !newDiskPicOperate.d() && getIsHighQualityFromCDNURL(str)) {
                return null;
            }
            return newDiskPicOperate.c();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static boolean getIsHighQualityFromCDNURL(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && dx5.a(str)) {
                String[] split2 = str.split("/");
                if (split2.length > 3) {
                    try {
                        for (String str2 : URLDecoder.decode(split2[split2.length - 3], "utf-8").split(ParamableElem.DIVIDE_PARAM)) {
                            if (str2.startsWith("q")) {
                                String[] split3 = str2.split("=");
                                if (Integer.valueOf(split3[split3.length - 1]).intValue() <= 50) {
                                    return false;
                                }
                            }
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String getPidFromCDNURL(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str != null && dx5.a(str)) {
                int lastIndexOf = str.lastIndexOf("/");
                int lastIndexOf2 = str.lastIndexOf(".");
                int lastIndexOf3 = str.lastIndexOf(".jpg");
                if (lastIndexOf3 <= 0) {
                    int lastIndexOf4 = str.lastIndexOf(".webp");
                    if (lastIndexOf4 <= 0) {
                        return null;
                    }
                    i = lastIndexOf4 + 5;
                } else {
                    i = lastIndexOf3 + 4;
                }
                StringBuffer stringBuffer = new StringBuffer();
                if (lastIndexOf > 0 && lastIndexOf2 > 0) {
                    stringBuffer.append(str.substring(lastIndexOf + 1, lastIndexOf2));
                    stringBuffer.append(str.substring(i));
                    return stringBuffer.toString();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static BdImage loadBdImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            if (!vb.f().call(newDiskPicOperate) || !newDiskPicOperate.isSuccess()) {
                return null;
            }
            newDiskPicOperate.formatData(newDiskPicOperate.getData());
            Bitmap bitmap = newDiskPicOperate.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new BdImage(bitmap, newDiskPicOperate.isGif(), str);
        }
        return (BdImage) invokeL.objValue;
    }

    public static zb newDiskPicOperate(String str, DiskFileOperate.Action action) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, action)) == null) {
            zb zbVar = new zb("images", str, action);
            zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            zbVar.setSubFolder(true);
            zbVar.setSdCard(false);
            zbVar.setSavedCache(true);
            return zbVar;
        }
        return (zb) invokeLL.objValue;
    }

    public static void updateLocal(String str, byte[] bArr, boolean z, eg egVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, bArr, Boolean.valueOf(z), egVar}) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
            newDiskPicOperate.setGif(z);
            if (pidFromCDNURL != null) {
                newDiskPicOperate.e(getIsHighQualityFromCDNURL(str));
            } else {
                newDiskPicOperate.e(true);
            }
            newDiskPicOperate.setData(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                egVar.a = diskCancelWorker;
            }
            vb.f().a(newDiskPicOperate);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
            byte[] bArr = (byte[]) objArr[1];
            if (bArr != null) {
                bitmap = BitmapHelper.Bytes2Bitmap(bArr);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                if (booleanValue && str.startsWith("/")) {
                    bitmap = yh.d().c(str);
                    if (bitmap != null && bArr == null) {
                        bArr = yh.d().a(bitmap, 100);
                    }
                } else {
                    bArr = getFromLocalData(str, egVar);
                    if (bArr != null) {
                        bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                    }
                }
            }
            if (bitmap == null) {
                return null;
            }
            return new BdImage(bitmap, BdUtilHelper.isGif(bArr), str2, bArr);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            Bitmap bitmap = null;
            if (str != null && str.startsWith("/")) {
                return null;
            }
            boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[2])).booleanValue();
            if (str != null && str.startsWith(NCDN_PER)) {
                booleanValue = false;
            }
            if (booleanValue) {
                str3 = str;
            } else {
                str3 = TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + TbImageHelper.getInstance().getUrlQuality());
            }
            gx5.e(booleanValue, str3, str);
            Pair<Boolean, String> d = gx5.d(str3);
            if (((Boolean) d.first).booleanValue()) {
                str4 = (String) d.second;
                z = true;
            } else {
                str4 = str3;
                z = false;
            }
            WebClient webClient = new WebClient();
            if (egVar != null) {
                egVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !booleanValue);
            boolean needCache = webClient.needCache();
            if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                BdLog.e("BIGIMAGE imagesize too big");
                Logger.addLog(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "BigImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str4);
            }
            if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete_big2, new TypedValue());
                    downloadImageBytes = zf.d(openRawResource);
                    BdCloseHelper.close(openRawResource);
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            }
            if (webClient.IsRequestSuccess() || webClient.responseCode == 302) {
                bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && bitmap == null) {
                    gx5.b(str4);
                    downloadImageBytes = webClient.downloadImageBytes(str3, !booleanValue);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
            }
            if (needCache && !webClient.isCrackPic) {
                updateLocal(str, downloadImageBytes, false, egVar);
            }
            BdImage bdImage = new BdImage(bitmap, BdUtilHelper.isGif(downloadImageBytes), str, downloadImageBytes);
            bdImage.setNeedCache(needCache);
            return bdImage;
        }
        return (BdImage) invokeCommon.objValue;
    }

    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.procType;
        }
        return invokeV.intValue;
    }
}
