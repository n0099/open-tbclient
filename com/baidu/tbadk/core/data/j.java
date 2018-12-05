package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aqo;
    public long aqp;
    public int aqq;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aqo = bookThread.book_id;
            this.aqp = bookThread.chapter_id.longValue();
            this.aqq = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqo = jSONObject.optString("book_id", "0");
                this.aqp = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aqq = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
