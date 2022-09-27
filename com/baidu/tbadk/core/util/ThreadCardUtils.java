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
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.eh6;
import com.baidu.tieba.ej;
import com.baidu.tieba.fz4;
import com.baidu.tieba.fz8;
import com.baidu.tieba.hv4;
import com.baidu.tieba.il5;
import com.baidu.tieba.kt4;
import com.baidu.tieba.nj;
import com.baidu.tieba.oh5;
import com.baidu.tieba.t16;
import com.baidu.tieba.tx4;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.yq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
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

    public static void cancelHighLight(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, threadData) == null) || threadData == null) {
            return;
        }
        threadData.cancelHighLight();
    }

    public static Rect computeViewArea(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            int height = view2.getHeight();
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
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, textView, spannableStringBuilder, i, i2)) == null) ? cutAndSetTextByMaxLine(textView, spannableStringBuilder, i, i2, false) : invokeLLII.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLineForDot(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, textView, spannableStringBuilder, i, i2)) == null) {
            if (!nj.b(i2, textView.getPaint(), spannableStringBuilder.toString(), i)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            dealText(textView, spannableStringBuilder, new SpannableStringBuilder(StringHelper.STRING_MORE), i, i2);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public static void dealMainViewTopMargin(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
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
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{textView, spannableStringBuilder, spannableStringBuilder2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textView.getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            float f = i2;
            if (staticLayout.getLineCount() >= i) {
                int i3 = i - 1;
                spannableStringBuilder.delete(staticLayout.getLineEnd(i3), spannableStringBuilder.length());
                f -= staticLayout.getLineWidth(i3);
            }
            int i4 = 2;
            CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() >= 2 ? spannableStringBuilder.length() - 2 : 0, spannableStringBuilder.length());
            float measureText = textView.getPaint().measureText(spannableStringBuilder2.toString());
            while (measureText > textView.getPaint().measureText(subSequence.toString()) + f) {
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
        if (!(interceptable == null || interceptable.invokeLILL(65546, null, context, i, threadData, rect) == null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        String str = i == 3 ? "frs" : i == 2 ? "index" : "";
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        oh5.e(context, arrayList, threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, rect, "from_nani_video", "personalize_page", "", str, str, false, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
    }

    public static boolean isNoThreadAbstract(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) ? threadData == null || threadData.getAbstractText() == null || dj.isEmptyStringAfterTrim(threadData.getAbstractText().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadTitle(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, threadData)) == null) ? threadData == null || threadData.getIsNoTitle() == 1 || threadData.getTitleText() == null || dj.isEmptyStringAfterTrim(threadData.getTitleText().toString()) : invokeL.booleanValue;
    }

    public static boolean isNoThreadVoice(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, threadData)) == null) ? threadData == null || ListUtils.getCount(threadData.getVoice()) <= 0 : invokeL.booleanValue;
    }

    public static boolean isPreloadType(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, threadData)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || StringUtils.isNull(threadData.getAuthor().getUserId()) || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static boolean isTargetUser(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, threadData, str)) == null) ? (threadData == null || threadData.getAuthor() == null || StringUtils.isNull(threadData.getAuthor().getUserId()) || StringUtils.isNull(str) || !threadData.getAuthor().getUserId().equals(str)) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isUgcThreadType(BaijiahaoData baijiahaoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, baijiahaoData)) == null) {
            if (baijiahaoData == null) {
                return false;
            }
            int i = baijiahaoData.oriUgcType;
            return i == 1 || i == 2 || i == 3 || i == 4;
        }
        return invokeL.booleanValue;
    }

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z, boolean z2, boolean z3, Rect rect, boolean z4, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), rect, Boolean.valueOf(z4), str, str2}) == null) || yq4Var == null || yq4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = yq4Var.getThreadData();
        if (threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
            BdToast b = BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f1537));
            b.f(BdToast.ToastIcon.FAILURE);
            b.i();
            return;
        }
        cancelHighLight(threadData);
        if (threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().video_url)) {
            gotoNainiPage(context, i, threadData, rect);
            return;
        }
        String g = t16.g();
        if (i == 3) {
            g = t16.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.getFid())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g, 18003, true, false, false);
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
        if (yq4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(yq4Var.getPbInputLocate());
        }
        if (i == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i == 2) {
            createFromThreadCfg.setVideo_source("index");
            kt4 kt4Var = new kt4();
            kt4Var.b(threadData);
            createFromThreadCfg.setRecomData(kt4Var);
        }
        createFromThreadCfg.setJumpGodReply(z);
        if (!z) {
            createFromThreadCfg.setJumpToCommentArea(z2);
        }
        createFromThreadCfg.setFromHomePageQuality(z3);
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && isPreloadType(threadData) && !z2 && !z4) {
            createFromThreadCfg.setNeedPreLoad(true);
            eh6.update(threadData);
        }
        createFromThreadCfg.setThreadData(threadData);
        createFromThreadCfg.setVideoOriginArea(rect);
        createFromThreadCfg.setIsPrivacy(threadData.isPrivacy);
        t16.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void jumpToPBCommentArea(yq4 yq4Var, Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65563, null, yq4Var, context, i, i2) == null) || yq4Var == null || context == null || yq4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = yq4Var.getThreadData();
        String g = t16.g();
        if (i == 3) {
            g = t16.f();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(threadData.getFid())));
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, g, 18003, true, false, false);
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
        if (yq4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(yq4Var.getPbInputLocate());
        }
        if (i == 3) {
            createFromThreadCfg.setVideo_source("frs");
        } else if (i == 2) {
            createFromThreadCfg.setVideo_source("index");
            kt4 kt4Var = new kt4();
            kt4Var.b(threadData);
            createFromThreadCfg.setRecomData(kt4Var);
        }
        if (threadData.isQualityReplyThread) {
            createFromThreadCfg.setFromHomePageQuality(true);
        }
        if (threadData.isInterviewLiveStyle() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        t16.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        cancelHighLight(threadData);
    }

    public static void setAbstract(TextView textView, TextView textView2, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65566, null, textView, textView2, threadData, i) == null) {
            setAbstract(textView, textView2, threadData, i, false);
        }
    }

    public static void setAbstractStyleAb(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, textView) == null) || textView == null) {
            return;
        }
        hv4.d(textView).z(R.dimen.T_X05);
    }

    public static void setOfficialPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, spannableStringBuilder) == null) {
            setUniversalPrefix(spannableStringBuilder, "官方", R.color.CAM_X0306, R.color.CAM_X0101);
        }
    }

    public static void setSendHelpPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, spannableStringBuilder) == null) {
            setUniversalPrefix(spannableStringBuilder, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1129), R.color.CAM_X0302, R.color.CAM_X0101);
        }
    }

    public static void setTitle(TextView textView, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, textView, threadData) == null) {
            setTitle(textView, threadData, 0, false);
        }
    }

    public static void setTitleStyleAb(TextView textView, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, textView, threadData) == null) || textView == null) {
            return;
        }
        setAbstractStyleAb(textView);
        if (threadData.threadType != 40) {
            hv4.d(textView).A(R.string.F_X02);
        } else {
            hv4.d(textView).A(R.string.F_X01);
        }
    }

    public static void setUniversalPrefix(SpannableStringBuilder spannableStringBuilder, String str, @ColorInt int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65577, null, spannableStringBuilder, str, i, i2) == null) || spannableStringBuilder == null) {
            return;
        }
        spannableStringBuilder.insert(0, (CharSequence) str);
        int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
        int f5 = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
        tx4 tx4Var = new tx4(f, -1, i, f3, i2, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        tx4Var.b(f2);
        tx4Var.i(f5);
        tx4Var.f(true);
        tx4Var.g(true);
        tx4Var.d(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
        spannableStringBuilder.setSpan(tx4Var, 0, str.length(), 17);
    }

    @Deprecated
    public static void setWorksPrefix(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, spannableStringBuilder) == null) {
        }
    }

    public static void startImageViewer(View view2, boolean z, List<MediaData> list, int i, ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{view2, Boolean.valueOf(z), list, Integer.valueOf(i), threadData, str}) == null) {
            startImageViewer(view2, z, list, i, threadData, str, false);
        }
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, SpannableStringBuilder spannableStringBuilder, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{textView, spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!nj.c(i2, textView.getPaint(), spannableStringBuilder.toString(), i, z ? 2 : 5)) {
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return false;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
            if (!z) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0054));
                spannableStringBuilder3.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, spannableStringBuilder3.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            }
            dealText(textView, spannableStringBuilder, spannableStringBuilder2, i, i2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void setAbstract(TextView textView, TextView textView2, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{textView, textView2, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setAbstract(textView, textView2, threadData, i, z, false);
        }
    }

    public static void setTitle(TextView textView, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65575, null, textView, threadData, z) == null) {
            setTitle(textView, threadData, 0, z);
        }
    }

    public static void startImageViewer(View view2, boolean z, List<MediaData> list, int i, ThreadData threadData, String str, boolean z2) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{view2, Boolean.valueOf(z), list, Integer.valueOf(i), threadData, str, Boolean.valueOf(z2)}) == null) || view2 == null) {
            return;
        }
        Context context = view2.getContext();
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            ej.M(context, R.string.obfuscated_res_0x7f0f0ec1);
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
                    imageUrlData.threadId = dh.g(threadData.getTid(), -1L);
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
        String first_post_id = threadData.getFirst_post_id();
        if (threadData.isShareThread && (originalThreadInfo = threadData.originalThreadData) != null) {
            if (!TextUtils.isEmpty(originalThreadInfo.n)) {
                first_post_id = threadData.originalThreadData.n;
            } else if (threadData.originalThreadData.g() != null && !TextUtils.isEmpty(threadData.originalThreadData.g().getFirst_post_id())) {
                first_post_id = threadData.originalThreadData.g().getFirst_post_id();
            }
        }
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
        builder.A(arrayList);
        builder.E(i);
        builder.C(threadData.getForum_name());
        builder.O(first_post_id);
        builder.B(String.valueOf(threadData.getFid()));
        builder.R(threadData.getTid());
        builder.F(z);
        builder.M(arrayList.size() > 0 ? arrayList.get(0) : "");
        builder.I(true);
        builder.y(concurrentHashMap);
        builder.K(true);
        builder.Q(threadData);
        builder.H(z2);
        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
        ImageViewerConfig x = builder.x(context);
        if (str != null) {
            x.getIntent().putExtra("from", str);
        }
        BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE_FROM, "image", "tran");
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
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

    public static void setAbstract(TextView textView, TextView textView2, ThreadData threadData, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{textView, textView2, threadData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (threadData != null && textView2 != null) {
                threadData.setShowFullThread(false);
                SpannableStringBuilder spannableStringBuilder = null;
                if (threadData.getAbstractText() != null) {
                    spannableStringBuilder = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.o(threadData.getTiePlusLinkOriginData());
                }
                if (threadData.getTabId() > 0 && !dj.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData) && (spannableStringBuilder == null || dj.isEmptyStringAfterTrim(spannableStringBuilder.toString()))) {
                    if (threadData.isShareThread && threadData.originalThreadData != null) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f117d));
                    } else if (threadData.isVoiceThreadType()) {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f159e));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13e5));
                    }
                }
                if (spannableStringBuilder != null && !dj.isEmptyStringAfterTrim(spannableStringBuilder.toString())) {
                    textView2.setVisibility(textView2.getVisibility());
                    if (z && threadData.getTabId() > 0 && !dj.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData)) {
                        spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                        spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
                    }
                    if (isNoThreadTitle(threadData) && threadData.isDisplayOffcialPrefix()) {
                        setOfficialPrefix(spannableStringBuilder);
                    } else if (isNoThreadTitle(threadData) && threadData.isDisplayHighQualityPrefix()) {
                        setWorksPrefix(spannableStringBuilder);
                    } else if (isNoThreadTitle(threadData) && threadData.isQuestionThread()) {
                        setSendHelpPrefix(spannableStringBuilder);
                    }
                    setAbstractStyleAb(textView);
                    textView.setOnTouchListener(new fz8(spannableStringBuilder));
                    textView.setVisibility(0);
                    int i2 = z2 ? 2 : 5;
                    if (textView2.getVisibility() != 8) {
                        i2 -= nj.a(i, textView2.getPaint(), textView2.getText().toString(), 2);
                    }
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, ej.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, spannableStringBuilder, i2, i, z2));
                } else {
                    textView.setVisibility(8);
                }
                t16.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public static void setTitle(TextView textView, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{textView, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || textView == null || threadData == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = threadData.getTitleText() != null ? new SpannableStringBuilder(threadData.getTitleText()) : null;
        if (isNoThreadTitle(threadData)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && threadData.getTabId() > 0 && !dj.isEmpty(threadData.getTabName())) {
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
            } else if (threadData.isQuestionThread()) {
                setSendHelpPrefix(spannableStringBuilder);
            }
            if (!threadData.isDisplayOffcialPrefix()) {
                ThreadRecommendTagUtil.setTag(spannableStringBuilder, threadData);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new fz8(spannableStringBuilder));
            if (i > 0) {
                cutAndSetTextByMaxLine(textView, spannableStringBuilder, 5, i);
            } else {
                textView.setText(spannableStringBuilder);
            }
            t16.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{textView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) ? cutAndSetTextByMaxLine(textView, str, i, i2, i3, i4, z, true) : invokeCommon.booleanValue;
    }

    public static boolean cutAndSetTextByMaxLine(TextView textView, String str, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{textView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (textView == null || StringUtils.isNull(str)) {
                return false;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
            spannableStringBuilder2.setSpan(new fz4(ej.f(textView.getContext(), i2)), 0, spannableStringBuilder2.length(), 17);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(i));
            if (z) {
                spannableStringBuilder3.setSpan(new il5(2, null), 0, spannableStringBuilder3.length(), 33);
            }
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" ");
            spannableStringBuilder4.setSpan(new fz4(ej.f(textView.getContext(), R.dimen.tbds1)), 0, spannableStringBuilder2.length(), 17);
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
        if (!(interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{textView, threadData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || textView == null || threadData == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = threadData.getTitleText() != null ? new SpannableStringBuilder(threadData.getTitleText()) : null;
        if (isNoThreadTitle(threadData)) {
            textView.setVisibility(8);
        } else if (spannableStringBuilder == null) {
        } else {
            if (z && threadData.getTabId() > 0 && !dj.isEmpty(threadData.getTabName())) {
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
            } else if (threadData.isQuestionThread()) {
                setSendHelpPrefix(spannableStringBuilder);
            }
            if (!threadData.isDisplayOffcialPrefix()) {
                ThreadRecommendTagUtil.setTag(spannableStringBuilder, threadData);
            }
            textView.setVisibility(0);
            textView.setOnTouchListener(new fz8(spannableStringBuilder));
            if (i > 0) {
                cutAndSetTextByMaxLineForDot(textView, spannableStringBuilder, i2, i);
            } else {
                textView.setText(spannableStringBuilder);
            }
            t16.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65555, null, originalThreadInfo, context, i, rect) == null) {
            jumpToPB(originalThreadInfo, context, i, rect, (String) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, null, originalThreadInfo, context, i) == null) {
            jumpToPB(originalThreadInfo, context, i, (Rect) null);
        }
    }

    public static void jumpToPB(OriginalThreadInfo originalThreadInfo, Context context, int i, Rect rect, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{originalThreadInfo, context, Integer.valueOf(i), rect, str}) == null) || originalThreadInfo == null || context == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
        createNormalCfg.setForumId(String.valueOf(originalThreadInfo.e));
        if (i == 3) {
            createNormalCfg.setFrom("from_frs");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(originalThreadInfo.e)));
        } else {
            createNormalCfg.setFrom("from_personalize");
        }
        if (TextUtils.isEmpty(str)) {
            createNormalCfg.setForumName(originalThreadInfo.d);
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
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{textView, textView2, spannableString, threadData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (threadData != null) {
                threadData.setShowFullThread(false);
                if (spannableString != null && !dj.isEmptyStringAfterTrim(spannableString.toString())) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
                    textView.setVisibility(0);
                    if (z2 && !z && threadData.getTabId() > 0 && !dj.isEmpty(threadData.getTabName()) && isNoThreadTitle(threadData)) {
                        spannableStringBuilder.insert(0, (CharSequence) threadData.getTabName());
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, threadData.getTabName().length(), 33);
                        spannableStringBuilder.insert(threadData.getTabName().length(), (CharSequence) TAB_NAME_SPLIT_STRING);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0203)), threadData.getTabName().length(), threadData.getTabName().length() + 5, 33);
                    }
                    textView.setOnTouchListener(new fz8(spannableStringBuilder));
                    setAbstractStyleAb(textView);
                    int a = textView2.getVisibility() != 8 ? 5 - nj.a(i, textView2.getPaint(), textView2.getText().toString(), 2) : 5;
                    if (textView2.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, 0, 0, 0);
                        textView.setLayoutParams(layoutParams);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.setMargins(0, ej.f(textView.getContext(), R.dimen.M_T_X002), 0, 0);
                        textView.setLayoutParams(layoutParams2);
                    }
                    threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, spannableStringBuilder, a, i));
                } else {
                    textView.setVisibility(8);
                }
                if (!z) {
                    t16.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
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

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            jumpToPB(yq4Var, context, i, z, false, false, null, false, "", "");
        }
    }

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), str, str2}) == null) {
            jumpToPB(yq4Var, context, i, z, null, str, str2);
        }
    }

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z, Rect rect, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect, str, str2}) == null) {
            jumpToPB(yq4Var, context, i, z, false, false, rect, false, str, str2);
        }
    }

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) {
            jumpToPB(yq4Var, context, i, z, false, false, rect, false, "", "");
        }
    }

    public static void jumpToPB(yq4 yq4Var, Context context, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{yq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jumpToPB(yq4Var, context, i, z, false, false, null, z2, "", "");
        }
    }

    public static void setAbstract(TextView textView, SpannableString spannableString, ThreadData threadData, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{textView, spannableString, threadData, Float.valueOf(f)}) == null) || textView == null) {
            return;
        }
        if (threadData != null && spannableString != null && !dj.isEmptyStringAfterTrim(spannableString.toString())) {
            textView.setVisibility(0);
            threadData.setShowFullThread(false);
            textView.setOnTouchListener(new fz8(spannableString));
            threadData.setShowFullThread(cutAndSetTextByMaxLine(textView, new SpannableStringBuilder(spannableString), 5, (int) f));
            t16.l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        textView.setVisibility(8);
    }
}
