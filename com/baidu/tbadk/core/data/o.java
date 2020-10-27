package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String eua;
    public long eub;
    public int euc;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.eua = bookThread.book_id;
            this.eub = bookThread.chapter_id.longValue();
            this.euc = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eua = jSONObject.optString("book_id", "0");
                this.eub = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.euc = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
