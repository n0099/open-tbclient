package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class h {
    private boolean abu;
    private String desc;
    private String tag;
    private String tip;

    public h() {
    }

    public h(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.abu = z;
    }

    public h(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.abu = z;
        this.tag = str3;
    }

    public String tZ() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.abu;
    }

    public void setChecked(boolean z) {
        this.abu = z;
    }

    public String getTag() {
        return this.tag;
    }
}
