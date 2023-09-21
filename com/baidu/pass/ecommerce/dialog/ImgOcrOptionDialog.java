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
        return R.layout.obfuscated_res_0x7f0d058e;
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
            if (id == R.id.obfuscated_res_0x7f0920be) {
                this.optionOnClickListener.onOptionClick(1001);
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "camera");
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap);
            } else if (id == R.id.obfuscated_res_0x7f09204a) {
                this.optionOnClickListener.onOptionClick(1002);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("stage", StatKey.EDITADDR_OCR_STAGE_PHOTO_ALBUM);
                AddressStatUtil.statAddressOption(StatKey.EDITADDR_OCR_STAGE, hashMap2);
            } else if (id == R.id.obfuscated_res_0x7f0920a8) {
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
        this.takePhotoTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920be);
        this.chooseImgTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09204a);
        this.cancelTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a8);
        if (this.isDarkMode) {
            this.takePhotoTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f081361);
            this.takePhotoTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a3d));
            view2.findViewById(R.id.obfuscated_res_0x7f0920bf).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609be));
            this.chooseImgTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f08135f);
            this.chooseImgTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a3d));
            view2.findViewById(R.id.obfuscated_res_0x7f09204b).setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e8));
            this.cancelTv.setBackgroundResource(R.drawable.obfuscated_res_0x7f08135f);
            this.cancelTv.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a3d));
        }
        this.takePhotoTv.setOnClickListener(this);
        this.chooseImgTv.setOnClickListener(this);
        this.cancelTv.setOnClickListener(this);
    }
}
