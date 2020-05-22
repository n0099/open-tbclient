package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dDJ = null;
    private String dDK = null;
    private String dDL = null;
    private Integer dDM = null;

    public void vu(String str) {
        this.dDJ = str;
    }

    public String aPC() {
        return this.dDJ;
    }

    public void vv(String str) {
        this.dDK = str;
    }

    public String aPD() {
        return this.dDK;
    }

    public void vw(String str) {
        this.dDL = str;
    }

    public String aPE() {
        return this.dDL;
    }

    public void h(Integer num) {
        this.dDM = num;
    }

    public Integer aPF() {
        return this.dDM;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dDJ = privatePopInfo.pop_type;
                this.dDK = privatePopInfo.pop_content;
                this.dDL = privatePopInfo.pop_url;
                this.dDM = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
