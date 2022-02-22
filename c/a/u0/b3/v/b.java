package c.a.u0.b3.v;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.d1.y;
import c.a.t0.s.r.e2;
import c.a.u0.a4.g;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData N0;
    public VideoSerializeVideoThreadInfo O0;
    public e2 P0;

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
        this.f15630e = 5000;
    }

    @Override // c.a.u0.b3.v.d
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.s;
            if (i2 == this.f15634i || i2 == this.r) {
                v0();
            }
        }
    }

    @Override // c.a.u0.b3.v.d
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15635j = 32;
        }
    }

    @Override // c.a.u0.b3.v.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.u0.b3.v.d
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a0();
            this.T.setOnTouchListener(null);
            this.T.setOnClickListener(this);
        }
    }

    @Override // c.a.u0.b3.v.d, c.a.u0.b3.v.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.u0.b3.v.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == g.video_mute) {
            T();
            return;
        }
        if (!l.z()) {
            n.M(this.R, j.no_network_guide);
        } else {
            u0(ThreadCardUtils.computeViewArea(this.T));
        }
        View.OnClickListener onClickListener = this.B0;
        if (onClickListener != null) {
            onClickListener.onClick(getMainView());
        }
    }

    @Override // c.a.u0.b3.v.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.u0.b3.v.d, c.a.u0.b3.v.a
    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e2Var) == null) {
            super.setData(e2Var);
            this.P0 = e2Var;
            if (this.W) {
                VideoItemData videoItemData = new VideoItemData();
                this.N0 = videoItemData;
                videoItemData.buildWithThreadData(e2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.O0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(e2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.O0;
            videoSerializeVideoThreadInfo2.source = e2Var.Z0;
            videoSerializeVideoThreadInfo2.extra = e2Var.c1;
            videoSerializeVideoThreadInfo2.ab_tag = e2Var.b1;
            videoSerializeVideoThreadInfo2.weight = e2Var.a1;
        }
    }

    public final void u0(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) || this.P0 == null) {
            return;
        }
        if (this.N0 == null) {
            this.N0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.N0.buildWithThreadData(this.P0);
        arrayList.add(this.N0);
        String str = null;
        e2 e2Var = this.P0;
        if (e2Var != null && e2Var.L() != null) {
            str = this.P0.L().oriUgcNid;
        }
        Context context = this.R;
        boolean z = this.W;
        String str2 = this.e0;
        y.e(context, arrayList, str, z, 0, rect, "from_nani_video", "personalize_page", "", str2, str2, false, this.P0.n, true);
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l0(this.f15635j);
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
