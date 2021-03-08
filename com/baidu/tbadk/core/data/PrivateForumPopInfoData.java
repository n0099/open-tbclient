package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eQB = null;
    private String eQC = null;
    private String eQD = null;
    private Integer eQE = null;

    public void Ad(String str) {
        this.eQB = str;
    }

    public String bmQ() {
        return this.eQB;
    }

    public void Ae(String str) {
        this.eQC = str;
    }

    public String bmR() {
        return this.eQC;
    }

    public void Af(String str) {
        this.eQD = str;
    }

    public String bmS() {
        return this.eQD;
    }

    public void m(Integer num) {
        this.eQE = num;
    }

    public Integer bmT() {
        return this.eQE;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eQB = privatePopInfo.pop_type;
                this.eQC = privatePopInfo.pop_content;
                this.eQD = privatePopInfo.pop_url;
                this.eQE = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
