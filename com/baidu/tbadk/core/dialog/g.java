package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class g {
    private boolean Xk;
    private String desc;
    private String tip;

    public g() {
    }

    public g(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.Xk = z;
    }

    public String sY() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Xk;
    }

    public void setChecked(boolean z) {
        this.Xk = z;
    }
}
