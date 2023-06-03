package com.baidu.searchbox.interaction.cloudcontrol.debug;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.view.GravityCompat;
import com.baidu.searchbox.debug.data.ViewFetcher;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionSpHelperByDebug;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionSpHelperKt;
import com.baidu.searchbox.interaction.cloudcontrol.debug.InteractionRadioGroupIteminfoKt$getItemInfo$1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/interaction/cloudcontrol/debug/InteractionRadioGroupIteminfoKt$getItemInfo$1", "Lcom/baidu/searchbox/debug/data/ViewFetcher;", "fetchView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InteractionRadioGroupIteminfoKt$getItemInfo$1 implements ViewFetcher {
    public final /* synthetic */ String $debugBranchKey;
    public final /* synthetic */ T $defaultValue;
    public final /* synthetic */ Pair<String, T>[] $otherModel;
    public final /* synthetic */ String $switchDebugKey;
    public final /* synthetic */ String $switchDebugTitle;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.Pair<java.lang.String, ? extends T>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public InteractionRadioGroupIteminfoKt$getItemInfo$1(String str, String str2, String str3, T t, Pair<String, ? extends T>[] pairArr) {
        this.$switchDebugTitle = str;
        this.$switchDebugKey = str2;
        this.$debugBranchKey = str3;
        this.$defaultValue = t;
        this.$otherModel = pairArr;
    }

    /* renamed from: fetchView$lambda-0  reason: not valid java name */
    public static final void m95fetchView$lambda0(String switchDebugKey, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(switchDebugKey, "$switchDebugKey");
        InteractionSpHelperByDebug.INSTANCE.putBoolean(switchDebugKey, z);
    }

    /* renamed from: fetchView$lambda-1  reason: not valid java name */
    public static final void m96fetchView$lambda1(RadioGroup radioGroup, String debugBranchKey, RadioGroup radioGroup2, int i) {
        Intrinsics.checkNotNullParameter(radioGroup, "$radioGroup");
        Intrinsics.checkNotNullParameter(debugBranchKey, "$debugBranchKey");
        InteractionSpHelperKt.putDebugSwitcherValue(debugBranchKey, ((RadioButton) radioGroup.findViewById(i)).getTag());
    }

    @Override // com.baidu.searchbox.debug.data.ViewFetcher
    public View fetchView(Context context) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 100);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(this.$switchDebugTitle);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.rightMargin = 10;
        checkBox.setLayoutParams(layoutParams2);
        linearLayout.addView(checkBox);
        checkBox.setChecked(InteractionSpHelperByDebug.INSTANCE.getBoolean(this.$switchDebugKey, false));
        final String str = this.$switchDebugKey;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.qo1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                    InteractionRadioGroupIteminfoKt$getItemInfo$1.m95fetchView$lambda0(str, compoundButton, z);
                }
            }
        });
        final RadioGroup radioGroup = new RadioGroup(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.rightMargin = 10;
        radioGroup.setOrientation(1);
        radioGroup.setLayoutParams(layoutParams3);
        radioGroup.setGravity(GravityCompat.START);
        Object debugSwitcherValue = InteractionSpHelperKt.getDebugSwitcherValue(this.$debugBranchKey, this.$defaultValue);
        RadioButton radioButton = null;
        boolean z = false;
        for (Pair pair : this.$otherModel) {
            RadioButton radioButton2 = new RadioButton(context);
            radioButton2.setText((CharSequence) pair.getFirst());
            radioButton2.setTag(pair.getSecond());
            radioGroup.addView(radioButton2);
            if (Intrinsics.areEqual(pair.getSecond(), debugSwitcherValue)) {
                radioButton2.setChecked(true);
                z = true;
            }
            if (radioButton == null) {
                radioButton = radioButton2;
            }
        }
        if (!z && radioButton != null) {
            radioButton.setChecked(true);
        }
        final String str2 = this.$debugBranchKey;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.ro1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, radioGroup2, i) == null) {
                    InteractionRadioGroupIteminfoKt$getItemInfo$1.m96fetchView$lambda1(radioGroup, str2, radioGroup2, i);
                }
            }
        });
        linearLayout.addView(radioGroup);
        return linearLayout;
    }
}
