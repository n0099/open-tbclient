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
/* loaded from: classes25.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType cDe;
    private static volatile a cDf;
    private PopupWindow cDg;
    private Timer cDh;
    private SwanAppActivity cDi;
    private c cDj;
    private ContentObserver cDk;
    private com.baidu.swan.apps.framework.a cDl;
    private b cDm;
    private InterfaceC0403a cDn;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0403a {
        void eK(boolean z);
    }

    private a() {
    }

    public static a amc() {
        if (cDf == null) {
            synchronized (a.class) {
                if (cDf == null) {
                    cDf = new a();
                }
            }
        }
        return cDf;
    }

    @UiThread
    public void a(@Nullable InterfaceC0403a interfaceC0403a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f aim;
        this.cDn = interfaceC0403a;
        We();
        if (eVar.aKn()) {
            amd();
            if (this.cDm != null) {
                this.cDm.mG(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.M(7.0f), 0);
                this.cDg = new PopupWindow(inflate, -2, -2);
                if (this.cDi != null && !this.cDi.isFinishing() && !this.cDi.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cDg.showAsDropDown(findViewById, 0, -ah.M(3.0f));
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
            int M = ah.M(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < M * 2) {
                i = displayWidth - (M * 2);
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
                        a.this.We();
                        if (a.this.cDn != null) {
                            a.this.cDn.eK(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cDe = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0464a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0464a
                        public void onSuccess() {
                            if (a.this.cDn != null) {
                                a.this.cDn.eK(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0464a
                        public void onFail() {
                            if (a.this.cDn != null) {
                                a.this.cDn.eK(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.We();
                    if (a.this.cDh != null) {
                        a.this.cDh.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cDg = new PopupWindow(inflate, -1, -2);
            this.cDg.setSoftInputMode(16);
            this.cDg.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.N(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cDi != null && (aim = this.cDi.aim()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e arD = aim.arD();
            final String arl = arD == null ? "" : arD.arl();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cDg != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cDj != aim.arB() || ((arD != null && !TextUtils.equals(arl, arD.arl())) || (!eVar.aKn() && ah.isScreenLand()))) {
                            a.this.We();
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
            if (this.cDh != null) {
                this.cDh.cancel();
            }
            this.cDh = new Timer();
            this.cDh.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.We();
                    if (a.this.cDn != null) {
                        a.this.cDn.eK(com.baidu.swan.apps.database.favorite.a.or(eVar.id));
                    }
                    if (a.this.cDh != null) {
                        a.this.cDh.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void amd() {
        if (this.cDm == null) {
            this.cDm = b.bax();
            if (this.cDm != null) {
                this.cDm.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void hR(int i) {
                        if (i == 1) {
                            a.this.We();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ame() {
                        a.this.We();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cDk = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aPa().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.or(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cDn != null) {
                                a.this.cDn.eK(true);
                            }
                            a.this.We();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.avm(), false, this.cDk);
        if (activity instanceof SwanAppActivity) {
            this.cDi = (SwanAppActivity) activity;
            if (this.cDl != null) {
                this.cDi.b(this.cDl);
            }
            this.cDl = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void amf() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.We();
                    if (a.this.cDi != null && a.this.cDl != null) {
                        a.this.cDi.b(a.this.cDl);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void amg() {
                    super.amg();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aJW());
                    if (!TextUtils.equals(eVar.id, e.aJW())) {
                        a.this.We();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void amh() {
                    if (a.this.cDg != null && a.this.cDg.isShowing()) {
                        a.this.We();
                    }
                }
            };
            this.cDi.a(this.cDl);
        }
        f aim = this.cDi.aim();
        if (aim != null) {
            this.cDj = aim.arB();
            if (this.cDj != null) {
                this.cDj.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void amh() {
                        a.this.We();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void We() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cDg != null) {
                    a.this.cDg.dismiss();
                    a.this.cDg = null;
                }
                if (a.this.cDk != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cDk);
                    a.this.cDk = null;
                }
                if (a.this.cDi != null && a.this.cDl != null) {
                    a.this.cDi.b(a.this.cDl);
                }
                if (a.this.cDj != null) {
                    a.this.cDj.a((c.b) null);
                }
            }
        });
    }

    public boolean lj(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
