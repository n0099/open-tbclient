package c.a.t0.z2.v;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.e1.y;
import c.a.s0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes9.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData M0;
    public VideoSerializeVideoThreadInfo N0;
    public d2 O0;

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
        this.f26892e = 5000;
    }

    @Override // c.a.t0.z2.v.d
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.r;
            if (i2 == this.f26895h || i2 == this.q) {
                v0();
            }
        }
    }

    @Override // c.a.t0.z2.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26896i = 32;
        }
    }

    @Override // c.a.t0.z2.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.t0.z2.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a0();
            this.S.setOnTouchListener(null);
            this.S.setOnClickListener(this);
        }
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            T();
            return;
        }
        if (!l.z()) {
            n.L(this.Q, R.string.no_network_guide);
        } else {
            u0(ThreadCardUtils.computeViewArea(this.S));
        }
        View.OnClickListener onClickListener = this.A0;
        if (onClickListener != null) {
            onClickListener.onClick(getMainView());
        }
    }

    @Override // c.a.t0.z2.v.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.t0.z2.v.d, c.a.t0.z2.v.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d2Var) == null) {
            super.setData(d2Var);
            this.O0 = d2Var;
            if (this.V) {
                VideoItemData videoItemData = new VideoItemData();
                this.M0 = videoItemData;
                videoItemData.buildWithThreadData(d2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.N0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(d2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.N0;
            videoSerializeVideoThreadInfo2.source = d2Var.Z0;
            videoSerializeVideoThreadInfo2.extra = d2Var.c1;
            videoSerializeVideoThreadInfo2.ab_tag = d2Var.b1;
            videoSerializeVideoThreadInfo2.weight = d2Var.a1;
        }
    }

    public final void u0(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) || this.O0 == null) {
            return;
        }
        if (this.M0 == null) {
            this.M0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.M0.buildWithThreadData(this.O0);
        arrayList.add(this.M0);
        String str = null;
        d2 d2Var = this.O0;
        if (d2Var != null && d2Var.L() != null) {
            str = this.O0.L().oriUgcNid;
        }
        Context context = this.Q;
        boolean z = this.V;
        String str2 = this.d0;
        y.e(context, arrayList, str, z, 0, rect, "from_nani_video", "personalize_page", "", str2, str2, false, this.O0.n, true);
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l0(this.f26896i);
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
        j0(z);
    }
}
