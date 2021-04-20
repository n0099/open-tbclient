package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12880e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12881f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12882g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12883h = null;

    public void A(String str) {
        this.f12882g = str;
    }

    public String s() {
        return this.f12881f;
    }

    public Integer t() {
        return this.f12883h;
    }

    public String u() {
        return this.f12880e;
    }

    public String v() {
        return this.f12882g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12880e = privatePopInfo.pop_type;
            this.f12881f = privatePopInfo.pop_content;
            this.f12882g = privatePopInfo.pop_url;
            this.f12883h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f12881f = str;
    }

    public void y(Integer num) {
        this.f12883h = num;
    }

    public void z(String str) {
        this.f12880e = str;
    }
}
