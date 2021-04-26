package com.baidu.pass.ecommerce.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class ImgOcrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public TextView cancelTv;
    public TextView chooseImgTv;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView takePhotoTv;

    /* loaded from: classes2.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_CHOOSE_IMG_TYPE = 1002;
        public static final int OPTION_TAKE_PHOTO_TYPE = 1001;

        void onOptionClick(int i2);
    }

    @SuppressLint({"ValidFragment"})
    public ImgOcrOptionDialog(boolean z) {
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment
    public int getLayoutResId() {
        return R.layout.layout_sapi_sdk_img_ocr_option_dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.optionOnClickListener != null) {
            int id = view.getId();
            if (id == R.id.sapi_sdk_take_photo) {
                this.optionOnClickListener.onOptionClick(1001);
            } else if (id == R.id.sapi_sdk_choose_img) {
                this.optionOnClickListener.onOptionClick(1002);
            }
        }
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.takePhotoTv = (TextView) view.findViewById(R.id.sapi_sdk_take_photo);
        this.chooseImgTv = (TextView) view.findViewById(R.id.sapi_sdk_choose_img);
        this.cancelTv = (TextView) view.findViewById(R.id.sapi_sdk_option_cancel);
        if (this.isDarkMode) {
            this.takePhotoTv.setBackgroundResource(R.drawable.sapi_sdk_option_top_round_bg_selector_dark);
            this.takePhotoTv.setTextColor(getResources().getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
            view.findViewById(R.id.sapi_sdk_take_photo_bottom_line).setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
            this.chooseImgTv.setBackgroundResource(R.drawable.sapi_sdk_option_common_bg_selector_dark);
            this.chooseImgTv.setTextColor(getResources().getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
            view.findViewById(R.id.sapi_sdk_choose_img_bottom_line).setBackgroundColor(getResources().getColor(R.color.sapi_sdk_addr_list_dialog_divider_bg_dark_color));
            this.cancelTv.setBackgroundResource(R.drawable.sapi_sdk_option_common_bg_selector_dark);
            this.cancelTv.setTextColor(getResources().getColor(R.color.sapi_sdk_common_select_dialog_item_text_dark_color));
        }
        this.takePhotoTv.setOnClickListener(this);
        this.chooseImgTv.setOnClickListener(this);
        this.cancelTv.setOnClickListener(this);
    }

    public void setOptionOnClickListener(OptionOnClickListener optionOnClickListener) {
        this.optionOnClickListener = optionOnClickListener;
    }
}
