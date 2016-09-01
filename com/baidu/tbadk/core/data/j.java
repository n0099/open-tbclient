package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String PY;
    public long PZ;
    public int Qa;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.PY = bookThread.book_id;
            this.PZ = bookThread.chapter_id.longValue();
            this.Qa = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PY = jSONObject.optString("book_id", "0");
                this.PZ = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Qa = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
