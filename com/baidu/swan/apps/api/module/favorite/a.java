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
    public static ShowFavoriteGuideApi.GuideType bBI;
    private static volatile a bBJ;
    private PopupWindow bBK;
    private Timer bBL;
    private SwanAppActivity bBM;
    private ContentObserver bBN;
    private com.baidu.swan.apps.framework.a bBO;
    private b bBP;
    private InterfaceC0271a bBQ;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0271a {
        void cX(boolean z);
    }

    private a() {
    }

    public static a Rv() {
        if (bBJ == null) {
            synchronized (a.class) {
                if (bBJ == null) {
                    bBJ = new a();
                }
            }
        }
        return bBJ;
    }

    @UiThread
    public void a(@Nullable InterfaceC0271a interfaceC0271a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable Bitmap bitmap, long j) {
        final com.baidu.swan.apps.core.d.e Ot;
        this.bBQ = interfaceC0271a;
        FY();
        if (eVar.ald()) {
            Rw();
            if (this.bBP != null) {
                this.bBP.m28if(0);
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
                this.bBK = new PopupWindow(inflate, -2, -2);
                this.bBK.showAsDropDown(findViewById, 0, -af.C(3.0f));
                if (this.bBM != null && (Ot = this.bBM.Ot()) != null) {
                    final com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            if (a.this.bBK == null && viewTreeObserver != null) {
                                viewTreeObserver.removeOnGlobalLayoutListener(this);
                            } else if (Wd != Ot.Wd() || (!eVar.ald() && af.isScreenLand())) {
                                a.this.FY();
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
                        a.this.FY();
                        if (a.this.bBQ != null) {
                            a.this.bBQ.cX(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bBI = guideType;
                    com.baidu.swan.apps.aa.a.a(activity, new a.InterfaceC0249a() { // from class: com.baidu.swan.apps.api.module.favorite.a.3.1
                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0249a
                        public void onSuccess() {
                            if (a.this.bBQ != null) {
                                a.this.bBQ.cX(true);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.aa.a.InterfaceC0249a
                        public void onFail() {
                            if (a.this.bBQ != null) {
                                a.this.bBQ.cX(false);
                            }
                            c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.FY();
                    if (a.this.bBL != null) {
                        a.this.bBL.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bBK = new PopupWindow(inflate, -1, -2);
            this.bBK.setSoftInputMode(16);
            this.bBK.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) af.D(50.0f));
        }
        if (guideType == ShowFavoriteGuideApi.GuideType.TIPS || guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
            if (this.bBL != null) {
                this.bBL.cancel();
            }
            this.bBL = new Timer();
            this.bBL.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.FY();
                    if (a.this.bBQ != null) {
                        a.this.bBQ.cX(com.baidu.swan.apps.database.favorite.a.iP(eVar.id));
                    }
                    if (a.this.bBL != null) {
                        a.this.bBL.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void Rw() {
        if (this.bBP == null) {
            this.bBP = b.ayF();
            if (this.bBP != null) {
                this.bBP.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ee(int i) {
                        if (i == 1) {
                            a.this.FY();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void Rx() {
                        a.this.FY();
                    }
                });
            }
        }
    }

    private void a(@NonNull Activity activity, @NonNull final e eVar) {
        this.bBN = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                m.aoV().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.iP(eVar.id)) {
                            a.this.FY();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.YZ(), false, this.bBN);
        if (activity instanceof SwanAppActivity) {
            this.bBM = (SwanAppActivity) activity;
            if (this.bBO != null) {
                this.bBM.b(this.bBO);
            }
            this.bBO = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Ry() {
                    c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.FY();
                    if (a.this.bBM != null && a.this.bBO != null) {
                        a.this.bBM.b(a.this.bBO);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void Rz() {
                    super.Rz();
                    c.d("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.akO());
                    if (!TextUtils.equals(eVar.id, e.akO())) {
                        a.this.FY();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void RA() {
                    if (a.this.bBK != null && a.this.bBK.isShowing()) {
                        a.this.FY();
                    }
                }
            };
            this.bBM.a(this.bBO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void FY() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bBK != null) {
                    a.this.bBK.dismiss();
                    a.this.bBK = null;
                }
            }
        });
        if (this.bBN != null) {
            AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(this.bBN);
            this.bBN = null;
        }
        if (this.bBM != null && this.bBO != null) {
            this.bBM.b(this.bBO);
        }
    }
}
