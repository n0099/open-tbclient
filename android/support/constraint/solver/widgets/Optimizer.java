package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;
/* loaded from: classes11.dex */
public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.mDimensionRatio != 0.0f) {
            if (constraintWidget.mListDimensionBehaviors[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void analyze(int i, ConstraintWidget constraintWidget) {
        boolean z = false;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget.mBottom.getResolutionNode();
        boolean z2 = (i & 8) == 8;
        boolean z3 = constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0);
        if (resolutionNode.type != 4 && resolutionNode3.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z2) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z2) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z2) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z2) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, -constraintWidget.getWidth());
                        resolutionNode3.setOpposite(resolutionNode, constraintWidget.getWidth());
                    }
                }
            } else if (z3) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (z2) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    if (z2) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    if (z2) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) {
                    if (z2) {
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
            }
        }
        if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1)) {
            z = true;
        }
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z2) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaseline.mTarget != null) {
                        constraintWidget.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z2) {
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
                    if (z2) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z2) {
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
            } else if (z) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    if (z2) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    if (z2) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                    if (z2) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    if (z2) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        float f;
        boolean z4;
        boolean z5;
        float f2;
        ConstraintWidget constraintWidget;
        float height;
        float height2;
        float margin;
        float margin2;
        int i3;
        ConstraintWidget constraintWidget2;
        float height3;
        ConstraintWidget constraintWidget3 = chainHead.mFirst;
        ConstraintWidget constraintWidget4 = chainHead.mLast;
        ConstraintWidget constraintWidget5 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget6 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget7 = chainHead.mHead;
        boolean z6 = false;
        int i4 = 0;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget8 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastMatchConstraintWidget;
        if (constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        }
        if (i == 0) {
            z = constraintWidget7.mHorizontalChainStyle == 0;
            z2 = constraintWidget7.mHorizontalChainStyle == 1;
            z3 = constraintWidget7.mHorizontalChainStyle == 2;
        } else {
            z = constraintWidget7.mVerticalChainStyle == 0;
            z2 = constraintWidget7.mVerticalChainStyle == 1;
            z3 = constraintWidget7.mVerticalChainStyle == 2;
        }
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i5 = 0;
        ConstraintWidget constraintWidget10 = constraintWidget3;
        while (!z6) {
            if (constraintWidget10.getVisibility() != 8) {
                i3 = i5 + 1;
                if (i == 0) {
                    height3 = constraintWidget10.getWidth() + f4;
                } else {
                    height3 = constraintWidget10.getHeight() + f4;
                }
                if (constraintWidget10 != constraintWidget5) {
                    height3 += constraintWidget10.mListAnchors[i2].getMargin();
                }
                if (constraintWidget10 != constraintWidget6) {
                    height3 += constraintWidget10.mListAnchors[i2 + 1].getMargin();
                }
                f5 = f5 + constraintWidget10.mListAnchors[i2].getMargin() + constraintWidget10.mListAnchors[i2 + 1].getMargin();
                f4 = height3;
            } else {
                i3 = i5;
            }
            ConstraintAnchor constraintAnchor = constraintWidget10.mListAnchors[i2];
            if (constraintWidget10.getVisibility() != 8 && constraintWidget10.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i6 = i4 + 1;
                if (i == 0) {
                    if (constraintWidget10.mMatchConstraintDefaultWidth != 0 || constraintWidget10.mMatchConstraintMinWidth != 0 || constraintWidget10.mMatchConstraintMaxWidth != 0) {
                        return false;
                    }
                } else if (constraintWidget10.mMatchConstraintDefaultHeight != 0 || constraintWidget10.mMatchConstraintMinHeight != 0 || constraintWidget10.mMatchConstraintMaxHeight != 0) {
                    return false;
                }
                if (constraintWidget10.mDimensionRatio != 0.0f) {
                    return false;
                }
                i4 = i6;
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget10.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor2 != null) {
                constraintWidget2 = constraintAnchor2.mOwner;
                if (constraintWidget2.mListAnchors[i2].mTarget == null || constraintWidget2.mListAnchors[i2].mTarget.mOwner != constraintWidget10) {
                    constraintWidget2 = null;
                }
            } else {
                constraintWidget2 = null;
            }
            if (constraintWidget2 == null) {
                z6 = true;
                constraintWidget2 = constraintWidget10;
            }
            constraintWidget10 = constraintWidget2;
            i5 = i3;
        }
        ResolutionAnchor resolutionNode = constraintWidget3.mListAnchors[i2].getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget4.mListAnchors[i2 + 1].getResolutionNode();
        if (resolutionNode.target == null || resolutionNode2.target == null || resolutionNode.target.state != 1 || resolutionNode2.target.state != 1) {
            return false;
        }
        if (i4 > 0 && i4 != i5) {
            return false;
        }
        float f6 = 0.0f;
        if (z3 || z || z2) {
            if (constraintWidget5 != null) {
                f6 = constraintWidget5.mListAnchors[i2].getMargin();
            }
            if (constraintWidget6 != null) {
                f6 += constraintWidget6.mListAnchors[i2 + 1].getMargin();
            }
        }
        float f7 = resolutionNode.target.resolvedOffset;
        float f8 = resolutionNode2.target.resolvedOffset;
        if (f7 < f8) {
            f = (f8 - f7) - f4;
        } else {
            f = (f7 - f8) - f4;
        }
        if (i4 > 0 && i4 == i5) {
            if (constraintWidget10.getParent() != null && constraintWidget10.getParent().mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                return false;
            }
            float f9 = (f + f4) - f5;
            float f10 = f7;
            while (constraintWidget3 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget11 = constraintWidget3.mNextChainWidget[i];
                if (constraintWidget11 != null || constraintWidget3 == constraintWidget4) {
                    float f11 = f9 / i4;
                    if (f3 > 0.0f) {
                        if (constraintWidget3.mWeight[i] == -1.0f) {
                            f11 = 0.0f;
                        } else {
                            f11 = (constraintWidget3.mWeight[i] * f9) / f3;
                        }
                    }
                    if (constraintWidget3.getVisibility() == 8) {
                        f11 = 0.0f;
                    }
                    float margin3 = f10 + constraintWidget3.mListAnchors[i2].getMargin();
                    constraintWidget3.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin3);
                    constraintWidget3.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin3 + f11);
                    constraintWidget3.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget3.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem);
                    margin2 = f11 + margin3 + constraintWidget3.mListAnchors[i2 + 1].getMargin();
                } else {
                    margin2 = f10;
                }
                f10 = margin2;
                constraintWidget3 = constraintWidget11;
            }
            return true;
        }
        if (f < 0.0f) {
            z3 = true;
            z4 = false;
            z5 = false;
        } else {
            z4 = z2;
            z5 = z;
        }
        if (z3) {
            float biasPercent = f7 + ((f - f6) * constraintWidget3.getBiasPercent(i));
            while (constraintWidget3 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget12 = constraintWidget3.mNextChainWidget[i];
                if (constraintWidget12 != null || constraintWidget3 == constraintWidget4) {
                    if (i == 0) {
                        height2 = constraintWidget3.getWidth();
                    } else {
                        height2 = constraintWidget3.getHeight();
                    }
                    float margin4 = biasPercent + constraintWidget3.mListAnchors[i2].getMargin();
                    constraintWidget3.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin4);
                    constraintWidget3.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin4 + height2);
                    constraintWidget3.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget3.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem);
                    margin = height2 + margin4 + constraintWidget3.mListAnchors[i2 + 1].getMargin();
                } else {
                    margin = biasPercent;
                }
                biasPercent = margin;
                constraintWidget3 = constraintWidget12;
            }
        } else if (z5 || z4) {
            if (z5) {
                f2 = f - f6;
            } else {
                f2 = z4 ? f - f6 : f;
            }
            float f12 = f2 / (i5 + 1);
            if (z4) {
                if (i5 > 1) {
                    f12 = f2 / (i5 - 1);
                } else {
                    f12 = f2 / 2.0f;
                }
            }
            float f13 = constraintWidget3.getVisibility() != 8 ? f7 + f12 : f7;
            if (z4 && i5 > 1) {
                f13 = constraintWidget5.mListAnchors[i2].getMargin() + f7;
            }
            if (!z5 || constraintWidget5 == null) {
                constraintWidget = constraintWidget3;
            } else {
                f13 += constraintWidget5.mListAnchors[i2].getMargin();
                constraintWidget = constraintWidget3;
            }
            while (constraintWidget != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget13 = constraintWidget.mNextChainWidget[i];
                if (constraintWidget13 != null || constraintWidget == constraintWidget4) {
                    if (i == 0) {
                        height = constraintWidget.getWidth();
                    } else {
                        height = constraintWidget.getHeight();
                    }
                    if (constraintWidget != constraintWidget5) {
                        f13 += constraintWidget.mListAnchors[i2].getMargin();
                    }
                    constraintWidget.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, f13);
                    constraintWidget.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, f13 + height);
                    constraintWidget.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem);
                    f13 += height + constraintWidget.mListAnchors[i2 + 1].getMargin();
                    if (constraintWidget13 != null && constraintWidget13.getVisibility() != 8) {
                        f13 += f12;
                    }
                }
                constraintWidget = constraintWidget13;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
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
