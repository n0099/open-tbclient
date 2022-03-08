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
import c.a.q0.c1.x;
import c.a.q0.e1.n.f;
import c.a.q0.r.l0.b;
import c.a.q0.r.r.a;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.n1;
import c.a.q0.r.v.c;
import c.a.r0.d1.l;
import c.a.r0.o4.h;
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
            if (!w.c(i3, textView.getPaint(), spannableStringBuilder.toString(), i2, 5)) {
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
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, textView, spannableStringBuilder, i2, i3)) == null) {
            if (!w.b(i3, textView.getPaint(), spannableStringBuilder.toString(), i2)) {
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
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
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

    public static void gotoNainiPage(Context context, int i2, e2 e2Var, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65544, null, context, i2, e2Var, rect) == null) || e2Var == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        String str = i2 == 3 ? "frs" : i2 == 2 ? "index" : "";
        videoItemData.buildWithThreadData(e2Var);
        arrayList.add(videoItemData);
        x.e(context, arrayList, e2Var.L() != null ? e2Var.L().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, rect, "from_nani_video", "personalize_page", "", str, str, false, e2Var.n, true);
    }

    public static boolean isNoThreadAbstract(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, e2Var)) == null) ? e2Var == null || e2Var.p() == null || m.isEmptyStringAfterTrim(e2Var.p().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadTitle(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, e2Var)) == null) ? e2Var == null || e2Var.p0() == 1 || e2Var.y1() == null || m.isEmptyStringAfterTrim(e2Var.y1().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadVoice(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, e2Var)) == null) ? e2Var == null || ListUtils.getCount(e2Var.G1()) <= 0 : invokeL.booleanValue;
    }

    public static boolean isPreloadType(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, e2Var)) == null) {
            if (e2Var != null && !e2Var.A1 && e2Var.B2 == null && e2Var.D2 == null) {
                int i2 = e2Var.d0;
                return i2 == 0 || i2 == 11 || i2 == 40 || e2Var.H2();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isSelf(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, e2Var)) == null) ? (e2Var == null || e2Var.J() == null || StringUtils.isNull(e2Var.J().getUserId()) || !e2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static boolean isTargetUser(e2 e2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, e2Var, str)) == null) ? (e2Var == null || e2Var.J() == null || StringUtils.isNull(e2Var.J().getUserId()) || StringUtils.isNull(str) || !e2Var.J().getUserId().equals(str)) ? false : true : invokeLL.booleanValue;
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

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2, boolean z3, Rect rect, boolean z4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), rect, Boolean.valueOf(z4), str, str2}) == null) || aVar == null || aVar.getThreadData() == null || context == null) {
            return;
        }
        e2 threadData = aVar.getThreadData();
        if (threadData.getType() == e2.Z3) {
            BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (threadData.u1() != null && !TextUtils.isEmpty(threadData.u1().video_url)) {
            gotoNainiPage(context, i2, threadData, rect);
        } else {
            String g2 = c.a.r0.f0.m.g();
            if (i2 == 3) {
                g2 = c.a.r0.f0.m.f();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.U())));
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.U()));
            if (i2 == 3) {
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
            createFromThreadCfg.setForumName(threadData.b0());
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
                l.update(threadData);
            }
            createFromThreadCfg.setThreadData(threadData);
            createFromThreadCfg.setVideoOriginArea(rect);
            createFromThreadCfg.setIsPrivacy(threadData.l2);
            c.a.r0.f0.m.a(threadData.w1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void jumpToPBCommentArea(a aVar, Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65561, null, aVar, context, i2, i3) == null) || aVar == null || context == null || aVar.getThreadData() == null) {
            return;
        }
        e2 threadData = aVar.getThreadData();
        String g2 = c.a.r0.f0.m.g();
        if (i2 == 3) {
            g2 = c.a.r0.f0.m.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.U())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g2, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.U()));
        createFromThreadCfg.setForumName(threadData.b0());
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
        if (threadData.X1) {
            createFromThreadCfg.setFromHomePageQuality(true);
        }
        if (threadData.h2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        c.a.r0.f0.m.a(threadData.w1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void setAbstract(TextView textView, TextView textView2, e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65564, null, textView, textView2, e2Var, i2) == null) {
            setAbstract(textView, textView2, e2Var, i2, false);
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

    public static void setTitle(TextView textView, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, textView, e2Var) == null) {
            setTitle(textView, e2Var, 0, false);
        }
    }

    public static void setTitleStyleAb(TextView textView, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, textView, e2Var) == null) || textView == null) {
            return;
        }
        setAbstractStyleAb(textView);
        if (e2Var.d0 != 40) {
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

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, e2 e2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i2), e2Var, str}) == null) {
            startImageViewer(view, z, list, i2, e2Var, str, false);
        }
    }

    public static void setAbstract(TextView textView, TextView textView2, e2 e2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{textView, textView2, e2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (e2Var != null && textView2 != null) {
                e2Var.y4(false);
                SpannableStringBuilder spannableStringBuilder = null;
                if (e2Var.p() != null) {
                    spannableStringBuilder = new SpannableStringBuilder(e2Var.p());
                    TiePlusEventController.tryExposeTiePlusLinkEvent(e2Var.x1());
                }
                if (e2Var.k1() > 0 && !m.isEmpty(e2Var.l1()) && isNoThreadTitle(e2Var) && (spannableStringBuilder == null || m.isEmptyStringAfterTrim(spannableStringBuilder.toString()))) {
                    if (e2Var.A1 && e2Var.z1 != null) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.share_thread_default_abstract));
                    } else if (e2Var.L2()) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_thread_default_abstract));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.thread_default_abstract));
                    }
                }
                if (spannableStringBuilder != null && !m.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                    textView2.setVisibility(textView2.getVisibility());
                    if (z && e2Var.k1() > 0 && !m.isEmpty(e2Var.l1()) && isNoThreadTitle(e2Var)) {
                        spannableStringBuilder.insert(0, (CharSequence) e2Var.l1());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, e2Var.l1().length(), 33);
                        spannableStringBuilder.insert(e2Var.l1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), e2Var.l1().length(), e2Var.l1().length() + 5, 33);
                    }
                    if (isNoThreadTitle(e2Var) && e2Var.Z1()) {
                        setOfficialPrefix(spannableStringBuilder);
                    } else if (isNoThreadTitle(e2Var) && e2Var.Y1()) {
                        setWorksPrefix(spannableStringBuilder);
                    }
                    setAbstractStyleAb(textView);
                    textView.setOnTouchListener(new h(spannableStringBuilder));
                    textView.setVisibility(0);
                    int a = textView2.getVisibility() != 8 ? 5 - w.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, n.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    e2Var.y4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a, i2));
                } else {
                    textView.setVisibility(8);
                }
                c.a.r0.f0.m.l(textView, e2Var.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void setTitle(TextView textView, e2 e2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65571, null, textView, e2Var, z) == null) {
            setTitle(textView, e2Var, 0, z);
        }
    }

    public static void startImageViewer(View view, boolean z, List<MediaData> list, int i2, e2 e2Var, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{view, Boolean.valueOf(z), list, Integer.valueOf(i2), e2Var, str, Boolean.valueOf(z2)}) == null) || view == null) {
            return;
        }
        Context context = view.getContext();
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            n.M(context, R.string.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.threadId = c.a.d.f.m.b.g(e2Var.w1(), -1L);
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
        bVar.z(e2Var.b0());
        bVar.y(String.valueOf(e2Var.U()));
        bVar.O(e2Var.w1());
        bVar.C(z);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        bVar.N(e2Var);
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
            historyMessage.threadId = e2Var.h0();
            historyMessage.threadName = e2Var.getTitle();
            historyMessage.forumName = e2Var.b0();
            historyMessage.postID = e2Var.X();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public static void setTitle(TextView textView, e2 e2Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{textView, e2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || textView == null || e2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = e2Var.y1() != null ? new SpannableStringBuilder(e2Var.y1()) : null;
        if (isNoThreadTitle(e2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && e2Var.k1() > 0 && !m.isEmpty(e2Var.l1())) {
                spannableStringBuilder.insert(0, (CharSequence) e2Var.l1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, e2Var.l1().length(), 33);
                spannableStringBuilder.insert(e2Var.l1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), e2Var.l1().length(), e2Var.l1().length() + 5, 33);
            }
            setTitleStyleAb(textView, e2Var);
            if (e2Var.Z1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (e2Var.Y1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new h(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLine(textView, spannableStringBuilder, 5, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            c.a.r0.f0.m.l(textView, e2Var.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
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
            spannableStringBuilder2.setSpan(new c.a.q0.r.l0.r.b(n.f(textView.getContext(), i3)), 0, spannableStringBuilder2.length(), 17);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i2));
            if (z) {
                spannableStringBuilder3.setSpan(new f(2, null), 0, spannableStringBuilder3.length(), 33);
            }
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
            spannableStringBuilder4.setSpan(new c.a.q0.r.l0.r.b(n.f(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
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

    public static void setTitle(TextView textView, e2 e2Var, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{textView, e2Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || textView == null || e2Var == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = e2Var.y1() != null ? new SpannableStringBuilder(e2Var.y1()) : null;
        if (isNoThreadTitle(e2Var)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && e2Var.k1() > 0 && !m.isEmpty(e2Var.l1())) {
                spannableStringBuilder.insert(0, (CharSequence) e2Var.l1());
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, e2Var.l1().length(), 33);
                spannableStringBuilder.insert(e2Var.l1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), e2Var.l1().length(), e2Var.l1().length() + 5, 33);
            }
            setTitleStyleAb(textView, e2Var);
            if (e2Var.Z1()) {
                setOfficialPrefix(spannableStringBuilder);
            } else if (e2Var.Y1()) {
                setWorksPrefix(spannableStringBuilder);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new h(spannableStringBuilder));
            if (i2 > 0) {
                cutAndSetTextByMaxLineForDot(textView, spannableStringBuilder, i3, i2);
            } else {
                textView.setText(spannableStringBuilder);
            }
            c.a.r0.f0.m.l(textView, e2Var.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65559, null, originalThreadInfo, context, i2, rect) == null) {
            jumpToPB(originalThreadInfo, context, i2, rect, (String) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65558, null, originalThreadInfo, context, i2) == null) {
            jumpToPB(originalThreadInfo, context, i2, (Rect) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i2, Rect rect, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{originalThreadInfo, context, Integer.valueOf(i2), rect, str}) == null) || originalThreadInfo == null || context == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.f38793f, originalThreadInfo.n, null);
        createNormalCfg.setForumId(String.valueOf(originalThreadInfo.f38792e));
        if (i2 == 3) {
            createNormalCfg.setFrom("from_frs");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.f38792e)));
        } else {
            createNormalCfg.setFrom("from_personalize");
        }
        if (TextUtils.isEmpty(str)) {
            createNormalCfg.setForumName(originalThreadInfo.f38791d);
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

    public static void setAbstract(TextView textView, TextView textView2, SpannableString spannableString, e2 e2Var, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{textView, textView2, spannableString, e2Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (e2Var != null) {
                e2Var.y4(false);
                if (spannableString != null && !m.isEmptyStringAfterTrim(spannableString.toString())) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                    textView.setVisibility(0);
                    if (z2 && !z && e2Var.k1() > 0 && !m.isEmpty(e2Var.l1()) && isNoThreadTitle(e2Var)) {
                        spannableStringBuilder.insert(0, (CharSequence) e2Var.l1());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, e2Var.l1().length(), 33);
                        spannableStringBuilder.insert(e2Var.l1().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), e2Var.l1().length(), e2Var.l1().length() + 5, 33);
                    }
                    textView.setOnTouchListener(new h(spannableStringBuilder));
                    setAbstractStyleAb(textView);
                    int a = textView2.getVisibility() != 8 ? 5 - w.a(i2, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, n.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    e2Var.y4(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a, i2));
                } else {
                    textView.setVisibility(8);
                }
                if (!z) {
                    c.a.r0.f0.m.l(textView, e2Var.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
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

    public static void jumpToPB(a aVar, Context context, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, null, false, "", "");
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), str, str2}) == null) {
            jumpToPB(aVar, context, i2, z, null, str, str2);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, Rect rect, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect, str, str2}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, rect, false, str, str2);
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), rect}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, rect, false, "", "");
        }
    }

    public static void jumpToPB(a aVar, Context context, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, context, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jumpToPB(aVar, context, i2, z, false, false, null, z2, "", "");
        }
    }

    public static void setAbstract(TextView textView, SpannableString spannableString, e2 e2Var, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{textView, spannableString, e2Var, Float.valueOf(f2)}) == null) || textView == null) {
            return;
        }
        if (e2Var != null && spannableString != null && !m.isEmptyStringAfterTrim(spannableString.toString())) {
            textView.setVisibility(0);
            e2Var.y4(false);
            textView.setOnTouchListener(new h(spannableString));
            e2Var.y4(cutAndSetTextByMaxLine(textView, new SpannableStringBuilder(spannableString), 5, (int) f2));
            c.a.r0.f0.m.l(textView, e2Var.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }
}
