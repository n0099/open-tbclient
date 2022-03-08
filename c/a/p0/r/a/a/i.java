package c.a.p0.r.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f0;
    public int g0;
    public boolean h0;
    public boolean i0;
    public int k0;
    public Dialog q0;
    public boolean r0;
    public boolean s0;
    public boolean t0;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = true;
        this.i0 = true;
        this.k0 = -1;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater C(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            if (!this.i0) {
                return super.C(bundle);
            }
            Dialog l1 = l1(bundle);
            this.q0 = l1;
            if (l1 != null) {
                m1(l1, this.f0);
                return (LayoutInflater) this.q0.getContext().getSystemService("layout_inflater");
            }
            return (LayoutInflater) this.x.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void H0(Bundle bundle) {
        Bundle onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.H0(bundle);
            Dialog dialog = this.q0;
            if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
                bundle.putBundle(DialogFragment.SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
            }
            int i2 = this.f0;
            if (i2 != 0) {
                bundle.putInt(DialogFragment.SAVED_STYLE, i2);
            }
            int i3 = this.g0;
            if (i3 != 0) {
                bundle.putInt(DialogFragment.SAVED_THEME, i3);
            }
            boolean z = this.h0;
            if (!z) {
                bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
            }
            boolean z2 = this.i0;
            if (!z2) {
                bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
            }
            int i4 = this.k0;
            if (i4 != -1) {
                bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i4);
            }
        }
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i1(false);
        }
    }

    public void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.s0) {
            return;
        }
        this.s0 = true;
        this.t0 = false;
        Dialog dialog = this.q0;
        if (dialog != null) {
            dialog.dismiss();
            this.q0 = null;
        }
        this.r0 = true;
        if (this.k0 >= 0) {
            z().e(this.k0, 1);
            this.k0 = -1;
            return;
        }
        o a = z().a();
        a.h(this);
        if (z) {
            a.f();
        } else {
            a.e();
        }
    }

    public Dialog j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q0 : (Dialog) invokeV.objValue;
    }

    @StyleRes
    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g0 : invokeV.intValue;
    }

    @NonNull
    public Dialog l1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) ? new Dialog(getActivity(), k1()) : (Dialog) invokeL.objValue;
    }

    public void m1(Dialog dialog, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, dialog, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            dialog.requestWindowFeature(1);
        }
    }

    public void n1(m mVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar, str) == null) {
            this.s0 = false;
            this.t0 = true;
            o a = mVar.a();
            a.c(this, str);
            a.e();
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) {
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.i0 = this.B == 0;
            if (bundle != null) {
                this.f0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
                this.g0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
                this.h0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
                this.i0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.i0);
                this.k0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, dialogInterface) == null) || this.r0) {
            return;
        }
        i1(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStart();
            Dialog dialog = this.q0;
            if (dialog != null) {
                this.r0 = false;
                dialog.show();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            Dialog dialog = this.q0;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void p0(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.p0(bundle);
            if (this.i0) {
                View W = W();
                if (W != null) {
                    if (W.getParent() == null) {
                        this.q0.setContentView(W);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                this.q0.setOwnerActivity(getActivity());
                this.q0.setCancelable(this.h0);
                this.q0.setOnCancelListener(this);
                this.q0.setOnDismissListener(this);
                if (bundle == null || (bundle2 = bundle.getBundle(DialogFragment.SAVED_DIALOG_STATE_TAG)) == null) {
                    return;
                }
                this.q0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            super.r0(activity);
            if (this.t0) {
                return;
            }
            this.s0 = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.y0();
            Dialog dialog = this.q0;
            if (dialog != null) {
                this.r0 = true;
                dialog.dismiss();
                this.q0 = null;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.z0();
            if (this.t0 || this.s0) {
                return;
            }
            this.s0 = true;
        }
    }
}
