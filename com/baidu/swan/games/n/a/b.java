package com.baidu.swan.games.n.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class b {
    @V8JavascriptField
    public String key;
    @V8JavascriptField
    public String value;

    public boolean OQ() {
        try {
            if (this.key != null) {
                if (this.key.getBytes(HTTP.UTF_8).length <= 128) {
                    return true;
                }
            }
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean OR() {
        try {
            if (this.key != null && this.value != null) {
                if (this.key.getBytes(HTTP.UTF_8).length + this.value.getBytes(HTTP.UTF_8).length <= 1024) {
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
