package com.baidu.adp.widget.refresh;
/* loaded from: classes.dex */
public interface IRefreshable {

    /* loaded from: classes.dex */
    public enum State {
        idle,
        pulling_no_refresh,
        animating,
        pulling_refresh;

        /* JADX DEBUG: Replace access to removed values field (Je) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }
}
