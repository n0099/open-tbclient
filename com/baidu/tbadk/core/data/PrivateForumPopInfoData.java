package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String cax = null;
    private String cay = null;
    private String caz = null;
    private Integer caA = null;

    public void mQ(String str) {
        this.cax = str;
    }

    public String ahJ() {
        return this.cax;
    }

    public void mR(String str) {
        this.cay = str;
    }

    public String ahK() {
        return this.cay;
    }

    public void mS(String str) {
        this.caz = str;
    }

    public String ahL() {
        return this.caz;
    }

    public void b(Integer num) {
        this.caA = num;
    }

    public Integer ahM() {
        return this.caA;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.cax = privatePopInfo.pop_type;
                this.cay = privatePopInfo.pop_content;
                this.caz = privatePopInfo.pop_url;
                this.caA = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
