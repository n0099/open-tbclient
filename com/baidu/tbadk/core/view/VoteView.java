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
    private static final int beM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int eJT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int eJU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] eJV = {beM, beM, 0.0f, 0.0f, 0.0f, 0.0f, beM, beM};
    private static final float[] eJW = {0.0f, 0.0f, beM, beM, beM, beM, 0.0f, 0.0f};
    private static final float[] eJX = {beM, beM, beM, beM, beM, beM, beM, beM};
    private static final float[] eJY = {eJT, eJT, eJT, eJT, eJT, eJT, eJT, eJT};
    private String alS;
    private boolean ala;
    private TextView eJZ;
    private TextView eKa;
    private ImageView eKb;
    private RecyclerView eKc;
    private View eKd;
    private TextView eKe;
    private List<Integer> eKf;
    private View.OnClickListener eKg;
    private boolean eKh;
    private boolean eKi;
    private boolean eKj;
    private boolean eKk;
    private AddPollPostModel eKl;
    private AddPollPostModel.a eKm;
    private View.OnClickListener eKn;
    private RecyclerView.Adapter<a> eKo;
    private PollData esR;
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
        this.eKm = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aA(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.eKe.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.esR.setPolledValue(VoteView.this.bd(VoteView.this.eKf));
                    VoteView.this.esR.setIsPolled(1);
                    VoteView.this.eKh = VoteView.this.esR.getIsPolled() == 1;
                    VoteView.this.esR.setTotalNum(VoteView.this.esR.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.esR.setTotalPoll(VoteView.this.esR.getTotalPoll() + VoteView.this.eKf.size());
                    if (VoteView.this.eKo != null) {
                        VoteView.this.eKo.notifyDataSetChanged();
                    }
                    VoteView.this.boM();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.eKn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bd = VoteView.this.bd(VoteView.this.eKf);
                if (VoteView.this.mPageContext != null && VoteView.this.eKl != null && !StringUtils.isNull(VoteView.this.alS) && VoteView.this.eKm != null && !StringUtils.isNull(bd) && VoteView.this.esR != null) {
                    VoteView.this.eKl.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.alS, -1L));
                    VoteView.this.eKl.a(VoteView.this.eKm);
                    VoteView.this.eKl.j(VoteView.this.alS, bd, VoteView.this.mFid);
                }
            }
        };
        this.eKo = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.esR == null || VoteView.this.esR.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.eKg != null) {
                        aVar.eKs.setOnClickListener(VoteView.this.eKg);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.esR.getTotalPoll() == num;
                    boolean contains = VoteView.this.eKf.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.eKh && !VoteView.this.eKi) {
                        if (VoteView.this.eKj) {
                            if (!VoteView.this.ala) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.eKk && VoteView.this.mData.size() > 3) || VoteView.this.ala) {
                                aVar.eKs.setOnClickListener(VoteView.this.eKg);
                            } else {
                                aVar.eKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.eKf.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.eKf.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.eKf.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.esR.setPolledValue(VoteView.this.bd(VoteView.this.eKf));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.esR.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.eKf.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.esR.setPolledValue(VoteView.this.bd(VoteView.this.eKf));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.esR.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.boM();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.eKk && VoteView.this.mData.size() > 3) || VoteView.this.ala) {
                                aVar.eKs.setOnClickListener(VoteView.this.eKg);
                            } else {
                                aVar.eKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.eKf.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.esR.setPolledValue(VoteView.this.bd(VoteView.this.eKf));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.esR.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.eKn != null) {
                                            VoteView.this.eKn.onClick(aVar.eKs);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.esR.getTotalPoll() - num));
                        aVar.eKu.setLayoutParams(layoutParams);
                        aVar.eKt.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.eKx.setText(at.db(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.eKs.setOnClickListener(VoteView.this.eKg);
                    }
                }
                aVar.eKs.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.eKf = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eKl = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.eJZ = (TextView) findViewById(R.id.vote_title);
        this.eKa = (TextView) findViewById(R.id.vote_sub_content);
        this.eKb = (ImageView) findViewById(R.id.vote_view_delete);
        this.eKc = (RecyclerView) findViewById(R.id.vote_item_list);
        this.eKd = findViewById(R.id.vote_list_bottom);
        this.eKe = (TextView) findViewById(R.id.vote_view_btn);
        this.eKe.setOnClickListener(this.eKn);
        this.eKc.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.eKc.setNestedScrollingEnabled(false);
        this.eKc.setAdapter(this.eKo);
        this.eKo.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.alS = str;
        this.mFid = j;
        this.esR = pollData;
        this.eKh = this.esR.getIsPolled() == 1;
        this.eKf.clear();
        if (this.eKh && !StringUtils.isNull(this.esR.getPolledValue())) {
            for (String str2 : this.esR.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.eKf.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.eKi = this.esR.getLastTime() <= 0 && this.esR.getLastTime() != -1;
        this.eKj = this.esR.getIsMulti() == 1;
        if (!StringUtils.isNull(this.esR.getTitle())) {
            this.eJZ.setText(this.esR.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.eKc.setLayoutParams(layoutParams);
        this.eKd.setVisibility(8);
        if (this.eKj && !this.eKi && !this.eKh && !this.ala) {
            this.eKe.setVisibility(0);
            this.eKe.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.eKe.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.eKk = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.esR.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.esR.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, eJU);
                    layoutParams.bottomMargin = 0;
                    this.eKc.setLayoutParams(layoutParams);
                    this.eKd.setVisibility(0);
                    this.eKe.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.esR.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.esR.getEndTime();
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
        String db = at.db(this.esR.getTotalNum());
        if (!StringUtils.isNull(db)) {
            return string + " · " + db + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.eKo != null) {
            this.eKo.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.eJZ.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.eKa.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.eKb != null && onClickListener != null) {
            this.eKb.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.eKg = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.eKb != null) {
            this.eKb.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.ala = z;
    }

    public void onChangeSkinType(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        gradientDrawable.setColor(ap.getColor(this.mBgColor));
        setBackgroundDrawable(gradientDrawable);
        if (this.mBgColor == R.color.cp_bg_line_e) {
            ap.setBackgroundResource(this.eKd, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.eKd, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.eJZ, R.color.cp_cont_b);
        ap.setViewTextColor(this.eKa, R.color.cp_cont_d);
        boM();
        if (this.eKo != null) {
            this.eKo.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eKl != null && !this.eKh && !this.eKi && !this.ala) {
            this.eKl.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eKl != null) {
            this.eKl.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boM() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eJY);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.08f));
        this.eKe.setBackgroundDrawable(gradientDrawable);
        if (!this.eKh && !y.isEmpty(this.eKf) && this.eKf.size() > 0) {
            ap.setViewTextColor(this.eKe, R.color.cp_link_tip_a);
            this.eKe.setEnabled(true);
            return;
        }
        this.eKe.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.3f));
        this.eKe.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.eKw.setVisibility(8);
        aVar.eKx.setVisibility(0);
        aVar.eKs.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.eKs, R.color.cp_link_tip_a);
            ap.setViewTextColor(aVar.eKx, R.color.cp_link_tip_a);
            if (z2) {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f));
                return;
            } else {
                a(aVar, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.16f), ap.getColor(R.color.cp_bg_line_h));
                return;
            }
        }
        ap.setViewTextColor(aVar.eKs, R.color.cp_cont_b);
        ap.setViewTextColor(aVar.eKx, R.color.cp_cont_b);
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
        aVar.eKw.setVisibility(8);
        aVar.eKx.setVisibility(8);
        aVar.eKs.setGravity(17);
        ap.setViewTextColor(aVar.eKs, R.color.cp_cont_b);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.eKw.setVisibility(0);
        aVar.eKx.setVisibility(8);
        aVar.eKs.setGravity(19);
        a(aVar, ap.getColor(R.color.cp_bg_line_h));
        if (z) {
            ap.setViewTextColor(aVar.eKs, R.color.cp_link_tip_a);
            SvgManager.bmU().a(aVar.eKw, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.cp_link_tip_a, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.eKs, R.color.cp_cont_b);
        SvgManager.bmU().a(aVar.eKw, R.drawable.ic_icon_pure_strok3_24_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i) {
        aVar.eKv.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eJX);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eKs.setBackgroundDrawable(gradientDrawable);
    }

    private void a(a aVar, int i, int i2) {
        aVar.eKv.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eJV);
        gradientDrawable.setColor(i);
        aVar.eKu.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(eJW);
        gradientDrawable2.setColor(i2);
        aVar.eKt.setBackgroundDrawable(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadii(eJX);
        gradientDrawable3.setColor(0);
        gradientDrawable3.setStroke(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds1), com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_border_d), 0.16f));
        aVar.eKs.setBackgroundDrawable(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bd(List<Integer> list) {
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
        public TextView eKs;
        public View eKt;
        public View eKu;
        public LinearLayout eKv;
        public ImageView eKw;
        public TextView eKx;

        public a(View view) {
            super(view);
            this.eKs = (TextView) view.findViewById(R.id.vote_item);
            this.eKt = view.findViewById(R.id.vote_item_background);
            this.eKu = view.findViewById(R.id.vote_item_foreground);
            this.eKv = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.eKw = (ImageView) view.findViewById(R.id.vote_check);
            this.eKx = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
