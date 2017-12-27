package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aKm;
    public long aKn;
    public int aKo;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aKm = bookThread.book_id;
            this.aKn = bookThread.chapter_id.longValue();
            this.aKo = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aKm = jSONObject.optString("book_id", "0");
                this.aKn = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aKo = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
