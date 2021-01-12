package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.model.AddPollPostModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class VoteView extends LinearLayout {
    private static final int bgP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int fjH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int fjI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] fjJ = {bgP, bgP, 0.0f, 0.0f, 0.0f, 0.0f, bgP, bgP};
    private static final float[] fjK = {0.0f, 0.0f, bgP, bgP, bgP, bgP, 0.0f, 0.0f};
    private static final float[] fjL = {bgP, bgP, bgP, bgP, bgP, bgP, bgP, bgP};
    private static final float[] fjM = {fjH, fjH, fjH, fjH, fjH, fjH, fjH, fjH};
    private boolean alR;
    private String amM;
    private PollData eRK;
    private TextView fjN;
    private TextView fjO;
    private ImageView fjP;
    private RecyclerView fjQ;
    private View fjR;
    private TextView fjS;
    private List<Integer> fjT;
    private View.OnClickListener fjU;
    private boolean fjV;
    private boolean fjW;
    private boolean fjX;
    private boolean fjY;
    private AddPollPostModel fjZ;
    private AddPollPostModel.a fka;
    private View.OnClickListener fkb;
    private RecyclerView.Adapter<a> fkc;
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
        this.fka = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aH(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.fjS.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eRK.setPolledValue(VoteView.this.bF(VoteView.this.fjT));
                    VoteView.this.eRK.setIsPolled(1);
                    VoteView.this.fjV = VoteView.this.eRK.getIsPolled() == 1;
                    VoteView.this.eRK.setTotalNum(VoteView.this.eRK.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eRK.setTotalPoll(VoteView.this.eRK.getTotalPoll() + VoteView.this.fjT.size());
                    if (VoteView.this.fkc != null) {
                        VoteView.this.fkc.notifyDataSetChanged();
                    }
                    VoteView.this.buw();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.fkb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bF = VoteView.this.bF(VoteView.this.fjT);
                if (VoteView.this.mPageContext != null && VoteView.this.fjZ != null && !StringUtils.isNull(VoteView.this.amM) && VoteView.this.fka != null && !StringUtils.isNull(bF) && VoteView.this.eRK != null) {
                    VoteView.this.fjZ.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.amM, -1L));
                    VoteView.this.fjZ.a(VoteView.this.fka);
                    VoteView.this.fjZ.k(VoteView.this.amM, bF, VoteView.this.mFid);
                }
            }
        };
        this.fkc = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: m */
            public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
                return new a(LayoutInflater.from(VoteView.this.mContext).inflate(R.layout.view_vote_text_item, viewGroup, false));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull final a aVar, final int i2) {
                if (VoteView.this.eRK == null || VoteView.this.eRK.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.fjU != null) {
                        aVar.fkg.setOnClickListener(VoteView.this.fjU);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eRK.getTotalPoll() == num;
                    boolean contains = VoteView.this.fjT.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.fjV && !VoteView.this.fjW) {
                        if (VoteView.this.fjX) {
                            if (!VoteView.this.alR) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.fjY && VoteView.this.mData.size() > 3) || VoteView.this.alR) {
                                aVar.fkg.setOnClickListener(VoteView.this.fjU);
                            } else {
                                aVar.fkg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.fjT.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.fjT.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.fjT.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eRK.setPolledValue(VoteView.this.bF(VoteView.this.fjT));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eRK.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.fjT.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eRK.setPolledValue(VoteView.this.bF(VoteView.this.fjT));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eRK.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.buw();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.fjY && VoteView.this.mData.size() > 3) || VoteView.this.alR) {
                                aVar.fkg.setOnClickListener(VoteView.this.fjU);
                            } else {
                                aVar.fkg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.fjT.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eRK.setPolledValue(VoteView.this.bF(VoteView.this.fjT));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eRK.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.fkb != null) {
                                            VoteView.this.fkb.onClick(aVar.fkg);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eRK.getTotalPoll() - num));
                        aVar.fki.setLayoutParams(layoutParams);
                        aVar.fkh.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.fkl.setText(at.dY(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.fkg.setOnClickListener(VoteView.this.fjU);
                    }
                }
                aVar.fkg.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                if (VoteView.this.mData == null) {
                    return 0;
                }
                return VoteView.this.mData.size();
            }
        };
        this.mContext = context;
        this.mData = new ArrayList();
        this.fjT = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fjZ = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.fjN = (TextView) findViewById(R.id.vote_title);
        this.fjO = (TextView) findViewById(R.id.vote_sub_content);
        this.fjP = (ImageView) findViewById(R.id.vote_view_delete);
        this.fjQ = (RecyclerView) findViewById(R.id.vote_item_list);
        this.fjR = findViewById(R.id.vote_list_bottom);
        this.fjS = (TextView) findViewById(R.id.vote_view_btn);
        this.fjP.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.fjS.setOnClickListener(this.fkb);
        this.fjQ.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.fjQ.setNestedScrollingEnabled(false);
        this.fjQ.setAdapter(this.fkc);
        this.fkc.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.amM = str;
        this.mFid = j;
        this.eRK = pollData;
        this.fjV = this.eRK.getIsPolled() == 1;
        this.fjT.clear();
        if (this.fjV && !StringUtils.isNull(this.eRK.getPolledValue())) {
            for (String str2 : this.eRK.getPolledValue().split(",")) {
                this.fjT.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.fjW = this.eRK.getLastTime() <= 0 && this.eRK.getLastTime() != -1;
        this.fjX = this.eRK.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eRK.getTitle())) {
            this.fjN.setText(this.eRK.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.fjQ.setLayoutParams(layoutParams);
        this.fjR.setVisibility(8);
        if (this.fjX && !this.fjW && !this.fjV && !this.alR) {
            this.fjS.setVisibility(0);
            this.fjS.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.fjS.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.fjY = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eRK.getOptions();
            if (!x.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eRK.getOptions();
            if (!x.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, fjI);
                    layoutParams.bottomMargin = 0;
                    this.fjQ.setLayoutParams(layoutParams);
                    this.fjR.setVisibility(0);
                    this.fjS.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eRK.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eRK.getEndTime();
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
        String dY = at.dY(this.eRK.getTotalNum());
        if (!StringUtils.isNull(dY)) {
            return string + " · " + dY + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.fkc != null) {
            this.fkc.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.fjN.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.fjO.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.fjP != null && onClickListener != null) {
            this.fjP.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.fjU = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.fjP != null) {
            this.fjP.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.alR = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this).od(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ao.setBackgroundResource(this.fjR, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ao.setBackgroundResource(this.fjR, R.drawable.bg_vote_list_bottom);
        }
        ao.setViewTextColor(this.fjN, R.color.CAM_X0105);
        ao.setViewTextColor(this.fjO, R.color.CAM_X0109);
        buw();
        if (this.fkc != null) {
            this.fkc.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fjZ != null && !this.fjV && !this.fjW && !this.alR) {
            this.fjZ.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fjZ != null) {
            this.fjZ.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buw() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fjM);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0302), 0.08f));
        this.fjS.setBackgroundDrawable(gradientDrawable);
        if (!this.fjV && !x.isEmpty(this.fjT) && this.fjT.size() > 0) {
            ao.setViewTextColor(this.fjS, R.color.CAM_X0302);
            this.fjS.setEnabled(true);
            return;
        }
        this.fjS.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0302), ao.eYz));
        this.fjS.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.fkk.setVisibility(8);
        aVar.fkl.setVisibility(0);
        aVar.fkg.setGravity(19);
        if (z) {
            ao.setViewTextColor(aVar.fkg, R.color.CAM_X0302);
            ao.setViewTextColor(aVar.fkl, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ao.setViewTextColor(aVar.fkg, R.color.CAM_X0105);
            ao.setViewTextColor(aVar.fkl, R.color.CAM_X0105);
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
        aVar.fkk.setVisibility(8);
        aVar.fkl.setVisibility(8);
        aVar.fkg.setGravity(17);
        ao.setViewTextColor(aVar.fkg, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.fkk.setVisibility(0);
        aVar.fkl.setVisibility(8);
        aVar.fkg.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ao.setViewTextColor(aVar.fkg, R.color.CAM_X0302);
            SvgManager.bsx().a(aVar.fkk, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ao.setViewTextColor(aVar.fkg, R.color.CAM_X0105);
        SvgManager.bsx().a(aVar.fkk, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.fkj.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.fkg).oh(R.string.A_X07).od(R.string.J_X04).og(R.dimen.L_X01).of(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.fkg).od(R.string.J_X04).og(R.dimen.L_X01).of(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.fkj.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fjJ);
        gradientDrawable.setColor(ao.getColor(i));
        aVar.fki.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(fjK);
        gradientDrawable2.setColor(ao.getColor(i2));
        aVar.fkh.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.fkg).oh(R.string.A_X07).od(R.string.J_X04).og(R.dimen.L_X01).of(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.fkg).od(R.string.J_X04).og(R.dimen.L_X01).of(R.color.CAM_X0902).setBackGroundColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bF(List<Integer> list) {
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
        public TextView fkg;
        public View fkh;
        public View fki;
        public LinearLayout fkj;
        public ImageView fkk;
        public TextView fkl;

        public a(View view) {
            super(view);
            this.fkg = (TextView) view.findViewById(R.id.vote_item);
            this.fkh = view.findViewById(R.id.vote_item_background);
            this.fki = view.findViewById(R.id.vote_item_foreground);
            this.fkj = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.fkk = (ImageView) view.findViewById(R.id.vote_check);
            this.fkl = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
