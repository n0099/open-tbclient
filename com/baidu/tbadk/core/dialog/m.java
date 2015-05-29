package com.baidu.tbadk.core.dialog;
/* loaded from: classes.dex */
public class m {
    private String Sq;
    private boolean Sr;
    private String desc;

    public m() {
    }

    public m(String str, String str2, boolean z) {
        this.Sq = str;
        this.desc = str2;
        this.Sr = z;
    }

    public String rS() {
        return this.Sq;
    }

    public String qG() {
        return this.desc;
    }

    public boolean isChecked() {
        return this.Sr;
    }

    public void setChecked(boolean z) {
        this.Sr = z;
    }
}
