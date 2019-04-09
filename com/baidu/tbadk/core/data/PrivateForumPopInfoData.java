package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bAe = null;
    private String bAf = null;
    private String bAg = null;
    private Integer bAh = null;

    public void lc(String str) {
        this.bAe = str;
    }

    public String XR() {
        return this.bAe;
    }

    public void ld(String str) {
        this.bAf = str;
    }

    public String XS() {
        return this.bAf;
    }

    public void le(String str) {
        this.bAg = str;
    }

    public String XT() {
        return this.bAg;
    }

    public void b(Integer num) {
        this.bAh = num;
    }

    public Integer XU() {
        return this.bAh;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bAe = privatePopInfo.pop_type;
                this.bAf = privatePopInfo.pop_content;
                this.bAg = privatePopInfo.pop_url;
                this.bAh = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
