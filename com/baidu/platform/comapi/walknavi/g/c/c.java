package com.baidu.platform.comapi.walknavi.g.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.a;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.tieba.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class c extends com.baidu.platform.comapi.walknavi.g.c.b implements CompoundButton.OnCheckedChangeListener, com.baidu.platform.comapi.walknavi.d.b {
    private TextView A;
    private View B;
    private ImageView C;
    private TextView D;
    private boolean E;
    private a F;
    private RelativeLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private RelativeLayout J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private ImageView O;
    private String R;
    private TextView T;
    private String U;
    private com.baidu.platform.comapi.walknavi.widget.a W;
    private IWMoreNPCModelOnClickListener X;
    private IWNPCLoadAndInitListener Y;

    /* renamed from: a  reason: collision with root package name */
    Animation f4516a;
    private a.b ae;
    private a.C0259a af;
    private View ag;
    private View ah;
    private RelativeLayout ai;
    private TextView aj;
    private TextView ak;
    private TextView al;
    private ImageView am;
    private TextView an;

    /* renamed from: b  reason: collision with root package name */
    Animation f4517b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    Button f;
    View g;
    ImageView h;
    private FrameLayout k;
    private Context l;
    private com.baidu.platform.comapi.walknavi.g.a m;
    private ad o;
    private RelativeLayout p;
    private ImageButton q;
    private ImageButton r;
    private int v;
    private RelativeLayout y;
    private ImageButton z;
    private Handler n = new Handler();
    private final int s = 1;
    private final int t = 2;
    private final int u = 3;
    private int w = 1;
    private int x = 1;
    private boolean N = false;
    private AlphaAnimation P = new AlphaAnimation(1.0f, 0.0f);
    private AlphaAnimation Q = new AlphaAnimation(0.0f, 1.0f);
    private boolean S = false;
    private boolean V = false;
    private boolean Z = true;
    private long aa = 0;
    private boolean ab = true;
    private boolean ac = false;
    private boolean ad = false;
    private final View.OnClickListener ao = new l(this);
    final Runnable i = new o(this);
    final Runnable j = new v(this);

    /* loaded from: classes15.dex */
    public interface a {
        void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void a(int i);

        void a(String str);
    }

    /* loaded from: classes15.dex */
    public interface d {
        void a();

        void b();
    }

    public c(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.K = null;
        this.l = context;
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        this.f4516a = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.attr.actionBarPopupTheme);
        this.f4516a.setFillAfter(true);
        this.f4517b = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.attr.actionBarItemBackground);
        this.f4517b.setFillAfter(true);
        this.P.setDuration(300L);
        this.Q.setDuration(300L);
        this.m = aVar;
        this.o = new ad(context, view);
        d(view);
        this.I = (RelativeLayout) view.findViewById(R.dimen.abc_seekbar_track_progress_height_material);
        this.J = (RelativeLayout) view.findViewById(R.dimen.abc_text_size_body_2_material);
        this.H = (RelativeLayout) view.findViewById(R.dimen.abc_text_size_display_3_material);
        a(this.H);
        this.K = (ImageView) view.findViewById(R.dimen.abc_text_size_button_material);
        if (n != null && n.getImageToNormal() != null && this.K != null) {
            this.K.setImageBitmap(n.getImageToNormal());
        }
        this.K.setOnClickListener(new com.baidu.platform.comapi.walknavi.g.c.d(this));
        this.L = (ImageView) view.findViewById(R.dimen.abc_text_size_caption_material);
        if (n != null && n.getImageArCloseIcon() != null && this.L != null) {
            this.L.setImageBitmap(n.getImageArCloseIcon());
        }
        c(view);
        this.M = (ImageView) view.findViewById(R.dimen.abc_text_size_body_1_material);
        if (com.baidu.platform.comapi.walknavi.b.a().c()) {
            this.M.setVisibility(0);
            if (n != null && n.getImageToAR() != null && this.M != null) {
                this.M.setImageBitmap(n.getImageToAR());
            }
        } else {
            this.M.setVisibility(8);
        }
        this.M.setOnClickListener(new r(this));
        this.p = (RelativeLayout) view.findViewById(R.dimen.abc_select_dialog_padding_start_material);
        this.q = (ImageButton) view.findViewById(R.dimen.abc_switch_padding);
        this.q.setOnClickListener(new w(this));
        this.y = (RelativeLayout) view.findViewById(R.dimen.abc_edit_text_inset_top_material);
        a(view);
        this.C.setOnClickListener(new x(this));
        this.B.setOnClickListener(new y(this));
        this.E = true;
        this.A.setOnClickListener(new z(this));
        if (this.G != null && this.z != null) {
            this.G.setOnClickListener(this.ao);
            this.z.setOnClickListener(this.ao);
        }
        this.O = (ImageView) view.findViewById(R.dimen.abc_text_size_display_2_material);
        if (n != null && n.getImageNPC() != null && this.O != null) {
            this.O.setImageBitmap(n.getImageNPC());
        }
        this.O.setOnClickListener(new aa(this));
        a(n);
    }

    private void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        if (walkNaviDisplayOption != null && walkNaviDisplayOption.getWNaviTextTypeface() != null) {
            this.ak.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.al.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.an.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.aj.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.D.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.T.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
            this.A.setTypeface(walkNaviDisplayOption.getWNaviTextTypeface());
        }
    }

    private void a(View view) {
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null || !n.getIsCustomWNaviRgBarLayout()) {
            b(view);
        } else if (!n()) {
            b(view);
        }
    }

    private boolean n() {
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null) {
            Log.e("CustomWNaviView", "Load bottomSetting layout failed,WalkNaviDisplayOption is null.");
            return false;
        }
        int bottomSettingLayout = n.getBottomSettingLayout();
        if (bottomSettingLayout == 0) {
            Log.e("CustomWNaviView", "BottomSetting layout resource is empty.");
            return false;
        } else if (this.y == null) {
            Log.e("CustomWNaviView", "BottomSetting layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from((Activity) this.l).inflate(bottomSettingLayout, (ViewGroup) this.y, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load bottomSetting layout failed,please checking xml layout.");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a((Activity) this.l, 3, bottomSettingLayout, this)) {
                Log.e("CustomWNaviView", "Parser bottomSetting layout failed,please checking layout.");
                return false;
            } else if (this.af == null) {
                Log.e("CustomWNaviView", "Parser bottomSetting layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.af.a()) || TextUtils.isEmpty(this.af.b()) || TextUtils.isEmpty(this.af.c()) || TextUtils.isEmpty(this.af.d()) || TextUtils.isEmpty(this.af.e())) {
                Log.e("CustomWNaviView", "BottomSetting layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.B = inflate.findViewById(Integer.parseInt(this.af.a().replace("@", "")));
                    this.C = (ImageView) inflate.findViewById(Integer.parseInt(this.af.b().replace("@", "")));
                    this.D = (TextView) inflate.findViewById(Integer.parseInt(this.af.c().replace("@", "")));
                    this.A = (TextView) inflate.findViewById(Integer.parseInt(this.af.d().replace("@", "")));
                    this.T = (TextView) inflate.findViewById(Integer.parseInt(this.af.e().replace("@", "")));
                    if (this.B == null || this.C == null || this.D == null || this.A == null || this.T == null) {
                        Log.e("CustomWNaviView", "BottomSetting layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.y.removeAllViews();
                    this.y.addView(inflate);
                    if (TextUtils.isEmpty(this.D.getText())) {
                        this.D.setText("退出");
                    }
                    this.A.setText("查看全览");
                    this.ad = true;
                    this.y.setBackgroundColor(0);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CustomWNaviView", "BottomSetting layout control type error");
                    return false;
                }
            }
        }
    }

    private void b(View view) {
        if (view != null) {
            this.C = (ImageView) view.findViewById(R.dimen.abc_list_item_padding_horizontal_material);
            this.D = (TextView) view.findViewById(R.dimen.abc_panel_menu_list_width);
            this.B = view.findViewById(R.dimen.abc_floating_window_z);
            this.A = (TextView) view.findViewById(R.dimen.abc_search_view_preferred_width);
            this.z = (ImageButton) view.findViewById(R.dimen.abc_search_view_preferred_height);
            this.G = (RelativeLayout) view.findViewById(R.dimen.abc_progress_bar_height_material);
            this.T = (TextView) view.findViewById(R.dimen.abc_seekbar_track_background_height_material);
        }
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        this.X = iWMoreNPCModelOnClickListener;
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        this.Y = iWNPCLoadAndInitListener;
    }

    private void c(View view) {
        this.k = (FrameLayout) view.findViewById(R.dimen.abc_dialog_padding_material);
    }

    private void a(String str, String str2) {
        if (!a(str2)) {
            Log.e("LoadLocalNPCError", "the localNPCPath is not found, please check");
        } else if (com.baidu.platform.comapi.walknavi.d.e.c().o()) {
            b(str, str2);
            com.baidu.platform.comapi.walknavi.b.a().K().b(str, str2);
            if (this.Y != null) {
                this.Y.onSuccess();
            }
        } else {
            com.baidu.platform.comapi.walknavi.b.a().a(new ab(this, str, str2));
        }
    }

    public void a(BaseNpcModel baseNpcModel) {
        if (this.l != null) {
            if (baseNpcModel == null) {
                Log.e("BaseNpcModel error", "BaseNpcModel is null,please check!");
            } else if (TextUtils.equals(baseNpcModel.getDownLoadKey(), "")) {
                com.baidu.platform.comapi.walknavi.d.e.c().a("");
                b(true);
                com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
                s();
            } else if (com.baidu.platform.comapi.wnplatform.a.a().c() && baseNpcModel.isLoadFromLocal()) {
                a(baseNpcModel.getDownLoadKey(), baseNpcModel.getLocalPath());
            } else if (!com.baidu.platform.comapi.walknavi.d.a.g.g.b(this.l)) {
                Toast.makeText(this.l, (int) R.drawable.res_0x7f08001f_ic_icon_mask_live__0, 0).show();
            } else if (!com.baidu.platform.comapi.walknavi.d.a.g.g.d(this.l)) {
                a(baseNpcModel.getDownLoadKey(), com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.drawable.res_0x7f08001e_ic_icon_mask_guide_travel_svg__1), 4);
            } else {
                a(baseNpcModel.getDownLoadKey(), new ac(this, baseNpcModel));
            }
        }
    }

    private boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        this.W = new com.baidu.platform.comapi.walknavi.widget.a(this.l).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.drawable.res_0x7f080004_avd_show_password__1)).a(String.format(str2, Integer.valueOf(i))).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.drawable.res_0x7f080000_avd_hide_password__0)).b().b(new f(this, str)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.drawable.res_0x7f080005_avd_show_password__2)).a(new e(this));
        if (!this.W.isShowing() && this.l != null && !((Activity) this.l).isFinishing()) {
            this.W.show();
        }
    }

    public void a(int i, boolean z) {
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            this.N = false;
            this.ai.setVisibility(0);
            this.y.setVisibility(0);
            this.I.setVisibility(0);
            this.J.setVisibility(8);
            this.k.setVisibility(8);
            if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
                c(true);
            }
            if (!z) {
                this.y.startAnimation(this.f4517b);
                this.I.startAnimation(this.f4517b);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            this.N = true;
            this.ai.setVisibility(8);
            if (z) {
                this.y.setVisibility(8);
                this.I.setVisibility(8);
                this.J.setVisibility(0);
            } else {
                this.y.setVisibility(8);
                this.y.startAnimation(this.f4516a);
                this.I.startAnimation(this.f4516a);
                this.f4516a.setAnimationListener(new g(this));
            }
            WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
            if (n != null && n.getImageArCloseIcon() != null && this.L != null) {
                this.L.setImageBitmap(n.getImageArCloseIcon());
            }
            com.baidu.platform.comapi.walknavi.b.a().G().d(true);
            this.n.postDelayed(this.i, 500L);
        }
    }

    private void d(View view) {
        this.ai = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_title_divider_material);
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null || !n.getIsCustomWNaviCalorieLayout()) {
            e(view);
        } else if (!o()) {
            e(view);
        }
    }

    private boolean o() {
        WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n == null) {
            Log.e("CustomWNaviView", "Load calorie layout WalkNaviDisplayOption is null ");
            return false;
        }
        int calorieLayout = n.getCalorieLayout();
        if (calorieLayout == 0) {
            Log.e("CustomWNaviView", "Calorie layout resource is empty");
            return false;
        } else if (this.ai == null) {
            Log.e("CustomWNaviView", "Calorie layout add failed.");
            return false;
        } else {
            View inflate = LayoutInflater.from((Activity) this.l).inflate(calorieLayout, (ViewGroup) this.ai, false);
            if (inflate == null) {
                Log.e("CustomWNaviView", "Load calorie layout failed,please checking layout");
                return false;
            } else if (!com.baidu.platform.comapi.walknavi.g.d.d.a().a((Activity) this.l, 2, calorieLayout, this)) {
                Log.e("CustomWNaviView", "Parser calorie layout failed,please checking layout.");
                return false;
            } else if (this.ae == null) {
                Log.e("CustomWNaviView", "Parser calorie layout failed,missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else if (TextUtils.isEmpty(this.ae.a()) || TextUtils.isEmpty(this.ae.e()) || TextUtils.isEmpty(this.ae.b()) || TextUtils.isEmpty(this.ae.c()) || TextUtils.isEmpty(this.ae.d()) || TextUtils.isEmpty(this.ae.f()) || TextUtils.isEmpty(this.ae.g())) {
                Log.e("CustomWNaviView", "Calorie layout missing other keywords like TAG attribute or ID attribute.");
                return false;
            } else {
                try {
                    this.ah = inflate.findViewById(Integer.parseInt(this.ae.a().replace("@", "")));
                    this.ag = inflate.findViewById(Integer.parseInt(this.ae.e().replace("@", "")));
                    this.aj = (TextView) inflate.findViewById(Integer.parseInt(this.ae.b().replace("@", "")));
                    this.am = (ImageView) inflate.findViewById(Integer.parseInt(this.ae.c().replace("@", "")));
                    this.an = (TextView) inflate.findViewById(Integer.parseInt(this.ae.d().replace("@", "")));
                    this.ak = (TextView) inflate.findViewById(Integer.parseInt(this.ae.f().replace("@", "")));
                    this.al = (TextView) inflate.findViewById(Integer.parseInt(this.ae.g().replace("@", "")));
                    if (this.ah == null || this.ag == null || this.aj == null || this.am == null || this.an == null || this.ak == null || this.al == null) {
                        Log.e("CustomWNaviView", "Calorie layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                        return false;
                    }
                    this.ai.removeAllViews();
                    this.ai.addView(inflate);
                    this.ac = true;
                    this.ah.setVisibility(8);
                    this.aj.setText("已消耗");
                    this.ak.setText("0");
                    this.al.setText("大卡");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("CustomWNaviView", "Calorie layout control type error.");
                    return false;
                }
            }
        }
    }

    private void e(View view) {
        if (view != null) {
            this.ag = view.findViewById(R.dimen.abc_dropdownitem_text_padding_right);
            this.ah = view.findViewById(R.dimen.abc_disabled_alpha_material_dark);
            this.aj = (TextView) view.findViewById(R.dimen.abc_disabled_alpha_material_light);
            this.ak = (TextView) view.findViewById(R.dimen.abc_edit_text_inset_bottom_material);
            this.al = (TextView) view.findViewById(R.dimen.abc_edit_text_inset_horizontal_material);
            this.am = (ImageView) view.findViewById(R.dimen.abc_dropdownitem_icon_width);
            this.an = (TextView) view.findViewById(R.dimen.abc_dropdownitem_text_padding_left);
            this.ah.setVisibility(8);
        }
    }

    public void a(int i) {
        this.ak.setText(i + "");
        com.baidu.platform.comapi.walknavi.g.d.a.a().a(i, new h(this));
    }

    private void a(RelativeLayout relativeLayout) {
        this.c = (CheckBox) relativeLayout.findViewById(R.dimen.abc_text_size_large_material);
        this.c.setOnCheckedChangeListener(this);
        if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
            this.c.setClickable(false);
        }
        this.d = (CheckBox) relativeLayout.findViewById(R.dimen.abc_text_size_menu_material);
        this.d.setOnCheckedChangeListener(this);
        this.g = relativeLayout.findViewById(R.dimen.abc_text_size_menu_header_material);
        this.h = (ImageView) relativeLayout.findViewById(R.dimen.abc_text_size_small_material);
        p();
        this.e = (CheckBox) relativeLayout.findViewById(R.dimen.abc_text_size_subtitle_material_toolbar);
        this.e.setOnCheckedChangeListener(this);
        this.f = (Button) relativeLayout.findViewById(R.dimen.abc_text_size_title_material_toolbar);
        this.f.setOnClickListener(new k(this));
    }

    private void p() {
        if (com.baidu.platform.comapi.wnplatform.p.a.a()) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            com.baidu.platform.comapi.walknavi.b.a().G().b(true);
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        com.baidu.platform.comapi.walknavi.b.a().G().b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == 0) {
            MapStatus i = com.baidu.platform.comapi.walknavi.b.a().J().i();
            if (i != null) {
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                builder.zoom(19.0f);
                builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.top + i.winRound.bottom) / 2) - ((int) (0.0d - ((Math.abs(i.winRound.bottom - i.winRound.top) - 75) * 0.25d)))));
                com.baidu.platform.comapi.basestruct.Point N = com.baidu.platform.comapi.walknavi.b.a().N();
                if (N != null) {
                    builder.target(new LatLng(N.getDoubleY(), N.getDoubleX()));
                }
                com.baidu.platform.comapi.walknavi.b.a().J().a(i, 500);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
    }

    public void c() {
        if (this.V) {
            com.baidu.platform.comapi.walknavi.d.e.c().a(new C0300c(this));
            String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
            if (TextUtils.isEmpty(a2)) {
                b(true);
                com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
                s();
            } else {
                a(a2, (d) null);
            }
            this.V = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0300c implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<com.baidu.platform.comapi.walknavi.g.c.b> f4518a;

        public C0300c(com.baidu.platform.comapi.walknavi.g.c.b bVar) {
            this.f4518a = null;
            this.f4518a = new WeakReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.g.a
        public void a(g.b bVar) {
        }
    }

    public void d() {
        r();
    }

    public void a(a aVar) {
        this.F = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.c.b
    public void a() {
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.attr.actionBarItemBackground);
        this.o.a();
        if (com.baidu.platform.comapi.walknavi.b.a().x() == 1) {
            if (!this.p.isShown()) {
                this.p.setAnimation(c);
            }
            this.p.setVisibility(0);
            if (this.ai != null) {
                if (!this.ai.isShown()) {
                    this.ai.setAnimation(c);
                }
                this.ai.setVisibility(0);
            }
            if (!this.y.isShown()) {
                this.y.setAnimation(c);
            }
            this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.c.b
    public void b() {
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.attr.actionBarPopupTheme);
        this.o.b();
        if (com.baidu.platform.comapi.walknavi.g.b.b.f4503a == 2) {
            if (this.r.isShown()) {
                this.r.setAnimation(c);
            }
            this.r.setVisibility(8);
        }
        if (this.ai != null) {
            if (this.ai.isShown()) {
                this.ai.setAnimation(c);
            }
            this.ai.setVisibility(8);
        }
    }

    private void r() {
    }

    public void b(int i) {
        switch (i) {
            case 3:
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.E = z;
        if (this.E) {
            this.A.setText("查看全览");
        } else {
            this.A.setText("继续当前导航");
        }
    }

    public void c(int i) {
        if (i == 2130837816) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, 2130837816));
            this.v = 1;
        } else if (i == 2130837819) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, 2130837819));
            this.v = 2;
        } else if (i == 2130837817) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, 2130837817));
            this.v = 3;
        }
    }

    public void g() {
        this.o.c();
        this.l = null;
        if (this.X != null) {
            this.X = null;
        }
        if (this.Y != null) {
            this.Y = null;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().i();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.dimen.abc_text_size_large_material) {
            if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
                com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:sound_check:" + z);
                if (z) {
                    if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
                        com.baidu.platform.comapi.wnplatform.l.a.a().a("sound", 1);
                        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
                    }
                    WNaviTTSPlayer.resumeVoiceTTSOutput();
                    com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_VOICE_ON_OFF", true);
                    return;
                }
                if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
                    com.baidu.platform.comapi.wnplatform.l.a.a().a("sound", 0);
                    com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
                }
                WNaviTTSPlayer.pauseVoiceTTSOutput();
                com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_VOICE_ON_OFF", false);
            }
        } else if (compoundButton.getId() == R.dimen.abc_text_size_menu_material) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:panocheck:" + z);
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_STREET_POI_ON_OFF", true);
                com.baidu.platform.comapi.walknavi.b.a().G().b(true);
                com.baidu.platform.comapi.wnplatform.l.a.a().a("streetPoi", 1);
                com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_STREET_POI_ON_OFF", false);
            com.baidu.platform.comapi.walknavi.b.a().G().b(false);
            com.baidu.platform.comapi.wnplatform.l.a.a().a("streetPoi", 0);
            com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
        } else if (compoundButton.getId() == R.dimen.abc_text_size_subtitle_material_toolbar) {
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_THREED_MAP_ON_OFF", true);
                d(true);
                com.baidu.platform.comapi.wnplatform.l.a.a().a("threeD", 1);
                com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_THREED_MAP_ON_OFF", false);
            d(false);
            com.baidu.platform.comapi.wnplatform.l.a.a().a("threeD", 0);
            com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG");
        }
    }

    private void d(boolean z) {
        MapStatus i = com.baidu.platform.comapi.walknavi.b.a().J().i();
        MapStatus.Builder builder = new MapStatus.Builder();
        if (i != null) {
            if (z) {
                builder.overlook(-50.0f);
                com.baidu.platform.comapi.walknavi.b.a().c(-50);
            } else {
                builder.overlook(0.0f);
                com.baidu.platform.comapi.walknavi.b.a().c(0);
            }
            com.baidu.platform.comapi.walknavi.b.a().J().a(i, 1300);
        }
    }

    public ImageView h() {
        return this.L;
    }

    public TextView i() {
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.platform.comapi.walknavi.d.e.c().a(str);
        b(str2);
        s();
    }

    private void b(String str) {
        this.k.setVisibility(0);
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null) {
            for (int i = 0; i < q.size(); i++) {
                if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, q.get(i).c())) {
                    String a3 = q.get(i).a();
                    String b2 = q.get(i).b();
                    if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2)) {
                        try {
                            com.baidu.platform.comapi.walknavi.b.a().G().a(Integer.parseInt(a3), Integer.parseInt(b2));
                        } catch (Exception e) {
                        }
                    } else {
                        com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
                    }
                }
            }
        }
        if (!com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            com.baidu.platform.comapi.walknavi.d.e.c().a(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (u() / 9) * 9);
            com.baidu.platform.comapi.walknavi.d.e.c().m().setZOrderOnTop(true);
            com.baidu.platform.comapi.walknavi.d.e.c().m().setFrameRate(30);
            this.k.addView(com.baidu.platform.comapi.walknavi.d.e.c().m(), layoutParams);
            com.baidu.platform.comapi.walknavi.d.e.c().f();
            this.n.postDelayed(new m(this, str), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().f();
        this.n.postDelayed(new n(this, str), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(a2)) {
            this.O.setVisibility(0);
            WalkNaviDisplayOption n = com.baidu.platform.comapi.walknavi.b.a().n();
            if (n != null && n.getImageNPC() != null && this.O != null) {
                this.O.setImageBitmap(n.getImageNPC());
                return;
            } else {
                this.O.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, 2130837854));
                return;
            }
        }
        com.baidu.platform.comapi.walknavi.d.a a3 = com.baidu.platform.comapi.walknavi.b.a().a(a2);
        if (a3 != null) {
            Bitmap d2 = a3.d();
            if (d2 != null) {
                this.O.setVisibility(0);
                this.O.setImageBitmap(d2);
                return;
            }
            this.O.setVisibility(0);
            this.O.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, 2130837868));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "call npcSwitchCase");
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, this.k.getHeight(), this.k.getWidth());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.baidu.platform.comapi.walknavi.d.e.c().b(str, this.k.getWidth(), this.k.getHeight());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    public void j() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.k.setVisibility(0);
        com.baidu.platform.comapi.walknavi.d.e.c().h();
    }

    public void b(boolean z) {
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().G().d(false);
            this.k.setVisibility(8);
            com.baidu.platform.comapi.walknavi.d.e.c().g();
            com.baidu.platform.comapi.wnplatform.n.d.a().a(false);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().e();
    }

    public void k() {
        com.baidu.platform.comapi.wnplatform.n.d.a().a(false);
        if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            t();
            com.baidu.platform.comapi.walknavi.d.e.c().c(true);
            com.baidu.platform.comapi.walknavi.d.e.c().a(false);
            com.baidu.platform.comapi.walknavi.d.e.c().i();
            this.k.removeAllViews();
        }
        if (this.n != null && this.i != null) {
            this.n.removeCallbacks(this.i);
            this.n = null;
        }
    }

    public void c(boolean z) {
        if (com.baidu.platform.comapi.walknavi.d.e.c().p()) {
            b(z);
        }
    }

    private void t() {
        if (com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_AR_NPC_IS_DOWNLOADING", false)) {
            com.baidu.platform.comapi.walknavi.d.e.c().n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null) {
            boolean z = false;
            for (int i = 0; i < q.size(); i++) {
                if (TextUtils.equals(str, q.get(i).c())) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    private void a(String str, b bVar) {
        com.baidu.platform.comapi.wnplatform.l.a.a().a(ARConfigKey.OLD_AR_KEY, str);
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, new q(this, bVar));
    }

    public void a(String str, d dVar) {
        String a2 = com.baidu.platform.comapi.walknavi.b.a().K().a(str, "");
        if (!TextUtils.isEmpty(a2)) {
            a(str, a2);
            return;
        }
        this.U = com.baidu.platform.comapi.walknavi.d.e.c().d(str);
        if (com.baidu.platform.comapi.walknavi.d.e.c().c(str) || this.S) {
            a(str, new s(this, str, dVar));
            return;
        }
        String str2 = this.U + File.separator + "ar";
        if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            b(str, str2);
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void l() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.b.a().K().a(a2, ""))) {
            com.baidu.platform.comapi.walknavi.d.e.c().b(a2, new t(this, a2));
        }
    }

    private int u() {
        return com.baidu.platform.comapi.wnplatform.p.h.c(this.l);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.platform.comapi.walknavi.d.b
    public void a(int i, HashMap<String, Object> hashMap) {
        char c;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "messageType:" + i);
        switch (i) {
            case 1:
                if (((Integer) hashMap.get("succeeded")).intValue() == 1) {
                    com.baidu.platform.comapi.walknavi.d.e.c().c(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().b();
                    l();
                    com.baidu.platform.comapi.walknavi.d.e.c().k();
                    com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/start.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"enter\"\nfunction run()\n    local cfg = an.ActionPriorityConfig:new()\n    cfg.forward_logic = 1\n    cfg.backward_logic = 1\n    local param = an.GpbAnimationParam:new()\n    param._speed = 1.0\n    param._repeat_count = 1\n    param._name = pod_name\n    local id_play_pod = pod_node:play_gpb_animation(param, cfg)\n    if id_play_pod == -1 then\n        local mapData = an.MapData:new()\n        mapData:put_string(\"action_type\", \"animation_failed\")\n        mapData:put_string(\"token\", token)\n        lua_handler:send_message_tosdk(mapData)\n        return\n    end\n    \n    local podFinishedHandlerId = lua_handler:register_handle(\"onEnterPlayPodFinished\")\n    pod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\n\nfunction onEnterPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"enter\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "enter");
                    return;
                }
                return;
            case 2:
                if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("action_name")) {
                    String str = (String) hashMap.get("action_name");
                    com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "animation end:" + str);
                    switch (str.hashCode()) {
                        case -1838009598:
                            if (str.equals("stopBreath")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1672022665:
                            if (str.equals("multiClickAndTumble")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1311375678:
                            if (str.equals("withoutGPS")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -789059494:
                            if (str.equals("helpless")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -788629758:
                            if (str.equals("turnAndGuide")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case -778128814:
                            if (str.equals("turnAndSayHi")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -420935824:
                            if (str.equals("turnAndCry")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -136570977:
                            if (str.equals("turnRight")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3641801:
                            if (str.equals("walk")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 96667352:
                            if (str.equals("enter")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 133959204:
                            if (str.equals("turnLeft")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1746496772:
                            if (str.equals("achieveGoal")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            com.baidu.platform.comapi.walknavi.d.e.c().k();
                            com.baidu.platform.comapi.walknavi.d.e.c().a(false);
                            com.baidu.platform.comapi.walknavi.d.e.c().b(false);
                            return;
                        case 1:
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            return;
                        case 2:
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().b("\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"stopBreath\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 0\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.0\nparam._repeat_count = -1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onStopBreathPlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onStopBreathPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n \nlocal onClickHandler = lua_handler:register_handle(\"onStopBreathClick\")\ncurrent_scene:set_event_handler(0, onClickHandler)\nfunction onStopBreathClick()\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_type\", \"click\")\n    mapData:put_string(\"name\", pod_name)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "stopBreath");
                            return;
                        case 3:
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            return;
                        case 4:
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            return;
                        case 5:
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            return;
                        case 6:
                        case '\t':
                        default:
                            return;
                        case 7:
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            return;
                        case '\b':
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            return;
                        case '\n':
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            this.ab = true;
                            return;
                        case 11:
                            com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                            com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                            return;
                    }
                }
                return;
            case 3:
                if (System.currentTimeMillis() - this.aa < 300) {
                    if (this.ab) {
                        this.ab = false;
                        this.aa = System.currentTimeMillis();
                        if (this.n != null && this.j != null) {
                            this.n.removeCallbacks(this.j);
                        }
                        com.baidu.platform.comapi.walknavi.d.e.c().k();
                        com.baidu.platform.comapi.walknavi.d.e.c().b(false);
                        com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/tap2.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"multiClickAndTumble\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 0\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.2\nparam._repeat_count = 1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onMultiClickAndTumblePlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onMultiClickAndTumblePlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"multiClickAndTumble\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "multiClickAndTumble");
                        return;
                    }
                    return;
                }
                this.ab = true;
                this.aa = System.currentTimeMillis();
                this.n.postDelayed(this.j, 500L);
                return;
            case 4:
                if (hashMap.containsKey("url")) {
                    String str2 = (String) hashMap.get("url");
                    if (com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_VOICE_ON_OFF", true)) {
                        com.baidu.platform.comapi.wnplatform.p.j.a().a(str2);
                        return;
                    }
                    return;
                }
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return;
        }
    }

    public boolean m() {
        return this.ad;
    }

    public void a(a.b bVar) {
        this.ae = bVar;
    }

    public void a(a.C0259a c0259a) {
        this.af = c0259a;
    }
}
