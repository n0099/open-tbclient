package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aKn;
    public long aKo;
    public int aKp;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aKn = bookThread.book_id;
            this.aKo = bookThread.chapter_id.longValue();
            this.aKp = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aKn = jSONObject.optString("book_id", "0");
                this.aKo = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aKp = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
