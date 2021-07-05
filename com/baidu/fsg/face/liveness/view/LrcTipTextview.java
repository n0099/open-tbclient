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
/* loaded from: classes3.dex */
public class LrcTipTextview extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6171a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f6172b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6173c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f6174d;

    /* renamed from: e  reason: collision with root package name */
    public int f6175e;

    /* renamed from: f  reason: collision with root package name */
    public int f6176f;

    /* loaded from: classes3.dex */
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
                public final /* synthetic */ LrcView.a f6177a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LrcTipTextview f6178b;

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
                    this.f6178b = this;
                    this.f6177a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f6178b.f6172b.setVisibility(8);
                        int top = this.f6178b.getTop() + this.f6178b.getPaddingTop();
                        int dimensionPixelOffset = this.f6178b.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                        ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (RelativeLayout.LayoutParams) this.f6178b.getLayoutParams(), top, dimensionPixelOffset) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ RelativeLayout.LayoutParams f6179a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f6180b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f6181c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f6182d;

                            /* renamed from: e  reason: collision with root package name */
                            public IntEvaluator f6183e;

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
                                this.f6182d = this;
                                this.f6179a = r7;
                                this.f6180b = top;
                                this.f6181c = dimensionPixelOffset;
                                this.f6183e = new IntEvaluator();
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    float f2 = intValue / 100.0f;
                                    this.f6179a.topMargin = this.f6183e.evaluate(f2, Integer.valueOf(this.f6180b), Integer.valueOf(this.f6181c)).intValue();
                                    int intValue2 = this.f6183e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                                    this.f6182d.f6178b.f6173c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f6182d.f6178b.f6174d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f6182d.f6178b.f6173c.setTextSize(0, this.f6183e.evaluate(f2, Integer.valueOf(this.f6182d.f6178b.f6175e), Integer.valueOf(this.f6182d.f6178b.f6176f)).intValue());
                                    this.f6182d.f6178b.requestLayout();
                                    if (intValue == 100) {
                                        this.f6182d.f6177a.a();
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
            this.f6175e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
            this.f6176f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            TextView textView = new TextView(getContext());
            this.f6172b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.f6172b.setTextSize(0, this.f6176f);
            this.f6172b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
            this.f6172b.setLayoutParams(layoutParams2);
            TextView textView2 = new TextView(getContext());
            this.f6173c = textView2;
            textView2.setTextColor(Color.rgb(255, 255, 255));
            this.f6173c.setTextSize(0, this.f6175e);
            this.f6173c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
            this.f6173c.setLayoutParams(layoutParams3);
            TextView textView3 = new TextView(getContext());
            this.f6174d = textView3;
            textView3.setTextColor(Color.rgb(255, 255, 255));
            this.f6174d.setTextSize(0, this.f6175e);
            this.f6174d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
            this.f6174d.setLayoutParams(layoutParams);
            addView(this.f6172b);
            addView(this.f6173c);
            addView(this.f6174d);
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
