package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String afj;
    public long afk;
    public int afl;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.afj = bookThread.book_id;
            this.afk = bookThread.chapter_id.longValue();
            this.afl = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afj = jSONObject.optString("book_id", "0");
                this.afk = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.afl = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
