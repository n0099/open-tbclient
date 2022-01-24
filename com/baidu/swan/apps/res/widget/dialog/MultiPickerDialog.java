package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import c.a.r0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class MultiPickerDialog extends SwanAppPickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public BdMultiPicker f39294g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f39295h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f39296i;

    /* renamed from: j  reason: collision with root package name */
    public BdMultiPicker.b f39297j;
    public boolean k;

    /* loaded from: classes11.dex */
    public static class a extends SwanAppPickerDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JSONArray f39298e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f39299f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f39300g;

        /* renamed from: h  reason: collision with root package name */
        public BdMultiPicker.b f39301h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog.a
        public SwanAppPickerDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                MultiPickerDialog multiPickerDialog = (MultiPickerDialog) super.a();
                multiPickerDialog.setDataArray(this.f39298e);
                multiPickerDialog.setDataIndex(this.f39299f);
                multiPickerDialog.setSingleMode(this.f39300g);
                multiPickerDialog.setMultiSelectedListener(this.f39301h);
                return multiPickerDialog;
            }
            return (SwanAppPickerDialog) invokeV.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog.a
        public SwanAppPickerDialog b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new MultiPickerDialog(context) : (SwanAppPickerDialog) invokeL.objValue;
        }

        public a l(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
                this.f39298e = jSONArray;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a m(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
                this.f39299f = jSONArray;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(BdMultiPicker.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f39301h = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f39300g = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPickerDialog(Context context) {
        super(context, i.SwanAppNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39294g = new BdMultiPicker(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            this.f39294g.setLayoutParams(layoutParams);
            this.f39294g.setMultiWheelData(this.f39295h, this.f39296i);
            if (this.k) {
                return;
            }
            this.f39294g.setMultiSelectedListener(this.f39297j);
        }
    }

    public JSONArray getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39294g.getCurrentIndex() : (JSONArray) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            b();
            getBuilder().j(this.f39294g);
        }
    }

    public void setDataArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONArray) == null) {
            this.f39295h = jSONArray;
        }
    }

    public void setDataIndex(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) {
            this.f39296i = jSONArray;
        }
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f39297j = bVar;
        }
    }

    public void setSingleMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void updateWheel(int i2, JSONArray jSONArray, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)}) == null) {
            this.f39294g.updateWheel(i2, jSONArray, i3);
        }
    }
}
