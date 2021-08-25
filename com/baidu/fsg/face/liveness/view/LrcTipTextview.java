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
    public boolean f40290a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f40291b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40292c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40293d;

    /* renamed from: e  reason: collision with root package name */
    public int f40294e;

    /* renamed from: f  reason: collision with root package name */
    public int f40295f;

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
                public final /* synthetic */ LrcView.a f40296a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LrcTipTextview f40297b;

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
                    this.f40297b = this;
                    this.f40296a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f40297b.f40291b.setVisibility(8);
                        int top = this.f40297b.getTop() + this.f40297b.getPaddingTop();
                        int dimensionPixelOffset = this.f40297b.getResources().getDimensionPixelOffset(R.dimen.liveness_video_lrc_tip_margintop_afteranim);
                        ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (RelativeLayout.LayoutParams) this.f40297b.getLayoutParams(), top, dimensionPixelOffset) { // from class: com.baidu.fsg.face.liveness.view.LrcTipTextview.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ RelativeLayout.LayoutParams f40298a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f40299b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f40300c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f40301d;

                            /* renamed from: e  reason: collision with root package name */
                            public IntEvaluator f40302e;

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
                                this.f40301d = this;
                                this.f40298a = r7;
                                this.f40299b = top;
                                this.f40300c = dimensionPixelOffset;
                                this.f40302e = new IntEvaluator();
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    float f2 = intValue / 100.0f;
                                    this.f40298a.topMargin = this.f40302e.evaluate(f2, Integer.valueOf(this.f40299b), Integer.valueOf(this.f40300c)).intValue();
                                    int intValue2 = this.f40302e.evaluate(f2, (Integer) 255, (Integer) 51).intValue();
                                    this.f40301d.f40297b.f40292c.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40301d.f40297b.f40293d.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                                    this.f40301d.f40297b.f40292c.setTextSize(0, this.f40302e.evaluate(f2, Integer.valueOf(this.f40301d.f40297b.f40294e), Integer.valueOf(this.f40301d.f40297b.f40295f)).intValue());
                                    this.f40301d.f40297b.requestLayout();
                                    if (intValue == 100) {
                                        this.f40301d.f40296a.a();
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
            this.f40294e = getResources().getDimensionPixelSize(R.dimen.rim_text_size_16);
            this.f40295f = getResources().getDimensionPixelSize(R.dimen.rim_text_size_24);
            TextView textView = new TextView(getContext());
            this.f40291b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.f40291b.setTextSize(0, this.f40295f);
            this.f40291b.setText(getContext().getString(R.string.rim_face_video_tips_start_resocrd));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text01_gap));
            this.f40291b.setLayoutParams(layoutParams2);
            TextView textView2 = new TextView(getContext());
            this.f40292c = textView2;
            textView2.setTextColor(Color.rgb(255, 255, 255));
            this.f40292c.setTextSize(0, this.f40294e);
            this.f40292c.setText(getContext().getString(R.string.rim_face_video_tips_read_content));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.liveness_video_lrc_tip_text12_gap));
            this.f40292c.setLayoutParams(layoutParams3);
            TextView textView3 = new TextView(getContext());
            this.f40293d = textView3;
            textView3.setTextColor(Color.rgb(255, 255, 255));
            this.f40293d.setTextSize(0, this.f40294e);
            this.f40293d.setText(getContext().getString(R.string.rim_face_video_tips_keep_face_in_box));
            this.f40293d.setLayoutParams(layoutParams);
            addView(this.f40291b);
            addView(this.f40292c);
            addView(this.f40293d);
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
