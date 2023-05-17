package com.baidu.searchbox.debug.data;

import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B*\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR1\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/debug/data/OnCheckListener;", "android/widget/CompoundButton$OnCheckedChangeListener", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "valueChanged", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class OnCheckListener implements CompoundButton.OnCheckedChangeListener {
    public Function1<? super Boolean, Unit> valueChanged;

    public OnCheckListener(Function1<? super Boolean, Unit> valueChanged) {
        Intrinsics.checkNotNullParameter(valueChanged, "valueChanged");
        this.valueChanged = valueChanged;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.valueChanged.invoke(Boolean.valueOf(z));
    }
}
