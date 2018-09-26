package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Set;
/* loaded from: classes3.dex */
public class JPushMessage implements Serializable {
    private String a;
    private Set<String> b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;
    private String h;

    public String getAlias() {
        return this.a;
    }

    public String getCheckTag() {
        return this.c;
    }

    public int getErrorCode() {
        return this.d;
    }

    public String getMobileNumber() {
        return this.h;
    }

    public int getSequence() {
        return this.g;
    }

    public boolean getTagCheckStateResult() {
        return this.e;
    }

    public Set<String> getTags() {
        return this.b;
    }

    public boolean isTagCheckOperator() {
        return this.f;
    }

    public void setAlias(String str) {
        this.a = str;
    }

    public void setCheckTag(String str) {
        this.c = str;
    }

    public void setErrorCode(int i) {
        this.d = i;
    }

    public void setMobileNumber(String str) {
        this.h = str;
    }

    public void setSequence(int i) {
        this.g = i;
    }

    public void setTagCheckOperator(boolean z) {
        this.f = z;
    }

    public void setTagCheckStateResult(boolean z) {
        this.e = z;
    }

    public void setTags(Set<String> set) {
        this.b = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.a + "', tags=" + this.b + ", checkTag='" + this.c + "', errorCode=" + this.d + ", tagCheckStateResult=" + this.e + ", isTagCheckOperator=" + this.f + ", sequence=" + this.g + ", mobileNumber=" + this.h + '}';
    }
}
