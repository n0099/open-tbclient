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
    public static ShowFavoriteGuideApi.GuideType cjy;
    private static volatile a cjz;
    private PopupWindow cjA;
    private Timer cjB;
    private SwanAppActivity cjC;
    private c cjD;
    private ContentObserver cjE;
    private com.baidu.swan.apps.framework.a cjF;
    private b cjG;
    private InterfaceC0367a cjH;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0367a {
        void dW(boolean z);
    }

    private a() {
    }

    public static a afi() {
        if (cjz == null) {
            synchronized (a.class) {
                if (cjz == null) {
                    cjz = new a();
                }
            }
        }
        return cjz;
    }

    @UiThread
    public void a(@Nullable InterfaceC0367a interfaceC0367a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f abs;
        this.cjH = interfaceC0367a;
        QK();
        if (eVar.aDt()) {
            afj();
            if (this.cjG != null) {
                this.cjG.lR(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.J(7.0f), 0);
                this.cjA = new PopupWindow(inflate, -2, -2);
                if (this.cjC != null && !this.cjC.isFinishing() && !this.cjC.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cjA.showAsDropDown(findViewById, 0, -ah.J(3.0f));
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
            int J = ah.J(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < J * 2) {
                i = displayWidth - (J * 2);
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
                        a.this.QK();
                        if (a.this.cjH != null) {
                            a.this.cjH.dW(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cjy = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0428a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0428a
                        public void onSuccess() {
                            if (a.this.cjH != null) {
                                a.this.cjH.dW(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0428a
                        public void onFail() {
                            if (a.this.cjH != null) {
                                a.this.cjH.dW(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.QK();
                    if (a.this.cjB != null) {
                        a.this.cjB.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cjA = new PopupWindow(inflate, -1, -2);
            this.cjA.setSoftInputMode(16);
            this.cjA.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.K(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cjC != null && (abs = this.cjC.abs()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e akJ = abs.akJ();
            final String akr = akJ == null ? "" : akJ.akr();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cjA != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cjD != abs.akH() || ((akJ != null && !TextUtils.equals(akr, akJ.akr())) || (!eVar.aDt() && ah.isScreenLand()))) {
                            a.this.QK();
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
            if (this.cjB != null) {
                this.cjB.cancel();
            }
            this.cjB = new Timer();
            this.cjB.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.QK();
                    if (a.this.cjH != null) {
                        a.this.cjH.dW(com.baidu.swan.apps.database.favorite.a.nh(eVar.id));
                    }
                    if (a.this.cjB != null) {
                        a.this.cjB.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void afj() {
        if (this.cjG == null) {
            this.cjG = b.aTG();
            if (this.cjG != null) {
                this.cjG.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void hc(int i) {
                        if (i == 1) {
                            a.this.QK();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void afk() {
                        a.this.QK();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cjE = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aIh().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.nh(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cjH != null) {
                                a.this.cjH.dW(true);
                            }
                            a.this.QK();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.aoq(), false, this.cjE);
        if (activity instanceof SwanAppActivity) {
            this.cjC = (SwanAppActivity) activity;
            if (this.cjF != null) {
                this.cjC.b(this.cjF);
            }
            this.cjF = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void afl() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.QK();
                    if (a.this.cjC != null && a.this.cjF != null) {
                        a.this.cjC.b(a.this.cjF);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void afm() {
                    super.afm();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aDc());
                    if (!TextUtils.equals(eVar.id, e.aDc())) {
                        a.this.QK();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void afn() {
                    if (a.this.cjA != null && a.this.cjA.isShowing()) {
                        a.this.QK();
                    }
                }
            };
            this.cjC.a(this.cjF);
        }
        f abs = this.cjC.abs();
        if (abs != null) {
            this.cjD = abs.akH();
            if (this.cjD != null) {
                this.cjD.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void afn() {
                        a.this.QK();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void QK() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cjA != null) {
                    a.this.cjA.dismiss();
                    a.this.cjA = null;
                }
                if (a.this.cjE != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cjE);
                    a.this.cjE = null;
                }
                if (a.this.cjC != null && a.this.cjF != null) {
                    a.this.cjC.b(a.this.cjF);
                }
                if (a.this.cjD != null) {
                    a.this.cjD.a((c.b) null);
                }
            }
        });
    }

    public boolean ka(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
