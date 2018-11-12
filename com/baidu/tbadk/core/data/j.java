package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String amN;
    public long amO;
    public int amP;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.amN = bookThread.book_id;
            this.amO = bookThread.chapter_id.longValue();
            this.amP = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.amN = jSONObject.optString("book_id", "0");
                this.amO = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.amP = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
