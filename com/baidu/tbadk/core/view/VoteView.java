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
    private static final int bgc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int eSp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int eSq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] eSr = {bgc, bgc, 0.0f, 0.0f, 0.0f, 0.0f, bgc, bgc};
    private static final float[] eSs = {0.0f, 0.0f, bgc, bgc, bgc, bgc, 0.0f, 0.0f};
    private static final float[] eSt = {bgc, bgc, bgc, bgc, bgc, bgc, bgc, bgc};
    private static final float[] eSu = {eSp, eSp, eSp, eSp, eSp, eSp, eSp, eSp};
    private String alT;
    private boolean alb;
    private PollData eBr;
    private TextView eSA;
    private List<Integer> eSB;
    private View.OnClickListener eSC;
    private boolean eSD;
    private boolean eSE;
    private boolean eSF;
    private boolean eSG;
    private AddPollPostModel eSH;
    private AddPollPostModel.a eSI;
    private View.OnClickListener eSJ;
    private RecyclerView.Adapter<a> eSK;
    private TextView eSv;
    private TextView eSw;
    private ImageView eSx;
    private RecyclerView eSy;
    private View eSz;
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
        this.eSI = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aC(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.eSA.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eBr.setPolledValue(VoteView.this.bn(VoteView.this.eSB));
                    VoteView.this.eBr.setIsPolled(1);
                    VoteView.this.eSD = VoteView.this.eBr.getIsPolled() == 1;
                    VoteView.this.eBr.setTotalNum(VoteView.this.eBr.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eBr.setTotalPoll(VoteView.this.eBr.getTotalPoll() + VoteView.this.eSB.size());
                    if (VoteView.this.eSK != null) {
                        VoteView.this.eSK.notifyDataSetChanged();
                    }
                    VoteView.this.bqF();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.eSJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bn = VoteView.this.bn(VoteView.this.eSB);
                if (VoteView.this.mPageContext != null && VoteView.this.eSH != null && !StringUtils.isNull(VoteView.this.alT) && VoteView.this.eSI != null && !StringUtils.isNull(bn) && VoteView.this.eBr != null) {
                    VoteView.this.eSH.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.alT, -1L));
                    VoteView.this.eSH.a(VoteView.this.eSI);
                    VoteView.this.eSH.j(VoteView.this.alT, bn, VoteView.this.mFid);
                }
            }
        };
        this.eSK = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eBr == null || VoteView.this.eBr.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.eSC != null) {
                        aVar.eSO.setOnClickListener(VoteView.this.eSC);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eBr.getTotalPoll() == num;
                    boolean contains = VoteView.this.eSB.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.eSD && !VoteView.this.eSE) {
                        if (VoteView.this.eSF) {
                            if (!VoteView.this.alb) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.eSG && VoteView.this.mData.size() > 3) || VoteView.this.alb) {
                                aVar.eSO.setOnClickListener(VoteView.this.eSC);
                            } else {
                                aVar.eSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.eSB.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.eSB.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.eSB.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eBr.setPolledValue(VoteView.this.bn(VoteView.this.eSB));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eBr.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.eSB.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eBr.setPolledValue(VoteView.this.bn(VoteView.this.eSB));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eBr.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.bqF();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.eSG && VoteView.this.mData.size() > 3) || VoteView.this.alb) {
                                aVar.eSO.setOnClickListener(VoteView.this.eSC);
                            } else {
                                aVar.eSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.eSB.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eBr.setPolledValue(VoteView.this.bn(VoteView.this.eSB));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eBr.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.eSJ != null) {
                                            VoteView.this.eSJ.onClick(aVar.eSO);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eBr.getTotalPoll() - num));
                        aVar.eSQ.setLayoutParams(layoutParams);
                        aVar.eSP.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.eST.setText(at.dd(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.eSO.setOnClickListener(VoteView.this.eSC);
                    }
                }
                aVar.eSO.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.eSB = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eSH = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.eSv = (TextView) findViewById(R.id.vote_title);
        this.eSw = (TextView) findViewById(R.id.vote_sub_content);
        this.eSx = (ImageView) findViewById(R.id.vote_view_delete);
        this.eSy = (RecyclerView) findViewById(R.id.vote_item_list);
        this.eSz = findViewById(R.id.vote_list_bottom);
        this.eSA = (TextView) findViewById(R.id.vote_view_btn);
        this.eSA.setOnClickListener(this.eSJ);
        this.eSy.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.eSy.setNestedScrollingEnabled(false);
        this.eSy.setAdapter(this.eSK);
        this.eSK.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.alT = str;
        this.mFid = j;
        this.eBr = pollData;
        this.eSD = this.eBr.getIsPolled() == 1;
        this.eSB.clear();
        if (this.eSD && !StringUtils.isNull(this.eBr.getPolledValue())) {
            for (String str2 : this.eBr.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.eSB.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.eSE = this.eBr.getLastTime() <= 0 && this.eBr.getLastTime() != -1;
        this.eSF = this.eBr.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eBr.getTitle())) {
            this.eSv.setText(this.eBr.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.eSy.setLayoutParams(layoutParams);
        this.eSz.setVisibility(8);
        if (this.eSF && !this.eSE && !this.eSD && !this.alb) {
            this.eSA.setVisibility(0);
            this.eSA.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.eSA.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.eSG = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eBr.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eBr.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, eSq);
                    layoutParams.bottomMargin = 0;
                    this.eSy.setLayoutParams(layoutParams);
                    this.eSz.setVisibility(0);
                    this.eSA.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eBr.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eBr.getEndTime();
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
        String dd = at.dd(this.eBr.getTotalNum());
        if (!StringUtils.isNull(dd)) {
            return string + " · " + dd + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.eSK != null) {
            this.eSK.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.eSv.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.eSw.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.eSx != null && onClickListener != null) {
            this.eSx.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.eSC = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.eSx != null) {
            this.eSx.setVisibility(i);
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
            ap.setBackgroundResource(this.eSz, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.eSz, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.eSv, R.color.cp_cont_b);
        ap.setViewTextColor(this.eSw, R.color.cp_cont_d);
        bqF();
        if (this.eSK != null) {
            this.eSK.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eSH != null && !this.eSD && !this.eSE && !this.alb) {
            this.eSH.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eSH != null) {
            this.eSH.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eSu);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.eSA.setBackgroundDrawable(gradientDrawable);
        if (!this.eSD && !y.isEmpty(this.eSB) && this.eSB.size() > 0) {
            ap.setViewTextColor(this.eSA, R.color.cp_link_tip_a);
            this.eSA.setEnabled(true);
            return;
        }
        this.eSA.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.eSA.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.eSS.setVisibility(8);
        aVar.eST.setVisibility(0);
        aVar.eSO.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.eSO, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.eST, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.eSO, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.eST, R.color.cp_cont_b);
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
        aVar.eSS.setVisibility(8);
        aVar.eST.setVisibility(8);
        aVar.eSO.setGravity(17);
        ap.setViewTextColor(aVar.eSO, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.eSS.setVisibility(0);
        aVar.eST.setVisibility(8);
        aVar.eSO.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.eSO, R.color.cp_link_tip_a);
            SvgManager.boN().a(aVar.eSS, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.eSO, R.color.cp_cont_b);
        SvgManager.boN().a(aVar.eSS, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.eSR.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eSt);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eSO.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.eSR.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eSr);
        gradientDrawable.setColor(i);
        aVar.eSQ.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(eSs);
        gradientDrawable2.setColor(i2);
        aVar.eSP.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(eSt);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eSO.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bn(List<Integer> list) {
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
        public TextView eSO;
        public View eSP;
        public View eSQ;
        public LinearLayout eSR;
        public ImageView eSS;
        public TextView eST;

        public a(View view) {
            super(view);
            this.eSO = (TextView) view.findViewById(R.id.vote_item);
            this.eSP = view.findViewById(R.id.vote_item_background);
            this.eSQ = view.findViewById(R.id.vote_item_foreground);
            this.eSR = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.eSS = (ImageView) view.findViewById(R.id.vote_check);
            this.eST = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
