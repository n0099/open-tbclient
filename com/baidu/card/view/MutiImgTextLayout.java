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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.b.c.e.p.l;
import d.b.c.j.c.b;
import d.b.i.p;
import d.b.i0.r.q.a2;
import d.b.j0.x.b0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MutiImgTextLayout extends LinearLayout implements p<d.b.i0.r.q.a> {
    public static final int k = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    /* renamed from: e  reason: collision with root package name */
    public TextView f4524e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4525f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4526g;

    /* renamed from: h  reason: collision with root package name */
    public b0<d.b.i0.r.q.a> f4527h;
    public d.b.i0.r.q.a i;
    public boolean j;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.b.i0.r.q.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
            if (subClickListener != null) {
                view.setTag("2");
                subClickListener.a(view, MutiImgTextLayout.this.i);
            }
        }
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    private void setVoiceData(a2 a2Var) {
        ArrayList<VoiceData$VoiceModel> H1 = a2Var.H1();
        if (ListUtils.isEmpty(H1)) {
            this.f4526g.setVisibility(8);
            return;
        }
        this.f4526g.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = H1.get(0);
        this.f4526g.setVoiceModel(voiceData$VoiceModel);
        this.f4526g.setTag(voiceData$VoiceModel);
        this.f4526g.b();
        if (voiceData$VoiceModel != null) {
            this.f4526g.k(voiceData$VoiceModel.voice_status.intValue());
        }
        this.f4526g.m();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f4525f = (TextView) findViewById(R.id.thread_card_abstract);
        this.f4524e = (TextView) findViewById(R.id.thread_card_title);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.f4526g = playVoiceBntNew;
        playVoiceBntNew.setAfterClickListener(new a());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: d */
    public void a(d.b.i0.r.q.a aVar) {
        this.i = aVar;
        a2 n = aVar.n();
        ThreadCardUtils.setTitle(this.f4524e, n, this.j);
        ThreadCardUtils.setAbstract(this.f4525f, this.f4524e, n, k, this.j);
        TextView textView = this.f4524e;
        boolean z = true;
        boolean z2 = textView == null || textView.getVisibility() != 0;
        TextView textView2 = this.f4525f;
        ThreadCardUtils.dealMainViewTopMargin(this.f4526g, z2 && (textView2 == null || textView2.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(n);
        PlayVoiceBntNew playVoiceBntNew = this.f4526g;
        if (playVoiceBntNew != null && playVoiceBntNew.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            TextView textView3 = this.f4525f;
            if (textView3 != null && textView3.getVisibility() == 0) {
                this.f4525f.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            }
            TextView textView4 = this.f4524e;
            if (textView4 == null || textView4.getVisibility() != 0) {
                return;
            }
            this.f4524e.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
            return;
        }
        TextView textView5 = this.f4524e;
        if (textView5 != null) {
            textView5.setPadding(0, 0, 0, 0);
        }
        TextView textView6 = this.f4525f;
        if (textView6 != null) {
            textView6.setPadding(0, 0, 0, 0);
        }
    }

    public b0<d.b.i0.r.q.a> getSubClickListener() {
        return this.f4527h;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setFrom(String str) {
    }

    public void setFromCDN(boolean z) {
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
        this.j = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    public void setSubClickListener(b0<d.b.i0.r.q.a> b0Var) {
        this.f4527h = b0Var;
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = null;
        this.j = false;
        c();
    }
}
