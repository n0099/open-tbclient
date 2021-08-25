package c.a.q0.o2.q;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public c2 N0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p0(false);
        setStageType(null);
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r0(this.f23245i);
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.o2.q.d
    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.q == this.f23244h) {
            A0();
        }
    }

    @Override // c.a.q0.o2.q.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23245i = 32;
        }
    }

    @Override // c.a.q0.o2.q.d
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.q0.o2.q.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g0();
            this.R.setOnTouchListener(null);
            this.R.setOnClickListener(this);
        }
    }

    @Override // c.a.q0.o2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            Z();
        } else if (!j.z()) {
            l.L(this.P, R.string.no_network_guide);
        } else if (this.U) {
            VideoItemData videoItemData = this.L0;
            if (videoItemData != null) {
                z0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
            if (videoSerializeVideoThreadInfo != null) {
                z0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // c.a.q0.o2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c2Var) == null) {
            super.setData(c2Var);
            this.N0 = c2Var;
            if (this.U) {
                VideoItemData videoItemData = new VideoItemData();
                this.L0 = videoItemData;
                videoItemData.buildWithThreadData(c2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.M0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(c2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.M0;
            videoSerializeVideoThreadInfo2.source = c2Var.U0;
            videoSerializeVideoThreadInfo2.extra = c2Var.X0;
            videoSerializeVideoThreadInfo2.ab_tag = c2Var.W0;
            videoSerializeVideoThreadInfo2.weight = c2Var.V0;
        }
    }

    public final void z0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
            pbActivityConfig.createNormalCfg(str2, null, null);
            pbActivityConfig.setForumId(String.valueOf(str));
            pbActivityConfig.setThreadData(this.N0);
            pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.R));
            pbActivityConfig.setNeedPreLoad(true);
            c.a.q0.v0.l.c(this.N0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            View.OnClickListener onClickListener = this.y0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }
}
