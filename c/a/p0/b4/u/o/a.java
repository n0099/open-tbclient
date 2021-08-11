package c.a.p0.b4.u.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.video.PreviewVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f16207a;

    /* renamed from: b  reason: collision with root package name */
    public PreviewVideoView f16208b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16209c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16210d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16211e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16212f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.w3.b f16213g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.e0.b f16214h;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f16215i;

    /* renamed from: j  reason: collision with root package name */
    public EditVideoData f16216j;
    public int k;
    public CustomMessageListener l;
    public View.OnClickListener m;

    /* renamed from: c.a.p0.b4.u.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0773a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16217a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0773a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f16217a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue >= 0 && intValue < 100) {
                    this.f16217a.w(1, intValue);
                } else if (intValue == 100) {
                    this.f16217a.w(2, intValue);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16218e;

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
            this.f16218e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != this.f16218e.f16212f) {
                    if (view == this.f16218e.f16208b.deleteIcon) {
                        if (this.f16218e.f16207a.getPageActivity() instanceof WriteActivity) {
                            this.f16218e.n();
                            ((WriteActivity) this.f16218e.f16207a.getPageActivity()).showPicOrVideo(true, false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                            return;
                        }
                        return;
                    } else if (view == this.f16218e.f16208b.editBtn) {
                        if (this.f16218e.k != 1 && (this.f16218e.f16207a.getPageActivity() instanceof WriteActivity)) {
                            this.f16218e.n();
                            if (this.f16218e.f16207a == null || this.f16218e.f16215i == null || this.f16218e.f16215i.getMultiMediaData() == null) {
                                return;
                            }
                            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.f16218e.f16207a.getPageActivity());
                            tbEditVideoActivityConfig.getIntent().putExtras(this.f16218e.f16207a.getPageActivity().getIntent());
                            tbEditVideoActivityConfig.setMusicData(null);
                            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.f16218e.f16215i));
                            tbEditVideoActivityConfig.setVideoFrom(3);
                            tbEditVideoActivityConfig.setVideoRatio(this.f16218e.f16215i.getMultiMediaData().videoRatio);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                            return;
                        }
                        return;
                    } else if (view == this.f16218e.f16208b.coverBtn) {
                        if (this.f16218e.k != 1 && (this.f16218e.f16207a.getPageActivity() instanceof WriteActivity)) {
                            this.f16218e.n();
                            if (this.f16218e.f16207a == null || this.f16218e.f16215i == null || this.f16218e.f16215i.getMultiMediaData() == null) {
                                return;
                            }
                            TbEditVideoActivityConfig tbEditVideoActivityConfig2 = new TbEditVideoActivityConfig(this.f16218e.f16207a.getPageActivity());
                            tbEditVideoActivityConfig2.getIntent().putExtras(this.f16218e.f16207a.getPageActivity().getIntent());
                            tbEditVideoActivityConfig2.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.f16218e.f16215i));
                            tbEditVideoActivityConfig2.setVideoFrom(3);
                            tbEditVideoActivityConfig2.setVideoRatio(this.f16218e.f16215i.getMultiMediaData().videoRatio);
                            tbEditVideoActivityConfig2.setPageModeType(3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig2));
                            return;
                        }
                        return;
                    } else if (this.f16218e.k == 1 || this.f16218e.f16215i == null) {
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbPreviewVideoActivityConfig(this.f16218e.f16207a.getPageActivity(), this.f16218e.f16215i)));
                        return;
                    }
                }
                this.f16218e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.p0.w3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f16219i;

        /* renamed from: c.a.p0.b4.u.o.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0774a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16220e;

            public RunnableC0774a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16220e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16220e.f16219i.w(1, 50);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16221e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16221e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16221e.f16219i.w(3, 0);
                    this.f16221e.f16219i.t();
                }
            }
        }

        /* renamed from: c.a.p0.b4.u.o.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0775c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16222e;

            public RunnableC0775c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16222e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16222e.f16219i.w(1, 100);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16223e;

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16223e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16223e.f16219i.w(3, 0);
                    this.f16223e.f16219i.t();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16224e;

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16224e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16224e.f16219i.w(2, 100);
                    if (this.f16224e.f16219i.f16207a == null || !(this.f16224e.f16219i.f16207a.getPageActivity() instanceof WriteActivity)) {
                        return;
                    }
                    ((WriteActivity) this.f16224e.f16219i.f16207a.getPageActivity()).refreshPostButton();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, BaseActivity baseActivity, EditVideoData editVideoData) {
            super(baseActivity, editVideoData);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, baseActivity, editVideoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((BaseActivity) objArr2[0], (EditVideoData) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16219i = aVar;
        }

        @Override // c.a.p0.w3.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.c();
            }
        }

        @Override // c.a.p0.w3.b
        public void d(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                super.d(i2, str);
                this.f16219i.f16207a.getPageActivity().runOnUiThread(new d(this));
            }
        }

        @Override // c.a.p0.w3.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f16219i.f16207a.getPageActivity().runOnUiThread(new RunnableC0775c(this));
            }
        }

        @Override // c.a.p0.w3.b
        public void f(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, videoInfo) == null) {
                super.f(videoInfo);
                String videoPath = videoInfo.getVideoPath();
                if (!k.isEmpty(videoPath) && videoPath.contains(c.a.p0.w3.c.f27859f)) {
                    File file = new File(videoPath);
                    videoPath = c.a.p0.w3.c.f27860g + file.getName();
                    FileHelper.copyFile(file.getAbsolutePath(), videoPath);
                }
                try {
                    this.f16219i.v(this.f16219i.f16207a.getPageActivity(), videoPath);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f16219i.f16216j.finalPath = videoPath;
                this.f16219i.f16215i.setVideoPath(videoPath);
                this.f16219i.f16215i.setThumbPath(this.f27848c);
                this.f16219i.f16207a.getPageActivity().runOnUiThread(new e(this));
            }
        }

        @Override // c.a.p0.w3.b
        public void g(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                super.g(i2, str);
                this.f16219i.f16207a.getPageActivity().runOnUiThread(new b(this));
            }
        }

        @Override // c.a.p0.w3.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f16219i.f16207a.getPageActivity().runOnUiThread(new RunnableC0774a(this));
            }
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = new C0773a(this, 2921584);
        this.m = new b(this);
        this.f16207a = tbPageContext;
        PreviewVideoView previewVideoView = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.f16208b = previewVideoView;
        previewVideoView.setOnClickListener(this.m);
        this.f16209c = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.f16210d = (TextView) view.findViewById(R.id.write_video_state_text);
        this.f16211e = (TextView) view.findViewById(R.id.write_video_percent);
        TextView textView = (TextView) view.findViewById(R.id.write_video_retry);
        this.f16212f = textView;
        textView.setOnClickListener(this.m);
        this.l.setTag(this.f16207a.getUniqueId());
        MessageManager.getInstance().registerListener(this.l);
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16208b.changeSkin();
            SkinManager.setViewTextColor(this.f16210d, this.k == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16211e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f16212f, R.color.CAM_X0302);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.w3.b bVar = this.f16213g;
            if (bVar == null) {
                this.f16213g = new c(this, (WriteActivity) this.f16207a.getPageActivity(), this.f16216j);
            } else {
                bVar.j(this.f16216j);
            }
            this.f16213g.i(false);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k == 2 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PreviewVideoView previewVideoView = this.f16208b;
            return previewVideoView != null && previewVideoView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.w3.b bVar = this.f16213g;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.p0.e0.b bVar2 = this.f16214h;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16208b.loadCover();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16208b.deleteCoverCache();
        }
    }

    public void s(VideoInfo videoInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, videoInfo, z) == null) {
            if (videoInfo == null) {
                this.f16216j = null;
            } else {
                this.f16216j = videoInfo.getEditVideoData();
            }
            this.f16215i = videoInfo;
            EditVideoData editVideoData = this.f16216j;
            if (editVideoData != null && editVideoData.isLegal()) {
                this.f16209c.setVisibility(0);
                this.f16208b.setVisibility(0);
                this.f16208b.setVideoInfo(this.f16216j);
                if (z) {
                    this.f16208b.updatePercent(1.0f);
                    return;
                }
                return;
            }
            this.f16209c.setVisibility(8);
            this.f16208b.setVisibility(8);
            this.f16208b.reset();
            c.a.p0.w3.b bVar = this.f16213g;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.p0.e0.b bVar2 = this.f16214h;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    public final void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tbPageContext = this.f16207a) != null && (tbPageContext.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.f16207a.getPageActivity()).showTip(this.f16207a.getString(R.string.write_video_mix_fail));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f16216j == null) {
            return;
        }
        k();
        w(1, 10);
        c.a.p0.e0.b bVar = (c.a.p0.e0.b) MessageManager.getInstance().runTask(2921466, c.a.p0.e0.b.class, this.f16213g).getData();
        this.f16214h = bVar;
        if (bVar != null) {
            bVar.start();
        } else {
            w(3, 0);
        }
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) || context == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new MediaScannerClient(context).saveVideo(str);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.f16211e.setText(String.format(this.f16207a.getString(R.string.video_mix_percent), Integer.valueOf(i3)));
            if (i2 != this.k) {
                this.k = i2;
                SkinManager.setViewTextColor(this.f16210d, i2 == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
                if (i2 == 1) {
                    this.f16210d.setText(this.f16207a.getString(R.string.video_mixing));
                    this.f16211e.setVisibility(0);
                    this.f16212f.setVisibility(8);
                } else if (i2 == 3) {
                    this.f16210d.setText(this.f16207a.getString(R.string.video_mix_failed));
                    this.f16211e.setVisibility(8);
                    this.f16212f.setVisibility(0);
                } else {
                    this.f16210d.setText(this.f16207a.getString(R.string.video_mix_success));
                    this.f16211e.setVisibility(8);
                    this.f16212f.setVisibility(8);
                }
            }
            this.f16208b.updatePercent(i3 / 100.0f);
        }
    }
}
