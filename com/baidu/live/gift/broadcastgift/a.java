package com.baidu.live.gift.broadcastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.CenterImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.gift.g;
import com.baidu.live.gift.p;
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a implements p {
    private AlaBroadcastGiftToastData XA;
    private boolean XC;
    private boolean XG;
    private int XH;
    private int XI;
    private LinearLayout XJ;
    private TextView XK;
    private LinearLayout XL;
    private AnimatorSet XM;
    private TranslateAnimation XN;
    private int ds28;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> Xz = new ArrayList<>();
    private boolean XB = false;
    private boolean XD = true;
    private long XE = -1;
    private long XF = 0;
    private HttpMessageListener XO = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.XF = alaGetBroadcastGiftResponseMessage.XS;
                a.this.e(alaGetBroadcastGiftResponseMessage.XR);
                a.this.qc();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                if (alaLiveInfoCoreData.broadcast_type == 2) {
                    LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                }
                if (a.this.XE != alaLiveInfoCoreData.liveID) {
                    ListUtils.add(a.this.Xz, 0, a.this.XA);
                    if (ListUtils.getCount(a.this.Xz) > 20) {
                        ListUtils.removeSubList(a.this.Xz, 21, ListUtils.getCount(a.this.Xz));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.Xz)));
                    TiebaInitialize.log(new StatisticItem("c13060"));
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.XG = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.XC = aVar.VP;
            this.XG = true;
            this.XJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.XL = (LinearLayout) this.XJ.findViewById(a.g.msg_background);
            this.XL.setOnClickListener(this.mOnClickListener);
            this.XL.setVisibility(4);
            this.XK = (TextView) this.XJ.findViewById(a.g.msg_content);
            this.XK.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.XK.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XK.getLayoutParams();
                layoutParams.width = i;
                this.XK.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.XK.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.XH = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630) - (this.ds28 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            qb();
            registerTask();
            MessageManager.getInstance().registerListener(this.XO);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.VQ)) {
                this.Xz.addAll(aVar.VQ);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.Xz, 0);
                ListUtils.remove(this.Xz, 0);
                g cl = q.cl(String.valueOf(alaBroadcastGiftToastData.gift_id));
                q.b(cl.pc(), 1L, cl.pd(), cl.pf(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "");
                qc();
                u(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void qb() {
        this.XM = new AnimatorSet();
        this.XM.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.XJ, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.XJ, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.XJ, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.XM.playTogether(this.mAnimators);
        this.XM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.XB = true;
                a.this.XL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.qd();
                a.this.qc();
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
    public void qc() {
        if (!this.XB && !ListUtils.isEmpty(this.Xz)) {
            this.XA = (AlaBroadcastGiftToastData) ListUtils.getItem(this.Xz, 0);
            ListUtils.remove(this.Xz, 0);
            a(this.XA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        this.XB = false;
        this.XK.clearAnimation();
        this.XJ.clearAnimation();
        this.XL.setVisibility(4);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            SpannableStringBuilder a = a(alaBroadcastGiftToastData, this.XC);
            if (a != null && a.length() <= 0) {
                qd();
                qc();
                return;
            }
            if (alaBroadcastGiftToastData.broadcast_type == 1) {
                this.XL.setClickable(false);
                bb(a.f.icon_live_remind_white_n);
            } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.XC) {
                    this.XL.setClickable(false);
                } else {
                    this.XL.setClickable(true);
                }
                bb(a.f.champion_icon);
            } else if (alaBroadcastGiftToastData.broad_type == 2) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.XC) {
                    this.XL.setClickable(false);
                } else {
                    this.XL.setClickable(true);
                }
                bb(a.f.ala_broadcast_guard_club_upgrade);
            } else {
                bb(a.f.icon_live_remind_white_n);
                this.XL.setClickable(true);
            }
            if (this.XE == alaBroadcastGiftToastData.live_id) {
                this.XL.setVisibility(0);
            } else if (this.XC && alaBroadcastGiftToastData.broadcast_type != 1 && alaBroadcastGiftToastData.broadcast_type != 2) {
                this.XL.setClickable(false);
                this.XL.setVisibility(0);
            } else {
                this.XL.setVisibility(0);
            }
            if (alaBroadcastGiftToastData.broad_type == 2) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.f.ala_broadcast_message_bg_guard);
                gradientDrawable.setAlpha(178);
                this.XL.setBackgroundDrawable(gradientDrawable);
            } else {
                this.XL.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
            alaLiveInfoCoreData.broadcast_type = alaBroadcastGiftToastData.broadcast_type;
            alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
            alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
            this.XL.setTag(alaLiveInfoCoreData);
            this.XK.setText(a);
            Drawable[] compoundDrawables = this.XK.getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 0) {
                this.XI = compoundDrawables[0].getIntrinsicWidth();
            }
            this.XI = ((TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) || alaBroadcastGiftToastData.broad_type != 1) ? 1 : 3) * this.XI;
            this.XI += this.XK.getCompoundDrawablePadding() * 4;
            if (a != null) {
                int textWidth = this.XI + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.XH) * 1.0f) / this.XH);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XK.getLayoutParams();
                if (textWidth - this.XH < 0) {
                    layoutParams.width = -2;
                    this.XK.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.XK.setLayoutParams(layoutParams);
                    this.XN = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.XN.setStartOffset(1500L);
                    this.XN.setDuration(2000L);
                    this.XN.setFillAfter(true);
                    this.XK.startAnimation(this.XN);
                }
            }
            this.XM.start();
            TiebaInitialize.log(new StatisticItem("c13059"));
        }
    }

    private void bb(int i) {
        this.XK.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(i), (Drawable) null, (Drawable) null, (Drawable) null);
        this.XK.setCompoundDrawablePadding(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.Xz.iterator();
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
                        this.Xz.add(next);
                    }
                }
            }
        }
    }

    public void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.Xz.add(alaBroadcastGiftToastData);
            qc();
        }
    }

    public SpannableStringBuilder a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, boolean z) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broadcast_type == 1) {
                spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.broadcasr_hour_rank_left_alarm));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 3, 5, 34);
            } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcasr_hour_rank_confirm), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 2, alaBroadcastGiftToastData.sender.length() + 2, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 6, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 6, 34);
            } else {
                if (alaBroadcastGiftToastData.broad_type == 2) {
                    String format = String.format(this.mContext.getString(a.i.broadcast_guard_club_upgrade), alaBroadcastGiftToastData.subjectName, String.valueOf(alaBroadcastGiftToastData.keywords));
                    spannableStringBuilder.append((CharSequence) format);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), 6, alaBroadcastGiftToastData.subjectName.length() + 6, 34);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), alaBroadcastGiftToastData.subjectName.length() + 11, format.length(), 34);
                } else if (z && this.XE == alaBroadcastGiftToastData.live_id) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_master_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.gift_name));
                } else {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_audience_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver, alaBroadcastGiftToastData.gift_name));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 1, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 3, 34);
                }
                if (!TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) && alaBroadcastGiftToastData.broad_type == 1) {
                    this.XK.setTag(alaBroadcastGiftToastData.gift_url);
                    this.XD = true;
                    BdResourceLoader.getInstance().loadResource(alaBroadcastGiftToastData.gift_url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.broadcastgift.a.4
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str, int i) {
                            Bitmap rawBitmap;
                            Bitmap copy;
                            Bitmap copy2;
                            super.onLoaded((AnonymousClass4) bdImage, str, i);
                            if (a.this.XK != null && bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
                                try {
                                    if (rawBitmap.getConfig() == null) {
                                        copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                                    } else {
                                        copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
                                    }
                                    copy = copy2;
                                } catch (OutOfMemoryError e) {
                                    BdLog.e(e);
                                    if (rawBitmap.getConfig() == null) {
                                        try {
                                            copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                                        } catch (OutOfMemoryError e2) {
                                            BdLog.e(e2);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (copy != null) {
                                    try {
                                        Bitmap resizeBitmap = BdBitmapHelper.getInstance().resizeBitmap(copy, a.this.ds28, a.this.ds28);
                                        if (resizeBitmap != copy) {
                                            copy.recycle();
                                        }
                                        if (resizeBitmap != null) {
                                            CenterImageSpan centerImageSpan = new CenterImageSpan(a.this.mContext, resizeBitmap, 1);
                                            SpannableString spannableString = new SpannableString(" [img]");
                                            spannableString.setSpan(centerImageSpan, 1, spannableString.length(), 33);
                                            spannableStringBuilder.append((CharSequence) spannableString);
                                            if (!a.this.XD && (a.this.XK.getTag() instanceof String) && ((String) a.this.XK.getTag()).equals(str)) {
                                                a.this.XK.setText(spannableStringBuilder);
                                            }
                                        }
                                    } catch (OutOfMemoryError e3) {
                                        BdLog.e(e3);
                                        if (copy != null) {
                                            copy.recycle();
                                        }
                                    }
                                }
                            }
                        }
                    }, null);
                    this.XD = false;
                }
            }
        }
        return spannableStringBuilder;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void u(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.p
    public void onDestroy() {
        this.XB = false;
        MessageManager.getInstance().unRegisterListener(this.XO);
        MessageManager.getInstance().unRegisterTask(1021119);
        if (this.XK != null) {
            this.XK.clearAnimation();
        }
        this.Xz.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.p
    public void a(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.XE = alaLiveInfoData.live_id;
            if (this.XC) {
                if (this.XF != alaLiveInfoData.broadGiftMsgId) {
                    u(this.XF);
                }
            } else if (this.XG) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    u(j);
                    this.XG = false;
                }
            } else if (this.XF < alaLiveInfoData.broadGiftMsgId) {
                u(this.XF);
            }
        }
    }

    @Override // com.baidu.live.gift.p
    public View pN() {
        return this.XJ;
    }
}
