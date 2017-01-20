package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class l {
    public String Pu;
    public long Pv;
    public int Pw;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Pu = bookThread.book_id;
            this.Pv = bookThread.chapter_id.longValue();
            this.Pw = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Pu = jSONObject.optString("book_id", "0");
                this.Pv = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Pw = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
