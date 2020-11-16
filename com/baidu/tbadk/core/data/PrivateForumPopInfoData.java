package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eAJ = null;
    private String eAK = null;
    private String eAL = null;
    private Integer eAM = null;

    public void Am(String str) {
        this.eAJ = str;
    }

    public String bkB() {
        return this.eAJ;
    }

    public void An(String str) {
        this.eAK = str;
    }

    public String bkC() {
        return this.eAK;
    }

    public void Ao(String str) {
        this.eAL = str;
    }

    public String bkD() {
        return this.eAL;
    }

    public void k(Integer num) {
        this.eAM = num;
    }

    public Integer bkE() {
        return this.eAM;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eAJ = privatePopInfo.pop_type;
                this.eAK = privatePopInfo.pop_content;
                this.eAL = privatePopInfo.pop_url;
                this.eAM = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
