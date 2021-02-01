package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String ePa = null;
    private String ePb = null;
    private String ePc = null;
    private Integer ePd = null;

    public void zW(String str) {
        this.ePa = str;
    }

    public String bmO() {
        return this.ePa;
    }

    public void zX(String str) {
        this.ePb = str;
    }

    public String bmP() {
        return this.ePb;
    }

    public void zY(String str) {
        this.ePc = str;
    }

    public String bmQ() {
        return this.ePc;
    }

    public void m(Integer num) {
        this.ePd = num;
    }

    public Integer bmR() {
        return this.ePd;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.ePa = privatePopInfo.pop_type;
                this.ePb = privatePopInfo.pop_content;
                this.ePc = privatePopInfo.pop_url;
                this.ePd = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
