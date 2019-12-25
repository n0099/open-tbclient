package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cLY = null;
    private String cLZ = null;
    private String cMa = null;
    private Integer cMb = null;

    public void se(String str) {
        this.cLY = str;
    }

    public String ayH() {
        return this.cLY;
    }

    public void sf(String str) {
        this.cLZ = str;
    }

    public String ayI() {
        return this.cLZ;
    }

    public void sg(String str) {
        this.cMa = str;
    }

    public String ayJ() {
        return this.cMa;
    }

    public void g(Integer num) {
        this.cMb = num;
    }

    public Integer ayK() {
        return this.cMb;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cLY = privatePopInfo.pop_type;
                this.cLZ = privatePopInfo.pop_content;
                this.cMa = privatePopInfo.pop_url;
                this.cMb = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
