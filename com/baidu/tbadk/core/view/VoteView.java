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
    private static final int bhw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int eYe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int eYf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] eYg = {bhw, bhw, 0.0f, 0.0f, 0.0f, 0.0f, bhw, bhw};
    private static final float[] eYh = {0.0f, 0.0f, bhw, bhw, bhw, bhw, 0.0f, 0.0f};
    private static final float[] eYi = {bhw, bhw, bhw, bhw, bhw, bhw, bhw, bhw};
    private static final float[] eYj = {eYe, eYe, eYe, eYe, eYe, eYe, eYe, eYe};
    private String alT;
    private boolean alb;
    private PollData eHg;
    private TextView eYk;
    private TextView eYl;
    private ImageView eYm;
    private RecyclerView eYn;
    private View eYo;
    private TextView eYp;
    private List<Integer> eYq;
    private View.OnClickListener eYr;
    private boolean eYs;
    private boolean eYt;
    private boolean eYu;
    private boolean eYv;
    private AddPollPostModel eYw;
    private AddPollPostModel.a eYx;
    private View.OnClickListener eYy;
    private RecyclerView.Adapter<a> eYz;
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
        this.eYx = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aG(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.eYp.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eHg.setPolledValue(VoteView.this.bu(VoteView.this.eYq));
                    VoteView.this.eHg.setIsPolled(1);
                    VoteView.this.eYs = VoteView.this.eHg.getIsPolled() == 1;
                    VoteView.this.eHg.setTotalNum(VoteView.this.eHg.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eHg.setTotalPoll(VoteView.this.eHg.getTotalPoll() + VoteView.this.eYq.size());
                    if (VoteView.this.eYz != null) {
                        VoteView.this.eYz.notifyDataSetChanged();
                    }
                    VoteView.this.btf();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.eYy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bu = VoteView.this.bu(VoteView.this.eYq);
                if (VoteView.this.mPageContext != null && VoteView.this.eYw != null && !StringUtils.isNull(VoteView.this.alT) && VoteView.this.eYx != null && !StringUtils.isNull(bu) && VoteView.this.eHg != null) {
                    VoteView.this.eYw.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.alT, -1L));
                    VoteView.this.eYw.a(VoteView.this.eYx);
                    VoteView.this.eYw.j(VoteView.this.alT, bu, VoteView.this.mFid);
                }
            }
        };
        this.eYz = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: i */
            public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
                return new a(LayoutInflater.from(VoteView.this.mContext).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: b */
            public void onBindViewHolder(@NonNull final a aVar, final int i2) {
                if (VoteView.this.eHg == null || VoteView.this.eHg.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.eYr != null) {
                        aVar.eYD.setOnClickListener(VoteView.this.eYr);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eHg.getTotalPoll() == num;
                    boolean contains = VoteView.this.eYq.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.eYs && !VoteView.this.eYt) {
                        if (VoteView.this.eYu) {
                            if (!VoteView.this.alb) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.eYv && VoteView.this.mData.size() > 3) || VoteView.this.alb) {
                                aVar.eYD.setOnClickListener(VoteView.this.eYr);
                            } else {
                                aVar.eYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.eYq.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.eYq.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.eYq.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eHg.setPolledValue(VoteView.this.bu(VoteView.this.eYq));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eHg.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.eYq.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eHg.setPolledValue(VoteView.this.bu(VoteView.this.eYq));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eHg.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.btf();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.eYv && VoteView.this.mData.size() > 3) || VoteView.this.alb) {
                                aVar.eYD.setOnClickListener(VoteView.this.eYr);
                            } else {
                                aVar.eYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.eYq.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eHg.setPolledValue(VoteView.this.bu(VoteView.this.eYq));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eHg.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.eYy != null) {
                                            VoteView.this.eYy.onClick(aVar.eYD);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eHg.getTotalPoll() - num));
                        aVar.eYF.setLayoutParams(layoutParams);
                        aVar.eYE.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.eYI.setText(at.dz(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.eYD.setOnClickListener(VoteView.this.eYr);
                    }
                }
                aVar.eYD.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.eYq = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eYw = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.eYk = (TextView) findViewById(R.id.vote_title);
        this.eYl = (TextView) findViewById(R.id.vote_sub_content);
        this.eYm = (ImageView) findViewById(R.id.vote_view_delete);
        this.eYn = (RecyclerView) findViewById(R.id.vote_item_list);
        this.eYo = findViewById(R.id.vote_list_bottom);
        this.eYp = (TextView) findViewById(R.id.vote_view_btn);
        this.eYp.setOnClickListener(this.eYy);
        this.eYn.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.eYn.setNestedScrollingEnabled(false);
        this.eYn.setAdapter(this.eYz);
        this.eYz.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.alT = str;
        this.mFid = j;
        this.eHg = pollData;
        this.eYs = this.eHg.getIsPolled() == 1;
        this.eYq.clear();
        if (this.eYs && !StringUtils.isNull(this.eHg.getPolledValue())) {
            for (String str2 : this.eHg.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.eYq.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.eYt = this.eHg.getLastTime() <= 0 && this.eHg.getLastTime() != -1;
        this.eYu = this.eHg.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eHg.getTitle())) {
            this.eYk.setText(this.eHg.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.eYn.setLayoutParams(layoutParams);
        this.eYo.setVisibility(8);
        if (this.eYu && !this.eYt && !this.eYs && !this.alb) {
            this.eYp.setVisibility(0);
            this.eYp.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.eYp.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.eYv = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eHg.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eHg.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, eYf);
                    layoutParams.bottomMargin = 0;
                    this.eYn.setLayoutParams(layoutParams);
                    this.eYo.setVisibility(0);
                    this.eYp.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eHg.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eHg.getEndTime();
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
        String dz = at.dz(this.eHg.getTotalNum());
        if (!StringUtils.isNull(dz)) {
            return string + " · " + dz + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.eYz != null) {
            this.eYz.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.eYk.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.eYl.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.eYm != null && onClickListener != null) {
            this.eYm.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.eYr = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.eYm != null) {
            this.eYm.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.alb = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ap.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ap.setBackgroundResource(this.eYo, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.eYo, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.eYk, R.color.cp_cont_b);
        ap.setViewTextColor(this.eYl, R.color.cp_cont_d);
        btf();
        if (this.eYz != null) {
            this.eYz.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eYw != null && !this.eYs && !this.eYt && !this.alb) {
            this.eYw.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eYw != null) {
            this.eYw.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eYj);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.eYp.setBackgroundDrawable(gradientDrawable);
        if (!this.eYs && !y.isEmpty(this.eYq) && this.eYq.size() > 0) {
            ap.setViewTextColor(this.eYp, R.color.cp_link_tip_a);
            this.eYp.setEnabled(true);
            return;
        }
        this.eYp.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.eYp.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.eYH.setVisibility(8);
        aVar.eYI.setVisibility(0);
        aVar.eYD.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.eYD, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.eYI, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.eYD, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.eYI, R.color.cp_cont_b);
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
        aVar.eYH.setVisibility(8);
        aVar.eYI.setVisibility(8);
        aVar.eYD.setGravity(17);
        ap.setViewTextColor(aVar.eYD, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.eYH.setVisibility(0);
        aVar.eYI.setVisibility(8);
        aVar.eYD.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.eYD, R.color.cp_link_tip_a);
            SvgManager.brn().a(aVar.eYH, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.eYD, R.color.cp_cont_b);
        SvgManager.brn().a(aVar.eYH, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.eYG.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eYi);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eYD.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.eYG.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eYg);
        gradientDrawable.setColor(i);
        aVar.eYF.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(eYh);
        gradientDrawable2.setColor(i2);
        aVar.eYE.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(eYi);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eYD.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bu(List<Integer> list) {
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
        public TextView eYD;
        public View eYE;
        public View eYF;
        public LinearLayout eYG;
        public ImageView eYH;
        public TextView eYI;

        public a(View view) {
            super(view);
            this.eYD = (TextView) view.findViewById(R.id.vote_item);
            this.eYE = view.findViewById(R.id.vote_item_background);
            this.eYF = view.findViewById(R.id.vote_item_foreground);
            this.eYG = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.eYH = (ImageView) view.findViewById(R.id.vote_check);
            this.eYI = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
