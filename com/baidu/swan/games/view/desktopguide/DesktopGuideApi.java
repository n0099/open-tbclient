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
import com.baidu.swan.apps.ai.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class DesktopGuideApi implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private PopupWindow cjA;
    private com.baidu.swan.games.view.b cjG;
    private long cjQ;
    private long cjR;
    private long cjS;
    private volatile long cwc;
    protected com.baidu.swan.games.f.b dCG;
    private volatile c dMo;
    private volatile DesktopGuideType dMp;
    private Runnable dMq;
    private AtomicBoolean dMr = new AtomicBoolean(false);
    private volatile long dMs;
    private volatile long dMt;

    public DesktopGuideApi(com.baidu.swan.games.f.b bVar) {
        this.dCG = bVar;
        updateConfig();
        aUg();
    }

    private void updateConfig() {
        com.baidu.swan.apps.storage.c.b aGy = h.aGy();
        this.cjQ = aGy.getLong("swan_favorite_guide_duration", 3L);
        this.cjR = aGy.getLong("swan_favorite_guide_intervalDays", 3L);
        this.cjS = aGy.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    private void afj() {
        if (this.cjG == null) {
            this.cjG = com.baidu.swan.games.view.b.aTG();
            if (this.cjG != null) {
                this.cjG.a(new b.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.1
                    @Override // com.baidu.swan.games.view.b.a
                    public void hc(int i) {
                        if (i == 0 && DesktopGuideApi.this.cjA != null && DesktopGuideApi.this.cjA.isShowing()) {
                            DesktopGuideApi.this.QK();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void afk() {
                        if (DesktopGuideApi.this.cjA != null && DesktopGuideApi.this.cjA.isShowing()) {
                            DesktopGuideApi.this.QK();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }
                });
            }
        }
    }

    private void aUg() {
        this.dMq = new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.2
            @Override // java.lang.Runnable
            public void run() {
                DesktopGuideApi.this.QK();
                DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
            }
        };
    }

    private void xq(@NonNull String str) {
        String string = h.aGy().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.dMs = Long.parseLong(split[0]);
            this.cwc = Long.parseLong(split[1]);
            this.dMt = Long.parseLong(split[2]);
        }
        if (DEBUG) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.cjQ + ", mIntervalDays=" + this.cjR + ", mMaxTimes=" + this.cjS + " ,storageValue=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, long j, long j2, long j3) {
        h.aGy().putString("desktop_guide_count_" + eVar.id, j + "#" + j2 + "#" + j3);
    }

    public void q(JsObject jsObject) {
        c e = c.e(jsObject);
        if (e == null) {
            e = new c();
        }
        this.dMo = e;
        final e aDa = e.aDa();
        if (aDa == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        final SwanAppActivity aCU = aDa.aCU();
        if (aCU == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.dMp = DesktopGuideType.parse(e.optString("type"));
        String optString = e.optString("content");
        String string = TextUtils.isEmpty(optString) ? aCU.getString(this.dMp.defaultText) : optString;
        if (b(aCU, aDa)) {
            a(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        xq("desktop_guide_count_" + aDa.id);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dMs >= this.cjS || currentTimeMillis - this.cwc <= this.cjR * 86400000) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else if (this.dMr.get()) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else {
            this.dMr.set(true);
            a(aDa, this.dMs + 1, currentTimeMillis, 0L);
            final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) aDa.abu(), "ShowAddToDesktopGuide", false);
            final String str = string;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.3
                @Override // java.lang.Runnable
                public void run() {
                    DesktopGuideApi.this.a(aCU, aDa, DesktopGuideApi.this.dMp, str, a2);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int J = ah.J(7.0f);
        int displayWidth = ah.getDisplayWidth(null);
        if (displayWidth - i < J * 2) {
            i = displayWidth - (J * 2);
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final e eVar, @NonNull final DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        afj();
        if (this.cjG != null) {
            this.cjG.lR(1);
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
                    DesktopGuideApi.this.QK();
                    DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                    com.baidu.swan.apps.statistic.h.O(desktopGuideType.ubcType, "flow_close_close", "click");
                }
            });
        }
        Button button = (Button) inflate.findViewById(a.f.favorite_guide_add_btn);
        button.setText(a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DesktopGuideApi.this.QK();
                DesktopGuideApi.this.a(activity, eVar);
                com.baidu.swan.apps.statistic.h.O(desktopGuideType.ubcType, "desk_flow".equals(desktopGuideType.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        });
        this.cjA = new PopupWindow(inflate, -1, -2);
        this.cjA.setSoftInputMode(16);
        this.cjA.showAtLocation(activity.getWindow().getDecorView(), 81, 0, ah.J(50.0f));
        this.cjA.a(new PopupWindow.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                DesktopGuideApi.this.dMr.set(false);
            }
        });
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && this.dMq != null) {
            ak.l(this.dMq);
            ak.c(this.dMq, this.cjQ * 1000);
        }
        com.baidu.swan.apps.statistic.h.O(desktopGuideType.ubcType, dMy, "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void QK() {
        if (this.dMq != null) {
            ak.l(this.dMq);
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.7
            @Override // java.lang.Runnable
            public void run() {
                if (DesktopGuideApi.this.cjA != null) {
                    DesktopGuideApi.this.cjA.dismiss();
                    DesktopGuideApi.this.cjA = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull final e eVar) {
        b.a abu = eVar.abu();
        if (abu == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
        } else {
            com.baidu.swan.apps.ai.a.a(context, abu, new a.InterfaceC0347a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.8
                @Override // com.baidu.swan.apps.ai.a.InterfaceC0347a
                public void ka(int i) {
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
                            if (DesktopGuideApi.this.dMt + 1 < 3) {
                                DesktopGuideApi.this.a(eVar, DesktopGuideApi.this.dMs, DesktopGuideApi.this.cwc, DesktopGuideApi.this.dMt + 1);
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
                    com.baidu.swan.apps.statistic.h.O(DesktopGuideApi.this.dMp.ubcType, str, "click");
                }
            });
        }
    }

    private boolean b(@NonNull Context context, @NonNull e eVar) {
        return com.baidu.swan.apps.ai.a.r(context, eVar.getName(), eVar.id) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void a(DesktopApiStatus desktopApiStatus) {
        if (this.dMo != null) {
            com.baidu.swan.games.utils.b.a(this.dMo, desktopApiStatus.success, new a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
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
