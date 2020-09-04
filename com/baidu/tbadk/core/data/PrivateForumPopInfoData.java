package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dZO = null;
    private String dZP = null;
    private String dZQ = null;
    private Integer dZR = null;

    public void zd(String str) {
        this.dZO = str;
    }

    public String bdD() {
        return this.dZO;
    }

    public void ze(String str) {
        this.dZP = str;
    }

    public String bdE() {
        return this.dZP;
    }

    public void zf(String str) {
        this.dZQ = str;
    }

    public String bdF() {
        return this.dZQ;
    }

    public void i(Integer num) {
        this.dZR = num;
    }

    public Integer bdG() {
        return this.dZR;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dZO = privatePopInfo.pop_type;
                this.dZP = privatePopInfo.pop_content;
                this.dZQ = privatePopInfo.pop_url;
                this.dZR = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
