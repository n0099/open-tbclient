package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.e0.a.d.b;
import c.a.b0.h0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BdVideoSeekbarImageView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BLANK_SPACE = " ";
    public static final int UI_DURATION_TEXT_MARGIN_LEFT;
    public static final int UI_HALF_SEEKBAR_MARGIN_LEFT;
    public static final int UI_IMAGE_TOP_MARGIN;
    public static final int UI_SEEKBAR_MARGIN_LEFT;
    public static final int UI_TEXT_FONT_SIZE;
    public static final int UI_TEXT_TITLE_FONT_SIZE;

    /* renamed from: j  reason: collision with root package name */
    public static final int f37739j;

    /* renamed from: k  reason: collision with root package name */
    public static final int f37740k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public String duration;

    /* renamed from: e  reason: collision with root package name */
    public final Context f37741e;

    /* renamed from: f  reason: collision with root package name */
    public int f37742f;

    /* renamed from: g  reason: collision with root package name */
    public int f37743g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f37744h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37745i;
    public BdThumbSeekBar mBdVideoSeekBar;
    public Drawable mBg;
    public int mMsgFontSize;
    public Paint mPaint;
    public Rect mRect;
    public Paint mTextPaint;
    public String mTextTitle;
    public int mTitleFontSize;
    public String seekPosition;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158956266, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoSeekbarImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158956266, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoSeekbarImageView;");
                return;
            }
        }
        UI_TEXT_FONT_SIZE = b.a(12.0f);
        UI_TEXT_TITLE_FONT_SIZE = b.d(30.0f);
        UI_IMAGE_TOP_MARGIN = b.a(17.0f);
        f37739j = b.a(13.0f);
        f37740k = b.a(2.0f);
        b.a(9.0f);
        l = b.b(90.0f);
        m = b.b(90.0f);
        n = b.a(77.0f);
        o = b.a(7.0f);
        p = b.a(1.0f);
        UI_SEEKBAR_MARGIN_LEFT = b.a(23.0f);
        UI_HALF_SEEKBAR_MARGIN_LEFT = b.a(21.0f);
        q = b.a(64.0f);
        r = b.a(34.0f);
        s = b.a(27.0f);
        t = b.a(25.0f);
        u = b.a(11.0f);
        v = b.a(9.0f);
        UI_DURATION_TEXT_MARGIN_LEFT = b.a(60.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdVideoSeekbarImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setTextSize(UI_TEXT_FONT_SIZE);
            this.mPaint.setColor(-1);
            Paint paint2 = new Paint();
            this.mTextPaint = paint2;
            paint2.setAntiAlias(true);
            this.mTextPaint.setTextSize(UI_TEXT_FONT_SIZE);
            this.mTextPaint.setColor(-7829368);
            this.mRect = new Rect();
            this.mBg = this.f37741e.getResources().getDrawable(q.nad_videoplayer_play_seekbar_background);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.f37741e, p);
            this.mBdVideoSeekBar = bdThumbSeekBar;
            bdThumbSeekBar.setDragable(false);
            this.mBdVideoSeekBar.setProgressBackgroundColor(-1);
            this.mBdVideoSeekBar.setThumbScaleVisible(false);
        }
    }

    public Bitmap getViewBitmap(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            view.setDrawingCacheEnabled(true);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            int width = drawingCache.getWidth();
            int height = drawingCache.getHeight();
            int i2 = n;
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, o / height);
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Drawable drawable = this.mBg;
            if (drawable != null) {
                this.mRect.set(0, 0, measuredWidth, measuredHeight);
                drawable.setBounds(this.mRect);
                drawable.draw(canvas);
            }
            if (this.f37744h == null) {
                this.mPaint.setTextSize(this.mTitleFontSize);
                canvas.drawText(this.mTextTitle, measuredWidth >> 1, UI_IMAGE_TOP_MARGIN * 2, this.mPaint);
            } else if (this.f37745i) {
                canvas.drawBitmap(this.f37744h, (measuredWidth - bitmap.getWidth()) / 2, UI_IMAGE_TOP_MARGIN, this.mPaint);
            }
            if (this.f37745i) {
                i2 = (measuredHeight / 2) + f37739j;
            } else {
                i2 = (measuredHeight / 2) - f37740k;
            }
            this.mPaint.setTextSize(this.mMsgFontSize);
            float f2 = i2;
            canvas.drawText(this.seekPosition + " ", seekPositionHorizontal(), f2, this.mPaint);
            canvas.drawText("/ " + this.duration, UI_DURATION_TEXT_MARGIN_LEFT, f2, this.mTextPaint);
            BdThumbSeekBar bdThumbSeekBar = this.mBdVideoSeekBar;
            if (bdThumbSeekBar != null) {
                Bitmap viewBitmap = getViewBitmap(bdThumbSeekBar);
                if (this.f37745i) {
                    canvas.drawBitmap(viewBitmap, UI_SEEKBAR_MARGIN_LEFT, q, this.mPaint);
                } else {
                    canvas.drawBitmap(viewBitmap, UI_HALF_SEEKBAR_MARGIN_LEFT, r, this.mPaint);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            setMeasuredDimension(this.f37742f, this.f37743g);
        }
    }

    public void refreshPositionAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            setDuration(i3);
            setPosition(i2);
            invalidate();
        }
    }

    public float seekPositionHorizontal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.duration.length() < 6) {
                return this.f37745i ? s : t;
            }
            return this.f37745i ? u : v;
        }
        return invokeV.floatValue;
    }

    public void setBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mBg = this.f37741e.getResources().getDrawable(i2);
        }
    }

    public void setDuration(int i2) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bdThumbSeekBar = this.mBdVideoSeekBar) == null) {
            return;
        }
        bdThumbSeekBar.setMax(i2);
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f37743g = i2;
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f37744h = BitmapFactory.decodeResource(this.f37741e.getResources(), i2);
        }
    }

    public void setIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f37745i = z;
        }
    }

    public void setMsg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.seekPosition = str;
            this.duration = str2;
            invalidate();
        }
    }

    public void setMsgFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mMsgFontSize = i2;
        }
    }

    public void setPosition(int i2) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (bdThumbSeekBar = this.mBdVideoSeekBar) == null) {
            return;
        }
        bdThumbSeekBar.setProgress(i2);
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mTextTitle = str;
        }
    }

    public void setTitleFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mTitleFontSize = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f37742f = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoSeekbarImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37742f = l;
        this.f37743g = m;
        this.mTextTitle = "";
        this.seekPosition = "";
        this.duration = "";
        this.mTitleFontSize = UI_TEXT_TITLE_FONT_SIZE;
        this.mMsgFontSize = UI_TEXT_FONT_SIZE;
        this.f37745i = true;
        this.f37741e = context;
        a();
    }
}
