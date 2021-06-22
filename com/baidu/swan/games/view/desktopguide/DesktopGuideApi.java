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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.f2.a;
import d.a.m0.a.k;
import d.a.m0.a.u.e.d.a;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class DesktopGuideApi implements d.a.m0.h.o0.e.b {
    public static final boolean n = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.m0.a.y.b.a f11837b;

    /* renamed from: c  reason: collision with root package name */
    public volatile DesktopGuideType f11838c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f11839d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f11840e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f11841f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.h.o0.a f11842g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f11843h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f11844i;
    public volatile long j;
    public long k;
    public long l;
    public long m;

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

        DesktopApiStatus(boolean z, int i2, String str) {
            this.success = z;
            this.statusCode = i2;
            this.statusMsg = String.format(z ? "showAddToDesktopGuide: success, %s" : "showAddToDesktopGuide: fail, %s", str);
        }
    }

    /* loaded from: classes3.dex */
    public enum DesktopGuideType {
        BAR("bar", -1, 992, "desk_flow", d.a.m0.f.g.swangame_desktop_guide_default_hint),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", d.a.m0.f.g.swangame_desktop_guide_default_hint);
        
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;
        public String ubcType;

        DesktopGuideType(String str, int i2, int i3, String str2, @StringRes int i4) {
            this.typeName = str;
            this.limit = i2;
            this.showWidth4px = i3;
            this.ubcType = str2;
            this.defaultText = i4;
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

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0895a {
        public a() {
        }

        @Override // d.a.m0.a.u.e.d.a.InterfaceC0895a
        public void a() {
            if (DesktopGuideApi.this.f11839d == null || !DesktopGuideApi.this.f11839d.x()) {
                return;
            }
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }

        @Override // d.a.m0.a.u.e.d.a.InterfaceC0895a
        public void b(int i2) {
            if (i2 == 0 && DesktopGuideApi.this.f11839d != null && DesktopGuideApi.this.f11839d.x()) {
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f11847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f11848f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11849g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bitmap f11850h;

        public c(SwanAppActivity swanAppActivity, d.a.m0.a.a2.e eVar, String str, Bitmap bitmap) {
            this.f11847e = swanAppActivity;
            this.f11848f = eVar;
            this.f11849g = str;
            this.f11850h = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
            desktopGuideApi.w(this.f11847e, this.f11848f, desktopGuideApi.f11838c, this.f11849g, this.f11850h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f11852e;

        public d(DesktopGuideType desktopGuideType) {
            this.f11852e = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            d.a.m0.a.j2.k.f(this.f11852e.ubcType, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f11854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f11855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f11856g;

        public e(Activity activity, d.a.m0.a.a2.e eVar, DesktopGuideType desktopGuideType) {
            this.f11854e = activity;
            this.f11855f = eVar;
            this.f11856g = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.m(this.f11854e, this.f11855f);
            d.a.m0.a.j2.k.f(this.f11856g.ubcType, "desk_flow".equals(this.f11856g.ubcType) ? "flow_close_add" : "flow_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.b {
        public f() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            DesktopGuideApi.this.f11841f.set(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DesktopGuideApi.this.f11839d != null) {
                DesktopGuideApi.this.f11839d.r();
                DesktopGuideApi.this.f11839d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f11860a;

        public h(d.a.m0.a.a2.e eVar) {
            this.f11860a = eVar;
        }

        @Override // d.a.m0.a.f2.a.f
        public void a(int i2) {
            DesktopApiStatus desktopApiStatus;
            String str;
            if (i2 == -1) {
                desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                str = "desk_notknown";
            } else if (i2 != 1) {
                desktopApiStatus = DesktopApiStatus.ADD_FAIL;
                if (DesktopGuideApi.this.j + 1 < 3) {
                    DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
                    desktopGuideApi.u(this.f11860a, desktopGuideApi.f11843h, DesktopGuideApi.this.f11844i, DesktopGuideApi.this.j + 1);
                }
                str = "desk_fail";
            } else {
                desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                str = "desk_success";
            }
            DesktopGuideApi.this.o(desktopApiStatus);
            d.a.m0.a.j2.k.f(DesktopGuideApi.this.f11838c.ubcType, str, PrefetchEvent.STATE_CLICK);
        }
    }

    public DesktopGuideApi(d.a.m0.a.l0.c cVar) {
        x();
        q();
    }

    public final void m(@NonNull Context context, @NonNull d.a.m0.a.a2.e eVar) {
        b.a N = eVar.N();
        if (N == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
        } else {
            d.a.m0.a.f2.a.k(context, N, new h(eVar));
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i2 = desktopGuideType.showWidth4px;
        int g2 = n0.g(7.0f);
        int o = n0.o(null);
        int i3 = g2 * 2;
        if (o - i2 < i3) {
            i2 = o - i3;
        }
        layoutParams.width = i2;
        viewGroup.setLayoutParams(layoutParams);
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        if (this.f11837b != null) {
            d.a.m0.h.m0.c.a(this.f11837b, desktopApiStatus.success, new d.a.m0.h.o0.e.a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    @AnyThread
    public final void p() {
        Runnable runnable = this.f11840e;
        if (runnable != null) {
            q0.a0(runnable);
        }
        q0.b0(new g());
    }

    public final void q() {
        this.f11840e = new b();
    }

    public final void r() {
        if (this.f11842g != null) {
            return;
        }
        d.a.m0.h.o0.a d2 = d.a.m0.h.o0.a.d();
        this.f11842g = d2;
        if (d2 != null) {
            d2.b(new a());
        }
    }

    public final boolean s(@NonNull Context context, @NonNull d.a.m0.a.a2.e eVar) {
        return d.a.m0.a.f2.a.s(context, eVar.O(), eVar.f44533f) == 1;
    }

    public final void t(@NonNull String str) {
        String string = d.a.m0.a.k2.g.h.a().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.f11843h = Long.parseLong(split[0]);
            this.f11844i = Long.parseLong(split[1]);
            this.j = Long.parseLong(split[2]);
        }
        if (n) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string);
        }
    }

    public final void u(@NonNull d.a.m0.a.a2.e eVar, long j, long j2, long j3) {
        d.a.m0.a.k2.g.b a2 = d.a.m0.a.k2.g.h.a();
        a2.putString("desktop_guide_count_" + eVar.f44533f, j + "#" + j2 + "#" + j3);
    }

    public void v(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            G = new d.a.m0.a.y.b.a();
        }
        this.f11837b = G;
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.f11838c = DesktopGuideType.parse(G.C("type"));
        String C = G.C("content");
        if (TextUtils.isEmpty(C)) {
            C = x.getString(this.f11838c.defaultText);
        }
        if (s(x, i2)) {
            o(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        t("desktop_guide_count_" + i2.f44533f);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f11843h < this.m && currentTimeMillis - this.f11844i > this.l * 86400000) {
            if (this.f11841f.get()) {
                o(DesktopApiStatus.REACH_MAX_TIMES);
                return;
            }
            this.f11841f.set(true);
            u(i2, 1 + this.f11843h, currentTimeMillis, 0L);
            q0.b0(new c(x, i2, C, q0.i(i2.N(), "ShowAddToDesktopGuide", false)));
            return;
        }
        o(DesktopApiStatus.REACH_MAX_TIMES);
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull d.a.m0.a.a2.e eVar, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        r();
        d.a.m0.h.o0.a aVar = this.f11842g;
        if (aVar != null) {
            aVar.c(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(d.a.m0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.a.m0.a.f.favorite_guide_content);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        n((ViewGroup) inflate.findViewById(d.a.m0.a.f.favorite_guide_container), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(d.a.m0.a.f.favorite_guide_icon);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(d.a.m0.a.e.aiapps_default_grey_icon);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(d.a.m0.a.f.favorite_guide_close);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new d(desktopGuideType));
        }
        Button button = (Button) inflate.findViewById(d.a.m0.a.f.favorite_guide_add_btn);
        button.setText(d.a.m0.f.g.aiapps_game_desktop_guide_add);
        button.setOnClickListener(new e(activity, eVar, desktopGuideType));
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.f11839d = popupWindow;
        popupWindow.N(16);
        this.f11839d.Q(activity.getWindow().getDecorView(), 81, 0, n0.g(50.0f));
        this.f11839d.L(new f());
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.f11840e) != null) {
            q0.a0(runnable);
            q0.Y(this.f11840e, this.k * 1000);
        }
        d.a.m0.a.j2.k.f(desktopGuideType.ubcType, d.a.m0.h.o0.e.b.f51339a, "show");
    }

    public final void x() {
        d.a.m0.a.k2.g.b a2 = d.a.m0.a.k2.g.h.a();
        this.k = a2.getLong("swan_favorite_guide_duration", 3L);
        this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
        this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
    }
}
