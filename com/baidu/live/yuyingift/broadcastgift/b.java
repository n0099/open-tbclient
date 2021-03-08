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
/* loaded from: classes10.dex */
public class b implements ab {
    private LinearLayout bZI;
    private AnimatorSet baB;
    private TranslateAnimation baC;
    private TbImageView baD;
    private LinearLayout baF;
    private TbImageView baG;
    private AlaBroadcastGiftToastData bao;
    private boolean baq;
    private AlaLiveUserInfoData bau;
    private boolean baw;
    private LinearLayout bax;
    private TextView baz;
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
    private ArrayList<AlaBroadcastGiftToastData> ban = new ArrayList<>();
    private boolean bap = false;
    private long bas = -1;
    private long bat = -1;
    private long bav = 0;
    private final String bZJ = "#ffffff";
    private final String bZK = "#ff5460";
    private final String bZL = "#D565A9";
    private HttpMessageListener baI = new HttpMessageListener(1031066) { // from class: com.baidu.live.yuyingift.broadcastgift.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                b.this.bav = alaGetBroadcastGiftResponseMessage.baO;
                b.this.g(alaGetBroadcastGiftResponseMessage.baN);
                b.this.FR();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            try {
                boolean iN = com.baidu.live.ao.a.Ym().iN(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                boolean isApplying = com.baidu.live.ao.a.Ym().isApplying();
                if (iN) {
                    a aVar = new a(b.this.mContext);
                    aVar.a(new a.InterfaceC0240a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.1
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0240a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0240a
                        public void onConfirm() {
                            com.baidu.live.ao.a.Ym().Yv();
                            b.this.al(view);
                        }
                    });
                    aVar.show();
                    aVar.setText("你当前正在麦上，离开本房间将断开本次连麦哦");
                } else if (!isApplying) {
                    b.this.al(view);
                } else {
                    a aVar2 = new a(b.this.mContext);
                    aVar2.a(new a.InterfaceC0240a() { // from class: com.baidu.live.yuyingift.broadcastgift.b.4.2
                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0240a
                        public void onCancel() {
                        }

                        @Override // com.baidu.live.yuyingift.broadcastgift.a.InterfaceC0240a
                        public void onConfirm() {
                            com.baidu.live.ao.a.Ym().Yw();
                            b.this.al(view);
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
        this.baw = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.baq = aVar.aWN;
            this.baw = true;
            this.bax = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.yuyin_broadcast_gift_toast_container, (ViewGroup) null);
            this.bZI = (LinearLayout) this.bax.findViewById(a.f.msg_background);
            this.bZI.setOnClickListener(this.mOnClickListener);
            this.bZI.setVisibility(4);
            this.baz = (TextView) this.bax.findViewById(a.f.msg_content);
            this.baz.setMaxLines(1);
            this.baF = (LinearLayout) this.bax.findViewById(a.f.content_layout);
            this.baD = (TbImageView) this.bax.findViewById(a.f.leftIcon_imageView);
            this.baD.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.baG = (TbImageView) this.bax.findViewById(a.f.rightIcon_imageView);
            this.baG.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            La();
            MessageManager.getInstance().registerListener(this.baI);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aWO)) {
                this.ban.addAll(aVar.aWO);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.ban, 0);
                ListUtils.remove(this.ban, 0);
                g gt = aj.gt(String.valueOf(alaBroadcastGiftToastData.gift_id));
                aj.b(gt.DU(), 1L, gt.DV(), gt.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L, gt.aXF, false, gt.DY(), 0L, 0, false);
                FR();
                aO(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void La() {
        this.baB = new AnimatorSet();
        this.baB.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bax, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bax, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bax, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.baB.playTogether(this.mAnimators);
        this.baB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.yuyingift.broadcastgift.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.bap = true;
                b.this.bZI.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.FS();
                b.this.FR();
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
    public void FR() {
        if (!this.bap && !ListUtils.isEmpty(this.ban)) {
            this.bao = (AlaBroadcastGiftToastData) ListUtils.getItem(this.ban, 0);
            ListUtils.remove(this.ban, 0);
            c(this.bao);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS() {
        this.bap = false;
        this.baF.clearAnimation();
        this.bax.clearAnimation();
        this.bZI.setVisibility(4);
    }

    private void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.bas && !com.baidu.live.ae.a.Qm().bCs.aRy.contains(alaBroadcastGiftToastData.gift_id + "")) {
                FS();
                FR();
                return;
            }
            SpannableStringBuilder h = h(alaBroadcastGiftToastData);
            if (h == null || h.length() <= 0) {
                FS();
                FR();
                return;
            }
            a(alaBroadcastGiftToastData, h);
        }
    }

    private void cP(int i) {
        if (i == 0) {
            this.baD.setVisibility(8);
            return;
        }
        this.baD.getLayoutParams().width = (int) ((this.baD.getLayoutParams().height * 18.0f) / 23.0f);
        this.baD.setLayoutParams(this.baD.getLayoutParams());
        this.baD.stopLoad();
        this.baD.setImageResource(i);
        this.baD.setVisibility(0);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.baD.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.baD.getLayoutParams().width = i;
            this.baD.setLayoutParams(this.baD.getLayoutParams());
            this.baD.setImageResource(0);
            this.baD.stopLoad();
            this.baD.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.baD.setVisibility(0);
            return;
        }
        this.baD.setVisibility(8);
    }

    private void f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.baG.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.baG.getLayoutParams().width = i;
            this.baG.setLayoutParams(this.baG.getLayoutParams());
            this.baG.stopLoad();
            this.baG.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.baG.setVisibility(0);
            return;
        }
        this.baG.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.bZI.setClickable(false);
                cP(a.e.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.bas == alaBroadcastGiftToastData.live_id || this.baq) {
                    this.bZI.setClickable(false);
                } else {
                    this.bZI.setClickable(true);
                }
                cP(a.e.champion_icon);
            }
            this.baG.setVisibility(8);
            this.bZI.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else {
            e(alaBroadcastGiftToastData);
            f(alaBroadcastGiftToastData);
            this.bZI.setClickable(alaBroadcastGiftToastData.isJump);
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
            this.bZI.setBackgroundDrawable(fVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.bZI.setTag(alaLiveInfoCoreData);
        this.baz.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.baz.getPaint(), spannableStringBuilder.toString());
            if (this.baG.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.baD.getVisibility() == 0 ? (i4 - this.baD.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baF.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.baF.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.baF.setLayoutParams(layoutParams);
                this.baC = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.baC.setStartOffset(1500L);
                this.baC.setDuration(2000L);
                this.baC.setFillAfter(true);
                this.baF.startAnimation(this.baC);
            }
        }
        this.baB.start();
        TiebaInitialize.log(new StatisticItem("c13059"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.ban.iterator();
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
                        this.ban.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.ban.add(alaBroadcastGiftToastData);
            FR();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void cL(int i) {
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
    public void al(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qm().bwx.aNW) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                if (alaLiveInfoCoreData.localBroadcastType == 2) {
                    LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                }
                if (this.bas != alaLiveInfoCoreData.liveID && !this.baq) {
                    ListUtils.add(this.ban, 0, this.bao);
                    if (ListUtils.getCount(this.ban) > 20) {
                        ListUtils.removeSubList(this.ban, 21, ListUtils.getCount(this.ban));
                    }
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                    alaLastLiveroomInfo.setLastLiveId(this.bas);
                    alaLastLiveroomInfo.setLastRoomId(this.bat);
                    alaLastLiveroomInfo.setIsAudio(1);
                    alaLastLiveroomInfo.setLastAnchorPortrait(this.mCover);
                    if (alaLiveInfoCoreData.isAudio == 1) {
                        YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.ban);
                        yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                    } else {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext, alaLiveInfoCoreData.liveID, "", this.ban);
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501058, "close_yuyin_activity"));
                    }
                    TiebaInitialize.log(new StatisticItem("c13060"));
                }
            }
        }
    }

    private void aO(long j) {
        HttpMessage httpMessage = new HttpMessage(1031066);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.baq ? 1 : 0);
        httpMessage.addParam("live_id", this.bas);
        httpMessage.addParam("is_jiaoyou", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        this.bap = false;
        MessageManager.getInstance().unRegisterListener(this.baI);
        if (this.baF != null) {
            this.baF.clearAnimation();
        }
        this.ban.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.bas = alaLiveInfoData.live_id;
            this.bat = alaLiveInfoData.room_id;
            this.mCover = alaLiveInfoData.cover;
            this.bau = alaLiveUserInfoData;
            if (this.baq) {
                if (this.bav != alaLiveInfoData.broadGiftMsgId) {
                    aO(this.bav);
                }
            } else if (this.baw) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    aO(j);
                    this.baw = false;
                }
            } else if (this.bav < alaLiveInfoData.broadGiftMsgId) {
                aO(this.bav);
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public View Fo() {
        return this.bax;
    }
}
