package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class h {
    private boolean abe;
    private String desc;
    private String tag;
    private String tip;

    public h() {
    }

    public h(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.abe = z;
    }

    public h(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.abe = z;
        this.tag = str3;
    }

    public String tB() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.abe;
    }

    public void setChecked(boolean z) {
        this.abe = z;
    }

    public String getTag() {
        return this.tag;
    }
}
