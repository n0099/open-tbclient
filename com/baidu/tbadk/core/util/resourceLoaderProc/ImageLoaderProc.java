package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.bh;
import com.baidu.tieba.ec;
import com.baidu.tieba.fj;
import com.baidu.tieba.jq4;
import com.baidu.tieba.jx4;
import com.baidu.tieba.l85;
import com.baidu.tieba.lc;
import com.baidu.tieba.nc;
import com.baidu.tieba.pn;
import com.baidu.tieba.sh5;
import com.baidu.tieba.xg;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements bh {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public pn m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (pn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bh
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    public ImageLoaderProc() {
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

    @Override // com.baidu.tieba.bh
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return jq4.c().g();
        }
        return invokeV.booleanValue;
    }

    public static pn readGifFromDisk(String str, yg ygVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, ygVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            nc ncVar = new nc("images", str, DiskFileOperate.Action.READ);
            ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ncVar.setSubFolder(true);
            ncVar.setIsFormatData(false);
            ncVar.setSdCard(false);
            ncVar.setSavedCache(true);
            ncVar.setLock(bArr);
            if (ygVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ncVar);
                ygVar.a = diskCancelWorker;
            }
            if (!lc.f().a(ncVar)) {
                return null;
            }
            int i3 = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i3 = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (!ncVar.isSuccess()) {
                return null;
            }
            boolean B = fj.B(ncVar.getData());
            if (B) {
                ncVar.formatData(ncVar.getData());
            }
            if (ncVar.a() != null) {
                return new pn((ec) ncVar.a(), BitmapHelper.Bytes2Bitmap(ncVar.getData()), true);
            }
            if (B) {
                BdLog.e("BIGIMAGE gif parse fail ");
                jx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new pn(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(ncVar.getData()), i, i2), false, str2);
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromLocal(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            pn readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), ygVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            xg.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            pn m = l85.k().m(str);
            if (z) {
                if (m != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                xg.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromRemote(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        pn pnVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            sh5.e(true, str, str);
            Pair d = sh5.d(str);
            if (((Boolean) d.first).booleanValue()) {
                str3 = (String) d.second;
                z = true;
            } else {
                str3 = str;
                z = false;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str3, false);
            boolean needCache = webClient.needCache();
            if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                BdLog.e("BIGIMAGE imageLoaderProc too big");
                jx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    sh5.b(str3);
                    jx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        l85.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean B = fj.B(downloadImageBytes);
                        if (NSGif.f && B) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            pnVar = new pn((ec) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            pnVar.y(needCache);
                        } else {
                            if (B) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                jx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            pn pnVar2 = new pn(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            pnVar2.y(needCache);
                            pnVar = pnVar2;
                        }
                        if (needCache) {
                            nc ncVar = new nc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            ncVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            ncVar.setSubFolder(true);
                            ncVar.setData(downloadImageBytes);
                            ncVar.setSdCard(false);
                            ncVar.setSavedCache(true);
                            lc.f().a(ncVar);
                            if (ygVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(ncVar);
                                ygVar.a = diskCancelWorker;
                            }
                        }
                        if (B) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, ygVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        xg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return pnVar;
                }
                xg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            xg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (pn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bh
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof pn)) {
            pn pnVar = (pn) obj;
            if (pnVar.u()) {
                pnVar.A(i);
                pnVar.z(i2);
                l85.k().d(str, pnVar);
            }
        }
    }
}
