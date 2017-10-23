package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes.dex */
public class k {
    public String UT;
    public long UU;
    public int UV;

    public void a(BookThread bookThread) {
        if (bookThread != null) {
            this.UT = bookThread.book_id;
            this.UU = bookThread.chapter_id.longValue();
            this.UV = bookThread.book_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UT = jSONObject.optString("book_id", "0");
                this.UU = jSONObject.optLong(MangaBrowserActivityConfig.CHAPTER_ID, 0L);
                this.UV = jSONObject.optInt("book_type", 0);
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
