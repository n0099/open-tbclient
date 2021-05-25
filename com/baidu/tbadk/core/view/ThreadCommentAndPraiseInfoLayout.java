package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.r0.m0;
import d.a.n0.z.c0;
import d.a.n0.z.m;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public EMTextView A;
    public ImageView B;
    public EMTextView C;
    public LinearLayout D;
    public a2 E;
    public Context F;
    public TbPageContext G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public int Q;
    public int R;
    public String S;
    public int T;
    public String U;
    public String V;
    public String W;
    public View.OnClickListener a0;
    public int b0;
    public View c0;
    public MaskView d0;

    /* renamed from: e  reason: collision with root package name */
    public int f12347e;
    public j e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12348f;
    public LinearLayout f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12349g;
    public i g0;

    /* renamed from: h  reason: collision with root package name */
    public AgreeView f12350h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f12351i;
    public CustomMessageListener i0;
    public ImageView j;
    public CustomMessageListener j0;
    public EMTextView k;
    public View l;
    public EMTextView m;
    public ImageView n;
    public View o;
    public FrameLayout p;
    public ImageView q;
    public EMTextView r;
    public ImageView s;
    public View t;
    public c0 u;
    public LinearLayout v;
    public ImageView w;
    public EMTextView x;
    public LinearLayout y;
    public ImageView z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadCommentAndPraiseInfoLayout.this.a0 != null) {
                ThreadCommentAndPraiseInfoLayout.this.a0.onClick(view);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = ThreadCommentAndPraiseInfoLayout.this;
            threadCommentAndPraiseInfoLayout.g(view, threadCommentAndPraiseInfoLayout.E);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ThreadCommentAndPraiseInfoLayout.this.B.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout.this.B.performClick();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout.this.B.performClick();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ThreadCommentAndPraiseInfoLayout.this.B.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout.this.B.performClick();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof a2)) {
                return;
            }
            a2 a2Var = (a2) customResponsedMessage.getData();
            if (ThreadCommentAndPraiseInfoLayout.this.E == null || a2Var == null) {
                return;
            }
            String str = a2Var.V() != null ? a2Var.V().oriUgcNid : "";
            String str2 = ThreadCommentAndPraiseInfoLayout.this.E.V() != null ? ThreadCommentAndPraiseInfoLayout.this.E.V().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    ThreadCommentAndPraiseInfoLayout.this.E.c4(a2Var.a1());
                    ThreadCommentAndPraiseInfoLayout.this.L(a2Var);
                    return;
                }
                return;
            }
            String o0 = a2Var.o0();
            String o02 = ThreadCommentAndPraiseInfoLayout.this.E.o0();
            if ("0".equals(o02) || TextUtils.isEmpty(o02) || !o02.equals(o0)) {
                return;
            }
            ThreadCommentAndPraiseInfoLayout.this.E.c4(a2Var.a1());
            ThreadCommentAndPraiseInfoLayout.this.L(a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str) || (a2Var = ThreadCommentAndPraiseInfoLayout.this.E) == null || "0".equals(a2Var.o0()) || !str.equals(ThreadCommentAndPraiseInfoLayout.this.E.o0())) {
                return;
            }
            if ((ThreadCommentAndPraiseInfoLayout.this.E.k2() || ThreadCommentAndPraiseInfoLayout.this.E.s2()) && ThreadCommentAndPraiseInfoLayout.this.E.r1() != null) {
                if (ThreadCommentAndPraiseInfoLayout.this.E.r1() != null && ThreadCommentAndPraiseInfoLayout.this.E.r1().share_info != null) {
                    ThreadCommentAndPraiseInfoLayout.this.E.r1().share_info.share_count++;
                }
            } else {
                a2 a2Var2 = ThreadCommentAndPraiseInfoLayout.this.E;
                a2Var2.h4(a2Var2.h1() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = ThreadCommentAndPraiseInfoLayout.this;
            threadCommentAndPraiseInfoLayout.O(threadCommentAndPraiseInfoLayout.E);
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f12347e = 11;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = 2;
        this.Q = 1;
        this.b0 = 3;
        this.e0 = null;
        this.h0 = true;
        this.i0 = new g(2921416);
        this.j0 = new h(2921417);
        n(context);
    }

    private BdUniqueId getPageUniqueId() {
        TbPageContext tbPageContext = this.G;
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    private int getShareObjSource() {
        int i2 = this.Q;
        if (i2 == 1) {
            return 5;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 == 4) {
            return 4;
        }
        if (i2 == 6) {
            return 8;
        }
        return i2 == 10 ? 16 : 0;
    }

    private int getThreadSourceForDynamicAndBjh() {
        int i2 = this.P;
        if (i2 == 4 || i2 == 9) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        return (i2 == 8 || i2 == 13) ? 3 : 0;
    }

    private int getThreadType() {
        a2 a2Var = this.E;
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.t1) {
            return 4;
        }
        if (a2Var.u1() == 49 || this.E.u1() == 69) {
            return 5;
        }
        if (this.E.w1() != null) {
            return 1;
        }
        if (this.E.getType() == a2.J2 || this.E.getType() == a2.f3) {
            return ListUtils.getCount(this.E.J1()) > 0 ? 3 : 2;
        }
        return 0;
    }

    private int getThreadTypeForDynamicAndBjh() {
        a2 a2Var = this.E;
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.Q1()) {
            return 1;
        }
        if (this.E.T1()) {
            return 2;
        }
        if (this.E.R1()) {
            return 3;
        }
        return this.E.S1() ? 4 : 0;
    }

    public void A(View view) {
        if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.F)) && this.E != null) {
            B();
            g(view, this.E);
            if (AntiHelper.e(getContext(), this.E)) {
                return;
            }
            F();
            View.OnClickListener onClickListener = this.a0;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public final void B() {
        if (this.E == null) {
            return;
        }
        StatisticItem e2 = e();
        e2.param("thread_type", this.E.u1());
        TiebaStatic.log(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F() {
        String y1;
        String str;
        boolean z;
        Uri parse;
        String C;
        String format;
        a2 a2Var = this.E;
        if (a2Var == null || this.F == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = this.E.i0();
        OriginalForumInfo originalForumInfo = this.E.D1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            i0 = originalForumInfo.ori_fname;
        }
        String str2 = i0;
        String str3 = valueOf;
        String z1 = this.E.z1();
        if (TextUtils.isEmpty(z1)) {
            z1 = this.E.C();
        }
        String str4 = z1;
        if (this.E.B2()) {
            y1 = this.E.V().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.E.V().oriUgcType + "&dvid=" + this.E.V().oriUgcVid + "&nid=" + this.E.V().oriUgcNid;
        } else {
            y1 = this.E.y1();
            str = "?share=9105&fr=share";
        }
        String str5 = str;
        String str6 = y1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + (str5 + "&share_from=post");
        if (this.E.r1() != null && this.E.r1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.E.r1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.E.r1() != null && this.E.r1().isLegalYYLiveData()) {
                str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.E.r1().mYyExtData.mSid + "&livessid=" + this.E.r1().mYyExtData.mSsid + "&uid=" + this.E.r1().mYyExtData.mYyUid;
                z = false;
            }
            String j2 = j(this.E);
            parse = j2 != null ? null : Uri.parse(j2);
            C = this.E.C();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.E.B2() && this.E.T() != null) {
                format = (TextUtils.isEmpty(this.E.z1()) || TextUtils.isEmpty(C)) ? MessageFormat.format(string2, this.E.T().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : C;
            } else {
                format = MessageFormat.format(string, str4, C);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int l = l(this.E);
            if (!this.E.B2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (l == 2 && this.E.w1() != null) {
                    shareItem.R = this.E.w1().play_count.intValue();
                } else if (l == 1) {
                    shareItem.R = this.E.I1();
                }
                shareItem.D = C;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f12600f = true;
            shareItem.o = this.Q;
            shareItem.E = getShareObjSource();
            shareItem.M = l;
            shareItem.F = 3;
            shareItem.G = k(this.E);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.E.B2()) {
                z = false;
            }
            shareItem.f0 = z;
            if (z) {
                shareItem.e0 = this.E.f1();
            }
            f();
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.E);
            if (this.P != 13) {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.E, 2);
            } else {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.E);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.F, shareItem, true, true);
            shareDialogConfig.setIsAlaLive(this.E.u1() != 49 || this.E.u1() == 60 || this.E.u1() == 69);
            c(shareDialogConfig);
            d.a.n0.d0.f.b().k(shareDialogConfig);
        }
        z = true;
        if (this.E.r1() != null) {
            str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.E.r1().mYyExtData.mSid + "&livessid=" + this.E.r1().mYyExtData.mSsid + "&uid=" + this.E.r1().mYyExtData.mYyUid;
            z = false;
        }
        String j22 = j(this.E);
        if (j22 != null) {
        }
        C = this.E.C();
        String string3 = getResources().getString(R.string.share_content_tpl);
        String string22 = getResources().getString(R.string.default_share_content_tpl);
        if (!this.E.B2()) {
        }
        format = MessageFormat.format(string3, str4, C);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int l2 = l(this.E);
        if (!this.E.B2()) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f12600f = true;
        shareItem2.o = this.Q;
        shareItem2.E = getShareObjSource();
        shareItem2.M = l2;
        shareItem2.F = 3;
        shareItem2.G = k(this.E);
        if (parse != null) {
        }
        if (this.E.B2()) {
        }
        shareItem2.f0 = z;
        if (z) {
        }
        f();
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.E);
        if (this.P != 13) {
        }
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.F, shareItem2, true, true);
        shareDialogConfig2.setIsAlaLive(this.E.u1() != 49 || this.E.u1() == 60 || this.E.u1() == 69);
        c(shareDialogConfig2);
        d.a.n0.d0.f.b().k(shareDialogConfig2);
    }

    public void G(a2 a2Var) {
        this.f12348f.setVisibility(8);
    }

    public void H(a2 a2Var) {
        EMTextView eMTextView = this.A;
        if (eMTextView != null) {
            int i2 = a2Var.G2;
            if (i2 <= 0) {
                eMTextView.setText(R.string.mark);
            } else {
                eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
            }
        }
        updateCollectStateUI(a2Var);
    }

    public void I() {
    }

    public void J(a2 a2Var) {
        LinearLayout linearLayout;
        if (this.t == null || a2Var == null) {
            return;
        }
        this.N = r(4);
        if (a2Var.D1 != null) {
            this.N = false;
        }
        if (this.N && ((linearLayout = this.D) == null || linearLayout.getVisibility() == 8)) {
            this.t.setVisibility(0);
            String string = this.F.getString(R.string.manage);
            this.r.setText(string);
            this.r.setContentDescription(string);
            this.H = true;
        } else {
            this.t.setVisibility(r(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void K(a2 a2Var) {
        if (a2Var != null && this.P == 13) {
            showOperationMaskView(a2Var.E2 == 1);
        }
    }

    public void L(a2 a2Var) {
        if (this.f12351i == null || a2Var == null) {
            return;
        }
        if (this.L) {
            this.l.setVisibility(0);
            if (a2Var.a1() > 0) {
                this.f12351i.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(a2Var.a1());
                if (this.K) {
                    updateReplyStateUI();
                    this.f12351i.setText(numFormatOverWan);
                } else {
                    this.f12351i.setText(String.format(this.F.getString(R.string.reply_num_tip), numFormatOverWan));
                }
                EMTextView eMTextView = this.f12351i;
                eMTextView.setContentDescription(this.F.getString(R.string.reply_num) + numFormatOverWan);
                this.H = true;
                return;
            } else if (this.K) {
                updateReplyStateUI();
                this.f12351i.setText(this.F.getString(R.string.action_comment_default));
                this.f12351i.setVisibility(0);
                this.H = true;
                return;
            } else {
                this.f12351i.setVisibility(8);
                return;
            }
        }
        this.l.setVisibility(8);
    }

    public final void M(a2 a2Var) {
        String Y0;
        if (this.f12349g == null || a2Var == null) {
            return;
        }
        if (a2Var.C0() > 0 && this.I) {
            this.f12349g.setVisibility(0);
            if (this.P == 3) {
                Y0 = a2Var.Z0();
            } else {
                Y0 = a2Var.Y0();
            }
            this.f12349g.setText(Y0);
            this.H = true;
            return;
        }
        this.f12349g.setVisibility(8);
    }

    public void N(a2 a2Var) {
        if (this.D == null || this.B == null || this.C == null || a2Var == null) {
            return;
        }
        if (!this.h0) {
            View view = this.c0;
            if (view != null) {
                view.setVisibility(8);
            }
            this.D.setVisibility(8);
        } else if (this.O && !r(128) && (d.a.n0.r0.b.e().g() || d.a.n0.r0.a.h().j())) {
            if (this.c0 == null) {
                View view2 = new View(getContext());
                this.c0 = view2;
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                addView(this.c0);
                this.c0.setAlpha(0.5f);
                this.c0.setOnTouchListener(new e());
                this.c0.setOnClickListener(new f());
            }
            int k = l.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c0.getLayoutParams();
            if (layoutParams == null) {
                this.c0.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.E.l2() && !this.E.m2()) {
                d.a.m0.r.u.c.d(this.C).u(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            this.c0.setVisibility(0);
            this.D.setVisibility(8);
        } else {
            View view3 = this.c0;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.D.setVisibility(8);
        }
    }

    public void O(a2 a2Var) {
        View view = this.o;
        if (view == null || this.m == null || a2Var == null) {
            return;
        }
        if (this.M) {
            view.setVisibility(0);
            long h1 = a2Var.h1();
            if ((a2Var.k2() || a2Var.s2()) && a2Var.r1() != null && a2Var.r1().share_info != null) {
                h1 = a2Var.r1().share_info.share_count;
            }
            String string = this.F.getString(R.string.share);
            if (h1 > 0) {
                string = StringHelper.numFormatOverWan(h1);
            }
            this.m.setText(string);
            this.H = true;
            updateShareStateUI(a2Var);
            return;
        }
        view.setVisibility(8);
    }

    public void addPraiseStats(int i2) {
        if (this.E != null || i2 >= 0) {
            StatisticItem d2 = d(i2);
            d2.param("thread_type", this.E.u1());
            TiebaStatic.log(d2);
        }
    }

    public final void c(ShareDialogConfig shareDialogConfig) {
        int i2 = this.P;
        if (i2 == 1) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
        } else if (i2 == 2) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
        } else if (i2 == 4) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
        } else if (i2 == 16) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
        } else if (i2 == 7) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
        } else if (i2 == 8) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
        } else if (i2 == 9) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
        } else if (i2 == 12) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
        } else if (i2 != 13) {
            shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
        } else {
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
        }
    }

    public void changeSelectStatus() {
        onClick(this.B);
    }

    public final StatisticItem d(int i2) {
        if (this.E != null || i2 >= 0) {
            StatisticItem statisticItem = new StatisticItem("c12003");
            statisticItem.param("tid", this.E.y1());
            if (this.E.u1() == 40) {
                statisticItem.param("obj_param1", "2");
            } else if (this.E.u1() == 0) {
                statisticItem.param("obj_param1", "1");
            }
            statisticItem.param("obj_source", "1");
            statisticItem.param("fid", this.E.c0());
            statisticItem.param("obj_locate", this.P);
            statisticItem.param("obj_id", i2);
            if (!k.isEmpty(this.S)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.S);
            }
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.E.M0());
            statisticItem.param("card_type", this.E.V0());
            statisticItem.param("recom_source", this.E.S0);
            statisticItem.param("ab_tag", this.E.U0);
            statisticItem.param("weight", this.E.T0);
            statisticItem.param("extra", this.E.V0);
            if (this.E.V() != null && !k.isEmpty(this.E.V().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.V().oriUgcVid);
            }
            d.a.m0.i0.c f2 = TbPageExtraHelper.f(this);
            if (f2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            return statisticItem;
        }
        return null;
    }

    public final StatisticItem e() {
        if (this.E == null) {
            return null;
        }
        int i2 = 0;
        int i3 = this.Q;
        if (i3 == 1) {
            i2 = 4;
        } else if (i3 == 2) {
            i2 = 5;
        } else if (i3 == 3) {
            i2 = 3;
        } else if (i3 == 4) {
            i2 = 2;
        } else if (i3 == 6) {
            i2 = 8;
        } else if (i3 == 7) {
            i2 = 9;
        } else if (i3 == 9) {
            i2 = 10;
        } else if (i3 == 10) {
            i2 = 17;
        } else if (i3 == 18) {
            i2 = 20;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("fid", this.E.c0());
        statisticItem.param("tid", this.E.y1());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.T);
        if (!k.isEmpty(this.S)) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.S);
        }
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.E.r1() != null && this.E.r1().user_info != null && this.E.r1().user_info.is_official == 2) {
            statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.E.r1().user_info.is_official);
        }
        statisticItem.param("card_type", this.E.V0()).param("ab_tag", this.E.U0).param("recom_source", this.E.S0).param("weight", this.E.T0).param("extra", this.E.V0);
        if (this.E.Q1()) {
            statisticItem.param("obj_type", 10);
        } else if (this.E.T1()) {
            statisticItem.param("obj_type", 9);
        } else if (this.E.S1()) {
            statisticItem.param("obj_type", 8);
        } else if (this.E.R1()) {
            statisticItem.param("obj_type", 7);
        } else {
            a2 a2Var = this.E;
            if (a2Var.t1) {
                statisticItem.param("obj_type", 6);
            } else {
                int i4 = a2Var.Z;
                if (i4 == 0) {
                    statisticItem.param("obj_type", 1);
                } else if (i4 == 40) {
                    statisticItem.param("obj_type", 2);
                } else if (i4 == 49 || i4 == 69) {
                    statisticItem.param("obj_type", 3);
                } else if (i4 == 54) {
                    statisticItem.param("obj_type", 4);
                } else {
                    statisticItem.param("obj_type", 5);
                }
            }
        }
        int i5 = this.P;
        if (i5 == 1 || i5 == 2) {
            statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
        }
        if (this.P == 18) {
            statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.U);
        }
        if (this.E.V() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.E.V().oriUgcNid);
            if (this.E.T1() || this.E.S1()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.V().oriUgcVid);
            }
        }
        if (this.E.V1()) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
        } else if (!this.E.Q1() && !this.E.T1()) {
            int i6 = this.E.Z;
            if (i6 == 0 || i6 == 40) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
        }
        TbPageContext tbPageContext = this.G;
        if (tbPageContext != null) {
            d.a.m0.j0.c.b(tbPageContext.getPageActivity(), statisticItem);
        }
        statisticItem.param("nid", this.E.M0());
        return statisticItem;
    }

    public final void f() {
        a2 a2Var;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Context context = this.F;
        if ((context instanceof m0) && ((m0) context).isInScoreTab() && (a2Var = this.E) != null && a2Var.z0() == null && (itemInfo = ((m0) this.F).getItemInfo()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(itemInfo.id.longValue());
            builder.item_name = itemInfo.name;
            builder.icon_size = itemInfo.icon_size;
            builder.icon_url = itemInfo.icon_url;
            builder.tags = itemInfo.tags;
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                Iterator<ItemPoint> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals("all")) {
                        Double d2 = next.point;
                        builder.score = d2;
                        builder.star = Integer.valueOf((int) (d2.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            this.E.R3(itemData);
        }
    }

    public final void g(View view, a2 a2Var) {
        int i2;
        if (a2Var == null) {
            return;
        }
        int id = view.getId();
        int i3 = 3;
        if (id == R.id.thread_info_commont_container) {
            i2 = 3;
        } else if (id == R.id.share_num_container) {
            i2 = 4;
        } else if (id == R.id.img_agree) {
            i2 = 1;
        } else {
            i2 = id == R.id.img_disagree ? 2 : 0;
        }
        int i4 = this.P;
        if (i4 == 1) {
            i3 = 1;
        } else if (i4 == 2) {
            i3 = 2;
        } else if (i4 != 4) {
            if (i4 == 8) {
                i3 = 4;
            } else if (i4 != 9) {
                i3 = 0;
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        TiebaStatic.log(d.a.n0.d3.a.o("c13694", a2Var, i3, i2));
    }

    public TextView getBarNameTv() {
        return this.f12348f;
    }

    public View getCommentContainer() {
        return this.l;
    }

    public View getCommentNumView() {
        return this.f12351i;
    }

    public final void h() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh <= 0 || threadTypeForDynamicAndBjh <= 0) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
        statisticItem.param("obj_source", threadSourceForDynamicAndBjh);
        statisticItem.param("obj_type", threadTypeForDynamicAndBjh);
        TiebaStatic.log(statisticItem);
    }

    public void hideDisagree() {
        this.f12350h.setAgreeAlone(true);
    }

    public void hideShareContainer() {
        this.M = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.j.setLayoutParams(layoutParams);
    }

    public View i(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    public boolean isInFrsAllThread() {
        return this.h0;
    }

    public boolean isVisible() {
        return this.H;
    }

    public final String j(a2 a2Var) {
        String str = null;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.r1() != null && !TextUtils.isEmpty(a2Var.r1().cover)) {
            return a2Var.r1().cover;
        }
        if (a2Var.L0() == null) {
            return null;
        }
        ArrayList<MediaData> L0 = a2Var.L0();
        int size = L0.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MediaData mediaData = L0.get(i2);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i2++;
        }
        return (str != null || a2Var.w1() == null || TextUtils.isEmpty(a2Var.w1().thumbnail_url)) ? str : a2Var.w1().thumbnail_url;
    }

    public final int k(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.Q1()) {
            return 10;
        }
        if (a2Var.T1()) {
            return 9;
        }
        if (a2Var.S1()) {
            return 8;
        }
        if (a2Var.R1()) {
            return 7;
        }
        if (a2Var.t1) {
            return 6;
        }
        int i2 = a2Var.Z;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 40) {
            return 2;
        }
        if (i2 == 49 || i2 == 69) {
            return 3;
        }
        return i2 == 54 ? 4 : 5;
    }

    public final int l(a2 a2Var) {
        if (a2Var != null) {
            if (a2Var.q2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            if (a2Var.Q1()) {
                return 5;
            }
            if (a2Var.T1()) {
                return 6;
            }
            if (a2Var.R1()) {
                return 7;
            }
            if (a2Var.S1()) {
                return 8;
            }
            if (!a2Var.t1 || a2Var.s1 == null) {
                return a2Var.r2() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    public final void m() {
        this.o.setVisibility(r(1) ? 0 : 8);
        this.l.setVisibility(r(2) ? 0 : 8);
        View view = this.t;
        int i2 = 4;
        if (r(4)) {
            i2 = 0;
        } else if (!r(64)) {
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f12350h.setVisibility(r(8) ? 0 : 8);
        this.f12350h.setAgreeAlone(r(32));
    }

    public final void n(Context context) {
        this.F = context;
        if (context instanceof BaseActivity) {
            this.G = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.G = ((BaseFragmentActivity) context).getPageContext();
        }
        l.g(this.F, R.dimen.tbds84);
        o();
    }

    public void o() {
        p(i(this.F));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.i0);
        MessageManager.getInstance().registerListener(this.j0);
    }

    public void onChangeSkinType() {
        if (this.b0 != TbadkCoreApplication.getInst().getSkinType()) {
            this.b0 = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0201);
            MaskView maskView = this.d0;
            if (maskView != null) {
                maskView.c();
            }
            SkinManager.setViewTextColor(this.f12348f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f12349g, R.color.CAM_X0107);
            updateReplyStateUI();
            updateCollectStateUI(this.E);
            updateShareStateUI(this.E);
            updateManagerUI();
            c0 c0Var = this.u;
            if (c0Var != null) {
                c0Var.W();
            }
            AgreeView agreeView = this.f12350h;
            if (agreeView != null) {
                agreeView.t(this.b0);
                AgreeView agreeView2 = this.f12350h;
                a2 a2Var = this.E;
                agreeView2.setAlpha((a2Var == null || a2Var.getType() != a2.z3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a2 a2Var = this.E;
        if (a2Var == null || a2Var.getType() != a2.z3) {
            if (view == this.f12348f) {
                s(view);
            } else if (view == this.l) {
                u(view);
            } else if (view == this.o) {
                A(view);
            } else if (view == this.q) {
                x(view);
            } else if (view == this.t) {
                w(view);
            } else if (view == this.B) {
                z(view);
            } else if (view == this.v) {
                y(view);
            } else if (view == this.y) {
                t(view);
            }
        }
    }

    public void onDestroy() {
        c0 c0Var = this.u;
        if (c0Var != null) {
            c0Var.O();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.i0);
        MessageManager.getInstance().unRegisterListener(this.j0);
    }

    public void p(View view) {
        this.f12348f = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.f12349g = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.f0 = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        EMTextView eMTextView = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        this.f12351i = eMTextView;
        d.a.m0.r.u.c.d(eMTextView).x(R.string.F_X01);
        this.j = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.k = (EMTextView) view.findViewById(R.id.thread_info_commont_grab_sofa);
        this.l = view.findViewById(R.id.thread_info_commont_container);
        EMTextView eMTextView2 = (EMTextView) view.findViewById(R.id.share_num);
        this.m = eMTextView2;
        d.a.m0.r.u.c.d(eMTextView2).x(R.string.F_X01);
        this.n = (ImageView) view.findViewById(R.id.share_num_img);
        this.o = view.findViewById(R.id.share_num_container);
        this.p = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.q = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            AgreeView agreeView = (AgreeView) findViewById;
            this.f12350h = agreeView;
            agreeView.setAfterClickListener(new a());
        }
        this.t = view.findViewById(R.id.manage_view_container);
        EMTextView eMTextView3 = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        this.r = eMTextView3;
        d.a.m0.r.u.c.d(eMTextView3).x(R.string.F_X01);
        this.s = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.B = (ImageView) view.findViewById(R.id.manage_select_img);
        EMTextView eMTextView4 = (EMTextView) view.findViewById(R.id.manage_select_text);
        this.C = eMTextView4;
        d.a.m0.r.u.c.d(eMTextView4).x(R.string.F_X01);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.D = linearLayout;
        linearLayout.setOnTouchListener(new b());
        this.C.setOnClickListener(new c());
        this.v = (LinearLayout) view.findViewById(R.id.qq_share_container);
        this.w = (ImageView) view.findViewById(R.id.qq_share_image);
        EMTextView eMTextView5 = (EMTextView) view.findViewById(R.id.qq_share_text);
        this.x = eMTextView5;
        if (eMTextView5 != null) {
            d.a.m0.r.u.c.d(eMTextView5).x(R.string.F_X01);
        }
        this.y = (LinearLayout) view.findViewById(R.id.collect_num_container);
        this.z = (ImageView) view.findViewById(R.id.collect_num_image);
        EMTextView eMTextView6 = (EMTextView) view.findViewById(R.id.collect_num_text);
        this.A = eMTextView6;
        if (eMTextView6 != null) {
            d.a.m0.r.u.c.d(eMTextView6).x(R.string.F_X01);
        }
        this.D.setOnClickListener(new d());
        this.l.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.B.setOnClickListener(this);
        LinearLayout linearLayout2 = this.v;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        LinearLayout linearLayout3 = this.y;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(this);
        }
    }

    public final boolean q(a2 a2Var) {
        return (a2Var == null || !a2Var.C2() || a2Var.w1() == null) ? false : true;
    }

    public final boolean r(int i2) {
        return (i2 & this.f12347e) > 0;
    }

    public void resetShareContainer() {
        this.M = true;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.leftMargin = this.F.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.j.setLayoutParams(layoutParams);
    }

    public final void s(View view) {
        a2 a2Var = this.E;
        if (a2Var == null || StringUtils.isNull(a2Var.i0())) {
            return;
        }
        if (!StringUtils.isNull(this.V) && !StringUtils.isNull(this.W)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createCfgForpersonalized(this.E.i0(), this.V, this.W)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createNormalCfg(this.E.i0(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.a0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setAgreeStatisticData(d.a.m0.r.q.e eVar) {
        AgreeView agreeView = this.f12350h;
        if (agreeView != null) {
            agreeView.setStatisticData(eVar);
        }
    }

    public void setAgreeViewType(a2 a2Var) {
        if (a2Var == null || !a2Var.B2()) {
            return;
        }
        this.f12350h.setAgreeAlone(true);
    }

    public void setBarNameClickEnabled(boolean z) {
        this.J = z;
        TextView textView = this.f12348f;
        if (textView != null) {
            textView.setClickable(z);
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        View view = this.l;
        if (view != null) {
            view.setClickable(z);
            this.j.setEnabled(z);
            this.f12351i.setEnabled(z);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public boolean setData(a2 a2Var) {
        if (a2Var == null) {
            setVisibility(8);
            return false;
        }
        this.E = a2Var;
        I();
        G(a2Var);
        M(a2Var);
        L(a2Var);
        H(a2Var);
        O(a2Var);
        updatePraiseNum(a2Var);
        N(a2Var);
        J(a2Var);
        setVisibility(this.H ? 0 : 8);
        K(a2Var);
        v();
        return this.H;
    }

    public void setDisPraiseFrom(int i2) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.a0 = onClickListener;
    }

    public void setForumId(String str) {
    }

    public void setFrom(int i2) {
        this.P = i2;
        AgreeView agreeView = this.f12350h;
        if (agreeView != null) {
            agreeView.setFrom(i2);
        }
    }

    public void setGameId(int i2) {
        this.T = i2;
        AgreeView agreeView = this.f12350h;
        if (agreeView != null) {
            agreeView.setGameId(i2);
        }
    }

    public void setInFrsAllThread(boolean z) {
        this.h0 = z;
    }

    public void setIsBarViewVisible(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.N = z;
    }

    public void setMultiForumCount(int i2) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.K = z;
    }

    public void setOnCommentClickCallback(i iVar) {
        this.g0 = iVar;
    }

    public void setOnSelectStatusChangeListener(j jVar) {
        this.e0 = jVar;
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout = this.v;
        if (linearLayout != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.I = z;
    }

    public void setSelectVisible(boolean z) {
        this.O = z;
    }

    public void setShareClickable(boolean z) {
        View view = this.o;
        if (view != null) {
            view.setClickable(z);
            this.n.setEnabled(z);
            this.m.setEnabled(z);
        }
    }

    public void setShareReportFrom(int i2) {
        this.Q = i2;
    }

    public void setShareVisible(boolean z) {
    }

    public void setShowCommonView() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
    }

    public void setShowFlag(int i2) {
        this.f12347e = i2;
        m();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setStType(String str) {
        this.V = str;
    }

    public void setTabName(String str) {
        this.U = str;
        AgreeView agreeView = this.f12350h;
        if (agreeView != null) {
            agreeView.setTabName(str);
        }
    }

    public void setYuelaouLocate(String str) {
        this.W = str;
    }

    public void showOperationMaskView(boolean z) {
        if (z && this.d0 == null) {
            MaskView maskView = new MaskView(getContext());
            this.d0 = maskView;
            addView(maskView);
        }
        MaskView maskView2 = this.d0;
        if (maskView2 != null) {
            maskView2.setVisibility(z ? 0 : 8);
        }
    }

    public void t(View view) {
    }

    public void u(View view) {
        a2 a2Var = this.E;
        if (a2Var == null || this.F == null) {
            return;
        }
        m.a(a2Var.y1());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.P);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.E.y1());
        statisticItem.param("nid", this.E.M0());
        if (this.P == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.E.c0());
            statisticItem.param("obj_locate", 18);
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.U);
        }
        d.a.m0.i0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem);
        PbActivityConfig addLocateParam = new PbActivityConfig(this.F).createFromThreadCfg(this.E, null, this.V, 0, true, false, false).addLocateParam("");
        addLocateParam.setForumId(String.valueOf(this.E.c0()));
        addLocateParam.setForumName(this.E.i0());
        if (this.E.r0() && this.E.h0() != null) {
            addLocateParam.setForumId(this.E.h0().h());
            addLocateParam.setForumName(this.E.h0().g());
        }
        addLocateParam.setJumpToCommentArea(true);
        i iVar = this.g0;
        if (iVar != null) {
            iVar.a(addLocateParam);
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && q(this.E)) {
            addLocateParam.setNeedPreLoad(true);
            d.a.n0.r0.l.c(this.E);
        }
        if (this.E.R1) {
            addLocateParam.setFromHomePageQuality(true);
        }
        if (this.E.g2() && addLocateParam.getIntent() != null) {
            addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        addLocateParam.setStartFrom(this.R);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.P);
        TiebaStatic.log(statisticItem2);
        h();
        g(view, this.E);
        View.OnClickListener onClickListener = this.a0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void updateCollectStateUI(a2 a2Var) {
        if (this.z != null) {
            if (a2Var != null && a2Var.t0() != 0) {
                WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void updateManagerUI() {
        int color;
        WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        EMTextView eMTextView = this.r;
        a2 a2Var = this.E;
        if (a2Var != null && a2Var.getType() == a2.z3) {
            color = d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
        } else {
            color = SkinManager.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
        ImageView imageView = this.s;
        a2 a2Var2 = this.E;
        imageView.setEnabled(a2Var2 == null || a2Var2.getType() != a2.z3);
    }

    public void updatePraiseNum(a2 a2Var) {
        setAgreeViewType(a2Var);
        if (a2Var.L() != null) {
            a2Var.L().isInThread = true;
            this.f12350h.setCardType(a2Var.V0());
            this.f12350h.setThreadData(a2Var);
            this.f12350h.setData(a2Var.L());
        }
        AgreeView agreeView = this.f12350h;
        a2 a2Var2 = this.E;
        agreeView.setAlpha((a2Var2 == null || a2Var2.getType() != a2.z3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
    }

    public void updateReplyStateUI() {
        int color;
        if (this.K) {
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        ImageView imageView = this.j;
        a2 a2Var = this.E;
        imageView.setEnabled(a2Var == null || a2Var.getType() != a2.z3);
        EMTextView eMTextView = this.f12351i;
        a2 a2Var2 = this.E;
        if (a2Var2 != null && a2Var2.getType() == a2.z3) {
            color = d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
        } else {
            color = SkinManager.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
    }

    public void updateShareStateUI(a2 a2Var) {
        WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.o(a2Var)) {
            setShareClickable(true);
            this.m.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        } else if (a2Var != null && a2Var.s1 != null && this.E.s1.m) {
            setShareClickable(false);
            this.m.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        } else {
            setShareClickable(true);
            d.a.m0.r.u.c.d(this.m).u(R.color.CAM_X0107);
        }
        a2 a2Var2 = this.E;
        if (a2Var2 == null || a2Var2.getType() != a2.z3) {
            return;
        }
        this.n.setEnabled(false);
        this.m.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
    }

    public void v() {
    }

    public void w(View view) {
        if (this.u == null) {
            this.u = new c0(this.G, r(16));
        }
        this.u.Y(this.E);
        this.u.l();
        if (this.E != null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.E.c0()).param("tid", this.E.o0()));
        }
    }

    public final void x(View view) {
    }

    public void y(View view) {
    }

    public void z(View view) {
        a2 a2Var;
        if (this.B == null || (a2Var = this.E) == null || this.C == null || a2Var.A2()) {
            return;
        }
        boolean z = true;
        if (!this.E.l2() && d.a.n0.r0.b.e().g()) {
            if (d.a.n0.r0.b.e().a(this.E)) {
                this.E.W3(true);
            }
        } else if (!this.E.m2() && d.a.n0.r0.a.h().j()) {
            if (d.a.n0.r0.a.h().a(this.E)) {
                this.E.X3(true);
            }
        } else {
            d.a.n0.r0.b.e().j(this.E);
            this.E.W3(false);
            d.a.n0.r0.a.h().l(this.E);
            this.E.X3(false);
        }
        if (!this.E.l2() && !this.E.m2()) {
            d.a.m0.r.u.c.d(this.C).u(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
        }
        j jVar = this.e0;
        if (jVar != null) {
            if (!this.E.l2() && !this.E.m2()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.f0;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f12347e = 11;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = 2;
        this.Q = 1;
        this.b0 = 3;
        this.e0 = null;
        this.h0 = true;
        this.i0 = new g(2921416);
        this.j0 = new h(2921417);
        n(context);
    }
}
