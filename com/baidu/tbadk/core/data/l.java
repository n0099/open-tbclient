package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bEW;
    public long bEX;
    public int bEY;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bEW = bookThread.book_id;
            this.bEX = bookThread.chapter_id.longValue();
            this.bEY = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEW = jSONObject.optString("book_id", "0");
                this.bEX = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bEY = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
