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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.menu.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType bVe;
    private static volatile a bVf;
    private PopupWindow bVg;
    private Timer bVh;
    private SwanAppActivity bVi;
    private c bVj;
    private ContentObserver bVk;
    private com.baidu.swan.apps.framework.a bVl;
    private b bVm;
    private InterfaceC0355a bVn;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0355a {
        void dB(boolean z);
    }

    private a() {
    }

    public static a abN() {
        if (bVf == null) {
            synchronized (a.class) {
                if (bVf == null) {
                    bVf = new a();
                }
            }
        }
        return bVf;
    }

    @UiThread
    public void a(@Nullable InterfaceC0355a interfaceC0355a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f XX;
        this.bVn = interfaceC0355a;
        Pc();
        if (eVar.aAb()) {
            abO();
            if (this.bVm != null) {
                this.bVm.lj(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.H(7.0f), 0);
                this.bVg = new PopupWindow(inflate, -2, -2);
                if (this.bVi != null && !this.bVi.isFinishing() && !this.bVi.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bVg.showAsDropDown(findViewById, 0, -ah.H(3.0f));
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
            int H = ah.H(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < H * 2) {
                i = displayWidth - (H * 2);
            }
            layoutParams.width = i;
            relativeLayout.setLayoutParams(layoutParams);
            ak.a((ImageView) inflate.findViewById(a.f.favorite_guide_icon), str2, a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Pc();
                        if (a.this.bVn != null) {
                            a.this.bVn.dB(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bVe = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0416a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0416a
                        public void onSuccess() {
                            if (a.this.bVn != null) {
                                a.this.bVn.dB(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0416a
                        public void onFail() {
                            if (a.this.bVn != null) {
                                a.this.bVn.dB(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Pc();
                    if (a.this.bVh != null) {
                        a.this.bVh.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bVg = new PopupWindow(inflate, -1, -2);
            this.bVg.setSoftInputMode(16);
            this.bVg.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.I(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bVi != null && (XX = this.bVi.XX()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e aho = XX.aho();
            final String agW = aho == null ? "" : aho.agW();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bVg != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bVj != XX.ahm() || ((aho != null && !TextUtils.equals(agW, aho.agW())) || (!eVar.aAb() && ah.isScreenLand()))) {
                            a.this.Pc();
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
            if (this.bVh != null) {
                this.bVh.cancel();
            }
            this.bVh = new Timer();
            this.bVh.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Pc();
                    if (a.this.bVn != null) {
                        a.this.bVn.dB(com.baidu.swan.apps.database.favorite.a.mb(eVar.id));
                    }
                    if (a.this.bVh != null) {
                        a.this.bVh.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void abO() {
        if (this.bVm == null) {
            this.bVm = b.aQl();
            if (this.bVm != null) {
                this.bVm.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void gw(int i) {
                        if (i == 1) {
                            a.this.Pc();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void abP() {
                        a.this.Pc();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.bVk = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aEO().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.mb(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bVn != null) {
                                a.this.bVn.dB(true);
                            }
                            a.this.Pc();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.akV(), false, this.bVk);
        if (activity instanceof SwanAppActivity) {
            this.bVi = (SwanAppActivity) activity;
            if (this.bVl != null) {
                this.bVi.b(this.bVl);
            }
            this.bVl = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void abQ() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Pc();
                    if (a.this.bVi != null && a.this.bVl != null) {
                        a.this.bVi.b(a.this.bVl);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void abR() {
                    super.abR();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.azK());
                    if (!TextUtils.equals(eVar.id, e.azK())) {
                        a.this.Pc();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void abS() {
                    if (a.this.bVg != null && a.this.bVg.isShowing()) {
                        a.this.Pc();
                    }
                }
            };
            this.bVi.a(this.bVl);
        }
        f XX = this.bVi.XX();
        if (XX != null) {
            this.bVj = XX.ahm();
            if (this.bVj != null) {
                this.bVj.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void abS() {
                        a.this.Pc();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void Pc() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bVg != null) {
                    a.this.bVg.dismiss();
                    a.this.bVg = null;
                }
                if (a.this.bVk != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bVk);
                    a.this.bVk = null;
                }
                if (a.this.bVi != null && a.this.bVl != null) {
                    a.this.bVi.b(a.this.bVl);
                }
                if (a.this.bVj != null) {
                    a.this.bVj.a((c.b) null);
                }
            }
        });
    }

    public boolean iU(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
