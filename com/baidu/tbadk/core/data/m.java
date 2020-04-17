package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String dnr;
    public long dnt;
    public int dnu;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dnr = bookThread.book_id;
            this.dnt = bookThread.chapter_id.longValue();
            this.dnu = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dnr = jSONObject.optString("book_id", "0");
                this.dnt = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dnu = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
