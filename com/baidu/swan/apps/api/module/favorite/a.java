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
    public static ShowFavoriteGuideApi.GuideType bBD;
    private static volatile a bBE;
    private PopupWindow bBF;
    private Timer bBG;
    private SwanAppActivity bBH;
    private ContentObserver bBI;
    private com.baidu.swan.apps.framework.a bBJ;
    private b bBK;
    private InterfaceC0250a bBL;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0250a {
        void cX(boolean z);
    }

    private a() {
    }

    public static a Rw() {
        if (bBE == null) {
            synchronized (a.class) {
                if (bBE == null) {
                    bBE = new a();
                }
            }
        }
        return bBE;
    }

    @UiThread
    public void a(@Nullable InterfaceC0250a interfaceC0250a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e Ou;
        this.bBL = interfaceC0250a;
        FZ();
        if (eVar.ale()) {
            Rx();
            if (this.bBK != null) {
                this.bBK.m28if(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((af.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - af.C(7.0f), 0);
                this.bBF = new PopupWindow(inflate, -2, -2);
                this.bBF.showAsDropDown(findViewById, 0, -af.C(3.0f));
                if (this.bBH != null && (Ou = this.bBH.Ou()) != null) {
                    final com.baidu.swan.apps.core.d.b We = Ou.We();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.bBF == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (We != Ou.We() || (!eVar.ale() && af.isScreenLand())) {
                                a.this.FZ();
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
            int C = af.C(7.0f);
            int displayWidth = af.getDisplayWidth(null);
            if (displayWidth - i < C * 2) {
                i = displayWidth - (C * 2);
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
                        a.this.FZ();
                        if (a.this.bBL != null) {
                            a.this.bBL.cX(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bBD = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0228a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0228a
                        public void onSuccess() {
                            if (a.this.bBL != null) {
                                a.this.bBL.cX(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0228a
                        public void onFail() {
                            if (a.this.bBL != null) {
                                a.this.bBL.cX(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.FZ();
                    if (a.this.bBG != null) {
                        a.this.bBG.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bBF = new PopupWindow(inflate, -1, -2);
            this.bBF.setSoftInputMode(16);
            this.bBF.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.D(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bBG != null) {
                this.bBG.cancel();
            }
            this.bBG = new Timer();
            this.bBG.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.FZ();
                    if (a.this.bBL != null) {
                        a.this.bBL.cX(com.baidu.swan.apps.database.favorite.a.iP(eVar.id));
                    }
                    if (a.this.bBG != null) {
                        a.this.bBG.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void Rx() {
        if (this.bBK == null) {
            this.bBK = b.ayF();
            if (this.bBK != null) {
                this.bBK.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ee(int i) {
                        if (i == 1) {
                            a.this.FZ();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void Ry() {
                        a.this.FZ();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.bBI = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.aoW().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.iP(eVar.id)) {
                            a.this.FZ();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.Za(), false, this.bBI);
        if (activity instanceof SwanAppActivity) {
            this.bBH = (SwanAppActivity) activity;
            if (this.bBJ != null) {
                this.bBH.b(this.bBJ);
            }
            this.bBJ = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Rz() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.FZ();
                    if (a.this.bBH != null && a.this.bBJ != null) {
                        a.this.bBH.b(a.this.bBJ);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void RA() {
                    super.RA();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.akP());
                    if (!TextUtils.equals(eVar.id, e.akP())) {
                        a.this.FZ();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void RB() {
                    if (a.this.bBF != null && a.this.bBF.isShowing()) {
                        a.this.FZ();
                    }
                }
            };
            this.bBH.a(this.bBJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void FZ() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bBF != null) {
                    a.this.bBF.dismiss();
                    a.this.bBF = null;
                }
            }
        });
        if (this.bBI != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.bBI);
            this.bBI = null;
        }
        if (this.bBH != null && this.bBJ != null) {
            this.bBH.b(this.bBJ);
        }
    }
}
