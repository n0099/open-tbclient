package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bxH;
    public long bxI;
    public int bxJ;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bxH = bookThread.book_id;
            this.bxI = bookThread.chapter_id.longValue();
            this.bxJ = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bxH = jSONObject.optString("book_id", "0");
                this.bxI = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bxJ = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
