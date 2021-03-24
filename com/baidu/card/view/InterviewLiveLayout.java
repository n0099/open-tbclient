package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.l.d;
import d.b.b.e.p.l;
import d.b.h0.a0.c;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.y1;
import d.b.i.p;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class InterviewLiveLayout extends FrameLayout implements p<d.b.h0.r.q.a> {

    /* renamed from: e  reason: collision with root package name */
    public int f4418e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4419f;

    /* renamed from: g  reason: collision with root package name */
    public b0<d.b.h0.r.q.a> f4420g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.r.q.a f4421h;
    public TbImageView i;
    public LinearLayout j;
    public ImageView k;
    public TextView l;
    public ArrayList<String> m;
    public a2 n;
    public long o;
    public String p;
    public View.OnClickListener q;
    public TbImageView.g r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ListUtils.getCount(InterviewLiveLayout.this.m) > 0) {
                if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                    String str = (String) InterviewLiveLayout.this.m.get(0);
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = InterviewLiveLayout.this.f4419f ? 13 : 14;
                    imageUrlData.imageUrl = str;
                    imageUrlData.originalUrl = str;
                    imageUrlData.originalSize = 0L;
                    imageUrlData.isLongPic = false;
                    imageUrlData.mIsShowOrigonButton = false;
                    imageUrlData.threadId = 0L;
                    imageUrlData.postId = 0L;
                    concurrentHashMap.put(str, imageUrlData);
                    ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                    bVar.x(InterviewLiveLayout.this.m);
                    bVar.C(InterviewLiveLayout.this.f4419f);
                    bVar.K(str);
                    bVar.G(false);
                    bVar.w(concurrentHashMap);
                    bVar.I(false);
                    bVar.O(InterviewLiveLayout.this.n);
                    bVar.J(false);
                    ImageViewerConfig v = bVar.v(InterviewLiveLayout.this.getContext());
                    v.getIntent().putExtra("from", "frs");
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    v.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                    StatisticItem statisticItem = new StatisticItem("c13327");
                    statisticItem.param("fid", InterviewLiveLayout.this.o);
                    statisticItem.param("obj_id", InterviewLiveLayout.this.p);
                    TiebaStatic.log(statisticItem);
                    if (InterviewLiveLayout.this.f4420g != null) {
                        InterviewLiveLayout.this.f4420g.a(InterviewLiveLayout.this.i, InterviewLiveLayout.this.f4421h);
                        return;
                    }
                    return;
                }
                l.K(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TbImageView.g {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            if (tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.b.b.j.d.a l = c.j().l(d.h().g(tbImageView.getUrl(), InterviewLiveLayout.this.f4419f ? 13 : 14));
            int i2 = 0;
            if (l != null) {
                i2 = l.r();
                i = l.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.J() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f5 = height;
                    f6 = i;
                } else {
                    f5 = width;
                    f6 = i2;
                }
                float f7 = f5 / f6;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f2 = height / i;
                    f4 = (width - (i2 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i2;
                    f3 = (height - (i * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (i > i2) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public final void j() {
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TbImageView tbImageView = (TbImageView) findViewById(R.id.img_interview_live);
        this.i = tbImageView;
        tbImageView.A(15);
        this.i.setPlaceHolder(3);
        this.j = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.k = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.l = (TextView) findViewById(R.id.interview_live_tip);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: k */
    public void a(d.b.h0.r.q.a aVar) {
        this.f4421h = aVar;
        if (aVar != null && this.i != null) {
            a2 n = aVar.n();
            y1 o1 = n.o1();
            if (o1 == null) {
                setVisibility(8);
                return;
            }
            this.n = n;
            this.o = n.c0();
            this.p = o1.f();
            if (k.c().g() && o1 != null && !StringUtils.isNull(o1.i())) {
                this.m.clear();
                this.m.add(o1.i());
                setVisibility(0);
                this.i.setSupportNoImage(true);
                this.i.setScaleType(ImageView.ScaleType.MATRIX);
                this.i.setOnDrawListener(this.r);
                this.i.W(o1.i(), this.f4419f ? 13 : 14, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                int k = l.k(getContext()) - l.g(getContext(), R.dimen.tbds88);
                layoutParams.width = k;
                layoutParams.height = (int) ((k * 428.0f) / 760.0f);
                setLayoutParams(layoutParams);
            } else {
                setVisibility(8);
            }
            this.i.setOnClickListener(this.q);
            return;
        }
        setVisibility(8);
    }

    public void l(int i) {
        if (i != this.f4418e) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
            SkinManager.setImageResource(this.k, R.drawable.interview_live_circle_share);
            SkinManager.setBackgroundResource(this.j, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setFromCDN(boolean z) {
        this.f4419f = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView = this.i;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
    }

    public void setSubClickListener(b0<d.b.h0.r.q.a> b0Var) {
        this.f4420g = b0Var;
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4418e = 3;
        this.f4419f = true;
        this.f4421h = null;
        this.m = new ArrayList<>();
        this.q = new a();
        this.r = new b();
        j();
    }
}
