package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x47;
/* loaded from: classes.dex */
public class FloatRecordView implements x47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public LinearLayout b;
    public LinearLayout c;
    public LinearLayout d;
    public int e;
    public long f;
    public int g;

    public FloatRecordView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0L;
        this.g = 0;
        d(context, null);
    }

    public LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (LinearLayout) invokeV.objValue;
    }

    @Override // com.repackage.x47
    public void closeRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.setVisibility(8);
        }
    }

    @Override // com.repackage.x47
    public void closeRecordTooShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setVisibility(8);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0295, (ViewGroup) null);
            this.b = linearLayout;
            this.a = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090ec1);
            this.c = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d029b, (ViewGroup) null);
            this.d = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d029a, (ViewGroup) null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setVisibility(0);
        }
    }

    @Override // com.repackage.ej
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e = Math.max(i, this.e);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f > 150) {
                this.e = 0;
                this.f = uptimeMillis;
            }
            int i2 = this.g + 1;
            this.g = i2;
            if (i2 % 5 == 0) {
                this.g = 0;
                int i3 = this.e;
                if (i3 < 2) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c2);
                } else if (i3 < 10) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806bf);
                } else if (i3 < 20) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c1);
                } else if (i3 < 30) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c0);
                } else if (i3 < 40) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806be);
                } else if (i3 < 50) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806bd);
                } else {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c0);
                }
            }
        }
    }

    @Override // com.repackage.ej
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.x47
    public void showRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.setVisibility(0);
        }
    }

    @Override // com.repackage.x47
    public void startRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.setVisibility(0);
        }
    }

    @Override // com.repackage.x47
    public void stopRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setVisibility(8);
        }
    }
}
