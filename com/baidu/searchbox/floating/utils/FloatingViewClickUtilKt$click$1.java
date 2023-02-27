package com.baidu.searchbox.floating.utils;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", AdvanceSetting.NETWORK_TYPE, "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FloatingViewClickUtilKt$click$1 implements View.OnClickListener {
    public final /* synthetic */ Function1 $block;
    public final /* synthetic */ View $this_click;
    public final /* synthetic */ long $time;

    public FloatingViewClickUtilKt$click$1(View view2, long j, Function1 function1) {
        this.$this_click = view2;
        this.$time = j;
        this.$block = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(this.$this_click) > this.$time) {
            FloatingViewClickUtilKt.setLastClickTime(this.$this_click, currentTimeMillis);
            this.$block.invoke(this.$this_click);
        }
    }
}
