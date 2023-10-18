package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.ab;
import com.baidu.tieba.bb;
import com.baidu.tieba.cb;
import com.baidu.tieba.n6;
import com.baidu.tieba.pr5;
import com.baidu.tieba.t6;
import com.baidu.tieba.uu4;
import com.baidu.tieba.v6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageLoaderProc implements cb<BdImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public BdImage m125decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (BdImage) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cb
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb
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

    @Override // com.baidu.tieba.cb
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return uu4.c().g();
        }
        return invokeV.booleanValue;
    }

    public static BdImage readGifFromDisk(String str, bb bbVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, bbVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            v6 v6Var = new v6("images", str, DiskFileOperate.Action.READ);
            v6Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            v6Var.setSubFolder(true);
            v6Var.setIsFormatData(false);
            v6Var.setSdCard(false);
            v6Var.setSavedCache(true);
            v6Var.setLock(bArr);
            if (bbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(v6Var);
                bbVar.a = diskCancelWorker;
            }
            if (!t6.g().a(v6Var)) {
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
            if (!v6Var.isSuccess()) {
                return null;
            }
            boolean isGif = BdUtilHelper.isGif(v6Var.getData());
            if (isGif) {
                v6Var.formatData(v6Var.getData());
            }
            if (v6Var.a() != null) {
                return new BdImage((n6) v6Var.a(), BitmapHelper.Bytes2Bitmap(v6Var.getData()), true);
            }
            if (isGif) {
                BdLog.e("BIGIMAGE gif parse fail ");
                Logger.addLog(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new BdImage(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(v6Var.getData()), i, i2), false, str2);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromLocal(String str, String str2, int i, int i2, bb bbVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bbVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BdImage readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), bbVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            if (readGifFromDisk != null) {
                z = true;
            } else {
                z = false;
            }
            ab.f(z, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BdImage D = TbImageMemoryCache.B().D(str);
            if (z) {
                if (D != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ab.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return D;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromRemote(String str, String str2, int i, int i2, bb bbVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        BdImage bdImage;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bbVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            pr5.e(true, str, str);
            Pair<Boolean, String> d = pr5.d(str);
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
                Logger.addLog(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    pr5.b(str3);
                    Logger.addLog(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        TbImageMemoryCache.B().v(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean isGif = BdUtilHelper.isGif(downloadImageBytes);
                        if (NSGif.f && isGif) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            bdImage = new BdImage((n6) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            bdImage.setNeedCache(needCache);
                        } else {
                            if (isGif) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                Logger.addLog(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            BdImage bdImage2 = new BdImage(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            bdImage2.setNeedCache(needCache);
                            bdImage = bdImage2;
                        }
                        if (needCache) {
                            v6 v6Var = new v6("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            v6Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            v6Var.setSubFolder(true);
                            v6Var.setData(downloadImageBytes);
                            v6Var.setSdCard(false);
                            v6Var.setSavedCache(true);
                            t6.g().a(v6Var);
                            if (bbVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(v6Var);
                                bbVar.a = diskCancelWorker;
                            }
                        }
                        if (isGif) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, bbVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        ab.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return bdImage;
                }
                ab.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            ab.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.cb
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof BdImage)) {
            BdImage bdImage = (BdImage) obj;
            if (bdImage.isNeedCache()) {
                bdImage.setRequestWidth(i);
                bdImage.setRequestHeight(i2);
                TbImageMemoryCache.B().l(str, bdImage);
            }
        }
    }
}
