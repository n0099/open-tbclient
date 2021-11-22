package b.a.r0.j1.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.a;
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
/* loaded from: classes4.dex */
public class k extends b.a.e.m.e.a<b.a.r0.j1.l.o, TopicMediaHolder> {
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19697e;

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
            this.f19697e = kVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (!this.f19697e.r) {
                    BdToast.i(this.f19697e.n.getPageContext().getPageActivity(), this.f19697e.n.getPageContext().getResources().getString(b.a.r0.j1.h.pb_play_error), b.a.r0.j1.d.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f19697e.B0();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19698a;

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
            this.f19698a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19698a.v0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19699a;

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
            this.f19699a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19699a.p == null || this.f19699a.p.mThumbnailImage == null || this.f19699a.p.mReplayLayout == null || this.f19699a.p.mVideoView == null) {
                return;
            }
            this.f19699a.p.mThumbnailImage.setVisibility(0);
            this.f19699a.p.mReplayLayout.setVisibility(8);
            this.f19699a.p.mVideoView.stopPlayback();
            this.f19699a.r = true;
            k kVar = this.f19699a;
            kVar.w0(kVar.p);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19700a;

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
            this.f19700a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19700a.p == null || this.f19700a.p.mTopicLayoutVideoView == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f19700a.p.mTopicLayoutVideoView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.f19700a.p.mTopicLayoutVideoView.getHeight();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19701a;

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
            this.f19701a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f19701a.v != null) {
                    this.f19701a.v.removeMessages(1);
                }
                if (this.f19701a.p == null || this.f19701a.p.mControllerView == null || this.f19701a.p.mVideoProgressView == null) {
                    return;
                }
                this.f19701a.p.mControllerView.destroy();
                this.f19701a.p.mVideoProgressView.destroy();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19704g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            this.f19704g = kVar;
            this.f19702e = topicMediaHolder;
            this.f19703f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19702e.mReplayLayout.setVisibility(8);
                TbCyberVideoView tbCyberVideoView = this.f19702e.mVideoView;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f19702e.mVideoView.start();
                this.f19704g.E0(this.f19703f, this.f19702e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19707g;

        public h(k kVar, TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            this.f19707g = kVar;
            this.f19705e = topicMediaHolder;
            this.f19706f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (topicMediaHolder = this.f19705e) == null || topicMediaHolder.mVideoView == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f19705e.mVideoView.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f19705e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.mControllerView;
                topicMediaHolder2.mVideoView.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f19707g.v.obtainMessage(1);
            obtainMessage.obj = this.f19706f;
            this.f19707g.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19710g;

        public i(k kVar, TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            this.f19710g = kVar;
            this.f19708e = topicMediaHolder;
            this.f19709f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19708e.mReplayLayout.setVisibility(0);
                this.f19710g.x0(this.f19709f, this.f19708e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19711e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19712f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19713g;

        public j(k kVar, TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            this.f19713g = kVar;
            this.f19711e = topicMediaHolder;
            this.f19712f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f19711e.mVideoView.isPlaying()) {
                    this.f19713g.t0(this.f19711e, this.f19712f);
                    return;
                }
                this.f19711e.mVideoView.pause();
                this.f19711e.mBtnPausePlay.setVisibility(0);
            }
        }
    }

    /* renamed from: b.a.r0.j1.j.k$k  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0993k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f19715f;

        public View$OnClickListenerC0993k(k kVar, b.a.r0.j1.l.o oVar) {
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
            this.f19715f = kVar;
            this.f19714e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19715f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f19715f.n.getActivity()).createNormalConfig(String.valueOf(this.f19714e.f19814e), this.f19714e.f19815f, "")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19716e;

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
            this.f19716e = kVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19716e.p != null && this.f19716e.p.mVideoView != null) {
                    this.f19716e.p.mVideoView.stopPlayback();
                }
                this.f19716e.B0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19717a;

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
            this.f19717a = kVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.f19717a.r || this.f19717a.p == null || this.f19717a.p.mVideoView == null || this.f19717a.p.mThumbnailImage == null || this.f19717a.p.mReplayLayout == null || this.f19717a.p.mBtnPausePlay == null) {
                return;
            }
            if (this.f19717a.p.mVideoView.getCurrentPosition() > 0) {
                this.f19717a.p.mThumbnailImage.setVisibility(8);
                this.f19717a.p.mReplayLayout.setVisibility(8);
                this.f19717a.p.mBtnPausePlay.setVisibility(8);
                k kVar = this.f19717a;
                kVar.E0((b.a.r0.j1.l.o) message.obj, kVar.p);
                k kVar2 = this.f19717a;
                kVar2.w0(kVar2.p);
                return;
            }
            Message obtainMessage = this.f19717a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.f19717a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.j1.l.o f19719f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19720g;

        public n(k kVar, TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            this.f19720g = kVar;
            this.f19718e = topicMediaHolder;
            this.f19719f = oVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f19718e;
                if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.mVideoView) != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f19720g.u0(this.f19718e, this.f19719f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.j1.l.o f19721e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f19722f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19723g;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f19724e;

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
                this.f19724e = pVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f19724e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public p(k kVar, b.a.r0.j1.l.o oVar, TopicMediaHolder topicMediaHolder) {
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
            this.f19723g = kVar;
            this.f19721e = oVar;
            this.f19722f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19721e == null || (topicMediaHolder = this.f19722f) == null || (tbCyberVideoView = topicMediaHolder.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f19722f.mVideoView.setVideoPath(this.f19721e.f19817h);
            this.f19722f.mVideoView.start();
            this.f19723g.r = false;
            this.f19723g.D0(this.f19722f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f19721e == null || (topicMediaHolder = this.f19722f) == null || (view2 = topicMediaHolder.mLoadingLayout) == null || topicMediaHolder.mVideoView == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f19722f.mVideoView.stopPlayback();
                this.f19723g.r = true;
                this.f19723g.w0(this.f19722f);
            } else if (b.a.e.f.p.j.x()) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19723g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.play_video_mobile_tip));
                aVar.setPositiveButton(b.a.r0.j1.h.confirm, new a(this));
                aVar.setNegativeButton(b.a.r0.j1.h.cancel, new b(this));
                aVar.create(this.f19723g.n.getPageContext()).show();
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

    public final void E0(b.a.r0.j1.l.o oVar, TopicMediaHolder topicMediaHolder) {
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

    public final void t0(TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, topicMediaHolder, oVar) == null) {
            if (b.a.e.f.p.j.x()) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.play_video_mobile_tip));
                aVar.setPositiveButton(b.a.r0.j1.h.confirm, new n(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(b.a.r0.j1.h.cancel, new o(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            u0(topicMediaHolder, oVar);
        }
    }

    public final void u0(TopicMediaHolder topicMediaHolder, b.a.r0.j1.l.o oVar) {
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
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(b.a.r0.j1.d.icon_play_video);
        }
    }

    public final void x0(b.a.r0.j1.l.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f19817h) && oVar.f19818i > 0) {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.j, 17, false);
        } else {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f19816g, 17, false);
        }
        topicMediaHolder.mThumbnailImage.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.j)) {
            topicMediaHolder.mThumbnailImage.setEvent(new a(this));
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.initProgress();
        } else {
            topicMediaHolder.mControllerView.initCurTimeAndDuration(0, oVar.f19818i * 1000);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: y0 */
    public TopicMediaHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            if (this.o == null) {
                this.o = LayoutInflater.from(this.f2421e).inflate(b.a.r0.j1.f.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(b.a.r0.j1.e.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k = b.a.e.f.p.l.k(this.f2421e);
                if (layoutParams != null) {
                    layoutParams.height = (int) (k / 1.8d);
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
    @Override // b.a.e.m.e.a
    /* renamed from: z0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.j1.l.o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f19817h) && oVar.f19818i > 0) {
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
                    if (!StringUtils.isNull(oVar.f19817h) && oVar.f19818i > 0) {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(b.a.r0.j1.d.icon_play_video);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(new p(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(null);
                    }
                    topicMediaHolder.mThumbnailImage.setTag(Integer.valueOf(i2));
                    topicMediaHolder.mThumbnailImage.setDefaultResource(0);
                    if (!b.a.q0.s.k.c().g()) {
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextColor(b.a.r0.j1.b.CAM_X0108);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds32));
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(b.a.r0.j1.c.fontsize28));
                        topicMediaHolder.mThumbnailImage.setSupportNoImage(true);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomText(TbadkCoreApplication.getInst().getString(b.a.r0.j1.h.click_to_play));
                    } else {
                        topicMediaHolder.mThumbnailImage.setDefaultBgResource(b.a.r0.j1.d.pic_bg_video_frs);
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
                    if (StringUtils.isNull(oVar.f19815f)) {
                        topicMediaHolder.mVedioTitle.setVisibility(8);
                        topicMediaHolder.mVedioLine.setVisibility(8);
                    } else {
                        topicMediaHolder.mVedioTitle.setVisibility(0);
                        topicMediaHolder.mVedioLine.setVisibility(0);
                        topicMediaHolder.mVedioTitle.setText(oVar.f19815f);
                        topicMediaHolder.mVedioTitle.setOnClickListener(new View$OnClickListenerC0993k(this, oVar));
                    }
                }
                if (topicMediaHolder.skinType != this.m) {
                    SkinManager.setBackgroundColor(view, b.a.r0.j1.b.CAM_X0201);
                    topicMediaHolder.mControllerView.onChangeSkinType(this.m);
                    SkinManager.setImageResource(topicMediaHolder.mBtnPausePlay, b.a.r0.j1.d.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.mBtnReplay, b.a.r0.j1.b.CAM_X0101, 1);
                    topicMediaHolder.mVideoProgressView.onChangeSkinType(this.m);
                    topicMediaHolder.mBtnReplay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, b.a.r0.j1.d.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.mVedioTitle, b.a.r0.j1.b.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.mVedioLine, b.a.r0.j1.b.CAM_X0204);
                }
                topicMediaHolder.skinType = this.m;
            }
            return this.o;
        }
        return (View) invokeCommon.objValue;
    }
}
