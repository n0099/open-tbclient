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
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ab;
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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements aa {
    private HeadImageView aEp;
    private AlaBroadcastGiftToastData aVV;
    private boolean aVX;
    private AlaLiveUserInfoData aWa;
    private boolean aWc;
    private LinearLayout aWd;
    private TextView aWe;
    private LinearLayout aWf;
    private AnimatorSet aWg;
    private TranslateAnimation aWh;
    private TbImageView aWi;
    private LinearLayout aWj;
    private TbImageView aWk;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aVU = new ArrayList<>();
    private boolean aVW = false;
    private long aVY = -1;
    private long aVZ = -1;
    private long aWb = 0;
    private final String aWl = "#ffffff";
    private final String aWm = "#ff5460";
    private final String aWn = "#D565A9";
    private HttpMessageListener aWo = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aWb = alaGetBroadcastGiftResponseMessage.aWr;
                a.this.l(alaGetBroadcastGiftResponseMessage.aWq);
                a.this.Hk();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.z.a.Pq().bmJ.aLL) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aVY != alaLiveInfoCoreData.liveID && !a.this.aVX) {
                        ListUtils.add(a.this.aVU, 0, a.this.aVV);
                        if (ListUtils.getCount(a.this.aVU) > 20) {
                            ListUtils.removeSubList(a.this.aVU, 21, ListUtils.getCount(a.this.aVU));
                        }
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aVY);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aVZ);
                        if (a.this.aWa != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aWa.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aWa.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aWa.portrait);
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
                        if (alaLiveInfoCoreData.isAudio == 1) {
                            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aVU);
                            yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                        } else {
                            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aVU);
                            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        }
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aWc = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aVX = aVar.aSH;
            this.aWc = true;
            this.aWd = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aWf = (LinearLayout) this.aWd.findViewById(a.g.msg_background);
            this.aWf.setOnClickListener(this.mOnClickListener);
            this.aWf.setVisibility(4);
            this.aWe = (TextView) this.aWd.findViewById(a.g.msg_content);
            this.aWe.setMaxLines(1);
            this.aWj = (LinearLayout) this.aWd.findViewById(a.g.content_layout);
            this.aEp = (HeadImageView) this.aWd.findViewById(a.g.avatar_cast_toast);
            this.aEp.setIsRound(true);
            this.aEp.setAutoChangeStyle(false);
            this.aEp.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
            this.aWi = (TbImageView) this.aWd.findViewById(a.g.leftIcon_imageView);
            this.aWi.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.aWk = (TbImageView) this.aWd.findViewById(a.g.rightIcon_imageView);
            this.aWk.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            Hj();
            MessageManager.getInstance().registerListener(this.aWo);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aSI)) {
                this.aVU.addAll(aVar.aSI);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aVU, 0);
                ListUtils.remove(this.aVU, 0);
                g gW = ab.gW(String.valueOf(alaBroadcastGiftToastData.gift_id));
                ab.a(gW.Fs(), 1L, gW.Ft(), gW.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", true, -1L, false);
                Hk();
                ac(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void Hj() {
        this.aWg = new AnimatorSet();
        this.aWg.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aWd, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aWd, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aWd, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aWg.playTogether(this.mAnimators);
        this.aWg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aVW = true;
                a.this.aWf.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.Hl();
                a.this.Hk();
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
    public void Hk() {
        if (!this.aVW && !ListUtils.isEmpty(this.aVU)) {
            this.aVV = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aVU, 0);
            ListUtils.remove(this.aVU, 0);
            b(this.aVV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        this.aVW = false;
        this.aWj.clearAnimation();
        this.aWd.clearAnimation();
        this.aWf.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aVY && !com.baidu.live.z.a.Pq().bsy.aOM.contains(alaBroadcastGiftToastData.gift_id + "")) {
                Hl();
                Hk();
                return;
            }
            SpannableStringBuilder f = f(alaBroadcastGiftToastData);
            if (f == null || f.length() <= 0) {
                Hl();
                Hk();
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
        this.aWf.setPadding(z ? 0 : this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aWf.getPaddingTop(), this.aWf.getPaddingRight(), this.aWf.getPaddingBottom());
        if (z) {
            this.aEp.setVisibility(0);
            this.aEp.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.aWi.setVisibility(8);
        } else {
            this.aEp.setVisibility(8);
        }
        return z;
    }

    private void eb(int i) {
        if (i == 0) {
            this.aWi.setVisibility(8);
            return;
        }
        this.aWi.getLayoutParams().width = (int) ((this.aWi.getLayoutParams().height * 18.0f) / 23.0f);
        this.aWi.setLayoutParams(this.aWi.getLayoutParams());
        this.aWi.stopLoad();
        this.aWi.setImageResource(i);
        this.aWi.setVisibility(0);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aWi.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aWi.getLayoutParams().width = i;
            this.aWi.setLayoutParams(this.aWi.getLayoutParams());
            this.aWi.setImageResource(0);
            this.aWi.stopLoad();
            this.aWi.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aWi.setVisibility(0);
            return;
        }
        this.aWi.setVisibility(8);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aWk.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aWk.getLayoutParams().width = i;
            this.aWk.setLayoutParams(this.aWk.getLayoutParams());
            this.aWk.stopLoad();
            this.aWk.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aWk.setVisibility(0);
            return;
        }
        this.aWk.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aWf.setClickable(false);
                if (!c(alaBroadcastGiftToastData)) {
                    eb(a.f.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aVY == alaBroadcastGiftToastData.live_id || this.aVX) {
                    this.aWf.setClickable(false);
                } else {
                    this.aWf.setClickable(true);
                }
                if (!c(alaBroadcastGiftToastData)) {
                    eb(a.f.champion_icon);
                }
            }
            this.aWk.setVisibility(8);
            this.aWf.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
        } else {
            if (!c(alaBroadcastGiftToastData)) {
                d(alaBroadcastGiftToastData);
            }
            e(alaBroadcastGiftToastData);
            this.aWf.setClickable(alaBroadcastGiftToastData.isJump);
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
            this.aWf.setBackgroundDrawable(gVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.aWf.setTag(alaLiveInfoCoreData);
        this.aWe.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aWe.getPaint(), spannableStringBuilder.toString());
            if (this.aWk.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aWi.getVisibility() == 0 ? (i4 - this.aWi.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWj.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aWj.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aWj.setLayoutParams(layoutParams);
                this.aWh = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aWh.setStartOffset(1500L);
                this.aWh.setDuration(2000L);
                this.aWh.setFillAfter(true);
                this.aWj.startAnimation(this.aWh);
            }
        }
        this.aWg.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aVU.iterator();
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
                        this.aVU.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aVU.add(alaBroadcastGiftToastData);
            Hk();
        }
    }

    @Override // com.baidu.live.gift.aa
    public void dX(int i) {
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

    private void ac(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aVX ? 1 : 0);
        httpMessage.addParam("live_id", this.aVY);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.aa
    public void onDestroy() {
        this.aVW = false;
        MessageManager.getInstance().unRegisterListener(this.aWo);
        if (this.aWj != null) {
            this.aWj.clearAnimation();
        }
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
        this.aVU.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.aa
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aVY = alaLiveInfoData.live_id;
            this.aVZ = alaLiveInfoData.room_id;
            this.aWa = alaLiveUserInfoData;
            if (this.aVX) {
                if (this.aWb != alaLiveInfoData.broadGiftMsgId) {
                    ac(this.aWb);
                }
            } else if (this.aWc) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    ac(j);
                    this.aWc = false;
                }
            } else if (this.aWb < alaLiveInfoData.broadGiftMsgId) {
                ac(this.aWb);
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    public View GG() {
        return this.aWd;
    }
}
