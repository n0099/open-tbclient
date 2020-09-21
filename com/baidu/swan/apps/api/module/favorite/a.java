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
/* loaded from: classes3.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType bXj;
    private static volatile a bXk;
    private PopupWindow bXl;
    private Timer bXm;
    private SwanAppActivity bXn;
    private c bXo;
    private ContentObserver bXp;
    private com.baidu.swan.apps.framework.a bXq;
    private b bXr;
    private InterfaceC0350a bXs;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0350a {
        void dA(boolean z);
    }

    private a() {
    }

    public static a acw() {
        if (bXk == null) {
            synchronized (a.class) {
                if (bXk == null) {
                    bXk = new a();
                }
            }
        }
        return bXk;
    }

    @UiThread
    public void a(@Nullable InterfaceC0350a interfaceC0350a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f YG;
        this.bXs = interfaceC0350a;
        PF();
        if (eVar.aAK()) {
            acx();
            if (this.bXr != null) {
                this.bXr.lu(0);
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
                this.bXl = new PopupWindow(inflate, -2, -2);
                if (this.bXn != null && !this.bXn.isFinishing() && !this.bXn.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bXl.showAsDropDown(findViewById, 0, -ah.H(3.0f));
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
                        a.this.PF();
                        if (a.this.bXs != null) {
                            a.this.bXs.dA(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bXj = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0411a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0411a
                        public void onSuccess() {
                            if (a.this.bXs != null) {
                                a.this.bXs.dA(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0411a
                        public void onFail() {
                            if (a.this.bXs != null) {
                                a.this.bXs.dA(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.PF();
                    if (a.this.bXm != null) {
                        a.this.bXm.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bXl = new PopupWindow(inflate, -1, -2);
            this.bXl.setSoftInputMode(16);
            this.bXl.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.I(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bXn != null && (YG = this.bXn.YG()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e ahY = YG.ahY();
            final String ahG = ahY == null ? "" : ahY.ahG();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bXl != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bXo != YG.ahW() || ((ahY != null && !TextUtils.equals(ahG, ahY.ahG())) || (!eVar.aAK() && ah.isScreenLand()))) {
                            a.this.PF();
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
            if (this.bXm != null) {
                this.bXm.cancel();
            }
            this.bXm = new Timer();
            this.bXm.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.PF();
                    if (a.this.bXs != null) {
                        a.this.bXs.dA(com.baidu.swan.apps.database.favorite.a.mv(eVar.id));
                    }
                    if (a.this.bXm != null) {
                        a.this.bXm.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void acx() {
        if (this.bXr == null) {
            this.bXr = b.aQX();
            if (this.bXr != null) {
                this.bXr.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void gF(int i) {
                        if (i == 1) {
                            a.this.PF();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void acy() {
                        a.this.PF();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.bXp = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aFy().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.mv(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bXs != null) {
                                a.this.bXs.dA(true);
                            }
                            a.this.PF();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.alF(), false, this.bXp);
        if (activity instanceof SwanAppActivity) {
            this.bXn = (SwanAppActivity) activity;
            if (this.bXq != null) {
                this.bXn.b(this.bXq);
            }
            this.bXq = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void acz() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.PF();
                    if (a.this.bXn != null && a.this.bXq != null) {
                        a.this.bXn.b(a.this.bXq);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void acA() {
                    super.acA();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aAt());
                    if (!TextUtils.equals(eVar.id, e.aAt())) {
                        a.this.PF();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void acB() {
                    if (a.this.bXl != null && a.this.bXl.isShowing()) {
                        a.this.PF();
                    }
                }
            };
            this.bXn.a(this.bXq);
        }
        f YG = this.bXn.YG();
        if (YG != null) {
            this.bXo = YG.ahW();
            if (this.bXo != null) {
                this.bXo.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void acB() {
                        a.this.PF();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void PF() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bXl != null) {
                    a.this.bXl.dismiss();
                    a.this.bXl = null;
                }
                if (a.this.bXp != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bXp);
                    a.this.bXp = null;
                }
                if (a.this.bXn != null && a.this.bXq != null) {
                    a.this.bXn.b(a.this.bXq);
                }
                if (a.this.bXo != null) {
                    a.this.bXo.a((c.b) null);
                }
            }
        });
    }

    public boolean jo(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
