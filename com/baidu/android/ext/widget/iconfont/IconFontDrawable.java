package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class IconFontDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_COLOR = -16777216;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mFontPath;
    public String mIconFont;
    public int mIconFontColor;
    public TextPaint mIconFontPaint;
    public Rect mTempRect;
    public float mX;
    public float mY;

    public IconFontDrawable(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIconFontColor = -16777216;
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            this.mContext = context;
            TextPaint textPaint = new TextPaint(1);
            this.mIconFontPaint = textPaint;
            textPaint.setStyle(Paint.Style.FILL);
            this.mIconFontPaint.setTextAlign(Paint.Align.CENTER);
            this.mIconFontPaint.setUnderlineText(false);
            this.mIconFontPaint.setColor(this.mIconFontColor);
            this.mIconFontPaint.setAntiAlias(true);
            this.mTempRect = new Rect();
            if (TextUtils.isEmpty(this.mFontPath)) {
                return;
            }
            this.mIconFontPaint.setTypeface(TypefaceCache.getTypeface(this.mContext, this.mFontPath));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || TextUtils.isEmpty(this.mFontPath) || TextUtils.isEmpty(this.mIconFont)) {
            return;
        }
        Rect bounds = getBounds();
        if (bounds.width() == 0 && bounds.height() == 0) {
            return;
        }
        this.mX = bounds.exactCenterX();
        Rect rect = this.mTempRect;
        int min = Math.min(bounds.height(), bounds.width());
        this.mIconFontPaint.setTextSize(min);
        TextPaint textPaint = this.mIconFontPaint;
        String str = this.mIconFont;
        textPaint.getTextBounds(str, 0, str.length(), rect);
        int height = rect.height();
        float f2 = ((bounds.top + ((min - height) / 2.0f)) + height) - rect.bottom;
        this.mY = f2;
        canvas.drawText(this.mIconFont, this.mX, f2, this.mIconFontPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int alpha = this.mIconFontPaint.getAlpha();
            if (alpha <= 0) {
                return -2;
            }
            return (alpha <= 0 || alpha >= 255) ? -1 : -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mIconFontPaint.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, colorFilter) == null) {
            this.mIconFontPaint.setColorFilter(colorFilter);
        }
    }

    public void setFontPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, this.mFontPath)) {
            return;
        }
        this.mFontPath = str;
        this.mIconFontPaint.setTypeface(TypefaceCache.getTypeface(this.mContext, str));
        invalidateSelf();
    }

    public void setIconFont(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, this.mIconFont)) {
            return;
        }
        this.mIconFont = str;
        invalidateSelf();
    }

    public void setIconFontColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == 0 || i2 == this.mIconFontColor) {
            return;
        }
        this.mIconFontColor = i2;
        this.mIconFontPaint.setColor(i2);
        invalidateSelf();
    }

    public IconFontDrawable(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIconFontColor = -16777216;
        this.mFontPath = str;
        this.mIconFont = str2;
        init(context);
    }
}
