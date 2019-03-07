package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bzY = null;
    private String bzZ = null;
    private String bAa = null;
    private Integer bAb = null;

    public void lb(String str) {
        this.bzY = str;
    }

    public String XU() {
        return this.bzY;
    }

    public void lc(String str) {
        this.bzZ = str;
    }

    public String XV() {
        return this.bzZ;
    }

    public void ld(String str) {
        this.bAa = str;
    }

    public String XW() {
        return this.bAa;
    }

    public void b(Integer num) {
        this.bAb = num;
    }

    public Integer XX() {
        return this.bAb;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bzY = privatePopInfo.pop_type;
                this.bzZ = privatePopInfo.pop_content;
                this.bAa = privatePopInfo.pop_url;
                this.bAb = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
