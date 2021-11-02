package b.a.r0.l3.s0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.t.c.r;
import b.a.q0.t.c.s;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j <= 0 || j2 <= 0) {
                return -1.0f;
            }
            return (((float) j2) / 1024.0f) / (((float) j) / 1000.0f);
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
        asyncPublishStatData.f20825d = currentTimeMillis;
        asyncPublishStatData.f20828g = currentTimeMillis - asyncPublishStatData.f20824c;
        if (errorData != null && errorData.getError_code() == 0) {
            asyncPublishStatData.f20826e = 0;
        } else if (errorData != null) {
            asyncPublishStatData.f20826e = errorData.error_code;
            asyncPublishStatData.f20827f = errorData.error_msg;
        } else {
            asyncPublishStatData.f20826e = -17;
            asyncPublishStatData.f20827f = TbadkCoreApplication.getInst().getApp().getString(R.string.neterror);
        }
        f(asyncPublishStatData);
        b("上传结束（endAsyncPublish）: id =" + asyncPublishStatData.f20824c + "    endTime = " + asyncPublishStatData.f20825d);
    }

    public static void d(WriteData writeData, ImageFileInfo imageFileInfo, ImageUploadResult imageUploadResult) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, writeData, imageFileInfo, imageUploadResult) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f20821e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar.f20809b = currentTimeMillis;
        long j = currentTimeMillis - aVar.o;
        aVar.f20813f = j;
        if (j <= 0) {
            aVar.f20813f = 1L;
        }
        aVar.f20814g = (((float) aVar.u) / 1024.0f) / (((float) aVar.f20813f) / 1000.0f);
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                aVar.f20810c = 0;
                aVar.f20812e = uploadedPicInfo.toPostString();
            } else {
                aVar.f20810c = imageUploadResult.error_code;
                aVar.f20811d = imageUploadResult.error_msg;
            }
        } else {
            aVar.f20810c = -52;
            aVar.f20811d = TbadkCoreApplication.getInst().getString(R.string.neterror);
        }
        b("结束单张上传图片（endAsyncPublishImage）: path =" + imageFileInfo.getFilePath());
        b("结束单张上传图片（网络耗时）: time = " + (aVar.f20809b - aVar.o));
    }

    public static void e(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        b bVar = asyncPublishStatData.E;
        bVar.f20818b = System.currentTimeMillis();
        asyncPublishStatData.f20829h = 1;
        asyncPublishStatData.o = bVar.f20821e.size();
        long j = 0;
        for (a aVar : bVar.f20821e.values()) {
            j += aVar.u;
        }
        asyncPublishStatData.p = j;
        long j2 = bVar.f20818b - bVar.f20817a;
        asyncPublishStatData.n = j2;
        asyncPublishStatData.m = a(j2, j);
        if (errorData == null) {
            bVar.f20819c = 0;
        } else {
            bVar.f20819c = errorData.error_code;
            bVar.f20820d = errorData.error_msg;
        }
        asyncPublishStatData.k = bVar.f20819c;
        asyncPublishStatData.l = bVar.f20820d;
        b("结束上传多张图片（endAsyncPublishImages）: id =" + bVar.f20817a + "    endTime = " + bVar.f20818b);
        StringBuilder sb = new StringBuilder();
        sb.append("结束上传多张图片（整体耗时）: time = ");
        sb.append(bVar.f20818b - bVar.f20817a);
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
                b("【打点】-【结束】endAsyncPublishStat: id = " + cVar.f20822a);
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
        eVar.f20832b = System.currentTimeMillis();
        asyncPublishStatData.f20830i = 1;
        if (videoFinishResult == null) {
            eVar.f20833c = -53;
        } else if (videoFinishResult.isSuccess()) {
            eVar.f20833c = 0;
            eVar.f20837g = videoFinishResult.getVideoMd5();
            eVar.f20838h = videoFinishResult.getVideoUrl();
        } else {
            eVar.f20833c = videoFinishResult.getErrorNo();
            eVar.f20834d = videoFinishResult.getUserMessage();
        }
        asyncPublishStatData.u = eVar.f20833c;
        asyncPublishStatData.v = eVar.f20834d;
        long j = eVar.f20832b - eVar.f20831a;
        asyncPublishStatData.x = j;
        long j2 = eVar.f20839i;
        asyncPublishStatData.y = j2;
        asyncPublishStatData.w = a(j, j2);
        b("上传视频结束（endAsyncPublishVideo）: id =" + eVar.f20831a + "    endTime = " + eVar.f20832b);
    }

    public static void h(WriteData writeData, ImageUploadResult imageUploadResult) {
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, writeData, imageUploadResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().H == null) {
            return;
        }
        a aVar = writeData.getAsyncPublishStatData().H;
        aVar.f20809b = System.currentTimeMillis();
        if (imageUploadResult == null) {
            aVar.f20810c = -53;
        } else {
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                aVar.f20810c = 0;
                aVar.f20812e = imageUploadResult.picInfo.bigPic.picUrl;
            } else {
                aVar.f20810c = imageUploadResult.error_code;
                aVar.f20811d = imageUploadResult.error_msg;
            }
        }
        long j = aVar.f20809b - aVar.f20808a;
        aVar.f20813f = j;
        aVar.f20814g = a(j, aVar.f20816i);
        b("上传视频首帧结束（endAsyncPublishVideoFirstFrame）: id =" + aVar.f20808a + "    endTime = " + aVar.f20809b);
    }

    public static void i(WriteData writeData, s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, writeData, sVar) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().F == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = asyncPublishStatData.F;
        fVar.f20841b = System.currentTimeMillis();
        asyncPublishStatData.j = 1;
        if (sVar != null && sVar.d()) {
            r a2 = sVar.a();
            if (a2 != null) {
                fVar.f20843d = 0;
                fVar.f20845f = a2.b();
            } else {
                fVar.f20843d = sVar.b();
                fVar.f20844e = sVar.c();
            }
        } else if (sVar != null) {
            fVar.f20843d = sVar.b();
            fVar.f20844e = sVar.c();
        } else {
            fVar.f20843d = TbErrInfo.ERR_VOI_SEND;
        }
        asyncPublishStatData.z = fVar.f20843d;
        asyncPublishStatData.A = fVar.f20844e;
        long j = fVar.f20841b - fVar.f20840a;
        asyncPublishStatData.C = j;
        long j2 = fVar.f20846g;
        asyncPublishStatData.D = j2;
        asyncPublishStatData.B = a(j, j2);
        b("上传声音结束（endAsyncPublishVoice）: id =" + fVar.f20840a + "    endTime = " + fVar.f20841b);
    }

    public static void j(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j)}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f20821e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.o = System.currentTimeMillis();
        aVar.r = str;
        aVar.s = iArr[0];
        aVar.t = iArr[1];
        aVar.u = j;
        b("压缩结束（endCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB");
    }

    public static void k(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, cVar) == null) {
            try {
                b.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.b("action", "async_publish_end");
                statsItem.c("extId", Long.valueOf(cVar.f20822a));
                statsItem.c("parentId", Long.valueOf(cVar.f20823b));
                statsItem.c("startTime", Long.valueOf(cVar.f20824c));
                statsItem.c("endTime", Long.valueOf(cVar.f20825d));
                statsItem.c("errorCode", Integer.valueOf(cVar.f20826e));
                statsItem.b("errorMessage", cVar.f20827f);
                statsItem.c("sendThreadDuration", Long.valueOf(cVar.f20828g));
                statsItem.c("haveImage", Integer.valueOf(cVar.f20829h));
                statsItem.c("haveVideo", Integer.valueOf(cVar.f20830i));
                statsItem.c("haveVoice", Integer.valueOf(cVar.j));
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
        b("开始后台上传（startAsyncPublish） id = " + cVar.f20822a + "  parentId = " + cVar.f20823b);
        o(cVar);
    }

    public static void m(WriteData writeData, ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, writeData, imageFileInfo) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null) {
            return;
        }
        writeData.getAsyncPublishStatData().E.f20821e.put(Long.valueOf(imageFileInfo.startUploadTime), new a(imageFileInfo));
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
        b("多张图片开始上传（startAsyncPublishImages）: startTime = " + asyncPublishStatData.E.f20817a);
    }

    public static void o(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.a());
                uBCManager.onEvent("4260", jSONObject);
                b("【打点】-【点击】startAsyncPublishStat: id = " + cVar.f20822a);
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
        eVar.f20839i = FileHelper.getFileSize(videoInfo.getVideoPath());
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
        aVar.f20816i = FileHelper.getFileSize(str);
        b("开始上传视频首帧（startAsyncPublishVideoFirstFrame): path =" + asyncPublishStatData.H.f20815h);
    }

    public static void r(WriteData writeData, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65553, null, writeData, j) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || TextUtils.isEmpty(writeData.getVoice())) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = new f(writeData.getVoice());
        fVar.f20846g = j;
        asyncPublishStatData.F = fVar;
        b("开始上传声音（startAsyncPublishVoice）: id =" + fVar.f20842c);
    }

    public static void s(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j, boolean z, boolean z2, boolean z3, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().E == null || (aVar = writeData.getAsyncPublishStatData().E.f20821e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.n = System.currentTimeMillis();
        aVar.f20815h = str;
        aVar.j = iArr[0];
        aVar.k = iArr[1];
        aVar.f20816i = j;
        aVar.l = z;
        aVar.m = z2;
        aVar.p = z3;
        aVar.q = str2;
        b("开始压缩（startCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB\n   isLongImage =" + z + "  isHeifImage =" + z2 + " resize =" + z3 + " uploadStrategy =" + str2);
    }

    public static void t(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cVar) == null) {
            b.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "async_publish_start");
            statsItem.c("extId", Long.valueOf(cVar.f20822a));
            statsItem.c("parentId", Long.valueOf(cVar.f20823b));
            statsItem.c("startTime", Long.valueOf(cVar.f20824c));
            BdStatisticsManager.getInstance().performance("thread", statsItem);
        }
    }
}
