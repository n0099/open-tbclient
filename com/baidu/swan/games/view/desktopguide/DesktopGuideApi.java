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
/* loaded from: classes7.dex */
public class DesktopGuideApi implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile long cIH;
    private long cwE;
    private long cwF;
    private long cwG;
    private PopupWindow cwo;
    private com.baidu.swan.games.view.b cwu;
    protected com.baidu.swan.games.f.b dPn;
    private volatile c dYV;
    private volatile DesktopGuideType dYW;
    private Runnable dYX;
    private AtomicBoolean dYY = new AtomicBoolean(false);
    private volatile long dYZ;
    private volatile long dZa;

    public DesktopGuideApi(com.baidu.swan.games.f.b bVar) {
        this.dPn = bVar;
        updateConfig();
        aXT();
    }

    private void updateConfig() {
        com.baidu.swan.apps.storage.c.b aKk = h.aKk();
        this.cwE = aKk.getLong("swan_favorite_guide_duration", 3L);
        this.cwF = aKk.getLong("swan_favorite_guide_intervalDays", 3L);
        this.cwG = aKk.getLong("swan_favorite_guide_maxTimes", 3L);
    }

    private void aiV() {
        if (this.cwu == null) {
            this.cwu = com.baidu.swan.games.view.b.aXs();
            if (this.cwu != null) {
                this.cwu.a(new b.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.1
                    @Override // com.baidu.swan.games.view.b.a
                    public void ht(int i) {
                        if (i == 0 && DesktopGuideApi.this.cwo != null && DesktopGuideApi.this.cwo.isShowing()) {
                            DesktopGuideApi.this.TE();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void aiW() {
                        if (DesktopGuideApi.this.cwo != null && DesktopGuideApi.this.cwo.isShowing()) {
                            DesktopGuideApi.this.TE();
                            DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                        }
                    }
                });
            }
        }
    }

    private void aXT() {
        this.dYX = new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.2
            @Override // java.lang.Runnable
            public void run() {
                DesktopGuideApi.this.TE();
                DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
            }
        };
    }

    private void xS(@NonNull String str) {
        String string = h.aKk().getString(str, "");
        String[] split = string.split("#");
        if (split.length == 3 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1]) && TextUtils.isDigitsOnly(split[2])) {
            this.dYZ = Long.parseLong(split[0]);
            this.cIH = Long.parseLong(split[1]);
            this.dZa = Long.parseLong(split[2]);
        }
        if (DEBUG) {
            Log.d("ShowAddToDesktopGuide", "duration=" + this.cwE + ", mIntervalDays=" + this.cwF + ", mMaxTimes=" + this.cwG + " ,storageValue=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull e eVar, long j, long j2, long j3) {
        h.aKk().putString("desktop_guide_count_" + eVar.id, j + "#" + j2 + "#" + j3);
    }

    public void q(JsObject jsObject) {
        c e = c.e(jsObject);
        if (e == null) {
            e = new c();
        }
        this.dYV = e;
        final e aGM = e.aGM();
        if (aGM == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        final SwanAppActivity aGG = aGM.aGG();
        if (aGG == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
            return;
        }
        this.dYW = DesktopGuideType.parse(e.optString("type"));
        String optString = e.optString("content");
        String string = TextUtils.isEmpty(optString) ? aGG.getString(this.dYW.defaultText) : optString;
        if (b(aGG, aGM)) {
            a(DesktopApiStatus.ALREADY_IN_DESKTOP);
            return;
        }
        xS("desktop_guide_count_" + aGM.id);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dYZ >= this.cwG || currentTimeMillis - this.cIH <= this.cwF * 86400000) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else if (this.dYY.get()) {
            a(DesktopApiStatus.REACH_MAX_TIMES);
        } else {
            this.dYY.set(true);
            a(aGM, this.dYZ + 1, currentTimeMillis, 0L);
            final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) aGM.afg(), "ShowAddToDesktopGuide", false);
            final String str = string;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.3
                @Override // java.lang.Runnable
                public void run() {
                    DesktopGuideApi.this.a(aGG, aGM, DesktopGuideApi.this.dYW, str, a2);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, DesktopGuideType desktopGuideType) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i = desktopGuideType.showWidth4px;
        int M = ah.M(7.0f);
        int displayWidth = ah.getDisplayWidth(null);
        if (displayWidth - i < M * 2) {
            i = displayWidth - (M * 2);
        }
        layoutParams.width = i;
        viewGroup.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final e eVar, @NonNull final DesktopGuideType desktopGuideType, @NonNull String str, Bitmap bitmap) {
        aiV();
        if (this.cwu != null) {
            this.cwu.mi(1);
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
                    DesktopGuideApi.this.TE();
                    DesktopGuideApi.this.a(DesktopApiStatus.USER_CANCEL);
                    com.baidu.swan.apps.statistic.h.V(desktopGuideType.ubcType, "flow_close_close", "click");
                }
            });
        }
        Button button = (Button) inflate.findViewById(a.f.favorite_guide_add_btn);
        button.setText(a.h.aiapps_desktop_guide_add);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DesktopGuideApi.this.TE();
                DesktopGuideApi.this.a(activity, eVar);
                com.baidu.swan.apps.statistic.h.V(desktopGuideType.ubcType, "desk_flow".equals(desktopGuideType.ubcType) ? "flow_close_add" : "flow_add", "click");
            }
        });
        this.cwo = new PopupWindow(inflate, -1, -2);
        this.cwo.setSoftInputMode(16);
        this.cwo.showAtLocation(activity.getWindow().getDecorView(), 81, 0, ah.M(50.0f));
        this.cwo.a(new PopupWindow.a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                DesktopGuideApi.this.dYY.set(false);
            }
        });
        if (desktopGuideType == DesktopGuideType.BAR_AUTOHIDE && this.dYX != null) {
            ak.l(this.dYX);
            ak.c(this.dYX, this.cwE * 1000);
        }
        com.baidu.swan.apps.statistic.h.V(desktopGuideType.ubcType, dZf, "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void TE() {
        if (this.dYX != null) {
            ak.l(this.dYX);
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.7
            @Override // java.lang.Runnable
            public void run() {
                if (DesktopGuideApi.this.cwo != null) {
                    DesktopGuideApi.this.cwo.dismiss();
                    DesktopGuideApi.this.cwo = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Context context, @NonNull final e eVar) {
        b.a afg = eVar.afg();
        if (afg == null) {
            a(DesktopApiStatus.EXEC_FAILURE);
        } else {
            com.baidu.swan.apps.ai.a.a(context, afg, new a.InterfaceC0371a() { // from class: com.baidu.swan.games.view.desktopguide.DesktopGuideApi.8
                @Override // com.baidu.swan.apps.ai.a.InterfaceC0371a
                public void kr(int i) {
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
                            if (DesktopGuideApi.this.dZa + 1 < 3) {
                                DesktopGuideApi.this.a(eVar, DesktopGuideApi.this.dYZ, DesktopGuideApi.this.cIH, DesktopGuideApi.this.dZa + 1);
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
                    com.baidu.swan.apps.statistic.h.V(DesktopGuideApi.this.dYW.ubcType, str, "click");
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
        if (this.dYV != null) {
            com.baidu.swan.games.utils.b.a(this.dYV, desktopApiStatus.success, new a(desktopApiStatus.statusCode, desktopApiStatus.statusMsg));
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
