package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String ebY = null;
    private String ebZ = null;
    private String eca = null;
    private Integer ecb = null;

    public void zy(String str) {
        this.ebY = str;
    }

    public String bex() {
        return this.ebY;
    }

    public void zz(String str) {
        this.ebZ = str;
    }

    public String bey() {
        return this.ebZ;
    }

    public void zA(String str) {
        this.eca = str;
    }

    public String bez() {
        return this.eca;
    }

    public void i(Integer num) {
        this.ecb = num;
    }

    public Integer beA() {
        return this.ecb;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.ebY = privatePopInfo.pop_type;
                this.ebZ = privatePopInfo.pop_content;
                this.eca = privatePopInfo.pop_url;
                this.ecb = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
