package c.a.r0.t3.k0;

import android.location.Address;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.k;
import c.a.q0.d0.f;
import c.a.q0.s.q.l1;
import c.a.q0.t.c.r;
import c.a.q0.t.c.s;
import c.a.r0.g2.g;
import c.a.r0.t3.q0.d.e;
import c.a.r0.t3.s0.d;
import c.a.r0.t3.s0.h;
import c.a.r0.t3.s0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.UploadPicParallelSwitch;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final String f23854k;
    public static final String l;
    public static final String m;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;

    /* renamed from: b  reason: collision with root package name */
    public ErrorData f23855b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23856c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f23857d;

    /* renamed from: e  reason: collision with root package name */
    public f f23858e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.t3.q0.a f23859f;

    /* renamed from: g  reason: collision with root package name */
    public c f23860g;

    /* renamed from: h  reason: collision with root package name */
    public g f23861h;

    /* renamed from: i  reason: collision with root package name */
    public SpanGroupManager f23862i;

    /* renamed from: j  reason: collision with root package name */
    public String f23863j;

    /* renamed from: c.a.r0.t3.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1368a implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteImagesInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f23864b;

        public C1368a(a aVar, WriteImagesInfo writeImagesInfo, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, writeImagesInfo, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeImagesInfo;
            this.f23864b = writeData;
        }

        @Override // c.a.q0.d0.f.b
        public void a(String str, Object obj, long j2, long j3, int i2, int i3) {
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                h.a("发帖：发送图片 进度 = " + i2 + "/" + i3 + " :" + j2 + "/" + j3 + "   ，" + str);
                WriteImagesInfo writeImagesInfo = this.a;
                if (writeImagesInfo == null || (i4 = writeImagesInfo.hasUploadFileSize) <= 0 || (i5 = writeImagesInfo.allImageFileSize) <= 0) {
                    return;
                }
                float f2 = (i4 * 1.0f) / i5;
                l1.g(this.f23864b, (int) ((f2 <= 1.0f ? f2 : 1.0f) * 90.0f)).f(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WriteData f23865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f23866c;

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
            this.f23866c = aVar;
            this.f23865b = writeData;
            this.a = 0;
        }

        @Override // c.a.r0.t3.q0.d.e
        public void onProgressUpdate(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                h.a("发帖：开始上传视频 percent = " + f2);
                int i2 = (int) (f2 * 90.0f);
                l1.g(this.f23865b, i2).f(true);
                if (i2 != this.a) {
                    this.a = i2;
                    this.f23866c.f(i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1046759199, "Lc/a/r0/t3/k0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1046759199, "Lc/a/r0/t3/k0/a;");
                return;
            }
        }
        f23854k = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
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
        this.a = null;
        this.f23855b = null;
        this.f23856c = false;
        this.f23855b = new ErrorData();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23856c = true;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            f fVar = this.f23858e;
            if (fVar != null) {
                fVar.a();
            }
            c.a.r0.t3.q0.a aVar = this.f23859f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23857d : (AntiData) invokeV.objValue;
    }

    public ErrorData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23855b : (ErrorData) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetWork netWork = this.a;
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
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (cVar = this.f23860g) == null) {
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
            if (this.f23858e == null) {
                this.f23858e = new f("HTTPWriteService.postImageData");
            }
            return this.f23858e.i(imageFileInfo, z);
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
        String title;
        String str4;
        String str5;
        String str6;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, writeData, z)) == null) {
            String str7 = null;
            if (writeData == null) {
                return null;
            }
            h.a("发帖：postWriteData 开始");
            NetWork netWork = new NetWork();
            this.a = netWork;
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            this.a.setNeedSig(true);
            this.a.addPostData("authsid", writeData.getAuthSid());
            if (!TextUtils.isEmpty(this.f23863j)) {
                content = this.f23863j;
                writeData.setSpanGroupString(content);
            } else {
                SpanGroupManager spanGroupManager = this.f23862i;
                if (spanGroupManager != null) {
                    content = spanGroupManager.C();
                    writeData.setSpanGroupString(content);
                } else if (!TextUtils.isEmpty(writeData.getSpanGroupString())) {
                    content = writeData.getSpanGroupString();
                } else {
                    content = writeData.getContent();
                }
            }
            if (writeData.getPortrait() != null && writeData.getName() != null && writeData.getSubPbReplyPrefix() != null) {
                content = "回复 #(reply, " + writeData.getPortrait() + StringUtil.ARRAY_ELEMENT_SEPARATOR + writeData.getName() + ") :" + content;
            } else if (writeData.getSubPbReplyPrefix() != null) {
                content = writeData.getSubPbReplyPrefix() + content;
            }
            if (!TextUtils.isEmpty(writeData.getZhongcePrefix())) {
                content = writeData.getZhongcePrefix() + content;
            }
            String str8 = content;
            h.a("发帖：发帖类型：" + writeData.getType());
            String str9 = "1";
            if (writeData.getType() == 3) {
                h.a("发帖：SHARE_SDK：设置数据");
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.a.addPostData("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.a.addPostData("tag", "11");
                }
                this.a.addPostData("newVcode", "1");
                this.a.addPostData("content", str8);
                this.a.setUrl(m);
                this.a.addPostData("fname", writeData.getForumName());
                if (!TextUtils.isEmpty(writeData.getTitle())) {
                    this.a.addPostData("title", writeData.getTitle());
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.a.addPostData("apiKey", writeData.getShareApiKey());
                this.a.addPostData("appName", writeData.getShareAppName());
                this.a.addPostData("signKey", writeData.getShareSignKey());
                this.a.addPostData("summary_title", writeData.getShareSummaryTitle());
                this.a.addPostData("summary_content", writeData.getShareSummaryContent());
                this.a.addPostData("summary_img", writeData.getShareSummaryImg());
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.a.addPostData(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.a.addPostData("referUrl", writeData.getShareReferUrl());
                str4 = str8;
            } else {
                h.a("发帖：开始分段数据发送");
                if (z && writeData.isHasImages()) {
                    WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
                    if (writeImagesInfo != null) {
                        writeImagesInfo.needImageParallel = UploadPicParallelSwitch.isOn();
                        writeImagesInfo.imageChunkSize = c.a.q0.s.e0.b.j().k("key_upload_pic_chunk_size", 0);
                        writeImagesInfo.imageUploadConcurrency = c.a.q0.s.e0.b.j().k("key_upload_pic_parallel_count", 0);
                        writeImagesInfo.imageChunkRetry = c.a.q0.s.e0.b.j().k("key_upload_pic_chunk_retry", 0);
                        if (writeImagesInfo.imageUploadConcurrency < 1) {
                            writeImagesInfo.imageUploadConcurrency = 1;
                        }
                    }
                    d.n(writeData);
                    h.a("发帖：发送图片 开始");
                    if (this.f23858e == null) {
                        f fVar = new f("HTTPWriteService.postWriteData");
                        this.f23858e = fVar;
                        fVar.h(writeData);
                        this.f23858e.e(new C1368a(this, writeImagesInfo, writeData), writeData);
                    }
                    if (writeData.startPublishTime() > 0 && writeImagesInfo != null) {
                        if (writeImagesInfo.needImageParallel) {
                            this.f23858e.b(104857600);
                        } else {
                            int i2 = writeImagesInfo.imageChunkSize;
                            if (i2 > 9) {
                                this.f23858e.b(i2 * 1024);
                            } else {
                                this.f23858e.b(512000);
                            }
                        }
                    }
                    if (writeData.getType() == 6) {
                        h.a("发帖：发送图片 上传图片 开始 1");
                        ErrorData p = this.f23858e.p(writeData.getWriteImagesInfo(), true);
                        if (p != null) {
                            this.f23855b.setError_code(p.getError_code());
                            this.f23855b.setError_msg(p.getError_msg());
                            h.a("发帖：发送图片 上传图片 错误 1");
                            d.e(writeData, p);
                            return null;
                        }
                        h.a("发帖：发送图片 上传图片 完成 1");
                    } else {
                        h.a("发帖：发送图片 上传图片 开始 2");
                        this.f23858e.m = writeData.isBJHPost();
                        ErrorData p2 = this.f23858e.p(writeData.getWriteImagesInfo(), true);
                        if (p2 != null) {
                            this.f23855b.setError_code(p2.getError_code());
                            this.f23855b.setError_msg(p2.getError_msg());
                            h.a("发帖：发送图片 上传图片 错误 2");
                            d.e(writeData, p2);
                            return null;
                        }
                        h.a("发帖：发送图片 上传图片 完成 2");
                    }
                    d.e(writeData, null);
                }
                if (this.f23856c) {
                    this.f23855b.setError_code(-54);
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
                    str = returnVoiceMd5;
                } else {
                    h.a("发帖：发送声音 开始");
                    c.a.q0.s.h0.c.b bVar = new c.a.q0.s.h0.c.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                    bVar.a("type", 1);
                    String storeFile = FileHelper.getStoreFile(voice, 1);
                    d.r(writeData, FileHelper.getFileSize(storeFile));
                    s d2 = bVar.d(storeFile);
                    if (d2 != null && d2.d()) {
                        r a = d2.a();
                        if (a != null) {
                            String b2 = a.b();
                            c.a.q0.s.h0.b.b.b(writeData.getVoice(), b2);
                            writeData.setReturnVoiceMd5(b2);
                            d.i(writeData, d2);
                            h.a("发帖：发送声音 完成 1");
                            str = b2;
                        } else {
                            FieldBuilder fieldBuilder = new FieldBuilder();
                            fieldBuilder.append("ErrCode", Integer.valueOf(d2.b()));
                            fieldBuilder.append("ErrMsg", d2.c());
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", fieldBuilder.toString());
                            this.f23855b.setError_code(d2.b());
                            this.f23855b.setError_msg(d2.c());
                            h.a("发帖：发送声音 失败 1");
                            d.i(writeData, d2);
                            return null;
                        }
                    } else {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("audioFile", storeFile);
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", fieldBuilder2.toString());
                        if (d2 != null) {
                            this.f23855b.setError_code(d2.b());
                            this.f23855b.setError_msg(d2.c());
                        }
                        d.i(writeData, d2);
                        h.a("发帖：发送声音 失败 2");
                        return null;
                    }
                }
                if (this.f23856c) {
                    this.f23855b.setError_code(-54);
                    return null;
                }
                VideoInfo videoInfo = writeData.getVideoInfo();
                if (videoInfo != null) {
                    if (videoInfo.needUploadVideo()) {
                        d.p(writeData, videoInfo);
                        this.f23859f = new c.a.r0.t3.q0.a(this.f23861h);
                        h.a("发帖：开始上传视频");
                        VideoFinishResult e2 = this.f23859f.e(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this, writeData));
                        d.g(writeData, e2);
                        if (e2 == null) {
                            this.f23855b.setError_code(-53);
                            this.f23855b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                            h.a("发帖：开始上传视频 失败 1");
                            return null;
                        } else if (e2.isSuccess()) {
                            videoInfo.setVideoMd5(e2.getVideoMd5());
                            videoInfo.setVideoUrl(e2.getVideoUrl());
                            h.a("发帖：开始上传视频 成功 ");
                        } else {
                            this.f23855b.setError_code(e2.getErrorNo());
                            this.f23855b.setError_msg(e2.getUserMessage());
                            h.a("发帖：开始上传视频 失败 2");
                            return null;
                        }
                    }
                    if (videoInfo.needUploadThunmb()) {
                        h.a("发帖：开始上传首帧图 开始 ");
                        if (this.f23858e == null) {
                            f fVar2 = new f("HTTPWriteService.postWriteData");
                            this.f23858e = fVar2;
                            fVar2.h(writeData);
                        }
                        d.q(writeData, videoInfo.getThumbPath());
                        ImageUploadResult l2 = this.f23858e.l(videoInfo.getThumbPath(), false);
                        d.h(writeData, l2);
                        if (l2 != null) {
                            videoInfo.setThumbId(l2.picId);
                            ImageUploadResult.picInfo picinfo = l2.picInfo;
                            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                                c.a.r0.t3.s0.g.j().C(l2.picInfo.bigPic.picUrl);
                            }
                        }
                        h.a("发帖：开始上传首帧图 完成 ");
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!ListUtils.isEmpty(videoInfo.getStickListInfo())) {
                            JSONArray jSONArray = new JSONArray();
                            for (String str10 : videoInfo.getStickListInfo()) {
                                jSONArray.put(str10);
                            }
                            jSONObject.put("sticker_id", jSONArray);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getBeautifyListInfo())) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (String str11 : videoInfo.getBeautifyListInfo()) {
                                jSONArray2.put(str11);
                            }
                            jSONObject.put("beautify_level", jSONArray2);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getFilterListInfo())) {
                            JSONArray jSONArray3 = new JSONArray();
                            for (String str12 : videoInfo.getFilterListInfo()) {
                                jSONArray3.put(str12);
                            }
                            jSONObject.put("filter_id", jSONArray3);
                        }
                        if (!ListUtils.isEmpty(videoInfo.getMusicListInfo())) {
                            JSONArray jSONArray4 = new JSONArray();
                            for (String str13 : videoInfo.getMusicListInfo()) {
                                jSONArray4.put(str13);
                            }
                            jSONObject.put("music_id", jSONArray4);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.a.addPostData("video_other", jSONObject.toString());
                }
                h.a("发帖：上传视频结束 完全完成 ");
                if (this.f23856c) {
                    this.f23855b.setError_code(-54);
                    return null;
                }
                h.a("发帖：其他数据设置开始 ");
                this.a.addPostData("anonymous", "1");
                this.a.addPostData("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                this.a.addPostData("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                this.a.addPostData("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                this.a.addPostData("entrance_type", String.valueOf(writeData.getEntranceType()));
                if (str != null) {
                    this.a.addPostData("voice_md5", str);
                    this.a.addPostData("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getType() != 6) {
                    if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str8) && writeData.getVideoInfo() == null) {
                        this.f23855b.setError_code(-53);
                        this.f23855b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                    if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(str8) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread() && writeData.getWriteVoteData() == null) {
                        this.f23855b.setError_code(-53);
                        this.f23855b.setError_msg(TbadkCoreApplication.getInst().getString(R.string.sand_fail));
                        return null;
                    }
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.a.addPostData("vcode", writeData.getVcode());
                }
                if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                    this.a.addPostData("vcode_md5", writeData.getVcodeMD5());
                }
                if (!StringUtils.isNull(writeData.getVcodeType())) {
                    this.a.addPostData("vcode_type", writeData.getVcodeType());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.a.addPostData("vcode_tag", "12");
                }
                Address j2 = c.a.d.f.i.a.n().j(false);
                if (!TextUtils.isEmpty(writeData.getTopicId())) {
                    this.a.addPostData("topic_id", writeData.getTopicId());
                }
                this.a.addPostData("new_vcode", "1");
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload()) {
                    String buildContent = writeData.getVideoInfo().buildContent();
                    title = writeData.getTitle();
                    str3 = buildContent + imagesCodeForPost;
                    str2 = str8 + imagesCodeForPost;
                    writeData.setIsNoTitle(k.isEmpty(title));
                } else {
                    str2 = null;
                    str3 = str8 + imagesCodeForPost;
                    title = writeData.getTitle();
                }
                String voteContentForPost = writeData.getVoteContentForPost();
                if (!StringUtils.isNull(voteContentForPost)) {
                    str3 = str3 + voteContentForPost;
                }
                EmotionUtil.statisticsEmotionUse(str3);
                String c2 = c.a.r0.x0.a.c(str3);
                if (!TextUtils.isEmpty(str2)) {
                    str2 = c.a.r0.x0.a.c(str2);
                }
                if (writeData.getItemDatas() != null && writeData.getItemDatas().size() > 0) {
                    c2 = c2 + writeData.getAssociatedItemsForPost();
                }
                this.a.addPostData("content", c2);
                this.a.addPostData("reply_uid", writeData.getReplyId());
                if (!TextUtils.isEmpty(writeData.getMemeText())) {
                    this.a.addPostData("meme_text", writeData.getMemeText());
                }
                if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                    this.a.addPostData("meme_cont_sign", writeData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(writeData.getItem_id())) {
                    this.a.addPostData("item_id", writeData.getItem_id());
                }
                if (!TextUtils.isEmpty(writeData.getComment_head())) {
                    this.a.addPostData("comment_head", writeData.getComment_head());
                }
                if (writeData.getClassAndTagData() != null && !TextUtils.isEmpty(writeData.getClassAndTagData().toPostJson())) {
                    this.a.addPostData("works_tag", writeData.getClassAndTagData().toPostJson());
                }
                h.a("设置数据");
                int type = writeData.getType();
                str4 = str8;
                String str14 = str2;
                if (type != 0) {
                    str6 = title;
                    str5 = "1";
                    if (type == 1) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.a.addPostData("v_fid", writeData.getVForumId());
                        this.a.addPostData("v_fname", writeData.getVForumName());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("is_ad", writeData.getIsAd() ? str5 : "0");
                        this.a.addPostData("is_barrage", writeData.isBarrage() ? str5 : "0");
                        this.a.addPostData("barrage_time", String.valueOf(writeData.getBarrageTime()));
                        if (writeData.isFrsReply()) {
                            this.a.addPostData("st_param", "frs");
                        }
                        if (c.a.q0.x.x.a.a().b() == 1) {
                            this.a.addPostData("ptype", "4");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        m.a(this.a, writeData);
                    } else if (type == 2) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("from_fourm_id", writeData.getFromForumId());
                        this.a.addPostData("v_fid", writeData.getVForumId());
                        this.a.addPostData("v_fname", writeData.getVForumName());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("quote_id", String.valueOf(writeData.getFloor()));
                        this.a.addPostData("is_twzhibo_thread", String.valueOf(0));
                        this.a.addPostData("floor_num", String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.a.addPostData("repostid", writeData.getRepostId());
                        }
                        this.a.addPostData("is_ad", writeData.getIsAd() ? str5 : "0");
                        this.a.addPostData("is_addition", writeData.isAddition() ? str5 : "0");
                        this.a.addPostData("is_giftpost", writeData.isGiftPost() ? str5 : "0");
                        this.a.addPostData("is_giftpost", writeData.isGiftPost() ? str5 : "0");
                        if (writeData.isAddition()) {
                            this.a.addPostData("st_type", "conadd");
                        }
                        if (!StringUtils.isNull(writeData.sourceFrom)) {
                            this.a.addPostData("post_from", writeData.sourceFrom);
                        }
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                    } else if (type == 4) {
                        this.a.setUrl(f23854k);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.a.addPostData("post_prefix", writeData.getPostPrefix());
                        }
                        this.a.addPostData("thread_type", "33");
                        m.a(this.a, writeData);
                    } else if (type == 5) {
                        this.a.setUrl(l);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData("tid", writeData.getThreadId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("is_twzhibo_thread", String.valueOf(1));
                        if (writeData.getBaijiahaoData() != null) {
                            this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                            this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                            this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                            this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                        }
                        m.a(this.a, writeData);
                    } else if (type == 6) {
                        this.a.setUrl(f23854k);
                        this.a.addPostData("fid", writeData.getForumId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        this.a.addPostData("thread_type", String.valueOf(36));
                        if (!TextUtils.isEmpty(writeData.getTitle())) {
                            this.a.addPostData("title", writeData.getTitle());
                        }
                        if (!StringUtils.isNull(writeData.getPostPrefix())) {
                            this.a.addPostData("post_prefix", writeData.getPostPrefix());
                        }
                        this.a.addPostData("is_ntitle", writeData.isNoTitle() ? str5 : "0");
                        if (writeData.isNoTitle()) {
                            this.a.addPostData("st_type", "notitle");
                        }
                        m.a(this.a, writeData);
                    } else if (type != 7 && type != 9) {
                        if (writeData.isCanNoForum()) {
                            this.a.addPostData("fid", "0");
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                            this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                        } else {
                            this.a.addPostData("fid", writeData.getForumId());
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                        }
                    }
                    str9 = str5;
                    str7 = imagesCodeForPost;
                } else {
                    str5 = "1";
                    str6 = title;
                }
                this.a.setUrl(f23854k);
                m(writeData);
                if (writeData.isCanNoForum()) {
                    this.a.addPostData("fid", "0");
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, "");
                    this.a.addPostData("transform_forums", writeData.getTransmitForumData());
                } else {
                    this.a.addPostData("fid", writeData.getForumId());
                    this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, writeData.getForumName());
                }
                this.a.addPostData("is_hide", writeData.isPrivacy() ? str5 : "0");
                this.a.addPostData("is_repost_to_dynamic", writeData.isToDynamic() ? str5 : "0");
                if (writeData.getVideoId() != null) {
                    this.a.addPostData("video_id", writeData.getVideoId());
                    if (writeData.getOriginalVideoCover() != null) {
                        this.a.addPostData("origin_video_cover", writeData.getOriginalVideoCover());
                    }
                    if (writeData.getOriginalVideoTitle() != null) {
                        this.a.addPostData("origin_video_title", writeData.getOriginalVideoTitle());
                    }
                }
                if (writeData.isShareThread()) {
                    str9 = str5;
                    this.a.addPostData("is_share", str9);
                    this.a.addPostData("from_tid", writeData.getOriginalThreadId());
                } else {
                    str9 = str5;
                }
                if (writeData.getProZone() >= 0) {
                    this.a.addPostData(EditVideoActivityConfig.KEY_PRO_ZONE, String.valueOf(writeData.getProZone()));
                }
                this.a.addPostData(IntentConfig.CALL_FROM, writeData.getStatisticFrom() + "");
                if (!TextUtils.isEmpty(str6)) {
                    this.a.addPostData("title", str6);
                }
                if (!TextUtils.isEmpty(str14)) {
                    this.a.addPostData(AlbumFloatActivityConfig.VIDEO_ABSTRACT, str14);
                }
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.a.addPostData("post_prefix", writeData.getPostPrefix());
                }
                this.a.addPostData("is_ntitle", writeData.isNoTitle() ? str9 : "0");
                if (writeData.isNoTitle()) {
                    this.a.addPostData("st_type", "notitle");
                }
                if (j2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                    this.a.addPostData("lbs", String.valueOf(j2.getLatitude()) + "," + String.valueOf(j2.getLongitude()));
                }
                m.a(this.a, writeData);
                if (writeData.getCategoryFrom() >= 0) {
                    this.a.addPostData("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                }
                if (writeData.getCategoryTo() >= 0) {
                    this.a.addPostData("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                }
                if (writeData.getType() == 7) {
                    this.a.addPostData("is_bottle", String.valueOf(1));
                }
                if (writeData.getRecommendExt() != null) {
                    this.a.addPostData("recommend_ext", writeData.getRecommendExt());
                }
                if (writeData.isLinkThread()) {
                    this.a.addPostData("link_url", writeData.getLinkUrl());
                    this.a.addPostData("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                }
                this.a.addPostData("is_link_thread", writeData.isLinkThread() ? str9 : "0");
                if (writeData.isShareThread()) {
                    if (writeData.getOriBaijiahaoData() != null) {
                        this.a.addPostData("ori_ugc_nid", writeData.getOriBaijiahaoData().oriUgcNid);
                        this.a.addPostData("ori_ugc_vid", writeData.getOriBaijiahaoData().oriUgcVid);
                        this.a.addPostData("ori_ugc_tid", writeData.getOriBaijiahaoData().oriUgcTid);
                        this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getOriBaijiahaoData().oriUgcType));
                    }
                } else if (writeData.getBaijiahaoData() != null) {
                    this.a.addPostData("ori_ugc_nid", writeData.getBaijiahaoData().oriUgcNid);
                    this.a.addPostData("ori_ugc_vid", writeData.getBaijiahaoData().oriUgcVid);
                    this.a.addPostData("ori_ugc_tid", writeData.getBaijiahaoData().oriUgcTid);
                    this.a.addPostData(TiebaStatic.Params.UGC_TYPE, String.valueOf(writeData.getBaijiahaoData().oriUgcType));
                }
                if (writeData.getTabId() > 0) {
                    this.a.addPostData("tab_name", writeData.getTabName());
                    this.a.addPostData("tab_id", String.valueOf(writeData.getTabId()));
                    this.a.addPostData(FrsCommonTabFragment.IS_GENERAL_TAB, String.valueOf(writeData.getIsGeneralTab()));
                }
                this.a.addPostData("is_forum_business_account", writeData.isForumBusinessAccount ? str9 : "0");
                str7 = imagesCodeForPost;
            }
            if (writeData.isPostLatLng()) {
                String lat = writeData.getLat() == null ? "" : writeData.getLat();
                String lng = writeData.getLng() != null ? writeData.getLng() : "";
                this.a.addPostData("real_lat", lat);
                this.a.addPostData("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.a.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (writeData.isWork()) {
                this.a.addPostData("is_works", str9);
            }
            h.a("发帖：其他数据设置开始 发送");
            l1.g(writeData, 93).f(true);
            String postNetData = this.a.postNetData();
            h.a("发帖：其他数据设置开始 结束 进度到 95");
            l1.g(writeData, 95).f(true);
            f(95);
            if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                this.f23855b.parserJson(postNetData);
            } else {
                this.f23855b.setError_code(this.a.isNetSuccess() ? this.a.getServerErrorCode() : this.a.getNetErrorCode());
                this.f23855b.setError_msg(this.a.getErrorString());
            }
            if (this.f23855b.error_code != 0 && !j.z()) {
                this.f23855b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            } else if (this.f23855b.error_code != 0 && writeData.isHasImages()) {
                if (k.isEmpty(str4 + str7)) {
                    this.f23855b.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.img_upload_error));
                }
            }
            try {
                AntiData antiData = new AntiData();
                this.f23857d = antiData;
                antiData.parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception unused) {
            }
            if (this.f23857d.getBlock_stat() == 0 && this.f23855b.error_code == 0 && this.a.getNetContext() != null && this.a.getNetContext().getRequest() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.a.getNetContext().getRequest().getNetWorkParam()));
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
            this.f23860g = cVar;
        }
    }

    public void j(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spanGroupManager) == null) {
            this.f23862i = spanGroupManager;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f23863j = str;
        }
    }

    public void l(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.f23861h = gVar;
        }
    }

    public void m(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, writeData) == null) || writeData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_POST_THREAD_AT_USE_CONDITION);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (k.isEmpty(writeData.getAtUidListString())) {
            statisticItem.param("obj_param1", "0");
        } else {
            statisticItem.param("obj_param1", "1");
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
        }
        TiebaStatic.log(statisticItem);
    }
}
