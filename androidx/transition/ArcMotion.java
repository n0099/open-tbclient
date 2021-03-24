package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    public static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    public static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    public static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    public float mMaximumAngle;
    public float mMaximumTangent;
    public float mMinimumHorizontalAngle;
    public float mMinimumHorizontalTangent;
    public float mMinimumVerticalAngle;
    public float mMinimumVerticalTangent;

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }

    public static float toTangent(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f2 / 2.0f));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f9 = f4 - f2;
        float f10 = f5 - f3;
        float f11 = (f9 * f9) + (f10 * f10);
        float f12 = (f2 + f4) / 2.0f;
        float f13 = (f3 + f5) / 2.0f;
        float f14 = 0.25f * f11;
        boolean z = f3 > f5;
        if (Math.abs(f9) < Math.abs(f10)) {
            float abs = Math.abs(f11 / (f10 * 2.0f));
            if (z) {
                f7 = abs + f5;
                f6 = f4;
            } else {
                f7 = abs + f3;
                f6 = f2;
            }
            f8 = this.mMinimumVerticalTangent;
        } else {
            float f15 = f11 / (f9 * 2.0f);
            if (z) {
                f7 = f3;
                f6 = f15 + f2;
            } else {
                f6 = f4 - f15;
                f7 = f5;
            }
            f8 = this.mMinimumHorizontalTangent;
        }
        float f16 = f14 * f8 * f8;
        float f17 = f12 - f6;
        float f18 = f13 - f7;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = this.mMaximumTangent;
        float f21 = f14 * f20 * f20;
        if (f19 >= f16) {
            f16 = f19 > f21 ? f21 : 0.0f;
        }
        if (f16 != 0.0f) {
            float sqrt = (float) Math.sqrt(f16 / f19);
            f6 = ((f6 - f12) * sqrt) + f12;
            f7 = f13 + (sqrt * (f7 - f13));
        }
        path.cubicTo((f2 + f6) / 2.0f, (f3 + f7) / 2.0f, (f6 + f4) / 2.0f, (f7 + f5) / 2.0f, f4, f5);
        return path;
    }

    public void setMaximumAngle(float f2) {
        this.mMaximumAngle = f2;
        this.mMaximumTangent = toTangent(f2);
    }

    public void setMinimumHorizontalAngle(float f2) {
        this.mMinimumHorizontalAngle = f2;
        this.mMinimumHorizontalTangent = toTangent(f2);
    }

    public void setMinimumVerticalAngle(float f2) {
        this.mMinimumVerticalAngle = f2;
        this.mMinimumVerticalTangent = toTangent(f2);
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
