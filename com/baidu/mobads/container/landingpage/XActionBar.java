package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class XActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BAR_HEIGHT = 46;
    public static final int BUTTON_WIDTH = 52;
    public static final int GO_BACK_BUTTON_VIEW_ID = 132343242;
    public static final int TEXT_HEIGHT = 16;
    public static final int THREE_POINT_BUTTON_VIEW_ID = 132343243;
    public transient /* synthetic */ FieldHolder $fh;
    public App2Activity.ActionBarColorTheme colorTheme;
    public int mBarHeight;
    public int mBarWidth;
    public OnButtonClickListener mClickListener;
    public Context mContext;
    public Paint paint;
    public TextView titleTextView;

    /* loaded from: classes5.dex */
    public class CustomButtonView extends View {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MOVE_GAP = 8;
        public static final int X_COORDINATE = 26;
        public static final int Y_COORDINATE = 23;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XActionBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomButtonView(XActionBar xActionBar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xActionBar, context};
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
            this.this$0 = xActionBar;
        }
    }

    /* loaded from: classes5.dex */
    public class GoBackButtonView extends CustomButtonView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int frontColor;
        public Paint mArrowPaint;
        public final /* synthetic */ XActionBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoBackButtonView(XActionBar xActionBar, Context context, int i2) {
            super(xActionBar, context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xActionBar, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((XActionBar) objArr2[0], (Context) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xActionBar;
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
                canvas.drawLine(ScreenUtils.getPixel(getContext(), 18), ScreenUtils.getPixel(getContext(), 15), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 31), getArrowPaint());
                canvas.drawLine(ScreenUtils.getPixel(getContext(), 18), ScreenUtils.getPixel(getContext(), 31), ScreenUtils.getPixel(getContext(), 34), ScreenUtils.getPixel(getContext(), 15), getArrowPaint());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface OnButtonClickListener {
        void onGoBackBttonClick();

        void onThreePointButtonClick();
    }

    /* loaded from: classes5.dex */
    public class ThreePointButtonView extends CustomButtonView {
        public static /* synthetic */ Interceptable $ic = null;
        public static final float POINT_RADIUS = 1.0f;
        public transient /* synthetic */ FieldHolder $fh;
        public int frontColor;
        public Paint pointPaint;
        public final /* synthetic */ XActionBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThreePointButtonView(XActionBar xActionBar, Context context, int i2) {
            super(xActionBar, context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xActionBar, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((XActionBar) objArr2[0], (Context) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xActionBar;
            this.frontColor = i2;
        }

        private void drawPoint(Canvas canvas, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65537, this, canvas, i2) == null) {
                canvas.drawCircle(ScreenUtils.getPixel(getContext(), 26), ScreenUtils.getPixel(getContext(), i2), (int) (ScreenUtils.getScreenDensity(getContext()) * 1.0f), getPointPaint());
            }
        }

        private Paint getPointPaint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.pointPaint == null) {
                    Paint paint = new Paint();
                    this.pointPaint = paint;
                    paint.setColor(this.frontColor);
                    this.pointPaint.setAlpha(255);
                    this.pointPaint.setAntiAlias(true);
                }
                return this.pointPaint;
            }
            return (Paint) invokeV.objValue;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                drawPoint(canvas, 31);
                drawPoint(canvas, 15);
                drawPoint(canvas, 23);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XActionBar(Context context) {
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
        this.paint = new Paint();
        this.mBarWidth = 0;
        this.mBarHeight = 0;
        this.mContext = context;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.colorTheme.equals(App2Activity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME)) {
                this.paint.setColor(-5592406);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setStrokeWidth(ScreenUtils.getPixel(this.mContext, 1));
                int i2 = this.mBarHeight;
                canvas.drawLine(0.0f, i2, this.mBarWidth, i2, this.paint);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mBarWidth = i4 - i2;
            this.mBarHeight = i5 - i3;
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onButtonClickListener) == null) {
            this.mClickListener = onButtonClickListener;
        }
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (textView = this.titleTextView) == null) {
            return;
        }
        textView.setText(str);
        this.titleTextView.invalidate();
    }

    public void showDefaultBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int pixel = ScreenUtils.getPixel(this.mContext, 52);
            View goBackButtonView = new GoBackButtonView(this, this.mContext, this.colorTheme.getCloseColor());
            goBackButtonView.setId(GO_BACK_BUTTON_VIEW_ID);
            addView(goBackButtonView, new RelativeLayout.LayoutParams(pixel, -1));
            goBackButtonView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XActionBar.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XActionBar this$0;

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
                    OnButtonClickListener onButtonClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onButtonClickListener = this.this$0.mClickListener) == null) {
                        return;
                    }
                    onButtonClickListener.onGoBackBttonClick();
                }
            });
            View threePointButtonView = new ThreePointButtonView(this, this.mContext, this.colorTheme.getCloseColor());
            threePointButtonView.setId(THREE_POINT_BUTTON_VIEW_ID);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pixel, -1);
            layoutParams.addRule(11);
            threePointButtonView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.XActionBar.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XActionBar this$0;

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
                    OnButtonClickListener onButtonClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onButtonClickListener = this.this$0.mClickListener) == null) {
                        return;
                    }
                    onButtonClickListener.onThreePointButtonClick();
                }
            });
            addView(threePointButtonView, layoutParams);
            TextView textView = new TextView(this.mContext);
            this.titleTextView = textView;
            textView.setTextSize(1, 16.0f);
            this.titleTextView.setLines(1);
            this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.titleTextView.setGravity(16);
            this.titleTextView.setTextColor(this.colorTheme.getTitleColor());
            this.titleTextView.setText("");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtils.getScreenRect(this.mContext).width() - (pixel * 2), -1);
            layoutParams2.addRule(14);
            addView(this.titleTextView, layoutParams2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XActionBar(Context context, App2Activity.ActionBarColorTheme actionBarColorTheme) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, actionBarColorTheme};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.colorTheme = actionBarColorTheme;
        setBackgroundColor(actionBarColorTheme.getBackgroundColor());
        showDefaultBar();
    }
}
