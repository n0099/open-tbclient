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
import com.repackage.co;
import com.repackage.dd5;
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.hg;
import com.repackage.kb;
import com.repackage.ki;
import com.repackage.ln4;
import com.repackage.mi;
import com.repackage.rb;
import com.repackage.tb;
import com.repackage.xt4;
import com.repackage.y35;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements hg<co> {
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

    public static co readGifFromDisk(String str, eg egVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, egVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            tb tbVar = new tb("images", str, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(true);
            tbVar.setIsFormatData(false);
            tbVar.setSdCard(false);
            tbVar.setSavedCache(true);
            tbVar.setLock(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                egVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i3 = ki.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    boolean A = mi.A(tbVar.getData());
                    if (A) {
                        tbVar.formatData(tbVar.getData());
                    }
                    if (tbVar.a() != null) {
                        return new co((kb) tbVar.a(), BitmapHelper.Bytes2Bitmap(tbVar.getData()), true);
                    }
                    if (A) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        xt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new co(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(tbVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public co m47decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (co) invokeLL.objValue;
    }

    @Override // com.repackage.hg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.hg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ln4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.hg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof co)) {
            co coVar = (co) obj;
            if (coVar.u()) {
                coVar.A(i);
                coVar.z(i2);
                y35.k().d(str, coVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            co readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), egVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            dg.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
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
    @Override // com.repackage.hg
    public co getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        co coVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            dd5.e(true, str, str);
            Pair<Boolean, String> d = dd5.d(str);
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
                xt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    dd5.b(str3);
                    xt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        y35.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean A = mi.A(downloadImageBytes);
                        if (NSGif.f && A) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            coVar = new co((kb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            coVar.y(needCache);
                        } else {
                            if (A) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                xt4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            co coVar2 = new co(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            coVar2.y(needCache);
                            coVar = coVar2;
                        }
                        if (needCache) {
                            tb tbVar = new tb("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            tbVar.setSubFolder(true);
                            tbVar.setData(downloadImageBytes);
                            tbVar.setSdCard(false);
                            tbVar.setSavedCache(true);
                            rb.f().a(tbVar);
                            if (egVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(tbVar);
                                egVar.a = diskCancelWorker;
                            }
                        }
                        if (A) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, egVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        dg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return coVar;
                }
                dg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            dg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (co) invokeCommon.objValue;
    }
}
