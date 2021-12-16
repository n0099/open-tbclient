package c.a.s0.z2.r;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.s0.d1.l;
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
/* loaded from: classes9.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData N0;
    public VideoSerializeVideoThreadInfo O0;
    public d2 P0;

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

    public final void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.Q);
            pbActivityConfig.createNormalCfg(str2, null, null);
            pbActivityConfig.setForumId(String.valueOf(str));
            pbActivityConfig.setThreadData(this.P0);
            pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.S));
            pbActivityConfig.setNeedPreLoad(true);
            l.update(this.P0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            View.OnClickListener onClickListener = this.B0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r0(this.f26431i);
        }
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.z2.r.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.r;
            if (i2 == this.f26430h || i2 == this.q) {
                B0();
            }
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26431i = 32;
        }
    }

    @Override // c.a.s0.z2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.s0.z2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.g0();
            this.S.setOnTouchListener(null);
            this.S.setOnClickListener(this);
        }
    }

    @Override // c.a.s0.z2.r.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            Z();
        } else if (!k.z()) {
            m.L(this.Q, R.string.no_network_guide);
        } else if (this.V) {
            VideoItemData videoItemData = this.N0;
            if (videoItemData != null) {
                A0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.O0;
            if (videoSerializeVideoThreadInfo != null) {
                A0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // c.a.s0.z2.r.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.s0.z2.r.d, c.a.s0.z2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, d2Var) == null) {
            super.setData(d2Var);
            this.P0 = d2Var;
            if (this.V) {
                VideoItemData videoItemData = new VideoItemData();
                this.N0 = videoItemData;
                videoItemData.buildWithThreadData(d2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.O0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(d2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.O0;
            videoSerializeVideoThreadInfo2.source = d2Var.Z0;
            videoSerializeVideoThreadInfo2.extra = d2Var.c1;
            videoSerializeVideoThreadInfo2.ab_tag = d2Var.b1;
            videoSerializeVideoThreadInfo2.weight = d2Var.a1;
        }
    }
}
