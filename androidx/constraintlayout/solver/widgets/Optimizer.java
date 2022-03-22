package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Optimizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_CHAIN_DANGLING = 1;
    public static final int FLAG_RECOMPUTE_BOUNDS = 2;
    public static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    public static boolean[] flags;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343398412, "Landroidx/constraintlayout/solver/widgets/Optimizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343398412, "Landroidx/constraintlayout/solver/widgets/Optimizer;");
                return;
            }
        }
        flags = new boolean[3];
    }

    public Optimizer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void analyze(int i, ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, constraintWidget) == null) {
            constraintWidget.updateResolutionNodes();
            ResolutionAnchor resolutionNode = constraintWidget.mLeft.getResolutionNode();
            ResolutionAnchor resolutionNode2 = constraintWidget.mTop.getResolutionNode();
            ResolutionAnchor resolutionNode3 = constraintWidget.mRight.getResolutionNode();
            ResolutionAnchor resolutionNode4 = constraintWidget.mBottom.getResolutionNode();
            boolean z = (i & 8) == 8;
            boolean z2 = constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0);
            if (resolutionNode.type != 4 && resolutionNode3.type != 4) {
                if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                    if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                        resolutionNode.setType(1);
                        resolutionNode3.setType(1);
                        if (z) {
                            resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                        }
                    } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                        resolutionNode.setType(1);
                        resolutionNode3.setType(1);
                        if (z) {
                            resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                        }
                    } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                        resolutionNode.setType(1);
                        resolutionNode3.setType(1);
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                        if (z) {
                            resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                        }
                    } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                        resolutionNode.setType(2);
                        resolutionNode3.setType(2);
                        if (z) {
                            constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                            constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                            resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode.setOpposite(resolutionNode3, -constraintWidget.getWidth());
                            resolutionNode3.setOpposite(resolutionNode, constraintWidget.getWidth());
                        }
                    }
                } else if (z2) {
                    int width = constraintWidget.getWidth();
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                        if (z) {
                            resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode3.dependsOn(resolutionNode, width);
                        }
                    } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                        if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                            if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                                if (z) {
                                    constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                    constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                                }
                                if (constraintWidget.mDimensionRatio == 0.0f) {
                                    resolutionNode.setType(3);
                                    resolutionNode3.setType(3);
                                    resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                    resolutionNode3.setOpposite(resolutionNode, 0.0f);
                                } else {
                                    resolutionNode.setType(2);
                                    resolutionNode3.setType(2);
                                    resolutionNode.setOpposite(resolutionNode3, -width);
                                    resolutionNode3.setOpposite(resolutionNode, width);
                                    constraintWidget.setWidth(width);
                                }
                            }
                        } else if (z) {
                            resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        } else {
                            resolutionNode.dependsOn(resolutionNode3, -width);
                        }
                    } else if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                }
            }
            boolean z3 = constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1);
            if (resolutionNode2.type == 4 || resolutionNode4.type == 4) {
                return;
            }
            if (constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.FIXED && (!z3 || constraintWidget.getVisibility() != 8)) {
                if (z3) {
                    int height = constraintWidget.getHeight();
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                        if (z) {
                            resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        } else {
                            resolutionNode4.dependsOn(resolutionNode2, height);
                        }
                    } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                        if (z) {
                            resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        } else {
                            resolutionNode4.dependsOn(resolutionNode2, height);
                        }
                    } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                        if (z) {
                            resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        } else {
                            resolutionNode2.dependsOn(resolutionNode4, -height);
                        }
                    } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) {
                    } else {
                        if (z) {
                            constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                            constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                        }
                        if (constraintWidget.mDimensionRatio == 0.0f) {
                            resolutionNode2.setType(3);
                            resolutionNode4.setType(3);
                            resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                            resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                            return;
                        }
                        resolutionNode2.setType(2);
                        resolutionNode4.setType(2);
                        resolutionNode2.setOpposite(resolutionNode4, -height);
                        resolutionNode4.setOpposite(resolutionNode2, height);
                        constraintWidget.setHeight(height);
                        if (constraintWidget.mBaselineDistance > 0) {
                            constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                        }
                    }
                }
            } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                }
                ConstraintAnchor constraintAnchor = constraintWidget.mBaseline;
                if (constraintAnchor.mTarget != null) {
                    constraintAnchor.getResolutionNode().setType(1);
                    resolutionNode2.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                }
            } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance > 0) {
                    constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                }
            } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (z) {
                    resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance > 0) {
                    constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                }
            } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) {
            } else {
                resolutionNode2.setType(2);
                resolutionNode4.setType(2);
                if (z) {
                    resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                    constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                } else {
                    resolutionNode2.setOpposite(resolutionNode4, -constraintWidget.getHeight());
                    resolutionNode4.setOpposite(resolutionNode2, constraintWidget.getHeight());
                }
                if (constraintWidget.mBaselineDistance > 0) {
                    constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r7.mHorizontalChainStyle == 2) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
        if (r7.mVerticalChainStyle == 2) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x010b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0108 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        boolean z3;
        ResolutionAnchor resolutionAnchor;
        float margin;
        int height;
        int height2;
        float f2;
        ConstraintWidget constraintWidget;
        boolean z4;
        int height3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{constraintWidgetContainer, linearSystem, Integer.valueOf(i), Integer.valueOf(i2), chainHead})) != null) {
            return invokeCommon.booleanValue;
        }
        ConstraintWidget constraintWidget2 = chainHead.mFirst;
        ConstraintWidget constraintWidget3 = chainHead.mLast;
        ConstraintWidget constraintWidget4 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget6 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget7 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget8 = chainHead.mLastMatchConstraintWidget;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.mListDimensionBehaviors[i];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget6.mHorizontalChainStyle == 0;
            z2 = constraintWidget6.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget6.mVerticalChainStyle == 0;
            z2 = constraintWidget6.mVerticalChainStyle == 1;
        }
        ConstraintWidget constraintWidget9 = constraintWidget2;
        int i3 = 0;
        boolean z5 = false;
        int i4 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (!z5) {
            if (constraintWidget9.getVisibility() != 8) {
                i4++;
                if (i == 0) {
                    height3 = constraintWidget9.getWidth();
                } else {
                    height3 = constraintWidget9.getHeight();
                }
                f4 += height3;
                if (constraintWidget9 != constraintWidget4) {
                    f4 += constraintWidget9.mListAnchors[i2].getMargin();
                }
                if (constraintWidget9 != constraintWidget5) {
                    f4 += constraintWidget9.mListAnchors[i2 + 1].getMargin();
                }
                f5 = f5 + constraintWidget9.mListAnchors[i2].getMargin() + constraintWidget9.mListAnchors[i2 + 1].getMargin();
            }
            ConstraintAnchor constraintAnchor = constraintWidget9.mListAnchors[i2];
            if (constraintWidget9.getVisibility() != 8 && constraintWidget9.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i3++;
                if (i == 0) {
                    if (constraintWidget9.mMatchConstraintDefaultWidth != 0) {
                        return false;
                    }
                    z4 = false;
                    if (constraintWidget9.mMatchConstraintMinWidth != 0 || constraintWidget9.mMatchConstraintMaxWidth != 0) {
                        return false;
                    }
                } else {
                    z4 = false;
                    if (constraintWidget9.mMatchConstraintDefaultHeight != 0) {
                        return false;
                    }
                    if (constraintWidget9.mMatchConstraintMinHeight == 0) {
                        if (constraintWidget9.mMatchConstraintMaxHeight != 0) {
                        }
                    }
                    return z4;
                }
                if (constraintWidget9.mDimensionRatio != 0.0f) {
                    return z4;
                }
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget9.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor2 != null) {
                ConstraintWidget constraintWidget10 = constraintAnchor2.mOwner;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget10.mListAnchors;
                if (constraintAnchorArr[i2].mTarget != null && constraintAnchorArr[i2].mTarget.mOwner == constraintWidget9) {
                    constraintWidget = constraintWidget10;
                    if (constraintWidget == null) {
                        constraintWidget9 = constraintWidget;
                    } else {
                        z5 = true;
                    }
                }
            }
            constraintWidget = null;
            if (constraintWidget == null) {
            }
        }
        ResolutionAnchor resolutionNode = constraintWidget2.mListAnchors[i2].getResolutionNode();
        int i5 = i2 + 1;
        ResolutionAnchor resolutionNode2 = constraintWidget3.mListAnchors[i5].getResolutionNode();
        ResolutionAnchor resolutionAnchor2 = resolutionNode.target;
        if (resolutionAnchor2 == null || (resolutionAnchor = resolutionNode2.target) == null || resolutionAnchor2.state != 1 || resolutionAnchor.state != 1) {
            return false;
        }
        if (i3 > 0 && i3 != i4) {
            return false;
        }
        if (z3 || z || z2) {
            margin = constraintWidget4 != null ? constraintWidget4.mListAnchors[i2].getMargin() : 0.0f;
            if (constraintWidget5 != null) {
                margin += constraintWidget5.mListAnchors[i5].getMargin();
            }
        } else {
            margin = 0.0f;
        }
        float f6 = resolutionNode.target.resolvedOffset;
        float f7 = resolutionNode2.target.resolvedOffset;
        float f8 = (f6 < f7 ? f7 - f6 : f6 - f7) - f4;
        if (i3 > 0 && i3 == i4) {
            if (constraintWidget9.getParent() == null || constraintWidget9.getParent().mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                float f9 = (f8 + f4) - f5;
                float f10 = f6;
                ConstraintWidget constraintWidget11 = constraintWidget2;
                while (constraintWidget11 != null) {
                    Metrics metrics = LinearSystem.sMetrics;
                    if (metrics != null) {
                        metrics.nonresolvedWidgets--;
                        metrics.resolvedWidgets++;
                        metrics.chainConnectionResolved++;
                    }
                    ConstraintWidget constraintWidget12 = constraintWidget11.mNextChainWidget[i];
                    if (constraintWidget12 != null || constraintWidget11 == constraintWidget3) {
                        float f11 = f9 / i3;
                        if (f3 > 0.0f) {
                            float[] fArr = constraintWidget11.mWeight;
                            if (fArr[i] != -1.0f) {
                                f11 = (fArr[i] * f9) / f3;
                            } else {
                                f2 = 0.0f;
                                if (constraintWidget11.getVisibility() == 8) {
                                    f2 = 0.0f;
                                }
                                float margin2 = f10 + constraintWidget11.mListAnchors[i2].getMargin();
                                constraintWidget11.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2);
                                float f12 = margin2 + f2;
                                constraintWidget11.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f12);
                                constraintWidget11.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                                constraintWidget11.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                                f10 = f12 + constraintWidget11.mListAnchors[i5].getMargin();
                            }
                        }
                        f2 = f11;
                        if (constraintWidget11.getVisibility() == 8) {
                        }
                        float margin22 = f10 + constraintWidget11.mListAnchors[i2].getMargin();
                        constraintWidget11.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin22);
                        float f122 = margin22 + f2;
                        constraintWidget11.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f122);
                        constraintWidget11.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                        constraintWidget11.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                        f10 = f122 + constraintWidget11.mListAnchors[i5].getMargin();
                    }
                    constraintWidget11 = constraintWidget12;
                }
                return true;
            }
            return false;
        }
        if (f8 < 0.0f) {
            z3 = true;
            z = false;
            z2 = false;
        }
        if (z3) {
            ConstraintWidget constraintWidget13 = constraintWidget2;
            float biasPercent = f6 + ((f8 - margin) * constraintWidget13.getBiasPercent(i));
            while (true) {
                ConstraintWidget constraintWidget14 = constraintWidget13;
                if (constraintWidget14 == null) {
                    return true;
                }
                Metrics metrics2 = LinearSystem.sMetrics;
                if (metrics2 != null) {
                    metrics2.nonresolvedWidgets--;
                    metrics2.resolvedWidgets++;
                    metrics2.chainConnectionResolved++;
                }
                constraintWidget13 = constraintWidget14.mNextChainWidget[i];
                if (constraintWidget13 != null || constraintWidget14 == constraintWidget3) {
                    if (i == 0) {
                        height2 = constraintWidget14.getWidth();
                    } else {
                        height2 = constraintWidget14.getHeight();
                    }
                    float margin3 = biasPercent + constraintWidget14.mListAnchors[i2].getMargin();
                    constraintWidget14.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin3);
                    float f13 = margin3 + height2;
                    constraintWidget14.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f13);
                    constraintWidget14.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget14.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                    biasPercent = f13 + constraintWidget14.mListAnchors[i5].getMargin();
                }
            }
        } else {
            ConstraintWidget constraintWidget15 = constraintWidget2;
            if (!z && !z2) {
                return true;
            }
            if (z || z2) {
                f8 -= margin;
            }
            float f14 = f8 / (i4 + 1);
            if (z2) {
                f14 = f8 / (i4 > 1 ? i4 - 1 : 2.0f);
            }
            float f15 = constraintWidget15.getVisibility() != 8 ? f6 + f14 : f6;
            if (z2 && i4 > 1) {
                f15 = constraintWidget4.mListAnchors[i2].getMargin() + f6;
            }
            if (z && constraintWidget4 != null) {
                f15 += constraintWidget4.mListAnchors[i2].getMargin();
            }
            while (true) {
                ConstraintWidget constraintWidget16 = constraintWidget15;
                if (constraintWidget16 == null) {
                    return true;
                }
                Metrics metrics3 = LinearSystem.sMetrics;
                if (metrics3 != null) {
                    metrics3.nonresolvedWidgets--;
                    metrics3.resolvedWidgets++;
                    metrics3.chainConnectionResolved++;
                }
                constraintWidget15 = constraintWidget16.mNextChainWidget[i];
                if (constraintWidget15 != null || constraintWidget16 == constraintWidget3) {
                    if (i == 0) {
                        height = constraintWidget16.getWidth();
                    } else {
                        height = constraintWidget16.getHeight();
                    }
                    float f16 = height;
                    if (constraintWidget16 != constraintWidget4) {
                        f15 += constraintWidget16.mListAnchors[i2].getMargin();
                    }
                    constraintWidget16.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, f15);
                    constraintWidget16.mListAnchors[i5].getResolutionNode().resolve(resolutionNode.resolvedTarget, f15 + f16);
                    constraintWidget16.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget16.mListAnchors[i5].getResolutionNode().addResolvedValue(linearSystem);
                    f15 += f16 + constraintWidget16.mListAnchors[i5].getMargin();
                    if (constraintWidget15 != null) {
                        if (constraintWidget15.getVisibility() != 8) {
                            f15 += f14;
                        }
                    }
                }
            }
        }
    }

    public static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, constraintWidgetContainer, linearSystem, constraintWidget) == null) {
            if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int i = constraintWidget.mLeft.mMargin;
                int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
                ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
                constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(i, width);
            }
            if (constraintWidgetContainer.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                return;
            }
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.mBottom;
            constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.mBaseline;
                constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    public static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, constraintWidget, i)) == null) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
            if (dimensionBehaviourArr[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                return false;
            }
            if (constraintWidget.mDimensionRatio != 0.0f) {
                if (dimensionBehaviourArr[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                }
                return false;
            }
            if (i == 0) {
                if (constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                    return false;
                }
            } else if (constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, null, constraintWidget, i, i2) == null) {
            int i3 = i * 2;
            int i4 = i3 + 1;
            constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
            constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = i2;
            constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
            constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
            constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = constraintWidget.getLength(i);
            constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
        }
    }
}
