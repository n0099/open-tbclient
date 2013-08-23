package com.baidu.adp.lib.skin;
/* loaded from: classes.dex */
public interface Hooker {

    /* loaded from: classes.dex */
    public enum HookerType {
        LITERAL_STRING,
        LITERAL_COLOR,
        REFERENCE_ID;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HookerType[] valuesCustom() {
            HookerType[] valuesCustom = values();
            int length = valuesCustom.length;
            HookerType[] hookerTypeArr = new HookerType[length];
            System.arraycopy(valuesCustom, 0, hookerTypeArr, 0, length);
            return hookerTypeArr;
        }
    }
}
