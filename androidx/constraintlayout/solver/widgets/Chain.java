package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Chain {
    public static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /* JADX DEBUG: Multi-variable search result rejected for r2v58, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0520 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x03a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget;
        ArrayList<ConstraintWidget> arrayList;
        int i3;
        boolean z5;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i4;
        ConstraintWidget constraintWidget3;
        int i5;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int i6;
        ConstraintWidget constraintWidget5;
        boolean z6;
        SolverVariable solverVariable3;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i7;
        int i8;
        ConstraintWidget constraintWidget6;
        ConstraintAnchor constraintAnchor6;
        SolverVariable solverVariable6;
        ConstraintAnchor constraintAnchor7;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        float f;
        int size;
        float f2;
        int i9;
        ArrayList<ConstraintWidget> arrayList2;
        int i10;
        boolean z7;
        int i11;
        boolean z8;
        boolean z9;
        ConstraintWidget constraintWidget7;
        boolean z10;
        int i12;
        int i13;
        ConstraintWidget constraintWidget8 = chainHead.mFirst;
        ConstraintWidget constraintWidget9 = chainHead.mLast;
        ConstraintWidget constraintWidget10 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget11 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget12 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget13 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget14 = chainHead.mLastMatchConstraintWidget;
        if (constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = true;
        } else {
            z = false;
        }
        if (i == 0) {
            if (constraintWidget12.mHorizontalChainStyle == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (constraintWidget12.mHorizontalChainStyle == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            if (constraintWidget12.mVerticalChainStyle == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (constraintWidget12.mVerticalChainStyle == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        ConstraintWidget constraintWidget15 = constraintWidget8;
        boolean z11 = z3;
        boolean z12 = z2;
        boolean z13 = false;
        while (true) {
            constraintWidget = null;
            if (z13) {
                break;
            }
            ConstraintAnchor constraintAnchor8 = constraintWidget15.mListAnchors[i2];
            if (z4) {
                i11 = 1;
            } else {
                i11 = 4;
            }
            int margin = constraintAnchor8.getMargin();
            float f4 = f3;
            boolean z14 = z13;
            if (constraintWidget15.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget15.mResolvedMatchConstraintDefault[i] == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            ConstraintAnchor constraintAnchor9 = constraintAnchor8.mTarget;
            if (constraintAnchor9 != null && constraintWidget15 != constraintWidget8) {
                margin += constraintAnchor9.getMargin();
            }
            int i14 = margin;
            if (z4 && constraintWidget15 != constraintWidget8 && constraintWidget15 != constraintWidget10) {
                z9 = z11;
                i11 = 8;
            } else {
                z9 = z11;
            }
            ConstraintAnchor constraintAnchor10 = constraintAnchor8.mTarget;
            if (constraintAnchor10 != null) {
                if (constraintWidget15 == constraintWidget10) {
                    z10 = z12;
                    constraintWidget7 = constraintWidget12;
                    linearSystem.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, i14, 6);
                } else {
                    constraintWidget7 = constraintWidget12;
                    z10 = z12;
                    linearSystem.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, i14, 8);
                }
                if (z8 && !z4) {
                    i13 = 5;
                } else {
                    i13 = i11;
                }
                linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, i14, i13);
            } else {
                constraintWidget7 = constraintWidget12;
                z10 = z12;
            }
            if (z) {
                if (constraintWidget15.getVisibility() != 8 && constraintWidget15.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget15.mListAnchors;
                    i12 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                } else {
                    i12 = 0;
                }
                linearSystem.addGreaterThan(constraintWidget15.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i12, 8);
            }
            ConstraintAnchor constraintAnchor11 = constraintWidget15.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor11 != null) {
                ConstraintWidget constraintWidget16 = constraintAnchor11.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == constraintWidget15) {
                    constraintWidget = constraintWidget16;
                }
            }
            if (constraintWidget != null) {
                constraintWidget15 = constraintWidget;
                z13 = z14;
            } else {
                z13 = true;
            }
            z11 = z9;
            f3 = f4;
            z12 = z10;
            constraintWidget12 = constraintWidget7;
        }
        ConstraintWidget constraintWidget17 = constraintWidget12;
        float f5 = f3;
        boolean z15 = z12;
        boolean z16 = z11;
        if (constraintWidget11 != null) {
            int i15 = i2 + 1;
            if (constraintWidget9.mListAnchors[i15].mTarget != null) {
                ConstraintAnchor constraintAnchor12 = constraintWidget11.mListAnchors[i15];
                if (constraintWidget11.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget11.mResolvedMatchConstraintDefault[i] == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7 && !z4) {
                    ConstraintAnchor constraintAnchor13 = constraintAnchor12.mTarget;
                    if (constraintAnchor13.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                        linearSystem.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget9.mListAnchors[i15].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                        if (z) {
                            int i16 = i2 + 1;
                            SolverVariable solverVariable11 = constraintWidgetContainer.mListAnchors[i16].mSolverVariable;
                            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget9.mListAnchors;
                            linearSystem.addGreaterThan(solverVariable11, constraintAnchorArr3[i16].mSolverVariable, constraintAnchorArr3[i16].getMargin(), 8);
                        }
                        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            if (!chainHead.mHasUndefinedWeights && !chainHead.mHasComplexMatchWeights) {
                                f2 = chainHead.mWidgetsMatchCount;
                            } else {
                                f2 = f5;
                            }
                            float f6 = 0.0f;
                            ConstraintWidget constraintWidget18 = null;
                            i9 = 0;
                            float f7 = 0.0f;
                            while (i9 < size) {
                                ConstraintWidget constraintWidget19 = arrayList.get(i9);
                                float f8 = constraintWidget19.mWeight[i];
                                if (f8 < f6) {
                                    if (chainHead.mHasComplexMatchWeights) {
                                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget19.mListAnchors;
                                        linearSystem.addEquality(constraintAnchorArr4[i2 + 1].mSolverVariable, constraintAnchorArr4[i2].mSolverVariable, 0, 4);
                                        arrayList2 = arrayList;
                                        i10 = size;
                                        i9++;
                                        size = i10;
                                        arrayList = arrayList2;
                                        f6 = 0.0f;
                                    } else {
                                        f8 = 1.0f;
                                        f6 = 0.0f;
                                    }
                                }
                                if (f8 == f6) {
                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget19.mListAnchors;
                                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 8);
                                    arrayList2 = arrayList;
                                    i10 = size;
                                    i9++;
                                    size = i10;
                                    arrayList = arrayList2;
                                    f6 = 0.0f;
                                } else {
                                    if (constraintWidget18 != null) {
                                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget18.mListAnchors;
                                        SolverVariable solverVariable12 = constraintAnchorArr6[i2].mSolverVariable;
                                        int i17 = i2 + 1;
                                        SolverVariable solverVariable13 = constraintAnchorArr6[i17].mSolverVariable;
                                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget19.mListAnchors;
                                        arrayList2 = arrayList;
                                        SolverVariable solverVariable14 = constraintAnchorArr7[i2].mSolverVariable;
                                        SolverVariable solverVariable15 = constraintAnchorArr7[i17].mSolverVariable;
                                        i10 = size;
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualMatchDimensions(f7, f2, f8, solverVariable12, solverVariable13, solverVariable14, solverVariable15);
                                        linearSystem.addConstraint(createRow);
                                    } else {
                                        arrayList2 = arrayList;
                                        i10 = size;
                                    }
                                    f7 = f8;
                                    constraintWidget18 = constraintWidget19;
                                    i9++;
                                    size = i10;
                                    arrayList = arrayList2;
                                    f6 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget10 == null && (constraintWidget10 == constraintWidget11 || z4)) {
                            ConstraintAnchor constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                            int i18 = i2 + 1;
                            ConstraintAnchor constraintAnchor15 = constraintWidget9.mListAnchors[i18];
                            ConstraintAnchor constraintAnchor16 = constraintAnchor14.mTarget;
                            if (constraintAnchor16 != null) {
                                solverVariable9 = constraintAnchor16.mSolverVariable;
                            } else {
                                solverVariable9 = null;
                            }
                            ConstraintAnchor constraintAnchor17 = constraintAnchor15.mTarget;
                            if (constraintAnchor17 != null) {
                                solverVariable10 = constraintAnchor17.mSolverVariable;
                            } else {
                                solverVariable10 = null;
                            }
                            ConstraintAnchor constraintAnchor18 = constraintWidget10.mListAnchors[i2];
                            ConstraintAnchor constraintAnchor19 = constraintWidget11.mListAnchors[i18];
                            if (solverVariable9 != null && solverVariable10 != null) {
                                if (i == 0) {
                                    f = constraintWidget17.mHorizontalBiasPercent;
                                } else {
                                    f = constraintWidget17.mVerticalBiasPercent;
                                }
                                linearSystem.addCentering(constraintAnchor18.mSolverVariable, solverVariable9, constraintAnchor18.getMargin(), f, solverVariable10, constraintAnchor19.mSolverVariable, constraintAnchor19.getMargin(), 7);
                            }
                        } else if (!z15 && constraintWidget10 != null) {
                            int i19 = chainHead.mWidgetsMatchCount;
                            if (i19 > 0 && chainHead.mWidgetsCount == i19) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            ConstraintWidget constraintWidget20 = constraintWidget10;
                            ConstraintWidget constraintWidget21 = constraintWidget20;
                            while (constraintWidget20 != null) {
                                ConstraintWidget constraintWidget22 = constraintWidget20.mNextChainWidget[i];
                                while (constraintWidget22 != null && constraintWidget22.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget22.mNextChainWidget[i];
                                }
                                if (constraintWidget22 != null || constraintWidget20 == constraintWidget11) {
                                    ConstraintAnchor constraintAnchor20 = constraintWidget20.mListAnchors[i2];
                                    SolverVariable solverVariable16 = constraintAnchor20.mSolverVariable;
                                    ConstraintAnchor constraintAnchor21 = constraintAnchor20.mTarget;
                                    if (constraintAnchor21 != null) {
                                        solverVariable3 = constraintAnchor21.mSolverVariable;
                                    } else {
                                        solverVariable3 = null;
                                    }
                                    if (constraintWidget21 != constraintWidget20) {
                                        solverVariable3 = constraintWidget21.mListAnchors[i2 + 1].mSolverVariable;
                                    } else if (constraintWidget20 == constraintWidget10 && constraintWidget21 == constraintWidget20) {
                                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget8.mListAnchors;
                                        if (constraintAnchorArr8[i2].mTarget != null) {
                                            solverVariable3 = constraintAnchorArr8[i2].mTarget.mSolverVariable;
                                        } else {
                                            solverVariable3 = null;
                                        }
                                    }
                                    int margin2 = constraintAnchor20.getMargin();
                                    int i20 = i2 + 1;
                                    int margin3 = constraintWidget20.mListAnchors[i20].getMargin();
                                    if (constraintWidget22 != null) {
                                        constraintAnchor5 = constraintWidget22.mListAnchors[i2];
                                        SolverVariable solverVariable17 = constraintAnchor5.mSolverVariable;
                                        solverVariable5 = constraintWidget20.mListAnchors[i20].mSolverVariable;
                                        solverVariable4 = solverVariable17;
                                    } else {
                                        constraintAnchor5 = constraintWidget9.mListAnchors[i20].mTarget;
                                        if (constraintAnchor5 != null) {
                                            solverVariable4 = constraintAnchor5.mSolverVariable;
                                        } else {
                                            solverVariable4 = null;
                                        }
                                        solverVariable5 = constraintWidget20.mListAnchors[i20].mSolverVariable;
                                    }
                                    if (constraintAnchor5 != null) {
                                        margin3 += constraintAnchor5.getMargin();
                                    }
                                    if (constraintWidget21 != null) {
                                        margin2 += constraintWidget21.mListAnchors[i20].getMargin();
                                    }
                                    if (solverVariable16 != null && solverVariable3 != null && solverVariable4 != null && solverVariable5 != null) {
                                        if (constraintWidget20 == constraintWidget10) {
                                            margin2 = constraintWidget10.mListAnchors[i2].getMargin();
                                        }
                                        int i21 = margin2;
                                        if (constraintWidget20 == constraintWidget11) {
                                            i7 = constraintWidget11.mListAnchors[i20].getMargin();
                                        } else {
                                            i7 = margin3;
                                        }
                                        if (z6) {
                                            i8 = 8;
                                        } else {
                                            i8 = 5;
                                        }
                                        SolverVariable solverVariable18 = solverVariable4;
                                        SolverVariable solverVariable19 = solverVariable5;
                                        int i22 = i7;
                                        constraintWidget6 = constraintWidget22;
                                        linearSystem.addCentering(solverVariable16, solverVariable3, i21, 0.5f, solverVariable18, solverVariable19, i22, i8);
                                        if (constraintWidget20.getVisibility() == 8) {
                                            constraintWidget21 = constraintWidget20;
                                        }
                                        constraintWidget20 = constraintWidget6;
                                    }
                                }
                                constraintWidget6 = constraintWidget22;
                                if (constraintWidget20.getVisibility() == 8) {
                                }
                                constraintWidget20 = constraintWidget6;
                            }
                        } else {
                            int i23 = 8;
                            if (z16 && constraintWidget10 != null) {
                                i3 = chainHead.mWidgetsMatchCount;
                                if (i3 <= 0 && chainHead.mWidgetsCount == i3) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                constraintWidget2 = constraintWidget10;
                                ConstraintWidget constraintWidget23 = constraintWidget2;
                                while (constraintWidget2 != null) {
                                    ConstraintWidget constraintWidget24 = constraintWidget2.mNextChainWidget[i];
                                    while (constraintWidget24 != null && constraintWidget24.getVisibility() == i23) {
                                        constraintWidget24 = constraintWidget24.mNextChainWidget[i];
                                    }
                                    if (constraintWidget2 != constraintWidget10 && constraintWidget2 != constraintWidget11 && constraintWidget24 != null) {
                                        if (constraintWidget24 == constraintWidget11) {
                                            constraintWidget4 = null;
                                        } else {
                                            constraintWidget4 = constraintWidget24;
                                        }
                                        ConstraintAnchor constraintAnchor22 = constraintWidget2.mListAnchors[i2];
                                        SolverVariable solverVariable20 = constraintAnchor22.mSolverVariable;
                                        ConstraintAnchor constraintAnchor23 = constraintAnchor22.mTarget;
                                        if (constraintAnchor23 != null) {
                                            SolverVariable solverVariable21 = constraintAnchor23.mSolverVariable;
                                        }
                                        int i24 = i2 + 1;
                                        SolverVariable solverVariable22 = constraintWidget23.mListAnchors[i24].mSolverVariable;
                                        int margin4 = constraintAnchor22.getMargin();
                                        int margin5 = constraintWidget2.mListAnchors[i24].getMargin();
                                        if (constraintWidget4 != null) {
                                            constraintAnchor4 = constraintWidget4.mListAnchors[i2];
                                            solverVariable = constraintAnchor4.mSolverVariable;
                                            ConstraintAnchor constraintAnchor24 = constraintAnchor4.mTarget;
                                            if (constraintAnchor24 != null) {
                                                solverVariable2 = constraintAnchor24.mSolverVariable;
                                            } else {
                                                solverVariable2 = null;
                                            }
                                        } else {
                                            constraintAnchor4 = constraintWidget11.mListAnchors[i2];
                                            if (constraintAnchor4 != null) {
                                                solverVariable = constraintAnchor4.mSolverVariable;
                                            } else {
                                                solverVariable = null;
                                            }
                                            solverVariable2 = constraintWidget2.mListAnchors[i24].mSolverVariable;
                                        }
                                        if (constraintAnchor4 != null) {
                                            margin5 += constraintAnchor4.getMargin();
                                        }
                                        int i25 = margin5;
                                        if (constraintWidget23 != null) {
                                            margin4 += constraintWidget23.mListAnchors[i24].getMargin();
                                        }
                                        int i26 = margin4;
                                        if (z5) {
                                            i6 = 8;
                                        } else {
                                            i6 = 4;
                                        }
                                        if (solverVariable20 != null && solverVariable22 != null && solverVariable != null && solverVariable2 != null) {
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget3 = constraintWidget23;
                                            i5 = 8;
                                            linearSystem.addCentering(solverVariable20, solverVariable22, i26, 0.5f, solverVariable, solverVariable2, i25, i6);
                                        } else {
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget3 = constraintWidget23;
                                            i5 = 8;
                                        }
                                        constraintWidget24 = constraintWidget5;
                                    } else {
                                        constraintWidget3 = constraintWidget23;
                                        i5 = 8;
                                    }
                                    if (constraintWidget2.getVisibility() == i5) {
                                        constraintWidget2 = constraintWidget3;
                                    }
                                    constraintWidget23 = constraintWidget2;
                                    i23 = 8;
                                    constraintWidget2 = constraintWidget24;
                                }
                                ConstraintAnchor constraintAnchor25 = constraintWidget10.mListAnchors[i2];
                                constraintAnchor = constraintWidget8.mListAnchors[i2].mTarget;
                                int i27 = i2 + 1;
                                constraintAnchor2 = constraintWidget11.mListAnchors[i27];
                                constraintAnchor3 = constraintWidget9.mListAnchors[i27].mTarget;
                                if (constraintAnchor == null) {
                                    if (constraintWidget10 != constraintWidget11) {
                                        i4 = 5;
                                        linearSystem.addEquality(constraintAnchor25.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor25.getMargin(), 5);
                                    } else {
                                        i4 = 5;
                                        if (constraintAnchor3 != null) {
                                            linearSystem.addCentering(constraintAnchor25.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor25.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                                        }
                                    }
                                } else {
                                    i4 = 5;
                                }
                                if (constraintAnchor3 != null && constraintWidget10 != constraintWidget11) {
                                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i4);
                                }
                            }
                        }
                        if ((!z15 || z16) && constraintWidget10 != null && constraintWidget10 != constraintWidget11) {
                            ConstraintAnchor constraintAnchor26 = constraintWidget10.mListAnchors[i2];
                            int i28 = i2 + 1;
                            ConstraintAnchor constraintAnchor27 = constraintWidget11.mListAnchors[i28];
                            constraintAnchor6 = constraintAnchor26.mTarget;
                            if (constraintAnchor6 != null) {
                                solverVariable6 = constraintAnchor6.mSolverVariable;
                            } else {
                                solverVariable6 = null;
                            }
                            constraintAnchor7 = constraintAnchor27.mTarget;
                            if (constraintAnchor7 != null) {
                                solverVariable7 = constraintAnchor7.mSolverVariable;
                            } else {
                                solverVariable7 = null;
                            }
                            if (constraintWidget9 != constraintWidget11) {
                                ConstraintAnchor constraintAnchor28 = constraintWidget9.mListAnchors[i28].mTarget;
                                if (constraintAnchor28 != null) {
                                    constraintWidget = constraintAnchor28.mSolverVariable;
                                }
                                solverVariable8 = constraintWidget;
                            } else {
                                solverVariable8 = solverVariable7;
                            }
                            if (constraintWidget10 == constraintWidget11) {
                                ConstraintAnchor[] constraintAnchorArr9 = constraintWidget10.mListAnchors;
                                ConstraintAnchor constraintAnchor29 = constraintAnchorArr9[i2];
                                constraintAnchor27 = constraintAnchorArr9[i28];
                                constraintAnchor26 = constraintAnchor29;
                            }
                            if (solverVariable6 != null && solverVariable8 != null) {
                                int margin6 = constraintAnchor26.getMargin();
                                if (constraintWidget11 != null) {
                                    constraintWidget9 = constraintWidget11;
                                }
                                linearSystem.addCentering(constraintAnchor26.mSolverVariable, solverVariable6, margin6, 0.5f, solverVariable8, constraintAnchor27.mSolverVariable, constraintWidget9.mListAnchors[i28].getMargin(), 5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (z4) {
                    ConstraintAnchor constraintAnchor30 = constraintAnchor12.mTarget;
                    if (constraintAnchor30.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor30.mSolverVariable, -constraintAnchor12.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget9.mListAnchors[i15].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                if (z) {
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null) {
                    if (!chainHead.mHasUndefinedWeights) {
                    }
                    f2 = f5;
                    float f62 = 0.0f;
                    ConstraintWidget constraintWidget182 = null;
                    i9 = 0;
                    float f72 = 0.0f;
                    while (i9 < size) {
                    }
                }
                if (constraintWidget10 == null) {
                }
                if (!z15) {
                }
                int i232 = 8;
                if (z16) {
                    i3 = chainHead.mWidgetsMatchCount;
                    if (i3 <= 0) {
                    }
                    z5 = false;
                    constraintWidget2 = constraintWidget10;
                    ConstraintWidget constraintWidget232 = constraintWidget2;
                    while (constraintWidget2 != null) {
                    }
                    ConstraintAnchor constraintAnchor252 = constraintWidget10.mListAnchors[i2];
                    constraintAnchor = constraintWidget8.mListAnchors[i2].mTarget;
                    int i272 = i2 + 1;
                    constraintAnchor2 = constraintWidget11.mListAnchors[i272];
                    constraintAnchor3 = constraintWidget9.mListAnchors[i272].mTarget;
                    if (constraintAnchor == null) {
                    }
                    if (constraintAnchor3 != null) {
                        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i4);
                    }
                }
                if (!z15) {
                }
                ConstraintAnchor constraintAnchor262 = constraintWidget10.mListAnchors[i2];
                int i282 = i2 + 1;
                ConstraintAnchor constraintAnchor272 = constraintWidget11.mListAnchors[i282];
                constraintAnchor6 = constraintAnchor262.mTarget;
                if (constraintAnchor6 != null) {
                }
                constraintAnchor7 = constraintAnchor272.mTarget;
                if (constraintAnchor7 != null) {
                }
                if (constraintWidget9 != constraintWidget11) {
                }
                if (constraintWidget10 == constraintWidget11) {
                }
                if (solverVariable6 != null) {
                    return;
                }
                return;
            }
        }
        if (z) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
        }
        if (constraintWidget10 == null) {
        }
        if (!z15) {
        }
        int i2322 = 8;
        if (z16) {
        }
        if (!z15) {
        }
        ConstraintAnchor constraintAnchor2622 = constraintWidget10.mListAnchors[i2];
        int i2822 = i2 + 1;
        ConstraintAnchor constraintAnchor2722 = constraintWidget11.mListAnchors[i2822];
        constraintAnchor6 = constraintAnchor2622.mTarget;
        if (constraintAnchor6 != null) {
        }
        constraintAnchor7 = constraintAnchor2722.mTarget;
        if (constraintAnchor7 != null) {
        }
        if (constraintWidget9 != constraintWidget11) {
        }
        if (constraintWidget10 == constraintWidget11) {
        }
        if (solverVariable6 != null) {
        }
    }

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = i4;
            i3 = 2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }
}
