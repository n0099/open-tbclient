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
/* loaded from: classes9.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType aXY;
    private static volatile a aXZ;
    private PopupWindow aYa;
    private Timer aYb;
    private SwanAppActivity aYc;
    private ContentObserver aYd;
    private com.baidu.swan.apps.framework.a aYe;
    private b aYf;
    private InterfaceC0208a aYg;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0208a {
        void bN(boolean z);
    }

    private a() {
    }

    public static a GU() {
        if (aXZ == null) {
            synchronized (a.class) {
                if (aXZ == null) {
                    aXZ = new a();
                }
            }
        }
        return aXZ;
    }

    @UiThread
    public void a(@Nullable InterfaceC0208a interfaceC0208a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e DP;
        this.aYg = interfaceC0208a;
        yl();
        if (eVar.aaj()) {
            GV();
            if (this.aYf != null) {
                this.aYf.hH(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((af.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - af.T(7.0f), 0);
                this.aYa = new PopupWindow(inflate, -2, -2);
                this.aYa.showAsDropDown(findViewById, 0, -af.T(3.0f));
                if (this.aYc != null && (DP = this.aYc.DP()) != null) {
                    final com.baidu.swan.apps.core.d.b LB = DP.LB();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.aYa == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (LB != DP.LB() || (!eVar.aaj() && af.isScreenLand())) {
                                a.this.yl();
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
            int T = af.T(7.0f);
            int displayWidth = af.getDisplayWidth(null);
            if (displayWidth - i < T * 2) {
                i = displayWidth - (T * 2);
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
                        a.this.yl();
                        if (a.this.aYg != null) {
                            a.this.aYg.bN(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.aXY = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0186a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0186a
                        public void onSuccess() {
                            if (a.this.aYg != null) {
                                a.this.aYg.bN(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0186a
                        public void onFail() {
                            if (a.this.aYg != null) {
                                a.this.aYg.bN(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.yl();
                    if (a.this.aYb != null) {
                        a.this.aYb.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.aYa = new PopupWindow(inflate, -1, -2);
            this.aYa.setSoftInputMode(16);
            this.aYa.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.U(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.aYb != null) {
                this.aYb.cancel();
            }
            this.aYb = new Timer();
            this.aYb.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.yl();
                    if (a.this.aYg != null) {
                        a.this.aYg.bN(com.baidu.swan.apps.database.favorite.a.hk(eVar.id));
                    }
                    if (a.this.aYb != null) {
                        a.this.aYb.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void GV() {
        if (this.aYf == null) {
            this.aYf = b.anH();
            if (this.aYf != null) {
                this.aYf.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void dI(int i) {
                        if (i == 1) {
                            a.this.yl();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void GW() {
                        a.this.yl();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.aYd = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.aee().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.hk(eVar.id)) {
                            a.this.yl();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.Ow(), false, this.aYd);
        if (activity instanceof SwanAppActivity) {
            this.aYc = (SwanAppActivity) activity;
            if (this.aYe != null) {
                this.aYc.b(this.aYe);
            }
            this.aYe = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void GX() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.yl();
                    if (a.this.aYc != null && a.this.aYe != null) {
                        a.this.aYc.b(a.this.aYe);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityResumed() {
                    super.onActivityResumed();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.ZU());
                    if (!TextUtils.equals(eVar.id, e.ZU())) {
                        a.this.yl();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void GY() {
                    if (a.this.aYa != null && a.this.aYa.isShowing()) {
                        a.this.yl();
                    }
                }
            };
            this.aYc.a(this.aYe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void yl() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aYa != null) {
                    a.this.aYa.dismiss();
                    a.this.aYa = null;
                }
            }
        });
        if (this.aYd != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.aYd);
            this.aYd = null;
        }
        if (this.aYc != null && this.aYe != null) {
            this.aYc.b(this.aYe);
        }
    }
}
