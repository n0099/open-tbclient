package com.baidu.searchbox.ai;
/* loaded from: classes3.dex */
public class InferenceException extends Exception {
    public static final int ERR_CONVERT_RESULT = 2;
    public static final int ERR_NO_RESULT = 1;
    public static final int ERR_UNKNOWN = 1000;
    public int status;

    public InferenceException(int i) {
        this.status = 1000;
        this.status = i;
    }

    public InferenceException(int i, String str) {
        super(str);
        this.status = 1000;
        this.status = i;
    }

    public InferenceException(String str) {
        super(str);
        this.status = 1000;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String name = InferenceException.class.getName();
        String localizedMessage = getLocalizedMessage();
        StringBuilder sb = new StringBuilder();
        sb.append(this.status);
        sb.append(":");
        if (localizedMessage != null) {
            name = name + ": " + localizedMessage;
        }
        sb.append(name);
        return sb.toString();
    }
}
