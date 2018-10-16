package com.baidu.searchbox.ng.ai.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes2.dex */
public class DatePickerDialog extends AiAppAlertDialog {
    private BdDatePicker mDatePicker;
    private int mDay;
    private boolean mDisabled;
    private Date mEndDate;
    private String mFields;
    private int mMonth;
    private Date mStartDate;
    private int mYear;

    DatePickerDialog(Context context) {
        super(context, R.style.NoTitleDialog);
    }

    DatePickerDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public void setYear(int i) {
        this.mYear = i;
    }

    public int getYear() {
        return this.mDatePicker.getYear();
    }

    public void setMonth(int i) {
        this.mMonth = i;
    }

    public int getMonth() {
        return this.mDatePicker.getMonth();
    }

    public void setDay(int i) {
        this.mDay = i;
    }

    public int getDay() {
        return this.mDatePicker.getDay();
    }

    private boolean isWheelViewVisible(String str) {
        return this.mDatePicker.isWheelViewVisible(str);
    }

    public String getSelectedDate() {
        StringBuilder sb = new StringBuilder();
        if (isWheelViewVisible(BdDatePicker.WHEEL_VIEW_YEAR_TYPE)) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (isWheelViewVisible(BdDatePicker.WHEEL_VIEW_MONTH_TYPE)) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (isWheelViewVisible("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void createTimePickerContentView() {
        this.mDatePicker = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.mDatePicker.setLayoutParams(layoutParams);
        this.mDatePicker.setScrollCycle(true);
        this.mDatePicker.setStartDate(this.mStartDate);
        this.mDatePicker.setEndDate(this.mEndDate);
        this.mDatePicker.setYear(this.mYear);
        this.mDatePicker.setMonth(this.mMonth);
        this.mDatePicker.setDay(this.mDay);
        this.mDatePicker.updateDatas();
        this.mDatePicker.setFields(this.mFields);
        this.mDatePicker.setDisabled(this.mDisabled);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        createTimePickerContentView();
        getBuilder().setView(this.mDatePicker);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.BaseDialog, android.app.Dialog
    public void show() {
        TextView ifOnlyOneBtnGetIt = getBuilder().ifOnlyOneBtnGetIt();
        if (ifOnlyOneBtnGetIt != null) {
            ifOnlyOneBtnGetIt.setBackgroundResource(R.drawable.aiapps_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.mFields = str;
    }

    public void setDisabled(boolean z) {
        this.mDisabled = z;
    }

    public void setStartDate(Date date) {
        this.mStartDate = date;
    }

    public void setEndDate(Date date) {
        this.mEndDate = date;
    }

    /* loaded from: classes2.dex */
    public static class Builder extends AiAppAlertDialog.Builder {
        private boolean disabled;
        public Date endDate;
        private String fields;
        public Date selectedDate;
        public Date startDate;

        public Builder(Context context) {
            super(context);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new DatePickerDialog(context);
        }

        public Builder startDate(Date date) {
            this.startDate = date;
            return this;
        }

        public Builder endDate(Date date) {
            this.endDate = date;
            return this;
        }

        public Builder selectedDate(Date date) {
            this.selectedDate = date;
            return this;
        }

        public Builder fields(String str) {
            this.fields = str;
            return this;
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            DatePickerDialog datePickerDialog = (DatePickerDialog) super.create();
            datePickerDialog.setFields(this.fields);
            datePickerDialog.setDisabled(this.disabled);
            if (this.selectedDate != null) {
                datePickerDialog.setYear(this.selectedDate.getYear() + BdDatePicker.START_YEAR);
                datePickerDialog.setMonth(this.selectedDate.getMonth() + 1);
                datePickerDialog.setDay(this.selectedDate.getDate());
            }
            if (this.startDate != null) {
                datePickerDialog.setStartDate(this.startDate);
            }
            if (this.endDate != null) {
                datePickerDialog.setEndDate(this.endDate);
            }
            return datePickerDialog;
        }
    }
}
