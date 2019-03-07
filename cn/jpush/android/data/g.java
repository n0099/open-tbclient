package cn.jpush.android.data;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a.i;
import com.baidu.tbadk.TbConfig;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class g extends b implements Runnable {
    public String J;
    public int K;
    public int L;
    public int M;
    public ArrayList<String> N = new ArrayList<>();
    public String O = "";
    public String P = "";
    public String Q;
    private transient Context R;
    public String a;

    public g() {
        this.q = 0;
    }

    @Override // cn.jpush.android.data.b
    public final void a(Context context) {
        this.R = cn.jpush.android.a.b(context);
        cn.jiguang.api.e.a(this, new int[0]);
    }

    @Override // cn.jpush.android.data.b
    public final boolean a(JSONObject jSONObject) {
        this.a = jSONObject.optString("e_url", "").trim();
        this.J = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.a) && !i.a(this.a)) {
            this.a = "http://" + this.a;
        }
        this.L = jSONObject.optInt("e_rich_type", 0);
        this.K = jSONObject.optInt("e_jump_mode", 0);
        this.M = jSONObject.optInt("e_show", 0);
        if (3 == this.L || 2 == this.L || 1 == this.L) {
            this.N = cn.jpush.android.d.b.a(jSONObject.optJSONArray("e_eres"));
        }
        this.O = jSONObject.optString("from_num", "");
        this.P = jSONObject.optString("to_num", "");
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        if (this.M != 0) {
            return;
        }
        String str3 = this.c;
        String str4 = this.a;
        String str5 = this.y;
        cn.jiguang.api.e.d(this.R.getApplicationContext(), 3);
        if (this.L == 0) {
            if (this.w == 3 && !TextUtils.isEmpty(str5)) {
                if (str5.startsWith("http://") || str5.startsWith("https://")) {
                    if (cn.jpush.android.d.a.b(this.R, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        Context context = this.R;
                        if (str5.endsWith(".jpg") || str5.endsWith(".png")) {
                            str2 = cn.jpush.android.d.c.b(context, str3) + (str3 + str5.substring(str5.lastIndexOf(".")));
                            byte[] a = cn.jpush.android.b.a.a(str5, 5, TbConfig.NOTIFY_SOUND_INTERVAL, 4);
                            if (a == null) {
                                str2 = "";
                            } else if (!cn.jpush.android.d.c.a(str2, a)) {
                                str2 = "";
                            }
                        } else {
                            str2 = "";
                        }
                        if (TextUtils.isEmpty(str2)) {
                            cn.jpush.android.d.f.c("ShowEntity", "Get network picture failed, show basic notification only.");
                        } else {
                            this.y = str2;
                        }
                    } else {
                        cn.jpush.android.d.f.c("ShowEntity", "No permission to write resource to storage, show basic notification only.");
                    }
                } else if (cn.jpush.android.d.a.b(this.R, "android.permission.READ_EXTERNAL_STORAGE")) {
                    String c = cn.jpush.android.d.c.c(this.R, str5);
                    if (TextUtils.isEmpty(c)) {
                        cn.jpush.android.d.f.c("ShowEntity", "Get developer picture failed, show basic notification only.");
                    } else {
                        this.y = c;
                    }
                } else {
                    cn.jpush.android.d.f.c("ShowEntity", "No permission to read resource from storage, show basic notification only.");
                }
            }
            cn.jpush.android.a.e.a(str3, 995, null, this.R);
            cn.jpush.android.api.c.a(this.R, this);
        } else if (4 == this.L) {
            this.Q = str4;
            cn.jpush.android.a.e.a(str3, 995, null, this.R);
            cn.jpush.android.api.c.a(this.R, this);
        } else if (!cn.jpush.android.d.a.b(this.R, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            cn.jpush.android.d.f.d("ShowEntity", "Rich-push needs the permission of WRITE_EXTERNAL_STORAGE, please request it.");
            cn.jpush.android.a.e.a(str3, 1014, null, this.R);
        } else {
            if (!TextUtils.isEmpty(str4)) {
                for (int i = 0; i < 4; i++) {
                    cn.jiguang.h.c a2 = cn.jpush.android.b.a.a(str4, 5, TbConfig.NOTIFY_SOUND_INTERVAL);
                    if (a2 != null && a2.getResponseCode() == 200) {
                        z = true;
                        str = a2.cr();
                        break;
                    }
                }
            }
            z = false;
            str = null;
            String b = cn.jpush.android.d.c.b(this.R, str3);
            if (!z) {
                cn.jpush.android.a.e.a(str3, 1014, null, this.R);
                cn.jpush.android.a.e.a(str3, PointerIconCompat.TYPE_GRABBING, cn.jpush.android.d.a.a(this.R, str4), this.R);
                return;
            }
            String str6 = b + str3 + ".html";
            String substring = str4.substring(0, str4.lastIndexOf("/") + 1);
            if (this.N.isEmpty()) {
                this.Q = this.a;
                cn.jpush.android.api.c.a(this.R, this);
            } else if (!b.a(this.N, this.R, substring, str3, a())) {
                cn.jpush.android.a.e.a(str3, 1014, null, this.R);
                cn.jpush.android.api.c.a(this.R, this);
            } else {
                String replaceAll = str.replaceAll("img src=\"" + substring, "img src=\"" + b);
                if (!TextUtils.isEmpty(replaceAll) && cn.jpush.android.d.c.a(str6, replaceAll)) {
                    z2 = true;
                }
                if (!z2) {
                    cn.jpush.android.a.e.a(str3, 1014, null, this.R);
                    return;
                }
                this.Q = SkiaImageDecoder.FILE_PREFIX + str6;
                cn.jpush.android.a.e.a(str3, 995, null, this.R);
                cn.jpush.android.api.c.a(this.R, this);
            }
        }
    }
}
