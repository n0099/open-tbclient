package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ImageLogger;
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
import com.repackage.hg;
import com.repackage.i55;
import com.repackage.ig;
import com.repackage.kg;
import com.repackage.lg;
import com.repackage.ne5;
import com.repackage.ng;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.rn4;
import com.repackage.vb;
import com.repackage.zb;
import com.repackage.zm;
import java.io.InputStream;
/* loaded from: classes3.dex */
public abstract class AbstractImageLoaderProc implements lg<zm> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractImageLoaderProc() {
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

    public static boolean isImageFileExist(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zb zbVar = new zb("images", TbMd5.getNameMd5FromUrl(kg.h().g(str, i)), DiskFileOperate.Action.INFO);
            zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            zbVar.setSubFolder(true);
            zbVar.setIsFormatData(false);
            zbVar.setSdCard(false);
            zbVar.setSavedCache(true);
            return zbVar.call();
        }
        return invokeLI.booleanValue;
    }

    public static zm loadBdImageFromLocal(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = kg.h().g(str, i);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g);
            if (i == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            zb zbVar = new zb("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            zbVar.setSubFolder(true);
            zbVar.setIsFormatData(false);
            zbVar.setSavedCache(true);
            zbVar.setSdCard(false);
            if (vb.f().call(zbVar) && zbVar.isSuccess()) {
                zbVar.formatData(zbVar.getData());
                Bitmap bitmap = zbVar.getBitmap();
                if (bitmap != null) {
                    return new zm(bitmap, zbVar.isGif(), g);
                }
                return null;
            }
            return null;
        }
        return (zm) invokeLI.objValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) ? BitmapHelper.checkBitmapSize(bitmap, i, i2) : (Bitmap) invokeLII.objValue;
    }

    public boolean checkBitmapValid(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? bitmap != null : invokeL.booleanValue;
    }

    public zb createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new zb("images", str, DiskFileOperate.Action.READ) : (zb) invokeL.objValue;
    }

    public zm createImageFromDiskPicOperate(zb zbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, zbVar, str, i, i2)) == null) {
            if (zbVar == null) {
                return null;
            }
            zbVar.b(zbVar.getData(), i, i2);
            Bitmap checkBitmapSize = checkBitmapSize(zbVar.getBitmap(), i, i2);
            if (checkBitmapSize != null) {
                return new zm(checkBitmapSize, zbVar.isGif(), str);
            }
            return null;
        }
        return (zm) invokeLLII.objValue;
    }

    public zm decodeToResourceWithWH(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i, i2);
            hg.c(decodeByteArray != null, System.currentTimeMillis() - currentTimeMillis);
            return new zm(decodeByteArray);
        }
        return (zm) invokeLII.objValue;
    }

    @Override // com.repackage.lg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.lg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract int getProcType();

    public abstract int getSuggestHeight();

    public abstract int getSuggestWidth();

    public String getUrlbyClientServerAddr(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, str, i, i2)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (str.startsWith(TbConfig.IMAGE_ADDRESS) || str.startsWith(TbDomainConfig.DOMAIN_HTTPS_STATIC_SERVER)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(pi.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + TbImageHelper.getInstance().getUrlQuality());
            sb.append("&first_gif=1");
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public abstract boolean isFromCDN();

    @Override // com.repackage.lg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? rn4.c().g() : invokeV.booleanValue;
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                i55.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
                return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, str, bArr, objArr) == null) || TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        zb zbVar = new zb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        zbVar.setSubFolder(true);
        zbVar.setData(bArr);
        zbVar.setSdCard(false);
        zbVar.setSavedCache(true);
        zbVar.setGif(booleanValue3);
        vb.f().a(zbVar);
        ig igVar = (ig) objArr[3];
        if (igVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(zbVar);
            igVar.a = diskCancelWorker;
        }
    }

    @Override // com.repackage.lg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof zm)) {
            zm zmVar = (zm) obj;
            if (zmVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                zmVar.A(i);
                zmVar.z(i2);
                i55.k().d(str, zmVar);
                hg.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public zm m41decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) ? decodeToResourceWithWH(bArr, qi.k(TbadkCoreApplication.getInst()), qi.i(TbadkCoreApplication.getInst())) : (zm) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromLocal(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[0];
            zb createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                igVar.a = diskCancelWorker;
            }
            if (!vb.f().a(createDiskPicOperate)) {
                hg.f(false, 0L);
                return null;
            }
            int i3 = oi.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException unused) {
                }
            }
            if (i == 0) {
                i = getSuggestWidth();
            }
            if (i2 == 0) {
                i2 = getSuggestHeight();
            }
            if (i == 0) {
                i = qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i2 == 0) {
                i2 = qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            zm createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2) : null;
            hg.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
            return createImageFromDiskPicOperate;
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            zm m = i55.k().m(str);
            if (z) {
                hg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x0167, TryCatch #0 {all -> 0x0167, blocks: (B:47:0x0106, B:49:0x0128, B:54:0x0132, B:56:0x0138, B:58:0x0163), top: B:123:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
    @Override // com.repackage.lg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zm getFromRemote(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        WebClient webClient;
        int i3;
        boolean z2;
        byte[] bArr;
        boolean z3;
        String str4;
        boolean z4;
        int i4;
        String str5;
        int i5;
        int i6;
        Bitmap p;
        byte[] bArr2;
        boolean z5;
        boolean z6;
        WebClient webClient2;
        boolean z7;
        zm zmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int suggestWidth = i == 0 ? getSuggestWidth() : i;
            int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
            if (suggestWidth == 0) {
                suggestWidth = qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i7 = suggestWidth;
            if (suggestHeight == 0) {
                suggestHeight = qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i8 = suggestHeight;
            boolean isFromCDN = isFromCDN();
            String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, i7, i8);
            ne5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = ne5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                str3 = (String) d.second;
                z = true;
            } else {
                str3 = urlbyClientServerAddr;
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (igVar != null) {
                igVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(str3, !isFromCDN);
            boolean needCache = webClient3.needCache();
            Rect rect = new Rect();
            if (webClient3.IsRequestSuccess()) {
                webClient = webClient3;
                i3 = 1;
                z2 = needCache;
            } else if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                hg.j(false, str3, webClient3.mStat, 0L, 0L);
                if (webClient3.mStat != null) {
                    webClient2 = webClient3;
                    z6 = needCache;
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                } else {
                    z6 = needCache;
                    webClient2 = webClient3;
                }
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080bc2, new TypedValue());
                    byte[] d2 = dg.d(openRawResource);
                    Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d2, rect);
                    WebClient webClient4 = webClient2;
                    if (!webClient4.isGif && !qi.B(d2)) {
                        z7 = false;
                        if (checkBitmapValid(Bytes2NineBitmap)) {
                            zmVar = null;
                        } else {
                            zmVar = new zm(Bytes2NineBitmap, z7, str, rect);
                            boolean z8 = z6;
                            zmVar.y(z8);
                            storeLocal(str2, d2, Boolean.valueOf(z8), Boolean.valueOf(webClient4.isCrackPic), Boolean.valueOf(z7), igVar, Bytes2NineBitmap);
                        }
                        ng.c(openRawResource);
                        return zmVar;
                    }
                    z7 = true;
                    if (checkBitmapValid(Bytes2NineBitmap)) {
                    }
                    ng.c(openRawResource);
                    return zmVar;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else {
                webClient = webClient3;
                i3 = 1;
                z2 = needCache;
                if (!webClient.getResponse().a) {
                    hg.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
            }
            if (downloadImageBytes == null) {
                if (webClient.getResponse().a) {
                    return null;
                }
                hg.j(false, str3, webClient.mStat, 0L, 0L);
                ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String str6 = urlbyClientServerAddr;
            hg.j(downloadImageBytes.length > i3, str3, webClient.mStat, currentTimeMillis2, downloadImageBytes.length);
            if (downloadImageBytes.length > 1) {
                ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                z3 = z2;
                str4 = str3;
                bArr = downloadImageBytes;
                str5 = str6;
                z4 = isFromCDN;
                i4 = i8;
                ImageLogger.imagePerfNetLog(str, true, str3, Boolean.valueOf(z), webClient.mStat, "InputToByteSucc", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            } else {
                bArr = downloadImageBytes;
                z3 = z2;
                str4 = str3;
                z4 = isFromCDN;
                i4 = i8;
                str5 = str6;
                ImageLogger.imagePerfNetLog(str, false, str4, Boolean.valueOf(z), webClient.mStat, "bytes<1", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            }
            byte[] bArr3 = bArr;
            i55.k().i(TbConfig.getPbImageSize() + bArr3.length);
            if (getProcType() == 19) {
                i6 = 1;
                p = m41decodeToResource(bArr3, rect).p();
                i5 = i7;
            } else {
                i5 = i7;
                i6 = 1;
                p = decodeToResourceWithWH(bArr3, i5, i4).p();
            }
            if (z && p == null) {
                ne5.b(str4);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(str5, !z4);
                boolean needCache2 = webClient.needCache();
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    if (getProcType() == 19) {
                        Object[] objArr2 = new Object[i6];
                        objArr2[0] = rect;
                        p = m41decodeToResource(downloadImageBytes2, objArr2).p();
                    } else {
                        p = decodeToResourceWithWH(downloadImageBytes2, i5, i4).p();
                    }
                }
                bArr2 = downloadImageBytes2;
                z5 = needCache2;
            } else {
                bArr2 = bArr3;
                z5 = z3;
            }
            if (bArr2 == null || p == null) {
                return null;
            }
            boolean z9 = webClient.isGif || qi.B(bArr2);
            Bitmap resizeBitmapSize = resizeBitmapSize(p, i5, i4);
            if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                zm zmVar2 = new zm(resizeBitmapSize, z9, str, rect);
                zmVar2.y(z5);
                Object[] objArr3 = new Object[5];
                objArr3[0] = Boolean.valueOf(z5);
                objArr3[i6] = Boolean.valueOf(webClient.isCrackPic);
                objArr3[2] = Boolean.valueOf(z9);
                objArr3[3] = igVar;
                objArr3[4] = resizeBitmapSize;
                storeLocal(str2, bArr2, objArr3);
                return zmVar2;
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }
}
