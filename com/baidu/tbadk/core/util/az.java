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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class az {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, int i2) {
        if (aVar != null && context != null && aVar.bmn() != null) {
            by bmn = aVar.bmn();
            String boB = com.baidu.tieba.card.n.boB();
            if (i == 3) {
                boB = com.baidu.tieba.card.n.crY();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(bmn.getFid())));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bmn, null, boB, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bmn.getFid()));
            createFromThreadCfg.setForumName(bmn.boT());
            createFromThreadCfg.setJumpToCommentArea(true);
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setSortType(i2);
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            if (aVar.bmq() != null) {
                createFromThreadCfg.addLocateParam(aVar.bmq());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
                bhVar.u(bmn);
                createFromThreadCfg.setRecomData(bhVar);
            }
            if (bmn.eMf) {
                createFromThreadCfg.setFromHomePageQuality(true);
            }
            if (bmn.bpY() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            com.baidu.tieba.card.n.Jq(bmn.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect, boolean z4) {
        if (aVar != null && aVar.bmn() != null && context != null) {
            by bmn = aVar.bmn();
            String boB = com.baidu.tieba.card.n.boB();
            if (i == 3) {
                boB = com.baidu.tieba.card.n.crY();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(bmn.getFid())));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bmn, null, boB, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bmn.getFid()));
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createFromThreadCfg.setForumName(bmn.boT());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.bmq() != null) {
                createFromThreadCfg.addLocateParam(aVar.bmq());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.bh bhVar = new com.baidu.tbadk.core.data.bh();
                bhVar.u(bmn);
                createFromThreadCfg.setRecomData(bhVar);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bmn) && !z2 && !z4) {
                createFromThreadCfg.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.an(bmn);
            }
            createFromThreadCfg.setThreadData(bmn);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(bmn.isPrivacy);
            com.baidu.tieba.card.n.Jq(bmn.getTid());
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.forumId)));
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

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z) {
        a(aVar, context, i, z, false, false, (Rect) null, false);
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        a(aVar, context, i, z, false, false, rect, false);
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, boolean z2) {
        a(aVar, context, i, z, false, false, (Rect) null, z2);
    }

    private static boolean w(by byVar) {
        if (byVar != null && !byVar.isShareThread && byVar.itemData == null && byVar.itemStarData == null) {
            int i = byVar.threadType;
            if (i == 0 || i == 11 || i == 40) {
                return true;
            }
            return byVar.bnz();
        }
        return false;
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, by byVar, String str) {
        a(view, z, list, i, byVar, str, false);
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, by byVar, String str, boolean z2) {
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
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(byVar.getTid(), -1L);
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
            aVar.x(arrayList).oj(i).AG(byVar.boT()).AH(String.valueOf(byVar.getFid())).AI(byVar.getTid()).iN(z).AJ(arrayList.size() > 0 ? arrayList.get(0) : "").iO(true).a(concurrentHashMap).iP(true).s(byVar).iU(z2).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig ez = aVar.ez(context);
            if (str != null) {
                ez.getIntent().putExtra("from", str);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
            if (context instanceof TbPageContextSupport) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = byVar.getId();
                historyMessage.threadName = byVar.getTitle();
                historyMessage.forumName = byVar.boT();
                historyMessage.postID = byVar.bpg();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public static void a(TextView textView, by byVar) {
        a(textView, byVar, 0, false);
    }

    public static void a(TextView textView, by byVar, boolean z) {
        a(textView, byVar, 0, z);
    }

    public static void a(TextView textView, by byVar, int i, boolean z) {
        if (textView != null && byVar != null) {
            SpannableStringBuilder spannableStringBuilder = null;
            if (byVar.bop() != null) {
                spannableStringBuilder = new SpannableStringBuilder(byVar.bop());
            }
            if (y(byVar)) {
                textView.setVisibility(8);
            } else if (spannableStringBuilder != null) {
                if (z && byVar.getTabId() > 0 && !au.isEmpty(byVar.getTabName())) {
                    spannableStringBuilder.insert(0, (CharSequence) byVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, byVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(byVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0203)), byVar.getTabName().length(), byVar.getTabName().length() + "  |  ".length(), 33);
                }
                if (byVar.brb()) {
                    b(spannableStringBuilder);
                }
                textView.setVisibility(0);
                textView.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                if (i > 0) {
                    a(textView, spannableStringBuilder, 5, i);
                } else {
                    textView.setText(spannableStringBuilder);
                }
                com.baidu.tieba.card.n.a(textView, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
        }
    }

    public static void a(TextView textView, TextView textView2, by byVar, int i) {
        a(textView, textView2, byVar, i, false);
    }

    public static void a(TextView textView, TextView textView2, by byVar, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        if (byVar != null) {
            byVar.ji(false);
            SpannableStringBuilder spannableStringBuilder2 = null;
            if (byVar.boq() != null) {
                spannableStringBuilder2 = new SpannableStringBuilder(byVar.boq());
            }
            if (byVar.getTabId() <= 0 || au.isEmpty(byVar.getTabName()) || !y(byVar) || !(spannableStringBuilder2 == null || au.isEmptyStringAfterTrim(spannableStringBuilder2.toString()))) {
                spannableStringBuilder = spannableStringBuilder2;
            } else if (byVar.isShareThread && byVar.eLH != null) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
            } else if (byVar.bpT()) {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract));
            } else {
                spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract));
            }
            if (spannableStringBuilder != null && !au.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                if (z && byVar.getTabId() > 0 && !au.isEmpty(byVar.getTabName()) && y(byVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) byVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, byVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(byVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0203)), byVar.getTabName().length(), byVar.getTabName().length() + "  |  ".length(), 33);
                }
                if (y(byVar) && byVar.brb()) {
                    b(spannableStringBuilder);
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
                    layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                byVar.ji(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            com.baidu.tieba.card.n.a(textView, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }

    private static void b(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, "官方");
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i = R.color.CAM_X0306;
            int i2 = R.color.CAM_X0101;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, i, dimens3, i2, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42));
            bVar.qC(dimens2);
            bVar.setMarginRight(dimens5);
            bVar.jB(true);
            bVar.jA(true);
            bVar.qB(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder.setSpan(bVar, 0, "官方".length(), 17);
        }
    }

    public static void a(TextView textView, TextView textView2, SpannableString spannableString, by byVar, int i, boolean z, boolean z2) {
        if (byVar != null) {
            byVar.ji(false);
            if (spannableString != null && !au.isEmptyStringAfterTrim(spannableString.toString())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                textView.setVisibility(0);
                if (z2 && !z && byVar.getTabId() > 0 && !au.isEmpty(byVar.getTabName()) && y(byVar)) {
                    spannableStringBuilder.insert(0, (CharSequence) byVar.getTabName());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, byVar.getTabName().length(), 33);
                    spannableStringBuilder.insert(byVar.getTabName().length(), (CharSequence) "  |  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0203)), byVar.getTabName().length(), byVar.getTabName().length() + "  |  ".length(), 33);
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
                    layoutParams2.setMargins(0, com.baidu.adp.lib.util.l.getDimens(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                byVar.ji(a(textView, spannableStringBuilder, i2, i));
            } else {
                textView.setVisibility(8);
            }
            if (!z) {
                com.baidu.tieba.card.n.a(textView, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            } else if (textView instanceof TextView) {
                ap.setViewTextColor(textView, R.color.CAM_X0105);
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
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, spannableStringBuilder3.length(), 17);
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
        a(textView, spannableStringBuilder, spannableStringBuilder2, i, i2);
        return true;
    }

    public static boolean a(TextView textView, String str, int i, int i2, int i3, int i4, boolean z) {
        return a(textView, str, i, i2, i3, i4, z, true);
    }

    public static boolean a(TextView textView, String str, int i, int i2, int i3, int i4, boolean z, boolean z2) {
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
        if (z2) {
            spannableStringBuilder5.append((CharSequence) spannableStringBuilder3);
        }
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

    public static void a(View view, boolean z, int i) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (z) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                }
            } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i;
            }
        }
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

    public static boolean h(by byVar, String str) {
        return (byVar == null || byVar.boP() == null || StringUtils.isNull(byVar.boP().getUserId()) || StringUtils.isNull(str) || !byVar.boP().getUserId().equals(str)) ? false : true;
    }

    public static boolean x(by byVar) {
        return (byVar == null || byVar.boP() == null || StringUtils.isNull(byVar.boP().getUserId()) || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public static Rect bn(View view) {
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

    public static boolean y(by byVar) {
        return byVar == null || byVar.bpd() == 1 || byVar.bop() == null || au.isEmptyStringAfterTrim(byVar.bop().toString());
    }

    public static boolean z(by byVar) {
        return byVar == null || byVar.boq() == null || au.isEmptyStringAfterTrim(byVar.boq().toString());
    }

    public static boolean A(by byVar) {
        return byVar == null || y.getCount(byVar.bpc()) <= 0;
    }
}
