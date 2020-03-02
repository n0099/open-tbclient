package com.baidu.tbadk.core.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class au {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect) {
        if (aVar != null && aVar.aAg() != null && context != null) {
            bj aAg = aVar.aAg();
            String aCa = com.baidu.tieba.card.l.aCa();
            if (i == 3) {
                aCa = com.baidu.tieba.card.l.buY();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aAg, null, aCa, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aAg.getFid()));
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createFromThreadCfg.setForumName(aAg.aCt());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.aAj() != null) {
                createFromThreadCfg.addLocateParam(aVar.aAj());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.ax axVar = new com.baidu.tbadk.core.data.ax();
                axVar.s(aAg);
                createFromThreadCfg.setRecomData(axVar);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(aAg) && !z2) {
                createFromThreadCfg.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.aj(aAg);
            }
            createFromThreadCfg.setThreadData(aAg);
            createFromThreadCfg.setVideoOriginArea(rect);
            com.baidu.tieba.card.l.zS(aAg.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(OriginalThreadInfo originalThreadInfo, Context context, int i) {
        a(originalThreadInfo, context, i, (Rect) null);
    }

    public static void a(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect) {
        if (originalThreadInfo != null && context != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            createNormalCfg.setForumId(String.valueOf(originalThreadInfo.forumId));
            if (i == 3) {
                createNormalCfg.setFrom("from_frs");
            } else {
                createNormalCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createNormalCfg.setForumName(originalThreadInfo.forumName);
            createNormalCfg.setStartFrom(i);
            createNormalCfg.setVideoOriginArea(rect);
            if (i == 3) {
                createNormalCfg.setVideo_source("frs");
            } else if (i == 2) {
                createNormalCfg.setVideo_source("index");
            }
            createNormalCfg.setBjhData(originalThreadInfo.oriUgcInfo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z) {
        a(aVar, context, i, z, false, false, (Rect) null);
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        a(aVar, context, i, z, false, false, rect);
    }

    private static boolean t(bj bjVar) {
        if (bjVar == null || bjVar.isShareThread) {
            return false;
        }
        int i = bjVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bjVar.aEi();
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bj bjVar, String str) {
        a(view, z, list, i, bjVar, str, false);
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bj bjVar, String str, boolean z2) {
        if (view != null) {
            Context context = view.getContext();
            if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                com.baidu.adp.lib.util.l.showToast(context, (int) R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = z ? 13 : 14;
                        imageUrlData.imageUrl = mediaData.getPicUrl();
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(context).createConfig(arrayList, i, bjVar.aCt(), String.valueOf(bjVar.getFid()), bjVar.getTid(), z, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            if (str != null) {
                createConfig.getIntent().putExtra("from", str);
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(bjVar);
            if (z2) {
                createConfig.makeDynamicCard();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (context instanceof TbPageContextSupport) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = bjVar.getId();
                historyMessage.threadName = bjVar.getTitle();
                historyMessage.forumName = bjVar.aCt();
                historyMessage.postID = bjVar.aCE();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public static void a(TextView textView, bj bjVar) {
        a(textView, bjVar, 0);
    }

    public static void a(TextView textView, bj bjVar, int i) {
        if (textView != null && bjVar != null) {
            SpannableStringBuilder aBP = bjVar.aBP();
            if (bjVar.aCD() == 1 || aBP == null || aq.isEmptyStringAfterTrim(aBP.toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new com.baidu.tieba.view.h(aBP));
            if (i > 0) {
                a(textView, aBP, 5, i);
            } else {
                textView.setText(aBP);
            }
            com.baidu.tieba.card.l.a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    public static void a(TextView textView, TextView textView2, bj bjVar, int i) {
        if (bjVar != null) {
            bjVar.fD(false);
            SpannableString aBQ = bjVar.aBQ();
            if (aBQ != null && !aq.isEmptyStringAfterTrim(aBQ.toString())) {
                textView.setOnTouchListener(new com.baidu.tieba.view.h(aBQ));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aBQ);
                textView.setVisibility(0);
                int i2 = 5;
                if (textView2.getVisibility() != 8) {
                    i2 = 5 - com.baidu.adp.lib.util.v.b(i, textView2.getPaint(), textView2.getText().toString(), 2);
                }
                if (textView2.getVisibility() != 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.tbds7), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                bjVar.fD(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            com.baidu.tieba.card.l.a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            return;
        }
        textView.setVisibility(8);
    }

    public static void a(TextView textView, TextView textView2, SpannableString spannableString, bj bjVar, int i, boolean z) {
        if (bjVar != null) {
            bjVar.fD(false);
            if (spannableString != null && !aq.isEmptyStringAfterTrim(spannableString.toString())) {
                textView.setOnTouchListener(new com.baidu.tieba.view.h(spannableString));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                textView.setVisibility(0);
                int i2 = 5;
                if (textView2.getVisibility() != 8) {
                    i2 = 5 - com.baidu.adp.lib.util.v.b(i, textView2.getPaint(), textView2.getText().toString(), 2);
                }
                if (textView2.getVisibility() != 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.tbds7), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                bjVar.fD(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            if (!z) {
                com.baidu.tieba.card.l.a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return;
            } else if (textView instanceof TextView) {
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                return;
            } else {
                return;
            }
        }
        textView.setVisibility(8);
    }

    private static boolean a(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (!com.baidu.adp.lib.util.v.a(i2, textView.getPaint(), spannableStringBuilder.toString(), i)) {
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return false;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.abstract_expand_flag));
        spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null), 0, spannableStringBuilder3.length(), 17);
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
        a(textView, spannableStringBuilder, spannableStringBuilder2, i, i2);
        return true;
    }

    public static boolean a(TextView textView, String str, int i, int i2, int i3, int i4, boolean z) {
        if (textView == null || StringUtils.isNull(str)) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(HanziToPinyin.Token.SEPARATOR);
        spannableStringBuilder2.setSpan(new a(com.baidu.adp.lib.util.l.getDimens(textView.getContext(), i2)), 0, spannableStringBuilder2.length(), 17);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i));
        if (z) {
            spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null), 0, spannableStringBuilder3.length(), 33);
        }
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(HanziToPinyin.Token.SEPARATOR);
        spannableStringBuilder4.setSpan(new a(com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(str);
        spannableStringBuilder5.append((CharSequence) spannableStringBuilder2);
        spannableStringBuilder5.append((CharSequence) spannableStringBuilder3);
        spannableStringBuilder5.append((CharSequence) spannableStringBuilder4);
        if (new StaticLayout(spannableStringBuilder5, textView.getPaint(), i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= i3) {
            textView.setText(spannableStringBuilder5, TextView.BufferType.SPANNABLE);
            return false;
        }
        SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(StringHelper.STRING_MORE);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder2);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder3);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder4);
        a(textView, spannableStringBuilder, spannableStringBuilder6, i3, i4);
        return true;
    }

    private static void a(TextView textView, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, int i, int i2) {
        float f;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textView.getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        float f2 = i2;
        if (staticLayout.getLineCount() >= i) {
            spannableStringBuilder.delete(staticLayout.getLineEnd(i - 1), spannableStringBuilder.length());
            f = i2 - staticLayout.getLineWidth(i - 1);
        } else {
            f = f2;
        }
        int i3 = 2;
        CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
        float measureText = textView.getPaint().measureText(spannableStringBuilder2.toString());
        while (measureText > textView.getPaint().measureText(subSequence.toString()) + f) {
            i3++;
            if (spannableStringBuilder.length() - i3 < 0) {
                break;
            }
            subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i3, spannableStringBuilder.length());
        }
        if (spannableStringBuilder.length() - i3 > 0) {
            spannableStringBuilder.replace(spannableStringBuilder.length() - i3, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
        }
        StaticLayout staticLayout2 = new StaticLayout(spannableStringBuilder, textView.getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        for (int i4 = 0; i4 < i - 1; i4++) {
            spannableStringBuilder.insert(staticLayout2.getLineEnd(i4) + i4, "\n");
        }
        textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public static boolean a(bj bjVar, String str) {
        return (bjVar == null || bjVar.aCo() == null || StringUtils.isNull(bjVar.aCo().getUserId()) || StringUtils.isNull(str) || !bjVar.aCo().getUserId().equals(str)) ? false : true;
    }

    public static boolean u(bj bjVar) {
        return (bjVar == null || bjVar.aCo() == null || StringUtils.isNull(bjVar.aCo().getUserId()) || !bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    /* loaded from: classes.dex */
    private static class a extends ReplacementSpan {
        private final Paint mPaint;
        private int mWidth;

        public a(int i) {
            this(i, 0);
        }

        public a(int i, int i2) {
            this.mPaint = new Paint();
            this.mWidth = i;
            this.mPaint.setColor(i2);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return this.mWidth;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            canvas.drawRect(f, i3, f + this.mWidth, i5, this.mPaint);
        }
    }

    public static Rect aP(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        if (rect.height() != height) {
            if (rect.top < TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds200)) {
                rect.top = rect.bottom - height;
                return rect;
            }
            rect.bottom = height + rect.top;
            return rect;
        }
        return rect;
    }

    public static boolean a(BaijiahaoData baijiahaoData) {
        if (baijiahaoData == null) {
            return false;
        }
        switch (baijiahaoData.oriUgcType) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
}
