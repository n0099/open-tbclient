package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cQA = null;
    private String cQB = null;
    private String cQC = null;
    private Integer cQD = null;

    public void sx(String str) {
        this.cQA = str;
    }

    public String aBw() {
        return this.cQA;
    }

    public void sy(String str) {
        this.cQB = str;
    }

    public String aBx() {
        return this.cQB;
    }

    public void sz(String str) {
        this.cQC = str;
    }

    public String aBy() {
        return this.cQC;
    }

    public void g(Integer num) {
        this.cQD = num;
    }

    public Integer aBz() {
        return this.cQD;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cQA = privatePopInfo.pop_type;
                this.cQB = privatePopInfo.pop_content;
                this.cQC = privatePopInfo.pop_url;
                this.cQD = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
