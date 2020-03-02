package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cQm = null;
    private String cQn = null;
    private String cQo = null;
    private Integer cQp = null;

    public void sy(String str) {
        this.cQm = str;
    }

    public String aBt() {
        return this.cQm;
    }

    public void sz(String str) {
        this.cQn = str;
    }

    public String aBu() {
        return this.cQn;
    }

    public void sA(String str) {
        this.cQo = str;
    }

    public String aBv() {
        return this.cQo;
    }

    public void g(Integer num) {
        this.cQp = num;
    }

    public Integer aBw() {
        return this.cQp;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cQm = privatePopInfo.pop_type;
                this.cQn = privatePopInfo.pop_content;
                this.cQo = privatePopInfo.pop_url;
                this.cQp = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
