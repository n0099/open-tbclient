package com.baidu.pass.ecommerce.common.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class BaseDialogFragment extends DialogFragment implements View.OnClickListener {
    public abstract int getLayoutResId();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window = getDialog().getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.dimAmount = 0.5f;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.obfuscated_res_0x7f100127);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.obfuscated_res_0x7f100409;
        return inflate;
    }
}
