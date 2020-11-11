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
/* loaded from: classes10.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType cxW;
    private static volatile a cxX;
    private PopupWindow cxY;
    private Timer cxZ;
    private SwanAppActivity cya;
    private c cyb;
    private ContentObserver cyc;
    private com.baidu.swan.apps.framework.a cyd;
    private b cye;
    private InterfaceC0393a cyf;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0393a {
        void es(boolean z);
    }

    private a() {
    }

    public static a ajC() {
        if (cxX == null) {
            synchronized (a.class) {
                if (cxX == null) {
                    cxX = new a();
                }
            }
        }
        return cxX;
    }

    @UiThread
    public void a(@Nullable InterfaceC0393a interfaceC0393a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f afM;
        this.cyf = interfaceC0393a;
        Un();
        if (eVar.aHN()) {
            ajD();
            if (this.cye != null) {
                this.cye.mm(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.N(7.0f), 0);
                this.cxY = new PopupWindow(inflate, -2, -2);
                if (this.cya != null && !this.cya.isFinishing() && !this.cya.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cxY.showAsDropDown(findViewById, 0, -ah.N(3.0f));
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
            int N = ah.N(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < N * 2) {
                i = displayWidth - (N * 2);
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
                        a.this.Un();
                        if (a.this.cyf != null) {
                            a.this.cyf.es(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cxW = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0454a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0454a
                        public void onSuccess() {
                            if (a.this.cyf != null) {
                                a.this.cyf.es(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0454a
                        public void onFail() {
                            if (a.this.cyf != null) {
                                a.this.cyf.es(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Un();
                    if (a.this.cxZ != null) {
                        a.this.cxZ.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cxY = new PopupWindow(inflate, -1, -2);
            this.cxY.setSoftInputMode(16);
            this.cxY.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.O(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cya != null && (afM = this.cya.afM()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e apd = afM.apd();
            final String aoL = apd == null ? "" : apd.aoL();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cxY != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cyb != afM.apb() || ((apd != null && !TextUtils.equals(aoL, apd.aoL())) || (!eVar.aHN() && ah.isScreenLand()))) {
                            a.this.Un();
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
            if (this.cxZ != null) {
                this.cxZ.cancel();
            }
            this.cxZ = new Timer();
            this.cxZ.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Un();
                    if (a.this.cyf != null) {
                        a.this.cyf.es(com.baidu.swan.apps.database.favorite.a.nO(eVar.id));
                    }
                    if (a.this.cxZ != null) {
                        a.this.cxZ.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void ajD() {
        if (this.cye == null) {
            this.cye = b.aYa();
            if (this.cye != null) {
                this.cye.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void hx(int i) {
                        if (i == 1) {
                            a.this.Un();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ajE() {
                        a.this.Un();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cyc = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aMB().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.nO(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cyf != null) {
                                a.this.cyf.es(true);
                            }
                            a.this.Un();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.asM(), false, this.cyc);
        if (activity instanceof SwanAppActivity) {
            this.cya = (SwanAppActivity) activity;
            if (this.cyd != null) {
                this.cya.b(this.cyd);
            }
            this.cyd = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajF() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Un();
                    if (a.this.cya != null && a.this.cyd != null) {
                        a.this.cya.b(a.this.cyd);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajG() {
                    super.ajG();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aHw());
                    if (!TextUtils.equals(eVar.id, e.aHw())) {
                        a.this.Un();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajH() {
                    if (a.this.cxY != null && a.this.cxY.isShowing()) {
                        a.this.Un();
                    }
                }
            };
            this.cya.a(this.cyd);
        }
        f afM = this.cya.afM();
        if (afM != null) {
            this.cyb = afM.apb();
            if (this.cyb != null) {
                this.cyb.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void ajH() {
                        a.this.Un();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void Un() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cxY != null) {
                    a.this.cxY.dismiss();
                    a.this.cxY = null;
                }
                if (a.this.cyc != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cyc);
                    a.this.cyc = null;
                }
                if (a.this.cya != null && a.this.cyd != null) {
                    a.this.cya.b(a.this.cyd);
                }
                if (a.this.cyb != null) {
                    a.this.cyb.a((c.b) null);
                }
            }
        });
    }

    public boolean kI(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
