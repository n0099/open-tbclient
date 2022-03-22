package c.a.p0.q4;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends TimePickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f17709b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17710c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onTimeSetListener, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (TimePickerDialog.OnTimeSetListener) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f17709b = -1;
        this.f17710c = false;
        this.a = i;
        this.f17709b = i2;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
            if (i == -1) {
                this.f17710c = true;
            } else {
                int i3 = this.a;
                if (i3 >= 0 && (i2 = this.f17709b) >= 0) {
                    updateTime(i3, i2);
                }
            }
            super.onClick(dialogInterface, i);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            updateTime(0, 0);
            this.a = bundle.getInt("hour_key");
            int i = bundle.getInt("min_key");
            this.f17709b = i;
            updateTime(this.a, i);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                bundle = super.onSaveInstanceState();
            } catch (Exception unused) {
                bundle = null;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("hour_key", this.a);
            bundle.putInt("min_key", this.f17709b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f17710c) {
                updateTime(this.a, this.f17709b);
            }
            super.onStop();
        }
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.updateTime(i, i2);
            this.a = i;
            this.f17709b = i2;
            this.f17710c = false;
        }
    }
}
