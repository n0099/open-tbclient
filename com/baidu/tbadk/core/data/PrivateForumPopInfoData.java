package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12141e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12142f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12143g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12144h = null;

    public void A(String str) {
        this.f12143g = str;
    }

    public String s() {
        return this.f12142f;
    }

    public Integer t() {
        return this.f12144h;
    }

    public String u() {
        return this.f12141e;
    }

    public String v() {
        return this.f12143g;
    }

    public void w(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12141e = privatePopInfo.pop_type;
            this.f12142f = privatePopInfo.pop_content;
            this.f12143g = privatePopInfo.pop_url;
            this.f12144h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void x(String str) {
        this.f12142f = str;
    }

    public void y(Integer num) {
        this.f12144h = num;
    }

    public void z(String str) {
        this.f12141e = str;
    }
}
