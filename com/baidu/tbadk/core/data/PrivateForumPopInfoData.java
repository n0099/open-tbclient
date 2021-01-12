package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eMO = null;
    private String eMP = null;
    private String eMQ = null;
    private Integer eMR = null;

    public void zF(String str) {
        this.eMO = str;
    }

    public String bmv() {
        return this.eMO;
    }

    public void zG(String str) {
        this.eMP = str;
    }

    public String bmw() {
        return this.eMP;
    }

    public void zH(String str) {
        this.eMQ = str;
    }

    public String bmx() {
        return this.eMQ;
    }

    public void m(Integer num) {
        this.eMR = num;
    }

    public Integer bmy() {
        return this.eMR;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eMO = privatePopInfo.pop_type;
                this.eMP = privatePopInfo.pop_content;
                this.eMQ = privatePopInfo.pop_url;
                this.eMR = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
