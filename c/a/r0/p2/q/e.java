package c.a.r0.p2.q;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int K0;
    public int L0;

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
        this.K0 = l.k(this.P) / 10;
    }

    @Override // c.a.r0.p2.q.d
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.Y(z);
            if (this.a0) {
                this.R.getLayoutParams().height = -1;
                return;
            }
            this.R.getLayoutParams().height = this.L0;
        }
    }

    @Override // c.a.r0.p2.q.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.r0.p2.q.d
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.K0) : invokeL.booleanValue;
    }

    @Override // c.a.r0.p2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPrepared();
            if (this.u.getCyberPlayer() == null) {
                return;
            }
            CyberPlayer cyberPlayer = this.u.getCyberPlayer();
            this.U = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            int videoHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.k(this.P));
            this.L0 = videoHeight;
            if (videoHeight > l.i(this.P)) {
                this.L0 = l.i(this.P);
            }
            this.R.getLayoutParams().height = this.L0;
            this.R.requestLayout();
        }
    }

    @Override // c.a.r0.p2.q.d
    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.r0(i2);
            this.K.setVisibility(8);
            this.E.setVisibility(8);
        }
    }

    public void z0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.V = str2;
            S();
            T();
            r0(this.f23832f);
            this.G.setPlayer(this.u);
            this.C.setVisibility(8);
            this.v.setPlaceHolder(3);
            this.v.startLoad(str, 10, false);
            this.I.setShareData(null);
        }
    }
}
