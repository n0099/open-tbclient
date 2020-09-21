package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private static final int bbc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int exK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int exL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] exM = {bbc, bbc, 0.0f, 0.0f, 0.0f, 0.0f, bbc, bbc};
    private static final float[] exN = {0.0f, 0.0f, bbc, bbc, bbc, bbc, 0.0f, 0.0f};
    private static final float[] exO = {bbc, bbc, bbc, bbc, bbc, bbc, bbc, bbc};
    private static final float[] exP = {exK, exK, exK, exK, exK, exK, exK, exK};
    private boolean akI;
    private String alA;
    private PollData egL;
    private TextView exQ;
    private TextView exR;
    private ImageView exS;
    private RecyclerView exT;
    private View exU;
    private TextView exV;
    private List<Integer> exW;
    private View.OnClickListener exX;
    private boolean exY;
    private boolean exZ;
    private boolean eya;
    private boolean eyb;
    private AddPollPostModel eyc;
    private AddPollPostModel.a eyd;
    private View.OnClickListener eyf;
    private RecyclerView.Adapter<a> eyg;
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
        this.mBgColor = R.color.cp_bg_line_g;
        this.eyd = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void ap(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.exV.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.egL.setPolledValue(VoteView.this.ba(VoteView.this.exW));
                    VoteView.this.egL.setIsPolled(1);
                    VoteView.this.exY = VoteView.this.egL.getIsPolled() == 1;
                    VoteView.this.egL.setTotalNum(VoteView.this.egL.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.egL.setTotalPoll(VoteView.this.egL.getTotalPoll() + VoteView.this.exW.size());
                    if (VoteView.this.eyg != null) {
                        VoteView.this.eyg.notifyDataSetChanged();
                    }
                    VoteView.this.bmc();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.eyf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String ba = VoteView.this.ba(VoteView.this.exW);
                if (VoteView.this.mPageContext != null && VoteView.this.eyc != null && !StringUtils.isNull(VoteView.this.alA) && VoteView.this.eyd != null && !StringUtils.isNull(ba) && VoteView.this.egL != null) {
                    VoteView.this.eyc.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.alA, -1L));
                    VoteView.this.eyc.a(VoteView.this.eyd);
                    VoteView.this.eyc.i(VoteView.this.alA, ba, VoteView.this.mFid);
                }
            }
        };
        this.eyg = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: g */
            public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
                return new a(LayoutInflater.from(VoteView.this.mContext).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: b */
            public void onBindViewHolder(@NonNull final a aVar, final int i2) {
                if (VoteView.this.egL == null || VoteView.this.egL.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.exX != null) {
                        aVar.eyk.setOnClickListener(VoteView.this.exX);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.egL.getTotalPoll() == num;
                    boolean contains = VoteView.this.exW.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.exY && !VoteView.this.exZ) {
                        if (VoteView.this.eya) {
                            if (!VoteView.this.akI) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.eyb && VoteView.this.mData.size() > 3) || VoteView.this.akI) {
                                aVar.eyk.setOnClickListener(VoteView.this.exX);
                            } else {
                                aVar.eyk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.exW.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.exW.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.exW.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.egL.setPolledValue(VoteView.this.ba(VoteView.this.exW));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.egL.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.exW.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.egL.setPolledValue(VoteView.this.ba(VoteView.this.exW));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.egL.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.bmc();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.eyb && VoteView.this.mData.size() > 3) || VoteView.this.akI) {
                                aVar.eyk.setOnClickListener(VoteView.this.exX);
                            } else {
                                aVar.eyk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.exW.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.egL.setPolledValue(VoteView.this.ba(VoteView.this.exW));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.egL.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.eyf != null) {
                                            VoteView.this.eyf.onClick(aVar.eyk);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.egL.getTotalPoll() - num));
                        aVar.eyn.setLayoutParams(layoutParams);
                        aVar.eyl.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.eyq.setText(at.cT(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.eyk.setOnClickListener(VoteView.this.exX);
                    }
                }
                aVar.eyk.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemCount() {
                if (VoteView.this.mData == null) {
                    return 0;
                }
                return VoteView.this.mData.size();
            }
        };
        this.mContext = context;
        this.mData = new ArrayList();
        this.exW = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eyc = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.exQ = (TextView) findViewById(R.id.vote_title);
        this.exR = (TextView) findViewById(R.id.vote_sub_content);
        this.exS = (ImageView) findViewById(R.id.vote_view_delete);
        this.exT = (RecyclerView) findViewById(R.id.vote_item_list);
        this.exU = findViewById(R.id.vote_list_bottom);
        this.exV = (TextView) findViewById(R.id.vote_view_btn);
        this.exV.setOnClickListener(this.eyf);
        this.exT.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.exT.setNestedScrollingEnabled(false);
        this.exT.setAdapter(this.eyg);
        this.eyg.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.alA = str;
        this.mFid = j;
        this.egL = pollData;
        this.exY = this.egL.getIsPolled() == 1;
        this.exW.clear();
        if (this.exY && !StringUtils.isNull(this.egL.getPolledValue())) {
            for (String str2 : this.egL.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.exW.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.exZ = this.egL.getLastTime() <= 0 && this.egL.getLastTime() != -1;
        this.eya = this.egL.getIsMulti() == 1;
        if (!StringUtils.isNull(this.egL.getTitle())) {
            this.exQ.setText(this.egL.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.exT.setLayoutParams(layoutParams);
        this.exU.setVisibility(8);
        if (this.eya && !this.exZ && !this.exY && !this.akI) {
            this.exV.setVisibility(0);
            this.exV.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.exV.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.eyb = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.egL.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.egL.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, exL);
                    layoutParams.bottomMargin = 0;
                    this.exT.setLayoutParams(layoutParams);
                    this.exU.setVisibility(0);
                    this.exV.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.egL.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.egL.getEndTime();
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
        String cT = at.cT(this.egL.getTotalNum());
        if (!StringUtils.isNull(cT)) {
            return string + " · " + cT + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.eyg != null) {
            this.eyg.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.exQ.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.exR.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.exS != null && onClickListener != null) {
            this.exS.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.exX = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.exS != null) {
            this.exS.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.akI = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ap.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ap.setBackgroundResource(this.exU, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.exU, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.exQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.exR, R.color.cp_cont_d);
        bmc();
        if (this.eyg != null) {
            this.eyg.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eyc != null && !this.exY && !this.exZ && !this.akI) {
            this.eyc.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eyc != null) {
            this.eyc.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmc() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(exP);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.exV.setBackgroundDrawable(gradientDrawable);
        if (!this.exY && !y.isEmpty(this.exW) && this.exW.size() > 0) {
            ap.setViewTextColor(this.exV, R.color.cp_link_tip_a);
            this.exV.setEnabled(true);
            return;
        }
        this.exV.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.exV.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.eyp.setVisibility(8);
        aVar.eyq.setVisibility(0);
        aVar.eyk.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.eyk, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.eyq, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.eyk, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.eyq, R.color.cp_cont_b);
        if (z3) {
            a(aVar, ap.getColor(R.color.cp_bg_line_h));
        } else if (z2) {
            a(aVar, ap.getColor(R.color.cp_bg_line_b));
        } else {
            a(aVar, ap.getColor(R.color.cp_bg_line_b), ap.getColor(R.color.cp_bg_line_h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(a aVar) {
        aVar.eyp.setVisibility(8);
        aVar.eyq.setVisibility(8);
        aVar.eyk.setGravity(17);
        ap.setViewTextColor(aVar.eyk, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.eyp.setVisibility(0);
        aVar.eyq.setVisibility(8);
        aVar.eyk.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.eyk, R.color.cp_link_tip_a);
            SvgManager.bkl().a(aVar.eyp, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.eyk, R.color.cp_cont_b);
        SvgManager.bkl().a(aVar.eyp, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.eyo.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(exO);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eyk.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.eyo.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(exM);
        gradientDrawable.setColor(i);
        aVar.eyn.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(exN);
        gradientDrawable2.setColor(i2);
        aVar.eyl.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(exO);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eyk.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ba(List<Integer> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        if (size == 0) {
            return "";
        }
        for (int i = 0; i < size - 1; i++) {
            sb.append(list.get(i)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        public TextView eyk;
        public View eyl;
        public View eyn;
        public LinearLayout eyo;
        public ImageView eyp;
        public TextView eyq;

        public a(View view) {
            super(view);
            this.eyk = (TextView) view.findViewById(R.id.vote_item);
            this.eyl = view.findViewById(R.id.vote_item_background);
            this.eyn = view.findViewById(R.id.vote_item_foreground);
            this.eyo = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.eyp = (ImageView) view.findViewById(R.id.vote_check);
            this.eyq = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
