package c.a.r0.j1.a;

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
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k extends c.a.e.l.e.a<c.a.r0.j1.c.o, TopicMediaHolder> {
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19375e;

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
            this.f19375e = kVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (!this.f19375e.r) {
                    BdToast.i(this.f19375e.n.getPageContext().getPageActivity(), this.f19375e.n.getPageContext().getResources().getString(R.string.pb_play_error), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f19375e.C0();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19376a;

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
            this.f19376a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19376a.w0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19377a;

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
            this.f19377a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19377a.p == null || this.f19377a.p.mThumbnailImage == null || this.f19377a.p.mReplayLayout == null || this.f19377a.p.mVideoView == null) {
                return;
            }
            this.f19377a.p.mThumbnailImage.setVisibility(0);
            this.f19377a.p.mReplayLayout.setVisibility(8);
            this.f19377a.p.mVideoView.stopPlayback();
            this.f19377a.r = true;
            k kVar = this.f19377a;
            kVar.x0(kVar.p);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19378a;

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
            this.f19378a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19378a.p == null || this.f19378a.p.mTopicLayoutVideoView == null) {
                return;
            }
            int[] iArr = new int[2];
            this.f19378a.p.mTopicLayoutVideoView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.f19378a.p.mTopicLayoutVideoView.getHeight();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19379a;

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
            this.f19379a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f19379a.v != null) {
                    this.f19379a.v.removeMessages(1);
                }
                if (this.f19379a.p == null || this.f19379a.p.mControllerView == null || this.f19379a.p.mVideoProgressView == null) {
                    return;
                }
                this.f19379a.p.mControllerView.destroy();
                this.f19379a.p.mVideoProgressView.destroy();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19382g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
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
            this.f19382g = kVar;
            this.f19380e = topicMediaHolder;
            this.f19381f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19380e.mReplayLayout.setVisibility(8);
                TbCyberVideoView tbCyberVideoView = this.f19380e.mVideoView;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f19380e.mVideoView.start();
                this.f19382g.F0(this.f19381f, this.f19380e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19385g;

        public h(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
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
            this.f19385g = kVar;
            this.f19383e = topicMediaHolder;
            this.f19384f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (topicMediaHolder = this.f19383e) == null || topicMediaHolder.mVideoView == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f19383e.mVideoView.getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f19383e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.mControllerView;
                topicMediaHolder2.mVideoView.seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f19385g.v.obtainMessage(1);
            obtainMessage.obj = this.f19384f;
            this.f19385g.v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19387f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19388g;

        public i(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
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
            this.f19388g = kVar;
            this.f19386e = topicMediaHolder;
            this.f19387f = oVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19386e.mReplayLayout.setVisibility(0);
                this.f19388g.y0(this.f19387f, this.f19386e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19390f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19391g;

        public j(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
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
            this.f19391g = kVar;
            this.f19389e = topicMediaHolder;
            this.f19390f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f19389e.mVideoView.isPlaying()) {
                    this.f19391g.u0(this.f19389e, this.f19390f);
                    return;
                }
                this.f19389e.mVideoView.pause();
                this.f19389e.mBtnPausePlay.setVisibility(0);
            }
        }
    }

    /* renamed from: c.a.r0.j1.a.k$k  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0934k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f19393f;

        public View$OnClickListenerC0934k(k kVar, c.a.r0.j1.c.o oVar) {
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
            this.f19393f = kVar;
            this.f19392e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19393f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f19393f.n.getActivity()).createNormalConfig(String.valueOf(this.f19392e.f19501e), this.f19392e.f19502f, "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19394e;

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
            this.f19394e = kVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19394e.p != null && this.f19394e.p.mVideoView != null) {
                    this.f19394e.p.mVideoView.stopPlayback();
                }
                this.f19394e.C0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19395a;

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
            this.f19395a = kVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.f19395a.r || this.f19395a.p == null || this.f19395a.p.mVideoView == null || this.f19395a.p.mThumbnailImage == null || this.f19395a.p.mReplayLayout == null || this.f19395a.p.mBtnPausePlay == null) {
                return;
            }
            if (this.f19395a.p.mVideoView.getCurrentPosition() > 0) {
                this.f19395a.p.mThumbnailImage.setVisibility(8);
                this.f19395a.p.mReplayLayout.setVisibility(8);
                this.f19395a.p.mBtnPausePlay.setVisibility(8);
                k kVar = this.f19395a;
                kVar.F0((c.a.r0.j1.c.o) message.obj, kVar.p);
                k kVar2 = this.f19395a;
                kVar2.x0(kVar2.p);
                return;
            }
            Message obtainMessage = this.f19395a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.f19395a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f19396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j1.c.o f19397f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19398g;

        public n(k kVar, TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
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
            this.f19398g = kVar;
            this.f19396e = topicMediaHolder;
            this.f19397f = oVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f19396e;
                if (topicMediaHolder != null && (tbCyberVideoView = topicMediaHolder.mVideoView) != null) {
                    tbCyberVideoView.setPlayMode("2");
                }
                this.f19398g.v0(this.f19396e, this.f19397f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.j1.c.o f19399e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f19400f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19401g;

        /* loaded from: classes3.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ p f19402e;

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
                this.f19402e = pVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f19402e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
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

        public p(k kVar, c.a.r0.j1.c.o oVar, TopicMediaHolder topicMediaHolder) {
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
            this.f19401g = kVar;
            this.f19399e = oVar;
            this.f19400f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19399e == null || (topicMediaHolder = this.f19400f) == null || (tbCyberVideoView = topicMediaHolder.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.setPlayMode("2");
            this.f19400f.mVideoView.setVideoPath(this.f19399e.f19504h);
            this.f19400f.mVideoView.start();
            this.f19401g.r = false;
            this.f19401g.E0(this.f19400f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f19399e == null || (topicMediaHolder = this.f19400f) == null || (view2 = topicMediaHolder.mLoadingLayout) == null || topicMediaHolder.mVideoView == null) {
                return;
            }
            if (view2.getVisibility() == 0) {
                this.f19400f.mVideoView.stopPlayback();
                this.f19401g.r = true;
                this.f19401g.x0(this.f19400f);
            } else if (c.a.e.e.p.j.x()) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f19401g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new a(this));
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.create(this.f19401g.n.getPageContext()).show();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: A0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.j1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f19504h) && oVar.f19505i > 0) {
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
                    if (!StringUtils.isNull(oVar.f19504h) && oVar.f19505i > 0) {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(R.drawable.icon_play_video);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(new p(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(null);
                    }
                    topicMediaHolder.mThumbnailImage.setTag(Integer.valueOf(i2));
                    topicMediaHolder.mThumbnailImage.setDefaultResource(0);
                    if (!c.a.q0.s.k.c().g()) {
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextColor(R.color.CAM_X0108);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                        topicMediaHolder.mThumbnailImage.setSupportNoImage(true);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomText(TbadkCoreApplication.getInst().getString(R.string.click_to_play));
                    } else {
                        topicMediaHolder.mThumbnailImage.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                        if (!topicMediaHolder.mVideoView.isPlaying()) {
                            y0(oVar, topicMediaHolder);
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
                    if (StringUtils.isNull(oVar.f19502f)) {
                        topicMediaHolder.mVedioTitle.setVisibility(8);
                        topicMediaHolder.mVedioLine.setVisibility(8);
                    } else {
                        topicMediaHolder.mVedioTitle.setVisibility(0);
                        topicMediaHolder.mVedioLine.setVisibility(0);
                        topicMediaHolder.mVedioTitle.setText(oVar.f19502f);
                        topicMediaHolder.mVedioTitle.setOnClickListener(new View$OnClickListenerC0934k(this, oVar));
                    }
                }
                if (topicMediaHolder.skinType != this.m) {
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                    topicMediaHolder.mControllerView.onChangeSkinType(this.m);
                    SkinManager.setImageResource(topicMediaHolder.mBtnPausePlay, R.drawable.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.mBtnReplay, R.color.CAM_X0101, 1);
                    topicMediaHolder.mVideoProgressView.onChangeSkinType(this.m);
                    topicMediaHolder.mBtnReplay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, R.drawable.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.mVedioTitle, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.mVedioLine, R.color.CAM_X0204);
                }
                topicMediaHolder.skinType = this.m;
            }
            return this.o;
        }
        return (View) invokeCommon.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q = false;
        }
    }

    public final void C0() {
        TopicMediaHolder topicMediaHolder;
        ForeDrawableImageView foreDrawableImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (topicMediaHolder = this.p) == null || (foreDrawableImageView = topicMediaHolder.mThumbnailImage) == null || topicMediaHolder.mReplayLayout == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.mReplayLayout.setVisibility(8);
        this.r = true;
        x0(this.p);
        D0(this.p);
    }

    public final void D0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicMediaHolder) == null) || topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null || topicMediaHolder.mVideoProgressView == null) {
            return;
        }
        topicVideoControllerView.resetProgress();
        topicMediaHolder.mVideoProgressView.resetProgress();
    }

    public final void E0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(0);
        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
    }

    public final void F0(c.a.r0.j1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, oVar, topicMediaHolder) == null) || oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.showProgress();
        } else {
            topicMediaHolder.mControllerView.showProgress();
        }
    }

    public final void u0(TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, topicMediaHolder, oVar) == null) {
            if (c.a.e.e.p.j.x()) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new n(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(R.string.cancel, new o(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            v0(topicMediaHolder, oVar);
        }
    }

    public final void v0(TopicMediaHolder topicMediaHolder, c.a.r0.j1.c.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, topicMediaHolder, oVar) == null) {
            topicMediaHolder.mVideoView.start();
            topicMediaHolder.mBtnPausePlay.setVisibility(8);
            topicMediaHolder.mReplayLayout.setVisibility(8);
            F0(oVar, topicMediaHolder);
        }
    }

    public final void w0() {
        TopicMediaHolder topicMediaHolder;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (topicMediaHolder = this.p) == null || (tbCyberVideoView = topicMediaHolder.mVideoView) == null || topicMediaHolder.mBtnPausePlay == null || topicMediaHolder.mLoadingLayout == null) {
            return;
        }
        if (tbCyberVideoView.isPlaying()) {
            this.p.mVideoView.pause();
            this.p.mBtnPausePlay.setVisibility(0);
        } else if (this.p.mLoadingLayout.getVisibility() == 0) {
            this.p.mVideoView.stopPlayback();
            this.r = true;
            x0(this.p);
        }
    }

    public final void x0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(8);
        if (this.t) {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
        } else {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(R.drawable.icon_play_video);
        }
    }

    public final void y0(c.a.r0.j1.c.o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f19504h) && oVar.f19505i > 0) {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f19506j, 17, false);
        } else {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f19503g, 17, false);
        }
        topicMediaHolder.mThumbnailImage.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.f19506j)) {
            topicMediaHolder.mThumbnailImage.setEvent(new a(this));
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.initProgress();
        } else {
            topicMediaHolder.mControllerView.initCurTimeAndDuration(0, oVar.f19505i * 1000);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: z0 */
    public TopicMediaHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, viewGroup)) == null) {
            if (this.o == null) {
                this.o = LayoutInflater.from(this.f2958e).inflate(R.layout.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(R.id.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k = c.a.e.e.p.l.k(this.f2958e);
                if (layoutParams != null) {
                    layoutParams.height = (int) (k / 1.8d);
                    findViewById.setLayoutParams(layoutParams);
                }
            } else {
                C0();
            }
            return this.p;
        }
        return (TopicMediaHolder) invokeL.objValue;
    }
}
