package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.database.ContentObserver;
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
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
    public static ShowFavoriteGuideApi.GuideType cHe;
    private static volatile a cHf;
    private PopupWindow cHg;
    private Timer cHh;
    private SwanAppActivity cHi;
    private c cHj;
    private ContentObserver cHk;
    private com.baidu.swan.apps.framework.a cHl;
    private b cHm;
    private InterfaceC0381a cHn;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0381a {
        void eR(boolean z);
    }

    private a() {
    }

    public static a ajU() {
        if (cHf == null) {
            synchronized (a.class) {
                if (cHf == null) {
                    cHf = new a();
                }
            }
        }
        return cHf;
    }

    @UiThread
    public void a(@Nullable InterfaceC0381a interfaceC0381a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f aga;
        this.cHn = interfaceC0381a;
        UY();
        if (eVar.aJg()) {
            ajV();
            if (this.cHm != null) {
                this.cHm.lm(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.T(7.0f), 0);
                this.cHg = new PopupWindow(inflate, -2, -2);
                if (this.cHi != null && !this.cHi.isFinishing() && !this.cHi.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cHg.showAsDropDown(findViewById, 0, -ah.T(3.0f));
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
            int T = ah.T(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < T * 2) {
                i = displayWidth - (T * 2);
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
                        a.this.UY();
                        if (a.this.cHn != null) {
                            a.this.cHn.eR(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cHe = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0442a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0442a
                        public void onSuccess() {
                            if (a.this.cHn != null) {
                                a.this.cHn.eR(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0442a
                        public void onFail() {
                            if (a.this.cHn != null) {
                                a.this.cHn.eR(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.UY();
                    if (a.this.cHh != null) {
                        a.this.cHh.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cHg = new PopupWindow(inflate, -1, -2);
            this.cHg.setSoftInputMode(16);
            this.cHg.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.U(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cHi != null && (aga = this.cHi.aga()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e apC = aga.apC();
            final String apk = apC == null ? "" : apC.apk();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cHg != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cHj != aga.apA() || ((apC != null && !TextUtils.equals(apk, apC.apk())) || (!eVar.aJg() && ah.isScreenLand()))) {
                            a.this.UY();
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
            if (this.cHh != null) {
                this.cHh.cancel();
            }
            this.cHh = new Timer();
            this.cHh.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.UY();
                    if (a.this.cHn != null) {
                        a.this.cHn.eR(com.baidu.swan.apps.database.favorite.a.nw(eVar.id));
                    }
                    if (a.this.cHh != null) {
                        a.this.cHh.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void ajV() {
        if (this.cHm == null) {
            this.cHm = b.aZn();
            if (this.cHm != null) {
                this.cHm.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void gi(int i) {
                        if (i == 1) {
                            a.this.UY();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ajW() {
                        a.this.UY();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cHk = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aNU().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.nw(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cHn != null) {
                                a.this.cHn.eR(true);
                            }
                            a.this.UY();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.atm(), false, this.cHk);
        if (activity instanceof SwanAppActivity) {
            this.cHi = (SwanAppActivity) activity;
            if (this.cHl != null) {
                this.cHi.b(this.cHl);
            }
            this.cHl = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajX() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.UY();
                    if (a.this.cHi != null && a.this.cHl != null) {
                        a.this.cHi.b(a.this.cHl);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajY() {
                    super.ajY();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aIP());
                    if (!TextUtils.equals(eVar.id, e.aIP())) {
                        a.this.UY();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajZ() {
                    if (a.this.cHg != null && a.this.cHg.isShowing()) {
                        a.this.UY();
                    }
                }
            };
            this.cHi.a(this.cHl);
        }
        f aga = this.cHi.aga();
        if (aga != null) {
            this.cHj = aga.apA();
            if (this.cHj != null) {
                this.cHj.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void ajZ() {
                        a.this.UY();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void UY() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cHg != null) {
                    a.this.cHg.dismiss();
                    a.this.cHg = null;
                }
                if (a.this.cHk != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cHk);
                    a.this.cHk = null;
                }
                if (a.this.cHi != null && a.this.cHl != null) {
                    a.this.cHi.b(a.this.cHl);
                }
                if (a.this.cHj != null) {
                    a.this.cHj.a((c.b) null);
                }
            }
        });
    }

    public boolean kq(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
