package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String Uw;
    public long Ux;
    public int Uy;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.Uw = bookThread.book_id;
            this.Ux = bookThread.chapter_id.longValue();
            this.Uy = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Uw = jSONObject.optString("book_id", "0");
                this.Ux = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.Uy = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
