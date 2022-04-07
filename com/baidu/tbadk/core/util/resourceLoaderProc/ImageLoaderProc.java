package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cn4;
import com.repackage.fg;
import com.repackage.fo;
import com.repackage.gg;
import com.repackage.h35;
import com.repackage.jg;
import com.repackage.kb;
import com.repackage.lt4;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.rb;
import com.repackage.tb;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements jg<fo> {
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

    public static fo readGifFromDisk(String str, gg ggVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, ggVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            tb tbVar = new tb("images", str, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(true);
            tbVar.setIsFormatData(false);
            tbVar.setSdCard(false);
            tbVar.setSavedCache(true);
            tbVar.setLock(bArr);
            if (ggVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                ggVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i3 = mi.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    boolean A = oi.A(tbVar.getData());
                    if (A) {
                        tbVar.formatData(tbVar.getData());
                    }
                    if (tbVar.a() != null) {
                        return new fo((kb) tbVar.a(), BitmapHelper.Bytes2Bitmap(tbVar.getData()), true);
                    }
                    if (A) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        lt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new fo(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(tbVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public fo m47decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (fo) invokeLL.objValue;
    }

    @Override // com.repackage.jg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.jg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.jg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? cn4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.jg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof fo)) {
            fo foVar = (fo) obj;
            if (foVar.u()) {
                foVar.A(i);
                foVar.z(i2);
                h35.k().d(str, foVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.jg
    public fo getFromLocal(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            fo readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), ggVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            fg.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.jg
    public fo getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            fo m = h35.k().m(str);
            if (z) {
                fg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.jg
    public fo getFromRemote(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        byte[] downloadImageBytes;
        fo foVar;
        boolean z2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                    str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                    z = true;
                    downloadImageBytes = webClient.downloadImageBytes(str3, false);
                    boolean needCache = webClient.needCache();
                    if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                        BdLog.e("BIGIMAGE imageLoaderProc too big");
                        lt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
                    }
                    if (downloadImageBytes == null && webClient.IsRequestSuccess()) {
                        Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        if (z && Bytes2Bitmap == null) {
                            TbadkCoreApplication.getInst().incWebpFailureCount();
                            lt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                            downloadImageBytes = webClient.downloadImageBytes(str, false);
                            needCache = webClient.needCache();
                            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                                Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                            }
                        }
                        if (downloadImageBytes != null && Bytes2Bitmap != null) {
                            synchronized (BitmapHelper.lockForSyncImageDecoder) {
                                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                                h35.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                                boolean A = oi.A(downloadImageBytes);
                                NSGif f = (NSGif.f && A) ? NSGif.f(downloadImageBytes, 0, downloadImageBytes.length) : null;
                                if (f != null) {
                                    foVar = new fo((kb) f, Bytes2Bitmap, true);
                                    foVar.y(needCache);
                                } else {
                                    if (A) {
                                        BdLog.e("BIGIMAGE gif parse fail ");
                                        lt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                                    }
                                    fo foVar2 = new fo(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                                    foVar2.y(needCache);
                                    foVar = foVar2;
                                }
                                if (needCache) {
                                    tb tbVar = new tb("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                                    tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    tbVar.setSubFolder(true);
                                    tbVar.setData(downloadImageBytes);
                                    tbVar.setSdCard(false);
                                    tbVar.setSavedCache(true);
                                    rb.f().a(tbVar);
                                    if (ggVar != null) {
                                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                        diskCancelWorker.setOperate(tbVar);
                                        ggVar.a = diskCancelWorker;
                                    }
                                }
                                if (A) {
                                    z2 = false;
                                    BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, ggVar);
                                } else {
                                    z2 = false;
                                }
                                if (downloadImageBytes.length > 1) {
                                    z2 = true;
                                }
                                fg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                            }
                            return foVar;
                        }
                        fg.j(false, str3, webClient.mStat, 0L, 0L);
                        return null;
                    }
                    fg.j(false, str3, webClient.mStat, 0L, 0L);
                    return null;
                }
            }
            str3 = str;
            z = false;
            downloadImageBytes = webClient.downloadImageBytes(str3, false);
            boolean needCache2 = webClient.needCache();
            if (webClient.IsRequestSuccess()) {
                BdLog.e("BIGIMAGE imageLoaderProc too big");
                lt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            if (downloadImageBytes == null) {
            }
            fg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (fo) invokeCommon.objValue;
    }
}
