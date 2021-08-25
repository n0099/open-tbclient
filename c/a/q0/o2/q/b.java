package c.a.q0.o2.q;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.b1.t;
import c.a.p0.s.q.c2;
import c.a.q0.a0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public c2 N0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, View view) {
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
        this.f23241e = 5000;
    }

    public final void A0(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rect) == null) || this.N0 == null) {
            return;
        }
        if (this.L0 == null) {
            this.L0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.L0.buildWithThreadData(this.N0);
        arrayList.add(this.L0);
        String str = null;
        c2 c2Var = this.N0;
        if (c2Var != null && c2Var.L() != null) {
            str = this.N0.L().oriUgcNid;
        }
        Context context = this.P;
        boolean z = this.U;
        String str2 = this.i0;
        t.g(context, arrayList, str, z, 0, rect, "from_nani_video", "personalize_page", "", str2, str2, false);
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.N0 == null) {
            return;
        }
        if (this.M0 == null) {
            this.M0 = new VideoSerializeVideoThreadInfo();
        }
        this.M0.copyFromThreadInfo(this.N0);
        VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.P, this.i0, this.W, m.g(), "", this.M0);
        c2 c2Var = this.N0;
        if (c2Var != null && c2Var.L() != null) {
            videoMiddlePageLightActivityConfig.setNid(this.N0.L().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (videoSerializeVideoThreadInfo = this.M0) == null) {
            return;
        }
        c2 c2Var = this.N0;
        if (c2Var != null) {
            videoSerializeVideoThreadInfo.copyFromThreadInfo(c2Var);
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.P, this.i0, this.W, m.g(), "", this.M0);
        c2 c2Var2 = this.N0;
        if (c2Var2 != null && c2Var2.L() != null) {
            videoMiddlePageActivityConfig.setNid(this.N0.L().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r0(this.f23245i);
        }
    }

    @Override // c.a.q0.o2.q.d
    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.q == this.f23244h) {
            D0();
        }
    }

    @Override // c.a.q0.o2.q.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23245i = 32;
        }
    }

    @Override // c.a.q0.o2.q.d
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.q0.o2.q.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.g0();
            this.R.setOnTouchListener(null);
            this.R.setOnClickListener(this);
        }
    }

    @Override // c.a.q0.o2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            Z();
            return;
        }
        if (!j.z()) {
            l.L(this.P, R.string.no_network_guide);
        } else if (c.a.p0.b.d.k0()) {
            B0();
        } else if (c.a.p0.b.d.m0()) {
            A0(ThreadCardUtils.computeViewArea(this.R));
        } else if (c.a.p0.b.d.p0()) {
            z0();
        } else if (this.U) {
            A0(ThreadCardUtils.computeViewArea(this.R));
        } else if (!"index".equals(this.i0) && !"frs".equals(this.i0) && !"concern_tab".equals(this.i0) && !"video_tab".equals(this.i0) && !"14".equals(this.i0)) {
            C0();
        } else {
            C0();
        }
        View.OnClickListener onClickListener = this.y0;
        if (onClickListener != null) {
            onClickListener.onClick(getMainView());
        }
    }

    @Override // c.a.q0.o2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.q0.o2.q.d, c.a.q0.o2.q.a
    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, c2Var) == null) {
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

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View.OnClickListener onClickListener = this.z0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
            if (videoSerializeVideoThreadInfo != null) {
                String str = videoSerializeVideoThreadInfo.threadId;
                String str2 = videoSerializeVideoThreadInfo.forumId;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
                pbActivityConfig.createNormalCfg(str, null, null);
                pbActivityConfig.setForumId(String.valueOf(str2));
                pbActivityConfig.setThreadData(this.N0);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, View view, boolean z) {
        this(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        p0(z);
    }
}
