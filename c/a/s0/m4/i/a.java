package c.a.s0.m4.i;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.s0.w0.a.g.b;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19664b;

    /* renamed from: c  reason: collision with root package name */
    public final d f19665c;

    /* renamed from: d  reason: collision with root package name */
    public TbMultiMediaData f19666d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.w0.a.c f19667e;

    /* renamed from: f  reason: collision with root package name */
    public VlogEditManager f19668f;

    /* renamed from: c.a.s0.m4.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1184a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f19669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f19670f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19671g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19672h;

        public RunnableC1184a(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
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
            this.f19669e = tbPageContext;
            this.f19670f = videoInfo;
            this.f19671g = str;
            this.f19672h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.y0.b.c().k(null);
                a.l(this.f19669e, this.f19670f, this.f19671g, this.f19672h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.w0.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19673e;

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
            this.f19673e = aVar;
        }

        @Override // c.a.s0.w0.a.b
        public void onCoverPathCallBack(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f19673e.f19665c.h(str);
                this.f19673e.f19666d.coverPath = str;
                c.a.r0.d0.b bVar = new c.a.r0.d0.b();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                ImageOperation g2 = c.a.r0.d0.i.d.g(m.k(this.f19673e.a.getPageActivity()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2), m.f(this.f19673e.a.getPageActivity(), R.dimen.tbds866));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g2);
                bVar.d(imageFileInfo, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.y0.c {
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

        @Override // c.a.y0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.s0.m4.m.b(this.a.a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.y0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.s0.j4.c.f18558c : (String) invokeV.objValue;
        }

        @Override // c.a.y0.c
        public c.a.y0.j.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.y0.j.a) invokeV.objValue;
        }

        @Override // c.a.y0.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class d implements c.a.y0.e.b {
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

        @Override // c.a.y0.e.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.y0.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.y0.e.b
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                g(str, this.a);
            }
        }

        @Override // c.a.y0.e.b
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1913188100, "Lc/a/s0/m4/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1913188100, "Lc/a/s0/m4/i/a;");
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
        this.f19664b = str;
        this.f19665c = dVar;
        e();
        f();
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull VideoInfo videoInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, tbPageContext, videoInfo, str, str2) == null) {
            Intent intent = new Intent();
            intent.putExtra("topic", str);
            intent.putExtra("topicId", str2);
            intent.putExtra("is_video_topic", false);
            intent.putExtra(WorkPublishActivityConfig.VIDEO_MIXING, false);
            intent.putExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, true);
            c.a.r0.s.n.d.a.f(intent, videoInfo, tbPageContext.getPageActivity(), true, false);
        }
    }

    public static String m(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, str)) == null) {
            File file = new File(str);
            File file2 = new File(c.a.s0.j4.c.f18562g);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str2 = c.a.s0.j4.c.f18562g + file.getName();
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
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4) == null) || (c2 = c.a.s0.i4.c.c(str)) == null) {
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
            editVideoData.coverPath = c.a.s0.j4.c.f18557b;
        } else {
            editVideoData.coverPath = videoInfo.getThumbPath();
        }
        editVideoData.originPath = videoInfo.getVideoPath();
        videoInfo.setEditVideoData(editVideoData);
        videoInfo.setMultiMediaData(c.a.s0.m4.m.c.d.d.a(videoInfo));
        e.a().post(new RunnableC1184a(tbPageContext, videoInfo, str3, str4));
    }

    public static VideoMuxer p(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<c.a.s0.m4.i.d.a> list, @NonNull d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, tbPageContext, str, list, dVar)) == null) ? new a(tbPageContext, str, dVar).o(list) : (VideoMuxer) invokeLLLL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoFileInfo c2 = c.a.s0.i4.c.c(this.f19664b);
            if (c2 == null) {
                this.a.getPageActivity().finish();
                return;
            }
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            this.f19666d = tbMultiMediaData;
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
            if (!c.a.s0.i4.a.a()) {
                this.a.getPageActivity().finish();
                return;
            }
            g();
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f19668f = new VlogEditManager(multiMediaDataSourceViewAdapter);
            GLMediaPreviewView gLMediaPreviewView = new GLMediaPreviewView(TbadkCoreApplication.getInst());
            gLMediaPreviewView.setZOrderMediaOverlay(true);
            gLMediaPreviewView.setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
            gLMediaPreviewView.setCanMeasure(false);
            gLMediaPreviewView.setVideoRatio(this.f19666d.videoRatio);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f19666d);
            this.f19668f.setMultiMediaData(arrayList);
            this.f19668f.setVideoRatio(this.f19666d.videoRatio);
            this.f19667e = new c.a.s0.w0.a.c(true);
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.y0.b.c().h(TbadkCoreApplication.getInst());
            c.a.y0.b.c().j(FileHelper.getCacheDir());
            c.a.y0.b.c().k(new c(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a aVar = new b.a();
            aVar.t(this.f19666d.width);
            aVar.o(this.f19666d.height);
            aVar.p(true);
            aVar.r(this.f19666d.videoRatio);
            VlogEditManager vlogEditManager = this.f19668f;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            c.a.s0.w0.a.g.b m = aVar.m();
            this.f19667e.e(new b(this));
            this.f19667e.d(false);
            this.f19667e.b(m, "default");
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
                this.f19668f.seek(j2);
                this.f19668f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
            }
        }
    }

    public final void j(c.a.s0.m4.i.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            int i2 = aVar.f19677b;
            if (i2 == 1) {
                k(aVar.a, aVar.f19680e, aVar.f19681f, aVar.f19682g, aVar.f19683h, aVar.f19684i, aVar.f19685j, aVar.f19686k);
            } else if (i2 == 2) {
                i(aVar.a, aVar.f19680e, aVar.f19681f, aVar.f19682g, aVar.f19683h, aVar.f19678c, aVar.f19679d);
            }
        }
    }

    public final void k(String str, long j2, long j3, double d2, double d3, double d4, double d5, String str2) {
        int d6;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), str2}) == null) {
            c.a.s0.i4.e.d().j((int) d5);
            String videoTmpDir = FileHelper.getVideoTmpDir();
            String str3 = System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            TextWordsEntity.TextStyleEntity textStyleEntity = new TextWordsEntity.TextStyleEntity();
            textStyleEntity.mTextInfoList = new ArrayList();
            textStyleEntity.mStrokeInfoList = new ArrayList();
            TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity = new TextWordsEntity.StyleTextInfoEntity();
            if (!c.a.s0.v3.c.c(c.a.s0.v3.c.d(str2)) && str2 != null && str2.startsWith("#") && str2.length() >= 7) {
                styleTextInfoEntity.mTextAlpha = String.format(Locale.CHINA, "%.1f", Double.valueOf(((d6 >>> 24) * 1.0d) / 255.0d));
                styleTextInfoEntity.mTextColor = str2.substring(str2.length() - 6, str2.length());
            } else {
                styleTextInfoEntity.mTextAlpha = "0.0";
                styleTextInfoEntity.mTextColor = "000000";
            }
            textStyleEntity.mTextInfoList.add(styleTextInfoEntity);
            Bitmap h2 = c.a.s0.i4.e.d().h(TbadkCoreApplication.getInst(), str, textStyleEntity, null);
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
                c.a.s0.i4.e.d().getClass();
                multiMediaData.x = ((int) d2) - 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else if (d4 == 3.0d) {
                int i2 = ((int) d2) - multiMediaData.width;
                c.a.s0.i4.e.d().getClass();
                multiMediaData.x = i2 + 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else {
                multiMediaData.x = (int) d2;
                multiMediaData.y = (int) d3;
            }
            h2.recycle();
            this.f19668f.seek(j2);
            this.f19668f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
        }
    }

    public final VideoMuxer o(@NonNull List<c.a.s0.m4.i.d.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            for (c.a.s0.m4.i.d.a aVar : list) {
                j(aVar);
            }
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setPhotoDataList(this.f19668f.getInputMultiMediaData());
            videoMuxerData.setStickerDataList(this.f19668f.getStickerMultiMediaDataList(false));
            videoMuxerData.setUserNewAudioMixture(true);
            ArrayList arrayList = new ArrayList();
            AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
            audioPlayTrackData.mAudioPlayDataList = new ArrayList();
            arrayList.add(audioPlayTrackData);
            videoMuxerData.setAudioPlayTrackDataList(arrayList);
            videoMuxerData.setPreviewWidth(this.f19668f.getMultiMediaData(0).width);
            videoMuxerData.setPreviewHeight(this.f19668f.getMultiMediaData(0).height);
            videoMuxerData.setOutWidth(this.f19668f.getMultiMediaData(0).width);
            videoMuxerData.setOutHeight(this.f19668f.getMultiMediaData(0).height);
            videoMuxerData.setOutBitRate(this.f19668f.getMultiMediaData(0).width * this.f19668f.getMultiMediaData(0).height * 6);
            videoMuxerData.setComposeNecessary(true);
            videoMuxerData.setCurrThemeEffect((MediaTrackConfig) new Gson().fromJson(this.f19668f.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class));
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(this.f19665c);
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeL.objValue;
    }
}
