package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBackwards;
    public float mLastPosition;
    public int mNumberOfStages;
    public float mStage1Duration;
    public float mStage1EndPosition;
    public float mStage1Velocity;
    public float mStage2Duration;
    public float mStage2EndPosition;
    public float mStage2Velocity;
    public float mStage3Duration;
    public float mStage3EndPosition;
    public float mStage3Velocity;
    public float mStartPosition;
    public String mType;

    public StopLogic() {
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
        this.mBackwards = false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mBackwards) {
                return -getVelocity(this.mLastPosition);
            }
            return getVelocity(this.mLastPosition);
        }
        return invokeV.floatValue;
    }

    private float calcY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, this, f)) == null) {
            float f2 = this.mStage1Duration;
            if (f <= f2) {
                float f3 = this.mStage1Velocity;
                return (f3 * f) + ((((this.mStage2Velocity - f3) * f) * f) / (f2 * 2.0f));
            }
            int i = this.mNumberOfStages;
            if (i == 1) {
                return this.mStage1EndPosition;
            }
            float f4 = f - f2;
            float f5 = this.mStage2Duration;
            if (f4 < f5) {
                float f6 = this.mStage1EndPosition;
                float f7 = this.mStage2Velocity;
                return f6 + (f7 * f4) + ((((this.mStage3Velocity - f7) * f4) * f4) / (f5 * 2.0f));
            } else if (i == 2) {
                return this.mStage2EndPosition;
            } else {
                float f8 = f4 - f5;
                float f9 = this.mStage3Duration;
                if (f8 < f9) {
                    float f10 = this.mStage2EndPosition;
                    float f11 = this.mStage3Velocity;
                    return (f10 + (f11 * f8)) - (((f11 * f8) * f8) / (f9 * 2.0f));
                }
                return this.mStage3EndPosition;
            }
        }
        return invokeF.floatValue;
    }

    private void setup(float f, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (f == 0.0f) {
                f = 1.0E-4f;
            }
            this.mStage1Velocity = f;
            float f6 = f / f3;
            float f7 = (f6 * f) / 2.0f;
            if (f < 0.0f) {
                float sqrt = (float) Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
                if (sqrt < f4) {
                    this.mType = "backward accelerate, decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f;
                    this.mStage2Velocity = sqrt;
                    this.mStage3Velocity = 0.0f;
                    float f8 = (sqrt - f) / f3;
                    this.mStage1Duration = f8;
                    this.mStage2Duration = sqrt / f3;
                    this.mStage1EndPosition = ((f + sqrt) * f8) / 2.0f;
                    this.mStage2EndPosition = f2;
                    this.mStage3EndPosition = f2;
                    return;
                }
                this.mType = "backward accelerate cruse decelerate";
                this.mNumberOfStages = 3;
                this.mStage1Velocity = f;
                this.mStage2Velocity = f4;
                this.mStage3Velocity = f4;
                float f9 = (f4 - f) / f3;
                this.mStage1Duration = f9;
                float f10 = f4 / f3;
                this.mStage3Duration = f10;
                float f11 = ((f + f4) * f9) / 2.0f;
                float f12 = (f10 * f4) / 2.0f;
                this.mStage2Duration = ((f2 - f11) - f12) / f4;
                this.mStage1EndPosition = f11;
                this.mStage2EndPosition = f2 - f12;
                this.mStage3EndPosition = f2;
            } else if (f7 >= f2) {
                this.mType = "hard stop";
                this.mNumberOfStages = 1;
                this.mStage1Velocity = f;
                this.mStage2Velocity = 0.0f;
                this.mStage1EndPosition = f2;
                this.mStage1Duration = (2.0f * f2) / f;
            } else {
                float f13 = f2 - f7;
                float f14 = f13 / f;
                if (f14 + f6 < f5) {
                    this.mType = "cruse decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f;
                    this.mStage2Velocity = f;
                    this.mStage3Velocity = 0.0f;
                    this.mStage1EndPosition = f13;
                    this.mStage2EndPosition = f2;
                    this.mStage1Duration = f14;
                    this.mStage2Duration = f6;
                    return;
                }
                float sqrt2 = (float) Math.sqrt((f3 * f2) + ((f * f) / 2.0f));
                float f15 = (sqrt2 - f) / f3;
                this.mStage1Duration = f15;
                float f16 = sqrt2 / f3;
                this.mStage2Duration = f16;
                if (sqrt2 < f4) {
                    this.mType = "accelerate decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f;
                    this.mStage2Velocity = sqrt2;
                    this.mStage3Velocity = 0.0f;
                    this.mStage1Duration = f15;
                    this.mStage2Duration = f16;
                    this.mStage1EndPosition = ((f + sqrt2) * f15) / 2.0f;
                    this.mStage2EndPosition = f2;
                    return;
                }
                this.mType = "accelerate cruse decelerate";
                this.mNumberOfStages = 3;
                this.mStage1Velocity = f;
                this.mStage2Velocity = f4;
                this.mStage3Velocity = f4;
                float f17 = (f4 - f) / f3;
                this.mStage1Duration = f17;
                float f18 = f4 / f3;
                this.mStage3Duration = f18;
                float f19 = ((f + f4) * f17) / 2.0f;
                float f20 = (f18 * f4) / 2.0f;
                this.mStage2Duration = ((f2 - f19) - f20) / f4;
                this.mStage1EndPosition = f19;
                this.mStage2EndPosition = f2 - f20;
                this.mStage3EndPosition = f2;
            }
        }
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            this.mStartPosition = f;
            if (f > f2) {
                z = true;
            } else {
                z = false;
            }
            this.mBackwards = z;
            if (z) {
                setup(-f3, f - f2, f5, f6, f4);
            } else {
                setup(f3, f2 - f, f5, f6, f4);
            }
        }
    }

    public void debug(String str, String str2, float f) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Float.valueOf(f)}) == null) {
            Log.v(str, str2 + " ===== " + this.mType);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            if (this.mBackwards) {
                str3 = "backwards";
            } else {
                str3 = "forward ";
            }
            sb.append(str3);
            sb.append(" time = ");
            sb.append(f);
            sb.append("  stages ");
            sb.append(this.mNumberOfStages);
            Log.v(str, sb.toString());
            Log.v(str, str2 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition);
            if (this.mNumberOfStages > 1) {
                Log.v(str, str2 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition);
            }
            if (this.mNumberOfStages > 2) {
                Log.v(str, str2 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition);
            }
            float f2 = this.mStage1Duration;
            if (f <= f2) {
                Log.v(str, str2 + "stage 0");
                return;
            }
            int i = this.mNumberOfStages;
            if (i == 1) {
                Log.v(str, str2 + "end stage 0");
                return;
            }
            float f3 = f - f2;
            float f4 = this.mStage2Duration;
            if (f3 < f4) {
                Log.v(str, str2 + " stage 1");
            } else if (i == 2) {
                Log.v(str, str2 + "end stage 1");
            } else if (f3 - f4 < this.mStage3Duration) {
                Log.v(str, str2 + " stage 2");
            } else {
                Log.v(str, str2 + " end stage 2");
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
            float calcY = calcY(f);
            this.mLastPosition = f;
            if (this.mBackwards) {
                return this.mStartPosition - calcY;
            }
            return this.mStartPosition + calcY;
        }
        return invokeF.floatValue;
    }

    public float getVelocity(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
            float f2 = this.mStage1Duration;
            if (f <= f2) {
                float f3 = this.mStage1Velocity;
                return f3 + (((this.mStage2Velocity - f3) * f) / f2);
            }
            int i = this.mNumberOfStages;
            if (i == 1) {
                return 0.0f;
            }
            float f4 = f - f2;
            float f5 = this.mStage2Duration;
            if (f4 < f5) {
                float f6 = this.mStage2Velocity;
                return f6 + (((this.mStage3Velocity - f6) * f4) / f5);
            } else if (i == 2) {
                return this.mStage2EndPosition;
            } else {
                float f7 = f4 - f5;
                float f8 = this.mStage3Duration;
                if (f7 < f8) {
                    float f9 = this.mStage3Velocity;
                    return f9 - ((f7 * f9) / f8);
                }
                return this.mStage3EndPosition;
            }
        }
        return invokeF.floatValue;
    }
}
