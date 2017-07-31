package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class f {
    private boolean abi;
    private String desc;
    private String tag;
    private String tip;

    public f() {
    }

    public f(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.abi = z;
    }

    public f(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.abi = z;
        this.tag = str3;
    }

    public String tA() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.abi;
    }

    public void setChecked(boolean z) {
        this.abi = z;
    }

    public String getTag() {
        return this.tag;
    }
}
