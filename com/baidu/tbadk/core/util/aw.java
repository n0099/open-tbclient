package com.baidu.tbadk.core.util;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class aw {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, int i2) {
        if (absThreadDataSupport != null && context != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            String aSb = com.baidu.tieba.card.m.aSb();
            if (i == 3) {
                aSb = com.baidu.tieba.card.m.bOt();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aPS, null, aSb, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aPS.getFid()));
            createFromThreadCfg.setForumName(aPS.aSt());
            createFromThreadCfg.setJumpToCommentArea(true);
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setSortType(i2);
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            if (absThreadDataSupport.aPV() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aPV());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
                bdVar.s(aPS);
                createFromThreadCfg.setRecomData(bdVar);
            }
            if (aPS.dOv) {
                createFromThreadCfg.setFromHomePageQuality(true);
            }
            if (aPS.aTw() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            com.baidu.tieba.card.m.DO(aPS.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect, boolean z4) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && context != null) {
            bu aPS = absThreadDataSupport.aPS();
            String aSb = com.baidu.tieba.card.m.aSb();
            if (i == 3) {
                aSb = com.baidu.tieba.card.m.bOt();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aPS, null, aSb, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aPS.getFid()));
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createFromThreadCfg.setForumName(aPS.aSt());
            createFromThreadCfg.setStartFrom(i);
            if (absThreadDataSupport.aPV() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aPV());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.bd bdVar = new com.baidu.tbadk.core.data.bd();
                bdVar.s(aPS);
                createFromThreadCfg.setRecomData(bdVar);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(aPS) && !z2 && !z4) {
                createFromThreadCfg.setNeedPreLoad(true);
                com.baidu.tieba.frs.k.an(aPS);
            }
            createFromThreadCfg.setThreadData(aPS);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(aPS.isPrivacy);
            com.baidu.tieba.card.m.DO(aPS.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect) {
        a(originalThreadInfo, context, i, rect, (String) null);
    }

    public static void a(OriginalThreadInfo originalThreadInfo, Context context, int i) {
        a(originalThreadInfo, context, i, (Rect) null);
    }

    public static void a(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect, String str) {
        if (originalThreadInfo != null && context != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.threadId, originalThreadInfo.postId, null);
            createNormalCfg.setForumId(String.valueOf(originalThreadInfo.forumId));
            if (i == 3) {
                createNormalCfg.setFrom("from_frs");
            } else {
                createNormalCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            if (TextUtils.isEmpty(str)) {
                createNormalCfg.setForumName(originalThreadInfo.forumName);
            } else {
                createNormalCfg.setForumName(str);
            }
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

    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z) {
        a(absThreadDataSupport, context, i, z, false, false, null, false);
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        a(absThreadDataSupport, context, i, z, false, false, rect, false);
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, boolean z2) {
        a(absThreadDataSupport, context, i, z, false, false, null, z2);
    }

    private static boolean u(bu buVar) {
        if (buVar == null || buVar.isShareThread) {
            return false;
        }
        int i = buVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return buVar.aQZ();
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bu buVar, String str) {
        a(view, z, list, i, buVar, str, false);
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bu buVar, String str, boolean z2) {
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
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(buVar.getTid(), -1L);
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
            ImageViewerConfig createConfig = new ImageViewerConfig(context).createConfig(arrayList, i, buVar.aSt(), String.valueOf(buVar.getFid()), buVar.getTid(), z, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            if (str != null) {
                createConfig.getIntent().putExtra("from", str);
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(buVar);
            if (z2) {
                createConfig.makeDynamicCard();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (context instanceof TbPageContextSupport) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = buVar.getId();
                historyMessage.threadName = buVar.getTitle();
                historyMessage.forumName = buVar.aSt();
                historyMessage.postID = buVar.aSG();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public static void a(TextView textView, bu buVar) {
        a(textView, buVar, 0, false);
    }

    public static void a(TextView textView, bu buVar, boolean z) {
        a(textView, buVar, 0, z);
    }

    public static void a(TextView textView, bu buVar, int i, boolean z) {
        if (textView != null && buVar != null) {
            SpannableStringBuilder spannableStringBuilder = null;
            if (buVar.aRP() != null) {
                spannableStringBuilder = new SpannableStringBuilder(buVar.aRP());
            }
            if (w(buVar)) {
                textView.setVisibility(8);
            } else if (spannableStringBuilder != null) {
                if (z && buVar.getTabId() > 0 && !ar.isEmpty(buVar.getTabName())) {
                    spannableStringBuilder.insert(0, (CharSequence) buVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, buVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(buVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_d)), buVar.getTabName().length(), buVar.getTabName().length() + "  |  ".length(), 33);
                }
                textView.setVisibility(0);
                textView.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                if (i > 0) {
                    a(textView, spannableStringBuilder, 5, i);
                } else {
                    textView.setText(spannableStringBuilder);
                }
                com.baidu.tieba.card.m.a(textView, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
        }
    }

    public static void a(TextView textView, TextView textView2, bu buVar, int i) {
        a(textView, textView2, buVar, i, false);
    }

    public static void a(TextView textView, TextView textView2, bu buVar, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        if (buVar != null) {
            buVar.hc(false);
            SpannableStringBuilder spannableStringBuilder2 = null;
            if (buVar.aRQ() != null) {
                spannableStringBuilder2 = new SpannableStringBuilder(buVar.aRQ());
            }
            if (buVar.getTabId() <= 0 || ar.isEmpty(buVar.getTabName()) || !w(buVar) || !(spannableStringBuilder2 == null || ar.isEmptyStringAfterTrim(spannableStringBuilder2.toString()))) {
                spannableStringBuilder = spannableStringBuilder2;
            } else if (buVar.isShareThread && buVar.dNX != null) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
            } else if (buVar.aTr()) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract));
            } else {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract));
            }
            if (spannableStringBuilder != null && !ar.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                if (z && buVar.getTabId() > 0 && !ar.isEmpty(buVar.getTabName()) && w(buVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) buVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, buVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(buVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_d)), buVar.getTabName().length(), buVar.getTabName().length() + "  |  ".length(), 33);
                }
                textView.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
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
                buVar.hc(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            com.baidu.tieba.card.m.a(textView, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            return;
        }
        textView.setVisibility(8);
    }

    public static void a(TextView textView, TextView textView2, SpannableString spannableString, bu buVar, int i, boolean z, boolean z2) {
        if (buVar != null) {
            buVar.hc(false);
            if (spannableString != null && !ar.isEmptyStringAfterTrim(spannableString.toString())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                textView.setVisibility(0);
                if (z2 && !z && buVar.getTabId() > 0 && !ar.isEmpty(buVar.getTabName()) && w(buVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) buVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, buVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(buVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_d)), buVar.getTabName().length(), buVar.getTabName().length() + "  |  ".length(), 33);
                }
                textView.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
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
                buVar.hc(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            if (!z) {
                com.baidu.tieba.card.m.a(textView, buVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                return;
            } else if (textView instanceof TextView) {
                an.setViewTextColor(textView, (int) R.color.cp_cont_b);
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
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_a)), 0, spannableStringBuilder3.length(), 17);
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
        a(textView, spannableStringBuilder, spannableStringBuilder2, i, i2);
        return true;
    }

    public static boolean a(TextView textView, String str, int i, int i2, int i3, int i4, boolean z) {
        if (textView == null || StringUtils.isNull(str)) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
        spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(com.baidu.adp.lib.util.l.getDimens(textView.getContext(), i2)), 0, spannableStringBuilder2.length(), 17);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i));
        if (z) {
            spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null), 0, spannableStringBuilder3.length(), 33);
        }
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
        spannableStringBuilder4.setSpan(new com.baidu.tbadk.core.view.a.b(com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
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
        textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public static boolean h(bu buVar, String str) {
        return (buVar == null || buVar.aSp() == null || StringUtils.isNull(buVar.aSp().getUserId()) || StringUtils.isNull(str) || !buVar.aSp().getUserId().equals(str)) ? false : true;
    }

    public static boolean v(bu buVar) {
        return (buVar == null || buVar.aSp() == null || StringUtils.isNull(buVar.aSp().getUserId()) || !buVar.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public static Rect aQ(View view) {
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

    private static boolean w(bu buVar) {
        return buVar == null || buVar.aSD() == 1 || buVar.aRP() == null || ar.isEmptyStringAfterTrim(buVar.aRP().toString());
    }
}
