package com.baidu.searchbox.floating.utils;

import android.view.View;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.videoplayer.floating.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u001aA\u0010\u0007\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\"2\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\u0006\u0010\t\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Landroid/view/View;", "T", "", "time", "Lkotlin/Function1;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "click", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "value", "getLastClickTime", "(Landroid/view/View;)J", "setLastClickTime", "(Landroid/view/View;J)V", "lastClickTime", "floating-view_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public final class FloatingViewClickUtilKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends View> void click(T click, long j2, Function1<? super T, Unit> block) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{click, Long.valueOf(j2), block}) == null) {
            Intrinsics.checkNotNullParameter(click, "$this$click");
            Intrinsics.checkNotNullParameter(block, "block");
            click.setOnClickListener(new FloatingViewClickUtilKt$click$1(click, j2, block));
        }
    }

    public static /* synthetic */ void click$default(View click, long j2, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 800;
        }
        Intrinsics.checkNotNullParameter(click, "$this$click");
        Intrinsics.checkNotNullParameter(block, "block");
        click.setOnClickListener(new FloatingViewClickUtilKt$click$1(click, j2, block));
    }

    public static final <T extends View> long getLastClickTime(T lastClickTime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lastClickTime)) == null) {
            Intrinsics.checkNotNullParameter(lastClickTime, "$this$lastClickTime");
            Object tag = lastClickTime.getTag(R.id.floating_click_view_tag);
            if (!(tag instanceof Long)) {
                tag = null;
            }
            Long l = (Long) tag;
            if (l != null) {
                return l.longValue();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final <T extends View> void setLastClickTime(T lastClickTime, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, null, lastClickTime, j2) == null) {
            Intrinsics.checkNotNullParameter(lastClickTime, "$this$lastClickTime");
            lastClickTime.setTag(R.id.floating_click_view_tag, Long.valueOf(j2));
        }
    }
}
