package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12186e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12187f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12188g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12189h = null;

    public void A(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12186e = privatePopInfo.pop_type;
            this.f12187f = privatePopInfo.pop_content;
            this.f12188g = privatePopInfo.pop_url;
            this.f12189h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void B(String str) {
        this.f12187f = str;
    }

    public void C(Integer num) {
        this.f12189h = num;
    }

    public void D(String str) {
        this.f12186e = str;
    }

    public void E(String str) {
        this.f12188g = str;
    }

    public String w() {
        return this.f12187f;
    }

    public Integer x() {
        return this.f12189h;
    }

    public String y() {
        return this.f12186e;
    }

    public String z() {
        return this.f12188g;
    }
}
