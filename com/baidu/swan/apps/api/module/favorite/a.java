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
    public static ShowFavoriteGuideApi.GuideType bda;
    private static volatile a bdb;
    private PopupWindow bdc;
    private Timer bdd;
    private SwanAppActivity bde;
    private ContentObserver bdf;
    private com.baidu.swan.apps.framework.a bdg;
    private b bdh;
    private InterfaceC0220a bdi;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0220a {
        void ca(boolean z);
    }

    private a() {
    }

    public static a JF() {
        if (bdb == null) {
            synchronized (a.class) {
                if (bdb == null) {
                    bdb = new a();
                }
            }
        }
        return bdb;
    }

    @UiThread
    public void a(@Nullable InterfaceC0220a interfaceC0220a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e GA;
        this.bdi = interfaceC0220a;
        AS();
        if (eVar.acU()) {
            JG();
            if (this.bdh != null) {
                this.bdh.hY(0);
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
                this.bdc = new PopupWindow(inflate, -2, -2);
                this.bdc.showAsDropDown(findViewById, 0, -af.S(3.0f));
                if (this.bde != null && (GA = this.bde.GA()) != null) {
                    final com.baidu.swan.apps.core.d.b Ol = GA.Ol();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.bdc == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (Ol != GA.Ol() || (!eVar.acU() && af.isScreenLand())) {
                                a.this.AS();
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
                        a.this.AS();
                        if (a.this.bdi != null) {
                            a.this.bdi.ca(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bda = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0198a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onSuccess() {
                            if (a.this.bdi != null) {
                                a.this.bdi.ca(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onFail() {
                            if (a.this.bdi != null) {
                                a.this.bdi.ca(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.AS();
                    if (a.this.bdd != null) {
                        a.this.bdd.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bdc = new PopupWindow(inflate, -1, -2);
            this.bdc.setSoftInputMode(16);
            this.bdc.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.T(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bdd != null) {
                this.bdd.cancel();
            }
            this.bdd = new Timer();
            this.bdd.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.AS();
                    if (a.this.bdi != null) {
                        a.this.bdi.ca(com.baidu.swan.apps.database.favorite.a.hC(eVar.id));
                    }
                    if (a.this.bdd != null) {
                        a.this.bdd.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void JG() {
        if (this.bdh == null) {
            this.bdh = b.aqo();
            if (this.bdh != null) {
                this.bdh.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void dZ(int i) {
                        if (i == 1) {
                            a.this.AS();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void JH() {
                        a.this.AS();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.bdf = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.agL().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.hC(eVar.id)) {
                            a.this.AS();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.Rg(), false, this.bdf);
        if (activity instanceof SwanAppActivity) {
            this.bde = (SwanAppActivity) activity;
            if (this.bdg != null) {
                this.bde.b(this.bdg);
            }
            this.bdg = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JI() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.AS();
                    if (a.this.bde != null && a.this.bdg != null) {
                        a.this.bde.b(a.this.bdg);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityResumed() {
                    super.onActivityResumed();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.acF());
                    if (!TextUtils.equals(eVar.id, e.acF())) {
                        a.this.AS();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JJ() {
                    if (a.this.bdc != null && a.this.bdc.isShowing()) {
                        a.this.AS();
                    }
                }
            };
            this.bde.a(this.bdg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void AS() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdc != null) {
                    a.this.bdc.dismiss();
                    a.this.bdc = null;
                }
            }
        });
        if (this.bdf != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.bdf);
            this.bdf = null;
        }
        if (this.bde != null && this.bdg != null) {
            this.bde.b(this.bdg);
        }
    }
}
