package c.a.t0.n4.i;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.t0.w0.a.g.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.R;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.ugc.utils.FileUtils;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19856b;

    /* renamed from: c  reason: collision with root package name */
    public final d f19857c;

    /* renamed from: d  reason: collision with root package name */
    public TbMultiMediaData f19858d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.w0.a.c f19859e;

    /* renamed from: f  reason: collision with root package name */
    public VlogEditManager f19860f;

    /* renamed from: c.a.t0.n4.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC1244a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f19861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f19862f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19863g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19864h;

        public RunnableC1244a(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, videoInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19861e = tbPageContext;
            this.f19862f = videoInfo;
            this.f19863g = str;
            this.f19864h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.a1.b.c().k(null);
                a.l(this.f19861e, this.f19862f, this.f19863g, this.f19864h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.t0.w0.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19865e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19865e = aVar;
        }

        @Override // c.a.t0.w0.a.b
        public void onCoverPathCallBack(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f19865e.f19857c.h(str);
                this.f19865e.f19858d.coverPath = str;
                c.a.s0.d0.b bVar = new c.a.s0.d0.b();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                ImageOperation g2 = c.a.s0.d0.i.d.g(n.k(this.f19865e.a.getPageActivity()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2), n.f(this.f19865e.a.getPageActivity(), R.dimen.tbds866));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g2);
                bVar.d(imageFileInfo, null, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a.a1.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.a1.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.t0.n4.m.b(this.a.a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.t0.k4.c.f18796c : (String) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public c.a.a1.j.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.a1.j.a) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class d implements c.a.a1.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public d() {
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

        @Override // c.a.a1.e.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.a1.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.a1.e.b
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                g(str, this.a);
            }
        }

        @Override // c.a.a1.e.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract void g(String str, String str2);

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1222197924, "Lc/a/t0/n4/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1222197924, "Lc/a/t0/n4/i/a;");
        }
    }

    public a(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f19856b = str;
        this.f19857c = dVar;
        e();
        f();
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull VideoInfo videoInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, tbPageContext, videoInfo, str, str2) == null) {
            Intent intent = new Intent();
            intent.putExtra("topic", str);
            intent.putExtra("topicId", str2);
            intent.putExtra("is_video_topic", "0");
            intent.putExtra(WorkPublishActivityConfig.VIDEO_MIXING, false);
            intent.putExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, true);
            c.a.s0.s.m.d.a.e(intent, videoInfo, tbPageContext.getPageActivity(), true, false);
        }
    }

    public static String m(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, str)) == null) {
            File file = new File(str);
            File file2 = new File(c.a.t0.k4.c.f18800g);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str2 = c.a.t0.k4.c.f18800g + file.getName();
            if (!str2.equals(file.getAbsolutePath())) {
                FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str2);
            }
            new MediaScannerClient(tbPageContext.getPageActivity()).saveVideo(str2);
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                tbPageContext.getPageActivity().sendBroadcast(intent);
            } catch (Exception e2) {
                BdLog.d(e2.getMessage());
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void n(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull String str2, String str3, String str4) {
        VideoFileInfo c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4) == null) || (c2 = c.a.t0.j4.c.c(str)) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(str);
        videoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
        videoInfo.setVideoWidth(c2.videoWidth);
        videoInfo.setVideoHeight(c2.videoHeight);
        videoInfo.setVideoLength(new File(str).length());
        videoInfo.setVideoSource(2);
        videoInfo.setIsCompressedVideo(true);
        videoInfo.setThumbPath(str2);
        EditVideoData editVideoData = new EditVideoData();
        if (StringUtils.isNull(videoInfo.getThumbPath())) {
            editVideoData.coverPath = c.a.t0.k4.c.f18795b;
        } else {
            editVideoData.coverPath = videoInfo.getThumbPath();
        }
        editVideoData.originPath = videoInfo.getVideoPath();
        videoInfo.setEditVideoData(editVideoData);
        videoInfo.setMultiMediaData(c.a.t0.n4.m.c.d.d.a(videoInfo));
        e.a().post(new RunnableC1244a(tbPageContext, videoInfo, str3, str4));
    }

    public static VideoMuxer p(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<c.a.t0.n4.i.d.a> list, @NonNull d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, tbPageContext, str, list, dVar)) == null) ? new a(tbPageContext, str, dVar).o(list) : (VideoMuxer) invokeLLLL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoFileInfo c2 = c.a.t0.j4.c.c(this.f19856b);
            if (c2 == null) {
                this.a.getPageActivity().finish();
                return;
            }
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            this.f19858d = tbMultiMediaData;
            tbMultiMediaData.path = c2.videoPath;
            tbMultiMediaData.coverPath = c2.thumbPath;
            int i2 = c2.videoHeight;
            tbMultiMediaData.height = i2;
            int i3 = c2.videoWidth;
            tbMultiMediaData.width = i3;
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            int i4 = c2.videoDuration;
            tbMultiMediaData.end = i4;
            tbMultiMediaData.originalDuration = i4;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.videoInfoSource = 2;
            tbMultiMediaData.coverSource = 1;
            tbMultiMediaData.videoRatio = (i2 * 1.0f) / i3;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!c.a.t0.j4.a.a()) {
                this.a.getPageActivity().finish();
                return;
            }
            g();
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f19860f = new VlogEditManager(multiMediaDataSourceViewAdapter);
            GLMediaPreviewView gLMediaPreviewView = new GLMediaPreviewView(TbadkCoreApplication.getInst());
            gLMediaPreviewView.setZOrderMediaOverlay(true);
            gLMediaPreviewView.setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
            gLMediaPreviewView.setCanMeasure(false);
            gLMediaPreviewView.setVideoRatio(this.f19858d.videoRatio);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f19858d);
            this.f19860f.setMultiMediaData(arrayList);
            this.f19860f.setVideoRatio(this.f19858d.videoRatio);
            this.f19859e = new c.a.t0.w0.a.c(true);
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.a1.b.c().h(TbadkCoreApplication.getInst());
            c.a.a1.b.c().j(FileHelper.getCacheDir());
            c.a.a1.b.c().k(new c(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a aVar = new b.a();
            aVar.t(this.f19858d.width);
            aVar.o(this.f19858d.height);
            aVar.p(true);
            aVar.r(this.f19858d.videoRatio);
            VlogEditManager vlogEditManager = this.f19860f;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            c.a.t0.w0.a.g.b m = aVar.m();
            this.f19859e.e(new b(this));
            this.f19859e.d(false);
            this.f19859e.b(m, "default");
        }
    }

    public final void i(String str, long j2, long j3, double d2, double d3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            MultiMediaData multiMediaData = new MultiMediaData();
            Bitmap image = FileHelper.getImage(str);
            if (image != null) {
                multiMediaData.path = str;
                multiMediaData.width = i2;
                multiMediaData.height = i3;
                multiMediaData.scaleType = "adaptive";
                multiMediaData.type = 0;
                multiMediaData.start = j2;
                multiMediaData.end = j3;
                multiMediaData.x = ((int) d2) - (i2 >> 1);
                multiMediaData.y = ((int) d3) - (i3 >> 1);
                image.recycle();
                this.f19860f.seek(j2);
                this.f19860f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
            }
        }
    }

    public final void j(c.a.t0.n4.i.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            int i2 = aVar.f19869b;
            if (i2 == 1) {
                k(aVar.a, aVar.f19872e, aVar.f19873f, aVar.f19874g, aVar.f19875h, aVar.f19876i, aVar.f19877j, aVar.k);
            } else if (i2 == 2) {
                i(aVar.a, aVar.f19872e, aVar.f19873f, aVar.f19874g, aVar.f19875h, aVar.f19870c, aVar.f19871d);
            }
        }
    }

    public final void k(String str, long j2, long j3, double d2, double d3, double d4, double d5, String str2) {
        int d6;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), str2}) == null) {
            c.a.t0.j4.e.d().j((int) d5);
            String videoTmpDir = FileHelper.getVideoTmpDir();
            String str3 = System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            TextWordsEntity.TextStyleEntity textStyleEntity = new TextWordsEntity.TextStyleEntity();
            textStyleEntity.mTextInfoList = new ArrayList();
            textStyleEntity.mStrokeInfoList = new ArrayList();
            TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity = new TextWordsEntity.StyleTextInfoEntity();
            if (!c.a.t0.w3.c.c(c.a.t0.w3.c.d(str2)) && str2 != null && str2.startsWith("#") && str2.length() >= 7) {
                styleTextInfoEntity.mTextAlpha = String.format(Locale.CHINA, "%.1f", Double.valueOf(((d6 >>> 24) * 1.0d) / 255.0d));
                styleTextInfoEntity.mTextColor = str2.substring(str2.length() - 6, str2.length());
            } else {
                styleTextInfoEntity.mTextAlpha = "0.0";
                styleTextInfoEntity.mTextColor = "000000";
            }
            textStyleEntity.mTextInfoList.add(styleTextInfoEntity);
            Bitmap h2 = c.a.t0.j4.e.d().h(TbadkCoreApplication.getInst(), str, textStyleEntity, null);
            MultiMediaData multiMediaData = new MultiMediaData();
            FileUtils.saveBitmap2PNG(videoTmpDir, str3, h2, 100);
            multiMediaData.path = videoTmpDir + File.separator + str3;
            multiMediaData.width = h2.getWidth();
            multiMediaData.height = h2.getHeight();
            multiMediaData.scaleType = "adaptive";
            multiMediaData.type = 0;
            multiMediaData.start = j2;
            multiMediaData.end = j3;
            if (d4 == 1.0d) {
                multiMediaData.x = ((int) d2) - (multiMediaData.width >> 1);
                multiMediaData.y = ((int) d3) - (height >> 1);
            } else if (d4 == 2.0d) {
                c.a.t0.j4.e.d().getClass();
                multiMediaData.x = ((int) d2) - 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else if (d4 == 3.0d) {
                int i2 = ((int) d2) - multiMediaData.width;
                c.a.t0.j4.e.d().getClass();
                multiMediaData.x = i2 + 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else {
                multiMediaData.x = (int) d2;
                multiMediaData.y = (int) d3;
            }
            h2.recycle();
            this.f19860f.seek(j2);
            this.f19860f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
        }
    }

    public final VideoMuxer o(@NonNull List<c.a.t0.n4.i.d.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            for (c.a.t0.n4.i.d.a aVar : list) {
                j(aVar);
            }
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setPhotoDataList(this.f19860f.getInputMultiMediaData());
            videoMuxerData.setStickerDataList(this.f19860f.getStickerMultiMediaDataList(false));
            videoMuxerData.setUserNewAudioMixture(true);
            ArrayList arrayList = new ArrayList();
            AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
            audioPlayTrackData.mAudioPlayDataList = new ArrayList();
            arrayList.add(audioPlayTrackData);
            videoMuxerData.setAudioPlayTrackDataList(arrayList);
            videoMuxerData.setPreviewWidth(this.f19860f.getMultiMediaData(0).width);
            videoMuxerData.setPreviewHeight(this.f19860f.getMultiMediaData(0).height);
            videoMuxerData.setOutWidth(this.f19860f.getMultiMediaData(0).width);
            videoMuxerData.setOutHeight(this.f19860f.getMultiMediaData(0).height);
            videoMuxerData.setOutBitRate(this.f19860f.getMultiMediaData(0).width * this.f19860f.getMultiMediaData(0).height * 6);
            videoMuxerData.setComposeNecessary(true);
            videoMuxerData.setCurrThemeEffect((MediaTrackConfig) new Gson().fromJson(this.f19860f.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class));
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(this.f19857c);
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeL.objValue;
    }
}
