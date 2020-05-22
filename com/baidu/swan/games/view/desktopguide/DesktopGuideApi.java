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
import com.baidu.swan.apps.aj.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
public class DesktopGuideApi implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PopupWindow bKb;
    private com.baidu.swan.games.view.b bKh;
    private long bKr;
    private long bKs;
    private long bKt;
    private volatile long bVo;
    protected com.baidu.swan.games.f.b cTU;
    private Runnable ddA;
    private AtomicBoolean ddB = new AtomicBoolean(false);
    private volatile long ddC;
    private volatile long ddD;
    private volatile c ddy;
    private volatile DesktopGuideType ddz;

    public DesktopGuideApi(com.baidu.swan.games.f.b bVar) {
        this.cTU = bVar;
        updateConfig();
        aCW();
    }

    private void updateConfig() {
        com.baidu.swan.apps.storage.c.b arO = h.arO();
        this.bKr = arO.getLong("swan_favorite_guide_duration", 3L);
        this.bKs = arO.getLong("swan_favorite_guide_intervalDays", 3L);
        this.bKt = arO.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    private void TX() {
        if (this.bKh == null) {
            this.bKh = com.baidu.swan.games.view.b.aCx();
            if (this.bKh != null) {
                this.bKh.a(new b.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.1
                    @Override // com.baidu.swan.games.view.b.a
                    public void ek(int i) {
                        if (i == 0 && DesktopGuideApi.this.bKb != null && DesktopGuideApi.this.bKb.isShowing()) {
                            DesktopGuideApi.this.HR();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void TY() {
                        if (DesktopGuideApi.this.bKb != null && DesktopGuideApi.this.bKb.isShowing()) {
                            DesktopGuideApi.this.HR();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }
                });
            }
        }
    }

    private void aCW() {
        this.ddA = new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.2
            @Override // java.lang.Runnable
            public void run() {
                DesktopGuideApi.this.HR();
                DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
            }
        };
    }

    private void sJ(@NonNull String str) {
        String string = h.arO().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.ddC = Long.parseLong(split[0]);
            this.bVo = Long.parseLong(split[1]);
            this.ddD = Long.parseLong(split[2]);
        }
        if (DEBUG) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.bKr + ", mIntervalDays=" + this.bKs + ", mMaxTimes=" + this.bKt + " ,storageValue=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, long j, long j2, long j3) {
        h.arO().putString("desktop_guide_count_" + eVar.id, j + "#" + j2 + "#" + j3);
    }

    public void q(JsObject jsObject) {
        c e = c.e(jsObject);
        if (e == null) {
            e = new c();
        }
        this.ddy = e;
        final e aoF = e.aoF();
        if (aoF == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        final SwanAppActivity aoz = aoF.aoz();
        if (aoz == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.ddz = DesktopGuideType.parse(e.optString("type"));
        String optString = e.optString("content");
        String string = TextUtils.isEmpty(optString) ? aoz.getString(this.ddz.defaultText) : optString;
        if (b(aoz, aoF)) {
            a(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        sJ("desktop_guide_count_" + aoF.id);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.ddC >= this.bKt || currentTimeMillis - this.bVo <= this.bKs * 86400000) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else if (this.ddB.get()) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else {
            this.ddB.set(true);
            a(aoF, this.ddC + 1, currentTimeMillis, 0L);
            final Bitmap a = aj.a((com.baidu.swan.apps.v.b.b) aoF.QJ(), "ShowAddToDesktopGuide", false);
            final String str = string;
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.3
                @Override // java.lang.Runnable
                public void run() {
                    DesktopGuideApi.this.a(aoz, aoF, DesktopGuideApi.this.ddz, str, a);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int B = ag.B(7.0f);
        int displayWidth = ag.getDisplayWidth(null);
        if (displayWidth - i < B * 2) {
            i = displayWidth - (B * 2);
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final e eVar, @NonNull final DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        TX();
        if (this.bKh != null) {
            this.bKh.iw(1);
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
                    DesktopGuideApi.this.HR();
                    DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                    com.baidu.swan.apps.statistic.h.J(desktopGuideType.ubcType, "flow_close_close", "click");
                }
            });
        }
        Button button = (Button) inflate.findViewById(a.f.favorite_guide_add_btn);
        button.setText(a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DesktopGuideApi.this.HR();
                DesktopGuideApi.this.a(activity, eVar);
                com.baidu.swan.apps.statistic.h.J(desktopGuideType.ubcType, "desk_flow".equals(desktopGuideType.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        });
        this.bKb = new PopupWindow(inflate, -1, -2);
        this.bKb.setSoftInputMode(16);
        this.bKb.showAtLocation(activity.getWindow().getDecorView(), 81, 0, ag.B(50.0f));
        this.bKb.a(new PopupWindow.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                DesktopGuideApi.this.ddB.set(false);
            }
        });
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && this.ddA != null) {
            aj.o(this.ddA);
            aj.c(this.ddA, this.bKr * 1000);
        }
        com.baidu.swan.apps.statistic.h.J(desktopGuideType.ubcType, ddI, "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void HR() {
        if (this.ddA != null) {
            aj.o(this.ddA);
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.7
            @Override // java.lang.Runnable
            public void run() {
                if (DesktopGuideApi.this.bKb != null) {
                    DesktopGuideApi.this.bKb.dismiss();
                    DesktopGuideApi.this.bKb = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull final e eVar) {
        b.a QJ = eVar.QJ();
        if (QJ == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
        } else {
            com.baidu.swan.apps.aj.a.a(context, QJ, new a.InterfaceC0287a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.8
                @Override // com.baidu.swan.apps.aj.a.InterfaceC0287a
                public void gP(int i) {
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
                            if (DesktopGuideApi.this.ddD + 1 < 3) {
                                DesktopGuideApi.this.a(eVar, DesktopGuideApi.this.ddC, DesktopGuideApi.this.bVo, DesktopGuideApi.this.ddD + 1);
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
                    com.baidu.swan.apps.statistic.h.J(DesktopGuideApi.this.ddz.ubcType, str, "click");
                }
            });
        }
    }

    private boolean b(@NonNull Context context, @NonNull e eVar) {
        return com.baidu.swan.apps.aj.a.p(context, eVar.getName(), eVar.id) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(DesktopApiStatus desktopApiStatus) {
        if (this.ddy != null) {
            com.baidu.swan.games.utils.b.a(this.ddy, desktopApiStatus.success, new a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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
