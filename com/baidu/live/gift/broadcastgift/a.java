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
import com.baidu.live.gift.g;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
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
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements u {
    private AlaBroadcastGiftToastData aGg;
    private boolean aGi;
    private boolean aGl;
    private LinearLayout aGm;
    private TextView aGn;
    private LinearLayout aGo;
    private AnimatorSet aGp;
    private TranslateAnimation aGq;
    private TbImageView aGr;
    private LinearLayout aGs;
    private TbImageView aGt;
    private int ds10;
    private int ds20;
    private int ds4;
    private int ds40;
    private int ds630;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aGf = new ArrayList<>();
    private boolean aGh = false;
    private long aGj = -1;
    private long aGk = 0;
    private final String aGu = "#ffffff";
    private final String aGv = "#ff5460";
    private final String aGw = "#D565A9";
    private HttpMessageListener aGx = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aGk = alaGetBroadcastGiftResponseMessage.aGA;
                a.this.g(alaGetBroadcastGiftResponseMessage.aGz);
                a.this.yN();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.localBroadcastType == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aGj != alaLiveInfoCoreData.liveID && !a.this.aGi) {
                        ListUtils.add(a.this.aGf, 0, a.this.aGg);
                        if (ListUtils.getCount(a.this.aGf) > 20) {
                            ListUtils.removeSubList(a.this.aGf, 21, ListUtils.getCount(a.this.aGf));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aGf)));
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aGl = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aGi = aVar.aDG;
            this.aGl = true;
            this.aGm = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aGo = (LinearLayout) this.aGm.findViewById(a.g.msg_background);
            this.aGo.setOnClickListener(this.mOnClickListener);
            this.aGo.setVisibility(4);
            this.aGn = (TextView) this.aGm.findViewById(a.g.msg_content);
            this.aGn.setMaxLines(1);
            this.aGs = (LinearLayout) this.aGm.findViewById(a.g.content_layout);
            this.aGr = (TbImageView) this.aGm.findViewById(a.g.leftIcon_imageView);
            this.aGr.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.aGt = (TbImageView) this.aGm.findViewById(a.g.rightIcon_imageView);
            this.aGt.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds4 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds4);
            this.ds10 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds40 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds40);
            this.ds630 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds20);
            yM();
            MessageManager.getInstance().registerListener(this.aGx);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.aDH)) {
                this.aGf.addAll(aVar.aDH);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aGf, 0);
                ListUtils.remove(this.aGf, 0);
                g eO = v.eO(String.valueOf(alaBroadcastGiftToastData.gift_id));
                v.b(eO.xl(), 1L, eO.xm(), eO.xo(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L);
                yN();
                Z(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void yM() {
        this.aGp = new AnimatorSet();
        this.aGp.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aGm, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aGm, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aGm, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aGp.playTogether(this.mAnimators);
        this.aGp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aGh = true;
                a.this.aGo.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.yO();
                a.this.yN();
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
    public void yN() {
        if (!this.aGh && !ListUtils.isEmpty(this.aGf)) {
            this.aGg = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aGf, 0);
            ListUtils.remove(this.aGf, 0);
            b(this.aGg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO() {
        this.aGh = false;
        this.aGs.clearAnimation();
        this.aGm.clearAnimation();
        this.aGo.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broad_type == 6 && alaBroadcastGiftToastData.live_id != this.aGj && !com.baidu.live.v.a.Ge().aYP.aAU.contains(alaBroadcastGiftToastData.gift_id + "")) {
                yO();
                yN();
                return;
            }
            SpannableStringBuilder e = e(alaBroadcastGiftToastData);
            if (e == null || e.length() <= 0) {
                yO();
                yN();
                return;
            }
            a(alaBroadcastGiftToastData, e);
        }
    }

    private void bQ(int i) {
        if (i == 0) {
            this.aGr.setVisibility(8);
            return;
        }
        this.aGr.getLayoutParams().width = (int) ((this.aGr.getLayoutParams().height * 18.0f) / 23.0f);
        this.aGr.setLayoutParams(this.aGr.getLayoutParams());
        this.aGr.stopLoad();
        this.aGr.setImageResource(i);
        this.aGr.setVisibility(0);
    }

    private void c(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.leftIcon)) {
            int i = this.aGr.getLayoutParams().height;
            if (alaBroadcastGiftToastData.leftIconWidth > 0 && alaBroadcastGiftToastData.leftIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.leftIconWidth) / alaBroadcastGiftToastData.leftIconHeight);
            }
            this.aGr.getLayoutParams().width = i;
            this.aGr.setLayoutParams(this.aGr.getLayoutParams());
            this.aGr.setImageResource(0);
            this.aGr.stopLoad();
            this.aGr.startLoad(alaBroadcastGiftToastData.leftIcon, 10, false);
            this.aGr.setVisibility(0);
            return;
        }
        this.aGr.setVisibility(8);
    }

    private void d(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (!TextUtils.isEmpty(alaBroadcastGiftToastData.rightIcon)) {
            int i = this.aGt.getLayoutParams().height;
            if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                i = (int) (((i * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
            }
            this.aGt.getLayoutParams().width = i;
            this.aGt.setLayoutParams(this.aGt.getLayoutParams());
            this.aGt.stopLoad();
            this.aGt.startLoad(alaBroadcastGiftToastData.rightIcon, 10, false);
            this.aGt.setVisibility(0);
            return;
        }
        this.aGt.setVisibility(8);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2;
        int parseColor;
        int i3 = 0;
        if (alaBroadcastGiftToastData.localBroadcastType == 1 || alaBroadcastGiftToastData.localBroadcastType == 2) {
            if (alaBroadcastGiftToastData.localBroadcastType == 1) {
                this.aGo.setClickable(false);
                bQ(a.f.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.localBroadcastType == 2) {
                if (this.aGj == alaBroadcastGiftToastData.live_id || this.aGi) {
                    this.aGo.setClickable(false);
                } else {
                    this.aGo.setClickable(true);
                }
                bQ(a.f.champion_icon);
            }
            this.aGt.setVisibility(8);
            this.aGo.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
        } else {
            c(alaBroadcastGiftToastData);
            d(alaBroadcastGiftToastData);
            this.aGo.setClickable(alaBroadcastGiftToastData.isJump);
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
            gVar.I(i2, parseColor);
            this.aGo.setBackgroundDrawable(gVar);
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
        alaLiveInfoCoreData.localBroadcastType = alaBroadcastGiftToastData.localBroadcastType;
        alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
        alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
        this.aGo.setTag(alaLiveInfoCoreData);
        this.aGn.setText(spannableStringBuilder);
        if (spannableStringBuilder != null) {
            int textWidth = BdUtilHelper.getTextWidth(this.aGn.getPaint(), spannableStringBuilder.toString());
            if (this.aGt.getVisibility() == 0) {
                if (alaBroadcastGiftToastData.rightIconWidth > 0 && alaBroadcastGiftToastData.rightIconHeight > 0) {
                    i = (int) (((this.ds40 * 1.0f) * alaBroadcastGiftToastData.rightIconWidth) / alaBroadcastGiftToastData.rightIconHeight);
                } else {
                    i = this.ds40;
                }
                i3 = this.ds4 + i;
            }
            int i4 = this.ds630 - (this.ds20 * 2);
            int i5 = this.aGr.getVisibility() == 0 ? (i4 - this.aGr.getLayoutParams().width) - this.ds10 : i4;
            int i6 = i3 + textWidth;
            float f = -(((i6 - i5) * 1.0f) / i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aGs.getLayoutParams();
            if (i6 < i5) {
                layoutParams.width = -2;
                this.aGs.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i6;
                this.aGs.setLayoutParams(layoutParams);
                this.aGq = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                this.aGq.setStartOffset(1500L);
                this.aGq.setDuration(2000L);
                this.aGq.setFillAfter(true);
                this.aGs.startAnimation(this.aGq);
            }
        }
        this.aGp.start();
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
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aGf.iterator();
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
                        this.aGf.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aGf.add(alaBroadcastGiftToastData);
            yN();
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
        httpMessage.addParam("is_host", this.aGi ? 1 : 0);
        httpMessage.addParam("live_id", this.aGj);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        this.aGh = false;
        MessageManager.getInstance().unRegisterListener(this.aGx);
        if (this.aGs != null) {
            this.aGs.clearAnimation();
        }
        this.aGf.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.u
    public void a(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.aGj = alaLiveInfoData.live_id;
            if (this.aGi) {
                if (this.aGk != alaLiveInfoData.broadGiftMsgId) {
                    Z(this.aGk);
                }
            } else if (this.aGl) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    Z(j);
                    this.aGl = false;
                }
            } else if (this.aGk < alaLiveInfoData.broadGiftMsgId) {
                Z(this.aGk);
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public View yq() {
        return this.aGm;
    }
}
