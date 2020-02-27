package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String cNY;
    public long cNZ;
    public int cOa;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.cNY = bookThread.book_id;
            this.cNZ = bookThread.chapter_id.longValue();
            this.cOa = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cNY = jSONObject.optString("book_id", "0");
                this.cNZ = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.cOa = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
