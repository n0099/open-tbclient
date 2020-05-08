package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dpK = null;
    private String dpL = null;
    private String dpM = null;
    private Integer dpN = null;

    public void tO(String str) {
        this.dpK = str;
    }

    public String aJH() {
        return this.dpK;
    }

    public void tP(String str) {
        this.dpL = str;
    }

    public String aJI() {
        return this.dpL;
    }

    public void tQ(String str) {
        this.dpM = str;
    }

    public String aJJ() {
        return this.dpM;
    }

    public void g(Integer num) {
        this.dpN = num;
    }

    public Integer aJK() {
        return this.dpN;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dpK = privatePopInfo.pop_type;
                this.dpL = privatePopInfo.pop_content;
                this.dpM = privatePopInfo.pop_url;
                this.dpN = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
