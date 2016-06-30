package com.baidu.tbadk.core.frameworkData;
/* loaded from: classes.dex */
public enum IntentAction {
    Activity,
    ActivityForResult,
    StartService,
    StopService;

    /* JADX DEBUG: Replace access to removed values field (Tw) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static IntentAction[] valuesCustom() {
        IntentAction[] valuesCustom = values();
        int length = valuesCustom.length;
        IntentAction[] intentActionArr = new IntentAction[length];
        System.arraycopy(valuesCustom, 0, intentActionArr, 0, length);
        return intentActionArr;
    }
}
