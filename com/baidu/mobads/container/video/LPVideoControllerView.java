package com.baidu.mobads.container.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LPVideoControllerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FULL_SCREEN_SHRINK = "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";
    public static final String FULL_SCREEN_STRETCH = "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";
    public static final String PAUSE = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAABlBMVEX///////9VfPVsAAAAAnRSTlMA5j/6inUAAAAiSURBVEjHY2AY4YARBIgSHNUwqmFUw6iGUQ2jGkY1jFAAANsqAX0ssJs1AAAAAElFTkSuQmCC";
    public static final String PLAY = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAA7VBMVEX////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////tpuCXAAAAT3RSTlMAoRzm3GoEvTPkiQ7RUakh3nIFwjrlkRLVWAGvJ+F4CMdBmBfYYQK2K+KAC8xIoBvbZKzPUH6rJs5PfKolTnuoJMtMeaciSgmlIMpJ4HajngnYGgAAAM5JREFUSMfl1cdaQlEMhdELmyJNiiBFDl0UzkW6SpMqRcD3fxye4R+T+RrkS7LjOPdcHi8E8vkDDEjBBwgUCkcYkKIxCKTHOARKJFMMSE9pCJR5zjIg5fIFBqSXIgQypTIDUqUKgVSrQ6DGa5MB6e0dArXalgHJ7UAgfXQhUK8PwaCIwHCEejBji5r+/EJz+J6gSZupRbs0m6NtdRfoHsyPRRe3XKGbXm9QapitRbm0+0XJt96jbDWlA0rv4wn9h78z+kCXaxn9uP+Tczd1AyMAFRYpWtU+AAAAAElFTkSuQmCC";
    public static final int PROGRESS_HEIGHT = 3;
    public static final int VIEW_ID_IMAGE_FULL_SCREEN = 1234234935;
    public static final int VIEW_ID_IMAGE_PLAY = 1234234933;
    public static final int VIEW_ID_TEXT_ELAPSED = 1234234934;
    public static final int VIEW_ID_TEXT_TOTAL = 1234234936;
    public transient /* synthetic */ FieldHolder $fh;
    public int heightOfViewController;
    public int icon;
    public int iconMargin;
    public ImageView imgfullscreen;
    public ImageView imgplay;
    public Context mContext;
    public SeekBar seekBar;
    public TextView textElapsed;
    public TextView textTotal;
    public int thumDiameter;
    public int thumbMargin;
    public int timeLength;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LPVideoControllerView(Context context) {
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
        this.heightOfViewController = 30;
        this.iconMargin = 5;
        this.thumbMargin = 10;
        this.icon = 25;
        this.timeLength = 45;
        this.thumDiameter = 14;
        this.mContext = context;
        this.iconMargin = ScreenUtils.getPixel(context, 5);
        this.timeLength = ScreenUtils.getPixel(this.mContext, this.timeLength);
        this.thumbMargin = ScreenUtils.getPixel(this.mContext, this.thumbMargin);
        this.heightOfViewController = ScreenUtils.getPixel(this.mContext, this.heightOfViewController);
        this.icon = ScreenUtils.getPixel(this.mContext, this.icon);
        this.thumDiameter = ScreenUtils.getPixel(this.mContext, this.thumDiameter);
        setBackgroundColor(1291845631);
        ImageView imageView = new ImageView(this.mContext);
        this.imgplay = imageView;
        imageView.setId(VIEW_ID_IMAGE_PLAY);
        int i4 = this.iconMargin;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.icon + i4, this.heightOfViewController);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.imgplay.setPadding(i4, i4, i4, i4);
        this.imgplay.setLayoutParams(layoutParams);
        addView(this.imgplay);
        TextView textView = new TextView(this.mContext);
        this.textElapsed = textView;
        textView.setId(VIEW_ID_TEXT_ELAPSED);
        this.textElapsed.setText("00:00");
        this.textElapsed.setGravity(17);
        this.textElapsed.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.timeLength, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.imgplay.getId());
        this.textElapsed.setLayoutParams(layoutParams2);
        addView(this.textElapsed);
        ImageView imageView2 = new ImageView(this.mContext);
        this.imgfullscreen = imageView2;
        imageView2.setId(VIEW_ID_IMAGE_FULL_SCREEN);
        int i5 = this.iconMargin;
        this.imgfullscreen.setPadding(i5, i5, i5, i5);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.icon + i5, this.heightOfViewController);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        this.imgfullscreen.setLayoutParams(layoutParams3);
        updateImageFullscreen(true);
        addView(this.imgfullscreen);
        TextView textView2 = new TextView(this.mContext);
        this.textTotal = textView2;
        textView2.setId(VIEW_ID_TEXT_TOTAL);
        this.textTotal.setText("00:00");
        this.textTotal.setTextColor(-1);
        this.textTotal.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.timeLength, -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, this.imgfullscreen.getId());
        this.textTotal.setLayoutParams(layoutParams4);
        addView(this.textTotal);
        this.seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(context, 30));
        layoutParams5.addRule(15);
        layoutParams5.addRule(0, this.textTotal.getId());
        layoutParams5.addRule(1, this.textElapsed.getId());
        int i6 = this.thumbMargin;
        layoutParams5.rightMargin = i6;
        layoutParams5.leftMargin = 0;
        this.seekBar.setPadding(i6, 0, i6, 0);
        this.seekBar.setLayoutParams(layoutParams5);
        addView(this.seekBar);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.seekBar == null) {
                return;
            }
            ProgressDrawable progressDrawable = new ProgressDrawable(this, this.mContext, this.heightOfViewController, this.seekBar.getWidth());
            progressDrawable.mPaint.setARGB(255, 0, 191, 255);
            this.seekBar.setProgressDrawable(new ClipDrawable(progressDrawable, 3, 1));
            ProgressDrawable progressDrawable2 = new ProgressDrawable(this, this.mContext, this.heightOfViewController, this.seekBar.getWidth(), this.thumbMargin);
            progressDrawable2.mPaint.setColor(-1);
            this.seekBar.setBackgroundDrawable(progressDrawable2);
            if (Build.VERSION.SDK_INT >= 11) {
                this.seekBar.getBackground().setAlpha(0);
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.setIntrinsicHeight(this.thumDiameter);
            shapeDrawable.setIntrinsicWidth(this.thumDiameter);
            shapeDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            this.seekBar.setThumb(shapeDrawable);
        }
    }

    public void updateImageFullscreen(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (imageView = this.imgfullscreen) == null) {
            return;
        }
        if (z) {
            imageView.setImageBitmap(ConvertUtils.string2bitmap(FULL_SCREEN_STRETCH));
        } else {
            imageView.setImageBitmap(ConvertUtils.string2bitmap(FULL_SCREEN_SHRINK));
        }
    }

    public void updateImagePauseOrPlay(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (imageView = this.imgplay) == null) {
            return;
        }
        if (z) {
            imageView.setImageBitmap(ConvertUtils.string2bitmap(PLAY));
        } else {
            imageView.setImageBitmap(ConvertUtils.string2bitmap(PAUSE));
        }
    }

    /* loaded from: classes5.dex */
    public class ProgressDrawable extends Drawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public int height;
        public Paint mPaint;
        public int padding;
        public final /* synthetic */ LPVideoControllerView this$0;
        public int width;

        public ProgressDrawable(LPVideoControllerView lPVideoControllerView, Context context, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPVideoControllerView, context, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lPVideoControllerView;
            this.height = 0;
            this.width = 0;
            this.padding = 0;
            this.context = context;
            this.height = i2;
            this.width = i3;
            this.mPaint = getPaint();
        }

        private Paint getPaint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.mPaint == null) {
                    Paint paint = new Paint();
                    this.mPaint = paint;
                    paint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setAlpha(255);
                    this.mPaint.setAntiAlias(true);
                    this.mPaint.setStrokeWidth(ScreenUtils.getPixel(this.context, 3));
                }
                return this.mPaint;
            }
            return (Paint) invokeV.objValue;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                int i2 = this.padding;
                int i3 = this.height;
                canvas.drawLine(i2, i3 / 2, this.width - i2, i3 / 2, this.mPaint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, colorFilter) == null) {
            }
        }

        public ProgressDrawable(LPVideoControllerView lPVideoControllerView, Context context, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lPVideoControllerView, context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = lPVideoControllerView;
            this.height = 0;
            this.width = 0;
            this.padding = 0;
            this.context = context;
            this.height = i2;
            this.width = i3;
            this.mPaint = getPaint();
            this.padding = i4;
        }
    }
}
