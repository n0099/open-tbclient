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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class ax {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, int i2) {
        if (absThreadDataSupport != null && context != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            String aVX = com.baidu.tieba.card.m.aVX();
            if (i == 3) {
                aVX = com.baidu.tieba.card.m.bRD();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aTN, null, aVX, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aTN.getFid()));
            createFromThreadCfg.setForumName(aTN.aWp());
            createFromThreadCfg.setJumpToCommentArea(true);
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setSortType(i2);
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            if (absThreadDataSupport.aTQ() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aTQ());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                beVar.t(aTN);
                createFromThreadCfg.setRecomData(beVar);
            }
            if (aTN.dUG) {
                createFromThreadCfg.setFromHomePageQuality(true);
            }
            if (aTN.aXs() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            com.baidu.tieba.card.m.Ez(aTN.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect, boolean z4) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && context != null) {
            bv aTN = absThreadDataSupport.aTN();
            String aVX = com.baidu.tieba.card.m.aVX();
            if (i == 3) {
                aVX = com.baidu.tieba.card.m.bRD();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aTN, null, aVX, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aTN.getFid()));
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createFromThreadCfg.setForumName(aTN.aWp());
            createFromThreadCfg.setStartFrom(i);
            if (absThreadDataSupport.aTQ() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aTQ());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                beVar.t(aTN);
                createFromThreadCfg.setRecomData(beVar);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(aTN) && !z2 && !z4) {
                createFromThreadCfg.setNeedPreLoad(true);
                com.baidu.tieba.frs.k.ak(aTN);
            }
            createFromThreadCfg.setThreadData(aTN);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(aTN.isPrivacy);
            com.baidu.tieba.card.m.Ez(aTN.getTid());
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

    private static boolean v(bv bvVar) {
        if (bvVar != null && !bvVar.isShareThread && bvVar.itemData == null && bvVar.itemStarData == null) {
            int i = bvVar.threadType;
            if (i == 0 || i == 11 || i == 40) {
                return true;
            }
            return bvVar.aUV();
        }
        return false;
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bv bvVar, String str) {
        a(view, z, list, i, bvVar, str, false);
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bv bvVar, String str, boolean z2) {
        if (view != null) {
            Context context = view.getContext();
            if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                com.baidu.adp.lib.util.l.showToast(context, R.string.plugin_image_viewer_install_error_tips);
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
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bvVar.getTid(), -1L);
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
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).kG(i).wE(bvVar.aWp()).wF(String.valueOf(bvVar.getFid())).wG(bvVar.getTid()).hl(z).wH(arrayList.size() > 0 ? arrayList.get(0) : "").hm(true).a(concurrentHashMap).hn(true).r(bvVar).hs(z2).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dI = aVar.dI(context);
            if (str != null) {
                dI.getIntent().putExtra("from", str);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
            if (context instanceof TbPageContextSupport) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = bvVar.getId();
                historyMessage.threadName = bvVar.getTitle();
                historyMessage.forumName = bvVar.aWp();
                historyMessage.postID = bvVar.aWC();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public static void a(TextView textView, bv bvVar) {
        a(textView, bvVar, 0, false);
    }

    public static void a(TextView textView, bv bvVar, boolean z) {
        a(textView, bvVar, 0, z);
    }

    public static void a(TextView textView, bv bvVar, int i, boolean z) {
        if (textView != null && bvVar != null) {
            SpannableStringBuilder spannableStringBuilder = null;
            if (bvVar.aVL() != null) {
                spannableStringBuilder = new SpannableStringBuilder(bvVar.aVL());
            }
            if (x(bvVar)) {
                textView.setVisibility(8);
            } else if (spannableStringBuilder != null) {
                if (z && bvVar.getTabId() > 0 && !as.isEmpty(bvVar.getTabName())) {
                    spannableStringBuilder.insert(0, (CharSequence) bvVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, bvVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(bvVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_d)), bvVar.getTabName().length(), bvVar.getTabName().length() + "  |  ".length(), 33);
                }
                textView.setVisibility(0);
                textView.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                if (i > 0) {
                    a(textView, spannableStringBuilder, 5, i);
                } else {
                    textView.setText(spannableStringBuilder);
                }
                com.baidu.tieba.card.m.a(textView, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
        }
    }

    public static void a(TextView textView, TextView textView2, bv bvVar, int i) {
        a(textView, textView2, bvVar, i, false);
    }

    public static void a(TextView textView, TextView textView2, bv bvVar, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        if (bvVar != null) {
            bvVar.hG(false);
            SpannableStringBuilder spannableStringBuilder2 = null;
            if (bvVar.aVM() != null) {
                spannableStringBuilder2 = new SpannableStringBuilder(bvVar.aVM());
            }
            if (bvVar.getTabId() <= 0 || as.isEmpty(bvVar.getTabName()) || !x(bvVar) || !(spannableStringBuilder2 == null || as.isEmptyStringAfterTrim(spannableStringBuilder2.toString()))) {
                spannableStringBuilder = spannableStringBuilder2;
            } else if (bvVar.isShareThread && bvVar.dUi != null) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
            } else if (bvVar.aXn()) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract));
            } else {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract));
            }
            if (spannableStringBuilder != null && !as.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                if (z && bvVar.getTabId() > 0 && !as.isEmpty(bvVar.getTabName()) && x(bvVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) bvVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, bvVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(bvVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_d)), bvVar.getTabName().length(), bvVar.getTabName().length() + "  |  ".length(), 33);
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
                bvVar.hG(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            com.baidu.tieba.card.m.a(textView, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            return;
        }
        textView.setVisibility(8);
    }

    public static void a(TextView textView, TextView textView2, SpannableString spannableString, bv bvVar, int i, boolean z, boolean z2) {
        if (bvVar != null) {
            bvVar.hG(false);
            if (spannableString != null && !as.isEmptyStringAfterTrim(spannableString.toString())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                textView.setVisibility(0);
                if (z2 && !z && bvVar.getTabId() > 0 && !as.isEmpty(bvVar.getTabName()) && x(bvVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) bvVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, bvVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(bvVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_d)), bvVar.getTabName().length(), bvVar.getTabName().length() + "  |  ".length(), 33);
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
                bvVar.hG(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            if (!z) {
                com.baidu.tieba.card.m.a(textView, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                return;
            } else if (textView instanceof TextView) {
                ao.setViewTextColor(textView, R.color.cp_cont_b);
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
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a)), 0, spannableStringBuilder3.length(), 17);
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

    public static boolean h(bv bvVar, String str) {
        return (bvVar == null || bvVar.aWl() == null || StringUtils.isNull(bvVar.aWl().getUserId()) || StringUtils.isNull(str) || !bvVar.aWl().getUserId().equals(str)) ? false : true;
    }

    public static boolean w(bv bvVar) {
        return (bvVar == null || bvVar.aWl() == null || StringUtils.isNull(bvVar.aWl().getUserId()) || !bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public static Rect aW(View view) {
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

    private static boolean x(bv bvVar) {
        return bvVar == null || bvVar.aWz() == 1 || bvVar.aVL() == null || as.isEmptyStringAfterTrim(bvVar.aVL().toString());
    }
}
