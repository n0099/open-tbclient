package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String dBx;
    public long dBy;
    public int dBz;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dBx = bookThread.book_id;
            this.dBy = bookThread.chapter_id.longValue();
            this.dBz = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dBx = jSONObject.optString("book_id", "0");
                this.dBy = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dBz = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
