package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class g {
    private boolean YG;
    private String desc;
    private String tip;

    public g() {
    }

    public g(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.YG = z;
    }

    public String tp() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.YG;
    }

    public void setChecked(boolean z) {
        this.YG = z;
    }
}
