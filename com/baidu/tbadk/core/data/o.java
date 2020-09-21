package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public int dZA;
    public String dZy;
    public long dZz;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dZy = bookThread.book_id;
            this.dZz = bookThread.chapter_id.longValue();
            this.dZA = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dZy = jSONObject.optString("book_id", "0");
                this.dZz = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dZA = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
