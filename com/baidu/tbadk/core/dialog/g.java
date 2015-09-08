package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class g {
    private boolean Xt;
    private String desc;
    private String tip;

    public g() {
    }

    public g(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.Xt = z;
    }

    public String td() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Xt;
    }

    public void setChecked(boolean z) {
        this.Xt = z;
    }
}
