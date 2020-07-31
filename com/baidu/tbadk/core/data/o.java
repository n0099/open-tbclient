package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String dOb;
    public long dOc;
    public int dOd;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dOb = bookThread.book_id;
            this.dOc = bookThread.chapter_id.longValue();
            this.dOd = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dOb = jSONObject.optString("book_id", "0");
                this.dOc = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dOd = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
