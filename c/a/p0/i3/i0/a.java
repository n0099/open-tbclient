package c.a.p0.i3.i0;

import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.o0.c0.f;
import c.a.o0.s.q.k1;
import c.a.o0.t.c.q;
import c.a.o0.t.c.r;
import c.a.p0.i3.o0.d.e;
import c.a.p0.i3.q0.d;
import c.a.p0.i3.q0.h;
import c.a.p0.i3.q0.m;
import c.a.p0.y1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String k;
    public static final String l;
    public static final String m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f19995a;

    /* renamed from: b  reason: collision with root package name */
    public ErrorData f19996b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19997c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f19998d;

    /* renamed from: e  reason: collision with root package name */
    public f f19999e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.i3.o0.a f20000f;

    /* renamed from: g  reason: collision with root package name */
    public c f20001g;

    /* renamed from: h  reason: collision with root package name */
    public g f20002h;

    /* renamed from: i  reason: collision with root package name */
    public SpanGroupManager f20003i;

    /* renamed from: j  reason: collision with root package name */
    public String f20004j;

    /* renamed from: c.a.p0.i3.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0942a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f20005a;

        public C0942a(a aVar, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20005a = writeData;
        }

        @Override // c.a.o0.c0.f.b
        public void a(String str, Object obj, long j2, long j3, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                h.a("发帖：发送图片 进度 = " + i2 + "/" + i3 + " :" + j2 + "/" + j3 + "   ，" + str);
                int i4 = (int) (90.0f / ((float) i3));
                float f2 = (((float) j2) / 2.0f) / ((float) j3);
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                k1.h(this.f20005a, (int) (((f2 + i2) - 1.0f) * i4)).f(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f20007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f20008c;

        public b(a aVar, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20008c = aVar;
            this.f20007b = writeData;
            this.f20006a = 0;
        }

        @Override // c.a.p0.i3.o0.d.e
        public void onProgressUpdate(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                h.a("发帖：开始上传视频 percent = " + f2);
                int i2 = (int) (f2 * 90.0f);
                k1.h(this.f20007b, i2).f(true);
                if (i2 != this.f20006a) {
                    this.f20006a = i2;
                    this.f20008c.f(i2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1647196922, "Lc/a/p0/i3/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1647196922, "Lc/a/p0/i3/i0/a;");
                return;
            }
        }
        k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
        l = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
        m = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19995a = null;
        this.f19996b = null;
        this.f19997c = false;
        this.f19996b = new ErrorData();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19997c = true;
            NetWork netWork = this.f19995a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            f fVar = this.f19999e;
            if (fVar != null) {
                fVar.a();
            }
            c.a.p0.i3.o0.a aVar = this.f20000f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19998d : (AntiData) invokeV.objValue;
    }

    public ErrorData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19996b : (ErrorData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetWork netWork = this.f19995a;
            if (netWork == null) {
                return false;
            }
            return netWork.getNetContext().getResponse().isRequestSuccess();
        }
        return invokeV.booleanValue;
    }

    public final void f(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (cVar = this.f20001g) == null) {
            return;
        }
        cVar.a(i2);
    }

    public ImageUploadResult g(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.f19999e == null) {
                this.f19999e = new f("HTTPWriteService.postImageData");
            }
            return this.f19999e.h(imageFileInfo, z);
        }
        return (ImageUploadResult) invokeLZ.objValue;
    }

    public String h(WriteData writeData, boolean z) {
        InterceptResult invokeLZ;
        String content;
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String title;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, writeData, z)) == null) {
            if (writeData == null) {
                return null;
            }
            h.a("发帖：postWriteData 开始");
            NetWork netWork = new NetWork();
            this.f19995a = netWork;
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            this.f19995a.setNeedSig(true);
            this.f19995a.addPostData("authsid", writeData.getAuthSid());
            if (!TextUtils.isEmpty(this.f20004j)) {
                content = this.f20004j;
                writeData.setSpanGroupString(content);
            } else {
                SpanGroupManager spanGroupManager = this.f20003i;
                if (spanGroupManager != null) {
                    content = spanGroupManager.t();
                    writeData.setSpanGroupString(content);
                } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
                    content = writeData.getSpanGroupString();
                } else {
                    content = writeData.getContent();
                }
            }
            if (writeData.getSubPbReplyPrefix() != null) {
                content = writeData.getSubPbReplyPrefix() + content;
            }
            if (!TextUtils.isEmpty(writeData.getZhongcePrefix())) {
                content = writeData.getZhongcePrefix() + content;
            }
            String str10 = content;
            h.a("发帖：发帖类型：" + writeData.getType());
            String str11 = "1";
            if (writeData.getType() == 3) {
                h.a("发帖：SHARE_SDK：设置数据");
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.f19995a.addPostData("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.f19995a.addPostData("tag", "11");
                }
                this.f19995a.addPostData("newVcode", "1");
                this.f19995a.addPostData("content", str10);
                this.f19995a.setUrl(m);
                this.f19995a.addPostData("fname", writeData.getForumName());
                if (!TextUtils.isEmpty(writeData.getTitle())) {
                    this.f19995a.addPostData("title", writeData.getTitle());
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.f19995a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.f19995a.addPostData("apiKey", writeData.getShareApiKey());
                this.f19995a.addPostData("appName", writeData.getShareAppName());
                this.f19995a.addPostData("signKey", writeData.getShareSignKey());
                this.f19995a.addPostData("summary_title", writeData.getShareSummaryTitle());
                this.f19995a.addPostData("summary_content", writeData.getShareSummaryContent());
                this.f19995a.addPostData("summary_img", writeData.getShareSummaryImg());
                this.f19995a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.f19995a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.f19995a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.f19995a.addPostData("referUrl", writeData.getShareReferUrl());
                str9 = null;
                str5 = str10;
            } else {
                h.a("发帖：开始分段数据发送");
                if (z && writeData.isHasImages()) {
                    d.n(writeData);
                    h.a("发帖：发送图片 开始");
                    if (this.f19999e == null) {
                        f fVar = new f("HTTPWriteService.postWriteData");
                        this.f19999e = fVar;
                        fVar.g(writeData);
                        this.f19999e.d(new C0942a(this, writeData), writeData);
                    }
                    if (writeData.getType() == 6) {
                        h.a("发帖：发送图片 上传图片 开始 1");
                        ErrorData o = this.f19999e.o(writeData.getWriteImagesInfo(), true);
                        if (o != null) {
                            this.f19996b.setError_code(o.getError_code());
                            this.f19996b.setError_msg(o.getError_msg());
                            h.a("发帖：发送图片 上传图片 错误 1");
                            d.e(writeData, o);
                            return null;
                        }
                        h.a("发帖：发送图片 上传图片 完成 1");
                    } else {
                        h.a("发帖：发送图片 上传图片 开始 2");
                        this.f19999e.m = writeData.isBJHPost();
                        ErrorData o2 = this.f19999e.o(writeData.getWriteImagesInfo(), true);
                        if (o2 != null) {
                            this.f19996b.setError_code(o2.getError_code());
                            this.f19996b.setError_msg(o2.getError_msg());
                            h.a("发帖：发送图片 上传图片 错误 2");
                            d.e(writeData, o2);
                            return null;
                        }
                        h.a("发帖：发送图片 上传图片 完成 2");
                    }
                    d.e(writeData, null);
                }
                if (this.f19997c) {
                    return null;
                }
                String voice = writeData.getVoice();
                int voiceDuringTime = writeData.getVoiceDuringTime();
                if (writeData.getReturnVoiceMd5() == null) {
                    returnVoiceMd5 = null;
                    z2 = false;
                } else {
                    returnVoiceMd5 = writeData.getReturnVoiceMd5();
                    z2 = true;
                }
                h.a("声音文件 = " + voice);
                if (voice == null || z2) {
                    str = str10;
                } else {
                    h.a("发帖：发送声音 开始");
                    c.a.o0.s.g0.c.b bVar = new c.a.o0.s.g0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                    bVar.a("type", 1);
                    String storeFile = FileHelper.getStoreFile(voice, 1);
                    str = str10;
                    d.r(writeData, FileHelper.getFileSize(storeFile));
                    r d2 = bVar.d(storeFile);
                    if (d2 != null && d2.d()) {
                        q a2 = d2.a();
                        if (a2 != null) {
                            returnVoiceMd5 = a2.b();
                            c.a.o0.s.g0.b.b.b(writeData.getVoice(), returnVoiceMd5);
                            writeData.setReturnVoiceMd5(returnVoiceMd5);
                            d.i(writeData, d2);
                            h.a("发帖：发送声音 完成 1");
                        } else {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("ErrCode", Integer.valueOf(d2.b()));
                            fieldBuilder.append("ErrMsg", d2.c());
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                            this.f19996b.setError_code(d2.b());
                            this.f19996b.setError_msg(d2.c());
                            h.a("发帖：发送声音 失败 1");
                            d.i(writeData, d2);
                            return null;
                        }
                    } else {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("audioFile", storeFile);
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                        if (d2 != null) {
                            this.f19996b.setError_code(d2.b());
                            this.f19996b.setError_msg(d2.c());
                        }
                        d.i(writeData, d2);
                        h.a("发帖：发送声音 失败 2");
                        return null;
                    }
                }
                if (this.f19997c) {
                    return null;
                }
                VideoInfo videoInfo = writeData.getVideoInfo();
                if (videoInfo != null) {
                    if (videoInfo.needUploadVideo()) {
                        d.p(writeData, videoInfo);
                        this.f20000f = new c.a.p0.i3.o0.a(this.f20002h);
                        h.a("发帖：开始上传视频");
                        VideoFinishResult e2 = this.f20000f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this, writeData));
                        d.g(writeData, e2);
                        if (e2 == null) {
                            this.f19996b.setError_code(-53);
                            this.f19996b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                            h.a("发帖：开始上传视频 失败 1");
                            return null;
                        } else if (e2.isSuccess()) {
                            videoInfo.setVideoMd5(e2.getVideoMd5());
                            videoInfo.setVideoUrl(e2.getVideoUrl());
                            h.a("发帖：开始上传视频 成功 ");
                        } else {
                            this.f19996b.setError_code(e2.getErrorNo());
                            this.f19996b.setError_msg(e2.getUserMessage());
                            h.a("发帖：开始上传视频 失败 2");
                            return null;
                        }
                    }
                    if (videoInfo.needUploadThunmb()) {
                        h.a("发帖：开始上传首帧图 开始 ");
                        if (this.f19999e == null) {
                            f fVar2 = new f("HTTPWriteService.postWriteData");
                            this.f19999e = fVar2;
                            fVar2.g(writeData);
                        }
                        d.q(writeData, videoInfo.getThumbPath());
                        ImageUploadResult k2 = this.f19999e.k(videoInfo.getThumbPath(), false);
                        d.h(writeData, k2);
                        if (k2 != null) {
                            videoInfo.setThumbId(k2.picId);
                            ImageUploadResult.picInfo picinfo = k2.picInfo;
                            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                                c.a.p0.i3.q0.g.g().u(k2.picInfo.bigPic.picUrl);
                            }
                        }
                        h.a("发帖：开始上传首帧图 完成 ");
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!ListUtils.isEmpty(videoInfo.getStickListInfo())) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str12 : videoInfo.getStickListInfo()) {
                                jSONArray.put(str12);
                            }
                            jSONObject.put("sticker_id", jSONArray);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getBeautifyListInfo())) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (String str13 : videoInfo.getBeautifyListInfo()) {
                                jSONArray2.put(str13);
                            }
                            jSONObject.put("beautify_level", jSONArray2);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getFilterListInfo())) {
                            JSONArray jSONArray3 = new JSONArray();
                            for (String str14 : videoInfo.getFilterListInfo()) {
                                jSONArray3.put(str14);
                            }
                            jSONObject.put("filter_id", jSONArray3);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getMusicListInfo())) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String str15 : videoInfo.getMusicListInfo()) {
                                jSONArray4.put(str15);
                            }
                            jSONObject.put("music_id", jSONArray4);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.f19995a.addPostData("video_other", jSONObject.toString());
                }
                h.a("发帖：上传视频结束 完全完成 ");
                if (this.f19997c) {
                    return null;
                }
                h.a("发帖：其他数据设置开始 ");
                this.f19995a.addPostData("anonymous", "1");
                this.f19995a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                this.f19995a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                this.f19995a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                this.f19995a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
                if (returnVoiceMd5 != null) {
                    this.f19995a.addPostData("voice_md5", returnVoiceMd5);
                    this.f19995a.addPostData("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getType() != 6) {
                    if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str) && writeData.getVideoInfo() == null) {
                        this.f19996b.setError_code(-53);
                        this.f19996b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                    if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                        this.f19996b.setError_code(-53);
                        this.f19996b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.f19995a.addPostData("vcode", writeData.getVcode());
                }
                if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                    this.f19995a.addPostData("vcode_md5", writeData.getVcodeMD5());
                }
                if (!StringUtils.isNull(writeData.getVcodeType())) {
                    this.f19995a.addPostData("vcode_type", writeData.getVcodeType());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.f19995a.addPostData("vcode_tag", "12");
                }
                Address h2 = c.a.e.e.i.a.l().h(false);
                if (!TextUtils.isEmpty(writeData.getTopicId())) {
                    this.f19995a.addPostData("topic_id", writeData.getTopicId());
                }
                this.f19995a.addPostData("new_vcode", "1");
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload()) {
                    String buildContent = writeData.getVideoInfo().buildContent();
                    title = writeData.getTitle();
                    str4 = buildContent + imagesCodeForPost;
                    StringBuilder sb = new StringBuilder();
                    str2 = str;
                    sb.append(str2);
                    sb.append(imagesCodeForPost);
                    str3 = sb.toString();
                    writeData.setIsNoTitle(k.isEmpty(title));
                } else {
                    str2 = str;
                    str3 = null;
                    str4 = str2 + imagesCodeForPost;
                    title = writeData.getTitle();
                }
                String voteContentForPost = writeData.getVoteContentForPost();
                if (!StringUtils.isNull(voteContentForPost)) {
                    str4 = str4 + voteContentForPost;
                }
                EmotionUtil.statisticsEmotionUse(str4);
                String b2 = c.a.p0.p0.a.b(str4);
                if (!TextUtils.isEmpty(str3)) {
                    str3 = c.a.p0.p0.a.b(str3);
                }
                String str16 = str3;
                this.f19995a.addPostData("content", b2);
                this.f19995a.addPostData("reply_uid", writeData.getReplyId());
                if (!TextUtils.isEmpty(writeData.getMemeText())) {
                    this.f19995a.addPostData("meme_text", writeData.getMemeText());
                }
                if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                    this.f19995a.addPostData("meme_cont_sign", writeData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(writeData.getItem_id())) {
                    this.f19995a.addPostData("item_id", writeData.getItem_id());
                }
                if (!TextUtils.isEmpty(writeData.getComment_head())) {
                    this.f19995a.addPostData("comment_head", writeData.getComment_head());
                }
                if (writeData.getClassAndTagData() != null && !TextUtils.isEmpty(writeData.getClassAndTagData().g())) {
                    this.f19995a.addPostData("works_tag", writeData.getClassAndTagData().g());
                }
                h.a("设置数据");
                int type = writeData.getType();
                str5 = str2;
                if (type != 0) {
                    str6 = title;
                    if (type != 1) {
                        str7 = TiebaStatic.Params.UGC_TYPE;
                        str8 = "1";
                        if (type == 2) {
                            this.f19995a.setUrl(l);
                            this.f19995a.addPostData("fid", writeData.getForumId());
                            this.f19995a.addPostData("from_fourm_id", writeData.getFromForumId());
                            this.f19995a.addPostData("v_fid", writeData.getVForumId());
                            this.f19995a.addPostData("v_fname", writeData.getVForumName());
                            this.f19995a.addPostData("tid", writeData.getThreadId());
                            this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            this.f19995a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                            this.f19995a.addPostData("is_twzhibo_thread", String.valueOf(0));
                            this.f19995a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                            if (writeData.getRepostId() != null) {
                                this.f19995a.addPostData("repostid", writeData.getRepostId());
                            }
                            this.f19995a.addPostData("is_ad", writeData.getIsAd() ? str8 : "0");
                            this.f19995a.addPostData("is_addition", writeData.isAddition() ? str8 : "0");
                            this.f19995a.addPostData("is_giftpost", writeData.isGiftPost() ? str8 : "0");
                            this.f19995a.addPostData("is_giftpost", writeData.isGiftPost() ? str8 : "0");
                            if (writeData.isAddition()) {
                                this.f19995a.addPostData("st_type", "conadd");
                            }
                            if (!StringUtils.isNull(writeData.sourceFrom)) {
                                this.f19995a.addPostData("post_from", writeData.sourceFrom);
                            }
                            if (writeData.getBaijiahaoData() != null) {
                                this.f19995a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                                this.f19995a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                                this.f19995a.addPostData(str7, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                                this.f19995a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                            }
                        } else if (type == 4) {
                            this.f19995a.setUrl(k);
                            this.f19995a.addPostData("fid", writeData.getForumId());
                            this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            if (!TextUtils.isEmpty(writeData.getTitle())) {
                                this.f19995a.addPostData("title", writeData.getTitle());
                            }
                            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                this.f19995a.addPostData("post_prefix", writeData.getPostPrefix());
                            }
                            this.f19995a.addPostData("thread_type", EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL);
                            m.a(this.f19995a, writeData);
                        } else if (type == 5) {
                            this.f19995a.setUrl(l);
                            this.f19995a.addPostData("fid", writeData.getForumId());
                            this.f19995a.addPostData("tid", writeData.getThreadId());
                            this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            this.f19995a.addPostData("is_twzhibo_thread", String.valueOf(1));
                            if (writeData.getBaijiahaoData() != null) {
                                this.f19995a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                                this.f19995a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                                this.f19995a.addPostData(str7, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                                this.f19995a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                            }
                            m.a(this.f19995a, writeData);
                        } else if (type == 6) {
                            this.f19995a.setUrl(k);
                            this.f19995a.addPostData("fid", writeData.getForumId());
                            this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            this.f19995a.addPostData("thread_type", String.valueOf(36));
                            if (!TextUtils.isEmpty(writeData.getTitle())) {
                                this.f19995a.addPostData("title", writeData.getTitle());
                            }
                            if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                this.f19995a.addPostData("post_prefix", writeData.getPostPrefix());
                            }
                            this.f19995a.addPostData("is_ntitle", writeData.isNoTitle() ? str8 : "0");
                            if (writeData.isNoTitle()) {
                                this.f19995a.addPostData("st_type", "notitle");
                            }
                            m.a(this.f19995a, writeData);
                        } else if (type != 7 && type != 9) {
                            if (writeData.isCanNoForum()) {
                                this.f19995a.addPostData("fid", "0");
                                this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                                this.f19995a.addPostData("transform_forums", writeData.getTransmitForumData());
                            } else {
                                this.f19995a.addPostData("fid", writeData.getForumId());
                                this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                            }
                        }
                    } else {
                        str8 = "1";
                        this.f19995a.setUrl(l);
                        this.f19995a.addPostData("fid", writeData.getForumId());
                        this.f19995a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.f19995a.addPostData("v_fid", writeData.getVForumId());
                        this.f19995a.addPostData("v_fname", writeData.getVForumName());
                        this.f19995a.addPostData("tid", writeData.getThreadId());
                        this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.f19995a.addPostData("is_ad", writeData.getIsAd() ? str8 : "0");
                        this.f19995a.addPostData("is_barrage", writeData.isBarrage() ? str8 : "0");
                        this.f19995a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                        if (writeData.isFrsReply()) {
                            this.f19995a.addPostData("st_param", "frs");
                        }
                        if (c.a.o0.x.w.a.a().b() == 1) {
                            this.f19995a.addPostData("ptype", "4");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.f19995a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.f19995a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.f19995a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.f19995a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.f19995a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        m.a(this.f19995a, writeData);
                    }
                    str11 = str8;
                    str9 = imagesCodeForPost;
                } else {
                    str6 = title;
                    str7 = TiebaStatic.Params.UGC_TYPE;
                    str8 = "1";
                }
                this.f19995a.setUrl(k);
                if (writeData.isCanNoForum()) {
                    this.f19995a.addPostData("fid", "0");
                    this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                    this.f19995a.addPostData("transform_forums", writeData.getTransmitForumData());
                } else {
                    this.f19995a.addPostData("fid", writeData.getForumId());
                    this.f19995a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                }
                this.f19995a.addPostData("is_hide", writeData.isPrivacy() ? str8 : "0");
                this.f19995a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? str8 : "0");
                if (writeData.getVideoId() != null) {
                    this.f19995a.addPostData("video_id", writeData.getVideoId());
                    if (writeData.getOriginalVideoCover() != null) {
                        this.f19995a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                    }
                    if (writeData.getOriginalVideoTitle() != null) {
                        this.f19995a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                    }
                }
                if (writeData.isShareThread()) {
                    str11 = str8;
                    this.f19995a.addPostData("is_share", str11);
                    this.f19995a.addPostData("from_tid", writeData.getOriginalThreadId());
                } else {
                    str11 = str8;
                }
                if (writeData.getProZone() >= 0) {
                    this.f19995a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
                }
                this.f19995a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
                if (!TextUtils.isEmpty(str6)) {
                    this.f19995a.addPostData("title", str6);
                }
                if (!TextUtils.isEmpty(str16)) {
                    this.f19995a.addPostData("video_abstract", str16);
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.f19995a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.f19995a.addPostData("is_ntitle", writeData.isNoTitle() ? str11 : "0");
                if (writeData.isNoTitle()) {
                    this.f19995a.addPostData("st_type", "notitle");
                }
                if (h2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                    this.f19995a.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                }
                m.a(this.f19995a, writeData);
                if (writeData.getCategoryFrom() >= 0) {
                    this.f19995a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                }
                if (writeData.getCategoryTo() >= 0) {
                    this.f19995a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                }
                if (writeData.getType() == 7) {
                    this.f19995a.addPostData("is_bottle", String.valueOf(1));
                }
                if (writeData.getRecommendExt() != null) {
                    this.f19995a.addPostData("recommend_ext", writeData.getRecommendExt());
                }
                if (writeData.isLinkThread()) {
                    this.f19995a.addPostData("link_url", writeData.getLinkUrl());
                    this.f19995a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                }
                this.f19995a.addPostData("is_link_thread", writeData.isLinkThread() ? str11 : "0");
                if (writeData.isShareThread()) {
                    if (writeData.getOriBaijiahaoData() != null) {
                        this.f19995a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                        this.f19995a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                        this.f19995a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                        this.f19995a.addPostData(str7, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                    }
                } else if (writeData.getBaijiahaoData() != null) {
                    this.f19995a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.f19995a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    this.f19995a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.f19995a.addPostData(str7, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                }
                if (writeData.getTabId() > 0) {
                    this.f19995a.addPostData("tab_name", writeData.getTabName());
                    this.f19995a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                    this.f19995a.addPostData(FrsCommonTabFragment.IS_GENERAL_TAB, String.valueOf(writeData.getIsGeneralTab()));
                }
                this.f19995a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? str11 : "0");
                str9 = imagesCodeForPost;
            }
            if (writeData.isPostLatLng()) {
                String lat = writeData.getLat() == null ? "" : writeData.getLat();
                String lng = writeData.getLng() != null ? writeData.getLng() : "";
                this.f19995a.addPostData("real_lat", lat);
                this.f19995a.addPostData("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.f19995a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (writeData.isWork()) {
                this.f19995a.addPostData("is_works", str11);
            }
            h.a("发帖：其他数据设置开始 发送");
            k1.h(writeData, 93).f(true);
            String postNetData = this.f19995a.postNetData();
            h.a("发帖：其他数据设置开始 结束 进度到 95");
            k1.h(writeData, 95).f(true);
            f(95);
            if (this.f19995a.getNetContext().getResponse().isRequestSuccess()) {
                this.f19996b.parserJson(postNetData);
            } else {
                this.f19996b.setError_code(this.f19995a.isNetSuccess() ? this.f19995a.getServerErrorCode() : this.f19995a.getNetErrorCode());
                this.f19996b.setError_msg(this.f19995a.getErrorString());
            }
            if (this.f19996b.error_code != 0 && !j.z()) {
                this.f19996b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            } else if (this.f19996b.error_code != 0 && writeData.isHasImages()) {
                if (k.isEmpty(str5 + str9)) {
                    this.f19996b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
                }
            }
            try {
                AntiData antiData = new AntiData();
                this.f19998d = antiData;
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception unused) {
            }
            if (this.f19998d.getBlock_stat() == 0 && this.f19996b.error_code == 0 && this.f19995a.getNetContext() != null && this.f19995a.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.f19995a.getNetContext().getRequest().getNetWorkParam()));
            }
            f(100);
            h.a("发帖：处理整个 发帖过程 结束数据 完成 进度到 100");
            return postNetData;
        }
        return (String) invokeLZ.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f20001g = cVar;
        }
    }

    public void j(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupManager) == null) {
            this.f20003i = spanGroupManager;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f20004j = str;
        }
    }

    public void l(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f20002h = gVar;
        }
    }
}
