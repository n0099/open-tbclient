package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class m {
    public String dnw;
    public long dnx;
    public int dny;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.dnw = bookThread.book_id;
            this.dnx = bookThread.chapter_id.longValue();
            this.dny = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dnw = jSONObject.optString("book_id", "0");
                this.dnx = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.dny = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
