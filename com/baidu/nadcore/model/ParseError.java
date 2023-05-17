package com.baidu.nadcore.model;
/* loaded from: classes3.dex */
public class ParseError extends Exception {
    public String mExtraParam;
    public String mPid;
    public final int mReason;
    public String mTplName;
    public final int mType;

    public ParseError(int i, int i2, String str) {
        this(i, i2, str, null);
    }

    public static ParseError contentError(int i, String str, String str2) {
        return new ParseError(10, i, str, str2, null);
    }

    public static ParseError parseError(int i, String str, String str2) {
        return new ParseError(10, i, null, str, str2);
    }

    public ParseError(int i, int i2, String str, String str2) {
        this(i, i2, str, str2, null);
    }

    public ParseError(int i, int i2, String str, String str2, String str3) {
        this.mType = i;
        this.mReason = i2;
        this.mTplName = str;
        this.mExtraParam = str2;
        this.mPid = str3;
    }

    public static ParseError contentError(int i, String str) {
        return new ParseError(10, i, str);
    }

    public static ParseError parseError(int i, String str) {
        return parseError(i, str, null);
    }

    public static ParseError smoothScroll(String str) {
        return new ParseError(4, -1, str);
    }

    public static ParseError timeOut(String str) {
        return new ParseError(5, -1, str);
    }
}
