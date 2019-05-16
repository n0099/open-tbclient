package com.baidu.swan.apps.scheme.actions.favorite;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.os.Process;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowFavoriteGuideAction extends z {
    public static GuideType aSh;
    private PopupWindow aRY;
    private Timer aRZ;
    private Bitmap aSa;
    private SwanAppActivity aSb;
    private ContentObserver aSc;
    private com.baidu.swan.apps.o.a aSd;
    private long aSe;
    private long aSf;
    private long aSg;
    private String ayh;
    private CallbackHandler mCallbackHandler;

    public ShowFavoriteGuideAction(j jVar) {
        super(jVar, "/swan/showFavoriteGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        this.mCallbackHandler = callbackHandler;
        final JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null || bVar == null || !(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        com.baidu.swan.apps.an.j.Oz().d(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.storage.b.f Ni = com.baidu.swan.apps.storage.b.f.Ni();
                final GuideType parse = GuideType.parse(c.optString("type"));
                final String optString = c.optString("content", null);
                if (TextUtils.isEmpty(optString)) {
                    optString = context.getString(parse.defaultText);
                }
                ShowFavoriteGuideAction.this.ayh = c.optString("cb");
                String str = bVar.id;
                String str2 = "favorite_guide_count_" + str;
                if (com.baidu.swan.apps.database.favorite.a.eg(str)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite already");
                    com.baidu.swan.apps.storage.b.f.Ni().putString(str2, LivenessStat.TYPE_STRING_DEFAULT);
                    return;
                }
                String string = com.baidu.swan.apps.storage.b.f.Ni().getString(str2, "");
                if (TextUtils.equals(LivenessStat.TYPE_STRING_DEFAULT, string)) {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "favorite at one time");
                    return;
                }
                String[] split = string.split("#");
                int i = 0;
                long j = 0;
                if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                    i = Integer.parseInt(split[0]);
                    j = Long.parseLong(split[1]);
                }
                long currentTimeMillis = System.currentTimeMillis();
                ShowFavoriteGuideAction.this.aSe = Ni.getLong("swan_favorite_guide_duration", 3L);
                ShowFavoriteGuideAction.this.aSf = Ni.getLong("swan_favorite_guide_intervalDays", 3L);
                ShowFavoriteGuideAction.this.aSg = Ni.getLong("swan_favorite_guide_maxTimes", 3L);
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "duration=" + ShowFavoriteGuideAction.this.aSe + ", mIntervalDays=" + ShowFavoriteGuideAction.this.aSf + ", mMaxTimes=" + ShowFavoriteGuideAction.this.aSg + " ,storageValue=" + string);
                if (i < ShowFavoriteGuideAction.this.aSg && currentTimeMillis - j > ShowFavoriteGuideAction.this.aSf * 86400000) {
                    com.baidu.swan.apps.storage.b.f.Ni().putString(str2, (i + 1) + "#" + currentTimeMillis);
                    ShowFavoriteGuideAction.this.aSa = ac.a(bVar.vk(), "ShowFavoriteGuideAction", false);
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ShowFavoriteGuideAction.this.a((Activity) context, bVar, parse, optString);
                        }
                    });
                    return;
                }
                com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }, "ShowFavoriteGuideAction");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(@NonNull final Activity activity, @NonNull final com.baidu.swan.apps.ae.b bVar, @NonNull final GuideType guideType, String str) {
        final com.baidu.swan.apps.core.d.e vi;
        Me();
        a(activity, bVar);
        View inflate = LayoutInflater.from(activity).inflate(guideType == GuideType.TIPS ? a.g.aiapps_favorite_guide_tips : a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(a.f.favorite_guide_content);
        if (textView != null && str != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str = str.substring(0, guideType.limit - 1) + "...";
            }
            textView.setText(str);
        }
        if (guideType == GuideType.TIPS) {
            final View findViewById = activity.findViewById(a.f.titlebar_right_menu_img);
            if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((com.baidu.swan.apps.an.z.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - com.baidu.swan.apps.an.z.ad(7.0f), 0);
                this.aRY = new PopupWindow(inflate, -2, -2);
                this.aRY.showAsDropDown(findViewById, 0, -com.baidu.swan.apps.an.z.ad(3.0f));
                if (this.aSb != null && (vi = this.aSb.vi()) != null) {
                    final com.baidu.swan.apps.core.d.b zK = vi.zK();
                    findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if ((vi != null && zK != vi.zK()) || com.baidu.swan.apps.an.z.OM()) {
                                ShowFavoriteGuideAction.this.Me();
                                if (findViewById != null) {
                                    findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }
                            }
                        }
                    });
                }
            }
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(a.f.favorite_guide_container);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            int i = guideType.showWidth4px;
            int ad = com.baidu.swan.apps.an.z.ad(7.0f);
            int displayWidth = com.baidu.swan.apps.an.z.getDisplayWidth(null);
            if (displayWidth - i < ad * 2) {
                i = displayWidth - (ad * 2);
            }
            layoutParams.width = i;
            relativeLayout.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_icon);
            if (this.aSa != null) {
                imageView.setImageBitmap(this.aSa);
            } else {
                imageView.setImageResource(a.e.aiapps_default_grey_icon);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
            if (guideType == GuideType.WEAK) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ShowFavoriteGuideAction.this.Me();
                        ShowFavoriteGuideAction.this.cs(false);
                        ShowFavoriteGuideAction.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ShowFavoriteGuideAction.aSh = guideType;
                    boolean Q = com.baidu.swan.apps.view.coverview.c.b.Q(activity);
                    ShowFavoriteGuideAction.this.cs(Q);
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "add favorite result=" + Q);
                    ShowFavoriteGuideAction.this.Me();
                    if (ShowFavoriteGuideAction.this.aRZ != null) {
                        ShowFavoriteGuideAction.this.aRZ.cancel();
                    }
                    ShowFavoriteGuideAction.a(guideType, guideType == GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.aRY = new PopupWindow(inflate, -1, -2);
            this.aRY.setSoftInputMode(16);
            this.aRY.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) com.baidu.swan.apps.an.z.ae(50.0f));
        }
        if (guideType == GuideType.TIPS || guideType == GuideType.WEAK) {
            if (this.aRZ != null) {
                this.aRZ.cancel();
            }
            this.aRZ = new Timer();
            this.aRZ.schedule(new TimerTask() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ShowFavoriteGuideAction.this.Me();
                    ShowFavoriteGuideAction.this.cs(com.baidu.swan.apps.database.favorite.a.eg(bVar.id));
                    if (ShowFavoriteGuideAction.this.aRZ != null) {
                        ShowFavoriteGuideAction.this.aRZ.cancel();
                    }
                }
            }, this.aSe * 1000);
        }
        a(guideType, "", SmsLoginView.StatEvent.LOGIN_SHOW);
    }

    private void a(@NonNull Activity activity, @NonNull final com.baidu.swan.apps.ae.b bVar) {
        this.aSc = new ContentObserver(null) { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                com.baidu.swan.apps.an.j.OB().execute(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.eg(bVar.id)) {
                            ShowFavoriteGuideAction.this.Me();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.BQ(), false, this.aSc);
        if (activity instanceof SwanAppActivity) {
            this.aSb = (SwanAppActivity) activity;
            if (this.aSd != null) {
                this.aSb.b(this.aSd);
            }
            this.aSd = new com.baidu.swan.apps.o.a() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.7
                @Override // com.baidu.swan.apps.o.a, com.baidu.swan.apps.o.b
                public void CH() {
                    com.baidu.swan.apps.console.c.i("ShowFavoriteGuideAction", "call onActivityDestroyed");
                    ShowFavoriteGuideAction.this.Me();
                    if (ShowFavoriteGuideAction.this.aSb != null && ShowFavoriteGuideAction.this.aSd != null) {
                        ShowFavoriteGuideAction.this.aSb.b(ShowFavoriteGuideAction.this.aSd);
                    }
                }
            };
            this.aSb.a(this.aSd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void Me() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction.8
            @Override // java.lang.Runnable
            public void run() {
                if (ShowFavoriteGuideAction.this.aRY != null) {
                    ShowFavoriteGuideAction.this.aRY.dismiss();
                }
            }
        });
        if (this.aSc != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.aSc);
            this.aSc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void cs(boolean z) {
        if (this.ayh != null && this.mCallbackHandler != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mCallbackHandler.handleSchemeDispatchCallback(this.ayh, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
        }
    }

    /* loaded from: classes2.dex */
    public enum GuideType {
        NORMAL("bar", -1, 992, a.h.aiapps_favorite_guide_default_hint),
        WEAK("bar-autohide", -1, 865, a.h.aiapps_favorite_guide_default_hint),
        TIPS("tip", 18, -1, a.h.aiapps_favorite_guide_default_tips);
        
        @StringRes
        private int defaultText;
        private int limit;
        private int showWidth4px;
        private String typeName;

        GuideType(String str, int i, int i2, int i3) {
            this.typeName = str;
            this.limit = i;
            this.showWidth4px = i2;
            this.defaultText = i3;
        }

        public static GuideType parse(String str) {
            GuideType[] values;
            if (!TextUtils.isEmpty(str)) {
                for (GuideType guideType : values()) {
                    if (TextUtils.equals(guideType.typeName, str)) {
                        return guideType;
                    }
                }
            }
            return NORMAL;
        }
    }

    public static void a(GuideType guideType, String str, String str2) {
        String str3;
        String LB = com.baidu.swan.apps.ae.b.LB();
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        if (guideType == null) {
            str3 = "window";
        } else {
            switch (guideType) {
                case TIPS:
                    str3 = "TIPS";
                    break;
                case WEAK:
                    str3 = "flow";
                    break;
                default:
                    str3 = "flow_close";
                    break;
            }
        }
        fVar.mType = str3;
        fVar.mSource = str;
        fVar.mValue = str2;
        fVar.k("appkey", LB);
        com.baidu.swan.apps.statistic.e.a("923", fVar);
    }
}
