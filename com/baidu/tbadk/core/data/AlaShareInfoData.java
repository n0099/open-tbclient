package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import tbclient.AlaShareInfo;
/* loaded from: classes.dex */
public class AlaShareInfoData extends OrmObject {
    public String content;
    public long record_tid;
    public int share_count;
    public int share_user_count;

    public void a(AlaShareInfo alaShareInfo) {
        if (alaShareInfo != null) {
            try {
                this.content = alaShareInfo.content;
                this.share_user_count = alaShareInfo.share_user_count.intValue();
                this.share_count = alaShareInfo.share_count.intValue();
                this.record_tid = alaShareInfo.record_tid.longValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
