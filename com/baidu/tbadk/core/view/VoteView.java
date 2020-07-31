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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private static final int aTp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int elG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int elH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] elI = {aTp, aTp, 0.0f, 0.0f, 0.0f, 0.0f, aTp, aTp};
    private static final float[] elJ = {0.0f, 0.0f, aTp, aTp, aTp, aTp, 0.0f, 0.0f};
    private static final float[] elK = {aTp, aTp, aTp, aTp, aTp, aTp, aTp, aTp};
    private static final float[] elL = {elG, elG, elG, elG, elG, elG, elG, elG};
    private boolean aiS;
    private String ajJ;
    private PollData dUZ;
    private TextView elM;
    private TextView elN;
    private ImageView elO;
    private RecyclerView elP;
    private View elQ;
    private TextView elR;
    private List<Integer> elS;
    private View.OnClickListener elT;
    private boolean elU;
    private boolean elV;
    private boolean elW;
    private boolean elX;
    private AddPollPostModel elY;
    private AddPollPostModel.a elZ;
    private View.OnClickListener ema;
    private RecyclerView.Adapter<a> emb;
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
        this.elZ = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aq(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.elR.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.dUZ.setPolledValue(VoteView.this.aW(VoteView.this.elS));
                    VoteView.this.dUZ.setIsPolled(1);
                    VoteView.this.elU = VoteView.this.dUZ.getIsPolled() == 1;
                    VoteView.this.dUZ.setTotalNum(VoteView.this.dUZ.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.dUZ.setTotalPoll(VoteView.this.dUZ.getTotalPoll() + VoteView.this.elS.size());
                    if (VoteView.this.emb != null) {
                        VoteView.this.emb.notifyDataSetChanged();
                    }
                    VoteView.this.bcJ();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.ema = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String aW = VoteView.this.aW(VoteView.this.elS);
                if (VoteView.this.mPageContext != null && VoteView.this.elY != null && !StringUtils.isNull(VoteView.this.ajJ) && VoteView.this.elZ != null && !StringUtils.isNull(aW) && VoteView.this.dUZ != null) {
                    VoteView.this.elY.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.ajJ, -1L));
                    VoteView.this.elY.a(VoteView.this.elZ);
                    VoteView.this.elY.j(VoteView.this.ajJ, aW, VoteView.this.mFid);
                }
            }
        };
        this.emb = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.dUZ == null || VoteView.this.dUZ.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.elT != null) {
                        aVar.emf.setOnClickListener(VoteView.this.elT);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.dUZ.getTotalPoll() == num;
                    boolean contains = VoteView.this.elS.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.elU && !VoteView.this.elV) {
                        if (VoteView.this.elW) {
                            if (!VoteView.this.aiS) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.elX && VoteView.this.mData.size() > 3) || VoteView.this.aiS) {
                                aVar.emf.setOnClickListener(VoteView.this.elT);
                            } else {
                                aVar.emf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.elS.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.elS.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.elS.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.dUZ.setPolledValue(VoteView.this.aW(VoteView.this.elS));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.dUZ.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.elS.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.dUZ.setPolledValue(VoteView.this.aW(VoteView.this.elS));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.dUZ.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.bcJ();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.elX && VoteView.this.mData.size() > 3) || VoteView.this.aiS) {
                                aVar.emf.setOnClickListener(VoteView.this.elT);
                            } else {
                                aVar.emf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.elS.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.dUZ.setPolledValue(VoteView.this.aW(VoteView.this.elS));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.dUZ.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.ema != null) {
                                            VoteView.this.ema.onClick(aVar.emf);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.dUZ.getTotalPoll() - num));
                        aVar.emh.setLayoutParams(layoutParams);
                        aVar.emg.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.emk.setText(as.cH(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.emf.setOnClickListener(VoteView.this.elT);
                    }
                }
                aVar.emf.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.elS = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.elY = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.elM = (TextView) findViewById(R.id.vote_title);
        this.elN = (TextView) findViewById(R.id.vote_sub_content);
        this.elO = (ImageView) findViewById(R.id.vote_view_delete);
        this.elP = (RecyclerView) findViewById(R.id.vote_item_list);
        this.elQ = findViewById(R.id.vote_list_bottom);
        this.elR = (TextView) findViewById(R.id.vote_view_btn);
        this.elR.setOnClickListener(this.ema);
        this.elP.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.elP.setNestedScrollingEnabled(false);
        this.elP.setAdapter(this.emb);
        this.emb.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.ajJ = str;
        this.mFid = j;
        this.dUZ = pollData;
        this.elU = this.dUZ.getIsPolled() == 1;
        this.elS.clear();
        if (this.elU && !StringUtils.isNull(this.dUZ.getPolledValue())) {
            for (String str2 : this.dUZ.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.elS.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.elV = this.dUZ.getLastTime() <= 0 && this.dUZ.getLastTime() != -1;
        this.elW = this.dUZ.getIsMulti() == 1;
        if (!StringUtils.isNull(this.dUZ.getTitle())) {
            this.elM.setText(this.dUZ.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.elP.setLayoutParams(layoutParams);
        this.elQ.setVisibility(8);
        if (this.elW && !this.elV && !this.elU && !this.aiS) {
            this.elR.setVisibility(0);
            this.elR.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.elR.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.elX = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.dUZ.getOptions();
            if (!x.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.dUZ.getOptions();
            if (!x.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, elH);
                    layoutParams.bottomMargin = 0;
                    this.elP.setLayoutParams(layoutParams);
                    this.elQ.setVisibility(0);
                    this.elR.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.dUZ.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.dUZ.getEndTime();
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
        String cH = as.cH(this.dUZ.getTotalNum());
        if (!StringUtils.isNull(cH)) {
            return string + " · " + cH + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.emb != null) {
            this.emb.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.elM.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.elN.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.elO != null && onClickListener != null) {
            this.elO.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.elT = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.elO != null) {
            this.elO.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.aiS = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ao.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ao.setBackgroundResource(this.elQ, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ao.setBackgroundResource(this.elQ, R.drawable.bg_vote_list_bottom);
        }
        ao.setViewTextColor(this.elM, R.color.cp_cont_b);
        ao.setViewTextColor(this.elN, R.color.cp_cont_d);
        bcJ();
        if (this.emb != null) {
            this.emb.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.elY != null && !this.elU && !this.elV && !this.aiS) {
            this.elY.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.elY != null) {
            this.elY.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcJ() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(elL);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.08f));
        this.elR.setBackgroundDrawable(gradientDrawable);
        if (!this.elU && !x.isEmpty(this.elS) && this.elS.size() > 0) {
            ao.setViewTextColor(this.elR, R.color.cp_link_tip_a);
            this.elR.setEnabled(true);
            return;
        }
        this.elR.setTextColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.3f));
        this.elR.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.emj.setVisibility(8);
        aVar.emk.setVisibility(0);
        aVar.emf.setGravity(19);
        if (z) {
            ao.setViewTextColor(aVar.emf, R.color.cp_link_tip_a);
            ao.setViewTextColor(aVar.emk, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.16f), ao.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ao.setViewTextColor(aVar.emf, R.color.cp_cont_b);
        ao.setViewTextColor(aVar.emk, R.color.cp_cont_b);
        if (z3) {
            a(aVar, ao.getColor(R.color.cp_bg_line_h));
        } else if (z2) {
            a(aVar, ao.getColor(R.color.cp_bg_line_b));
        } else {
            a(aVar, ao.getColor(R.color.cp_bg_line_b), ao.getColor(R.color.cp_bg_line_h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(a aVar) {
        aVar.emj.setVisibility(8);
        aVar.emk.setVisibility(8);
        aVar.emf.setGravity(17);
        ao.setViewTextColor(aVar.emf, R.color.cp_cont_b);
        a(aVar, ao.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.emj.setVisibility(0);
        aVar.emk.setVisibility(8);
        aVar.emf.setGravity(19);
        a(aVar, ao.getColor(R.color.cp_bg_line_h));
        if (z) {
            ao.setViewTextColor(aVar.emf, R.color.cp_link_tip_a);
            SvgManager.baR().a(aVar.emj, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ao.setViewTextColor(aVar.emf, R.color.cp_cont_b);
        SvgManager.baR().a(aVar.emj, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.emi.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(elK);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_border_d), 0.16f));
        aVar.emf.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.emi.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(elI);
        gradientDrawable.setColor(i);
        aVar.emh.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(elJ);
        gradientDrawable2.setColor(i2);
        aVar.emg.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(elK);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_border_d), 0.16f));
        aVar.emf.setBackgroundDrawable(gradientDrawable3);
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
        public TextView emf;
        public View emg;
        public View emh;
        public LinearLayout emi;
        public ImageView emj;
        public TextView emk;

        public a(View view) {
            super(view);
            this.emf = (TextView) view.findViewById(R.id.vote_item);
            this.emg = view.findViewById(R.id.vote_item_background);
            this.emh = view.findViewById(R.id.vote_item_foreground);
            this.emi = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.emj = (ImageView) view.findViewById(R.id.vote_check);
            this.emk = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
