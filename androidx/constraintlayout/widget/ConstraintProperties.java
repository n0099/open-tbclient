package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes.dex */
public class ConstraintProperties {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstraintLayout.LayoutParams mParams;
    public View mView;

    private String sideToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            switch (i) {
                case 1:
                    return "left";
                case 2:
                    return "right";
                case 3:
                    return "top";
                case 4:
                    return "bottom";
                case 5:
                    return "baseline";
                case 6:
                    return "start";
                case 7:
                    return "end";
                default:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeI.objValue;
    }

    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public ConstraintProperties scaleY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f)) == null) ? this : (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view2;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            if (i == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            connect(1, i, i3, 0);
            if (i2 == 0) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            connect(2, i2, i4, 0);
            if (i != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(2, this.mView.getId(), 1, 0);
            }
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(1, this.mView.getId(), 2, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (i == 0) {
                i3 = 6;
            } else {
                i3 = 7;
            }
            connect(6, i, i3, 0);
            if (i2 == 0) {
                i4 = 7;
            } else {
                i4 = 6;
            }
            connect(7, i2, i4, 0);
            if (i != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(7, this.mView.getId(), 6, 0);
            }
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(6, this.mView.getId(), 7, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            if (i == 0) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            connect(3, i, i3, 0);
            if (i2 == 0) {
                i4 = 4;
            } else {
                i4 = 3;
            }
            connect(4, i2, i4, 0);
            if (i != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(4, this.mView.getId(), 3, 0);
            }
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(3, this.mView.getId(), 4, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
            switch (i) {
                case 1:
                    this.mParams.goneLeftMargin = i2;
                    break;
                case 2:
                    this.mParams.goneRightMargin = i2;
                    break;
                case 3:
                    this.mParams.goneTopMargin = i2;
                    break;
                case 4:
                    this.mParams.goneBottomMargin = i2;
                    break;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    this.mParams.goneStartMargin = i2;
                    break;
                case 7:
                    this.mParams.goneEndMargin = i2;
                    break;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties margin(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i, i2)) == null) {
            switch (i) {
                case 1:
                    ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i2;
                    break;
                case 2:
                    ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i2;
                    break;
                case 3:
                    ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i2;
                    break;
                case 4:
                    ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i2;
                    break;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    this.mParams.setMarginStart(i2);
                    break;
                case 7:
                    this.mParams.setMarginEnd(i2);
                    break;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties alpha(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
            this.mView.setAlpha(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties centerHorizontally(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i == 0) {
                center(0, 1, 0, 0, 2, 0, 0.5f);
            } else {
                center(i, 2, 0, i, 1, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i == 0) {
                center(0, 6, 0, 0, 7, 0, 0.5f);
            } else {
                center(i, 7, 0, i, 6, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties centerVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i == 0) {
                center(0, 3, 0, 0, 4, 0, 0.5f);
            } else {
                center(i, 4, 0, i, 3, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.mParams.matchConstraintDefaultHeight = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.mParams.matchConstraintDefaultWidth = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            ((ViewGroup.MarginLayoutParams) this.mParams).height = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.mParams.matchConstraintMaxHeight = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.mParams.matchConstraintMaxWidth = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.mParams.matchConstraintMinHeight = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.mParams.matchConstraintMinWidth = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            ((ViewGroup.MarginLayoutParams) this.mParams).width = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties dimensionRatio(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.mParams.dimensionRatio = str;
            return this;
        }
        return (ConstraintProperties) invokeL.objValue;
    }

    public ConstraintProperties elevation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mView.setElevation(f);
            }
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties horizontalBias(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f)) == null) {
            this.mParams.horizontalBias = f;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            this.mParams.horizontalChainStyle = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties horizontalWeight(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f)) == null) {
            this.mParams.horizontalWeight = f;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties rotation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            this.mView.setRotation(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties rotationX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f)) == null) {
            this.mView.setRotationX(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties rotationY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f)) == null) {
            this.mView.setRotationY(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties scaleX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f)) == null) {
            this.mView.setScaleY(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties transformPivotX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048613, this, f)) == null) {
            this.mView.setPivotX(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties transformPivotY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048614, this, f)) == null) {
            this.mView.setPivotY(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translationX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048616, this, f)) == null) {
            this.mView.setTranslationX(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translationY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048617, this, f)) == null) {
            this.mView.setTranslationY(f);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translationZ(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048618, this, f)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mView.setTranslationZ(f);
            }
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties verticalBias(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048619, this, f)) == null) {
            this.mParams.verticalBias = f;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            this.mParams.verticalChainStyle = i;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties verticalWeight(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048621, this, f)) == null) {
            this.mParams.verticalWeight = f;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties visibility(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            this.mView.setVisibility(i);
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f)})) == null) {
            if (i3 >= 0) {
                if (i6 >= 0) {
                    if (f > 0.0f && f <= 1.0f) {
                        if (i2 != 1 && i2 != 2) {
                            if (i2 != 6 && i2 != 7) {
                                connect(3, i, i2, i3);
                                connect(4, i4, i5, i6);
                                this.mParams.verticalBias = f;
                            } else {
                                connect(6, i, i2, i3);
                                connect(7, i4, i5, i6);
                                this.mParams.horizontalBias = f;
                            }
                        } else {
                            connect(1, i, i2, i3);
                            connect(2, i4, i5, i6);
                            this.mParams.horizontalBias = f;
                        }
                        return this;
                    }
                    throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
                }
                throw new IllegalArgumentException("margin must be > 0");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f)})) == null) {
            connect(1, i, i2, i3);
            connect(2, i4, i5, i6);
            this.mParams.horizontalBias = f;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f)})) == null) {
            connect(6, i, i2, i3);
            connect(7, i4, i5, i6);
            this.mParams.horizontalBias = f;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f)})) == null) {
            connect(3, i, i2, i3);
            connect(4, i4, i5, i6);
            this.mParams.verticalBias = f;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048588, this, i, i2, i3, i4)) == null) {
            switch (i) {
                case 1:
                    if (i3 == 1) {
                        ConstraintLayout.LayoutParams layoutParams = this.mParams;
                        layoutParams.leftToLeft = i2;
                        layoutParams.leftToRight = -1;
                    } else if (i3 == 2) {
                        ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                        layoutParams2.leftToRight = i2;
                        layoutParams2.leftToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + sideToString(i3) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i4;
                    break;
                case 2:
                    if (i3 == 1) {
                        ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                        layoutParams3.rightToLeft = i2;
                        layoutParams3.rightToRight = -1;
                    } else if (i3 == 2) {
                        ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                        layoutParams4.rightToRight = i2;
                        layoutParams4.rightToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i4;
                    break;
                case 3:
                    if (i3 == 3) {
                        ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                        layoutParams5.topToTop = i2;
                        layoutParams5.topToBottom = -1;
                        layoutParams5.baselineToBaseline = -1;
                    } else if (i3 == 4) {
                        ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                        layoutParams6.topToBottom = i2;
                        layoutParams6.topToTop = -1;
                        layoutParams6.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i4;
                    break;
                case 4:
                    if (i3 == 4) {
                        ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                        layoutParams7.bottomToBottom = i2;
                        layoutParams7.bottomToTop = -1;
                        layoutParams7.baselineToBaseline = -1;
                    } else if (i3 == 3) {
                        ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                        layoutParams8.bottomToTop = i2;
                        layoutParams8.bottomToBottom = -1;
                        layoutParams8.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i4;
                    break;
                case 5:
                    if (i3 == 5) {
                        ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                        layoutParams9.baselineToBaseline = i2;
                        layoutParams9.bottomToBottom = -1;
                        layoutParams9.bottomToTop = -1;
                        layoutParams9.topToTop = -1;
                        layoutParams9.topToBottom = -1;
                        break;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                case 6:
                    if (i3 == 6) {
                        ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                        layoutParams10.startToStart = i2;
                        layoutParams10.startToEnd = -1;
                    } else if (i3 == 7) {
                        ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                        layoutParams11.startToEnd = i2;
                        layoutParams11.startToStart = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.mParams.setMarginStart(i4);
                        break;
                    }
                    break;
                case 7:
                    if (i3 == 7) {
                        ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                        layoutParams12.endToEnd = i2;
                        layoutParams12.endToStart = -1;
                    } else if (i3 == 6) {
                        ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                        layoutParams13.endToStart = i2;
                        layoutParams13.endToEnd = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.mParams.setMarginEnd(i4);
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException(sideToString(i) + " to " + sideToString(i3) + " unknown");
            }
            return this;
        }
        return (ConstraintProperties) invokeIIII.objValue;
    }

    public ConstraintProperties removeConstraints(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            switch (i) {
                case 1:
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToRight = -1;
                    layoutParams.leftToLeft = -1;
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                    layoutParams.goneLeftMargin = -1;
                    break;
                case 2:
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.rightToRight = -1;
                    layoutParams2.rightToLeft = -1;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                    layoutParams2.goneRightMargin = -1;
                    break;
                case 3:
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.topToBottom = -1;
                    layoutParams3.topToTop = -1;
                    ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                    layoutParams3.goneTopMargin = -1;
                    break;
                case 4:
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.bottomToTop = -1;
                    layoutParams4.bottomToBottom = -1;
                    ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                    layoutParams4.goneBottomMargin = -1;
                    break;
                case 5:
                    this.mParams.baselineToBaseline = -1;
                    break;
                case 6:
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.startToEnd = -1;
                    layoutParams5.startToStart = -1;
                    layoutParams5.setMarginStart(-1);
                    this.mParams.goneStartMargin = -1;
                    break;
                case 7:
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.endToStart = -1;
                    layoutParams6.endToEnd = -1;
                    layoutParams6.setMarginEnd(-1);
                    this.mParams.goneEndMargin = -1;
                    break;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ConstraintLayout.LayoutParams layoutParams = this.mParams;
            int i = layoutParams.leftToRight;
            int i2 = layoutParams.rightToLeft;
            if (i == -1 && i2 == -1) {
                int i3 = layoutParams.startToEnd;
                int i4 = layoutParams.endToStart;
                if (i3 != -1 || i4 != -1) {
                    ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
                    ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4));
                    if (i3 != -1 && i4 != -1) {
                        constraintProperties.connect(7, i4, 6, 0);
                        constraintProperties2.connect(6, i, 7, 0);
                    } else if (i != -1 || i4 != -1) {
                        ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                        int i5 = layoutParams2.rightToRight;
                        if (i5 != -1) {
                            constraintProperties.connect(7, i5, 7, 0);
                        } else {
                            int i6 = layoutParams2.leftToLeft;
                            if (i6 != -1) {
                                constraintProperties2.connect(6, i6, 6, 0);
                            }
                        }
                    }
                }
                removeConstraints(6);
                removeConstraints(7);
            } else {
                ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
                ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
                if (i != -1 && i2 != -1) {
                    constraintProperties3.connect(2, i2, 1, 0);
                    constraintProperties4.connect(1, i, 2, 0);
                } else if (i != -1 || i2 != -1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    int i7 = layoutParams3.rightToRight;
                    if (i7 != -1) {
                        constraintProperties3.connect(2, i7, 2, 0);
                    } else {
                        int i8 = layoutParams3.leftToLeft;
                        if (i8 != -1) {
                            constraintProperties4.connect(1, i8, 1, 0);
                        }
                    }
                }
                removeConstraints(1);
                removeConstraints(2);
            }
            return this;
        }
        return (ConstraintProperties) invokeV.objValue;
    }

    public ConstraintProperties removeFromVerticalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ConstraintLayout.LayoutParams layoutParams = this.mParams;
            int i = layoutParams.topToBottom;
            int i2 = layoutParams.bottomToTop;
            if (i != -1 || i2 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
                if (i != -1 && i2 != -1) {
                    constraintProperties.connect(4, i2, 3, 0);
                    constraintProperties2.connect(3, i, 4, 0);
                } else if (i != -1 || i2 != -1) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    int i3 = layoutParams2.bottomToBottom;
                    if (i3 != -1) {
                        constraintProperties.connect(4, i3, 4, 0);
                    } else {
                        int i4 = layoutParams2.topToTop;
                        if (i4 != -1) {
                            constraintProperties2.connect(3, i4, 3, 0);
                        }
                    }
                }
            }
            removeConstraints(3);
            removeConstraints(4);
            return this;
        }
        return (ConstraintProperties) invokeV.objValue;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.mView.setPivotX(f);
            this.mView.setPivotY(f2);
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties translation(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.mView.setTranslationX(f);
            this.mView.setTranslationY(f2);
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }
}
