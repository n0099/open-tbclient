package c.a.r0.k4.i;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.r0.w0.a.g.b;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18880g = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18881b;

    /* renamed from: c  reason: collision with root package name */
    public final d f18882c;

    /* renamed from: d  reason: collision with root package name */
    public TbMultiMediaData f18883d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.w0.a.c f18884e;

    /* renamed from: f  reason: collision with root package name */
    public VlogEditManager f18885f;

    /* renamed from: c.a.r0.k4.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC1113a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18886e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f18887f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f18888g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f18889h;

        public RunnableC1113a(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
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
            this.f18886e = tbPageContext;
            this.f18887f = videoInfo;
            this.f18888g = str;
            this.f18889h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.x0.b.c().k(null);
                a.m(this.f18886e, this.f18887f, this.f18888g, this.f18889h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.r0.w0.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18890e;

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
            this.f18890e = aVar;
        }

        @Override // c.a.r0.w0.a.b
        public void onCoverPathCallBack(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                String unused = a.f18880g;
                String str2 = "coverPath = " + str;
                this.f18890e.f18882c.h(str);
                this.f18890e.f18883d.coverPath = str;
                c.a.q0.d0.b bVar = new c.a.q0.d0.b();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                ImageOperation g2 = c.a.q0.d0.i.d.g(l.k(this.f18890e.a.getPageActivity()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2), l.f(this.f18890e.a.getPageActivity(), R.dimen.tbds866));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g2);
                bVar.d(imageFileInfo, null, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.x0.c {
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

        @Override // c.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.r0.k4.m.b(this.a.a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.r0.h4.c.f17909c : (String) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public c.a.x0.j.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.x0.j.a) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d implements c.a.x0.e.b {
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

        @Override // c.a.x0.e.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String unused = a.f18880g;
            }
        }

        @Override // c.a.x0.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String unused = a.f18880g;
            }
        }

        @Override // c.a.x0.e.b
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                String unused = a.f18880g;
                String str2 = "onMuxerEnd = " + str;
                g(str, this.a);
            }
        }

        @Override // c.a.x0.e.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                String unused = a.f18880g;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(803285339, "Lc/a/r0/k4/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(803285339, "Lc/a/r0/k4/i/a;");
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
        this.f18881b = str;
        this.f18882c = dVar;
        f();
        g();
    }

    public static void m(@NonNull TbPageContext<?> tbPageContext, @NonNull VideoInfo videoInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, tbPageContext, videoInfo, str, str2) == null) {
            Intent intent = new Intent();
            intent.putExtra("topic", str);
            intent.putExtra("topicId", str2);
            intent.putExtra("is_video_topic", false);
            intent.putExtra(WorkPublishActivityConfig.VIDEO_MIXING, false);
            intent.putExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, true);
            c.a.q0.s.m.d.a.f(intent, videoInfo, tbPageContext.getPageActivity(), true, false);
        }
    }

    public static String n(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, tbPageContext, str)) == null) {
            File file = new File(str);
            File file2 = new File(c.a.r0.h4.c.f17913g);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str2 = c.a.r0.h4.c.f17913g + file.getName();
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

    public static void o(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull String str2, String str3, String str4) {
        String n;
        VideoFileInfo c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65545, null, tbPageContext, str, str2, str3, str4) == null) || (c2 = c.a.r0.g4.c.c((n = n(tbPageContext, str)))) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(n);
        videoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
        videoInfo.setVideoWidth(c2.videoWidth);
        videoInfo.setVideoHeight(c2.videoHeight);
        videoInfo.setVideoLength(new File(n).length());
        videoInfo.setVideoSource(2);
        videoInfo.setIsCompressedVideo(true);
        videoInfo.setThumbPath(str2);
        EditVideoData editVideoData = new EditVideoData();
        if (StringUtils.isNull(videoInfo.getThumbPath())) {
            editVideoData.coverPath = c.a.r0.h4.c.f17908b;
        } else {
            editVideoData.coverPath = videoInfo.getThumbPath();
        }
        editVideoData.originPath = videoInfo.getVideoPath();
        videoInfo.setEditVideoData(editVideoData);
        videoInfo.setMultiMediaData(c.a.r0.k4.m.c.d.d.a(videoInfo));
        e.a().post(new RunnableC1113a(tbPageContext, videoInfo, str3, str4));
    }

    public static VideoMuxer q(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<c.a.r0.k4.i.d.a> list, @NonNull d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, tbPageContext, str, list, dVar)) == null) ? new a(tbPageContext, str, dVar).p(list) : (VideoMuxer) invokeLLLL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoFileInfo c2 = c.a.r0.g4.c.c(this.f18881b);
            if (c2 == null) {
                this.a.getPageActivity().finish();
                return;
            }
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            this.f18883d = tbMultiMediaData;
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!c.a.r0.g4.a.a()) {
                this.a.getPageActivity().finish();
                return;
            }
            h();
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f18885f = new VlogEditManager(multiMediaDataSourceViewAdapter);
            GLMediaPreviewView gLMediaPreviewView = new GLMediaPreviewView(TbadkCoreApplication.getInst());
            gLMediaPreviewView.setZOrderMediaOverlay(true);
            gLMediaPreviewView.setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
            gLMediaPreviewView.setCanMeasure(false);
            gLMediaPreviewView.setVideoRatio(this.f18883d.videoRatio);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f18883d);
            this.f18885f.setMultiMediaData(arrayList);
            this.f18885f.setVideoRatio(this.f18883d.videoRatio);
            this.f18884e = new c.a.r0.w0.a.c(true);
            i();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.x0.b.c().h(TbadkCoreApplication.getInst());
            c.a.x0.b.c().j(FileHelper.getCacheDir());
            c.a.x0.b.c().k(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a aVar = new b.a();
            aVar.t(this.f18883d.width);
            aVar.o(this.f18883d.height);
            aVar.p(true);
            aVar.r(this.f18883d.videoRatio);
            VlogEditManager vlogEditManager = this.f18885f;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            c.a.r0.w0.a.g.b m = aVar.m();
            this.f18884e.e(new b(this));
            this.f18884e.d(false);
            this.f18884e.b(m, "default");
        }
    }

    public final void j(String str, long j2, long j3, double d2, double d3, int i2, int i3) {
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
                this.f18885f.seek(j2);
                this.f18885f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
            }
        }
    }

    public final void k(c.a.r0.k4.i.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            int i2 = aVar.f18894b;
            if (i2 == 1) {
                l(aVar.a, aVar.f18897e, aVar.f18898f, aVar.f18899g, aVar.f18900h, aVar.f18901i, aVar.f18902j, aVar.f18903k);
            } else if (i2 == 2) {
                j(aVar.a, aVar.f18897e, aVar.f18898f, aVar.f18899g, aVar.f18900h, aVar.f18895c, aVar.f18896d);
            }
        }
    }

    public final void l(String str, long j2, long j3, double d2, double d3, double d4, double d5, String str2) {
        int d6;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), str2}) == null) {
            c.a.r0.g4.e.d().j((int) d5);
            String videoTmpDir = FileHelper.getVideoTmpDir();
            String str3 = System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            TextWordsEntity.TextStyleEntity textStyleEntity = new TextWordsEntity.TextStyleEntity();
            textStyleEntity.mTextInfoList = new ArrayList();
            textStyleEntity.mStrokeInfoList = new ArrayList();
            TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity = new TextWordsEntity.StyleTextInfoEntity();
            if (!c.a.r0.t3.c.c(c.a.r0.t3.c.d(str2)) && str2 != null && str2.startsWith("#") && str2.length() >= 7) {
                styleTextInfoEntity.mTextAlpha = String.format(Locale.CHINA, "%.1f", Double.valueOf(((d6 >>> 24) * 1.0d) / 255.0d));
                styleTextInfoEntity.mTextColor = str2.substring(str2.length() - 6, str2.length());
            } else {
                styleTextInfoEntity.mTextAlpha = "0.0";
                styleTextInfoEntity.mTextColor = "000000";
            }
            textStyleEntity.mTextInfoList.add(styleTextInfoEntity);
            Bitmap h2 = c.a.r0.g4.e.d().h(TbadkCoreApplication.getInst(), str, textStyleEntity, null);
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
                c.a.r0.g4.e.d().getClass();
                multiMediaData.x = ((int) d2) - 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else if (d4 == 3.0d) {
                int i2 = ((int) d2) - multiMediaData.width;
                c.a.r0.g4.e.d().getClass();
                multiMediaData.x = i2 + 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else {
                multiMediaData.x = (int) d2;
                multiMediaData.y = (int) d3;
            }
            h2.recycle();
            this.f18885f.seek(j2);
            this.f18885f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
        }
    }

    public final VideoMuxer p(@NonNull List<c.a.r0.k4.i.d.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            for (c.a.r0.k4.i.d.a aVar : list) {
                k(aVar);
            }
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setPhotoDataList(this.f18885f.getInputMultiMediaData());
            videoMuxerData.setStickerDataList(this.f18885f.getStickerMultiMediaDataList(false));
            videoMuxerData.setUserNewAudioMixture(true);
            ArrayList arrayList = new ArrayList();
            AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
            audioPlayTrackData.mAudioPlayDataList = new ArrayList();
            arrayList.add(audioPlayTrackData);
            videoMuxerData.setAudioPlayTrackDataList(arrayList);
            videoMuxerData.setPreviewWidth(this.f18885f.getMultiMediaData(0).width);
            videoMuxerData.setPreviewHeight(this.f18885f.getMultiMediaData(0).height);
            videoMuxerData.setOutWidth(this.f18885f.getMultiMediaData(0).width);
            videoMuxerData.setOutHeight(this.f18885f.getMultiMediaData(0).height);
            videoMuxerData.setOutBitRate(this.f18885f.getMultiMediaData(0).width * this.f18885f.getMultiMediaData(0).height * 6);
            videoMuxerData.setComposeNecessary(true);
            videoMuxerData.setCurrThemeEffect((MediaTrackConfig) new Gson().fromJson(this.f18885f.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class));
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(this.f18882c);
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeL.objValue;
    }
}
