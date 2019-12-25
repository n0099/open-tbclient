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
/* loaded from: classes9.dex */
public class DesktopGuideApi implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PopupWindow aYa;
    private com.baidu.swan.games.view.b aYf;
    private long aYp;
    private long aYq;
    private long aYr;
    private volatile long biG;
    protected com.baidu.swan.games.e.b cfI;
    private volatile c coW;
    private volatile DesktopGuideType coX;
    private Runnable coY;
    private AtomicBoolean coZ = new AtomicBoolean(false);
    private volatile long cpa;
    private volatile long cpb;

    public DesktopGuideApi(com.baidu.swan.games.e.b bVar) {
        this.cfI = bVar;
        updateConfig();
        aoh();
    }

    private void updateConfig() {
        com.baidu.swan.apps.storage.c.b acE = h.acE();
        this.aYp = acE.getLong("swan_favorite_guide_duration", 3L);
        this.aYq = acE.getLong("swan_favorite_guide_intervalDays", 3L);
        this.aYr = acE.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    private void GV() {
        if (this.aYf == null) {
            this.aYf = com.baidu.swan.games.view.b.anH();
            if (this.aYf != null) {
                this.aYf.a(new b.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.1
                    @Override // com.baidu.swan.games.view.b.a
                    public void dI(int i) {
                        if (i == 0 && DesktopGuideApi.this.aYa != null && DesktopGuideApi.this.aYa.isShowing()) {
                            DesktopGuideApi.this.yl();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void GW() {
                        if (DesktopGuideApi.this.aYa != null && DesktopGuideApi.this.aYa.isShowing()) {
                            DesktopGuideApi.this.yl();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }
                });
            }
        }
    }

    private void aoh() {
        this.coY = new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.2
            @Override // java.lang.Runnable
            public void run() {
                DesktopGuideApi.this.yl();
                DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
            }
        };
    }

    private void pB(@NonNull String str) {
        String string = h.acE().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.cpa = Long.parseLong(split[0]);
            this.biG = Long.parseLong(split[1]);
            this.cpb = Long.parseLong(split[2]);
        }
        if (DEBUG) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.aYp + ", mIntervalDays=" + this.aYq + ", mMaxTimes=" + this.aYr + " ,storageValue=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, long j, long j2, long j3) {
        h.acE().putString("desktop_guide_count_" + eVar.id, j + "#" + j2 + "#" + j3);
    }

    public void o(JsObject jsObject) {
        c c = c.c(jsObject);
        if (c == null) {
            c = new c();
        }
        this.coW = c;
        final e ZS = e.ZS();
        if (ZS == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        final SwanAppActivity ZO = ZS.ZO();
        if (ZO == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.coX = DesktopGuideType.parse(c.optString("type"));
        String optString = c.optString("content");
        String string = TextUtils.isEmpty(optString) ? ZO.getString(this.coX.defaultText) : optString;
        if (b(ZO, ZS)) {
            a(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        pB("desktop_guide_count_" + ZS.id);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cpa >= this.aYr || currentTimeMillis - this.biG <= this.aYq * 86400000) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else if (this.coZ.get()) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else {
            this.coZ.set(true);
            a(ZS, this.cpa + 1, currentTimeMillis, 0L);
            final Bitmap a = ai.a((com.baidu.swan.apps.x.b.b) ZS.DR(), "ShowAddToDesktopGuide", false);
            final String str = string;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.3
                @Override // java.lang.Runnable
                public void run() {
                    DesktopGuideApi.this.a(ZO, ZS, DesktopGuideApi.this.coX, str, a);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int T = af.T(7.0f);
        int displayWidth = af.getDisplayWidth(null);
        if (displayWidth - i < T * 2) {
            i = displayWidth - (T * 2);
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final e eVar, @NonNull final DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        GV();
        if (this.aYf != null) {
            this.aYf.hH(1);
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
                    DesktopGuideApi.this.yl();
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
                DesktopGuideApi.this.yl();
                DesktopGuideApi.this.a(activity, eVar);
                f.F(desktopGuideType.ubcType, "desk_flow".equals(desktopGuideType.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        });
        this.aYa = new PopupWindow(inflate, -1, -2);
        this.aYa.setSoftInputMode(16);
        this.aYa.showAtLocation(activity.getWindow().getDecorView(), 81, 0, af.T(50.0f));
        this.aYa.a(new PopupWindow.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                DesktopGuideApi.this.coZ.set(false);
            }
        });
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && this.coY != null) {
            ai.k(this.coY);
            ai.b(this.coY, this.aYp * 1000);
        }
        f.F(desktopGuideType.ubcType, cpg, "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void yl() {
        if (this.coY != null) {
            ai.k(this.coY);
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.7
            @Override // java.lang.Runnable
            public void run() {
                if (DesktopGuideApi.this.aYa != null) {
                    DesktopGuideApi.this.aYa.dismiss();
                    DesktopGuideApi.this.aYa = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull final e eVar) {
        b.a DR = eVar.DR();
        if (DR == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
        } else {
            com.baidu.swan.apps.al.a.a(context, DR, new a.InterfaceC0191a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.8
                @Override // com.baidu.swan.apps.al.a.InterfaceC0191a
                public void fY(int i) {
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
                            if (DesktopGuideApi.this.cpb + 1 < 3) {
                                DesktopGuideApi.this.a(eVar, DesktopGuideApi.this.cpa, DesktopGuideApi.this.biG, DesktopGuideApi.this.cpb + 1);
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
                    f.F(DesktopGuideApi.this.coX.ubcType, str, "click");
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
        if (this.coW != null) {
            com.baidu.swan.games.utils.b.a(this.coW, desktopApiStatus.success, new a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
