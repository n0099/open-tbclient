package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eHI = null;
    private String eHJ = null;
    private String eHK = null;
    private Integer eHL = null;

    public void AT(String str) {
        this.eHI = str;
    }

    public String bnO() {
        return this.eHI;
    }

    public void AU(String str) {
        this.eHJ = str;
    }

    public String bnP() {
        return this.eHJ;
    }

    public void AV(String str) {
        this.eHK = str;
    }

    public String bnQ() {
        return this.eHK;
    }

    public void k(Integer num) {
        this.eHL = num;
    }

    public Integer bnR() {
        return this.eHL;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eHI = privatePopInfo.pop_type;
                this.eHJ = privatePopInfo.pop_content;
                this.eHK = privatePopInfo.pop_url;
                this.eHL = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
