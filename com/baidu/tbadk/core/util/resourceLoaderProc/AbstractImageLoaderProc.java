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
import com.repackage.co;
import com.repackage.dd5;
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.gg;
import com.repackage.hg;
import com.repackage.jg;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.ln4;
import com.repackage.mi;
import com.repackage.rb;
import com.repackage.vb;
import com.repackage.y35;
import com.repackage.zf;
import java.io.InputStream;
/* loaded from: classes3.dex */
public abstract class AbstractImageLoaderProc implements hg<co> {
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
            vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(gg.h().g(str, i)), DiskFileOperate.Action.INFO);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSubFolder(true);
            vbVar.setIsFormatData(false);
            vbVar.setSdCard(false);
            vbVar.setSavedCache(true);
            return vbVar.call();
        }
        return invokeLI.booleanValue;
    }

    public static co loadBdImageFromLocal(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = gg.h().g(str, i);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g);
            if (i == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            vb vbVar = new vb("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSubFolder(true);
            vbVar.setIsFormatData(false);
            vbVar.setSavedCache(true);
            vbVar.setSdCard(false);
            if (rb.f().call(vbVar) && vbVar.isSuccess()) {
                vbVar.formatData(vbVar.getData());
                Bitmap bitmap = vbVar.getBitmap();
                if (bitmap != null) {
                    return new co(bitmap, vbVar.isGif(), g);
                }
                return null;
            }
            return null;
        }
        return (co) invokeLI.objValue;
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

    public vb createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new vb("images", str, DiskFileOperate.Action.READ) : (vb) invokeL.objValue;
    }

    public co createImageFromDiskPicOperate(vb vbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, vbVar, str, i, i2)) == null) {
            if (vbVar == null) {
                return null;
            }
            vbVar.b(vbVar.getData(), i, i2);
            Bitmap checkBitmapSize = checkBitmapSize(vbVar.getBitmap(), i, i2);
            if (checkBitmapSize != null) {
                return new co(checkBitmapSize, vbVar.isGif(), str);
            }
            return null;
        }
        return (co) invokeLLII.objValue;
    }

    public co decodeToResourceWithWH(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i, i2);
            dg.c(decodeByteArray != null, System.currentTimeMillis() - currentTimeMillis);
            return new co(decodeByteArray);
        }
        return (co) invokeLII.objValue;
    }

    @Override // com.repackage.hg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.hg
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
            if (str.startsWith(TbConfig.IMAGE_ADDRESS)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(li.getUrlEncode(str));
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

    @Override // com.repackage.hg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? ln4.c().g() : invokeV.booleanValue;
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                y35.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
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
        vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        vbVar.setSubFolder(true);
        vbVar.setData(bArr);
        vbVar.setSdCard(false);
        vbVar.setSavedCache(true);
        vbVar.setGif(booleanValue3);
        rb.f().a(vbVar);
        eg egVar = (eg) objArr[3];
        if (egVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(vbVar);
            egVar.a = diskCancelWorker;
        }
    }

    @Override // com.repackage.hg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof co)) {
            co coVar = (co) obj;
            if (coVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                coVar.A(i);
                coVar.z(i2);
                y35.k().d(str, coVar);
                dg.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public co m43decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) ? decodeToResourceWithWH(bArr, mi.k(TbadkCoreApplication.getInst()), mi.i(TbadkCoreApplication.getInst())) : (co) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[0];
            vb createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                egVar.a = diskCancelWorker;
            }
            if (!rb.f().a(createDiskPicOperate)) {
                dg.f(false, 0L);
                return null;
            }
            int i3 = ki.H() ? 300 : 2000;
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
                i = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i2 == 0) {
                i2 = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            co createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2) : null;
            dg.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
            return createImageFromDiskPicOperate;
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            co m = y35.k().m(str);
            if (z) {
                dg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x0167, TryCatch #0 {all -> 0x0167, blocks: (B:47:0x0106, B:49:0x0128, B:54:0x0132, B:56:0x0138, B:58:0x0163), top: B:123:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
    @Override // com.repackage.hg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public co getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
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
        co coVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int suggestWidth = i == 0 ? getSuggestWidth() : i;
            int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
            if (suggestWidth == 0) {
                suggestWidth = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i7 = suggestWidth;
            if (suggestHeight == 0) {
                suggestHeight = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i8 = suggestHeight;
            boolean isFromCDN = isFromCDN();
            String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, i7, i8);
            dd5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = dd5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                str3 = (String) d.second;
                z = true;
            } else {
                str3 = urlbyClientServerAddr;
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (egVar != null) {
                egVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(str3, !isFromCDN);
            boolean needCache = webClient3.needCache();
            Rect rect = new Rect();
            if (webClient3.IsRequestSuccess()) {
                webClient = webClient3;
                i3 = 1;
                z2 = needCache;
            } else if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                dg.j(false, str3, webClient3.mStat, 0L, 0L);
                if (webClient3.mStat != null) {
                    webClient2 = webClient3;
                    z6 = needCache;
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                } else {
                    z6 = needCache;
                    webClient2 = webClient3;
                }
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080b96, new TypedValue());
                    byte[] d2 = zf.d(openRawResource);
                    Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d2, rect);
                    WebClient webClient4 = webClient2;
                    if (!webClient4.isGif && !mi.A(d2)) {
                        z7 = false;
                        if (checkBitmapValid(Bytes2NineBitmap)) {
                            coVar = null;
                        } else {
                            coVar = new co(Bytes2NineBitmap, z7, str, rect);
                            boolean z8 = z6;
                            coVar.y(z8);
                            storeLocal(str2, d2, Boolean.valueOf(z8), Boolean.valueOf(webClient4.isCrackPic), Boolean.valueOf(z7), egVar, Bytes2NineBitmap);
                        }
                        jg.c(openRawResource);
                        return coVar;
                    }
                    z7 = true;
                    if (checkBitmapValid(Bytes2NineBitmap)) {
                    }
                    jg.c(openRawResource);
                    return coVar;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else {
                webClient = webClient3;
                i3 = 1;
                z2 = needCache;
                if (!webClient.getResponse().a) {
                    dg.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
            }
            if (downloadImageBytes == null) {
                if (webClient.getResponse().a) {
                    return null;
                }
                dg.j(false, str3, webClient.mStat, 0L, 0L);
                ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String str6 = urlbyClientServerAddr;
            dg.j(downloadImageBytes.length > i3, str3, webClient.mStat, currentTimeMillis2, downloadImageBytes.length);
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
            y35.k().i(TbConfig.getPbImageSize() + bArr3.length);
            if (getProcType() == 19) {
                i6 = 1;
                p = m43decodeToResource(bArr3, rect).p();
                i5 = i7;
            } else {
                i5 = i7;
                i6 = 1;
                p = decodeToResourceWithWH(bArr3, i5, i4).p();
            }
            if (z && p == null) {
                dd5.b(str4);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(str5, !z4);
                boolean needCache2 = webClient.needCache();
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    if (getProcType() == 19) {
                        Object[] objArr2 = new Object[i6];
                        objArr2[0] = rect;
                        p = m43decodeToResource(downloadImageBytes2, objArr2).p();
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
            boolean z9 = webClient.isGif || mi.A(bArr2);
            Bitmap resizeBitmapSize = resizeBitmapSize(p, i5, i4);
            if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                co coVar2 = new co(resizeBitmapSize, z9, str, rect);
                coVar2.y(z5);
                Object[] objArr3 = new Object[5];
                objArr3[0] = Boolean.valueOf(z5);
                objArr3[i6] = Boolean.valueOf(webClient.isCrackPic);
                objArr3[2] = Boolean.valueOf(z9);
                objArr3[3] = egVar;
                objArr3[4] = resizeBitmapSize;
                storeLocal(str2, bArr2, objArr3);
                return coVar2;
            }
            return null;
        }
        return (co) invokeCommon.objValue;
    }
}
