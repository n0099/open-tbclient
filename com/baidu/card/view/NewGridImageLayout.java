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
import d.b.c.e.p.l;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.i.p;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NewGridImageLayout extends LinearLayout implements p<d.b.h0.r.q.a>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final int f4529e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4530f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4531g;

    /* renamed from: h  reason: collision with root package name */
    public PlayVoiceBntNew f4532h;
    public VoteView i;
    public GridImageLayout j;
    public Context k;
    public d.b.h0.r.q.a l;
    public String m;
    public b0<d.b.h0.r.q.a> n;
    public boolean o;
    public boolean p;
    public LinkedList<MediaData> q;
    public d.b.h0.b1.m.a r;
    public View.OnClickListener s;
    public boolean t;
    public int u;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.h0.r.q.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
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
            b0<d.b.h0.r.q.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
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
        public void a(View view, String str, int i, boolean z, boolean z2) {
            ThreadCardUtils.startImageViewer(view, NewGridImageLayout.this.r.r, NewGridImageLayout.this.q, i, NewGridImageLayout.this.l.n(), NewGridImageLayout.this.m, true);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.q.a f4536e;

        public d(d.b.h0.r.q.a aVar) {
            this.f4536e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCardUtils.jumpToPB(this.f4536e.n().r1, NewGridImageLayout.this.k, NewGridImageLayout.this.u);
        }
    }

    /* loaded from: classes.dex */
    public class e implements TbRichTextView.x {
        public e() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i, boolean z, boolean z2) {
            ThreadCardUtils.jumpToPB(NewGridImageLayout.this.l.n().r1, NewGridImageLayout.this.k, 2);
        }
    }

    /* loaded from: classes.dex */
    public class f implements TbRichTextView.x {
        public f() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i, boolean z, boolean z2) {
            ThreadCardUtils.startImageViewer(view, true, NewGridImageLayout.this.q, i, NewGridImageLayout.this.l.n().r1.a(), NewGridImageLayout.this.m, NewGridImageLayout.this.l.n().r1.o);
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
            this.f4532h.i(new g());
        }
        ArrayList<VoiceData$VoiceModel> H1 = (!a2Var.s1 || (originalThreadInfo = a2Var.r1) == null) ? a2Var.H1() : originalThreadInfo.q;
        if (ListUtils.isEmpty(H1)) {
            this.f4532h.setVisibility(8);
            return;
        }
        this.f4532h.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4532h.setVoiceModel(voiceData$VoiceModel);
        this.f4532h.setTag(voiceData$VoiceModel);
        this.f4532h.b();
        if (voiceData$VoiceModel != null) {
            this.f4532h.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4532h.m();
    }

    public b0<d.b.h0.r.q.a> getSubClickListener() {
        return this.n;
    }

    public final void i(a2 a2Var) {
        boolean z;
        String j;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> K0 = a2Var.K0();
        String g0 = a2Var.g0();
        if (!a2Var.s1 || (originalThreadInfo = a2Var.r1) == null) {
            z = false;
        } else if (originalThreadInfo.m) {
            this.j.setVisibility(8);
            return;
        } else {
            K0 = originalThreadInfo.f12879h;
            z = true;
        }
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            this.q.clear();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
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
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    MediaData mediaData2 = (MediaData) ListUtils.getItem(this.q, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.q.size() > 1) {
                        j = k(mediaData2);
                    } else {
                        j = j(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.E(j);
                    tbRichTextImageInfo.D(originalUrl);
                    tbRichTextImageInfo.C(mediaData2.isLongPic());
                    int i3 = mediaData2.picWidth;
                    if (i3 > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(i3);
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
        this.f4531g = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4530f = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4532h = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.j = gridImageLayout;
        gridImageLayout.setSupportGifPlay(false);
        this.j.setCornerStyle(1);
        this.j.setAfterClickListener(new b());
        this.r = new d.b.h0.b1.m.a();
        int i = l.p(this.k)[0];
        this.r.D = i - (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.r.E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.j.setLayoutStrategy(this.r);
        this.q = new LinkedList<>();
        this.j.setOnImageClickListener(new c());
        VoteView voteView = (VoteView) findViewById(R.id.thread_card_vote);
        this.i = voteView;
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
        for (int i = 0; i < size; i++) {
            MediaData mediaData = arrayList.get(i);
            MediaData mediaData2 = arrayList2.get(i);
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
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar == null || aVar.n() == null) {
            return;
        }
        a2 n = aVar.n();
        OriginalThreadInfo originalThreadInfo = n.r1;
        if (originalThreadInfo != null && this.o) {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f4531g);
            d2.v(R.string.F_X01);
            d2.u(R.dimen.T_X07);
            d.b.h0.r.u.c.d(this.f4530f).u(R.dimen.T_X07);
            this.f4530f.setVisibility(8);
            if (originalThreadInfo.m) {
                ThreadCardUtils.setAbstract(this.f4531g, this.f4530f, new SpannableString(originalThreadInfo.f12878g), n, this.f4529e, this.o, this.t);
                SkinManager.setViewTextColor(this.f4531g, R.color.CAM_X0108);
            } else {
                ThreadCardUtils.setAbstract(this.f4531g, this.f4530f, originalThreadInfo.t, n, this.f4529e, this.o, this.t);
            }
            if (n(originalThreadInfo.D)) {
                d dVar = new d(aVar);
                this.i.setOnClickListener(dVar);
                this.i.setOnItemClickListener(dVar);
                this.i.setIsTransmit(true);
                this.i.setData(originalThreadInfo.D, originalThreadInfo.f12877f, originalThreadInfo.f12876e);
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        } else {
            q(this.j, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.i.setVisibility(8);
            this.f4531g.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            this.f4531g.setLineSpacing(l.g(this.k, R.dimen.M_T_X002), 1.0f);
            this.f4530f.setTextSize(0, l.g(this.k, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.f4530f, n, this.t);
            ThreadCardUtils.setAbstract(this.f4531g, this.f4530f, n.D(), n, this.f4529e, this.o, this.t);
        }
        if (r(n)) {
            i(n);
        }
        setVoiceData(n);
        this.l = aVar;
        if (aVar.n().r1 == null) {
            return;
        }
        if (n.s1) {
            if (this.l.n().r1 == null) {
                return;
            }
            if (!this.l.n().r1.m) {
                this.j.setOnImageClickListener(new e());
            }
        }
        if (!this.l.n().r1.m) {
            this.j.setOnImageClickListener(new f());
        }
        if (this.o) {
            if (this.l.n().r1 != null && !this.l.n().r1.m) {
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

    public void p(int i) {
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.p();
        }
        VoteView voteView = this.i;
        if (voteView != null) {
            voteView.C(i);
        }
    }

    public final void q(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean r(a2 a2Var) {
        d.b.h0.r.q.a aVar = this.l;
        if (aVar == null || aVar.n() == null) {
            return true;
        }
        if (this.l.n().w1() == null || this.l.n().w1().equals(a2Var.w1())) {
            if (a2Var.s1 && a2Var.r1 != null) {
                if (this.l.n().r1 == null) {
                    return true;
                }
                return !m(a2Var.r1.f12879h, this.l.n().r1.f12879h);
            }
            return !m(a2Var.K0(), this.l.n().K0());
        }
        return true;
    }

    public void setCornerStyle(int i) {
        this.j.setCornerStyle(i);
    }

    public void setFrom(String str) {
        this.m = str;
    }

    public void setFromCDN(boolean z) {
    }

    public void setFromForPb(int i) {
        this.u = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setNeedFrsTabName(boolean z) {
        this.t = z;
    }

    public void setObjectPool(d.b.c.e.k.b<ImageView> bVar, d.b.c.e.k.b<GifView> bVar2) {
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.setObjectPool(bVar, bVar2);
        }
    }

    public void setPreloadSizeReadyCallback(d.b.c.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.b.h0.r.q.a> b0Var) {
        this.n = b0Var;
    }

    public void setTransmit(boolean z) {
        this.o = z;
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4529e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.o = false;
        this.t = false;
        this.k = context;
        l();
    }
}
