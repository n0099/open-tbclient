package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);
    private boolean mAllowsGoneWidget = true;

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        ResolutionAnchor resolutionNode;
        ResolutionAnchor resolutionNode2;
        if (this.mParent != null && ((ConstraintWidgetContainer) this.mParent).optimizeFor(2)) {
            switch (this.mBarrierType) {
                case 0:
                    resolutionNode = this.mLeft.getResolutionNode();
                    break;
                case 1:
                    resolutionNode = this.mRight.getResolutionNode();
                    break;
                case 2:
                    resolutionNode = this.mTop.getResolutionNode();
                    break;
                case 3:
                    resolutionNode = this.mBottom.getResolutionNode();
                    break;
                default:
                    return;
            }
            resolutionNode.setType(5);
            if (this.mBarrierType == 0 || this.mBarrierType == 1) {
                this.mTop.getResolutionNode().resolve(null, 0.0f);
                this.mBottom.getResolutionNode().resolve(null, 0.0f);
            } else {
                this.mLeft.getResolutionNode().resolve(null, 0.0f);
                this.mRight.getResolutionNode().resolve(null, 0.0f);
            }
            this.mNodes.clear();
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    switch (this.mBarrierType) {
                        case 0:
                            resolutionNode2 = constraintWidget.mLeft.getResolutionNode();
                            break;
                        case 1:
                            resolutionNode2 = constraintWidget.mRight.getResolutionNode();
                            break;
                        case 2:
                            resolutionNode2 = constraintWidget.mTop.getResolutionNode();
                            break;
                        case 3:
                            resolutionNode2 = constraintWidget.mBottom.getResolutionNode();
                            break;
                        default:
                            resolutionNode2 = null;
                            break;
                    }
                    if (resolutionNode2 != null) {
                        this.mNodes.add(resolutionNode2);
                        resolutionNode2.addDependent(resolutionNode);
                    }
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void resolve() {
        ResolutionAnchor resolutionNode;
        float f;
        ResolutionAnchor resolutionAnchor;
        float f2 = Float.MAX_VALUE;
        switch (this.mBarrierType) {
            case 0:
                resolutionNode = this.mLeft.getResolutionNode();
                break;
            case 1:
                resolutionNode = this.mRight.getResolutionNode();
                f2 = 0.0f;
                break;
            case 2:
                resolutionNode = this.mTop.getResolutionNode();
                break;
            case 3:
                resolutionNode = this.mBottom.getResolutionNode();
                f2 = 0.0f;
                break;
            default:
                return;
        }
        int size = this.mNodes.size();
        int i = 0;
        ResolutionAnchor resolutionAnchor2 = null;
        float f3 = f2;
        while (i < size) {
            ResolutionAnchor resolutionAnchor3 = this.mNodes.get(i);
            if (resolutionAnchor3.state == 1) {
                if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                    if (resolutionAnchor3.resolvedOffset < f3) {
                        f = resolutionAnchor3.resolvedOffset;
                        resolutionAnchor = resolutionAnchor3.resolvedTarget;
                    }
                    resolutionAnchor = resolutionAnchor2;
                    f = f3;
                } else {
                    if (resolutionAnchor3.resolvedOffset > f3) {
                        f = resolutionAnchor3.resolvedOffset;
                        resolutionAnchor = resolutionAnchor3.resolvedTarget;
                    }
                    resolutionAnchor = resolutionAnchor2;
                    f = f3;
                }
                i++;
                f3 = f;
                resolutionAnchor2 = resolutionAnchor;
            } else {
                return;
            }
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().barrierConnectionResolved++;
        }
        resolutionNode.resolvedTarget = resolutionAnchor2;
        resolutionNode.resolvedOffset = f3;
        resolutionNode.didResolve();
        switch (this.mBarrierType) {
            case 0:
                this.mRight.getResolutionNode().resolve(resolutionAnchor2, f3);
                return;
            case 1:
                this.mLeft.getResolutionNode().resolve(resolutionAnchor2, f3);
                return;
            case 2:
                this.mBottom.getResolutionNode().resolve(resolutionAnchor2, f3);
                return;
            case 3:
                this.mTop.getResolutionNode().resolve(resolutionAnchor2, f3);
                return;
            default:
                return;
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i = 0; i < this.mListAnchors.length; i++) {
            this.mListAnchors[i].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i]);
        }
        if (this.mBarrierType >= 0 && this.mBarrierType < 4) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[this.mBarrierType];
            int i2 = 0;
            while (true) {
                if (i2 >= this.mWidgetsCount) {
                    z = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    if ((this.mBarrierType != 0 && this.mBarrierType != 1) || constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        if ((this.mBarrierType == 2 || this.mBarrierType == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            z = true;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (this.mBarrierType == 0 || this.mBarrierType == 1) {
                if (getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = false;
                }
            } else if (getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
            for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i3];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = createObjectVariable;
                    if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                        linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, z);
                    } else {
                        linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, z);
                    }
                }
            }
            if (this.mBarrierType == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
                if (!z) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 5);
                }
            } else if (this.mBarrierType == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
                if (!z) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 5);
                }
            } else if (this.mBarrierType == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
                if (!z) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 5);
                }
            } else if (this.mBarrierType == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
                if (!z) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
                }
            }
        }
    }
}
