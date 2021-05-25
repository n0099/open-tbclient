package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12042e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12043f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12044g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12045h = null;

    public void A(String str) {
        this.f12044g = str;
    }

    public String s() {
        return this.f12043f;
    }

    public Integer t() {
        return this.f12045h;
    }

    public String u() {
        return this.f12042e;
    }

    public String v() {
        return this.f12044g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12042e = privatePopInfo.pop_type;
            this.f12043f = privatePopInfo.pop_content;
            this.f12044g = privatePopInfo.pop_url;
            this.f12045h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f12043f = str;
    }

    public void y(Integer num) {
        this.f12045h = num;
    }

    public void z(String str) {
        this.f12042e = str;
    }
}
