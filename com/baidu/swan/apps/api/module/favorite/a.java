package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.database.ContentObserver;
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
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.menu.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.b;
import com.baidu.swan.menu.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class a {
    public static ShowFavoriteGuideApi.GuideType cHU;
    private static volatile a cHV;
    private PopupWindow cHW;
    private Timer cHX;
    private SwanAppActivity cHY;
    private c cHZ;
    private ContentObserver cIa;
    private com.baidu.swan.apps.framework.a cIb;
    private b cIc;
    private InterfaceC0395a cId;

    /* renamed from: com.baidu.swan.apps.api.module.favorite.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0395a {
        void eT(boolean z);
    }

    private a() {
    }

    public static a anm() {
        if (cHV == null) {
            synchronized (a.class) {
                if (cHV == null) {
                    cHV = new a();
                }
            }
        }
        return cHV;
    }

    @UiThread
    public void a(@Nullable InterfaceC0395a interfaceC0395a, @NonNull final Activity activity, @NonNull final e eVar, @NonNull final ShowFavoriteGuideApi.GuideType guideType, @Nullable String str, @Nullable String str2, long j) {
        final f ajs;
        this.cId = interfaceC0395a;
        Xg();
        if (eVar.aMD()) {
            ann();
            if (this.cIc != null) {
                this.cIc.mO(0);
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
                inflate.findViewById(a.f.favorite_guide_arrow).setPadding(0, 0, ((ah.getDisplayWidth(null) - iArr[0]) - (findViewById.getWidth() / 2)) - ah.O(7.0f), 0);
                this.cHW = new PopupWindow(inflate, -2, -2);
                if (this.cHY != null && !this.cHY.isFinishing() && !this.cHY.isDestroyed() && findViewById.isAttachedToWindow()) {
                    try {
                        this.cHW.showAsDropDown(findViewById, 0, -ah.O(3.0f));
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
            int O = ah.O(7.0f);
            int displayWidth = ah.getDisplayWidth(null);
            if (displayWidth - i < O * 2) {
                i = displayWidth - (O * 2);
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
                        a.this.Xg();
                        if (a.this.cId != null) {
                            a.this.cId.eT(false);
                        }
                        ShowFavoriteGuideApi.a(guideType, "flow_close_close", "click");
                    }
                });
            }
            ((Button) inflate.findViewById(a.f.favorite_guide_add_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.cHU = guideType;
                    com.baidu.swan.apps.menu.a.a(activity, new a.InterfaceC0456a() { // from class: com.baidu.swan.apps.api.module.favorite.a.2.1
                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0456a
                        public void onSuccess() {
                            if (a.this.cId != null) {
                                a.this.cId.eT(true);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=true");
                        }

                        @Override // com.baidu.swan.apps.menu.a.InterfaceC0456a
                        public void onFail() {
                            if (a.this.cId != null) {
                                a.this.cId.eT(false);
                            }
                            com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "add favorite result=false");
                        }
                    });
                    a.this.Xg();
                    if (a.this.cHX != null) {
                        a.this.cHX.cancel();
                    }
                    ShowFavoriteGuideApi.a(guideType, guideType == ShowFavoriteGuideApi.GuideType.WEAK ? "flow_add" : "flow_close_add", "click");
                }
            });
            this.cHW = new PopupWindow(inflate, -1, -2);
            this.cHW.setSoftInputMode(16);
            this.cHW.showAtLocation(activity.getWindow().getDecorView(), 81, 0, (int) ah.P(50.0f));
        }
        if ((guideType == ShowFavoriteGuideApi.GuideType.NORMAL || guideType == ShowFavoriteGuideApi.GuideType.TIPS) && this.cHY != null && (ajs = this.cHY.ajs()) != null && findViewById != null) {
            final com.baidu.swan.apps.core.d.e asV = ajs.asV();
            final String asD = asV == null ? "" : asV.asD();
            final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.api.module.favorite.a.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.cHW != null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        if (a.this.cHZ != ajs.asT() || ((asV != null && !TextUtils.equals(asD, asV.asD())) || (!eVar.aMD() && ah.isScreenLand()))) {
                            a.this.Xg();
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
            if (this.cHX != null) {
                this.cHX.cancel();
            }
            this.cHX = new Timer();
            this.cHX.schedule(new TimerTask() { // from class: com.baidu.swan.apps.api.module.favorite.a.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    a.this.Xg();
                    if (a.this.cId != null) {
                        a.this.cId.eT(com.baidu.swan.apps.database.favorite.a.oj(eVar.id));
                    }
                    if (a.this.cHX != null) {
                        a.this.cHX.cancel();
                    }
                }
            }, 1000 * j);
        }
        ShowFavoriteGuideApi.a(guideType, "", "show");
    }

    private void ann() {
        if (this.cIc == null) {
            this.cIc = b.bcR();
            if (this.cIc != null) {
                this.cIc.a(new b.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.5
                    @Override // com.baidu.swan.games.view.b.a
                    public void hL(int i) {
                        if (i == 1) {
                            a.this.Xg();
                        }
                    }

                    @Override // com.baidu.swan.games.view.b.a
                    public void ano() {
                        a.this.Xg();
                    }
                });
            }
        }
    }

    private synchronized void a(@NonNull Activity activity, @NonNull final e eVar, final ShowFavoriteGuideApi.GuideType guideType) {
        this.cIa = new ContentObserver(null) { // from class: com.baidu.swan.apps.api.module.favorite.a.6
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                p.aRr().execute(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.swan.apps.database.favorite.a.oj(eVar.id)) {
                            if (guideType == ShowFavoriteGuideApi.GuideType.NORMAL && a.this.cId != null) {
                                a.this.cId.eT(true);
                            }
                            a.this.Xg();
                        }
                    }
                });
            }
        };
        AppRuntime.getAppContext().getContentResolver().registerContentObserver(com.baidu.swan.apps.database.favorite.a.awE(), false, this.cIa);
        if (activity instanceof SwanAppActivity) {
            this.cHY = (SwanAppActivity) activity;
            if (this.cIb != null) {
                this.cHY.b(this.cIb);
            }
            this.cIb = new com.baidu.swan.apps.framework.a() { // from class: com.baidu.swan.apps.api.module.favorite.a.7
                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void anp() {
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "call onActivityDestroyed");
                    a.this.Xg();
                    if (a.this.cHY != null && a.this.cIb != null) {
                        a.this.cHY.b(a.this.cIb);
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void anq() {
                    super.anq();
                    com.baidu.swan.apps.console.c.i("FavoriteGuideHelper", "swanId=" + eVar.id + ", nowId=" + e.aMm());
                    if (!TextUtils.equals(eVar.id, e.aMm())) {
                        a.this.Xg();
                    }
                }

                @Override // com.baidu.swan.apps.framework.a, com.baidu.swan.apps.framework.b
                public void anr() {
                    if (a.this.cHW != null && a.this.cHW.isShowing()) {
                        a.this.Xg();
                    }
                }
            };
            this.cHY.a(this.cIb);
        }
        f ajs = this.cHY.ajs();
        if (ajs != null) {
            this.cHZ = ajs.asT();
            if (this.cHZ != null) {
                this.cHZ.a(new c.b() { // from class: com.baidu.swan.apps.api.module.favorite.a.8
                    @Override // com.baidu.swan.apps.core.d.c.b
                    public void anr() {
                        a.this.Xg();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public synchronized void Xg() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.favorite.a.9
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cHW != null) {
                    a.this.cHW.dismiss();
                    a.this.cHW = null;
                }
                if (a.this.cIa != null) {
                    AppRuntime.getAppContext().getContentResolver().unregisterContentObserver(a.this.cIa);
                    a.this.cIa = null;
                }
                if (a.this.cHY != null && a.this.cIb != null) {
                    a.this.cHY.b(a.this.cIb);
                }
                if (a.this.cHZ != null) {
                    a.this.cHZ.a((c.b) null);
                }
            }
        });
    }

    public boolean lc(String str) {
        return TextUtils.isEmpty(str) || ShowFavoriteGuideApi.GuideType.parse(str) == ShowFavoriteGuideApi.GuideType.NORMAL;
    }
}
