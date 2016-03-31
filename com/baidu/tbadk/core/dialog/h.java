package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class h {
    private boolean Xw;
    private String desc;
    private String tip;

    public h() {
    }

    public h(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.Xw = z;
    }

    public String uy() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Xw;
    }

    public void setChecked(boolean z) {
        this.Xw = z;
    }
}
