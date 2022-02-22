package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.a.f.c;
import c.a.d.f.l.b;
import c.a.d.f.l.d;
import c.a.d.f.l.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.d.o.d.a;
import c.a.t0.s.l;
import c.a.u0.a4.f;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes11.dex */
public abstract class AbstractImageLoaderProc implements e<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractImageLoaderProc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isImageFileExist(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            c cVar = new c("images", TbMd5.getNameMd5FromUrl(d.h().g(str, i2)), DiskFileOperate.Action.INFO);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            return cVar.call();
        }
        return invokeLI.booleanValue;
    }

    public static a loadBdImageFromLocal(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g2 = d.h().g(str, i2);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
            if (i2 == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            c cVar = new c("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSavedCache(true);
            cVar.setSdCard(false);
            if (c.a.d.f.a.d.f().call(cVar) && cVar.isSuccess()) {
                cVar.formatData(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new a(bitmap, cVar.isGif(), g2);
                }
                return null;
            }
            return null;
        }
        return (a) invokeLI.objValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i2, i3)) == null) ? BitmapHelper.checkBitmapSize(bitmap, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    public boolean checkBitmapValid(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? bitmap != null : invokeL.booleanValue;
    }

    public c createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new c("images", str, DiskFileOperate.Action.READ) : (c) invokeL.objValue;
    }

    public a createImageFromDiskPicOperate(c cVar, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, cVar, str, i2, i3)) == null) {
            if (cVar == null) {
                return null;
            }
            cVar.b(cVar.getData(), i2, i3);
            Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i2, i3);
            if (checkBitmapSize != null) {
                return new a(checkBitmapSize, cVar.isGif(), str);
            }
            return null;
        }
        return (a) invokeLLII.objValue;
    }

    public a decodeToResourceWithWH(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i2, i3);
            c.a.d.f.l.a.c(decodeByteArray != null, System.currentTimeMillis() - currentTimeMillis);
            return new a(decodeByteArray);
        }
        return (a) invokeLII.objValue;
    }

    @Override // c.a.d.f.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // c.a.d.f.l.e
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

    public String getUrlbyClientServerAddr(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, str, i2, i3)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (str.startsWith(TbConfig.IMAGE_ADDRESS)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(m.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i2));
            sb.append("&height=");
            sb.append(String.valueOf(i3));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + TbImageHelper.getInstance().getUrlQuality());
            sb.append("&first_gif=1");
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public abstract boolean isFromCDN();

    @Override // c.a.d.f.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? l.c().g() : invokeV.booleanValue;
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i2, i3)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
                c.a.t0.c0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
                return BitmapHelper.resizeBitmap(bitmap, i2, i3, true);
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
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(bArr);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setGif(booleanValue3);
        c.a.d.f.a.d.f().a(cVar);
        b bVar = (b) objArr[3];
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.a = diskCancelWorker;
        }
    }

    @Override // c.a.d.f.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.A(i2);
                aVar.z(i3);
                c.a.t0.c0.c.k().d(str, aVar);
                c.a.d.f.l.a.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) ? decodeToResourceWithWH(bArr, n.k(TbadkCoreApplication.getInst()), n.i(TbadkCoreApplication.getInst())) : (a) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.d.f.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[0];
            c createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                bVar.a = diskCancelWorker;
            }
            if (!c.a.d.f.a.d.f().a(createDiskPicOperate)) {
                c.a.d.f.l.a.f(false, 0L);
                return null;
            }
            int i4 = c.a.d.f.p.l.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i4);
                } catch (InterruptedException unused) {
                }
            }
            if (i2 == 0) {
                i2 = getSuggestWidth();
            }
            if (i3 == 0) {
                i3 = getSuggestHeight();
            }
            if (i2 == 0) {
                i2 = n.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i3 == 0) {
                i3 = n.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            a createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i2, i3) : null;
            c.a.d.f.l.a.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
            return createImageFromDiskPicOperate;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.d.f.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a m = c.a.t0.c0.c.k().m(str);
            if (z) {
                c.a.d.f.l.a.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177 A[Catch: all -> 0x01a6, TryCatch #0 {all -> 0x01a6, blocks: (B:59:0x0148, B:61:0x0167, B:66:0x0171, B:68:0x0177, B:70:0x01a2), top: B:136:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0227  */
    @Override // c.a.d.f.l.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        WebClient webClient;
        byte[] downloadImageBytes;
        boolean z2;
        WebClient webClient2;
        int i4;
        char c2;
        byte[] bArr;
        boolean z3;
        String str4;
        int i5;
        int i6;
        int i7;
        Bitmap p;
        Bitmap bitmap;
        boolean z4;
        boolean z5;
        WebClient webClient3;
        char c3;
        boolean z6;
        a aVar;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) != null) {
            return (a) invokeCommon.objValue;
        }
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int suggestWidth = i2 == 0 ? getSuggestWidth() : i2;
        int suggestHeight = i3 == 0 ? getSuggestHeight() : i3;
        if (suggestWidth == 0) {
            suggestWidth = n.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        int i8 = suggestWidth;
        if (suggestHeight == 0) {
            suggestHeight = n.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        int i9 = suggestHeight;
        boolean isFromCDN = isFromCDN();
        String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, i8, i9);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = urlbyClientServerAddr.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = urlbyClientServerAddr.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = urlbyClientServerAddr.lastIndexOf(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX)) > 0) {
                str3 = urlbyClientServerAddr.substring(0, lastIndexOf) + ".webp" + urlbyClientServerAddr.substring(lastIndexOf + 4, urlbyClientServerAddr.length());
                z = true;
                webClient = new WebClient();
                if (bVar != null) {
                    bVar.a = webClient;
                }
                downloadImageBytes = webClient.downloadImageBytes(str3, !isFromCDN);
                boolean needCache = webClient.needCache();
                Rect rect = new Rect();
                if (!webClient.IsRequestSuccess()) {
                    z2 = needCache;
                    webClient2 = webClient;
                    i4 = 1;
                    c2 = 0;
                } else if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    c.a.d.f.l.a.j(false, str3, webClient.mStat, 0L, 0L);
                    if (webClient.mStat != null) {
                        z5 = needCache;
                        webClient3 = webClient;
                        c3 = 0;
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    } else {
                        z5 = needCache;
                        webClient3 = webClient;
                        c3 = 0;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(f.img_default_delete, new TypedValue());
                        byte[] d2 = c.a.d.f.j.c.b.d(openRawResource);
                        Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d2, rect);
                        if (!webClient3.isGif && !n.A(d2)) {
                            z6 = false;
                            if (checkBitmapValid(Bytes2NineBitmap)) {
                                aVar = null;
                            } else {
                                aVar = new a(Bytes2NineBitmap, z6, str, rect);
                                boolean z7 = z5;
                                aVar.y(z7);
                                Object[] objArr2 = new Object[5];
                                objArr2[c3] = Boolean.valueOf(z7);
                                objArr2[1] = Boolean.valueOf(webClient3.isCrackPic);
                                objArr2[2] = Boolean.valueOf(z6);
                                objArr2[3] = bVar;
                                objArr2[4] = Bytes2NineBitmap;
                                storeLocal(str2, d2, objArr2);
                            }
                            c.a.d.f.m.a.c(openRawResource);
                            return aVar;
                        }
                        z6 = true;
                        if (checkBitmapValid(Bytes2NineBitmap)) {
                        }
                        c.a.d.f.m.a.c(openRawResource);
                        return aVar;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                } else {
                    z2 = needCache;
                    webClient2 = webClient;
                    i4 = 1;
                    c2 = 0;
                    if (!webClient2.getResponse().a) {
                        c.a.d.f.l.a.j(false, str3, webClient2.mStat, 0L, 0L);
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                        return null;
                    }
                }
                if (downloadImageBytes != null) {
                    if (webClient2.getResponse().a) {
                        return null;
                    }
                    c.a.d.f.l.a.j(false, str3, webClient2.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                c.a.d.f.l.a.j(downloadImageBytes.length > i4, str3, webClient2.mStat, currentTimeMillis2, downloadImageBytes.length);
                if (downloadImageBytes.length > 1) {
                    ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                    bArr = downloadImageBytes;
                    z3 = z2;
                    str4 = urlbyClientServerAddr;
                    i5 = i9;
                    ImageLogger.imagePerfNetLog(str, true, str3, Boolean.valueOf(z), webClient2.mStat, "InputToByteSucc", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                } else {
                    bArr = downloadImageBytes;
                    z3 = z2;
                    str4 = urlbyClientServerAddr;
                    i5 = i9;
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "bytes<1", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                }
                byte[] bArr2 = bArr;
                c.a.t0.c0.c.k().i(TbConfig.getPbImageSize() + bArr2.length);
                if (getProcType() == 19) {
                    i7 = 1;
                    Object[] objArr3 = new Object[1];
                    objArr3[c2] = rect;
                    p = m45decodeToResource(bArr2, objArr3).p();
                    i6 = i8;
                } else {
                    i6 = i8;
                    i7 = 1;
                    p = decodeToResourceWithWH(bArr2, i6, i5).p();
                }
                if (z && p == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    bArr2 = webClient2.downloadImageBytes(str4, !isFromCDN);
                    z4 = webClient2.needCache();
                    if (bArr2 != null && webClient2.IsRequestSuccess()) {
                        if (getProcType() == 19) {
                            Object[] objArr4 = new Object[i7];
                            objArr4[c2] = rect;
                            p = m45decodeToResource(bArr2, objArr4).p();
                        } else {
                            p = decodeToResourceWithWH(bArr2, i6, i5).p();
                        }
                    }
                    bitmap = p;
                } else {
                    bitmap = p;
                    z4 = z3;
                }
                byte[] bArr3 = bArr2;
                if (bArr3 == null || bitmap == null) {
                    return null;
                }
                boolean z8 = webClient2.isGif || n.A(bArr3);
                Bitmap resizeBitmapSize = resizeBitmapSize(bitmap, i6, i5);
                if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                    a aVar2 = new a(resizeBitmapSize, z8, str, rect);
                    aVar2.y(z4);
                    Object[] objArr5 = new Object[5];
                    objArr5[c2] = Boolean.valueOf(z4);
                    objArr5[i7] = Boolean.valueOf(webClient2.isCrackPic);
                    objArr5[2] = Boolean.valueOf(z8);
                    objArr5[3] = bVar;
                    objArr5[4] = resizeBitmapSize;
                    storeLocal(str2, bArr3, objArr5);
                    return aVar2;
                }
                return null;
            }
        }
        str3 = urlbyClientServerAddr;
        z = false;
        webClient = new WebClient();
        if (bVar != null) {
        }
        downloadImageBytes = webClient.downloadImageBytes(str3, !isFromCDN);
        boolean needCache2 = webClient.needCache();
        Rect rect2 = new Rect();
        if (!webClient.IsRequestSuccess()) {
        }
        if (downloadImageBytes != null) {
        }
    }
}
