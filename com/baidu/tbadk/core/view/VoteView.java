package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class VoteView extends LinearLayout {
    public static final int C = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    public static final int D = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    public static final int E = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    public static final float[] F;
    public static final float[] G;
    public static final float[] H;
    public View.OnClickListener A;
    public RecyclerView.Adapter<e> B;

    /* renamed from: e  reason: collision with root package name */
    public Context f13199e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f13200f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13201g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13202h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f13203i;
    public RecyclerView j;
    public View k;
    public TextView l;
    public String m;
    public long n;
    public PollData o;
    public List<PollOptionData> p;
    public List<Integer> q;
    public View.OnClickListener r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public AddPollPostModel y;
    public AddPollPostModel.b z;

    /* loaded from: classes3.dex */
    public class a implements AddPollPostModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.model.AddPollPostModel.b
        public void a(int i2, String str) {
            if (i2 != 0) {
                if (StringUtils.isNull(str)) {
                    return;
                }
                VoteView.this.f13200f.showToast(str);
                return;
            }
            VoteView.this.l.setText(VoteView.this.f13199e.getString(R.string.pb_voted_text));
            PollData pollData = VoteView.this.o;
            VoteView voteView = VoteView.this;
            pollData.setPolledValue(voteView.z(voteView.q));
            VoteView.this.o.setIsPolled(1);
            VoteView voteView2 = VoteView.this;
            voteView2.s = voteView2.o.getIsPolled() == 1;
            VoteView.this.o.setTotalNum(VoteView.this.o.getTotalNum() + 1);
            VoteView voteView3 = VoteView.this;
            voteView3.setVoteSubContent(voteView3.getSubContent());
            VoteView.this.o.setTotalPoll(VoteView.this.o.getTotalPoll() + VoteView.this.q.size());
            if (VoteView.this.B != null) {
                VoteView.this.B.notifyDataSetChanged();
            }
            VoteView.this.H();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VoteView voteView = VoteView.this;
            String z = voteView.z(voteView.q);
            if (VoteView.this.f13200f == null || VoteView.this.y == null || StringUtils.isNull(VoteView.this.m) || VoteView.this.z == null || StringUtils.isNull(z) || VoteView.this.o == null) {
                return;
            }
            VoteView.this.y.x(d.a.c.e.m.b.f(VoteView.this.m, -1L));
            VoteView.this.y.w(VoteView.this.z);
            VoteView.this.y.u(VoteView.this.m, z, VoteView.this.n);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.Adapter<e> {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f13207e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f13208f;

            public a(e eVar, int i2) {
                this.f13207e = eVar;
                this.f13208f = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VoteView voteView = VoteView.this;
                voteView.D(this.f13207e, !voteView.q.contains(Integer.valueOf(((PollOptionData) VoteView.this.p.get(this.f13208f)).getId())));
                if (!VoteView.this.q.contains(Integer.valueOf(((PollOptionData) VoteView.this.p.get(this.f13208f)).getId()))) {
                    VoteView.this.q.add(Integer.valueOf(((PollOptionData) VoteView.this.p.get(this.f13208f)).getId()));
                    PollData pollData = VoteView.this.o;
                    VoteView voteView2 = VoteView.this;
                    pollData.setPolledValue(voteView2.z(voteView2.q));
                    ((PollOptionData) VoteView.this.p.get(this.f13208f)).setNum(((PollOptionData) VoteView.this.p.get(this.f13208f)).getNum() + 1);
                    VoteView.this.o.getOptions().get(this.f13208f).setNum(((PollOptionData) VoteView.this.p.get(this.f13208f)).getNum());
                } else {
                    VoteView.this.q.remove(Integer.valueOf(((PollOptionData) VoteView.this.p.get(this.f13208f)).getId()));
                    PollData pollData2 = VoteView.this.o;
                    VoteView voteView3 = VoteView.this;
                    pollData2.setPolledValue(voteView3.z(voteView3.q));
                    ((PollOptionData) VoteView.this.p.get(this.f13208f)).setNum(((PollOptionData) VoteView.this.p.get(this.f13208f)).getNum() - 1);
                    VoteView.this.o.getOptions().get(this.f13208f).setNum(((PollOptionData) VoteView.this.p.get(this.f13208f)).getNum());
                }
                VoteView.this.H();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f13210e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f13211f;

            public b(int i2, e eVar) {
                this.f13210e = i2;
                this.f13211f = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VoteView.this.q.add(Integer.valueOf(((PollOptionData) VoteView.this.p.get(this.f13210e)).getId()));
                PollData pollData = VoteView.this.o;
                VoteView voteView = VoteView.this;
                pollData.setPolledValue(voteView.z(voteView.q));
                ((PollOptionData) VoteView.this.p.get(this.f13210e)).setNum(((PollOptionData) VoteView.this.p.get(this.f13210e)).getNum() + 1);
                VoteView.this.o.getOptions().get(this.f13210e).setNum(((PollOptionData) VoteView.this.p.get(this.f13210e)).getNum());
                if (VoteView.this.A != null) {
                    VoteView.this.A.onClick(this.f13211f.f13214a);
                }
            }
        }

        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull e eVar, int i2) {
            if (VoteView.this.o == null || VoteView.this.o.getOptions() == null || VoteView.this.p == null) {
                VoteView.this.setSingleUnCheckItemView(eVar);
                if (VoteView.this.r != null) {
                    eVar.f13214a.setOnClickListener(VoteView.this.r);
                }
            } else {
                PollOptionData pollOptionData = (PollOptionData) VoteView.this.p.get(i2);
                long num = pollOptionData.getNum();
                boolean z = num == 0;
                boolean z2 = VoteView.this.o.getTotalPoll() == num;
                boolean contains = VoteView.this.q.contains(Integer.valueOf(pollOptionData.getId()));
                if (!VoteView.this.s && !VoteView.this.t) {
                    if (VoteView.this.u) {
                        if (!VoteView.this.v) {
                            VoteView.this.D(eVar, false);
                        } else {
                            VoteView.this.setSingleUnCheckItemView(eVar);
                        }
                        if ((!VoteView.this.x && VoteView.this.p.size() > 3) || VoteView.this.v) {
                            eVar.f13214a.setOnClickListener(VoteView.this.r);
                        } else {
                            eVar.f13214a.setOnClickListener(new a(eVar, i2));
                        }
                    } else {
                        VoteView.this.setSingleUnCheckItemView(eVar);
                        if ((!VoteView.this.x && VoteView.this.p.size() > 3) || VoteView.this.v) {
                            eVar.f13214a.setOnClickListener(VoteView.this.r);
                        } else {
                            eVar.f13214a.setOnClickListener(new b(i2, eVar));
                        }
                    }
                } else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.o.getTotalPoll() - num));
                    eVar.f13216c.setLayoutParams(layoutParams);
                    eVar.f13215b.setLayoutParams(layoutParams2);
                    VoteView.this.E(eVar, contains, z2, z);
                    eVar.f13219f.setText(StringHelper.numberUniformFormatExtraWithRoundVote(num) + VoteView.this.f13199e.getString(R.string.write_vote_num));
                    eVar.f13214a.setOnClickListener(VoteView.this.r);
                }
            }
            eVar.f13214a.setText(((PollOptionData) VoteView.this.p.get(i2)).getText());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: d */
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new e(LayoutInflater.from(VoteView.this.f13199e).inflate(R.layout.view_vote_text_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (VoteView.this.p == null) {
                return 0;
            }
            return VoteView.this.p.size();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends LinearLayoutManager {
        public d(Context context, int i2, boolean z) {
            super(context, i2, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f13214a;

        /* renamed from: b  reason: collision with root package name */
        public View f13215b;

        /* renamed from: c  reason: collision with root package name */
        public View f13216c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f13217d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f13218e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f13219f;

        public e(View view) {
            super(view);
            this.f13214a = (TextView) view.findViewById(R.id.vote_item);
            this.f13215b = view.findViewById(R.id.vote_item_background);
            this.f13216c = view.findViewById(R.id.vote_item_foreground);
            this.f13217d = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.f13218e = (ImageView) view.findViewById(R.id.vote_check);
            this.f13219f = (TextView) view.findViewById(R.id.vote_num);
        }
    }

    static {
        int i2 = C;
        F = new float[]{i2, i2, 0.0f, 0.0f, 0.0f, 0.0f, i2, i2};
        G = new float[]{0.0f, 0.0f, i2, i2, i2, i2, 0.0f, 0.0f};
        int i3 = D;
        H = new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
    }

    public VoteView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        Context context;
        int i2;
        String str;
        if (this.o.getIsMulti() == 1) {
            context = this.f13199e;
            i2 = R.string.vote_type_multiple;
        } else {
            context = this.f13199e;
            i2 = R.string.vote_type_single;
        }
        String string = context.getString(i2);
        long endTime = this.o.getEndTime();
        if (endTime > 0) {
            Date date = new Date(endTime * 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            str = String.format(this.f13199e.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (!StringUtils.isNull(str)) {
            string = string + " · " + str;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(this.o.getTotalNum());
        if (StringUtils.isNull(numberUniformFormatExtraWithRoundVote)) {
            return string;
        }
        return string + " · " + numberUniformFormatExtraWithRoundVote + this.f13199e.getString(R.string.write_vote_total);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(e eVar) {
        eVar.f13218e.setVisibility(8);
        eVar.f13219f.setVisibility(8);
        eVar.f13214a.setGravity(17);
        SkinManager.setViewTextColor(eVar.f13214a, R.color.CAM_X0105);
        G(eVar, R.color.CAM_X0207, false);
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = l.g(this.f13199e, R.dimen.tbds25);
        this.j.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        if (this.u && !this.t && !this.s && !this.v) {
            this.l.setVisibility(0);
            this.l.setText(this.f13199e.getString(R.string.pb_vote_text));
        } else {
            this.l.setVisibility(8);
        }
        setData(list);
    }

    public final void A() {
        LayoutInflater.from(this.f13199e).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.f13201g = (TextView) findViewById(R.id.vote_title);
        this.f13202h = (TextView) findViewById(R.id.vote_sub_content);
        this.f13203i = (ImageView) findViewById(R.id.vote_view_delete);
        this.j = (RecyclerView) findViewById(R.id.vote_item_list);
        this.k = findViewById(R.id.vote_list_bottom);
        this.l = (TextView) findViewById(R.id.vote_view_btn);
        this.f13203i.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.l.setOnClickListener(this.A);
        this.j.setLayoutManager(new d(this.f13199e, 1, false));
        this.j.setNestedScrollingEnabled(false);
        this.j.setAdapter(this.B);
        this.B.notifyDataSetChanged();
    }

    public final void B(PollData pollData, String str, long j) {
        this.m = str;
        this.n = j;
        this.o = pollData;
        this.s = pollData.getIsPolled() == 1;
        this.q.clear();
        if (this.s && !StringUtils.isNull(this.o.getPolledValue())) {
            for (String str2 : this.o.getPolledValue().split(",")) {
                this.q.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.t = this.o.getLastTime() <= 0 && this.o.getLastTime() != -1;
        this.u = this.o.getIsMulti() == 1;
        if (!StringUtils.isNull(this.o.getTitle())) {
            this.f13201g.setText(this.o.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    public void C(int i2) {
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this);
        d2.k(R.string.J_X05);
        d2.f(this.w);
        if (this.w == R.color.CAM_X0207) {
            SkinManager.setBackgroundResource(this.k, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            SkinManager.setBackgroundResource(this.k, R.drawable.bg_vote_list_bottom);
        }
        SkinManager.setViewTextColor(this.f13201g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13202h, R.color.CAM_X0109);
        H();
        RecyclerView.Adapter<e> adapter = this.B;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void D(e eVar, boolean z) {
        eVar.f13218e.setVisibility(0);
        eVar.f13219f.setVisibility(8);
        eVar.f13214a.setGravity(19);
        G(eVar, R.color.CAM_X0207, z);
        if (z) {
            SkinManager.setViewTextColor(eVar.f13214a, R.color.CAM_X0302);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f13218e, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        SkinManager.setViewTextColor(eVar.f13214a, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(eVar.f13218e, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    public final void E(e eVar, boolean z, boolean z2, boolean z3) {
        eVar.f13218e.setVisibility(8);
        eVar.f13219f.setVisibility(0);
        eVar.f13214a.setGravity(19);
        if (z) {
            SkinManager.setViewTextColor(eVar.f13214a, R.color.CAM_X0302);
            SkinManager.setViewTextColor(eVar.f13219f, R.color.CAM_X0302);
            if (z2) {
                G(eVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            SkinManager.setViewTextColor(eVar.f13214a, R.color.CAM_X0105);
            SkinManager.setViewTextColor(eVar.f13219f, R.color.CAM_X0105);
            if (z3) {
                G(eVar, R.color.CAM_X0207, z);
                return;
            } else if (z2) {
                G(eVar, R.color.CAM_X0209, z);
                return;
            }
        }
        F(eVar, z ? R.color.CAM_X0905 : R.color.CAM_X0209, R.color.CAM_X0207, z);
    }

    public final void F(e eVar, int i2, int i3, boolean z) {
        eVar.f13217d.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(F);
        gradientDrawable.setColor(SkinManager.getColor(i2));
        eVar.f13216c.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(G);
        gradientDrawable2.setColor(SkinManager.getColor(i3));
        eVar.f13215b.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(eVar.f13214a);
            d2.e(R.string.A_X07);
            d2.k(R.string.J_X04);
            d2.i(R.dimen.L_X01);
            d2.h(R.color.CAM_X0302);
            d2.f(i3);
            return;
        }
        d.a.i0.r.u.c d3 = d.a.i0.r.u.c.d(eVar.f13214a);
        d3.k(R.string.J_X04);
        d3.i(R.dimen.L_X01);
        d3.h(R.color.CAM_X0902);
        d3.f(i3);
    }

    public final void G(e eVar, int i2, boolean z) {
        eVar.f13217d.setVisibility(8);
        if (z) {
            d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(eVar.f13214a);
            d2.e(R.string.A_X07);
            d2.k(R.string.J_X04);
            d2.i(R.dimen.L_X01);
            d2.h(R.color.CAM_X0302);
            d2.f(i2);
            return;
        }
        d.a.i0.r.u.c d3 = d.a.i0.r.u.c.d(eVar.f13214a);
        d3.k(R.string.J_X04);
        d3.i(R.dimen.L_X01);
        d3.h(R.color.CAM_X0902);
        d3.f(i2);
    }

    public final void H() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(H);
        gradientDrawable.setColor(d.a.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.08f));
        this.l.setBackgroundDrawable(gradientDrawable);
        if (!this.s && !ListUtils.isEmpty(this.q) && this.q.size() > 0) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
            this.l.setEnabled(true);
            return;
        }
        this.l.setTextColor(d.a.j0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
        this.l.setEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AddPollPostModel addPollPostModel = this.y;
        if (addPollPostModel == null || this.s || this.t || this.v) {
            return;
        }
        addPollPostModel.registerListener();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AddPollPostModel addPollPostModel = this.y;
        if (addPollPostModel != null) {
            addPollPostModel.unRegisterListener();
        }
    }

    public void setBgColor(int i2) {
        this.w = i2;
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData == null) {
            return;
        }
        B(pollData, str, j);
        List<PollOptionData> options = this.o.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        if (options.size() > 3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, E);
            layoutParams.bottomMargin = 0;
            this.j.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            setData(options.subList(0, 4));
            return;
        }
        setViewWithAllData(options);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData == null) {
            return;
        }
        this.x = true;
        B(pollData, str, d.a.c.e.m.b.f(str2, 0L));
        List<PollOptionData> options = this.o.getOptions();
        if (ListUtils.isEmpty(options)) {
            return;
        }
        setViewWithAllData(options);
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f13203i;
        if (imageView == null || onClickListener == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setIsTransmit(boolean z) {
        this.v = z;
    }

    public void setMarginTop(int i2) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i2;
        requestLayout();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f13200f = tbPageContext;
        this.y = new AddPollPostModel(tbPageContext);
    }

    public void setVoteSubContent(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f13202h.setText(str);
    }

    public void setVoteTitle(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f13201g.setText(str);
    }

    public void setVoteViewDeleteVisibility(int i2) {
        ImageView imageView = this.f13203i;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
    }

    public final String z(List<Integer> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        if (size == 0) {
            return "";
        }
        int i2 = 0;
        while (true) {
            int i3 = size - 1;
            if (i2 < i3) {
                sb.append(list.get(i2));
                sb.append(",");
                i2++;
            } else {
                sb.append(list.get(i3));
                return sb.toString();
            }
        }
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoteView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w = R.color.CAM_X0206;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.f13199e = context;
        this.p = new ArrayList();
        this.q = new ArrayList();
        A();
    }

    public void setData(List<PollOptionData> list) {
        this.p.clear();
        this.p.addAll(list);
        RecyclerView.Adapter<e> adapter = this.B;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
