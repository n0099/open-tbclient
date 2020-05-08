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
import com.alibaba.fastjson.asm.Opcodes;
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
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a implements t {
    private AlaBroadcastGiftToastData aAN;
    private boolean aAP;
    private boolean aAT;
    private int aAU;
    private int aAV;
    private LinearLayout aAW;
    private TextView aAX;
    private LinearLayout aAY;
    private AnimatorSet aAZ;
    private TranslateAnimation aBa;
    private int ds28;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> aAM = new ArrayList<>();
    private boolean aAO = false;
    private boolean aAQ = true;
    private long aAR = -1;
    private long aAS = 0;
    private HttpMessageListener aBb = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.aAS = alaGetBroadcastGiftResponseMessage.aBf;
                a.this.g(alaGetBroadcastGiftResponseMessage.aBe);
                a.this.xz();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.En().aQu.ata) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.broadcast_type == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.aAR != alaLiveInfoCoreData.liveID) {
                        ListUtils.add(a.this.aAM, 0, a.this.aAN);
                        if (ListUtils.getCount(a.this.aAM) > 20) {
                            ListUtils.removeSubList(a.this.aAM, 21, ListUtils.getCount(a.this.aAM));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.aAM)));
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aAT = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aAP = aVar.ayo;
            this.aAT = true;
            this.aAW = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aAY = (LinearLayout) this.aAW.findViewById(a.g.msg_background);
            this.aAY.setOnClickListener(this.mOnClickListener);
            this.aAY.setVisibility(4);
            this.aAX = (TextView) this.aAW.findViewById(a.g.msg_content);
            this.aAX.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.aAX.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAX.getLayoutParams();
                layoutParams.width = i;
                this.aAX.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.aAX.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aAU = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630) - (this.ds28 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            xy();
            xB();
            MessageManager.getInstance().registerListener(this.aBb);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.ayp)) {
                this.aAM.addAll(aVar.ayp);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aAM, 0);
                ListUtils.remove(this.aAM, 0);
                g ef = u.ef(String.valueOf(alaBroadcastGiftToastData.gift_id));
                u.b(ef.vU(), 1L, ef.vV(), ef.vX(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "", -1L);
                xz();
                V(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void xy() {
        this.aAZ = new AnimatorSet();
        this.aAZ.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aAW, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aAW, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aAW, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aAZ.playTogether(this.mAnimators);
        this.aAZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aAO = true;
                a.this.aAY.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.xA();
                a.this.xz();
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
    public void xz() {
        if (!this.aAO && !ListUtils.isEmpty(this.aAM)) {
            this.aAN = (AlaBroadcastGiftToastData) ListUtils.getItem(this.aAM, 0);
            ListUtils.remove(this.aAM, 0);
            b(this.aAN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xA() {
        this.aAO = false;
        this.aAX.clearAnimation();
        this.aAW.clearAnimation();
        this.aAY.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            SpannableStringBuilder a = a(alaBroadcastGiftToastData, this.aAP);
            if (a != null && a.length() <= 0) {
                xA();
                xz();
                return;
            }
            if (alaBroadcastGiftToastData.broadcast_type == 1 || alaBroadcastGiftToastData.broadcast_type == 2) {
                if (alaBroadcastGiftToastData.broadcast_type == 1) {
                    this.aAY.setClickable(false);
                    bH(a.f.icon_live_remind_white_n);
                } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                    if (alaBroadcastGiftToastData.live_id <= 0 || this.aAP) {
                        this.aAY.setClickable(false);
                    } else {
                        this.aAY.setClickable(true);
                    }
                    bH(a.f.champion_icon);
                }
            } else if (alaBroadcastGiftToastData.broad_type == 2) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.aAP) {
                    this.aAY.setClickable(false);
                } else {
                    this.aAY.setClickable(true);
                }
                bH(a.f.ala_broadcast_guard_club_upgrade);
            } else if (alaBroadcastGiftToastData.broad_type == 3) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.aAP) {
                    this.aAY.setClickable(false);
                } else {
                    this.aAY.setClickable(true);
                }
                bH(a.f.icon_broadcast_redpacket);
            } else {
                this.aAY.setClickable(true);
                bH(a.f.icon_live_remind_white_n);
            }
            if (this.aAR == alaBroadcastGiftToastData.live_id) {
                this.aAY.setVisibility(0);
            } else if (this.aAP && alaBroadcastGiftToastData.broadcast_type != 1 && alaBroadcastGiftToastData.broadcast_type != 2) {
                this.aAY.setClickable(false);
                this.aAY.setVisibility(0);
            } else {
                this.aAY.setVisibility(0);
            }
            if (alaBroadcastGiftToastData.broad_type == 2 || alaBroadcastGiftToastData.broad_type == 4 || alaBroadcastGiftToastData.broad_type == 5) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.f.ala_broadcast_message_bg_guard);
                gradientDrawable.setAlpha(Opcodes.GETSTATIC);
                this.aAY.setBackgroundDrawable(gradientDrawable);
            } else {
                this.aAY.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
            alaLiveInfoCoreData.broadcast_type = alaBroadcastGiftToastData.broadcast_type;
            alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
            alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
            this.aAY.setTag(alaLiveInfoCoreData);
            this.aAX.setText(a);
            Drawable[] compoundDrawables = this.aAX.getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 0) {
                this.aAV = compoundDrawables[0].getIntrinsicWidth();
            }
            this.aAV = ((TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) || !(alaBroadcastGiftToastData.broad_type == 0 || alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) ? 1 : 3) * this.aAV;
            this.aAV += this.aAX.getCompoundDrawablePadding() * 4;
            if (a != null) {
                int textWidth = this.aAV + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.aAU) * 1.0f) / this.aAU);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAX.getLayoutParams();
                if (textWidth - this.aAU < 0) {
                    layoutParams.width = -2;
                    this.aAX.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.aAX.setLayoutParams(layoutParams);
                    this.aBa = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aBa.setStartOffset(1500L);
                    this.aBa.setDuration(2000L);
                    this.aBa.setFillAfter(true);
                    this.aAX.startAnimation(this.aBa);
                }
            }
            this.aAZ.start();
            TiebaInitialize.log(new StatisticItem("c13059"));
        }
    }

    private void bH(int i) {
        this.aAX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(i), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aAX.setCompoundDrawablePadding(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.aAM.iterator();
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
                        this.aAM.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.aAM.add(alaBroadcastGiftToastData);
            xz();
        }
    }

    public SpannableStringBuilder a(AlaBroadcastGiftToastData alaBroadcastGiftToastData, boolean z) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaBroadcastGiftToastData != null) {
            if (alaBroadcastGiftToastData.broadcast_type == 1) {
                spannableStringBuilder.append((CharSequence) this.mContext.getString(a.i.broadcasr_hour_rank_left_alarm));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 3, 5, 34);
                return spannableStringBuilder;
            } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcasr_hour_rank_confirm), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 2, alaBroadcastGiftToastData.sender.length() + 2, 34);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 6, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 6, 34);
                return spannableStringBuilder;
            } else {
                if (alaBroadcastGiftToastData.broad_type == 2) {
                    String format = String.format(this.mContext.getString(a.i.broadcast_guard_club_upgrade), alaBroadcastGiftToastData.subjectName, String.valueOf(alaBroadcastGiftToastData.keywords));
                    spannableStringBuilder.append((CharSequence) format);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), 6, alaBroadcastGiftToastData.subjectName.length() + 6, 34);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), alaBroadcastGiftToastData.subjectName.length() + 11, format.length(), 34);
                } else if (alaBroadcastGiftToastData.broad_type == 3) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcast_redpacket), alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.receiver)));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), 0, alaBroadcastGiftToastData.sender.length(), 34);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), alaBroadcastGiftToastData.sender.length() + 1, alaBroadcastGiftToastData.sender.length() + 1 + alaBroadcastGiftToastData.receiver.length(), 34);
                } else if (alaBroadcastGiftToastData.broad_type == 4) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcast_turntable_top), alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.receiver), alaBroadcastGiftToastData.keywords, alaBroadcastGiftToastData.gift_name));
                    int length = TextUtils.isEmpty(alaBroadcastGiftToastData.sender) ? 0 : alaBroadcastGiftToastData.sender.length();
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), length + 6, length + 6 + alaBroadcastGiftToastData.receiver.length(), 34);
                } else if (alaBroadcastGiftToastData.broad_type == 5) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.broadcast_turntable_num), alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.receiver), alaBroadcastGiftToastData.keywords, alaBroadcastGiftToastData.gift_name));
                    int length2 = TextUtils.isEmpty(alaBroadcastGiftToastData.sender) ? 0 : alaBroadcastGiftToastData.sender.length();
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5DD1F")), length2 + 6, length2 + 6 + alaBroadcastGiftToastData.receiver.length(), 34);
                } else if (z && this.aAR == alaBroadcastGiftToastData.live_id) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_master_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.gift_name));
                } else {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_audience_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver, alaBroadcastGiftToastData.gift_name));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 1, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 3, 34);
                }
                if (!TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) && (alaBroadcastGiftToastData.broad_type == 0 || alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) {
                    this.aAX.setTag(alaBroadcastGiftToastData.gift_url);
                    this.aAQ = true;
                    BdResourceLoader.getInstance().loadResource(alaBroadcastGiftToastData.gift_url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.broadcastgift.a.4
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str, int i) {
                            Bitmap rawBitmap;
                            Bitmap copy;
                            Bitmap copy2;
                            super.onLoaded((AnonymousClass4) bdImage, str, i);
                            if (a.this.aAX != null && bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
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
                                            if (!a.this.aAQ && (a.this.aAX.getTag() instanceof String) && ((String) a.this.aAX.getTag()).equals(str)) {
                                                a.this.aAX.setText(spannableStringBuilder);
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
                    this.aAQ = false;
                }
            }
        }
        return spannableStringBuilder;
    }

    private void xB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void V(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.t
    public void onDestroy() {
        this.aAO = false;
        MessageManager.getInstance().unRegisterListener(this.aBb);
        MessageManager.getInstance().unRegisterTask(1021119);
        if (this.aAX != null) {
            this.aAX.clearAnimation();
        }
        this.aAM.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.t
    public void a(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.aAR = alaLiveInfoData.live_id;
            if (this.aAP) {
                if (this.aAS != alaLiveInfoData.broadGiftMsgId) {
                    V(this.aAS);
                }
            } else if (this.aAT) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    V(j);
                    this.aAT = false;
                }
            } else if (this.aAS < alaLiveInfoData.broadGiftMsgId) {
                V(this.aAS);
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public View wZ() {
        return this.aAW;
    }
}
