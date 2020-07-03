package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.database.ContentObserver;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.b;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.a;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType bON;
    private static volatile a bOO;
    private PopupWindow bOP;
    private Timer bOQ;
    private SwanAppActivity bOR;
    private b bOS;
    private ContentObserver bOT;
    private com.baidu.swan.apps.framework.a bOU;
    private com.baidu.swan.games.view.b bOV;
    private InterfaceC0311a bOW;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0311a {
        void dp(boolean z);
    }

    private a() {
    }

    public static a Vc() {
        if (bOO == null) {
            synchronized (a.class) {
                if (bOO == null) {
                    bOO = new a();
                }
            }
        }
        return bOO;
    }

    @UiThread
    public void a(@Nullable InterfaceC0311a interfaceC0311a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final com.baidu.swan.apps.core.d.e RN;
        this.bOW = interfaceC0311a;
        Je();
        if (eVar.aqf()) {
            Vd();
            if (this.bOV != null) {
                this.bOV.iJ(0);
            }
        }
        a(activity, eVar, guideType);
        View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? a.g.aiapps_favorite_guide_tips : a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(a.f.favorite_guide_content);
        if (textView != null && str != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str = str.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str);
        }
        View findViewById = activity.findViewById(a.f.titlebar_right_menu_img);
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
            if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ag.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ag.D(7.0f), 0);
                this.bOP = new PopupWindow(inflate, -2, -2);
                if (this.bOR != null && !this.bOR.isFinishing() && !this.bOR.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bOP.showAsDropDown(findViewById, 0, -ag.D(3.0f));
                    } catch (WindowManager.BadTokenException e) {
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.e("FavoriteGuideHelper", "Bad token when showing fav guide popup!");
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(a.f.favorite_guide_container);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            int i = guideType.showWidth4px;
            int D = ag.D(7.0f);
            int displayWidth = ag.getDisplayWidth(null);
            if (displayWidth - i < D * 2) {
                i = displayWidth - (D * 2);
            }
            layoutParams.width = i;
            relativeLayout.setLayoutParams(layoutParams);
            aj.a((ImageView) inflate.findViewById(a.f.favorite_guide_icon), str2, a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Je();
                        if (a.this.bOW != null) {
                            a.this.bOW.dp(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bON = guideType;
                    com.baidu.swan.apps.y.a.a(activity, new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.y.a.InterfaceC0409a
                        public void onSuccess() {
                            if (a.this.bOW != null) {
                                a.this.bOW.dp(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.y.a.InterfaceC0409a
                        public void onFail() {
                            if (a.this.bOW != null) {
                                a.this.bOW.dp(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Je();
                    if (a.this.bOQ != null) {
                        a.this.bOQ.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bOP = new PopupWindow(inflate, -1, -2);
            this.bOP.setSoftInputMode(16);
            this.bOP.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ag.E(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bOR != null && (RN = this.bOR.RN()) != null && findViewById != null) {
            final d ZX = RN.ZX();
            final String ZH = ZX == null ? "" : ZX.ZH();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bOP != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bOS != RN.ZV() || ((ZX != null && !TextUtils.equals(ZH, ZX.ZH())) || (!eVar.aqf() && ag.isScreenLand()))) {
                            a.this.Je();
                            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bOQ != null) {
                this.bOQ.cancel();
            }
            this.bOQ = new Timer();
            this.bOQ.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Je();
                    if (a.this.bOW != null) {
                        a.this.bOW.dp(com.baidu.swan.apps.database.favorite.a.ke(eVar.id));
                    }
                    if (a.this.bOQ != null) {
                        a.this.bOQ.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void Vd() {
        if (this.bOV == null) {
            this.bOV = com.baidu.swan.games.view.b.aDD();
            if (this.bOV != null) {
                this.bOV.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ex(int i) {
                        if (i == 1) {
                            a.this.Je();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void Ve() {
                        a.this.Je();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.bOT = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                n.auC().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.ke(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bOW != null) {
                                a.this.bOW.dp(true);
                            }
                            a.this.Je();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.adg(), false, this.bOT);
        if (activity instanceof SwanAppActivity) {
            this.bOR = (SwanAppActivity) activity;
            if (this.bOU != null) {
                this.bOR.b(this.bOU);
            }
            this.bOU = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Vf() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Je();
                    if (a.this.bOR != null && a.this.bOU != null) {
                        a.this.bOR.b(a.this.bOU);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Vg() {
                    super.Vg();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.apO());
                    if (!TextUtils.equals(eVar.id, e.apO())) {
                        a.this.Je();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Vh() {
                    if (a.this.bOP != null && a.this.bOP.isShowing()) {
                        a.this.Je();
                    }
                }
            };
            this.bOR.a(this.bOU);
        }
        com.baidu.swan.apps.core.d.e RN = this.bOR.RN();
        if (RN != null) {
            this.bOS = RN.ZV();
            if (this.bOS != null) {
                this.bOS.a(new b.InterfaceC0342b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.b.InterfaceC0342b
                    public void Vh() {
                        a.this.Je();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void Je() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bOP != null) {
                    a.this.bOP.dismiss();
                    a.this.bOP = null;
                }
                if (a.this.bOT != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bOT);
                    a.this.bOT = null;
                }
                if (a.this.bOR != null && a.this.bOU != null) {
                    a.this.bOR.b(a.this.bOU);
                }
                if (a.this.bOS != null) {
                    a.this.bOS.a((b.InterfaceC0342b) null);
                }
            }
        });
    }
}
