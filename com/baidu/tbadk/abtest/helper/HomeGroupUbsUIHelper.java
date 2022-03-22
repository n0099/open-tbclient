package com.baidu.tbadk.abtest.helper;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.c3.w.a;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class HomeGroupUbsUIHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HomeGroupUbsUIHelper() {
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

    public static float getTotalWidthNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return 3.0f;
        }
        return invokeV.floatValue;
    }

    public static int getTransmitLRMarginByUbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X005) : invokeV.intValue;
    }

    public static int getWantWidthNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public static void handleContentInterval(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, view, i, i2) == null) || view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (UbsABTestHelper.showNewUI()) {
            marginLayoutParams.topMargin = n.f(TbadkCoreApplication.getInst(), i2);
        } else {
            marginLayoutParams.topMargin = n.f(TbadkCoreApplication.getInst(), i);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static int handleDimen(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) ? UbsABTestHelper.showNewUI() ? i2 : i : invokeII.intValue;
    }

    public static void handleHeadSegmentTitleView(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, textView) == null) || textView == null) {
            return;
        }
        if (UbsABTestHelper.showNewUI()) {
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds39));
            return;
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds42));
    }

    public static void handleHeadSegmentTitleViewColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, textView) == null) || textView == null) {
            return;
        }
        if (UbsABTestHelper.showNewUI()) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
        }
    }

    public static void handleImgMask(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65544, null, view, i) == null) || view == null) {
            return;
        }
        if (UbsABTestHelper.showNewUI()) {
            view.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802a4);
        } else if (i > 0) {
            view.setBackgroundResource(i);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public static void handleImgMaskNoShowNewUI(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, view, i) == null) || view == null) {
            return;
        }
        if (i > 0) {
            view.setBackgroundResource(i);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public static void handleLine(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, view) == null) || view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        marginLayoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        view.setLayoutParams(marginLayoutParams);
    }

    public static void handleLineColor(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, view) == null) || view == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0202);
    }

    public static void handleSinglePicSize(ThreadData threadData, int[] iArr) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, threadData, iArr) == null) && iArr != null && iArr.length == 2 && threadData != null && UbsABTestHelper.showNewUI()) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int wantWidthNumber = (getWantWidthNumber() * ((int) (((View.MeasureSpec.getSize(n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) - (dimensionPixelSize * 2)) / getTotalWidthNumber()))) + dimensionPixelSize;
            MediaData mediaData = (MediaData) ListUtils.getItem(threadData.getMedias(), 0);
            if (mediaData == null || (i = mediaData.picWidth) <= 0 || (i2 = mediaData.picHeight) <= 0) {
                return;
            }
            if (i == i2) {
                iArr[0] = wantWidthNumber;
                iArr[1] = wantWidthNumber;
            } else if (i > i2) {
                iArr[0] = wantWidthNumber;
                iArr[1] = (wantWidthNumber * 3) / 4;
            } else {
                iArr[0] = wantWidthNumber;
                iArr[1] = (wantWidthNumber * 4) / 3;
            }
        }
    }

    public static void handleTextLineSpacingExtra(TextView textView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65550, null, textView, i, i2) == null) || textView == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (UbsABTestHelper.showNewUI()) {
            textView.setLineSpacing(n.f(textView.getContext(), i2), textView.getLineSpacingMultiplier());
        } else {
            textView.setLineSpacing(n.f(textView.getContext(), i), textView.getLineSpacingMultiplier());
        }
    }

    public static boolean handleTransmitVerticalVideoSize(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{layoutParams, layoutParams2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (layoutParams == null || layoutParams2 == null || !UbsABTestHelper.showNewUI()) {
                return z;
            }
            int size = View.MeasureSpec.getSize(n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int wantWidthNumber = (getWantWidthNumber() * ((int) ((size - (dimensionPixelSize * 2)) / getTotalWidthNumber()))) + dimensionPixelSize;
            layoutParams2.width = (n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44) * 2) + wantWidthNumber;
            int f2 = ((wantWidthNumber * 4) / 3) + n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
            layoutParams2.height = f2;
            layoutParams.height = f2;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean handleVerticalVideoSize(ViewGroup.LayoutParams layoutParams, boolean z, a aVar, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{layoutParams, Boolean.valueOf(z), aVar, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (layoutParams == null || !UbsABTestHelper.showNewUI()) {
                return z;
            }
            int size = View.MeasureSpec.getSize(n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int wantWidthNumber = (getWantWidthNumber() * ((int) ((size - (dimensionPixelSize * 2)) / getTotalWidthNumber()))) + dimensionPixelSize;
            layoutParams.width = wantWidthNumber;
            int i3 = (wantWidthNumber * 4) / 3;
            layoutParams.height = i3;
            boolean z2 = (wantWidthNumber == i && i3 == i2) ? false : true;
            if (aVar != null) {
                aVar.changeRenderViewMode(0);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isFromHotRankTab(c.a.o0.r.r.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().isFromHotRankTab) ? false : true : invokeL.booleanValue;
    }

    public static int[] handleSinglePicSize(MediaData mediaData) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, mediaData)) == null) {
            int[] iArr = new int[2];
            if (mediaData != null && UbsABTestHelper.showNewUI()) {
                int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                int wantWidthNumber = (getWantWidthNumber() * ((int) (((View.MeasureSpec.getSize(n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) - (dimensionPixelSize * 2)) / getTotalWidthNumber()))) + dimensionPixelSize;
                int i2 = mediaData.picWidth;
                if (i2 > 0 && (i = mediaData.picHeight) > 0) {
                    if (i2 == i) {
                        iArr[0] = wantWidthNumber;
                        iArr[1] = wantWidthNumber;
                    } else if (i2 > i) {
                        iArr[0] = wantWidthNumber;
                        iArr[1] = (wantWidthNumber * 3) / 4;
                    } else {
                        iArr[0] = wantWidthNumber;
                        iArr[1] = (wantWidthNumber * 4) / 3;
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }
}
