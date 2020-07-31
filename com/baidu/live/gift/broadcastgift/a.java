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
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements u {
    private AlaBroadcastGiftToastData aJY;
    private boolean aKa;
    private AlaLiveUserInfoData aKd;
    private boolean aKf;
    private LinearLayout aKg;
    private TextView aKh;
    private LinearLayout aKi;
    private AnimatorSet aKj;
    private TranslateAnimation aKk;
    private TbImageView aKl;
    private LinearLayout aKm;
    private TbImageView aKn;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aJX = new ArrayList<>();
    private boolean aJZ = false;
    private long aKb = -1;
    private long aKc = -1;
    private long aKe = 0;
    private final String aKo = "#ffffff";
    private final String aKp = "#ff5460";
    private final String aKq = "#D565A9";
    private HttpMessageListener aKr = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aKe = alaGetBroadcastGiftResponseMessage.aKu;
                a.this.g(alaGetBroadcastGiftResponseMessage.aKt);
                a.this.zP();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hs().aZn.aBC) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aKb != alaLiveInfoCoreData.liveID && !a.this.aKa) {
                        ListUtils.add(a.this.aJX, 0, a.this.aJY);
                        if (ListUtils.getCount(a.this.aJX) > 20) {
                            ListUtils.removeSubList(a.this.aJX, 21, ListUtils.getCount(a.this.aJX));
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aJX);
                        AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                        alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_BROADCAST);
                        alaLastLiveroomInfo.setLastLiveId(a.this.aKb);
                        alaLastLiveroomInfo.setLastRoomId(a.this.aKc);
                        if (a.this.aKd != null) {
                            alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(a.this.aKd.userId));
                            alaLastLiveroomInfo.setLastAnchorUname(a.this.aKd.nickName);
                            alaLastLiveroomInfo.setLastAnchorPortrait(a.this.aKd.portrait);
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
        this.aKf = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aKa = aVar.aHx;
            this.aKf = true;
            this.aKg = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aKi = (LinearLayout) this.aKg.findViewById(a.g.msg_background);
            this.aKi.setOnClickListener(this.mOnClickListener);
            this.aKi.setVisibility(4);
            this.aKh = (TextView) this.aKg.findViewById(a.g.msg_content);
            this.aKh.setMaxLines(1);
            this.aKm = (LinearLayout) this.aKg.findViewById(a.g.content_layout);
            this.aKl = (TbImageView) this.aKg.findViewById(a.g.leftIcon_imageView);
            this.aKl.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.aKn = (TbImageView) this.aKg.findViewById(a.g.rightIcon_imageView);
            this.aKn.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            zO();
            MessageManager.getInstance().registerListener(this.aKr);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aHy)) {
                this.aJX.addAll(aVar.aHy);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aJX, 0);
                ListUtils.remove(this.aJX, 0);
                g eT = v.eT(String.valueOf(alaBroadcastGiftToastData.gift_id));
                v.b(eT.yo(), 1L, eT.yp(), eT.getThumbnail_url(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L);
                zP();
                Z(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void zO() {
        this.aKj = new AnimatorSet();
        this.aKj.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aKg, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aKg, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aKg, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aKj.playTogether(this.mAnimators);
        this.aKj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aJZ = true;
                a.this.aKi.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.zQ();
                a.this.zP();
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
    public void zP() {
        if (!this.aJZ && !ListUtils.isEmpty(this.aJX)) {
            this.aJY = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aJX, 0);
            ListUtils.remove(this.aJX, 0);
            b(this.aJY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        this.aJZ = false;
        this.aKm.clearAnimation();
        this.aKg.clearAnimation();
        this.aKi.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aKb && !com.baidu.live.v.a.Hs().beo.aEA.contains(alaBroadcastGiftToastData.gift_id + "")) {
                zQ();
                zP();
                return;
            }
            SpannableStringBuilder e = e(alaBroadcastGiftToastData);
            if (e == null || e.length() <= 0) {
                zQ();
                zP();
                return;
            }
            a(alaBroadcastGiftToastData, e);
        }
    }

    private void cc(int i) {
        if (i == 0) {
            this.aKl.setVisibility(8);
            return;
        }
        this.aKl.getLayoutParams().width = (int) ((this.aKl.getLayoutParams().height * 18.0f) / 23.0f);
        this.aKl.setLayoutParams(this.aKl.getLayoutParams());
        this.aKl.stopLoad();
        this.aKl.setImageResource(i);
        this.aKl.setVisibility(0);
    }

    private void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aKl.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aKl.getLayoutParams().width = i;
            this.aKl.setLayoutParams(this.aKl.getLayoutParams());
            this.aKl.setImageResource(0);
            this.aKl.stopLoad();
            this.aKl.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aKl.setVisibility(0);
            return;
        }
        this.aKl.setVisibility(8);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aKn.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aKn.getLayoutParams().width = i;
            this.aKn.setLayoutParams(this.aKn.getLayoutParams());
            this.aKn.stopLoad();
            this.aKn.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aKn.setVisibility(0);
            return;
        }
        this.aKn.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aKi.setClickable(false);
                cc(a.f.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aKb == alaBroadcastGiftToastData.live_id || this.aKa) {
                    this.aKi.setClickable(false);
                } else {
                    this.aKi.setClickable(true);
                }
                cc(a.f.champion_icon);
            }
            this.aKn.setVisibility(8);
            this.aKi.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
        } else {
            c(alaBroadcastGiftToastData);
            d(alaBroadcastGiftToastData);
            this.aKi.setClickable(alaBroadcastGiftToastData.isJump);
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
            gVar.K(i2, parseColor);
            this.aKi.setBackgroundDrawable(gVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        this.aKi.setTag(alaLiveInfoCoreData);
        this.aKh.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aKh.getPaint(), spannableStringBuilder.toString());
            if (this.aKn.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aKl.getVisibility() == 0 ? (i4 - this.aKl.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKm.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aKm.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aKm.setLayoutParams(layoutParams);
                this.aKk = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aKk.setStartOffset(1500L);
                this.aKk.setDuration(2000L);
                this.aKk.setFillAfter(true);
                this.aKm.startAnimation(this.aKk);
            }
        }
        this.aKj.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aJX.iterator();
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
                        this.aJX.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aJX.add(alaBroadcastGiftToastData);
            zP();
        }
    }

    public SpannableStringBuilder e(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
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

    private void Z(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        httpMessage.addParam("is_host", this.aKa ? 1 : 0);
        httpMessage.addParam("live_id", this.aKb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        this.aJZ = false;
        MessageManager.getInstance().unRegisterListener(this.aKr);
        if (this.aKm != null) {
            this.aKm.clearAnimation();
        }
        this.aJX.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaLiveInfoData alaLiveInfoData, AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveInfoData != null) {
            this.aKb = alaLiveInfoData.live_id;
            this.aKc = alaLiveInfoData.room_id;
            this.aKd = alaLiveUserInfoData;
            if (this.aKa) {
                if (this.aKe != alaLiveInfoData.broadGiftMsgId) {
                    Z(this.aKe);
                }
            } else if (this.aKf) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    Z(j);
                    this.aKf = false;
                }
            } else if (this.aKe < alaLiveInfoData.broadGiftMsgId) {
                Z(this.aKe);
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public View zs() {
        return this.aKg;
    }
}
