package c.a.t0.q1.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import c.a.s0.s.s.a;
import c.a.t0.q1.l.o;
import c.a.t0.z2.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.holder.TopicMediaHolder;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class k extends c.a.d.n.e.a<o, TopicMediaHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public BaseActivity<?> n;
    public View o;
    public TopicMediaHolder p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public TbVideoViewContainer.a u;
    public Handler v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, int i2) {
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
                this.a.o0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k kVar, int i2) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.p == null || this.a.p.mThumbnailImage == null || this.a.p.mReplayLayout == null || this.a.p.mTbVideoViewContainer == null || this.a.p.mTbVideoViewContainer.getControl() == null) {
                return;
            }
            this.a.p.mThumbnailImage.setVisibility(0);
            this.a.p.mReplayLayout.setVisibility(8);
            this.a.p.mTbVideoViewContainer.getControl().stopPlayback();
            this.a.r = true;
            k kVar = this.a;
            kVar.p0(kVar.p);
        }
    }

    /* loaded from: classes8.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.p == null || this.a.p.mTopicLayoutVideoView == null) {
                return;
            }
            int[] iArr = new int[2];
            this.a.p.mTopicLayoutVideoView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            this.a.p.mTopicLayoutVideoView.getHeight();
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o f21468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21469g;

        public e(k kVar, TopicMediaHolder topicMediaHolder, o oVar) {
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
            this.f21469g = kVar;
            this.f21467e = topicMediaHolder;
            this.f21468f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21467e.mReplayLayout.setVisibility(8);
                TbVideoViewContainer tbVideoViewContainer = this.f21467e.mTbVideoViewContainer;
                if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                    this.f21467e.mTbVideoViewContainer.getControl().setPlayMode("2");
                }
                this.f21467e.mTbVideoViewContainer.getControl().start();
                this.f21469g.x0(this.f21468f, this.f21467e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements c.a.t0.z2.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o f21471f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21472g;

        public f(k kVar, TopicMediaHolder topicMediaHolder, o oVar) {
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
            this.f21472g = kVar;
            this.f21470e = topicMediaHolder;
            this.f21471f = oVar;
        }

        @Override // c.a.t0.z2.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.t0.z2.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f21470e.mReplayLayout.setVisibility(0);
                this.f21472g.q0(this.f21471f, this.f21470e);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                if (!this.f21472g.r) {
                    BdToast.i(this.f21472g.n.getPageContext().getPageActivity(), this.f21472g.n.getPageContext().getResources().getString(c.a.t0.q1.h.pb_play_error), c.a.t0.q1.d.icon_pure_toast_mistake40_svg, true).q();
                }
                this.f21472g.u0();
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TopicMediaHolder topicMediaHolder;
            TbVideoViewContainer tbVideoViewContainer;
            TopicVideoControllerView topicVideoControllerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (topicMediaHolder = this.f21470e) == null || (tbVideoViewContainer = topicMediaHolder.mTbVideoViewContainer) == null || tbVideoViewContainer.getControl() == null || (topicVideoControllerView = this.f21470e.mControllerView) == null) {
                return;
            }
            int curProgress = topicVideoControllerView.getCurProgress();
            if (curProgress > 0) {
                float duration = this.f21470e.mTbVideoViewContainer.getControl().getDuration() * 1.0f * curProgress;
                TopicMediaHolder topicMediaHolder2 = this.f21470e;
                TopicVideoControllerView topicVideoControllerView2 = topicMediaHolder2.mControllerView;
                topicMediaHolder2.mTbVideoViewContainer.getControl().seekTo((int) (duration / 10000.0f));
            }
            Message obtainMessage = this.f21472g.v.obtainMessage(1);
            obtainMessage.obj = this.f21471f;
            this.f21472g.v.sendMessage(obtainMessage);
        }

        @Override // c.a.t0.z2.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.z2.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.t0.z2.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o f21474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21475g;

        public g(k kVar, TopicMediaHolder topicMediaHolder, o oVar) {
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
            this.f21475g = kVar;
            this.f21473e = topicMediaHolder;
            this.f21474f = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f21473e.mTbVideoViewContainer.getControl().isPlaying()) {
                    this.f21475g.m0(this.f21473e, this.f21474f);
                    return;
                }
                this.f21473e.mTbVideoViewContainer.getControl().pause();
                this.f21473e.mBtnPausePlay.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f21476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f21477f;

        public h(k kVar, o oVar) {
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
            this.f21477f = kVar;
            this.f21476e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21477f.n.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f21477f.n.getActivity()).createNormalConfig(String.valueOf(this.f21476e.f21575e), this.f21476e.f21576f, "")));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f21478e;

        public i(k kVar) {
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
            this.f21478e = kVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f21478e.p != null && this.f21478e.p.mTbVideoViewContainer != null && this.f21478e.p.mTbVideoViewContainer.getControl() != null) {
                    this.f21478e.p.mTbVideoViewContainer.getControl().stopPlayback();
                }
                this.f21478e.u0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(k kVar, Looper looper) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 1 || this.a.r || this.a.p == null || this.a.p.mTbVideoViewContainer == null || this.a.p.mTbVideoViewContainer.getControl() == null || this.a.p.mThumbnailImage == null || this.a.p.mReplayLayout == null || this.a.p.mBtnPausePlay == null) {
                return;
            }
            if (this.a.p.mTbVideoViewContainer.getControl().getCurrentPosition() > 0) {
                this.a.p.mThumbnailImage.setVisibility(8);
                this.a.p.mReplayLayout.setVisibility(8);
                this.a.p.mBtnPausePlay.setVisibility(8);
                k kVar = this.a;
                kVar.x0((o) message.obj, kVar.p);
                k kVar2 = this.a;
                kVar2.p0(kVar2.p);
                return;
            }
            Message obtainMessage = this.a.v.obtainMessage(1);
            obtainMessage.obj = message.obj;
            this.a.v.sendMessageDelayed(obtainMessage, 50L);
        }
    }

    /* renamed from: c.a.t0.q1.j.k$k  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1337k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicMediaHolder f21479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o f21480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21481g;

        public C1337k(k kVar, TopicMediaHolder topicMediaHolder, o oVar) {
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
            this.f21481g = kVar;
            this.f21479e = topicMediaHolder;
            this.f21480f = oVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TopicMediaHolder topicMediaHolder = this.f21479e;
                if (topicMediaHolder != null && (tbVideoViewContainer = topicMediaHolder.mTbVideoViewContainer) != null && tbVideoViewContainer.getControl() != null) {
                    this.f21479e.mTbVideoViewContainer.getControl().setPlayMode("2");
                }
                this.f21481g.n0(this.f21479e, this.f21480f);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class m implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(k kVar) {
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

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public o f21482e;

        /* renamed from: f  reason: collision with root package name */
        public TopicMediaHolder f21483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f21484g;

        /* loaded from: classes8.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f21485e;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21485e = nVar;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21485e.b();
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
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

        public n(k kVar, o oVar, TopicMediaHolder topicMediaHolder) {
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
            this.f21484g = kVar;
            this.f21482e = oVar;
            this.f21483f = topicMediaHolder;
        }

        public final void b() {
            TopicMediaHolder topicMediaHolder;
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21482e == null || (topicMediaHolder = this.f21483f) == null || (tbVideoViewContainer = topicMediaHolder.mTbVideoViewContainer) == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            this.f21483f.mTbVideoViewContainer.getControl().setPlayMode("2");
            this.f21483f.mTbVideoViewContainer.getControl().setVideoPath(this.f21482e.f21578h);
            this.f21483f.mTbVideoViewContainer.getControl().start();
            this.f21484g.r = false;
            this.f21484g.w0(this.f21483f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicMediaHolder topicMediaHolder;
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f21482e == null || (topicMediaHolder = this.f21483f) == null || topicMediaHolder.mLoadingLayout == null || (tbVideoViewContainer = topicMediaHolder.mTbVideoViewContainer) == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            if (this.f21483f.mLoadingLayout.getVisibility() == 0) {
                this.f21483f.mTbVideoViewContainer.getControl().stopPlayback();
                this.f21484g.r = true;
                this.f21484g.p0(this.f21483f);
            } else if (c.a.d.f.p.l.x()) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f21484g.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(c.a.t0.q1.h.play_video_mobile_tip));
                aVar.setPositiveButton(c.a.t0.q1.h.confirm, new a(this));
                aVar.setNegativeButton(c.a.t0.q1.h.cancel, new b(this));
                aVar.create(this.f21484g.n.getPageContext()).show();
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
        this.u = new i(this);
        this.v = new j(this, Looper.getMainLooper());
        this.w = new a(this, 2004011);
        this.x = new b(this, 2004012);
        this.y = new c(this, 2004013);
        this.z = new d(this, 2004014);
        this.n = baseActivity;
        if (baseActivity != null) {
            baseActivity.registerListener(this.w);
            baseActivity.registerListener(this.x);
            baseActivity.registerListener(this.y);
            baseActivity.registerListener(this.z);
        }
    }

    public final void m0(TopicMediaHolder topicMediaHolder, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topicMediaHolder, oVar) == null) {
            if (c.a.d.f.p.l.x()) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.n.getPageContext().getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(c.a.t0.q1.h.play_video_mobile_tip));
                aVar.setPositiveButton(c.a.t0.q1.h.confirm, new C1337k(this, topicMediaHolder, oVar));
                aVar.setNegativeButton(c.a.t0.q1.h.cancel, new l(this));
                aVar.create(this.n.getPageContext()).show();
                return;
            }
            n0(topicMediaHolder, oVar);
        }
    }

    public final void n0(TopicMediaHolder topicMediaHolder, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, topicMediaHolder, oVar) == null) {
            topicMediaHolder.mTbVideoViewContainer.getControl().start();
            topicMediaHolder.mBtnPausePlay.setVisibility(8);
            topicMediaHolder.mReplayLayout.setVisibility(8);
            x0(oVar, topicMediaHolder);
        }
    }

    public final void o0() {
        TopicMediaHolder topicMediaHolder;
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (topicMediaHolder = this.p) == null || (tbVideoViewContainer = topicMediaHolder.mTbVideoViewContainer) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        TopicMediaHolder topicMediaHolder2 = this.p;
        if (topicMediaHolder2.mBtnPausePlay == null || topicMediaHolder2.mLoadingLayout == null) {
            return;
        }
        if (topicMediaHolder2.mTbVideoViewContainer.getControl().isPlaying()) {
            this.p.mTbVideoViewContainer.getControl().pause();
            this.p.mBtnPausePlay.setVisibility(0);
        } else if (this.p.mLoadingLayout.getVisibility() == 0) {
            this.p.mTbVideoViewContainer.getControl().stopPlayback();
            this.r = true;
            p0(this.p);
        }
    }

    public final void p0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(8);
        if (this.t) {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
        } else {
            topicMediaHolder.mThumbnailImage.setForegroundDrawable(c.a.t0.q1.d.icon_play_video);
        }
    }

    public final void q0(o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, oVar, topicMediaHolder) == null) || oVar == null) {
            return;
        }
        if (!StringUtils.isNull(oVar.f21578h) && oVar.f21579i > 0) {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f21580j, 17, false);
        } else {
            topicMediaHolder.mThumbnailImage.startLoad(oVar.f21577g, 17, false);
        }
        topicMediaHolder.mThumbnailImage.setNoImageBottomText("");
        if (!StringUtils.isNull(oVar.f21580j)) {
            topicMediaHolder.mThumbnailImage.setEvent(new m(this));
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.initProgress();
        } else {
            topicMediaHolder.mControllerView.initCurTimeAndDuration(0, oVar.f21579i * 1000);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: r0 */
    public TopicMediaHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            if (this.o == null) {
                this.o = LayoutInflater.from(this.f3258e).inflate(c.a.t0.q1.f.topic_vedio_item, viewGroup, false);
                this.p = new TopicMediaHolder(this.o);
                View findViewById = this.o.findViewById(c.a.t0.q1.e.topic_layout_video_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int k = c.a.d.f.p.n.k(this.f3258e);
                if (layoutParams != null) {
                    layoutParams.height = (int) (k / 1.8d);
                    findViewById.setLayoutParams(layoutParams);
                }
            } else {
                u0();
            }
            return this.p;
        }
        return (TopicMediaHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: s0 */
    public View S(int i2, View view, ViewGroup viewGroup, o oVar, TopicMediaHolder topicMediaHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, topicMediaHolder})) == null) {
            if (oVar != null && topicMediaHolder != null) {
                if (!this.q) {
                    this.q = true;
                    if (!StringUtils.isNull(oVar.f21578h) && oVar.f21579i > 0) {
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
                    if (!StringUtils.isNull(oVar.f21578h) && oVar.f21579i > 0) {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(c.a.t0.q1.d.icon_play_video);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(new n(this, oVar, topicMediaHolder));
                    } else {
                        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
                        topicMediaHolder.mThumbnailImage.setOnClickListener(null);
                    }
                    topicMediaHolder.mThumbnailImage.setTag(Integer.valueOf(i2));
                    topicMediaHolder.mThumbnailImage.setDefaultResource(0);
                    if (!c.a.s0.s.k.c().g()) {
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextColor(c.a.t0.q1.b.CAM_X0108);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.q1.c.ds32));
                        topicMediaHolder.mThumbnailImage.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(c.a.t0.q1.c.fontsize28));
                        topicMediaHolder.mThumbnailImage.setSupportNoImage(true);
                        topicMediaHolder.mThumbnailImage.setNoImageBottomText(TbadkCoreApplication.getInst().getString(c.a.t0.q1.h.click_to_play));
                    } else {
                        topicMediaHolder.mThumbnailImage.setDefaultBgResource(c.a.t0.q1.d.pic_bg_video_frs);
                        if (!topicMediaHolder.mTbVideoViewContainer.getControl().isPlaying()) {
                            q0(oVar, topicMediaHolder);
                        }
                    }
                    topicMediaHolder.mBtnReplay.setOnClickListener(new e(this, topicMediaHolder, oVar));
                    topicMediaHolder.mTbVideoViewContainer.getControl().setOperableVideoContainer(new f(this, topicMediaHolder, oVar));
                    topicMediaHolder.mTbVideoViewContainer.getControl().setOnSurfaceDestroyedListener(this.u);
                    topicMediaHolder.mCoverView.setOnClickListener(new g(this, topicMediaHolder, oVar));
                    if (this.s) {
                        topicMediaHolder.mVideoProgressView.setPlayer(topicMediaHolder.mTbVideoViewContainer.getControl());
                    } else {
                        topicMediaHolder.mControllerView.setPlayer(topicMediaHolder.mTbVideoViewContainer.getControl());
                    }
                    if (StringUtils.isNull(oVar.f21576f)) {
                        topicMediaHolder.mVedioTitle.setVisibility(8);
                        topicMediaHolder.mVedioLine.setVisibility(8);
                    } else {
                        topicMediaHolder.mVedioTitle.setVisibility(0);
                        topicMediaHolder.mVedioLine.setVisibility(0);
                        topicMediaHolder.mVedioTitle.setText(oVar.f21576f);
                        topicMediaHolder.mVedioTitle.setOnClickListener(new h(this, oVar));
                    }
                }
                if (topicMediaHolder.skinType != this.m) {
                    SkinManager.setBackgroundColor(view, c.a.t0.q1.b.CAM_X0201);
                    topicMediaHolder.mControllerView.onChangeSkinType(this.m);
                    SkinManager.setImageResource(topicMediaHolder.mBtnPausePlay, c.a.t0.q1.d.icon_play_video);
                    SkinManager.setViewTextColor(topicMediaHolder.mBtnReplay, c.a.t0.q1.b.CAM_X0101, 1);
                    topicMediaHolder.mVideoProgressView.onChangeSkinType(this.m);
                    topicMediaHolder.mBtnReplay.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, c.a.t0.q1.d.topic_replay_selector), (Drawable) null, (Drawable) null);
                    SkinManager.setViewTextColor(topicMediaHolder.mVedioTitle, c.a.t0.q1.b.CAM_X0105, 1);
                    SkinManager.setBackgroundColor(topicMediaHolder.mVedioLine, c.a.t0.q1.b.CAM_X0204);
                }
                topicMediaHolder.skinType = this.m;
            }
            return this.o;
        }
        return (View) invokeCommon.objValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.q = false;
        }
    }

    public final void u0() {
        TopicMediaHolder topicMediaHolder;
        ForeDrawableImageView foreDrawableImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (topicMediaHolder = this.p) == null || (foreDrawableImageView = topicMediaHolder.mThumbnailImage) == null || topicMediaHolder.mReplayLayout == null) {
            return;
        }
        foreDrawableImageView.setVisibility(0);
        this.p.mReplayLayout.setVisibility(8);
        this.r = true;
        p0(this.p);
        v0(this.p);
    }

    public final void v0(TopicMediaHolder topicMediaHolder) {
        TopicVideoControllerView topicVideoControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, topicMediaHolder) == null) || topicMediaHolder == null || (topicVideoControllerView = topicMediaHolder.mControllerView) == null || topicMediaHolder.mVideoProgressView == null) {
            return;
        }
        topicVideoControllerView.resetProgress();
        topicMediaHolder.mVideoProgressView.resetProgress();
    }

    public final void w0(TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, topicMediaHolder) == null) || topicMediaHolder == null) {
            return;
        }
        topicMediaHolder.mLoadingLayout.setVisibility(0);
        topicMediaHolder.mThumbnailImage.setForegroundDrawable(0);
    }

    public final void x0(o oVar, TopicMediaHolder topicMediaHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, oVar, topicMediaHolder) == null) || oVar == null || topicMediaHolder == null) {
            return;
        }
        if (this.s) {
            topicMediaHolder.mVideoProgressView.showProgress();
        } else {
            topicMediaHolder.mControllerView.showProgress();
        }
    }
}
