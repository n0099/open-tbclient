package com.baidu.live.yuyingift.broadcastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.g;
import com.baidu.live.gift.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.f;
import com.baidu.live.yuyingift.broadcastgift.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements z {
    private TbImageView aXA;
    private LinearLayout aXB;
    private TbImageView aXC;
    private AlaBroadcastGiftToastData aXn;
    private boolean aXp;
    private AlaLiveUserInfoData aXs;
    private boolean aXu;
    private LinearLayout aXv;
    private TextView aXw;
    private LinearLayout aXx;
    private AnimatorSet aXy;
    private TranslateAnimation aXz;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private String mCover;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aXm = new ArrayList<>();
    private boolean aXo = false;
    private long aXq = -1;
    private long aXr = -1;
    private long aXt = 0;
    private final String aXD = "#ffffff";
    private final String aXE = "#ff5460";
    private final String aXF = "#D565A9";
    private HttpMessageListener aXG = new HttpMessageListener(1031066) { // from class: com.baidu.live.yuyingift.broadcastgift.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                b.this.aXt = alaGetBroadcastGiftResponseMessage.aXJ;
                b.this.l(alaGetBroadcastGiftResponseMessage.aXI);
                b.this.HL();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            try {
                boolean iV = com.baidu.live.al.b.Xh().iV(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                boolean isApplying = com.baidu.live.al.b.Xh().isApplying();
                if (iV) {
                    a aVar = new a(b.this.mContext);
                    aVar.a(new a.InterfaceC0235a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.1
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0235a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0235a
                        public void onConfirm() {
                            com.baidu.live.al.b.Xh().Xp();
                            b.this.ak(view);
                        }
                    });
                    aVar.show();
                    aVar.setText("你当前正在麦上，离开本房间将断开本次连麦哦");
                } else if (!isApplying) {
                    b.this.ak(view);
                } else {
                    a aVar2 = new a(b.this.mContext);
                    aVar2.a(new a.InterfaceC0235a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.2
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0235a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0235a
                        public void onConfirm() {
                            com.baidu.live.al.b.Xh().Xq();
                            b.this.ak(view);
                        }
                    });
                    aVar2.show();
                    aVar2.setText("你当前正在申请上麦，离开本房间将取消本次申请哦");
                }
            } catch (Exception e) {
            }
        }
    };

    public b(com.baidu.live.gift.a aVar) {
        this.aXu = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aXp = aVar.aUa;
            this.aXu = true;
            this.aXv = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.broadcast_gift_toast_container, (ViewGroup) null);
            this.aXx = (LinearLayout) this.aXv.findViewById(a.f.msg_background);
            this.aXx.setOnClickListener(this.mOnClickListener);
            this.aXx.setVisibility(4);
            this.aXw = (TextView) this.aXv.findViewById(a.f.msg_content);
            this.aXw.setMaxLines(1);
            this.aXB = (LinearLayout) this.aXv.findViewById(a.f.content_layout);
            this.aXA = (TbImageView) this.aXv.findViewById(a.f.leftIcon_imageView);
            this.aXA.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aXC = (TbImageView) this.aXv.findViewById(a.f.rightIcon_imageView);
            this.aXC.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            HK();
            MessageManager.getInstance().registerListener(this.aXG);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aUb)) {
                this.aXm.addAll(aVar.aUb);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aXm, 0);
                ListUtils.remove(this.aXm, 0);
                g hc = ah.hc(String.valueOf(alaBroadcastGiftToastData.gift_id));
                ah.b(hc.FT(), 1L, hc.FU(), hc.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L, hc.aUO, false);
                HL();
                ao(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void HK() {
        this.aXy = new AnimatorSet();
        this.aXy.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aXv, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aXv, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aXv, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(7000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.live.yuyingift.broadcastgift.b.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                if (f <= 0.14285715f) {
                    return 3.5f * f;
                }
                if (f >= 0.71428573f) {
                    return (3.5f * f) - 2.0f;
                }
                return 0.5f;
            }
        });
        this.mAnimators = new ArrayList<>();
        this.mAnimators.add(ofFloat);
        this.mAnimators.add(ofFloat2);
        this.mAnimators.add(ofFloat3);
        this.aXy.playTogether(this.mAnimators);
        this.aXy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aXo = true;
                b.this.aXx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.HM();
                b.this.HL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (!this.aXo && !ListUtils.isEmpty(this.aXm)) {
            this.aXn = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aXm, 0);
            ListUtils.remove(this.aXm, 0);
            b(this.aXn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        this.aXo = false;
        this.aXB.clearAnimation();
        this.aXv.clearAnimation();
        this.aXx.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aXq && !com.baidu.live.aa.a.PQ().btT.aPJ.contains(alaBroadcastGiftToastData.gift_id + "")) {
                HM();
                HL();
                return;
            }
            SpannableStringBuilder f = f(alaBroadcastGiftToastData);
            if (f == null || f.length() <= 0) {
                HM();
                HL();
                return;
            }
            a(alaBroadcastGiftToastData, f);
        }
    }

    private void eb(int i) {
        if (i == 0) {
            this.aXA.setVisibility(8);
            return;
        }
        this.aXA.getLayoutParams().width = (int) ((this.aXA.getLayoutParams().height * 18.0f) / 23.0f);
        this.aXA.setLayoutParams(this.aXA.getLayoutParams());
        this.aXA.stopLoad();
        this.aXA.setImageResource(i);
        this.aXA.setVisibility(0);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aXA.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aXA.getLayoutParams().width = i;
            this.aXA.setLayoutParams(this.aXA.getLayoutParams());
            this.aXA.setImageResource(0);
            this.aXA.stopLoad();
            this.aXA.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aXA.setVisibility(0);
            return;
        }
        this.aXA.setVisibility(8);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aXC.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aXC.getLayoutParams().width = i;
            this.aXC.setLayoutParams(this.aXC.getLayoutParams());
            this.aXC.stopLoad();
            this.aXC.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aXC.setVisibility(0);
            return;
        }
        this.aXC.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aXx.setClickable(false);
                eb(a.e.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aXq == alaBroadcastGiftToastData.live_id || this.aXp) {
                    this.aXx.setClickable(false);
                } else {
                    this.aXx.setClickable(true);
                }
                eb(a.e.champion_icon);
            }
            this.aXC.setVisibility(8);
            this.aXx.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else {
            d(alaBroadcastGiftToastData);
            e(alaBroadcastGiftToastData);
            this.aXx.setClickable(alaBroadcastGiftToastData.isJump);
            try {
                i2 = !TextUtils.isEmpty(alaBroadcastGiftToastData.startBgColor) ? Color.parseColor(alaBroadcastGiftToastData.startBgColor) : 0;
            } catch (Exception e) {
                int parseColor2 = Color.parseColor("#ff5460");
                e.printStackTrace();
                i2 = parseColor2;
            }
            try {
                parseColor = !TextUtils.isEmpty(alaBroadcastGiftToastData.endBgColor) ? Color.parseColor(alaBroadcastGiftToastData.endBgColor) : 0;
            } catch (Exception e2) {
                parseColor = Color.parseColor("#D565A9");
                e2.printStackTrace();
            }
            f fVar = new f();
            fVar.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds40));
            fVar.O(i2, parseColor);
            this.aXx.setBackgroundDrawable(fVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.aXx.setTag(alaLiveInfoCoreData);
        this.aXw.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aXw.getPaint(), spannableStringBuilder.toString());
            if (this.aXC.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aXA.getVisibility() == 0 ? (i4 - this.aXA.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXB.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aXB.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aXB.setLayoutParams(layoutParams);
                this.aXz = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aXz.setStartOffset(1500L);
                this.aXz.setDuration(2000L);
                this.aXz.setFillAfter(true);
                this.aXB.startAnimation(this.aXz);
            }
        }
        this.aXy.start();
        TiebaInitialize.log(new StatisticItem("c13059"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aXm.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        } else if (it2.next().msg_id == next.msg_id) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.aXm.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.z
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aXm.add(alaBroadcastGiftToastData);
            HL();
        }
    }

    @Override // com.baidu.live.gift.z
    public void dX(int i) {
    }

    public SpannableStringBuilder f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        int parseColor;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaBroadcastGiftToastData.localBroadcastType == 1) {
            spannableStringBuilder.append((CharSequence) this.mContext.getString(a.h.broadcasr_hour_rank_left_alarm));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 3, 5, 34);
            return spannableStringBuilder;
        } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.broadcasr_hour_rank_confirm), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 2, alaBroadcastGiftToastData.sender.length() + 2, 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 6, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 6, 34);
            return spannableStringBuilder;
        } else {
            if (alaBroadcastGiftToastData.textArray != null && alaBroadcastGiftToastData.textArray.length > 0) {
                for (int i = 0; i < alaBroadcastGiftToastData.textArray.length; i++) {
                    String str = "#ffffff";
                    if (alaBroadcastGiftToastData.textColorArray != null && alaBroadcastGiftToastData.textColorArray.length > i) {
                        str = alaBroadcastGiftToastData.textColorArray[i];
                    }
                    try {
                        parseColor = Color.parseColor(str);
                    } catch (Exception e) {
                        parseColor = Color.parseColor("#ffffff");
                        e.printStackTrace();
                    }
                    String str2 = alaBroadcastGiftToastData.textArray[i];
                    SpannableString valueOf = SpannableString.valueOf(str2);
                    valueOf.setSpan(new ForegroundColorSpan(parseColor), 0, str2.length(), 33);
                    spannableStringBuilder.append((CharSequence) valueOf);
                }
            }
            return spannableStringBuilder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.PQ().bod.aML) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                if (alaLiveInfoCoreData.localBroadcastType == 2) {
                    LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                }
                if (this.aXq != alaLiveInfoCoreData.liveID && !this.aXp) {
                    ListUtils.add(this.aXm, 0, this.aXn);
                    if (ListUtils.getCount(this.aXm) > 20) {
                        ListUtils.removeSubList(this.aXm, 21, ListUtils.getCount(this.aXm));
                    }
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                    alaLastLiveroomInfo.setLastLiveId(this.aXq);
                    alaLastLiveroomInfo.setLastRoomId(this.aXr);
                    alaLastLiveroomInfo.setIsAudio(1);
                    alaLastLiveroomInfo.setLastAnchorPortrait(this.mCover);
                    if (alaLiveInfoCoreData.isAudio == 1) {
                        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.aXm);
                        yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                    } else {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.aXm);
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501058, "close_yuyin_activity"));
                    }
                    TiebaInitialize.log(new StatisticItem("c13060"));
                }
            }
        }
    }

    private void ao(long j) {
        HttpMessage httpMessage = new HttpMessage(1031066);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aXp ? 1 : 0);
        httpMessage.addParam("live_id", this.aXq);
        httpMessage.addParam("is_jiaoyou", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.z
    public void onDestroy() {
        this.aXo = false;
        MessageManager.getInstance().unRegisterListener(this.aXG);
        if (this.aXB != null) {
            this.aXB.clearAnimation();
        }
        this.aXm.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.z
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aXq = alaLiveInfoData.live_id;
            this.aXr = alaLiveInfoData.room_id;
            this.mCover = alaLiveInfoData.cover;
            this.aXs = alaLiveUserInfoData;
            if (this.aXp) {
                if (this.aXt != alaLiveInfoData.broadGiftMsgId) {
                    ao(this.aXt);
                }
            } else if (this.aXu) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    ao(j);
                    this.aXu = false;
                }
            } else if (this.aXt < alaLiveInfoData.broadGiftMsgId) {
                ao(this.aXt);
            }
        }
    }

    @Override // com.baidu.live.gift.z
    public View Hh() {
        return this.aXv;
    }
}
