package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NativeActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUTTON_WIDTH = 52;
    public static final int GO_BACK_VIEW_ID = 132343252;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mBarContext;
    public OnGButtonClickListener mGButtonClickListener;
    public TextView titleTextView;

    /* loaded from: classes2.dex */
    public class GoBackButtonView extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int frontColor;
        public Paint mArrowPaint;
        public final /* synthetic */ NativeActionBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoBackButtonView(NativeActionBar nativeActionBar, Context context, int i2) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeActionBar, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = nativeActionBar;
            this.frontColor = i2;
        }

        private Paint getArrowPaint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (this.mArrowPaint == null) {
                    Paint paint = new Paint();
                    this.mArrowPaint = paint;
                    paint.setStyle(Paint.Style.STROKE);
                    this.mArrowPaint.setColor(this.frontColor);
                    this.mArrowPaint.setAlpha(255);
                    this.mArrowPaint.setAntiAlias(true);
                    this.mArrowPaint.setStrokeWidth((int) ScreenUtils.getScreenDensity(getContext()));
                }
                return this.mArrowPaint;
            }
            return (Paint) invokeV.objValue;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                canvas.drawLine(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), 23), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 31), getArrowPaint());
                canvas.drawLine(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), 23), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 15), getArrowPaint());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnGButtonClickListener {
        void onGoBackBttonClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeActionBar(Context context) {
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
        this.mBarContext = context;
        setBackgroundColor(Color.parseColor("#66CDAA"));
        showDefaultBar();
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (textView = this.titleTextView) == null) {
            return;
        }
        textView.setText(str);
        this.titleTextView.invalidate();
    }

    public void setmGButtonClickListener(OnGButtonClickListener onGButtonClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGButtonClickListener) == null) {
            this.mGButtonClickListener = onGButtonClickListener;
        }
    }

    public void showDefaultBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int pixel = ScreenUtils.getPixel(this.mBarContext, 52);
            View goBackButtonView = new GoBackButtonView(this, this.mBarContext, Color.parseColor("#FFFFFF"));
            goBackButtonView.setId(GO_BACK_VIEW_ID);
            addView(goBackButtonView, new RelativeLayout.LayoutParams(pixel, -1));
            goBackButtonView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.NativeActionBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NativeActionBar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mGButtonClickListener == null) {
                        return;
                    }
                    this.this$0.mGButtonClickListener.onGoBackBttonClick();
                }
            });
            TextView textView = new TextView(this.mBarContext);
            this.titleTextView = textView;
            textView.setTextSize(1, 16.0f);
            this.titleTextView.setLines(1);
            this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.titleTextView.setTextColor(-1);
            this.titleTextView.setText("");
            this.titleTextView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getScreenRect(this.mBarContext).width() - (pixel * 2), -1);
            layoutParams.addRule(14);
            addView(this.titleTextView, layoutParams);
        }
    }
}
