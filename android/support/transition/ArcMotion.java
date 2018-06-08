package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes2.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    private static float toTangent(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    @Override // android.support.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path = new Path();
        path.moveTo(f, f2);
        float f13 = f3 - f;
        float f14 = f4 - f2;
        float f15 = (f14 * f14) + (f13 * f13);
        float f16 = (f + f3) / 2.0f;
        float f17 = (f2 + f4) / 2.0f;
        float f18 = f15 * 0.25f;
        boolean z = f2 > f4;
        if (Math.abs(f13) < Math.abs(f14)) {
            float abs = Math.abs(f15 / (2.0f * f14));
            if (z) {
                f11 = f4 + abs;
                f12 = f3;
            } else {
                f11 = f2 + abs;
                f12 = f;
            }
            f7 = f12;
            f8 = f11;
            f9 = this.mMinimumVerticalTangent * f18 * this.mMinimumVerticalTangent;
        } else {
            float f19 = f15 / (f13 * 2.0f);
            if (z) {
                f5 = f + f19;
                f6 = f2;
            } else {
                f5 = f3 - f19;
                f6 = f4;
            }
            f7 = f5;
            f8 = f6;
            f9 = this.mMinimumHorizontalTangent * f18 * this.mMinimumHorizontalTangent;
        }
        float f20 = f16 - f7;
        float f21 = f17 - f8;
        float f22 = (f21 * f21) + (f20 * f20);
        float f23 = this.mMaximumTangent * f18 * this.mMaximumTangent;
        if (f22 >= f9) {
            f9 = f22 > f23 ? f23 : 0.0f;
        }
        if (f9 != 0.0f) {
            float sqrt = (float) Math.sqrt(f9 / f22);
            f7 = ((f7 - f16) * sqrt) + f16;
            f10 = f17 + (sqrt * (f8 - f17));
        } else {
            f10 = f8;
        }
        path.cubicTo((f + f7) / 2.0f, (f2 + f10) / 2.0f, (f7 + f3) / 2.0f, (f10 + f4) / 2.0f, f3, f4);
        return path;
    }
}
