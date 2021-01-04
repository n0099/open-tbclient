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
    private static final int blE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int foq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);

    /* renamed from: for  reason: not valid java name */
    private static final int f3for = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] fos = {blE, blE, 0.0f, 0.0f, 0.0f, 0.0f, blE, blE};
    private static final float[] fot = {0.0f, 0.0f, blE, blE, blE, blE, 0.0f, 0.0f};
    private static final float[] fou = {blE, blE, blE, blE, blE, blE, blE, blE};
    private static final float[] fov = {foq, foq, foq, foq, foq, foq, foq, foq};
    private boolean amI;
    private String anD;
    private PollData eWv;
    private View foA;
    private TextView foB;
    private List<Integer> foC;
    private View.OnClickListener foD;
    private boolean foE;
    private boolean foF;
    private boolean foG;
    private boolean foH;
    private AddPollPostModel foI;
    private AddPollPostModel.a foJ;
    private View.OnClickListener foK;
    private RecyclerView.Adapter<a> foL;
    private TextView fow;
    private TextView fox;
    private ImageView foy;
    private RecyclerView foz;
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
        this.foJ = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aG(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.foB.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eWv.setPolledValue(VoteView.this.bF(VoteView.this.foC));
                    VoteView.this.eWv.setIsPolled(1);
                    VoteView.this.foE = VoteView.this.eWv.getIsPolled() == 1;
                    VoteView.this.eWv.setTotalNum(VoteView.this.eWv.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eWv.setTotalPoll(VoteView.this.eWv.getTotalPoll() + VoteView.this.foC.size());
                    if (VoteView.this.foL != null) {
                        VoteView.this.foL.notifyDataSetChanged();
                    }
                    VoteView.this.byp();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.foK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bF = VoteView.this.bF(VoteView.this.foC);
                if (VoteView.this.mPageContext != null && VoteView.this.foI != null && !StringUtils.isNull(VoteView.this.anD) && VoteView.this.foJ != null && !StringUtils.isNull(bF) && VoteView.this.eWv != null) {
                    VoteView.this.foI.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.anD, -1L));
                    VoteView.this.foI.a(VoteView.this.foJ);
                    VoteView.this.foI.k(VoteView.this.anD, bF, VoteView.this.mFid);
                }
            }
        };
        this.foL = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eWv == null || VoteView.this.eWv.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.foD != null) {
                        aVar.foP.setOnClickListener(VoteView.this.foD);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eWv.getTotalPoll() == num;
                    boolean contains = VoteView.this.foC.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.foE && !VoteView.this.foF) {
                        if (VoteView.this.foG) {
                            if (!VoteView.this.amI) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.foH && VoteView.this.mData.size() > 3) || VoteView.this.amI) {
                                aVar.foP.setOnClickListener(VoteView.this.foD);
                            } else {
                                aVar.foP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.foC.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.foC.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.foC.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eWv.setPolledValue(VoteView.this.bF(VoteView.this.foC));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eWv.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.foC.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eWv.setPolledValue(VoteView.this.bF(VoteView.this.foC));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eWv.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.byp();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.foH && VoteView.this.mData.size() > 3) || VoteView.this.amI) {
                                aVar.foP.setOnClickListener(VoteView.this.foD);
                            } else {
                                aVar.foP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.foC.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eWv.setPolledValue(VoteView.this.bF(VoteView.this.foC));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eWv.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.foK != null) {
                                            VoteView.this.foK.onClick(aVar.foP);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eWv.getTotalPoll() - num));
                        aVar.foR.setLayoutParams(layoutParams);
                        aVar.foQ.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.foU.setText(at.dY(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.foP.setOnClickListener(VoteView.this.foD);
                    }
                }
                aVar.foP.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.foC = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.foI = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.fow = (TextView) findViewById(R.id.vote_title);
        this.fox = (TextView) findViewById(R.id.vote_sub_content);
        this.foy = (ImageView) findViewById(R.id.vote_view_delete);
        this.foz = (RecyclerView) findViewById(R.id.vote_item_list);
        this.foA = findViewById(R.id.vote_list_bottom);
        this.foB = (TextView) findViewById(R.id.vote_view_btn);
        this.foy.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.foB.setOnClickListener(this.foK);
        this.foz.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.foz.setNestedScrollingEnabled(false);
        this.foz.setAdapter(this.foL);
        this.foL.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.anD = str;
        this.mFid = j;
        this.eWv = pollData;
        this.foE = this.eWv.getIsPolled() == 1;
        this.foC.clear();
        if (this.foE && !StringUtils.isNull(this.eWv.getPolledValue())) {
            for (String str2 : this.eWv.getPolledValue().split(",")) {
                this.foC.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.foF = this.eWv.getLastTime() <= 0 && this.eWv.getLastTime() != -1;
        this.foG = this.eWv.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eWv.getTitle())) {
            this.fow.setText(this.eWv.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.foz.setLayoutParams(layoutParams);
        this.foA.setVisibility(8);
        if (this.foG && !this.foF && !this.foE && !this.amI) {
            this.foB.setVisibility(0);
            this.foB.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.foB.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.foH = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eWv.getOptions();
            if (!x.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eWv.getOptions();
            if (!x.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f3for);
                    layoutParams.bottomMargin = 0;
                    this.foz.setLayoutParams(layoutParams);
                    this.foA.setVisibility(0);
                    this.foB.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eWv.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eWv.getEndTime();
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
        String dY = at.dY(this.eWv.getTotalNum());
        if (!StringUtils.isNull(dY)) {
            return string + " · " + dY + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.foL != null) {
            this.foL.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.fow.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.fox.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.foy != null && onClickListener != null) {
            this.foy.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.foD = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.foy != null) {
            this.foy.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.amI = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this).pK(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ao.setBackgroundResource(this.foA, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ao.setBackgroundResource(this.foA, R.drawable.bg_vote_list_bottom);
        }
        ao.setViewTextColor(this.fow, R.color.CAM_X0105);
        ao.setViewTextColor(this.fox, R.color.CAM_X0109);
        byp();
        if (this.foL != null) {
            this.foL.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.foI != null && !this.foE && !this.foF && !this.amI) {
            this.foI.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.foI != null) {
            this.foI.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byp() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fov);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0302), 0.08f));
        this.foB.setBackgroundDrawable(gradientDrawable);
        if (!this.foE && !x.isEmpty(this.foC) && this.foC.size() > 0) {
            ao.setViewTextColor(this.foB, R.color.CAM_X0302);
            this.foB.setEnabled(true);
            return;
        }
        this.foB.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0302), ao.fdi));
        this.foB.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.foT.setVisibility(8);
        aVar.foU.setVisibility(0);
        aVar.foP.setGravity(19);
        if (z) {
            ao.setViewTextColor(aVar.foP, R.color.CAM_X0302);
            ao.setViewTextColor(aVar.foU, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ao.setViewTextColor(aVar.foP, R.color.CAM_X0105);
            ao.setViewTextColor(aVar.foU, R.color.CAM_X0105);
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
        aVar.foT.setVisibility(8);
        aVar.foU.setVisibility(8);
        aVar.foP.setGravity(17);
        ao.setViewTextColor(aVar.foP, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.foT.setVisibility(0);
        aVar.foU.setVisibility(8);
        aVar.foP.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ao.setViewTextColor(aVar.foP, R.color.CAM_X0302);
            SvgManager.bwq().a(aVar.foT, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ao.setViewTextColor(aVar.foP, R.color.CAM_X0105);
        SvgManager.bwq().a(aVar.foT, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.foS.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.foP).pO(R.string.A_X07).pK(R.string.J_X04).pN(R.dimen.L_X01).pM(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.foP).pK(R.string.J_X04).pN(R.dimen.L_X01).pM(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.foS.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fos);
        gradientDrawable.setColor(ao.getColor(i));
        aVar.foR.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(fot);
        gradientDrawable2.setColor(ao.getColor(i2));
        aVar.foQ.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.foP).pO(R.string.A_X07).pK(R.string.J_X04).pN(R.dimen.L_X01).pM(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(aVar.foP).pK(R.string.J_X04).pN(R.dimen.L_X01).pM(R.color.CAM_X0902).setBackGroundColor(i2);
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
        public TextView foP;
        public View foQ;
        public View foR;
        public LinearLayout foS;
        public ImageView foT;
        public TextView foU;

        public a(View view) {
            super(view);
            this.foP = (TextView) view.findViewById(R.id.vote_item);
            this.foQ = view.findViewById(R.id.vote_item_background);
            this.foR = view.findViewById(R.id.vote_item_foreground);
            this.foS = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.foT = (ImageView) view.findViewById(R.id.vote_check);
            this.foU = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
