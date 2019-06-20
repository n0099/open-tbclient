package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bHr = null;
    private String bHs = null;
    private String bHt = null;
    private Integer bHu = null;

    public void mg(String str) {
        this.bHr = str;
    }

    public String acy() {
        return this.bHr;
    }

    public void mh(String str) {
        this.bHs = str;
    }

    public String acz() {
        return this.bHs;
    }

    public void mi(String str) {
        this.bHt = str;
    }

    public String acA() {
        return this.bHt;
    }

    public void b(Integer num) {
        this.bHu = num;
    }

    public Integer acB() {
        return this.bHu;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bHr = privatePopInfo.pop_type;
                this.bHs = privatePopInfo.pop_content;
                this.bHt = privatePopInfo.pop_url;
                this.bHu = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
