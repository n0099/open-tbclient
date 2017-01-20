package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class h {
    private boolean VR;
    private String desc;
    private String tag;
    private String tip;

    public h() {
    }

    public h(String str, String str2, boolean z) {
        this.tip = str;
        this.desc = str2;
        this.VR = z;
    }

    public h(String str, String str2, boolean z, String str3) {
        this.tip = str;
        this.desc = str2;
        this.VR = z;
        this.tag = str3;
    }

    public String te() {
        return this.tip;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.VR;
    }

    public void setChecked(boolean z) {
        this.VR = z;
    }

    public String getTag() {
        return this.tag;
    }
}
