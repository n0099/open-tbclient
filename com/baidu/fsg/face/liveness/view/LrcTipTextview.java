package com.baidu.fsg.face.liveness.view;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.fsg.face.liveness.view.LrcView;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LrcTipTextview extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38368a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f38369b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f38370c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f38371d;

    /* renamed from: e  reason: collision with root package name */
    public int f38372e;

    /* renamed from: f  reason: collision with root package name */
    public int f38373f;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LrcTipTextview(Context context) {
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
        a();
    }

    public void startLrcTipAnim(LrcView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            postDelayed(new Runnable(this, aVar) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LrcView.a f38374a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LrcTipTextview f38375b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38375b = this;
                    this.f38374a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38375b.f38369b.setVisibility(8);
                        int top = this.f38375b.getTop() + this.f38375b.getPaddingTop();
                        int dimensionPixelOffset = this.f38375b.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                        ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (RelativeLayout.LayoutParams) this.f38375b.getLayoutParams(), top, dimensionPixelOffset) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ RelativeLayout.LayoutParams f38376a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f38377b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f38378c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f38379d;

                            /* renamed from: e  reason: collision with root package name */
                            public IntEvaluator f38380e;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7, Integer.valueOf(top), Integer.valueOf(dimensionPixelOffset)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38379d = this;
                                this.f38376a = r7;
                                this.f38377b = top;
                                this.f38378c = dimensionPixelOffset;
                                this.f38380e = new IntEvaluator();
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    float f2 = intValue / 100.0f;
                                    this.f38376a.topMargin = this.f38380e.evaluate(f2, Integer.valueOf(this.f38377b), Integer.valueOf(this.f38378c)).intValue();
                                    int intValue2 = this.f38380e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                                    this.f38379d.f38375b.f38370c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f38379d.f38375b.f38371d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f38379d.f38375b.f38370c.setTextSize(0, this.f38380e.evaluate(f2, Integer.valueOf(this.f38379d.f38375b.f38372e), Integer.valueOf(this.f38379d.f38375b.f38373f)).intValue());
                                    this.f38379d.f38375b.requestLayout();
                                    if (intValue == 100) {
                                        this.f38379d.f38374a.a();
                                    }
                                }
                            }
                        });
                        ofInt.setDuration(400L).start();
                    }
                }
            }, 0L);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setOrientation(1);
            setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f38372e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
            this.f38373f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            TextView textView = new TextView(getContext());
            this.f38369b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.f38369b.setTextSize(0, this.f38373f);
            this.f38369b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
            this.f38369b.setLayoutParams(layoutParams2);
            TextView textView2 = new TextView(getContext());
            this.f38370c = textView2;
            textView2.setTextColor(Color.rgb(255, 255, 255));
            this.f38370c.setTextSize(0, this.f38372e);
            this.f38370c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
            this.f38370c.setLayoutParams(layoutParams3);
            TextView textView3 = new TextView(getContext());
            this.f38371d = textView3;
            textView3.setTextColor(Color.rgb(255, 255, 255));
            this.f38371d.setTextSize(0, this.f38372e);
            this.f38371d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
            this.f38371d.setLayoutParams(layoutParams);
            addView(this.f38369b);
            addView(this.f38370c);
            addView(this.f38371d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LrcTipTextview(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }
}
