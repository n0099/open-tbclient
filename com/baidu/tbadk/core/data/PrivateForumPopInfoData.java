package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12805e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12806f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12807g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12808h = null;

    public void A(String str) {
        this.f12807g = str;
    }

    public String s() {
        return this.f12806f;
    }

    public Integer t() {
        return this.f12808h;
    }

    public String u() {
        return this.f12805e;
    }

    public String v() {
        return this.f12807g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12805e = privatePopInfo.pop_type;
            this.f12806f = privatePopInfo.pop_content;
            this.f12807g = privatePopInfo.pop_url;
            this.f12808h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f12806f = str;
    }

    public void y(Integer num) {
        this.f12808h = num;
    }

    public void z(String str) {
        this.f12805e = str;
    }
}
