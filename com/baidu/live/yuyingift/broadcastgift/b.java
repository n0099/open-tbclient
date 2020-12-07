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
import com.baidu.live.gift.ab;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.g;
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
public class b implements ab {
    private AlaBroadcastGiftToastData aYN;
    private boolean aYP;
    private AlaLiveUserInfoData aYS;
    private boolean aYU;
    private LinearLayout aYV;
    private TextView aYX;
    private AnimatorSet aYZ;
    private TranslateAnimation aZa;
    private TbImageView aZb;
    private LinearLayout aZd;
    private TbImageView aZe;
    private LinearLayout bTl;
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
    private ArrayList<AlaBroadcastGiftToastData> aYM = new ArrayList<>();
    private boolean aYO = false;
    private long aYQ = -1;
    private long aYR = -1;
    private long aYT = 0;
    private final String aZg = "#ffffff";
    private final String aZh = "#ff5460";
    private final String aZi = "#D565A9";
    private HttpMessageListener aZj = new HttpMessageListener(1031066) { // from class: com.baidu.live.yuyingift.broadcastgift.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                b.this.aYT = alaGetBroadcastGiftResponseMessage.aZo;
                b.this.l(alaGetBroadcastGiftResponseMessage.aZn);
                b.this.IS();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            try {
                boolean jt = com.baidu.live.ap.b.YX().jt(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                boolean isApplying = com.baidu.live.ap.b.YX().isApplying();
                if (jt) {
                    a aVar = new a(b.this.mContext);
                    aVar.a(new a.InterfaceC0242a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.1
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0242a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0242a
                        public void onConfirm() {
                            com.baidu.live.ap.b.YX().Zf();
                            b.this.am(view);
                        }
                    });
                    aVar.show();
                    aVar.setText("你当前正在麦上，离开本房间将断开本次连麦哦");
                } else if (!isApplying) {
                    b.this.am(view);
                } else {
                    a aVar2 = new a(b.this.mContext);
                    aVar2.a(new a.InterfaceC0242a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.2
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0242a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0242a
                        public void onConfirm() {
                            com.baidu.live.ap.b.YX().Zg();
                            b.this.am(view);
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
        this.aYU = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aYP = aVar.aVr;
            this.aYU = true;
            this.aYV = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.broadcast_gift_toast_container, (ViewGroup) null);
            this.bTl = (LinearLayout) this.aYV.findViewById(a.f.msg_background);
            this.bTl.setOnClickListener(this.mOnClickListener);
            this.bTl.setVisibility(4);
            this.aYX = (TextView) this.aYV.findViewById(a.f.msg_content);
            this.aYX.setMaxLines(1);
            this.aZd = (LinearLayout) this.aYV.findViewById(a.f.content_layout);
            this.aZb = (TbImageView) this.aYV.findViewById(a.f.leftIcon_imageView);
            this.aZb.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aZe = (TbImageView) this.aYV.findViewById(a.f.rightIcon_imageView);
            this.aZe.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            NS();
            MessageManager.getInstance().registerListener(this.aZj);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aVs)) {
                this.aYM.addAll(aVar.aVs);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aYM, 0);
                ListUtils.remove(this.aYM, 0);
                g hr = aj.hr(String.valueOf(alaBroadcastGiftToastData.gift_id));
                aj.b(hr.GX(), 1L, hr.GY(), hr.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L, hr.aWh, false);
                IS();
                aM(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void NS() {
        this.aYZ = new AnimatorSet();
        this.aYZ.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYV, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aYV, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aYV, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aYZ.playTogether(this.mAnimators);
        this.aYZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aYO = true;
                b.this.bTl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.IT();
                b.this.IS();
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
    public void IS() {
        if (!this.aYO && !ListUtils.isEmpty(this.aYM)) {
            this.aYN = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aYM, 0);
            ListUtils.remove(this.aYM, 0);
            c(this.aYN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        this.aYO = false;
        this.aZd.clearAnimation();
        this.aYV.clearAnimation();
        this.bTl.setVisibility(4);
    }

    private void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aYQ && !com.baidu.live.ae.a.RB().bxq.aQY.contains(alaBroadcastGiftToastData.gift_id + "")) {
                IT();
                IS();
                return;
            }
            SpannableStringBuilder h = h(alaBroadcastGiftToastData);
            if (h == null || h.length() <= 0) {
                IT();
                IS();
                return;
            }
            a(alaBroadcastGiftToastData, h);
        }
    }

    private void er(int i) {
        if (i == 0) {
            this.aZb.setVisibility(8);
            return;
        }
        this.aZb.getLayoutParams().width = (int) ((this.aZb.getLayoutParams().height * 18.0f) / 23.0f);
        this.aZb.setLayoutParams(this.aZb.getLayoutParams());
        this.aZb.stopLoad();
        this.aZb.setImageResource(i);
        this.aZb.setVisibility(0);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aZb.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZb.getLayoutParams().width = i;
            this.aZb.setLayoutParams(this.aZb.getLayoutParams());
            this.aZb.setImageResource(0);
            this.aZb.stopLoad();
            this.aZb.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aZb.setVisibility(0);
            return;
        }
        this.aZb.setVisibility(8);
    }

    private void f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aZe.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aZe.getLayoutParams().width = i;
            this.aZe.setLayoutParams(this.aZe.getLayoutParams());
            this.aZe.stopLoad();
            this.aZe.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aZe.setVisibility(0);
            return;
        }
        this.aZe.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.bTl.setClickable(false);
                er(a.e.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aYQ == alaBroadcastGiftToastData.live_id || this.aYP) {
                    this.bTl.setClickable(false);
                } else {
                    this.bTl.setClickable(true);
                }
                er(a.e.champion_icon);
            }
            this.aZe.setVisibility(8);
            this.bTl.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else {
            e(alaBroadcastGiftToastData);
            f(alaBroadcastGiftToastData);
            this.bTl.setClickable(alaBroadcastGiftToastData.isJump);
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
            fVar.N(i2, parseColor);
            this.bTl.setBackgroundDrawable(fVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.bTl.setTag(alaLiveInfoCoreData);
        this.aYX.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aYX.getPaint(), spannableStringBuilder.toString());
            if (this.aZe.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aZb.getVisibility() == 0 ? (i4 - this.aZb.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZd.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aZd.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aZd.setLayoutParams(layoutParams);
                this.aZa = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aZa.setStartOffset(1500L);
                this.aZa.setDuration(2000L);
                this.aZa.setFillAfter(true);
                this.aZd.startAnimation(this.aZa);
            }
        }
        this.aYZ.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aYM.iterator();
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
                        this.aYM.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aYM.add(alaBroadcastGiftToastData);
            IS();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void en(int i) {
    }

    public SpannableStringBuilder h(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
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
    public void am(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                if (alaLiveInfoCoreData.localBroadcastType == 2) {
                    LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                }
                if (this.aYQ != alaLiveInfoCoreData.liveID && !this.aYP) {
                    ListUtils.add(this.aYM, 0, this.aYN);
                    if (ListUtils.getCount(this.aYM) > 20) {
                        ListUtils.removeSubList(this.aYM, 21, ListUtils.getCount(this.aYM));
                    }
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                    alaLastLiveroomInfo.setLastLiveId(this.aYQ);
                    alaLastLiveroomInfo.setLastRoomId(this.aYR);
                    alaLastLiveroomInfo.setIsAudio(1);
                    alaLastLiveroomInfo.setLastAnchorPortrait(this.mCover);
                    if (alaLiveInfoCoreData.isAudio == 1) {
                        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.aYM);
                        yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                    } else {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.aYM);
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501058, "close_yuyin_activity"));
                    }
                    TiebaInitialize.log(new StatisticItem("c13060"));
                }
            }
        }
    }

    private void aM(long j) {
        HttpMessage httpMessage = new HttpMessage(1031066);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aYP ? 1 : 0);
        httpMessage.addParam("live_id", this.aYQ);
        httpMessage.addParam("is_jiaoyou", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        this.aYO = false;
        MessageManager.getInstance().unRegisterListener(this.aZj);
        if (this.aZd != null) {
            this.aZd.clearAnimation();
        }
        this.aYM.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aYQ = alaLiveInfoData.live_id;
            this.aYR = alaLiveInfoData.room_id;
            this.mCover = alaLiveInfoData.cover;
            this.aYS = alaLiveUserInfoData;
            if (this.aYP) {
                if (this.aYT != alaLiveInfoData.broadGiftMsgId) {
                    aM(this.aYT);
                }
            } else if (this.aYU) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    aM(j);
                    this.aYU = false;
                }
            } else if (this.aYT < alaLiveInfoData.broadGiftMsgId) {
                aM(this.aYT);
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public View Ip() {
        return this.aYV;
    }
}
