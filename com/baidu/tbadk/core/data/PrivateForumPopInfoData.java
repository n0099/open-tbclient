package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cQn = null;
    private String cQo = null;
    private String cQp = null;
    private Integer cQq = null;

    public void sy(String str) {
        this.cQn = str;
    }

    public String aBt() {
        return this.cQn;
    }

    public void sz(String str) {
        this.cQo = str;
    }

    public String aBu() {
        return this.cQo;
    }

    public void sA(String str) {
        this.cQp = str;
    }

    public String aBv() {
        return this.cQp;
    }

    public void g(Integer num) {
        this.cQq = num;
    }

    public Integer aBw() {
        return this.cQq;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cQn = privatePopInfo.pop_type;
                this.cQo = privatePopInfo.pop_content;
                this.cQp = privatePopInfo.pop_url;
                this.cQq = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
