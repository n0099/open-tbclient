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
import com.repackage.am4;
import com.repackage.cg;
import com.repackage.dg;
import com.repackage.gg;
import com.repackage.ji;
import com.repackage.kb;
import com.repackage.li;
import com.repackage.ns4;
import com.repackage.rb;
import com.repackage.tb;
import com.repackage.u25;
import com.repackage.um;
import com.repackage.xb5;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements gg<um> {
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

    public static um readGifFromDisk(String str, dg dgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, dgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            tb tbVar = new tb("images", str, DiskFileOperate.Action.READ);
            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            tbVar.setSubFolder(true);
            tbVar.setIsFormatData(false);
            tbVar.setSdCard(false);
            tbVar.setSavedCache(true);
            tbVar.setLock(bArr);
            if (dgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(tbVar);
                dgVar.a = diskCancelWorker;
            }
            if (rb.f().a(tbVar)) {
                int i3 = ji.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (tbVar.isSuccess()) {
                    boolean B = li.B(tbVar.getData());
                    if (B) {
                        tbVar.formatData(tbVar.getData());
                    }
                    if (tbVar.a() != null) {
                        return new um((kb) tbVar.a(), BitmapHelper.Bytes2Bitmap(tbVar.getData()), true);
                    }
                    if (B) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        ns4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new um(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(tbVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public um m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (um) invokeLL.objValue;
    }

    @Override // com.repackage.gg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.gg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? am4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.gg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof um)) {
            um umVar = (um) obj;
            if (umVar.u()) {
                umVar.A(i);
                umVar.z(i2);
                u25.k().d(str, umVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            um readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), dgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            cg.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            um m = u25.k().m(str);
            if (z) {
                cg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        um umVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            xb5.e(true, str, str);
            Pair<Boolean, String> d = xb5.d(str);
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
                ns4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    xb5.b(str3);
                    ns4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        u25.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean B = li.B(downloadImageBytes);
                        if (NSGif.f && B) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            umVar = new um((kb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            umVar.y(needCache);
                        } else {
                            if (B) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                ns4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            um umVar2 = new um(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            umVar2.y(needCache);
                            umVar = umVar2;
                        }
                        if (needCache) {
                            tb tbVar = new tb("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            tbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            tbVar.setSubFolder(true);
                            tbVar.setData(downloadImageBytes);
                            tbVar.setSdCard(false);
                            tbVar.setSavedCache(true);
                            rb.f().a(tbVar);
                            if (dgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(tbVar);
                                dgVar.a = diskCancelWorker;
                            }
                        }
                        if (B) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, dgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        cg.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return umVar;
                }
                cg.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            cg.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (um) invokeCommon.objValue;
    }
}
