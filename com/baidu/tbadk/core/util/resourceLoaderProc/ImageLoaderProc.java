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
import com.baidu.tieba.ah;
import com.baidu.tieba.dc;
import com.baidu.tieba.ej;
import com.baidu.tieba.kc;
import com.baidu.tieba.mc;
import com.baidu.tieba.on;
import com.baidu.tieba.qw4;
import com.baidu.tieba.u75;
import com.baidu.tieba.up4;
import com.baidu.tieba.wg;
import com.baidu.tieba.xg;
import com.baidu.tieba.zg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements ah<on> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

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

    public static on readGifFromDisk(String str, xg xgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, xgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            mc mcVar = new mc("images", str, DiskFileOperate.Action.READ);
            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            mcVar.setSubFolder(true);
            mcVar.setIsFormatData(false);
            mcVar.setSdCard(false);
            mcVar.setSavedCache(true);
            mcVar.setLock(bArr);
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(mcVar);
                xgVar.a = diskCancelWorker;
            }
            if (kc.f().a(mcVar)) {
                int i3 = BdNetTypeUtil.isWifiNet() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (mcVar.isSuccess()) {
                    boolean B = ej.B(mcVar.getData());
                    if (B) {
                        mcVar.formatData(mcVar.getData());
                    }
                    if (mcVar.a() != null) {
                        return new on((dc) mcVar.a(), BitmapHelper.Bytes2Bitmap(mcVar.getData()), true);
                    }
                    if (B) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        qw4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new on(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(mcVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public on m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (on) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ah
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ah
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? up4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.baidu.tieba.ah
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof on)) {
            on onVar = (on) obj;
            if (onVar.u()) {
                onVar.A(i);
                onVar.z(i2);
                u75.k().d(str, onVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromLocal(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            on readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), xgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            wg.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            on m = u75.k().m(str);
            if (z) {
                wg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromRemote(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        on onVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            zg5.e(true, str, str);
            Pair<Boolean, String> d = zg5.d(str);
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
                qw4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    zg5.b(str3);
                    qw4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        u75.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean B = ej.B(downloadImageBytes);
                        if (NSGif.f && B) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            onVar = new on((dc) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            onVar.y(needCache);
                        } else {
                            if (B) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                qw4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            on onVar2 = new on(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            onVar2.y(needCache);
                            onVar = onVar2;
                        }
                        if (needCache) {
                            mc mcVar = new mc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            mcVar.setSubFolder(true);
                            mcVar.setData(downloadImageBytes);
                            mcVar.setSdCard(false);
                            mcVar.setSavedCache(true);
                            kc.f().a(mcVar);
                            if (xgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(mcVar);
                                xgVar.a = diskCancelWorker;
                            }
                        }
                        if (B) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, xgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        wg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return onVar;
                }
                wg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            wg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (on) invokeCommon.objValue;
    }
}
