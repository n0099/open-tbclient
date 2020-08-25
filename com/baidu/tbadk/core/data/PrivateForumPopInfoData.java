package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes2.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dZK = null;
    private String dZL = null;
    private String dZM = null;
    private Integer dZN = null;

    public void zc(String str) {
        this.dZK = str;
    }

    public String bdD() {
        return this.dZK;
    }

    public void zd(String str) {
        this.dZL = str;
    }

    public String bdE() {
        return this.dZL;
    }

    public void ze(String str) {
        this.dZM = str;
    }

    public String bdF() {
        return this.dZM;
    }

    public void i(Integer num) {
        this.dZN = num;
    }

    public Integer bdG() {
        return this.dZN;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dZK = privatePopInfo.pop_type;
                this.dZL = privatePopInfo.pop_content;
                this.dZM = privatePopInfo.pop_url;
                this.dZN = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
