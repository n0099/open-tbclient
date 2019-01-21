package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aqR;
    public long aqS;
    public int aqT;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aqR = bookThread.book_id;
            this.aqS = bookThread.chapter_id.longValue();
            this.aqT = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqR = jSONObject.optString("book_id", "0");
                this.aqS = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aqT = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
