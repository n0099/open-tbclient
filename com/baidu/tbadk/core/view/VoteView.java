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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private static final int bkg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int flY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int flZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] fma = {bkg, bkg, 0.0f, 0.0f, 0.0f, 0.0f, bkg, bkg};
    private static final float[] fmb = {0.0f, 0.0f, bkg, bkg, bkg, bkg, 0.0f, 0.0f};
    private static final float[] fmc = {bkg, bkg, bkg, bkg, bkg, bkg, bkg, bkg};
    private static final float[] fmd = {flY, flY, flY, flY, flY, flY, flY, flY};
    private boolean alH;
    private String amC;
    private PollData eTY;
    private TextView fme;
    private TextView fmf;
    private ImageView fmg;
    private RecyclerView fmh;
    private View fmi;
    private TextView fmj;
    private List<Integer> fmk;
    private View.OnClickListener fml;
    private boolean fmm;
    private boolean fmn;
    private boolean fmo;
    private boolean fmq;
    private AddPollPostModel fmr;
    private AddPollPostModel.a fms;
    private View.OnClickListener fmt;
    private RecyclerView.Adapter<a> fmu;
    private int mBgColor;
    private Context mContext;
    private List<PollOptionData> mData;
    private long mFid;
    private TbPageContext mPageContext;

    public VoteView(Context context) {
        this(context, null);
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgColor = R.color.CAM_X0206;
        this.fms = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aL(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.fmj.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eTY.setPolledValue(VoteView.this.bA(VoteView.this.fmk));
                    VoteView.this.eTY.setIsPolled(1);
                    VoteView.this.fmm = VoteView.this.eTY.getIsPolled() == 1;
                    VoteView.this.eTY.setTotalNum(VoteView.this.eTY.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eTY.setTotalPoll(VoteView.this.eTY.getTotalPoll() + VoteView.this.fmk.size());
                    if (VoteView.this.fmu != null) {
                        VoteView.this.fmu.notifyDataSetChanged();
                    }
                    VoteView.this.buQ();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.fmt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bA = VoteView.this.bA(VoteView.this.fmk);
                if (VoteView.this.mPageContext != null && VoteView.this.fmr != null && !StringUtils.isNull(VoteView.this.amC) && VoteView.this.fms != null && !StringUtils.isNull(bA) && VoteView.this.eTY != null) {
                    VoteView.this.fmr.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.amC, -1L));
                    VoteView.this.fmr.a(VoteView.this.fms);
                    VoteView.this.fmr.l(VoteView.this.amC, bA, VoteView.this.mFid);
                }
            }
        };
        this.fmu = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: m */
            public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
                return new a(LayoutInflater.from(VoteView.this.mContext).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull final a aVar, final int i2) {
                if (VoteView.this.eTY == null || VoteView.this.eTY.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.fml != null) {
                        aVar.fmy.setOnClickListener(VoteView.this.fml);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eTY.getTotalPoll() == num;
                    boolean contains = VoteView.this.fmk.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.fmm && !VoteView.this.fmn) {
                        if (VoteView.this.fmo) {
                            if (!VoteView.this.alH) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.fmq && VoteView.this.mData.size() > 3) || VoteView.this.alH) {
                                aVar.fmy.setOnClickListener(VoteView.this.fml);
                            } else {
                                aVar.fmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.fmk.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.fmk.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.fmk.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eTY.setPolledValue(VoteView.this.bA(VoteView.this.fmk));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eTY.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.fmk.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eTY.setPolledValue(VoteView.this.bA(VoteView.this.fmk));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eTY.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.buQ();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.fmq && VoteView.this.mData.size() > 3) || VoteView.this.alH) {
                                aVar.fmy.setOnClickListener(VoteView.this.fml);
                            } else {
                                aVar.fmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.fmk.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eTY.setPolledValue(VoteView.this.bA(VoteView.this.fmk));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eTY.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.fmt != null) {
                                            VoteView.this.fmt.onClick(aVar.fmy);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eTY.getTotalPoll() - num));
                        aVar.fmA.setLayoutParams(layoutParams);
                        aVar.fmz.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.fmD.setText(au.ee(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.fmy.setOnClickListener(VoteView.this.fml);
                    }
                }
                aVar.fmy.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                if (VoteView.this.mData == null) {
                    return 0;
                }
                return VoteView.this.mData.size();
            }
        };
        this.mContext = context;
        this.mData = new ArrayList();
        this.fmk = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fmr = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.fme = (TextView) findViewById(R.id.vote_title);
        this.fmf = (TextView) findViewById(R.id.vote_sub_content);
        this.fmg = (ImageView) findViewById(R.id.vote_view_delete);
        this.fmh = (RecyclerView) findViewById(R.id.vote_item_list);
        this.fmi = findViewById(R.id.vote_list_bottom);
        this.fmj = (TextView) findViewById(R.id.vote_view_btn);
        this.fmg.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.fmj.setOnClickListener(this.fmt);
        this.fmh.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.fmh.setNestedScrollingEnabled(false);
        this.fmh.setAdapter(this.fmu);
        this.fmu.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.amC = str;
        this.mFid = j;
        this.eTY = pollData;
        this.fmm = this.eTY.getIsPolled() == 1;
        this.fmk.clear();
        if (this.fmm && !StringUtils.isNull(this.eTY.getPolledValue())) {
            for (String str2 : this.eTY.getPolledValue().split(",")) {
                this.fmk.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.fmn = this.eTY.getLastTime() <= 0 && this.eTY.getLastTime() != -1;
        this.fmo = this.eTY.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eTY.getTitle())) {
            this.fme.setText(this.eTY.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.fmh.setLayoutParams(layoutParams);
        this.fmi.setVisibility(8);
        if (this.fmo && !this.fmn && !this.fmm && !this.alH) {
            this.fmj.setVisibility(0);
            this.fmj.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.fmj.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.fmq = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eTY.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eTY.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, flZ);
                    layoutParams.bottomMargin = 0;
                    this.fmh.setLayoutParams(layoutParams);
                    this.fmi.setVisibility(0);
                    this.fmj.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eTY.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eTY.getEndTime();
        String str = "";
        if (endTime > 0) {
            Date date = new Date(endTime * 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            str = String.format(this.mContext.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        }
        if (!StringUtils.isNull(str)) {
            string = string + " · " + str;
        }
        String ee = au.ee(this.eTY.getTotalNum());
        if (!StringUtils.isNull(ee)) {
            return string + " · " + ee + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.fmu != null) {
            this.fmu.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.fme.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.fmf.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.fmg != null && onClickListener != null) {
            this.fmg.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.fml = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.fmg != null) {
            this.fmg.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.alH = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this).og(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ap.setBackgroundResource(this.fmi, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.fmi, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.fme, R.color.CAM_X0105);
        ap.setViewTextColor(this.fmf, R.color.CAM_X0109);
        buQ();
        if (this.fmu != null) {
            this.fmu.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fmr != null && !this.fmm && !this.fmn && !this.alH) {
            this.fmr.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fmr != null) {
            this.fmr.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fmd);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0302), 0.08f));
        this.fmj.setBackgroundDrawable(gradientDrawable);
        if (!this.fmm && !y.isEmpty(this.fmk) && this.fmk.size() > 0) {
            ap.setViewTextColor(this.fmj, R.color.CAM_X0302);
            this.fmj.setEnabled(true);
            return;
        }
        this.fmj.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0302), ap.faO));
        this.fmj.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.fmC.setVisibility(8);
        aVar.fmD.setVisibility(0);
        aVar.fmy.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.fmy, R.color.CAM_X0302);
            ap.setViewTextColor(aVar.fmD, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ap.setViewTextColor(aVar.fmy, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.fmD, R.color.CAM_X0105);
            if (z3) {
                a(aVar, R.color.CAM_X0207, z);
                return;
            } else if (z2) {
                a(aVar, R.color.CAM_X0209, z);
                return;
            }
        }
        a(aVar, z ? R.color.CAM_X0905 : R.color.CAM_X0209, R.color.CAM_X0207, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(a aVar) {
        aVar.fmC.setVisibility(8);
        aVar.fmD.setVisibility(8);
        aVar.fmy.setGravity(17);
        ap.setViewTextColor(aVar.fmy, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.fmC.setVisibility(0);
        aVar.fmD.setVisibility(8);
        aVar.fmy.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ap.setViewTextColor(aVar.fmy, R.color.CAM_X0302);
            SvgManager.bsR().a(aVar.fmC, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.fmy, R.color.CAM_X0105);
        SvgManager.bsR().a(aVar.fmC, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.fmB.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fmy).ol(R.string.A_X07).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fmy).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.fmB.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fma);
        gradientDrawable.setColor(ap.getColor(i));
        aVar.fmA.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(fmb);
        gradientDrawable2.setColor(ap.getColor(i2));
        aVar.fmz.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fmy).ol(R.string.A_X07).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fmy).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0902).setBackGroundColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bA(List<Integer> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        if (size == 0) {
            return "";
        }
        for (int i = 0; i < size - 1; i++) {
            sb.append(list.get(i)).append(",");
        }
        sb.append(list.get(size - 1));
        return sb.toString();
    }

    public void setMarginTop(int i) {
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = i;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {
        public View fmA;
        public LinearLayout fmB;
        public ImageView fmC;
        public TextView fmD;
        public TextView fmy;
        public View fmz;

        public a(View view) {
            super(view);
            this.fmy = (TextView) view.findViewById(R.id.vote_item);
            this.fmz = view.findViewById(R.id.vote_item_background);
            this.fmA = view.findViewById(R.id.vote_item_foreground);
            this.fmB = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.fmC = (ImageView) view.findViewById(R.id.vote_check);
            this.fmD = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
