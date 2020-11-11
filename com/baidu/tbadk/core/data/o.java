package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class o {
    public String ezT;
    public long ezU;
    public int ezV;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.ezT = bookThread.book_id;
            this.ezU = bookThread.chapter_id.longValue();
            this.ezV = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ezT = jSONObject.optString("book_id", "0");
                this.ezU = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.ezV = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
