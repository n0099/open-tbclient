package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path mOriginalPatternPath;
    public final Path mPatternPath;
    public final Matrix mTempMatrix;

    public PatternPathMotion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        this.mPatternPath.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = this.mPatternPath;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {path};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(path);
    }

    public static float distance(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return invokeCommon.floatValue;
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = f3 - f;
            float f6 = f4 - f2;
            float distance = distance(f5, f6);
            double atan2 = Math.atan2(f6, f5);
            this.mTempMatrix.setScale(distance, distance);
            this.mTempMatrix.postRotate((float) Math.toDegrees(atan2));
            this.mTempMatrix.postTranslate(f, f2);
            Path path = new Path();
            this.mPatternPath.transform(this.mTempMatrix, path);
            return path;
        }
        return (Path) invokeCommon.objValue;
    }

    public Path getPatternPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mOriginalPatternPath;
        }
        return (Path) invokeV.objValue;
    }

    public void setPatternPath(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, path) == null) {
            PathMeasure pathMeasure = new PathMeasure(path, false);
            float[] fArr = new float[2];
            pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
            float f = fArr[0];
            float f2 = fArr[1];
            pathMeasure.getPosTan(0.0f, fArr, null);
            float f3 = fArr[0];
            float f4 = fArr[1];
            if (f3 == f && f4 == f2) {
                throw new IllegalArgumentException("pattern must not end at the starting point");
            }
            this.mTempMatrix.setTranslate(-f3, -f4);
            float f5 = f - f3;
            float f6 = f2 - f4;
            float distance = 1.0f / distance(f5, f6);
            this.mTempMatrix.postScale(distance, distance);
            this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
            path.transform(this.mTempMatrix, this.mPatternPath);
            this.mOriginalPatternPath = path;
        }
    }
}
