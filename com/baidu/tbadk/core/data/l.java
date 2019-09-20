package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bGx;
    public long bGy;
    public int bGz;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bGx = bookThread.book_id;
            this.bGy = bookThread.chapter_id.longValue();
            this.bGz = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bGx = jSONObject.optString("book_id", "0");
                this.bGy = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bGz = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
