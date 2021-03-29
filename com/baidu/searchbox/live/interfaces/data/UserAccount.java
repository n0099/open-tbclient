package com.baidu.searchbox.live.interfaces.data;

import com.baidu.sapi2.SapiAccount;
import java.util.HashMap;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R$\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0005\"\u0004\b#\u0010\u0007R$\u0010$\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u0005\"\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "", "bduss", "Ljava/lang/String;", "getBduss", "()Ljava/lang/String;", "setBduss", "(Ljava/lang/String;)V", "displayname", "getDisplayname", "setDisplayname", "email", "getEmail", "setEmail", "Ljava/util/HashMap;", "extFields", "Ljava/util/HashMap;", "getExtFields", "()Ljava/util/HashMap;", "setExtFields", "(Ljava/util/HashMap;)V", "nickName", "getNickName", "setNickName", "phone", "getPhone", "setPhone", "protrait", "getProtrait", "setProtrait", SapiAccount.f10606h, "getPtoken", "setPtoken", "uid", "getUid", "setUid", "uk", "getUk", "setUk", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class UserAccount {
    public String bduss;
    public String displayname;
    public String email;
    public HashMap<String, String> extFields;
    public String nickName;
    public String phone;
    public String protrait;
    public String ptoken;
    public String uid;
    public String uk;

    public final String getBduss() {
        return this.bduss;
    }

    public final String getDisplayname() {
        return this.displayname;
    }

    public final String getEmail() {
        return this.email;
    }

    public final HashMap<String, String> getExtFields() {
        return this.extFields;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getProtrait() {
        return this.protrait;
    }

    public final String getPtoken() {
        return this.ptoken;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUk() {
        return this.uk;
    }

    public final void setBduss(String str) {
        this.bduss = str;
    }

    public final void setDisplayname(String str) {
        this.displayname = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setExtFields(HashMap<String, String> hashMap) {
        this.extFields = hashMap;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setProtrait(String str) {
        this.protrait = str;
    }

    public final void setPtoken(String str) {
        this.ptoken = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUk(String str) {
        this.uk = str;
    }
}
