package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String cJV;
    public long cJW;
    public int cJX;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.cJV = bookThread.book_id;
            this.cJW = bookThread.chapter_id.longValue();
            this.cJX = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cJV = jSONObject.optString("book_id", "0");
                this.cJW = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.cJX = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
