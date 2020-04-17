package com.baidu.swan.games.q.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import java.io.UnsupportedEncodingException;
/* loaded from: classes11.dex */
public class b {
    @V8JavascriptField
    public String key;
    @V8JavascriptField
    public String value;

    public boolean axu() {
        try {
            if (this.key != null) {
                if (this.key.getBytes("UTF-8").length <= 128) {
                    return true;
                }
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean axv() {
        try {
            if (this.key != null && this.value != null) {
                if (this.key.getBytes("UTF-8").length + this.value.getBytes("UTF-8").length <= 1024) {
                    return true;
                }
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return true;
        }
    }

    public String toString() {
        return this.key + ":" + this.value;
    }
}
