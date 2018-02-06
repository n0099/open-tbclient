package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class j {
    public String aLH;
    public long aLI;
    public int aLJ;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aLH = bookThread.book_id;
            this.aLI = bookThread.chapter_id.longValue();
            this.aLJ = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLH = jSONObject.optString("book_id", "0");
                this.aLI = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aLJ = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
