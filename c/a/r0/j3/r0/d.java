package c.a.r0.j3.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.t.c.q;
import c.a.q0.t.c.r;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j2 <= 0 || j3 <= 0) {
                return -1.0f;
            }
            return (((float) j3) / 1024.0f) / (((float) j2) / 1000.0f);
        }
        return invokeCommon.floatValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void c(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        long currentTimeMillis = System.currentTimeMillis();
        asyncPublishStatData.f21067d = currentTimeMillis;
        asyncPublishStatData.f21070g = currentTimeMillis - asyncPublishStatData.f21066c;
        if (errorData != null && errorData.getError_code() == 0) {
            asyncPublishStatData.f21068e = 0;
        } else if (errorData != null) {
            asyncPublishStatData.f21068e = errorData.error_code;
            asyncPublishStatData.f21069f = errorData.error_msg;
        } else {
            asyncPublishStatData.f21068e = -17;
            asyncPublishStatData.f21069f = TbadkCoreApplication.getInst().getApp().getString(R.string.neterror);
        }
        f(asyncPublishStatData);
        b("上传结束（endAsyncPublish）: id =" + asyncPublishStatData.f21066c + "    endTime = " + asyncPublishStatData.f21067d);
    }

    public static void d(WriteData writeData, ImageFileInfo imageFileInfo, ImageUploadResult imageUploadResult) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, writeData, imageFileInfo, imageUploadResult) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f21063e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar.f21050b = currentTimeMillis;
        long j2 = currentTimeMillis - aVar.o;
        aVar.f21054f = j2;
        if (j2 <= 0) {
            aVar.f21054f = 1L;
        }
        aVar.f21055g = (((float) aVar.u) / 1024.0f) / (((float) aVar.f21054f) / 1000.0f);
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                aVar.f21051c = 0;
                aVar.f21053e = uploadedPicInfo.toPostString();
            } else {
                aVar.f21051c = imageUploadResult.error_code;
                aVar.f21052d = imageUploadResult.error_msg;
            }
        } else {
            aVar.f21051c = -52;
            aVar.f21052d = TbadkCoreApplication.getInst().getString(R.string.neterror);
        }
        b("结束单张上传图片（endAsyncPublishImage）: path =" + imageFileInfo.getFilePath());
        b("结束单张上传图片（网络耗时）: time = " + (aVar.f21050b - aVar.o));
    }

    public static void e(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        b bVar = asyncPublishStatData.E;
        bVar.f21060b = System.currentTimeMillis();
        asyncPublishStatData.f21071h = 1;
        asyncPublishStatData.o = bVar.f21063e.size();
        long j2 = 0;
        for (a aVar : bVar.f21063e.values()) {
            j2 += aVar.u;
        }
        asyncPublishStatData.p = j2;
        long j3 = bVar.f21060b - bVar.f21059a;
        asyncPublishStatData.n = j3;
        asyncPublishStatData.m = a(j3, j2);
        if (errorData == null) {
            bVar.f21061c = 0;
        } else {
            bVar.f21061c = errorData.error_code;
            bVar.f21062d = errorData.error_msg;
        }
        asyncPublishStatData.k = bVar.f21061c;
        asyncPublishStatData.l = bVar.f21062d;
        b("结束上传多张图片（endAsyncPublishImages）: id =" + bVar.f21059a + "    endTime = " + bVar.f21060b);
        StringBuilder sb = new StringBuilder();
        sb.append("结束上传多张图片（整体耗时）: time = ");
        sb.append(bVar.f21060b - bVar.f21059a);
        b(sb.toString());
    }

    public static void f(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.b());
                uBCManager.onEvent("4259", jSONObject);
                b("【打点】-【结束】endAsyncPublishStat: id = " + cVar.f21064a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            k(cVar);
        }
    }

    public static void g(WriteData writeData, VideoFinishResult videoFinishResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, writeData, videoFinishResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().G == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        e eVar = asyncPublishStatData.G;
        eVar.f21075b = System.currentTimeMillis();
        asyncPublishStatData.f21072i = 1;
        if (videoFinishResult == null) {
            eVar.f21076c = -53;
        } else if (videoFinishResult.isSuccess()) {
            eVar.f21076c = 0;
            eVar.f21080g = videoFinishResult.getVideoMd5();
            eVar.f21081h = videoFinishResult.getVideoUrl();
        } else {
            eVar.f21076c = videoFinishResult.getErrorNo();
            eVar.f21077d = videoFinishResult.getUserMessage();
        }
        asyncPublishStatData.u = eVar.f21076c;
        asyncPublishStatData.v = eVar.f21077d;
        long j2 = eVar.f21075b - eVar.f21074a;
        asyncPublishStatData.x = j2;
        long j3 = eVar.f21082i;
        asyncPublishStatData.y = j3;
        asyncPublishStatData.w = a(j2, j3);
        b("上传视频结束（endAsyncPublishVideo）: id =" + eVar.f21074a + "    endTime = " + eVar.f21075b);
    }

    public static void h(WriteData writeData, ImageUploadResult imageUploadResult) {
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, writeData, imageUploadResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().H == null) {
            return;
        }
        a aVar = writeData.getAsyncPublishStatData().H;
        aVar.f21050b = System.currentTimeMillis();
        if (imageUploadResult == null) {
            aVar.f21051c = -53;
        } else {
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                aVar.f21051c = 0;
                aVar.f21053e = imageUploadResult.picInfo.bigPic.picUrl;
            } else {
                aVar.f21051c = imageUploadResult.error_code;
                aVar.f21052d = imageUploadResult.error_msg;
            }
        }
        long j2 = aVar.f21050b - aVar.f21049a;
        aVar.f21054f = j2;
        aVar.f21055g = a(j2, aVar.f21057i);
        b("上传视频首帧结束（endAsyncPublishVideoFirstFrame）: id =" + aVar.f21049a + "    endTime = " + aVar.f21050b);
    }

    public static void i(WriteData writeData, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, writeData, rVar) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().F == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = asyncPublishStatData.F;
        fVar.f21084b = System.currentTimeMillis();
        asyncPublishStatData.f21073j = 1;
        if (rVar != null && rVar.d()) {
            q a2 = rVar.a();
            if (a2 != null) {
                fVar.f21086d = 0;
                fVar.f21088f = a2.b();
            } else {
                fVar.f21086d = rVar.b();
                fVar.f21087e = rVar.c();
            }
        } else if (rVar != null) {
            fVar.f21086d = rVar.b();
            fVar.f21087e = rVar.c();
        } else {
            fVar.f21086d = TbErrInfo.ERR_VOI_SEND;
        }
        asyncPublishStatData.z = fVar.f21086d;
        asyncPublishStatData.A = fVar.f21087e;
        long j2 = fVar.f21084b - fVar.f21083a;
        asyncPublishStatData.C = j2;
        long j3 = fVar.f21089g;
        asyncPublishStatData.D = j3;
        asyncPublishStatData.B = a(j2, j3);
        b("上传声音结束（endAsyncPublishVoice）: id =" + fVar.f21083a + "    endTime = " + fVar.f21084b);
    }

    public static void j(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j2)}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f21063e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.o = System.currentTimeMillis();
        aVar.r = str;
        aVar.s = iArr[0];
        aVar.t = iArr[1];
        aVar.u = j2;
        b("压缩结束（endCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j2) / 1048576.0f) + "MB");
    }

    public static void k(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, cVar) == null) {
            try {
                c.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.b("action", "async_publish_end");
                statsItem.c("extId", Long.valueOf(cVar.f21064a));
                statsItem.c("parentId", Long.valueOf(cVar.f21065b));
                statsItem.c("startTime", Long.valueOf(cVar.f21066c));
                statsItem.c("endTime", Long.valueOf(cVar.f21067d));
                statsItem.c("errorCode", Integer.valueOf(cVar.f21068e));
                statsItem.b("errorMessage", cVar.f21069f);
                statsItem.c("sendThreadDuration", Long.valueOf(cVar.f21070g));
                statsItem.c("haveImage", Integer.valueOf(cVar.f21071h));
                statsItem.c("haveVideo", Integer.valueOf(cVar.f21072i));
                statsItem.c("haveVoice", Integer.valueOf(cVar.f21073j));
                if (cVar.E != null) {
                    statsItem.b("imagesData", cVar.E.a().toString());
                    statsItem.c("imageErrorCode", Integer.valueOf(cVar.k));
                    statsItem.b("imageErrorMessage", cVar.l);
                    statsItem.c("imageUploadRate", Float.valueOf(cVar.m));
                    statsItem.c("imageUploadDuration", Long.valueOf(cVar.n));
                    statsItem.c("imageCount", Integer.valueOf(cVar.o));
                    statsItem.c("imageSize", Long.valueOf(cVar.p));
                    statsItem.c("needImageParallel", Integer.valueOf(cVar.q));
                    statsItem.c("imageChunkSize", Integer.valueOf(cVar.r));
                    statsItem.c("imageUploadConcurrency", Integer.valueOf(cVar.s));
                    statsItem.c("imageChunkRetry", Integer.valueOf(cVar.t));
                }
                if (cVar.F != null) {
                    statsItem.b("voiceData", cVar.F.a().toString());
                    statsItem.c("voiceErrorCode", Integer.valueOf(cVar.z));
                    statsItem.b("voiceErrorMessage", cVar.A);
                    statsItem.c("voiceUploadDuration", Long.valueOf(cVar.C));
                    statsItem.c("voiceUploadRate", Float.valueOf(cVar.B));
                }
                if (cVar.G != null) {
                    statsItem.b("videoData", cVar.G.a().toString());
                    statsItem.c("videoErrorCode", Integer.valueOf(cVar.u));
                    statsItem.b("videoErrorMessage", cVar.v);
                    statsItem.c("videoUploadRate", Float.valueOf(cVar.w));
                    statsItem.c("videoUploadDuration", Long.valueOf(cVar.x));
                }
                if (cVar.H != null) {
                    statsItem.b("videoFirstFrame", cVar.H.a().toString());
                }
                BdStatisticsManager.getInstance().performance("thread", statsItem);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void l(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, writeData) == null) || writeData == null || writeData.startPublishTime() <= 0) {
            return;
        }
        c cVar = new c(writeData);
        writeData.setAsyncPublishStatData(cVar);
        b("开始后台上传（startAsyncPublish） id = " + cVar.f21064a + "  parentId = " + cVar.f21065b);
        o(cVar);
    }

    public static void m(WriteData writeData, ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, writeData, imageFileInfo) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null) {
            return;
        }
        writeData.getAsyncPublishStatData().E.f21063e.put(Long.valueOf(imageFileInfo.startUploadTime), new a(imageFileInfo));
        b("多张图片开始上传(startAsyncPublishImage): path =" + imageFileInfo.getFilePath());
    }

    public static void n(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, writeData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        asyncPublishStatData.E = new b();
        WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
        if (writeImagesInfo != null) {
            asyncPublishStatData.q = writeImagesInfo.needImageParallel ? 1 : 0;
            asyncPublishStatData.r = writeImagesInfo.imageChunkSize;
            asyncPublishStatData.s = writeImagesInfo.imageUploadConcurrency;
            asyncPublishStatData.t = writeImagesInfo.imageChunkRetry;
        }
        b("多张图片开始上传（startAsyncPublishImages）: startTime = " + asyncPublishStatData.E.f21059a);
    }

    public static void o(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.a());
                uBCManager.onEvent("4260", jSONObject);
                b("【打点】-【点击】startAsyncPublishStat: id = " + cVar.f21064a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            t(cVar);
        }
    }

    public static void p(WriteData writeData, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, writeData, videoInfo) == null) || writeData == null || videoInfo == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        e eVar = new e(videoInfo);
        asyncPublishStatData.G = eVar;
        eVar.f21082i = FileHelper.getFileSize(videoInfo.getVideoPath());
        b("开始上传视频（startAsyncPublishVideo）: id =" + videoInfo.getVideoPath());
    }

    public static void q(WriteData writeData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, writeData, str) == null) || writeData == null || TextUtils.isEmpty(str) || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        a aVar = new a(str);
        asyncPublishStatData.H = aVar;
        aVar.f21057i = FileHelper.getFileSize(str);
        b("开始上传视频首帧（startAsyncPublishVideoFirstFrame): path =" + asyncPublishStatData.H.f21056h);
    }

    public static void r(WriteData writeData, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65553, null, writeData, j2) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || TextUtils.isEmpty(writeData.getVoice())) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = new f(writeData.getVoice());
        fVar.f21089g = j2;
        asyncPublishStatData.F = fVar;
        b("开始上传声音（startAsyncPublishVoice）: id =" + fVar.f21085c);
    }

    public static void s(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j2, boolean z, boolean z2, boolean z3, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f21063e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.n = System.currentTimeMillis();
        aVar.f21056h = str;
        aVar.f21058j = iArr[0];
        aVar.k = iArr[1];
        aVar.f21057i = j2;
        aVar.l = z;
        aVar.m = z2;
        aVar.p = z3;
        aVar.q = str2;
        b("开始压缩（startCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j2) / 1048576.0f) + "MB\n   isLongImage =" + z + "  isHeifImage =" + z2 + " resize =" + z3 + " uploadStrategy =" + str2);
    }

    public static void t(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cVar) == null) {
            c.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "async_publish_start");
            statsItem.c("extId", Long.valueOf(cVar.f21064a));
            statsItem.c("parentId", Long.valueOf(cVar.f21065b));
            statsItem.c("startTime", Long.valueOf(cVar.f21066c));
            BdStatisticsManager.getInstance().performance("thread", statsItem);
        }
    }
}
