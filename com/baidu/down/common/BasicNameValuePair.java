package com.baidu.down.common;
/* loaded from: classes2.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable {
    public static final int HASH_MULTIPLIER = 37;
    public static final int HASH_SEED = 17;
    public final String mName = "";
    public final String mValue = "";

    public BasicNameValuePair(String str, String str2) {
    }

    private boolean equals(Object obj, Object obj2) {
        return false;
    }

    private int hashCode(int i, int i2) {
        return 0;
    }

    private int hashCode(int i, Object obj) {
        return 0;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.baidu.down.common.NameValuePair
    public String getName() {
        return null;
    }

    @Override // com.baidu.down.common.NameValuePair
    public String getValue() {
        return null;
    }

    public int hashCode() {
        return 0;
    }
}
