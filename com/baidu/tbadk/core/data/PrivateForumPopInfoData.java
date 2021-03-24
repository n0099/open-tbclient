package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f13218e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f13219f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f13220g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f13221h = null;

    public void A(String str) {
        this.f13220g = str;
    }

    public String s() {
        return this.f13219f;
    }

    public Integer t() {
        return this.f13221h;
    }

    public String u() {
        return this.f13218e;
    }

    public String v() {
        return this.f13220g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f13218e = privatePopInfo.pop_type;
            this.f13219f = privatePopInfo.pop_content;
            this.f13220g = privatePopInfo.pop_url;
            this.f13221h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f13219f = str;
    }

    public void y(Integer num) {
        this.f13221h = num;
    }

    public void z(String str) {
        this.f13218e = str;
    }
}
