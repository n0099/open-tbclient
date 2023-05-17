package com.baidu.searchbox.debug.data;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BT\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\r\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00028\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR(\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R1\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/debug/data/RadioDebugViewFetcher;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "Landroid/content/Context;", "context", "Landroid/widget/RadioGroup;", "createRadioGroup", "(Landroid/content/Context;)Landroid/widget/RadioGroup;", "Landroid/view/View;", "fetchView", "(Landroid/content/Context;)Landroid/view/View;", "initialValue", "Ljava/lang/Object;", "", "Lkotlin/Pair;", "", "radios", "Ljava/util/List;", "title", "Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "valueChanged", "Lkotlin/Function1;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class RadioDebugViewFetcher<T> implements ViewFetcher {
    public final T initialValue;
    public final List<Pair<String, T>> radios;
    public final String title;
    public Function1<? super T, Unit> valueChanged;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.Pair<java.lang.String, ? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public RadioDebugViewFetcher(String title, List<? extends Pair<String, ? extends T>> radios, T t, Function1<? super T, Unit> valueChanged) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(radios, "radios");
        Intrinsics.checkNotNullParameter(valueChanged, "valueChanged");
        this.title = title;
        this.radios = radios;
        this.initialValue = t;
        this.valueChanged = valueChanged;
    }

    @Override // com.baidu.searchbox.debug.data.ViewFetcher
    public View fetchView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setText(this.title);
        textView.setGravity(17);
        linearLayout.addView(textView);
        linearLayout.addView(createRadioGroup(context));
        return linearLayout;
    }

    private final RadioGroup createRadioGroup(Context context) {
        RadioGroup radioGroup = new RadioGroup(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.rightMargin = 10;
        radioGroup.setOrientation(1);
        radioGroup.setLayoutParams(layoutParams);
        radioGroup.setGravity(GravityCompat.START);
        Iterator<T> it = this.radios.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText((CharSequence) pair.getFirst());
            radioButton.setId(pair.hashCode());
            if (Intrinsics.areEqual(pair.getSecond(), this.initialValue)) {
                radioButton.setChecked(true);
            }
            radioGroup.addView(radioButton);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.searchbox.debug.data.RadioDebugViewFetcher$createRadioGroup$2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                List<Pair> list;
                boolean z;
                Function1 function1;
                list = RadioDebugViewFetcher.this.radios;
                for (Pair pair2 : list) {
                    if (pair2.hashCode() == i) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        function1 = RadioDebugViewFetcher.this.valueChanged;
                        function1.invoke(pair2.getSecond());
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        });
        return radioGroup;
    }
}
