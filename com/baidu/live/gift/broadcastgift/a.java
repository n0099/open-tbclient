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
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.r.a;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a implements r {
    private AlaBroadcastGiftToastData afU;
    private boolean afW;
    private boolean aga;
    private int agb;
    private int agc;
    private LinearLayout agd;
    private TextView agf;
    private LinearLayout agg;
    private AnimatorSet agh;
    private TranslateAnimation agi;
    private int ds28;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> afT = new ArrayList<>();
    private boolean afV = false;
    private boolean afX = true;
    private long afY = -1;
    private long afZ = 0;
    private HttpMessageListener agj = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.afZ = alaGetBroadcastGiftResponseMessage.agn;
                a.this.f(alaGetBroadcastGiftResponseMessage.agm);
                a.this.rR();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.s.a.wR().asq.YD) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.broadcast_type == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.afY != alaLiveInfoCoreData.liveID) {
                        ListUtils.add(a.this.afT, 0, a.this.afU);
                        if (ListUtils.getCount(a.this.afT) > 20) {
                            ListUtils.removeSubList(a.this.afT, 21, ListUtils.getCount(a.this.afT));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.afT)));
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aga = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.afW = aVar.adF;
            this.aga = true;
            this.agd = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.agg = (LinearLayout) this.agd.findViewById(a.g.msg_background);
            this.agg.setOnClickListener(this.mOnClickListener);
            this.agg.setVisibility(4);
            this.agf = (TextView) this.agd.findViewById(a.g.msg_content);
            this.agf.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.agf.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agf.getLayoutParams();
                layoutParams.width = i;
                this.agf.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.agf.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.agb = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630) - (this.ds28 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            rQ();
            rT();
            MessageManager.getInstance().registerListener(this.agj);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.adG)) {
                this.afT.addAll(aVar.adG);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.afT, 0);
                ListUtils.remove(this.afT, 0);
                g df = s.df(String.valueOf(alaBroadcastGiftToastData.gift_id));
                s.b(df.qE(), 1L, df.qF(), df.qH(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "");
                rR();
                w(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void rQ() {
        this.agh = new AnimatorSet();
        this.agh.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.agd, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.agd, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.agd, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.agh.playTogether(this.mAnimators);
        this.agh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.afV = true;
                a.this.agg.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.rS();
                a.this.rR();
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
    public void rR() {
        if (!this.afV && !ListUtils.isEmpty(this.afT)) {
            this.afU = (AlaBroadcastGiftToastData) ListUtils.getItem(this.afT, 0);
            ListUtils.remove(this.afT, 0);
            a(this.afU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        this.afV = false;
        this.agf.clearAnimation();
        this.agd.clearAnimation();
        this.agg.setVisibility(4);
    }

    private void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            SpannableStringBuilder a = a(alaBroadcastGiftToastData, this.afW);
            if (a != null && a.length() <= 0) {
                rS();
                rR();
                return;
            }
            if (alaBroadcastGiftToastData.broadcast_type == 1 || alaBroadcastGiftToastData.broadcast_type == 2) {
                if (alaBroadcastGiftToastData.broadcast_type == 1) {
                    this.agg.setClickable(false);
                    bn(a.f.icon_live_remind_white_n);
                } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                    if (alaBroadcastGiftToastData.live_id <= 0 || this.afW) {
                        this.agg.setClickable(false);
                    } else {
                        this.agg.setClickable(true);
                    }
                    bn(a.f.champion_icon);
                }
            } else if (alaBroadcastGiftToastData.broad_type == 2) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.afW) {
                    this.agg.setClickable(false);
                } else {
                    this.agg.setClickable(true);
                }
                bn(a.f.ala_broadcast_guard_club_upgrade);
            } else if (alaBroadcastGiftToastData.broad_type == 3) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.afW) {
                    this.agg.setClickable(false);
                } else {
                    this.agg.setClickable(true);
                }
                bn(a.f.icon_broadcast_redpacket);
            } else {
                this.agg.setClickable(true);
                bn(a.f.icon_live_remind_white_n);
            }
            if (this.afY == alaBroadcastGiftToastData.live_id) {
                this.agg.setVisibility(0);
            } else if (this.afW && alaBroadcastGiftToastData.broadcast_type != 1 && alaBroadcastGiftToastData.broadcast_type != 2) {
                this.agg.setClickable(false);
                this.agg.setVisibility(0);
            } else {
                this.agg.setVisibility(0);
            }
            if (alaBroadcastGiftToastData.broad_type == 2 || alaBroadcastGiftToastData.broad_type == 4 || alaBroadcastGiftToastData.broad_type == 5) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.f.ala_broadcast_message_bg_guard);
                gradientDrawable.setAlpha(178);
                this.agg.setBackgroundDrawable(gradientDrawable);
            } else {
                this.agg.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
            alaLiveInfoCoreData.broadcast_type = alaBroadcastGiftToastData.broadcast_type;
            alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
            alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
            this.agg.setTag(alaLiveInfoCoreData);
            this.agf.setText(a);
            Drawable[] compoundDrawables = this.agf.getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 0) {
                this.agc = compoundDrawables[0].getIntrinsicWidth();
            }
            this.agc = ((TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) || !(alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) ? 1 : 3) * this.agc;
            this.agc += this.agf.getCompoundDrawablePadding() * 4;
            if (a != null) {
                int textWidth = this.agc + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.agb) * 1.0f) / this.agb);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agf.getLayoutParams();
                if (textWidth - this.agb < 0) {
                    layoutParams.width = -2;
                    this.agf.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.agf.setLayoutParams(layoutParams);
                    this.agi = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.agi.setStartOffset(1500L);
                    this.agi.setDuration(2000L);
                    this.agi.setFillAfter(true);
                    this.agf.startAnimation(this.agi);
                }
            }
            this.agh.start();
            TiebaInitialize.log(new StatisticItem("c13059"));
        }
    }

    private void bn(int i) {
        this.agf.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(i), (Drawable) null, (Drawable) null, (Drawable) null);
        this.agf.setCompoundDrawablePadding(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.afT.iterator();
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
                        this.afT.add(next);
                    }
                }
            }
        }
    }

    public void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.afT.add(alaBroadcastGiftToastData);
            rR();
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
                } else if (z && this.afY == alaBroadcastGiftToastData.live_id) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_master_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.gift_name));
                } else {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_audience_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver, alaBroadcastGiftToastData.gift_name));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 1, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 3, 34);
                }
                if (!TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) && (alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) {
                    this.agf.setTag(alaBroadcastGiftToastData.gift_url);
                    this.afX = true;
                    BdResourceLoader.getInstance().loadResource(alaBroadcastGiftToastData.gift_url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.broadcastgift.a.4
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str, int i) {
                            Bitmap rawBitmap;
                            Bitmap copy;
                            Bitmap copy2;
                            super.onLoaded((AnonymousClass4) bdImage, str, i);
                            if (a.this.agf != null && bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
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
                                            if (!a.this.afX && (a.this.agf.getTag() instanceof String) && ((String) a.this.agf.getTag()).equals(str)) {
                                                a.this.agf.setText(spannableStringBuilder);
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
                    this.afX = false;
                }
            }
        }
        return spannableStringBuilder;
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void w(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.r
    public void onDestroy() {
        this.afV = false;
        MessageManager.getInstance().unRegisterListener(this.agj);
        MessageManager.getInstance().unRegisterTask(1021119);
        if (this.agf != null) {
            this.agf.clearAnimation();
        }
        this.afT.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.r
    public void a(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.afY = alaLiveInfoData.live_id;
            if (this.afW) {
                if (this.afZ != alaLiveInfoData.broadGiftMsgId) {
                    w(this.afZ);
                }
            } else if (this.aga) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    w(j);
                    this.aga = false;
                }
            } else if (this.afZ < alaLiveInfoData.broadGiftMsgId) {
                w(this.afZ);
            }
        }
    }

    @Override // com.baidu.live.gift.r
    public View rB() {
        return this.agd;
    }
}
