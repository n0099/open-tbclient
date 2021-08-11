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
    public boolean f40183a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f40184b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40185c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40186d;

    /* renamed from: e  reason: collision with root package name */
    public int f40187e;

    /* renamed from: f  reason: collision with root package name */
    public int f40188f;

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
                public final /* synthetic */ LrcView.a f40189a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LrcTipTextview f40190b;

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
                    this.f40190b = this;
                    this.f40189a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f40190b.f40184b.setVisibility(8);
                        int top = this.f40190b.getTop() + this.f40190b.getPaddingTop();
                        int dimensionPixelOffset = this.f40190b.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                        ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (RelativeLayout.LayoutParams) this.f40190b.getLayoutParams(), top, dimensionPixelOffset) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ RelativeLayout.LayoutParams f40191a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f40192b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f40193c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f40194d;

                            /* renamed from: e  reason: collision with root package name */
                            public IntEvaluator f40195e;

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
                                this.f40194d = this;
                                this.f40191a = r7;
                                this.f40192b = top;
                                this.f40193c = dimensionPixelOffset;
                                this.f40195e = new IntEvaluator();
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    float f2 = intValue / 100.0f;
                                    this.f40191a.topMargin = this.f40195e.evaluate(f2, Integer.valueOf(this.f40192b), Integer.valueOf(this.f40193c)).intValue();
                                    int intValue2 = this.f40195e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                                    this.f40194d.f40190b.f40185c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40194d.f40190b.f40186d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40194d.f40190b.f40185c.setTextSize(0, this.f40195e.evaluate(f2, Integer.valueOf(this.f40194d.f40190b.f40187e), Integer.valueOf(this.f40194d.f40190b.f40188f)).intValue());
                                    this.f40194d.f40190b.requestLayout();
                                    if (intValue == 100) {
                                        this.f40194d.f40189a.a();
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
            this.f40187e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
            this.f40188f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            TextView textView = new TextView(getContext());
            this.f40184b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.f40184b.setTextSize(0, this.f40188f);
            this.f40184b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
            this.f40184b.setLayoutParams(layoutParams2);
            TextView textView2 = new TextView(getContext());
            this.f40185c = textView2;
            textView2.setTextColor(Color.rgb(255, 255, 255));
            this.f40185c.setTextSize(0, this.f40187e);
            this.f40185c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
            this.f40185c.setLayoutParams(layoutParams3);
            TextView textView3 = new TextView(getContext());
            this.f40186d = textView3;
            textView3.setTextColor(Color.rgb(255, 255, 255));
            this.f40186d.setTextSize(0, this.f40187e);
            this.f40186d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
            this.f40186d.setLayoutParams(layoutParams);
            addView(this.f40184b);
            addView(this.f40185c);
            addView(this.f40186d);
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
