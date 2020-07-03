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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private boolean aiY;
    private String ajO;
    private PollData dON;
    private TextView efC;
    private TextView efD;
    private ImageView efE;
    private RecyclerView efF;
    private View efG;
    private TextView efH;
    private List<Integer> efI;
    private View.OnClickListener efJ;
    private boolean efK;
    private boolean efL;
    private boolean efM;
    private boolean efN;
    private AddPollPostModel efO;
    private AddPollPostModel.a efP;
    private View.OnClickListener efQ;
    private RecyclerView.Adapter<a> efR;
    private int mBgColor;
    private Context mContext;
    private List<PollOptionData> mData;
    private long mFid;
    private TbPageContext mPageContext;
    private static final int aRW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int efw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int efx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] efy = {aRW, aRW, 0.0f, 0.0f, 0.0f, 0.0f, aRW, aRW};
    private static final float[] efz = {0.0f, 0.0f, aRW, aRW, aRW, aRW, 0.0f, 0.0f};
    private static final float[] efA = {aRW, aRW, aRW, aRW, aRW, aRW, aRW, aRW};
    private static final float[] efB = {efw, efw, efw, efw, efw, efw, efw, efw};

    public VoteView(Context context) {
        this(context, null);
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgColor = R.color.cp_bg_line_g;
        this.efP = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void ap(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.efH.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.dON.setPolledValue(VoteView.this.aQ(VoteView.this.efI));
                    VoteView.this.dON.setIsPolled(1);
                    VoteView.this.efK = VoteView.this.dON.getIsPolled() == 1;
                    VoteView.this.dON.setTotalNum(VoteView.this.dON.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.dON.setTotalPoll(VoteView.this.dON.getTotalPoll() + VoteView.this.efI.size());
                    if (VoteView.this.efR != null) {
                        VoteView.this.efR.notifyDataSetChanged();
                    }
                    VoteView.this.aYM();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.efQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String aQ = VoteView.this.aQ(VoteView.this.efI);
                if (VoteView.this.mPageContext != null && VoteView.this.efO != null && !StringUtils.isNull(VoteView.this.ajO) && VoteView.this.efP != null && !StringUtils.isNull(aQ) && VoteView.this.dON != null) {
                    VoteView.this.efO.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.ajO, -1L));
                    VoteView.this.efO.a(VoteView.this.efP);
                    VoteView.this.efO.i(VoteView.this.ajO, aQ, VoteView.this.mFid);
                }
            }
        };
        this.efR = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.dON == null || VoteView.this.dON.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.efJ != null) {
                        aVar.efV.setOnClickListener(VoteView.this.efJ);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.dON.getTotalPoll() == num;
                    boolean contains = VoteView.this.efI.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.efK && !VoteView.this.efL) {
                        if (VoteView.this.efM) {
                            if (!VoteView.this.aiY) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.efN && VoteView.this.mData.size() > 3) || VoteView.this.aiY) {
                                aVar.efV.setOnClickListener(VoteView.this.efJ);
                            } else {
                                aVar.efV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.efI.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.efI.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.efI.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.dON.setPolledValue(VoteView.this.aQ(VoteView.this.efI));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.dON.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.efI.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.dON.setPolledValue(VoteView.this.aQ(VoteView.this.efI));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.dON.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.aYM();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.efN && VoteView.this.mData.size() > 3) || VoteView.this.aiY) {
                                aVar.efV.setOnClickListener(VoteView.this.efJ);
                            } else {
                                aVar.efV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.efI.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.dON.setPolledValue(VoteView.this.aQ(VoteView.this.efI));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.dON.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.efQ != null) {
                                            VoteView.this.efQ.onClick(aVar.efV);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.dON.getTotalPoll() - num));
                        aVar.efX.setLayoutParams(layoutParams);
                        aVar.efW.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.ega.setText(ar.co(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.efV.setOnClickListener(VoteView.this.efJ);
                    }
                }
                aVar.efV.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.efI = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.efO = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.efC = (TextView) findViewById(R.id.vote_title);
        this.efD = (TextView) findViewById(R.id.vote_sub_content);
        this.efE = (ImageView) findViewById(R.id.vote_view_delete);
        this.efF = (RecyclerView) findViewById(R.id.vote_item_list);
        this.efG = findViewById(R.id.vote_list_bottom);
        this.efH = (TextView) findViewById(R.id.vote_view_btn);
        this.efH.setOnClickListener(this.efQ);
        this.efF.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.efF.setNestedScrollingEnabled(false);
        this.efF.setAdapter(this.efR);
        this.efR.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.ajO = str;
        this.mFid = j;
        this.dON = pollData;
        this.efK = this.dON.getIsPolled() == 1;
        this.efI.clear();
        if (this.efK && !StringUtils.isNull(this.dON.getPolledValue())) {
            for (String str2 : this.dON.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.efI.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.efL = this.dON.getLastTime() <= 0 && this.dON.getLastTime() != -1;
        this.efM = this.dON.getIsMulti() == 1;
        if (!StringUtils.isNull(this.dON.getTitle())) {
            this.efC.setText(this.dON.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.efF.setLayoutParams(layoutParams);
        this.efG.setVisibility(8);
        if (this.efM && !this.efL && !this.efK && !this.aiY) {
            this.efH.setVisibility(0);
            this.efH.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.efH.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.efN = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.dON.getOptions();
            if (!w.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.dON.getOptions();
            if (!w.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, efx);
                    layoutParams.bottomMargin = 0;
                    this.efF.setLayoutParams(layoutParams);
                    this.efG.setVisibility(0);
                    this.efH.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.dON.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.dON.getEndTime();
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
        String co = ar.co(this.dON.getTotalNum());
        if (!StringUtils.isNull(co)) {
            return string + " · " + co + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.efR != null) {
            this.efR.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.efC.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.efD.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.efE != null && onClickListener != null) {
            this.efE.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.efJ = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.efE != null) {
            this.efE.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.aiY = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(an.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            an.setBackgroundResource(this.efG, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            an.setBackgroundResource(this.efG, R.drawable.bg_vote_list_bottom);
        }
        an.setViewTextColor(this.efC, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.efD, (int) R.color.cp_cont_d);
        aYM();
        if (this.efR != null) {
            this.efR.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.efO != null && !this.efK && !this.efL && !this.aiY) {
            this.efO.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.efO != null) {
            this.efO.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYM() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(efB);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.08f));
        this.efH.setBackgroundDrawable(gradientDrawable);
        if (!this.efK && !w.isEmpty(this.efI) && this.efI.size() > 0) {
            an.setViewTextColor(this.efH, (int) R.color.cp_link_tip_a);
            this.efH.setEnabled(true);
            return;
        }
        this.efH.setTextColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.3f));
        this.efH.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.efZ.setVisibility(8);
        aVar.ega.setVisibility(0);
        aVar.efV.setGravity(19);
        if (z) {
            an.setViewTextColor(aVar.efV, (int) R.color.cp_link_tip_a);
            an.setViewTextColor(aVar.ega, (int) R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.16f), an.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        an.setViewTextColor(aVar.efV, (int) R.color.cp_cont_b);
        an.setViewTextColor(aVar.ega, (int) R.color.cp_cont_b);
        if (z3) {
            a(aVar, an.getColor(R.color.cp_bg_line_h));
        } else if (z2) {
            a(aVar, an.getColor(R.color.cp_bg_line_b));
        } else {
            a(aVar, an.getColor(R.color.cp_bg_line_b), an.getColor(R.color.cp_bg_line_h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingleUnCheckItemView(a aVar) {
        aVar.efZ.setVisibility(8);
        aVar.ega.setVisibility(8);
        aVar.efV.setGravity(17);
        an.setViewTextColor(aVar.efV, (int) R.color.cp_cont_b);
        a(aVar, an.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.efZ.setVisibility(0);
        aVar.ega.setVisibility(8);
        aVar.efV.setGravity(19);
        a(aVar, an.getColor(R.color.cp_bg_line_h));
        if (z) {
            an.setViewTextColor(aVar.efV, (int) R.color.cp_link_tip_a);
            SvgManager.aWQ().a(aVar.efZ, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        an.setViewTextColor(aVar.efV, (int) R.color.cp_cont_b);
        SvgManager.aWQ().a(aVar.efZ, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.efY.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(efA);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_border_d), 0.16f));
        aVar.efV.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.efY.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(efy);
        gradientDrawable.setColor(i);
        aVar.efX.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(efz);
        gradientDrawable2.setColor(i2);
        aVar.efW.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(efA);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_border_d), 0.16f));
        aVar.efV.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQ(List<Integer> list) {
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
        public TextView efV;
        public View efW;
        public View efX;
        public LinearLayout efY;
        public ImageView efZ;
        public TextView ega;

        public a(View view) {
            super(view);
            this.efV = (TextView) view.findViewById(R.id.vote_item);
            this.efW = view.findViewById(R.id.vote_item_background);
            this.efX = view.findViewById(R.id.vote_item_foreground);
            this.efY = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.efZ = (ImageView) view.findViewById(R.id.vote_check);
            this.ega = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
