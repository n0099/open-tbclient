package c.a.r0.x2.r;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.d1.w;
import c.a.q0.s.q.d2;
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
/* loaded from: classes7.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public d2 N0;

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
        this.f25447e = 5000;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r0(this.f25451i);
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.x2.r.d
    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.q == this.f25450h) {
            A0();
        }
    }

    @Override // c.a.r0.x2.r.d
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25451i = 32;
        }
    }

    @Override // c.a.r0.x2.r.d
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.x2.r.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g0();
            this.R.setOnTouchListener(null);
            this.R.setOnClickListener(this);
        }
    }

    @Override // c.a.r0.x2.r.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            Z();
            return;
        }
        if (!j.z()) {
            l.L(this.P, R.string.no_network_guide);
        } else {
            z0(ThreadCardUtils.computeViewArea(this.R));
        }
        View.OnClickListener onClickListener = this.z0;
        if (onClickListener != null) {
            onClickListener.onClick(getMainView());
        }
    }

    @Override // c.a.r0.x2.r.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            startPlay();
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d2Var) == null) {
            super.setData(d2Var);
            this.N0 = d2Var;
            if (this.U) {
                VideoItemData videoItemData = new VideoItemData();
                this.L0 = videoItemData;
                videoItemData.buildWithThreadData(d2Var);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.M0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(d2Var);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.M0;
            videoSerializeVideoThreadInfo2.source = d2Var.Z0;
            videoSerializeVideoThreadInfo2.extra = d2Var.c1;
            videoSerializeVideoThreadInfo2.ab_tag = d2Var.b1;
            videoSerializeVideoThreadInfo2.weight = d2Var.a1;
        }
    }

    public final void z0(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, rect) == null) || this.N0 == null) {
            return;
        }
        if (this.L0 == null) {
            this.L0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.L0.buildWithThreadData(this.N0);
        arrayList.add(this.L0);
        String str = null;
        d2 d2Var = this.N0;
        if (d2Var != null && d2Var.L() != null) {
            str = this.N0.L().oriUgcNid;
        }
        Context context = this.P;
        boolean z = this.U;
        String str2 = this.d0;
        w.e(context, arrayList, str, z, 0, rect, "from_nani_video", "personalize_page", "", str2, str2, false, this.N0.n, true);
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
