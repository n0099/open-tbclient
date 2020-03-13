package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String cOa;
    public long cOb;
    public int cOc;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.cOa = bookThread.book_id;
            this.cOb = bookThread.chapter_id.longValue();
            this.cOc = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cOa = jSONObject.optString("book_id", "0");
                this.cOb = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.cOc = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
