package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String TW;
    public long TX;
    public int TY;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.TW = bookThread.book_id;
            this.TX = bookThread.chapter_id.longValue();
            this.TY = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.TW = jSONObject.optString("book_id", "0");
                this.TX = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.TY = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
