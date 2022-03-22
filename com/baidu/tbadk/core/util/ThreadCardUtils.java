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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.d.f.p.w;
import c.a.o0.c1.x;
import c.a.o0.e1.n.f;
import c.a.o0.r.l0.b;
import c.a.o0.r.r.a;
import c.a.o0.r.r.k1;
import c.a.o0.r.v.c;
import c.a.p0.f1.l;
import c.a.p0.q4.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class ThreadCardUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String REAL_TIME_PIC_TYPE = "1";
    public static final String REAL_TIME_VIDEO_TYPE = "3";
    public static final String REAL_TIME_VOICE_TYPE = "2";
    public static final String TAB_NAME_SPLIT_STRING = "  |  ";
    public transient /* synthetic */ FieldHolder $fh;

    public ThreadCardUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Rect computeViewArea(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view == null) {
                return null;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int height = view.getHeight();
            if (rect.height() != height) {
                int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds200);
                int i = rect.top;
                if (i < dimensionPixelOffset) {
                    rect.top = rect.bottom - height;
                } else {
                    rect.bottom = i + height;
                }
            }
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, textView, spannableStringBuilder, i, i2)) == null) {
            if (!w.c(i2, textView.getPaint(), spannableStringBuilder.toString(), i, 5)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0054));
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, spannableStringBuilder3.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            dealText(textView, spannableStringBuilder, spannableStringBuilder2, i, i2);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLineForDot(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, textView, spannableStringBuilder, i, i2)) == null) {
            if (!w.b(i2, textView.getPaint(), spannableStringBuilder.toString(), i)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            dealText(textView, spannableStringBuilder, new SpannableStringBuilder(StringHelper.STRING_MORE), i, i2);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public static void dealMainViewTopMargin(View view, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            }
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i;
        }
    }

    public static void dealText(TextView textView, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{textView, spannableStringBuilder, spannableStringBuilder2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textView.getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            float f2 = i2;
            if (staticLayout.getLineCount() >= i) {
                int i3 = i - 1;
                spannableStringBuilder.delete(staticLayout.getLineEnd(i3), spannableStringBuilder.length());
                f2 -= staticLayout.getLineWidth(i3);
            }
            int i4 = 2;
            CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
            float measureText = textView.getPaint().measureText(spannableStringBuilder2.toString());
            while (measureText > textView.getPaint().measureText(subSequence.toString()) + f2) {
                i4++;
                if (spannableStringBuilder.length() - i4 < 0) {
                    break;
                }
                subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i4, spannableStringBuilder.length());
            }
            if (spannableStringBuilder.length() - i4 > 0) {
                spannableStringBuilder.replace(spannableStringBuilder.length() - i4, spannableStringBuilder.length(), "");
                while (spannableStringBuilder.length() > 0 && Character.isHighSurrogate(spannableStringBuilder.charAt(spannableStringBuilder.length() - 1))) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), "");
                }
            }
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    public static void gotoNainiPage(Context context, int i, ThreadData threadData, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65544, null, context, i, threadData, rect) == null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        String str = i == 3 ? "frs" : i == 2 ? "index" : "";
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        x.e(context, arrayList, threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, rect, "from_nani_video", "personalize_page", "", str, str, false, threadData.isJumpToFrsVideoTabPlay, true);
    }

    public static boolean isNoThreadAbstract(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) ? threadData == null || threadData.getAbstractText() == null || m.isEmptyStringAfterTrim(threadData.getAbstractText().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadTitle(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, threadData)) == null) ? threadData == null || threadData.getIsNoTitle() == 1 || threadData.getTitleText() == null || m.isEmptyStringAfterTrim(threadData.getTitleText().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadVoice(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) ? threadData == null || ListUtils.getCount(threadData.getVoice()) <= 0 : invokeL.booleanValue;
    }

    public static boolean isPreloadType(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, threadData)) == null) {
            if (threadData != null && !threadData.isShareThread && threadData.itemData == null && threadData.itemStarData == null) {
                int i = threadData.threadType;
                return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSelf(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || StringUtils.isNull(threadData.getAuthor().getUserId()) || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static boolean isTargetUser(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, threadData, str)) == null) ? (threadData == null || threadData.getAuthor() == null || StringUtils.isNull(threadData.getAuthor().getUserId()) || StringUtils.isNull(str) || !threadData.getAuthor().getUserId().equals(str)) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isUgcThreadType(BaijiahaoData baijiahaoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, baijiahaoData)) == null) {
            if (baijiahaoData == null) {
                return false;
            }
            int i = baijiahaoData.oriUgcType;
            return i == 1 || i == 2 || i == 3 || i == 4;
        }
        return invokeL.booleanValue;
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect, boolean z4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), rect, Boolean.valueOf(z4), str, str2}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = aVar.getThreadData();
        if (threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
            BdToast.i(context, context.getString(R.string.obfuscated_res_0x7f0f14d0), R.drawable.obfuscated_res_0x7f08099f, true).q();
        } else if (threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
            gotoNainiPage(context, i, threadData, rect);
        } else {
            String g2 = c.a.p0.h0.m.g();
            if (i == 3) {
                g2 = c.a.p0.h0.m.f();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.getFid())));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            if (i == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom("from_personalize");
            }
            if (!StringUtils.isNull(str2)) {
                createFromThreadCfg.setHottopicSubjectName(str2);
            }
            if (!StringUtils.isNull(str)) {
                createFromThreadCfg.setHottopicId(str);
            }
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
            }
            if (i == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i == 2) {
                createFromThreadCfg.setVideo_source("index");
                k1 k1Var = new k1();
                k1Var.b(threadData);
                createFromThreadCfg.setRecomData(k1Var);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && isPreloadType(threadData) && !z2 && !z4) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.update(threadData);
            }
            createFromThreadCfg.setThreadData(threadData);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(threadData.isPrivacy);
            c.a.p0.h0.m.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void jumpToPBCommentArea(a aVar, Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65561, null, aVar, context, i, i2) == null) || aVar == null || context == null || aVar.getThreadData() == null) {
            return;
        }
        ThreadData threadData = aVar.getThreadData();
        String g2 = c.a.p0.h0.m.g();
        if (i == 3) {
            g2 = c.a.p0.h0.m.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.getFid())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setJumpToCommentArea(true);
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setSortType(i2);
        if (i == 3) {
            createFromThreadCfg.setFrom("from_frs");
        } else {
            createFromThreadCfg.setFrom("from_personalize");
        }
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (i == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i == 2) {
            createFromThreadCfg.setVideo_source("index");
            k1 k1Var = new k1();
            k1Var.b(threadData);
            createFromThreadCfg.setRecomData(k1Var);
        }
        if (threadData.isQualityReplyThread) {
            createFromThreadCfg.setFromHomePageQuality(true);
        }
        if (threadData.isInterviewLiveStyle() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        c.a.p0.h0.m.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65564, null, textView, textView2, threadData, i) == null) {
            setAbstract(textView, textView2, threadData, i, false);
        }
    }

    public static void setAbstractStyleAb(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, textView) == null) || textView == null) {
            return;
        }
        c.d(textView).z(R.dimen.T_X05);
    }

    public static void setOfficialPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, spannableStringBuilder) == null) || spannableStringBuilder == null) {
            return;
        }
        spannableStringBuilder.insert(0, "官方");
        int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int f5 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        int f6 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        b bVar = new b(f2, -1, R.color.CAM_X0306, f4, R.color.CAM_X0101, f5, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.b(f3);
        bVar.i(f6);
        bVar.f(true);
        bVar.g(true);
        bVar.d(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        spannableStringBuilder.setSpan(bVar, 0, 2, 17);
    }

    public static void setTitle(TextView textView, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, textView, threadData) == null) {
            setTitle(textView, threadData, 0, false);
        }
    }

    public static void setTitleStyleAb(TextView textView, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, textView, threadData) == null) || textView == null) {
            return;
        }
        setAbstractStyleAb(textView);
        if (threadData.threadType != 40) {
            c.d(textView).A(R.string.F_X02);
        } else {
            c.d(textView).A(R.string.F_X01);
        }
    }

    @Deprecated
    public static void setWorksPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, spannableStringBuilder) == null) {
        }
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i, ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i), threadData, str}) == null) {
            startImageViewer(view, z, list, i, threadData, str, false);
        }
    }

    public static void setAbstract(TextView textView, TextView textView2, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{textView, textView2, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (threadData != null && textView2 != null) {
                threadData.setShowFullThread(false);
                SpannableStringBuilder spannableStringBuilder = null;
                if (threadData.getAbstractText() != null) {
                    spannableStringBuilder = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.h(threadData.getTiePlusLinkOriginData());
                }
                if (threadData.getTabId() > 0 && !m.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData) && (spannableStringBuilder == null || m.isEmptyStringAfterTrim(spannableStringBuilder.toString()))) {
                    if (threadData.isShareThread && threadData.originalThreadData != null) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f113b));
                    } else if (threadData.isVoiceThreadType()) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f152d));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1392));
                    }
                }
                if (spannableStringBuilder != null && !m.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                    textView2.setVisibility(textView2.getVisibility());
                    if (z && threadData.getTabId() > 0 && !m.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData)) {
                        spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                        spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
                    }
                    if (isNoThreadTitle(threadData) && threadData.isDisplayOffcialPrefix()) {
                        setOfficialPrefix(spannableStringBuilder);
                    } else if (isNoThreadTitle(threadData) && threadData.isDisplayHighQualityPrefix()) {
                        setWorksPrefix(spannableStringBuilder);
                    }
                    setAbstractStyleAb(textView);
                    textView.setOnTouchListener(new i(spannableStringBuilder));
                    textView.setVisibility(0);
                    int a = textView2.getVisibility() != 8 ? 5 - w.a(i, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, n.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a, i));
                } else {
                    textView.setVisibility(8);
                }
                c.a.p0.h0.m.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void setTitle(TextView textView, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65571, null, textView, threadData, z) == null) {
            setTitle(textView, threadData, 0, z);
        }
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i, ThreadData threadData, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i), threadData, str, Boolean.valueOf(z2)}) == null) || view == null) {
            return;
        }
        Context context = view.getContext();
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            n.M(context, R.string.obfuscated_res_0x7f0f0e63);
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
                    imageUrlData.threadId = c.a.d.f.m.b.g(threadData.getTid(), -1L);
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
        bVar.B(i);
        bVar.z(threadData.getForum_name());
        bVar.y(String.valueOf(threadData.getFid()));
        bVar.O(threadData.getTid());
        bVar.C(z);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(threadData);
        bVar.E(z2);
        bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig v = bVar.v(context);
        if (str != null) {
            v.getIntent().putExtra("from", str);
        }
        BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE_FROM, "image", "tran");
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        if (context instanceof TbPageContextSupport) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = ((TbPageContextSupport) context).getPageContext();
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public static void setTitle(TextView textView, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{textView, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || textView == null || threadData == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = threadData.getTitleText() != null ? new SpannableStringBuilder(threadData.getTitleText()) : null;
        if (isNoThreadTitle(threadData)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && threadData.getTabId() > 0 && !m.isEmpty(threadData.getTabName())) {
                spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
            }
            setTitleStyleAb(textView, threadData);
            if (threadData.isDisplayOffcialPrefix()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (threadData.isDisplayHighQualityPrefix()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new i(spannableStringBuilder));
            if (i > 0) {
                cutAndSetTextByMaxLine(textView, spannableStringBuilder, 5, i);
            } else {
                textView.setText(spannableStringBuilder);
            }
            c.a.p0.h0.m.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{textView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) ? cutAndSetTextByMaxLine(textView, str, i, i2, i3, i4, z, true) : invokeCommon.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{textView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (textView == null || StringUtils.isNull(str)) {
                return false;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
            spannableStringBuilder2.setSpan(new c.a.o0.r.l0.r.b(n.f(textView.getContext(), i2)), 0, spannableStringBuilder2.length(), 17);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i));
            if (z) {
                spannableStringBuilder3.setSpan(new f(2, null), 0, spannableStringBuilder3.length(), 33);
            }
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
            spannableStringBuilder4.setSpan(new c.a.o0.r.l0.r.b(n.f(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
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
            dealText(textView, spannableStringBuilder, spannableStringBuilder6, i3, i4);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void setTitle(TextView textView, ThreadData threadData, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{textView, threadData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || textView == null || threadData == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = threadData.getTitleText() != null ? new SpannableStringBuilder(threadData.getTitleText()) : null;
        if (isNoThreadTitle(threadData)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && threadData.getTabId() > 0 && !m.isEmpty(threadData.getTabName())) {
                spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
            }
            setTitleStyleAb(textView, threadData);
            if (threadData.isDisplayOffcialPrefix()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (threadData.isDisplayHighQualityPrefix()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new i(spannableStringBuilder));
            if (i > 0) {
                cutAndSetTextByMaxLineForDot(textView, spannableStringBuilder, i2, i);
            } else {
                textView.setText(spannableStringBuilder);
            }
            c.a.p0.h0.m.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65559, null, originalThreadInfo, context, i, rect) == null) {
            jumpToPB(originalThreadInfo, context, i, rect, (String) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65558, null, originalThreadInfo, context, i) == null) {
            jumpToPB(originalThreadInfo, context, i, (Rect) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{originalThreadInfo, context, Integer.valueOf(i), rect, str}) == null) || originalThreadInfo == null || context == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.f29826f, originalThreadInfo.n, null);
        createNormalCfg.setForumId(String.valueOf(originalThreadInfo.f29825e));
        if (i == 3) {
            createNormalCfg.setFrom("from_frs");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.f29825e)));
        } else {
            createNormalCfg.setFrom("from_personalize");
        }
        if (TextUtils.isEmpty(str)) {
            createNormalCfg.setForumName(originalThreadInfo.f29824d);
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
        createNormalCfg.setBjhData(originalThreadInfo.p);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, SpannableString spannableString, ThreadData threadData, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{textView, textView2, spannableString, threadData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (threadData != null) {
                threadData.setShowFullThread(false);
                if (spannableString != null && !m.isEmptyStringAfterTrim(spannableString.toString())) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                    textView.setVisibility(0);
                    if (z2 && !z && threadData.getTabId() > 0 && !m.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData)) {
                        spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                        spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
                    }
                    textView.setOnTouchListener(new i(spannableStringBuilder));
                    setAbstractStyleAb(textView);
                    int a = textView2.getVisibility() != 8 ? 5 - w.a(i, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, n.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a, i));
                } else {
                    textView.setVisibility(8);
                }
                if (!z) {
                    c.a.p0.h0.m.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return;
                } else if (textView instanceof TextView) {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                    return;
                } else {
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            jumpToPB(aVar, context, i, z, false, false, null, false, "", "");
        }
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), str, str2}) == null) {
            jumpToPB(aVar, context, i, z, null, str, str2);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z, Rect rect, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), rect, str, str2}) == null) {
            jumpToPB(aVar, context, i, z, false, false, rect, false, str, str2);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) {
            jumpToPB(aVar, context, i, z, false, false, rect, false, "", "");
        }
    }

    public static void jumpToPB(a aVar, Context context, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jumpToPB(aVar, context, i, z, false, false, null, z2, "", "");
        }
    }

    public static void setAbstract(TextView textView, SpannableString spannableString, ThreadData threadData, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{textView, spannableString, threadData, Float.valueOf(f2)}) == null) || textView == null) {
            return;
        }
        if (threadData != null && spannableString != null && !m.isEmptyStringAfterTrim(spannableString.toString())) {
            textView.setVisibility(0);
            threadData.setShowFullThread(false);
            textView.setOnTouchListener(new i(spannableString));
            threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, new SpannableStringBuilder(spannableString), 5, (int) f2));
            c.a.p0.h0.m.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }
}
