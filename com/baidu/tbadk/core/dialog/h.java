package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class h {
    private boolean Zd;
    private String desc;
    private String tip;

    public h() {
    }

    public h(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.Zd = z;
    }

    public String ut() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Zd;
    }

    public void setChecked(boolean z) {
        this.Zd = z;
    }
}
