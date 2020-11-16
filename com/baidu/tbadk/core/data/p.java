package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class p {
    public String eyj;
    public long eyk;
    public int eyl;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eyj = bookThread.book_id;
            this.eyk = bookThread.chapter_id.longValue();
            this.eyl = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eyj = jSONObject.optString("book_id", "0");
                this.eyk = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.eyl = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
