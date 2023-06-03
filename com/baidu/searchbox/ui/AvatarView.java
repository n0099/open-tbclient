package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class AvatarView extends FrameLayout {
    public static final float CANVAS_DRAW_CICLE_ROTATION_ANGLE = 45.0f;
    public static final int DEFAULT_AVATAR_DIAMETER = 300;
    public static final int DEFAULT_CIRCLE_END_COLOR = 3383551;
    public static final int DEFAULT_CIRCLE_START_COLOR = -9316097;
    public static final int DEFAULT_CIRCLE_STROKE_WIDTH = 30;
    public static final String RES_URI_PREFIX = "res://" + AppRuntime.getAppContext().getPackageName() + "/";
    public int mAvatarDiameter;
    public SimpleDraweeView mAvatarIcon;
    public int mCircleEndColor;
    public int mCircleStartColor;
    public int mCircleStrokeWidth;
    public boolean mIsUseNightMode;
    public final Paint mPaint;

    private void updateLayoutParams() {
        SimpleDraweeView simpleDraweeView = this.mAvatarIcon;
        if (simpleDraweeView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) simpleDraweeView.getLayoutParams();
            int i = this.mAvatarDiameter;
            layoutParams.width = i;
            layoutParams.height = i;
            int i2 = this.mCircleStrokeWidth;
            layoutParams.topMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            layoutParams.bottomMargin = i2;
            this.mAvatarIcon.setLayoutParams(layoutParams);
        }
    }

    public AvatarView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        if (context == null) {
            return;
        }
        setWillNotDraw(false);
        LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.avatar_view_layout, this);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(com.baidu.tieba.R.id.avatar_img);
        this.mAvatarIcon = simpleDraweeView;
        simpleDraweeView.getHierarchy().setUseGlobalColorFilter(this.mIsUseNightMode);
    }

    @SuppressLint({"SwitchIntDef"})
    private int measureDimension(int i) {
        int i2 = this.mAvatarDiameter + (this.mCircleStrokeWidth * 2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                return size;
            }
            return i2;
        }
        return Math.min(i2, size);
    }

    public void setAvatarDiameter(int i) {
        this.mAvatarDiameter = i;
    }

    public void setAvatarImage(int i) {
        this.mAvatarIcon.setImageURI(Uri.parse(RES_URI_PREFIX + i));
    }

    public void setCircleEndColor(int i) {
        this.mCircleEndColor = i;
        updatePaint();
        postInvalidate();
    }

    public void setCircleStartColor(int i) {
        this.mCircleStartColor = i;
        updatePaint();
        postInvalidate();
    }

    public void setCircleStrokeWidth(int i) {
        this.mCircleStrokeWidth = i;
        updatePaint();
        postInvalidate();
    }

    public void setUseNightMode(boolean z) {
        this.mIsUseNightMode = z;
        this.mAvatarIcon.getHierarchy().setUseGlobalColorFilter(this.mIsUseNightMode);
    }

    public AvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(measureDimension(i), measureDimension(i2));
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsUseNightMode = true;
        this.mPaint = new Paint();
        initAttrs(context, attributeSet);
        init(context);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.searchbox.common.res.R.styleable.avatarView);
        this.mAvatarDiameter = obtainStyledAttributes.getDimensionPixelSize(0, 300);
        this.mCircleStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(3, 30);
        this.mCircleStartColor = obtainStyledAttributes.getColor(2, DEFAULT_CIRCLE_START_COLOR);
        this.mCircleEndColor = obtainStyledAttributes.getColor(1, DEFAULT_CIRCLE_END_COLOR);
        this.mIsUseNightMode = obtainStyledAttributes.getBoolean(4, true);
        updatePaint();
        updateLayoutParams();
        obtainStyledAttributes.recycle();
    }

    private void updatePaint() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mCircleStrokeWidth);
        int i = this.mAvatarDiameter;
        this.mPaint.setShader(new LinearGradient(0.0f, (-i) / 2, 0.0f, i / 2, this.mCircleStartColor, this.mCircleEndColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        updateLayoutParams();
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.mAvatarIcon.getX() + (this.mAvatarIcon.getWidth() / 2), this.mAvatarIcon.getY() + (this.mAvatarIcon.getHeight() / 2));
        canvas.rotate(45.0f);
        canvas.drawCircle(0.0f, 0.0f, (this.mAvatarDiameter + this.mCircleStrokeWidth) / 2, this.mPaint);
        canvas.restore();
    }

    public void setAvatarImage(Uri uri) {
        if (uri != null) {
            this.mAvatarIcon.setImageURI(uri);
        }
    }

    public void setAvatarImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAvatarIcon.setImageURI(str);
        }
    }
}
