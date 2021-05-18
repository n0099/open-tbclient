package com.baidu.card.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.i.p;
import d.a.j0.r.u.c;
import d.a.k0.x.b0;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<d.a.j0.r.q.a> {

    /* renamed from: e  reason: collision with root package name */
    public Context f4526e;

    /* renamed from: f  reason: collision with root package name */
    public int f4527f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f4528g;

    /* renamed from: h  reason: collision with root package name */
    public View f4529h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f4530i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public RelativeLayout o;
    public boolean p;
    public b0<d.a.j0.r.q.a> q;
    public d.a.j0.r.q.a r;
    public View.OnClickListener s;
    public d.a.i.w0.a t;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoImageNoPlayerLayout.this.q != null) {
                b0 b0Var = VideoImageNoPlayerLayout.this.q;
                VideoImageNoPlayerLayout videoImageNoPlayerLayout = VideoImageNoPlayerLayout.this;
                b0Var.a(videoImageNoPlayerLayout.f4528g, videoImageNoPlayerLayout.r);
            }
            if (VideoImageNoPlayerLayout.this.s != null) {
                VideoImageNoPlayerLayout.this.s.onClick(VideoImageNoPlayerLayout.this.f4528g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoImageNoPlayerLayout.this.t.a(VideoImageNoPlayerLayout.this.r);
        }
    }

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.f4527f = 3;
        this.p = false;
        this.f4526e = context;
        f();
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.n = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.o = (RelativeLayout) findViewById(R.id.video_container);
        new WeakReference(TbadkCoreApplication.getInst());
        this.f4528g = (TbImageView) findViewById(R.id.video_thumbnail);
        this.f4529h = findViewById(R.id.video_thumbnail_mask);
        this.f4530i = (ImageView) findViewById(R.id.video_play);
        this.j = (ImageView) findViewById(R.id.video_pause);
        this.k = (TextView) findViewById(R.id.video_play_count);
        this.l = (TextView) findViewById(R.id.video_play_flag);
        this.m = (TextView) findViewById(R.id.video_duration);
        this.f4528g.setConrers(15);
        this.f4528g.setRadiusById(R.string.J_X05);
        this.f4528g.setDrawCorner(true);
        this.f4528g.setPlaceHolder(3);
        setOnClickListener(new a());
        SkinManager.setBackgroundResource(this, R.color.CAM_X0206);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: g */
    public void a(d.a.j0.r.q.a aVar) {
        if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = aVar.m().r1;
        originalThreadInfo.r.is_vertical.intValue();
        String str = originalThreadInfo.f12137f;
        originalThreadInfo.r.video_length.intValue();
        originalThreadInfo.r.video_duration.intValue();
        long j = originalThreadInfo.f12136e;
        this.m.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
        this.k.setText(String.format(this.f4526e.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
        this.l.setVisibility(8);
        this.f4528g.V(originalThreadInfo.r.thumbnail_url, 10, false);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.n;
    }

    public void h(TbPageContext tbPageContext, int i2) {
        if (this.f4527f != i2) {
            c.d(this.f4529h).o(R.array.Mask_X001);
            c.d(this.f4529h).k(R.string.J_X05);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
            this.f4530i.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        }
        this.f4527f = i2;
    }

    public final void i() {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new b());
        }
    }

    public void setCanCenterStart(boolean z) {
        this.p = z;
    }

    public void setData(d.a.j0.r.q.a aVar) {
        this.r = aVar;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setOnCardSubClickListener(b0<d.a.j0.r.q.a> b0Var) {
        this.q = b0Var;
    }

    public void setVideoAreaClickListener(d.a.i.w0.a aVar) {
        this.t = aVar;
        if (aVar != null) {
            i();
        }
    }
}
