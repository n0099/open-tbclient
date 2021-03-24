package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    public Path mOriginalPatternPath;
    public final Path mPatternPath = new Path();
    public final Matrix mTempMatrix = new Matrix();

    public PatternPathMotion() {
        this.mPatternPath.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = this.mPatternPath;
    }

    public static float distance(float f2, float f3) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float distance = distance(f6, f7);
        double atan2 = Math.atan2(f7, f6);
        this.mTempMatrix.setScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(atan2));
        this.mTempMatrix.postTranslate(f2, f3);
        Path path = new Path();
        this.mPatternPath.transform(this.mTempMatrix, path);
        return path;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.mTempMatrix.setTranslate(-f4, -f5);
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float distance = 1.0f / distance(f6, f7);
        this.mTempMatrix.postScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(f7, f6)));
        path.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.PATTERN_PATH_MOTION);
        try {
            String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString != null) {
                setPatternPath(PathParser.createPathFromPathData(namedString));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        setPatternPath(path);
    }
}
