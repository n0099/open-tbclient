package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aLx;
    public long aLy;
    public int aLz;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aLx = bookThread.book_id;
            this.aLy = bookThread.chapter_id.longValue();
            this.aLz = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLx = jSONObject.optString("book_id", "0");
                this.aLy = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aLz = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
