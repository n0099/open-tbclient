package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aKk;
    public long aKl;
    public int aKm;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aKk = bookThread.book_id;
            this.aKl = bookThread.chapter_id.longValue();
            this.aKm = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aKk = jSONObject.optString("book_id", "0");
                this.aKl = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aKm = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
