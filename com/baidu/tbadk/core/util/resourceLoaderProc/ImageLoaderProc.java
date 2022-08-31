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
import com.baidu.tieba.an;
import com.baidu.tieba.hu4;
import com.baidu.tieba.ig;
import com.baidu.tieba.jg;
import com.baidu.tieba.m55;
import com.baidu.tieba.mg;
import com.baidu.tieba.pb;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.tieba.se5;
import com.baidu.tieba.sn4;
import com.baidu.tieba.wb;
import com.baidu.tieba.yb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements mg<an> {
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

    public static an readGifFromDisk(String str, jg jgVar, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, jgVar, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[0];
            yb ybVar = new yb("images", str, DiskFileOperate.Action.READ);
            ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ybVar.setSubFolder(true);
            ybVar.setIsFormatData(false);
            ybVar.setSdCard(false);
            ybVar.setSavedCache(true);
            ybVar.setLock(bArr);
            if (jgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ybVar);
                jgVar.a = diskCancelWorker;
            }
            if (wb.f().a(ybVar)) {
                int i3 = pi.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException e) {
                        BdLog.detailException(e);
                    }
                }
                if (ybVar.isSuccess()) {
                    boolean B = ri.B(ybVar.getData());
                    if (B) {
                        ybVar.formatData(ybVar.getData());
                    }
                    if (ybVar.a() != null) {
                        return new an((pb) ybVar.a(), BitmapHelper.Bytes2Bitmap(ybVar.getData()), true);
                    }
                    if (B) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        hu4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new an(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(ybVar.getData()), i, i2), false, str2);
                }
                return null;
            }
            return null;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public an m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.mg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? sn4.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.baidu.tieba.mg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof an)) {
            an anVar = (an) obj;
            if (anVar.u()) {
                anVar.A(i);
                anVar.z(i2);
                m55.k().d(str, anVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromLocal(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            an readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), jgVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
            ig.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            an m = m55.k().m(str);
            if (z) {
                ig.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromRemote(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        an anVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            se5.e(true, str, str);
            Pair<Boolean, String> d = se5.d(str);
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
                hu4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            NSGif nSGif = null;
            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                if (z && Bytes2Bitmap == null) {
                    se5.b(str3);
                    hu4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                    downloadImageBytes = webClient.downloadImageBytes(str, false);
                    needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    }
                }
                if (downloadImageBytes != null && Bytes2Bitmap != null) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                        m55.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                        boolean B = ri.B(downloadImageBytes);
                        if (NSGif.f && B) {
                            nSGif = NSGif.f(downloadImageBytes, 0, downloadImageBytes.length);
                        }
                        NSGif nSGif2 = nSGif;
                        if (nSGif2 != null) {
                            anVar = new an((pb) nSGif2, Bytes2Bitmap, true, downloadImageBytes);
                            anVar.y(needCache);
                        } else {
                            if (B) {
                                BdLog.e("BIGIMAGE gif parse fail ");
                                hu4.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                            }
                            an anVar2 = new an(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                            anVar2.y(needCache);
                            anVar = anVar2;
                        }
                        if (needCache) {
                            yb ybVar = new yb("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                            ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            ybVar.setSubFolder(true);
                            ybVar.setData(downloadImageBytes);
                            ybVar.setSdCard(false);
                            ybVar.setSavedCache(true);
                            wb.f().a(ybVar);
                            if (jgVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(ybVar);
                                jgVar.a = diskCancelWorker;
                            }
                        }
                        if (B) {
                            z2 = false;
                            BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, jgVar);
                        } else {
                            z2 = false;
                        }
                        if (downloadImageBytes.length > 1) {
                            z2 = true;
                        }
                        ig.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                    }
                    return anVar;
                }
                ig.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
            ig.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (an) invokeCommon.objValue;
    }
}
