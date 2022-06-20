package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gg;
import com.repackage.hg;
import com.repackage.j35;
import com.repackage.kc5;
import com.repackage.kg;
import com.repackage.km4;
import com.repackage.nb;
import com.repackage.ni;
import com.repackage.pi;
import com.repackage.ub;
import com.repackage.wb;
import com.repackage.ws4;
import com.repackage.ym;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements kg<ym> {
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

    public static ym readGifFromDisk(String str, hg hgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, hgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            wb wbVar = new wb("images", str, DiskFileOperate.Action.READ);
            wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            wbVar.setSubFolder(true);
            wbVar.setIsFormatData(false);
            wbVar.setSdCard(false);
            wbVar.setSavedCache(true);
            wbVar.setLock(bArr);
            if (hgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(wbVar);
                hgVar.a = diskCancelWorker;
            }
            if (ub.f().a(wbVar)) {
                int i3 = ni.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (wbVar.isSuccess()) {
                    boolean B = pi.B(wbVar.getData());
                    if (B) {
                        wbVar.formatData(wbVar.getData());
                    }
                    if (wbVar.a() != null) {
                        return new ym((nb) wbVar.a(), BitmapHelper.Bytes2Bitmap(wbVar.getData()), true);
                    }
                    if (B) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        ws4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new ym(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(wbVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public ym m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (ym) invokeLL.objValue;
    }

    @Override // com.repackage.kg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.kg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.kg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? km4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.kg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof ym)) {
            ym ymVar = (ym) obj;
            if (ymVar.u()) {
                ymVar.A(i);
                ymVar.z(i2);
                j35.k().d(str, ymVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromLocal(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ym readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), hgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            gg.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            ym m = j35.k().m(str);
            if (z) {
                gg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromRemote(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        ym ymVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            kc5.e(true, str, str);
            Pair<Boolean, String> d = kc5.d(str);
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
                ws4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    kc5.b(str3);
                    ws4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        j35.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean B = pi.B(downloadImageBytes);
                        if (NSGif.f && B) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            ymVar = new ym((nb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            ymVar.y(needCache);
                        } else {
                            if (B) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                ws4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            ym ymVar2 = new ym(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            ymVar2.y(needCache);
                            ymVar = ymVar2;
                        }
                        if (needCache) {
                            wb wbVar = new wb("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            wbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            wbVar.setSubFolder(true);
                            wbVar.setData(downloadImageBytes);
                            wbVar.setSdCard(false);
                            wbVar.setSavedCache(true);
                            ub.f().a(wbVar);
                            if (hgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(wbVar);
                                hgVar.a = diskCancelWorker;
                            }
                        }
                        if (B) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, hgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        gg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return ymVar;
                }
                gg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            gg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (ym) invokeCommon.objValue;
    }
}
