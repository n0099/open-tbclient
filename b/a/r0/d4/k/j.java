package b.a.r0.d4.k;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
import b.a.r0.a2.k;
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
import com.baidu.tbadk.plugins.XiaoyingUtil;
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
import java.io.File;
/* loaded from: classes4.dex */
public class j implements b.a.r0.z3.d, Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f15944e;

    /* renamed from: f  reason: collision with root package name */
    public VideoFileInfo f15945f;

    /* renamed from: g  reason: collision with root package name */
    public String f15946g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15947h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15948i;
    public boolean j;
    public AlbumVideoCompressingDialogView k;
    public VideoConvertUtil l;
    public Handler m;
    public b.a.r0.a2.g n;
    public boolean o;
    public final CustomMessageListener p;

    /* loaded from: classes4.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f15949a;

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
            this.f15949a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                this.f15949a.f15944e.setResult(-1, intent);
                this.f15949a.f15944e.finish();
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
        this.f15947h = false;
        this.f15948i = false;
        this.j = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.n = kVar.get();
        }
        b.a.r0.a2.g gVar = this.n;
        if (gVar != null) {
            gVar.g();
        }
        this.p = new b(this, 2001374);
        this.f15944e = baseFragmentActivity;
        VideoConvertUtil videoConvertUtil = new VideoConvertUtil(baseFragmentActivity);
        this.l = videoConvertUtil;
        videoConvertUtil.s(this);
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
                            videoFileInfo.videoDuration = b.a.e.e.m.b.e(mediaMetadataRetriever.extractMetadata(9), 0);
                            videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                            videoFileInfo.videoWidth = b.a.e.e.m.b.e(mediaMetadataRetriever.extractMetadata(18), 0);
                            videoFileInfo.videoHeight = b.a.e.e.m.b.e(mediaMetadataRetriever.extractMetadata(19), 0);
                            int e2 = b.a.e.e.m.b.e(mediaMetadataRetriever.extractMetadata(24), 0);
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

    @Override // b.a.r0.z3.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.m.sendEmptyMessage(2);
        }
    }

    @Override // b.a.r0.z3.d
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
            this.j = true;
            if (this.f15946g != null) {
                File file = new File(this.f15946g);
                if (file.exists()) {
                    file.delete();
                }
            }
            h();
            this.f15946g = null;
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f15944e.showLoadingDialog(null);
            VideoFileInfo e2 = e(this.f15946g);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.f15946g);
            videoInfo.setVideoDuration(e2.videoDuration / 1000);
            videoInfo.setVideoWidth(e2.videoWidth);
            videoInfo.setVideoHeight(e2.videoHeight);
            videoInfo.setVideoLength(new File(e2.videoPath).length());
            videoInfo.setVideoSource(2);
            videoInfo.setIsCompressedVideo(z);
            TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(this.f15944e);
            tbFileVideoActivityConfig.getIntent().putExtras(this.f15944e.getIntent());
            tbFileVideoActivityConfig.setFrom(1);
            tbFileVideoActivityConfig.setVideoInfo(videoInfo);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
            if (b.a.q0.s.m.b.b()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 2).param("obj_source", b.a.q0.s.m.b.d() ? 2 : 1));
            }
            this.f15948i = false;
            this.f15946g = null;
            b.a.r0.a2.g gVar = this.n;
            if (gVar != null) {
                gVar.d();
            }
        }
    }

    public void g(VideoFileInfo videoFileInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, videoFileInfo, str, str2) == null) {
            this.f15945f = videoFileInfo;
            if (videoFileInfo == null || this.f15944e == null) {
                return;
            }
            if (videoFileInfo.videoDuration > 600000) {
                t();
                return;
            }
            VideoConvertUtil videoConvertUtil = this.l;
            if (videoConvertUtil == null || !videoConvertUtil.q()) {
                String str3 = this.f15945f.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.L(this.f15944e, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(107);
                } else if (!new File(str3).exists()) {
                    l.L(this.f15944e, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str3));
                    n(106);
                } else if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                    if (VideoConvertUtil.o(str3) >= 1500000) {
                        if (VideoConvertUtil.l()) {
                            this.f15946g = new File(VideoConvertUtil.n, "tieba_" + VideoConvertUtil.t(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.l.r(1);
                            this.l.m(str3, this.f15946g);
                            s();
                            this.f15948i = false;
                            this.j = false;
                            return;
                        }
                        return;
                    }
                    VideoFileInfo videoFileInfo2 = this.f15945f;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.f15946g = new File(VideoConvertUtil.n, "tieba_" + VideoConvertUtil.t(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.l.r(2);
                            this.l.m(str3, this.f15946g);
                            s();
                            this.f15948i = false;
                            this.j = false;
                            return;
                        }
                        this.f15946g = videoFileInfo2.videoPath;
                        f(false);
                        n(102);
                    }
                } else {
                    VideoFileInfo videoFileInfo3 = this.f15945f;
                    if (videoFileInfo3 != null) {
                        this.f15946g = videoFileInfo3.videoPath;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = (RelativeLayout) this.f15944e.findViewById(R.id.parent)) == null || this.k.getParent() == null) {
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
                if (!this.j) {
                    l.L(this.f15944e, R.string.mv_local_video_compress_failed);
                    n(103);
                }
                this.o = false;
                this.f15948i = false;
                h();
            } else if (i2 == 3) {
                this.o = false;
                this.f15948i = true;
                if (!StringUtils.isNull(this.f15946g)) {
                    File file = new File(this.f15946g);
                    this.f15946g = this.f15946g.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.f15946g));
                }
                h();
                if (!this.f15947h) {
                    f(true);
                    b.a.r0.a2.g gVar = this.n;
                    if (gVar != null) {
                        gVar.d();
                    }
                }
            } else if (i2 == 4) {
                this.o = false;
                this.f15948i = false;
                h();
                n(104);
            } else if (i2 == 5) {
                this.o = false;
                l.L(this.f15944e, R.string.mv_local_video_compress_failed);
                VideoConvertUtil videoConvertUtil = this.l;
                if (videoConvertUtil != null && videoConvertUtil.q()) {
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
                videoConvertUtil.n();
            }
            Handler handler = this.m;
            if (handler != null) {
                handler.removeMessages(5);
            }
            b.a.r0.a2.g gVar = this.n;
            if (gVar != null) {
                gVar.k("album");
            }
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f15948i && !TextUtils.isEmpty(this.f15946g) && new File(this.f15946g).exists()) {
                f(true);
                n(101);
            }
            b.a.r0.a2.g gVar = this.n;
            if (gVar != null) {
                gVar.e("album");
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f15947h = false;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f15947h = true;
            this.f15944e.closeLoadingDialog();
        }
    }

    public final void n(int i2) {
        b.a.r0.a2.g gVar;
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

    @Override // b.a.r0.z3.d
    public void onConvertAborted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.sendEmptyMessage(4);
        }
    }

    @Override // b.a.r0.z3.d
    public void onConvertFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.sendEmptyMessage(2);
        }
    }

    @Override // b.a.r0.z3.d
    public void onConvertProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i2;
            this.m.sendMessage(obtain);
        }
    }

    @Override // b.a.r0.z3.d
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
            RelativeLayout relativeLayout = (RelativeLayout) this.f15944e.findViewById(R.id.parent);
            if (relativeLayout != null) {
                if (this.k == null) {
                    this.k = new AlbumVideoCompressingDialogView(this.f15944e);
                }
                if (this.k.getParent() != null) {
                    return;
                }
                relativeLayout.addView(this.k);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.k.setLayoutParams(layoutParams);
            }
            this.k.setPercent(0);
            this.o = true;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b.a.q0.s.s.a positiveButton = new b.a.q0.s.s.a(this.f15944e).setTitle(R.string.mv_local_video_too_long).setPositiveButton(R.string.group_create_private_isee, new a(this));
            positiveButton.create(this.f15944e.getPageContext());
            positiveButton.setCanceledOnTouchOutside(false);
            positiveButton.show();
        }
    }
}
