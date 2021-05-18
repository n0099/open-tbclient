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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.j0.b1.j.d;
import d.a.j0.r.k;
import d.a.j0.r.q.a2;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<d.a.j0.r.q.a> {
    public static final int s;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4430e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4431f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4432g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4433h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4434i;
    public TbImageView j;
    public TbImageView k;
    public String l;
    public boolean m;
    public b0<d.a.j0.r.q.a> n;
    public d.a.j0.r.q.a o;
    public int p;
    public d q;
    public LinkedList<MediaData> r;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.j0.r.q.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MutiImgMoreLayout.this.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {
        public b() {
        }

        @Override // d.a.j0.b1.j.d
        public void a(View view, int i2, boolean z) {
            b0<d.a.j0.r.q.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgMoreLayout.this.o.objType = 2;
                subClickListener.a(view, MutiImgMoreLayout.this.o);
                MutiImgMoreLayout.this.o.objType = 1;
            }
            ThreadCardUtils.startImageViewer(view, MutiImgMoreLayout.this.m, MutiImgMoreLayout.this.r, i2, MutiImgMoreLayout.this.o.m(), MutiImgMoreLayout.this.l);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f4437e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4438f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4439g;

        public c(int i2, boolean z, boolean z2) {
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            this.f4437e = i2;
            this.f4438f = z;
            this.f4439g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.q != null) {
                MutiImgMoreLayout.this.q.a(view, this.f4437e, this.f4438f && this.f4439g);
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        s = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < K0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.r = linkedList;
            boolean z = linkedList.size() > 3;
            this.f4433h.setVisibility(8);
            if (ListUtils.getCount(linkedList) >= 3) {
                this.f4433h.setVisibility(0);
                this.f4434i.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 0), this.f4434i, R.string.J_X12, false, false, 0);
                this.j.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 1), this.j, R.string.J_X02, false, false, 1);
                this.k.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 2), this.k, R.string.J_X11, z, true, 2);
                return;
            }
            this.f4433h.setVisibility(8);
            return;
        }
        this.f4433h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> I1 = a2Var.I1();
        if (ListUtils.isEmpty(I1)) {
            this.f4432g.setVisibility(8);
            return;
        }
        this.f4432g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = I1.get(0);
        this.f4432g.setVoiceModel(voiceData$VoiceModel);
        this.f4432g.setTag(voiceData$VoiceModel);
        this.f4432g.b();
        if (voiceData$VoiceModel != null) {
            this.f4432g.j(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4432g.l();
    }

    public final int g(int i2) {
        int i3 = this.p;
        if (i3 > 0) {
            return i3;
        }
        int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
        this.p = size;
        return size;
    }

    public b0<d.a.j0.r.q.a> getSubClickListener() {
        return this.n;
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4431f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4430e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4432g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.f4433h = relativeLayout;
        d.a.j0.b.g.b.b(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
        this.f4434i = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.j = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.k = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.q = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: j */
    public void a(d.a.j0.r.q.a aVar) {
        this.o = aVar;
        a2 m = aVar.m();
        ThreadCardUtils.setTitle(this.f4430e, m);
        ThreadCardUtils.setAbstract(this.f4431f, this.f4430e, m, s);
        TextView textView = this.f4430e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4431f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        RelativeLayout relativeLayout = this.f4433h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(m);
        setVoiceData(m);
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        if (this.q != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof c) {
                ((c) onClickListener).a(i2, z, z2);
            } else {
                tbImageView.setOnClickListener(new c(i2, z, z2));
            }
        } else if (this.q != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, int i2, boolean z, boolean z2, int i3) {
        String h2 = h(mediaData);
        int i4 = this.m ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.Q();
        }
        tbImageView.setRadiusById(i2);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.V(h2, i4, false);
        k(tbImageView, i3, z, z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int g2 = g(i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4434i.getLayoutParams();
        layoutParams.width = g2;
        layoutParams.height = g2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.width = g2;
        layoutParams2.height = g2;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams3.width = g2;
        layoutParams3.height = g2;
        if (this.f4433h.getVisibility() != 8) {
            this.f4434i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
            this.k.setLayoutParams(layoutParams3);
        }
    }

    public void setFrom(String str) {
        this.l = str;
    }

    public void setFromCDN(boolean z) {
        this.m = z;
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

    public void setPreloadSizeReadyCallback(d.a.c.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.a.j0.r.q.a> b0Var) {
        this.n = b0Var;
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = true;
        this.o = null;
        this.p = 0;
        i();
    }
}
