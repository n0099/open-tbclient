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
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
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
public class a implements s {
    private AnimatorSet aiA;
    private TranslateAnimation aiB;
    private AlaBroadcastGiftToastData aio;
    private boolean aiq;
    private boolean aiu;
    private int aiv;
    private int aiw;
    private LinearLayout aix;
    private TextView aiy;
    private LinearLayout aiz;
    private int ds28;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<AlaBroadcastGiftToastData> ain = new ArrayList<>();
    private boolean aip = false;
    private boolean air = true;
    private long ais = -1;
    private long ait = 0;
    private HttpMessageListener aiC = new HttpMessageListener(1021119) { // from class: com.baidu.live.gift.broadcastgift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaGetBroadcastGiftResponseMessage) {
                AlaGetBroadcastGiftResponseMessage alaGetBroadcastGiftResponseMessage = (AlaGetBroadcastGiftResponseMessage) httpResponsedMessage;
                a.this.ait = alaGetBroadcastGiftResponseMessage.aiG;
                a.this.g(alaGetBroadcastGiftResponseMessage.aiF);
                a.this.th();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.broadcastgift.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zs().awM.aaF) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) view.getTag();
                    if (alaLiveInfoCoreData.broadcast_type == 2) {
                        LogManager.getCommonLogger().doClickHourRankConfirmNoticeLog(alaLiveInfoCoreData.feed_id, alaLiveInfoCoreData.otherParams);
                    }
                    if (a.this.ais != alaLiveInfoCoreData.liveID) {
                        ListUtils.add(a.this.ain, 0, a.this.aio);
                        if (ListUtils.getCount(a.this.ain) > 20) {
                            ListUtils.removeSubList(a.this.ain, 21, ListUtils.getCount(a.this.ain));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig(a.this.mContext, alaLiveInfoCoreData.liveID, "", a.this.ain)));
                        TiebaInitialize.log(new StatisticItem("c13060"));
                    }
                }
            }
        }
    };

    public a(com.baidu.live.gift.a aVar) {
        this.aiu = true;
        if (aVar != null && aVar.context != null) {
            this.mContext = aVar.context;
            this.aiq = aVar.afR;
            this.aiu = true;
            this.aix = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.broadcast_gift_toast_container, (ViewGroup) null);
            this.aiz = (LinearLayout) this.aix.findViewById(a.g.msg_background);
            this.aiz.setOnClickListener(this.mOnClickListener);
            this.aiz.setVisibility(4);
            this.aiy = (TextView) this.aix.findViewById(a.g.msg_content);
            this.aiy.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.aiy.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiy.getLayoutParams();
                layoutParams.width = i;
                this.aiy.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.aiy.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.aiv = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds630) - (this.ds28 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            tg();
            tj();
            MessageManager.getInstance().registerListener(this.aiC);
            if (!StringUtils.isNull(aVar.fromType) && aVar.fromType.equals("broadcast_gift_toast") && !ListUtils.isEmpty(aVar.afS)) {
                this.ain.addAll(aVar.afS);
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) ListUtils.getItem(this.ain, 0);
                ListUtils.remove(this.ain, 0);
                g m19do = t.m19do(String.valueOf(alaBroadcastGiftToastData.gift_id));
                t.b(m19do.rC(), 1L, m19do.rD(), m19do.rF(), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.sender_portrait, alaBroadcastGiftToastData.sender, String.valueOf(alaBroadcastGiftToastData.live_id), "", false, "", "", "", "", "");
                th();
                x(alaBroadcastGiftToastData.msg_id);
            }
        }
    }

    private void tg() {
        this.aiA = new AnimatorSet();
        this.aiA.setDuration(7000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aix, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aix, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.aix, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aiA.playTogether(this.mAnimators);
        this.aiA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.gift.broadcastgift.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aip = true;
                a.this.aiz.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.ti();
                a.this.th();
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
    public void th() {
        if (!this.aip && !ListUtils.isEmpty(this.ain)) {
            this.aio = (AlaBroadcastGiftToastData) ListUtils.getItem(this.ain, 0);
            ListUtils.remove(this.ain, 0);
            b(this.aio);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        this.aip = false;
        this.aiy.clearAnimation();
        this.aix.clearAnimation();
        this.aiz.setVisibility(4);
    }

    private void b(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            SpannableStringBuilder a = a(alaBroadcastGiftToastData, this.aiq);
            if (a != null && a.length() <= 0) {
                ti();
                th();
                return;
            }
            if (alaBroadcastGiftToastData.broadcast_type == 1 || alaBroadcastGiftToastData.broadcast_type == 2) {
                if (alaBroadcastGiftToastData.broadcast_type == 1) {
                    this.aiz.setClickable(false);
                    bu(a.f.icon_live_remind_white_n);
                } else if (alaBroadcastGiftToastData.broadcast_type == 2) {
                    if (alaBroadcastGiftToastData.live_id <= 0 || this.aiq) {
                        this.aiz.setClickable(false);
                    } else {
                        this.aiz.setClickable(true);
                    }
                    bu(a.f.champion_icon);
                }
            } else if (alaBroadcastGiftToastData.broad_type == 2) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.aiq) {
                    this.aiz.setClickable(false);
                } else {
                    this.aiz.setClickable(true);
                }
                bu(a.f.ala_broadcast_guard_club_upgrade);
            } else if (alaBroadcastGiftToastData.broad_type == 3) {
                if (alaBroadcastGiftToastData.live_id <= 0 || this.aiq) {
                    this.aiz.setClickable(false);
                } else {
                    this.aiz.setClickable(true);
                }
                bu(a.f.icon_broadcast_redpacket);
            } else {
                this.aiz.setClickable(true);
                bu(a.f.icon_live_remind_white_n);
            }
            if (this.ais == alaBroadcastGiftToastData.live_id) {
                this.aiz.setVisibility(0);
            } else if (this.aiq && alaBroadcastGiftToastData.broadcast_type != 1 && alaBroadcastGiftToastData.broadcast_type != 2) {
                this.aiz.setClickable(false);
                this.aiz.setVisibility(0);
            } else {
                this.aiz.setVisibility(0);
            }
            if (alaBroadcastGiftToastData.broad_type == 2 || alaBroadcastGiftToastData.broad_type == 4 || alaBroadcastGiftToastData.broad_type == 5) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.mContext.getResources().getDrawable(a.f.ala_broadcast_message_bg_guard);
                gradientDrawable.setAlpha(Opcodes.GETSTATIC);
                this.aiz.setBackgroundDrawable(gradientDrawable);
            } else {
                this.aiz.setBackgroundResource(a.f.ala_broadcast_gift_toast_bg);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaBroadcastGiftToastData.live_id;
            alaLiveInfoCoreData.broadcast_type = alaBroadcastGiftToastData.broadcast_type;
            alaLiveInfoCoreData.feed_id = alaBroadcastGiftToastData.feed_id;
            alaLiveInfoCoreData.otherParams = alaBroadcastGiftToastData.otherParams;
            this.aiz.setTag(alaLiveInfoCoreData);
            this.aiy.setText(a);
            Drawable[] compoundDrawables = this.aiy.getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 0) {
                this.aiw = compoundDrawables[0].getIntrinsicWidth();
            }
            this.aiw = ((TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) || !(alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) ? 1 : 3) * this.aiw;
            this.aiw += this.aiy.getCompoundDrawablePadding() * 4;
            if (a != null) {
                int textWidth = this.aiw + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.aiv) * 1.0f) / this.aiv);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiy.getLayoutParams();
                if (textWidth - this.aiv < 0) {
                    layoutParams.width = -2;
                    this.aiy.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.aiy.setLayoutParams(layoutParams);
                    this.aiB = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aiB.setStartOffset(1500L);
                    this.aiB.setDuration(2000L);
                    this.aiB.setFillAfter(true);
                    this.aiy.startAnimation(this.aiB);
                }
            }
            this.aiA.start();
            TiebaInitialize.log(new StatisticItem("c13059"));
        }
    }

    private void bu(int i) {
        this.aiy.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(i), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aiy.setCompoundDrawablePadding(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        boolean z;
        if (arrayList != null) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null) {
                    Iterator<AlaBroadcastGiftToastData> it2 = this.ain.iterator();
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
                        this.ain.add(next);
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public void a(AlaBroadcastGiftToastData alaBroadcastGiftToastData) {
        if (alaBroadcastGiftToastData != null) {
            this.ain.add(alaBroadcastGiftToastData);
            th();
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
                } else if (z && this.ais == alaBroadcastGiftToastData.live_id) {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_master_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.gift_name));
                } else {
                    spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.ala_broadcasr_gift_audience_receive), alaBroadcastGiftToastData.sender, alaBroadcastGiftToastData.receiver, alaBroadcastGiftToastData.gift_name));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), alaBroadcastGiftToastData.sender.length() + 1, alaBroadcastGiftToastData.sender.length() + alaBroadcastGiftToastData.receiver.length() + 3, 34);
                }
                if (!TextUtils.isEmpty(alaBroadcastGiftToastData.gift_url) && (alaBroadcastGiftToastData.broad_type == 1 || alaBroadcastGiftToastData.broad_type == 4)) {
                    this.aiy.setTag(alaBroadcastGiftToastData.gift_url);
                    this.air = true;
                    BdResourceLoader.getInstance().loadResource(alaBroadcastGiftToastData.gift_url, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.broadcastgift.a.4
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                        public void onLoaded(BdImage bdImage, String str, int i) {
                            Bitmap rawBitmap;
                            Bitmap copy;
                            Bitmap copy2;
                            super.onLoaded((AnonymousClass4) bdImage, str, i);
                            if (a.this.aiy != null && bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
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
                                            if (!a.this.air && (a.this.aiy.getTag() instanceof String) && ((String) a.this.aiy.getTag()).equals(str)) {
                                                a.this.aiy.setText(spannableStringBuilder);
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
                    this.air = false;
                }
            }
        }
        return spannableStringBuilder;
    }

    private void tj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void x(long j) {
        HttpMessage httpMessage = new HttpMessage(1021119);
        httpMessage.addParam("msg_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.gift.s
    public void onDestroy() {
        this.aip = false;
        MessageManager.getInstance().unRegisterListener(this.aiC);
        MessageManager.getInstance().unRegisterTask(1021119);
        if (this.aiy != null) {
            this.aiy.clearAnimation();
        }
        this.ain.clear();
        com.baidu.live.gift.a.broadGiftMsgId = 0L;
    }

    @Override // com.baidu.live.gift.s
    public void a(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.ais = alaLiveInfoData.live_id;
            if (this.aiq) {
                if (this.ait != alaLiveInfoData.broadGiftMsgId) {
                    x(this.ait);
                }
            } else if (this.aiu) {
                long j = com.baidu.live.gift.a.broadGiftMsgId;
                if (alaLiveInfoData.broadGiftMsgId > j) {
                    x(j);
                    this.aiu = false;
                }
            } else if (this.ait < alaLiveInfoData.broadGiftMsgId) {
                x(this.ait);
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public View sH() {
        return this.aix;
    }
}
