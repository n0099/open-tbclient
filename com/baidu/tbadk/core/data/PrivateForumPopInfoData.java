package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.PrivatePopInfo;
/* loaded from: classes.dex */
public class PrivateForumPopInfoData extends OrmObject {
    private String dQr = null;
    private String dQs = null;
    private String dQt = null;
    private Integer dQu = null;

    public void wO(String str) {
        this.dQr = str;
    }

    public String aVk() {
        return this.dQr;
    }

    public void wP(String str) {
        this.dQs = str;
    }

    public String aVl() {
        return this.dQs;
    }

    public void wQ(String str) {
        this.dQt = str;
    }

    public String aVm() {
        return this.dQt;
    }

    public void h(Integer num) {
        this.dQu = num;
    }

    public Integer aVn() {
        return this.dQu;
    }

    public void a(PrivatePopInfo privatePopInfo) {
        if (privatePopInfo != null) {
            try {
                this.dQr = privatePopInfo.pop_type;
                this.dQs = privatePopInfo.pop_content;
                this.dQt = privatePopInfo.pop_url;
                this.dQu = privatePopInfo.pop_forum_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
