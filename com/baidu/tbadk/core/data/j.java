package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String ahe;
    public long ahf;
    public int ahg;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.ahe = bookThread.book_id;
            this.ahf = bookThread.chapter_id.longValue();
            this.ahg = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahe = jSONObject.optString("book_id", "0");
                this.ahf = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.ahg = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
