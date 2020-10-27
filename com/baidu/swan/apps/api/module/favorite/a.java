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
    public static ShowFavoriteGuideApi.GuideType crZ;
    private static volatile a csa;
    private PopupWindow csb;
    private Timer csc;
    private SwanAppActivity csd;
    private c cse;
    private ContentObserver csf;
    private com.baidu.swan.apps.framework.a csg;
    private b csh;
    private InterfaceC0381a csi;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0381a {
        void ej(boolean z);
    }

    private a() {
    }

    public static a ahc() {
        if (csa == null) {
            synchronized (a.class) {
                if (csa == null) {
                    csa = new a();
                }
            }
        }
        return csa;
    }

    @UiThread
    public void a(@Nullable InterfaceC0381a interfaceC0381a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f adm;
        this.csi = interfaceC0381a;
        RF();
        if (eVar.aFn()) {
            ahd();
            if (this.csh != null) {
                this.csh.mc(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.L(7.0f), 0);
                this.csb = new PopupWindow(inflate, -2, -2);
                if (this.csd != null && !this.csd.isFinishing() && !this.csd.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.csb.showAsDropDown(findViewById, 0, -ah.L(3.0f));
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
            int L = ah.L(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < L * 2) {
                i = displayWidth - (L * 2);
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
                        a.this.RF();
                        if (a.this.csi != null) {
                            a.this.csi.ej(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.crZ = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0442a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0442a
                        public void onSuccess() {
                            if (a.this.csi != null) {
                                a.this.csi.ej(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0442a
                        public void onFail() {
                            if (a.this.csi != null) {
                                a.this.csi.ej(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.RF();
                    if (a.this.csc != null) {
                        a.this.csc.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.csb = new PopupWindow(inflate, -1, -2);
            this.csb.setSoftInputMode(16);
            this.csb.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.M(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.csd != null && (adm = this.csd.adm()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e amD = adm.amD();
            final String aml = amD == null ? "" : amD.aml();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.csb != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cse != adm.amB() || ((amD != null && !TextUtils.equals(aml, amD.aml())) || (!eVar.aFn() && ah.isScreenLand()))) {
                            a.this.RF();
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
            if (this.csc != null) {
                this.csc.cancel();
            }
            this.csc = new Timer();
            this.csc.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.RF();
                    if (a.this.csi != null) {
                        a.this.csi.ej(com.baidu.swan.apps.database.favorite.a.nA(eVar.id));
                    }
                    if (a.this.csc != null) {
                        a.this.csc.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void ahd() {
        if (this.csh == null) {
            this.csh = b.aVA();
            if (this.csh != null) {
                this.csh.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void hn(int i) {
                        if (i == 1) {
                            a.this.RF();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ahe() {
                        a.this.RF();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.csf = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aKb().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.nA(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.csi != null) {
                                a.this.csi.ej(true);
                            }
                            a.this.RF();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.aql(), false, this.csf);
        if (activity instanceof SwanAppActivity) {
            this.csd = (SwanAppActivity) activity;
            if (this.csg != null) {
                this.csd.b(this.csg);
            }
            this.csg = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ahf() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.RF();
                    if (a.this.csd != null && a.this.csg != null) {
                        a.this.csd.b(a.this.csg);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ahg() {
                    super.ahg();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aEW());
                    if (!TextUtils.equals(eVar.id, e.aEW())) {
                        a.this.RF();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ahh() {
                    if (a.this.csb != null && a.this.csb.isShowing()) {
                        a.this.RF();
                    }
                }
            };
            this.csd.a(this.csg);
        }
        f adm = this.csd.adm();
        if (adm != null) {
            this.cse = adm.amB();
            if (this.cse != null) {
                this.cse.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void ahh() {
                        a.this.RF();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void RF() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.csb != null) {
                    a.this.csb.dismiss();
                    a.this.csb = null;
                }
                if (a.this.csf != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.csf);
                    a.this.csf = null;
                }
                if (a.this.csd != null && a.this.csg != null) {
                    a.this.csd.b(a.this.csg);
                }
                if (a.this.cse != null) {
                    a.this.cse.a((c.b) null);
                }
            }
        });
    }

    public boolean kt(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
