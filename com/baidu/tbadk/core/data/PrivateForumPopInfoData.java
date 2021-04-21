package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12888e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12889f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12890g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12891h = null;

    public void A(String str) {
        this.f12890g = str;
    }

    public String s() {
        return this.f12889f;
    }

    public Integer t() {
        return this.f12891h;
    }

    public String u() {
        return this.f12888e;
    }

    public String v() {
        return this.f12890g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12888e = privatePopInfo.pop_type;
            this.f12889f = privatePopInfo.pop_content;
            this.f12890g = privatePopInfo.pop_url;
            this.f12891h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f12889f = str;
    }

    public void y(Integer num) {
        this.f12891h = num;
    }

    public void z(String str) {
        this.f12888e = str;
    }
}
