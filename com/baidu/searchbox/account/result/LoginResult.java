package com.baidu.searchbox.account.result;
/* loaded from: classes3.dex */
public abstract class LoginResult {
    public boolean isEnable;
    public boolean isFinish;
    public int resultCode;
    public String resultMsg;

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setFinish(boolean z) {
        this.isFinish = z;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
