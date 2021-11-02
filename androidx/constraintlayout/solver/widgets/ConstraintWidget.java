package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ConstraintWidget {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    public static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int DIMENSION_HORIZONTAL = 0;
    public static final int DIMENSION_VERTICAL = 1;
    public static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    public static final int WRAP = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean OPTIMIZE_WRAP;
    public boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    public boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    public ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public ConstraintAnchor mBottom;
    public boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    public ConstraintAnchor mCenterX;
    public ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    public Object mCompanionWidget;
    public int mContainerItemSkip;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mDistToBottom;
    public int mDistToLeft;
    public int mDistToRight;
    public int mDistToTop;
    public boolean mGroupsToSolver;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public boolean mHorizontalChainFixedPosition;
    public int mHorizontalChainStyle;
    public ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public boolean mHorizontalWrapVisited;
    public boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    public boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public int mLastHorizontalMeasureSpec;
    public int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    public boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    public int[] mMaxDimension;
    public boolean mMeasureRequested;
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public int mOffsetX;
    public int mOffsetY;
    public ConstraintWidget mParent;
    public int mRelX;
    public int mRelY;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
    public boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    public boolean mTopHasCentered;
    public String mType;
    public float mVerticalBiasPercent;
    public boolean mVerticalChainFixedPosition;
    public int mVerticalChainStyle;
    public ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public boolean mVerticalWrapVisited;
    public int mVisibility;
    public float[] mWeight;
    public int mWidth;
    public int mX;
    public int mY;
    public boolean measured;
    public boolean resolvedHorizontal;
    public boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1701419361, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1701419361, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$1;");
                    return;
                }
            }
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class DimensionBehaviour {
        public static final /* synthetic */ DimensionBehaviour[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DimensionBehaviour FIXED;
        public static final DimensionBehaviour MATCH_CONSTRAINT;
        public static final DimensionBehaviour MATCH_PARENT;
        public static final DimensionBehaviour WRAP_CONTENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(109674799, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(109674799, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;");
                    return;
                }
            }
            FIXED = new DimensionBehaviour("FIXED", 0);
            WRAP_CONTENT = new DimensionBehaviour("WRAP_CONTENT", 1);
            MATCH_CONSTRAINT = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            DimensionBehaviour dimensionBehaviour = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = dimensionBehaviour;
            $VALUES = new DimensionBehaviour[]{FIXED, WRAP_CONTENT, MATCH_CONSTRAINT, dimensionBehaviour};
        }

        public DimensionBehaviour(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DimensionBehaviour valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, str) : (DimensionBehaviour) invokeL.objValue;
        }

        public static DimensionBehaviour[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DimensionBehaviour[]) $VALUES.clone() : (DimensionBehaviour[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1848506828, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1848506828, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget;");
        }
    }

    public ConstraintWidget() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mAnchors.add(this.mLeft);
            this.mAnchors.add(this.mTop);
            this.mAnchors.add(this.mRight);
            this.mAnchors.add(this.mBottom);
            this.mAnchors.add(this.mCenterX);
            this.mAnchors.add(this.mCenterY);
            this.mAnchors.add(this.mCenter);
            this.mAnchors.add(this.mBaseline);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:244:0x0437, code lost:
        if ((r2 instanceof androidx.constraintlayout.solver.widgets.Barrier) != false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x055c, code lost:
        if (r1[1] == r2) goto L289;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x052c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:363:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3, int i4, int i5, float f2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f3, boolean z11) {
        int i10;
        boolean z12;
        int i11;
        SolverVariable solverVariable3;
        int i12;
        int i13;
        int i14;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        boolean z13;
        int i15;
        boolean z14;
        SolverVariable createObjectVariable;
        SolverVariable createObjectVariable2;
        ConstraintAnchor constraintAnchor3;
        int i16;
        SolverVariable solverVariable7;
        boolean z15;
        boolean z16;
        SolverVariable solverVariable8;
        int i17;
        boolean z17;
        int i18;
        int i19;
        int i20;
        boolean z18;
        SolverVariable solverVariable9;
        int i21;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable10;
        int i22;
        boolean z19;
        boolean z20;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable11;
        int i23;
        int i24;
        ConstraintWidget constraintWidget4;
        int i25;
        boolean z21;
        int i26;
        int i27;
        boolean z22;
        boolean z23;
        boolean z24;
        int i28;
        int i29;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable12;
        int i30;
        ConstraintWidget constraintWidget6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65544, this, new Object[]{linearSystem, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), solverVariable, solverVariable2, dimensionBehaviour, Boolean.valueOf(z5), constraintAnchor, constraintAnchor2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Float.valueOf(f3), Boolean.valueOf(z11)}) != null) {
            return;
        }
        int i31 = i8;
        int i32 = i9;
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i33 = isConnected ? 1 : 0;
        if (isConnected2) {
            i33++;
        }
        if (isConnected3) {
            i33++;
        }
        int i34 = i33;
        int i35 = z6 ? 3 : i6;
        int i36 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i36 == 1 || i36 == 2 || i36 == 3 || i36 != 4) {
            i10 = i35;
        } else {
            i10 = i35;
            if (i10 != 4) {
                z12 = true;
                if (this.mVisibility != 8) {
                    i11 = 0;
                    z12 = false;
                } else {
                    i11 = i3;
                }
                if (z11) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable3, i2);
                    } else if (isConnected && !isConnected2) {
                        solverVariable3 = createObjectVariable6;
                        linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 8);
                        if (z12) {
                            i12 = i34;
                            if (i12 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                                if (i31 == -2) {
                                    i31 = i11;
                                }
                                int i37 = i32 == -2 ? i11 : i32;
                                if (i11 > 0 && i10 != 1) {
                                    i11 = 0;
                                }
                                if (i31 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i31, 8);
                                    i11 = Math.max(i11, i31);
                                }
                                if (i37 > 0) {
                                    if ((z2 && i10 == 1) ? false : true) {
                                        i13 = 8;
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i37, 8);
                                    } else {
                                        i13 = 8;
                                    }
                                    i11 = Math.min(i11, i37);
                                } else {
                                    i13 = 8;
                                }
                                if (i10 == 1) {
                                    if (z2) {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i11, i13);
                                    } else if (z8) {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i11, 5);
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i11, i13);
                                    } else {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i11, 5);
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i11, i13);
                                    }
                                    z14 = z4;
                                    i32 = i37;
                                    i14 = i10;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    solverVariable6 = solverVariable3;
                                } else if (i10 == 2) {
                                    if (constraintAnchor.getType() != ConstraintAnchor.Type.TOP && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                                    } else {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                                    }
                                    i14 = i10;
                                    solverVariable6 = solverVariable3;
                                    int i38 = i37;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, f3));
                                    i32 = i38;
                                    i15 = i31;
                                    z13 = false;
                                    z14 = z4;
                                } else {
                                    int i39 = i37;
                                    i14 = i10;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    solverVariable6 = solverVariable3;
                                    i32 = i39;
                                    z13 = z12;
                                    i15 = i31;
                                    z14 = true;
                                }
                            } else {
                                int max = Math.max(i31, i11);
                                if (i32 > 0) {
                                    max = Math.min(i32, max);
                                }
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 8);
                                z14 = z4;
                                i15 = i31;
                                i14 = i10;
                                solverVariable4 = createObjectVariable5;
                                solverVariable5 = createObjectVariable4;
                                solverVariable6 = solverVariable3;
                                z13 = false;
                            }
                            if (z11 || z8) {
                                boolean z25 = true;
                                if (i12 >= 2 && z2 && z14) {
                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 8);
                                    boolean z26 = z || this.mBaseline.mTarget == null;
                                    if (z || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                                        z25 = z26;
                                    } else {
                                        ConstraintWidget constraintWidget7 = constraintAnchor3.mOwner;
                                        if (constraintWidget7.mDimensionRatio != 0.0f) {
                                            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget7.mListDimensionBehaviors;
                                            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                                            DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                            if (dimensionBehaviour2 == dimensionBehaviour3) {
                                            }
                                        }
                                        z25 = false;
                                    }
                                    if (z25) {
                                        linearSystem.addGreaterThan(solverVariable2, solverVariable5, 0, 8);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if ((isConnected || isConnected2 || isConnected3) && (!isConnected || isConnected2)) {
                                if (!isConnected && isConnected2) {
                                    linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                    if (z2) {
                                        if (this.OPTIMIZE_WRAP && createObjectVariable3.isFinalValue && (constraintWidget5 = this.mParent) != null) {
                                            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                                            if (z) {
                                                constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                            } else {
                                                constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                            }
                                        } else {
                                            linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 5);
                                        }
                                    }
                                } else if (isConnected && isConnected2) {
                                    ConstraintWidget constraintWidget8 = constraintAnchor.mTarget.mOwner;
                                    ConstraintWidget constraintWidget9 = constraintAnchor2.mTarget.mOwner;
                                    ConstraintWidget parent = getParent();
                                    int i40 = 6;
                                    if (!z13) {
                                        i16 = i14;
                                        if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                            linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f2, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), 8);
                                            if (z2 && z14) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i17 = constraintAnchor2.getMargin();
                                                    solverVariable8 = solverVariable2;
                                                } else {
                                                    solverVariable8 = solverVariable2;
                                                    i17 = 0;
                                                }
                                                if (solverVariable6 != solverVariable8) {
                                                    linearSystem.addGreaterThan(solverVariable8, solverVariable5, i17, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        solverVariable7 = solverVariable2;
                                        z15 = true;
                                        z16 = true;
                                    } else {
                                        i16 = i14;
                                        if (i16 == 0) {
                                            if (i32 != 0 || i15 != 0) {
                                                z22 = true;
                                                z23 = false;
                                                z24 = true;
                                                i28 = 5;
                                                i29 = 5;
                                            } else if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                linearSystem.addEquality(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), 8);
                                                linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                return;
                                            } else {
                                                z22 = false;
                                                z23 = true;
                                                z24 = false;
                                                i28 = 8;
                                                i29 = 8;
                                            }
                                            if ((constraintWidget8 instanceof Barrier) || (constraintWidget9 instanceof Barrier)) {
                                                solverVariable7 = solverVariable2;
                                                z15 = z24;
                                                i18 = i28;
                                                i19 = 6;
                                                i20 = 4;
                                                z16 = z22;
                                                z17 = z23;
                                            } else {
                                                solverVariable7 = solverVariable2;
                                                z15 = z24;
                                                i20 = i29;
                                                i19 = 6;
                                                z16 = z22;
                                                i18 = i28;
                                                z17 = z23;
                                            }
                                        } else {
                                            if (i16 == 1) {
                                                solverVariable7 = solverVariable2;
                                                z15 = true;
                                                z16 = true;
                                                z17 = false;
                                                i18 = 8;
                                            } else if (i16 == 3) {
                                                if (this.mResolvedDimensionRatioSide == -1) {
                                                    if (z9) {
                                                        solverVariable7 = solverVariable2;
                                                        z15 = true;
                                                        z16 = true;
                                                        z17 = true;
                                                        i18 = 8;
                                                        i19 = z2 ? 5 : 4;
                                                    } else {
                                                        solverVariable7 = solverVariable2;
                                                        z15 = true;
                                                        z16 = true;
                                                        z17 = true;
                                                        i18 = 8;
                                                        i19 = 8;
                                                    }
                                                } else if (z6) {
                                                    if (i7 != 2 && i7 != 1) {
                                                        z21 = false;
                                                        if (z21) {
                                                            i26 = 8;
                                                            i27 = 5;
                                                        } else {
                                                            i26 = 5;
                                                            i27 = 4;
                                                        }
                                                        i18 = i26;
                                                        i20 = i27;
                                                        z15 = true;
                                                        z16 = true;
                                                        z17 = true;
                                                        i19 = 6;
                                                        solverVariable7 = solverVariable2;
                                                    }
                                                    z21 = true;
                                                    if (z21) {
                                                    }
                                                    i18 = i26;
                                                    i20 = i27;
                                                    z15 = true;
                                                    z16 = true;
                                                    z17 = true;
                                                    i19 = 6;
                                                    solverVariable7 = solverVariable2;
                                                } else if (i32 > 0) {
                                                    solverVariable7 = solverVariable2;
                                                    z15 = true;
                                                    z16 = true;
                                                    z17 = true;
                                                    i18 = 5;
                                                    i19 = 6;
                                                } else if (i32 != 0 || i15 != 0) {
                                                    solverVariable7 = solverVariable2;
                                                    z15 = true;
                                                    z16 = true;
                                                    z17 = true;
                                                    i18 = 5;
                                                } else if (z9) {
                                                    solverVariable7 = solverVariable2;
                                                    i18 = (constraintWidget8 == parent || constraintWidget9 == parent) ? 5 : 4;
                                                    z15 = true;
                                                    z16 = true;
                                                    z17 = true;
                                                } else {
                                                    solverVariable7 = solverVariable2;
                                                    z15 = true;
                                                    z16 = true;
                                                    z17 = true;
                                                    i18 = 5;
                                                    i19 = 6;
                                                    i20 = 8;
                                                }
                                                i20 = 5;
                                            } else {
                                                solverVariable7 = solverVariable2;
                                                z15 = false;
                                                z16 = false;
                                            }
                                            i19 = 6;
                                            i20 = 4;
                                        }
                                        if (z15 || solverVariable4 != solverVariable6 || constraintWidget8 == parent) {
                                            z18 = true;
                                        } else {
                                            z15 = false;
                                            z18 = false;
                                        }
                                        if (z16) {
                                            solverVariable9 = solverVariable4;
                                            i21 = i16;
                                            constraintWidget = parent;
                                            constraintWidget2 = constraintWidget9;
                                            solverVariable10 = createObjectVariable3;
                                            i22 = 8;
                                            z19 = z2;
                                        } else {
                                            if (z13 || z7 || z9 || solverVariable4 != solverVariable || solverVariable6 != solverVariable7) {
                                                z19 = z2;
                                            } else {
                                                z19 = false;
                                                i18 = 8;
                                                i19 = 8;
                                                z18 = false;
                                            }
                                            solverVariable9 = solverVariable4;
                                            i22 = 8;
                                            i21 = i16;
                                            constraintWidget = parent;
                                            constraintWidget2 = constraintWidget9;
                                            solverVariable10 = createObjectVariable3;
                                            linearSystem.addCentering(createObjectVariable3, solverVariable9, constraintAnchor.getMargin(), f2, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), i19);
                                        }
                                        z20 = z18;
                                        if (this.mVisibility == i22 || constraintAnchor2.hasDependents()) {
                                            SolverVariable solverVariable13 = solverVariable9;
                                            if (z15) {
                                                constraintWidget3 = constraintWidget2;
                                                solverVariable11 = solverVariable10;
                                            } else {
                                                if (!z19 || solverVariable13 == solverVariable6 || z13) {
                                                    constraintWidget3 = constraintWidget2;
                                                } else {
                                                    if (constraintWidget8 instanceof Barrier) {
                                                        constraintWidget3 = constraintWidget2;
                                                    } else {
                                                        constraintWidget3 = constraintWidget2;
                                                    }
                                                    i25 = 6;
                                                    solverVariable11 = solverVariable10;
                                                    linearSystem.addGreaterThan(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i25);
                                                    linearSystem.addLowerThan(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i25);
                                                    i18 = i25;
                                                }
                                                i25 = i18;
                                                solverVariable11 = solverVariable10;
                                                linearSystem.addGreaterThan(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i25);
                                                linearSystem.addLowerThan(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i25);
                                                i18 = i25;
                                            }
                                            if (z19 || !z10 || (constraintWidget8 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                i23 = i18;
                                                i24 = i20;
                                            } else {
                                                i23 = 6;
                                                i24 = 6;
                                                z20 = true;
                                            }
                                            if (z20) {
                                                if (!z17 || (z9 && !z3)) {
                                                    constraintWidget4 = constraintWidget;
                                                } else {
                                                    constraintWidget4 = constraintWidget;
                                                    if (constraintWidget8 != constraintWidget4 && constraintWidget3 != constraintWidget4) {
                                                        i40 = i24;
                                                    }
                                                    i40 = ((constraintWidget8 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) ? 5 : 5;
                                                    i24 = Math.max(z9 ? 5 : ((constraintWidget8 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) ? 5 : 5, i24);
                                                }
                                                if (z19) {
                                                    i24 = (z6 && !z9 && (constraintWidget8 == constraintWidget4 || constraintWidget3 == constraintWidget4)) ? 4 : Math.min(i23, i24);
                                                }
                                                linearSystem.addEquality(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i24);
                                                linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i24);
                                            }
                                            if (z19) {
                                                int margin = solverVariable == solverVariable13 ? constraintAnchor.getMargin() : 0;
                                                if (solverVariable13 != solverVariable) {
                                                    linearSystem.addGreaterThan(solverVariable11, solverVariable, margin, 5);
                                                }
                                            }
                                            if (z19 && z13 && i4 == 0 && i15 == 0) {
                                                if (!z13 && i21 == 3) {
                                                    linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, i22);
                                                } else {
                                                    linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, 5);
                                                }
                                            }
                                            if (z19 && z14) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i30 = constraintAnchor2.getMargin();
                                                    solverVariable12 = solverVariable2;
                                                } else {
                                                    solverVariable12 = solverVariable2;
                                                    i30 = 0;
                                                }
                                                if (solverVariable6 != solverVariable12) {
                                                    if (this.OPTIMIZE_WRAP && solverVariable5.isFinalValue && (constraintWidget6 = this.mParent) != null) {
                                                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget6;
                                                        if (z) {
                                                            constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                                                            return;
                                                        } else {
                                                            constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                                                            return;
                                                        }
                                                    }
                                                    linearSystem.addGreaterThan(solverVariable12, solverVariable5, i30, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    z17 = false;
                                    i18 = 5;
                                    i19 = 6;
                                    i20 = 4;
                                    if (z15) {
                                    }
                                    z18 = true;
                                    if (z16) {
                                    }
                                    z20 = z18;
                                    if (this.mVisibility == i22) {
                                    }
                                    SolverVariable solverVariable132 = solverVariable9;
                                    if (z15) {
                                    }
                                    if (z19) {
                                    }
                                    i23 = i18;
                                    i24 = i20;
                                    if (z20) {
                                    }
                                    if (z19) {
                                    }
                                    if (z19) {
                                        if (!z13) {
                                        }
                                        linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, 5);
                                    }
                                    if (z19) {
                                        return;
                                    }
                                    return;
                                }
                            }
                            z19 = z2;
                            if (z19) {
                            }
                        } else {
                            if (z5) {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
                                if (i4 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i4, 8);
                                }
                                if (i5 < Integer.MAX_VALUE) {
                                    linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i5, 8);
                                }
                            } else {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i11, 8);
                            }
                            i14 = i10;
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                            i12 = i34;
                            solverVariable6 = solverVariable3;
                            z14 = z4;
                        }
                        z13 = z12;
                        i15 = i31;
                        if (z11) {
                        }
                        boolean z252 = true;
                        if (i12 >= 2) {
                            return;
                        }
                        return;
                    }
                }
                solverVariable3 = createObjectVariable6;
                if (z12) {
                }
                z13 = z12;
                i15 = i31;
                if (z11) {
                }
                boolean z2522 = true;
                if (i12 >= 2) {
                }
            }
        }
        z12 = false;
        if (this.mVisibility != 8) {
        }
        if (z11) {
        }
        solverVariable3 = createObjectVariable6;
        if (z12) {
        }
        z13 = z12;
        i15 = i31;
        if (z11) {
        }
        boolean z25222 = true;
        if (i12 >= 2) {
        }
    }

    private boolean isChainHead(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            int i3 = i2 * 2;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget != constraintAnchorArr[i3]) {
                int i4 = i3 + 1;
                if (constraintAnchorArr[i4].mTarget != null && constraintAnchorArr[i4].mTarget.mTarget == constraintAnchorArr[i4]) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{constraintWidgetContainer, linearSystem, hashSet, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (!hashSet.contains(this)) {
                    return;
                }
                Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            }
            if (i2 == 0) {
                HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
                if (dependents != null) {
                    Iterator<ConstraintAnchor> it = dependents.iterator();
                    while (it.hasNext()) {
                        it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                    }
                }
                HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
                if (dependents2 != null) {
                    Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                    while (it2.hasNext()) {
                        it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                    }
                    return;
                }
                return;
            }
            HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
            if (dependents3 != null) {
                Iterator<ConstraintAnchor> it3 = dependents3.iterator();
                while (it3.hasNext()) {
                    it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
            if (dependents4 != null) {
                Iterator<ConstraintAnchor> it4 = dependents4.iterator();
                while (it4.hasNext()) {
                    it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
            if (dependents5 != null) {
                Iterator<ConstraintAnchor> it5 = dependents5.iterator();
                while (it5.hasNext()) {
                    it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
        }
    }

    public boolean addFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this instanceof VirtualLayout) || (this instanceof Guideline) : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:208:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z6;
        int i6;
        boolean z7;
        boolean z8;
        int i7;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i8;
        int i9;
        char c2;
        ConstraintWidget constraintWidget3;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        boolean z14;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget4;
        boolean z15;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode;
        int i10;
        int i11;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, linearSystem, z) == null) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            ConstraintWidget constraintWidget5 = this.mParent;
            if (constraintWidget5 != null) {
                boolean z16 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget constraintWidget6 = this.mParent;
                z2 = z16;
                z3 = constraintWidget6 != null && constraintWidget6.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            } else {
                z2 = false;
                z3 = false;
            }
            if (this.mVisibility == 8 && !hasDependencies()) {
                boolean[] zArr = this.mIsInBarrier;
                if (!zArr[0] && !zArr[1]) {
                    return;
                }
            }
            if (this.resolvedHorizontal || this.resolvedVertical) {
                if (this.resolvedHorizontal) {
                    linearSystem.addEquality(createObjectVariable, this.mX);
                    linearSystem.addEquality(createObjectVariable2, this.mX + this.mWidth);
                    if (z2 && (constraintWidget2 = this.mParent) != null) {
                        if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                            constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                            constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                        } else {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), createObjectVariable2, 0, 5);
                        }
                    }
                }
                if (this.resolvedVertical) {
                    linearSystem.addEquality(createObjectVariable3, this.mY);
                    linearSystem.addEquality(createObjectVariable4, this.mY + this.mHeight);
                    if (this.mBaseline.hasDependents()) {
                        linearSystem.addEquality(createObjectVariable5, this.mY + this.mBaselineDistance);
                    }
                    if (z3 && (constraintWidget = this.mParent) != null) {
                        if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                            ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                            constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                            constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                        } else {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), createObjectVariable4, 0, 5);
                        }
                    }
                }
                if (this.resolvedHorizontal && this.resolvedVertical) {
                    this.resolvedHorizontal = false;
                    this.resolvedVertical = false;
                    return;
                }
            }
            Metrics metrics = LinearSystem.sMetrics;
            if (metrics != null) {
                metrics.widgets++;
            }
            if (z && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun = this.verticalRun) != null && horizontalWidgetRun2.start.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                Metrics metrics2 = LinearSystem.sMetrics;
                if (metrics2 != null) {
                    metrics2.graphSolved++;
                }
                linearSystem.addEquality(createObjectVariable, this.horizontalRun.start.value);
                linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, this.verticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, this.verticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, this.verticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                    }
                    if (z3 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                    }
                }
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
            Metrics metrics3 = LinearSystem.sMetrics;
            if (metrics3 != null) {
                metrics3.linearSolved++;
            }
            if (this.mParent != null) {
                if (isChainHead(0)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                    isInHorizontalChain = true;
                } else {
                    isInHorizontalChain = isInHorizontalChain();
                }
                if (isChainHead(1)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                    isInVerticalChain = true;
                } else {
                    isInVerticalChain = isInVerticalChain();
                }
                if (!isInHorizontalChain && z2 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
                }
                if (!isInVerticalChain && z3 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
                }
                z5 = isInHorizontalChain;
                z4 = isInVerticalChain;
            } else {
                z4 = false;
                z5 = false;
            }
            int i12 = this.mWidth;
            int i13 = this.mMinWidth;
            if (i12 < i13) {
                i12 = i13;
            }
            int i14 = this.mHeight;
            int i15 = this.mMinHeight;
            if (i14 < i15) {
                i14 = i15;
            }
            boolean z17 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z18 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
            this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
            float f2 = this.mDimensionRatio;
            this.mResolvedDimensionRatio = f2;
            int i16 = this.mMatchConstraintDefaultWidth;
            int i17 = this.mMatchConstraintDefaultHeight;
            int i18 = i12;
            if (f2 <= 0.0f || this.mVisibility == 8) {
                i2 = i17;
                i3 = i16;
                i4 = i18;
                i5 = i14;
                z6 = false;
            } else {
                int i19 = i14;
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 0) {
                    i16 = 3;
                }
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i17 == 0) {
                    i17 = 3;
                }
                DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
                DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2) {
                    i11 = 3;
                    if (i16 == 3 && i17 == 3) {
                        setupDimensionRatio(z2, z3, z17, z18);
                        i2 = i17;
                        i3 = i16;
                        i4 = i18;
                        i5 = i19;
                        z6 = true;
                    }
                } else {
                    i11 = 3;
                }
                DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr2[0];
                DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour3 == dimensionBehaviour4 && i16 == i11) {
                    this.mResolvedDimensionRatioSide = 0;
                    i4 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                    i2 = i17;
                    if (dimensionBehaviourArr2[1] != dimensionBehaviour4) {
                        i5 = i19;
                        z6 = false;
                        i3 = 4;
                    } else {
                        i3 = i16;
                        i5 = i19;
                        z6 = true;
                    }
                } else {
                    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i17 == 3) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (this.mDimensionRatioSide == -1) {
                            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                        }
                        i5 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                            i3 = i16;
                            i4 = i18;
                            z6 = false;
                            i2 = 4;
                        } else {
                            i2 = i17;
                            i3 = i16;
                            i4 = i18;
                            z6 = true;
                        }
                    }
                    i2 = i17;
                    i3 = i16;
                    i4 = i18;
                    i5 = i19;
                    z6 = true;
                }
            }
            int[] iArr = this.mResolvedMatchConstraintDefault;
            iArr[0] = i3;
            iArr[1] = i2;
            this.mResolvedHasRatio = z6;
            if (z6) {
                int i20 = this.mResolvedDimensionRatioSide;
                i6 = -1;
                if (i20 == 0 || i20 == -1) {
                    z7 = true;
                    boolean z19 = !z6 && ((i10 = this.mResolvedDimensionRatioSide) == 1 || i10 == i6);
                    z8 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                    i7 = !z8 ? 0 : i4;
                    z9 = !this.mCenter.isConnected();
                    boolean[] zArr2 = this.mIsInBarrier;
                    z10 = zArr2[0];
                    boolean z20 = zArr2[1];
                    if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                        if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                            dependencyNode = horizontalWidgetRun.start;
                            if (dependencyNode.resolved && horizontalWidgetRun.end.resolved) {
                                if (z) {
                                    linearSystem.addEquality(createObjectVariable, dependencyNode.value);
                                    linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                                    if (this.mParent != null && z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                                    }
                                }
                            }
                        }
                        ConstraintWidget constraintWidget7 = this.mParent;
                        SolverVariable createObjectVariable6 = constraintWidget7 == null ? linearSystem.createObjectVariable(constraintWidget7.mRight) : null;
                        ConstraintWidget constraintWidget8 = this.mParent;
                        SolverVariable createObjectVariable7 = constraintWidget8 == null ? linearSystem.createObjectVariable(constraintWidget8.mLeft) : null;
                        boolean z21 = this.isTerminalWidget[0];
                        DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                        z11 = z2;
                        z12 = z3;
                        z13 = z6;
                        solverVariable = createObjectVariable5;
                        solverVariable2 = createObjectVariable4;
                        solverVariable3 = createObjectVariable3;
                        solverVariable4 = createObjectVariable2;
                        solverVariable5 = createObjectVariable;
                        applyConstraints(linearSystem, true, z2, z3, z21, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr3[0], z8, this.mLeft, this.mRight, this.mX, i7, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr3[1] != DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z10, i3, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                        if (z) {
                            i8 = 8;
                            i9 = 0;
                            c2 = 1;
                            constraintWidget3 = this;
                            linearSystem2 = linearSystem;
                            solverVariable6 = solverVariable;
                            solverVariable7 = solverVariable2;
                            solverVariable8 = solverVariable3;
                        } else {
                            constraintWidget3 = this;
                            VerticalWidgetRun verticalWidgetRun2 = constraintWidget3.verticalRun;
                            if (verticalWidgetRun2 != null) {
                                DependencyNode dependencyNode2 = verticalWidgetRun2.start;
                                if (dependencyNode2.resolved && verticalWidgetRun2.end.resolved) {
                                    linearSystem2 = linearSystem;
                                    solverVariable8 = solverVariable3;
                                    linearSystem2.addEquality(solverVariable8, dependencyNode2.value);
                                    solverVariable7 = solverVariable2;
                                    linearSystem2.addEquality(solverVariable7, constraintWidget3.verticalRun.end.value);
                                    solverVariable6 = solverVariable;
                                    linearSystem2.addEquality(solverVariable6, constraintWidget3.verticalRun.baseline.value);
                                    ConstraintWidget constraintWidget9 = constraintWidget3.mParent;
                                    if (constraintWidget9 == null || z4 || !z12) {
                                        i8 = 8;
                                        i9 = 0;
                                        c2 = 1;
                                    } else {
                                        c2 = 1;
                                        if (constraintWidget3.isTerminalWidget[1]) {
                                            i8 = 8;
                                            i9 = 0;
                                            linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget9.mBottom), solverVariable7, 0, 8);
                                        } else {
                                            i8 = 8;
                                            i9 = 0;
                                        }
                                    }
                                    z14 = false;
                                    if ((constraintWidget3.mVerticalResolution == 2 ? false : z14) || constraintWidget3.resolvedVertical) {
                                        solverVariable9 = solverVariable7;
                                        solverVariable10 = solverVariable8;
                                    } else {
                                        boolean z22 = constraintWidget3.mListDimensionBehaviors[c2] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget3 instanceof ConstraintWidgetContainer);
                                        if (z22) {
                                            i5 = 0;
                                        }
                                        ConstraintWidget constraintWidget10 = constraintWidget3.mParent;
                                        SolverVariable createObjectVariable8 = constraintWidget10 != null ? linearSystem2.createObjectVariable(constraintWidget10.mBottom) : null;
                                        ConstraintWidget constraintWidget11 = constraintWidget3.mParent;
                                        SolverVariable createObjectVariable9 = constraintWidget11 != null ? linearSystem2.createObjectVariable(constraintWidget11.mTop) : null;
                                        if (constraintWidget3.mBaselineDistance > 0 || constraintWidget3.mVisibility == i8) {
                                            if (constraintWidget3.mBaseline.mTarget != null) {
                                                linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i8);
                                                linearSystem2.addEquality(solverVariable6, linearSystem2.createObjectVariable(constraintWidget3.mBaseline.mTarget), i9, i8);
                                                if (z12) {
                                                    linearSystem2.addGreaterThan(createObjectVariable8, linearSystem2.createObjectVariable(constraintWidget3.mBottom), i9, 5);
                                                }
                                                z15 = false;
                                                boolean z23 = constraintWidget3.isTerminalWidget[c2];
                                                DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidget3.mListDimensionBehaviors;
                                                solverVariable9 = solverVariable7;
                                                solverVariable10 = solverVariable8;
                                                applyConstraints(linearSystem, false, z12, z11, z23, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr4[c2], z22, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i5, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c2], constraintWidget3.mVerticalBiasPercent, z19, dimensionBehaviourArr4[0] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z20, i2, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z15);
                                            } else if (constraintWidget3.mVisibility == i8) {
                                                linearSystem2.addEquality(solverVariable6, solverVariable8, i9, i8);
                                            } else {
                                                linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i8);
                                            }
                                        }
                                        z15 = z9;
                                        boolean z232 = constraintWidget3.isTerminalWidget[c2];
                                        DimensionBehaviour[] dimensionBehaviourArr42 = constraintWidget3.mListDimensionBehaviors;
                                        solverVariable9 = solverVariable7;
                                        solverVariable10 = solverVariable8;
                                        applyConstraints(linearSystem, false, z12, z11, z232, createObjectVariable9, createObjectVariable8, dimensionBehaviourArr42[c2], z22, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i5, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c2], constraintWidget3.mVerticalBiasPercent, z19, dimensionBehaviourArr42[0] != DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z20, i2, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z15);
                                    }
                                    if (z13) {
                                        constraintWidget4 = this;
                                        if (constraintWidget4.mResolvedDimensionRatioSide == 1) {
                                            linearSystem.addRatio(solverVariable9, solverVariable10, solverVariable4, solverVariable5, constraintWidget4.mResolvedDimensionRatio, 8);
                                        } else {
                                            linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable9, solverVariable10, constraintWidget4.mResolvedDimensionRatio, 8);
                                        }
                                    } else {
                                        constraintWidget4 = this;
                                    }
                                    if (constraintWidget4.mCenter.isConnected()) {
                                        linearSystem.addCenterPoint(constraintWidget4, constraintWidget4.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget4.mCircleConstraintAngle + 90.0f), constraintWidget4.mCenter.getMargin());
                                    }
                                    constraintWidget4.resolvedHorizontal = false;
                                    constraintWidget4.resolvedVertical = false;
                                }
                            }
                            linearSystem2 = linearSystem;
                            solverVariable6 = solverVariable;
                            solverVariable7 = solverVariable2;
                            solverVariable8 = solverVariable3;
                            i8 = 8;
                            i9 = 0;
                            c2 = 1;
                        }
                        z14 = true;
                        if (constraintWidget3.mVerticalResolution == 2 ? false : z14) {
                        }
                        solverVariable9 = solverVariable7;
                        solverVariable10 = solverVariable8;
                        if (z13) {
                        }
                        if (constraintWidget4.mCenter.isConnected()) {
                        }
                        constraintWidget4.resolvedHorizontal = false;
                        constraintWidget4.resolvedVertical = false;
                    }
                    z11 = z2;
                    z12 = z3;
                    z13 = z6;
                    solverVariable = createObjectVariable5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    solverVariable5 = createObjectVariable;
                    if (z) {
                    }
                    z14 = true;
                    if (constraintWidget3.mVerticalResolution == 2 ? false : z14) {
                    }
                    solverVariable9 = solverVariable7;
                    solverVariable10 = solverVariable8;
                    if (z13) {
                    }
                    if (constraintWidget4.mCenter.isConnected()) {
                    }
                    constraintWidget4.resolvedHorizontal = false;
                    constraintWidget4.resolvedVertical = false;
                }
            } else {
                i6 = -1;
            }
            z7 = false;
            if (z6) {
            }
            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
            }
            if (!z8) {
            }
            z9 = !this.mCenter.isConnected();
            boolean[] zArr22 = this.mIsInBarrier;
            z10 = zArr22[0];
            boolean z202 = zArr22[1];
            if (this.mHorizontalResolution != 2) {
                if (z) {
                    dependencyNode = horizontalWidgetRun.start;
                    if (dependencyNode.resolved) {
                        if (z) {
                        }
                    }
                }
                ConstraintWidget constraintWidget72 = this.mParent;
                if (constraintWidget72 == null) {
                }
                ConstraintWidget constraintWidget82 = this.mParent;
                if (constraintWidget82 == null) {
                }
                boolean z212 = this.isTerminalWidget[0];
                DimensionBehaviour[] dimensionBehaviourArr32 = this.mListDimensionBehaviors;
                z11 = z2;
                z12 = z3;
                z13 = z6;
                solverVariable = createObjectVariable5;
                solverVariable2 = createObjectVariable4;
                solverVariable3 = createObjectVariable3;
                solverVariable4 = createObjectVariable2;
                solverVariable5 = createObjectVariable;
                applyConstraints(linearSystem, true, z2, z3, z212, createObjectVariable7, createObjectVariable6, dimensionBehaviourArr32[0], z8, this.mLeft, this.mRight, this.mX, i7, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z7, dimensionBehaviourArr32[1] != DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z10, i3, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z9);
                if (z) {
                }
                z14 = true;
                if (constraintWidget3.mVerticalResolution == 2 ? false : z14) {
                }
                solverVariable9 = solverVariable7;
                solverVariable10 = solverVariable8;
                if (z13) {
                }
                if (constraintWidget4.mCenter.isConnected()) {
                }
                constraintWidget4.resolvedHorizontal = false;
                constraintWidget4.resolvedVertical = false;
            }
            z11 = z2;
            z12 = z3;
            z13 = z6;
            solverVariable = createObjectVariable5;
            solverVariable2 = createObjectVariable4;
            solverVariable3 = createObjectVariable3;
            solverVariable4 = createObjectVariable2;
            solverVariable5 = createObjectVariable;
            if (z) {
            }
            z14 = true;
            if (constraintWidget3.mVerticalResolution == 2 ? false : z14) {
            }
            solverVariable9 = solverVariable7;
            solverVariable10 = solverVariable8;
            if (z13) {
            }
            if (constraintWidget4.mCenter.isConnected()) {
            }
            constraintWidget4.resolvedHorizontal = false;
            constraintWidget4.resolvedVertical = false;
        }
    }

    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVisibility != 8 : invokeV.booleanValue;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048582, this, constraintAnchor, constraintAnchor2, i2) == null) && constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{constraintWidget, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
            immediateConnect(type, constraintWidget, type, i2, 0);
            this.mCircleConstraintAngle = f2;
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, constraintWidget, hashMap) == null) {
            this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
            this.mVerticalResolution = constraintWidget.mVerticalResolution;
            this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
            this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
            int[] iArr = this.mResolvedMatchConstraintDefault;
            int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1];
            this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
            this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
            this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
            this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
            this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
            this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
            this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
            this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
            this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
            int[] iArr3 = constraintWidget.mMaxDimension;
            this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
            this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
            this.hasBaseline = constraintWidget.hasBaseline;
            this.inPlaceholder = constraintWidget.inPlaceholder;
            this.mLeft.reset();
            this.mTop.reset();
            this.mRight.reset();
            this.mBottom.reset();
            this.mBaseline.reset();
            this.mCenterX.reset();
            this.mCenterY.reset();
            this.mCenter.reset();
            this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
            this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
            this.mWidth = constraintWidget.mWidth;
            this.mHeight = constraintWidget.mHeight;
            this.mDimensionRatio = constraintWidget.mDimensionRatio;
            this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
            this.mX = constraintWidget.mX;
            this.mY = constraintWidget.mY;
            this.mRelX = constraintWidget.mRelX;
            this.mRelY = constraintWidget.mRelY;
            this.mOffsetX = constraintWidget.mOffsetX;
            this.mOffsetY = constraintWidget.mOffsetY;
            this.mBaselineDistance = constraintWidget.mBaselineDistance;
            this.mMinWidth = constraintWidget.mMinWidth;
            this.mMinHeight = constraintWidget.mMinHeight;
            this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
            this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
            this.mCompanionWidget = constraintWidget.mCompanionWidget;
            this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
            this.mVisibility = constraintWidget.mVisibility;
            this.mDebugName = constraintWidget.mDebugName;
            this.mType = constraintWidget.mType;
            this.mDistToTop = constraintWidget.mDistToTop;
            this.mDistToLeft = constraintWidget.mDistToLeft;
            this.mDistToRight = constraintWidget.mDistToRight;
            this.mDistToBottom = constraintWidget.mDistToBottom;
            this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
            this.mRightHasCentered = constraintWidget.mRightHasCentered;
            this.mTopHasCentered = constraintWidget.mTopHasCentered;
            this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
            this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
            this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
            this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
            this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
            this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
            this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
            float[] fArr = this.mWeight;
            float[] fArr2 = constraintWidget.mWeight;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
            ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
            constraintWidgetArr[0] = constraintWidgetArr2[0];
            constraintWidgetArr[1] = constraintWidgetArr2[1];
            ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
            ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
            constraintWidgetArr3[0] = constraintWidgetArr4[0];
            constraintWidgetArr3[1] = constraintWidgetArr4[1];
            ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
            this.mHorizontalNextWidget = constraintWidget2 == null ? null : hashMap.get(constraintWidget2);
            ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
            this.mVerticalNextWidget = constraintWidget3 != null ? hashMap.get(constraintWidget3) : null;
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, linearSystem) == null) {
            linearSystem.createObjectVariable(this.mLeft);
            linearSystem.createObjectVariable(this.mTop);
            linearSystem.createObjectVariable(this.mRight);
            linearSystem.createObjectVariable(this.mBottom);
            if (this.mBaselineDistance > 0) {
                linearSystem.createObjectVariable(this.mBaseline);
            }
        }
    }

    public void ensureMeasureRequested() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mMeasureRequested = true;
        }
    }

    public void ensureWidgetRuns() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.horizontalRun == null) {
                this.horizontalRun = new HorizontalWidgetRun(this);
            }
            if (this.verticalRun == null) {
                this.verticalRun = new VerticalWidgetRun(this);
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, type)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
                case 1:
                    return this.mLeft;
                case 2:
                    return this.mTop;
                case 3:
                    return this.mRight;
                case 4:
                    return this.mBottom;
                case 5:
                    return this.mBaseline;
                case 6:
                    return this.mCenter;
                case 7:
                    return this.mCenterX;
                case 8:
                    return this.mCenterY;
                case 9:
                    return null;
                default:
                    throw new AssertionError(type.name());
            }
        }
        return (ConstraintAnchor) invokeL.objValue;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mAnchors : (ArrayList) invokeV.objValue;
    }

    public int getBaselineDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBaselineDistance : invokeV.intValue;
    }

    public float getBiasPercent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0) {
                return this.mHorizontalBiasPercent;
            }
            if (i2 == 1) {
                return this.mVerticalBiasPercent;
            }
            return -1.0f;
        }
        return invokeI.floatValue;
    }

    public int getBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getY() + this.mHeight : invokeV.intValue;
    }

    public Object getCompanionWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mCompanionWidget : invokeV.objValue;
    }

    public int getContainerItemSkip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mContainerItemSkip : invokeV.intValue;
    }

    public String getDebugName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mDebugName : (String) invokeV.objValue;
    }

    public DimensionBehaviour getDimensionBehaviour(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (i2 == 0) {
                return getHorizontalDimensionBehaviour();
            }
            if (i2 == 1) {
                return getVerticalDimensionBehaviour();
            }
            return null;
        }
        return (DimensionBehaviour) invokeI.objValue;
    }

    public float getDimensionRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mDimensionRatio : invokeV.floatValue;
    }

    public int getDimensionRatioSide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mDimensionRatioSide : invokeV.intValue;
    }

    public boolean getHasBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.hasBaseline : invokeV.booleanValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mVisibility == 8) {
                return 0;
            }
            return this.mHeight;
        }
        return invokeV.intValue;
    }

    public float getHorizontalBiasPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mHorizontalBiasPercent : invokeV.floatValue;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (isInHorizontalChain()) {
                ConstraintWidget constraintWidget = this;
                ConstraintWidget constraintWidget2 = null;
                while (constraintWidget2 == null && constraintWidget != null) {
                    ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                    ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                    ConstraintWidget owner = target == null ? null : target.getOwner();
                    if (owner == getParent()) {
                        return constraintWidget;
                    }
                    ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
                    if (target2 == null || target2.getOwner() == constraintWidget) {
                        constraintWidget = owner;
                    } else {
                        constraintWidget2 = constraintWidget;
                    }
                }
                return constraintWidget2;
            }
            return null;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    public int getHorizontalChainStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mHorizontalChainStyle : invokeV.intValue;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mListDimensionBehaviors[0] : (DimensionBehaviour) invokeV.objValue;
    }

    public int getHorizontalMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ConstraintAnchor constraintAnchor = this.mLeft;
            int i2 = constraintAnchor != null ? 0 + constraintAnchor.mMargin : 0;
            ConstraintAnchor constraintAnchor2 = this.mRight;
            return constraintAnchor2 != null ? i2 + constraintAnchor2.mMargin : i2;
        }
        return invokeV.intValue;
    }

    public int getLastHorizontalMeasureSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mLastHorizontalMeasureSpec : invokeV.intValue;
    }

    public int getLastVerticalMeasureSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mLastVerticalMeasureSpec : invokeV.intValue;
    }

    public int getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? getX() : invokeV.intValue;
    }

    public int getLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            if (i2 == 0) {
                return getWidth();
            }
            if (i2 == 1) {
                return getHeight();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public int getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mMaxDimension[1] : invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mMaxDimension[0] : invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mMinHeight : invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mMinWidth : invokeV.intValue;
    }

    public ConstraintWidget getNextChainMember(int i2) {
        InterceptResult invokeI;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                    return constraintAnchor2.mOwner;
                }
                return null;
            }
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        }
        return (ConstraintWidget) invokeI.objValue;
    }

    public int getOptimizerWrapHeight() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            int i3 = this.mHeight;
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.mMatchConstraintDefaultHeight == 1) {
                    i2 = Math.max(this.mMatchConstraintMinHeight, i3);
                } else {
                    i2 = this.mMatchConstraintMinHeight;
                    if (i2 > 0) {
                        this.mHeight = i2;
                    } else {
                        i2 = 0;
                    }
                }
                int i4 = this.mMatchConstraintMaxHeight;
                return (i4 <= 0 || i4 >= i2) ? i2 : i4;
            }
            return i3;
        }
        return invokeV.intValue;
    }

    public int getOptimizerWrapWidth() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int i3 = this.mWidth;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.mMatchConstraintDefaultWidth == 1) {
                    i2 = Math.max(this.mMatchConstraintMinWidth, i3);
                } else {
                    i2 = this.mMatchConstraintMinWidth;
                    if (i2 > 0) {
                        this.mWidth = i2;
                    } else {
                        i2 = 0;
                    }
                }
                int i4 = this.mMatchConstraintMaxWidth;
                return (i4 <= 0 || i4 >= i2) ? i2 : i4;
            }
            return i3;
        }
        return invokeV.intValue;
    }

    public ConstraintWidget getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mParent : (ConstraintWidget) invokeV.objValue;
    }

    public ConstraintWidget getPreviousChainMember(int i2) {
        InterceptResult invokeI;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                    return constraintAnchor2.mOwner;
                }
                return null;
            }
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        }
        return (ConstraintWidget) invokeI.objValue;
    }

    public int getRelativePositioning(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            if (i2 == 0) {
                return this.mRelX;
            }
            if (i2 == 1) {
                return this.mRelY;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public int getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? getX() + this.mWidth : invokeV.intValue;
    }

    public int getRootX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mX + this.mOffsetX : invokeV.intValue;
    }

    public int getRootY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mY + this.mOffsetY : invokeV.intValue;
    }

    public WidgetRun getRun(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            if (i2 == 0) {
                return this.horizontalRun;
            }
            if (i2 == 1) {
                return this.verticalRun;
            }
            return null;
        }
        return (WidgetRun) invokeI.objValue;
    }

    public int getTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? getY() : invokeV.intValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    public float getVerticalBiasPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mVerticalBiasPercent : invokeV.floatValue;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (isInVerticalChain()) {
                ConstraintWidget constraintWidget = this;
                ConstraintWidget constraintWidget2 = null;
                while (constraintWidget2 == null && constraintWidget != null) {
                    ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                    ConstraintWidget owner = target == null ? null : target.getOwner();
                    if (owner == getParent()) {
                        return constraintWidget;
                    }
                    ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
                    if (target2 == null || target2.getOwner() == constraintWidget) {
                        constraintWidget = owner;
                    } else {
                        constraintWidget2 = constraintWidget;
                    }
                }
                return constraintWidget2;
            }
            return null;
        }
        return (ConstraintWidget) invokeV.objValue;
    }

    public int getVerticalChainStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mVerticalChainStyle : invokeV.intValue;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mListDimensionBehaviors[1] : (DimensionBehaviour) invokeV.objValue;
    }

    public int getVerticalMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            int i2 = this.mLeft != null ? 0 + this.mTop.mMargin : 0;
            return this.mRight != null ? i2 + this.mBottom.mMargin : i2;
        }
        return invokeV.intValue;
    }

    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mVisibility : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.mVisibility == 8) {
                return 0;
            }
            return this.mWidth;
        }
        return invokeV.intValue;
    }

    public int getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            ConstraintWidget constraintWidget = this.mParent;
            if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
                return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
            }
            return this.mX;
        }
        return invokeV.intValue;
    }

    public int getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            ConstraintWidget constraintWidget = this.mParent;
            if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
                return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
            }
            return this.mY;
        }
        return invokeV.intValue;
    }

    public boolean hasBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.hasBaseline : invokeV.booleanValue;
    }

    public boolean hasDanglingDimension(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            if (i2 == 0) {
                return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
            }
            return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
        }
        return invokeI.booleanValue;
    }

    public boolean hasDependencies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mAnchors.get(i2).hasDependents()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{type, constraintWidget, type2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            getAnchor(type).connect(constraintWidget.getAnchor(type2), i2, i3, true);
        }
    }

    public boolean isHeightWrapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mIsHeightWrapContent : invokeV.booleanValue;
    }

    public boolean isInHorizontalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ConstraintAnchor constraintAnchor = this.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
                ConstraintAnchor constraintAnchor3 = this.mRight;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isInPlaceholder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.inPlaceholder : invokeV.booleanValue;
    }

    public boolean isInVerticalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ConstraintAnchor constraintAnchor = this.mTop;
            ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
            if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
                ConstraintAnchor constraintAnchor3 = this.mBottom;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isInVirtualLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mInVirtuaLayout : invokeV.booleanValue;
    }

    public boolean isMeasureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mMeasureRequested && this.mVisibility != 8 : invokeV.booleanValue;
    }

    public boolean isResolvedHorizontally() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue()) : invokeV.booleanValue;
    }

    public boolean isResolvedVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue()) : invokeV.booleanValue;
    }

    public boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mParent == null : invokeV.booleanValue;
    }

    public boolean isSpreadHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT : invokeV.booleanValue;
    }

    public boolean isSpreadWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT : invokeV.booleanValue;
    }

    public boolean isWidthWrapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mIsWidthWrapContent : invokeV.booleanValue;
    }

    public boolean oppositeDimensionDependsOn(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i2)) == null) {
            char c2 = i2 == 0 ? (char) 1 : (char) 0;
            DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i2];
            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c2];
            DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
            return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
        }
        return invokeI.booleanValue;
    }

    public boolean oppositeDimensionsTied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.mLeft.reset();
            this.mTop.reset();
            this.mRight.reset();
            this.mBottom.reset();
            this.mBaseline.reset();
            this.mCenterX.reset();
            this.mCenterY.reset();
            this.mCenter.reset();
            this.mParent = null;
            this.mCircleConstraintAngle = 0.0f;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mDimensionRatio = 0.0f;
            this.mDimensionRatioSide = -1;
            this.mX = 0;
            this.mY = 0;
            this.mOffsetX = 0;
            this.mOffsetY = 0;
            this.mBaselineDistance = 0;
            this.mMinWidth = 0;
            this.mMinHeight = 0;
            float f2 = DEFAULT_BIAS;
            this.mHorizontalBiasPercent = f2;
            this.mVerticalBiasPercent = f2;
            DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
            dimensionBehaviourArr[0] = dimensionBehaviour;
            dimensionBehaviourArr[1] = dimensionBehaviour;
            this.mCompanionWidget = null;
            this.mContainerItemSkip = 0;
            this.mVisibility = 0;
            this.mType = null;
            this.mHorizontalWrapVisited = false;
            this.mVerticalWrapVisited = false;
            this.mHorizontalChainStyle = 0;
            this.mVerticalChainStyle = 0;
            this.mHorizontalChainFixedPosition = false;
            this.mVerticalChainFixedPosition = false;
            float[] fArr = this.mWeight;
            fArr[0] = -1.0f;
            fArr[1] = -1.0f;
            this.mHorizontalResolution = -1;
            this.mVerticalResolution = -1;
            int[] iArr = this.mMaxDimension;
            iArr[0] = Integer.MAX_VALUE;
            iArr[1] = Integer.MAX_VALUE;
            this.mMatchConstraintDefaultWidth = 0;
            this.mMatchConstraintDefaultHeight = 0;
            this.mMatchConstraintPercentWidth = 1.0f;
            this.mMatchConstraintPercentHeight = 1.0f;
            this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
            this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
            this.mMatchConstraintMinWidth = 0;
            this.mMatchConstraintMinHeight = 0;
            this.mResolvedHasRatio = false;
            this.mResolvedDimensionRatioSide = -1;
            this.mResolvedDimensionRatio = 1.0f;
            this.mGroupsToSolver = false;
            boolean[] zArr = this.isTerminalWidget;
            zArr[0] = true;
            zArr[1] = true;
            this.mInVirtuaLayout = false;
            boolean[] zArr2 = this.mIsInBarrier;
            zArr2[0] = false;
            zArr2[1] = false;
            this.mMeasureRequested = true;
        }
    }

    public void resetAllConstraints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            resetAnchors();
            setVerticalBiasPercent(DEFAULT_BIAS);
            setHorizontalBiasPercent(DEFAULT_BIAS);
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, constraintAnchor) == null) {
            if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
                return;
            }
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor != anchor && constraintAnchor != anchor2) {
                if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor5.reset();
                }
            } else if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            ConstraintWidget parent = getParent();
            if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
                return;
            }
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAnchors.get(i2).reset();
            }
        }
    }

    public void resetFinalResolution() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAnchors.get(i2).resetFinalResolution();
            }
        }
    }

    public void resetSolverVariables(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, cache) == null) {
            this.mLeft.resetSolverVariable(cache);
            this.mTop.resetSolverVariable(cache);
            this.mRight.resetSolverVariable(cache);
            this.mBottom.resetSolverVariable(cache);
            this.mBaseline.resetSolverVariable(cache);
            this.mCenter.resetSolverVariable(cache);
            this.mCenterX.resetSolverVariable(cache);
            this.mCenterY.resetSolverVariable(cache);
        }
    }

    public void setBaselineDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.mBaselineDistance = i2;
            this.hasBaseline = i2 > 0;
        }
    }

    public void setCompanionWidget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, obj) == null) {
            this.mCompanionWidget = obj;
        }
    }

    public void setContainerItemSkip(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            if (i2 >= 0) {
                this.mContainerItemSkip = i2;
            } else {
                this.mContainerItemSkip = 0;
            }
        }
    }

    public void setDebugName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            this.mDebugName = str;
        }
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048663, this, linearSystem, str) == null) {
            this.mDebugName = str;
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
            createObjectVariable.setName(str + ".left");
            createObjectVariable2.setName(str + ".top");
            createObjectVariable3.setName(str + ".right");
            createObjectVariable4.setName(str + ".bottom");
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void setDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048664, this, i2, i3) == null) {
            this.mWidth = i2;
            int i4 = this.mMinWidth;
            if (i2 < i4) {
                this.mWidth = i4;
            }
            this.mHeight = i3;
            int i5 = this.mMinHeight;
            if (i3 < i5) {
                this.mHeight = i5;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0088 -> B:41:0x0089). Please submit an issue!!! */
    public void setDimensionRatio(String str) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            int i2 = 0;
            if (str != null && str.length() != 0) {
                int i3 = -1;
                int length = str.length();
                int indexOf = str.indexOf(44);
                int i4 = 0;
                if (indexOf > 0 && indexOf < length - 1) {
                    String substring = str.substring(0, indexOf);
                    if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                        i3 = 0;
                    } else if (substring.equalsIgnoreCase(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                        i3 = 1;
                    }
                    i4 = indexOf + 1;
                }
                int indexOf2 = str.indexOf(58);
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = str.substring(i4, indexOf2);
                    String substring3 = str.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i3 == 1) {
                                f2 = Math.abs(parseFloat2 / parseFloat);
                            } else {
                                f2 = Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                    f2 = 0.0f;
                } else {
                    String substring4 = str.substring(i4);
                    if (substring4.length() > 0) {
                        f2 = Float.parseFloat(substring4);
                    }
                    f2 = 0.0f;
                }
                i2 = (f2 > i2 ? 1 : (f2 == i2 ? 0 : -1));
                if (i2 > 0) {
                    this.mDimensionRatio = f2;
                    this.mDimensionRatioSide = i3;
                    return;
                }
                return;
            }
            this.mDimensionRatio = 0.0f;
        }
    }

    public void setFinalBaseline(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048667, this, i2) == null) && this.hasBaseline) {
            int i3 = i2 - this.mBaselineDistance;
            int i4 = this.mHeight + i3;
            this.mY = i3;
            this.mTop.setFinalValue(i3);
            this.mBottom.setFinalValue(i4);
            this.mBaseline.setFinalValue(i2);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048668, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            setFrame(i2, i3, i4, i5);
            setBaselineDistance(i6);
            if (i7 == 0) {
                this.resolvedHorizontal = true;
                this.resolvedVertical = false;
            } else if (i7 == 1) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = true;
            } else if (i7 == 2) {
                this.resolvedHorizontal = true;
                this.resolvedVertical = true;
            } else {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
            }
        }
    }

    public void setFinalHorizontal(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048669, this, i2, i3) == null) {
            this.mLeft.setFinalValue(i2);
            this.mRight.setFinalValue(i3);
            this.mX = i2;
            this.mWidth = i3 - i2;
            this.resolvedHorizontal = true;
        }
    }

    public void setFinalLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
            this.mLeft.setFinalValue(i2);
            this.mX = i2;
        }
    }

    public void setFinalTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.mTop.setFinalValue(i2);
            this.mY = i2;
        }
    }

    public void setFinalVertical(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048672, this, i2, i3) == null) {
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3);
            this.mY = i2;
            this.mHeight = i3 - i2;
            if (this.hasBaseline) {
                this.mBaseline.setFinalValue(i2 + this.mBaselineDistance);
            }
            this.resolvedVertical = true;
        }
    }

    public void setFrame(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048674, this, i2, i3, i4, i5) == null) {
            int i8 = i4 - i2;
            int i9 = i5 - i3;
            this.mX = i2;
            this.mY = i3;
            if (this.mVisibility == 8) {
                this.mWidth = 0;
                this.mHeight = 0;
                return;
            }
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i7 = this.mWidth)) {
                i8 = i7;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i6 = this.mHeight)) {
                i9 = i6;
            }
            this.mWidth = i8;
            this.mHeight = i9;
            int i10 = this.mMinHeight;
            if (i9 < i10) {
                this.mHeight = i10;
            }
            int i11 = this.mWidth;
            int i12 = this.mMinWidth;
            if (i11 < i12) {
                this.mWidth = i12;
            }
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048675, this, type, i2) == null) {
            int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
            if (i3 == 1) {
                this.mLeft.mGoneMargin = i2;
            } else if (i3 == 2) {
                this.mTop.mGoneMargin = i2;
            } else if (i3 == 3) {
                this.mRight.mGoneMargin = i2;
            } else if (i3 != 4) {
            } else {
                this.mBottom.mGoneMargin = i2;
            }
        }
    }

    public void setHasBaseline(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.hasBaseline = z;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i2) == null) {
            this.mHeight = i2;
            int i3 = this.mMinHeight;
            if (i2 < i3) {
                this.mHeight = i3;
            }
        }
    }

    public void setHeightWrapContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z) == null) {
            this.mIsHeightWrapContent = z;
        }
    }

    public void setHorizontalBiasPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048679, this, f2) == null) {
            this.mHorizontalBiasPercent = f2;
        }
    }

    public void setHorizontalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i2) == null) {
            this.mHorizontalChainStyle = i2;
        }
    }

    public void setHorizontalDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048681, this, i2, i3) == null) {
            this.mX = i2;
            int i4 = i3 - i2;
            this.mWidth = i4;
            int i5 = this.mMinWidth;
            if (i4 < i5) {
                this.mWidth = i5;
            }
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, dimensionBehaviour) == null) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour;
        }
    }

    public void setHorizontalMatchStyle(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            this.mMatchConstraintDefaultWidth = i2;
            this.mMatchConstraintMinWidth = i3;
            if (i4 == Integer.MAX_VALUE) {
                i4 = 0;
            }
            this.mMatchConstraintMaxWidth = i4;
            this.mMatchConstraintPercentWidth = f2;
            if (f2 <= 0.0f || f2 >= 1.0f || this.mMatchConstraintDefaultWidth != 0) {
                return;
            }
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048684, this, f2) == null) {
            this.mWeight[0] = f2;
        }
    }

    public void setInBarrier(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mIsInBarrier[i2] = z;
        }
    }

    public void setInPlaceholder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.inPlaceholder = z;
        }
    }

    public void setInVirtualLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z) == null) {
            this.mInVirtuaLayout = z;
        }
    }

    public void setLastMeasureSpec(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048688, this, i2, i3) == null) {
            this.mLastHorizontalMeasureSpec = i2;
            this.mLastVerticalMeasureSpec = i3;
            setMeasureRequested(false);
        }
    }

    public void setLength(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048689, this, i2, i3) == null) {
            if (i3 == 0) {
                setWidth(i2);
            } else if (i3 == 1) {
                setHeight(i2);
            }
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            this.mMaxDimension[1] = i2;
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i2) == null) {
            this.mMaxDimension[0] = i2;
        }
    }

    public void setMeasureRequested(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            this.mMeasureRequested = z;
        }
    }

    public void setMinHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            if (i2 < 0) {
                this.mMinHeight = 0;
            } else {
                this.mMinHeight = i2;
            }
        }
    }

    public void setMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i2) == null) {
            if (i2 < 0) {
                this.mMinWidth = 0;
            } else {
                this.mMinWidth = i2;
            }
        }
    }

    public void setOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048695, this, i2, i3) == null) {
            this.mOffsetX = i2;
            this.mOffsetY = i3;
        }
    }

    public void setOrigin(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048696, this, i2, i3) == null) {
            this.mX = i2;
            this.mY = i3;
        }
    }

    public void setParent(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, constraintWidget) == null) {
            this.mParent = constraintWidget;
        }
    }

    public void setRelativePositioning(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048698, this, i2, i3) == null) {
            if (i3 == 0) {
                this.mRelX = i2;
            } else if (i3 == 1) {
                this.mRelY = i2;
            }
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            this.mType = str;
        }
    }

    public void setVerticalBiasPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048700, this, f2) == null) {
            this.mVerticalBiasPercent = f2;
        }
    }

    public void setVerticalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i2) == null) {
            this.mVerticalChainStyle = i2;
        }
    }

    public void setVerticalDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048702, this, i2, i3) == null) {
            this.mY = i2;
            int i4 = i3 - i2;
            this.mHeight = i4;
            int i5 = this.mMinHeight;
            if (i4 < i5) {
                this.mHeight = i5;
            }
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, dimensionBehaviour) == null) {
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
    }

    public void setVerticalMatchStyle(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            this.mMatchConstraintDefaultHeight = i2;
            this.mMatchConstraintMinHeight = i3;
            if (i4 == Integer.MAX_VALUE) {
                i4 = 0;
            }
            this.mMatchConstraintMaxHeight = i4;
            this.mMatchConstraintPercentHeight = f2;
            if (f2 <= 0.0f || f2 >= 1.0f || this.mMatchConstraintDefaultHeight != 0) {
                return;
            }
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048705, this, f2) == null) {
            this.mWeight[1] = f2;
        }
    }

    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            this.mVisibility = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            this.mWidth = i2;
            int i3 = this.mMinWidth;
            if (i2 < i3) {
                this.mWidth = i3;
            }
        }
    }

    public void setWidthWrapContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z) == null) {
            this.mIsWidthWrapContent = z;
        }
    }

    public void setX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            this.mX = i2;
        }
    }

    public void setY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i2) == null) {
            this.mY = i2;
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048711, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            if (this.mResolvedDimensionRatioSide == -1) {
                if (z3 && !z4) {
                    this.mResolvedDimensionRatioSide = 0;
                } else if (!z3 && z4) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                }
            }
            if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
                this.mResolvedDimensionRatioSide = 1;
            } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
                this.mResolvedDimensionRatioSide = 0;
            }
            if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
                if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                    this.mResolvedDimensionRatioSide = 0;
                } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatioSide = 1;
                }
            }
            if (this.mResolvedDimensionRatioSide == -1) {
                if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                    this.mResolvedDimensionRatioSide = 0;
                } else if (this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMinHeight <= 0) {
                } else {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatioSide = 1;
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            if (this.mType != null) {
                str = "type: " + this.mType + " ";
            } else {
                str = "";
            }
            sb.append(str);
            if (this.mDebugName != null) {
                str2 = "id: " + this.mDebugName + " ";
            }
            sb.append(str2);
            sb.append("(");
            sb.append(this.mX);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.mY);
            sb.append(") - (");
            sb.append(this.mWidth);
            sb.append(" x ");
            sb.append(this.mHeight);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048713, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean isResolved = z & this.horizontalRun.isResolved();
            boolean isResolved2 = z2 & this.verticalRun.isResolved();
            HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
            int i4 = horizontalWidgetRun.start.value;
            VerticalWidgetRun verticalWidgetRun = this.verticalRun;
            int i5 = verticalWidgetRun.start.value;
            int i6 = horizontalWidgetRun.end.value;
            int i7 = verticalWidgetRun.end.value;
            int i8 = i7 - i5;
            if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
                i6 = 0;
                i4 = 0;
                i7 = 0;
                i5 = 0;
            }
            int i9 = i6 - i4;
            int i10 = i7 - i5;
            if (isResolved) {
                this.mX = i4;
            }
            if (isResolved2) {
                this.mY = i5;
            }
            if (this.mVisibility == 8) {
                this.mWidth = 0;
                this.mHeight = 0;
                return;
            }
            if (isResolved) {
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i9 < (i3 = this.mWidth)) {
                    i9 = i3;
                }
                this.mWidth = i9;
                int i11 = this.mMinWidth;
                if (i9 < i11) {
                    this.mWidth = i11;
                }
            }
            if (isResolved2) {
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i10 < (i2 = this.mHeight)) {
                    i10 = i2;
                }
                this.mHeight = i10;
                int i12 = this.mMinHeight;
                if (i10 < i12) {
                    this.mHeight = i12;
                }
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048714, this, linearSystem, z) == null) {
            int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
            int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
            int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
            int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
            if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                DependencyNode dependencyNode = horizontalWidgetRun.start;
                if (dependencyNode.resolved) {
                    DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                    if (dependencyNode2.resolved) {
                        objectVariableValue = dependencyNode.value;
                        objectVariableValue3 = dependencyNode2.value;
                    }
                }
            }
            if (z && (verticalWidgetRun = this.verticalRun) != null) {
                DependencyNode dependencyNode3 = verticalWidgetRun.start;
                if (dependencyNode3.resolved) {
                    DependencyNode dependencyNode4 = verticalWidgetRun.end;
                    if (dependencyNode4.resolved) {
                        objectVariableValue2 = dependencyNode3.value;
                        objectVariableValue4 = dependencyNode4.value;
                    }
                }
            }
            int i2 = objectVariableValue4 - objectVariableValue2;
            if (objectVariableValue3 - objectVariableValue < 0 || i2 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
                objectVariableValue4 = 0;
                objectVariableValue = 0;
                objectVariableValue2 = 0;
                objectVariableValue3 = 0;
            }
            setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, type, constraintWidget, type2) == null) {
            connect(type, constraintWidget, type2, 0);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048581, this, type, constraintWidget, type2, i2) == null) {
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
            if (type == type3) {
                if (type2 == type3) {
                    ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                    ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                    ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    boolean z2 = true;
                    if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                        connect(type4, constraintWidget, type4, 0);
                        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.RIGHT;
                        connect(type5, constraintWidget, type5, 0);
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.TOP;
                        connect(type6, constraintWidget, type6, 0);
                        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BOTTOM;
                        connect(type7, constraintWidget, type7, 0);
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                    } else if (z) {
                        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                    } else if (z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                    }
                } else if (type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) {
                    if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                        connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                        connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                        getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                    }
                } else {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                }
            } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor5.connect(anchor6, 0);
                anchor7.connect(anchor6, 0);
                getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
            } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
                getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
                getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
            } else {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.CENTER_X;
                if (type == type8 && type2 == type8) {
                    getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
                    getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.CENTER_Y;
                if (type == type9 && type2 == type9) {
                    getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
                    getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                ConstraintAnchor anchor9 = getAnchor(type);
                ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
                if (anchor9.isValidConnection(anchor10)) {
                    if (type == ConstraintAnchor.Type.BASELINE) {
                        ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor11 != null) {
                            anchor11.reset();
                        }
                        if (anchor12 != null) {
                            anchor12.reset();
                        }
                        i2 = 0;
                    } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                        if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                            ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.CENTER);
                            if (anchor13.getTarget() != anchor10) {
                                anchor13.reset();
                            }
                            ConstraintAnchor opposite = getAnchor(type).getOpposite();
                            ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                            if (anchor14.isConnected()) {
                                opposite.reset();
                                anchor14.reset();
                            }
                        }
                    } else {
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor15 != null) {
                            anchor15.reset();
                        }
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor10) {
                            anchor16.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (anchor17.isConnected()) {
                            opposite2.reset();
                            anchor17.reset();
                        }
                    }
                    anchor9.connect(anchor10, i2);
                }
            }
        }
    }

    public void setFrame(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048673, this, i2, i3, i4) == null) {
            if (i4 == 0) {
                setHorizontalDimension(i2, i3);
            } else if (i4 == 1) {
                setVerticalDimension(i2, i3);
            }
        }
    }

    public void setDimensionRatio(float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            this.mDimensionRatio = f2;
            this.mDimensionRatioSide = i2;
        }
    }

    public ConstraintWidget(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        addAnchors();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConstraintWidget(String str, int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        setDebugName(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConstraintWidget(int i2, int i3) {
        this(0, 0, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConstraintWidget(String str, int i2, int i3) {
        this(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        setDebugName(str);
    }
}
