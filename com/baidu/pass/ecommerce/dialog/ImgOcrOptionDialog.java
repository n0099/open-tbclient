package com.baidu.pass.ecommerce.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.ecommerce.AddressStatUtil;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment;
import com.baidu.tieba.R;
import java.util.HashMap;
@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class ImgOcrOptionDialog extends BaseDialogFragment implements View.OnClickListener {
    public TextView cancelTv;
    public TextView chooseImgTv;
    public boolean isDarkMode;
    public OptionOnClickListener optionOnClickListener;
    public TextView takePhotoTv;

    /* loaded from: classes3.dex */
    public interface OptionOnClickListener {
        public static final int OPTION_CHOOSE_IMG_TYPE = 1002;
        public static final int OPTION_TAKE_PHOTO_TYPE = 1001;

        void onOptionClick(int i);
    }

    @Override // com.baidu.pass.ecommerce.common.dialog.BaseDialogFragment
    public int getLayoutResId() {
        return R.layout.obfuscated_res_0x7f0d05b1;
    }

    @SuppressLint({"ValidFragment"})
    public ImgOcrOptionDialog(boolean z) {
        this.isDarkMode = z;
    }

    public void setOptionOnClickListener(OptionOnClickListener optionOnClickListener) {
        this.optionOnClickListener = optionOnClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.optionOnClickListener != null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092189) {
                this.optionOnClickListener.onOptionClick(1001);
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "camera");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap);
            } else if (id == R.id.obfuscated_res_0x7f092115) {
                this.optionOnClickListener.onOptionClick(1002);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("stage", StatKey.EDITADDR_OCR_STAGE_PHOTO_ALBUM);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap2);
            } else if (id == R.id.obfuscated_res_0x7f092173) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("stage", "cancel");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap3);
            }
        }
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.takePhotoTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092189);
        this.chooseImgTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092115);
        this.cancelTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092173);
        if (this.isDarkMode) {
            this.takePhotoTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081399);
            this.takePhotoTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a44));
            view2.findViewById(R.id.obfuscated_res_0x7f09218a).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609c5));
            this.chooseImgTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081397);
            this.chooseImgTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a44));
            view2.findViewById(R.id.obfuscated_res_0x7f092116).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609ef));
            this.cancelTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081397);
            this.cancelTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a44));
        }
        this.takePhotoTv.setOnClickListener(this);
        this.chooseImgTv.setOnClickListener(this);
        this.cancelTv.setOnClickListener(this);
    }
}
