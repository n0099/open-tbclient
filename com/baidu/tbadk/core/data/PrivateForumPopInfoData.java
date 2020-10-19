package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String eoc = null;
    private String eod = null;
    private String eoe = null;
    private Integer eog = null;

    public void Ak(String str) {
        this.eoc = str;
    }

    public String bhg() {
        return this.eoc;
    }

    public void Al(String str) {
        this.eod = str;
    }

    public String bhh() {
        return this.eod;
    }

    public void Am(String str) {
        this.eoe = str;
    }

    public String bhi() {
        return this.eoe;
    }

    public void k(Integer num) {
        this.eog = num;
    }

    public Integer bhj() {
        return this.eog;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.eoc = privatePopInfo.pop_type;
                this.eod = privatePopInfo.pop_content;
                this.eoe = privatePopInfo.pop_url;
                this.eog = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
