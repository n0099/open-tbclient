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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private static final int bfK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int eXl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int eXm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] eXn = {bfK, bfK, 0.0f, 0.0f, 0.0f, 0.0f, bfK, bfK};
    private static final float[] eXo = {0.0f, 0.0f, bfK, bfK, bfK, bfK, 0.0f, 0.0f};
    private static final float[] eXp = {bfK, bfK, bfK, bfK, bfK, bfK, bfK, bfK};
    private static final float[] eXq = {eXl, eXl, eXl, eXl, eXl, eXl, eXl, eXl};
    private String alZ;
    private boolean alf;
    private PollData eFy;
    private boolean eXA;
    private boolean eXB;
    private boolean eXC;
    private AddPollPostModel eXD;
    private AddPollPostModel.a eXE;
    private View.OnClickListener eXF;
    private RecyclerView.Adapter<a> eXG;
    private TextView eXr;
    private TextView eXs;
    private ImageView eXt;
    private RecyclerView eXu;
    private View eXv;
    private TextView eXw;
    private List<Integer> eXx;
    private View.OnClickListener eXy;
    private boolean eXz;
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
        this.eXE = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aE(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.eXw.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eFy.setPolledValue(VoteView.this.bu(VoteView.this.eXx));
                    VoteView.this.eFy.setIsPolled(1);
                    VoteView.this.eXz = VoteView.this.eFy.getIsPolled() == 1;
                    VoteView.this.eFy.setTotalNum(VoteView.this.eFy.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eFy.setTotalPoll(VoteView.this.eFy.getTotalPoll() + VoteView.this.eXx.size());
                    if (VoteView.this.eXG != null) {
                        VoteView.this.eXG.notifyDataSetChanged();
                    }
                    VoteView.this.bsv();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.eXF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bu = VoteView.this.bu(VoteView.this.eXx);
                if (VoteView.this.mPageContext != null && VoteView.this.eXD != null && !StringUtils.isNull(VoteView.this.alZ) && VoteView.this.eXE != null && !StringUtils.isNull(bu) && VoteView.this.eFy != null) {
                    VoteView.this.eXD.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.alZ, -1L));
                    VoteView.this.eXD.a(VoteView.this.eXE);
                    VoteView.this.eXD.j(VoteView.this.alZ, bu, VoteView.this.mFid);
                }
            }
        };
        this.eXG = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eFy == null || VoteView.this.eFy.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.eXy != null) {
                        aVar.eXK.setOnClickListener(VoteView.this.eXy);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eFy.getTotalPoll() == num;
                    boolean contains = VoteView.this.eXx.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.eXz && !VoteView.this.eXA) {
                        if (VoteView.this.eXB) {
                            if (!VoteView.this.alf) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.eXC && VoteView.this.mData.size() > 3) || VoteView.this.alf) {
                                aVar.eXK.setOnClickListener(VoteView.this.eXy);
                            } else {
                                aVar.eXK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.eXx.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.eXx.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.eXx.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eFy.setPolledValue(VoteView.this.bu(VoteView.this.eXx));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eFy.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.eXx.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eFy.setPolledValue(VoteView.this.bu(VoteView.this.eXx));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eFy.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.bsv();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.eXC && VoteView.this.mData.size() > 3) || VoteView.this.alf) {
                                aVar.eXK.setOnClickListener(VoteView.this.eXy);
                            } else {
                                aVar.eXK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.eXx.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eFy.setPolledValue(VoteView.this.bu(VoteView.this.eXx));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eFy.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.eXF != null) {
                                            VoteView.this.eXF.onClick(aVar.eXK);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eFy.getTotalPoll() - num));
                        aVar.eXM.setLayoutParams(layoutParams);
                        aVar.eXL.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.eXP.setText(au.dz(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.eXK.setOnClickListener(VoteView.this.eXy);
                    }
                }
                aVar.eXK.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.eXx = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eXD = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.eXr = (TextView) findViewById(R.id.vote_title);
        this.eXs = (TextView) findViewById(R.id.vote_sub_content);
        this.eXt = (ImageView) findViewById(R.id.vote_view_delete);
        this.eXu = (RecyclerView) findViewById(R.id.vote_item_list);
        this.eXv = findViewById(R.id.vote_list_bottom);
        this.eXw = (TextView) findViewById(R.id.vote_view_btn);
        this.eXt.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.eXw.setOnClickListener(this.eXF);
        this.eXu.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.eXu.setNestedScrollingEnabled(false);
        this.eXu.setAdapter(this.eXG);
        this.eXG.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.alZ = str;
        this.mFid = j;
        this.eFy = pollData;
        this.eXz = this.eFy.getIsPolled() == 1;
        this.eXx.clear();
        if (this.eXz && !StringUtils.isNull(this.eFy.getPolledValue())) {
            for (String str2 : this.eFy.getPolledValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                this.eXx.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.eXA = this.eFy.getLastTime() <= 0 && this.eFy.getLastTime() != -1;
        this.eXB = this.eFy.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eFy.getTitle())) {
            this.eXr.setText(this.eFy.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.eXu.setLayoutParams(layoutParams);
        this.eXv.setVisibility(8);
        if (this.eXB && !this.eXA && !this.eXz && !this.alf) {
            this.eXw.setVisibility(0);
            this.eXw.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.eXw.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.eXC = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eFy.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eFy.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, eXm);
                    layoutParams.bottomMargin = 0;
                    this.eXu.setLayoutParams(layoutParams);
                    this.eXv.setVisibility(0);
                    this.eXw.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eFy.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eFy.getEndTime();
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
        String dz = au.dz(this.eFy.getTotalNum());
        if (!StringUtils.isNull(dz)) {
            return string + " · " + dz + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.eXG != null) {
            this.eXG.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXr.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.eXs.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.eXt != null && onClickListener != null) {
            this.eXt.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.eXy = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.eXt != null) {
            this.eXt.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.alf = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bj(this).pb(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ap.setBackgroundResource(this.eXv, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.eXv, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.eXr, R.color.CAM_X0105);
        ap.setViewTextColor(this.eXs, R.color.CAM_X0109);
        bsv();
        if (this.eXG != null) {
            this.eXG.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eXD != null && !this.eXz && !this.eXA && !this.alf) {
            this.eXD.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eXD != null) {
            this.eXD.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eXq);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.08f));
        this.eXw.setBackgroundDrawable(gradientDrawable);
        if (!this.eXz && !y.isEmpty(this.eXx) && this.eXx.size() > 0) {
            ap.setViewTextColor(this.eXw, R.color.CAM_X0302);
            this.eXw.setEnabled(true);
            return;
        }
        this.eXw.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), ap.eMz));
        this.eXw.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.eXO.setVisibility(8);
        aVar.eXP.setVisibility(0);
        aVar.eXK.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.eXK, R.color.CAM_X0302);
            ap.setViewTextColor(aVar.eXP, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ap.setViewTextColor(aVar.eXK, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.eXP, R.color.CAM_X0105);
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
        aVar.eXO.setVisibility(8);
        aVar.eXP.setVisibility(8);
        aVar.eXK.setGravity(17);
        ap.setViewTextColor(aVar.eXK, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.eXO.setVisibility(0);
        aVar.eXP.setVisibility(8);
        aVar.eXK.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ap.setViewTextColor(aVar.eXK, R.color.CAM_X0302);
            SvgManager.bqB().a(aVar.eXO, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.eXK, R.color.CAM_X0105);
        SvgManager.bqB().a(aVar.eXO, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.eXN.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bj(aVar.eXK).pe(R.string.A_X07).pb(R.string.J_X04).pd(R.dimen.L_X01).pc(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bj(aVar.eXK).pb(R.string.J_X04).pd(R.dimen.L_X01).pc(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.eXN.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(eXn);
        gradientDrawable.setColor(ap.getColor(i));
        aVar.eXM.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(eXo);
        gradientDrawable2.setColor(ap.getColor(i2));
        aVar.eXL.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bj(aVar.eXK).pe(R.string.A_X07).pb(R.string.J_X04).pd(R.dimen.L_X01).pc(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bj(aVar.eXK).pb(R.string.J_X04).pd(R.dimen.L_X01).pc(R.color.CAM_X0902).setBackGroundColor(i2);
        }
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
        public TextView eXK;
        public View eXL;
        public View eXM;
        public LinearLayout eXN;
        public ImageView eXO;
        public TextView eXP;

        public a(View view) {
            super(view);
            this.eXK = (TextView) view.findViewById(R.id.vote_item);
            this.eXL = view.findViewById(R.id.vote_item_background);
            this.eXM = view.findViewById(R.id.vote_item_foreground);
            this.eXN = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.eXO = (ImageView) view.findViewById(R.id.vote_check);
            this.eXP = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
