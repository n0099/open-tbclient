package c.a.t0.p4.u;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.t0.i2.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements c.a.t0.k4.d, Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21615e;

    /* renamed from: f  reason: collision with root package name */
    public VideoFileInfo f21616f;

    /* renamed from: g  reason: collision with root package name */
    public String f21617g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21618h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21619i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f21620j;
    public AlbumVideoCompressingDialogView k;
    public VideoConvertUtil l;
    public Handler m;
    public c.a.t0.i2.g n;
    public boolean o;
    public final CustomMessageListener p;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.f21615e.setResult(-1, intent);
                this.a.f21615e.finish();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21618h = false;
        this.f21619i = false;
        this.f21620j = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.n = kVar.get();
        }
        c.a.t0.i2.g gVar = this.n;
        if (gVar != null) {
            gVar.g();
        }
        this.p = new b(this, 2001374);
        this.f21615e = baseFragmentActivity;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.l = videoConvertUtil;
        videoConvertUtil.o(this);
        this.m = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.p);
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
                                int i2 = videoFileInfo.videoWidth;
                                videoFileInfo.videoWidth = videoFileInfo.videoHeight;
                                videoFileInfo.videoHeight = i2;
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

    @Override // c.a.t0.k4.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.m.sendEmptyMessage(2);
        }
    }

    @Override // c.a.t0.k4.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VideoConvertUtil videoConvertUtil = this.l;
            if (videoConvertUtil != null) {
                videoConvertUtil.a();
            }
            this.f21620j = true;
            if (this.f21617g != null) {
                File file = new File(this.f21617g);
                if (file.exists()) {
                    file.delete();
                }
            }
            h();
            this.f21617g = null;
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f21615e.showLoadingDialog(null);
            VideoFileInfo e2 = e(this.f21617g);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.f21617g);
            videoInfo.setVideoDuration(e2.videoDuration / 1000);
            videoInfo.setVideoWidth(e2.videoWidth);
            videoInfo.setVideoHeight(e2.videoHeight);
            videoInfo.setVideoLength(new File(e2.videoPath).length());
            videoInfo.setVideoSource(2);
            videoInfo.setIsCompressedVideo(z);
            TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(this.f21615e);
            tbFileVideoActivityConfig.getIntent().putExtras(this.f21615e.getIntent());
            tbFileVideoActivityConfig.setFrom(1);
            tbFileVideoActivityConfig.setVideoInfo(videoInfo);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
            if (c.a.s0.s.m.c.b()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 2).param("obj_source", c.a.s0.s.m.c.d() ? 2 : 1));
            }
            this.f21619i = false;
            this.f21617g = null;
            c.a.t0.i2.g gVar = this.n;
            if (gVar != null) {
                gVar.d();
            }
        }
    }

    public void g(VideoFileInfo videoFileInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, videoFileInfo, str, str2) == null) {
            this.f21616f = videoFileInfo;
            if (videoFileInfo == null || this.f21615e == null) {
                return;
            }
            if (videoFileInfo.videoDuration > 600000) {
                s();
                return;
            }
            VideoConvertUtil videoConvertUtil = this.l;
            if (videoConvertUtil == null || !videoConvertUtil.n()) {
                String str3 = this.f21616f.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    n.M(this.f21615e, c.a.t0.p4.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(107);
                } else if (!new File(str3).exists()) {
                    n.M(this.f21615e, c.a.t0.p4.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(106);
                } else {
                    VideoFileInfo videoFileInfo2 = this.f21616f;
                    if (videoFileInfo2 != null) {
                        this.f21617g = videoFileInfo2.videoPath;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = (RelativeLayout) this.f21615e.findViewById(c.a.t0.p4.g.parent)) == null || this.k.getParent() == null) {
            return;
        }
        relativeLayout.removeView(this.k);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            this.m.removeMessages(5);
            int i2 = message.what;
            if (i2 == 1) {
                this.m.removeMessages(1);
                AlbumVideoCompressingDialogView albumVideoCompressingDialogView = this.k;
                if (albumVideoCompressingDialogView != null && albumVideoCompressingDialogView.isShowing()) {
                    this.k.setPercent(message.arg1);
                }
                Handler handler = this.m;
                handler.sendMessageDelayed(handler.obtainMessage(5), 60000L);
            } else if (i2 == 2) {
                if (!this.f21620j) {
                    n.M(this.f21615e, c.a.t0.p4.j.mv_local_video_compress_failed);
                    n(103);
                }
                this.o = false;
                this.f21619i = false;
                h();
            } else if (i2 == 3) {
                this.o = false;
                this.f21619i = true;
                if (!StringUtils.isNull(this.f21617g)) {
                    File file = new File(this.f21617g);
                    this.f21617g = this.f21617g.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.f21617g));
                }
                h();
                if (!this.f21618h) {
                    f(true);
                    c.a.t0.i2.g gVar = this.n;
                    if (gVar != null) {
                        gVar.d();
                    }
                }
            } else if (i2 == 4) {
                this.o = false;
                this.f21619i = false;
                h();
                n(104);
            } else if (i2 == 5) {
                this.o = false;
                n.M(this.f21615e, c.a.t0.p4.j.mv_local_video_compress_failed);
                VideoConvertUtil videoConvertUtil = this.l;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VideoConvertUtil videoConvertUtil = this.l;
            if (videoConvertUtil != null) {
                videoConvertUtil.l();
            }
            Handler handler = this.m;
            if (handler != null) {
                handler.removeMessages(5);
            }
            c.a.t0.i2.g gVar = this.n;
            if (gVar != null) {
                gVar.k("album");
            }
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f21619i && !TextUtils.isEmpty(this.f21617g) && new File(this.f21617g).exists()) {
                f(true);
                n(101);
            }
            c.a.t0.i2.g gVar = this.n;
            if (gVar != null) {
                gVar.e("album");
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21618h = false;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f21618h = true;
            this.f21615e.closeLoadingDialog();
        }
    }

    public final void n(int i2) {
        c.a.t0.i2.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.i(i2, "album");
    }

    public void o(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, antiData, postPrefixData, str, str2) == null) {
        }
    }

    @Override // c.a.t0.k4.d
    public void onConvertAborted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.sendEmptyMessage(4);
        }
    }

    @Override // c.a.t0.k4.d
    public void onConvertFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.sendEmptyMessage(2);
        }
    }

    @Override // c.a.t0.k4.d
    public void onConvertProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i2;
            this.m.sendMessage(obtain);
        }
    }

    @Override // c.a.t0.k4.d
    public void onConvertSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.m.sendEmptyMessage(3);
        }
    }

    public void p(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, frsTabInfoData) == null) {
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.s0.s.s.a positiveButton = new c.a.s0.s.s.a(this.f21615e).setTitle(c.a.t0.p4.j.mv_local_video_too_long).setPositiveButton(c.a.t0.p4.j.group_create_private_isee, new a(this));
            positiveButton.create(this.f21615e.getPageContext());
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        }
    }
}
