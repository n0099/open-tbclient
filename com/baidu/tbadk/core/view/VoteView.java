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
    private boolean amZ;
    private String anU;
    private PollData eVz;
    private TextView fnE;
    private TextView fnF;
    private ImageView fnG;
    private RecyclerView fnH;
    private View fnI;
    private TextView fnJ;
    private List<Integer> fnK;
    private View.OnClickListener fnL;
    private boolean fnM;
    private boolean fnN;
    private boolean fnO;
    private boolean fnP;
    private AddPollPostModel fnQ;
    private AddPollPostModel.a fnR;
    private View.OnClickListener fnS;
    private RecyclerView.Adapter<a> fnT;
    private int mBgColor;
    private Context mContext;
    private List<PollOptionData> mData;
    private long mFid;
    private TbPageContext mPageContext;
    private static final int blG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
    private static final int fny = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds45);
    private static final int fnz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds469);
    private static final float[] fnA = {blG, blG, 0.0f, 0.0f, 0.0f, 0.0f, blG, blG};
    private static final float[] fnB = {0.0f, 0.0f, blG, blG, blG, blG, 0.0f, 0.0f};
    private static final float[] fnC = {blG, blG, blG, blG, blG, blG, blG, blG};
    private static final float[] fnD = {fny, fny, fny, fny, fny, fny, fny, fny};

    public VoteView(Context context) {
        this(context, null);
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgColor = R.color.CAM_X0206;
        this.fnR = new AddPollPostModel.a() { // from class: com.baidu.tbadk.core.view.VoteView.1
            @Override // com.baidu.tieba.model.AddPollPostModel.a
            public void aL(int i2, String str) {
                if (i2 == 0) {
                    VoteView.this.fnJ.setText(VoteView.this.mContext.getString(R.string.pb_voted_text));
                    VoteView.this.eVz.setPolledValue(VoteView.this.bA(VoteView.this.fnK));
                    VoteView.this.eVz.setIsPolled(1);
                    VoteView.this.fnM = VoteView.this.eVz.getIsPolled() == 1;
                    VoteView.this.eVz.setTotalNum(VoteView.this.eVz.getTotalNum() + 1);
                    VoteView.this.setVoteSubContent(VoteView.this.getSubContent());
                    VoteView.this.eVz.setTotalPoll(VoteView.this.eVz.getTotalPoll() + VoteView.this.fnK.size());
                    if (VoteView.this.fnT != null) {
                        VoteView.this.fnT.notifyDataSetChanged();
                    }
                    VoteView.this.buT();
                } else if (!StringUtils.isNull(str)) {
                    VoteView.this.mPageContext.showToast(str);
                }
            }
        };
        this.fnS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String bA = VoteView.this.bA(VoteView.this.fnK);
                if (VoteView.this.mPageContext != null && VoteView.this.fnQ != null && !StringUtils.isNull(VoteView.this.anU) && VoteView.this.fnR != null && !StringUtils.isNull(bA) && VoteView.this.eVz != null) {
                    VoteView.this.fnQ.setTid(com.baidu.adp.lib.f.b.toLong(VoteView.this.anU, -1L));
                    VoteView.this.fnQ.a(VoteView.this.fnR);
                    VoteView.this.fnQ.l(VoteView.this.anU, bA, VoteView.this.mFid);
                }
            }
        };
        this.fnT = new RecyclerView.Adapter<a>() { // from class: com.baidu.tbadk.core.view.VoteView.3
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
                if (VoteView.this.eVz == null || VoteView.this.eVz.getOptions() == null || VoteView.this.mData == null) {
                    VoteView.this.setSingleUnCheckItemView(aVar);
                    if (VoteView.this.fnL != null) {
                        aVar.fnX.setOnClickListener(VoteView.this.fnL);
                    }
                } else {
                    PollOptionData pollOptionData = (PollOptionData) VoteView.this.mData.get(i2);
                    long num = pollOptionData.getNum();
                    boolean z = num == 0;
                    boolean z2 = VoteView.this.eVz.getTotalPoll() == num;
                    boolean contains = VoteView.this.fnK.contains(Integer.valueOf(pollOptionData.getId()));
                    if (!VoteView.this.fnM && !VoteView.this.fnN) {
                        if (VoteView.this.fnO) {
                            if (!VoteView.this.amZ) {
                                VoteView.this.a(aVar, false);
                            } else {
                                VoteView.this.setSingleUnCheckItemView(aVar);
                            }
                            if ((!VoteView.this.fnP && VoteView.this.mData.size() > 3) || VoteView.this.amZ) {
                                aVar.fnX.setOnClickListener(VoteView.this.fnL);
                            } else {
                                aVar.fnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.a(aVar, !VoteView.this.fnK.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId())));
                                        if (!VoteView.this.fnK.contains(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()))) {
                                            VoteView.this.fnK.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eVz.setPolledValue(VoteView.this.bA(VoteView.this.fnK));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                            VoteView.this.eVz.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        } else {
                                            VoteView.this.fnK.remove(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                            VoteView.this.eVz.setPolledValue(VoteView.this.bA(VoteView.this.fnK));
                                            ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() - 1);
                                            VoteView.this.eVz.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        }
                                        VoteView.this.buT();
                                    }
                                });
                            }
                        } else {
                            VoteView.this.setSingleUnCheckItemView(aVar);
                            if ((!VoteView.this.fnP && VoteView.this.mData.size() > 3) || VoteView.this.amZ) {
                                aVar.fnX.setOnClickListener(VoteView.this.fnL);
                            } else {
                                aVar.fnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.VoteView.3.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        VoteView.this.fnK.add(Integer.valueOf(((PollOptionData) VoteView.this.mData.get(i2)).getId()));
                                        VoteView.this.eVz.setPolledValue(VoteView.this.bA(VoteView.this.fnK));
                                        ((PollOptionData) VoteView.this.mData.get(i2)).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum() + 1);
                                        VoteView.this.eVz.getOptions().get(i2).setNum(((PollOptionData) VoteView.this.mData.get(i2)).getNum());
                                        if (VoteView.this.fnS != null) {
                                            VoteView.this.fnS.onClick(aVar.fnX);
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, (float) num);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, (float) (VoteView.this.eVz.getTotalPoll() - num));
                        aVar.fnZ.setLayoutParams(layoutParams);
                        aVar.fnY.setLayoutParams(layoutParams2);
                        VoteView.this.a(aVar, contains, z2, z);
                        aVar.foc.setText(au.ee(num) + VoteView.this.mContext.getString(R.string.write_vote_num));
                        aVar.fnX.setOnClickListener(VoteView.this.fnL);
                    }
                }
                aVar.fnX.setText(((PollOptionData) VoteView.this.mData.get(i2)).getText());
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
        this.fnK = new ArrayList();
        init();
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fnQ = new AddPollPostModel(this.mPageContext);
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.view_vote_main, (ViewGroup) this, true);
        this.fnE = (TextView) findViewById(R.id.vote_title);
        this.fnF = (TextView) findViewById(R.id.vote_sub_content);
        this.fnG = (ImageView) findViewById(R.id.vote_view_delete);
        this.fnH = (RecyclerView) findViewById(R.id.vote_item_list);
        this.fnI = findViewById(R.id.vote_list_bottom);
        this.fnJ = (TextView) findViewById(R.id.vote_view_btn);
        this.fnG.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        this.fnJ.setOnClickListener(this.fnS);
        this.fnH.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false) { // from class: com.baidu.tbadk.core.view.VoteView.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        this.fnH.setNestedScrollingEnabled(false);
        this.fnH.setAdapter(this.fnT);
        this.fnT.notifyDataSetChanged();
    }

    private void a(PollData pollData, String str, long j) {
        this.anU = str;
        this.mFid = j;
        this.eVz = pollData;
        this.fnM = this.eVz.getIsPolled() == 1;
        this.fnK.clear();
        if (this.fnM && !StringUtils.isNull(this.eVz.getPolledValue())) {
            for (String str2 : this.eVz.getPolledValue().split(",")) {
                this.fnK.add(Integer.valueOf(Integer.parseInt(str2)));
            }
        }
        this.fnN = this.eVz.getLastTime() <= 0 && this.eVz.getLastTime() != -1;
        this.fnO = this.eVz.getIsMulti() == 1;
        if (!StringUtils.isNull(this.eVz.getTitle())) {
            this.fnE.setText(this.eVz.getTitle());
        }
        setVoteSubContent(getSubContent());
    }

    private void setViewWithAllData(List<PollOptionData> list) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25);
        this.fnH.setLayoutParams(layoutParams);
        this.fnI.setVisibility(8);
        if (this.fnO && !this.fnN && !this.fnM && !this.amZ) {
            this.fnJ.setVisibility(0);
            this.fnJ.setText(this.mContext.getString(R.string.pb_vote_text));
        } else {
            this.fnJ.setVisibility(8);
        }
        setData(list);
    }

    public void setDataForPb(PollData pollData, String str, String str2) {
        if (pollData != null) {
            this.fnP = true;
            a(pollData, str, com.baidu.adp.lib.f.b.toLong(str2, 0L));
            List<PollOptionData> options = this.eVz.getOptions();
            if (!y.isEmpty(options)) {
                setViewWithAllData(options);
            }
        }
    }

    public void setData(PollData pollData, String str, long j) {
        if (pollData != null) {
            a(pollData, str, j);
            List<PollOptionData> options = this.eVz.getOptions();
            if (!y.isEmpty(options)) {
                if (options.size() > 3) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, fnz);
                    layoutParams.bottomMargin = 0;
                    this.fnH.setLayoutParams(layoutParams);
                    this.fnI.setVisibility(0);
                    this.fnJ.setVisibility(8);
                    setData(options.subList(0, 4));
                    return;
                }
                setViewWithAllData(options);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSubContent() {
        String string = this.eVz.getIsMulti() == 1 ? this.mContext.getString(R.string.vote_type_multiple) : this.mContext.getString(R.string.vote_type_single);
        long endTime = this.eVz.getEndTime();
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
        String ee = au.ee(this.eVz.getTotalNum());
        if (!StringUtils.isNull(ee)) {
            return string + " · " + ee + this.mContext.getString(R.string.write_vote_total);
        }
        return string;
    }

    public void setData(List<PollOptionData> list) {
        this.mData.clear();
        this.mData.addAll(list);
        if (this.fnT != null) {
            this.fnT.notifyDataSetChanged();
        }
    }

    public void setVoteTitle(String str) {
        if (!StringUtils.isNull(str)) {
            this.fnE.setText(str);
        }
    }

    public void setVoteSubContent(String str) {
        if (!StringUtils.isNull(str)) {
            this.fnF.setText(str);
        }
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        if (this.fnG != null && onClickListener != null) {
            this.fnG.setOnClickListener(onClickListener);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.fnL = onClickListener;
    }

    public void setVoteViewDeleteVisibility(int i) {
        if (this.fnG != null) {
            this.fnG.setVisibility(i);
        }
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setIsTransmit(boolean z) {
        this.amZ = z;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this).oh(R.string.J_X05).setBackGroundColor(this.mBgColor);
        if (this.mBgColor == R.color.CAM_X0207) {
            ap.setBackgroundResource(this.fnI, R.drawable.bg_vote_list_transmit_bottom);
        } else {
            ap.setBackgroundResource(this.fnI, R.drawable.bg_vote_list_bottom);
        }
        ap.setViewTextColor(this.fnE, R.color.CAM_X0105);
        ap.setViewTextColor(this.fnF, R.color.CAM_X0109);
        buT();
        if (this.fnT != null) {
            this.fnT.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fnQ != null && !this.fnM && !this.fnN && !this.amZ) {
            this.fnQ.registerListener();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fnQ != null) {
            this.fnQ.unRegisterListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fnD);
        gradientDrawable.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0302), 0.08f));
        this.fnJ.setBackgroundDrawable(gradientDrawable);
        if (!this.fnM && !y.isEmpty(this.fnK) && this.fnK.size() > 0) {
            ap.setViewTextColor(this.fnJ, R.color.CAM_X0302);
            this.fnJ.setEnabled(true);
            return;
        }
        this.fnJ.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0302), ap.fcn));
        this.fnJ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        aVar.fob.setVisibility(8);
        aVar.foc.setVisibility(0);
        aVar.fnX.setGravity(19);
        if (z) {
            ap.setViewTextColor(aVar.fnX, R.color.CAM_X0302);
            ap.setViewTextColor(aVar.foc, R.color.CAM_X0302);
            if (z2) {
                a(aVar, R.color.CAM_X0905, z);
                return;
            }
        } else {
            ap.setViewTextColor(aVar.fnX, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.foc, R.color.CAM_X0105);
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
        aVar.fob.setVisibility(8);
        aVar.foc.setVisibility(8);
        aVar.fnX.setGravity(17);
        ap.setViewTextColor(aVar.fnX, R.color.CAM_X0105);
        a(aVar, R.color.CAM_X0207, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, boolean z) {
        aVar.fob.setVisibility(0);
        aVar.foc.setVisibility(8);
        aVar.fnX.setGravity(19);
        a(aVar, R.color.CAM_X0207, z);
        if (z) {
            ap.setViewTextColor(aVar.fnX, R.color.CAM_X0302);
            SvgManager.bsU().a(aVar.fob, R.drawable.ic_icon_pure_toast_complete24_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        ap.setViewTextColor(aVar.fnX, R.color.CAM_X0105);
        SvgManager.bsU().a(aVar.fob, R.drawable.ic_icon_pure_strok3_24_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
    }

    private void a(a aVar, int i, boolean z) {
        aVar.foa.setVisibility(8);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fnX).om(R.string.A_X07).oh(R.string.J_X04).ol(R.dimen.L_X01).ok(R.color.CAM_X0302).setBackGroundColor(i);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fnX).oh(R.string.J_X04).ol(R.dimen.L_X01).ok(R.color.CAM_X0902).setBackGroundColor(i);
        }
    }

    private void a(a aVar, int i, int i2, boolean z) {
        aVar.foa.setVisibility(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fnA);
        gradientDrawable.setColor(ap.getColor(i));
        aVar.fnZ.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadii(fnB);
        gradientDrawable2.setColor(ap.getColor(i2));
        aVar.fnY.setBackgroundDrawable(gradientDrawable2);
        if (z) {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fnX).om(R.string.A_X07).oh(R.string.J_X04).ol(R.dimen.L_X01).ok(R.color.CAM_X0302).setBackGroundColor(i2);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(aVar.fnX).oh(R.string.J_X04).ol(R.dimen.L_X01).ok(R.color.CAM_X0902).setBackGroundColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bA(List<Integer> list) {
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
        public TextView fnX;
        public View fnY;
        public View fnZ;
        public LinearLayout foa;
        public ImageView fob;
        public TextView foc;

        public a(View view) {
            super(view);
            this.fnX = (TextView) view.findViewById(R.id.vote_item);
            this.fnY = view.findViewById(R.id.vote_item_background);
            this.fnZ = view.findViewById(R.id.vote_item_foreground);
            this.foa = (LinearLayout) view.findViewById(R.id.vote_item_ground);
            this.fob = (ImageView) view.findViewById(R.id.vote_check);
            this.foc = (TextView) view.findViewById(R.id.vote_num);
        }
    }
}
