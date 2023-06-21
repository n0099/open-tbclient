package com.baidu.swan.games.view.desktopguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.bf4;
import com.baidu.tieba.cf4;
import com.baidu.tieba.g42;
import com.baidu.tieba.hk3;
import com.baidu.tieba.jj2;
import com.baidu.tieba.js1;
import com.baidu.tieba.k02;
import com.baidu.tieba.le4;
import com.baidu.tieba.mh3;
import com.baidu.tieba.nk3;
import com.baidu.tieba.qp3;
import com.baidu.tieba.se4;
import com.baidu.tieba.si3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.ww2;
import com.baidu.tieba.zb3;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class DesktopGuideApi implements cf4 {
    public static final boolean n = js1.a;
    public volatile g42 b;
    public volatile DesktopGuideType c;
    public PopupWindow d;
    public Runnable e;
    public AtomicBoolean f = new AtomicBoolean(false);
    public se4 g;
    public volatile long h;
    public volatile long i;
    public volatile long j;
    public long k;
    public long l;
    public long m;

    /* loaded from: classes4.dex */
    public class a implements k02.a {
        public a() {
        }

        @Override // com.baidu.tieba.k02.a
        public void b(int i) {
            if (i != 0 || DesktopGuideApi.this.d == null || !DesktopGuideApi.this.d.y()) {
                return;
            }
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }

        @Override // com.baidu.tieba.k02.a
        public void a() {
            if (DesktopGuideApi.this.d != null && DesktopGuideApi.this.d.y()) {
                DesktopGuideApi.this.p();
                DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ zb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bitmap d;

        public c(SwanAppActivity swanAppActivity, zb3 zb3Var, String str, Bitmap bitmap) {
            this.a = swanAppActivity;
            this.b = zb3Var;
            this.c = str;
            this.d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
            desktopGuideApi.w(this.a, this.b, desktopGuideApi.c, this.c, this.d);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ DesktopGuideType a;

        public d(DesktopGuideType desktopGuideType) {
            this.a = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            si3.f(this.a.ubcType, "flow_close_close", "click");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ zb3 b;
        public final /* synthetic */ DesktopGuideType c;

        public e(Activity activity, zb3 zb3Var, DesktopGuideType desktopGuideType) {
            this.a = activity;
            this.b = zb3Var;
            this.c = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.m(this.a, this.b);
            if ("desk_flow".equals(this.c.ubcType)) {
                str = "flow_close_add";
            } else {
                str = "flow_add";
            }
            si3.f(this.c.ubcType, str, "click");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PopupWindow.b {
        public f() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            DesktopGuideApi.this.f.set(false);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DesktopGuideApi.this.d != null) {
                DesktopGuideApi.this.d.q();
                DesktopGuideApi.this.d = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements mh3.f {
        public final /* synthetic */ zb3 a;

        public h(zb3 zb3Var) {
            this.a = zb3Var;
        }

        @Override // com.baidu.tieba.mh3.f
        public void a(int i) {
            DesktopApiStatus desktopApiStatus;
            String str;
            if (i != -1) {
                if (i != 1) {
                    desktopApiStatus = DesktopApiStatus.ADD_FAIL;
                    if (DesktopGuideApi.this.j + 1 < 3) {
                        DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
                        desktopGuideApi.u(this.a, desktopGuideApi.h, DesktopGuideApi.this.i, DesktopGuideApi.this.j + 1);
                    }
                    str = "desk_fail";
                } else {
                    desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                    str = "desk_success";
                }
            } else {
                desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                str = "desk_notknown";
            }
            DesktopGuideApi.this.o(desktopApiStatus);
            si3.f(DesktopGuideApi.this.c.ubcType, str, "click");
        }
    }

    @AnyThread
    public final void p() {
        Runnable runnable = this.e;
        if (runnable != null) {
            tp3.d0(runnable);
        }
        tp3.e0(new g());
    }

    public final void q() {
        this.e = new b();
    }

    public final void r() {
        if (this.g != null) {
            return;
        }
        se4 c2 = se4.c();
        this.g = c2;
        if (c2 != null) {
            c2.a(new a());
        }
    }

    public final void x() {
        hk3 a2 = nk3.a();
        this.k = a2.getLong("swan_favorite_guide_duration", 3L);
        this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
        this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    /* loaded from: classes4.dex */
    public enum DesktopApiStatus {
        ALREADY_IN_DESKTOP(true, 1, "shortcut already in the desktop."),
        ADD_SUCCESS(true, 2, "add shortcut to desktop success."),
        ADD_UNKNOWN(true, 3, "try to add but could not get the addition result."),
        EXEC_FAILURE(false, -1, "api internal error."),
        REACH_MAX_TIMES(false, -2, "reach max invoke times limit."),
        USER_CANCEL(false, -3, "cancel by user."),
        ADD_FAIL(false, -4, "add shortcut to desktop failed.");
        
        public int statusCode;
        public String statusMsg;
        public boolean success;

        DesktopApiStatus(boolean z, int i, String str) {
            String str2;
            this.success = z;
            this.statusCode = i;
            if (z) {
                str2 = "showAddToDesktopGuide: success, %s";
            } else {
                str2 = "showAddToDesktopGuide: fail, %s";
            }
            this.statusMsg = String.format(str2, str);
        }
    }

    /* loaded from: classes4.dex */
    public enum DesktopGuideType {
        BAR("bar", -1, 992, "desk_flow", R.string.obfuscated_res_0x7f0f155d),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", R.string.obfuscated_res_0x7f0f155d);
        
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;
        public String ubcType;

        DesktopGuideType(String str, int i, int i2, String str2, @StringRes int i3) {
            this.typeName = str;
            this.limit = i;
            this.showWidth4px = i2;
            this.ubcType = str2;
            this.defaultText = i3;
        }

        public static DesktopGuideType parse(String str) {
            DesktopGuideType[] values;
            for (DesktopGuideType desktopGuideType : values()) {
                if (TextUtils.equals(desktopGuideType.typeName, str)) {
                    return desktopGuideType;
                }
            }
            return BAR;
        }
    }

    public DesktopGuideApi(jj2 jj2Var) {
        x();
        q();
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        if (this.b != null) {
            le4.call(this.b, desktopApiStatus.success, new bf4(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    public final void m(@NonNull Context context, @NonNull zb3 zb3Var) {
        ww2.a Y = zb3Var.Y();
        if (Y == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
        } else {
            mh3.k(context, Y, new h(zb3Var));
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int g2 = qp3.g(7.0f);
        int o = qp3.o(null);
        int i2 = g2 * 2;
        if (o - i < i2) {
            i = o - i2;
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    public final boolean s(@NonNull Context context, @NonNull zb3 zb3Var) {
        if (mh3.s(context, zb3Var.Z(), zb3Var.b) == 1) {
            return true;
        }
        return false;
    }

    public final void t(@NonNull String str) {
        String string = nk3.a().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.h = Long.parseLong(split[0]);
            this.i = Long.parseLong(split[1]);
            this.j = Long.parseLong(split[2]);
        }
        if (n) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string);
        }
    }

    public final void u(@NonNull zb3 zb3Var, long j, long j2, long j3) {
        hk3 a2 = nk3.a();
        a2.putString("desktop_guide_count_" + zb3Var.b, j + "#" + j2 + "#" + j3);
    }

    public void v(JsObject jsObject) {
        g42 F = g42.F(jsObject);
        if (F == null) {
            F = new g42();
        }
        this.b = F;
        zb3 M = zb3.M();
        if (M == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.c = DesktopGuideType.parse(F.B("type"));
        String B = F.B("content");
        if (TextUtils.isEmpty(B)) {
            B = w.getString(this.c.defaultText);
        }
        if (s(w, M)) {
            o(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        t("desktop_guide_count_" + M.b);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.h < this.m && currentTimeMillis - this.i > this.l * 86400000) {
            if (this.f.get()) {
                o(DesktopApiStatus.REACH_MAX_TIMES);
                return;
            }
            this.f.set(true);
            u(M, 1 + this.h, currentTimeMillis, 0L);
            tp3.e0(new c(w, M, B, tp3.i(M.Y(), "ShowAddToDesktopGuide", false)));
            return;
        }
        o(DesktopApiStatus.REACH_MAX_TIMES);
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull zb3 zb3Var, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        r();
        se4 se4Var = this.g;
        if (se4Var != null) {
            se4Var.b(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00a9, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090ad1);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + "...";
        }
        textView.setText(str);
        n((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090ad0), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ad2);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080159);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090acf);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new d(desktopGuideType));
        }
        Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090acd);
        button.setText(R.string.obfuscated_res_0x7f0f0193);
        button.setOnClickListener(new e(activity, zb3Var, desktopGuideType));
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.d = popupWindow;
        popupWindow.M(16);
        this.d.P(activity.getWindow().getDecorView(), 81, 0, qp3.g(50.0f));
        this.d.J(new f());
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.e) != null) {
            tp3.d0(runnable);
            tp3.b0(this.e, this.k * 1000);
        }
        si3.f(desktopGuideType.ubcType, cf4.a, "show");
    }
}
