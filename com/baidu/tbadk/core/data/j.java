package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aqQ;
    public long aqR;
    public int aqS;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aqQ = bookThread.book_id;
            this.aqR = bookThread.chapter_id.longValue();
            this.aqS = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqQ = jSONObject.optString("book_id", "0");
                this.aqR = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aqS = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
