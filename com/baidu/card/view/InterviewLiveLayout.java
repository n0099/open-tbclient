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
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.m0.a0.c;
import d.a.m0.r.k;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.y1;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class InterviewLiveLayout extends FrameLayout implements p<d.a.m0.r.q.a> {

    /* renamed from: e  reason: collision with root package name */
    public int f4414e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4415f;

    /* renamed from: g  reason: collision with root package name */
    public b0<d.a.m0.r.q.a> f4416g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.r.q.a f4417h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4418i;
    public LinearLayout j;
    public ImageView k;
    public TextView l;
    public ArrayList<String> m;
    public a2 n;
    public long o;
    public String p;
    public View.OnClickListener q;
    public TbImageView.g r;

    /* loaded from: classes.dex */
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
                    imageUrlData.urlType = InterviewLiveLayout.this.f4415f ? 13 : 14;
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
                    bVar.C(InterviewLiveLayout.this.f4415f);
                    bVar.J(str);
                    bVar.F(false);
                    bVar.w(concurrentHashMap);
                    bVar.H(false);
                    bVar.N(InterviewLiveLayout.this.n);
                    bVar.I(false);
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
                    if (InterviewLiveLayout.this.f4416g != null) {
                        InterviewLiveLayout.this.f4416g.a(InterviewLiveLayout.this.f4418i, InterviewLiveLayout.this.f4417h);
                        return;
                    }
                    return;
                }
                l.L(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TbImageView.g {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            if (tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.k.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), InterviewLiveLayout.this.f4415f ? 13 : 14));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.I() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f5 = height;
                    f6 = i2;
                } else {
                    f5 = width;
                    f6 = i3;
                }
                float f7 = f5 / f6;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f2 = height / i2;
                    f4 = (width - (i3 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i3;
                    f3 = (height - (i2 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (i2 > i3) {
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
        this.f4418i = tbImageView;
        tbImageView.z(15);
        this.f4418i.setPlaceHolder(3);
        this.j = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.k = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.l = (TextView) findViewById(R.id.interview_live_tip);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: k */
    public void a(d.a.m0.r.q.a aVar) {
        this.f4417h = aVar;
        if (aVar != null && this.f4418i != null) {
            a2 i2 = aVar.i();
            y1 q1 = i2.q1();
            if (q1 == null) {
                setVisibility(8);
                return;
            }
            this.n = i2;
            this.o = i2.c0();
            this.p = q1.f();
            if (k.c().g() && q1 != null && !StringUtils.isNull(q1.i())) {
                this.m.clear();
                this.m.add(q1.i());
                setVisibility(0);
                this.f4418i.setSupportNoImage(true);
                this.f4418i.setScaleType(ImageView.ScaleType.MATRIX);
                this.f4418i.setOnDrawListener(this.r);
                this.f4418i.U(q1.i(), this.f4415f ? 13 : 14, false);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                int k = l.k(getContext()) - l.g(getContext(), R.dimen.tbds88);
                layoutParams.width = k;
                layoutParams.height = (int) ((k * 428.0f) / 760.0f);
                setLayoutParams(layoutParams);
            } else {
                setVisibility(8);
            }
            this.f4418i.setOnClickListener(this.q);
            return;
        }
        setVisibility(8);
    }

    public void l(int i2) {
        if (i2 != this.f4414e) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
            SkinManager.setImageResource(this.k, R.drawable.interview_live_circle_share);
            SkinManager.setBackgroundResource(this.j, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setFromCDN(boolean z) {
        this.f4415f = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView = this.f4418i;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
    }

    public void setSubClickListener(b0<d.a.m0.r.q.a> b0Var) {
        this.f4416g = b0Var;
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4414e = 3;
        this.f4415f = true;
        this.f4417h = null;
        this.m = new ArrayList<>();
        this.q = new a();
        this.r = new b();
        j();
    }
}
