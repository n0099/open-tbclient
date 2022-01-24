package c.a.t0.a3.v;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
        j0(false);
        this.N0 = n.k(this.R) / 10;
    }

    @Override // c.a.t0.a3.v.d
    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Context context = this.R;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.S(z);
            if (this.b0) {
                this.T.getLayoutParams().height = -1;
                return;
            }
            this.T.getLayoutParams().height = this.O0;
        }
    }

    @Override // c.a.t0.a3.v.d
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.w.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // c.a.t0.a3.v.d
    public boolean c0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? this.b0 || motionEvent.getX() > ((float) this.N0) : invokeL.booleanValue;
    }

    @Override // c.a.t0.a3.v.d
    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.l0(i2);
            this.M.setVisibility(8);
            this.G.setVisibility(8);
        }
    }

    @Override // c.a.t0.a3.v.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrepared();
            if (this.w.getControl().getPlayerWidth() == 0) {
                return;
            }
            this.W = this.w.getControl().getPlayerHeight() > this.w.getControl().getPlayerWidth();
            int playerHeight = (int) ((this.w.getControl().getPlayerHeight() / this.w.getControl().getPlayerWidth()) * n.k(this.R));
            this.O0 = playerHeight;
            if (playerHeight > n.i(this.R)) {
                this.O0 = n.i(this.R);
            }
            this.T.getLayoutParams().height = this.O0;
            this.T.requestLayout();
        }
    }

    public void u0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.X = str2;
            M();
            N();
            l0(this.f15309f);
            this.I.setPlayer(this.w.getControl());
            this.E.setVisibility(8);
            this.x.setPlaceHolder(3);
            this.x.startLoad(str, 10, false);
            this.K.setShareData(null);
        }
    }
}
