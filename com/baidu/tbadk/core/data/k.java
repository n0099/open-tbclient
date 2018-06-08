package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String aeU;
    public long aeV;
    public int aeW;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.aeU = bookThread.book_id;
            this.aeV = bookThread.chapter_id.longValue();
            this.aeW = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aeU = jSONObject.optString("book_id", "0");
                this.aeV = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.aeW = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
