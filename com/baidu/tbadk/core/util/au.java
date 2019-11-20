package com.baidu.tbadk.core.util;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class au {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z) {
        if (aVar != null && aVar.agG() != null && context != null) {
            bh agG = aVar.agG();
            String air = com.baidu.tieba.card.n.air();
            if (i == 3 || i == 15) {
                air = com.baidu.tieba.card.n.bam();
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(agG, null, air, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(agG.getFid()));
            if (i == 3 || i == 15) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            createFromThreadCfg.setForumName(agG.aiJ());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.agJ() != null) {
                createFromThreadCfg.addLocateParam(aVar.agJ());
            }
            if (i == 3 || i == 15) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
                avVar.n(agG);
                createFromThreadCfg.setRecomData(avVar);
            }
            createFromThreadCfg.setJumpGodReply(z);
            com.baidu.tieba.card.n.uz(agG.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(View view, boolean z, List<MediaData> list, int i, bh bhVar, String str) {
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
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
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
            ImageViewerConfig createConfig = new ImageViewerConfig(context).createConfig(arrayList, i, bhVar.aiJ(), String.valueOf(bhVar.getFid()), bhVar.getTid(), z, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            if (str != null) {
                createConfig.getIntent().putExtra("from", str);
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (context instanceof TbPageContextSupport) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
                historyMessage.threadId = bhVar.getId();
                historyMessage.threadName = bhVar.getTitle();
                historyMessage.forumName = bhVar.aiJ();
                historyMessage.postID = bhVar.aiU();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public static void a(TextView textView, bh bhVar) {
        if (textView != null && bhVar != null) {
            SpannableStringBuilder aif = bhVar.aif();
            if (bhVar.aiT() == 1 || aif == null || aq.isEmptyStringAfterTrim(aif.toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new com.baidu.tieba.view.k(aif));
            textView.setText(aif);
            com.baidu.tieba.card.n.a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    public static void a(TextView textView, TextView textView2, bh bhVar, int i) {
        int i2;
        float f;
        if (bhVar != null) {
            bhVar.ee(false);
            SpannableString aig = bhVar.aig();
            if (aig != null && !aq.isEmptyStringAfterTrim(aig.toString())) {
                textView.setOnTouchListener(new com.baidu.tieba.view.k(aig));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aig);
                textView.setVisibility(0);
                if (textView2.getVisibility() == 8) {
                    i2 = 5;
                } else {
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
                if (!com.baidu.adp.lib.util.v.a(i, textView.getPaint(), spannableStringBuilder.toString(), i2)) {
                    textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.abstract_expand_flag));
                    spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.util.au.1
                    }, 0, spannableStringBuilder3.length(), 17);
                    spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), textView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    float f2 = i;
                    if (staticLayout.getLineCount() >= i2) {
                        spannableStringBuilder.delete(staticLayout.getLineEnd(i2 - 1), aig.length());
                        f = i - staticLayout.getLineWidth(i2 - 1);
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
                    bhVar.ee(true);
                    textView.setText(spannableStringBuilder);
                }
            } else {
                textView.setVisibility(8);
            }
            com.baidu.tieba.card.n.a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            return;
        }
        textView.setVisibility(8);
    }

    public static boolean o(bh bhVar) {
        return (bhVar == null || bhVar.aiE() == null || StringUtils.isNull(bhVar.aiE().getUserId()) || !bhVar.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }
}
