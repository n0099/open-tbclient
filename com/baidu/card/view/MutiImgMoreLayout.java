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
import d.b.c.e.p.l;
import d.b.i.p;
import d.b.i0.b1.j.d;
import d.b.i0.r.k;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<d.b.i0.r.q.a> {
    public static final int s;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4488e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4489f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4490g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4491h;
    public TbImageView i;
    public TbImageView j;
    public TbImageView k;
    public String l;
    public boolean m;
    public b0<d.b.i0.r.q.a> n;
    public d.b.i0.r.q.a o;
    public int p;
    public d q;
    public LinkedList<MediaData> r;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.i0.r.q.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
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

        @Override // d.b.i0.b1.j.d
        public void a(View view, int i, boolean z) {
            b0<d.b.i0.r.q.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("1");
                MutiImgMoreLayout.this.o.objType = 2;
                subClickListener.a(view, MutiImgMoreLayout.this.o);
                MutiImgMoreLayout.this.o.objType = 1;
            }
            ThreadCardUtils.startImageViewer(view, MutiImgMoreLayout.this.m, MutiImgMoreLayout.this.r, i, MutiImgMoreLayout.this.o.n(), MutiImgMoreLayout.this.l);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f4494e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4495f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4496g;

        public c(int i, boolean z, boolean z2) {
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            this.f4494e = i;
            this.f4495f = z;
            this.f4496g = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.q != null) {
                MutiImgMoreLayout.this.q.a(view, this.f4494e, this.f4495f && this.f4496g);
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
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.r = linkedList;
            boolean z = linkedList.size() > 3;
            this.f4491h.setVisibility(8);
            if (ListUtils.getCount(linkedList) >= 3) {
                this.f4491h.setVisibility(0);
                this.i.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 0), this.i, R.string.J_X12, false, false, 0);
                this.j.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 1), this.j, R.string.J_X02, false, false, 1);
                this.k.setConrers(15);
                l((MediaData) ListUtils.getItem(K0, 2), this.k, R.string.J_X11, z, true, 2);
                return;
            }
            this.f4491h.setVisibility(8);
            return;
        }
        this.f4491h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.f4490g.setVisibility(8);
            return;
        }
        this.f4490g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4490g.setVoiceModel(voiceData$VoiceModel);
        this.f4490g.setTag(voiceData$VoiceModel);
        this.f4490g.b();
        if (voiceData$VoiceModel != null) {
            this.f4490g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4490g.m();
    }

    public final int g(int i) {
        int i2 = this.p;
        if (i2 > 0) {
            return i2;
        }
        int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
        this.p = size;
        return size;
    }

    public b0<d.b.i0.r.q.a> getSubClickListener() {
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
        this.f4489f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4488e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4490g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.f4491h = relativeLayout;
        d.b.i0.b.g.b.b(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
        this.i = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.j = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.k = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.q = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: j */
    public void a(d.b.i0.r.q.a aVar) {
        this.o = aVar;
        a2 n = aVar.n();
        ThreadCardUtils.setTitle(this.f4488e, n);
        ThreadCardUtils.setAbstract(this.f4489f, this.f4488e, n, s);
        TextView textView = this.f4488e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4489f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        RelativeLayout relativeLayout = this.f4491h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(n);
        setVoiceData(n);
    }

    public final void k(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.q != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof c) {
                ((c) onClickListener).a(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new c(i, z, z2));
            }
        } else if (this.q != null || tbImageView == null) {
        } else {
            tbImageView.setClickable(false);
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, int i, boolean z, boolean z2, int i2) {
        String h2 = h(mediaData);
        int i3 = this.m ? 13 : 14;
        if (!StringHelper.equals(h2, tbImageView.getUrl())) {
            tbImageView.S();
        }
        tbImageView.setRadiusById(i);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.W(h2, i3, false);
        k(tbImageView, i2, z, z2);
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
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams3.width = g2;
        layoutParams3.height = g2;
        if (this.f4491h.getVisibility() != 8) {
            this.i.setLayoutParams(layoutParams);
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

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setPreloadSizeReadyCallback(d.b.c.j.c.b bVar) {
    }

    public void setSubClickListener(b0<d.b.i0.r.q.a> b0Var) {
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
