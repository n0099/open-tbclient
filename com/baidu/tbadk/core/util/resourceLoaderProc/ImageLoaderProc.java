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
import com.baidu.tieba.ar4;
import com.baidu.tieba.dc;
import com.baidu.tieba.e95;
import com.baidu.tieba.hn;
import com.baidu.tieba.kc;
import com.baidu.tieba.mc;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi5;
import com.baidu.tieba.qg;
import com.baidu.tieba.tg;
import com.baidu.tieba.xi;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements tg<hn> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public hn m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (hn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tg
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

    @Override // com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ar4.c().g();
        }
        return invokeV.booleanValue;
    }

    public static hn readGifFromDisk(String str, qg qgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, qgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            mc mcVar = new mc("images", str, DiskFileOperate.Action.READ);
            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            mcVar.setSubFolder(true);
            mcVar.setIsFormatData(false);
            mcVar.setSdCard(false);
            mcVar.setSavedCache(true);
            mcVar.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(mcVar);
                qgVar.a = diskCancelWorker;
            }
            if (!kc.f().a(mcVar)) {
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
            if (!mcVar.isSuccess()) {
                return null;
            }
            boolean D = xi.D(mcVar.getData());
            if (D) {
                mcVar.formatData(mcVar.getData());
            }
            if (mcVar.a() != null) {
                return new hn((dc) mcVar.a(), BitmapHelper.Bytes2Bitmap(mcVar.getData()), true);
            }
            if (D) {
                BdLog.e("BIGIMAGE gif parse fail ");
                zx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new hn(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(mcVar.getData()), i, i2), false, str2);
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public hn getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hn readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), qgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            pg.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public hn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            hn m = e95.k().m(str);
            if (z) {
                if (m != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pg.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public hn getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        hn hnVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            pi5.e(true, str, str);
            Pair<Boolean, String> d = pi5.d(str);
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
                zx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    pi5.b(str3);
                    zx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        e95.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean D = xi.D(downloadImageBytes);
                        if (NSGif.f && D) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            hnVar = new hn((dc) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            hnVar.y(needCache);
                        } else {
                            if (D) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                zx4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            hn hnVar2 = new hn(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            hnVar2.y(needCache);
                            hnVar = hnVar2;
                        }
                        if (needCache) {
                            mc mcVar = new mc("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            mcVar.setSubFolder(true);
                            mcVar.setData(downloadImageBytes);
                            mcVar.setSdCard(false);
                            mcVar.setSavedCache(true);
                            kc.f().a(mcVar);
                            if (qgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(mcVar);
                                qgVar.a = diskCancelWorker;
                            }
                        }
                        if (D) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, qgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        pg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return hnVar;
                }
                pg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            pg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (hn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof hn)) {
            hn hnVar = (hn) obj;
            if (hnVar.u()) {
                hnVar.A(i);
                hnVar.z(i2);
                e95.k().d(str, hnVar);
            }
        }
    }
}
