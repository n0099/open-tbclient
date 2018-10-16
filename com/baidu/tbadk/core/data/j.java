package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String ama;
    public long amb;
    public int amc;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.ama = bookThread.book_id;
            this.amb = bookThread.chapter_id.longValue();
            this.amc = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ama = jSONObject.optString("book_id", "0");
                this.amb = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.amc = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
