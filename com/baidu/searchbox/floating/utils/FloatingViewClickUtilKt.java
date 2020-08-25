package com.baidu.searchbox.floating.utils;

import android.view.View;
import com.baidu.searchbox.videoplayer.floating.R;
import kotlin.h;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
/* loaded from: classes19.dex */
public final class FloatingViewClickUtilKt {
    public static final <T extends View> void setLastClickTime(T t, long j) {
        q.m(t, "$receiver");
        t.setTag(R.id.floating_click_view_tag, Long.valueOf(j));
    }

    public static final <T extends View> long getLastClickTime(T t) {
        q.m(t, "$receiver");
        Object tag = t.getTag(R.id.floating_click_view_tag);
        if (!(tag instanceof Long)) {
            tag = null;
        }
        Long l = (Long) tag;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static /* synthetic */ void click$default(View view, long j, b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 800;
        }
        q.m(view, "$receiver");
        q.m(bVar, "block");
        view.setOnClickListener(new FloatingViewClickUtilKt$click$1(view, j, bVar));
    }

    public static final <T extends View> void click(T t, long j, b<? super T, l> bVar) {
        q.m(t, "$receiver");
        q.m(bVar, "block");
        t.setOnClickListener(new FloatingViewClickUtilKt$click$1(t, j, bVar));
    }
}
