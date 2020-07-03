package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String dHQ;
    public long dHR;
    public int dHS;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dHQ = bookThread.book_id;
            this.dHR = bookThread.chapter_id.longValue();
            this.dHS = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dHQ = jSONObject.optString("book_id", "0");
                this.dHR = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dHS = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
