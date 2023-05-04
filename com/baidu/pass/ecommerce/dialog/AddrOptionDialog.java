package com.baidu.pass.ecommerce.dialog;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class AddrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public static final String KEY_IS_DEFAULT_ADDR = "key_is_default_addr";
    public TextView copyView;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView setDefaultView;
    public View setDefaultViewBottomLine;

    /* loaded from: classes2.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_COPY_TYPE = 1003;
        public static final int OPTION_DEL_TYPE = 1002;
        public static final int OPTION_SET_DEFAULT_TYPE = 1001;

        void onOptionClick(int i);
    }

    @Override // com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment
    public int getLayoutResId() {
        return R.layout.obfuscated_res_0x7f0d052f;
    }

    @SuppressLint({"ValidFragment"})
    public AddrOptionDialog(boolean z) {
        this.isDarkMode = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.optionOnClickListener != null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091ec5) {
                this.optionOnClickListener.onOptionClick(1001);
            } else if (id == R.id.obfuscated_res_0x7f091e98) {
                this.optionOnClickListener.onOptionClick(1003);
            } else if (id == R.id.obfuscated_res_0x7f091ea3) {
                this.optionOnClickListener.onOptionClick(1002);
            }
        }
        dismiss();
    }

    public void setOptionOnClickListener(OptionOnClickListener optionOnClickListener) {
        this.optionOnClickListener = optionOnClickListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.setDefaultView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ec5);
        this.setDefaultViewBottomLine = view2.findViewById(R.id.obfuscated_res_0x7f091ec6);
        this.copyView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e98);
        this.setDefaultView.setOnClickListener(this);
        this.copyView.setOnClickListener(this);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ea3);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ebd);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        if (this.isDarkMode) {
            Resources resources = getResources();
            this.setDefaultView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081151);
            this.setDefaultView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06089a));
            this.setDefaultViewBottomLine.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06081a));
            this.copyView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08114f);
            this.copyView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06089a));
            view2.findViewById(R.id.obfuscated_res_0x7f091e99).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06081a));
            textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08114f);
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06088a));
            view2.findViewById(R.id.obfuscated_res_0x7f091ea5).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06081a));
            textView2.setBackgroundResource(R.drawable.obfuscated_res_0x7f08114f);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06089a));
        }
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            z = arguments.getBoolean(KEY_IS_DEFAULT_ADDR, false);
        }
        if (z) {
            this.setDefaultView.setText("取消默认");
        } else {
            this.setDefaultView.setText("设为默认地址");
        }
    }
}
