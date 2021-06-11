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
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.m0.b.g.b;
import d.a.m0.r.k;
import d.a.m0.r.q.a;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<a> {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    public static final int k;
    public static final int l;
    public static final int m;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4475e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f4476f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f4477g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4478h;

    /* renamed from: i  reason: collision with root package name */
    public b0<a> f4479i;

    static {
        int k2 = l.k(TbadkCoreApplication.getInst());
        k = k2;
        int i2 = k2 - j;
        l = i2;
        m = i2 / 2;
    }

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    private void setImageData(a2 a2Var) {
        ArrayList<MediaData> L0 = a2Var.L0();
        if (k.c().g() && ListUtils.getCount(L0) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < L0.size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(L0, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.f4476f.setVisibility(8);
            this.f4477g.setVisibility(8);
            if (ListUtils.getCount(linkedList) > 0) {
                this.f4476f.setVisibility(0);
                this.f4477g.setVisibility(0);
                this.f4476f.setConrers(15);
                e((MediaData) ListUtils.getItem(L0, 0), this.f4476f, true, false, true, 0);
                return;
            }
            this.f4476f.setVisibility(8);
            this.f4477g.setVisibility(8);
            return;
        }
        this.f4476f.setVisibility(8);
        this.f4477g.setVisibility(8);
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
        this.f4475e = textView;
        b.k(textView, R.dimen.tbds7, R.dimen.tbds10);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.f4476f = tbImageView;
        b.b(tbImageView, R.dimen.tbds26, R.dimen.tbds14);
        this.f4477g = (ImageView) findViewById(R.id.play_btn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: d */
    public void a(a aVar) {
        a2 i2 = aVar.i();
        ThreadCardUtils.setTitle(this.f4475e, i2);
        setImageData(i2);
    }

    public final void e(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i2) {
        String b2 = b(mediaData);
        int i3 = this.f4478h ? 46 : 47;
        if (!StringHelper.equals(b2, tbImageView.getUrl())) {
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
        tbImageView.U(b2, i3, false);
    }

    public b0<a> getSubClickListener() {
        return this.f4479i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setFromCDN(boolean z) {
        this.f4478h = z;
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

    public void setSubClickListener(b0<a> b0Var) {
        this.f4479i = b0Var;
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4478h = true;
        c();
    }
}
