package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.u1.f.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FloatRecordView implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24840b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f24841c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f24842d;

    /* renamed from: e  reason: collision with root package name */
    public int f24843e;

    /* renamed from: f  reason: collision with root package name */
    public long f24844f;

    /* renamed from: g  reason: collision with root package name */
    public int f24845g;

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
        this.f24840b = null;
        this.f24841c = null;
        this.f24842d = null;
        this.f24843e = 0;
        this.f24844f = 0L;
        this.f24845g = 0;
        d(context, null);
    }

    public LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24842d : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24841c : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24840b : (LinearLayout) invokeV.objValue;
    }

    @Override // c.a.p0.u1.f.b
    public void closeRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24842d.setVisibility(8);
        }
    }

    @Override // c.a.p0.u1.f.b
    public void closeRecordTooShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f24841c.setVisibility(8);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0294, (ViewGroup) null);
            this.f24840b = linearLayout;
            this.a = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090ec5);
            this.f24841c = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d029a, (ViewGroup) null);
            this.f24842d = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0299, (ViewGroup) null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f24841c.setVisibility(0);
        }
    }

    @Override // c.a.d.f.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f24843e = Math.max(i, this.f24843e);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f24844f > 150) {
                this.f24843e = 0;
                this.f24844f = uptimeMillis;
            }
            int i2 = this.f24845g + 1;
            this.f24845g = i2;
            if (i2 % 5 == 0) {
                this.f24845g = 0;
                int i3 = this.f24843e;
                if (i3 < 2) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c3);
                } else if (i3 < 10) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c0);
                } else if (i3 < 20) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c2);
                } else if (i3 < 30) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c1);
                } else if (i3 < 40) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806bf);
                } else if (i3 < 50) {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806be);
                } else {
                    this.a.setImageResource(R.drawable.obfuscated_res_0x7f0806c1);
                }
            }
        }
    }

    @Override // c.a.d.f.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // c.a.p0.u1.f.b
    public void showRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f24842d.setVisibility(0);
        }
    }

    @Override // c.a.p0.u1.f.b
    public void startRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f24840b.setVisibility(0);
        }
    }

    @Override // c.a.p0.u1.f.b
    public void stopRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f24840b.setVisibility(8);
        }
    }
}
