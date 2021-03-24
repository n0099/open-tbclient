package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Chain {
    public static final boolean DEBUG = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ChainHead[] chainHeadArr;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
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

    /* JADX DEBUG: Multi-variable search result rejected for r2v52, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget2;
        int i4;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        float f2;
        int size;
        int i5;
        ArrayList<ConstraintWidget> arrayList2;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        ConstraintWidget constraintWidget5;
        boolean z6;
        int i8;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget11 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget12 = chainHead.mLastMatchConstraintWidget;
        boolean z7 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget10.mHorizontalChainStyle == 0;
            z2 = constraintWidget10.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget10.mVerticalChainStyle == 0;
            z2 = constraintWidget10.mVerticalChainStyle == 1;
        }
        ConstraintWidget constraintWidget13 = constraintWidget6;
        boolean z8 = z2;
        boolean z9 = z;
        boolean z10 = false;
        while (true) {
            if (z10) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget13.mListAnchors[i2];
            int i9 = (z7 || z3) ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            float f4 = f3;
            ConstraintAnchor constraintAnchor7 = constraintAnchor6.mTarget;
            if (constraintAnchor7 != null && constraintWidget13 != constraintWidget6) {
                margin += constraintAnchor7.getMargin();
            }
            int i10 = margin;
            if (z3 && constraintWidget13 != constraintWidget6 && constraintWidget13 != constraintWidget8) {
                z4 = z10;
                z5 = z8;
                i7 = 6;
            } else if (z9 && z7) {
                z4 = z10;
                z5 = z8;
                i7 = 4;
            } else {
                z4 = z10;
                i7 = i9;
                z5 = z8;
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor6.mTarget;
            if (constraintAnchor8 != null) {
                if (constraintWidget13 == constraintWidget8) {
                    z6 = z9;
                    constraintWidget5 = constraintWidget10;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i10, 5);
                } else {
                    constraintWidget5 = constraintWidget10;
                    z6 = z9;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i10, 6);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i10, i7);
            } else {
                constraintWidget5 = constraintWidget10;
                z6 = z9;
            }
            if (z7) {
                if (constraintWidget13.getVisibility() == 8 || constraintWidget13.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget13.mListAnchors;
                    i8 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget13.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i8, 6);
            }
            ConstraintAnchor constraintAnchor9 = constraintWidget13.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor9 != null) {
                ConstraintWidget constraintWidget14 = constraintAnchor9.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget14.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == constraintWidget13) {
                    r21 = constraintWidget14;
                }
            }
            if (r21 != null) {
                constraintWidget13 = r21;
                z10 = z4;
            } else {
                z10 = true;
            }
            z8 = z5;
            f3 = f4;
            z9 = z6;
            constraintWidget10 = constraintWidget5;
        }
        ConstraintWidget constraintWidget15 = constraintWidget10;
        float f5 = f3;
        boolean z11 = z9;
        boolean z12 = z8;
        if (constraintWidget9 != null) {
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget7.mListAnchors;
            int i11 = i2 + 1;
            if (constraintAnchorArr3[i11].mTarget != null) {
                ConstraintAnchor constraintAnchor10 = constraintWidget9.mListAnchors[i11];
                linearSystem.addLowerThan(constraintAnchor10.mSolverVariable, constraintAnchorArr3[i11].mTarget.mSolverVariable, -constraintAnchor10.getMargin(), 5);
                if (z7) {
                    int i12 = i2 + 1;
                    SolverVariable solverVariable7 = constraintWidgetContainer.mListAnchors[i12].mSolverVariable;
                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget7.mListAnchors;
                    linearSystem.addGreaterThan(solverVariable7, constraintAnchorArr4[i12].mSolverVariable, constraintAnchorArr4[i12].getMargin(), 6);
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f6 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f5 : chainHead.mWidgetsMatchCount;
                    float f7 = 0.0f;
                    ConstraintWidget constraintWidget16 = null;
                    i5 = 0;
                    float f8 = 0.0f;
                    while (i5 < size) {
                        ConstraintWidget constraintWidget17 = arrayList.get(i5);
                        float f9 = constraintWidget17.mWeight[i];
                        if (f9 < f7) {
                            if (chainHead.mHasComplexMatchWeights) {
                                ConstraintAnchor[] constraintAnchorArr5 = constraintWidget17.mListAnchors;
                                linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 4);
                                arrayList2 = arrayList;
                                i6 = size;
                                i5++;
                                size = i6;
                                arrayList = arrayList2;
                                f7 = 0.0f;
                            } else {
                                f9 = 1.0f;
                                f7 = 0.0f;
                            }
                        }
                        if (f9 == f7) {
                            ConstraintAnchor[] constraintAnchorArr6 = constraintWidget17.mListAnchors;
                            linearSystem.addEquality(constraintAnchorArr6[i2 + 1].mSolverVariable, constraintAnchorArr6[i2].mSolverVariable, 0, 6);
                            arrayList2 = arrayList;
                            i6 = size;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f7 = 0.0f;
                        } else {
                            if (constraintWidget16 != null) {
                                ConstraintAnchor[] constraintAnchorArr7 = constraintWidget16.mListAnchors;
                                SolverVariable solverVariable8 = constraintAnchorArr7[i2].mSolverVariable;
                                int i13 = i2 + 1;
                                SolverVariable solverVariable9 = constraintAnchorArr7[i13].mSolverVariable;
                                ConstraintAnchor[] constraintAnchorArr8 = constraintWidget17.mListAnchors;
                                arrayList2 = arrayList;
                                SolverVariable solverVariable10 = constraintAnchorArr8[i2].mSolverVariable;
                                SolverVariable solverVariable11 = constraintAnchorArr8[i13].mSolverVariable;
                                i6 = size;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f8, f6, f9, solverVariable8, solverVariable9, solverVariable10, solverVariable11);
                                linearSystem.addConstraint(createRow);
                            } else {
                                arrayList2 = arrayList;
                                i6 = size;
                            }
                            f8 = f9;
                            constraintWidget16 = constraintWidget17;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f7 = 0.0f;
                        }
                    }
                }
                if (constraintWidget8 == null && (constraintWidget8 == constraintWidget9 || z3)) {
                    ConstraintAnchor[] constraintAnchorArr9 = constraintWidget6.mListAnchors;
                    ConstraintAnchor constraintAnchor11 = constraintAnchorArr9[i2];
                    int i14 = i2 + 1;
                    ConstraintAnchor constraintAnchor12 = constraintWidget7.mListAnchors[i14];
                    SolverVariable solverVariable12 = constraintAnchorArr9[i2].mTarget != null ? constraintAnchorArr9[i2].mTarget.mSolverVariable : null;
                    ConstraintAnchor[] constraintAnchorArr10 = constraintWidget7.mListAnchors;
                    SolverVariable solverVariable13 = constraintAnchorArr10[i14].mTarget != null ? constraintAnchorArr10[i14].mTarget.mSolverVariable : null;
                    if (constraintWidget8 == constraintWidget9) {
                        ConstraintAnchor[] constraintAnchorArr11 = constraintWidget8.mListAnchors;
                        constraintAnchor11 = constraintAnchorArr11[i2];
                        constraintAnchor12 = constraintAnchorArr11[i14];
                    }
                    if (solverVariable12 != null && solverVariable13 != null) {
                        if (i == 0) {
                            f2 = constraintWidget15.mHorizontalBiasPercent;
                        } else {
                            f2 = constraintWidget15.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor11.mSolverVariable, solverVariable12, constraintAnchor11.getMargin(), f2, solverVariable13, constraintAnchor12.mSolverVariable, constraintAnchor12.getMargin(), 5);
                    }
                } else if (z11 || constraintWidget8 == null) {
                    int i15 = 8;
                    if (z12 && constraintWidget8 != null) {
                        int i16 = chainHead.mWidgetsMatchCount;
                        boolean z13 = i16 <= 0 && chainHead.mWidgetsCount == i16;
                        constraintWidget = constraintWidget8;
                        ConstraintWidget constraintWidget18 = constraintWidget;
                        while (constraintWidget != null) {
                            ConstraintWidget constraintWidget19 = constraintWidget.mNextChainWidget[i];
                            while (constraintWidget19 != null && constraintWidget19.getVisibility() == i15) {
                                constraintWidget19 = constraintWidget19.mNextChainWidget[i];
                            }
                            if (constraintWidget == constraintWidget8 || constraintWidget == constraintWidget9 || constraintWidget19 == null) {
                                constraintWidget2 = constraintWidget18;
                                i4 = 8;
                            } else {
                                ConstraintWidget constraintWidget20 = constraintWidget19 == constraintWidget9 ? null : constraintWidget19;
                                ConstraintAnchor constraintAnchor13 = constraintWidget.mListAnchors[i2];
                                SolverVariable solverVariable14 = constraintAnchor13.mSolverVariable;
                                ConstraintAnchor constraintAnchor14 = constraintAnchor13.mTarget;
                                if (constraintAnchor14 != null) {
                                    SolverVariable solverVariable15 = constraintAnchor14.mSolverVariable;
                                }
                                int i17 = i2 + 1;
                                SolverVariable solverVariable16 = constraintWidget18.mListAnchors[i17].mSolverVariable;
                                int margin2 = constraintAnchor13.getMargin();
                                int margin3 = constraintWidget.mListAnchors[i17].getMargin();
                                if (constraintWidget20 != null) {
                                    constraintAnchor4 = constraintWidget20.mListAnchors[i2];
                                    solverVariable = constraintAnchor4.mSolverVariable;
                                    ConstraintAnchor constraintAnchor15 = constraintAnchor4.mTarget;
                                    solverVariable2 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
                                } else {
                                    constraintAnchor4 = constraintWidget.mListAnchors[i17].mTarget;
                                    solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable2 = constraintWidget.mListAnchors[i17].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                int i18 = margin3;
                                if (constraintWidget18 != null) {
                                    margin2 += constraintWidget18.mListAnchors[i17].getMargin();
                                }
                                int i19 = margin2;
                                int i20 = z13 ? 6 : 4;
                                if (solverVariable14 == null || solverVariable16 == null || solverVariable == null || solverVariable2 == null) {
                                    constraintWidget3 = constraintWidget20;
                                    constraintWidget2 = constraintWidget18;
                                    i4 = 8;
                                } else {
                                    constraintWidget3 = constraintWidget20;
                                    constraintWidget2 = constraintWidget18;
                                    i4 = 8;
                                    linearSystem.addCentering(solverVariable14, solverVariable16, i19, 0.5f, solverVariable, solverVariable2, i18, i20);
                                }
                                constraintWidget19 = constraintWidget3;
                            }
                            if (constraintWidget.getVisibility() == i4) {
                                constraintWidget = constraintWidget2;
                            }
                            constraintWidget18 = constraintWidget;
                            i15 = 8;
                            constraintWidget = constraintWidget19;
                        }
                        ConstraintAnchor constraintAnchor16 = constraintWidget8.mListAnchors[i2];
                        constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
                        int i21 = i2 + 1;
                        constraintAnchor2 = constraintWidget9.mListAnchors[i21];
                        constraintAnchor3 = constraintWidget7.mListAnchors[i21].mTarget;
                        if (constraintAnchor != null) {
                            i3 = 5;
                        } else if (constraintWidget8 != constraintWidget9) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor16.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor16.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor16.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor16.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (constraintAnchor3 != null && constraintWidget8 != constraintWidget9) {
                            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                        }
                    }
                } else {
                    int i22 = chainHead.mWidgetsMatchCount;
                    boolean z14 = i22 > 0 && chainHead.mWidgetsCount == i22;
                    ConstraintWidget constraintWidget21 = constraintWidget8;
                    ConstraintWidget constraintWidget22 = constraintWidget21;
                    while (constraintWidget21 != null) {
                        ConstraintWidget constraintWidget23 = constraintWidget21.mNextChainWidget[i];
                        while (constraintWidget23 != null && constraintWidget23.getVisibility() == 8) {
                            constraintWidget23 = constraintWidget23.mNextChainWidget[i];
                        }
                        if (constraintWidget23 != null || constraintWidget21 == constraintWidget9) {
                            ConstraintAnchor constraintAnchor17 = constraintWidget21.mListAnchors[i2];
                            SolverVariable solverVariable17 = constraintAnchor17.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                            SolverVariable solverVariable18 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                            if (constraintWidget22 != constraintWidget21) {
                                solverVariable18 = constraintWidget22.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget21 == constraintWidget8 && constraintWidget22 == constraintWidget21) {
                                ConstraintAnchor[] constraintAnchorArr12 = constraintWidget6.mListAnchors;
                                solverVariable18 = constraintAnchorArr12[i2].mTarget != null ? constraintAnchorArr12[i2].mTarget.mSolverVariable : null;
                            }
                            int margin4 = constraintAnchor17.getMargin();
                            int i23 = i2 + 1;
                            int margin5 = constraintWidget21.mListAnchors[i23].getMargin();
                            if (constraintWidget23 != null) {
                                constraintAnchor5 = constraintWidget23.mListAnchors[i2];
                                SolverVariable solverVariable19 = constraintAnchor5.mSolverVariable;
                                solverVariable4 = constraintWidget21.mListAnchors[i23].mSolverVariable;
                                solverVariable3 = solverVariable19;
                            } else {
                                constraintAnchor5 = constraintWidget7.mListAnchors[i23].mTarget;
                                solverVariable3 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable4 = constraintWidget21.mListAnchors[i23].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin5 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget22 != null) {
                                margin4 += constraintWidget22.mListAnchors[i23].getMargin();
                            }
                            if (solverVariable17 != null && solverVariable18 != null && solverVariable3 != null && solverVariable4 != null) {
                                if (constraintWidget21 == constraintWidget8) {
                                    margin4 = constraintWidget8.mListAnchors[i2].getMargin();
                                }
                                int i24 = margin4;
                                constraintWidget4 = constraintWidget23;
                                linearSystem.addCentering(solverVariable17, solverVariable18, i24, 0.5f, solverVariable3, solverVariable4, constraintWidget21 == constraintWidget9 ? constraintWidget9.mListAnchors[i23].getMargin() : margin5, z14 ? 6 : 4);
                                if (constraintWidget21.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget21;
                                }
                                constraintWidget21 = constraintWidget4;
                            }
                        }
                        constraintWidget4 = constraintWidget23;
                        if (constraintWidget21.getVisibility() == 8) {
                        }
                        constraintWidget21 = constraintWidget4;
                    }
                }
                if ((!z11 || z12) && constraintWidget8 != null) {
                    ConstraintAnchor constraintAnchor19 = constraintWidget8.mListAnchors[i2];
                    int i25 = i2 + 1;
                    ConstraintAnchor constraintAnchor20 = constraintWidget9.mListAnchors[i25];
                    ConstraintAnchor constraintAnchor21 = constraintAnchor19.mTarget;
                    solverVariable5 = constraintAnchor21 == null ? constraintAnchor21.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor22 = constraintAnchor20.mTarget;
                    SolverVariable solverVariable20 = constraintAnchor22 == null ? constraintAnchor22.mSolverVariable : null;
                    if (constraintWidget7 == constraintWidget9) {
                        ConstraintAnchor constraintAnchor23 = constraintWidget7.mListAnchors[i25].mTarget;
                        solverVariable6 = constraintAnchor23 != null ? constraintAnchor23.mSolverVariable : null;
                    } else {
                        solverVariable6 = solverVariable20;
                    }
                    if (constraintWidget8 == constraintWidget9) {
                        ConstraintAnchor[] constraintAnchorArr13 = constraintWidget8.mListAnchors;
                        ConstraintAnchor constraintAnchor24 = constraintAnchorArr13[i2];
                        constraintAnchor20 = constraintAnchorArr13[i25];
                        constraintAnchor19 = constraintAnchor24;
                    }
                    if (solverVariable5 != null || solverVariable6 == null) {
                    }
                    int margin6 = constraintAnchor19.getMargin();
                    if (constraintWidget9 != null) {
                        constraintWidget7 = constraintWidget9;
                    }
                    linearSystem.addCentering(constraintAnchor19.mSolverVariable, solverVariable5, margin6, 0.5f, solverVariable6, constraintAnchor20.mSolverVariable, constraintWidget7.mListAnchors[i25].getMargin(), 5);
                    return;
                }
                return;
            }
        }
        if (z7) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
            if (chainHead.mHasUndefinedWeights) {
            }
            float f72 = 0.0f;
            ConstraintWidget constraintWidget162 = null;
            i5 = 0;
            float f82 = 0.0f;
            while (i5 < size) {
            }
        }
        if (constraintWidget8 == null) {
        }
        if (z11) {
        }
        int i152 = 8;
        if (z12) {
            int i162 = chainHead.mWidgetsMatchCount;
            if (i162 <= 0) {
            }
            constraintWidget = constraintWidget8;
            ConstraintWidget constraintWidget182 = constraintWidget;
            while (constraintWidget != null) {
            }
            ConstraintAnchor constraintAnchor162 = constraintWidget8.mListAnchors[i2];
            constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
            int i212 = i2 + 1;
            constraintAnchor2 = constraintWidget9.mListAnchors[i212];
            constraintAnchor3 = constraintWidget7.mListAnchors[i212].mTarget;
            if (constraintAnchor != null) {
            }
            if (constraintAnchor3 != null) {
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
            }
        }
        if (z11) {
        }
        ConstraintAnchor constraintAnchor192 = constraintWidget8.mListAnchors[i2];
        int i252 = i2 + 1;
        ConstraintAnchor constraintAnchor202 = constraintWidget9.mListAnchors[i252];
        ConstraintAnchor constraintAnchor212 = constraintAnchor192.mTarget;
        if (constraintAnchor212 == null) {
        }
        ConstraintAnchor constraintAnchor222 = constraintAnchor202.mTarget;
        if (constraintAnchor222 == null) {
        }
        if (constraintWidget7 == constraintWidget9) {
        }
        if (constraintWidget8 == constraintWidget9) {
        }
        if (solverVariable5 != null) {
        }
    }
}
