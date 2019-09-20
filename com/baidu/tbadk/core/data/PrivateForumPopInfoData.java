package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bIQ = null;
    private String bIR = null;
    private String bIS = null;
    private Integer bIT = null;

    public void mt(String str) {
        this.bIQ = str;
    }

    public String adF() {
        return this.bIQ;
    }

    public void mu(String str) {
        this.bIR = str;
    }

    public String adG() {
        return this.bIR;
    }

    public void mv(String str) {
        this.bIS = str;
    }

    public String adH() {
        return this.bIS;
    }

    public void b(Integer num) {
        this.bIT = num;
    }

    public Integer adI() {
        return this.bIT;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bIQ = privatePopInfo.pop_type;
                this.bIR = privatePopInfo.pop_content;
                this.bIS = privatePopInfo.pop_url;
                this.bIT = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
