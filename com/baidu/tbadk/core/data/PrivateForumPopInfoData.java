package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bAa = null;
    private String bAb = null;
    private String bAc = null;
    private Integer bAd = null;

    public void lb(String str) {
        this.bAa = str;
    }

    public String XU() {
        return this.bAa;
    }

    public void lc(String str) {
        this.bAb = str;
    }

    public String XV() {
        return this.bAb;
    }

    public void ld(String str) {
        this.bAc = str;
    }

    public String XW() {
        return this.bAc;
    }

    public void b(Integer num) {
        this.bAd = num;
    }

    public Integer XX() {
        return this.bAd;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bAa = privatePopInfo.pop_type;
                this.bAb = privatePopInfo.pop_content;
                this.bAc = privatePopInfo.pop_url;
                this.bAd = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
