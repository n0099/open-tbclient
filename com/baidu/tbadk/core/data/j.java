package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String NA;
    public long NB;
    public int NC;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.NA = bookThread.book_id;
            this.NB = bookThread.chapter_id.longValue();
            this.NC = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.NA = jSONObject.optString("book_id", "0");
                this.NB = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.NC = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
