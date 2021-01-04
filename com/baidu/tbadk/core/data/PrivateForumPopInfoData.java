package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eRz = null;
    private String eRA = null;
    private String eRB = null;
    private Integer eRC = null;

    public void AR(String str) {
        this.eRz = str;
    }

    public String bqo() {
        return this.eRz;
    }

    public void AS(String str) {
        this.eRA = str;
    }

    public String bqp() {
        return this.eRA;
    }

    public void AT(String str) {
        this.eRB = str;
    }

    public String bqq() {
        return this.eRB;
    }

    public void m(Integer num) {
        this.eRC = num;
    }

    public Integer bqr() {
        return this.eRC;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eRz = privatePopInfo.pop_type;
                this.eRA = privatePopInfo.pop_content;
                this.eRB = privatePopInfo.pop_url;
                this.eRC = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
