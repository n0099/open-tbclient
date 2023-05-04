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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ab4;
import com.baidu.tieba.e02;
import com.baidu.tieba.fg3;
import com.baidu.tieba.hf2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.iw1;
import com.baidu.tieba.ja4;
import com.baidu.tieba.kd3;
import com.baidu.tieba.lg3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.qa4;
import com.baidu.tieba.qe3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.us2;
import com.baidu.tieba.x73;
import com.baidu.tieba.za4;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class DesktopGuideApi implements ab4 {
    public static final boolean n = ho1.a;
    public volatile e02 b;
    public volatile DesktopGuideType c;
    public PopupWindow d;
    public Runnable e;
    public AtomicBoolean f = new AtomicBoolean(false);
    public qa4 g;
    public volatile long h;
    public volatile long i;
    public volatile long j;
    public long k;
    public long l;
    public long m;

    /* loaded from: classes3.dex */
    public class a implements iw1.a {
        public a() {
        }

        @Override // com.baidu.tieba.iw1.a
        public void b(int i) {
            if (i != 0 || DesktopGuideApi.this.d == null || !DesktopGuideApi.this.d.z()) {
                return;
            }
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }

        @Override // com.baidu.tieba.iw1.a
        public void a() {
            if (DesktopGuideApi.this.d != null && DesktopGuideApi.this.d.z()) {
                DesktopGuideApi.this.p();
                DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ x73 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bitmap d;

        public c(SwanAppActivity swanAppActivity, x73 x73Var, String str, Bitmap bitmap) {
            this.a = swanAppActivity;
            this.b = x73Var;
            this.c = str;
            this.d = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
            desktopGuideApi.w(this.a, this.b, desktopGuideApi.c, this.c, this.d);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ DesktopGuideType a;

        public d(DesktopGuideType desktopGuideType) {
            this.a = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            qe3.f(this.a.ubcType, "flow_close_close", "click");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ x73 b;
        public final /* synthetic */ DesktopGuideType c;

        public e(Activity activity, x73 x73Var, DesktopGuideType desktopGuideType) {
            this.a = activity;
            this.b = x73Var;
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
            qe3.f(this.c.ubcType, str, "click");
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.b {
        public f() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            DesktopGuideApi.this.f.set(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DesktopGuideApi.this.d != null) {
                DesktopGuideApi.this.d.r();
                DesktopGuideApi.this.d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements kd3.f {
        public final /* synthetic */ x73 a;

        public h(x73 x73Var) {
            this.a = x73Var;
        }

        @Override // com.baidu.tieba.kd3.f
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
            qe3.f(DesktopGuideApi.this.c.ubcType, str, "click");
        }
    }

    @AnyThread
    public final void p() {
        Runnable runnable = this.e;
        if (runnable != null) {
            rl3.d0(runnable);
        }
        rl3.e0(new g());
    }

    public final void q() {
        this.e = new b();
    }

    public final void r() {
        if (this.g != null) {
            return;
        }
        qa4 c2 = qa4.c();
        this.g = c2;
        if (c2 != null) {
            c2.a(new a());
        }
    }

    public final void x() {
        fg3 a2 = lg3.a();
        this.k = a2.getLong("swan_favorite_guide_duration", 3L);
        this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
        this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public enum DesktopGuideType {
        BAR("bar", -1, 992, "desk_flow", R.string.obfuscated_res_0x7f0f1435),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", R.string.obfuscated_res_0x7f0f1435);
        
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

    public DesktopGuideApi(hf2 hf2Var) {
        x();
        q();
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        if (this.b != null) {
            ja4.call(this.b, desktopApiStatus.success, new za4(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    public final void m(@NonNull Context context, @NonNull x73 x73Var) {
        us2.a Y = x73Var.Y();
        if (Y == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
        } else {
            kd3.k(context, Y, new h(x73Var));
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int g2 = ol3.g(7.0f);
        int o = ol3.o(null);
        int i2 = g2 * 2;
        if (o - i < i2) {
            i = o - i2;
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    public final boolean s(@NonNull Context context, @NonNull x73 x73Var) {
        if (kd3.s(context, x73Var.Z(), x73Var.b) == 1) {
            return true;
        }
        return false;
    }

    public final void t(@NonNull String str) {
        String string = lg3.a().getString(str, "");
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

    public final void u(@NonNull x73 x73Var, long j, long j2, long j3) {
        fg3 a2 = lg3.a();
        a2.putString("desktop_guide_count_" + x73Var.b, j + "#" + j2 + "#" + j3);
    }

    public void v(JsObject jsObject) {
        e02 F = e02.F(jsObject);
        if (F == null) {
            F = new e02();
        }
        this.b = F;
        x73 M = x73.M();
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
            rl3.e0(new c(w, M, B, rl3.i(M.Y(), "ShowAddToDesktopGuide", false)));
            return;
        }
        o(DesktopApiStatus.REACH_MAX_TIMES);
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull x73 x73Var, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        r();
        qa4 qa4Var = this.g;
        if (qa4Var != null) {
            qa4Var.b(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00a7, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a97);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        n((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090a96), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a98);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080141);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a95);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new d(desktopGuideType));
        }
        Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f090a93);
        button.setText(R.string.obfuscated_res_0x7f0f0169);
        button.setOnClickListener(new e(activity, x73Var, desktopGuideType));
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.d = popupWindow;
        popupWindow.N(16);
        this.d.Q(activity.getWindow().getDecorView(), 81, 0, ol3.g(50.0f));
        this.d.K(new f());
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.e) != null) {
            rl3.d0(runnable);
            rl3.b0(this.e, this.k * 1000);
        }
        qe3.f(desktopGuideType.ubcType, ab4.a, "show");
    }
}
