package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String elA;
    public long elB;
    public int elC;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.elA = bookThread.book_id;
            this.elB = bookThread.chapter_id.longValue();
            this.elC = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.elA = jSONObject.optString("book_id", "0");
                this.elB = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.elC = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
