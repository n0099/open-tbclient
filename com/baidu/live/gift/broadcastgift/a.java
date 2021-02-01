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
import com.baidu.live.adp.framework.listener.CustomMessageListener;
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
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements ab {
    private HeadImageView aDr;
    private AlaBroadcastGiftToastData aYO;
    private boolean aYQ;
    private AlaLiveUserInfoData aYT;
    private boolean aYV;
    private LinearLayout aYW;
    private RelativeLayout aYX;
    private TextView aYY;
    private RelativeLayout aYZ;
    private AnimatorSet aZa;
    private TranslateAnimation aZb;
    private TbImageView aZc;
    private LinearLayout aZd;
    private LinearLayout aZe;
    private TbImageView aZf;
    private TextView aZg;
    private View aaM;
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
    private ArrayList<AlaBroadcastGiftToastData> aYN = new ArrayList<>();
    private boolean aYP = false;
    private long aYR = -1;
    private long aYS = -1;
    private long aYU = 0;
    private HttpMessageListener aZh = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aYU = alaGetBroadcastGiftResponseMessage.aZn;
                a.this.g(alaGetBroadcastGiftResponseMessage.aZm);
                a.this.FO();
            }
        }
    };
    private CustomMessageListener aZi = new CustomMessageListener(2913297) { // from class: com.baidu.live.gift.broadcastgift.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                alaBroadcastGiftToastData.localBroadcastType = 3;
                alaBroadcastGiftToastData.originJsonObject = (JSONObject) customResponsedMessage.getData();
                alaBroadcastGiftToastData.enterTime = 1;
                alaBroadcastGiftToastData.quitTime = 1;
                alaBroadcastGiftToastData.stop1Time = 1;
                alaBroadcastGiftToastData.stop2Time = 1;
                alaBroadcastGiftToastData.maxRollTime = 5;
                a.this.c(alaBroadcastGiftToastData);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qj().buX.aMw) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aYR != alaLiveInfoCoreData.liveID && !a.this.aYQ) {
                        ListUtils.add(a.this.aYN, 0, a.this.aYO);
                        if (ListUtils.getCount(a.this.aYN) > 20) {
                            ListUtils.removeSubList(a.this.aYN, 21, ListUtils.getCount(a.this.aYN));
                        }
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aYR);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aYS);
                        if (a.this.aYT != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aYT.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aYT.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aYT.portrait);
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
                            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aYN);
                            yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                        } else {
                            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(alaLiveInfoCoreData.liveID)));
                            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aYN);
                            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                        }
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aYV = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aYQ = aVar.aVn;
            this.aYV = true;
            this.aYW = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.broadcast_gift_toast_container, (ViewGroup) null);
            this.aZd = (LinearLayout) this.aYW.findViewById(a.f.outter_layout);
            this.aYX = (RelativeLayout) this.aYW.findViewById(a.f.container_layout);
            this.aYZ = (RelativeLayout) this.aYW.findViewById(a.f.msg_background);
            this.aYZ.setOnClickListener(this.mOnClickListener);
            this.aYX.setVisibility(4);
            this.aaM = this.aYW.findViewById(a.f.bg_view);
            this.aYY = (TextView) this.aYW.findViewById(a.f.msg_content);
            this.aYY.setMaxLines(1);
            this.aZe = (LinearLayout) this.aYW.findViewById(a.f.content_layout);
            this.aDr = (HeadImageView) this.aYW.findViewById(a.f.avatar_cast_toast);
            this.aDr.setIsRound(true);
            this.aDr.setAutoChangeStyle(false);
            this.aDr.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
            this.aZc = (TbImageView) this.aYW.findViewById(a.f.leftIcon_imageView);
            this.aZc.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aZf = (TbImageView) this.aYW.findViewById(a.f.rightIcon_imageView);
            this.aZf.setDefaultBgResource(a.e.sdk_shape_transparent);
            this.aZg = (TextView) this.aYW.findViewById(a.f.guide_textView);
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
            MessageManager.getInstance().registerListener(this.aZh);
            MessageManager.getInstance().registerListener(this.aZi);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aVo)) {
                this.aYN.addAll(aVar.aVo);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aYN, 0);
                ListUtils.remove(this.aYN, 0);
                g gm = ac.gm(String.valueOf(alaBroadcastGiftToastData.gift_id));
                c cVar = new c();
                cVar.giftId = gm.DR();
                cVar.aWN = 1L;
                cVar.giftName = gm.DS();
                cVar.aWQ = gm.getThumbnail_url();
                cVar.bdh = "";
                cVar.isDynamic = false;
                com.baidu.live.data.a aVar2 = new com.baidu.live.data.a();
                aVar2.userId = alaBroadcastGiftToastData.sender;
                aVar2.portrait = alaBroadcastGiftToastData.sender_portrait;
                aVar2.userName = alaBroadcastGiftToastData.sender;
                ac.b(cVar, aVar2, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", true, true, "", "", -1L);
                FO();
                aO(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        long j = alaBroadcastGiftToastData.enterTime * 1000;
        long j2 = alaBroadcastGiftToastData.quitTime * 1000;
        long j3 = (alaBroadcastGiftToastData.stop1Time * 1000) + j + (alaBroadcastGiftToastData.maxRollTime * 1000) + (alaBroadcastGiftToastData.stop2Time * 1000) + j2;
        this.aZa = new AnimatorSet();
        this.aZa.setDuration(j3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aYW, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aZa.play(ofFloat);
        this.aZa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aYP = true;
                a.this.aYX.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.FP();
                a.this.FO();
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
    public void FO() {
        if (!this.aYP && !ListUtils.isEmpty(this.aYN)) {
            this.aYO = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aYN, 0);
            ListUtils.remove(this.aYN, 0);
            c(this.aYO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        this.aYP = false;
        this.aZe.clearAnimation();
        this.aYW.clearAnimation();
        this.aYX.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aYR && !com.baidu.live.ae.a.Qj().bAS.aPY.contains(alaBroadcastGiftToastData.gift_id + "")) {
                FP();
                FO();
                return;
            }
            SpannableStringBuilder h = h(alaBroadcastGiftToastData);
            if (h == null || h.length() <= 0) {
                FP();
                FO();
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
        this.aYZ.setPadding(z ? 0 : this.ds20, this.aYZ.getPaddingTop(), this.aYZ.getPaddingRight(), this.aYZ.getPaddingBottom());
        if (z) {
            this.aDr.setVisibility(0);
            this.aDr.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.aZc.setVisibility(8);
        } else {
            this.aDr.setVisibility(8);
        }
        return z;
    }

    private void cO(int i) {
        if (i == 0) {
            this.aZc.setVisibility(8);
            return;
        }
        this.aZc.getLayoutParams().width = (int) ((this.aZc.getLayoutParams().height * 18.0f) / 23.0f);
        this.aZc.setLayoutParams(this.aZc.getLayoutParams());
        this.aZc.stopLoad();
        this.aZc.setImageResource(i);
        this.aZc.setVisibility(0);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aZc.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZc.getLayoutParams().width = i;
            this.aZc.setLayoutParams(this.aZc.getLayoutParams());
            this.aZc.setImageResource(0);
            this.aZc.stopLoad();
            this.aZc.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aZc.setVisibility(0);
            return;
        }
        this.aZc.setVisibility(8);
    }

    private void f(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aZf.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aZf.getLayoutParams().width = i;
            this.aZf.setLayoutParams(this.aZf.getLayoutParams());
            this.aZf.stopLoad();
            this.aZf.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aZf.setVisibility(0);
            return;
        }
        this.aZf.setVisibility(8);
    }

    private void g(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.guideButtonText) && !this.aYQ) {
            com.baidu.live.gift.e.a aVar = new com.baidu.live.gift.e.a(this.mContext, alaBroadcastGiftToastData.guideButtonText, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonGroundColor, alaBroadcastGiftToastData.guideButtonFontColor, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
            SpannableString spannableString = new SpannableString(" b");
            spannableString.setSpan(aVar, 1, spannableString.length(), 33);
            this.aZg.setText(spannableString);
            this.aZg.setVisibility(0);
            return;
        }
        this.aZg.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int parseColor;
        int parseColor2;
        b(alaBroadcastGiftToastData);
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aYZ.setClickable(false);
                if (!d(alaBroadcastGiftToastData)) {
                    cO(a.e.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aYR == alaBroadcastGiftToastData.live_id || this.aYQ) {
                    this.aYZ.setClickable(false);
                } else {
                    this.aYZ.setClickable(true);
                }
                if (!d(alaBroadcastGiftToastData)) {
                    cO(a.e.champion_icon);
                }
            }
            this.aZf.setVisibility(8);
            this.aZg.setVisibility(8);
            this.aaM.setBackgroundResource(a.e.ala_broadcast_gift_toast_bg);
        } else if (alaBroadcastGiftToastData.localBroadcastType == 3) {
            this.aYZ.setClickable(false);
            this.aZf.setVisibility(8);
            this.aZc.setVisibility(8);
            this.aDr.setVisibility(8);
        } else {
            if (!d(alaBroadcastGiftToastData)) {
                e(alaBroadcastGiftToastData);
            }
            f(alaBroadcastGiftToastData);
            g(alaBroadcastGiftToastData);
            this.aYZ.setClickable(alaBroadcastGiftToastData.isJump);
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
            this.aaM.setBackgroundDrawable(fVar);
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
        this.aYZ.setTag(alaLiveInfoCoreData);
        this.aYY.setText(spannableStringBuilder);
        if (this.aZc.getVisibility() == 0 && alaBroadcastGiftToastData.leftIconModel == 1) {
            this.aYZ.getLayoutParams().height = this.ds68;
            this.aZc.getLayoutParams().height = this.ds68;
            this.aYZ.setPadding(0, 0, this.ds20, 0);
            int i3 = this.ds68;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i3 = (int) (((i3 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZc.getLayoutParams().width = i3;
            ((LinearLayout.LayoutParams) this.aYX.getLayoutParams()).topMargin = (this.ds56 - this.ds68) / 2;
        } else {
            this.aYZ.getLayoutParams().height = this.ds56;
            this.aZc.getLayoutParams().height = this.ds32;
            this.aYZ.setPadding(alaBroadcastGiftToastData.showPortrait && !TextUtils.isEmpty(alaBroadcastGiftToastData.sender_portrait) ? 0 : this.ds20, this.aYZ.getPaddingTop(), this.aYZ.getPaddingRight(), this.aYZ.getPaddingBottom());
            int i4 = this.ds32;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i4 = (int) (((i4 * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aZc.getLayoutParams().width = i4;
            ((LinearLayout.LayoutParams) this.aYX.getLayoutParams()).topMargin = 0;
        }
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aYY.getPaint(), spannableStringBuilder.toString());
            int i5 = 0;
            if (this.aZf.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((1.0f * this.ds40) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i5 = i + this.ds4;
            }
            int i6 = 0;
            if (this.aZg.getVisibility() == 0) {
                this.aZg.measure(0, 0);
                i6 = this.aZg.getMeasuredWidth();
            }
            this.aZd.setPadding(0, 0, i6, 0);
            int paddingLeft = ((this.ds630 - this.ds20) - i6) - this.aYZ.getPaddingLeft();
            if (this.aZc.getVisibility() == 0 || this.aDr.getVisibility() == 0) {
                if (this.aZc.getVisibility() == 0) {
                    paddingLeft = (paddingLeft - this.aZc.getLayoutParams().width) - this.ds10;
                } else {
                    paddingLeft = ((paddingLeft - this.ds52) - this.ds3) - this.ds8;
                }
            }
            int i7 = textWidth + i5;
            float f = -(((i7 - paddingLeft) * 1.0f) / (i6 + paddingLeft));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZe.getLayoutParams();
            if (i7 < paddingLeft) {
                layoutParams.width = -2;
                this.aZe.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i7;
                this.aZe.setLayoutParams(layoutParams);
                this.aZb = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aZb.setStartOffset(j + j2);
                this.aZb.setDuration(j3);
                this.aZb.setFillAfter(true);
                this.aZe.startAnimation(this.aZb);
            }
        }
        this.aZa.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aYN.iterator();
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
                        this.aYN.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aYN.add(alaBroadcastGiftToastData);
            FO();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void cK(int i) {
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
        } else if (alaBroadcastGiftToastData.localBroadcastType == 3) {
            if (alaBroadcastGiftToastData.originJsonObject != null) {
                spannableStringBuilder.append((CharSequence) alaBroadcastGiftToastData.originJsonObject.optString("tips_1_content"));
            }
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

    private void aO(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aYQ ? 1 : 0);
        httpMessage.addParam("live_id", this.aYR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        this.aYP = false;
        MessageManager.getInstance().unRegisterListener(this.aZh);
        FP();
        if (this.aZe != null) {
            this.aZe.clearAnimation();
        }
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
        this.aYN.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.ab
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aYR = alaLiveInfoData.live_id;
            this.aYS = alaLiveInfoData.room_id;
            this.aYT = alaLiveUserInfoData;
            if (this.aYQ) {
                if (this.aYU != alaLiveInfoData.broadGiftMsgId) {
                    aO(this.aYU);
                }
            } else if (this.aYV) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    aO(j);
                    this.aYV = false;
                }
            } else if (this.aYU < alaLiveInfoData.broadGiftMsgId) {
                aO(this.aYU);
            }
        }
    }

    @Override // com.baidu.live.gift.ab
    public View Fl() {
        return this.aYW;
    }
}
