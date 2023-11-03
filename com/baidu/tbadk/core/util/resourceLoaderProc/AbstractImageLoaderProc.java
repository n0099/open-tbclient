package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.R;
import com.baidu.tieba.j7;
import com.baidu.tieba.jt5;
import com.baidu.tieba.lv4;
import com.baidu.tieba.mb;
import com.baidu.tieba.n7;
import com.baidu.tieba.qb;
import com.baidu.tieba.qd;
import com.baidu.tieba.rb;
import com.baidu.tieba.sb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes4.dex */
public abstract class AbstractImageLoaderProc implements sb<BdImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean checkBitmapValid(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? bitmap != null : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sb
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

    public abstract boolean isFromCDN();

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

    private boolean isNinePatchImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (getProcType() != 19 && getProcType() != 59) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sb
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sb
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return lv4.c().g();
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageFileExist(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            n7 n7Var = new n7("images", TbMd5.getNameMd5FromUrl(BdResourceLoader.getInstance().genCacheKey(str, i)), DiskFileOperate.Action.INFO);
            n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            n7Var.setSubFolder(true);
            n7Var.setIsFormatData(false);
            n7Var.setSdCard(false);
            n7Var.setSavedCache(true);
            return n7Var.call();
        }
        return invokeLI.booleanValue;
    }

    public static BdImage loadBdImageFromLocal(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String genCacheKey = BdResourceLoader.getInstance().genCacheKey(str, i);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(genCacheKey);
            if (i == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            n7 n7Var = new n7("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            n7Var.setSubFolder(true);
            n7Var.setIsFormatData(false);
            n7Var.setSavedCache(true);
            n7Var.setSdCard(false);
            if (!j7.g().d(n7Var) || !n7Var.isSuccess()) {
                return null;
            }
            n7Var.formatData(n7Var.getData());
            Bitmap bitmap = n7Var.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new BdImage(bitmap, n7Var.isGif(), genCacheKey);
        }
        return (BdImage) invokeLI.objValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) {
            return BitmapHelper.checkBitmapSize(bitmap, i, i2);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public BdImage decodeToResourceWithWH(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i, i2);
            if (decodeByteArray != null) {
                z = true;
            } else {
                z = false;
            }
            qb.c(z, System.currentTimeMillis() - currentTimeMillis);
            return new BdImage(decodeByteArray);
        }
        return (BdImage) invokeLII.objValue;
    }

    public n7 createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new n7("images", str, DiskFileOperate.Action.READ);
        }
        return (n7) invokeL.objValue;
    }

    public BdImage createImageFromDiskPicOperate(n7 n7Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, n7Var, str, i, i2)) == null) {
            if (n7Var == null) {
                return null;
            }
            n7Var.b(n7Var.getData(), i, i2);
            Bitmap checkBitmapSize = checkBitmapSize(n7Var.getBitmap(), i, i2);
            if (checkBitmapSize == null) {
                return null;
            }
            return new BdImage(checkBitmapSize, n7Var.isGif(), str);
        }
        return (BdImage) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: decodeToResource */
    public BdImage mo122decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) {
            return decodeToResourceWithWH(bArr, BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()), BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
        }
        return (BdImage) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sb
    public BdImage getFromLocal(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            byte[] bArr = new byte[0];
            n7 createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            BdImage bdImage = null;
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (rbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                rbVar.a = diskCancelWorker;
            }
            if (!j7.g().a(createDiskPicOperate)) {
                qb.f(false, 0L);
                return null;
            }
            int i3 = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i3 = 300;
            }
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
                i = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i2 == 0) {
                i2 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (createDiskPicOperate.isSuccess()) {
                bdImage = createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
            }
            if (bdImage != null) {
                z = true;
            }
            qb.f(z, System.currentTimeMillis() - currentTimeMillis);
            return bdImage;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sb
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BdImage D = TbImageMemoryCache.B().D(str);
            if (z) {
                if (D != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                qb.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return D;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139 A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:47:0x0107, B:49:0x0129, B:54:0x0133, B:56:0x0139, B:58:0x0164), top: B:123:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0163  */
    @Override // com.baidu.tieba.sb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BdImage getFromRemote(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        String urlbyClientServerAddr;
        String str3;
        boolean z;
        WebClient webClient;
        int i5;
        boolean z2;
        boolean z3;
        byte[] bArr;
        boolean z4;
        String str4;
        boolean z5;
        int i6;
        String str5;
        int i7;
        int i8;
        Bitmap rawBitmap;
        Bitmap bitmap;
        byte[] bArr2;
        boolean z6;
        boolean z7;
        boolean z8;
        WebClient webClient2;
        boolean z9;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 0) {
                i3 = getSuggestWidth();
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = getSuggestHeight();
            } else {
                i4 = i2;
            }
            if (i3 == 0) {
                i3 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i9 = i3;
            if (i4 == 0) {
                i4 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i10 = i4;
            boolean isFromCDN = isFromCDN();
            if (isFromCDN) {
                urlbyClientServerAddr = str;
            } else {
                urlbyClientServerAddr = getUrlbyClientServerAddr(str, i9, i10);
            }
            jt5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = jt5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                str3 = (String) d.second;
                z = true;
            } else {
                str3 = urlbyClientServerAddr;
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (rbVar != null) {
                rbVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(str3, !isFromCDN);
            boolean needCache = webClient3.needCache();
            Rect rect = new Rect();
            if (!webClient3.IsRequestSuccess()) {
                if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    qb.j(false, str3, webClient3.mStat, 0L, 0L);
                    if (webClient3.mStat != null) {
                        webClient2 = webClient3;
                        z8 = needCache;
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                    } else {
                        z8 = needCache;
                        webClient2 = webClient3;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                        byte[] d2 = mb.d(openRawResource);
                        Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d2, rect);
                        WebClient webClient4 = webClient2;
                        if (!webClient4.isGif && !BdUtilHelper.isGif(d2)) {
                            z9 = false;
                            if (!checkBitmapValid(Bytes2NineBitmap)) {
                                bdImage = new BdImage(Bytes2NineBitmap, z9, str, rect);
                                boolean z10 = z8;
                                bdImage.setNeedCache(z10);
                                storeLocal(str2, d2, Boolean.valueOf(z10), Boolean.valueOf(webClient4.isCrackPic), Boolean.valueOf(z9), rbVar, Bytes2NineBitmap);
                            } else {
                                bdImage = null;
                            }
                            BdCloseHelper.close(openRawResource);
                            return bdImage;
                        }
                        z9 = true;
                        if (!checkBitmapValid(Bytes2NineBitmap)) {
                        }
                        BdCloseHelper.close(openRawResource);
                        return bdImage;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                webClient = webClient3;
                i5 = 1;
                z2 = needCache;
                if (!webClient.getResponse().a) {
                    qb.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
            } else {
                webClient = webClient3;
                i5 = 1;
                z2 = needCache;
            }
            if (downloadImageBytes == null) {
                if (!webClient.getResponse().a) {
                    qb.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (downloadImageBytes.length > i5) {
                z3 = true;
            } else {
                z3 = false;
            }
            String str6 = urlbyClientServerAddr;
            qb.j(z3, str3, webClient.mStat, currentTimeMillis2, downloadImageBytes.length);
            if (downloadImageBytes.length > 1) {
                ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                z4 = z2;
                str4 = str3;
                bArr = downloadImageBytes;
                str5 = str6;
                z5 = isFromCDN;
                i6 = i10;
                ImageLogger.imagePerfNetLog(str, true, str3, Boolean.valueOf(z), webClient.mStat, "InputToByteSucc", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            } else {
                bArr = downloadImageBytes;
                z4 = z2;
                str4 = str3;
                z5 = isFromCDN;
                i6 = i10;
                str5 = str6;
                ImageLogger.imagePerfNetLog(str, false, str4, Boolean.valueOf(z), webClient.mStat, "bytes<1", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            }
            byte[] bArr3 = bArr;
            TbImageMemoryCache.B().v(TbConfig.getPbImageSize() + bArr3.length);
            if (isNinePatchImage()) {
                i8 = 1;
                rawBitmap = mo122decodeToResource(bArr3, rect).getRawBitmap();
                i7 = i9;
            } else {
                i7 = i9;
                i8 = 1;
                rawBitmap = decodeToResourceWithWH(bArr3, i7, i6).getRawBitmap();
            }
            if (z && rawBitmap == null) {
                jt5.b(str4);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(str5, !z5);
                boolean needCache2 = webClient.needCache();
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    if (isNinePatchImage()) {
                        Object[] objArr2 = new Object[i8];
                        objArr2[0] = rect;
                        rawBitmap = mo122decodeToResource(downloadImageBytes2, objArr2).getRawBitmap();
                    } else {
                        rawBitmap = decodeToResourceWithWH(downloadImageBytes2, i7, i6).getRawBitmap();
                    }
                }
                Bitmap bitmap2 = rawBitmap;
                bArr2 = downloadImageBytes2;
                z6 = needCache2;
                bitmap = bitmap2;
            } else {
                bitmap = rawBitmap;
                bArr2 = bArr3;
                z6 = z4;
            }
            if (bArr2 != null && bitmap != null) {
                if (!webClient.isGif && !BdUtilHelper.isGif(bArr2)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                Bitmap resizeBitmapSize = resizeBitmapSize(bitmap, i7, i6);
                if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                    BdImage bdImage2 = new BdImage(resizeBitmapSize, z7, str, rect);
                    bdImage2.setNeedCache(z6);
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = Boolean.valueOf(z6);
                    objArr3[i8] = Boolean.valueOf(webClient.isCrackPic);
                    objArr3[2] = Boolean.valueOf(z7);
                    objArr3[3] = rbVar;
                    objArr3[4] = resizeBitmapSize;
                    storeLocal(str2, bArr2, objArr3);
                    return bdImage2;
                }
                return null;
            }
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    public String getUrlbyClientServerAddr(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, str, i, i2)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (str.startsWith(TbConfig.IMAGE_ADDRESS)) {
                return str;
            }
            if (str.startsWith(TbDomainConfig.DOMAIN_HTTPS_STATIC_SERVER)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(qd.getUrlEncode(str));
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

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, str, bArr, objArr) == null) && !TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                n7 n7Var = new n7("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                n7Var.setSubFolder(true);
                n7Var.setData(bArr);
                n7Var.setSdCard(false);
                n7Var.setSavedCache(true);
                n7Var.setGif(booleanValue3);
                j7.g().a(n7Var);
                rb rbVar = (rb) objArr[3];
                if (rbVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(n7Var);
                    rbVar.a = diskCancelWorker;
                }
            }
        }
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                TbImageMemoryCache.B().v(BitmapHelper.getBitmapSize(bitmap) * 2);
                return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // com.baidu.tieba.sb
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof BdImage)) {
            long currentTimeMillis = System.currentTimeMillis();
            BdImage bdImage = (BdImage) obj;
            bdImage.setRequestWidth(i);
            bdImage.setRequestHeight(i2);
            TbImageMemoryCache.B().l(str, bdImage);
            qb.k(true, System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
