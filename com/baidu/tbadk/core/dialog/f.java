package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class f {
    private boolean ZM;
    private String desc;
    private String tag;
    private String tip;

    public f() {
    }

    public f(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.ZM = z;
    }

    public f(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.ZM = z;
        this.tag = str3;
    }

    public String tq() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.ZM;
    }

    public void setChecked(boolean z) {
        this.ZM = z;
    }

    public String getTag() {
        return this.tag;
    }
}
