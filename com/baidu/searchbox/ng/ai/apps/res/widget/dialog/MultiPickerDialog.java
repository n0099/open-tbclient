package com.baidu.searchbox.ng.ai.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class MultiPickerDialog extends AiAppAlertDialog {
    private BdMultiPicker mBdMultiPicker;
    private JSONArray mDataArray;
    private JSONArray mDataIndex;
    private boolean mIsSingleMode;
    private BdMultiPicker.OnMultiSelectedChangedListener mMultiSelectedChangedListener;

    public MultiPickerDialog(Context context) {
        super(context, R.style.NoTitleDialog);
    }

    private void createMultiPickerContentView() {
        this.mBdMultiPicker = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.mBdMultiPicker.setLayoutParams(layoutParams);
        this.mBdMultiPicker.setMultiWheelData(this.mDataArray, this.mDataIndex);
        if (!this.mIsSingleMode) {
            this.mBdMultiPicker.setMultiSelectedListener(this.mMultiSelectedChangedListener);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        createMultiPickerContentView();
        getBuilder().setView(this.mBdMultiPicker);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.mDataArray = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.mDataIndex = jSONArray;
    }

    public void setSingleMode(boolean z) {
        this.mIsSingleMode = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.OnMultiSelectedChangedListener onMultiSelectedChangedListener) {
        this.mMultiSelectedChangedListener = onMultiSelectedChangedListener;
    }

    public JSONArray getCurrentIndex() {
        return this.mBdMultiPicker.getCurrentIndex();
    }

    public void updateWheel(int i, JSONArray jSONArray, int i2) {
        this.mBdMultiPicker.updateWheel(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends AiAppAlertDialog.Builder {
        public JSONArray dataArray;
        public JSONArray dataIndex;
        public boolean isSingleMode;
        public BdMultiPicker.OnMultiSelectedChangedListener multiSelectedChangedListener;

        public Builder(Context context) {
            super(context);
        }

        public Builder setDataArray(JSONArray jSONArray) {
            this.dataArray = jSONArray;
            return this;
        }

        public Builder setDataIndex(JSONArray jSONArray) {
            this.dataIndex = jSONArray;
            return this;
        }

        public Builder setSingleMode(boolean z) {
            this.isSingleMode = z;
            return this;
        }

        public Builder setMultiSelectedListener(BdMultiPicker.OnMultiSelectedChangedListener onMultiSelectedChangedListener) {
            this.multiSelectedChangedListener = onMultiSelectedChangedListener;
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new MultiPickerDialog(context);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            MultiPickerDialog multiPickerDialog = (MultiPickerDialog) super.create();
            multiPickerDialog.setDataArray(this.dataArray);
            multiPickerDialog.setDataIndex(this.dataIndex);
            multiPickerDialog.setSingleMode(this.isSingleMode);
            multiPickerDialog.setMultiSelectedListener(this.multiSelectedChangedListener);
            return multiPickerDialog;
        }
    }
}
