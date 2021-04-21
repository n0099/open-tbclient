package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.c.e.p.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import d.b.j0.d2.k.e.w0;
/* loaded from: classes3.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    public TextView A;
    public TextView B;
    public FrameLayout C;
    public int D;
    public ImageView E;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadAchievementShareInfo f12800e;

    /* renamed from: f  reason: collision with root package name */
    public Gson f12801f;

    /* renamed from: g  reason: collision with root package name */
    public Context f12802g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12803h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public PermissionJudgePolicy q;
    public w0 r;
    public TbPageContext s;
    public d.b.i0.r.s.a t;
    public Bitmap u;
    public View v;
    public ImageView w;
    public LinearLayout x;
    public FrameLayout y;
    public HeadImageView z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadAchievementShareDialogView.this.t == null || !ThreadAchievementShareDialogView.this.t.isShowing()) {
                return;
            }
            ThreadAchievementShareDialogView.this.t.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.n(threadAchievementShareDialogView.k());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 3);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 2);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 4);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 8);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadAchievementShareDialogView threadAchievementShareDialogView = ThreadAchievementShareDialogView.this;
            threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 6);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f12811a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f12812b;

        public h(Bitmap bitmap, int i) {
            this.f12811a = bitmap;
            this.f12812b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return ThreadAchievementShareDialogView.this.j(this.f12811a, this.f12812b);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f12814a;

        public i(int i) {
            this.f12814a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ThreadAchievementShareDialogView.this.f12802g, this.f12814a, shareItem, false));
        }
    }

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.f12801f = new Gson();
        this.f12802g = context;
        this.f12800e = m(str);
    }

    private int getTextViewWidth() {
        int k;
        int g2 = l.g(this.f12802g, R.dimen.tbds44);
        int g3 = l.g(this.f12802g, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.f12802g) == 2) {
            k = l.i(this.f12802g);
        } else {
            k = l.k(this.f12802g);
        }
        return ((k - (g2 * 2)) - g3) / 6;
    }

    public final void f() {
        String user_img;
        ThreadAchievementShareInfo threadAchievementShareInfo = this.f12800e;
        if (threadAchievementShareInfo == null || threadAchievementShareInfo.getParams() == null) {
            return;
        }
        ThreadAchievementShareInfo.UserBean user = this.f12800e.getParams().getUser();
        if (!TextUtils.isEmpty(user.getImg())) {
            user_img = user.getImg();
        } else {
            user_img = user.getUser_img();
        }
        HeadImageView headImageView = this.z;
        headImageView.W("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
        this.o.setText(user.getUsername());
        if (!TextUtils.isEmpty(this.f12800e.getParams().getUrl())) {
            i(this.f12800e.getParams().getUrl());
            this.w.setVisibility(0);
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean g() {
        if (this.q == null) {
            this.q = new PermissionJudgePolicy();
        }
        this.q.clearRequestPermissionList();
        this.q.appendRequestPermission(this.s.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return this.q.startRequestPermission(this.s.getPageActivity());
    }

    public boolean h(TbPageContext tbPageContext, d.b.i0.r.s.a aVar) {
        this.s = tbPageContext;
        this.t = aVar;
        l(this.f12802g);
        if (this.f12800e.getParams() != null && !ListUtils.isEmpty(this.f12800e.getParams().getThread_list())) {
            this.y.addView(new d.b.i0.l.f.a(this.f12802g, this.f12800e).a());
            this.p.setText(this.f12800e.getParams().getTitle());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            statisticItem.param("obj_source", 1);
            TiebaStatic.log(statisticItem);
            this.D = 2;
        } else if (this.f12800e.getParams() != null) {
            if (this.f12800e.getParams().getVideo_info() != null) {
                this.y.addView(new d.b.i0.l.f.c(this.f12802g, this.f12800e).a());
            } else {
                this.y.addView(new d.b.i0.l.f.b(this.f12802g, this.f12800e).a());
            }
            this.p.setText(this.f12800e.getParams().getTitle());
            StatisticItem statisticItem2 = new StatisticItem("c10898");
            statisticItem2.param("obj_source", 2);
            TiebaStatic.log(statisticItem2);
            this.D = 3;
        }
        f();
        return true;
    }

    public final void i(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.w.setImageBitmap((Bitmap) runTask.getData());
    }

    public final ShareItem j(Bitmap bitmap, int i2) {
        ShareItem shareItem = new ShareItem();
        shareItem.a0 = false;
        shareItem.Z = false;
        shareItem.V = 1;
        shareItem.r = this.f12802g.getString(R.string.app_name);
        shareItem.s = "";
        shareItem.h(bitmap);
        shareItem.f();
        return shareItem;
    }

    public Bitmap k() {
        if (this.u == null) {
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement);
            this.x.buildDrawingCache();
            this.u = this.x.getDrawingCache();
        }
        SkinManager.setBackgroundResource(this.x, R.drawable.bg_frs_private_dialog);
        SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement_round);
        return this.u;
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_share);
        this.f12803h = linearLayout;
        this.v = linearLayout.findViewById(R.id.poster_head_bg);
        SkinManager.setBackgroundResource(this.f12803h, R.drawable.bg_frs_private_dialog);
        SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement_round);
        this.y = (FrameLayout) this.f12803h.findViewById(R.id.poster_container);
        this.p = (TextView) this.f12803h.findViewById(R.id.achievement_desc);
        this.z = (HeadImageView) this.f12803h.findViewById(R.id.head_portrait);
        TextView textView = (TextView) this.f12803h.findViewById(R.id.user_name);
        this.o = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
        this.z.setIsRound(true);
        this.z.setPlaceHolder(2);
        this.z.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.x = (LinearLayout) this.f12803h.findViewById(R.id.share_view_layout);
        this.w = (ImageView) this.f12803h.findViewById(R.id.share_qrcode);
        this.A = (TextView) this.f12803h.findViewById(R.id.qrcode_top_desc);
        this.B = (TextView) this.f12803h.findViewById(R.id.qrcode_bottom_desc);
        this.C = (FrameLayout) this.f12803h.findViewById(R.id.qrcode_layout);
        ImageView imageView = (ImageView) this.f12803h.findViewById(R.id.close_button);
        this.E = imageView;
        imageView.setOnClickListener(new a());
        SkinManager.setImageResource(this.E, R.drawable.icon_popup_shut_n);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.C, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.x, R.drawable.bg_frs_private_dialog);
        TextView textView2 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_download);
        this.i = textView2;
        o(textView2, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.i.setOnClickListener(new b());
        TextView textView3 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_wechat);
        this.j = textView3;
        o(textView3, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.j.setOnClickListener(new c());
        TextView textView4 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_moment);
        this.k = textView4;
        o(textView4, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.k.setOnClickListener(new d());
        TextView textView5 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_qzone);
        this.l = textView5;
        o(textView5, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.l.setOnClickListener(new e());
        TextView textView6 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_qq);
        this.m = textView6;
        o(textView6, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.m.setOnClickListener(new f());
        TextView textView7 = (TextView) this.f12803h.findViewById(R.id.frs_private_share_weibo);
        this.n = textView7;
        o(textView7, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.n.setOnClickListener(new g());
    }

    public final ThreadAchievementShareInfo m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.f12801f.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public final void n(Bitmap bitmap) {
        if (g()) {
            return;
        }
        if (this.r == null) {
            this.r = new w0(this.s);
        }
        if (this.f12800e.getParams() != null && !TextUtils.isEmpty(this.f12800e.getParams().getUrl())) {
            this.r.b(this.f12800e.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
        } else {
            this.r.b("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
        this.E.performClick();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.D);
        TiebaStatic.log(statisticItem);
    }

    public final void o(TextView textView, AbsSvgType absSvgType) {
        if (absSvgType == null) {
            return;
        }
        Drawable drawable = absSvgType.getDrawable();
        int g2 = l.g(getContext(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    public final void p(Bitmap bitmap, int i2) {
        if (bitmap == null || g()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i2 == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i2 == 4) {
            statisticItem.param("obj_type", 5);
        } else {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.D);
        TiebaStatic.log(statisticItem);
        h0.b(new h(bitmap, i2), new i(i2));
    }
}
