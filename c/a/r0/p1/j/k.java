package c.a.r0.p1.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k extends c.a.d.m.e.a<c.a.r0.p1.l.o, TopicMediaHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public int m;
    public BaseActivity<?> n;
    public View o;
    public TopicMediaHolder p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public TbCyberVideoView.h u;
    public Handler v;
    public CyberPlayerManager.OnErrorListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f21067e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21067e = kVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (!this.f21067e.r) {
                    BdToast.i(this.f21067e.n.getPageContext().getPageActivity(), this.f21067e.n.getPageContext().getResources().getString(c.a.r0.p1.h.pb_play_error), c.a.r0.p1.d.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f21067e.B0();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.p == null || this.a.p.mThumbnailImage == null || this.a.p.mReplayLayout == null || this.a.p.mVideoView == null) {
                return;
            }
            this.a.p.mThumbnailImage.setVisibility(0);
            this.a.p.mReplayLayout.setVisibility(8);
            this.a.p.mVideoView.stopPlayback();
            this.a.r = true;
            k kVar = this.a;
            kVar.w0(kVar.p);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.p == null || this.a.p.mTopicLayoutVideoView == null) {
                return;
            }
            int[] iArr = new int[2];
            this.a.p.mTopicLayoutVideoView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.a.p.mTopicLayoutVideoView.getHeight();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(k kVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.v != null) {
                    this.a.v.removeMessages(1);
                }
                if (this.a.p == null || this.a.p.mControllerView == null || this.a.p.mVideoProgressView == null) {
                    return;
                }
                this.a.p.mControllerView.destroy();
                this.a.p.mVideoProgressView.destroy();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21069f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21070g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21070g = kVar;
            this.f21068e = topicMediaHolder;
            this.f21069f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21068e.mReplayLayout.setVisibility(8);
                TbCyberVideoView tbCyberVideoView = this.f21068e.mVideoView;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f21068e.mVideoView.start();
                this.f21070g.E0(this.f21069f, this.f21068e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21073g;

        public h(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21073g = kVar;
            this.f21071e = topicMediaHolder;
            this.f21072f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (topicMediaHolder = this.f21071e) == null || topicMediaHolder.mVideoView == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f21071e.mVideoView.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f21071e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.mControllerView;
                topicMediaHolder2.mVideoView.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f21073g.v.obtainMessage(1);
            obtainMessage.obj = this.f21072f;
            this.f21073g.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21076g;

        public i(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21076g = kVar;
            this.f21074e = topicMediaHolder;
            this.f21075f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21074e.mReplayLayout.setVisibility(0);
                this.f21076g.x0(this.f21075f, this.f21074e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21078f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21079g;

        public j(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21079g = kVar;
            this.f21077e = topicMediaHolder;
            this.f21078f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f21077e.mVideoView.isPlaying()) {
                    this.f21079g.t0(this.f21077e, this.f21078f);
                    return;
                }
                this.f21077e.mVideoView.pause();
                this.f21077e.mBtnPausePlay.setVisibility(0);
            }
        }
    }

    /* renamed from: c.a.r0.p1.j.k$k  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1245k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21080e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f21081f;

        public View$OnClickListenerC1245k(k kVar, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21081f = kVar;
            this.f21080e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21081f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f21081f.n.getActivity()).createNormalConfig(String.valueOf(this.f21080e.f21186e), this.f21080e.f21187f, "")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f21082e;

        public l(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21082e = kVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f21082e.p != null && this.f21082e.p.mVideoView != null) {
                    this.f21082e.p.mVideoView.stopPlayback();
                }
                this.f21082e.B0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(k kVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.a.r || this.a.p == null || this.a.p.mVideoView == null || this.a.p.mThumbnailImage == null || this.a.p.mReplayLayout == null || this.a.p.mBtnPausePlay == null) {
                return;
            }
            if (this.a.p.mVideoView.getCurrentPosition() > 0) {
                this.a.p.mThumbnailImage.setVisibility(8);
                this.a.p.mReplayLayout.setVisibility(8);
                this.a.p.mBtnPausePlay.setVisibility(8);
                k kVar = this.a;
                kVar.E0((c.a.r0.p1.l.o) message.obj, kVar.p);
                k kVar2 = this.a;
                kVar2.w0(kVar2.p);
                return;
            }
            Message obtainMessage = this.a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes6.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.p1.l.o f21084f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21085g;

        public n(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, topicMediaHolder, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21085g = kVar;
            this.f21083e = topicMediaHolder;
            this.f21084f = oVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f21083e;
                if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.mVideoView) != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f21085g.u0(this.f21083e, this.f21084f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.p1.l.o f21086e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f21087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21088g;

        /* loaded from: classes6.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f21089e;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21089e = pVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21089e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public p(k kVar, c.a.r0.p1.l.o oVar, TopicMediaHolder topicMediaHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar, topicMediaHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21088g = kVar;
            this.f21086e = oVar;
            this.f21087f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21086e == null || (topicMediaHolder = this.f21087f) == null || (tbCyberVideoView = topicMediaHolder.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f21087f.mVideoView.setVideoPath(this.f21086e.f21189h);
            this.f21087f.mVideoView.start();
            this.f21088g.r = false;
            this.f21088g.D0(this.f21087f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f21086e == null || (topicMediaHolder = this.f21087f) == null || (view2 = topicMediaHolder.mLoadingLayout) == null || topicMediaHolder.mVideoView == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f21087f.mVideoView.stopPlayback();
                this.f21088g.r = true;
                this.f21088g.w0(this.f21087f);
            } else if (c.a.d.f.p.j.x()) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f21088g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(c.a.r0.p1.h.play_video_mobile_tip));
                aVar.setPositiveButton(c.a.r0.p1.h.confirm, new a(this));
                aVar.setNegativeButton(c.a.r0.p1.h.cancel, new b(this));
                aVar.create(this.f21088g.n.getPageContext()).show();
            } else {
                b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = new l(this);
        this.v = new m(this, Looper.getMainLooper());
        this.w = new b(this);
        this.x = new c(this, 2004011);
        this.y = new d(this, 2004012);
        this.z = new e(this, 2004013);
        this.A = new f(this, 2004014);
        this.n = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.x);
            baseActivity.registerListener(this.y);
            baseActivity.registerListener(this.z);
            baseActivity.registerListener(this.A);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q = false;
        }
    }

    public final void B0() {
        TopicMediaHolder topicMediaHolder;
        ForeDrawableImageView foreDrawableImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (topicMediaHolder = this.p) == null || (foreDrawableImageView = topicMediaHolder.mThumbnailImage) == null || topicMediaHolder.mReplayLayout == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.mReplayLayout.setVisibility(8);
        this.r = true;
        w0(this.p);
        C0(this.p);
    }

    public final void C0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, topicMediaHolder) == null) || topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null || topicMediaHolder.mVideoProgressView == null) {
            return;
        }
        topicVideoControllerView.resetProgress();
        topicMediaHolder.mVideoProgressView.resetProgress();
    }

    public final void D0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(0);
        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
    }

    public final void E0(c.a.r0.p1.l.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, oVar, topicMediaHolder) == null) || oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.showProgress();
        } else {
            topicMediaHolder.mControllerView.showProgress();
        }
    }

    public final void t0(TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, topicMediaHolder, oVar) == null) {
            if (c.a.d.f.p.j.x()) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(c.a.r0.p1.h.play_video_mobile_tip));
                aVar.setPositiveButton(c.a.r0.p1.h.confirm, new n(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(c.a.r0.p1.h.cancel, new o(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            u0(topicMediaHolder, oVar);
        }
    }

    public final void u0(TopicMediaHolder topicMediaHolder, c.a.r0.p1.l.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, topicMediaHolder, oVar) == null) {
            topicMediaHolder.mVideoView.start();
            topicMediaHolder.mBtnPausePlay.setVisibility(8);
            topicMediaHolder.mReplayLayout.setVisibility(8);
            E0(oVar, topicMediaHolder);
        }
    }

    public final void v0() {
        TopicMediaHolder topicMediaHolder;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (topicMediaHolder = this.p) == null || (tbCyberVideoView = topicMediaHolder.mVideoView) == null || topicMediaHolder.mBtnPausePlay == null || topicMediaHolder.mLoadingLayout == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.mVideoView.pause();
            this.p.mBtnPausePlay.setVisibility(0);
        } else if (this.p.mLoadingLayout.getVisibility() == 0) {
            this.p.mVideoView.stopPlayback();
            this.r = true;
            w0(this.p);
        }
    }

    public final void w0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(8);
        if (this.t) {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
        } else {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(c.a.r0.p1.d.icon_play_video);
        }
    }

    public final void x0(c.a.r0.p1.l.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f21189h) && oVar.f21190i > 0) {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f21191j, 17, false);
        } else {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f21188g, 17, false);
        }
        topicMediaHolder.mThumbnailImage.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.f21191j)) {
            topicMediaHolder.mThumbnailImage.setEvent(new a(this));
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.initProgress();
        } else {
            topicMediaHolder.mControllerView.initCurTimeAndDuration(0, oVar.f21190i * 1000);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: y0 */
    public TopicMediaHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            if (this.o == null) {
                this.o = LayoutInflater.from(this.f2907e).inflate(c.a.r0.p1.f.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(c.a.r0.p1.e.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k2 = c.a.d.f.p.l.k(this.f2907e);
                if (layoutParams != null) {
                    layoutParams.height = (int) (k2 / 1.8d);
                    findViewById.setLayoutParams(layoutParams);
                }
            } else {
                B0();
            }
            return this.p;
        }
        return (TopicMediaHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: z0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.p1.l.o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f21189h) && oVar.f21190i > 0) {
                        this.t = false;
                        topicMediaHolder.mCoverView.setVisibility(0);
                        if (this.s) {
                            topicMediaHolder.mControllerView.setVisibility(8);
                            topicMediaHolder.mVideoProgressView.setVisibility(0);
                        } else {
                            topicMediaHolder.mControllerView.setVisibility(0);
                            topicMediaHolder.mVideoProgressView.setVisibility(8);
                        }
                    } else {
                        this.t = true;
                        topicMediaHolder.mControllerView.setVisibility(8);
                        topicMediaHolder.mVideoProgressView.setVisibility(8);
                        topicMediaHolder.mCoverView.setVisibility(8);
                    }
                    if (!StringUtils.isNull(oVar.f21189h) && oVar.f21190i > 0) {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(c.a.r0.p1.d.icon_play_video);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(new p(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(null);
                    }
                    topicMediaHolder.mThumbnailImage.setTag(Integer.valueOf(i2));
                    topicMediaHolder.mThumbnailImage.setDefaultResource(0);
                    if (!c.a.q0.s.k.c().g()) {
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextColor(c.a.r0.p1.b.CAM_X0108);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.r0.p1.c.ds32));
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(c.a.r0.p1.c.fontsize28));
                        topicMediaHolder.mThumbnailImage.setSupportNoImage(true);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomText(TbadkCoreApplication.getInst().getString(c.a.r0.p1.h.click_to_play));
                    } else {
                        topicMediaHolder.mThumbnailImage.setDefaultBgResource(c.a.r0.p1.d.pic_bg_video_frs);
                        if (!topicMediaHolder.mVideoView.isPlaying()) {
                            x0(oVar, topicMediaHolder);
                        }
                    }
                    topicMediaHolder.mBtnReplay.setOnClickListener(new g(this, topicMediaHolder, oVar));
                    topicMediaHolder.mVideoView.setOnPreparedListener(new h(this, topicMediaHolder, oVar));
                    topicMediaHolder.mVideoView.setOnCompletionListener(new i(this, topicMediaHolder, oVar));
                    topicMediaHolder.mVideoView.setOnErrorListener(this.w);
                    topicMediaHolder.mVideoView.setOnSurfaceDestroyedListener(this.u);
                    topicMediaHolder.mCoverView.setOnClickListener(new j(this, topicMediaHolder, oVar));
                    if (this.s) {
                        topicMediaHolder.mVideoProgressView.setPlayer(topicMediaHolder.mVideoView);
                    } else {
                        topicMediaHolder.mControllerView.setPlayer(topicMediaHolder.mVideoView);
                    }
                    if (StringUtils.isNull(oVar.f21187f)) {
                        topicMediaHolder.mVedioTitle.setVisibility(8);
                        topicMediaHolder.mVedioLine.setVisibility(8);
                    } else {
                        topicMediaHolder.mVedioTitle.setVisibility(0);
                        topicMediaHolder.mVedioLine.setVisibility(0);
                        topicMediaHolder.mVedioTitle.setText(oVar.f21187f);
                        topicMediaHolder.mVedioTitle.setOnClickListener(new View$OnClickListenerC1245k(this, oVar));
                    }
                }
                if (topicMediaHolder.skinType != this.m) {
                    SkinManager.setBackgroundColor(view, c.a.r0.p1.b.CAM_X0201);
                    topicMediaHolder.mControllerView.onChangeSkinType(this.m);
                    SkinManager.setImageResource(topicMediaHolder.mBtnPausePlay, c.a.r0.p1.d.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.mBtnReplay, c.a.r0.p1.b.CAM_X0101, 1);
                    topicMediaHolder.mVideoProgressView.onChangeSkinType(this.m);
                    topicMediaHolder.mBtnReplay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, c.a.r0.p1.d.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.mVedioTitle, c.a.r0.p1.b.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.mVedioLine, c.a.r0.p1.b.CAM_X0204);
                }
                topicMediaHolder.skinType = this.m;
            }
            return this.o;
        }
        return (View) invokeCommon.objValue;
    }
}
