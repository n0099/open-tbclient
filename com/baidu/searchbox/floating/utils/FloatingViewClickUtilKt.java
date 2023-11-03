package com.baidu.searchbox.floating.utils;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\"2\u0010\u0002\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"value", "", "lastClickTime", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "getLastClickTime", "(Landroid/view/View;)J", "setLastClickTime", "(Landroid/view/View;J)V", "click", "", "time", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function1;", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "floating-view_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingViewClickUtilKt {
    public static final <T extends View> void click(T t, long j, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        t.setOnClickListener(new FloatingViewClickUtilKt$click$1(t, j, block));
    }

    public static /* synthetic */ void click$default(View view2, long j, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 800;
        }
        Intrinsics.checkNotNullParameter(view2, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view2.setOnClickListener(new FloatingViewClickUtilKt$click$1(view2, j, block));
    }

    public static final <T extends View> long getLastClickTime(T t) {
        Long l;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Object tag = t.getTag(R.id.obfuscated_res_0x7f090b9c);
        if (tag instanceof Long) {
            l = (Long) tag;
        } else {
            l = null;
        }
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final <T extends View> void setLastClickTime(T t, long j) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        t.setTag(R.id.obfuscated_res_0x7f090b9c, Long.valueOf(j));
    }
}
