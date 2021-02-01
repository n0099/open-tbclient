package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ChainHead[] chainHeadArr;
        if (i == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (constraintWidgetContainer.optimizeFor(4)) {
                if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i2, chainHead)) {
                    applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
                }
            } else {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
            }
        }
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        float f;
        int size;
        ConstraintWidget constraintWidget3;
        boolean z4;
        ConstraintWidget constraintWidget4 = chainHead.mFirst;
        ConstraintWidget constraintWidget5 = chainHead.mLast;
        ConstraintWidget constraintWidget6 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget7 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget8 = chainHead.mHead;
        boolean z5 = false;
        float f2 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget9 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget10 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            boolean z7 = constraintWidget8.mHorizontalChainStyle == 0;
            boolean z8 = constraintWidget8.mHorizontalChainStyle == 1;
            z = constraintWidget8.mHorizontalChainStyle == 2;
            z2 = z8;
            z3 = z7;
            constraintWidget = constraintWidget4;
        } else {
            boolean z9 = constraintWidget8.mVerticalChainStyle == 0;
            boolean z10 = constraintWidget8.mVerticalChainStyle == 1;
            z = constraintWidget8.mVerticalChainStyle == 2;
            z2 = z10;
            z3 = z9;
            constraintWidget = constraintWidget4;
        }
        while (!z5) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.mListAnchors[i2];
            int i3 = 4;
            i3 = (z6 || z) ? 1 : 1;
            int margin = constraintAnchor5.getMargin();
            if (constraintAnchor5.mTarget != null && constraintWidget != constraintWidget4) {
                margin += constraintAnchor5.mTarget.getMargin();
            }
            if (z && constraintWidget != constraintWidget4 && constraintWidget != constraintWidget6) {
                i3 = 6;
            } else if (z3 && z6) {
                i3 = 4;
            }
            if (constraintAnchor5.mTarget != null) {
                if (constraintWidget == constraintWidget6) {
                    linearSystem.addGreaterThan(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, margin, 5);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, margin, 6);
                }
                linearSystem.addEquality(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, margin, i3);
            }
            if (z6) {
                if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    linearSystem.addGreaterThan(constraintWidget.mListAnchors[i2 + 1].mSolverVariable, constraintWidget.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, 0, 6);
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor6 != null) {
                constraintWidget3 = constraintAnchor6.mOwner;
                if (constraintWidget3.mListAnchors[i2].mTarget == null || constraintWidget3.mListAnchors[i2].mTarget.mOwner != constraintWidget) {
                    constraintWidget3 = null;
                }
            } else {
                constraintWidget3 = null;
            }
            if (constraintWidget3 != null) {
                z4 = z5;
            } else {
                z4 = true;
                constraintWidget3 = constraintWidget;
            }
            z5 = z4;
            constraintWidget = constraintWidget3;
        }
        if (constraintWidget7 != null && constraintWidget5.mListAnchors[i2 + 1].mTarget != null) {
            ConstraintAnchor constraintAnchor7 = constraintWidget7.mListAnchors[i2 + 1];
            linearSystem.addLowerThan(constraintAnchor7.mSolverVariable, constraintWidget5.mListAnchors[i2 + 1].mTarget.mSolverVariable, -constraintAnchor7.getMargin(), 5);
        }
        if (z6) {
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i2 + 1].mSolverVariable, constraintWidget5.mListAnchors[i2 + 1].mSolverVariable, constraintWidget5.mListAnchors[i2 + 1].getMargin(), 6);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            ConstraintWidget constraintWidget11 = null;
            float f3 = 0.0f;
            float f4 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f2 : chainHead.mWidgetsMatchCount;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                if (i5 >= size) {
                    break;
                }
                constraintWidget11 = arrayList.get(i5);
                float f5 = constraintWidget11.mWeight[i];
                if (f5 < 0.0f) {
                    if (chainHead.mHasComplexMatchWeights) {
                        linearSystem.addEquality(constraintWidget11.mListAnchors[i2 + 1].mSolverVariable, constraintWidget11.mListAnchors[i2].mSolverVariable, 0, 4);
                        constraintWidget11 = constraintWidget12;
                        i4 = i5 + 1;
                    } else {
                        f5 = 1.0f;
                    }
                }
                if (f5 == 0.0f) {
                    linearSystem.addEquality(constraintWidget11.mListAnchors[i2 + 1].mSolverVariable, constraintWidget11.mListAnchors[i2].mSolverVariable, 0, 6);
                    constraintWidget11 = constraintWidget12;
                } else {
                    if (constraintWidget12 != null) {
                        SolverVariable solverVariable5 = constraintWidget12.mListAnchors[i2].mSolverVariable;
                        SolverVariable solverVariable6 = constraintWidget12.mListAnchors[i2 + 1].mSolverVariable;
                        SolverVariable solverVariable7 = constraintWidget11.mListAnchors[i2].mSolverVariable;
                        SolverVariable solverVariable8 = constraintWidget11.mListAnchors[i2 + 1].mSolverVariable;
                        ArrayRow createRow = linearSystem.createRow();
                        createRow.createRowEqualMatchDimensions(f3, f4, f5, solverVariable5, solverVariable6, solverVariable7, solverVariable8);
                        linearSystem.addConstraint(createRow);
                    }
                    f3 = f5;
                }
                i4 = i5 + 1;
            }
        }
        if (constraintWidget6 != null && (constraintWidget6 == constraintWidget7 || z)) {
            ConstraintAnchor constraintAnchor8 = constraintWidget4.mListAnchors[i2];
            ConstraintAnchor constraintAnchor9 = constraintWidget5.mListAnchors[i2 + 1];
            SolverVariable solverVariable9 = constraintWidget4.mListAnchors[i2].mTarget != null ? constraintWidget4.mListAnchors[i2].mTarget.mSolverVariable : null;
            SolverVariable solverVariable10 = constraintWidget5.mListAnchors[i2 + 1].mTarget != null ? constraintWidget5.mListAnchors[i2 + 1].mTarget.mSolverVariable : null;
            if (constraintWidget6 == constraintWidget7) {
                constraintAnchor8 = constraintWidget6.mListAnchors[i2];
                constraintAnchor9 = constraintWidget6.mListAnchors[i2 + 1];
            }
            if (solverVariable9 != null && solverVariable10 != null) {
                if (i == 0) {
                    f = constraintWidget8.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget8.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor8.mSolverVariable, solverVariable9, constraintAnchor8.getMargin(), f, solverVariable10, constraintAnchor9.mSolverVariable, constraintAnchor9.getMargin(), 5);
            }
        } else if (z3 && constraintWidget6 != null) {
            boolean z11 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget constraintWidget13 = constraintWidget6;
            ConstraintWidget constraintWidget14 = constraintWidget6;
            while (constraintWidget14 != null) {
                ConstraintWidget constraintWidget15 = constraintWidget14.mNextChainWidget[i];
                while (constraintWidget15 != null && constraintWidget15.getVisibility() == 8) {
                    constraintWidget15 = constraintWidget15.mNextChainWidget[i];
                }
                if (constraintWidget15 != null || constraintWidget14 == constraintWidget7) {
                    ConstraintAnchor constraintAnchor10 = constraintWidget14.mListAnchors[i2];
                    SolverVariable solverVariable11 = constraintAnchor10.mSolverVariable;
                    SolverVariable solverVariable12 = constraintAnchor10.mTarget != null ? constraintAnchor10.mTarget.mSolverVariable : null;
                    if (constraintWidget13 != constraintWidget14) {
                        solverVariable12 = constraintWidget13.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget14 == constraintWidget6 && constraintWidget13 == constraintWidget14) {
                        solverVariable12 = constraintWidget4.mListAnchors[i2].mTarget != null ? constraintWidget4.mListAnchors[i2].mTarget.mSolverVariable : null;
                    }
                    SolverVariable solverVariable13 = null;
                    int margin2 = constraintAnchor10.getMargin();
                    int margin3 = constraintWidget14.mListAnchors[i2 + 1].getMargin();
                    if (constraintWidget15 != null) {
                        ConstraintAnchor constraintAnchor11 = constraintWidget15.mListAnchors[i2];
                        solverVariable4 = constraintAnchor11.mSolverVariable;
                        solverVariable3 = constraintWidget14.mListAnchors[i2 + 1].mSolverVariable;
                        constraintAnchor2 = constraintAnchor11;
                    } else {
                        constraintAnchor2 = constraintWidget5.mListAnchors[i2 + 1].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable13 = constraintAnchor2.mSolverVariable;
                        }
                        solverVariable3 = constraintWidget14.mListAnchors[i2 + 1].mSolverVariable;
                        solverVariable4 = solverVariable13;
                    }
                    if (constraintAnchor2 != null) {
                        margin3 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget13 != null) {
                        margin2 += constraintWidget13.mListAnchors[i2 + 1].getMargin();
                    }
                    if (solverVariable11 != null && solverVariable12 != null && solverVariable4 != null && solverVariable3 != null) {
                        if (constraintWidget14 == constraintWidget6) {
                            margin2 = constraintWidget6.mListAnchors[i2].getMargin();
                        }
                        if (constraintWidget14 == constraintWidget7) {
                            margin3 = constraintWidget7.mListAnchors[i2 + 1].getMargin();
                        }
                        int i6 = 4;
                        if (z11) {
                            i6 = 6;
                        }
                        linearSystem.addCentering(solverVariable11, solverVariable12, margin2, 0.5f, solverVariable4, solverVariable3, margin3, i6);
                    }
                }
                constraintWidget13 = constraintWidget14.getVisibility() != 8 ? constraintWidget14 : constraintWidget13;
                constraintWidget14 = constraintWidget15;
            }
        } else if (z2 && constraintWidget6 != null) {
            boolean z12 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget constraintWidget16 = constraintWidget6;
            for (ConstraintWidget constraintWidget17 = constraintWidget6; constraintWidget17 != null; constraintWidget17 = constraintWidget2) {
                ConstraintWidget constraintWidget18 = constraintWidget17.mNextChainWidget[i];
                while (constraintWidget18 != null && constraintWidget18.getVisibility() == 8) {
                    constraintWidget18 = constraintWidget18.mNextChainWidget[i];
                }
                if (constraintWidget17 == constraintWidget6 || constraintWidget17 == constraintWidget7 || constraintWidget18 == null) {
                    constraintWidget2 = constraintWidget18;
                } else {
                    constraintWidget2 = constraintWidget18 == constraintWidget7 ? null : constraintWidget18;
                    ConstraintAnchor constraintAnchor12 = constraintWidget17.mListAnchors[i2];
                    SolverVariable solverVariable14 = constraintAnchor12.mSolverVariable;
                    if (constraintAnchor12.mTarget != null) {
                        SolverVariable solverVariable15 = constraintAnchor12.mTarget.mSolverVariable;
                    }
                    SolverVariable solverVariable16 = constraintWidget16.mListAnchors[i2 + 1].mSolverVariable;
                    SolverVariable solverVariable17 = null;
                    int margin4 = constraintAnchor12.getMargin();
                    int margin5 = constraintWidget17.mListAnchors[i2 + 1].getMargin();
                    if (constraintWidget2 != null) {
                        constraintAnchor = constraintWidget2.mListAnchors[i2];
                        solverVariable2 = constraintAnchor.mSolverVariable;
                        solverVariable = constraintAnchor.mTarget != null ? constraintAnchor.mTarget.mSolverVariable : null;
                    } else {
                        constraintAnchor = constraintWidget17.mListAnchors[i2 + 1].mTarget;
                        if (constraintAnchor != null) {
                            solverVariable17 = constraintAnchor.mSolverVariable;
                        }
                        solverVariable = constraintWidget17.mListAnchors[i2 + 1].mSolverVariable;
                        solverVariable2 = solverVariable17;
                    }
                    if (constraintAnchor != null) {
                        margin5 += constraintAnchor.getMargin();
                    }
                    if (constraintWidget16 != null) {
                        margin4 += constraintWidget16.mListAnchors[i2 + 1].getMargin();
                    }
                    int i7 = 4;
                    if (z12) {
                        i7 = 6;
                    }
                    if (solverVariable14 != null && solverVariable16 != null && solverVariable2 != null && solverVariable != null) {
                        linearSystem.addCentering(solverVariable14, solverVariable16, margin4, 0.5f, solverVariable2, solverVariable, margin5, i7);
                    }
                }
                constraintWidget16 = constraintWidget17.getVisibility() != 8 ? constraintWidget17 : constraintWidget16;
            }
            ConstraintAnchor constraintAnchor13 = constraintWidget6.mListAnchors[i2];
            ConstraintAnchor constraintAnchor14 = constraintWidget4.mListAnchors[i2].mTarget;
            ConstraintAnchor constraintAnchor15 = constraintWidget7.mListAnchors[i2 + 1];
            ConstraintAnchor constraintAnchor16 = constraintWidget5.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor14 != null) {
                if (constraintWidget6 != constraintWidget7) {
                    linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor14.mSolverVariable, constraintAnchor13.getMargin(), 5);
                } else if (constraintAnchor16 != null) {
                    linearSystem.addCentering(constraintAnchor13.mSolverVariable, constraintAnchor14.mSolverVariable, constraintAnchor13.getMargin(), 0.5f, constraintAnchor15.mSolverVariable, constraintAnchor16.mSolverVariable, constraintAnchor15.getMargin(), 5);
                }
            }
            if (constraintAnchor16 != null && constraintWidget6 != constraintWidget7) {
                linearSystem.addEquality(constraintAnchor15.mSolverVariable, constraintAnchor16.mSolverVariable, -constraintAnchor15.getMargin(), 5);
            }
        }
        if ((z3 || z2) && constraintWidget6 != null) {
            ConstraintAnchor constraintAnchor17 = constraintWidget6.mListAnchors[i2];
            ConstraintAnchor constraintAnchor18 = constraintWidget7.mListAnchors[i2 + 1];
            SolverVariable solverVariable18 = constraintAnchor17.mTarget != null ? constraintAnchor17.mTarget.mSolverVariable : null;
            SolverVariable solverVariable19 = constraintAnchor18.mTarget != null ? constraintAnchor18.mTarget.mSolverVariable : null;
            if (constraintWidget5 != constraintWidget7) {
                ConstraintAnchor constraintAnchor19 = constraintWidget5.mListAnchors[i2 + 1];
                solverVariable19 = constraintAnchor19.mTarget != null ? constraintAnchor19.mTarget.mSolverVariable : null;
            }
            if (constraintWidget6 == constraintWidget7) {
                ConstraintAnchor constraintAnchor20 = constraintWidget6.mListAnchors[i2];
                constraintAnchor3 = constraintWidget6.mListAnchors[i2 + 1];
                constraintAnchor4 = constraintAnchor20;
            } else {
                constraintAnchor3 = constraintAnchor18;
                constraintAnchor4 = constraintAnchor17;
            }
            if (solverVariable18 != null && solverVariable19 != null) {
                linearSystem.addCentering(constraintAnchor4.mSolverVariable, solverVariable18, constraintAnchor4.getMargin(), 0.5f, solverVariable19, constraintAnchor3.mSolverVariable, (constraintWidget7 == null ? constraintWidget5 : constraintWidget7).mListAnchors[i2 + 1].getMargin(), 5);
            }
        }
    }
}
