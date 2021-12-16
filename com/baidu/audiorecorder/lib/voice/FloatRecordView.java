package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s1.f.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FloatRecordView implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33767e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f33768f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f33769g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f33770h;

    /* renamed from: i  reason: collision with root package name */
    public int f33771i;

    /* renamed from: j  reason: collision with root package name */
    public long f33772j;

    /* renamed from: k  reason: collision with root package name */
    public int f33773k;

    public FloatRecordView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33767e = null;
        this.f33768f = null;
        this.f33769g = null;
        this.f33770h = null;
        this.f33771i = 0;
        this.f33772j = 0L;
        this.f33773k = 0;
        d(context, null);
    }

    public LinearLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33770h : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33769g : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33768f : (LinearLayout) invokeV.objValue;
    }

    @Override // c.a.s0.s1.f.b
    public void closeRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f33770h.setVisibility(8);
        }
    }

    @Override // c.a.s0.s1.f.b
    public void closeRecordTooShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f33769g.setVisibility(8);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, viewGroup) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
            this.f33768f = linearLayout;
            this.f33767e = (ImageView) linearLayout.findViewById(R.id.img_msgsend_recording);
            this.f33769g = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
            this.f33770h = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33769g.setVisibility(0);
        }
    }

    @Override // c.a.d.f.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecordTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecording(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f33771i = Math.max(i2, this.f33771i);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f33772j > 150) {
                this.f33771i = 0;
                this.f33772j = uptimeMillis;
            }
            int i3 = this.f33773k + 1;
            this.f33773k = i3;
            if (i3 % 5 == 0) {
                this.f33773k = 0;
                int i4 = this.f33771i;
                if (i4 < 2) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
                } else if (i4 < 10) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
                } else if (i4 < 20) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
                } else if (i4 < 30) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
                } else if (i4 < 40) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
                } else if (i4 < 50) {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
                } else {
                    this.f33767e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
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

    @Override // c.a.s0.s1.f.b
    public void showRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f33770h.setVisibility(0);
        }
    }

    @Override // c.a.s0.s1.f.b
    public void startRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f33768f.setVisibility(0);
        }
    }

    @Override // c.a.s0.s1.f.b
    public void stopRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f33768f.setVisibility(8);
        }
    }
}
