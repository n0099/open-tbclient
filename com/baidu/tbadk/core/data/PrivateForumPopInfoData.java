package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cMi = null;
    private String cMj = null;
    private String cMk = null;
    private Integer cMl = null;

    public void sh(String str) {
        this.cMi = str;
    }

    public String aza() {
        return this.cMi;
    }

    public void si(String str) {
        this.cMj = str;
    }

    public String azb() {
        return this.cMj;
    }

    public void sj(String str) {
        this.cMk = str;
    }

    public String azc() {
        return this.cMk;
    }

    public void g(Integer num) {
        this.cMl = num;
    }

    public Integer azd() {
        return this.cMl;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cMi = privatePopInfo.pop_type;
                this.cMj = privatePopInfo.pop_content;
                this.cMk = privatePopInfo.pop_url;
                this.cMl = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
