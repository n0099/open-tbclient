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
import com.baidu.tieba.ax5;
import com.baidu.tieba.fc;
import com.baidu.tieba.g95;
import com.baidu.tieba.hc;
import com.baidu.tieba.in;
import com.baidu.tieba.og;
import com.baidu.tieba.pg;
import com.baidu.tieba.r05;
import com.baidu.tieba.sg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageLoaderProc implements sg<in> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public in m124decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (in) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sg
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

    @Override // com.baidu.tieba.sg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return r05.c().g();
        }
        return invokeV.booleanValue;
    }

    public static in readGifFromDisk(String str, pg pgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, pgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            hc hcVar = new hc("images", str, DiskFileOperate.Action.READ);
            hcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            hcVar.setSubFolder(true);
            hcVar.setIsFormatData(false);
            hcVar.setSdCard(false);
            hcVar.setSavedCache(true);
            hcVar.setLock(bArr);
            if (pgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(hcVar);
                pgVar.a = diskCancelWorker;
            }
            if (!fc.f().a(hcVar)) {
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
            if (!hcVar.isSuccess()) {
                return null;
            }
            boolean D = xi.D(hcVar.getData());
            if (D) {
                hcVar.formatData(hcVar.getData());
            }
            if (hcVar.a() != null) {
                return new in((yb) hcVar.a(), BitmapHelper.Bytes2Bitmap(hcVar.getData()), true);
            }
            if (D) {
                BdLog.e("BIGIMAGE gif parse fail ");
                g95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new in(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(hcVar.getData()), i, i2), false, str2);
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromLocal(String str, String str2, int i, int i2, pg pgVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), pgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            in readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), pgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            og.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            in w = TbImageMemoryCache.u().w(str);
            if (z) {
                if (w != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                og.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return w;
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromRemote(String str, String str2, int i, int i2, pg pgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        in inVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), pgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            ax5.e(true, str, str);
            Pair<Boolean, String> d = ax5.d(str);
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
                g95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    ax5.b(str3);
                    g95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
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
                        boolean D = xi.D(downloadImageBytes);
                        if (NSGif.f && D) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            inVar = new in((yb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            inVar.y(needCache);
                        } else {
                            if (D) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                g95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            in inVar2 = new in(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            inVar2.y(needCache);
                            inVar = inVar2;
                        }
                        if (needCache) {
                            hc hcVar = new hc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            hcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            hcVar.setSubFolder(true);
                            hcVar.setData(downloadImageBytes);
                            hcVar.setSdCard(false);
                            hcVar.setSavedCache(true);
                            fc.f().a(hcVar);
                            if (pgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(hcVar);
                                pgVar.a = diskCancelWorker;
                            }
                        }
                        if (D) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, pgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        og.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return inVar;
                }
                og.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            og.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (in) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.sg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof in)) {
            in inVar = (in) obj;
            if (inVar.u()) {
                inVar.A(i);
                inVar.z(i2);
                TbImageMemoryCache.u().l(str, inVar);
            }
        }
    }
}
