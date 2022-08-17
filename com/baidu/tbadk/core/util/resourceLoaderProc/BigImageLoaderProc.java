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
import com.repackage.dg;
import com.repackage.gu4;
import com.repackage.ig;
import com.repackage.ii;
import com.repackage.ke5;
import com.repackage.lg;
import com.repackage.ne5;
import com.repackage.ng;
import com.repackage.oi;
import com.repackage.qi;
import com.repackage.vb;
import com.repackage.zb;
import com.repackage.zm;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class BigImageLoaderProc implements lg<zm> {
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
                zb newDiskPicOperate = newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO);
                if (vb.f().call(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                    return newDiskPicOperate.getFileInfo();
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static byte[] getFromLocalData(String str, ig igVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, igVar)) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            byte[] bArr = new byte[0];
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            newDiskPicOperate.setLock(bArr);
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                igVar.a = diskCancelWorker;
            }
            if (vb.f().a(newDiskPicOperate)) {
                int i = oi.H() ? 500 : 2000;
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
            if (str != null && ke5.a(str)) {
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
            if (str != null && ke5.a(str)) {
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

    public static zm loadBdImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
            if (vb.f().call(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                newDiskPicOperate.formatData(newDiskPicOperate.getData());
                Bitmap bitmap = newDiskPicOperate.getBitmap();
                if (bitmap != null) {
                    return new zm(bitmap, newDiskPicOperate.isGif(), str);
                }
                return null;
            }
            return null;
        }
        return (zm) invokeL.objValue;
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

    public static void updateLocal(String str, byte[] bArr, boolean z, ig igVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, bArr, Boolean.valueOf(z), igVar}) == null) {
            String pidFromCDNURL = getPidFromCDNURL(str);
            zb newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
            newDiskPicOperate.setGif(z);
            if (pidFromCDNURL != null) {
                newDiskPicOperate.e(getIsHighQualityFromCDNURL(str));
            } else {
                newDiskPicOperate.e(true);
            }
            newDiskPicOperate.setData(bArr);
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(newDiskPicOperate);
                igVar.a = diskCancelWorker;
            }
            vb.f().a(newDiskPicOperate);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public zm m42decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (zm) invokeLL.objValue;
    }

    @Override // com.repackage.lg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.lg
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
    @Override // com.repackage.lg
    public zm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (zm) invokeCommon.objValue;
    }

    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.procType : invokeV.intValue;
    }

    @Override // com.repackage.lg
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

    @Override // com.repackage.lg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromLocal(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
            byte[] bArr = (byte[]) objArr[1];
            Bitmap Bytes2Bitmap = bArr != null ? BitmapHelper.Bytes2Bitmap(bArr) : null;
            if (Bytes2Bitmap == null) {
                if (booleanValue && str.startsWith("/")) {
                    Bytes2Bitmap = ii.d().c(str);
                    if (Bytes2Bitmap != null && bArr == null) {
                        bArr = ii.d().a(Bytes2Bitmap, 100);
                    }
                } else {
                    bArr = getFromLocalData(str, igVar);
                    if (bArr != null) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                    }
                }
            }
            if (Bytes2Bitmap != null) {
                return new zm(Bytes2Bitmap, qi.B(bArr), str2, bArr);
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromRemote(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
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
                ne5.e(booleanValue, str3, str);
                Pair<Boolean, String> d = ne5.d(str3);
                if (((Boolean) d.first).booleanValue()) {
                    str4 = (String) d.second;
                    z = true;
                } else {
                    str4 = str3;
                    z = false;
                }
                WebClient webClient = new WebClient();
                if (igVar != null) {
                    igVar.a = webClient;
                }
                byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !booleanValue);
                boolean needCache = webClient.needCache();
                if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                    BdLog.e("BIGIMAGE imagesize too big");
                    gu4.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "BigImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str4);
                }
                if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080bc4, new TypedValue());
                        downloadImageBytes = dg.d(openRawResource);
                        ng.c(openRawResource);
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                if (webClient.IsRequestSuccess() || webClient.responseCode == 302) {
                    bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    if (z && bitmap == null) {
                        ne5.b(str4);
                        downloadImageBytes = webClient.downloadImageBytes(str3, !booleanValue);
                        needCache = webClient.needCache();
                        if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                            bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        }
                    }
                }
                if (needCache && !webClient.isCrackPic) {
                    updateLocal(str, downloadImageBytes, false, igVar);
                }
                zm zmVar = new zm(bitmap, qi.B(downloadImageBytes), str, downloadImageBytes);
                zmVar.y(needCache);
                return zmVar;
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }
}
