package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cQl = null;
    private String cQm = null;
    private String cQn = null;
    private Integer cQo = null;

    public void sy(String str) {
        this.cQl = str;
    }

    public String aBr() {
        return this.cQl;
    }

    public void sz(String str) {
        this.cQm = str;
    }

    public String aBs() {
        return this.cQm;
    }

    public void sA(String str) {
        this.cQn = str;
    }

    public String aBt() {
        return this.cQn;
    }

    public void g(Integer num) {
        this.cQo = num;
    }

    public Integer aBu() {
        return this.cQo;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cQl = privatePopInfo.pop_type;
                this.cQm = privatePopInfo.pop_content;
                this.cQn = privatePopInfo.pop_url;
                this.cQo = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
