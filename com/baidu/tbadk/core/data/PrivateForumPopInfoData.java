package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dpG = null;
    private String dpH = null;
    private String dpI = null;
    private Integer dpJ = null;

    public void tL(String str) {
        this.dpG = str;
    }

    public String aJJ() {
        return this.dpG;
    }

    public void tM(String str) {
        this.dpH = str;
    }

    public String aJK() {
        return this.dpH;
    }

    public void tN(String str) {
        this.dpI = str;
    }

    public String aJL() {
        return this.dpI;
    }

    public void g(Integer num) {
        this.dpJ = num;
    }

    public Integer aJM() {
        return this.dpJ;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dpG = privatePopInfo.pop_type;
                this.dpH = privatePopInfo.pop_content;
                this.dpI = privatePopInfo.pop_url;
                this.dpJ = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
