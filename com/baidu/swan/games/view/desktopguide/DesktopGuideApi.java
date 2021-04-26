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
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.w1.a;
import d.a.h0.a.y0.e.b;
import d.a.h0.g.k0.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class DesktopGuideApi implements d.a.h0.g.k0.g.b {
    public static final boolean n = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.h0.g.e.d.c f12450b;

    /* renamed from: c  reason: collision with root package name */
    public volatile DesktopGuideType f12451c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f12452d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f12453e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f12454f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.k0.b f12455g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f12456h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f12457i;
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
        BAR("bar", -1, 992, "desk_flow", d.a.h0.a.h.swangame_desktop_guide_default_hint),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", d.a.h0.a.h.swangame_desktop_guide_default_hint);
        
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
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.h0.g.k0.b.a
        public void a() {
            if (DesktopGuideApi.this.f12452d == null || !DesktopGuideApi.this.f12452d.t()) {
                return;
            }
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
        }

        @Override // d.a.h0.g.k0.b.a
        public void b(int i2) {
            if (i2 == 0 && DesktopGuideApi.this.f12452d != null && DesktopGuideApi.this.f12452d.t()) {
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
        public final /* synthetic */ SwanAppActivity f12460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f12461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12462g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bitmap f12463h;

        public c(SwanAppActivity swanAppActivity, d.a.h0.a.r1.e eVar, String str, Bitmap bitmap) {
            this.f12460e = swanAppActivity;
            this.f12461f = eVar;
            this.f12462g = str;
            this.f12463h = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
            desktopGuideApi.w(this.f12460e, this.f12461f, desktopGuideApi.f12451c, this.f12462g, this.f12463h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f12465e;

        public d(DesktopGuideType desktopGuideType) {
            this.f12465e = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            d.a.h0.a.z1.h.h(this.f12465e.ubcType, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f12468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f12469g;

        public e(Activity activity, d.a.h0.a.r1.e eVar, DesktopGuideType desktopGuideType) {
            this.f12467e = activity;
            this.f12468f = eVar;
            this.f12469g = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.m(this.f12467e, this.f12468f);
            d.a.h0.a.z1.h.h(this.f12469g.ubcType, "desk_flow".equals(this.f12469g.ubcType) ? "flow_close_add" : "flow_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.b {
        public f() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            DesktopGuideApi.this.f12454f.set(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DesktopGuideApi.this.f12452d != null) {
                DesktopGuideApi.this.f12452d.n();
                DesktopGuideApi.this.f12452d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f12473a;

        public h(d.a.h0.a.r1.e eVar) {
            this.f12473a = eVar;
        }

        @Override // d.a.h0.a.w1.a.f
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
                    desktopGuideApi.u(this.f12473a, desktopGuideApi.f12456h, DesktopGuideApi.this.f12457i, DesktopGuideApi.this.j + 1);
                }
                str = "desk_fail";
            } else {
                desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                str = "desk_success";
            }
            DesktopGuideApi.this.o(desktopApiStatus);
            d.a.h0.a.z1.h.h(DesktopGuideApi.this.f12451c.ubcType, str, PrefetchEvent.STATE_CLICK);
        }
    }

    public DesktopGuideApi(d.a.h0.g.i.b bVar) {
        x();
        q();
    }

    public final void m(@NonNull Context context, @NonNull d.a.h0.a.r1.e eVar) {
        b.a L = eVar.L();
        if (L == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
        } else {
            d.a.h0.a.w1.a.j(context, L, new h(eVar));
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i2 = desktopGuideType.showWidth4px;
        int f2 = h0.f(7.0f);
        int m = h0.m(null);
        int i3 = f2 * 2;
        if (m - i2 < i3) {
            i2 = m - i3;
        }
        layoutParams.width = i2;
        viewGroup.setLayoutParams(layoutParams);
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        if (this.f12450b != null) {
            d.a.h0.g.i0.b.a(this.f12450b, desktopApiStatus.success, new d.a.h0.g.k0.g.a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    @AnyThread
    public final void p() {
        Runnable runnable = this.f12453e;
        if (runnable != null) {
            k0.W(runnable);
        }
        k0.X(new g());
    }

    public final void q() {
        this.f12453e = new b();
    }

    public final void r() {
        if (this.f12455g != null) {
            return;
        }
        d.a.h0.g.k0.b a2 = d.a.h0.g.k0.b.a();
        this.f12455g = a2;
        if (a2 != null) {
            a2.c(new a());
        }
    }

    public final boolean s(@NonNull Context context, @NonNull d.a.h0.a.r1.e eVar) {
        return d.a.h0.a.w1.a.r(context, eVar.M(), eVar.f43823f) == 1;
    }

    public final void t(@NonNull String str) {
        String string = d.a.h0.a.a2.g.h.a().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.f12456h = Long.parseLong(split[0]);
            this.f12457i = Long.parseLong(split[1]);
            this.j = Long.parseLong(split[2]);
        }
        if (n) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string);
        }
    }

    public final void u(@NonNull d.a.h0.a.r1.e eVar, long j, long j2, long j3) {
        d.a.h0.a.a2.g.b a2 = d.a.h0.a.a2.g.h.a();
        a2.putString("desktop_guide_count_" + eVar.f43823f, j + "#" + j2 + "#" + j3);
    }

    public void v(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.a.h0.g.e.d.c();
        }
        this.f12450b = F;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        SwanAppActivity v = h2.v();
        if (v == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.f12451c = DesktopGuideType.parse(F.B("type"));
        String B = F.B("content");
        if (TextUtils.isEmpty(B)) {
            B = v.getString(this.f12451c.defaultText);
        }
        if (s(v, h2)) {
            o(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        t("desktop_guide_count_" + h2.f43823f);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f12456h < this.m && currentTimeMillis - this.f12457i > this.l * 86400000) {
            if (this.f12454f.get()) {
                o(DesktopApiStatus.REACH_MAX_TIMES);
                return;
            }
            this.f12454f.set(true);
            u(h2, 1 + this.f12456h, currentTimeMillis, 0L);
            k0.X(new c(v, h2, B, k0.j(h2.L(), "ShowAddToDesktopGuide", false)));
            return;
        }
        o(DesktopApiStatus.REACH_MAX_TIMES);
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        r();
        d.a.h0.g.k0.b bVar = this.f12455g;
        if (bVar != null) {
            bVar.d(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(d.a.h0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.a.h0.a.f.favorite_guide_content);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        n((ViewGroup) inflate.findViewById(d.a.h0.a.f.favorite_guide_container), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(d.a.h0.a.f.favorite_guide_icon);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(d.a.h0.a.e.aiapps_default_grey_icon);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(d.a.h0.a.f.favorite_guide_close);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new d(desktopGuideType));
        }
        Button button = (Button) inflate.findViewById(d.a.h0.a.f.favorite_guide_add_btn);
        button.setText(d.a.h0.a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new e(activity, eVar, desktopGuideType));
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.f12452d = popupWindow;
        popupWindow.I(16);
        this.f12452d.L(activity.getWindow().getDecorView(), 81, 0, h0.f(50.0f));
        this.f12452d.G(new f());
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.f12453e) != null) {
            k0.W(runnable);
            k0.U(this.f12453e, this.k * 1000);
        }
        d.a.h0.a.z1.h.h(desktopGuideType.ubcType, d.a.h0.g.k0.g.b.f46451a, "show");
    }

    public final void x() {
        d.a.h0.a.a2.g.b a2 = d.a.h0.a.a2.g.h.a();
        this.k = a2.getLong("swan_favorite_guide_duration", 3L);
        this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
        this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
    }
}
