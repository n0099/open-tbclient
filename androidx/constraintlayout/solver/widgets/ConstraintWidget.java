package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConstraintWidget {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    public static final boolean AUTOTAG_CENTER = false;
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
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    public static final int WRAP = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public ConstraintWidgetGroup mBelongingGroup;
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
    public int mDrawHeight;
    public int mDrawWidth;
    public int mDrawX;
    public int mDrawY;
    public boolean mGroupsToSolver;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public boolean mHorizontalChainFixedPosition;
    public int mHorizontalChainStyle;
    public ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public boolean mHorizontalWrapVisited;
    public boolean mIsHeightWrapContent;
    public boolean mIsWidthWrapContent;
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
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public int mOffsetX;
    public int mOffsetY;
    public boolean mOptimizerMeasurable;
    public boolean mOptimizerMeasured;
    public ConstraintWidget mParent;
    public int mRelX;
    public int mRelY;
    public ResolutionDimension mResolutionHeight;
    public ResolutionDimension mResolutionWidth;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
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
    public int mWrapHeight;
    public int mWrapWidth;
    public int mX;
    public int mY;

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
    public static final class ContentAlignment {
        public static final /* synthetic */ ContentAlignment[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ContentAlignment BEGIN;
        public static final ContentAlignment BOTTOM;
        public static final ContentAlignment END;
        public static final ContentAlignment LEFT;
        public static final ContentAlignment MIDDLE;
        public static final ContentAlignment RIGHT;
        public static final ContentAlignment TOP;
        public static final ContentAlignment VERTICAL_MIDDLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-367956260, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$ContentAlignment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-367956260, "Landroidx/constraintlayout/solver/widgets/ConstraintWidget$ContentAlignment;");
                    return;
                }
            }
            BEGIN = new ContentAlignment("BEGIN", 0);
            MIDDLE = new ContentAlignment("MIDDLE", 1);
            END = new ContentAlignment("END", 2);
            TOP = new ContentAlignment("TOP", 3);
            VERTICAL_MIDDLE = new ContentAlignment("VERTICAL_MIDDLE", 4);
            BOTTOM = new ContentAlignment("BOTTOM", 5);
            LEFT = new ContentAlignment("LEFT", 6);
            ContentAlignment contentAlignment = new ContentAlignment("RIGHT", 7);
            RIGHT = contentAlignment;
            $VALUES = new ContentAlignment[]{BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, contentAlignment};
        }

        public ContentAlignment(String str, int i2) {
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

        public static ContentAlignment valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ContentAlignment) Enum.valueOf(ContentAlignment.class, str) : (ContentAlignment) invokeL.objValue;
        }

        public static ContentAlignment[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ContentAlignment[]) $VALUES.clone() : (ContentAlignment[]) invokeV.objValue;
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
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
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
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
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
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    private void addAnchors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:163:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02fa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3, int i4, int i5, float f2, boolean z3, boolean z4, int i6, int i7, int i8, float f3, boolean z5) {
        boolean z6;
        int i9;
        int i10;
        int i11;
        boolean z7;
        SolverVariable createObjectVariable;
        SolverVariable createObjectVariable2;
        SolverVariable solverVariable3;
        int i12;
        int i13;
        int i14;
        int i15;
        SolverVariable solverVariable4;
        boolean z8;
        boolean z9;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        boolean z10;
        boolean z11;
        int i16;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        boolean z12;
        boolean z13;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z14;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{linearSystem, Boolean.valueOf(z), solverVariable, solverVariable2, dimensionBehaviour, Boolean.valueOf(z2), constraintAnchor, constraintAnchor2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Float.valueOf(f3), Boolean.valueOf(z5)}) == null) {
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
            SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
            if (linearSystem.graphOptimizer && constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
                if (LinearSystem.getMetrics() != null) {
                    LinearSystem.getMetrics().resolvedWidgets++;
                }
                constraintAnchor.getResolutionNode().addResolvedValue(linearSystem);
                constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem);
                if (z4 || !z) {
                    return;
                }
                linearSystem.addGreaterThan(solverVariable2, createObjectVariable4, 0, 6);
                return;
            }
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().nonresolvedWidgets++;
            }
            boolean isConnected = constraintAnchor.isConnected();
            boolean isConnected2 = constraintAnchor2.isConnected();
            boolean isConnected3 = this.mCenter.isConnected();
            int i21 = isConnected ? 1 : 0;
            if (isConnected2) {
                i21++;
            }
            if (isConnected3) {
                i21++;
            }
            int i22 = i21;
            int i23 = z3 ? 3 : i6;
            int i24 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
            boolean z15 = (i24 == 1 || i24 == 2 || i24 == 3 || i24 != 4 || i23 == 4) ? false : true;
            if (this.mVisibility == 8) {
                i9 = 0;
                z6 = false;
            } else {
                z6 = z15;
                i9 = i3;
            }
            if (z5) {
                if (!isConnected && !isConnected2 && !isConnected3) {
                    linearSystem.addEquality(createObjectVariable3, i2);
                } else if (isConnected && !isConnected2) {
                    i10 = 6;
                    linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 6);
                    if (z6) {
                        if (z2) {
                            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
                            if (i4 > 0) {
                                linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i4, 6);
                            }
                            if (i5 < Integer.MAX_VALUE) {
                                linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i5, 6);
                            }
                        } else {
                            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i9, i10);
                        }
                        i11 = i7;
                        i13 = i23;
                        i14 = i22;
                        solverVariable4 = createObjectVariable6;
                        solverVariable3 = createObjectVariable5;
                        z9 = z6;
                        i15 = i8;
                    } else {
                        i11 = i7;
                        int i25 = i8;
                        if (i11 == -2) {
                            i11 = i9;
                        }
                        if (i25 == -2) {
                            i25 = i9;
                        }
                        if (i11 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i11, 6);
                            i9 = Math.max(i9, i11);
                        }
                        if (i25 > 0) {
                            linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i25, 6);
                            i9 = Math.min(i9, i25);
                        }
                        if (i23 != 1) {
                            z7 = z6;
                            if (i23 == 2) {
                                if (constraintAnchor.getType() != ConstraintAnchor.Type.TOP && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                                    createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                    createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                                } else {
                                    createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                    createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                                }
                                SolverVariable solverVariable10 = createObjectVariable;
                                solverVariable3 = createObjectVariable5;
                                i12 = i9;
                                i13 = i23;
                                i14 = i22;
                                i15 = i25;
                                solverVariable4 = createObjectVariable6;
                                linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, solverVariable10, f3));
                                z8 = false;
                                if (z8) {
                                }
                                z9 = z8;
                            }
                        } else if (z) {
                            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i9, 6);
                            i13 = i23;
                            i14 = i22;
                            solverVariable4 = createObjectVariable6;
                            solverVariable3 = createObjectVariable5;
                            z7 = z6;
                            i12 = i9;
                            i15 = i25;
                            z8 = z7;
                            if (z8 || i14 == 2 || z3) {
                                z9 = z8;
                            } else {
                                int max = Math.max(i11, i12);
                                if (i15 > 0) {
                                    max = Math.min(i15, max);
                                }
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 6);
                                z9 = false;
                            }
                        } else if (z4) {
                            z7 = z6;
                            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i9, 4);
                        } else {
                            z7 = z6;
                            linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i9, 1);
                        }
                        i13 = i23;
                        i14 = i22;
                        i15 = i25;
                        solverVariable4 = createObjectVariable6;
                        solverVariable3 = createObjectVariable5;
                        i12 = i9;
                        z8 = z7;
                        if (z8) {
                        }
                        z9 = z8;
                    }
                    if (z5 || z4) {
                        if (i14 < 2 || !z) {
                        }
                        linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 6);
                        linearSystem.addGreaterThan(solverVariable2, createObjectVariable4, 0, 6);
                        return;
                    }
                    if (isConnected || isConnected2 || isConnected3) {
                        if (!isConnected || isConnected2) {
                            if (!isConnected && isConnected2) {
                                linearSystem.addEquality(createObjectVariable4, solverVariable4, -constraintAnchor2.getMargin(), 6);
                                if (z) {
                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 5);
                                }
                            } else if (isConnected && isConnected2) {
                                if (z9) {
                                    solverVariable5 = solverVariable4;
                                    if (z && i4 == 0) {
                                        linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, 0, 6);
                                    }
                                    if (i13 == 0) {
                                        if (i15 > 0 || i11 > 0) {
                                            i20 = 4;
                                            z14 = true;
                                        } else {
                                            i20 = 6;
                                            z14 = false;
                                        }
                                        solverVariable6 = solverVariable3;
                                        linearSystem.addEquality(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), i20);
                                        linearSystem.addEquality(createObjectVariable4, solverVariable5, -constraintAnchor2.getMargin(), i20);
                                        z10 = i15 > 0 || i11 > 0;
                                        z11 = z14;
                                        i16 = 5;
                                    } else {
                                        int i26 = i13;
                                        solverVariable6 = solverVariable3;
                                        if (i26 == 1) {
                                            z10 = true;
                                            z11 = true;
                                            i16 = 6;
                                        } else if (i26 == 3) {
                                            int i27 = (z3 || this.mResolvedDimensionRatioSide == -1 || i15 > 0) ? 4 : 6;
                                            linearSystem.addEquality(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), i27);
                                            linearSystem.addEquality(createObjectVariable4, solverVariable5, -constraintAnchor2.getMargin(), i27);
                                            z10 = true;
                                            z11 = true;
                                            i16 = 5;
                                            if (z10) {
                                                solverVariable8 = solverVariable5;
                                                solverVariable7 = solverVariable6;
                                                solverVariable9 = createObjectVariable4;
                                                linearSystem.addCentering(createObjectVariable3, solverVariable6, constraintAnchor.getMargin(), f2, solverVariable5, createObjectVariable4, constraintAnchor2.getMargin(), i16);
                                                boolean z16 = constraintAnchor.mTarget.mOwner instanceof Barrier;
                                                boolean z17 = constraintAnchor2.mTarget.mOwner instanceof Barrier;
                                                if (z16 && !z17) {
                                                    z12 = z;
                                                    i17 = 6;
                                                    i18 = 5;
                                                    z13 = true;
                                                } else if (!z16 && z17) {
                                                    z13 = z;
                                                    i17 = 5;
                                                    i18 = 6;
                                                    z12 = true;
                                                }
                                                if (z11) {
                                                    i17 = 6;
                                                    i18 = 6;
                                                }
                                                if ((!z9 && z12) || z11) {
                                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable7, constraintAnchor.getMargin(), i18);
                                                }
                                                if ((!z9 && z13) || z11) {
                                                    linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                                }
                                                i19 = 0;
                                                if (z) {
                                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 6);
                                                }
                                                if (z) {
                                                    linearSystem.addGreaterThan(solverVariable2, solverVariable9, i19, 6);
                                                    return;
                                                }
                                                return;
                                            }
                                            solverVariable7 = solverVariable6;
                                            solverVariable8 = solverVariable5;
                                            solverVariable9 = createObjectVariable4;
                                            z12 = z;
                                            z13 = z12;
                                            i17 = 5;
                                            i18 = 5;
                                            if (z11) {
                                            }
                                            if (!z9) {
                                                linearSystem.addGreaterThan(createObjectVariable3, solverVariable7, constraintAnchor.getMargin(), i18);
                                                if (!z9) {
                                                    linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                                    i19 = 0;
                                                    if (z) {
                                                    }
                                                    if (z) {
                                                    }
                                                }
                                                linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                                i19 = 0;
                                                if (z) {
                                                }
                                                if (z) {
                                                }
                                            }
                                            linearSystem.addGreaterThan(createObjectVariable3, solverVariable7, constraintAnchor.getMargin(), i18);
                                            if (!z9) {
                                            }
                                            linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                            i19 = 0;
                                            if (z) {
                                            }
                                            if (z) {
                                            }
                                        } else {
                                            z10 = false;
                                        }
                                    }
                                    if (z10) {
                                    }
                                    z12 = z;
                                    z13 = z12;
                                    i17 = 5;
                                    i18 = 5;
                                    if (z11) {
                                    }
                                    if (!z9) {
                                    }
                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable7, constraintAnchor.getMargin(), i18);
                                    if (!z9) {
                                    }
                                    linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                    i19 = 0;
                                    if (z) {
                                    }
                                    if (z) {
                                    }
                                } else {
                                    solverVariable5 = solverVariable4;
                                    solverVariable6 = solverVariable3;
                                    z10 = true;
                                }
                                z11 = false;
                                i16 = 5;
                                if (z10) {
                                }
                                z12 = z;
                                z13 = z12;
                                i17 = 5;
                                i18 = 5;
                                if (z11) {
                                }
                                if (!z9) {
                                }
                                linearSystem.addGreaterThan(createObjectVariable3, solverVariable7, constraintAnchor.getMargin(), i18);
                                if (!z9) {
                                }
                                linearSystem.addLowerThan(solverVariable9, solverVariable8, -constraintAnchor2.getMargin(), i17);
                                i19 = 0;
                                if (z) {
                                }
                                if (z) {
                                }
                            }
                        } else if (z) {
                            linearSystem.addGreaterThan(solverVariable2, createObjectVariable4, 0, 5);
                        }
                    } else if (z) {
                        linearSystem.addGreaterThan(solverVariable2, createObjectVariable4, 0, 5);
                    }
                    solverVariable9 = createObjectVariable4;
                    i19 = 0;
                    if (z) {
                    }
                }
            }
            i10 = 6;
            if (z6) {
            }
            if (z5) {
            }
            if (i14 < 2) {
            }
        }
    }

    private boolean isChainHead(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:117:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0250 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        SolverVariable solverVariable;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        boolean z7;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        LinearSystem linearSystem2;
        boolean z8;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        int i6;
        int i7;
        int i8;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, linearSystem) != null) {
            return;
        }
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget2 = this.mParent;
        if (constraintWidget2 != null) {
            z = constraintWidget2 != null && constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget3 = this.mParent;
            boolean z9 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
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
            if (z && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (z9 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z2 = z9;
            z3 = isInHorizontalChain;
            z4 = isInVerticalChain;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i9 = this.mWidth;
        int i10 = this.mMinWidth;
        if (i9 < i10) {
            i9 = i10;
        }
        int i11 = this.mHeight;
        int i12 = this.mMinHeight;
        if (i11 < i12) {
            i11 = i12;
        }
        boolean z10 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z11 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f2 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f2;
        int i13 = this.mMatchConstraintDefaultWidth;
        int i14 = this.mMatchConstraintDefaultHeight;
        if (f2 <= 0.0f || this.mVisibility == 8) {
            solverVariable = createObjectVariable5;
            i2 = i13;
            i3 = i9;
            i4 = i11;
            i5 = i14;
            z5 = false;
        } else {
            solverVariable = createObjectVariable5;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i13 == 0) {
                i13 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i14 == 0) {
                i14 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2) {
                i8 = 3;
                if (i13 == 3 && i14 == 3) {
                    setupDimensionRatio(z, z2, z10, z11);
                    i2 = i13;
                    i3 = i9;
                    i4 = i11;
                    i5 = i14;
                    z5 = true;
                }
            } else {
                i8 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr2[0];
            DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour3 == dimensionBehaviour4 && i13 == i8) {
                this.mResolvedDimensionRatioSide = 0;
                DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr2[1];
                i3 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                if (dimensionBehaviour5 != dimensionBehaviour4) {
                    i4 = i11;
                    i5 = i14;
                    z5 = false;
                    i2 = 4;
                } else {
                    i2 = i13;
                    i4 = i11;
                    i5 = i14;
                    z5 = true;
                }
            } else {
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i14 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    DimensionBehaviour dimensionBehaviour6 = this.mListDimensionBehaviors[0];
                    DimensionBehaviour dimensionBehaviour7 = DimensionBehaviour.MATCH_CONSTRAINT;
                    i4 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                    i2 = i13;
                    i3 = i9;
                    if (dimensionBehaviour6 != dimensionBehaviour7) {
                        z5 = false;
                        i5 = 4;
                    }
                    i5 = i14;
                    z5 = true;
                }
                i2 = i13;
                i3 = i9;
                i4 = i11;
                i5 = i14;
                z5 = true;
            }
        }
        int[] iArr = this.mResolvedMatchConstraintDefault;
        iArr[0] = i2;
        iArr[1] = i5;
        if (z5 && ((i7 = this.mResolvedDimensionRatioSide) == 0 || i7 == -1)) {
            z6 = true;
            boolean z12 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
            boolean z13 = !this.mCenter.isConnected();
            if (this.mHorizontalResolution == 2) {
                ConstraintWidget constraintWidget4 = this.mParent;
                SolverVariable createObjectVariable6 = constraintWidget4 != null ? linearSystem.createObjectVariable(constraintWidget4.mRight) : null;
                ConstraintWidget constraintWidget5 = this.mParent;
                z7 = z2;
                solverVariable4 = solverVariable;
                solverVariable5 = createObjectVariable4;
                solverVariable2 = createObjectVariable3;
                boolean z14 = z12;
                solverVariable3 = createObjectVariable2;
                applyConstraints(linearSystem, z, constraintWidget5 != null ? linearSystem.createObjectVariable(constraintWidget5.mLeft) : null, createObjectVariable6, this.mListDimensionBehaviors[0], z14, this.mLeft, this.mRight, this.mX, i3, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z3, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z13);
            } else {
                solverVariable2 = createObjectVariable3;
                solverVariable3 = createObjectVariable2;
                z7 = z2;
                solverVariable4 = solverVariable;
                solverVariable5 = createObjectVariable4;
            }
            if (this.mVerticalResolution != 2) {
                return;
            }
            boolean z15 = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
            boolean z16 = z5 && ((i6 = this.mResolvedDimensionRatioSide) == 1 || i6 == -1);
            if (this.mBaselineDistance <= 0) {
                linearSystem2 = linearSystem;
            } else if (this.mBaseline.getResolutionNode().state == 1) {
                linearSystem2 = linearSystem;
                this.mBaseline.getResolutionNode().addResolvedValue(linearSystem2);
            } else {
                linearSystem2 = linearSystem;
                SolverVariable solverVariable7 = solverVariable4;
                solverVariable6 = solverVariable2;
                linearSystem2.addEquality(solverVariable7, solverVariable6, getBaselineDistance(), 6);
                ConstraintAnchor constraintAnchor = this.mBaseline.mTarget;
                if (constraintAnchor != null) {
                    linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(constraintAnchor), 0, 6);
                    z8 = false;
                    ConstraintWidget constraintWidget6 = this.mParent;
                    SolverVariable createObjectVariable7 = constraintWidget6 != null ? linearSystem2.createObjectVariable(constraintWidget6.mBottom) : null;
                    ConstraintWidget constraintWidget7 = this.mParent;
                    SolverVariable solverVariable8 = solverVariable6;
                    applyConstraints(linearSystem, z7, constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z15, this.mTop, this.mBottom, this.mY, i4, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z16, z4, i5, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                    if (z5) {
                        constraintWidget = this;
                        if (constraintWidget.mResolvedDimensionRatioSide == 1) {
                            linearSystem.addRatio(solverVariable5, solverVariable8, solverVariable3, createObjectVariable, constraintWidget.mResolvedDimensionRatio, 6);
                        } else {
                            linearSystem.addRatio(solverVariable3, createObjectVariable, solverVariable5, solverVariable8, constraintWidget.mResolvedDimensionRatio, 6);
                        }
                    } else {
                        constraintWidget = this;
                    }
                    if (constraintWidget.mCenter.isConnected()) {
                        linearSystem.addCenterPoint(constraintWidget, constraintWidget.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget.mCircleConstraintAngle + 90.0f), constraintWidget.mCenter.getMargin());
                        return;
                    }
                    return;
                }
                z8 = z13;
                ConstraintWidget constraintWidget62 = this.mParent;
                if (constraintWidget62 != null) {
                }
                ConstraintWidget constraintWidget72 = this.mParent;
                SolverVariable solverVariable82 = solverVariable6;
                applyConstraints(linearSystem, z7, constraintWidget72 != null ? linearSystem2.createObjectVariable(constraintWidget72.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z15, this.mTop, this.mBottom, this.mY, i4, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z16, z4, i5, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                if (z5) {
                }
                if (constraintWidget.mCenter.isConnected()) {
                }
            }
            solverVariable6 = solverVariable2;
            z8 = z13;
            ConstraintWidget constraintWidget622 = this.mParent;
            if (constraintWidget622 != null) {
            }
            ConstraintWidget constraintWidget722 = this.mParent;
            SolverVariable solverVariable822 = solverVariable6;
            applyConstraints(linearSystem, z7, constraintWidget722 != null ? linearSystem2.createObjectVariable(constraintWidget722.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z15, this.mTop, this.mBottom, this.mY, i4, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z16, z4, i5, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
            if (z5) {
            }
            if (constraintWidget.mCenter.isConnected()) {
            }
        }
        z6 = false;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        boolean z132 = !this.mCenter.isConnected();
        if (this.mHorizontalResolution == 2) {
        }
        if (this.mVerticalResolution != 2) {
        }
    }

    public boolean allowedInBarrier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVisibility != 8 : invokeV.booleanValue;
    }

    public void analyze(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Optimizer.analyze(i2, this);
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, constraintAnchor, constraintAnchor2, i2, i3) == null) {
            connect(constraintAnchor, constraintAnchor2, i2, ConstraintAnchor.Strength.STRONG, i3);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{constraintWidget, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
            immediateConnect(type, constraintWidget, type, i2, 0);
            this.mCircleConstraintAngle = f2;
        }
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, constraintWidget) == null) {
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linearSystem) == null) {
            linearSystem.createObjectVariable(this.mLeft);
            linearSystem.createObjectVariable(this.mTop);
            linearSystem.createObjectVariable(this.mRight);
            linearSystem.createObjectVariable(this.mBottom);
            if (this.mBaselineDistance > 0) {
                linearSystem.createObjectVariable(this.mBaseline);
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, constraintWidget) == null) {
            ArrayList<ConstraintAnchor> anchors = getAnchors();
            int size = anchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = anchors.get(i2);
                if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, constraintWidget) == null) {
            ArrayList<ConstraintAnchor> anchors = getAnchors();
            int size = anchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = anchors.get(i2);
                if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void forceUpdateDrawPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.mX;
            int i3 = this.mY;
            this.mDrawX = i2;
            this.mDrawY = i3;
            this.mDrawWidth = (this.mWidth + i2) - i2;
            this.mDrawHeight = (this.mHeight + i3) - i3;
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, type)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAnchors : (ArrayList) invokeV.objValue;
    }

    public int getBaselineDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mBaselineDistance : invokeV.intValue;
    }

    public float getBiasPercent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getY() + this.mHeight : invokeV.intValue;
    }

    public Object getCompanionWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mCompanionWidget : invokeV.objValue;
    }

    public int getContainerItemSkip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mContainerItemSkip : invokeV.intValue;
    }

    public String getDebugName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mDebugName : (String) invokeV.objValue;
    }

    public DimensionBehaviour getDimensionBehaviour(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mDimensionRatio : invokeV.floatValue;
    }

    public int getDimensionRatioSide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mDimensionRatioSide : invokeV.intValue;
    }

    public int getDrawBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getDrawY() + this.mDrawHeight : invokeV.intValue;
    }

    public int getDrawHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mDrawHeight : invokeV.intValue;
    }

    public int getDrawRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getDrawX() + this.mDrawWidth : invokeV.intValue;
    }

    public int getDrawWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mDrawWidth : invokeV.intValue;
    }

    public int getDrawX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mDrawX + this.mOffsetX : invokeV.intValue;
    }

    public int getDrawY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mDrawY + this.mOffsetY : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mHorizontalBiasPercent : invokeV.floatValue;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mHorizontalChainStyle : invokeV.intValue;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mListDimensionBehaviors[0] : (DimensionBehaviour) invokeV.objValue;
    }

    public int getInternalDrawBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mDrawY + this.mDrawHeight : invokeV.intValue;
    }

    public int getInternalDrawRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mDrawX + this.mDrawWidth : invokeV.intValue;
    }

    public int getInternalDrawX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mDrawX : invokeV.intValue;
    }

    public int getInternalDrawY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mDrawY : invokeV.intValue;
    }

    public int getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? getX() : invokeV.intValue;
    }

    public int getLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mMaxDimension[1] : invokeV.intValue;
    }

    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mMaxDimension[0] : invokeV.intValue;
    }

    public int getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mMinHeight : invokeV.intValue;
    }

    public int getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mMinWidth : invokeV.intValue;
    }

    public int getOptimizerWrapHeight() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mParent : (ConstraintWidget) invokeV.objValue;
    }

    public int getRelativePositioning(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
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

    public ResolutionDimension getResolutionHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.mResolutionHeight == null) {
                this.mResolutionHeight = new ResolutionDimension();
            }
            return this.mResolutionHeight;
        }
        return (ResolutionDimension) invokeV.objValue;
    }

    public ResolutionDimension getResolutionWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.mResolutionWidth == null) {
                this.mResolutionWidth = new ResolutionDimension();
            }
            return this.mResolutionWidth;
        }
        return (ResolutionDimension) invokeV.objValue;
    }

    public int getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? getX() + this.mWidth : invokeV.intValue;
    }

    public WidgetContainer getRootWidgetContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            ConstraintWidget constraintWidget = this;
            while (constraintWidget.getParent() != null) {
                constraintWidget = constraintWidget.getParent();
            }
            if (constraintWidget instanceof WidgetContainer) {
                return (WidgetContainer) constraintWidget;
            }
            return null;
        }
        return (WidgetContainer) invokeV.objValue;
    }

    public int getRootX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mX + this.mOffsetX : invokeV.intValue;
    }

    public int getRootY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mY + this.mOffsetY : invokeV.intValue;
    }

    public int getTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? getY() : invokeV.intValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    public float getVerticalBiasPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mVerticalBiasPercent : invokeV.floatValue;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mVerticalChainStyle : invokeV.intValue;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mListDimensionBehaviors[1] : (DimensionBehaviour) invokeV.objValue;
    }

    public int getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mVisibility : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.mVisibility == 8) {
                return 0;
            }
            return this.mWidth;
        }
        return invokeV.intValue;
    }

    public int getWrapHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mWrapHeight : invokeV.intValue;
    }

    public int getWrapWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mWrapWidth : invokeV.intValue;
    }

    public int getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mX : invokeV.intValue;
    }

    public int getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mY : invokeV.intValue;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, constraintWidget)) == null) {
            ConstraintWidget parent = getParent();
            if (parent == constraintWidget) {
                return true;
            }
            if (parent == constraintWidget.getParent()) {
                return false;
            }
            while (parent != null) {
                if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                    return true;
                }
                parent = parent.getParent();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean hasBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mBaselineDistance > 0 : invokeV.booleanValue;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{type, constraintWidget, type2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            getAnchor(type).connect(constraintWidget.getAnchor(type2), i2, i3, ConstraintAnchor.Strength.STRONG, 0, true);
        }
    }

    public boolean isFullyResolved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1 : invokeV.booleanValue;
    }

    public boolean isHeightWrapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mIsHeightWrapContent : invokeV.booleanValue;
    }

    public boolean isInHorizontalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
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

    public boolean isInVerticalChain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
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

    public boolean isInsideConstraintLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ConstraintWidget parent = getParent();
            if (parent == null) {
                return false;
            }
            while (parent != null) {
                if (parent instanceof ConstraintWidgetContainer) {
                    return true;
                }
                parent = parent.getParent();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.mParent == null : invokeV.booleanValue;
    }

    public boolean isRootContainer() {
        InterceptResult invokeV;
        ConstraintWidget constraintWidget;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? (this instanceof ConstraintWidgetContainer) && ((constraintWidget = this.mParent) == null || !(constraintWidget instanceof ConstraintWidgetContainer)) : invokeV.booleanValue;
    }

    public boolean isSpreadHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT : invokeV.booleanValue;
    }

    public boolean isSpreadWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT : invokeV.booleanValue;
    }

    public boolean isWidthWrapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.mIsWidthWrapContent : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
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
            this.mDrawX = 0;
            this.mDrawY = 0;
            this.mDrawWidth = 0;
            this.mDrawHeight = 0;
            this.mOffsetX = 0;
            this.mOffsetY = 0;
            this.mBaselineDistance = 0;
            this.mMinWidth = 0;
            this.mMinHeight = 0;
            this.mWrapWidth = 0;
            this.mWrapHeight = 0;
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
            this.mResolvedDimensionRatioSide = -1;
            this.mResolvedDimensionRatio = 1.0f;
            ResolutionDimension resolutionDimension = this.mResolutionWidth;
            if (resolutionDimension != null) {
                resolutionDimension.reset();
            }
            ResolutionDimension resolutionDimension2 = this.mResolutionHeight;
            if (resolutionDimension2 != null) {
                resolutionDimension2.reset();
            }
            this.mBelongingGroup = null;
            this.mOptimizerMeasurable = false;
            this.mOptimizerMeasured = false;
            this.mGroupsToSolver = false;
        }
    }

    public void resetAllConstraints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            resetAnchors();
            setVerticalBiasPercent(DEFAULT_BIAS);
            setHorizontalBiasPercent(DEFAULT_BIAS);
            if (this instanceof ConstraintWidgetContainer) {
                return;
            }
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getHeight() == getWrapHeight()) {
                    setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getHeight() > getMinHeight()) {
                    setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, constraintAnchor) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
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

    public void resetResolutionNodes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            for (int i2 = 0; i2 < 6; i2++) {
                this.mListAnchors[i2].getResolutionNode().reset();
            }
        }
    }

    public void resetSolverVariables(Cache cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, cache) == null) {
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

    public void resolve() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
        }
    }

    public void setBaselineDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
            this.mBaselineDistance = i2;
        }
    }

    public void setCompanionWidget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, obj) == null) {
            this.mCompanionWidget = obj;
        }
    }

    public void setContainerItemSkip(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i2) == null) {
            if (i2 >= 0) {
                this.mContainerItemSkip = i2;
            } else {
                this.mContainerItemSkip = 0;
            }
        }
    }

    public void setDebugName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.mDebugName = str;
        }
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, linearSystem, str) == null) {
            this.mDebugName = str;
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
            createObjectVariable.setName(str + ".left");
            createObjectVariable2.setName(str + ".top");
            createObjectVariable3.setName(str + ".right");
            createObjectVariable4.setName(str + ".bottom");
            if (this.mBaselineDistance > 0) {
                SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
                createObjectVariable5.setName(str + ".baseline");
            }
        }
    }

    public void setDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048672, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            int i2 = 0;
            if (str != null && str.length() != 0) {
                int i3 = -1;
                int length = str.length();
                int indexOf = str.indexOf(44);
                int i4 = 0;
                if (indexOf > 0 && indexOf < length - 1) {
                    String substring = str.substring(0, indexOf);
                    if (substring.equalsIgnoreCase("W")) {
                        i3 = 0;
                    } else if (substring.equalsIgnoreCase("H")) {
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

    public void setDrawHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            this.mDrawHeight = i2;
        }
    }

    public void setDrawOrigin(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048676, this, i2, i3) == null) {
            int i4 = i2 - this.mOffsetX;
            this.mDrawX = i4;
            int i5 = i3 - this.mOffsetY;
            this.mDrawY = i5;
            this.mX = i4;
            this.mY = i5;
        }
    }

    public void setDrawWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i2) == null) {
            this.mDrawWidth = i2;
        }
    }

    public void setDrawX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            int i3 = i2 - this.mOffsetX;
            this.mDrawX = i3;
            this.mX = i3;
        }
    }

    public void setDrawY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            int i3 = i2 - this.mOffsetY;
            this.mDrawY = i3;
            this.mY = i3;
        }
    }

    public void setFrame(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048681, this, i2, i3, i4, i5) == null) {
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
            this.mOptimizerMeasured = true;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048682, this, type, i2) == null) {
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

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            this.mHeight = i2;
            int i3 = this.mMinHeight;
            if (i2 < i3) {
                this.mHeight = i3;
            }
        }
    }

    public void setHeightWrapContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z) == null) {
            this.mIsHeightWrapContent = z;
        }
    }

    public void setHorizontalBiasPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048685, this, f2) == null) {
            this.mHorizontalBiasPercent = f2;
        }
    }

    public void setHorizontalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i2) == null) {
            this.mHorizontalChainStyle = i2;
        }
    }

    public void setHorizontalDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048687, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048688, this, dimensionBehaviour) == null) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour;
            if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                setWidth(this.mWrapWidth);
            }
        }
    }

    public void setHorizontalMatchStyle(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048689, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            this.mMatchConstraintDefaultWidth = i2;
            this.mMatchConstraintMinWidth = i3;
            this.mMatchConstraintMaxWidth = i4;
            this.mMatchConstraintPercentWidth = f2;
            if (f2 >= 1.0f || i2 != 0) {
                return;
            }
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048690, this, f2) == null) {
            this.mWeight[0] = f2;
        }
    }

    public void setLength(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048691, this, i2, i3) == null) {
            if (i3 == 0) {
                setWidth(i2);
            } else if (i3 == 1) {
                setHeight(i2);
            }
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i2) == null) {
            this.mMaxDimension[1] = i2;
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            this.mMaxDimension[0] = i2;
        }
    }

    public void setMinHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i2) == null) {
            if (i2 < 0) {
                this.mMinHeight = 0;
            } else {
                this.mMinHeight = i2;
            }
        }
    }

    public void setMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            if (i2 < 0) {
                this.mMinWidth = 0;
            } else {
                this.mMinWidth = i2;
            }
        }
    }

    public void setOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048696, this, i2, i3) == null) {
            this.mOffsetX = i2;
            this.mOffsetY = i3;
        }
    }

    public void setOrigin(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048697, this, i2, i3) == null) {
            this.mX = i2;
            this.mY = i3;
        }
    }

    public void setParent(ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, constraintWidget) == null) {
            this.mParent = constraintWidget;
        }
    }

    public void setRelativePositioning(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048699, this, i2, i3) == null) {
            if (i3 == 0) {
                this.mRelX = i2;
            } else if (i3 == 1) {
                this.mRelY = i2;
            }
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, str) == null) {
            this.mType = str;
        }
    }

    public void setVerticalBiasPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048701, this, f2) == null) {
            this.mVerticalBiasPercent = f2;
        }
    }

    public void setVerticalChainStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i2) == null) {
            this.mVerticalChainStyle = i2;
        }
    }

    public void setVerticalDimension(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048703, this, i2, i3) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048704, this, dimensionBehaviour) == null) {
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
            if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                setHeight(this.mWrapHeight);
            }
        }
    }

    public void setVerticalMatchStyle(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048705, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            this.mMatchConstraintDefaultHeight = i2;
            this.mMatchConstraintMinHeight = i3;
            this.mMatchConstraintMaxHeight = i4;
            this.mMatchConstraintPercentHeight = f2;
            if (f2 >= 1.0f || i2 != 0) {
                return;
            }
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048706, this, f2) == null) {
            this.mWeight[1] = f2;
        }
    }

    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            this.mVisibility = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            this.mWidth = i2;
            int i3 = this.mMinWidth;
            if (i2 < i3) {
                this.mWidth = i3;
            }
        }
    }

    public void setWidthWrapContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z) == null) {
            this.mIsWidthWrapContent = z;
        }
    }

    public void setWrapHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i2) == null) {
            this.mWrapHeight = i2;
        }
    }

    public void setWrapWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
            this.mWrapWidth = i2;
        }
    }

    public void setX(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i2) == null) {
            this.mX = i2;
        }
    }

    public void setY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i2) == null) {
            this.mY = i2;
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
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
                if (z && !z2) {
                    this.mResolvedDimensionRatioSide = 0;
                } else if (!z && z2) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatioSide = 1;
                }
            }
            if (this.mResolvedDimensionRatioSide == -1) {
                if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                    this.mResolvedDimensionRatioSide = 0;
                } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatioSide = 1;
                }
            }
            if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
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
            sb.append(") wrap: (");
            sb.append(this.mWrapWidth);
            sb.append(" x ");
            sb.append(this.mWrapHeight);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void updateDrawPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            int i2 = this.mX;
            int i3 = this.mY;
            this.mDrawX = i2;
            this.mDrawY = i3;
            this.mDrawWidth = (this.mWidth + i2) - i2;
            this.mDrawHeight = (this.mHeight + i3) - i3;
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, linearSystem) == null) {
            int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
            int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
            int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
            int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
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

    public void updateResolutionNodes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            for (int i2 = 0; i2 < 6; i2++) {
                this.mListAnchors[i2].getResolutionNode().update();
            }
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, constraintAnchor, constraintAnchor2, i2) == null) {
            connect(constraintAnchor, constraintAnchor2, i2, ConstraintAnchor.Strength.STRONG, 0);
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, ConstraintAnchor.Strength strength, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{constraintAnchor, constraintAnchor2, Integer.valueOf(i2), strength, Integer.valueOf(i3)}) == null) && constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i2, strength, i3);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, type, constraintWidget, type2, i2) == null) {
            connect(type, constraintWidget, type2, i2, ConstraintAnchor.Strength.STRONG);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, type, constraintWidget, type2) == null) {
            connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, ConstraintAnchor.Strength strength) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{type, constraintWidget, type2, Integer.valueOf(i2), strength}) == null) {
            connect(type, constraintWidget, type2, i2, strength, 0);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, ConstraintAnchor.Strength strength, int i3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{type, constraintWidget, type2, Integer.valueOf(i2), strength, Integer.valueOf(i3)}) == null) {
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
            int i4 = 0;
            if (type == type3) {
                if (type2 == type3) {
                    ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                    ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                    ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    boolean z2 = true;
                    if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                        connect(type4, constraintWidget, type4, 0, strength, i3);
                        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.RIGHT;
                        connect(type5, constraintWidget, type5, 0, strength, i3);
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.TOP;
                        connect(type6, constraintWidget, type6, 0, strength, i3);
                        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BOTTOM;
                        connect(type7, constraintWidget, type7, 0, strength, i3);
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, i3);
                    } else if (z) {
                        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i3);
                    } else if (z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i3);
                    }
                } else if (type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) {
                    if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                        connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0, strength, i3);
                        connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0, strength, i3);
                        getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
                    }
                } else {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0, strength, i3);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0, strength, i3);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i3);
                }
            } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor5.connect(anchor6, 0, i3);
                anchor7.connect(anchor6, 0, i3);
                getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i3);
            } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
                getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i3);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i3);
                getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i3);
            } else {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.CENTER_X;
                if (type == type8 && type2 == type8) {
                    getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, i3);
                    getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i3);
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i3);
                    return;
                }
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.CENTER_Y;
                if (type == type9 && type2 == type9) {
                    getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, i3);
                    getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i3);
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i3);
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
                    } else {
                        if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
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
                        i4 = i2;
                    }
                    anchor9.connect(anchor10, i4, strength, i3);
                    anchor10.getOwner().connectedTo(anchor9.getOwner());
                }
            }
        }
    }

    public void resetAnchors(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            ConstraintWidget parent = getParent();
            if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
                return;
            }
            int size = this.mAnchors.size();
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i3);
                if (i2 == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void setFrame(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048680, this, i2, i3, i4) == null) {
            if (i4 == 0) {
                setHorizontalDimension(i2, i3);
            } else if (i4 == 1) {
                setVerticalDimension(i2, i3);
            }
            this.mOptimizerMeasured = true;
        }
    }

    public void setDimensionRatio(float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            this.mDimensionRatio = f2;
            this.mDimensionRatioSide = i2;
        }
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
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
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
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
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
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        addAnchors();
        forceUpdateDrawPosition();
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
}
