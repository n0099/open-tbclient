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
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.m0.b1.j.d;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<d.a.m0.r.q.a> {
    public static final int n;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4402e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4403f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4404g;

    /* renamed from: h  reason: collision with root package name */
    public ConstrainImageGroup f4405h;

    /* renamed from: i  reason: collision with root package name */
    public String f4406i;
    public boolean j;
    public b0<d.a.m0.r.q.a> k;
    public d.a.m0.r.q.a l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.m0.r.q.a> subClickListener = MultiImgLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MultiImgLayout.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinkedList f4408a;

        public b(LinkedList linkedList) {
            this.f4408a = linkedList;
        }

        @Override // d.a.m0.b1.j.d
        public void a(View view, int i2, boolean z) {
            if (MultiImgLayout.this.k == null || !MultiImgLayout.this.k.c(view, MultiImgLayout.this.l, "")) {
                b0<d.a.m0.r.q.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgLayout.this.l.objType = 2;
                    subClickListener.f63445a = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgLayout.this.l);
                    MultiImgLayout.this.l.objType = 1;
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().q) {
                    ThreadCardUtils.startImageViewer(view, MultiImgLayout.this.j, this.f4408a, i2, MultiImgLayout.this.l.m(), MultiImgLayout.this.f4406i);
                } else if ("frs".equals(MultiImgLayout.this.f4406i)) {
                    ThreadCardUtils.jumpToPB(MultiImgLayout.this.l, view.getContext(), 3, false);
                } else if ("index".equals(MultiImgLayout.this.f4406i)) {
                    ThreadCardUtils.jumpToPB(MultiImgLayout.this.l, view.getContext(), 2, false);
                } else {
                    ThreadCardUtils.startImageViewer(view, MultiImgLayout.this.j, this.f4408a, i2, MultiImgLayout.this.l.m(), MultiImgLayout.this.f4406i);
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
        this.f4405h.setFromCDN(this.j);
        this.f4405h.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (ListUtils.getCount(linkedList) > 0) {
                this.f4405h.setVisibility(0);
                this.f4405h.setFromCDN(this.j);
                this.f4405h.setImageClickListener(new b(linkedList));
                this.f4405h.setImageMediaList(linkedList);
                return;
            }
            this.f4405h.setVisibility(8);
            return;
        }
        this.f4405h.setVisibility(8);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> J1 = a2Var.J1();
        if (ListUtils.isEmpty(J1)) {
            this.f4404g.setVisibility(8);
            return;
        }
        this.f4404g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = J1.get(0);
        this.f4404g.setVoiceModel(voiceData$VoiceModel);
        this.f4404g.setTag(voiceData$VoiceModel);
        this.f4404g.b();
        if (voiceData$VoiceModel != null) {
            this.f4404g.j(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4404g.l();
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4403f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4402e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4404g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
        this.f4405h = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.f4405h.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        d.a.m0.b1.j.a aVar = new d.a.m0.b1.j.a(3);
        aVar.d(1.0d);
        this.f4405h.setImageProcessor(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: g */
    public void a(d.a.m0.r.q.a aVar) {
        this.l = aVar;
        a2 m = aVar.m();
        ThreadCardUtils.setTitle(this.f4402e, m, this.m);
        ThreadCardUtils.setAbstract(this.f4403f, this.f4402e, m, n, this.m);
        TextView textView = this.f4402e;
        boolean z = false;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4403f;
        boolean z3 = textView2 == null || textView2.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.f4405h;
        if (z2 && z3) {
            z = true;
        }
        ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(m);
        setVoiceData(m);
    }

    public b0<d.a.m0.r.q.a> getSubClickListener() {
        return this.k;
    }

    public void setConstrainImagePool(d.a.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.f4405h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void setConstrainLayoutPool(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.f4405h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public void setFrom(String str) {
        this.f4406i = str;
    }

    public void setFromCDN(boolean z) {
        this.j = z;
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

    public void setNeedFrsTabName(boolean z) {
        this.m = z;
    }

    public void setPreloadSizeReadyCallback(d.a.c.j.c.b bVar) {
        this.f4405h.setPreloadSizeReadyCallback(bVar);
    }

    public void setSingleImageRatio(double d2) {
        ConstrainImageGroup constrainImageGroup = this.f4405h;
        if (constrainImageGroup != null) {
            constrainImageGroup.setSingleImageRatio(d2);
        }
    }

    public void setSubClickListener(b0<d.a.m0.r.q.a> b0Var) {
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
