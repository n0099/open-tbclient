package com.baidu.live.gift.broadcastgift;

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
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.gift.g;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a implements u {
    private HeadImageView aAw;
    private TbImageView aPA;
    private LinearLayout aPB;
    private TbImageView aPC;
    private AlaBroadcastGiftToastData aPn;
    private boolean aPp;
    private AlaLiveUserInfoData aPs;
    private boolean aPu;
    private LinearLayout aPv;
    private TextView aPw;
    private LinearLayout aPx;
    private AnimatorSet aPy;
    private TranslateAnimation aPz;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aPm = new ArrayList<>();
    private boolean aPo = false;
    private long aPq = -1;
    private long aPr = -1;
    private long aPt = 0;
    private final String aPD = "#ffffff";
    private final String aPE = "#ff5460";
    private final String aPF = "#D565A9";
    private HttpMessageListener aPG = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aPt = alaGetBroadcastGiftResponseMessage.aPJ;
                a.this.l(alaGetBroadcastGiftResponseMessage.aPI);
                a.this.Fs();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beJ.aGO) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aPq != alaLiveInfoCoreData.liveID && !a.this.aPp) {
                        ListUtils.add(a.this.aPm, 0, a.this.aPn);
                        if (ListUtils.getCount(a.this.aPm) > 20) {
                            ListUtils.removeSubList(a.this.aPm, 21, ListUtils.getCount(a.this.aPm));
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aPm);
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aPq);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aPr);
                        if (a.this.aPs != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aPs.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aPs.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aPs.portrait);
                            if (!TextUtils.isEmpty(alaLiveInfoCoreData.liveCover)) {
                                alaLastLiveroomInfo.setLastCover(alaLiveInfoCoreData.liveCover);
                            }
                            if (!TextUtils.isEmpty(alaLiveInfoCoreData.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(alaLiveInfoCoreData.flvUrl);
                            } else if (!TextUtils.isEmpty(alaLiveInfoCoreData.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(alaLiveInfoCoreData.hlsUrl);
                            } else if (!TextUtils.isEmpty(alaLiveInfoCoreData.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(alaLiveInfoCoreData.rtmpUrl);
                            }
                        }
                        alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aPu = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aPp = aVar.aMJ;
            this.aPu = true;
            this.aPv = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aPx = (LinearLayout) this.aPv.findViewById(a.g.msg_background);
            this.aPx.setOnClickListener(this.mOnClickListener);
            this.aPx.setVisibility(4);
            this.aPw = (TextView) this.aPv.findViewById(a.g.msg_content);
            this.aPw.setMaxLines(1);
            this.aPB = (LinearLayout) this.aPv.findViewById(a.g.content_layout);
            this.aAw = (HeadImageView) this.aPv.findViewById(a.g.avatar_cast_toast);
            this.aAw.setIsRound(true);
            this.aAw.setAutoChangeStyle(false);
            this.aAw.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
            this.aPA = (TbImageView) this.aPv.findViewById(a.g.leftIcon_imageView);
            this.aPA.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.aPC = (TbImageView) this.aPv.findViewById(a.g.rightIcon_imageView);
            this.aPC.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            Fr();
            MessageManager.getInstance().registerListener(this.aPG);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aMK)) {
                this.aPm.addAll(aVar.aMK);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aPm, 0);
                ListUtils.remove(this.aPm, 0);
                g go = v.go(String.valueOf(alaBroadcastGiftToastData.gift_id));
                v.b(go.DR(), 1L, go.DS(), go.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L);
                Fs();
                aa(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void Fr() {
        this.aPy = new AnimatorSet();
        this.aPy.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aPv, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aPv, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aPv, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(7000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.live.gift.broadcastgift.a.1
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
        this.aPy.playTogether(this.mAnimators);
        this.aPy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aPo = true;
                a.this.aPx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.Ft();
                a.this.Fs();
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
    public void Fs() {
        if (!this.aPo && !ListUtils.isEmpty(this.aPm)) {
            this.aPn = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aPm, 0);
            ListUtils.remove(this.aPm, 0);
            b(this.aPn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft() {
        this.aPo = false;
        this.aPB.clearAnimation();
        this.aPv.clearAnimation();
        this.aPx.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aPq && !com.baidu.live.w.a.Nk().bkd.aJM.contains(alaBroadcastGiftToastData.gift_id + "")) {
                Ft();
                Fs();
                return;
            }
            SpannableStringBuilder f = f(alaBroadcastGiftToastData);
            if (f == null || f.length() <= 0) {
                Ft();
                Fs();
                return;
            }
            a(alaBroadcastGiftToastData, f);
        }
    }

    private boolean c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData == null) {
            return false;
        }
        boolean z = alaBroadcastGiftToastData.showPortrait && !TextUtils.isEmpty(alaBroadcastGiftToastData.sender_portrait);
        this.aPx.setPadding(z ? 0 : this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aPx.getPaddingTop(), this.aPx.getPaddingRight(), this.aPx.getPaddingBottom());
        if (z) {
            this.aAw.setVisibility(0);
            this.aAw.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.aPA.setVisibility(8);
        } else {
            this.aAw.setVisibility(8);
        }
        return z;
    }

    private void dR(int i) {
        if (i == 0) {
            this.aPA.setVisibility(8);
            return;
        }
        this.aPA.getLayoutParams().width = (int) ((this.aPA.getLayoutParams().height * 18.0f) / 23.0f);
        this.aPA.setLayoutParams(this.aPA.getLayoutParams());
        this.aPA.stopLoad();
        this.aPA.setImageResource(i);
        this.aPA.setVisibility(0);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aPA.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aPA.getLayoutParams().width = i;
            this.aPA.setLayoutParams(this.aPA.getLayoutParams());
            this.aPA.setImageResource(0);
            this.aPA.stopLoad();
            this.aPA.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aPA.setVisibility(0);
            return;
        }
        this.aPA.setVisibility(8);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aPC.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aPC.getLayoutParams().width = i;
            this.aPC.setLayoutParams(this.aPC.getLayoutParams());
            this.aPC.stopLoad();
            this.aPC.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aPC.setVisibility(0);
            return;
        }
        this.aPC.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aPx.setClickable(false);
                if (!c(alaBroadcastGiftToastData)) {
                    dR(a.f.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aPq == alaBroadcastGiftToastData.live_id || this.aPp) {
                    this.aPx.setClickable(false);
                } else {
                    this.aPx.setClickable(true);
                }
                if (!c(alaBroadcastGiftToastData)) {
                    dR(a.f.champion_icon);
                }
            }
            this.aPC.setVisibility(8);
            this.aPx.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
        } else {
            if (!c(alaBroadcastGiftToastData)) {
                d(alaBroadcastGiftToastData);
            }
            e(alaBroadcastGiftToastData);
            this.aPx.setClickable(alaBroadcastGiftToastData.isJump);
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
            com.baidu.live.view.g gVar = new com.baidu.live.view.g();
            gVar.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds40));
            gVar.O(i2, parseColor);
            this.aPx.setBackgroundDrawable(gVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        this.aPx.setTag(alaLiveInfoCoreData);
        this.aPw.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aPw.getPaint(), spannableStringBuilder.toString());
            if (this.aPC.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aPA.getVisibility() == 0 ? (i4 - this.aPA.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aPB.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aPB.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aPB.setLayoutParams(layoutParams);
                this.aPz = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aPz.setStartOffset(1500L);
                this.aPz.setDuration(2000L);
                this.aPz.setFillAfter(true);
                this.aPB.startAnimation(this.aPz);
            }
        }
        this.aPy.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aPm.iterator();
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
                        this.aPm.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aPm.add(alaBroadcastGiftToastData);
            Fs();
        }
    }

    public SpannableStringBuilder f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        int parseColor;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaBroadcastGiftToastData.localBroadcastType == 1) {
            spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.broadcasr_hour_rank_left_alarm));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 3, 5, 34);
            return spannableStringBuilder;
        } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcasr_hour_rank_confirm), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver));
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

    private void aa(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aPp ? 1 : 0);
        httpMessage.addParam("live_id", this.aPq);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        this.aPo = false;
        MessageManager.getInstance().unRegisterListener(this.aPG);
        if (this.aPB != null) {
            this.aPB.clearAnimation();
        }
        if (this.aAw != null) {
            this.aAw.stopLoad();
        }
        this.aPm.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aPq = alaLiveInfoData.live_id;
            this.aPr = alaLiveInfoData.room_id;
            this.aPs = alaLiveUserInfoData;
            if (this.aPp) {
                if (this.aPt != alaLiveInfoData.broadGiftMsgId) {
                    aa(this.aPt);
                }
            } else if (this.aPu) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    aa(j);
                    this.aPu = false;
                }
            } else if (this.aPt < alaLiveInfoData.broadGiftMsgId) {
                aa(this.aPt);
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public View EV() {
        return this.aPv;
    }
}
