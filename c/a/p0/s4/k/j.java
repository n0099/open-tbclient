package c.a.p0.s4.k;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.l2.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
/* loaded from: classes2.dex */
public class j implements c.a.p0.n4.d, Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public VideoFileInfo f18377b;

    /* renamed from: c  reason: collision with root package name */
    public String f18378c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18379d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18380e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18381f;

    /* renamed from: g  reason: collision with root package name */
    public AlbumVideoCompressingDialogView f18382g;

    /* renamed from: h  reason: collision with root package name */
    public VideoConvertUtil f18383h;
    public Handler i;
    public c.a.p0.l2.g j;
    public boolean k;
    public final CustomMessageListener l;

    /* loaded from: classes2.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                this.a.a.setResult(-1, intent);
                this.a.a.finish();
            }
        }
    }

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18379d = false;
        this.f18380e = false;
        this.f18381f = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.j = kVar.get();
        }
        c.a.p0.l2.g gVar = this.j;
        if (gVar != null) {
            gVar.g();
        }
        this.l = new b(this, 2001374);
        this.a = baseFragmentActivity;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.f18383h = videoConvertUtil;
        videoConvertUtil.o(this);
        this.i = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.l);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:25:0x0085). Please submit an issue!!! */
    public static VideoFileInfo e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                VideoFileInfo videoFileInfo = new VideoFileInfo();
                videoFileInfo.videoPath = str;
                videoFileInfo.lastModified = file.lastModified();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            videoFileInfo.videoDuration = c.a.d.f.m.b.e(mediaMetadataRetriever.extractMetadata(9), 0);
                            videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                            videoFileInfo.videoWidth = c.a.d.f.m.b.e(mediaMetadataRetriever.extractMetadata(18), 0);
                            videoFileInfo.videoHeight = c.a.d.f.m.b.e(mediaMetadataRetriever.extractMetadata(19), 0);
                            int e2 = c.a.d.f.m.b.e(mediaMetadataRetriever.extractMetadata(24), 0);
                            if (e2 == 90 || e2 == 270) {
                                int i = videoFileInfo.videoWidth;
                                videoFileInfo.videoWidth = videoFileInfo.videoHeight;
                                videoFileInfo.videoHeight = i;
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return videoFileInfo;
            }
            return null;
        }
        return (VideoFileInfo) invokeL.objValue;
    }

    @Override // c.a.p0.n4.d
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // c.a.p0.n4.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VideoConvertUtil videoConvertUtil = this.f18383h;
            if (videoConvertUtil != null) {
                videoConvertUtil.a();
            }
            this.f18381f = true;
            if (this.f18378c != null) {
                File file = new File(this.f18378c);
                if (file.exists()) {
                    file.delete();
                }
            }
            h();
            this.f18378c = null;
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a.showLoadingDialog(null);
            VideoFileInfo e2 = e(this.f18378c);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.f18378c);
            videoInfo.setVideoDuration(e2.videoDuration / 1000);
            videoInfo.setVideoWidth(e2.videoWidth);
            videoInfo.setVideoHeight(e2.videoHeight);
            videoInfo.setVideoLength(new File(e2.videoPath).length());
            videoInfo.setVideoSource(2);
            videoInfo.setIsCompressedVideo(z);
            TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(this.a);
            tbFileVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
            tbFileVideoActivityConfig.setFrom(1);
            tbFileVideoActivityConfig.setVideoInfo(videoInfo);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
            if (WorkPublishManager.isWorkPublishLocate()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 2).param("obj_source", WorkPublishManager.isWorkPublishLocateVideoCenter() ? 2 : 1));
            }
            this.f18380e = false;
            this.f18378c = null;
            c.a.p0.l2.g gVar = this.j;
            if (gVar != null) {
                gVar.d();
            }
        }
    }

    public void g(VideoFileInfo videoFileInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, videoFileInfo, str, str2) == null) {
            this.f18377b = videoFileInfo;
            if (videoFileInfo == null || this.a == null) {
                return;
            }
            if (videoFileInfo.videoDuration > 600000) {
                s();
                return;
            }
            VideoConvertUtil videoConvertUtil = this.f18383h;
            if (videoConvertUtil == null || !videoConvertUtil.n()) {
                String str3 = this.f18377b.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    n.M(this.a, R.string.obfuscated_res_0x7f0f0b1d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(107);
                } else if (!new File(str3).exists()) {
                    n.M(this.a, R.string.obfuscated_res_0x7f0f0b1d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(106);
                } else {
                    VideoFileInfo videoFileInfo2 = this.f18377b;
                    if (videoFileInfo2 != null) {
                        this.f18378c = videoFileInfo2.videoPath;
                        f(false);
                        n(102);
                    }
                }
            }
        }
    }

    public final void h() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091647)) == null || this.f18382g.getParent() == null) {
            return;
        }
        relativeLayout.removeView(this.f18382g);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            this.i.removeMessages(5);
            int i = message.what;
            if (i == 1) {
                this.i.removeMessages(1);
                AlbumVideoCompressingDialogView albumVideoCompressingDialogView = this.f18382g;
                if (albumVideoCompressingDialogView != null && albumVideoCompressingDialogView.b()) {
                    this.f18382g.setPercent(message.arg1);
                }
                Handler handler = this.i;
                handler.sendMessageDelayed(handler.obtainMessage(5), 60000L);
            } else if (i == 2) {
                if (!this.f18381f) {
                    n.M(this.a, R.string.obfuscated_res_0x7f0f0b1a);
                    n(103);
                }
                this.k = false;
                this.f18380e = false;
                h();
            } else if (i == 3) {
                this.k = false;
                this.f18380e = true;
                if (!StringUtils.isNull(this.f18378c)) {
                    File file = new File(this.f18378c);
                    this.f18378c = this.f18378c.replace("_tiebaconverting.mp4", DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file.renameTo(new File(this.f18378c));
                }
                h();
                if (!this.f18379d) {
                    f(true);
                    c.a.p0.l2.g gVar = this.j;
                    if (gVar != null) {
                        gVar.d();
                    }
                }
            } else if (i == 4) {
                this.k = false;
                this.f18380e = false;
                h();
                n(104);
            } else if (i == 5) {
                this.k = false;
                n.M(this.a, R.string.obfuscated_res_0x7f0f0b1a);
                VideoConvertUtil videoConvertUtil = this.f18383h;
                if (videoConvertUtil != null && videoConvertUtil.n()) {
                    d();
                }
                n(105);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VideoConvertUtil videoConvertUtil = this.f18383h;
            if (videoConvertUtil != null) {
                videoConvertUtil.l();
            }
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(5);
            }
            c.a.p0.l2.g gVar = this.j;
            if (gVar != null) {
                gVar.k("album");
            }
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f18380e && !TextUtils.isEmpty(this.f18378c) && new File(this.f18378c).exists()) {
                f(true);
                n(101);
            }
            c.a.p0.l2.g gVar = this.j;
            if (gVar != null) {
                gVar.e("album");
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18379d = false;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f18379d = true;
            this.a.closeLoadingDialog();
        }
    }

    public final void n(int i) {
        c.a.p0.l2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (gVar = this.j) == null) {
            return;
        }
        gVar.i(i, "album");
    }

    public void o(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, antiData, postPrefixData, str, str2) == null) {
        }
    }

    @Override // c.a.p0.n4.d
    public void onConvertAborted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i.sendEmptyMessage(4);
        }
    }

    @Override // c.a.p0.n4.d
    public void onConvertFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.i.sendEmptyMessage(2);
        }
    }

    @Override // c.a.p0.n4.d
    public void onConvertProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            this.i.sendMessage(obtain);
        }
    }

    @Override // c.a.p0.n4.d
    public void onConvertSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.i.sendEmptyMessage(3);
        }
    }

    public void p(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, frsTabInfoData) == null) {
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.o0.r.t.a positiveButton = new c.a.o0.r.t.a(this.a).setTitle(R.string.obfuscated_res_0x7f0f0b1c).setPositiveButton(R.string.obfuscated_res_0x7f0f07d4, new a(this));
            positiveButton.create(this.a.getPageContext());
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        }
    }
}
