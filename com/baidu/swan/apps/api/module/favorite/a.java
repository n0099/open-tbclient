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
    public static ShowFavoriteGuideApi.GuideType bdp;
    private static volatile a bdq;
    private PopupWindow bdr;
    private Timer bds;
    private SwanAppActivity bdt;
    private ContentObserver bdu;
    private com.baidu.swan.apps.framework.a bdv;
    private b bdw;
    private InterfaceC0220a bdx;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0220a {
        void cb(boolean z);
    }

    private a() {
    }

    public static a JK() {
        if (bdq == null) {
            synchronized (a.class) {
                if (bdq == null) {
                    bdq = new a();
                }
            }
        }
        return bdq;
    }

    @UiThread
    public void a(@Nullable InterfaceC0220a interfaceC0220a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e GH;
        this.bdx = interfaceC0220a;
        Bb();
        if (eVar.acZ()) {
            JL();
            if (this.bdw != null) {
                this.bdw.hY(0);
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
                this.bdr = new PopupWindow(inflate, -2, -2);
                this.bdr.showAsDropDown(findViewById, 0, -af.S(3.0f));
                if (this.bdt != null && (GH = this.bdt.GH()) != null) {
                    final com.baidu.swan.apps.core.d.b Oq = GH.Oq();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.bdr == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (Oq != GH.Oq() || (!eVar.acZ() && af.isScreenLand())) {
                                a.this.Bb();
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
                        a.this.Bb();
                        if (a.this.bdx != null) {
                            a.this.bdx.cb(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bdp = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0198a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onSuccess() {
                            if (a.this.bdx != null) {
                                a.this.bdx.cb(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0198a
                        public void onFail() {
                            if (a.this.bdx != null) {
                                a.this.bdx.cb(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Bb();
                    if (a.this.bds != null) {
                        a.this.bds.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bdr = new PopupWindow(inflate, -1, -2);
            this.bdr.setSoftInputMode(16);
            this.bdr.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.T(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bds != null) {
                this.bds.cancel();
            }
            this.bds = new Timer();
            this.bds.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Bb();
                    if (a.this.bdx != null) {
                        a.this.bdx.cb(com.baidu.swan.apps.database.favorite.a.hB(eVar.id));
                    }
                    if (a.this.bds != null) {
                        a.this.bds.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void JL() {
        if (this.bdw == null) {
            this.bdw = b.aqt();
            if (this.bdw != null) {
                this.bdw.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void dZ(int i) {
                        if (i == 1) {
                            a.this.Bb();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void JM() {
                        a.this.Bb();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.bdu = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.agQ().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.hB(eVar.id)) {
                            a.this.Bb();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.Rl(), false, this.bdu);
        if (activity instanceof SwanAppActivity) {
            this.bdt = (SwanAppActivity) activity;
            if (this.bdv != null) {
                this.bdt.b(this.bdv);
            }
            this.bdv = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JN() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Bb();
                    if (a.this.bdt != null && a.this.bdv != null) {
                        a.this.bdt.b(a.this.bdv);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityResumed() {
                    super.onActivityResumed();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.acK());
                    if (!TextUtils.equals(eVar.id, e.acK())) {
                        a.this.Bb();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void JO() {
                    if (a.this.bdr != null && a.this.bdr.isShowing()) {
                        a.this.Bb();
                    }
                }
            };
            this.bdt.a(this.bdv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void Bb() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdr != null) {
                    a.this.bdr.dismiss();
                    a.this.bdr = null;
                }
            }
        });
        if (this.bdu != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.bdu);
            this.bdu = null;
        }
        if (this.bdt != null && this.bdv != null) {
            this.bdt.b(this.bdv);
        }
    }
}
