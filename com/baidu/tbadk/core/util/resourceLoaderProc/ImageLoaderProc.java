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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.d95;
import com.baidu.tieba.ec;
import com.baidu.tieba.gc;
import com.baidu.tieba.hn;
import com.baidu.tieba.ng;
import com.baidu.tieba.o05;
import com.baidu.tieba.og;
import com.baidu.tieba.rg;
import com.baidu.tieba.vw5;
import com.baidu.tieba.wi;
import com.baidu.tieba.xb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageLoaderProc implements rg<hn> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public hn m124decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (hn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.rg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg
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

    @Override // com.baidu.tieba.rg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return o05.c().g();
        }
        return invokeV.booleanValue;
    }

    public static hn readGifFromDisk(String str, og ogVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, ogVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            gc gcVar = new gc("images", str, DiskFileOperate.Action.READ);
            gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            gcVar.setSubFolder(true);
            gcVar.setIsFormatData(false);
            gcVar.setSdCard(false);
            gcVar.setSavedCache(true);
            gcVar.setLock(bArr);
            if (ogVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(gcVar);
                ogVar.a = diskCancelWorker;
            }
            if (!ec.f().a(gcVar)) {
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
            if (!gcVar.isSuccess()) {
                return null;
            }
            boolean D = wi.D(gcVar.getData());
            if (D) {
                gcVar.formatData(gcVar.getData());
            }
            if (gcVar.a() != null) {
                return new hn((xb) gcVar.a(), BitmapHelper.Bytes2Bitmap(gcVar.getData()), true);
            }
            if (D) {
                BdLog.e("BIGIMAGE gif parse fail ");
                d95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new hn(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(gcVar.getData()), i, i2), false, str2);
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rg
    public hn getFromLocal(String str, String str2, int i, int i2, og ogVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ogVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hn readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), ogVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            ng.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rg
    public hn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hn z3 = TbImageMemoryCache.u().z(str);
            if (z) {
                if (z3 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ng.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return z3;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.rg
    public hn getFromRemote(String str, String str2, int i, int i2, og ogVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        hn hnVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ogVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            vw5.e(true, str, str);
            Pair<Boolean, String> d = vw5.d(str);
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
                d95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    vw5.b(str3);
                    d95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        TbImageMemoryCache.u().s(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean D = wi.D(downloadImageBytes);
                        if (NSGif.f && D) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            hnVar = new hn((xb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            hnVar.y(needCache);
                        } else {
                            if (D) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                d95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            hn hnVar2 = new hn(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            hnVar2.y(needCache);
                            hnVar = hnVar2;
                        }
                        if (needCache) {
                            gc gcVar = new gc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            gcVar.setSubFolder(true);
                            gcVar.setData(downloadImageBytes);
                            gcVar.setSdCard(false);
                            gcVar.setSavedCache(true);
                            ec.f().a(gcVar);
                            if (ogVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(gcVar);
                                ogVar.a = diskCancelWorker;
                            }
                        }
                        if (D) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, ogVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        ng.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return hnVar;
                }
                ng.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            ng.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (hn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.rg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof hn)) {
            hn hnVar = (hn) obj;
            if (hnVar.u()) {
                hnVar.A(i);
                hnVar.z(i2);
                TbImageMemoryCache.u().l(str, hnVar);
            }
        }
    }
}
