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
    public static ShowFavoriteGuideApi.GuideType cDi;
    private static volatile a cDj;
    private PopupWindow cDk;
    private Timer cDl;
    private SwanAppActivity cDm;
    private c cDn;
    private ContentObserver cDo;
    private com.baidu.swan.apps.framework.a cDp;
    private b cDq;
    private InterfaceC0378a cDr;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0378a {
        void eP(boolean z);
    }

    private a() {
    }

    public static a ajt() {
        if (cDj == null) {
            synchronized (a.class) {
                if (cDj == null) {
                    cDj = new a();
                }
            }
        }
        return cDj;
    }

    @UiThread
    public void a(@Nullable InterfaceC0378a interfaceC0378a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f afz;
        this.cDr = interfaceC0378a;
        To();
        if (eVar.aIK()) {
            aju();
            if (this.cDq != null) {
                this.cDq.li(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.O(7.0f), 0);
                this.cDk = new PopupWindow(inflate, -2, -2);
                if (this.cDm != null && !this.cDm.isFinishing() && !this.cDm.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cDk.showAsDropDown(findViewById, 0, -ah.O(3.0f));
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
            int O = ah.O(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < O * 2) {
                i = displayWidth - (O * 2);
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
                        a.this.To();
                        if (a.this.cDr != null) {
                            a.this.cDr.eP(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cDi = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0439a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0439a
                        public void onSuccess() {
                            if (a.this.cDr != null) {
                                a.this.cDr.eP(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0439a
                        public void onFail() {
                            if (a.this.cDr != null) {
                                a.this.cDr.eP(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.To();
                    if (a.this.cDl != null) {
                        a.this.cDl.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cDk = new PopupWindow(inflate, -1, -2);
            this.cDk.setSoftInputMode(16);
            this.cDk.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.P(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cDm != null && (afz = this.cDm.afz()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e apa = afz.apa();
            final String aoI = apa == null ? "" : apa.aoI();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cDk != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cDn != afz.aoY() || ((apa != null && !TextUtils.equals(aoI, apa.aoI())) || (!eVar.aIK() && ah.isScreenLand()))) {
                            a.this.To();
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
            if (this.cDl != null) {
                this.cDl.cancel();
            }
            this.cDl = new Timer();
            this.cDl.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.To();
                    if (a.this.cDr != null) {
                        a.this.cDr.eP(com.baidu.swan.apps.database.favorite.a.mX(eVar.id));
                    }
                    if (a.this.cDl != null) {
                        a.this.cDl.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void aju() {
        if (this.cDq == null) {
            this.cDq = b.aYY();
            if (this.cDq != null) {
                this.cDq.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ge(int i) {
                        if (i == 1) {
                            a.this.To();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ajv() {
                        a.this.To();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cDo = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aNy().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.mX(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cDr != null) {
                                a.this.cDr.eP(true);
                            }
                            a.this.To();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.asL(), false, this.cDo);
        if (activity instanceof SwanAppActivity) {
            this.cDm = (SwanAppActivity) activity;
            if (this.cDp != null) {
                this.cDm.b(this.cDp);
            }
            this.cDp = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajw() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.To();
                    if (a.this.cDm != null && a.this.cDp != null) {
                        a.this.cDm.b(a.this.cDp);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajx() {
                    super.ajx();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aIt());
                    if (!TextUtils.equals(eVar.id, e.aIt())) {
                        a.this.To();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajy() {
                    if (a.this.cDk != null && a.this.cDk.isShowing()) {
                        a.this.To();
                    }
                }
            };
            this.cDm.a(this.cDp);
        }
        f afz = this.cDm.afz();
        if (afz != null) {
            this.cDn = afz.aoY();
            if (this.cDn != null) {
                this.cDn.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void ajy() {
                        a.this.To();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void To() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cDk != null) {
                    a.this.cDk.dismiss();
                    a.this.cDk = null;
                }
                if (a.this.cDo != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cDo);
                    a.this.cDo = null;
                }
                if (a.this.cDm != null && a.this.cDp != null) {
                    a.this.cDm.b(a.this.cDp);
                }
                if (a.this.cDn != null) {
                    a.this.cDn.a((c.b) null);
                }
            }
        });
    }

    public boolean jR(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
