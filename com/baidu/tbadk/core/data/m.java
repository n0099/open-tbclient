package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String cNZ;
    public long cOa;
    public int cOb;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.cNZ = bookThread.book_id;
            this.cOa = bookThread.chapter_id.longValue();
            this.cOb = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cNZ = jSONObject.optString("book_id", "0");
                this.cOa = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.cOb = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
