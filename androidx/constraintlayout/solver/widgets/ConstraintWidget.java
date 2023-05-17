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
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ConstraintWidget {
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

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
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

    public ConstraintWidget() {
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
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
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

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public void setFinalHorizontal(int i, int i2) {
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.mX = i;
        this.mWidth = i2 - i;
        this.resolvedHorizontal = true;
    }

    public void setFinalVertical(int i, int i2) {
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        this.mBottom.mGoneMargin = i;
                        return;
                    }
                    return;
                }
                this.mRight.mGoneMargin = i;
                return;
            }
            this.mTop.mGoneMargin = i;
            return;
        }
        this.mLeft.mGoneMargin = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.mLastHorizontalMeasureSpec = i;
        this.mLastVerticalMeasureSpec = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
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
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
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
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    public ConstraintWidget(String str) {
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
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
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

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public ConstraintWidget(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Code restructure failed: missing block: B:242:0x0433, code lost:
        if ((r2 instanceof androidx.constraintlayout.solver.widgets.Barrier) != false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0558, code lost:
        if (r1[1] == r2) goto L287;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0528 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:361:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i9;
        int i10;
        int i11;
        boolean z12;
        int i12;
        SolverVariable solverVariable3;
        int i13;
        int i14;
        int i15;
        int i16;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        boolean z13;
        int i17;
        boolean z14;
        SolverVariable createObjectVariable;
        SolverVariable createObjectVariable2;
        boolean z15;
        boolean z16;
        ConstraintAnchor constraintAnchor3;
        int i18;
        SolverVariable solverVariable7;
        boolean z17;
        boolean z18;
        SolverVariable solverVariable8;
        int i19;
        boolean z19;
        int i20;
        int i21;
        int i22;
        boolean z20;
        SolverVariable solverVariable9;
        int i23;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable10;
        int i24;
        boolean z21;
        boolean z22;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable11;
        int i25;
        int i26;
        int i27;
        ConstraintWidget constraintWidget4;
        int i28;
        int i29;
        int i30;
        boolean z23;
        int i31;
        int i32;
        boolean z24;
        boolean z25;
        boolean z26;
        int i33;
        int i34;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable12;
        int i35;
        ConstraintWidget constraintWidget6;
        int i36 = i7;
        int i37 = i8;
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
        if (isConnected) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        if (isConnected2) {
            i9++;
        }
        if (isConnected3) {
            i9++;
        }
        int i38 = i9;
        if (z6) {
            i10 = 3;
        } else {
            i10 = i5;
        }
        int i39 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i39 == 1 || i39 == 2 || i39 == 3 || i39 != 4) {
            i11 = i10;
        } else {
            i11 = i10;
            if (i11 != 4) {
                z12 = true;
                if (this.mVisibility != 8) {
                    i12 = 0;
                    z12 = false;
                } else {
                    i12 = i2;
                }
                if (z11) {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable3, i);
                    } else if (isConnected && !isConnected2) {
                        solverVariable3 = createObjectVariable6;
                        linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 8);
                        if (!z12) {
                            if (z5) {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
                                if (i3 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i3, 8);
                                }
                                if (i4 < Integer.MAX_VALUE) {
                                    linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i4, 8);
                                }
                            } else {
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i12, 8);
                            }
                            i16 = i11;
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                            i13 = i38;
                            solverVariable6 = solverVariable3;
                            z14 = z4;
                        } else {
                            i13 = i38;
                            if (i13 != 2 && !z6 && (i11 == 1 || i11 == 0)) {
                                int max = Math.max(i36, i12);
                                if (i37 > 0) {
                                    max = Math.min(i37, max);
                                }
                                linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 8);
                                z14 = z4;
                                i17 = i36;
                                i16 = i11;
                                solverVariable4 = createObjectVariable5;
                                solverVariable5 = createObjectVariable4;
                                solverVariable6 = solverVariable3;
                                z13 = false;
                            } else {
                                if (i36 == -2) {
                                    i36 = i12;
                                }
                                if (i37 == -2) {
                                    i14 = i12;
                                } else {
                                    i14 = i37;
                                }
                                if (i12 > 0 && i11 != 1) {
                                    i12 = 0;
                                }
                                if (i36 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i36, 8);
                                    i12 = Math.max(i12, i36);
                                }
                                if (i14 > 0) {
                                    if (z2 && i11 == 1) {
                                        z15 = false;
                                    } else {
                                        z15 = true;
                                    }
                                    if (z15) {
                                        i15 = 8;
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i14, 8);
                                    } else {
                                        i15 = 8;
                                    }
                                    i12 = Math.min(i12, i14);
                                } else {
                                    i15 = 8;
                                }
                                if (i11 == 1) {
                                    if (z2) {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i12, i15);
                                    } else if (z8) {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i12, 5);
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i12, i15);
                                    } else {
                                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i12, 5);
                                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i12, i15);
                                    }
                                    z14 = z4;
                                    i37 = i14;
                                    i16 = i11;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    solverVariable6 = solverVariable3;
                                } else if (i11 == 2) {
                                    if (constraintAnchor.getType() != ConstraintAnchor.Type.TOP && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                                    } else {
                                        createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                        createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                                    }
                                    i16 = i11;
                                    solverVariable6 = solverVariable3;
                                    int i40 = i14;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, f2));
                                    i37 = i40;
                                    i17 = i36;
                                    z13 = false;
                                    z14 = z4;
                                } else {
                                    int i41 = i14;
                                    i16 = i11;
                                    solverVariable4 = createObjectVariable5;
                                    solverVariable5 = createObjectVariable4;
                                    solverVariable6 = solverVariable3;
                                    i37 = i41;
                                    z13 = z12;
                                    i17 = i36;
                                    z14 = true;
                                }
                            }
                            if (!z11 && !z8) {
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
                                        ConstraintWidget constraintWidget7 = constraintAnchor.mTarget.mOwner;
                                        ConstraintWidget constraintWidget8 = constraintAnchor2.mTarget.mOwner;
                                        ConstraintWidget parent = getParent();
                                        int i42 = 6;
                                        if (z13) {
                                            i18 = i16;
                                            if (i18 == 0) {
                                                if (i37 == 0 && i17 == 0) {
                                                    if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                        linearSystem.addEquality(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), 8);
                                                        linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                        return;
                                                    }
                                                    z24 = false;
                                                    z25 = true;
                                                    z26 = false;
                                                    i33 = 8;
                                                    i34 = 8;
                                                } else {
                                                    z24 = true;
                                                    z25 = false;
                                                    z26 = true;
                                                    i33 = 5;
                                                    i34 = 5;
                                                }
                                                if (!(constraintWidget7 instanceof Barrier) && !(constraintWidget8 instanceof Barrier)) {
                                                    solverVariable7 = solverVariable2;
                                                    z17 = z26;
                                                    i22 = i34;
                                                    i21 = 6;
                                                    z18 = z24;
                                                    i20 = i33;
                                                    z19 = z25;
                                                } else {
                                                    solverVariable7 = solverVariable2;
                                                    z17 = z26;
                                                    i20 = i33;
                                                    i21 = 6;
                                                    i22 = 4;
                                                    z18 = z24;
                                                    z19 = z25;
                                                }
                                            } else {
                                                if (i18 == 1) {
                                                    solverVariable7 = solverVariable2;
                                                    z17 = true;
                                                    z18 = true;
                                                    z19 = false;
                                                    i20 = 8;
                                                } else if (i18 == 3) {
                                                    if (this.mResolvedDimensionRatioSide == -1) {
                                                        if (z9) {
                                                            solverVariable7 = solverVariable2;
                                                            z17 = true;
                                                            z18 = true;
                                                            z19 = true;
                                                            i20 = 8;
                                                            if (z2) {
                                                                i21 = 5;
                                                            } else {
                                                                i21 = 4;
                                                            }
                                                        } else {
                                                            solverVariable7 = solverVariable2;
                                                            z17 = true;
                                                            z18 = true;
                                                            z19 = true;
                                                            i20 = 8;
                                                            i21 = 8;
                                                        }
                                                    } else if (z6) {
                                                        if (i6 != 2 && i6 != 1) {
                                                            z23 = false;
                                                            if (z23) {
                                                                i31 = 8;
                                                                i32 = 5;
                                                            } else {
                                                                i31 = 5;
                                                                i32 = 4;
                                                            }
                                                            i20 = i31;
                                                            i22 = i32;
                                                            z17 = true;
                                                            z18 = true;
                                                            z19 = true;
                                                            i21 = 6;
                                                            solverVariable7 = solverVariable2;
                                                        }
                                                        z23 = true;
                                                        if (z23) {
                                                        }
                                                        i20 = i31;
                                                        i22 = i32;
                                                        z17 = true;
                                                        z18 = true;
                                                        z19 = true;
                                                        i21 = 6;
                                                        solverVariable7 = solverVariable2;
                                                    } else if (i37 > 0) {
                                                        solverVariable7 = solverVariable2;
                                                        z17 = true;
                                                        z18 = true;
                                                        z19 = true;
                                                        i20 = 5;
                                                        i21 = 6;
                                                    } else if (i37 == 0 && i17 == 0) {
                                                        if (!z9) {
                                                            solverVariable7 = solverVariable2;
                                                            z17 = true;
                                                            z18 = true;
                                                            z19 = true;
                                                            i20 = 5;
                                                            i21 = 6;
                                                            i22 = 8;
                                                        } else {
                                                            if (constraintWidget7 != parent && constraintWidget8 != parent) {
                                                                i30 = 4;
                                                            } else {
                                                                i30 = 5;
                                                            }
                                                            solverVariable7 = solverVariable2;
                                                            i20 = i30;
                                                            z17 = true;
                                                            z18 = true;
                                                            z19 = true;
                                                        }
                                                    } else {
                                                        solverVariable7 = solverVariable2;
                                                        z17 = true;
                                                        z18 = true;
                                                        z19 = true;
                                                        i20 = 5;
                                                    }
                                                    i22 = 5;
                                                } else {
                                                    solverVariable7 = solverVariable2;
                                                    z17 = false;
                                                    z18 = false;
                                                }
                                                i21 = 6;
                                                i22 = 4;
                                            }
                                            if (!z17 && solverVariable4 == solverVariable6 && constraintWidget7 != parent) {
                                                z17 = false;
                                                z20 = false;
                                            } else {
                                                z20 = true;
                                            }
                                            if (!z18) {
                                                if (!z13 && !z7 && !z9 && solverVariable4 == solverVariable && solverVariable6 == solverVariable7) {
                                                    z21 = false;
                                                    i20 = 8;
                                                    i21 = 8;
                                                    z20 = false;
                                                } else {
                                                    z21 = z2;
                                                }
                                                solverVariable9 = solverVariable4;
                                                i24 = 8;
                                                i23 = i18;
                                                constraintWidget = parent;
                                                constraintWidget2 = constraintWidget8;
                                                solverVariable10 = createObjectVariable3;
                                                linearSystem.addCentering(createObjectVariable3, solverVariable9, constraintAnchor.getMargin(), f, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), i21);
                                            } else {
                                                solverVariable9 = solverVariable4;
                                                i23 = i18;
                                                constraintWidget = parent;
                                                constraintWidget2 = constraintWidget8;
                                                solverVariable10 = createObjectVariable3;
                                                i24 = 8;
                                                z21 = z2;
                                            }
                                            z22 = z20;
                                            if (this.mVisibility != i24 && !constraintAnchor2.hasDependents()) {
                                                return;
                                            }
                                            SolverVariable solverVariable13 = solverVariable9;
                                            if (!z17) {
                                                if (z21 && solverVariable13 != solverVariable6 && !z13) {
                                                    if (!(constraintWidget7 instanceof Barrier)) {
                                                        constraintWidget3 = constraintWidget2;
                                                    } else {
                                                        constraintWidget3 = constraintWidget2;
                                                    }
                                                    i29 = 6;
                                                    solverVariable11 = solverVariable10;
                                                    linearSystem.addGreaterThan(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i29);
                                                    linearSystem.addLowerThan(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i29);
                                                    i20 = i29;
                                                } else {
                                                    constraintWidget3 = constraintWidget2;
                                                }
                                                i29 = i20;
                                                solverVariable11 = solverVariable10;
                                                linearSystem.addGreaterThan(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i29);
                                                linearSystem.addLowerThan(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i29);
                                                i20 = i29;
                                            } else {
                                                constraintWidget3 = constraintWidget2;
                                                solverVariable11 = solverVariable10;
                                            }
                                            if (!z21 && z10 && !(constraintWidget7 instanceof Barrier) && !(constraintWidget3 instanceof Barrier)) {
                                                i25 = 6;
                                                i26 = 6;
                                                z22 = true;
                                            } else {
                                                i25 = i20;
                                                i26 = i22;
                                            }
                                            if (z22) {
                                                if (z19 && (!z9 || z3)) {
                                                    constraintWidget4 = constraintWidget;
                                                    if (constraintWidget7 != constraintWidget4 && constraintWidget3 != constraintWidget4) {
                                                        i42 = i26;
                                                    }
                                                    i42 = ((constraintWidget7 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) ? 5 : 5;
                                                    i42 = ((constraintWidget7 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) ? 5 : 5;
                                                    if (z9) {
                                                        i28 = 5;
                                                    } else {
                                                        i28 = i42;
                                                    }
                                                    i26 = Math.max(i28, i26);
                                                } else {
                                                    constraintWidget4 = constraintWidget;
                                                }
                                                if (z21) {
                                                    int min = Math.min(i25, i26);
                                                    if (z6 && !z9 && (constraintWidget7 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                        i26 = 4;
                                                    } else {
                                                        i26 = min;
                                                    }
                                                }
                                                linearSystem.addEquality(solverVariable11, solverVariable13, constraintAnchor.getMargin(), i26);
                                                linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), i26);
                                            }
                                            if (z21) {
                                                if (solverVariable == solverVariable13) {
                                                    i27 = constraintAnchor.getMargin();
                                                } else {
                                                    i27 = 0;
                                                }
                                                if (solverVariable13 != solverVariable) {
                                                    linearSystem.addGreaterThan(solverVariable11, solverVariable, i27, 5);
                                                }
                                            }
                                            if (z21 && z13 && i3 == 0 && i17 == 0) {
                                                if (!z13 && i23 == 3) {
                                                    linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, i24);
                                                } else {
                                                    linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, 5);
                                                }
                                            }
                                            if (z21 && z14) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i35 = constraintAnchor2.getMargin();
                                                    solverVariable12 = solverVariable2;
                                                } else {
                                                    solverVariable12 = solverVariable2;
                                                    i35 = 0;
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
                                                    linearSystem.addGreaterThan(solverVariable12, solverVariable5, i35, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        i18 = i16;
                                        if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                            linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), 8);
                                            if (z2 && z14) {
                                                if (constraintAnchor2.mTarget != null) {
                                                    i19 = constraintAnchor2.getMargin();
                                                    solverVariable8 = solverVariable2;
                                                } else {
                                                    solverVariable8 = solverVariable2;
                                                    i19 = 0;
                                                }
                                                if (solverVariable6 != solverVariable8) {
                                                    linearSystem.addGreaterThan(solverVariable8, solverVariable5, i19, 5);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        solverVariable7 = solverVariable2;
                                        z17 = true;
                                        z18 = true;
                                        z19 = false;
                                        i20 = 5;
                                        i21 = 6;
                                        i22 = 4;
                                        if (!z17) {
                                        }
                                        z20 = true;
                                        if (!z18) {
                                        }
                                        z22 = z20;
                                        if (this.mVisibility != i24) {
                                        }
                                        SolverVariable solverVariable132 = solverVariable9;
                                        if (!z17) {
                                        }
                                        if (!z21) {
                                        }
                                        i25 = i20;
                                        i26 = i22;
                                        if (z22) {
                                        }
                                        if (z21) {
                                        }
                                        if (z21) {
                                            if (!z13) {
                                            }
                                            linearSystem.addGreaterThan(solverVariable5, solverVariable11, 0, 5);
                                        }
                                        if (z21) {
                                            return;
                                        }
                                        return;
                                    }
                                }
                                z21 = z2;
                                if (z21) {
                                }
                            } else {
                                boolean z27 = true;
                                if (i13 >= 2 && z2 && z14) {
                                    linearSystem.addGreaterThan(createObjectVariable3, solverVariable, 0, 8);
                                    if (!z && this.mBaseline.mTarget != null) {
                                        z16 = false;
                                    } else {
                                        z16 = true;
                                    }
                                    if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                                        ConstraintWidget constraintWidget9 = constraintAnchor3.mOwner;
                                        if (constraintWidget9.mDimensionRatio != 0.0f) {
                                            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget9.mListDimensionBehaviors;
                                            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                                            DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                            if (dimensionBehaviour2 == dimensionBehaviour3) {
                                            }
                                        }
                                        z27 = false;
                                    } else {
                                        z27 = z16;
                                    }
                                    if (z27) {
                                        linearSystem.addGreaterThan(solverVariable2, solverVariable5, 0, 8);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        z13 = z12;
                        i17 = i36;
                        if (!z11) {
                        }
                        boolean z272 = true;
                        if (i13 >= 2) {
                            return;
                        }
                        return;
                    }
                }
                solverVariable3 = createObjectVariable6;
                if (!z12) {
                }
                z13 = z12;
                i17 = i36;
                if (!z11) {
                }
                boolean z2722 = true;
                if (i13 >= 2) {
                }
            }
        }
        z12 = false;
        if (this.mVisibility != 8) {
        }
        if (z11) {
        }
        solverVariable3 = createObjectVariable6;
        if (!z12) {
        }
        z13 = z12;
        i17 = i36;
        if (!z11) {
        }
        boolean z27222 = true;
        if (i13 >= 2) {
        }
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (constraintAnchorArr[i2].mTarget != null && constraintAnchorArr[i2].mTarget.mTarget != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        char c;
        if (i == 0) {
            c = 1;
        } else {
            c = 0;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
            return true;
        }
        return false;
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i) {
        boolean z;
        this.mBaselineDistance = i;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        this.hasBaseline = z;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setFinalBaseline(int i) {
        if (!this.hasBaseline) {
            return;
        }
        int i2 = i - this.mBaselineDistance;
        int i3 = this.mHeight + i2;
        this.mY = i2;
        this.mTop.setFinalValue(i2);
        this.mBottom.setFinalValue(i3);
        this.mBaseline.setFinalValue(i);
        this.resolvedVertical = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.mX = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.mY = i;
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    public boolean addFirst() {
        if (!(this instanceof VirtualLayout) && !(this instanceof Guideline)) {
            return false;
        }
        return true;
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i + constraintAnchor2.mMargin;
        }
        return i;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i = Math.max(this.mMatchConstraintMinHeight, i2);
            } else {
                i = this.mMatchConstraintMinHeight;
                if (i > 0) {
                    this.mHeight = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxHeight;
            if (i3 > 0 && i3 < i) {
                return i3;
            }
            return i;
        }
        return i2;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                i = Math.max(this.mMatchConstraintMinWidth, i2);
            } else {
                i = this.mMatchConstraintMinWidth;
                if (i > 0) {
                    this.mWidth = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxWidth;
            if (i3 > 0 && i3 < i) {
                return i3;
            }
            return i;
        }
        return i2;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return i + this.mBottom.mMargin;
        }
        return i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
        }
        return this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
        }
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            if (this.mAnchors.get(i).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        if (this.mMeasureRequested && this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public boolean isResolvedHorizontally() {
        if (!this.resolvedHorizontal && (!this.mLeft.hasFinalValue() || !this.mRight.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isResolvedVertically() {
        if (!this.resolvedVertical && (!this.mTop.hasFinalValue() || !this.mBottom.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth != 0 || this.mDimensionRatio != 0.0f || this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMaxWidth != 0 || this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        return true;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return false;
        }
        return true;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int size = this.mAnchors.size();
        for (int i = 0; i < size; i++) {
            this.mAnchors.get(i).resetFinalResolution();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x05d3  */
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
        boolean z6;
        boolean z7;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z8;
        int i5;
        boolean z9;
        boolean z10;
        boolean z11;
        int i6;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i7;
        int i8;
        char c;
        ConstraintWidget constraintWidget3;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        boolean z17;
        boolean z18;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget4;
        boolean z19;
        SolverVariable solverVariable11;
        SolverVariable solverVariable12;
        boolean z20;
        DimensionBehaviour[] dimensionBehaviourArr;
        boolean z21;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget6;
        SolverVariable solverVariable14;
        DimensionBehaviour[] dimensionBehaviourArr2;
        boolean z22;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode;
        int i9;
        int i10;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun;
        boolean z23;
        boolean z24;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget7 = this.mParent;
        if (constraintWidget7 != null) {
            if (constraintWidget7 != null && constraintWidget7.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
                z23 = true;
            } else {
                z23 = false;
            }
            ConstraintWidget constraintWidget8 = this.mParent;
            if (constraintWidget8 != null && constraintWidget8.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT) {
                z24 = true;
            } else {
                z24 = false;
            }
            z2 = z23;
            z3 = z24;
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
        int i11 = this.mWidth;
        int i12 = this.mMinWidth;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = this.mHeight;
        int i14 = this.mMinHeight;
        if (i13 < i14) {
            i13 = i14;
        }
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i15 = this.mMatchConstraintDefaultWidth;
        int i16 = this.mMatchConstraintDefaultHeight;
        int i17 = i11;
        if (f > 0.0f && this.mVisibility != 8) {
            int i18 = i13;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 0) {
                i15 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 0) {
                i16 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr3[0];
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr3[1] == dimensionBehaviour2) {
                i10 = 3;
                if (i15 == 3 && i16 == 3) {
                    setupDimensionRatio(z2, z3, z6, z7);
                    i = i16;
                    i2 = i15;
                    i3 = i17;
                    i4 = i18;
                    z8 = true;
                }
            } else {
                i10 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr4 = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr4[0];
            DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour3 == dimensionBehaviour4 && i15 == i10) {
                this.mResolvedDimensionRatioSide = 0;
                i3 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                i = i16;
                if (dimensionBehaviourArr4[1] != dimensionBehaviour4) {
                    i4 = i18;
                    z8 = false;
                    i2 = 4;
                } else {
                    i2 = i15;
                    i4 = i18;
                    z8 = true;
                }
            } else {
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    i4 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i2 = i15;
                        i3 = i17;
                        z8 = false;
                        i = 4;
                    } else {
                        i = i16;
                        i2 = i15;
                        i3 = i17;
                        z8 = true;
                    }
                }
                i = i16;
                i2 = i15;
                i3 = i17;
                i4 = i18;
                z8 = true;
            }
        } else {
            i = i16;
            i2 = i15;
            i3 = i17;
            i4 = i13;
            z8 = false;
        }
        int[] iArr = this.mResolvedMatchConstraintDefault;
        iArr[0] = i2;
        iArr[1] = i;
        this.mResolvedHasRatio = z8;
        if (z8) {
            int i19 = this.mResolvedDimensionRatioSide;
            i5 = -1;
            if (i19 == 0 || i19 == -1) {
                z9 = true;
                if (!z8 && ((i9 = this.mResolvedDimensionRatioSide) == 1 || i9 == i5)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    i6 = 0;
                } else {
                    i6 = i3;
                }
                z12 = !this.mCenter.isConnected();
                boolean[] zArr2 = this.mIsInBarrier;
                z13 = zArr2[0];
                boolean z25 = zArr2[1];
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
                    constraintWidget5 = this.mParent;
                    if (constraintWidget5 == null) {
                        solverVariable13 = linearSystem.createObjectVariable(constraintWidget5.mRight);
                    } else {
                        solverVariable13 = null;
                    }
                    constraintWidget6 = this.mParent;
                    if (constraintWidget6 == null) {
                        solverVariable14 = linearSystem.createObjectVariable(constraintWidget6.mLeft);
                    } else {
                        solverVariable14 = null;
                    }
                    boolean z26 = this.isTerminalWidget[0];
                    dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                    DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr2[0];
                    ConstraintAnchor constraintAnchor = this.mLeft;
                    ConstraintAnchor constraintAnchor2 = this.mRight;
                    int i20 = this.mX;
                    int i21 = this.mMinWidth;
                    int i22 = this.mMaxDimension[0];
                    float f2 = this.mHorizontalBiasPercent;
                    if (dimensionBehaviourArr2[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z14 = z2;
                    z15 = z3;
                    z16 = z8;
                    solverVariable = createObjectVariable5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    solverVariable5 = createObjectVariable;
                    applyConstraints(linearSystem, true, z2, z3, z26, solverVariable14, solverVariable13, dimensionBehaviour5, z11, constraintAnchor, constraintAnchor2, i20, i6, i21, i22, f2, z9, z22, z5, z4, z13, i2, i, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z12);
                    if (!z) {
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
                                if (constraintWidget9 != null && !z4 && z15) {
                                    c = 1;
                                    if (constraintWidget3.isTerminalWidget[1]) {
                                        i7 = 8;
                                        i8 = 0;
                                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget9.mBottom), solverVariable7, 0, 8);
                                    } else {
                                        i7 = 8;
                                        i8 = 0;
                                    }
                                } else {
                                    i7 = 8;
                                    i8 = 0;
                                    c = 1;
                                }
                                z17 = false;
                                if (constraintWidget3.mVerticalResolution == 2) {
                                    z18 = false;
                                } else {
                                    z18 = z17;
                                }
                                if (!z18 && !constraintWidget3.resolvedVertical) {
                                    if (constraintWidget3.mListDimensionBehaviors[c] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget3 instanceof ConstraintWidgetContainer)) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19) {
                                        i4 = 0;
                                    }
                                    ConstraintWidget constraintWidget10 = constraintWidget3.mParent;
                                    if (constraintWidget10 != null) {
                                        solverVariable11 = linearSystem2.createObjectVariable(constraintWidget10.mBottom);
                                    } else {
                                        solverVariable11 = null;
                                    }
                                    ConstraintWidget constraintWidget11 = constraintWidget3.mParent;
                                    if (constraintWidget11 != null) {
                                        solverVariable12 = linearSystem2.createObjectVariable(constraintWidget11.mTop);
                                    } else {
                                        solverVariable12 = null;
                                    }
                                    if (constraintWidget3.mBaselineDistance > 0 || constraintWidget3.mVisibility == i7) {
                                        if (constraintWidget3.mBaseline.mTarget != null) {
                                            linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i7);
                                            linearSystem2.addEquality(solverVariable6, linearSystem2.createObjectVariable(constraintWidget3.mBaseline.mTarget), i8, i7);
                                            if (z15) {
                                                linearSystem2.addGreaterThan(solverVariable11, linearSystem2.createObjectVariable(constraintWidget3.mBottom), i8, 5);
                                            }
                                            z20 = false;
                                            boolean z27 = constraintWidget3.isTerminalWidget[c];
                                            dimensionBehaviourArr = constraintWidget3.mListDimensionBehaviors;
                                            DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[c];
                                            ConstraintAnchor constraintAnchor3 = constraintWidget3.mTop;
                                            ConstraintAnchor constraintAnchor4 = constraintWidget3.mBottom;
                                            int i23 = constraintWidget3.mY;
                                            int i24 = constraintWidget3.mMinHeight;
                                            int i25 = constraintWidget3.mMaxDimension[c];
                                            float f3 = constraintWidget3.mVerticalBiasPercent;
                                            if (dimensionBehaviourArr[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                                z21 = true;
                                            } else {
                                                z21 = false;
                                            }
                                            solverVariable9 = solverVariable7;
                                            solverVariable10 = solverVariable8;
                                            applyConstraints(linearSystem, false, z15, z14, z27, solverVariable12, solverVariable11, dimensionBehaviour6, z19, constraintAnchor3, constraintAnchor4, i23, i4, i24, i25, f3, z10, z21, z4, z5, z25, i, i2, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z20);
                                        } else if (constraintWidget3.mVisibility == i7) {
                                            linearSystem2.addEquality(solverVariable6, solverVariable8, i8, i7);
                                        } else {
                                            linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i7);
                                        }
                                    }
                                    z20 = z12;
                                    boolean z272 = constraintWidget3.isTerminalWidget[c];
                                    dimensionBehaviourArr = constraintWidget3.mListDimensionBehaviors;
                                    DimensionBehaviour dimensionBehaviour62 = dimensionBehaviourArr[c];
                                    ConstraintAnchor constraintAnchor32 = constraintWidget3.mTop;
                                    ConstraintAnchor constraintAnchor42 = constraintWidget3.mBottom;
                                    int i232 = constraintWidget3.mY;
                                    int i242 = constraintWidget3.mMinHeight;
                                    int i252 = constraintWidget3.mMaxDimension[c];
                                    float f32 = constraintWidget3.mVerticalBiasPercent;
                                    if (dimensionBehaviourArr[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                                    }
                                    solverVariable9 = solverVariable7;
                                    solverVariable10 = solverVariable8;
                                    applyConstraints(linearSystem, false, z15, z14, z272, solverVariable12, solverVariable11, dimensionBehaviour62, z19, constraintAnchor32, constraintAnchor42, i232, i4, i242, i252, f32, z10, z21, z4, z5, z25, i, i2, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z20);
                                } else {
                                    solverVariable9 = solverVariable7;
                                    solverVariable10 = solverVariable8;
                                }
                                if (z16) {
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
                        i7 = 8;
                        i8 = 0;
                        c = 1;
                    } else {
                        i7 = 8;
                        i8 = 0;
                        c = 1;
                        constraintWidget3 = this;
                        linearSystem2 = linearSystem;
                        solverVariable6 = solverVariable;
                        solverVariable7 = solverVariable2;
                        solverVariable8 = solverVariable3;
                    }
                    z17 = true;
                    if (constraintWidget3.mVerticalResolution == 2) {
                    }
                    if (!z18) {
                    }
                    solverVariable9 = solverVariable7;
                    solverVariable10 = solverVariable8;
                    if (z16) {
                    }
                    if (constraintWidget4.mCenter.isConnected()) {
                    }
                    constraintWidget4.resolvedHorizontal = false;
                    constraintWidget4.resolvedVertical = false;
                }
                z14 = z2;
                z15 = z3;
                z16 = z8;
                solverVariable = createObjectVariable5;
                solverVariable2 = createObjectVariable4;
                solverVariable3 = createObjectVariable3;
                solverVariable4 = createObjectVariable2;
                solverVariable5 = createObjectVariable;
                if (!z) {
                }
                z17 = true;
                if (constraintWidget3.mVerticalResolution == 2) {
                }
                if (!z18) {
                }
                solverVariable9 = solverVariable7;
                solverVariable10 = solverVariable8;
                if (z16) {
                }
                if (constraintWidget4.mCenter.isConnected()) {
                }
                constraintWidget4.resolvedHorizontal = false;
                constraintWidget4.resolvedVertical = false;
            }
        } else {
            i5 = -1;
        }
        z9 = false;
        if (!z8) {
        }
        z10 = false;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        z11 = false;
        if (!z11) {
        }
        z12 = !this.mCenter.isConnected();
        boolean[] zArr22 = this.mIsInBarrier;
        z13 = zArr22[0];
        boolean z252 = zArr22[1];
        if (this.mHorizontalResolution != 2) {
            if (z) {
                dependencyNode = horizontalWidgetRun.start;
                if (dependencyNode.resolved) {
                    if (z) {
                    }
                }
            }
            constraintWidget5 = this.mParent;
            if (constraintWidget5 == null) {
            }
            constraintWidget6 = this.mParent;
            if (constraintWidget6 == null) {
            }
            boolean z262 = this.isTerminalWidget[0];
            dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour52 = dimensionBehaviourArr2[0];
            ConstraintAnchor constraintAnchor5 = this.mLeft;
            ConstraintAnchor constraintAnchor22 = this.mRight;
            int i202 = this.mX;
            int i212 = this.mMinWidth;
            int i222 = this.mMaxDimension[0];
            float f22 = this.mHorizontalBiasPercent;
            if (dimensionBehaviourArr2[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            z14 = z2;
            z15 = z3;
            z16 = z8;
            solverVariable = createObjectVariable5;
            solverVariable2 = createObjectVariable4;
            solverVariable3 = createObjectVariable3;
            solverVariable4 = createObjectVariable2;
            solverVariable5 = createObjectVariable;
            applyConstraints(linearSystem, true, z2, z3, z262, solverVariable14, solverVariable13, dimensionBehaviour52, z11, constraintAnchor5, constraintAnchor22, i202, i6, i212, i222, f22, z9, z22, z5, z4, z13, i2, i, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z12);
            if (!z) {
            }
            z17 = true;
            if (constraintWidget3.mVerticalResolution == 2) {
            }
            if (!z18) {
            }
            solverVariable9 = solverVariable7;
            solverVariable10 = solverVariable8;
            if (z16) {
            }
            if (constraintWidget4.mCenter.isConnected()) {
            }
            constraintWidget4.resolvedHorizontal = false;
            constraintWidget4.resolvedVertical = false;
        }
        z14 = z2;
        z15 = z3;
        z16 = z8;
        solverVariable = createObjectVariable5;
        solverVariable2 = createObjectVariable4;
        solverVariable3 = createObjectVariable3;
        solverVariable4 = createObjectVariable2;
        solverVariable5 = createObjectVariable;
        if (!z) {
        }
        z17 = true;
        if (constraintWidget3.mVerticalResolution == 2) {
        }
        if (!z18) {
        }
        solverVariable9 = solverVariable7;
        solverVariable10 = solverVariable8;
        if (z16) {
        }
        if (constraintWidget4.mCenter.isConnected()) {
        }
        constraintWidget4.resolvedHorizontal = false;
        constraintWidget4.resolvedVertical = false;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
        if (type == type3) {
            if (type2 == type3) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor != null && anchor.isConnected()) || (anchor2 != null && anchor2.isConnected())) {
                    z = false;
                } else {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                    connect(type4, constraintWidget, type4, 0);
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.RIGHT;
                    connect(type5, constraintWidget, type5, 0);
                    z = true;
                }
                if ((anchor3 != null && anchor3.isConnected()) || (anchor4 != null && anchor4.isConnected())) {
                    z2 = false;
                } else {
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.TOP;
                    connect(type6, constraintWidget, type6, 0);
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BOTTOM;
                    connect(type7, constraintWidget, type7, 0);
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
                    i = 0;
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
                anchor9.connect(anchor10, i);
            }
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
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
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
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
        ConstraintWidget constraintWidget5 = constraintWidget.mHorizontalNextWidget;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.mHorizontalNextWidget = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.mVerticalNextWidget = constraintWidget4;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
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

    public boolean hasDanglingDimension(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == 0) {
            if (this.mLeft.mTarget != null) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.mRight.mTarget != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if (i5 + i6 < 2) {
                return true;
            }
            return false;
        }
        if (this.mTop.mTarget != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i7 = i2 + i3;
        if (this.mBaseline.mTarget != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i7 + i4 < 2) {
            return true;
        }
        return false;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public void reset() {
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
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
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

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
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

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
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

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.mX = i3;
        }
        if (isResolved2) {
            this.mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
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
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    public void setDimensionRatio(String str) {
        float f;
        int i = 0;
        if (str != null && str.length() != 0) {
            int i2 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase(IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i3, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i2 == 1) {
                            f = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f = 0.0f;
            } else {
                String substring4 = str.substring(i3);
                if (substring4.length() > 0) {
                    f = Float.parseFloat(substring4);
                }
                f = 0.0f;
            }
            i = (f > i ? 1 : (f == i ? 0 : -1));
            if (i > 0) {
                this.mDimensionRatio = f;
                this.mDimensionRatioSide = i2;
                return;
            }
            return;
        }
        this.mDimensionRatio = 0.0f;
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i6 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i6 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mWidth;
        int i11 = this.mMinWidth;
        if (i10 < i11) {
            this.mWidth = i11;
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f > 0.0f && f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
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
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType == null) {
            str = "";
        } else {
            str = "type: " + this.mType + " ";
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
}
