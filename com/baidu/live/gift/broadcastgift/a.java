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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a implements ab {
    private HeadImageView aGr;
    private View aaS;
    private boolean baB;
    private LinearLayout baC;
    private RelativeLayout baD;
    private TextView baE;
    private RelativeLayout baF;
    private AnimatorSet baG;
    private TranslateAnimation baH;
    private TbImageView baI;
    private LinearLayout baJ;
    private LinearLayout baK;
    private TbImageView baL;
    private TextView baM;
    private AlaBroadcastGiftToastData bau;
    private boolean baw;
    private AlaLiveUserInfoData baz;
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
    private ArrayList<AlaBroadcastGiftToastData> bat = new ArrayList<>();
    private boolean bav = false;
    private long bax = -1;
    private long bay = -1;
    private long baA = 0;
    private final String baN = "#ffffff";
    private final String baO = "#ff5460";
    private final String baP = "#D565A9";
    private HttpMessageListener baQ = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.baA = alaGetBroadcastGiftResponseMessage.baV;
                a.this.l(alaGetBroadcastGiftResponseMessage.baU);
                a.this.It();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.SE().bwi.aOz) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.bax != alaLiveInfoCoreData.liveID && !a.this.baw) {
                        ListUtils.add(a.this.bat, 0, a.this.bau);
                        if (ListUtils.getCount(a.this.bat) > 20) {
                            ListUtils.removeSubList(a.this.bat, 21, ListUtils.getCount(a.this.bat));
                        }
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.bax);
                        alaLastLiveroomInfo.setLastRoomId(a.this.bay);
                        if (a.this.baz != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.baz.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.baz.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.baz.portrait);
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
                            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.bat);
                            yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                        } else {
                            com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(alaLiveInfoCoreData.liveID)));
                            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.bat);
                            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                        }
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.baB = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.baw = aVar.aWW;
            this.baB = true;
            this.baC = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.broadcast_gift_toast_container, (ViewGroup) null);
            this.baJ = (LinearLayout) this.baC.findViewById(a.f.outter_layout);
            this.baD = (RelativeLayout) this.baC.findViewById(a.f.container_layout);
            this.baF = (RelativeLayout) this.baC.findViewById(a.f.msg_background);
            this.baF.setOnClickListener(this.mOnClickListener);
            this.baD.setVisibility(4);
            this.aaS = this.baC.findViewById(a.f.bg_view);
            this.baE = (TextView) this.baC.findViewById(a.f.msg_content);
            this.baE.setMaxLines(1);
            this.baK = (LinearLayout) this.baC.findViewById(a.f.content_layout);
            this.aGr = (HeadImageView) this.baC.findViewById(a.f.avatar_cast_toast);
            this.aGr.setIsRound(true);
            this.aGr.setAutoChangeStyle(false);
            this.aGr.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
            this.baI = (TbImageView) this.baC.findViewById(a.f.leftIcon_imageView);
            this.baI.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.baL = (TbImageView) this.baC.findViewById(a.f.rightIcon_imageView);
            this.baL.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.baM = (TextView) this.baC.findViewById(a.f.guide_textView);
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
            MessageManager.getInstance().registerListener(this.baQ);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aWX)) {
                this.bat.addAll(aVar.aWX);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.bat, 0);
                ListUtils.remove(this.bat, 0);
                g hc = ac.hc(String.valueOf(alaBroadcastGiftToastData.gift_id));
                c cVar = new c();
                cVar.giftId = hc.Gx();
                cVar.aYv = 1L;
                cVar.giftName = hc.Gy();
                cVar.aYy = hc.getThumbnail_url();
                cVar.beQ = "";
                cVar.isDynamic = false;
                com.baidu.live.data.a aVar2 = new com.baidu.live.data.a();
                aVar2.userId = alaBroadcastGiftToastData.sender;
                aVar2.portrait = alaBroadcastGiftToastData.sender_portrait;
                aVar2.userName = alaBroadcastGiftToastData.sender;
                ac.b(cVar, aVar2, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", true, true, "", "", -1L);
                It();
                aL(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        long j = alaBroadcastGiftToastData.enterTime * 1000;
        long j2 = alaBroadcastGiftToastData.quitTime * 1000;
        long j3 = (alaBroadcastGiftToastData.stop1Time * 1000) + j + (alaBroadcastGiftToastData.maxRollTime * 1000) + (alaBroadcastGiftToastData.stop2Time * 1000) + j2;
        this.baG = new AnimatorSet();
        this.baG.setDuration(j3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baC, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.baG.play(ofFloat);
        this.baG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.bav = true;
                a.this.baD.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.Iu();
                a.this.It();
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
    public void It() {
        if (!this.bav && !ListUtils.isEmpty(this.bat)) {
            this.bau = (AlaBroadcastGiftToastData) ListUtils.getItem(this.bat, 0);
            ListUtils.remove(this.bat, 0);
            c(this.bau);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu() {
        this.bav = false;
        this.baK.clearAnimation();
        this.baC.clearAnimation();
        this.baD.setVisibility(4);
    }

    private void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.bax && !com.baidu.live.af.a.SE().bCb.aRN.contains(alaBroadcastGiftToastData.gift_id + "")) {
                Iu();
                It();
                return;
            }
            SpannableStringBuilder h = h(alaBroadcastGiftToastData);
            if (h == null || h.length() <= 0) {
                Iu();
                It();
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
        this.baF.setPadding(z ? 0 : this.ds20, this.baF.getPaddingTop(), this.baF.getPaddingRight(), this.baF.getPaddingBottom());
        if (z) {
            this.aGr.setVisibility(0);
            this.aGr.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.baI.setVisibility(8);
        } else {
            this.aGr.setVisibility(8);
        }
        return z;
    }

    private void ep(int i) {
        if (i == 0) {
            this.baI.setVisibility(8);
            return;
        }
        this.baI.getLayoutParams().width = (int) ((this.baI.getLayoutParams().height * 18.0f) / 23.0f);
        this.baI.setLayoutParams(this.baI.getLayoutParams());
        this.baI.stopLoad();
        this.baI.setImageResource(i);
        this.baI.setVisibility(0);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.baI.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.baI.getLayoutParams().width = i;
            this.baI.setLayoutParams(this.baI.getLayoutParams());
            this.baI.setImageResource(0);
            this.baI.stopLoad();
            this.baI.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.baI.setVisibility(0);
            return;
        }
        this.baI.setVisibility(8);
    }

    private void f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.baL.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.baL.getLayoutParams().width = i;
            this.baL.setLayoutParams(this.baL.getLayoutParams());
            this.baL.stopLoad();
            this.baL.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.baL.setVisibility(0);
            return;
        }
        this.baL.setVisibility(8);
    }

    private void g(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.guideButtonText) && !this.baw) {
            com.baidu.live.gift.e.a aVar = new com.baidu.live.gift.e.a(this.mContext, alaBroadcastGiftToastData.guideButtonText, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonFontColor, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            SpannableString spannableString = new SpannableString(" b");
            spannableString.setSpan(aVar, 1, spannableString.length(), 33);
            this.baM.setText(spannableString);
            this.baM.setVisibility(0);
            return;
        }
        this.baM.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int parseColor;
        int parseColor2;
        b(alaBroadcastGiftToastData);
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.baF.setClickable(false);
                if (!d(alaBroadcastGiftToastData)) {
                    ep(a.e.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.bax == alaBroadcastGiftToastData.live_id || this.baw) {
                    this.baF.setClickable(false);
                } else {
                    this.baF.setClickable(true);
                }
                if (!d(alaBroadcastGiftToastData)) {
                    ep(a.e.champion_icon);
                }
            }
            this.baL.setVisibility(8);
            this.baM.setVisibility(8);
            this.aaS.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else {
            if (!d(alaBroadcastGiftToastData)) {
                e(alaBroadcastGiftToastData);
            }
            f(alaBroadcastGiftToastData);
            g(alaBroadcastGiftToastData);
            this.baF.setClickable(alaBroadcastGiftToastData.isJump);
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
            this.aaS.setBackgroundDrawable(fVar);
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
        this.baF.setTag(alaLiveInfoCoreData);
        this.baE.setText(spannableStringBuilder);
        if (this.baI.getVisibility() == 0 && alaBroadcastGiftToastData.leftIconModel == 1) {
            this.baF.getLayoutParams().height = this.ds68;
            this.baI.getLayoutParams().height = this.ds68;
            this.baF.setPadding(0, 0, this.ds20, 0);
            int i3 = this.ds68;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i3 = (int) (((i3 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.baI.getLayoutParams().width = i3;
            ((LinearLayout.LayoutParams) this.baD.getLayoutParams()).topMargin = (this.ds56 - this.ds68) / 2;
        } else {
            this.baF.getLayoutParams().height = this.ds56;
            this.baI.getLayoutParams().height = this.ds32;
            this.baF.setPadding(alaBroadcastGiftToastData.showPortrait && !TextUtils.isEmpty(alaBroadcastGiftToastData.sender_portrait) ? 0 : this.ds20, this.baF.getPaddingTop(), this.baF.getPaddingRight(), this.baF.getPaddingBottom());
            int i4 = this.ds32;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i4 = (int) (((i4 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.baI.getLayoutParams().width = i4;
            ((LinearLayout.LayoutParams) this.baD.getLayoutParams()).topMargin = 0;
        }
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.baE.getPaint(), spannableStringBuilder.toString());
            int i5 = 0;
            if (this.baL.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((1.0f * this.ds40) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i5 = i + this.ds4;
            }
            int i6 = 0;
            if (this.baM.getVisibility() == 0) {
                this.baM.measure(0, 0);
                i6 = this.baM.getMeasuredWidth();
            }
            this.baJ.setPadding(0, 0, i6, 0);
            int paddingLeft = ((this.ds630 - this.ds20) - i6) - this.baF.getPaddingLeft();
            if (this.baI.getVisibility() == 0 || this.aGr.getVisibility() == 0) {
                if (this.baI.getVisibility() == 0) {
                    paddingLeft = (paddingLeft - this.baI.getLayoutParams().width) - this.ds10;
                } else {
                    paddingLeft = ((paddingLeft - this.ds52) - this.ds3) - this.ds8;
                }
            }
            int i7 = textWidth + i5;
            float f = -(((i7 - paddingLeft) * 1.0f) / (i6 + paddingLeft));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baK.getLayoutParams();
            if (i7 < paddingLeft) {
                layoutParams.width = -2;
                this.baK.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i7;
                this.baK.setLayoutParams(layoutParams);
                this.baH = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.baH.setStartOffset(j + j2);
                this.baH.setDuration(j3);
                this.baH.setFillAfter(true);
                this.baK.startAnimation(this.baH);
            }
        }
        this.baG.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.bat.iterator();
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
                        this.bat.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.bat.add(alaBroadcastGiftToastData);
            It();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void el(int i) {
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

    private void aL(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.baw ? 1 : 0);
        httpMessage.addParam("live_id", this.bax);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        this.bav = false;
        MessageManager.getInstance().unRegisterListener(this.baQ);
        Iu();
        if (this.baK != null) {
            this.baK.clearAnimation();
        }
        if (this.aGr != null) {
            this.aGr.stopLoad();
        }
        this.bat.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.bax = alaLiveInfoData.live_id;
            this.bay = alaLiveInfoData.room_id;
            this.baz = alaLiveUserInfoData;
            if (this.baw) {
                if (this.baA != alaLiveInfoData.broadGiftMsgId) {
                    aL(this.baA);
                }
            } else if (this.baB) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    aL(j);
                    this.baB = false;
                }
            } else if (this.baA < alaLiveInfoData.broadGiftMsgId) {
                aL(this.baA);
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public View HQ() {
        return this.baC;
    }
}
