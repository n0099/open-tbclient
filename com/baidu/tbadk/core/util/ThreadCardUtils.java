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
import c.a.e.e.p.k;
import c.a.e.e.p.t;
import c.a.q0.b.d;
import c.a.q0.d1.u;
import c.a.q0.f1.m.e;
import c.a.q0.s.f0.b;
import c.a.q0.s.q.a;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.n1;
import c.a.q0.s.u.c;
import c.a.r0.a0.m;
import c.a.r0.b4.h;
import c.a.r0.w0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                int i2 = rect.top;
                if (i2 < dimensionPixelOffset) {
                    rect.top = rect.bottom - height;
                } else {
                    rect.bottom = i2 + height;
                }
            }
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, textView, spannableStringBuilder, i2, i3)) == null) {
            if (!t.c(i3, textView.getPaint(), spannableStringBuilder.toString(), i2, 5)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("...");
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.abstract_expand_flag));
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, spannableStringBuilder3.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            dealText(textView, spannableStringBuilder, spannableStringBuilder2, i2, i3);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLineForDot(TextView textView, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(AdIconUtil.AD_TEXT_ID, null, textView, spannableStringBuilder, i2, i3)) == null) {
            if (!t.b(i3, textView.getPaint(), spannableStringBuilder.toString(), i2)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            dealText(textView, spannableStringBuilder, new SpannableStringBuilder("..."), i2, i3);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public static void dealMainViewTopMargin(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{textView, spannableStringBuilder, spannableStringBuilder2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
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
                spannableStringBuilder.replace(spannableStringBuilder.length() - i5, spannableStringBuilder.length(), "");
                while (spannableStringBuilder.length() > 0 && Character.isHighSurrogate(spannableStringBuilder.charAt(spannableStringBuilder.length() - 1))) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), "");
                }
            }
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    public static void gotoNainiPage(Context context, int i2, d2 d2Var, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65544, null, context, i2, d2Var, rect) == null) || d2Var == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        String str = i2 == 3 ? "frs" : i2 == 2 ? "index" : "";
        videoItemData.buildWithThreadData(d2Var);
        arrayList.add(videoItemData);
        u.d(context, arrayList, d2Var.L() != null ? d2Var.L().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, rect, "from_nani_video", "personalize_page", "", str, str, false);
    }

    public static boolean isNoThreadAbstract(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, d2Var)) == null) ? d2Var == null || d2Var.p() == null || k.isEmptyStringAfterTrim(d2Var.p().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadTitle(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, d2Var)) == null) ? d2Var == null || d2Var.n0() == 1 || d2Var.u1() == null || k.isEmptyStringAfterTrim(d2Var.u1().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadVoice(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, d2Var)) == null) ? d2Var == null || ListUtils.getCount(d2Var.D1()) <= 0 : invokeL.booleanValue;
    }

    public static boolean isPreloadType(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, d2Var)) == null) {
            if (d2Var != null && !d2Var.y1 && d2Var.y2 == null && d2Var.A2 == null) {
                int i2 = d2Var.c0;
                return i2 == 0 || i2 == 11 || i2 == 40 || d2Var.D2();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSelf(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, d2Var)) == null) ? (d2Var == null || d2Var.J() == null || StringUtils.isNull(d2Var.J().getUserId()) || !d2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static boolean isTargetUser(d2 d2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, d2Var, str)) == null) ? (d2Var == null || d2Var.J() == null || StringUtils.isNull(d2Var.J().getUserId()) || StringUtils.isNull(str) || !d2Var.J().getUserId().equals(str)) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isUgcThreadType(BaijiahaoData baijiahaoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, baijiahaoData)) == null) {
            if (baijiahaoData == null) {
                return false;
            }
            int i2 = baijiahaoData.oriUgcType;
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }
        return invokeL.booleanValue;
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2, boolean z3, Rect rect, boolean z4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), rect, Boolean.valueOf(z4)}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        if (threadData.getType() == d2.P3) {
            BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (threadData.q1() != null && !TextUtils.isEmpty(threadData.q1().video_url)) {
            gotoNainiPage(context, i2, threadData, rect);
        } else {
            String g2 = m.g();
            if (i2 == 3) {
                g2 = m.f();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.T())));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
            if (i2 == 3) {
                createFromThreadCfg.setFrom("from_frs");
            } else {
                createFromThreadCfg.setFrom("from_personalize");
            }
            createFromThreadCfg.setForumName(threadData.Z());
            createFromThreadCfg.setStartFrom(i2);
            if (aVar.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
            }
            if (i2 == 3) {
                createFromThreadCfg.setVideo_source("frs");
            } else if (i2 == 2) {
                createFromThreadCfg.setVideo_source("index");
                n1 n1Var = new n1();
                n1Var.b(threadData);
                createFromThreadCfg.setRecomData(n1Var);
            }
            createFromThreadCfg.setJumpGodReply(z);
            if (!z) {
                createFromThreadCfg.setJumpToCommentArea(z2);
            }
            createFromThreadCfg.setFromHomePageQuality(z3);
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && isPreloadType(threadData) && !z2 && !z4) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.c(threadData);
            }
            createFromThreadCfg.setThreadData(threadData);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(threadData.i2);
            m.a(threadData.s1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void jumpToPBCommentArea(a aVar, Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65559, null, aVar, context, i2, i3) == null) || aVar == null || context == null || aVar.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        String g2 = m.g();
        if (i2 == 3) {
            g2 = m.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.T())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.T()));
        createFromThreadCfg.setForumName(threadData.Z());
        createFromThreadCfg.setJumpToCommentArea(true);
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setSortType(i3);
        if (i2 == 3) {
            createFromThreadCfg.setFrom("from_frs");
        } else {
            createFromThreadCfg.setFrom("from_personalize");
        }
        if (aVar.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(aVar.getPbInputLocate());
        }
        if (i2 == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i2 == 2) {
            createFromThreadCfg.setVideo_source("index");
            n1 n1Var = new n1();
            n1Var.b(threadData);
            createFromThreadCfg.setRecomData(n1Var);
        }
        if (threadData.W1) {
            createFromThreadCfg.setFromHomePageQuality(true);
        }
        if (threadData.d2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        m.a(threadData.s1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65562, null, textView, textView2, d2Var, i2) == null) {
            setAbstract(textView, textView2, d2Var, i2, false);
        }
    }

    public static void setAbstractStyleAb(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, textView) == null) && textView != null && d.m()) {
            c.d(textView).A(R.dimen.T_X05);
        }
    }

    public static void setOfficialPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65565, null, spannableStringBuilder) == null) || spannableStringBuilder == null) {
            return;
        }
        spannableStringBuilder.insert(0, "官方");
        int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i2 = R.color.CAM_X0306;
        int i3 = R.color.CAM_X0101;
        int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int g5 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        int g6 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        b bVar = new b(g2, -1, i2, g4, i3, g5, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.b(g3);
        bVar.i(g6);
        bVar.f(true);
        bVar.g(true);
        bVar.d(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        spannableStringBuilder.setSpan(bVar, 0, 2, 17);
    }

    public static void setTitle(TextView textView, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, textView, d2Var) == null) {
            setTitle(textView, d2Var, 0, false);
        }
    }

    public static void setTitleStyleAb(TextView textView, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65570, null, textView, d2Var) == null) || textView == null) {
            return;
        }
        setAbstractStyleAb(textView);
        int i2 = d2Var.c0;
        if (d.m()) {
            if (i2 != 40) {
                c.d(textView).B(R.string.F_X02);
            } else {
                c.d(textView).B(R.string.F_X01);
            }
        }
    }

    @Deprecated
    public static void setWorksPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, spannableStringBuilder) == null) {
        }
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, d2 d2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i2), d2Var, str}) == null) {
            startImageViewer(view, z, list, i2, d2Var, str, false);
        }
    }

    public static void setAbstract(TextView textView, TextView textView2, d2 d2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{textView, textView2, d2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (d2Var != null && textView2 != null) {
                d2Var.t4(false);
                SpannableStringBuilder spannableStringBuilder = null;
                if (d2Var.p() != null) {
                    spannableStringBuilder = new SpannableStringBuilder(d2Var.p());
                    TiePlusEventController.tryExposeTiePlusLinkEvent(d2Var.t1());
                }
                if (d2Var.h1() > 0 && !k.isEmpty(d2Var.i1()) && isNoThreadTitle(d2Var) && (spannableStringBuilder == null || k.isEmptyStringAfterTrim(spannableStringBuilder.toString()))) {
                    if (d2Var.y1 && d2Var.x1 != null) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
                    } else if (d2Var.G2()) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract));
                    }
                }
                if (spannableStringBuilder != null && !k.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                    textView2.setVisibility(textView2.getVisibility());
                    if (z && d2Var.h1() > 0 && !k.isEmpty(d2Var.i1()) && isNoThreadTitle(d2Var)) {
                        spannableStringBuilder.insert(0, (CharSequence) d2Var.i1());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, d2Var.i1().length(), 33);
                        spannableStringBuilder.insert(d2Var.i1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), d2Var.i1().length(), d2Var.i1().length() + 5, 33);
                    }
                    if (isNoThreadTitle(d2Var) && d2Var.V1()) {
                        setOfficialPrefix(spannableStringBuilder);
                    } else if (isNoThreadTitle(d2Var) && d2Var.U1()) {
                        setWorksPrefix(spannableStringBuilder);
                    }
                    setAbstractStyleAb(textView);
                    textView.setOnTouchListener(new h(spannableStringBuilder));
                    textView.setVisibility(0);
                    int a2 = textView2.getVisibility() != 8 ? 5 - t.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, c.a.e.e.p.l.g(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    d2Var.t4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a2, i2));
                } else {
                    textView.setVisibility(8);
                }
                m.l(textView, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void setTitle(TextView textView, d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65569, null, textView, d2Var, z) == null) {
            setTitle(textView, d2Var, 0, z);
        }
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, d2 d2Var, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i2), d2Var, str, Boolean.valueOf(z2)}) == null) || view == null) {
            return;
        }
        Context context = view.getContext();
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            c.a.e.e.p.l.L(context, R.string.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.threadId = c.a.e.e.m.b.g(d2Var.s1(), -1L);
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
        bVar.z(d2Var.Z());
        bVar.y(String.valueOf(d2Var.T()));
        bVar.O(d2Var.s1());
        bVar.C(z);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(d2Var);
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
            historyMessage.threadId = d2Var.f0();
            historyMessage.threadName = d2Var.getTitle();
            historyMessage.forumName = d2Var.Z();
            historyMessage.postID = d2Var.W();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public static void setTitle(TextView textView, d2 d2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{textView, d2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || textView == null || d2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = d2Var.u1() != null ? new SpannableStringBuilder(d2Var.u1()) : null;
        if (isNoThreadTitle(d2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && d2Var.h1() > 0 && !k.isEmpty(d2Var.i1())) {
                spannableStringBuilder.insert(0, (CharSequence) d2Var.i1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, d2Var.i1().length(), 33);
                spannableStringBuilder.insert(d2Var.i1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), d2Var.i1().length(), d2Var.i1().length() + 5, 33);
            }
            setTitleStyleAb(textView, d2Var);
            if (d2Var.V1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (d2Var.U1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new h(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLine(textView, spannableStringBuilder, 5, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            m.l(textView, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{textView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) ? cutAndSetTextByMaxLine(textView, str, i2, i3, i4, i5, z, true) : invokeCommon.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{textView, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (textView == null || StringUtils.isNull(str)) {
                return false;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
            spannableStringBuilder2.setSpan(new c.a.q0.s.f0.r.b(c.a.e.e.p.l.g(textView.getContext(), i3)), 0, spannableStringBuilder2.length(), 17);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i2));
            if (z) {
                spannableStringBuilder3.setSpan(new e(2, null), 0, spannableStringBuilder3.length(), 33);
            }
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
            spannableStringBuilder4.setSpan(new c.a.q0.s.f0.r.b(c.a.e.e.p.l.g(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
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
            SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder("...");
            spannableStringBuilder6.append((CharSequence) spannableStringBuilder2);
            spannableStringBuilder6.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder6.append((CharSequence) spannableStringBuilder4);
            dealText(textView, spannableStringBuilder, spannableStringBuilder6, i4, i5);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void setTitle(TextView textView, d2 d2Var, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{textView, d2Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || textView == null || d2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = d2Var.u1() != null ? new SpannableStringBuilder(d2Var.u1()) : null;
        if (isNoThreadTitle(d2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && d2Var.h1() > 0 && !k.isEmpty(d2Var.i1())) {
                spannableStringBuilder.insert(0, (CharSequence) d2Var.i1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, d2Var.i1().length(), 33);
                spannableStringBuilder.insert(d2Var.i1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), d2Var.i1().length(), d2Var.i1().length() + 5, 33);
            }
            setTitleStyleAb(textView, d2Var);
            if (d2Var.V1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (d2Var.U1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new h(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLineForDot(textView, spannableStringBuilder, i3, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            m.l(textView, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65557, null, originalThreadInfo, context, i2, rect) == null) {
            jumpToPB(originalThreadInfo, context, i2, rect, (String) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65556, null, originalThreadInfo, context, i2) == null) {
            jumpToPB(originalThreadInfo, context, i2, (Rect) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{originalThreadInfo, context, Integer.valueOf(i2), rect, str}) == null) || originalThreadInfo == null || context == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.f47422f, originalThreadInfo.n, null);
        createNormalCfg.setForumId(String.valueOf(originalThreadInfo.f47421e));
        if (i2 == 3) {
            createNormalCfg.setFrom("from_frs");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.f47421e)));
        } else {
            createNormalCfg.setFrom("from_personalize");
        }
        if (TextUtils.isEmpty(str)) {
            createNormalCfg.setForumName(originalThreadInfo.f47420d);
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

    public static void setAbstract(TextView textView, TextView textView2, SpannableString spannableString, d2 d2Var, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{textView, textView2, spannableString, d2Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (d2Var != null) {
                d2Var.t4(false);
                if (spannableString != null && !k.isEmptyStringAfterTrim(spannableString.toString())) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                    textView.setVisibility(0);
                    if (z2 && !z && d2Var.h1() > 0 && !k.isEmpty(d2Var.i1()) && isNoThreadTitle(d2Var)) {
                        spannableStringBuilder.insert(0, (CharSequence) d2Var.i1());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, d2Var.i1().length(), 33);
                        spannableStringBuilder.insert(d2Var.i1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), d2Var.i1().length(), d2Var.i1().length() + 5, 33);
                    }
                    textView.setOnTouchListener(new h(spannableStringBuilder));
                    setAbstractStyleAb(textView);
                    int a2 = textView2.getVisibility() != 8 ? 5 - t.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, c.a.e.e.p.l.g(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    d2Var.t4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a2, i2));
                } else {
                    textView.setVisibility(8);
                }
                if (!z) {
                    m.l(textView, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
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
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, null, false);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, rect, false);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, null, z2);
        }
    }

    public static void setAbstract(TextView textView, SpannableString spannableString, d2 d2Var, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{textView, spannableString, d2Var, Float.valueOf(f2)}) == null) || textView == null) {
            return;
        }
        if (d2Var != null && spannableString != null && !k.isEmptyStringAfterTrim(spannableString.toString())) {
            textView.setVisibility(0);
            d2Var.t4(false);
            textView.setOnTouchListener(new h(spannableString));
            d2Var.t4(cutAndSetTextByMaxLine(textView, new SpannableStringBuilder(spannableString), 5, (int) f2));
            m.l(textView, d2Var.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }
}
