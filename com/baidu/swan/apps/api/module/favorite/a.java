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
    public static ShowFavoriteGuideApi.GuideType bJZ;
    private static volatile a bKa;
    private PopupWindow bKb;
    private Timer bKc;
    private SwanAppActivity bKd;
    private b bKe;
    private ContentObserver bKf;
    private com.baidu.swan.apps.framework.a bKg;
    private com.baidu.swan.games.view.b bKh;
    private InterfaceC0305a bKi;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0305a {
        void dk(boolean z);
    }

    private a() {
    }

    public static a TW() {
        if (bKa == null) {
            synchronized (a.class) {
                if (bKa == null) {
                    bKa = new a();
                }
            }
        }
        return bKa;
    }

    @UiThread
    public void a(@Nullable InterfaceC0305a interfaceC0305a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final com.baidu.swan.apps.core.d.e QH;
        this.bKi = interfaceC0305a;
        HR();
        if (eVar.aoY()) {
            TX();
            if (this.bKh != null) {
                this.bKh.iw(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ag.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ag.B(7.0f), 0);
                this.bKb = new PopupWindow(inflate, -2, -2);
                if (this.bKd != null && !this.bKd.isFinishing() && !this.bKd.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bKb.showAsDropDown(findViewById, 0, -ag.B(3.0f));
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
            int B = ag.B(7.0f);
            int displayWidth = ag.getDisplayWidth(null);
            if (displayWidth - i < B * 2) {
                i = displayWidth - (B * 2);
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
                        a.this.HR();
                        if (a.this.bKi != null) {
                            a.this.bKi.dk(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bJZ = guideType;
                    com.baidu.swan.apps.y.a.a(activity, new a.InterfaceC0403a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.y.a.InterfaceC0403a
                        public void onSuccess() {
                            if (a.this.bKi != null) {
                                a.this.bKi.dk(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.y.a.InterfaceC0403a
                        public void onFail() {
                            if (a.this.bKi != null) {
                                a.this.bKi.dk(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.HR();
                    if (a.this.bKc != null) {
                        a.this.bKc.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bKb = new PopupWindow(inflate, -1, -2);
            this.bKb.setSoftInputMode(16);
            this.bKb.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ag.C(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bKd != null && (QH = this.bKd.QH()) != null && findViewById != null) {
            final d YR = QH.YR();
            final String YB = YR == null ? "" : YR.YB();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bKb != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bKe != QH.YP() || ((YR != null && !TextUtils.equals(YB, YR.YB())) || (!eVar.aoY() && ag.isScreenLand()))) {
                            a.this.HR();
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
            if (this.bKc != null) {
                this.bKc.cancel();
            }
            this.bKc = new Timer();
            this.bKc.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.HR();
                    if (a.this.bKi != null) {
                        a.this.bKi.dk(com.baidu.swan.apps.database.favorite.a.jW(eVar.id));
                    }
                    if (a.this.bKc != null) {
                        a.this.bKc.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void TX() {
        if (this.bKh == null) {
            this.bKh = com.baidu.swan.games.view.b.aCx();
            if (this.bKh != null) {
                this.bKh.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ek(int i) {
                        if (i == 1) {
                            a.this.HR();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void TY() {
                        a.this.HR();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.bKf = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                n.atw().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.jW(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bKi != null) {
                                a.this.bKi.dk(true);
                            }
                            a.this.HR();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.aca(), false, this.bKf);
        if (activity instanceof SwanAppActivity) {
            this.bKd = (SwanAppActivity) activity;
            if (this.bKg != null) {
                this.bKd.b(this.bKg);
            }
            this.bKg = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void TZ() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.HR();
                    if (a.this.bKd != null && a.this.bKg != null) {
                        a.this.bKd.b(a.this.bKg);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Ua() {
                    super.Ua();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aoH());
                    if (!TextUtils.equals(eVar.id, e.aoH())) {
                        a.this.HR();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Ub() {
                    if (a.this.bKb != null && a.this.bKb.isShowing()) {
                        a.this.HR();
                    }
                }
            };
            this.bKd.a(this.bKg);
        }
        com.baidu.swan.apps.core.d.e QH = this.bKd.QH();
        if (QH != null) {
            this.bKe = QH.YP();
            if (this.bKe != null) {
                this.bKe.a(new b.InterfaceC0336b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.b.InterfaceC0336b
                    public void Ub() {
                        a.this.HR();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void HR() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bKb != null) {
                    a.this.bKb.dismiss();
                    a.this.bKb = null;
                }
                if (a.this.bKf != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bKf);
                    a.this.bKf = null;
                }
                if (a.this.bKd != null && a.this.bKg != null) {
                    a.this.bKd.b(a.this.bKg);
                }
                if (a.this.bKe != null) {
                    a.this.bKe.a((b.InterfaceC0336b) null);
                }
            }
        });
    }
}
