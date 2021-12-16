package c.a.s0.z2.r;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public int O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, View view) {
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
        this.N0 = m.k(this.Q) / 10;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.W = str2;
            Q();
            S();
            r0(this.f26428f);
            this.H.setPlayer(this.v);
            this.D.setVisibility(8);
            this.w.setPlaceHolder(3);
            this.w.startLoad(str, 10, false);
            this.J.setShareData(null);
        }
    }

    @Override // c.a.s0.z2.r.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Context context = this.Q;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.Y(z);
            if (this.b0) {
                this.S.getLayoutParams().height = -1;
                return;
            }
            this.S.getLayoutParams().height = this.O0;
        }
    }

    @Override // c.a.s0.z2.r.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.v.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.s0.z2.r.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // c.a.s0.z2.r.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrepared();
            if (this.v.getCyberPlayer() == null) {
                return;
            }
            CyberPlayer cyberPlayer = this.v.getCyberPlayer();
            this.V = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            int videoHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * m.k(this.Q));
            this.O0 = videoHeight;
            if (videoHeight > m.i(this.Q)) {
                this.O0 = m.i(this.Q);
            }
            this.S.getLayoutParams().height = this.O0;
            this.S.requestLayout();
        }
    }

    @Override // c.a.s0.z2.r.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.r0(i2);
            this.L.setVisibility(8);
            this.F.setVisibility(8);
        }
    }
}
