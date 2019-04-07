package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bAd = null;
    private String bAe = null;
    private String bAf = null;
    private Integer bAg = null;

    public void lc(String str) {
        this.bAd = str;
    }

    public String XR() {
        return this.bAd;
    }

    public void ld(String str) {
        this.bAe = str;
    }

    public String XS() {
        return this.bAe;
    }

    public void le(String str) {
        this.bAf = str;
    }

    public String XT() {
        return this.bAf;
    }

    public void b(Integer num) {
        this.bAg = num;
    }

    public Integer XU() {
        return this.bAg;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bAd = privatePopInfo.pop_type;
                this.bAe = privatePopInfo.pop_content;
                this.bAf = privatePopInfo.pop_url;
                this.bAg = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
