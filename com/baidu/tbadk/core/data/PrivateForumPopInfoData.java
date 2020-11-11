package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eCs = null;
    private String eCt = null;
    private String eCu = null;
    private Integer eCv = null;

    public void AR(String str) {
        this.eCs = str;
    }

    public String blz() {
        return this.eCs;
    }

    public void AS(String str) {
        this.eCt = str;
    }

    public String blA() {
        return this.eCt;
    }

    public void AT(String str) {
        this.eCu = str;
    }

    public String blB() {
        return this.eCu;
    }

    public void k(Integer num) {
        this.eCv = num;
    }

    public Integer blC() {
        return this.eCv;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eCs = privatePopInfo.pop_type;
                this.eCt = privatePopInfo.pop_content;
                this.eCu = privatePopInfo.pop_url;
                this.eCv = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
