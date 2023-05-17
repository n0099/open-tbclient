package com.baidu.searchbox.account.result;

import com.baidu.searchbox.NoProGuard;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class AccountOpenBdussResult implements NoProGuard {
    public String bduss;
    public String displayname;
    public String openBduss;
    public String resultMsg;
    public String uid;
    public String unionid;
    public String flag = "";
    public Map<String, String> tplStokenMap = new HashMap();
    public int resultCode = -202;

    public String getBduss() {
        return this.bduss;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getOpenBduss() {
        return this.openBduss;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public Map<String, String> getTplStokenMap() {
        return this.tplStokenMap;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUnionid() {
        return this.unionid;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setOpenBduss(String str) {
        this.openBduss = str;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public void setTplStokenMap(Map<String, String> map) {
        this.tplStokenMap = map;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUnionid(String str) {
        this.unionid = str;
    }
}
