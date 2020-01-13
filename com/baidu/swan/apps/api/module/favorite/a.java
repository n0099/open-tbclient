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
/* loaded from: classes10.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType aYQ;
    private static volatile a aYR;
    private PopupWindow aYS;
    private Timer aYT;
    private SwanAppActivity aYU;
    private ContentObserver aYV;
    private com.baidu.swan.apps.framework.a aYW;
    private b aYX;
    private InterfaceC0210a aYY;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0210a {
        void bS(boolean z);
    }

    private a() {
    }

    public static a Hq() {
        if (aYR == null) {
            synchronized (a.class) {
                if (aYR == null) {
                    aYR = new a();
                }
            }
        }
        return aYR;
    }

    @UiThread
    public void a(@Nullable InterfaceC0210a interfaceC0210a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e El;
        this.aYY = interfaceC0210a;
        yB();
        if (eVar.aaG()) {
            Hr();
            if (this.aYX != null) {
                this.aYX.hH(0);
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
                this.aYS = new PopupWindow(inflate, -2, -2);
                this.aYS.showAsDropDown(findViewById, 0, -af.S(3.0f));
                if (this.aYU != null && (El = this.aYU.El()) != null) {
                    final com.baidu.swan.apps.core.d.b LX = El.LX();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.aYS == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (LX != El.LX() || (!eVar.aaG() && af.isScreenLand())) {
                                a.this.yB();
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
                        a.this.yB();
                        if (a.this.aYY != null) {
                            a.this.aYY.bS(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.aYQ = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0188a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0188a
                        public void onSuccess() {
                            if (a.this.aYY != null) {
                                a.this.aYY.bS(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0188a
                        public void onFail() {
                            if (a.this.aYY != null) {
                                a.this.aYY.bS(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.yB();
                    if (a.this.aYT != null) {
                        a.this.aYT.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.aYS = new PopupWindow(inflate, -1, -2);
            this.aYS.setSoftInputMode(16);
            this.aYS.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.T(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.aYT != null) {
                this.aYT.cancel();
            }
            this.aYT = new Timer();
            this.aYT.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.yB();
                    if (a.this.aYY != null) {
                        a.this.aYY.bS(com.baidu.swan.apps.database.favorite.a.hn(eVar.id));
                    }
                    if (a.this.aYT != null) {
                        a.this.aYT.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void Hr() {
        if (this.aYX == null) {
            this.aYX = b.aoa();
            if (this.aYX != null) {
                this.aYX.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void dJ(int i) {
                        if (i == 1) {
                            a.this.yB();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void Hs() {
                        a.this.yB();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.aYV = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.aex().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.hn(eVar.id)) {
                            a.this.yB();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.OS(), false, this.aYV);
        if (activity instanceof SwanAppActivity) {
            this.aYU = (SwanAppActivity) activity;
            if (this.aYW != null) {
                this.aYU.b(this.aYW);
            }
            this.aYW = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Ht() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.yB();
                    if (a.this.aYU != null && a.this.aYW != null) {
                        a.this.aYU.b(a.this.aYW);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void onActivityResumed() {
                    super.onActivityResumed();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aar());
                    if (!TextUtils.equals(eVar.id, e.aar())) {
                        a.this.yB();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Hu() {
                    if (a.this.aYS != null && a.this.aYS.isShowing()) {
                        a.this.yB();
                    }
                }
            };
            this.aYU.a(this.aYW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void yB() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aYS != null) {
                    a.this.aYS.dismiss();
                    a.this.aYS = null;
                }
            }
        });
        if (this.aYV != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.aYV);
            this.aYV = null;
        }
        if (this.aYU != null && this.aYW != null) {
            this.aYU.b(this.aYW);
        }
    }
}
