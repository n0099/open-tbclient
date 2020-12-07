package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class p {
    public String eFj;
    public long eFk;
    public int eFl;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eFj = bookThread.book_id;
            this.eFk = bookThread.chapter_id.longValue();
            this.eFl = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eFj = jSONObject.optString("book_id", "0");
                this.eFk = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.eFl = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
