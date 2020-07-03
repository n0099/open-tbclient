package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dKf = null;
    private String dKg = null;
    private String dKh = null;
    private Integer dKi = null;

    public void vH(String str) {
        this.dKf = str;
    }

    public String aRo() {
        return this.dKf;
    }

    public void vI(String str) {
        this.dKg = str;
    }

    public String aRp() {
        return this.dKg;
    }

    public void vJ(String str) {
        this.dKh = str;
    }

    public String aRq() {
        return this.dKh;
    }

    public void h(Integer num) {
        this.dKi = num;
    }

    public Integer aRr() {
        return this.dKi;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dKf = privatePopInfo.pop_type;
                this.dKg = privatePopInfo.pop_content;
                this.dKh = privatePopInfo.pop_url;
                this.dKi = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
