package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NewGridImageLayout extends LinearLayout implements p<d.a.m0.r.q.a>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final int f4498e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4499f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4500g;

    /* renamed from: h  reason: collision with root package name */
    public PlayVoiceBntNew f4501h;

    /* renamed from: i  reason: collision with root package name */
    public VoteView f4502i;
    public GridImageLayout j;
    public Context k;
    public d.a.m0.r.q.a l;
    public String m;
    public b0<d.a.m0.r.q.a> n;
    public boolean o;
    public boolean p;
    public LinkedList<MediaData> q;
    public d.a.m0.b1.m.a r;
    public View.OnClickListener s;
    public boolean t;
    public int u;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.m0.r.q.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, NewGridImageLayout.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.m0.r.q.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                subClickListener.a(view, NewGridImageLayout.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbRichTextView.x {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            ThreadCardUtils.startImageViewer(view, NewGridImageLayout.this.r.r, NewGridImageLayout.this.q, i2, NewGridImageLayout.this.l.i(), NewGridImageLayout.this.m, true);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.q.a f4506e;

        public d(d.a.m0.r.q.a aVar) {
            this.f4506e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCardUtils.jumpToPB(this.f4506e.i().t1, NewGridImageLayout.this.k, NewGridImageLayout.this.u);
        }
    }

    /* loaded from: classes.dex */
    public class e implements TbRichTextView.x {
        public e() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            ThreadCardUtils.jumpToPB(NewGridImageLayout.this.l.i().t1, NewGridImageLayout.this.k, 2);
        }
    }

    /* loaded from: classes.dex */
    public class f implements TbRichTextView.x {
        public f() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            ThreadCardUtils.startImageViewer(view, true, NewGridImageLayout.this.q, i2, NewGridImageLayout.this.l.i().t1.a(), NewGridImageLayout.this.m, NewGridImageLayout.this.l.i().t1.o);
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NewGridImageLayout.this.s != null) {
                NewGridImageLayout.this.s.onClick(view);
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    private void setVoiceData(a2 a2Var) {
        OriginalThreadInfo originalThreadInfo;
        if (a2Var == null) {
            return;
        }
        if (this.o) {
            this.f4501h.i(new g());
        }
        ArrayList<VoiceData$VoiceModel> K1 = (!a2Var.u1 || (originalThreadInfo = a2Var.t1) == null) ? a2Var.K1() : originalThreadInfo.q;
        if (ListUtils.isEmpty(K1)) {
            this.f4501h.setVisibility(8);
            return;
        }
        this.f4501h.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = K1.get(0);
        this.f4501h.setVoiceModel(voiceData$VoiceModel);
        this.f4501h.setTag(voiceData$VoiceModel);
        this.f4501h.b();
        if (voiceData$VoiceModel != null) {
            this.f4501h.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4501h.m();
    }

    public b0<d.a.m0.r.q.a> getSubClickListener() {
        return this.n;
    }

    public final void i(a2 a2Var) {
        boolean z;
        String j;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> L0 = a2Var.L0();
        String g0 = a2Var.g0();
        if (!a2Var.u1 || (originalThreadInfo = a2Var.t1) == null) {
            z = false;
        } else if (originalThreadInfo.m) {
            this.j.setVisibility(8);
            return;
        } else {
            L0 = originalThreadInfo.f12102h;
            z = true;
        }
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            this.q.clear();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (!z) {
                        if (g0 != null) {
                            if (!g0.equals(mediaData.getPostId() + "")) {
                            }
                        }
                    }
                    this.q.add(mediaData);
                }
            }
            if (ListUtils.getCount(this.q) > 0) {
                this.j.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < this.q.size(); i3++) {
                    MediaData mediaData2 = (MediaData) ListUtils.getItem(this.q, i3);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.q.size() > 1) {
                        j = k(mediaData2);
                    } else {
                        j = j(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.I(j);
                    tbRichTextImageInfo.H(originalUrl);
                    tbRichTextImageInfo.G(mediaData2.isLongPic());
                    int i4 = mediaData2.picWidth;
                    if (i4 > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(i4);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList.add(tbRichTextImageInfo);
                }
                this.j.setData(arrayList);
                return;
            }
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(8);
    }

    public final String j(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallPicUrl();
        }
        return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
    }

    public final String k(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String smallPicUrl = mediaData.getSmallPicUrl();
        if (TextUtils.isEmpty(smallPicUrl)) {
            smallPicUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(smallPicUrl)) {
            smallPicUrl = mediaData.getPicUrl();
        }
        return TextUtils.isEmpty(smallPicUrl) ? mediaData.getSrc_pic() : smallPicUrl;
    }

    public final void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4500g = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4499f = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4501h = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.j = gridImageLayout;
        gridImageLayout.setSupportGifPlay(false);
        this.j.setCornerStyle(1);
        this.j.setAfterClickListener(new b());
        this.r = new d.a.m0.b1.m.a();
        int i2 = l.p(this.k)[0];
        this.r.D = i2 - (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.r.E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.j.setLayoutStrategy(this.r);
        this.q = new LinkedList<>();
        this.j.setOnImageClickListener(new c());
        VoteView voteView = (VoteView) findViewById(R.id.thread_card_vote);
        this.f4502i = voteView;
        voteView.setBgColor(R.color.CAM_X0207);
    }

    public final boolean m(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        String j;
        String j2;
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MediaData mediaData = arrayList.get(i2);
            MediaData mediaData2 = arrayList2.get(i2);
            if (size > 1) {
                j = k(mediaData);
                j2 = k(mediaData2);
            } else {
                j = j(mediaData);
                j2 = j(mediaData2);
            }
            if (j != j2 && (j == null || j2 == null || !j.equals(j2))) {
                return false;
            }
        }
        return true;
    }

    public final boolean n(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.m0.r.q.a aVar) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        a2 i2 = aVar.i();
        OriginalThreadInfo originalThreadInfo = i2.t1;
        if (originalThreadInfo != null && this.o) {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f4500g);
            d2.x(R.string.F_X01);
            d2.w(R.dimen.T_X07);
            d.a.m0.r.u.c.d(this.f4499f).w(R.dimen.T_X07);
            this.f4499f.setVisibility(8);
            if (originalThreadInfo.m) {
                ThreadCardUtils.setAbstract(this.f4500g, this.f4499f, new SpannableString(originalThreadInfo.f12101g), i2, this.f4498e, this.o, this.t);
                SkinManager.setViewTextColor(this.f4500g, R.color.CAM_X0108);
            } else {
                ThreadCardUtils.setAbstract(this.f4500g, this.f4499f, originalThreadInfo.t, i2, this.f4498e, this.o, this.t);
            }
            if (n(originalThreadInfo.D)) {
                d dVar = new d(aVar);
                this.f4502i.setOnClickListener(dVar);
                this.f4502i.setOnItemClickListener(dVar);
                this.f4502i.setIsTransmit(true);
                this.f4502i.setData(originalThreadInfo.D, originalThreadInfo.f12100f, originalThreadInfo.f12099e);
                this.f4502i.setVisibility(0);
            } else {
                this.f4502i.setVisibility(8);
            }
        } else {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.f4502i.setVisibility(8);
            this.f4500g.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            this.f4500g.setLineSpacing(l.g(this.k, R.dimen.M_T_X002), 1.0f);
            this.f4499f.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.f4499f, i2, this.t);
            ThreadCardUtils.setAbstract(this.f4500g, this.f4499f, i2.D(), i2, this.f4498e, this.o, this.t);
        }
        if (r(i2)) {
            i(i2);
        }
        setVoiceData(i2);
        this.l = aVar;
        if (aVar.i().t1 == null) {
            return;
        }
        if (i2.u1) {
            if (this.l.i().t1 == null) {
                return;
            }
            if (!this.l.i().t1.m) {
                this.j.setOnImageClickListener(new e());
            }
        }
        if (!this.l.i().t1.m) {
            this.j.setOnImageClickListener(new f());
        }
        if (this.o) {
            if (this.l.i().t1 != null && !this.l.i().t1.m) {
                setOnClickListener(this);
            } else {
                setOnClickListener(null);
            }
            setClickable(true);
            return;
        }
        setOnClickListener(null);
        setClickable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void p(int i2) {
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.p();
        }
        VoteView voteView = this.f4502i;
        if (voteView != null) {
            voteView.C(i2);
        }
    }

    public final void q(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean r(a2 a2Var) {
        d.a.m0.r.q.a aVar = this.l;
        if (aVar == null || aVar.i() == null) {
            return true;
        }
        if (this.l.i().z1() == null || this.l.i().z1().equals(a2Var.z1())) {
            if (a2Var.u1 && a2Var.t1 != null) {
                if (this.l.i().t1 == null) {
                    return true;
                }
                return !m(a2Var.t1.f12102h, this.l.i().t1.f12102h);
            }
            return !m(a2Var.L0(), this.l.i().L0());
        }
        return true;
    }

    public void setCornerStyle(int i2) {
        this.j.setCornerStyle(i2);
    }

    public void setFrom(String str) {
        this.m = str;
    }

    public void setFromCDN(boolean z) {
    }

    public void setFromForPb(int i2) {
        this.u = i2;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setNeedFrsTabName(boolean z) {
        this.t = z;
    }

    public void setObjectPool(d.a.c.e.k.b<ImageView> bVar, d.a.c.e.k.b<GifView> bVar2) {
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.setObjectPool(bVar, bVar2);
        }
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
    }

    public void setSubClickListener(b0<d.a.m0.r.q.a> b0Var) {
        this.n = b0Var;
    }

    public void setTransmit(boolean z) {
        this.o = z;
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4498e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.o = false;
        this.t = false;
        this.k = context;
        l();
    }
}
