package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class g {
    private boolean Xn;
    private String desc;
    private String tip;

    public g() {
    }

    public g(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.Xn = z;
    }

    public String sX() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Xn;
    }

    public void setChecked(boolean z) {
        this.Xn = z;
    }
}
