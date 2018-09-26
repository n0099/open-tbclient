package cn.jpush.android.data;

import android.text.TextUtils;
import java.io.Serializable;
/* loaded from: classes3.dex */
public final class c implements Serializable {
    public String a;
    public String b;

    public c() {
    }

    public c(b bVar) {
        this.a = bVar.c;
        this.b = bVar.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(cVar.a) || !TextUtils.equals(this.a, cVar.a)) {
                return false;
            }
            if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(cVar.b)) {
                return true;
            }
            return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(cVar.b) || !TextUtils.equals(this.b, cVar.b)) ? false : true;
        }
        return false;
    }

    public final String toString() {
        return "msg_id = " + this.a + ",  override_msg_id = " + this.b;
    }
}
