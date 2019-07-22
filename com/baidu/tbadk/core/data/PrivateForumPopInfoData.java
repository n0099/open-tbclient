package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bIr = null;
    private String bIs = null;
    private String bIt = null;
    private Integer bIu = null;

    public void mr(String str) {
        this.bIr = str;
    }

    public String adA() {
        return this.bIr;
    }

    public void ms(String str) {
        this.bIs = str;
    }

    public String adB() {
        return this.bIs;
    }

    public void mt(String str) {
        this.bIt = str;
    }

    public String adC() {
        return this.bIt;
    }

    public void b(Integer num) {
        this.bIu = num;
    }

    public Integer adD() {
        return this.bIu;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bIr = privatePopInfo.pop_type;
                this.bIs = privatePopInfo.pop_content;
                this.bIt = privatePopInfo.pop_url;
                this.bIu = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
