package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.a.d;
import c.a.e.e.l.b;
import c.a.e.e.l.e;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.d.a;
import c.a.q0.c0.c;
import c.a.q0.s.k;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
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
/* loaded from: classes6.dex */
public class ImageLoaderProc implements e<a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";
    public transient /* synthetic */ FieldHolder $fh;

    public ImageLoaderProc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a readGifFromDisk(String str, b bVar, String str2, String str3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, bVar, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            byte[] bArr = new byte[0];
            c.a.e.e.a.f.a aVar = new c.a.e.e.a.f.a("images", str, DiskFileOperate.Action.READ);
            aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar.setSubFolder(true);
            aVar.setIsFormatData(false);
            aVar.setSdCard(false);
            aVar.setSavedCache(true);
            aVar.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(aVar);
                bVar.f2382a = diskCancelWorker;
            }
            if (d.g().a(aVar)) {
                int i4 = j.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i4);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
                    }
                }
                if (aVar.isSuccess()) {
                    boolean B = l.B(aVar.getData());
                    if (B) {
                        aVar.formatData(aVar.getData());
                    }
                    if (aVar.a() != null) {
                        return new a((c.a.e.d.b) aVar.a(), BitmapHelper.Bytes2Bitmap(aVar.getData()), true);
                    }
                    if (B) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        c.a.q0.s.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                    }
                    return new a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar.getData()), i2, i3), false, str2);
                }
                return null;
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m27decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (a) invokeLL.objValue;
    }

    @Override // c.a.e.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // c.a.e.e.l.e
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.e.e.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? k.c().g() : invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // c.a.e.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.u()) {
                aVar.A(i2);
                aVar.z(i3);
                c.k().d(str, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.e.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), bVar, str2, "ImageLoaderProc.getFromLocal", i2, i3);
            c.a.e.e.l.a.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
            return readGifFromDisk;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.e.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a m = c.k().m(str);
            if (z) {
                c.a.e.e.l.a.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.e.e.l.e
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        byte[] downloadImageBytes;
        a aVar;
        boolean z2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            WebClient webClient = new WebClient();
            if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX)) > 0) {
                    str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                    z = true;
                    downloadImageBytes = webClient.downloadImageBytes(str3, false);
                    boolean needCache = webClient.needCache();
                    if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                        BdLog.e("BIGIMAGE imageLoaderProc too big");
                        c.a.q0.s.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
                    }
                    if (downloadImageBytes == null && webClient.IsRequestSuccess()) {
                        Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        if (z && Bytes2Bitmap == null) {
                            TbadkCoreApplication.getInst().incWebpFailureCount();
                            c.a.q0.s.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                            downloadImageBytes = webClient.downloadImageBytes(str, false);
                            needCache = webClient.needCache();
                            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                                Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                            }
                        }
                        if (downloadImageBytes != null && Bytes2Bitmap != null) {
                            synchronized (BitmapHelper.lockForSyncImageDecoder) {
                                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                                c.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                                boolean B = l.B(downloadImageBytes);
                                NSGif f2 = (NSGif.f36295f && B) ? NSGif.f(downloadImageBytes, 0, downloadImageBytes.length) : null;
                                if (f2 != null) {
                                    aVar = new a((c.a.e.d.b) f2, Bytes2Bitmap, true);
                                    aVar.y(needCache);
                                } else {
                                    if (B) {
                                        BdLog.e("BIGIMAGE gif parse fail ");
                                        c.a.q0.s.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                                    }
                                    a aVar2 = new a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i2, i3), false, str);
                                    aVar2.y(needCache);
                                    aVar = aVar2;
                                }
                                if (needCache) {
                                    c.a.e.e.a.f.a aVar3 = new c.a.e.e.a.f.a("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                                    aVar3.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    aVar3.setSubFolder(true);
                                    aVar3.setData(downloadImageBytes);
                                    aVar3.setSdCard(false);
                                    aVar3.setSavedCache(true);
                                    d.g().a(aVar3);
                                    if (bVar != null) {
                                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                        diskCancelWorker.setOperate(aVar3);
                                        bVar.f2382a = diskCancelWorker;
                                    }
                                }
                                if (B) {
                                    z2 = false;
                                    BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, bVar);
                                } else {
                                    z2 = false;
                                }
                                if (downloadImageBytes.length > 1) {
                                    z2 = true;
                                }
                                c.a.e.e.l.a.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                            }
                            return aVar;
                        }
                        c.a.e.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
                        return null;
                    }
                    c.a.e.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
                    return null;
                }
            }
            str3 = str;
            z = false;
            downloadImageBytes = webClient.downloadImageBytes(str3, false);
            boolean needCache2 = webClient.needCache();
            if (webClient.IsRequestSuccess()) {
                BdLog.e("BIGIMAGE imageLoaderProc too big");
                c.a.q0.s.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
            }
            if (downloadImageBytes == null) {
            }
            c.a.e.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
            return null;
        }
        return (a) invokeCommon.objValue;
    }
}
