package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class g {
    private boolean checked;
    private String desc;
    private String tag;
    private String tip;

    public g() {
    }

    public g(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.checked = z;
    }

    public g(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.checked = z;
        this.tag = str3;
    }

    public String AJ() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public String getTag() {
        return this.tag;
    }
}
