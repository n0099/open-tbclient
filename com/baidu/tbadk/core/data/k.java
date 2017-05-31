package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String TX;
    public long TY;
    public int TZ;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.TX = bookThread.book_id;
            this.TY = bookThread.chapter_id.longValue();
            this.TZ = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TX = jSONObject.optString("book_id", "0");
                this.TY = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.TZ = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
