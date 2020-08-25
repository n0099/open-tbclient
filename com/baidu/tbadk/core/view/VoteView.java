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
/* loaded from: classes2.dex */
public class VoteView extends LinearLayout {
    private static final int aYD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int evB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int evC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] evD = {aYD, aYD, 0.0f, 0.0f, 0.0f, 0.0f, aYD, aYD};
    private static final float[] evE = {0.0f, 0.0f, aYD, aYD, aYD, aYD, 0.0f, 0.0f};
    private static final float[] evF = {aYD, aYD, aYD, aYD, aYD, aYD, aYD, aYD};
    private static final float[] evG = {evB, evB, evB, evB, evB, evB, evB, evB};
    private String akY;
    private boolean akh;
    private PollData eey;
    private TextView evH;
    private TextView evI;
    private ImageView evJ;
    private RecyclerView evK;
    private View evL;
    private TextView evM;
    private List<Integer> evN;
    private View.OnClickListener evO;
    private boolean evP;
    private boolean evQ;
    private boolean evR;
    private boolean evS;
    private AddPollPostModel evT;
    private AddPollPostModel.a evU;
    private View.OnClickListener evV;
    private RecyclerView.Adapter<a> evW;
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
        this.evU = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void ao(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.evM.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eey.setPolledValue(VoteView.this.aW(VoteView.this.evN));
                    VoteView.this.eey.setIsPolled(1);
                    VoteView.this.evP = VoteView.this.eey.getIsPolled() == 1;
                    VoteView.this.eey.setTotalNum(VoteView.this.eey.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eey.setTotalPoll(VoteView.this.eey.getTotalPoll() + VoteView.this.evN.size());
                    if (VoteView.this.evW != null) {
                        VoteView.this.evW.notifyDataSetChanged();
                    }
                    VoteView.this.blh();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.evV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String aW = VoteView.this.aW(VoteView.this.evN);
                if (VoteView.this.mPageContext != null && VoteView.this.evT != null && !StringUtils.isNull(VoteView.this.akY) && VoteView.this.evU != null && !StringUtils.isNull(aW) && VoteView.this.eey != null) {
                    VoteView.this.evT.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.akY, -1L));
                    VoteView.this.evT.a(VoteView.this.evU);
                    VoteView.this.evT.i(VoteView.this.akY, aW, VoteView.this.mFid);
                }
            }
        };
        this.evW = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eey == null || VoteView.this.eey.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.evO != null) {
                        aVar.ewa.setOnClickListener(VoteView.this.evO);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eey.getTotalPoll() == num;
                    boolean contains = VoteView.this.evN.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.evP && !VoteView.this.evQ) {
                        if (VoteView.this.evR) {
                            if (!VoteView.this.akh) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.evS && VoteView.this.mData.size() > 3) || VoteView.this.akh) {
                                aVar.ewa.setOnClickListener(VoteView.this.evO);
                            } else {
                                aVar.ewa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.evN.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.evN.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.evN.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eey.setPolledValue(VoteView.this.aW(VoteView.this.evN));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eey.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.evN.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eey.setPolledValue(VoteView.this.aW(VoteView.this.evN));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eey.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.blh();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.evS && VoteView.this.mData.size() > 3) || VoteView.this.akh) {
                                aVar.ewa.setOnClickListener(VoteView.this.evO);
                            } else {
                                aVar.ewa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.evN.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eey.setPolledValue(VoteView.this.aW(VoteView.this.evN));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eey.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.evV != null) {
                                            VoteView.this.evV.onClick(aVar.ewa);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eey.getTotalPoll() - num));
                        aVar.ewc.setLayoutParams(layoutParams);
                        aVar.ewb.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.ewf.setText(at.cS(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.ewa.setOnClickListener(VoteView.this.evO);
                    }
                }
                aVar.ewa.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.evN = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.evT = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.evH = (TextView) findViewById(R.id.vote_title);
        this.evI = (TextView) findViewById(R.id.vote_sub_content);
        this.evJ = (ImageView) findViewById(R.id.vote_view_delete);
        this.evK = (RecyclerView) findViewById(R.id.vote_item_list);
        this.evL = findViewById(R.id.vote_list_bottom);
        this.evM = (TextView) findViewById(R.id.vote_view_btn);
        this.evM.setOnClickListener(this.evV);
        this.evK.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.evK.setNestedScrollingEnabled(false);
        this.evK.setAdapter(this.evW);
        this.evW.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.akY = str;
        this.mFid = j;
        this.eey = pollData;
        this.evP = this.eey.getIsPolled() == 1;
        this.evN.clear();
        if (this.evP && !StringUtils.isNull(this.eey.getPolledValue())) {
            for (String str2 : this.eey.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.evN.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.evQ = this.eey.getLastTime() <= 0 && this.eey.getLastTime() != -1;
        this.evR = this.eey.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eey.getTitle())) {
            this.evH.setText(this.eey.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.evK.setLayoutParams(layoutParams);
        this.evL.setVisibility(8);
        if (this.evR && !this.evQ && !this.evP && !this.akh) {
            this.evM.setVisibility(0);
            this.evM.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.evM.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.evS = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eey.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eey.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, evC);
                    layoutParams.bottomMargin = 0;
                    this.evK.setLayoutParams(layoutParams);
                    this.evL.setVisibility(0);
                    this.evM.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eey.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eey.getEndTime();
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
        String cS = at.cS(this.eey.getTotalNum());
        if (!StringUtils.isNull(cS)) {
            return string + " · " + cS + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.evW != null) {
            this.evW.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.evH.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.evI.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.evJ != null && onClickListener != null) {
            this.evJ.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.evO = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.evJ != null) {
            this.evJ.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.akh = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ap.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ap.setBackgroundResource(this.evL, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.evL, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.evH, R.color.cp_cont_b);
        ap.setViewTextColor(this.evI, R.color.cp_cont_d);
        blh();
        if (this.evW != null) {
            this.evW.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.evT != null && !this.evP && !this.evQ && !this.akh) {
            this.evT.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.evT != null) {
            this.evT.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blh() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evG);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.evM.setBackgroundDrawable(gradientDrawable);
        if (!this.evP && !y.isEmpty(this.evN) && this.evN.size() > 0) {
            ap.setViewTextColor(this.evM, R.color.cp_link_tip_a);
            this.evM.setEnabled(true);
            return;
        }
        this.evM.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.evM.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.ewe.setVisibility(8);
        aVar.ewf.setVisibility(0);
        aVar.ewa.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.ewa, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.ewf, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.ewa, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.ewf, R.color.cp_cont_b);
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
        aVar.ewe.setVisibility(8);
        aVar.ewf.setVisibility(8);
        aVar.ewa.setGravity(17);
        ap.setViewTextColor(aVar.ewa, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.ewe.setVisibility(0);
        aVar.ewf.setVisibility(8);
        aVar.ewa.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.ewa, R.color.cp_link_tip_a);
            SvgManager.bjq().a(aVar.ewe, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.ewa, R.color.cp_cont_b);
        SvgManager.bjq().a(aVar.ewe, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.ewd.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evF);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.ewa.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.ewd.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(evD);
        gradientDrawable.setColor(i);
        aVar.ewc.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(evE);
        gradientDrawable2.setColor(i2);
        aVar.ewb.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(evF);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.ewa.setBackgroundDrawable(gradientDrawable3);
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
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        public TextView ewa;
        public View ewb;
        public View ewc;
        public LinearLayout ewd;
        public ImageView ewe;
        public TextView ewf;

        public a(View view) {
            super(view);
            this.ewa = (TextView) view.findViewById(R.id.vote_item);
            this.ewb = view.findViewById(R.id.vote_item_background);
            this.ewc = view.findViewById(R.id.vote_item_foreground);
            this.ewd = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.ewe = (ImageView) view.findViewById(R.id.vote_check);
            this.ewf = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
