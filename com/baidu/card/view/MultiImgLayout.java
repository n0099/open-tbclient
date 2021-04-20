package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.b.c.e.p.l;
import d.b.h0.b1.j.d;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.i.p;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<d.b.h0.r.q.a> {
    public static final int n;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4460e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4461f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4462g;

    /* renamed from: h  reason: collision with root package name */
    public ConstrainImageGroup f4463h;
    public String i;
    public boolean j;
    public b0<d.b.h0.r.q.a> k;
    public d.b.h0.r.q.a l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.h0.r.q.a> subClickListener = MultiImgLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MultiImgLayout.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f4465a;

        public b(LinkedList linkedList) {
            this.f4465a = linkedList;
        }

        @Override // d.b.h0.b1.j.d
        public void a(View view, int i, boolean z) {
            if (MultiImgLayout.this.k == null || !MultiImgLayout.this.k.c(view, MultiImgLayout.this.l, "")) {
                b0<d.b.h0.r.q.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgLayout.this.l.objType = 2;
                    subClickListener.f63759a = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgLayout.this.l);
                    MultiImgLayout.this.l.objType = 1;
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                    ThreadCardUtils.startImageViewer(view, MultiImgLayout.this.j, this.f4465a, i, MultiImgLayout.this.l.n(), MultiImgLayout.this.i);
                } else if ("frs".equals(MultiImgLayout.this.i)) {
                    ThreadCardUtils.jumpToPB(MultiImgLayout.this.l, view.getContext(), 3, false);
                } else if ("index".equals(MultiImgLayout.this.i)) {
                    ThreadCardUtils.jumpToPB(MultiImgLayout.this.l, view.getContext(), 2, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, MultiImgLayout.this.j, this.f4465a, i, MultiImgLayout.this.l.n(), MultiImgLayout.this.i);
                }
            }
        }
    }

    static {
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        n = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        this.f4463h.setFromCDN(this.j);
        this.f4463h.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (ListUtils.getCount(linkedList) > 0) {
                this.f4463h.setVisibility(0);
                this.f4463h.setFromCDN(this.j);
                this.f4463h.setImageClickListener(new b(linkedList));
                this.f4463h.setImageMediaList(linkedList);
                return;
            }
            this.f4463h.setVisibility(8);
            return;
        }
        this.f4463h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.f4462g.setVisibility(8);
            return;
        }
        this.f4462g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4462g.setVoiceModel(voiceData$VoiceModel);
        this.f4462g.setTag(voiceData$VoiceModel);
        this.f4462g.b();
        if (voiceData$VoiceModel != null) {
            this.f4462g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4462g.m();
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4461f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4460e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4462g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        this.f4463h = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.f4463h.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        d.b.h0.b1.j.a aVar = new d.b.h0.b1.j.a(3);
        aVar.d(1.0d);
        this.f4463h.setImageProcessor(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: g */
    public void a(d.b.h0.r.q.a aVar) {
        this.l = aVar;
        a2 n2 = aVar.n();
        ThreadCardUtils.setTitle(this.f4460e, n2, this.m);
        ThreadCardUtils.setAbstract(this.f4461f, this.f4460e, n2, n, this.m);
        TextView textView = this.f4460e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4461f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.f4463h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(n2);
        setVoiceData(n2);
    }

    public b0<d.b.h0.r.q.a> getSubClickListener() {
        return this.k;
    }

    public void setConstrainImagePool(d.b.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.f4463h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void setConstrainLayoutPool(d.b.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.f4463h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public void setFrom(String str) {
        this.i = str;
    }

    public void setFromCDN(boolean z) {
        this.j = z;
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

    public void setNeedFrsTabName(boolean z) {
        this.m = z;
    }

    public void setPreloadSizeReadyCallback(d.b.c.j.c.b bVar) {
        this.f4463h.setPreloadSizeReadyCallback(bVar);
    }

    public void setSingleImageRatio(double d2) {
        ConstrainImageGroup constrainImageGroup = this.f4463h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setSingleImageRatio(d2);
        }
    }

    public void setSubClickListener(b0<d.b.h0.r.q.a> b0Var) {
        this.k = b0Var;
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.l = null;
        this.m = false;
        f();
    }
}
