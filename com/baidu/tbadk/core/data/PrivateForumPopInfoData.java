package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String bZG = null;
    private String bZH = null;
    private String bZI = null;
    private Integer bZJ = null;

    public void mQ(String str) {
        this.bZG = str;
    }

    public String ahH() {
        return this.bZG;
    }

    public void mR(String str) {
        this.bZH = str;
    }

    public String ahI() {
        return this.bZH;
    }

    public void mS(String str) {
        this.bZI = str;
    }

    public String ahJ() {
        return this.bZI;
    }

    public void b(Integer num) {
        this.bZJ = num;
    }

    public Integer ahK() {
        return this.bZJ;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.bZG = privatePopInfo.pop_type;
                this.bZH = privatePopInfo.pop_content;
                this.bZI = privatePopInfo.pop_url;
                this.bZJ = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
