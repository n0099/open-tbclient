package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String Um;
    public long Un;
    public int Uo;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Um = bookThread.book_id;
            this.Un = bookThread.chapter_id.longValue();
            this.Uo = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Um = jSONObject.optString("book_id", "0");
                this.Un = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Uo = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
