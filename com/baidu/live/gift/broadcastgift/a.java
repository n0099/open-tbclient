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
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.baidu.live.gift.ac;
import com.baidu.live.gift.g;
import com.baidu.live.im.data.c;
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
import com.baidu.live.view.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements ab {
    private HeadImageView aGa;
    private AlaBroadcastGiftToastData aYN;
    private boolean aYP;
    private AlaLiveUserInfoData aYS;
    private boolean aYU;
    private LinearLayout aYV;
    private RelativeLayout aYW;
    private TextView aYX;
    private RelativeLayout aYY;
    private AnimatorSet aYZ;
    private TranslateAnimation aZa;
    private TbImageView aZb;
    private LinearLayout aZc;
    private LinearLayout aZd;
    private TbImageView aZe;
    private TextView aZf;
    private View aaj;
    private int ds10;
    private int ds20;
    private int ds3;
    private int ds32;
    private int ds4;
    private int ds40;
    private int ds52;
    private int ds56;
    private int ds630;
    private int ds68;
    private int ds8;
    private Context mContext;
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
    private HttpMessageListener aZj = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aYT = alaGetBroadcastGiftResponseMessage.aZo;
                a.this.l(alaGetBroadcastGiftResponseMessage.aZn);
                a.this.IS();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aYQ != alaLiveInfoCoreData.liveID && !a.this.aYP) {
                        ListUtils.add(a.this.aYM, 0, a.this.aYN);
                        if (ListUtils.getCount(a.this.aYM) > 20) {
                            ListUtils.removeSubList(a.this.aYM, 21, ListUtils.getCount(a.this.aYM));
                        }
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aYQ);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aYR);
                        if (a.this.aYS != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aYS.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aYS.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aYS.portrait);
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
                            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aYM);
                            yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                        } else {
                            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aYM);
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
        this.aYU = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aYP = aVar.aVr;
            this.aYU = true;
            this.aYV = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.broadcast_gift_toast_container, (ViewGroup) null);
            this.aZc = (LinearLayout) this.aYV.findViewById(a.f.outter_layout);
            this.aYW = (RelativeLayout) this.aYV.findViewById(a.f.container_layout);
            this.aYY = (RelativeLayout) this.aYV.findViewById(a.f.msg_background);
            this.aYY.setOnClickListener(this.mOnClickListener);
            this.aYW.setVisibility(4);
            this.aaj = this.aYV.findViewById(a.f.bg_view);
            this.aYX = (TextView) this.aYV.findViewById(a.f.msg_content);
            this.aYX.setMaxLines(1);
            this.aZd = (LinearLayout) this.aYV.findViewById(a.f.content_layout);
            this.aGa = (HeadImageView) this.aYV.findViewById(a.f.avatar_cast_toast);
            this.aGa.setIsRound(true);
            this.aGa.setAutoChangeStyle(false);
            this.aGa.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
            this.aZb = (TbImageView) this.aYV.findViewById(a.f.leftIcon_imageView);
            this.aZb.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aZe = (TbImageView) this.aYV.findViewById(a.f.rightIcon_imageView);
            this.aZe.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aZf = (TextView) this.aYV.findViewById(a.f.guide_textView);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds3 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds3);
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds4);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds32 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds32);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds40);
            this.ds52 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds52);
            this.ds56 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds56);
            this.ds68 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds68);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            MessageManager.getInstance().registerListener(this.aZj);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aVs)) {
                this.aYM.addAll(aVar.aVs);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aYM, 0);
                ListUtils.remove(this.aYM, 0);
                g hr = ac.hr(String.valueOf(alaBroadcastGiftToastData.gift_id));
                c cVar = new c();
                cVar.giftId = hr.GX();
                cVar.aWP = 1L;
                cVar.giftName = hr.GY();
                cVar.aWS = hr.getThumbnail_url();
                cVar.boV = "";
                cVar.isDynamic = false;
                com.baidu.live.data.a aVar2 = new com.baidu.live.data.a();
                aVar2.userId = alaBroadcastGiftToastData.sender;
                aVar2.portrait = alaBroadcastGiftToastData.sender_portrait;
                aVar2.userName = alaBroadcastGiftToastData.sender;
                ac.b(cVar, aVar2, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", true, true, "", "", -1L);
                IS();
                aM(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        long j = alaBroadcastGiftToastData.enterTime * 1000;
        long j2 = alaBroadcastGiftToastData.quitTime * 1000;
        long j3 = (alaBroadcastGiftToastData.stop1Time * 1000) + j + (alaBroadcastGiftToastData.maxRollTime * 1000) + (alaBroadcastGiftToastData.stop2Time * 1000) + j2;
        this.aYZ = new AnimatorSet();
        this.aYZ.setDuration(j3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYV, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat.setDuration(j3);
        final float f = (((float) j) * 1.0f) / ((float) j3);
        final float f2 = (((float) (j3 - j2)) * 1.0f) / ((float) j3);
        ofFloat.setInterpolator(new Interpolator() { // from class: com.baidu.live.gift.broadcastgift.a.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f3) {
                if (f3 <= f) {
                    return (0.5f * f3) / f;
                }
                if (f3 >= f2) {
                    return 0.5f + ((1.5f * (f3 - f2)) / (1.0f - f2));
                }
                return 0.5f;
            }
        });
        this.aYZ.play(ofFloat);
        this.aYZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aYO = true;
                a.this.aYW.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.IT();
                a.this.IS();
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
        this.aYW.setVisibility(4);
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

    private boolean d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData == null) {
            return false;
        }
        boolean z = alaBroadcastGiftToastData.showPortrait && !TextUtils.isEmpty(alaBroadcastGiftToastData.sender_portrait);
        this.aYY.setPadding(z ? 0 : this.ds20, this.aYY.getPaddingTop(), this.aYY.getPaddingRight(), this.aYY.getPaddingBottom());
        if (z) {
            this.aGa.setVisibility(0);
            this.aGa.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.aZb.setVisibility(8);
        } else {
            this.aGa.setVisibility(8);
        }
        return z;
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

    private void g(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.guideButtonText) && !this.aYP) {
            com.baidu.live.gift.e.a aVar = new com.baidu.live.gift.e.a(this.mContext, alaBroadcastGiftToastData.guideButtonText, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonFontColor, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            SpannableString spannableString = new SpannableString(" b");
            spannableString.setSpan(aVar, 1, spannableString.length(), 33);
            this.aZf.setText(spannableString);
            this.aZf.setVisibility(0);
            return;
        }
        this.aZf.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int parseColor;
        int parseColor2;
        b(alaBroadcastGiftToastData);
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aYY.setClickable(false);
                if (!d(alaBroadcastGiftToastData)) {
                    er(a.e.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aYQ == alaBroadcastGiftToastData.live_id || this.aYP) {
                    this.aYY.setClickable(false);
                } else {
                    this.aYY.setClickable(true);
                }
                if (!d(alaBroadcastGiftToastData)) {
                    er(a.e.champion_icon);
                }
            }
            this.aZe.setVisibility(8);
            this.aZf.setVisibility(8);
            this.aaj.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else {
            if (!d(alaBroadcastGiftToastData)) {
                e(alaBroadcastGiftToastData);
            }
            f(alaBroadcastGiftToastData);
            g(alaBroadcastGiftToastData);
            this.aYY.setClickable(alaBroadcastGiftToastData.isJump);
            int i2 = 0;
            try {
                if (!TextUtils.isEmpty(alaBroadcastGiftToastData.startBgColor)) {
                    i2 = Color.parseColor(alaBroadcastGiftToastData.startBgColor);
                }
                parseColor = i2;
            } catch (Exception e) {
                parseColor = Color.parseColor("#ff5460");
                e.printStackTrace();
            }
            try {
                if (TextUtils.isEmpty(alaBroadcastGiftToastData.endBgColor)) {
                    parseColor2 = 0;
                } else {
                    parseColor2 = Color.parseColor(alaBroadcastGiftToastData.endBgColor);
                }
            } catch (Exception e2) {
                parseColor2 = Color.parseColor("#D565A9");
                e2.printStackTrace();
            }
            f fVar = new f();
            fVar.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds40));
            fVar.N(parseColor, parseColor2);
            this.aaj.setBackgroundDrawable(fVar);
        }
        long j = alaBroadcastGiftToastData.enterTime * 1000;
        long j2 = alaBroadcastGiftToastData.stop1Time * 1000;
        long j3 = alaBroadcastGiftToastData.maxRollTime * 1000;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.aYY.setTag(alaLiveInfoCoreData);
        this.aYX.setText(spannableStringBuilder);
        if (this.aZb.getVisibility() == 0 && alaBroadcastGiftToastData.leftIconModel == 1) {
            this.aYY.getLayoutParams().height = this.ds68;
            this.aZb.getLayoutParams().height = this.ds68;
            this.aYY.setPadding(0, 0, this.ds20, 0);
            int i3 = this.ds68;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i3 = (int) (((i3 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZb.getLayoutParams().width = i3;
            ((LinearLayout.LayoutParams) this.aYW.getLayoutParams()).topMargin = (this.ds56 - this.ds68) / 2;
        } else {
            this.aYY.getLayoutParams().height = this.ds56;
            this.aZb.getLayoutParams().height = this.ds32;
            this.aYY.setPadding(alaBroadcastGiftToastData.showPortrait && !TextUtils.isEmpty(alaBroadcastGiftToastData.sender_portrait) ? 0 : this.ds20, this.aYY.getPaddingTop(), this.aYY.getPaddingRight(), this.aYY.getPaddingBottom());
            int i4 = this.ds32;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i4 = (int) (((i4 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZb.getLayoutParams().width = i4;
            ((LinearLayout.LayoutParams) this.aYW.getLayoutParams()).topMargin = 0;
        }
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aYX.getPaint(), spannableStringBuilder.toString());
            int i5 = 0;
            if (this.aZe.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((1.0f * this.ds40) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i5 = i + this.ds4;
            }
            int i6 = 0;
            if (this.aZf.getVisibility() == 0) {
                this.aZf.measure(0, 0);
                i6 = this.aZf.getMeasuredWidth();
            }
            this.aZc.setPadding(0, 0, i6, 0);
            int paddingLeft = ((this.ds630 - this.ds20) - i6) - this.aYY.getPaddingLeft();
            if (this.aZb.getVisibility() == 0 || this.aGa.getVisibility() == 0) {
                if (this.aZb.getVisibility() == 0) {
                    paddingLeft = (paddingLeft - this.aZb.getLayoutParams().width) - this.ds10;
                } else {
                    paddingLeft = ((paddingLeft - this.ds52) - this.ds3) - this.ds8;
                }
            }
            int i7 = textWidth + i5;
            float f = -(((i7 - paddingLeft) * 1.0f) / (i6 + paddingLeft));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZd.getLayoutParams();
            if (i7 < paddingLeft) {
                layoutParams.width = -2;
                this.aZd.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i7;
                this.aZd.setLayoutParams(layoutParams);
                this.aZa = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aZa.setStartOffset(j + j2);
                this.aZa.setDuration(j3);
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

    private void aM(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aYP ? 1 : 0);
        httpMessage.addParam("live_id", this.aYQ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        this.aYO = false;
        MessageManager.getInstance().unRegisterListener(this.aZj);
        IT();
        if (this.aZd != null) {
            this.aZd.clearAnimation();
        }
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
        this.aYM.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aYQ = alaLiveInfoData.live_id;
            this.aYR = alaLiveInfoData.room_id;
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
