package com.baidu.audiorecorder.lib.voice;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.sj;
import com.baidu.tieba.w77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FloatNewRecordView extends RelativeLayout implements w77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public ImageView b;
    public EMTextView c;
    public ImageView d;
    public AudioCircleProgress e;
    public boolean f;
    public boolean g;
    public Animator.AnimatorListener h;

    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatNewRecordView a;

        public a(FloatNewRecordView floatNewRecordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatNewRecordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = floatNewRecordView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatNewRecordView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        b(context, null);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setBackgroundColor(SkinManager.getColor(R.color.CAM_X0502));
            WebPManager.setMaskDrawable(this.d, R.drawable.icon_pic_im_bottom_voicebuton_press, null);
        }
    }

    public final void b(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07b5, this);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0902e7);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091702);
            this.c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091703);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0903eb);
            this.d = imageView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = ej.d(context, 117.0f);
            AudioCircleProgress audioCircleProgress = (AudioCircleProgress) findViewById(R.id.obfuscated_res_0x7f0902e9);
            this.e = audioCircleProgress;
            audioCircleProgress.setArcColor(SkinManager.getColor(R.color.CAM_X0302));
            this.e.setArcWidth(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            this.e.setBgColor(SkinManager.getColor(R.color.CAM_X0211));
            this.e.setPadding(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds6));
            this.a.addAnimatorListener(this.h);
            this.a.setAnimation(R.raw.obfuscated_res_0x7f110024);
            this.a.setImageAssetsFolder("lottie_audio_recoding/");
            this.a.setRepeatCount(-1);
            ((ViewGroup.MarginLayoutParams) ((RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906e3)).getLayoutParams()).topMargin = (ej.i(TbadkCoreApplication.getInst()) * 36) / 100;
            a();
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || sj.b - i > 10000 || this.f) {
            return;
        }
        this.c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b13), Integer.valueOf(((sj.b - i) / 1000) + 1)));
    }

    @Override // com.baidu.tieba.w77
    public void closeRecordCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.w77
    public void closeRecordTooShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f) {
            return;
        }
        this.a.cancelAnimation();
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b17));
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0310);
        WebPManager.setPureDrawable(this.b, R.drawable.obfuscated_res_0x7f080965, R.color.CAM_X0310, null);
        this.e.setArcColor(SkinManager.getColor(R.color.CAM_X0310));
        WebPManager.setMaskDrawable(this.d, R.drawable.icon_pic_im_bottom_voicebuton_out, null);
        this.f = true;
        this.g = false;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.cancelAnimation();
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b18));
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0319);
            WebPManager.setPureDrawable(this.b, R.drawable.obfuscated_res_0x7f080966, R.color.CAM_X0319, null);
            this.g = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.g) {
            return;
        }
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0f));
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
        this.a.playAnimation();
        this.e.setArcColor(SkinManager.getColor(R.color.CAM_X0302));
        WebPManager.setMaskDrawable(this.d, R.drawable.icon_pic_im_bottom_voicebuton_press, null);
        this.f = false;
        this.g = true;
    }

    @Override // com.baidu.tieba.w77
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.a;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.g = false;
            this.e.f();
        }
    }

    @Override // com.baidu.tieba.uj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uj
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.uj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
        }
    }

    @Override // com.baidu.tieba.uj
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
        }
    }

    @Override // com.baidu.tieba.uj
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.e.setProgress((i / 1.0f) / sj.b);
            c(i);
        }
    }

    @Override // com.baidu.tieba.uj
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.uj
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.uj
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }
}
