package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aa.a;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType bdc;
    private static volatile a bdd;
    private PopupWindow bde;
    private Timer bdf;
    private SwanAppActivity bdg;
    private ContentObserver bdh;
    private com.baidu.swan.apps.framework.a bdi;
    private b bdj;
    private InterfaceC0220a bdk;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0220a {
        void ca(boolean z);
    }

    private a() {
    }

    public static a JH() {
        if (bdd == null) {
            synchronized (a.class) {
                if (bdd == null) {
                    bdd = new a();
                }
            }
        }
        return bdd;
    }

    @UiThread
    public void a(@Nullable InterfaceC0220a interfaceC0220a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e GC;
        this.bdk = interfaceC0220a;
        AU();
        if (eVar.acW()) {
            JI();
            if (this.bdj != null) {
                this.bdj.hY(0);
            }
        }
        a(activity, eVar);
        View inflate = LayoutInflater.from(activity).inflate(guideType == ShowFavoriteGuideApi.GuideType.TIPS ? a.g.aiapps_favorite_guide_tips : a.g.aiapps_favorite_guide_normal, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(a.f.favorite_guide_content);
        if (textView != null && str != null) {
            if (guideType.limit != -1 && str.length() > guideType.limit) {
                str = str.substring(0, guideType.limit - 1) + StringHelper.STRING_MORE;
            }
            textView.setText(str);
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS) {
            View findViewById = activity.findViewById(a.f.titlebar_right_menu_img);
            if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((af.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - af.S(7.0f), 0);
                this.bde = new PopupWindow(inflate, -2, -2);
                this.bde.showAsDropDown(findViewById, 0, -af.S(3.0f));
                if (this.bdg != null && (GC = this.bdg.GC()) != null) {
                    final com.baidu.swan.apps.core.d.b On = GC.On();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.bde == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (On != GC.On() || (!eVar.acW() && af.isScreenLand())) {
                                a.this.AU();
                                if (viewTreeObserver != null) {
                                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                                }
                            }
                        }
                    });
                }
            }
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(a.f.favorite_guide_container);
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            int i = guideType.showWidth4px;
            int S = af.S(7.0f);
            int displayWidth = af.getDisplayWidth(null);
            if (displayWidth - i < S * 2) {
                i = displayWidth - (S * 2);
            }
            layoutParams.width = i;
            relativeLayout.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_icon);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(a.e.aiapps_default_grey_icon);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.AU();
                        if (a.this.bdk != null) {
                            a.this.bdk.ca(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bdc = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0198a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onSuccess() {
                            if (a.this.bdk != null) {
                                a.this.bdk.ca(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onFail() {
                            if (a.this.bdk != null) {
                                a.this.bdk.ca(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.AU();
                    if (a.this.bdf != null) {
                        a.this.bdf.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bde = new PopupWindow(inflate, -1, -2);
            this.bde.setSoftInputMode(16);
            this.bde.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.T(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bdf != null) {
                this.bdf.cancel();
            }
            this.bdf = new Timer();
            this.bdf.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.AU();
                    if (a.this.bdk != null) {
                        a.this.bdk.ca(com.baidu.swan.apps.database.favorite.a.hC(eVar.id));
                    }
                    if (a.this.bdf != null) {
                        a.this.bdf.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void JI() {
        if (this.bdj == null) {
            this.bdj = b.aqq();
            if (this.bdj != null) {
                this.bdj.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void dZ(int i) {
                        if (i == 1) {
                            a.this.AU();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void JJ() {
                        a.this.AU();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.bdh = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.agN().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.hC(eVar.id)) {
                            a.this.AU();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.Ri(), false, this.bdh);
        if (activity instanceof SwanAppActivity) {
            this.bdg = (SwanAppActivity) activity;
            if (this.bdi != null) {
                this.bdg.b(this.bdi);
            }
            this.bdi = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JK() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.AU();
                    if (a.this.bdg != null && a.this.bdi != null) {
                        a.this.bdg.b(a.this.bdi);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityResumed() {
                    super.onActivityResumed();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.acH());
                    if (!TextUtils.equals(eVar.id, e.acH())) {
                        a.this.AU();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JL() {
                    if (a.this.bde != null && a.this.bde.isShowing()) {
                        a.this.AU();
                    }
                }
            };
            this.bdg.a(this.bdi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void AU() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bde != null) {
                    a.this.bde.dismiss();
                    a.this.bde = null;
                }
            }
        });
        if (this.bdh != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.bdh);
            this.bdh = null;
        }
        if (this.bdg != null && this.bdi != null) {
            this.bdg.b(this.bdi);
        }
    }
}
