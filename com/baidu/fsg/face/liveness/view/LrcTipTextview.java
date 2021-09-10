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
/* loaded from: classes5.dex */
public class LrcTipTextview extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f40401a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f40402b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40403c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40404d;

    /* renamed from: e  reason: collision with root package name */
    public int f40405e;

    /* renamed from: f  reason: collision with root package name */
    public int f40406f;

    /* loaded from: classes5.dex */
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
                public final /* synthetic */ LrcView.a f40407a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LrcTipTextview f40408b;

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
                    this.f40408b = this;
                    this.f40407a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f40408b.f40402b.setVisibility(8);
                        int top = this.f40408b.getTop() + this.f40408b.getPaddingTop();
                        int dimensionPixelOffset = this.f40408b.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                        ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (RelativeLayout.LayoutParams) this.f40408b.getLayoutParams(), top, dimensionPixelOffset) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ RelativeLayout.LayoutParams f40409a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f40410b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f40411c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f40412d;

                            /* renamed from: e  reason: collision with root package name */
                            public IntEvaluator f40413e;

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
                                this.f40412d = this;
                                this.f40409a = r7;
                                this.f40410b = top;
                                this.f40411c = dimensionPixelOffset;
                                this.f40413e = new IntEvaluator();
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    float f2 = intValue / 100.0f;
                                    this.f40409a.topMargin = this.f40413e.evaluate(f2, Integer.valueOf(this.f40410b), Integer.valueOf(this.f40411c)).intValue();
                                    int intValue2 = this.f40413e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                                    this.f40412d.f40408b.f40403c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40412d.f40408b.f40404d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40412d.f40408b.f40403c.setTextSize(0, this.f40413e.evaluate(f2, Integer.valueOf(this.f40412d.f40408b.f40405e), Integer.valueOf(this.f40412d.f40408b.f40406f)).intValue());
                                    this.f40412d.f40408b.requestLayout();
                                    if (intValue == 100) {
                                        this.f40412d.f40407a.a();
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
            this.f40405e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
            this.f40406f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            TextView textView = new TextView(getContext());
            this.f40402b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.f40402b.setTextSize(0, this.f40406f);
            this.f40402b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
            this.f40402b.setLayoutParams(layoutParams2);
            TextView textView2 = new TextView(getContext());
            this.f40403c = textView2;
            textView2.setTextColor(Color.rgb(255, 255, 255));
            this.f40403c.setTextSize(0, this.f40405e);
            this.f40403c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
            this.f40403c.setLayoutParams(layoutParams3);
            TextView textView3 = new TextView(getContext());
            this.f40404d = textView3;
            textView3.setTextColor(Color.rgb(255, 255, 255));
            this.f40404d.setTextSize(0, this.f40405e);
            this.f40404d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
            this.f40404d.setLayoutParams(layoutParams);
            addView(this.f40402b);
            addView(this.f40403c);
            addView(this.f40404d);
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
