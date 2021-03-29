package com.baidu.card.view;

import android.content.Context;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.b.g.b;
import d.b.h0.r.k;
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
import d.b.i.p;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<a> {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    public static final int k;
    public static final int l;
    public static final int m;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4474e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f4475f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f4476g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4477h;
    public b0<a> i;

    static {
        int k2 = l.k(TbadkCoreApplication.getInst());
        k = k2;
        int i = k2 - j;
        l = i;
        m = i / 2;
    }

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        ArrayList<MediaData> K0 = a2Var.K0();
        if (k.c().g() && ListUtils.getCount(K0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.f4475f.setVisibility(8);
            this.f4476g.setVisibility(8);
            if (ListUtils.getCount(linkedList) > 0) {
                this.f4475f.setVisibility(0);
                this.f4476g.setVisibility(0);
                this.f4475f.setConrers(15);
                e((MediaData) ListUtils.getItem(K0, 0), this.f4475f, true, false, true, 0);
                return;
            }
            this.f4475f.setVisibility(8);
            this.f4476g.setVisibility(8);
            return;
        }
        this.f4475f.setVisibility(8);
        this.f4476g.setVisibility(8);
    }

    public final String b(MediaData mediaData) {
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

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, m));
        TextView textView = (TextView) findViewById(R.id.thread_card_title);
        this.f4474e = textView;
        b.k(textView, R.dimen.tbds7, R.dimen.tbds10);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.f4475f = tbImageView;
        b.b(tbImageView, R.dimen.tbds26, R.dimen.tbds14);
        this.f4476g = (ImageView) findViewById(R.id.play_btn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: d */
    public void a(a aVar) {
        a2 n = aVar.n();
        ThreadCardUtils.setTitle(this.f4474e, n);
        setImageData(n);
    }

    public final void e(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String b2 = b(mediaData);
        int i2 = this.f4477h ? 13 : 14;
        if (!StringHelper.equals(b2, tbImageView.getUrl())) {
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
        tbImageView.W(b2, i2, false);
    }

    public b0<a> getSubClickListener() {
        return this.i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setFromCDN(boolean z) {
        this.f4477h = z;
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

    public void setSubClickListener(b0<a> b0Var) {
        this.i = b0Var;
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4477h = true;
        c();
    }
}
