package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bHq = null;
    private String bHr = null;
    private String bHs = null;
    private Integer bHt = null;

    public void mh(String str) {
        this.bHq = str;
    }

    public String acy() {
        return this.bHq;
    }

    public void mi(String str) {
        this.bHr = str;
    }

    public String acz() {
        return this.bHr;
    }

    public void mj(String str) {
        this.bHs = str;
    }

    public String acA() {
        return this.bHs;
    }

    public void b(Integer num) {
        this.bHt = num;
    }

    public Integer acB() {
        return this.bHt;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bHq = privatePopInfo.pop_type;
                this.bHr = privatePopInfo.pop_content;
                this.bHs = privatePopInfo.pop_url;
                this.bHt = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
