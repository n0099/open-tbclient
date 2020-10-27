package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String ewA = null;
    private String ewB = null;
    private String ewC = null;
    private Integer ewD = null;

    public void AD(String str) {
        this.ewA = str;
    }

    public String biZ() {
        return this.ewA;
    }

    public void AE(String str) {
        this.ewB = str;
    }

    public String bja() {
        return this.ewB;
    }

    public void AF(String str) {
        this.ewC = str;
    }

    public String bjb() {
        return this.ewC;
    }

    public void k(Integer num) {
        this.ewD = num;
    }

    public Integer bjc() {
        return this.ewD;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.ewA = privatePopInfo.pop_type;
                this.ewB = privatePopInfo.pop_content;
                this.ewC = privatePopInfo.pop_url;
                this.ewD = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
