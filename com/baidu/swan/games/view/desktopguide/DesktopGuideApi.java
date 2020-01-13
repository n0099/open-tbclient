package com.baidu.swan.games.view.desktopguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.al.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class DesktopGuideApi implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PopupWindow aYS;
    private com.baidu.swan.games.view.b aYX;
    private long aZh;
    private long aZi;
    private long aZj;
    private volatile long bjv;
    protected com.baidu.swan.games.e.b cfV;
    private volatile c cpi;
    private volatile DesktopGuideType cpj;
    private Runnable cpk;
    private AtomicBoolean cpl = new AtomicBoolean(false);
    private volatile long cpm;
    private volatile long cpn;

    public DesktopGuideApi(com.baidu.swan.games.e.b bVar) {
        this.cfV = bVar;
        updateConfig();
        aoA();
    }

    private void updateConfig() {
        com.baidu.swan.apps.storage.c.b adb = h.adb();
        this.aZh = adb.getLong("swan_favorite_guide_duration", 3L);
        this.aZi = adb.getLong("swan_favorite_guide_intervalDays", 3L);
        this.aZj = adb.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    private void Hr() {
        if (this.aYX == null) {
            this.aYX = com.baidu.swan.games.view.b.aoa();
            if (this.aYX != null) {
                this.aYX.a(new b.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.1
                    @Override // com.baidu.swan.games.view.b.a
                    public void dJ(int i) {
                        if (i == 0 && DesktopGuideApi.this.aYS != null && DesktopGuideApi.this.aYS.isShowing()) {
                            DesktopGuideApi.this.yB();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void Hs() {
                        if (DesktopGuideApi.this.aYS != null && DesktopGuideApi.this.aYS.isShowing()) {
                            DesktopGuideApi.this.yB();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }
                });
            }
        }
    }

    private void aoA() {
        this.cpk = new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.2
            @Override // java.lang.Runnable
            public void run() {
                DesktopGuideApi.this.yB();
                DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
            }
        };
    }

    private void pE(@NonNull String str) {
        String string = h.adb().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.cpm = Long.parseLong(split[0]);
            this.bjv = Long.parseLong(split[1]);
            this.cpn = Long.parseLong(split[2]);
        }
        if (DEBUG) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.aZh + ", mIntervalDays=" + this.aZi + ", mMaxTimes=" + this.aZj + " ,storageValue=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, long j, long j2, long j3) {
        h.adb().putString("desktop_guide_count_" + eVar.id, j + "#" + j2 + "#" + j3);
    }

    public void o(JsObject jsObject) {
        c c = c.c(jsObject);
        if (c == null) {
            c = new c();
        }
        this.cpi = c;
        final e aap = e.aap();
        if (aap == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        final SwanAppActivity aal = aap.aal();
        if (aal == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.cpj = DesktopGuideType.parse(c.optString("type"));
        String optString = c.optString("content");
        String string = TextUtils.isEmpty(optString) ? aal.getString(this.cpj.defaultText) : optString;
        if (b(aal, aap)) {
            a(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        pE("desktop_guide_count_" + aap.id);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cpm >= this.aZj || currentTimeMillis - this.bjv <= this.aZi * 86400000) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else if (this.cpl.get()) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else {
            this.cpl.set(true);
            a(aap, this.cpm + 1, currentTimeMillis, 0L);
            final Bitmap a = ai.a((com.baidu.swan.apps.x.b.b) aap.En(), "ShowAddToDesktopGuide", false);
            final String str = string;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.3
                @Override // java.lang.Runnable
                public void run() {
                    DesktopGuideApi.this.a(aal, aap, DesktopGuideApi.this.cpj, str, a);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int S = af.S(7.0f);
        int displayWidth = af.getDisplayWidth(null);
        if (displayWidth - i < S * 2) {
            i = displayWidth - (S * 2);
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final e eVar, @NonNull final DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        Hr();
        if (this.aYX != null) {
            this.aYX.hH(1);
        }
        View inflate = LayoutInflater.from(activity).inflate(a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(a.f.favorite_guide_content);
        if (desktopGuideType.limit != -1 && str.length() > desktopGuideType.limit) {
            str = str.substring(0, desktopGuideType.limit - 1) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        a((ViewGroup) inflate.findViewById(a.f.favorite_guide_container), desktopGuideType);
        ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_icon);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(a.e.aiapps_default_grey_icon);
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DesktopGuideApi.this.yB();
                    DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                    f.F(desktopGuideType.ubcType, "flow_close_close", "click");
                }
            });
        }
        Button button = (Button) inflate.findViewById(a.f.favorite_guide_add_btn);
        button.setText(a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DesktopGuideApi.this.yB();
                DesktopGuideApi.this.a(activity, eVar);
                f.F(desktopGuideType.ubcType, "desk_flow".equals(desktopGuideType.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        });
        this.aYS = new PopupWindow(inflate, -1, -2);
        this.aYS.setSoftInputMode(16);
        this.aYS.showAtLocation(activity.getWindow().getDecorView(), 81, 0, af.S(50.0f));
        this.aYS.a(new PopupWindow.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                DesktopGuideApi.this.cpl.set(false);
            }
        });
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && this.cpk != null) {
            ai.k(this.cpk);
            ai.b(this.cpk, this.aZh * 1000);
        }
        f.F(desktopGuideType.ubcType, cps, "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void yB() {
        if (this.cpk != null) {
            ai.k(this.cpk);
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.7
            @Override // java.lang.Runnable
            public void run() {
                if (DesktopGuideApi.this.aYS != null) {
                    DesktopGuideApi.this.aYS.dismiss();
                    DesktopGuideApi.this.aYS = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull final e eVar) {
        b.a En = eVar.En();
        if (En == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
        } else {
            com.baidu.swan.apps.al.a.a(context, En, new a.InterfaceC0193a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.8
                @Override // com.baidu.swan.apps.al.a.InterfaceC0193a
                public void fZ(int i) {
                    DesktopApiStatus desktopApiStatus;
                    String str;
                    switch (i) {
                        case -1:
                            desktopApiStatus = DesktopApiStatus.ADD_UNKNOWN;
                            str = "desk_notknown";
                            break;
                        case 0:
                        default:
                            DesktopApiStatus desktopApiStatus2 = DesktopApiStatus.ADD_FAIL;
                            if (DesktopGuideApi.this.cpn + 1 < 3) {
                                DesktopGuideApi.this.a(eVar, DesktopGuideApi.this.cpm, DesktopGuideApi.this.bjv, DesktopGuideApi.this.cpn + 1);
                            }
                            str = "desk_fail";
                            desktopApiStatus = desktopApiStatus2;
                            break;
                        case 1:
                            desktopApiStatus = DesktopApiStatus.ADD_SUCCESS;
                            str = "desk_success";
                            break;
                    }
                    DesktopGuideApi.this.a(desktopApiStatus);
                    f.F(DesktopGuideApi.this.cpj.ubcType, str, "click");
                }
            });
        }
    }

    private boolean b(@NonNull Context context, @NonNull e eVar) {
        return com.baidu.swan.apps.al.a.n(context, eVar.getName(), eVar.id) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(DesktopApiStatus desktopApiStatus) {
        if (this.cpi != null) {
            com.baidu.swan.games.utils.b.a(this.cpi, desktopApiStatus.success, new a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    /* loaded from: classes10.dex */
    public enum DesktopGuideType {
        BAR("bar", -1, 992, "desk_flow", a.h.swangame_desktop_guide_default_hint),
        BAR_AUTOHIDE("bar-autohide", -1, 865, "desk_flow_close", a.h.swangame_desktop_guide_default_hint);
        
        @StringRes
        private int defaultText;
        private int limit;
        private int showWidth4px;
        private String typeName;
        private String ubcType;

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

    /* loaded from: classes10.dex */
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
}
