package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.WorkIntroSwitch;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.t;
import d.a.n0.b1.m.f;
import d.a.n0.r.f0.b;
import d.a.n0.r.q.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.k1;
import d.a.o0.r0.l;
import d.a.o0.v3.i;
import d.a.o0.z.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class ThreadCardUtils {
    public static final String REAL_TIME_PIC_TYPE = "1";
    public static final String REAL_TIME_VIDEO_TYPE = "3";
    public static final String REAL_TIME_VOICE_TYPE = "2";
    public static final String TAB_NAME_SPLIT_STRING = "  |  ";

    public static Rect computeViewArea(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        if (rect.height() != height) {
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds200);
            int i2 = rect.top;
            if (i2 < dimensionPixelOffset) {
                rect.top = rect.bottom - height;
            } else {
                rect.bottom = i2 + height;
            }
        }
        return rect;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (!t.b(i3, textView.getPaint(), spannableStringBuilder.toString(), i2)) {
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return false;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.abstract_expand_flag));
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, spannableStringBuilder3.length(), 17);
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
        dealText(textView, spannableStringBuilder, spannableStringBuilder2, i2, i3);
        return true;
    }

    public static boolean cutAndSetTextByMaxLineForDot(TextView textView, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (!t.b(i3, textView.getPaint(), spannableStringBuilder.toString(), i2)) {
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return false;
        }
        dealText(textView, spannableStringBuilder, new SpannableStringBuilder(StringHelper.STRING_MORE), i2, i3);
        return true;
    }

    public static void dealMainViewTopMargin(View view, boolean z, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            }
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
        }
    }

    public static void dealText(TextView textView, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, int i2, int i3) {
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textView.getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        float f2 = i3;
        if (staticLayout.getLineCount() >= i2) {
            int i4 = i2 - 1;
            spannableStringBuilder.delete(staticLayout.getLineEnd(i4), spannableStringBuilder.length());
            f2 -= staticLayout.getLineWidth(i4);
        }
        int i5 = 2;
        CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
        float measureText = textView.getPaint().measureText(spannableStringBuilder2.toString());
        while (measureText > textView.getPaint().measureText(subSequence.toString()) + f2) {
            i5++;
            if (spannableStringBuilder.length() - i5 < 0) {
                break;
            }
            subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i5, spannableStringBuilder.length());
        }
        if (spannableStringBuilder.length() - i5 > 0) {
            spannableStringBuilder.replace(spannableStringBuilder.length() - i5, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
        }
        textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public static boolean isNoThreadAbstract(a2 a2Var) {
        return a2Var == null || a2Var.D() == null || k.isEmptyStringAfterTrim(a2Var.D().toString());
    }

    public static boolean isNoThreadTitle(a2 a2Var) {
        return a2Var == null || a2Var.v0() == 1 || a2Var.B1() == null || k.isEmptyStringAfterTrim(a2Var.B1().toString());
    }

    public static boolean isNoThreadVoice(a2 a2Var) {
        return a2Var == null || ListUtils.getCount(a2Var.K1()) <= 0;
    }

    public static boolean isPreloadType(a2 a2Var) {
        if (a2Var != null && !a2Var.u1 && a2Var.u2 == null && a2Var.w2 == null) {
            int i2 = a2Var.Z;
            return i2 == 0 || i2 == 11 || i2 == 40 || a2Var.C2();
        }
        return false;
    }

    public static boolean isSelf(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || StringUtils.isNull(a2Var.T().getUserId()) || !a2Var.T().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    public static boolean isTargetUser(a2 a2Var, String str) {
        return (a2Var == null || a2Var.T() == null || StringUtils.isNull(a2Var.T().getUserId()) || StringUtils.isNull(str) || !a2Var.T().getUserId().equals(str)) ? false : true;
    }

    public static boolean isUgcThreadType(BaijiahaoData baijiahaoData) {
        if (baijiahaoData == null) {
            return false;
        }
        int i2 = baijiahaoData.oriUgcType;
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2, boolean z3, Rect rect, boolean z4) {
        if (aVar == null || aVar.i() == null || context == null) {
            return;
        }
        a2 i3 = aVar.i();
        if (i3.getType() == a2.C3) {
            BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
            return;
        }
        String g2 = m.g();
        if (i2 == 3) {
            g2 = m.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(i3.c0())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(i3, null, g2, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(i3.c0()));
        if (i2 == 3) {
            createFromThreadCfg.setFrom("from_frs");
        } else {
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        }
        createFromThreadCfg.setForumName(i3.i0());
        createFromThreadCfg.setStartFrom(i2);
        if (aVar.g() != null) {
            createFromThreadCfg.addLocateParam(aVar.g());
        }
        if (i2 == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i2 == 2) {
            createFromThreadCfg.setVideo_source("index");
            k1 k1Var = new k1();
            k1Var.b(i3);
            createFromThreadCfg.setRecomData(k1Var);
        }
        createFromThreadCfg.setJumpGodReply(z);
        if (!z) {
            createFromThreadCfg.setJumpToCommentArea(z2);
        }
        createFromThreadCfg.setFromHomePageQuality(z3);
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && isPreloadType(i3) && !z2 && !z4) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(i3);
        }
        createFromThreadCfg.setThreadData(i3);
        createFromThreadCfg.setVideoOriginArea(rect);
        createFromThreadCfg.setIsPrivacy(i3.e2);
        m.a(i3.z1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void jumpToPBCommentArea(a aVar, Context context, int i2, int i3) {
        if (aVar == null || context == null || aVar.i() == null) {
            return;
        }
        a2 i4 = aVar.i();
        String g2 = m.g();
        if (i2 == 3) {
            g2 = m.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(i4.c0())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(i4, null, g2, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(i4.c0()));
        createFromThreadCfg.setForumName(i4.i0());
        createFromThreadCfg.setJumpToCommentArea(true);
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setSortType(i3);
        if (i2 == 3) {
            createFromThreadCfg.setFrom("from_frs");
        } else {
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        }
        if (aVar.g() != null) {
            createFromThreadCfg.addLocateParam(aVar.g());
        }
        if (i2 == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i2 == 2) {
            createFromThreadCfg.setVideo_source("index");
            k1 k1Var = new k1();
            k1Var.b(i4);
            createFromThreadCfg.setRecomData(k1Var);
        }
        if (i4.S1) {
            createFromThreadCfg.setFromHomePageQuality(true);
        }
        if (i4.h2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        m.a(i4.z1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, a2 a2Var, int i2) {
        setAbstract(textView, textView2, a2Var, i2, false);
    }

    public static void setOfficialPrefix(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return;
        }
        spannableStringBuilder.insert(0, "官方");
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i2 = R.color.CAM_X0306;
        int i3 = R.color.CAM_X0101;
        int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        int g6 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        b bVar = new b(g2, -1, i2, g4, i3, g5, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.b(g3);
        bVar.i(g6);
        bVar.f(true);
        bVar.g(true);
        bVar.d(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        spannableStringBuilder.setSpan(bVar, 0, 2, 17);
    }

    public static void setTitle(TextView textView, a2 a2Var) {
        setTitle(textView, a2Var, 0, false);
    }

    public static void setWorksPrefix(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.works);
        spannableStringBuilder.insert(0, (CharSequence) string);
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i2 = R.color.CAM_X0319;
        int i3 = R.color.CAM_X0101;
        int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        int g6 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        b bVar = new b(g2, -1, i2, g4, i3, g5, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.b(g3);
        bVar.i(g6);
        bVar.f(true);
        bVar.g(true);
        bVar.d(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        if (WorkIntroSwitch.isOn()) {
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.tbadk.core.util.ThreadCardUtils.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) ((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.URL_WORKS_INFO}, true);
                    }
                }
            }, 0, string.length(), 33);
        }
        spannableStringBuilder.setSpan(bVar, 0, string.length(), 33);
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, a2 a2Var, String str) {
        startImageViewer(view, z, list, i2, a2Var, str, false);
    }

    public static void setAbstract(TextView textView, TextView textView2, a2 a2Var, int i2, boolean z) {
        if (a2Var != null) {
            a2Var.j4(false);
            SpannableStringBuilder spannableStringBuilder = a2Var.D() != null ? new SpannableStringBuilder(a2Var.D()) : null;
            if (a2Var.o1() > 0 && !k.isEmpty(a2Var.p1()) && isNoThreadTitle(a2Var) && (spannableStringBuilder == null || k.isEmptyStringAfterTrim(spannableStringBuilder.toString()))) {
                spannableStringBuilder = (!a2Var.u1 || a2Var.t1 == null) ? a2Var.F2() ? new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract)) : new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract)) : new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
            }
            if (spannableStringBuilder != null && !k.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                if (z && a2Var.o1() > 0 && !k.isEmpty(a2Var.p1()) && isNoThreadTitle(a2Var)) {
                    spannableStringBuilder.insert(0, (CharSequence) a2Var.p1());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, a2Var.p1().length(), 33);
                    spannableStringBuilder.insert(a2Var.p1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), a2Var.p1().length(), a2Var.p1().length() + 5, 33);
                }
                if (isNoThreadTitle(a2Var) && a2Var.Z1()) {
                    setOfficialPrefix(spannableStringBuilder);
                } else if (isNoThreadTitle(a2Var) && a2Var.Y1()) {
                    setWorksPrefix(spannableStringBuilder);
                }
                textView.setOnTouchListener(new i(spannableStringBuilder));
                textView.setVisibility(0);
                int a2 = textView2.getVisibility() != 8 ? 5 - t.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                if (textView2.getVisibility() != 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, d.a.c.e.p.l.g(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                a2Var.j4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a2, i2));
            } else {
                textView.setVisibility(8);
            }
            m.l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }

    public static void setTitle(TextView textView, a2 a2Var, boolean z) {
        setTitle(textView, a2Var, 0, z);
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, a2 a2Var, String str, boolean z2) {
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            d.a.c.e.p.l.L(context, R.string.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.threadId = d.a.c.e.m.b.f(a2Var.z1(), -1L);
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
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i2);
        bVar.z(a2Var.i0());
        bVar.y(String.valueOf(a2Var.c0()));
        bVar.O(a2Var.z1());
        bVar.C(z);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(a2Var);
        bVar.E(z2);
        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(context);
        if (str != null) {
            v.getIntent().putExtra("from", str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        if (context instanceof TbPageContextSupport) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
            historyMessage.threadId = a2Var.o0();
            historyMessage.threadName = a2Var.A1();
            historyMessage.forumName = a2Var.i0();
            historyMessage.postID = a2Var.f0();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public static void setTitle(TextView textView, a2 a2Var, int i2, boolean z) {
        if (textView == null || a2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = a2Var.B1() != null ? new SpannableStringBuilder(a2Var.B1()) : null;
        if (isNoThreadTitle(a2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && a2Var.o1() > 0 && !k.isEmpty(a2Var.p1())) {
                spannableStringBuilder.insert(0, (CharSequence) a2Var.p1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, a2Var.p1().length(), 33);
                spannableStringBuilder.insert(a2Var.p1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), a2Var.p1().length(), a2Var.p1().length() + 5, 33);
            }
            if (a2Var.Z1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (a2Var.Y1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new i(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLine(textView, spannableStringBuilder, 5, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            m.l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i2, int i3, int i4, int i5, boolean z) {
        return cutAndSetTextByMaxLine(textView, str, i2, i3, i4, i5, z, true);
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        if (textView == null || StringUtils.isNull(str)) {
            return false;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
        spannableStringBuilder2.setSpan(new d.a.n0.r.f0.o.b(d.a.c.e.p.l.g(textView.getContext(), i3)), 0, spannableStringBuilder2.length(), 17);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i2));
        if (z) {
            spannableStringBuilder3.setSpan(new f(2, null), 0, spannableStringBuilder3.length(), 33);
        }
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
        spannableStringBuilder4.setSpan(new d.a.n0.r.f0.o.b(d.a.c.e.p.l.g(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(str);
        spannableStringBuilder5.append((CharSequence) spannableStringBuilder2);
        if (z2) {
            spannableStringBuilder5.append((CharSequence) spannableStringBuilder3);
        }
        spannableStringBuilder5.append((CharSequence) spannableStringBuilder4);
        if (new StaticLayout(spannableStringBuilder5, textView.getPaint(), i5, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= i4) {
            textView.setText(spannableStringBuilder5, TextView.BufferType.SPANNABLE);
            return false;
        }
        SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(StringHelper.STRING_MORE);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder2);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder3);
        spannableStringBuilder6.append((CharSequence) spannableStringBuilder4);
        dealText(textView, spannableStringBuilder, spannableStringBuilder6, i4, i5);
        return true;
    }

    public static void setTitle(TextView textView, a2 a2Var, int i2, int i3, boolean z) {
        if (textView == null || a2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = a2Var.B1() != null ? new SpannableStringBuilder(a2Var.B1()) : null;
        if (isNoThreadTitle(a2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && a2Var.o1() > 0 && !k.isEmpty(a2Var.p1())) {
                spannableStringBuilder.insert(0, (CharSequence) a2Var.p1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, a2Var.p1().length(), 33);
                spannableStringBuilder.insert(a2Var.p1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), a2Var.p1().length(), a2Var.p1().length() + 5, 33);
            }
            if (a2Var.Z1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (a2Var.Y1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new i(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLineForDot(textView, spannableStringBuilder, i3, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            m.l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect) {
        jumpToPB(originalThreadInfo, context, i2, rect, (String) null);
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2) {
        jumpToPB(originalThreadInfo, context, i2, (Rect) null);
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect, String str) {
        if (originalThreadInfo == null || context == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.f12182f, originalThreadInfo.n, null);
        createNormalCfg.setForumId(String.valueOf(originalThreadInfo.f12181e));
        if (i2 == 3) {
            createNormalCfg.setFrom("from_frs");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.f12181e)));
        } else {
            createNormalCfg.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        }
        if (TextUtils.isEmpty(str)) {
            createNormalCfg.setForumName(originalThreadInfo.f12180d);
        } else {
            createNormalCfg.setForumName(str);
        }
        createNormalCfg.setStartFrom(i2);
        createNormalCfg.setVideoOriginArea(rect);
        if (i2 == 3) {
            createNormalCfg.setVideo_source("frs");
        } else if (i2 == 2) {
            createNormalCfg.setVideo_source("index");
        }
        createNormalCfg.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, SpannableString spannableString, a2 a2Var, int i2, boolean z, boolean z2) {
        if (a2Var != null) {
            a2Var.j4(false);
            if (spannableString != null && !k.isEmptyStringAfterTrim(spannableString.toString())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                textView.setVisibility(0);
                if (z2 && !z && a2Var.o1() > 0 && !k.isEmpty(a2Var.p1()) && isNoThreadTitle(a2Var)) {
                    spannableStringBuilder.insert(0, (CharSequence) a2Var.p1());
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, a2Var.p1().length(), 33);
                    spannableStringBuilder.insert(a2Var.p1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), a2Var.p1().length(), a2Var.p1().length() + 5, 33);
                }
                textView.setOnTouchListener(new i(spannableStringBuilder));
                int a2 = textView2.getVisibility() != 8 ? 5 - t.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                if (textView2.getVisibility() != 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(0, d.a.c.e.p.l.g(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                    textView.setLayoutParams(layoutParams2);
                }
                a2Var.j4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a2, i2));
            } else {
                textView.setVisibility(8);
            }
            if (!z) {
                m.l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            } else if (textView instanceof TextView) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                return;
            } else {
                return;
            }
        }
        textView.setVisibility(8);
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z) {
        jumpToPB(aVar, context, i2, z, false, false, null, false);
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, Rect rect) {
        jumpToPB(aVar, context, i2, z, false, false, rect, false);
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2) {
        jumpToPB(aVar, context, i2, z, false, false, null, z2);
    }

    public static void setAbstract(TextView textView, SpannableString spannableString, a2 a2Var, float f2) {
        if (textView == null) {
            return;
        }
        if (a2Var != null && spannableString != null && !k.isEmptyStringAfterTrim(spannableString.toString())) {
            textView.setVisibility(0);
            a2Var.j4(false);
            textView.setOnTouchListener(new i(spannableString));
            a2Var.j4(cutAndSetTextByMaxLine(textView, new SpannableStringBuilder(spannableString), 5, (int) f2));
            m.l(textView, a2Var.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }
}
