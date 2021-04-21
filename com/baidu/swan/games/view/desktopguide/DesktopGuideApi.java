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
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.w1.a;
import d.b.h0.a.y0.e.b;
import d.b.h0.g.k0.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class DesktopGuideApi implements d.b.h0.g.k0.g.b {
    public static final boolean n = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.b.h0.g.e.d.c f12556b;

    /* renamed from: c  reason: collision with root package name */
    public volatile DesktopGuideType f12557c;

    /* renamed from: d  reason: collision with root package name */
    public PopupWindow f12558d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f12559e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f12560f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.g.k0.b f12561g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f12562h;
    public volatile long i;
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

        DesktopApiStatus(boolean z, int i, String str) {
            this.success = z;
            this.statusCode = i;
            this.statusMsg = String.format(z ? "showAddToDesktopGuide: success, %s" : "showAddToDesktopGuide: fail, %s", str);
        }
    }

    /* loaded from: classes3.dex */
    public enum DesktopGuideType {
        BAR("bar", -1, 992, "desk_flow", d.b.h0.a.h.swangame_desktop_guide_default_hint),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", d.b.h0.a.h.swangame_desktop_guide_default_hint);
        
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

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.h0.g.k0.b.a
        public void a(int i) {
            if (i == 0 && DesktopGuideApi.this.f12558d != null && DesktopGuideApi.this.f12558d.u()) {
                DesktopGuideApi.this.p();
                DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            }
        }

        @Override // d.b.h0.g.k0.b.a
        public void b() {
            if (DesktopGuideApi.this.f12558d == null || !DesktopGuideApi.this.f12558d.u()) {
                return;
            }
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
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
        public final /* synthetic */ SwanAppActivity f12565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f12566f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12567g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bitmap f12568h;

        public c(SwanAppActivity swanAppActivity, d.b.h0.a.r1.e eVar, String str, Bitmap bitmap) {
            this.f12565e = swanAppActivity;
            this.f12566f = eVar;
            this.f12567g = str;
            this.f12568h = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
            desktopGuideApi.w(this.f12565e, this.f12566f, desktopGuideApi.f12557c, this.f12567g, this.f12568h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f12569e;

        public d(DesktopGuideType desktopGuideType) {
            this.f12569e = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.o(DesktopApiStatus.USER_CANCEL);
            d.b.h0.a.z1.h.h(this.f12569e.ubcType, "flow_close_close", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f12572f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DesktopGuideType f12573g;

        public e(Activity activity, d.b.h0.a.r1.e eVar, DesktopGuideType desktopGuideType) {
            this.f12571e = activity;
            this.f12572f = eVar;
            this.f12573g = desktopGuideType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DesktopGuideApi.this.p();
            DesktopGuideApi.this.m(this.f12571e, this.f12572f);
            d.b.h0.a.z1.h.h(this.f12573g.ubcType, "desk_flow".equals(this.f12573g.ubcType) ? "flow_close_add" : "flow_add", PrefetchEvent.STATE_CLICK);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.b {
        public f() {
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            DesktopGuideApi.this.f12560f.set(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DesktopGuideApi.this.f12558d != null) {
                DesktopGuideApi.this.f12558d.n();
                DesktopGuideApi.this.f12558d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f12577a;

        public h(d.b.h0.a.r1.e eVar) {
            this.f12577a = eVar;
        }

        @Override // d.b.h0.a.w1.a.f
        public void a(int i) {
            DesktopApiStatus desktopApiStatus;
            String str;
            if (i == -1) {
                desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                str = "desk_notknown";
            } else if (i != 1) {
                desktopApiStatus = DesktopApiStatus.ADD_FAIL;
                if (DesktopGuideApi.this.j + 1 < 3) {
                    DesktopGuideApi desktopGuideApi = DesktopGuideApi.this;
                    desktopGuideApi.u(this.f12577a, desktopGuideApi.f12562h, DesktopGuideApi.this.i, DesktopGuideApi.this.j + 1);
                }
                str = "desk_fail";
            } else {
                desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                str = "desk_success";
            }
            DesktopGuideApi.this.o(desktopApiStatus);
            d.b.h0.a.z1.h.h(DesktopGuideApi.this.f12557c.ubcType, str, PrefetchEvent.STATE_CLICK);
        }
    }

    public DesktopGuideApi(d.b.h0.g.i.b bVar) {
        x();
        q();
    }

    public final void m(@NonNull Context context, @NonNull d.b.h0.a.r1.e eVar) {
        b.a L = eVar.L();
        if (L == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
        } else {
            d.b.h0.a.w1.a.j(context, L, new h(eVar));
        }
    }

    public final void n(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int f2 = h0.f(7.0f);
        int m = h0.m(null);
        int i2 = f2 * 2;
        if (m - i < i2) {
            i = m - i2;
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    @AnyThread
    public final void o(DesktopApiStatus desktopApiStatus) {
        if (this.f12556b != null) {
            d.b.h0.g.i0.b.a(this.f12556b, desktopApiStatus.success, new d.b.h0.g.k0.g.a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    @AnyThread
    public final void p() {
        Runnable runnable = this.f12559e;
        if (runnable != null) {
            k0.W(runnable);
        }
        k0.X(new g());
    }

    public final void q() {
        this.f12559e = new b();
    }

    public final void r() {
        if (this.f12561g != null) {
            return;
        }
        d.b.h0.g.k0.b a2 = d.b.h0.g.k0.b.a();
        this.f12561g = a2;
        if (a2 != null) {
            a2.c(new a());
        }
    }

    public final boolean s(@NonNull Context context, @NonNull d.b.h0.a.r1.e eVar) {
        return d.b.h0.a.w1.a.r(context, eVar.M(), eVar.f46461f) == 1;
    }

    public final void t(@NonNull String str) {
        String string = d.b.h0.a.a2.g.h.a().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.f12562h = Long.parseLong(split[0]);
            this.i = Long.parseLong(split[1]);
            this.j = Long.parseLong(split[2]);
        }
        if (n) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.k + ", mIntervalDays=" + this.l + ", mMaxTimes=" + this.m + " ,storageValue=" + string);
        }
    }

    public final void u(@NonNull d.b.h0.a.r1.e eVar, long j, long j2, long j3) {
        d.b.h0.a.a2.g.b a2 = d.b.h0.a.a2.g.h.a();
        a2.putString("desktop_guide_count_" + eVar.f46461f, j + "#" + j2 + "#" + j3);
    }

    public void v(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.b.h0.g.e.d.c();
        }
        this.f12556b = F;
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        SwanAppActivity n2 = y.n();
        if (n2 == null) {
            o(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.f12557c = DesktopGuideType.parse(F.B("type"));
        String B = F.B("content");
        if (TextUtils.isEmpty(B)) {
            B = n2.getString(this.f12557c.defaultText);
        }
        if (s(n2, y)) {
            o(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        t("desktop_guide_count_" + y.f46461f);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f12562h < this.m && currentTimeMillis - this.i > this.l * 86400000) {
            if (this.f12560f.get()) {
                o(DesktopApiStatus.REACH_MAX_TIMES);
                return;
            }
            this.f12560f.set(true);
            u(y, 1 + this.f12562h, currentTimeMillis, 0L);
            k0.X(new c(n2, y, B, k0.j(y.L(), "ShowAddToDesktopGuide", false)));
            return;
        }
        o(DesktopApiStatus.REACH_MAX_TIMES);
    }

    @UiThread
    public final void w(@NonNull Activity activity, @NonNull d.b.h0.a.r1.e eVar, @NonNull DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Runnable runnable;
        r();
        d.b.h0.g.k0.b bVar = this.f12561g;
        if (bVar != null) {
            bVar.d(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(d.b.h0.a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(d.b.h0.a.f.favorite_guide_content);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        n((ViewGroup) inflate.findViewById(d.b.h0.a.f.favorite_guide_container), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(d.b.h0.a.f.favorite_guide_icon);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(d.b.h0.a.e.aiapps_default_grey_icon);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(d.b.h0.a.f.favorite_guide_close);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new d(desktopGuideType));
        }
        Button button = (Button) inflate.findViewById(d.b.h0.a.f.favorite_guide_add_btn);
        button.setText(d.b.h0.a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new e(activity, eVar, desktopGuideType));
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.f12558d = popupWindow;
        popupWindow.J(16);
        this.f12558d.M(activity.getWindow().getDecorView(), 81, 0, h0.f(50.0f));
        this.f12558d.G(new f());
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && (runnable = this.f12559e) != null) {
            k0.W(runnable);
            k0.U(this.f12559e, this.k * 1000);
        }
        d.b.h0.a.z1.h.h(desktopGuideType.ubcType, d.b.h0.g.k0.g.b.f48976a, "show");
    }

    public final void x() {
        d.b.h0.a.a2.g.b a2 = d.b.h0.a.a2.g.h.a();
        this.k = a2.getLong("swan_favorite_guide_duration", 3L);
        this.l = a2.getLong("swan_favorite_guide_intervalDays", 3L);
        this.m = a2.getLong("swan_favorite_guide_maxTimes", 3L);
    }
}
