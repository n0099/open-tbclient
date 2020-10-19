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
import com.baidu.live.gift.g;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
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
public class a implements v {
    private HeadImageView aEh;
    private AlaBroadcastGiftToastData aUA;
    private boolean aUC;
    private AlaLiveUserInfoData aUF;
    private boolean aUH;
    private LinearLayout aUI;
    private TextView aUJ;
    private LinearLayout aUK;
    private AnimatorSet aUL;
    private TranslateAnimation aUM;
    private TbImageView aUN;
    private LinearLayout aUO;
    private TbImageView aUP;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aUz = new ArrayList<>();
    private boolean aUB = false;
    private long aUD = -1;
    private long aUE = -1;
    private long aUG = 0;
    private final String aUQ = "#ffffff";
    private final String aUR = "#ff5460";
    private final String aUS = "#D565A9";
    private HttpMessageListener aUT = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aUG = alaGetBroadcastGiftResponseMessage.aUW;
                a.this.l(alaGetBroadcastGiftResponseMessage.aUV);
                a.this.GO();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.OS().blo.aLh) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aUD != alaLiveInfoCoreData.liveID && !a.this.aUC) {
                        ListUtils.add(a.this.aUz, 0, a.this.aUA);
                        if (ListUtils.getCount(a.this.aUz) > 20) {
                            ListUtils.removeSubList(a.this.aUz, 21, ListUtils.getCount(a.this.aUz));
                        }
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aUD);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aUE);
                        if (a.this.aUF != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aUF.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aUF.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aUF.portrait);
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
                            YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aUz);
                            yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                        } else {
                            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aUz);
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
        this.aUH = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aUC = aVar.aRM;
            this.aUH = true;
            this.aUI = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aUK = (LinearLayout) this.aUI.findViewById(a.g.msg_background);
            this.aUK.setOnClickListener(this.mOnClickListener);
            this.aUK.setVisibility(4);
            this.aUJ = (TextView) this.aUI.findViewById(a.g.msg_content);
            this.aUJ.setMaxLines(1);
            this.aUO = (LinearLayout) this.aUI.findViewById(a.g.content_layout);
            this.aEh = (HeadImageView) this.aUI.findViewById(a.g.avatar_cast_toast);
            this.aEh.setIsRound(true);
            this.aEh.setAutoChangeStyle(false);
            this.aEh.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
            this.aUN = (TbImageView) this.aUI.findViewById(a.g.leftIcon_imageView);
            this.aUN.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.aUP = (TbImageView) this.aUI.findViewById(a.g.rightIcon_imageView);
            this.aUP.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            GN();
            MessageManager.getInstance().registerListener(this.aUT);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aRN)) {
                this.aUz.addAll(aVar.aRN);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aUz, 0);
                ListUtils.remove(this.aUz, 0);
                g gM = w.gM(String.valueOf(alaBroadcastGiftToastData.gift_id));
                w.b(gM.Fd(), 1L, gM.Fe(), gM.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", true, -1L);
                GO();
                ab(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void GN() {
        this.aUL = new AnimatorSet();
        this.aUL.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUI, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aUI, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aUI, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aUL.playTogether(this.mAnimators);
        this.aUL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aUB = true;
                a.this.aUK.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.GP();
                a.this.GO();
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
    public void GO() {
        if (!this.aUB && !ListUtils.isEmpty(this.aUz)) {
            this.aUA = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aUz, 0);
            ListUtils.remove(this.aUz, 0);
            b(this.aUA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        this.aUB = false;
        this.aUO.clearAnimation();
        this.aUI.clearAnimation();
        this.aUK.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aUD && !com.baidu.live.x.a.OS().bqJ.aOh.contains(alaBroadcastGiftToastData.gift_id + "")) {
                GP();
                GO();
                return;
            }
            SpannableStringBuilder f = f(alaBroadcastGiftToastData);
            if (f == null || f.length() <= 0) {
                GP();
                GO();
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
        this.aUK.setPadding(z ? 0 : this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20), this.aUK.getPaddingTop(), this.aUK.getPaddingRight(), this.aUK.getPaddingBottom());
        if (z) {
            this.aEh.setVisibility(0);
            this.aEh.startLoad(alaBroadcastGiftToastData.sender_portrait, 12, false, false);
            this.aUN.setVisibility(8);
        } else {
            this.aEh.setVisibility(8);
        }
        return z;
    }

    private void ea(int i) {
        if (i == 0) {
            this.aUN.setVisibility(8);
            return;
        }
        this.aUN.getLayoutParams().width = (int) ((this.aUN.getLayoutParams().height * 18.0f) / 23.0f);
        this.aUN.setLayoutParams(this.aUN.getLayoutParams());
        this.aUN.stopLoad();
        this.aUN.setImageResource(i);
        this.aUN.setVisibility(0);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aUN.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aUN.getLayoutParams().width = i;
            this.aUN.setLayoutParams(this.aUN.getLayoutParams());
            this.aUN.setImageResource(0);
            this.aUN.stopLoad();
            this.aUN.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aUN.setVisibility(0);
            return;
        }
        this.aUN.setVisibility(8);
    }

    private void e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aUP.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aUP.getLayoutParams().width = i;
            this.aUP.setLayoutParams(this.aUP.getLayoutParams());
            this.aUP.stopLoad();
            this.aUP.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aUP.setVisibility(0);
            return;
        }
        this.aUP.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aUK.setClickable(false);
                if (!c(alaBroadcastGiftToastData)) {
                    ea(a.f.icon_live_remind_white_n);
                }
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aUD == alaBroadcastGiftToastData.live_id || this.aUC) {
                    this.aUK.setClickable(false);
                } else {
                    this.aUK.setClickable(true);
                }
                if (!c(alaBroadcastGiftToastData)) {
                    ea(a.f.champion_icon);
                }
            }
            this.aUP.setVisibility(8);
            this.aUK.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
        } else {
            if (!c(alaBroadcastGiftToastData)) {
                d(alaBroadcastGiftToastData);
            }
            e(alaBroadcastGiftToastData);
            this.aUK.setClickable(alaBroadcastGiftToastData.isJump);
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
            this.aUK.setBackgroundDrawable(gVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        alaLiveInfoCoreData.isAudio = alaBroadcastGiftToastData.is_jiaoyou;
        this.aUK.setTag(alaLiveInfoCoreData);
        this.aUJ.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aUJ.getPaint(), spannableStringBuilder.toString());
            if (this.aUP.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aUN.getVisibility() == 0 ? (i4 - this.aUN.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUO.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aUO.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aUO.setLayoutParams(layoutParams);
                this.aUM = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aUM.setStartOffset(1500L);
                this.aUM.setDuration(2000L);
                this.aUM.setFillAfter(true);
                this.aUO.startAnimation(this.aUM);
            }
        }
        this.aUL.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aUz.iterator();
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
                        this.aUz.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aUz.add(alaBroadcastGiftToastData);
            GO();
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

    private void ab(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aUC ? 1 : 0);
        httpMessage.addParam("live_id", this.aUD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        this.aUB = false;
        MessageManager.getInstance().unRegisterListener(this.aUT);
        if (this.aUO != null) {
            this.aUO.clearAnimation();
        }
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
        this.aUz.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.v
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aUD = alaLiveInfoData.live_id;
            this.aUE = alaLiveInfoData.room_id;
            this.aUF = alaLiveUserInfoData;
            if (this.aUC) {
                if (this.aUG != alaLiveInfoData.broadGiftMsgId) {
                    ab(this.aUG);
                }
            } else if (this.aUH) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    ab(j);
                    this.aUH = false;
                }
            } else if (this.aUG < alaLiveInfoData.broadGiftMsgId) {
                ab(this.aUG);
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public View Gl() {
        return this.aUI;
    }
}
