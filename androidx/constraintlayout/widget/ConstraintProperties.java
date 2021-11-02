package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
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

    public ConstraintProperties(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            switch (i2) {
                case 1:
                    return "left";
                case 2:
                    return HorizontalTranslateLayout.RIGHT;
                case 3:
                    return VerticalTranslateLayout.TOP;
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

    public ConstraintProperties addToHorizontalChain(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            connect(1, i2, i2 == 0 ? 1 : 2, 0);
            connect(2, i3, i3 == 0 ? 2 : 1, 0);
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(2, this.mView.getId(), 1, 0);
            }
            if (i3 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(1, this.mView.getId(), 2, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            connect(6, i2, i2 == 0 ? 6 : 7, 0);
            connect(7, i3, i3 == 0 ? 7 : 6, 0);
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(7, this.mView.getId(), 6, 0);
            }
            if (i3 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(6, this.mView.getId(), 7, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties addToVerticalChain(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            connect(3, i2, i2 == 0 ? 3 : 4, 0);
            connect(4, i3, i3 == 0 ? 4 : 3, 0);
            if (i2 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2)).connect(4, this.mView.getId(), 3, 0);
            }
            if (i3 != 0) {
                new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(3, this.mView.getId(), 4, 0);
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties alpha(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            this.mView.setAlpha(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public void apply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public ConstraintProperties center(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f2)})) == null) {
            if (i4 >= 0) {
                if (i7 >= 0) {
                    if (f2 <= 0.0f || f2 > 1.0f) {
                        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
                    }
                    if (i3 == 1 || i3 == 2) {
                        connect(1, i2, i3, i4);
                        connect(2, i5, i6, i7);
                        this.mParams.horizontalBias = f2;
                    } else if (i3 != 6 && i3 != 7) {
                        connect(3, i2, i3, i4);
                        connect(4, i5, i6, i7);
                        this.mParams.verticalBias = f2;
                    } else {
                        connect(6, i2, i3, i4);
                        connect(7, i5, i6, i7);
                        this.mParams.horizontalBias = f2;
                    }
                    return this;
                }
                throw new IllegalArgumentException("margin must be > 0");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerHorizontally(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f2)})) == null) {
            connect(1, i2, i3, i4);
            connect(2, i5, i6, i7);
            this.mParams.horizontalBias = f2;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerHorizontallyRtl(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f2)})) == null) {
            connect(6, i2, i3, i4);
            connect(7, i5, i6, i7);
            this.mParams.horizontalBias = f2;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties centerVertically(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f2)})) == null) {
            connect(3, i2, i3, i4);
            connect(4, i5, i6, i7);
            this.mParams.verticalBias = f2;
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties connect(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048588, this, i2, i3, i4, i5)) == null) {
            switch (i2) {
                case 1:
                    if (i4 == 1) {
                        ConstraintLayout.LayoutParams layoutParams = this.mParams;
                        layoutParams.leftToLeft = i3;
                        layoutParams.leftToRight = -1;
                    } else if (i4 == 2) {
                        ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                        layoutParams2.leftToRight = i3;
                        layoutParams2.leftToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + sideToString(i4) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i5;
                    break;
                case 2:
                    if (i4 == 1) {
                        ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                        layoutParams3.rightToLeft = i3;
                        layoutParams3.rightToRight = -1;
                    } else if (i4 == 2) {
                        ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                        layoutParams4.rightToRight = i3;
                        layoutParams4.rightToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i5;
                    break;
                case 3:
                    if (i4 == 3) {
                        ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                        layoutParams5.topToTop = i3;
                        layoutParams5.topToBottom = -1;
                        layoutParams5.baselineToBaseline = -1;
                    } else if (i4 == 4) {
                        ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                        layoutParams6.topToBottom = i3;
                        layoutParams6.topToTop = -1;
                        layoutParams6.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i5;
                    break;
                case 4:
                    if (i4 == 4) {
                        ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                        layoutParams7.bottomToBottom = i3;
                        layoutParams7.bottomToTop = -1;
                        layoutParams7.baselineToBaseline = -1;
                    } else if (i4 == 3) {
                        ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                        layoutParams8.bottomToTop = i3;
                        layoutParams8.bottomToBottom = -1;
                        layoutParams8.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i5;
                    break;
                case 5:
                    if (i4 == 5) {
                        ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                        layoutParams9.baselineToBaseline = i3;
                        layoutParams9.bottomToBottom = -1;
                        layoutParams9.bottomToTop = -1;
                        layoutParams9.topToTop = -1;
                        layoutParams9.topToBottom = -1;
                        break;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                case 6:
                    if (i4 == 6) {
                        ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                        layoutParams10.startToStart = i3;
                        layoutParams10.startToEnd = -1;
                    } else if (i4 == 7) {
                        ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                        layoutParams11.startToEnd = i3;
                        layoutParams11.startToStart = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.mParams.setMarginStart(i5);
                        break;
                    }
                    break;
                case 7:
                    if (i4 == 7) {
                        ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                        layoutParams12.endToEnd = i3;
                        layoutParams12.endToStart = -1;
                    } else if (i4 == 6) {
                        ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                        layoutParams13.endToStart = i3;
                        layoutParams13.endToEnd = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.mParams.setMarginEnd(i5);
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
            }
            return this;
        }
        return (ConstraintProperties) invokeIIII.objValue;
    }

    public ConstraintProperties constrainDefaultHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.mParams.matchConstraintDefaultHeight = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainDefaultWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.mParams.matchConstraintDefaultWidth = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            ((ViewGroup.MarginLayoutParams) this.mParams).height = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMaxHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.mParams.matchConstraintMaxHeight = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMaxWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.mParams.matchConstraintMaxWidth = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMinHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.mParams.matchConstraintMinHeight = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainMinWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.mParams.matchConstraintMinWidth = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties constrainWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            ((ViewGroup.MarginLayoutParams) this.mParams).width = i2;
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

    public ConstraintProperties elevation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mView.setElevation(f2);
            }
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties goneMargin(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i2, i3)) == null) {
            switch (i2) {
                case 1:
                    this.mParams.goneLeftMargin = i3;
                    break;
                case 2:
                    this.mParams.goneRightMargin = i3;
                    break;
                case 3:
                    this.mParams.goneTopMargin = i3;
                    break;
                case 4:
                    this.mParams.goneBottomMargin = i3;
                    break;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    this.mParams.goneStartMargin = i3;
                    break;
                case 7:
                    this.mParams.goneEndMargin = i3;
                    break;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties horizontalBias(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f2)) == null) {
            this.mParams.horizontalBias = f2;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties horizontalChainStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.mParams.horizontalChainStyle = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties horizontalWeight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f2)) == null) {
            this.mParams.horizontalWeight = f2;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties margin(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i2, i3)) == null) {
            switch (i2) {
                case 1:
                    ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i3;
                    break;
                case 2:
                    ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i3;
                    break;
                case 3:
                    ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i3;
                    break;
                case 4:
                    ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i3;
                    break;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    this.mParams.setMarginStart(i3);
                    break;
                case 7:
                    this.mParams.setMarginEnd(i3);
                    break;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
            return this;
        }
        return (ConstraintProperties) invokeII.objValue;
    }

    public ConstraintProperties removeConstraints(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            switch (i2) {
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
            int i2 = layoutParams.leftToRight;
            int i3 = layoutParams.rightToLeft;
            if (i2 == -1 && i3 == -1) {
                int i4 = layoutParams.startToEnd;
                int i5 = layoutParams.endToStart;
                if (i4 != -1 || i5 != -1) {
                    ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4));
                    ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5));
                    if (i4 != -1 && i5 != -1) {
                        constraintProperties.connect(7, i5, 6, 0);
                        constraintProperties2.connect(6, i2, 7, 0);
                    } else if (i2 != -1 || i5 != -1) {
                        ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                        int i6 = layoutParams2.rightToRight;
                        if (i6 != -1) {
                            constraintProperties.connect(7, i6, 7, 0);
                        } else {
                            int i7 = layoutParams2.leftToLeft;
                            if (i7 != -1) {
                                constraintProperties2.connect(6, i7, 6, 0);
                            }
                        }
                    }
                }
                removeConstraints(6);
                removeConstraints(7);
            } else {
                ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
                ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
                if (i2 != -1 && i3 != -1) {
                    constraintProperties3.connect(2, i3, 1, 0);
                    constraintProperties4.connect(1, i2, 2, 0);
                } else if (i2 != -1 || i3 != -1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    int i8 = layoutParams3.rightToRight;
                    if (i8 != -1) {
                        constraintProperties3.connect(2, i8, 2, 0);
                    } else {
                        int i9 = layoutParams3.leftToLeft;
                        if (i9 != -1) {
                            constraintProperties4.connect(1, i9, 1, 0);
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
            int i2 = layoutParams.topToBottom;
            int i3 = layoutParams.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i2));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
                if (i2 != -1 && i3 != -1) {
                    constraintProperties.connect(4, i3, 3, 0);
                    constraintProperties2.connect(3, i2, 4, 0);
                } else if (i2 != -1 || i3 != -1) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    int i4 = layoutParams2.bottomToBottom;
                    if (i4 != -1) {
                        constraintProperties.connect(4, i4, 4, 0);
                    } else {
                        int i5 = layoutParams2.topToTop;
                        if (i5 != -1) {
                            constraintProperties2.connect(3, i5, 3, 0);
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

    public ConstraintProperties rotation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            this.mView.setRotation(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties rotationX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f2)) == null) {
            this.mView.setRotationX(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties rotationY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f2)) == null) {
            this.mView.setRotationY(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties scaleX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f2)) == null) {
            this.mView.setScaleY(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties scaleY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) ? this : (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties transformPivot(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.mView.setPivotX(f2);
            this.mView.setPivotY(f3);
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties transformPivotX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048613, this, f2)) == null) {
            this.mView.setPivotX(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties transformPivotY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048614, this, f2)) == null) {
            this.mView.setPivotY(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translation(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.mView.setTranslationX(f2);
            this.mView.setTranslationY(f3);
            return this;
        }
        return (ConstraintProperties) invokeCommon.objValue;
    }

    public ConstraintProperties translationX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048616, this, f2)) == null) {
            this.mView.setTranslationX(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translationY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048617, this, f2)) == null) {
            this.mView.setTranslationY(f2);
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties translationZ(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048618, this, f2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mView.setTranslationZ(f2);
            }
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties verticalBias(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048619, this, f2)) == null) {
            this.mParams.verticalBias = f2;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties verticalChainStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            this.mParams.verticalChainStyle = i2;
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties verticalWeight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048621, this, f2)) == null) {
            this.mParams.verticalWeight = f2;
            return this;
        }
        return (ConstraintProperties) invokeF.objValue;
    }

    public ConstraintProperties visibility(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            this.mView.setVisibility(i2);
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties centerHorizontally(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 0) {
                center(0, 1, 0, 0, 2, 0, 0.5f);
            } else {
                center(i2, 2, 0, i2, 1, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties centerHorizontallyRtl(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 == 0) {
                center(0, 6, 0, 0, 7, 0, 0.5f);
            } else {
                center(i2, 7, 0, i2, 6, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }

    public ConstraintProperties centerVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 == 0) {
                center(0, 3, 0, 0, 4, 0, 0.5f);
            } else {
                center(i2, 4, 0, i2, 3, 0, 0.5f);
            }
            return this;
        }
        return (ConstraintProperties) invokeI.objValue;
    }
}
