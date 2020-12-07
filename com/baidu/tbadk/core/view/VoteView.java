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
    private static final int bka = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int feI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int feJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] feK = {bka, bka, 0.0f, 0.0f, 0.0f, 0.0f, bka, bka};
    private static final float[] feL = {0.0f, 0.0f, bka, bka, bka, bka, 0.0f, 0.0f};
    private static final float[] feM = {bka, bka, bka, bka, bka, bka, bka, bka};
    private static final float[] feN = {feI, feI, feI, feI, feI, feI, feI, feI};
    private String amY;
    private boolean amg;
    private PollData eMA;
    private TextView feO;
    private TextView feP;
    private ImageView feQ;
    private RecyclerView feR;
    private View feS;
    private TextView feT;
    private List<Integer> feU;
    private View.OnClickListener feV;
    private boolean feW;
    private boolean feX;
    private boolean feY;
    private boolean feZ;
    private AddPollPostModel ffa;
    private AddPollPostModel.a ffb;
    private View.OnClickListener ffc;
    private RecyclerView.Adapter<a> ffd;
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
        this.ffb = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aE(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.feT.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eMA.setPolledValue(VoteView.this.by(VoteView.this.feU));
                    VoteView.this.eMA.setIsPolled(1);
                    VoteView.this.feW = VoteView.this.eMA.getIsPolled() == 1;
                    VoteView.this.eMA.setTotalNum(VoteView.this.eMA.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eMA.setTotalPoll(VoteView.this.eMA.getTotalPoll() + VoteView.this.feU.size());
                    if (VoteView.this.ffd != null) {
                        VoteView.this.ffd.notifyDataSetChanged();
                    }
                    VoteView.this.bvV();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.ffc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String by = VoteView.this.by(VoteView.this.feU);
                if (VoteView.this.mPageContext != null && VoteView.this.ffa != null && !StringUtils.isNull(VoteView.this.amY) && VoteView.this.ffb != null && !StringUtils.isNull(by) && VoteView.this.eMA != null) {
                    VoteView.this.ffa.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.amY, -1L));
                    VoteView.this.ffa.a(VoteView.this.ffb);
                    VoteView.this.ffa.j(VoteView.this.amY, by, VoteView.this.mFid);
                }
            }
        };
        this.ffd = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: i */
            public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
                return new a(LayoutInflater.from(VoteView.this.mContext).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull final a aVar, final int i2) {
                if (VoteView.this.eMA == null || VoteView.this.eMA.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.feV != null) {
                        aVar.ffh.setOnClickListener(VoteView.this.feV);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eMA.getTotalPoll() == num;
                    boolean contains = VoteView.this.feU.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.feW && !VoteView.this.feX) {
                        if (VoteView.this.feY) {
                            if (!VoteView.this.amg) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.feZ && VoteView.this.mData.size() > 3) || VoteView.this.amg) {
                                aVar.ffh.setOnClickListener(VoteView.this.feV);
                            } else {
                                aVar.ffh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.feU.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.feU.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.feU.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eMA.setPolledValue(VoteView.this.by(VoteView.this.feU));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eMA.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.feU.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eMA.setPolledValue(VoteView.this.by(VoteView.this.feU));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eMA.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.bvV();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.feZ && VoteView.this.mData.size() > 3) || VoteView.this.amg) {
                                aVar.ffh.setOnClickListener(VoteView.this.feV);
                            } else {
                                aVar.ffh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.feU.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eMA.setPolledValue(VoteView.this.by(VoteView.this.feU));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eMA.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.ffc != null) {
                                            VoteView.this.ffc.onClick(aVar.ffh);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eMA.getTotalPoll() - num));
                        aVar.ffj.setLayoutParams(layoutParams);
                        aVar.ffi.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.ffm.setText(au.dY(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.ffh.setOnClickListener(VoteView.this.feV);
                    }
                }
                aVar.ffh.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.feU = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ffa = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.feO = (TextView) findViewById(R.id.vote_title);
        this.feP = (TextView) findViewById(R.id.vote_sub_content);
        this.feQ = (ImageView) findViewById(R.id.vote_view_delete);
        this.feR = (RecyclerView) findViewById(R.id.vote_item_list);
        this.feS = findViewById(R.id.vote_list_bottom);
        this.feT = (TextView) findViewById(R.id.vote_view_btn);
        this.feQ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.feT.setOnClickListener(this.ffc);
        this.feR.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.feR.setNestedScrollingEnabled(false);
        this.feR.setAdapter(this.ffd);
        this.ffd.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.amY = str;
        this.mFid = j;
        this.eMA = pollData;
        this.feW = this.eMA.getIsPolled() == 1;
        this.feU.clear();
        if (this.feW && !StringUtils.isNull(this.eMA.getPolledValue())) {
            for (String str2 : this.eMA.getPolledValue().split(",")) {
                this.feU.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.feX = this.eMA.getLastTime() <= 0 && this.eMA.getLastTime() != -1;
        this.feY = this.eMA.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eMA.getTitle())) {
            this.feO.setText(this.eMA.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.feR.setLayoutParams(layoutParams);
        this.feS.setVisibility(8);
        if (this.feY && !this.feX && !this.feW && !this.amg) {
            this.feT.setVisibility(0);
            this.feT.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.feT.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.feZ = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eMA.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eMA.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, feJ);
                    layoutParams.bottomMargin = 0;
                    this.feR.setLayoutParams(layoutParams);
                    this.feS.setVisibility(0);
                    this.feT.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eMA.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eMA.getEndTime();
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
        String dY = au.dY(this.eMA.getTotalNum());
        if (!StringUtils.isNull(dY)) {
            return string + " · " + dY + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.ffd != null) {
            this.ffd.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.feO.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.feP.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.feQ != null && onClickListener != null) {
            this.feQ.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.feV = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.feQ != null) {
            this.feQ.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.amg = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bm(this).pA(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ap.setBackgroundResource(this.feS, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.feS, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.feO, R.color.CAM_X0105);
        ap.setViewTextColor(this.feP, R.color.CAM_X0109);
        bvV();
        if (this.ffd != null) {
            this.ffd.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ffa != null && !this.feW && !this.feX && !this.amg) {
            this.ffa.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ffa != null) {
            this.ffa.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvV() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(feN);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.08f));
        this.feT.setBackgroundDrawable(gradientDrawable);
        if (!this.feW && !y.isEmpty(this.feU) && this.feU.size() > 0) {
            ap.setViewTextColor(this.feT, R.color.CAM_X0302);
            this.feT.setEnabled(true);
            return;
        }
        this.feT.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), ap.eTL));
        this.feT.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.ffl.setVisibility(8);
        aVar.ffm.setVisibility(0);
        aVar.ffh.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.ffh, R.color.CAM_X0302);
            ap.setViewTextColor(aVar.ffm, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ap.setViewTextColor(aVar.ffh, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.ffm, R.color.CAM_X0105);
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
        aVar.ffl.setVisibility(8);
        aVar.ffm.setVisibility(8);
        aVar.ffh.setGravity(17);
        ap.setViewTextColor(aVar.ffh, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.ffl.setVisibility(0);
        aVar.ffm.setVisibility(8);
        aVar.ffh.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ap.setViewTextColor(aVar.ffh, R.color.CAM_X0302);
            SvgManager.btW().a(aVar.ffl, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.ffh, R.color.CAM_X0105);
        SvgManager.btW().a(aVar.ffl, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.ffk.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bm(aVar.ffh).pE(R.string.A_X07).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(aVar.ffh).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.ffk.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(feK);
        gradientDrawable.setColor(ap.getColor(i));
        aVar.ffj.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(feL);
        gradientDrawable2.setColor(ap.getColor(i2));
        aVar.ffi.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bm(aVar.ffh).pE(R.string.A_X07).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(aVar.ffh).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0902).setBackGroundColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String by(List<Integer> list) {
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
        public TextView ffh;
        public View ffi;
        public View ffj;
        public LinearLayout ffk;
        public ImageView ffl;
        public TextView ffm;

        public a(View view) {
            super(view);
            this.ffh = (TextView) view.findViewById(R.id.vote_item);
            this.ffi = view.findViewById(R.id.vote_item_background);
            this.ffj = view.findViewById(R.id.vote_item_foreground);
            this.ffk = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.ffl = (ImageView) view.findViewById(R.id.vote_check);
            this.ffm = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
