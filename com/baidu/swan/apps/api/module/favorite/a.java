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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.x.a;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType bPE;
    private static volatile a bPF;
    private PopupWindow bPG;
    private Timer bPH;
    private SwanAppActivity bPI;
    private c bPJ;
    private ContentObserver bPK;
    private com.baidu.swan.apps.framework.a bPL;
    private b bPM;
    private InterfaceC0310a bPN;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0310a {
        void ds(boolean z);
    }

    private a() {
    }

    public static a VH() {
        if (bPF == null) {
            synchronized (a.class) {
                if (bPF == null) {
                    bPF = new a();
                }
            }
        }
        return bPF;
    }

    @UiThread
    public void a(@Nullable InterfaceC0310a interfaceC0310a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f Sc;
        this.bPN = interfaceC0310a;
        Jk();
        if (eVar.arO()) {
            VI();
            if (this.bPM != null) {
                this.bPM.ja(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ai.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ai.D(7.0f), 0);
                this.bPG = new PopupWindow(inflate, -2, -2);
                if (this.bPI != null && !this.bPI.isFinishing() && !this.bPI.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.bPG.showAsDropDown(findViewById, 0, -ai.D(3.0f));
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
            int D = ai.D(7.0f);
            int displayWidth = ai.getDisplayWidth(null);
            if (displayWidth - i < D * 2) {
                i = displayWidth - (D * 2);
            }
            layoutParams.width = i;
            relativeLayout.setLayoutParams(layoutParams);
            al.a((ImageView) inflate.findViewById(a.f.favorite_guide_icon), str2, a.e.aiapps_default_grey_icon);
            ImageView imageView = (ImageView) inflate.findViewById(a.f.favorite_guide_close);
            if (guideType == ShowFavoriteGuideApi.GuideType.WEAK) {
                imageView.setVisibility(8);
            } else {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Jk();
                        if (a.this.bPN != null) {
                            a.this.bPN.ds(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.bPE = guideType;
                    com.baidu.swan.apps.x.a.a(activity, new a.InterfaceC0414a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.x.a.InterfaceC0414a
                        public void onSuccess() {
                            if (a.this.bPN != null) {
                                a.this.bPN.ds(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.x.a.InterfaceC0414a
                        public void onFail() {
                            if (a.this.bPN != null) {
                                a.this.bPN.ds(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Jk();
                    if (a.this.bPH != null) {
                        a.this.bPH.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.bPG = new PopupWindow(inflate, -1, -2);
            this.bPG.setSoftInputMode(16);
            this.bPG.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ai.E(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.bPI != null && (Sc = this.bPI.Sc()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e abb = Sc.abb();
            final String aaL = abb == null ? "" : abb.aaL();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.bPG != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.bPJ != Sc.aaZ() || ((abb != null && !TextUtils.equals(aaL, abb.aaL())) || (!eVar.arO() && ai.isScreenLand()))) {
                            a.this.Jk();
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
            if (this.bPH != null) {
                this.bPH.cancel();
            }
            this.bPH = new Timer();
            this.bPH.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Jk();
                    if (a.this.bPN != null) {
                        a.this.bPN.ds(com.baidu.swan.apps.database.favorite.a.ky(eVar.id));
                    }
                    if (a.this.bPH != null) {
                        a.this.bPH.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void VI() {
        if (this.bPM == null) {
            this.bPM = b.aHt();
            if (this.bPM != null) {
                this.bPM.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ey(int i) {
                        if (i == 1) {
                            a.this.Jk();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void VJ() {
                        a.this.Jk();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.bPK = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.awE().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.ky(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.bPN != null) {
                                a.this.bPN.ds(true);
                            }
                            a.this.Jk();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.ael(), false, this.bPK);
        if (activity instanceof SwanAppActivity) {
            this.bPI = (SwanAppActivity) activity;
            if (this.bPL != null) {
                this.bPI.b(this.bPL);
            }
            this.bPL = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void VK() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Jk();
                    if (a.this.bPI != null && a.this.bPL != null) {
                        a.this.bPI.b(a.this.bPL);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void VL() {
                    super.VL();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.arx());
                    if (!TextUtils.equals(eVar.id, e.arx())) {
                        a.this.Jk();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void VM() {
                    if (a.this.bPG != null && a.this.bPG.isShowing()) {
                        a.this.Jk();
                    }
                }
            };
            this.bPI.a(this.bPL);
        }
        f Sc = this.bPI.Sc();
        if (Sc != null) {
            this.bPJ = Sc.aaZ();
            if (this.bPJ != null) {
                this.bPJ.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void VM() {
                        a.this.Jk();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void Jk() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bPG != null) {
                    a.this.bPG.dismiss();
                    a.this.bPG = null;
                }
                if (a.this.bPK != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.bPK);
                    a.this.bPK = null;
                }
                if (a.this.bPI != null && a.this.bPL != null) {
                    a.this.bPI.b(a.this.bPL);
                }
                if (a.this.bPJ != null) {
                    a.this.bPJ.a((c.b) null);
                }
            }
        });
    }

    public boolean hx(String str) {
        return (TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL) && com.baidu.swan.apps.t.a.ahm().Tf();
    }
}
