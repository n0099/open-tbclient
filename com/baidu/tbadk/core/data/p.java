package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class p {
    public String eKo;
    public long eKp;
    public int eKq;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eKo = bookThread.book_id;
            this.eKp = bookThread.chapter_id.longValue();
            this.eKq = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eKo = jSONObject.optString("book_id", "0");
                this.eKp = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.eKq = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
