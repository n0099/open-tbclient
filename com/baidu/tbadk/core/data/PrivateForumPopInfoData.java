package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes3.dex */
public class PrivateForumPopInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f12104e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f12105f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f12106g = null;

    /* renamed from: h  reason: collision with root package name */
    public Integer f12107h = null;

    public void A(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo == null) {
            return;
        }
        try {
            this.f12104e = privatePopInfo.pop_type;
            this.f12105f = privatePopInfo.pop_content;
            this.f12106g = privatePopInfo.pop_url;
            this.f12107h = privatePopInfo.pop_forum_id;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void B(String str) {
        this.f12105f = str;
    }

    public void C(Integer num) {
        this.f12107h = num;
    }

    public void D(String str) {
        this.f12104e = str;
    }

    public void E(String str) {
        this.f12106g = str;
    }

    public String w() {
        return this.f12105f;
    }

    public Integer x() {
        return this.f12107h;
    }

    public String y() {
        return this.f12104e;
    }

    public String z() {
        return this.f12106g;
    }
}
