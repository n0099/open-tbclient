package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cg;
import com.repackage.hg;
import com.repackage.hi;
import com.repackage.kd5;
import com.repackage.kg;
import com.repackage.mg;
import com.repackage.mt4;
import com.repackage.nd5;
import com.repackage.ni;
import com.repackage.pi;
import com.repackage.ub;
import com.repackage.yb;
import com.repackage.ym;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class BigImageLoaderProc implements kg<ym> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NCDN_PER = "width=";
    public transient /* synthetic */ FieldHolder $fh;
    public int procType;

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

    public static boolean checkBigImageFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String nameMd5FromUrl = getNameMd5FromUrl(str);
            if (TextUtils.isEmpty(nameMd5FromUrl)) {
                return false;
            }
            return newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO).call();
        }
        return invokeL.booleanValue;
    }

    public static File getFileInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String nameMd5FromUrl = getNameMd5FromUrl(str);
            if (!TextUtils.isEmpty(nameMd5FromUrl)) {
                yb newDiskPicOperate = newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO);
                if (ub.f().call(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                    return newDiskPicOperate.getFileInfo();
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static byte[] getFromLocalData(String str, hg hgVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, hgVar)) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            byte[] bArr = new byte[0];
            yb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            newDiskPicOperate.setLock(bArr);
            if (hgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                hgVar.a = diskCancelWorker;
            }
            if (ub.f().a(newDiskPicOperate)) {
                int i = ni.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (newDiskPicOperate.isSuccess()) {
                    if (pidFromCDNURL == null || newDiskPicOperate.d() || !getIsHighQualityFromCDNURL(str)) {
                        return newDiskPicOperate.c();
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static boolean getIsHighQualityFromCDNURL(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && kd5.a(str)) {
                String[] split2 = str.split("/");
                if (split2.length > 3) {
                    try {
                        for (String str2 : URLDecoder.decode(split2[split2.length - 3], IMAudioTransRequest.CHARSET).split(ParamableElem.DIVIDE_PARAM)) {
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

    public static String getPidFromCDNURL(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str != null && kd5.a(str)) {
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

    public static ym loadBdImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            yb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            if (ub.f().call(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                newDiskPicOperate.formatData(newDiskPicOperate.getData());
                Bitmap bitmap = newDiskPicOperate.getBitmap();
                if (bitmap != null) {
                    return new ym(bitmap, newDiskPicOperate.isGif(), str);
                }
                return null;
            }
            return null;
        }
        return (ym) invokeL.objValue;
    }

    public static yb newDiskPicOperate(String str, DiskFileOperate.Action action) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, action)) == null) {
            yb ybVar = new yb("images", str, action);
            ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ybVar.setSubFolder(true);
            ybVar.setSdCard(false);
            ybVar.setSavedCache(true);
            return ybVar;
        }
        return (yb) invokeLL.objValue;
    }

    public static void updateLocal(String str, byte[] bArr, boolean z, hg hgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, bArr, Boolean.valueOf(z), hgVar}) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            yb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
            newDiskPicOperate.setGif(z);
            if (pidFromCDNURL != null) {
                newDiskPicOperate.e(getIsHighQualityFromCDNURL(str));
            } else {
                newDiskPicOperate.e(true);
            }
            newDiskPicOperate.setData(bArr);
            if (hgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                hgVar.a = diskCancelWorker;
            }
            ub.f().a(newDiskPicOperate);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public ym m42decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (ym) invokeLL.objValue;
    }

    @Override // com.repackage.kg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.kg
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
    @Override // com.repackage.kg
    public ym getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (ym) invokeCommon.objValue;
    }

    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.procType : invokeV.intValue;
    }

    @Override // com.repackage.kg
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

    @Override // com.repackage.kg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromLocal(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
            byte[] bArr = (byte[]) objArr[1];
            Bitmap Bytes2Bitmap = bArr != null ? BitmapHelper.Bytes2Bitmap(bArr) : null;
            if (Bytes2Bitmap == null) {
                if (booleanValue && str.startsWith("/")) {
                    Bytes2Bitmap = hi.d().c(str);
                    if (Bytes2Bitmap != null && bArr == null) {
                        bArr = hi.d().a(Bytes2Bitmap, 100);
                    }
                } else {
                    bArr = getFromLocalData(str, hgVar);
                    if (bArr != null) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                    }
                }
            }
            if (Bytes2Bitmap != null) {
                return new ym(Bytes2Bitmap, pi.B(bArr), str2, bArr);
            }
            return null;
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromRemote(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            Bitmap bitmap = null;
            if (str == null || !str.startsWith("/")) {
                boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[2])).booleanValue();
                if (str != null && str.startsWith(NCDN_PER)) {
                    booleanValue = false;
                }
                if (booleanValue) {
                    str3 = str;
                } else {
                    str3 = TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + TbImageHelper.getInstance().getUrlQuality());
                }
                nd5.e(booleanValue, str3, str);
                Pair<Boolean, String> d = nd5.d(str3);
                if (((Boolean) d.first).booleanValue()) {
                    str4 = (String) d.second;
                    z = true;
                } else {
                    str4 = str3;
                    z = false;
                }
                WebClient webClient = new WebClient();
                if (hgVar != null) {
                    hgVar.a = webClient;
                }
                byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !booleanValue);
                boolean needCache = webClient.needCache();
                if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                    BdLog.e("BIGIMAGE imagesize too big");
                    mt4.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "BigImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str4);
                }
                if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080b9d, new TypedValue());
                        downloadImageBytes = cg.d(openRawResource);
                        mg.c(openRawResource);
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                if (webClient.IsRequestSuccess() || webClient.responseCode == 302) {
                    bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    if (z && bitmap == null) {
                        nd5.b(str4);
                        downloadImageBytes = webClient.downloadImageBytes(str3, !booleanValue);
                        needCache = webClient.needCache();
                        if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                            bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        }
                    }
                }
                if (needCache && !webClient.isCrackPic) {
                    updateLocal(str, downloadImageBytes, false, hgVar);
                }
                ym ymVar = new ym(bitmap, pi.B(downloadImageBytes), str, downloadImageBytes);
                ymVar.y(needCache);
                return ymVar;
            }
            return null;
        }
        return (ym) invokeCommon.objValue;
    }
}
