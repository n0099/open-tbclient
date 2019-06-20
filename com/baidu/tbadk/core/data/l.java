package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String bEX;
    public long bEY;
    public int bEZ;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.bEX = bookThread.book_id;
            this.bEY = bookThread.chapter_id.longValue();
            this.bEZ = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEX = jSONObject.optString("book_id", "0");
                this.bEY = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.bEZ = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
