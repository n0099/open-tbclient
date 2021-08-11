package c.a.p0.i3.q0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.t.c.q;
import c.a.o0.t.c.r;
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
        asyncPublishStatData.f20169d = currentTimeMillis;
        asyncPublishStatData.f20172g = currentTimeMillis - asyncPublishStatData.f20168c;
        if (errorData != null && errorData.getError_code() == 0) {
            asyncPublishStatData.f20170e = 0;
        } else if (errorData != null) {
            asyncPublishStatData.f20170e = errorData.error_code;
            asyncPublishStatData.f20171f = errorData.error_msg;
        } else {
            asyncPublishStatData.f20170e = -17;
            asyncPublishStatData.f20171f = TbadkCoreApplication.getInst().getApp().getString(R.string.neterror);
        }
        f(asyncPublishStatData);
        b("上传结束（endAsyncPublish）: id =" + asyncPublishStatData.f20168c + "    endTime = " + asyncPublishStatData.f20169d);
    }

    public static void d(WriteData writeData, ImageFileInfo imageFileInfo, ImageUploadResult imageUploadResult) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, writeData, imageFileInfo, imageUploadResult) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().A == null || (aVar = writeData.getAsyncPublishStatData().A.f20165e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar.f20152b = currentTimeMillis;
        long j2 = currentTimeMillis - aVar.o;
        aVar.f20156f = j2;
        if (j2 <= 0) {
            aVar.f20156f = 1L;
        }
        aVar.f20157g = (((float) aVar.u) / 1024.0f) / (((float) aVar.f20156f) / 1000.0f);
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                aVar.f20153c = 0;
                aVar.f20155e = uploadedPicInfo.toPostString();
            } else {
                aVar.f20153c = imageUploadResult.error_code;
                aVar.f20154d = imageUploadResult.error_msg;
            }
        } else {
            aVar.f20153c = -53;
            aVar.f20154d = TbadkCoreApplication.getInst().getString(R.string.upload_error);
        }
        b("结束单张上传图片（endAsyncPublishImage）: path =" + imageFileInfo.getFilePath());
        b("结束单张上传图片（网络耗时）: time = " + (aVar.f20152b - aVar.o));
    }

    public static void e(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().A == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        b bVar = asyncPublishStatData.A;
        bVar.f20162b = System.currentTimeMillis();
        asyncPublishStatData.f20173h = 1;
        asyncPublishStatData.o = bVar.f20165e.size();
        long j2 = 0;
        for (a aVar : bVar.f20165e.values()) {
            j2 += aVar.u;
        }
        asyncPublishStatData.p = j2;
        long j3 = bVar.f20162b - bVar.f20161a;
        asyncPublishStatData.n = j3;
        asyncPublishStatData.m = a(j3, j2);
        if (errorData == null) {
            bVar.f20163c = 0;
        } else {
            bVar.f20163c = errorData.error_code;
            bVar.f20164d = errorData.error_msg;
        }
        asyncPublishStatData.k = bVar.f20163c;
        asyncPublishStatData.l = bVar.f20164d;
        b("结束上传多张图片（endAsyncPublishImages）: id =" + bVar.f20161a + "    endTime = " + bVar.f20162b);
    }

    public static void f(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.b());
                uBCManager.onEvent("4259", jSONObject);
                b("【打点】-【结束】endAsyncPublishStat: id = " + cVar.f20166a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            k(cVar);
        }
    }

    public static void g(WriteData writeData, VideoFinishResult videoFinishResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, writeData, videoFinishResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().C == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        e eVar = asyncPublishStatData.C;
        eVar.f20177b = System.currentTimeMillis();
        asyncPublishStatData.f20174i = 1;
        if (videoFinishResult == null) {
            eVar.f20178c = -53;
        } else if (videoFinishResult.isSuccess()) {
            eVar.f20178c = 0;
            eVar.f20182g = videoFinishResult.getVideoMd5();
            eVar.f20183h = videoFinishResult.getVideoUrl();
        } else {
            eVar.f20178c = videoFinishResult.getErrorNo();
            eVar.f20179d = videoFinishResult.getUserMessage();
        }
        asyncPublishStatData.q = eVar.f20178c;
        asyncPublishStatData.r = eVar.f20179d;
        long j2 = eVar.f20177b - eVar.f20176a;
        asyncPublishStatData.t = j2;
        long j3 = eVar.f20184i;
        asyncPublishStatData.u = j3;
        asyncPublishStatData.s = a(j2, j3);
        b("上传视频结束（endAsyncPublishVideo）: id =" + eVar.f20176a + "    endTime = " + eVar.f20177b);
    }

    public static void h(WriteData writeData, ImageUploadResult imageUploadResult) {
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, writeData, imageUploadResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().D == null) {
            return;
        }
        a aVar = writeData.getAsyncPublishStatData().D;
        aVar.f20152b = System.currentTimeMillis();
        if (imageUploadResult == null) {
            aVar.f20153c = -53;
        } else {
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                aVar.f20153c = 0;
                aVar.f20155e = imageUploadResult.picInfo.bigPic.picUrl;
            } else {
                aVar.f20153c = imageUploadResult.error_code;
                aVar.f20154d = imageUploadResult.error_msg;
            }
        }
        long j2 = aVar.f20152b - aVar.f20151a;
        aVar.f20156f = j2;
        aVar.f20157g = a(j2, aVar.f20159i);
        b("上传视频首帧结束（endAsyncPublishVideoFirstFrame）: id =" + aVar.f20151a + "    endTime = " + aVar.f20152b);
    }

    public static void i(WriteData writeData, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, writeData, rVar) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().B == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = asyncPublishStatData.B;
        fVar.f20186b = System.currentTimeMillis();
        asyncPublishStatData.f20175j = 1;
        if (rVar != null && rVar.d()) {
            q a2 = rVar.a();
            if (a2 != null) {
                fVar.f20188d = 0;
                fVar.f20190f = a2.b();
            } else {
                fVar.f20188d = rVar.b();
                fVar.f20189e = rVar.c();
            }
        } else if (rVar != null) {
            fVar.f20188d = rVar.b();
            fVar.f20189e = rVar.c();
        } else {
            fVar.f20188d = TbErrInfo.ERR_VOI_SEND;
        }
        asyncPublishStatData.v = fVar.f20188d;
        asyncPublishStatData.w = fVar.f20189e;
        long j2 = fVar.f20186b - fVar.f20185a;
        asyncPublishStatData.y = j2;
        long j3 = fVar.f20191g;
        asyncPublishStatData.z = j3;
        asyncPublishStatData.x = a(j2, j3);
        b("上传声音结束（endAsyncPublishVoice）: id =" + fVar.f20185a + "    endTime = " + fVar.f20186b);
    }

    public static void j(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j2)}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().A == null || (aVar = writeData.getAsyncPublishStatData().A.f20165e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
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
                statsItem.c("extId", Long.valueOf(cVar.f20166a));
                statsItem.c("parentId", Long.valueOf(cVar.f20167b));
                statsItem.c("startTime", Long.valueOf(cVar.f20168c));
                statsItem.c("endTime", Long.valueOf(cVar.f20169d));
                statsItem.c("errorCode", Integer.valueOf(cVar.f20170e));
                statsItem.b("errorMessage", cVar.f20171f);
                statsItem.c("sendThreadDuration", Long.valueOf(cVar.f20172g));
                statsItem.c("haveImage", Integer.valueOf(cVar.f20173h));
                statsItem.c("haveVideo", Integer.valueOf(cVar.f20174i));
                statsItem.c("haveVoice", Integer.valueOf(cVar.f20175j));
                if (cVar.A != null) {
                    statsItem.b("imagesData", cVar.A.a().toString());
                    statsItem.c("imageErrorCode", Integer.valueOf(cVar.k));
                    statsItem.b("imageErrorMessage", cVar.l);
                    statsItem.c("imageUploadRate", Float.valueOf(cVar.m));
                    statsItem.c("imageUploadDuration", Long.valueOf(cVar.n));
                    statsItem.c("imageCount", Integer.valueOf(cVar.o));
                    statsItem.c("imageSize", Long.valueOf(cVar.p));
                }
                if (cVar.B != null) {
                    statsItem.b("voiceData", cVar.B.a().toString());
                    statsItem.c("voiceErrorCode", Integer.valueOf(cVar.v));
                    statsItem.b("voiceErrorMessage", cVar.w);
                    statsItem.c("voiceUploadDuration", Long.valueOf(cVar.y));
                    statsItem.c("voiceUploadRate", Float.valueOf(cVar.x));
                }
                if (cVar.C != null) {
                    statsItem.b("videoData", cVar.C.a().toString());
                    statsItem.c("videoErrorCode", Integer.valueOf(cVar.q));
                    statsItem.b("videoErrorMessage", cVar.r);
                    statsItem.c("videoUploadRate", Float.valueOf(cVar.s));
                    statsItem.c("videoUploadDuration", Long.valueOf(cVar.t));
                }
                if (cVar.D != null) {
                    statsItem.b("videoFirstFrame", cVar.D.a().toString());
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
        b("开始后台上传（startAsyncPublish） id = " + cVar.f20166a + "  parentId = " + cVar.f20167b);
        o(cVar);
    }

    public static void m(WriteData writeData, ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, writeData, imageFileInfo) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().A == null) {
            return;
        }
        writeData.getAsyncPublishStatData().A.f20165e.put(Long.valueOf(imageFileInfo.startUploadTime), new a(imageFileInfo));
        b("多张图片开始上传(startAsyncPublishImage): path =" + imageFileInfo.getFilePath());
    }

    public static void n(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, writeData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        asyncPublishStatData.A = new b();
        b("多张图片开始上传（startAsyncPublishImages）: startTime = " + asyncPublishStatData.A.f20161a);
    }

    public static void o(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, cVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", cVar.a());
                uBCManager.onEvent("4260", jSONObject);
                b("【打点】-【点击】startAsyncPublishStat: id = " + cVar.f20166a);
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
        asyncPublishStatData.C = eVar;
        eVar.f20184i = FileHelper.getFileSize(videoInfo.getVideoPath());
        b("开始上传视频（startAsyncPublishVideo）: id =" + videoInfo.getVideoPath());
    }

    public static void q(WriteData writeData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, writeData, str) == null) || writeData == null || TextUtils.isEmpty(str) || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        a aVar = new a(str);
        asyncPublishStatData.D = aVar;
        aVar.f20159i = FileHelper.getFileSize(str);
        b("开始上传视频首帧（startAsyncPublishVideoFirstFrame): path =" + asyncPublishStatData.D.f20158h);
    }

    public static void r(WriteData writeData, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65553, null, writeData, j2) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || TextUtils.isEmpty(writeData.getVoice())) {
            return;
        }
        c asyncPublishStatData = writeData.getAsyncPublishStatData();
        f fVar = new f(writeData.getVoice());
        fVar.f20191g = j2;
        asyncPublishStatData.B = fVar;
        b("开始上传声音（startAsyncPublishVoice）: id =" + fVar.f20187c);
    }

    public static void s(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j2, boolean z, boolean z2, boolean z3, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().A == null || (aVar = writeData.getAsyncPublishStatData().A.f20165e.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        aVar.n = System.currentTimeMillis();
        aVar.f20158h = str;
        aVar.f20160j = iArr[0];
        aVar.k = iArr[1];
        aVar.f20159i = j2;
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
            statsItem.c("extId", Long.valueOf(cVar.f20166a));
            statsItem.c("parentId", Long.valueOf(cVar.f20167b));
            statsItem.c("startTime", Long.valueOf(cVar.f20168c));
            BdStatisticsManager.getInstance().performance("thread", statsItem);
        }
    }
}
