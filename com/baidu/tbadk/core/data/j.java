package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String PW;
    public long PX;
    public int PY;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.PW = bookThread.book_id;
            this.PX = bookThread.chapter_id.longValue();
            this.PY = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PW = jSONObject.optString("book_id", "0");
                this.PX = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.PY = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
