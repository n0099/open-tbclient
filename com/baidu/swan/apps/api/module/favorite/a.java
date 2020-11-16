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
/* loaded from: classes7.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType cwm;
    private static volatile a cwn;
    private PopupWindow cwo;
    private Timer cwp;
    private SwanAppActivity cwq;
    private c cwr;
    private ContentObserver cws;
    private com.baidu.swan.apps.framework.a cwt;
    private b cwu;
    private InterfaceC0391a cwv;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0391a {
        void ev(boolean z);
    }

    private a() {
    }

    public static a aiU() {
        if (cwn == null) {
            synchronized (a.class) {
                if (cwn == null) {
                    cwn = new a();
                }
            }
        }
        return cwn;
    }

    @UiThread
    public void a(@Nullable InterfaceC0391a interfaceC0391a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f afe;
        this.cwv = interfaceC0391a;
        TE();
        if (eVar.aHf()) {
            aiV();
            if (this.cwu != null) {
                this.cwu.mi(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.M(7.0f), 0);
                this.cwo = new PopupWindow(inflate, -2, -2);
                if (this.cwq != null && !this.cwq.isFinishing() && !this.cwq.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cwo.showAsDropDown(findViewById, 0, -ah.M(3.0f));
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
            int M = ah.M(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < M * 2) {
                i = displayWidth - (M * 2);
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
                        a.this.TE();
                        if (a.this.cwv != null) {
                            a.this.cwv.ev(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cwm = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0452a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0452a
                        public void onSuccess() {
                            if (a.this.cwv != null) {
                                a.this.cwv.ev(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0452a
                        public void onFail() {
                            if (a.this.cwv != null) {
                                a.this.cwv.ev(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.TE();
                    if (a.this.cwp != null) {
                        a.this.cwp.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cwo = new PopupWindow(inflate, -1, -2);
            this.cwo.setSoftInputMode(16);
            this.cwo.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.N(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cwq != null && (afe = this.cwq.afe()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e aov = afe.aov();
            final String aod = aov == null ? "" : aov.aod();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cwo != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cwr != afe.aot() || ((aov != null && !TextUtils.equals(aod, aov.aod())) || (!eVar.aHf() && ah.isScreenLand()))) {
                            a.this.TE();
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
            if (this.cwp != null) {
                this.cwp.cancel();
            }
            this.cwp = new Timer();
            this.cwp.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.TE();
                    if (a.this.cwv != null) {
                        a.this.cwv.ev(com.baidu.swan.apps.database.favorite.a.nI(eVar.id));
                    }
                    if (a.this.cwp != null) {
                        a.this.cwp.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void aiV() {
        if (this.cwu == null) {
            this.cwu = b.aXs();
            if (this.cwu != null) {
                this.cwu.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void ht(int i) {
                        if (i == 1) {
                            a.this.TE();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void aiW() {
                        a.this.TE();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cws = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aLT().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.nI(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cwv != null) {
                                a.this.cwv.ev(true);
                            }
                            a.this.TE();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.asd(), false, this.cws);
        if (activity instanceof SwanAppActivity) {
            this.cwq = (SwanAppActivity) activity;
            if (this.cwt != null) {
                this.cwq.b(this.cwt);
            }
            this.cwt = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void aiX() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.TE();
                    if (a.this.cwq != null && a.this.cwt != null) {
                        a.this.cwq.b(a.this.cwt);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void aiY() {
                    super.aiY();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aGO());
                    if (!TextUtils.equals(eVar.id, e.aGO())) {
                        a.this.TE();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void aiZ() {
                    if (a.this.cwo != null && a.this.cwo.isShowing()) {
                        a.this.TE();
                    }
                }
            };
            this.cwq.a(this.cwt);
        }
        f afe = this.cwq.afe();
        if (afe != null) {
            this.cwr = afe.aot();
            if (this.cwr != null) {
                this.cwr.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void aiZ() {
                        a.this.TE();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void TE() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cwo != null) {
                    a.this.cwo.dismiss();
                    a.this.cwo = null;
                }
                if (a.this.cws != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cws);
                    a.this.cws = null;
                }
                if (a.this.cwq != null && a.this.cwt != null) {
                    a.this.cwq.b(a.this.cwt);
                }
                if (a.this.cwr != null) {
                    a.this.cwr.a((c.b) null);
                }
            }
        });
    }

    public boolean kC(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
