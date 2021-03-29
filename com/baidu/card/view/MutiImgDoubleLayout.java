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
import d.b.b.e.p.l;
import d.b.h0.b1.j.d;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.i.p;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<d.b.h0.r.q.a> {
    public static final int r;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4443e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4444f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4445g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4446h;
    public TbImageView i;
    public TbImageView j;
    public String k;
    public boolean l;
    public b0<d.b.h0.r.q.a> m;
    public d.b.h0.r.q.a n;
    public int o;
    public d p;
    public LinkedList<MediaData> q;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.h0.r.q.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
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

        @Override // d.b.h0.b1.j.d
        public void a(View view, int i, boolean z) {
            b0<d.b.h0.r.q.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgDoubleLayout.this.n.objType = 2;
                subClickListener.a(view, MutiImgDoubleLayout.this.n);
                MutiImgDoubleLayout.this.n.objType = 1;
            }
            ThreadCardUtils.startImageViewer(view, MutiImgDoubleLayout.this.l, MutiImgDoubleLayout.this.q, i, MutiImgDoubleLayout.this.n.n(), MutiImgDoubleLayout.this.k);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f4449e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4450f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4451g;

        public c(int i, boolean z, boolean z2) {
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            this.f4449e = i;
            this.f4450f = z;
            this.f4451g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.p != null) {
                MutiImgDoubleLayout.this.p.a(view, this.f4449e, this.f4450f && this.f4451g);
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
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.q = linkedList;
            this.f4446h.setVisibility(8);
            if (ListUtils.getCount(linkedList) == 2) {
                this.f4446h.setVisibility(0);
                this.i.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 0), this.i, true, false, false, 0);
                this.j.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 1), this.j, true, false, true, 1);
                return;
            }
            this.f4446h.setVisibility(8);
            return;
        }
        this.f4446h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.f4445g.setVisibility(8);
            return;
        }
        this.f4445g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4445g.setVoiceModel(voiceData$VoiceModel);
        this.f4445g.setTag(voiceData$VoiceModel);
        this.f4445g.d();
        if (voiceData$VoiceModel != null) {
            this.f4445g.m(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4445g.o();
    }

    public final int g(int i) {
        int i2 = this.o;
        if (i2 > 0) {
            return i2;
        }
        int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
        this.o = size;
        return size;
    }

    public b0<d.b.h0.r.q.a> getSubClickListener() {
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
        this.f4444f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4443e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4445g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        d.b.h0.b.g.b.b(this.f4445g, R.dimen.tbds28, R.dimen.tbds14);
        d.b.h0.b.g.b.k(this.f4443e, R.dimen.tbds7, R.dimen.tbds10);
        d.b.h0.b.g.b.k(this.f4444f, R.dimen.tbds7, R.dimen.tbds10);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.f4446h = relativeLayout;
        d.b.h0.b.g.b.b(relativeLayout, R.dimen.tbds20, R.dimen.tbds14);
        this.i = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.j = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.p = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: j */
    public void a(d.b.h0.r.q.a aVar) {
        this.n = aVar;
        a2 n = aVar.n();
        ThreadCardUtils.setTitle(this.f4443e, n);
        ThreadCardUtils.setAbstract(this.f4444f, this.f4443e, n, r);
        setImageData(n);
        setVoiceData(n);
    }

    public final void k(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.p != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof c) {
                ((c) onClickListener).a(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new c(i, z, z2));
            }
        } else if (this.p != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String h2 = h(mediaData);
        int i2 = this.l ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.S();
        }
        if (z) {
            tbImageView.setRadius(l.g(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
        }
        tbImageView.W(h2, i2, false);
        k(tbImageView, i, z2, z3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int g2 = g(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = g2;
        layoutParams.height = g2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.width = g2;
        layoutParams2.height = g2;
        if (this.f4446h.getVisibility() != 8) {
            this.i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
        }
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public void setFromCDN(boolean z) {
        this.l = z;
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setPreloadSizeReadyCallback(d.b.b.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.b.h0.r.q.a> b0Var) {
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
