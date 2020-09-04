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
    private static final int aYF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int evF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int evG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] evH = {aYF, aYF, 0.0f, 0.0f, 0.0f, 0.0f, aYF, aYF};
    private static final float[] evI = {0.0f, 0.0f, aYF, aYF, aYF, aYF, 0.0f, 0.0f};
    private static final float[] evJ = {aYF, aYF, aYF, aYF, aYF, aYF, aYF, aYF};
    private static final float[] evK = {evF, evF, evF, evF, evF, evF, evF, evF};
    private boolean akj;
    private String ala;
    private PollData eeC;
    private TextView evL;
    private TextView evM;
    private ImageView evN;
    private RecyclerView evO;
    private View evP;
    private TextView evQ;
    private List<Integer> evR;
    private View.OnClickListener evS;
    private boolean evT;
    private boolean evU;
    private boolean evV;
    private boolean evW;
    private AddPollPostModel evX;
    private AddPollPostModel.a evY;
    private View.OnClickListener evZ;
    private RecyclerView.Adapter<a> ewa;
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
        this.evY = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void ao(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.evQ.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eeC.setPolledValue(VoteView.this.aW(VoteView.this.evR));
                    VoteView.this.eeC.setIsPolled(1);
                    VoteView.this.evT = VoteView.this.eeC.getIsPolled() == 1;
                    VoteView.this.eeC.setTotalNum(VoteView.this.eeC.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eeC.setTotalPoll(VoteView.this.eeC.getTotalPoll() + VoteView.this.evR.size());
                    if (VoteView.this.ewa != null) {
                        VoteView.this.ewa.notifyDataSetChanged();
                    }
                    VoteView.this.blh();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.evZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String aW = VoteView.this.aW(VoteView.this.evR);
                if (VoteView.this.mPageContext != null && VoteView.this.evX != null && !StringUtils.isNull(VoteView.this.ala) && VoteView.this.evY != null && !StringUtils.isNull(aW) && VoteView.this.eeC != null) {
                    VoteView.this.evX.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.ala, -1L));
                    VoteView.this.evX.a(VoteView.this.evY);
                    VoteView.this.evX.i(VoteView.this.ala, aW, VoteView.this.mFid);
                }
            }
        };
        this.ewa = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eeC == null || VoteView.this.eeC.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.evS != null) {
                        aVar.ewe.setOnClickListener(VoteView.this.evS);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eeC.getTotalPoll() == num;
                    boolean contains = VoteView.this.evR.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.evT && !VoteView.this.evU) {
                        if (VoteView.this.evV) {
                            if (!VoteView.this.akj) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.evW && VoteView.this.mData.size() > 3) || VoteView.this.akj) {
                                aVar.ewe.setOnClickListener(VoteView.this.evS);
                            } else {
                                aVar.ewe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.evR.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.evR.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.evR.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eeC.setPolledValue(VoteView.this.aW(VoteView.this.evR));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eeC.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.evR.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eeC.setPolledValue(VoteView.this.aW(VoteView.this.evR));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eeC.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.blh();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.evW && VoteView.this.mData.size() > 3) || VoteView.this.akj) {
                                aVar.ewe.setOnClickListener(VoteView.this.evS);
                            } else {
                                aVar.ewe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.evR.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eeC.setPolledValue(VoteView.this.aW(VoteView.this.evR));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eeC.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.evZ != null) {
                                            VoteView.this.evZ.onClick(aVar.ewe);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eeC.getTotalPoll() - num));
                        aVar.ewg.setLayoutParams(layoutParams);
                        aVar.ewf.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.ewj.setText(at.cS(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.ewe.setOnClickListener(VoteView.this.evS);
                    }
                }
                aVar.ewe.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.evR = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.evX = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.evL = (TextView) findViewById(R.id.vote_title);
        this.evM = (TextView) findViewById(R.id.vote_sub_content);
        this.evN = (ImageView) findViewById(R.id.vote_view_delete);
        this.evO = (RecyclerView) findViewById(R.id.vote_item_list);
        this.evP = findViewById(R.id.vote_list_bottom);
        this.evQ = (TextView) findViewById(R.id.vote_view_btn);
        this.evQ.setOnClickListener(this.evZ);
        this.evO.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.evO.setNestedScrollingEnabled(false);
        this.evO.setAdapter(this.ewa);
        this.ewa.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.ala = str;
        this.mFid = j;
        this.eeC = pollData;
        this.evT = this.eeC.getIsPolled() == 1;
        this.evR.clear();
        if (this.evT && !StringUtils.isNull(this.eeC.getPolledValue())) {
            for (String str2 : this.eeC.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.evR.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.evU = this.eeC.getLastTime() <= 0 && this.eeC.getLastTime() != -1;
        this.evV = this.eeC.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eeC.getTitle())) {
            this.evL.setText(this.eeC.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.evO.setLayoutParams(layoutParams);
        this.evP.setVisibility(8);
        if (this.evV && !this.evU && !this.evT && !this.akj) {
            this.evQ.setVisibility(0);
            this.evQ.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.evQ.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.evW = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eeC.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eeC.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, evG);
                    layoutParams.bottomMargin = 0;
                    this.evO.setLayoutParams(layoutParams);
                    this.evP.setVisibility(0);
                    this.evQ.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eeC.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eeC.getEndTime();
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
        String cS = at.cS(this.eeC.getTotalNum());
        if (!StringUtils.isNull(cS)) {
            return string + " · " + cS + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.ewa != null) {
            this.ewa.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.evL.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.evM.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.evN != null && onClickListener != null) {
            this.evN.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.evS = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.evN != null) {
            this.evN.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.akj = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ap.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ap.setBackgroundResource(this.evP, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.evP, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.evL, R.color.cp_cont_b);
        ap.setViewTextColor(this.evM, R.color.cp_cont_d);
        blh();
        if (this.ewa != null) {
            this.ewa.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.evX != null && !this.evT && !this.evU && !this.akj) {
            this.evX.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.evX != null) {
            this.evX.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blh() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evK);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.evQ.setBackgroundDrawable(gradientDrawable);
        if (!this.evT && !y.isEmpty(this.evR) && this.evR.size() > 0) {
            ap.setViewTextColor(this.evQ, R.color.cp_link_tip_a);
            this.evQ.setEnabled(true);
            return;
        }
        this.evQ.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.evQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.ewi.setVisibility(8);
        aVar.ewj.setVisibility(0);
        aVar.ewe.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.ewe, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.ewj, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.ewe, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.ewj, R.color.cp_cont_b);
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
        aVar.ewi.setVisibility(8);
        aVar.ewj.setVisibility(8);
        aVar.ewe.setGravity(17);
        ap.setViewTextColor(aVar.ewe, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.ewi.setVisibility(0);
        aVar.ewj.setVisibility(8);
        aVar.ewe.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.ewe, R.color.cp_link_tip_a);
            SvgManager.bjq().a(aVar.ewi, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.ewe, R.color.cp_cont_b);
        SvgManager.bjq().a(aVar.ewi, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.ewh.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evJ);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.ewe.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.ewh.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evH);
        gradientDrawable.setColor(i);
        aVar.ewg.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(evI);
        gradientDrawable2.setColor(i2);
        aVar.ewf.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(evJ);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.ewe.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aW(List<Integer> list) {
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
        public TextView ewe;
        public View ewf;
        public View ewg;
        public LinearLayout ewh;
        public ImageView ewi;
        public TextView ewj;

        public a(View view) {
            super(view);
            this.ewe = (TextView) view.findViewById(R.id.vote_item);
            this.ewf = view.findViewById(R.id.vote_item_background);
            this.ewg = view.findViewById(R.id.vote_item_foreground);
            this.ewh = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.ewi = (ImageView) view.findViewById(R.id.vote_check);
            this.ewj = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
