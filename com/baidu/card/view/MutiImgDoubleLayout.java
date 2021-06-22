package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.n0.b1.j.d;
import d.a.n0.r.k;
import d.a.n0.r.q.a2;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<d.a.n0.r.q.a> {
    public static final int r;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4441e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4442f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4443g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4444h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4445i;
    public TbImageView j;
    public String k;
    public boolean l;
    public b0<d.a.n0.r.q.a> m;
    public d.a.n0.r.q.a n;
    public int o;
    public d p;
    public LinkedList<MediaData> q;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.n0.r.q.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MutiImgDoubleLayout.this.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {
        public b() {
        }

        @Override // d.a.n0.b1.j.d
        public void a(View view, int i2, boolean z) {
            b0<d.a.n0.r.q.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgDoubleLayout.this.n.objType = 2;
                subClickListener.a(view, MutiImgDoubleLayout.this.n);
                MutiImgDoubleLayout.this.n.objType = 1;
            }
            ThreadCardUtils.startImageViewer(view, MutiImgDoubleLayout.this.l, MutiImgDoubleLayout.this.q, i2, MutiImgDoubleLayout.this.n.i(), MutiImgDoubleLayout.this.k);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f4448e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4449f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4450g;

        public c(int i2, boolean z, boolean z2) {
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            this.f4448e = i2;
            this.f4449f = z;
            this.f4450g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.p != null) {
                MutiImgDoubleLayout.this.p.a(view, this.f4448e, this.f4449f && this.f4450g);
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        r = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.q = linkedList;
            this.f4444h.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 2) {
                this.f4444h.setVisibility(0);
                this.f4445i.setConrers(15);
                l((MediaData) ListUtils.getItem(L0, 0), this.f4445i, true, false, false, 0);
                this.j.setConrers(15);
                l((MediaData) ListUtils.getItem(L0, 1), this.j, true, false, true, 1);
                return;
            }
            this.f4444h.setVisibility(8);
            return;
        }
        this.f4444h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> K1 = a2Var.K1();
        if (ListUtils.isEmpty(K1)) {
            this.f4443g.setVisibility(8);
            return;
        }
        this.f4443g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = K1.get(0);
        this.f4443g.setVoiceModel(voiceData$VoiceModel);
        this.f4443g.setTag(voiceData$VoiceModel);
        this.f4443g.b();
        if (voiceData$VoiceModel != null) {
            this.f4443g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4443g.m();
    }

    public final int g(int i2) {
        int i3 = this.o;
        if (i3 > 0) {
            return i3;
        }
        int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
        this.o = size;
        return size;
    }

    public b0<d.a.n0.r.q.a> getSubClickListener() {
        return this.m;
    }

    public final String h(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
    }

    public final void i() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4442f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4441e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4443g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        d.a.n0.b.g.b.b(this.f4443g, R.dimen.tbds28, R.dimen.tbds14);
        d.a.n0.b.g.b.k(this.f4441e, R.dimen.tbds7, R.dimen.tbds10);
        d.a.n0.b.g.b.k(this.f4442f, R.dimen.tbds7, R.dimen.tbds10);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.f4444h = relativeLayout;
        d.a.n0.b.g.b.b(relativeLayout, R.dimen.tbds20, R.dimen.tbds14);
        this.f4445i = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.j = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.p = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: j */
    public void a(d.a.n0.r.q.a aVar) {
        this.n = aVar;
        a2 i2 = aVar.i();
        ThreadCardUtils.setTitle(this.f4441e, i2);
        ThreadCardUtils.setAbstract(this.f4442f, this.f4441e, i2, r);
        setImageData(i2);
        setVoiceData(i2);
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        if (this.p != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof c) {
                ((c) onClickListener).a(i2, z, z2);
            } else {
                tbImageView.setOnClickListener(new c(i2, z, z2));
            }
        } else if (this.p != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i2) {
        String h2 = h(mediaData);
        int i3 = this.l ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.Q();
        }
        if (z) {
            tbImageView.setRadius(l.g(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
        }
        tbImageView.U(h2, i3, false);
        k(tbImageView, i2, z2, z3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int g2 = g(i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4445i.getLayoutParams();
        layoutParams.width = g2;
        layoutParams.height = g2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.width = g2;
        layoutParams2.height = g2;
        if (this.f4444h.getVisibility() != 8) {
            this.f4445i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public void setFromCDN(boolean z) {
        this.l = z;
    }

    public void setMarginsTop(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setPreloadSizeReadyCallback(d.a.c.k.c.b bVar) {
    }

    public void setSubClickListener(b0<d.a.n0.r.q.a> b0Var) {
        this.m = b0Var;
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = true;
        this.n = null;
        this.o = 0;
        i();
    }
}
