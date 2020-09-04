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
    public static ShowFavoriteGuideApi.GuideType bVi;
    private static volatile a bVj;
    private PopupWindow bVk;
    private Timer bVl;
    private SwanAppActivity bVm;
    private c bVn;
    private ContentObserver bVo;
    private com.baidu.swan.apps.framework.a bVp;
    private b bVq;
    private InterfaceC0355a bVr;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0355a {
        void dC(boolean z);
    }

    private a() {
    }

    public static a abN() {
        if (bVj == null) {
            synchronized (a.class) {
                if (bVj == null) {
                    bVj = new a();
                }
            }
        }
        return bVj;
    }

    @UiThread
    public void a(@Nullable InterfaceC0355a interfaceC0355a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f XX;
        this.bVr = interfaceC0355a;
        Pc();
        if (eVar.aAb()) {
            abO();
            if (this.bVq != null) {
                this.bVq.lj(0);
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
                this.bVk = new PopupWindow(inflate, -2, -2);
                if (this.bVm != null && !this.bVm.isFinishing() && !this.bVm.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bVk.showAsDropDown(findViewById, 0, -ah.H(3.0f));
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
                        if (a.this.bVr != null) {
                            a.this.bVr.dC(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bVi = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0416a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0416a
                        public void onSuccess() {
                            if (a.this.bVr != null) {
                                a.this.bVr.dC(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0416a
                        public void onFail() {
                            if (a.this.bVr != null) {
                                a.this.bVr.dC(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Pc();
                    if (a.this.bVl != null) {
                        a.this.bVl.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bVk = new PopupWindow(inflate, -1, -2);
            this.bVk.setSoftInputMode(16);
            this.bVk.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.I(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bVm != null && (XX = this.bVm.XX()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e aho = XX.aho();
            final String agW = aho == null ? "" : aho.agW();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bVk != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bVn != XX.ahm() || ((aho != null && !TextUtils.equals(agW, aho.agW())) || (!eVar.aAb() && ah.isScreenLand()))) {
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
            if (this.bVl != null) {
                this.bVl.cancel();
            }
            this.bVl = new Timer();
            this.bVl.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Pc();
                    if (a.this.bVr != null) {
                        a.this.bVr.dC(com.baidu.swan.apps.database.favorite.a.mc(eVar.id));
                    }
                    if (a.this.bVl != null) {
                        a.this.bVl.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void abO() {
        if (this.bVq == null) {
            this.bVq = b.aQl();
            if (this.bVq != null) {
                this.bVq.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
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
        this.bVo = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aEO().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.mc(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bVr != null) {
                                a.this.bVr.dC(true);
                            }
                            a.this.Pc();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.akV(), false, this.bVo);
        if (activity instanceof SwanAppActivity) {
            this.bVm = (SwanAppActivity) activity;
            if (this.bVp != null) {
                this.bVm.b(this.bVp);
            }
            this.bVp = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void abQ() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Pc();
                    if (a.this.bVm != null && a.this.bVp != null) {
                        a.this.bVm.b(a.this.bVp);
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
                    if (a.this.bVk != null && a.this.bVk.isShowing()) {
                        a.this.Pc();
                    }
                }
            };
            this.bVm.a(this.bVp);
        }
        f XX = this.bVm.XX();
        if (XX != null) {
            this.bVn = XX.ahm();
            if (this.bVn != null) {
                this.bVn.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
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
                if (a.this.bVk != null) {
                    a.this.bVk.dismiss();
                    a.this.bVk = null;
                }
                if (a.this.bVo != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bVo);
                    a.this.bVo = null;
                }
                if (a.this.bVm != null && a.this.bVp != null) {
                    a.this.bVm.b(a.this.bVp);
                }
                if (a.this.bVn != null) {
                    a.this.bVn.a((c.b) null);
                }
            }
        });
    }

    public boolean iV(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
