package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bIs = null;
    private String bIt = null;
    private String bIu = null;
    private Integer bIv = null;

    public void mr(String str) {
        this.bIs = str;
    }

    public String adB() {
        return this.bIs;
    }

    public void ms(String str) {
        this.bIt = str;
    }

    public String adC() {
        return this.bIt;
    }

    public void mt(String str) {
        this.bIu = str;
    }

    public String adD() {
        return this.bIu;
    }

    public void b(Integer num) {
        this.bIv = num;
    }

    public Integer adE() {
        return this.bIv;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bIs = privatePopInfo.pop_type;
                this.bIt = privatePopInfo.pop_content;
                this.bIu = privatePopInfo.pop_url;
                this.bIv = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
