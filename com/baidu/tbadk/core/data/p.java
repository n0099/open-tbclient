package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class p {
    public String eOZ;
    public long ePa;
    public int ePb;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eOZ = bookThread.book_id;
            this.ePa = bookThread.chapter_id.longValue();
            this.ePb = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eOZ = jSONObject.optString("book_id", "0");
                this.ePa = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.ePb = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
