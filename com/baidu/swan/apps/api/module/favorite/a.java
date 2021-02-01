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
/* loaded from: classes9.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType cFE;
    private static volatile a cFF;
    private PopupWindow cFG;
    private Timer cFH;
    private SwanAppActivity cFI;
    private c cFJ;
    private ContentObserver cFK;
    private com.baidu.swan.apps.framework.a cFL;
    private b cFM;
    private InterfaceC0375a cFN;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0375a {
        void eR(boolean z);
    }

    private a() {
    }

    public static a ajR() {
        if (cFF == null) {
            synchronized (a.class) {
                if (cFF == null) {
                    cFF = new a();
                }
            }
        }
        return cFF;
    }

    @UiThread
    public void a(@Nullable InterfaceC0375a interfaceC0375a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f afX;
        this.cFN = interfaceC0375a;
        UV();
        if (eVar.aJd()) {
            ajS();
            if (this.cFM != null) {
                this.cFM.ll(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.P(7.0f), 0);
                this.cFG = new PopupWindow(inflate, -2, -2);
                if (this.cFI != null && !this.cFI.isFinishing() && !this.cFI.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cFG.showAsDropDown(findViewById, 0, -ah.P(3.0f));
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
            int P = ah.P(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < P * 2) {
                i = displayWidth - (P * 2);
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
                        a.this.UV();
                        if (a.this.cFN != null) {
                            a.this.cFN.eR(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cFE = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0436a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0436a
                        public void onSuccess() {
                            if (a.this.cFN != null) {
                                a.this.cFN.eR(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0436a
                        public void onFail() {
                            if (a.this.cFN != null) {
                                a.this.cFN.eR(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.UV();
                    if (a.this.cFH != null) {
                        a.this.cFH.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cFG = new PopupWindow(inflate, -1, -2);
            this.cFG.setSoftInputMode(16);
            this.cFG.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.Q(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cFI != null && (afX = this.cFI.afX()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e apz = afX.apz();
            final String apg = apz == null ? "" : apz.apg();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cFG != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cFJ != afX.apx() || ((apz != null && !TextUtils.equals(apg, apz.apg())) || (!eVar.aJd() && ah.isScreenLand()))) {
                            a.this.UV();
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
            if (this.cFH != null) {
                this.cFH.cancel();
            }
            this.cFH = new Timer();
            this.cFH.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.UV();
                    if (a.this.cFN != null) {
                        a.this.cFN.eR(com.baidu.swan.apps.database.favorite.a.np(eVar.id));
                    }
                    if (a.this.cFH != null) {
                        a.this.cFH.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void ajS() {
        if (this.cFM == null) {
            this.cFM = b.aZk();
            if (this.cFM != null) {
                this.cFM.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void gh(int i) {
                        if (i == 1) {
                            a.this.UV();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ajT() {
                        a.this.UV();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cFK = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aNR().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.np(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cFN != null) {
                                a.this.cFN.eR(true);
                            }
                            a.this.UV();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.atj(), false, this.cFK);
        if (activity instanceof SwanAppActivity) {
            this.cFI = (SwanAppActivity) activity;
            if (this.cFL != null) {
                this.cFI.b(this.cFL);
            }
            this.cFL = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajU() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.UV();
                    if (a.this.cFI != null && a.this.cFL != null) {
                        a.this.cFI.b(a.this.cFL);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajV() {
                    super.ajV();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aIM());
                    if (!TextUtils.equals(eVar.id, e.aIM())) {
                        a.this.UV();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void ajW() {
                    if (a.this.cFG != null && a.this.cFG.isShowing()) {
                        a.this.UV();
                    }
                }
            };
            this.cFI.a(this.cFL);
        }
        f afX = this.cFI.afX();
        if (afX != null) {
            this.cFJ = afX.apx();
            if (this.cFJ != null) {
                this.cFJ.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void ajW() {
                        a.this.UV();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void UV() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cFG != null) {
                    a.this.cFG.dismiss();
                    a.this.cFG = null;
                }
                if (a.this.cFK != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cFK);
                    a.this.cFK = null;
                }
                if (a.this.cFI != null && a.this.cFL != null) {
                    a.this.cFI.b(a.this.cFL);
                }
                if (a.this.cFJ != null) {
                    a.this.cFJ.a((c.b) null);
                }
            }
        });
    }

    public boolean kj(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
