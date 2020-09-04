package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String dXo;
    public long dXp;
    public int dXq;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dXo = bookThread.book_id;
            this.dXp = bookThread.chapter_id.longValue();
            this.dXq = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dXo = jSONObject.optString("book_id", "0");
                this.dXp = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dXq = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
