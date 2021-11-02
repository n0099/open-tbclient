package androidx.constraintlayout.motion.utils;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackwards = false;
    }

    private float calcY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, this, f2)) == null) {
            float f3 = this.mStage1Duration;
            if (f2 <= f3) {
                float f4 = this.mStage1Velocity;
                return (f4 * f2) + ((((this.mStage2Velocity - f4) * f2) * f2) / (f3 * 2.0f));
            }
            int i2 = this.mNumberOfStages;
            if (i2 == 1) {
                return this.mStage1EndPosition;
            }
            float f5 = f2 - f3;
            float f6 = this.mStage2Duration;
            if (f5 < f6) {
                float f7 = this.mStage1EndPosition;
                float f8 = this.mStage2Velocity;
                return f7 + (f8 * f5) + ((((this.mStage3Velocity - f8) * f5) * f5) / (f6 * 2.0f));
            } else if (i2 == 2) {
                return this.mStage2EndPosition;
            } else {
                float f9 = f5 - f6;
                float f10 = this.mStage3Duration;
                if (f9 < f10) {
                    float f11 = this.mStage2EndPosition;
                    float f12 = this.mStage3Velocity;
                    return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
                }
                return this.mStage3EndPosition;
            }
        }
        return invokeF.floatValue;
    }

    private void setup(float f2, float f3, float f4, float f5, float f6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
            if (f2 == 0.0f) {
                f2 = 1.0E-4f;
            }
            this.mStage1Velocity = f2;
            float f7 = f2 / f4;
            float f8 = (f7 * f2) / 2.0f;
            if (f2 < 0.0f) {
                float sqrt = (float) Math.sqrt((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4);
                if (sqrt < f5) {
                    this.mType = "backward accelerate, decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f2;
                    this.mStage2Velocity = sqrt;
                    this.mStage3Velocity = 0.0f;
                    float f9 = (sqrt - f2) / f4;
                    this.mStage1Duration = f9;
                    this.mStage2Duration = sqrt / f4;
                    this.mStage1EndPosition = ((f2 + sqrt) * f9) / 2.0f;
                    this.mStage2EndPosition = f3;
                    this.mStage3EndPosition = f3;
                    return;
                }
                this.mType = "backward accelerate cruse decelerate";
                this.mNumberOfStages = 3;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = f5;
                this.mStage3Velocity = f5;
                float f10 = (f5 - f2) / f4;
                this.mStage1Duration = f10;
                float f11 = f5 / f4;
                this.mStage3Duration = f11;
                float f12 = ((f2 + f5) * f10) / 2.0f;
                float f13 = (f11 * f5) / 2.0f;
                this.mStage2Duration = ((f3 - f12) - f13) / f5;
                this.mStage1EndPosition = f12;
                this.mStage2EndPosition = f3 - f13;
                this.mStage3EndPosition = f3;
            } else if (f8 >= f3) {
                this.mType = "hard stop";
                this.mNumberOfStages = 1;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = 0.0f;
                this.mStage1EndPosition = f3;
                this.mStage1Duration = (2.0f * f3) / f2;
            } else {
                float f14 = f3 - f8;
                float f15 = f14 / f2;
                if (f15 + f7 < f6) {
                    this.mType = "cruse decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f2;
                    this.mStage2Velocity = f2;
                    this.mStage3Velocity = 0.0f;
                    this.mStage1EndPosition = f14;
                    this.mStage2EndPosition = f3;
                    this.mStage1Duration = f15;
                    this.mStage2Duration = f7;
                    return;
                }
                float sqrt2 = (float) Math.sqrt((f4 * f3) + ((f2 * f2) / 2.0f));
                float f16 = (sqrt2 - f2) / f4;
                this.mStage1Duration = f16;
                float f17 = sqrt2 / f4;
                this.mStage2Duration = f17;
                if (sqrt2 < f5) {
                    this.mType = "accelerate decelerate";
                    this.mNumberOfStages = 2;
                    this.mStage1Velocity = f2;
                    this.mStage2Velocity = sqrt2;
                    this.mStage3Velocity = 0.0f;
                    this.mStage1Duration = f16;
                    this.mStage2Duration = f17;
                    this.mStage1EndPosition = ((f2 + sqrt2) * f16) / 2.0f;
                    this.mStage2EndPosition = f3;
                    return;
                }
                this.mType = "accelerate cruse decelerate";
                this.mNumberOfStages = 3;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = f5;
                this.mStage3Velocity = f5;
                float f18 = (f5 - f2) / f4;
                this.mStage1Duration = f18;
                float f19 = f5 / f4;
                this.mStage3Duration = f19;
                float f20 = ((f2 + f5) * f18) / 2.0f;
                float f21 = (f19 * f5) / 2.0f;
                this.mStage2Duration = ((f3 - f20) - f21) / f5;
                this.mStage1EndPosition = f20;
                this.mStage2EndPosition = f3 - f21;
                this.mStage3EndPosition = f3;
            }
        }
    }

    public void config(float f2, float f3, float f4, float f5, float f6, float f7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
            this.mStartPosition = f2;
            boolean z = f2 > f3;
            this.mBackwards = z;
            if (z) {
                setup(-f4, f2 - f3, f6, f7, f5);
            } else {
                setup(f4, f3 - f2, f6, f7, f5);
            }
        }
    }

    public void debug(String str, String str2, float f2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Float.valueOf(f2)}) == null) {
            String str4 = str2 + " ===== " + this.mType;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(this.mBackwards ? "backwards" : "forward ");
            sb.append(" time = ");
            sb.append(f2);
            sb.append("  stages ");
            sb.append(this.mNumberOfStages);
            sb.toString();
            String str5 = str2 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition;
            if (this.mNumberOfStages > 1) {
                r0 = str2 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition;
            }
            if (this.mNumberOfStages > 2) {
                r0 = str2 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition;
            }
            float f3 = this.mStage1Duration;
            if (f2 <= f3) {
                r0 = str2 + "stage 0";
                return;
            }
            int i2 = this.mNumberOfStages;
            if (i2 == 1) {
                str3 = str2 + "end stage 0";
                return;
            }
            float f4 = f2 - f3;
            float f5 = this.mStage2Duration;
            if (f4 < f5) {
                String str6 = str2 + " stage 1";
            } else if (i2 == 2) {
                String str7 = str2 + "end stage 1";
            } else if (f4 - f5 < this.mStage3Duration) {
                String str8 = str2 + " stage 2";
            } else {
                String str9 = str2 + " end stage 2";
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            float calcY = calcY(f2);
            this.mLastPosition = f2;
            return this.mBackwards ? this.mStartPosition - calcY : this.mStartPosition + calcY;
        }
        return invokeF.floatValue;
    }

    public float getVelocity(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            float f3 = this.mStage1Duration;
            if (f2 <= f3) {
                float f4 = this.mStage1Velocity;
                return f4 + (((this.mStage2Velocity - f4) * f2) / f3);
            }
            int i2 = this.mNumberOfStages;
            if (i2 == 1) {
                return 0.0f;
            }
            float f5 = f2 - f3;
            float f6 = this.mStage2Duration;
            if (f5 < f6) {
                float f7 = this.mStage2Velocity;
                return f7 + (((this.mStage3Velocity - f7) * f5) / f6);
            } else if (i2 == 2) {
                return this.mStage2EndPosition;
            } else {
                float f8 = f5 - f6;
                float f9 = this.mStage3Duration;
                if (f8 < f9) {
                    float f10 = this.mStage3Velocity;
                    return f10 - ((f8 * f10) / f9);
                }
                return this.mStage3EndPosition;
            }
        }
        return invokeF.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition) : invokeV.floatValue;
    }
}
