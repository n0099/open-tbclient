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
import com.baidu.tieba.a95;
import com.baidu.tieba.ec;
import com.baidu.tieba.gc;
import com.baidu.tieba.gn;
import com.baidu.tieba.mg;
import com.baidu.tieba.n05;
import com.baidu.tieba.ng;
import com.baidu.tieba.ow5;
import com.baidu.tieba.qg;
import com.baidu.tieba.vi;
import com.baidu.tieba.xb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageLoaderProc implements qg<gn> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public gn m124decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (gn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qg
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

    @Override // com.baidu.tieba.qg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return n05.c().g();
        }
        return invokeV.booleanValue;
    }

    public static gn readGifFromDisk(String str, ng ngVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, ngVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            gc gcVar = new gc("images", str, DiskFileOperate.Action.READ);
            gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            gcVar.setSubFolder(true);
            gcVar.setIsFormatData(false);
            gcVar.setSdCard(false);
            gcVar.setSavedCache(true);
            gcVar.setLock(bArr);
            if (ngVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(gcVar);
                ngVar.a = diskCancelWorker;
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
            boolean D = vi.D(gcVar.getData());
            if (D) {
                gcVar.formatData(gcVar.getData());
            }
            if (gcVar.a() != null) {
                return new gn((xb) gcVar.a(), BitmapHelper.Bytes2Bitmap(gcVar.getData()), true);
            }
            if (D) {
                BdLog.e("BIGIMAGE gif parse fail ");
                a95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new gn(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(gcVar.getData()), i, i2), false, str2);
        }
        return (gn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromLocal(String str, String str2, int i, int i2, ng ngVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ngVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            gn readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), ngVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            mg.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (gn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            gn z3 = TbImageMemoryCache.u().z(str);
            if (z) {
                if (z3 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mg.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return z3;
        }
        return (gn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromRemote(String str, String str2, int i, int i2, ng ngVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        gn gnVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ngVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            ow5.e(true, str, str);
            Pair<Boolean, String> d = ow5.d(str);
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
                a95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    ow5.b(str3);
                    a95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
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
                        boolean D = vi.D(downloadImageBytes);
                        if (NSGif.f && D) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            gnVar = new gn((xb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            gnVar.y(needCache);
                        } else {
                            if (D) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                a95.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            gn gnVar2 = new gn(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            gnVar2.y(needCache);
                            gnVar = gnVar2;
                        }
                        if (needCache) {
                            gc gcVar = new gc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            gcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            gcVar.setSubFolder(true);
                            gcVar.setData(downloadImageBytes);
                            gcVar.setSdCard(false);
                            gcVar.setSavedCache(true);
                            ec.f().a(gcVar);
                            if (ngVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(gcVar);
                                ngVar.a = diskCancelWorker;
                            }
                        }
                        if (D) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, ngVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        mg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return gnVar;
                }
                mg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            mg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (gn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof gn)) {
            gn gnVar = (gn) obj;
            if (gnVar.u()) {
                gnVar.A(i);
                gnVar.z(i2);
                TbImageMemoryCache.u().l(str, gnVar);
            }
        }
    }
}
